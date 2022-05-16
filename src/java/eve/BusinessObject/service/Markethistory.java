package eve.BusinessObject.service;

import data.conversion.JSONConversion;
import db.TransactionOutput;
import eve.BusinessObject.Logic.BLevetype;
import eve.BusinessObject.Logic.BLorder_history;
import eve.BusinessObject.Logic.BLorder_history_maxdate;
import eve.BusinessObject.Logic.BLorder_history_month;
import eve.BusinessObject.Logic.BLview_order_region_evetype;
import eve.data.Swagger;
import eve.logicview.View_order_region_evetype;
import general.exception.DBException;
import general.exception.DataException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * @author Franky Laseure
 */
public class Markethistory implements Runnable {
    
    private MarkethistoryStatus markethistorystatus;
    private boolean keeprunning = true;
    
    public void stoprunning() {
        this.keeprunning = false;
    }
    
    public MarkethistoryStatus getStatus() {
        return markethistorystatus;
    }
    
    public class MarkethistoryStatus {
        private long historylines = 0;
        private long totalhistorylines = 1;
        private ArrayList<String> messages = new ArrayList<>();
        private boolean done = false;
        
        public MarkethistoryStatus() {
        }
        
        public void incMarkethistorylines() {
            this.historylines++;
        }
        
        public long getMarkethistorylines() {
            return historylines;
        }
        
        public long getTotalmarkethistorylines() {
            return totalhistorylines;
        }
        
        public void setDone() {
            this.done = true;
        }
        
        public void addMessage(String message) {
            messages.add(message);
        }

        public ArrayList getMessages() {
            return this.messages;
        }

        public boolean isDone() {
            return this.done;
        }
    }
    
    public Markethistory() {
        markethistorystatus = new MarkethistoryStatus();
    }
    
    private BLorder_history blorderhistory;
    private BLview_order_region_evetype blview_order_region_evetype;
    private BLorder_history_maxdate blorder_history_maxdate;
    private BLevetype blevetype;
    private TransactionOutput toutput;
    private JSONObject json;
    private JSONArray jsonhistory;
    private Iterator<JSONObject> jsonhistoryI;
    private JSONObject jsonline;
    private Date maxdate;
    private Date swaggerdate;
    private int pagenr;
    private long start;
    private ArrayList<View_order_region_evetype> view_order_region_evetypes;
    private int historycounter;
    private StringBuilder sqlb;
    
    @Override
    public void run() {
        try {
            initialize_businesslogic();
            markethistorystatus.addMessage("Download market history");
            initialize();
            for(View_order_region_evetype region_evetype: view_order_region_evetypes)
                save_market_history_for_region_evetypes(region_evetype);
            markethistorystatus.addMessage("Build Market history / month");
            build_markethistory_per_month();
            update_priceaverages_based_on_lastmonth();
        }
        catch(DBException e) {
            markethistorystatus.addMessage(e.getMessage());
        }
        catch(Exception e) {
            markethistorystatus.addMessage(e.getMessage());
        }
        long end = System.currentTimeMillis();
        markethistorystatus.addMessage("Download market history in " + ((end - start)/1000) + "sec.");
        markethistorystatus.setDone();
    }

    private void update_priceaverages_based_on_lastmonth() throws DBException, DataException {
        markethistorystatus.addMessage("Update type averages");
        blevetype.updateHistoryaverages();
        toutput = blevetype.Commit2DB();
        if(toutput.getHaserror())
            markethistorystatus.addMessage("Update type averages " + toutput.getErrormessage());
    }

    private void build_markethistory_per_month() throws DBException {
        BLorder_history_month blorderhistorymonth = new BLorder_history_month();
        blorderhistorymonth.deleteall();
        blorderhistorymonth.buildfromMarkethistory();
        toutput = blorderhistorymonth.Commit2DB();
        if(toutput.getHaserror())
            markethistorystatus.addMessage("Markethistory Downloader " + toutput.getErrormessage());
    }

    private void save_market_history_for_region_evetypes(View_order_region_evetype region_evetype) throws DBException {
        markethistorystatus.incMarkethistorylines();
        jsonhistory = Swagger.getMarket_history(region_evetype.getRegion(), region_evetype.getEvetype());
        jsonhistoryI = jsonhistory.iterator();
        while(jsonhistoryI.hasNext())
            process_swagger_history_line(region_evetype, jsonhistoryI.next());
        toutput = blorderhistory.Commit2DB();
        if(toutput.getHaserror())
            markethistorystatus.addMessage("Markethistory Downloader " + toutput.getErrormessage());
    }

    private void process_swagger_history_line(View_order_region_evetype region_evetype, JSONObject jsonline) throws DBException {
        swaggerdate = Swagger.datestring2Date(JSONConversion.getString(jsonline, "date"));
        if(swaggerdate.after(maxdate))
            add_orderhistory_line_to_database(region_evetype, jsonline);
    }

    private void add_orderhistory_line_to_database(View_order_region_evetype region_evetype, JSONObject jsonline1) throws DBException {
        blorderhistory.addStatement(build_orderhistory_insert(region_evetype, jsonline1).toString());
        historycounter++;
        if(historycounter==100)
            commit_orderhistory_buffer_to_database();
    }

    private void commit_orderhistory_buffer_to_database() throws DBException {
        historycounter = 0;
        toutput = blorderhistory.Commit2DB();
        if(toutput.getHaserror())
            markethistorystatus.addMessage("Markethistory Downloader " + toutput.getErrormessage());
    }

    private StringBuilder build_orderhistory_insert(View_order_region_evetype region_evetype, JSONObject jsonline1) {
        sqlb.delete(0, 200);
        sqlb.append("insert into order_history values (");
        sqlb.append(region_evetype.getRegion()).append(",");
        sqlb.append(region_evetype.getEvetype()).append(",");
        sqlb.append("'").append(swaggerdate).append("',");
        sqlb.append(JSONConversion.getDouble(jsonline1, "average")).append(",");
        sqlb.append(JSONConversion.getDouble(jsonline1, "highest")).append(",");
        sqlb.append(JSONConversion.getDouble(jsonline1, "lowest")).append(",");
        sqlb.append(JSONConversion.getint(jsonline1, "volume")).append(",");
        sqlb.append(JSONConversion.getint(jsonline1, "order_count"));
        sqlb.append(")");
        return sqlb;
    }

    private void initialize() throws DBException {
        start = System.currentTimeMillis();
        maxdate = blorder_history_maxdate.getOrder_history_maxdates().get(0).getMaxdate();
        view_order_region_evetypes = blview_order_region_evetype.getAll();
        markethistorystatus.totalhistorylines = view_order_region_evetypes.size();
        historycounter = 0;
        sqlb = new StringBuilder();
    }

    private void initialize_businesslogic() {
        blorderhistory = new BLorder_history();
        blorderhistory.setAuthenticated(true);
        blview_order_region_evetype = new BLview_order_region_evetype();
        blview_order_region_evetype.setAuthenticated(true);
        blorder_history_maxdate = new BLorder_history_maxdate();
        blorder_history_maxdate.setAuthenticated(true);
        blevetype = new BLevetype();
        blevetype.setAuthenticated(true);
    }

}
