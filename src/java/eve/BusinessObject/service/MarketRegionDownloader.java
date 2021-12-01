/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eve.BusinessObject.service;

import data.conversion.JSONConversion;
import db.SQLMapper;
import db.TransactionOutput;
import eve.BusinessObject.Logic.BLevetype;
import eve.BusinessObject.Logic.BLgraphic;
import eve.BusinessObject.Logic.BLmarket_group;
import eve.BusinessObject.Logic.BLorders;
import eve.BusinessObject.Logic.BLregion;
import eve.BusinessObject.Logic.BLtypegroup;
import eve.BusinessObject.service.MarketService.MarketStatus;
import eve.data.Swagger;
import eve.entity.pk.EvetypePK;
import eve.entity.pk.GraphicPK;
import eve.entity.pk.Market_groupPK;
import eve.entity.pk.OrdersPK;
import eve.entity.pk.TypegroupPK;
import eve.logicentity.Evetype;
import eve.logicentity.Graphic;
import eve.logicentity.Market_group;
import eve.logicentity.Region;
import eve.logicentity.Typegroup;
import general.exception.DBException;
import general.exception.DataException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
        String sqlstatement;
        HashMap<Long, Boolean> orderids = new HashMap<>();
        ArrayList<String> sqlstatements = new ArrayList<>();
        ArrayList<Long> type_statements = new ArrayList<>();

        try {
            Region region = data.getNextregion();
            while(keeprunning && region!=null) {
                pagenr = 1;
                errorcounter = 0;
                orderids.clear();
                do {
                    jsonorders = Swagger.getMarket_region_orders(region.getPrimaryKey().getId(), pagenr);
                    jsonordersI = jsonorders.iterator();
                    ordercounter = 0;
                    while(keeprunning && jsonordersI.hasNext()) {
                        jsonorderdetails = jsonordersI.next();
                        orderid = JSONConversion.getLong(jsonorderdetails, "order_id");
                        orderspk.setId(orderid);
                        if(orderids.get(orderid)==null) {
                            orderids.put(orderid, true);
                            sqlstatement = composeSQLinsert(jsonorderdetails, pagenr);
                            blorders.addStatement(sqlstatement);                                
                            //sqlstatements.add(sqlstatement);
                            type_statements.add(JSONConversion.getLong(jsonorderdetails, "type_id"));
                            ordercounter++;
                        }
                        if(ordercounter==100) {
                            orderbatch = ordercounter;
                            ordercounter = 0;
                            toutput = blorders.Commit2DB();
                            if(toutput.getHaserror()) {
                                correctTypeError(toutput.getSqllist(), type_statements);
                                errorcounter++;
                            }
                            //sqlstatements = new ArrayList<>();
                            type_statements = new ArrayList<>();
                        }
                    }
                    //don't attempt to commit to database if keeprunning flag is off
                    if(keeprunning) {
                        toutput = blorders.Commit2DB();
                        if(toutput.getHaserror()) {
                            correctTypeError(toutput.getSqllist(), type_statements);
                            errorcounter++;
                        }
                        //sqlstatements = new ArrayList<>();
                        type_statements = new ArrayList<>();
                        pagenr++;
                        marketstatus.updateStatus(region.getPrimaryKey().getId(), pagenr);
                    }
                } while(keeprunning && jsonorders.size()>0);
                marketstatus.setDone(region.getPrimaryKey().getId());
                //don't attempt to commit to database if keeprunning flag is off
                if(keeprunning) {
                    region.setOrderpages(pagenr);
                    region.setOrdererrors(errorcounter);
                    blregion.updateRegion(region);

                    region = data.getNextregion();
                }
            }         
        }
        catch(DBException e) {
            marketstatus.addMessage("MarketRegionDownloader " + e.getMessage());
        }
        catch(DataException e) {
            marketstatus.addMessage("MarketRegionDownloader " + e.getMessage());
        }
        return;
    }    

    //put as local variable, got results that did not make sence when using SQLMapper.DATETIMEFORMATTER
    private final SimpleDateFormat datetimeformat = new SimpleDateFormat(SQLMapper.DATETIMEFORMAT);    
    
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
    
    public void correctTypeError(ArrayList<TransactionOutput.TransactionOutputLine> sqlstatements, ArrayList<Long> type_statements) throws DBException, DataException {
        Swagger swagger = new Swagger();
        BLmarket_group blmarketgroup = new BLmarket_group();
        BLtypegroup bltypegroup = new BLtypegroup();
        BLgraphic blgraphic = new BLgraphic();
        BLevetype blevetype = new BLevetype();
        BLorders blorders = new BLorders();
        Evetype evetype;
        JSONObject jsonmarketgroup;
        Market_groupPK marketgroupPK;
        Market_group marketgroup;
        JSONObject jsongraphic;
        GraphicPK graphicPK;
        Graphic graphic;
        JSONObject jsontypegroup;
        TypegroupPK typegroupPK;
        Typegroup typegroup;
        TransactionOutput toutputtest;
        int l = sqlstatements.size();
        HashMap<Long, Boolean> evetypehash = new HashMap<>();
        for(int s=0; s<l; s++) {
            if(!blevetype.getEntityExists(new EvetypePK(type_statements.get(s)))) {
                if(!evetypehash.containsKey(type_statements.get(s))) {
                    JSONObject jsonevetypedetails = Swagger.getType(type_statements.get(s));
                    evetype = blevetype.updateEvetype(jsonevetypedetails);
                    marketgroupPK = evetype.getMarket_groupPK();
                    graphicPK = evetype.getGraphicPK();
                    typegroupPK = evetype.getTypegroupPK();
                    if(graphicPK!=null && !blgraphic.getEntityExists(graphicPK)) {
                        jsongraphic = Swagger.getGraphic(graphicPK.getId());
                        graphic = blgraphic.updateGraphic(jsongraphic);
                        toutputtest = blgraphic.Commit2DB();
                        if(toutputtest.getHaserror()) {
                            marketstatus.addMessage("Graphic " + graphicPK.getId() + " could not be added");
                        } else {
                            marketstatus.addMessage("Graphic added " + graphic.getGraphic_file());
                        }
                    }
                    if(marketgroupPK!=null && !blmarketgroup.getEntityExists(marketgroupPK)) {
                        jsonmarketgroup = Swagger.getMarketgroup(marketgroupPK.getId());
                        marketgroup = blmarketgroup.updateMarket_group(jsonmarketgroup);
                        toutputtest = blmarketgroup.Commit2DB();
                        if(toutputtest.getHaserror()) {
                            marketstatus.addMessage("Marketgroup " + marketgroupPK.getId() + " could not be added");
                        } else {
                            marketstatus.addMessage("Marketgroup added " + marketgroup.getName());
                        }
                    }
                    if(typegroupPK!=null && !bltypegroup.getEntityExists(typegroupPK)) {
                        jsontypegroup = Swagger.getGroup(typegroupPK.getId());
                        typegroup = bltypegroup.updateTypegroup(jsontypegroup);
                        toutputtest = bltypegroup.Commit2DB();
                        if(toutputtest.getHaserror()) {
                            marketstatus.addMessage("Typegroup " + typegroupPK.getId() + " could not be added");
                        } else {
                            marketstatus.addMessage("Typegroup added " + typegroup.getName());
                        }
                    }
                    toutputtest = blevetype.Commit2DB();
                    if(toutputtest.getHaserror()) {
                        marketstatus.addMessage("Type " + type_statements.get(s) + " could not be added");
                    } else {
                        marketstatus.addMessage("Type added " + evetype.getName());
                    }
                }                                    
            }
            blorders.addStatement(sqlstatements.get(s).getSql());
            TransactionOutput toutput2 = blorders.Commit2DB();
            if(toutput2.getHaserror()) {
                marketstatus.addMessage("MarketRegionDownloader correctTypeError " + toutput2.getErrormessage());
            }
        }
    }
}
