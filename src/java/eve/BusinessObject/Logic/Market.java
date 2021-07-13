/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eve.BusinessObject.Logic;

import data.conversion.JSONConversion;
import db.AbstractSQLMapper;
import db.TransactionOutput;
import eve.data.Swagger;
import eve.entity.pk.RoutetypePK;
import eve.entity.pk.Security_islandPK;
import eve.entity.pk.Systemtrade_orderPK;
import eve.logicentity.Evetype;
import eve.logicentity.Orders;
import eve.logicentity.Region;
import eve.logicentity.Systemtrade;
import eve.logicentity.Systemtrade_order;
import eve.logicentity.Trade;
import eve.logicview.View_tradeorders;
import general.exception.DBException;
import general.exception.DataException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author pelgrim
 */
public class Market implements Runnable {
    
    private MarketStatus marketstatus;
    private boolean keeprunning = true;
    
    public Market() throws DBException {
        marketstatus = new MarketStatus();
    }
    
    public void stoprunning() {
        this.keeprunning = false;
    }
    
    public MarketStatus getStatus() {
        return marketstatus;
    }
    
    public class MarketStatus {

        private HashMap<Long, RegionStatus> regions = new HashMap<>();
        private ArrayList<String> messages = new ArrayList<>();
        private boolean done = false;
        
        public MarketStatus() throws DBException {
            BLregion blregion = new BLregion();
            Iterator<Region> regionI = blregion.getAll().iterator();
            Region region;
            while(regionI.hasNext()) {
                region = regionI.next();
                regions.put(region.getPrimaryKey().getId(), new RegionStatus(region));
            }
        }
        
        public void updateStatus(long regionid, int page) {
            regions.get(regionid).setPage(page);
        }
        
        public void setDone(long regionid) {
            regions.get(regionid).setDone();
        }
        
        public void addMessage(String message) {
            messages.add(message);
        }
        
        public HashMap<Long, RegionStatus> getRegions() {
            return regions;
        }
        
        public ArrayList getMessages() {
            return this.messages;
        }
        
        public void setDone() {
            this.done = true;
        }
        
        public boolean isDone() {
            return done;
        }
        
    }
    
    public class RegionStatus {
        private String name = "";
        private int page = 0;
        private int totalpages = 1;
        private boolean done = false;
        
        public RegionStatus(Region region) {
            this.name = region.getName();
            this.totalpages = region.getOrderpages();
        }
        
        public String getName() {
            return name;
        }
        
        public void setPage(int page) {
            this.page = page;
        }
        
        public int getPage() {
            return page;
        }
        
        public int getTotalpages() {
            return totalpages;
        }
        
        public void setDone() {
            this.done = true;
        }
        
        public boolean isDone() {
            return this.done;
        }
    }
    
    public void run() {
        try {
            this.keeprunning = true;
            //download orders from game server
            downloadOrders();
            //process order data locally
            //trade orders from station to station, seperate types
            processView_tradeorders();
            //trade grouped by system, type
            //processView_systemtradeorders();
        }
        catch(DataException e) {
            marketstatus.addMessage(e.getMessage());
        }
        catch(DBException e) {
            marketstatus.addMessage(e.getMessage());
        }
        catch(Exception e) {
            marketstatus.addMessage(e.getMessage());
        }        
        marketstatus.setDone();
    }
    
    private void downloadOrders() throws DataException, DBException {
        BLorders blorders = new BLorders();
        BLorder_hist blorderhist = new BLorder_hist();
        BLregion blregion = new BLregion();

        //more orders to order_hist
        marketstatus.addMessage("Delete orders");
        if(blorders.count()>0) {
            //blorderhist.deleteorders();
            //blorderhist.copyorders();
            blorders.deleteorders();
        }
        marketstatus.addMessage("Download orders");
        long start = System.currentTimeMillis();
        //add market orders for each region
        int pagenr;
        Iterator<Region> regionsI = blregion.getAll().iterator();
        Region region;
        //performance:
        //to prevent a huge amount of object creations, JSON is directly translated to SQL
        JSONArray jsonorders;
        Iterator<JSONObject> jsonordersI;
        int ordercounter = 0;
        int errorcounter = 0;
        int orderbatch = 0;
        int rangenumber = 0;

        StringBuilder sqlb = new StringBuilder();
        JSONObject jsonorderdetails;
        TransactionOutput toutput;
        while(keeprunning && regionsI.hasNext()) {
            region = regionsI.next();
            pagenr = 1;
            errorcounter = 0;
            do {
                //System.out.print("Page " + pagenr + " * ");
                jsonorders = Swagger.getMarket_region_orders(region.getPrimaryKey().getId(), pagenr);
                jsonordersI = jsonorders.iterator();
                ordercounter = 0;
                while(keeprunning && jsonordersI.hasNext()) {
                    jsonorderdetails = jsonordersI.next();
                    sqlb.delete(0, 200);
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
                    sqlb.append("'").append(AbstractSQLMapper.datetimeformat.format(Swagger.datetimestring2Timestamp(JSONConversion.getString(jsonorderdetails, "issued")))).append("',");
                    sqlb.append(JSONConversion.getint(jsonorderdetails, "duration"));
                    sqlb.append(")");

                    blorders.addStatement(sqlb.toString(), null);

                    ordercounter++;
                    if(ordercounter==100) {
                        orderbatch = ordercounter;
                        ordercounter = 0;
                        toutput = blorders.Commit2DB_returnSQL();
                        if(toutput.getHaserror()) {
                            errorcounter++;
                            marketstatus.addMessage(toutput.getErrormessage());
                        }
                    }
                }
                toutput = blorders.Commit2DB_returnSQL();
                if(toutput.getHaserror()) {
                    errorcounter++;
                    marketstatus.addMessage(toutput.getErrormessage());
                }
                pagenr++;
                marketstatus.updateStatus(region.getPrimaryKey().getId(), pagenr);
            } while(keeprunning && jsonorders.size()>0);
            marketstatus.setDone(region.getPrimaryKey().getId());
            region.setOrderpages(pagenr);
            region.setOrdererrors(errorcounter);
            blregion.updateRegion(region);
        }         
        long end = System.currentTimeMillis();
        marketstatus.addMessage("Download time Swagger -> orders " + ((end - start)/1000) + "sec.");
    }
    
    private void downloadJsonorders() throws DataException, DBException {
        BLjson_orders bljsonorders = new BLjson_orders();
        BLorders blorders = new BLorders();
        BLregion blregion = new BLregion();

        //more orders to order_hist
        System.out.print("Start downloadJsonorders");
        if(blorders.count()>0) {
            //blorderhist.deleteorders();
            //blorderhist.copyorders();
            blorders.deleteorders();
        }
        System.out.print("Orders deleted");
        System.out.print("Starting json_orders");
        long start = System.currentTimeMillis();
        //add market orders for each region
        int pagenr;
        Iterator<Region> regionsI = blregion.getAll().iterator();
        Region region;
        //performance:
        //to prevent a huge amount of object creations, JSON is directly translated to SQL
        JSONArray jsonorders;
        Iterator<JSONObject> jsonordersI;
        int ordercounter = 0;
        int orderbatch = 0;
        int rangenumber = 0;

        StringBuilder sqlb = new StringBuilder();
        JSONObject jsonorderdetails;
        TransactionOutput toutput;
        while(regionsI.hasNext()) {
            region = regionsI.next();
            System.out.println("Region " + region.getPrimaryKey().getId() + " " + region.getName());
            pagenr = 1;
            do {
                //System.out.print("Page " + pagenr + " * ");
                jsonorders = Swagger.getMarket_region_orders(region.getPrimaryKey().getId(), pagenr);
                jsonordersI = jsonorders.iterator();
                ordercounter = 0;
                while(jsonordersI.hasNext()) {
                    jsonorderdetails = jsonordersI.next();
                    sqlb.delete(0, sqlb.length());
                    sqlb.append("insert into json_orders (json) values ('").append(jsonorderdetails.toJSONString()).append("')");
                    blorders.addStatement(sqlb.toString(), null);

                    ordercounter++;
                    if(ordercounter==100) {
                        orderbatch = ordercounter;
                        ordercounter = 0;
                        toutput = blorders.Commit2DB_returnSQL();
                        if(toutput.getHaserror()) {
                            marketstatus.addMessage(toutput.getErrormessage());                    
                        }
                        blorders.Commit2DB();
                    }
                }
                toutput = blorders.Commit2DB_returnSQL();
                if(toutput.getHaserror()) {
                    marketstatus.addMessage(toutput.getErrormessage());
                }
                pagenr++;
            } while(jsonorders.size()>0);
        }         
        long end = System.currentTimeMillis();
        System.out.println("Download time Swagger -> orders " + ((end - start)/1000));
    }
    
    private void processView_tradeorders() throws DataException, DBException {
        RouteHash routehash = new RouteHash(new RoutetypePK(1));
        BLorders blorders = new BLorders();
        BLorder_hist blorderhist = new BLorder_hist();
        BLregion blregion = new BLregion();
        BLevetype blevetype = new BLevetype();
        BLsystem blsystem = new BLsystem();
        BLroute blroute = new BLroute();
        BLtrade bltrade = new BLtrade();
        BLview_tradeorders blviewtradeorders = new BLview_tradeorders();

        //calculate average, min and max price for buy/sell orders for each evetype
        marketstatus.addMessage("Update average prices");
        blevetype.updateaverageprices();
        
        marketstatus.addMessage("Construct trade table");
        bltrade.deletetrade();
        float max_cargo = 33980.4f;
        long min_profit = 1000000;
        long min_profit_per_jump = 100000;
        float perc_tax = 0.05f;
        float perc_net = 1 - perc_tax;
        Security_islandPK security_islandPK = new Security_islandPK(1);
        //get all view_tradeorders
        Iterator<View_tradeorders> tradeordersI = blviewtradeorders.getTradeorders(security_islandPK, max_cargo, perc_net, min_profit).iterator();
        View_tradeorders tradeorder;
        double buyordervalue;
        double sellordervalue;
        double totalvolume;
        int maxunits_per_run;
        double profit_per_unit;
        double profit; //total profit between buy and sell
        double profit_per_jump;
        double singlerun_profit_per_jump;
        int jumps; //jumps for a single trip between buy and sell station
        int totaljumps;
        int runs; //times to travel between buy and sell station to process total amount
        Trade trade;
        int count = 0;
        TransactionOutput toutput;
        
        //loop all orders from view
        while(tradeordersI.hasNext()) {
            tradeorder = tradeordersI.next();
            totalvolume = tradeorder.getTradevolume();
            buyordervalue = tradeorder.getBuy_totalprice();
            sellordervalue = tradeorder.getSell_totalprice();
            profit_per_unit = tradeorder.getBuy_price() * perc_net - tradeorder.getSell_price();
            profit = buyordervalue * perc_net - sellordervalue;
            if(profit>=min_profit) {
                jumps = tradeorder.getJumps();
                if(jumps==0) jumps = 1;
                maxunits_per_run = (int)Math.floor(max_cargo/tradeorder.getSell_packaged_volume());
                runs = (int)Math.ceil(totalvolume/maxunits_per_run);
                totaljumps = jumps * (runs * 2 -1);
                profit_per_jump = profit / totaljumps;
                singlerun_profit_per_jump = profit_per_jump;
                if(runs>1) {
                    singlerun_profit_per_jump = maxunits_per_run * (profit_per_unit) / jumps;
                }
                if(profit_per_jump >= min_profit_per_jump || singlerun_profit_per_jump >= min_profit_per_jump) {
                    trade = new Trade(tradeorder.getSell_id(), tradeorder.getBuy_id());
                    trade.setBuy_order_value(buyordervalue);
                    trade.setJumps(jumps);
                    trade.setMaxunits_per_run(maxunits_per_run);
                    trade.setProfit(profit);
                    trade.setProfit_per_jump(profit_per_jump);
                    trade.setRuns(runs);
                    trade.setSell_order_value(sellordervalue);
                    trade.setSinglerun_profit_per_jump(singlerun_profit_per_jump);
                    trade.setTotal_jumps(totaljumps);
                    trade.setTotal_volume(totalvolume);
                    bltrade.trans_insertTrade(trade);
                    count++;
                    if(count==100) {
                        toutput = bltrade.Commit2DB_returnSQL();
                        if(toutput.getHaserror()) {
                            marketstatus.addMessage(toutput.getErrormessage());
                        }
                    }
                }
            }
            toutput = bltrade.Commit2DB_returnSQL();
            if(toutput.getHaserror()) {
                marketstatus.addMessage(toutput.getErrormessage());
            }
        }
    }

    private void processView_systemtradeorders() throws DataException, DBException {
        float max_cargo = 33980.4f;
        long min_profit = 2000000;
        long min_profit_per_jump = 100000;
        float perc_tax = 0.05f;
        float perc_net = 1 - perc_tax;
        Security_islandPK security_islandPK = new Security_islandPK(1);
        TransactionOutput toutput;
        BLsystemtrade blsystemtrade = new BLsystemtrade();
        BLsystemtrade_order blsystemtrade_order = new BLsystemtrade_order();
        marketstatus.addMessage("Construct system trade orders");
        blsystemtrade.deletesystemtrade();
        BLorders blorders = new BLorders();
        BLevetype blevetype = new BLevetype();
        Iterator<Orders> sellordersI;
        Evetype evetype = new Evetype(-1);
        Orders sellorder;
        ArrayList sellorders = new ArrayList();
        Iterator<Orders> buyordersI = sellorders.iterator();
        Orders buyorder;
        long prev_sellsystemid = -1;
        Iterator<Systemtrade> systemtradeI = blsystemtrade.getSystemtradeorders(security_islandPK, max_cargo, perc_net, min_profit).iterator();
        Systemtrade systemtrade;
        Systemtrade_orderPK systemtrade_orderPK;
        Systemtrade_order systemtradeorder;
        long amount = 0;
        long sellvolume = 0;
        long buyvolume = 0;
        double sellprice;
        double buyprice;
        double profit;
        double cargovolume;
        double totalprofit;
        double totalcargovolume;
        int count = 0;
        //loop all found system combinations
        while(systemtradeI.hasNext()) {
            count++;
            System.out.println("" + count);
            systemtrade = systemtradeI.next();
            totalprofit = 0;
            totalcargovolume = 0;
            buyordersI = blorders.load_buyorders4system(systemtrade.getPrimaryKey().getSystembuy_systemPK(), max_cargo, perc_net).iterator();
            //systemtradeI is sorted by sekk_system to minimize sql execution, sell order list is always biggest to load
            if(systemtrade.getPrimaryKey().getSell_system()!=prev_sellsystemid) {
                prev_sellsystemid = systemtrade.getPrimaryKey().getSell_system();
                sellorders = blorders.load_sellorders4system(systemtrade.getPrimaryKey().getSystemsell_systemPK(), max_cargo, perc_net);
            }
            sellordersI = sellorders.iterator();
            //initialize first sellorder from new list
            sellorder = sellordersI.next();
            //loop all buy orders, look for matching sell orders which make a profit
            while(buyordersI.hasNext()) {
                buyorder = buyordersI.next();
                buyvolume = buyorder.getVolume_remain();
                //find matching evetype
                while(sellorder.getEvetypePK().getId()<buyorder.getEvetypePK().getId() && sellordersI.hasNext()) {
                    sellorder = sellordersI.next();
                    sellvolume = sellorder.getVolume_remain();
                }
                //find available quantities with profit
                if(sellorder.getEvetypePK().getId()==buyorder.getEvetypePK().getId()) {
                    if(!evetype.getPrimaryKey().equals(sellorder.getEvetypePK())) {
                        evetype = blevetype.getEvetype(sellorder.getEvetypePK());
                    }
                    while(evetype.getPrimaryKey().equals(sellorder.getEvetypePK()) 
                            && buyvolume>0 && sellvolume>0 
                            && buyorder.getPrice()*perc_net>sellorder.getPrice()) {
                        amount = Math.min(sellvolume, buyvolume);
                        sellprice = amount * sellorder.getPrice();
                        buyprice = amount * buyorder.getPrice();
                        profit = buyprice * perc_net - sellprice;
                        cargovolume = amount * evetype.getPackaged_volume();
                        sellvolume -= amount;
                        buyvolume -= amount;
                        totalprofit += profit;
                        totalcargovolume += cargovolume;
                        systemtrade_orderPK = new Systemtrade_orderPK();
                        systemtrade_orderPK.setSystemtradePK(systemtrade.getPrimaryKey());
                        systemtrade_orderPK.setOrderssell_orderPK(sellorder.getPrimaryKey());
                        systemtrade_orderPK.setOrdersbuy_orderPK(buyorder.getPrimaryKey());
                        systemtradeorder = new Systemtrade_order(systemtrade_orderPK);
                        systemtradeorder.setAmount(amount);
                        systemtradeorder.setBuyprice(buyprice);
                        systemtradeorder.setCargovolume(cargovolume);
                        systemtradeorder.setProfit(profit);
                        systemtradeorder.setSellprice(sellprice);
                        blsystemtrade_order.trans_insertSystemtrade_order(systemtradeorder);
                        if((buyvolume>0 || sellvolume==0) && sellordersI.hasNext()) {
                            sellorder = sellordersI.next();
                            sellvolume = sellorder.getVolume_remain();
                        }
                    }
                }
            }
            if(totalprofit>=min_profit) {
                systemtrade.setProfit(totalprofit);
                systemtrade.setTotal_cargo_volume(totalcargovolume);
                systemtrade.setJumps(systemtrade.getJumps());
                blsystemtrade.trans_insertSystemtrade(systemtrade);
                toutput = blsystemtrade.Commit2DB_returnSQL();
                if(toutput.getHaserror()) {
                    marketstatus.addMessage(toutput.getErrormessage());
                }
                toutput = blsystemtrade_order.Commit2DB_returnSQL();
                if(toutput.getHaserror()) {
                    marketstatus.addMessage(toutput.getErrormessage());
                }
            } else {
                blsystemtrade_order.getTransactionqueue().clear();
            }
        }
    }

}
