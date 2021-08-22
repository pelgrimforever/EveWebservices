/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eve.BusinessObject.service;

import eve.BusinessObject.Logic.BLmarket_group;
import eve.data.Swagger;
import eve.entity.pk.Market_groupPK;
import eve.logicentity.Market_group;
import general.exception.DBException;
import general.exception.DataException;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Market loader service
 * @author pelgrim
 */
public class Market_groupService implements Runnable {
    
    private Market_groupStatus market_groupstatus;
    private boolean keeprunning = true;
    
    public void stoprunning() {
        this.keeprunning = false;
    }
    
    public Market_groupStatus getStatus() {
        return market_groupstatus;
    }
    
    public class Market_groupStatus {
        private long marketgroups = 0;
        private long totalmarketgroups = 1;
        private ArrayList<String> messages = new ArrayList<>();
        private boolean done = false;
        
        public Market_groupStatus() {
            try {
                totalmarketgroups = (new BLmarket_group()).count();
            }
            catch(DBException e) {
                
            }
        }
        
        public void incMarketgroups() {
            this.marketgroups++;
        }
        
        public long getMarketgroups() {
            return marketgroups;
        }
        
        public long getTotalmarketgroups() {
            return totalmarketgroups;
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
    
    public Market_groupService() {
        market_groupstatus = new Market_groupStatus();
    }
    
    @Override
    public void run() {
        market_groupstatus.addMessage("Download market groups");

        long start = System.currentTimeMillis();

        try {
            BLmarket_group blmarketgroup = new BLmarket_group();
            int run = 0;
            //add/update marketgroups
            JSONArray jsonmarketgroup = Swagger.getMarketgroups();
            Iterator<Long> jsonmarketgroupI = jsonmarketgroup.iterator();
            Long marketgroupid;
            JSONObject jsonmarketgroupdetails;
            int marketgroupcounter = 0;
            ArrayList<Market_group> parentupdates = new ArrayList<>();
            Market_group marketgroup;
            do {
                while(keeprunning && jsonmarketgroupI.hasNext()) {
                    marketgroupid = (Long)jsonmarketgroupI.next();
                    if(run==0 || !blmarketgroup.getMarket_groupExists(new Market_groupPK(marketgroupid))) {
                        jsonmarketgroupdetails = Swagger.getMarketgroup(marketgroupid);
                        marketgroup = blmarketgroup.updateMarket_group(jsonmarketgroupdetails);
                        if(run==0 && jsonmarketgroupdetails.containsKey("parent_group_id")) {
                            parentupdates.add(blmarketgroup.updateParent(marketgroup, jsonmarketgroupdetails));
                        }              
                        market_groupstatus.incMarketgroups();
                        marketgroupcounter++;
                        if(marketgroupcounter==100) {
                            marketgroupcounter = 0;
                            blmarketgroup.Commit2DB();
                        }
                    }
                }
                blmarketgroup.Commit2DB();
                run++;
            } while(keeprunning && blmarketgroup.count()<jsonmarketgroup.size());

            Iterator<Market_group> marketgroupI = parentupdates.iterator();
            while(marketgroupI.hasNext()) {
                blmarketgroup.trans_updateMarket_group(marketgroupI.next());
            }
            blmarketgroup.Commit2DB();
        }
        catch(DBException e) {
            market_groupstatus.addMessage(e.getMessage());
        }
        catch(DataException e) {
            market_groupstatus.addMessage(e.getMessage());
        }

        long end = System.currentTimeMillis();
        market_groupstatus.addMessage("Download time Market groups " + ((end - start)/1000) + "sec.");
        market_groupstatus.setDone();
    }

}
