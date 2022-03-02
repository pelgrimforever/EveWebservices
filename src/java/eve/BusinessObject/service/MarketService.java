/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eve.BusinessObject.service;

import db.TransactionOutput;
import eve.BusinessObject.Logic.BLevetype;
import eve.BusinessObject.Logic.BLorders;
import eve.BusinessObject.Logic.BLregion;
import eve.BusinessObject.Logic.BLstock;
import eve.BusinessObject.Logic.BLstocktrade;
import eve.BusinessObject.Logic.BLsyssettings;
import eve.BusinessObject.Logic.BLsystem;
import eve.BusinessObject.Logic.BLtrade;
import eve.BusinessObject.Logic.BLtradecombined;
import eve.BusinessObject.Logic.BLtradecombined_sell;
import eve.BusinessObject.Logic.BLusersettings;
import eve.BusinessObject.Logic.BLview_trade_systemsevetype;
import eve.BusinessObject.Logic.BLview_tradeorders_lowsec;
import eve.entity.pk.EvetypePK;
import eve.entity.pk.Security_islandPK;
import eve.entity.pk.StocktradePK;
import eve.entity.pk.SystemPK;
import eve.entity.pk.Tradecombined_sellPK;
import eve.interfaces.logicentity.ISettings;
import eve.interfaces.logicentity.ISyssettings;
import eve.logicentity.Orders;
import eve.logicentity.Region;
import eve.logicentity.Stock;
import eve.logicentity.Stocktrade;
import eve.logicentity.Syssettings;
import eve.logicentity.Trade;
import eve.logicentity.Tradecombined;
import eve.logicentity.Tradecombined_sell;
import eve.logicentity.Usersettings;
import eve.logicview.View_trade_systemsevetype;
import eve.logicview.View_tradeorders_lowsec;
import general.exception.CustomException;
import general.exception.DBException;
import general.exception.DataException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Market loader service
 * @author pelgrim
 */
public class MarketService implements Runnable {
    
    private String username;
    private MarketStatus marketstatus;
    private boolean keeprunning = true;
    private int maxtransactions = 50;
    
    protected Marketdata data;
    protected ArrayList<MarketRegionDownloader> downloaders;
    protected ArrayList<Thread> marketthreads;

    public void stoprunning() {
        this.keeprunning = false;
        this.AskStopthreads();
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
            blregion.setAuthenticated(true);
            
            Iterator<Region> regionI = blregion.getAll().iterator();
            Region region;
            while(regionI.hasNext()) {
                region = regionI.next();
                regions.put(region.getPrimaryKey().getId(), new RegionStatus(region));
            }
        }
        
        public void updateStatus(long regionid, int page, long orders) {
            RegionStatus regionstatus = regions.get(regionid);
            regionstatus.setPage(page);
            regionstatus.setOrders(orders);
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
        private long orders = 0;
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
        
        public void setOrders(long orders) {
            this.orders = orders;
        }

        public long getOrders() {
            return this.orders;
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
    
    public MarketService(String username) {
        this.username = username;
        BLregion blregion = new BLregion();
        blregion.setAuthenticated(true);
        
        try {
            marketstatus = new MarketStatus();
            data = new Marketdata(blregion.getAll());
        }
        catch(DBException e) {
            System.out.println(e.getMessage());
        }
    }
    
    protected boolean locktoONEprocessor = false;
    private static int processors = Runtime.getRuntime().availableProcessors(); //max number of available processors
    private static int maxprocessors = 4; //max number of available processors
    
    /**
     * Get number of processors
     * @return amount of processors
     */
    public static int getProcessors() {
        return processors;
    }
    
    public int processorsasked = processors;
    
    /**
     * Processors (threads) currently working
     */
    private static int processorsactive = 0;
    public static int getProcessorsactive() {
        return processorsactive;
    }
    /**
     * set activeprocessors
     * set the cpu text used in GUI
     * @param value 
     */
    protected static void setProcessorsactive(int value) {
        processorsactive = value;
    }

    @Override
    public void run() {
        try {
            BLorders blorders = new BLorders();
            blorders.setAuthenticated(true);
            
            //more orders to order_hist
            marketstatus.addMessage("Delete orders");
            if(blorders.count()>0) {
                //blorderhist.deleteorders();
                //blorderhist.copyorders();
                blorders.deleteorders();
            }
        }
        catch(DBException e) {
            marketstatus.addMessage(e.getMessage());
        }
        catch(DataException e) {
            marketstatus.addMessage(e.getMessage());
        }
        marketstatus.addMessage("Download orders");

        downloaders = new ArrayList<>();
        marketthreads = new ArrayList<>();
        MarketRegionDownloader downloader;
        Thread marketthread;
        int p;
        //start all threads
        long start = System.currentTimeMillis();
        try {
            if(processorsasked>maxprocessors) processors = maxprocessors;
            for(p=0; p<processorsasked && p<processors; p++) {
                downloader = new MarketRegionDownloader(data, marketstatus, p);
                downloaders.add(downloader);
                marketthread = new Thread(downloader);
                marketthreads.add(marketthread);
                marketthread.setPriority(Thread.MIN_PRIORITY);
                marketthread.start();
            }
            setProcessorsactive(processors);
            //wait untill all threads are finished
            for(p=0; p<processorsasked && p<processors; p++) {
                marketthread = marketthreads.get(p);
                marketthread.join();
            }
        }
        catch(InterruptedException e) {
        }
        long end = System.currentTimeMillis();
        marketstatus.addMessage("Download time Swagger -> orders " + ((end - start)/1000) + "sec.");

        try {
            processView_tradeorders();
            combineTradeorders();
            processStock();
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

    /**
     * Shut down all downloads
     */
    public void AskStopthreads() {
        for(int i=0, l=downloaders.size(); i<l; i++) {
            downloaders.get(i).stoprunning();
        }
        for(int i=0, l=marketthreads.size(); i<l; i++) {
            marketthreads.get(i).interrupt();
        }
        downloaders = new ArrayList<>();
        marketthreads = new ArrayList<>();
    }

    /**
     * calculate current average prices
     * search trade opportunities and store in table Trade
     * search the best prices for items in stock and store in table Stocktrade
     * @throws DataException
     * @throws DBException 
     */
    private void processView_tradeorders() throws DataException, DBException, CustomException {
        long start = System.currentTimeMillis();
        BLorders blorders = new BLorders();
        blorders.setAuthenticated(true);
        BLregion blregion = new BLregion();
        blregion.setAuthenticated(true);
        BLevetype blevetype = new BLevetype();
        blevetype.setAuthenticated(true);
        BLsystem blsystem = new BLsystem();
        blsystem.setAuthenticated(true);
        BLtrade bltrade = new BLtrade();
        bltrade.setAuthenticated(true);
        //BLview_tradeorders blviewtradeorders = new BLview_tradeorders();
        BLview_tradeorders_lowsec blviewtradeorders_lowsec = new BLview_tradeorders_lowsec();
        blviewtradeorders_lowsec.setAuthenticated(true);
        BLsyssettings blsyssettings = new BLsyssettings();
        blsyssettings.setAuthenticated(true);
        

        //calculate average, min and max price for buy/sell orders for each evetype
        marketstatus.addMessage("Update average prices");
        blevetype.updateaverageprices();
        
        marketstatus.addMessage("Construct trade table");
        bltrade.deletetrade();
        //load usersettings
        Syssettings set_brokerfee = blsyssettings.getSyssettings(ISyssettings.BROKER_FEE);
        Syssettings set_maxcargo = blsyssettings.getSyssettings(ISyssettings.MAXCARGO);
        Syssettings set_minprofit = blsyssettings.getSyssettings(ISyssettings.MIN_PROFIT);
        Syssettings set_minprofitperjump = blsyssettings.getSyssettings(ISyssettings.MIN_PROFIT_PER_JUMP);
        float max_cargo = Float.valueOf(set_maxcargo.getValue());
        long min_profit = Long.valueOf(set_minprofit.getValue());
        long min_profit_per_jump = Long.valueOf(set_minprofitperjump.getValue());
        float perc_tax = Float.valueOf(set_brokerfee.getValue());
        float perc_net = 1 - perc_tax;
        Security_islandPK security_islandPK = new Security_islandPK(1);
        //get all view_tradeorders
        //Iterator<View_tradeorders> tradeordersI = blviewtradeorders.getTradeorders(security_islandPK, max_cargo, perc_net, min_profit).iterator();
        Iterator<View_tradeorders_lowsec> tradeordersI = blviewtradeorders_lowsec.getTradeorders(max_cargo, perc_net, min_profit).iterator();
        //View_tradeorders tradeorder;
        View_tradeorders_lowsec tradeorder;
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
        StringBuilder sql;
        
        //loop all orders from view
        //add trade opportunities in Trade
        while(keeprunning && tradeordersI.hasNext()) {
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
/*                    trade = new Trade(tradeorder.getSell_id(), tradeorder.getBuy_id());
                    trade.setBuy_order_value(buyordervalue);
                    trade.setJumps(jumps);
                    trade.setJumpslowsec(tradeorder.getJumpslowsec());
                    trade.setJumpsnullsec(tradeorder.getJumpsnullsec());
                    trade.setMaxunits_per_run(maxunits_per_run);
                    trade.setProfit(profit);
                    trade.setProfit_per_jump(profit_per_jump);
                    trade.setRuns(runs);
                    trade.setSell_order_value(sellordervalue);
                    trade.setSinglerun_profit_per_jump(singlerun_profit_per_jump);
                    trade.setTotal_jumps(totaljumps);
                    trade.setTotal_volume(totalvolume);
                    bltrade.trans_insertTrade(trade);
*/
                    sql = new StringBuilder("insert into trade (sell_order_id, buy_order_id, total_volume, buy_order_value, sell_order_value, profit, jumps, runs, total_jumps, profit_per_jump, singlerun_profit_per_jump, maxunits_per_run, jumpslowsec, jumpsnullsec) values (");
                    sql.append(tradeorder.getSell_id()).append(","); //sell_order_id
                    sql.append(tradeorder.getBuy_id()).append(","); //buy_order_id
                    sql.append(totalvolume).append(","); //total_volume
                    sql.append(buyordervalue).append(",");//buy_order_value
                    sql.append(sellordervalue).append(",");//sell_order_value
                    sql.append(profit).append(",");//profit
                    sql.append(jumps).append(",");//jumps
                    sql.append(runs).append(",");//runs
                    sql.append(totaljumps).append(",");//total_jumps
                    sql.append(profit_per_jump).append(",");//profit_per_jump
                    sql.append(singlerun_profit_per_jump).append(",");//singlerun_profit_per_jump
                    sql.append(maxunits_per_run).append(",");//maxunits_per_run
                    sql.append(tradeorder.getJumpslowsec()).append(",");//jumpslowsec
                    sql.append(tradeorder.getJumpsnullsec());//jumpsnullsec
                    sql.append(")");
                    bltrade.addStatement(sql.toString());
                    count++;
                    if(count==maxtransactions) {
                        toutput = bltrade.Commit2DB();
                        if(toutput.getHaserror()) {
                            marketstatus.addMessage(toutput.getErrormessage());
                        }
                    }
                }
            }
            toutput = bltrade.Commit2DB();
            if(toutput.getHaserror()) {
                marketstatus.addMessage(toutput.getErrormessage());
            }
        }        
        long end = System.currentTimeMillis();
        marketstatus.addMessage("Trade orders compiled in " + ((end - start)/1000) + "sec.");
    }
    
    private void combineTradeorders() throws DBException, DataException {
        long start = System.currentTimeMillis();
        marketstatus.addMessage("Combine trade orders");
        BLview_trade_systemsevetype blview_trade_systemsevetype = new BLview_trade_systemsevetype();
        blview_trade_systemsevetype.setAuthenticated(true);
        BLorders blorders = new BLorders();
        blorders.setAuthenticated(true);
        BLusersettings blusersettings = new BLusersettings();
        blusersettings.setAuthenticated(true);
        BLtradecombined bltradecombined = new BLtradecombined();
        bltradecombined.setAuthenticated(true);
        BLtradecombined_sell bltradecombined_sell = new BLtradecombined_sell();
        bltradecombined_sell.setAuthenticated(true);
        BLsyssettings blsyssettings = new BLsyssettings();
        blsyssettings.setAuthenticated(true);
        //load usersettings
        Syssettings set_brokerfee = blsyssettings.getSyssettings(ISyssettings.BROKER_FEE);
        float perc_tax = Float.valueOf(set_brokerfee.getValue());
        float perc_net = 1 - perc_tax;

        //buy system, sell system, evetype combinations
        ArrayList<View_trade_systemsevetype> view_trade_systemsevetypes = blview_trade_systemsevetype.getAll();
        Iterator<Orders> buyordersI;
        Orders buyorder;
        Iterator<Orders> sellordersI;
        Orders sellorder;
        SystemPK sellsystemPK;
        SystemPK buysystemPK;
        EvetypePK evetypePK;
        long buyorderasked = 0;
        long sellorderasked = 0;
        long amount;
        boolean hasprofit, ordersavailable;
        Tradecombined tradecombined;
        Tradecombined_sellPK tradecombined_sellPK;
        Tradecombined_sell tradecombined_sell;
        int insertcounter = 0;
        StringBuilder sql;
        TransactionOutput toutput;
        for(View_trade_systemsevetype view_trade_systemsevetype: view_trade_systemsevetypes) {
            sellsystemPK = new SystemPK(view_trade_systemsevetype.getSystemsell());
            buysystemPK = new SystemPK(view_trade_systemsevetype.getSystembuy());
            evetypePK = new EvetypePK(view_trade_systemsevetype.getEvetype());
            sellordersI = blorders.load_sellorders4systemevetype(sellsystemPK, evetypePK).iterator();
            buyordersI = blorders.load_buyorders4systemevetype(buysystemPK, evetypePK).iterator();
            sellorder = sellordersI.next();
            buyorder = buyordersI.next();
            buyorderasked = buyorder.getVolume_remain();
            sellorderasked = sellorder.getVolume_remain();
            hasprofit = buyorder.getPrice()*perc_net>sellorder.getPrice();
            ordersavailable = buyorderasked>0 && sellorderasked>0;
            //new Tradecombined per View_trade_systeevetype
/*            tradecombined = new Tradecombined(sellsystemPK.getId(), buysystemPK.getId(), evetypePK.getId());
            tradecombined.setJumps(view_trade_systemsevetype.getJumps());
            tradecombined.setJumpslowsec(view_trade_systemsevetype.getJumpslowsec());
            tradecombined.setJumpsnullsec(view_trade_systemsevetype.getJumpsnullsec());
            bltradecombined.trans_insertTradecombined(tradecombined);
*/
            sql = new StringBuilder("insert into tradecombined values (");
            sql.append(sellsystemPK.getId()).append(",");
            sql.append(buysystemPK.getId()).append(",");
            sql.append(evetypePK.getId()).append(",");
            sql.append(view_trade_systemsevetype.getJumps()).append(",");
            sql.append(view_trade_systemsevetype.getJumpslowsec()).append(",");
            sql.append(view_trade_systemsevetype.getJumpsnullsec()).append(")");
            bltradecombined.addStatement(sql.toString());
            while(hasprofit && ordersavailable) {
                amount = Math.min(buyorderasked, sellorderasked);
/*                tradecombined_sellPK = new Tradecombined_sellPK();
                tradecombined_sellPK.setTradecombinedPK(tradecombined.getPrimaryKey());
                tradecombined_sellPK.setOrdersbuy_order_idPK(buyorder.getPrimaryKey());
                tradecombined_sellPK.setOrderssell_order_idPK(sellorder.getPrimaryKey());
                tradecombined_sell = new Tradecombined_sell(tradecombined_sellPK);
                tradecombined_sell.setAmount(amount);
                tradecombined_sell.setBuy_order_value(buyorder.getPrice() * amount);
                tradecombined_sell.setSell_order_value(sellorder.getPrice() * amount);
                tradecombined_sell.setProfit((buyorder.getPrice() * perc_net - sellorder.getPrice()) * amount);
                bltradecombined_sell.trans_insertTradecombined_sell(tradecombined_sell);*/
                sql = new StringBuilder("insert into tradecombined_sell values (");
                sql.append(sellsystemPK.getId()).append(",");
                sql.append(buysystemPK.getId()).append(",");
                sql.append(evetypePK.getId()).append(",");
                sql.append(buyorder.getPrimaryKey().getId()).append(",");
                sql.append(sellorder.getPrimaryKey().getId()).append(",");
                sql.append(amount).append(",");
                sql.append(buyorder.getPrice() * amount).append(",");
                sql.append(sellorder.getPrice() * amount).append(",");
                sql.append((buyorder.getPrice() * perc_net - sellorder.getPrice()) * amount).append(")");
                bltradecombined_sell.addStatement(sql.toString());
                insertcounter++;
                buyorderasked -= amount;
                sellorderasked -= amount;
                if(buyorderasked==0 && buyordersI.hasNext()) {
                    buyorder = buyordersI.next();
                    buyorderasked += buyorder.getVolume_remain();
                }
                if(sellorderasked==0 && sellordersI.hasNext()) {
                    sellorder = sellordersI.next();
                    sellorderasked += sellorder.getVolume_remain();
                }
                hasprofit = buyorder.getPrice()*perc_net>sellorder.getPrice();
                ordersavailable = buyorderasked>0 && sellorderasked>0;
            }
            if(insertcounter>maxtransactions) {
                toutput = bltradecombined.Commit2DB();
                if(toutput.getHaserror()) {
                    marketstatus.addMessage(toutput.getErrormessage());
                }
                toutput = bltradecombined_sell.Commit2DB();
                if(toutput.getHaserror()) {
                    marketstatus.addMessage(toutput.getErrormessage());
                }
            }
        }
        toutput = bltradecombined.Commit2DB();
        if(toutput.getHaserror()) {
            marketstatus.addMessage(toutput.getErrormessage());
        }
        toutput = bltradecombined_sell.Commit2DB();
        if(toutput.getHaserror()) {
            marketstatus.addMessage(toutput.getErrormessage());
        }
        long end = System.currentTimeMillis();
        marketstatus.addMessage("Combined Orders by System/Type in " + ((end - start)/1000) + "sec.");
    }
    
    /**
     * search highest bidding prices for stock items
     * save in stocktrade
     * @throws DBException
     * @throws DataException 
     */
    private void processStock() throws DBException, DataException {
        marketstatus.addMessage("Construct stocktrade table");
        BLorders blorders = new BLorders();
        blorders.setAuthenticated(true);
        BLstock blstock = new BLstock();
        blstock.setAuthenticated(true);
        BLstocktrade blstocktrade = new BLstocktrade();
        blstocktrade.setAuthenticated(true);
        BLusersettings blusersettings = new BLusersettings();
        blusersettings.setAuthenticated(true);
        
        blstocktrade.deletestocktrade(username);
        blstocktrade.Commit2DB();
        //Security_islandPK security_islandPK = new Security_islandPK(1);
        //load usersettings
        ArrayList<Usersettings> usersettings = blusersettings.getUsersettings(username);
        long stocksystemid = Long.valueOf(blusersettings.getUsersetting(usersettings, ISettings.STOCKSYSTEMID).getValue());
        SystemPK stocksystemPK = new SystemPK(stocksystemid);
        Iterator<Stock> stockI = blstock.getStock4user(username).iterator();
        Stock stock;
        Iterator<Orders> ordersI;
        Orders order;
        StocktradePK stocktradePK;
        Stocktrade stocktrade;
        long stockamount;
        long tradeamount;
        TransactionOutput toutput;
        while(keeprunning && stockI.hasNext()) {
            stock = stockI.next();
            stockamount = stock.getAmount();
            //ordersI = blorders.load_buyorders4evetype(security_islandPK, stock.getPrimaryKey().getEvetypePK()).iterator();
            ordersI = blorders.load_buyorders4evetype(stocksystemPK, stock.getPrimaryKey().getEvetypePK()).iterator();
            while(ordersI.hasNext() && stockamount>0) {
                order = ordersI.next();
                tradeamount = Math.min(order.getVolume_remain(), stockamount);
                if(tradeamount>=order.getMin_volume()) {
                    stocktradePK = new StocktradePK();
                    stocktradePK.setStockPK(stock.getPrimaryKey());
                    stocktradePK.setOrderid(order.getPrimaryKey().getId());
                    stocktrade = new Stocktrade(stocktradePK);
                    stocktrade.setSellamount(tradeamount);
                    blstocktrade.trans_insertStocktrade(stocktrade);
                    stockamount -= tradeamount;
                }
            }
        }
        toutput = blstocktrade.Commit2DB();
        if(toutput.getHaserror()) {
            marketstatus.addMessage(toutput.getErrormessage());
        }
    }
}
