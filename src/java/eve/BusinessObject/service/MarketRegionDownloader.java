/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eve.BusinessObject.service;

import data.conversion.JSONConversion;
import db.AbstractSQLMapper;
import db.TransactionOutput;
import eve.BusinessObject.Logic.BLorders;
import eve.BusinessObject.Logic.BLregion;
import eve.BusinessObject.service.MarketService.MarketStatus;
import eve.data.Swagger;
import eve.entity.pk.OrdersPK;
import eve.logicentity.Region;
import general.exception.DBException;
import general.exception.DataException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author pelgrim
 */
public class MarketRegionDownloader implements Runnable {
    
    private Marketdata data;
    private MarketStatus marketstatus;
    private boolean keeprunning = true;
    private int id = 0;
    
    public MarketRegionDownloader(Marketdata data, MarketStatus marketstatus, int id) {
        this.data = data;
        this.marketstatus = marketstatus;
        this.id = id;
    }
    
    public void stoprunning() {
        this.keeprunning = false;
    }

    @Override
    public void run() {
        BLregion blregion = new BLregion();
        BLorders blorders = new BLorders();
        int pagenr;
        StringBuilder sqlb = new StringBuilder();
        JSONObject jsonorderdetails;
        TransactionOutput toutput;
        JSONArray jsonorders;
        Iterator<JSONObject> jsonordersI;
        int ordercounter = 0;
        int errorcounter = 0;
        int orderbatch = 0;
        int rangenumber = 0;
        long orderid;
        OrdersPK orderspk = new OrdersPK();
        HashMap<Long, Boolean> orderids = new HashMap<>();

        try {
            Region region = data.getNextregion();
            while(keeprunning && region!=null) {
                //System.out.print(id + " Region " + region.getName());
                pagenr = 1;
                errorcounter = 0;
                orderids.clear();
                do {
                    //System.out.print("Page " + pagenr + " * ");
                    jsonorders = Swagger.getMarket_region_orders(region.getPrimaryKey().getId(), pagenr);
                    jsonordersI = jsonorders.iterator();
                    ordercounter = 0;
                    while(keeprunning && jsonordersI.hasNext()) {
                        jsonorderdetails = jsonordersI.next();
                        orderid = JSONConversion.getLong(jsonorderdetails, "order_id");
                        orderspk.setId(orderid);
                        if(orderids.get(orderid)==null) {
                            orderids.put(orderid, true);
                            blorders.addStatement(composeSQLinsert(jsonorderdetails, pagenr), null);                                
                            ordercounter++;
                        }
                        if(ordercounter==100) {
                            orderbatch = ordercounter;
                            ordercounter = 0;
                            toutput = blorders.Commit2DB_returnSQL();
                            if(toutput.getHaserror()) {
                                errorcounter++;
                                marketstatus.addMessage(toutput.getErrormessage());
                                System.out.print(id + " " + region.getPrimaryKey().getId() + " " + region.getName() + " " + toutput.getErrormessage());
                            }
                        }
                    }
                    toutput = blorders.Commit2DB_returnSQL();
                    if(toutput.getHaserror()) {
                        errorcounter++;
                        marketstatus.addMessage(toutput.getErrormessage());
                        System.out.print(id + " " + region.getPrimaryKey().getId() + " " + region.getName() + " " + toutput.getErrormessage());
                    }
                    pagenr++;
                    marketstatus.updateStatus(region.getPrimaryKey().getId(), pagenr);
                } while(keeprunning && jsonorders.size()>0);
                marketstatus.setDone(region.getPrimaryKey().getId());
                region.setOrderpages(pagenr);
                region.setOrdererrors(errorcounter);
                blregion.updateRegion(region);

                region = data.getNextregion();
            }         
        }
        catch(DBException e) {
            marketstatus.addMessage(e.getMessage());
        }
        catch(DataException e) {
            marketstatus.addMessage(e.getMessage());
        }
        return;
    }    

    //put as local variable, got results that did not make sence when using AbstractSQLMapper.datetimeformat
    private final SimpleDateFormat datetimeformat = new SimpleDateFormat(AbstractSQLMapper.strdatetimeformat);    
    
    private String composeSQLinsert(JSONObject jsonorderdetails, int pagenr) {
        StringBuilder sqlb = new StringBuilder();
        sqlb.append("insert into orders values (");
        sqlb.append(JSONConversion.getLong(jsonorderdetails, "order_id")).append(",");
        sqlb.append("true,");
        sqlb.append(JSONConversion.getLong(jsonorderdetails, "system_id")).append(",");
        sqlb.append(JSONConversion.getLong(jsonorderdetails, "type_id")).append(",");
        sqlb.append(JSONConversion.getLong(jsonorderdetails, "volume_total")).append(",");
        sqlb.append(JSONConversion.getLong(jsonorderdetails, "volume_remain")).append(",");
        sqlb.append("'").append(JSONConversion.getString(jsonorderdetails, "range")).append("',");
        sqlb.append("0,");
        sqlb.append(JSONConversion.getDouble(jsonorderdetails, "price")).append(",");
        sqlb.append(JSONConversion.getint(jsonorderdetails, "min_volume")).append(",");
        sqlb.append(JSONConversion.getLong(jsonorderdetails, "location_id")).append(",");
        sqlb.append(JSONConversion.getboolean(jsonorderdetails, "is_buy_order")).append(",");
        sqlb.append("'").append(datetimeformat.format(Swagger.datetimestring2Timestamp(JSONConversion.getString(jsonorderdetails, "issued"))));
        sqlb.append("',").append(JSONConversion.getint(jsonorderdetails, "duration"));
        sqlb.append(",").append(pagenr);
        sqlb.append(")");
        return sqlb.toString();
    }
    
    private String composeSQLupdate(JSONObject jsonorderdetails) {
        StringBuilder sqlb = new StringBuilder();
        sqlb.append("update orders set volume_remain = ").append(JSONConversion.getLong(jsonorderdetails, "volume_remain "));
        sqlb.append("where orderid = ").append(JSONConversion.getLong(jsonorderdetails, "order_id"));
        return sqlb.toString();
    }
}
