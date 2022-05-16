package eve.BusinessObject.service;

import db.TransactionOutput;
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
 * @author Franky Laseure
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
    
    private BLmarket_group blmarketgroup;
    private TransactionOutput toutput;
    private int run;
    private JSONArray jsonmarketgroup;
    private Iterator<Long> jsonmarketgroupI;
    private Long marketgroupid;
    private JSONObject jsonmarketgroupdetails;
    private int marketgroupcounter;
    private ArrayList<Market_group> marketgroup_parents;
    private Market_group marketgroup;
    
    @Override
    public void run() {
        market_groupstatus.addMessage("Download market groups");
        blmarketgroup = new BLmarket_group();
        blmarketgroup.setAuthenticated(true);
        long start = System.currentTimeMillis();
        try {
            run = 0;
            load_and_update_marketgroups();            
            load_and_update_marketgroup_parents();
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

    private void load_and_update_marketgroups() throws DBException, DataException {
        jsonmarketgroup = Swagger.getMarketgroups();
        jsonmarketgroupI = jsonmarketgroup.iterator();
        marketgroupcounter = 0;
        marketgroup_parents = new ArrayList<>();
        do
            update_marketgroups_in_database();
        while(keeprunning && less_marketgroups_in_database_then_loaded());
    }

    private void load_and_update_marketgroup_parents() throws DataException, DBException {
        Iterator<Market_group> marketgroupI = marketgroup_parents.iterator();
        while(marketgroupI.hasNext())
            blmarketgroup.trans_updateMarket_group(marketgroupI.next());
        toutput = blmarketgroup.Commit2DB();
        if(toutput.getHaserror())
            market_groupstatus.addMessage("MarketGroupDownloader " + toutput.getErrormessage());
    }

    private boolean less_marketgroups_in_database_then_loaded() throws DBException {
        return blmarketgroup.count()<jsonmarketgroup.size();
    }

    private void update_marketgroups_in_database() throws DataException, DBException {
        while(keeprunning && jsonmarketgroupI.hasNext())
            load_and_update_marketgroup();
        save_marketgroup_buffer_to_database();
    }

    private void save_marketgroup_buffer_to_database() throws DBException {
        toutput = blmarketgroup.Commit2DB();
        if(toutput.getHaserror())
            market_groupstatus.addMessage("MarketGroupDownloader " + toutput.getErrormessage());
        run++;
    }

    private void load_and_update_marketgroup() throws DBException, DataException {
        marketgroupid = (Long)jsonmarketgroupI.next();
        boolean marketgroup_not_in_database = !blmarketgroup.getMarket_groupExists(new Market_groupPK(marketgroupid));
        if(run==0 || marketgroup_not_in_database)
            load_and_save_marketgroup_details();
    }

    private void load_and_save_marketgroup_details() throws DataException, DBException {
        jsonmarketgroupdetails = Swagger.getMarketgroup(marketgroupid);
        marketgroup = blmarketgroup.updateMarket_group(jsonmarketgroupdetails);
        boolean marketgroup_has_parent_marketgroup = jsonmarketgroupdetails.containsKey("parent_group_id");
        if(run==0 && marketgroup_has_parent_marketgroup)
            marketgroup_parents.add(blmarketgroup.updateParent(marketgroup, jsonmarketgroupdetails));
        market_groupstatus.incMarketgroups();
        marketgroupcounter++;
        if(marketgroupcounter==100)
            save_marketgroup_buffer();
    }

    private void save_marketgroup_buffer() throws DBException {
        marketgroupcounter = 0;
        toutput = blmarketgroup.Commit2DB();
        if(toutput.getHaserror())
            market_groupstatus.addMessage("MarketGroupDownloader " + toutput.getErrormessage());
    }

}
