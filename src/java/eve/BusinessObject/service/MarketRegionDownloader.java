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
 * @author Franky Laseure
 */
public class MarketRegionDownloader implements Runnable {
    
    private final Marketdata data;
    private final MarketStatus marketstatus;
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

    private BLregion blregion;
    private BLorders blorders;
    private BLmarket_group blmarketgroup;
    private BLtypegroup bltypegroup;
    private BLgraphic blgraphic;
    private BLevetype blevetype;

    private int pagenr;
    private StringBuilder sqlb;
    private TransactionOutput toutput;
    private JSONArray jsonorders;
    private  Iterator<JSONObject> jsonordersI;
    private int ordercounter;
    private int errorcounter;
    private int orderbatch;
    private int rangenumber;
    private long orderid;
    private OrdersPK orderspk;
    private String sqlstatement;
    private HashMap<Long, Boolean> orderids;
    private ArrayList<String> sqlstatements;
    private ArrayList<Long> type_statements;
    
    @Override
    public void run() {
        initialize_businesslogic();
        initialize();
        try {
            Region region = data.getNextregion();
            while(keeprunning && region!=null) {
                initialize_download_orders_for_region();
                do
                    process_next_page_orders_for_region(region);
                while(keeprunning && jsonorders.size()>0);
                set_status_done_for_region(region);
                if(keeprunning)
                    region = update_region_in_database(region);
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

    private Region update_region_in_database(Region region) throws DBException, DataException {
        region.setOrderpages(pagenr);
        region.setOrdererrors(errorcounter);
        blregion.updateRegion(region);
        region = data.getNextregion();
        return region;
    }

    private void set_status_done_for_region(Region region) {
        pagenr--;
        marketstatus.updateStatus(region.getPrimaryKey().getId(), Math.max(1, pagenr), orderbatch);
        marketstatus.setDone(region.getPrimaryKey().getId());
    }

    private void process_next_page_orders_for_region(Region region) throws DBException, DataException {
        download_next_page_orders_for_region(region);
        while(keeprunning && jsonordersI.hasNext())
            process_page_orders_for_region(jsonordersI.next());
        if(keeprunning && jsonorders.size()>0)
            save_orders_buffer(region);
    }

    private void save_orders_buffer(Region region) throws DBException, DataException {
        toutput = blorders.Commit2DB();
        if(toutput.getHaserror())
            handle_orders_commit_error();
        type_statements = new ArrayList<>();
        marketstatus.updateStatus(region.getPrimaryKey().getId(), pagenr, orderbatch);
    }

    private void handle_orders_commit_error() throws DataException, DBException {
        Commmitorders_errorhandler errorhandler = new Commmitorders_errorhandler();
        errorhandler.process_statements(toutput.getSqllist(), type_statements);
        errorcounter++;
    }

    private void process_page_orders_for_region(JSONObject jsonorderdetails) throws DataException, DBException {
        create_orders_primarykey(jsonorderdetails);
        boolean ordersid_not_saved = orderids.get(orderid)==null;
        if(ordersid_not_saved)
            create_order_remember_used_evetype(jsonorderdetails);
        if(ordercounter==100)
            save_orders_buffer();
    }

    private void save_orders_buffer() throws DataException, DBException {
        ordercounter = 0;
        toutput = blorders.Commit2DB();
        if(toutput.getHaserror())
            handle_orders_commit_error();
        type_statements = new ArrayList<>();
    }

    private void create_order_remember_used_evetype(JSONObject jsonorderdetails) {
        orderids.put(orderid, true);
        sqlstatement = composeSQLinsert(jsonorderdetails, pagenr);
        blorders.addStatement(sqlstatement);
        type_statements.add(JSONConversion.getLong(jsonorderdetails, "type_id"));
        ordercounter++;
    }

    private void create_orders_primarykey(JSONObject jsonorderdetails) {
        orderid = JSONConversion.getLong(jsonorderdetails, "order_id");
        orderspk.setId(orderid);
    }

    private void download_next_page_orders_for_region(Region region) {
        pagenr++;
        jsonorders = Swagger.getMarket_region_orders(region.getPrimaryKey().getId(), pagenr);
        orderbatch += jsonorders.size();
        jsonordersI = jsonorders.iterator();
        ordercounter = 0;
    }

    private void initialize_download_orders_for_region() {
        pagenr = 0;
        orderbatch = 0;
        errorcounter = 0;
        orderids.clear();
    }

    private void initialize() {
        sqlb = new StringBuilder();
        ordercounter = 0;
        errorcounter = 0;
        orderbatch = 0;
        rangenumber = 0;
        orderspk = new OrdersPK();
        orderids = new HashMap<>();
        sqlstatements = new ArrayList<>();
        type_statements = new ArrayList<>();
    }

    private void initialize_businesslogic() {
        blregion = new BLregion();
        blregion.setAuthenticated(true);
        blorders = new BLorders();
        blorders.setAuthenticated(true);
        blmarketgroup = new BLmarket_group();
        blmarketgroup.setAuthenticated(true);
        bltypegroup = new BLtypegroup();
        bltypegroup.setAuthenticated(true);
        blgraphic = new BLgraphic();
        blgraphic.setAuthenticated(true);
        blevetype = new BLevetype();
        blevetype.setAuthenticated(true);
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

    private class Commmitorders_errorhandler {
        
        private Evetype evetype;
        private JSONObject jsonmarketgroup;
        private JSONObject jsongraphic;
        private JSONObject jsontypegroup;
        private TransactionOutput toutputtest;
        private Market_groupPK marketgroupPK;
        private Market_group marketgroup;
        private GraphicPK graphicPK;
        private Graphic graphic;
        private TypegroupPK typegroupPK;
        private Typegroup typegroup;
        private HashMap<Long, Boolean> evetypehash;
        
        private void process_statements(ArrayList<TransactionOutput.TransactionOutputLine> sqlstatements, ArrayList<Long> transactionoutputlines) throws DBException, DataException {
            int l = sqlstatements.size();
            evetypehash = new HashMap<>();
            for(int s=0; s<l; s++)
                save_evetype_if_not_in_database(transactionoutputlines.get(s), sqlstatements.get(s));
        }

        private void save_evetype_if_not_in_database(long evetypeid, TransactionOutput.TransactionOutputLine transactionoutputline) throws DataException, DBException {
            if(!blevetype.getEntityExists(new EvetypePK(evetypeid)))
                save_evetype_if_not_previously_processed(evetypeid);
            blorders.addStatement(transactionoutputline.getSql());
            TransactionOutput toutput2 = blorders.Commit2DB();
            if(toutput2.getHaserror())
                handle_errormessage(toutput2);
        }

        private void handle_errormessage(TransactionOutput toutput2) {
            marketstatus.addMessage("MarketRegionDownloader correctTypeError " + toutput2.getErrormessage());
            for(TransactionOutput.TransactionOutputLine line: toutput2.getSqllist())
                marketstatus.addMessage(line.getSql());
        }

        private void save_evetype_if_not_previously_processed(long evetypeid) throws DataException, DBException {
            if(!evetypehash.containsKey(evetypeid))
                save_evetype_and_related_data(evetypeid);
        }

        private void save_evetype_and_related_data(long evetypeid) throws DBException, DataException {
            download_and_save_evetype(evetypeid);
            add_graphic_if_not_in_database();
            add_marketgroup_if_not_in_database();
            add_typegroup_if_not_in_database();
            save_changes_to_database(evetypeid);
        }

        private void download_and_save_evetype(long evetypeid) throws DataException, DBException {
            evetypehash.put(evetypeid, true);
            JSONObject jsonevetypedetails = Swagger.getType(evetypeid);
            evetype = blevetype.updateEvetype(jsonevetypedetails);
        }

        private void add_graphic_if_not_in_database() throws DataException, DBException {
            graphicPK = evetype.getGraphicPK();
            boolean evetype_has_graphic = graphicPK!=null;
            if(evetype_has_graphic && !blgraphic.getEntityExists(graphicPK))
                download_and_save_graphic();
        }

        private void download_and_save_graphic() throws DataException, DBException {
            jsongraphic = Swagger.getGraphic(graphicPK.getId());
            graphic = blgraphic.updateGraphic(jsongraphic);
            toutputtest = blgraphic.Commit2DB();
            if(toutputtest.getHaserror())
                marketstatus.addMessage("Graphic " + graphicPK.getId() + " could not be added");
            else
                marketstatus.addMessage("Graphic added " + graphic.getGraphic_file());
        }

        private void add_marketgroup_if_not_in_database() throws DBException, DataException {
            marketgroupPK = evetype.getMarket_groupPK();
            boolean evetype_has_marketgroup = marketgroupPK!=null;
            if(evetype_has_marketgroup && !blmarketgroup.getEntityExists(marketgroupPK))
                download_and_save_marketgroup();
        }

        private void download_and_save_marketgroup() throws DBException, DataException {
            jsonmarketgroup = Swagger.getMarketgroup(marketgroupPK.getId());
            marketgroup = blmarketgroup.updateMarket_group(jsonmarketgroup);
            toutputtest = blmarketgroup.Commit2DB();
            if(toutputtest.getHaserror())
                marketstatus.addMessage("Marketgroup " + marketgroupPK.getId() + " could not be added");
            else
                marketstatus.addMessage("Marketgroup added " + marketgroup.getName());
        }

        private void add_typegroup_if_not_in_database() throws DBException, DataException {
            typegroupPK = evetype.getTypegroupPK();
            boolean evetype_has_typegroup = typegroupPK!=null;
            if(evetype_has_typegroup && !bltypegroup.getEntityExists(typegroupPK))
                download_and_save_typegroup();
        }

        private void download_and_save_typegroup() throws DataException, DBException {
            jsontypegroup = Swagger.getGroup(typegroupPK.getId());
            typegroup = bltypegroup.updateTypegroup(jsontypegroup);
            toutputtest = bltypegroup.Commit2DB();
            if(toutputtest.getHaserror())
                marketstatus.addMessage("Typegroup " + typegroupPK.getId() + " could not be added");
            else
                marketstatus.addMessage("Typegroup added " + typegroup.getName());
        }

        private void save_changes_to_database(long evetypeid) throws DBException {
            toutputtest = blevetype.Commit2DB();
            if(toutputtest.getHaserror())
                marketstatus.addMessage("Type " + evetypeid + " could not be added");
            else
                marketstatus.addMessage("Type added " + evetype.getName());
        }
    }    

}
