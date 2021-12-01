/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eve.BusinessObject.service;

import db.TransactionOutput;
import eve.BusinessObject.Logic.BLevetype;
import eve.BusinessObject.Logic.BLorder_hist;
import eve.BusinessObject.Logic.BLorders;
import eve.BusinessObject.Logic.BLregion;
import eve.BusinessObject.Logic.BLroute;
import eve.BusinessObject.Logic.BLstock;
import eve.BusinessObject.Logic.BLstocktrade;
import eve.BusinessObject.Logic.BLsystem;
import eve.BusinessObject.Logic.BLsystemjumps;
import eve.BusinessObject.Logic.BLtrade;
import eve.BusinessObject.Logic.BLtradecombined;
import eve.BusinessObject.Logic.BLtradecombined_sell;
import eve.BusinessObject.Logic.BLusersettings;
import eve.BusinessObject.Logic.BLview_trade_systemsevetype;
import eve.BusinessObject.Logic.BLview_tradeorders;
import eve.BusinessObject.Logic.RouteHash;
import eve.entity.pk.EvetypePK;
import eve.entity.pk.RoutetypePK;
import eve.entity.pk.Security_islandPK;
import eve.entity.pk.StocktradePK;
import eve.entity.pk.SystemPK;
import eve.entity.pk.SystemjumpsPK;
import eve.entity.pk.Tradecombined_sellPK;
import eve.interfaces.logicentity.ISettings;
import eve.logicentity.Orders;
import eve.logicentity.Region;
import eve.logicentity.Stock;
import eve.logicentity.Stocktrade;
import eve.logicentity.Systemjumps;
import eve.logicentity.Trade;
import eve.logicentity.Tradecombined;
import eve.logicentity.Tradecombined_sell;
import eve.logicentity.Usersettings;
import eve.logicview.View_trade_systemsevetype;
import eve.logicview.View_tradeorders;
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
    
    public MarketService(String username) {
        this.username = username;
        try {
            marketstatus = new MarketStatus();
            BLregion blregion = new BLregion();
            data = new Marketdata(blregion.getAll());
        }
        catch(DBException e) {
            System.out.println(e.getMessage());
        }
    }
    
    protected boolean locktoONEprocessor = false;
    private static int processors = Runtime.getRuntime().availableProcessors(); //max number of available processors
    //private static int processors = 4; //max number of available processors
    
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
        RouteHash routehash = new RouteHash(new RoutetypePK(1));
        BLorders blorders = new BLorders();
        BLorder_hist blorderhist = new BLorder_hist();
        BLregion blregion = new BLregion();
        BLevetype blevetype = new BLevetype();
        BLsystem blsystem = new BLsystem();
        BLroute blroute = new BLroute();
        BLtrade bltrade = new BLtrade();
        BLview_tradeorders blviewtradeorders = new BLview_tradeorders();
        BLusersettings blusersettings = new BLusersettings();

        //calculate average, min and max price for buy/sell orders for each evetype
        marketstatus.addMessage("Update average prices");
        blevetype.updateaverageprices();
        
        marketstatus.addMessage("Construct trade table");
        bltrade.deletetrade();
        //load usersettings
        ArrayList<Usersettings> usersettings = blusersettings.getUsersettings(username);
        Usersettings brokerfee = blusersettings.getUsersetting(usersettings, ISettings.BROKER_FEE);
        float max_cargo = 33980.4f;
        long min_profit = 1000000;
        long min_profit_per_jump = 100000;
        float perc_tax = Float.valueOf(brokerfee.getValue());
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
    }
    
    private void combineTradeorders() throws DBException, DataException {
        marketstatus.addMessage("Combine trade orders");
        BLview_trade_systemsevetype blview_trade_systemsevetype = new BLview_trade_systemsevetype();
        BLorders blorders = new BLorders();
        BLusersettings blusersettings = new BLusersettings();
        BLtradecombined bltradecombined = new BLtradecombined();
        BLtradecombined_sell bltradecombined_sell = new BLtradecombined_sell();
        //load usersettings
        ArrayList<Usersettings> usersettings = blusersettings.getUsersettings(username);
        Usersettings brokerfee = blusersettings.getUsersetting(usersettings, ISettings.BROKER_FEE);
        float perc_tax = Float.valueOf(brokerfee.getValue());
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
        Systemjumps systemjumps;
        SystemjumpsPK systemjumpspk;
        long buyorderasked = 0;
        long sellorderasked = 0;
        long amount;
        boolean hasprofit, ordersavailable;
        Tradecombined tradecombined;
        Tradecombined_sellPK tradecombined_sellPK;
        Tradecombined_sell tradecombined_sell;
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
            tradecombined = new Tradecombined(sellsystemPK.getId(), buysystemPK.getId(), evetypePK.getId());
            tradecombined.setJumps(view_trade_systemsevetype.getJumps());
            bltradecombined.trans_insertTradecombined(tradecombined);
            while(hasprofit && ordersavailable) {
                amount = Math.min(buyorderasked, sellorderasked);
                tradecombined_sellPK = new Tradecombined_sellPK();
                tradecombined_sellPK.setTradecombinedPK(tradecombined.getPrimaryKey());
                tradecombined_sellPK.setOrdersbuy_order_idPK(buyorder.getPrimaryKey());
                tradecombined_sellPK.setOrderssell_order_idPK(sellorder.getPrimaryKey());
                tradecombined_sell = new Tradecombined_sell(tradecombined_sellPK);
                tradecombined_sell.setAmount(amount);
                tradecombined_sell.setBuy_order_value(buyorder.getPrice() * amount);
                tradecombined_sell.setSell_order_value(sellorder.getPrice() * amount);
                tradecombined_sell.setProfit((buyorder.getPrice() * perc_net - sellorder.getPrice()) * amount);
                bltradecombined_sell.trans_insertTradecombined_sell(tradecombined_sell);
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
            bltradecombined.Commit2DB();
            bltradecombined_sell.Commit2DB();
        }
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
        BLstock blstock = new BLstock();
        BLstocktrade blstocktrade = new BLstocktrade();
        Security_islandPK security_islandPK = new Security_islandPK(1);
        Iterator<Stock> stockI = blstock.getAll().iterator();
        Stock stock;
        Iterator<Orders> ordersI;
        Orders order;
        StocktradePK stocktradePK;
        Stocktrade stocktrade;
        long stockamount;
        long tradeamount;
        while(keeprunning && stockI.hasNext()) {
            stock = stockI.next();
            stockamount = stock.getAmount();
            ordersI = blorders.load_buyorders4evetype(security_islandPK, stock.getPrimaryKey().getEvetypePK()).iterator();
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
        blstocktrade.Commit2DB();
    }
}
