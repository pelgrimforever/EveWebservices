/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eve.BusinessObject.service;

import data.conversion.JSONConversion;
import db.TransactionOutput;
import eve.BusinessObject.Logic.BLorder_history;
import eve.BusinessObject.Logic.BLorder_history_maxdate;
import eve.BusinessObject.Logic.BLorder_history_month;
import eve.BusinessObject.Logic.BLview_order_region_evetype;
import eve.data.Swagger;
import eve.logicview.View_order_region_evetype;
import general.exception.DBException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Market loader service
 * @author pelgrim
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
    
    @Override
    public void run() {
        markethistorystatus.addMessage("Download market history");

        long start = System.currentTimeMillis();
        TransactionOutput toutput;

        try {
            int jsonlength;
            JSONObject json;
            JSONArray jsonhistory;
            Iterator<JSONObject> jsonhistoryI;
            JSONObject jsonline;
            
            BLorder_history blorderhistory = new BLorder_history();
            BLview_order_region_evetype blview_order_region_evetype = new BLview_order_region_evetype();
            BLorder_history_maxdate blorder_history_maxdate = new BLorder_history_maxdate();
            Date maxdate = blorder_history_maxdate.getOrder_history_maxdates().get(0).getMaxdate();
            Date swaggerdate;

            //add market history per region / type
            int pagenr;
            ArrayList<View_order_region_evetype> view_order_region_evetypes = blview_order_region_evetype.getAll();
            markethistorystatus.totalhistorylines = view_order_region_evetypes.size();
            int historycounter = 0;
            StringBuilder sqlb = new StringBuilder();
            for(View_order_region_evetype region_evetype: view_order_region_evetypes) {
                markethistorystatus.incMarkethistorylines();
                jsonhistory = Swagger.getMarket_history(region_evetype.getRegion(), region_evetype.getEvetype());
                jsonhistoryI = jsonhistory.iterator();
                while(jsonhistoryI.hasNext()) {
                    jsonline = jsonhistoryI.next();
                    swaggerdate = Swagger.datestring2Date(JSONConversion.getString(jsonline, "date"));
                    if(swaggerdate.after(maxdate)) {
                        //blorderhistory.updateOrder_history(region_evetype.getRegion(), region_evetype.getEvetype(), jsonline);
                        sqlb.delete(0, 200);
                        sqlb.append("insert into order_history values (");
                        sqlb.append(region_evetype.getRegion()).append(",");
                        sqlb.append(region_evetype.getEvetype()).append(",");
                        sqlb.append("'").append(swaggerdate).append("',");
                        sqlb.append(JSONConversion.getDouble(jsonline, "average")).append(",");
                        sqlb.append(JSONConversion.getDouble(jsonline, "highest")).append(",");
                        sqlb.append(JSONConversion.getDouble(jsonline, "lowest")).append(",");
                        sqlb.append(JSONConversion.getint(jsonline, "volume")).append(",");
                        sqlb.append(JSONConversion.getint(jsonline, "order_count"));
                        sqlb.append(")");

                        blorderhistory.addStatement(sqlb.toString(), null);

                        historycounter++;
                        if(historycounter==100) {
                            historycounter = 0;
                            toutput = blorderhistory.Commit2DB();
                            if(toutput.getHaserror()) {
                                markethistorystatus.addMessage("Markethistory Downloader " + toutput.getErrormessage());
                            }
                        }
                    }
                }
                toutput = blorderhistory.Commit2DB();
                if(toutput.getHaserror()) {
                    markethistorystatus.addMessage("Markethistory Downloader " + toutput.getErrormessage());
                }
                markethistorystatus.addMessage("Build Market history / month " + toutput.getErrormessage());
                BLorder_history_month blorderhistorymonth = new BLorder_history_month();
                blorderhistorymonth.deleteall();
                blorderhistorymonth.buildfromMarkethistory();
                toutput = blorderhistorymonth.Commit2DB();
                if(toutput.getHaserror()) {
                    markethistorystatus.addMessage("Markethistory Downloader " + toutput.getErrormessage());
                }
            }
            System.out.println("Download done");
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

}
