package eve.BusinessObject.service;

import db.SQLTwriter;
import db.SQLToutput;
import db.SQLTqueue;
import db.SQLreader;
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
import eve.entity.pk.StocktradePK;
import eve.entity.pk.SystemPK;
import eve.interfaces.logicentity.ISettings;
import eve.interfaces.logicentity.ISyssettings;
import eve.logicentity.Orders;
import eve.logicentity.Region;
import eve.logicentity.Stock;
import eve.logicentity.Stocktrade;
import eve.logicentity.Syssettings;
import eve.logicentity.Trade;
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
 * @author Franky Laseure
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
        
        public MarketStatus(ArrayList<Region> regionsarray) throws DBException {
            for(Region region: regionsarray)
                regions.put(region.getPrimaryKey().getId(), new RegionStatus(region));
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
    
    public MarketService(SQLreader sqlreader, SQLTwriter sqlwriter, String username) {
        this.sqlreader = sqlreader;
        this.sqlwriter = sqlwriter;
        this.username = username;
    }
    
    protected boolean locktoONEprocessor = false;
    private static int processors = Runtime.getRuntime().availableProcessors(); //max number of available processors
    private final static int maxprocessors = 4;
    private int processorsasked = processors;
    private static int processorsactive = 0;
    
    public static int getProcessors() {
        return processors;
    }
        
    public static int getProcessorsactive() {
        return processorsactive;
    }

    protected static void setProcessorsactive(int value) {
        processorsactive = value;
    }

    private SQLreader sqlreader;
    private SQLTwriter sqlwriter;
    private SQLTqueue transactionqueue;
    private BLorders blorders;
    private BLregion blregion;
    private BLevetype blevetype;
    private BLsystem blsystem;
    private BLtrade bltrade;
    private BLview_tradeorders_lowsec blviewtradeorders_lowsec;
    private BLsyssettings blsyssettings;
    private BLview_trade_systemsevetype blview_trade_systemsevetype;
    private BLtradecombined bltradecombined;
    private BLtradecombined_sell bltradecombined_sell;
    private BLstock blstock;
    private BLstocktrade blstocktrade;
    private BLusersettings blusersettings;
    
    @Override
    public void run() {
        try {
            initialize_businesslogic();
            delete_orders();
            download_swagger_orders();
            load_system_user_settings();
            calculate_tradeorders();
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

    private void delete_orders() {
        try {
            marketstatus.addMessage("Delete orders");
            if(blorders.count()>0) {
                blorders.deleteorders(transactionqueue);
                sqlwriter.Commit2DB(transactionqueue);
            }
        }
        catch(DBException e) {
            marketstatus.addMessage(e.getMessage());
        }
        catch(DataException e) {
            marketstatus.addMessage(e.getMessage());
        }
    }

    private void download_swagger_orders() {
        marketstatus.addMessage("Download orders");
        long start = System.currentTimeMillis();
        downloaders = new ArrayList<>();
        marketthreads = new ArrayList<>();
        int p;
        try {
            if(processorsasked>maxprocessors) processors = maxprocessors;
            for(p=0; p<processorsasked && p<processors; p++)
                start_marketdownloader(p);
            setProcessorsactive(processors);
            for(p=0; p<processorsasked && p<processors; p++)
                join_marketthreads(p);
        }
        catch(InterruptedException e) {
        }
        long end = System.currentTimeMillis();
        marketstatus.addMessage("Download time Swagger -> orders " + ((end - start)/1000) + "sec.");
    }

    private void join_marketthreads(int p) throws InterruptedException {
        Thread marketthread;
        marketthread = marketthreads.get(p);
        marketthread.join();
    }

    private void start_marketdownloader(int p) {
        MarketRegionDownloader downloader;
        Thread marketthread;
        downloader = new MarketRegionDownloader(sqlreader, sqlwriter, data, marketstatus, p);
        downloaders.add(downloader);
        marketthread = new Thread(downloader);
        marketthreads.add(marketthread);
        marketthread.setPriority(Thread.MIN_PRIORITY);
        marketthread.start();
    }

    public void AskStopthreads() {
        for(int i=0, l=downloaders.size(); i<l; i++)
            downloaders.get(i).stoprunning();
        for(int i=0, l=marketthreads.size(); i<l; i++)
            marketthreads.get(i).interrupt();
        downloaders = new ArrayList<>();
        marketthreads = new ArrayList<>();
    }

    private float max_cargo;
    private long min_profit;
    private long min_profit_per_jump;
    private float perc_tax;
    private float perc_net;
    private double buyordervalue;
    private double sellordervalue;
    private double totalvolume;
    private int maxunits_per_run;
    private double profit_per_unit;
    private double totalprofit;
    private double profit_per_jump;
    private double singlerun_profit_per_jump;
    private int jumps_for_single_trip;
    private int totaljumps;
    private int runs_for_1_complete_order;
    private Trade trade;
    private int count;
    private SQLToutput toutput;
    private Iterator<View_tradeorders_lowsec> tradeordersI;
    private View_tradeorders_lowsec tradeorder;
    
    private void calculate_tradeorders() throws DataException, DBException, CustomException {
        long start = System.currentTimeMillis();
        update_average_prices_of_evetypes();
        marketstatus.addMessage("Construct trade table");
        bltrade.deletetrade(transactionqueue);
        sqlwriter.Commit2DB(transactionqueue);
        tradeordersI = blviewtradeorders_lowsec.getTradeorders(max_cargo, perc_net, min_profit).iterator();
        count = 0;
        while(keeprunning && tradeordersI.hasNext())
            process_candidate_trade();
        long end = System.currentTimeMillis();
        marketstatus.addMessage("Trade orders compiled in " + ((end - start)/1000) + "sec.");
    }

    private void process_candidate_trade() throws DBException {
        tradeorder = tradeordersI.next();
        calculate_trade_parameters();
        if(totalprofit>=min_profit)
            create_trade_when_profit_per_jump_is_big_enough();
        save_trade_buffer();
    }

    private void calculate_trade_parameters() {
        totalvolume = tradeorder.getTradevolume();
        buyordervalue = tradeorder.getBuy_totalprice();
        sellordervalue = tradeorder.getSell_totalprice();
        profit_per_unit = tradeorder.getBuy_price() * perc_net - tradeorder.getSell_price();
        totalprofit = buyordervalue * perc_net - sellordervalue;
    }

    private void create_trade_when_profit_per_jump_is_big_enough() throws DBException {
        calculate_trade_parameters_per_jump();
        if(runs_for_1_complete_order>1)
            singlerun_profit_per_jump = maxunits_per_run * (profit_per_unit) / jumps_for_single_trip;
        if(profit_per_jump >= min_profit_per_jump || singlerun_profit_per_jump >= min_profit_per_jump)
            create_trade_record();
    }

    private void calculate_trade_parameters_per_jump() {
        jumps_for_single_trip = tradeorder.getJumps();
        if(jumps_for_single_trip==0) jumps_for_single_trip = 1;
        maxunits_per_run = (int)Math.floor(max_cargo/tradeorder.getSell_packaged_volume());
        runs_for_1_complete_order = (int)Math.ceil(totalvolume/maxunits_per_run);
        totaljumps = jumps_for_single_trip * (runs_for_1_complete_order * 2 -1);
        profit_per_jump = totalprofit / totaljumps;
        singlerun_profit_per_jump = profit_per_jump;
    }

    private void create_trade_record() throws DBException {
        bltrade.addStatement(transactionqueue, build_trade_insert_statement().toString());
        count++;
        if(count==maxtransactions)
            save_trade_buffer();
    }

    private StringBuilder build_trade_insert_statement() {
        StringBuilder sql = new StringBuilder("insert into trade (sell_order_id, buy_order_id, total_volume, buy_order_value, sell_order_value, profit, jumps, runs, total_jumps, profit_per_jump, singlerun_profit_per_jump, maxunits_per_run, jumpslowsec, jumpsnullsec) values (");
        sql.append(tradeorder.getSell_id()).append(","); //sell_order_id
        sql.append(tradeorder.getBuy_id()).append(","); //buy_order_id
        sql.append(totalvolume).append(","); //total_volume
        sql.append(buyordervalue).append(",");//buy_order_value
        sql.append(sellordervalue).append(",");//sell_order_value
        sql.append(totalprofit).append(",");//profit
        sql.append(jumps_for_single_trip).append(",");//jumps
        sql.append(runs_for_1_complete_order).append(",");//runs
        sql.append(totaljumps).append(",");//total_jumps
        sql.append(profit_per_jump).append(",");//profit_per_jump
        sql.append(singlerun_profit_per_jump).append(",");//singlerun_profit_per_jump
        sql.append(maxunits_per_run).append(",");//maxunits_per_run
        sql.append(tradeorder.getJumpslowsec()).append(",");//jumpslowsec
        sql.append(tradeorder.getJumpsnullsec());//jumpsnullsec
        sql.append(")");
        return sql;
    }

    private void save_trade_buffer() throws DBException {
        toutput = sqlwriter.Commit2DB(transactionqueue);
        if(toutput.getHaserror())
            marketstatus.addMessage(toutput.getErrormessage());
    }

    private void load_system_user_settings() throws DataException, NumberFormatException, DBException {
        Syssettings set_brokerfee = blsyssettings.getSyssettings(ISyssettings.BROKER_FEE);
        Syssettings set_maxcargo = blsyssettings.getSyssettings(ISyssettings.MAXCARGO);
        Syssettings set_minprofit = blsyssettings.getSyssettings(ISyssettings.MIN_PROFIT);
        Syssettings set_minprofitperjump = blsyssettings.getSyssettings(ISyssettings.MIN_PROFIT_PER_JUMP);
        max_cargo = Float.valueOf(set_maxcargo.getValue());
        min_profit = Long.valueOf(set_minprofit.getValue());
        min_profit_per_jump = Long.valueOf(set_minprofitperjump.getValue());
        perc_tax = Float.valueOf(set_brokerfee.getValue());
        perc_net = 1 - perc_tax;
        ArrayList<Usersettings> usersettings = blusersettings.get_or_initialize_Usersettings(transactionqueue, username);
        stocksystemid = Long.valueOf(blusersettings.getUsersetting(usersettings, ISettings.STOCKSYSTEMID).getValue());
    }

    private void update_average_prices_of_evetypes() throws DBException, DataException {
        marketstatus.addMessage("Update average prices");
        blevetype.updateaverageprices(transactionqueue);
        sqlwriter.Commit2DB(transactionqueue);
    }

    private void initialize_businesslogic() throws DBException {
        transactionqueue = new SQLTqueue();
        blorders = new BLorders(sqlreader);
        blorders.setAuthenticated(true);
        blregion = new BLregion(sqlreader);
        blregion.setAuthenticated(true);
        ArrayList<Region> regions = blregion.getAll_Orderpages();
        marketstatus = new MarketStatus(regions);
        data = new Marketdata(regions);
        blevetype = new BLevetype(sqlreader);
        blevetype.setAuthenticated(true);
        blsystem = new BLsystem(sqlreader);
        blsystem.setAuthenticated(true);
        bltrade = new BLtrade(sqlreader);
        bltrade.setAuthenticated(true);
        blviewtradeorders_lowsec = new BLview_tradeorders_lowsec(sqlreader);
        blviewtradeorders_lowsec.setAuthenticated(true);
        blsyssettings = new BLsyssettings(sqlreader);
        blsyssettings.setAuthenticated(true);
        blview_trade_systemsevetype = new BLview_trade_systemsevetype(sqlreader);
        blview_trade_systemsevetype.setAuthenticated(true);
        bltradecombined = new BLtradecombined(sqlreader);
        bltradecombined.setAuthenticated(true);
        bltradecombined_sell = new BLtradecombined_sell(sqlreader);
        bltradecombined_sell.setAuthenticated(true);
        blstock = new BLstock(sqlreader);
        blstock.setAuthenticated(true);
        blstocktrade = new BLstocktrade(sqlreader);
        blstocktrade.setAuthenticated(true);
        blusersettings = new BLusersettings(sqlreader);
        blusersettings.setAuthenticated(true);
    }

    private Iterator<Orders> buyordersI;
    private Orders buyorder;
    private Iterator<Orders> sellordersI;
    private Orders sellorder;
    private SystemPK sellsystemPK;
    private SystemPK buysystemPK;
    private EvetypePK evetypePK;
    private long buyorderasked;
    private long sellorderasked;
    private long amount;
    private boolean hasprofit, ordersavailable;
    private int insertcounter;
    
    private void combineTradeorders() throws DBException, DataException {
        long start = System.currentTimeMillis();
        marketstatus.addMessage("Combine trade orders");

        ArrayList<View_trade_systemsevetype> view_trade_systemsevetypes = blview_trade_systemsevetype.getView_trade_systemsevetypes();
        initialize_tradecombined_counters();
        for(View_trade_systemsevetype view_trade_systemsevetype: view_trade_systemsevetypes)
            create_tradecombined(view_trade_systemsevetype);
        save_tradecombined_buffers();
        long end = System.currentTimeMillis();
        marketstatus.addMessage("Combined Orders by System/Type in " + ((end - start)/1000) + "sec.");
    }

    private void initialize_tradecombined_counters() {
        buyorderasked = 0;
        sellorderasked = 0;
        insertcounter = 0;
    }

    private void create_tradecombined(View_trade_systemsevetype view_trade_systemsevetype) throws DBException {
        evetypePK = new EvetypePK(view_trade_systemsevetype.getEvetype());
        initialize_sellorder_parameters(view_trade_systemsevetype);
        initialize_buyorder_parameters(view_trade_systemsevetype);
        initialize_tradecombined_parameters(view_trade_systemsevetype);
        bltradecombined.addStatement(transactionqueue, build_tradecombined_statement(view_trade_systemsevetype).toString());
        while(hasprofit && ordersavailable)
            create_new_tradecombination_sell();
        if(insertcounter>maxtransactions)
            save_tradecombined_buffers();
    }

    private void initialize_tradecombined_parameters(View_trade_systemsevetype view_trade_systemsevetype) {
        hasprofit = buyorder.getPrice()*perc_net>sellorder.getPrice();
        ordersavailable = buyorderasked>0 && sellorderasked>0;
    }

    private void initialize_buyorder_parameters(View_trade_systemsevetype view_trade_systemsevetype) throws DBException {
        buysystemPK = new SystemPK(view_trade_systemsevetype.getSystembuy());
        buyordersI = blorders.load_buyorders4systemevetype(buysystemPK, evetypePK).iterator();
        buyorder = buyordersI.next();
        buyorderasked = buyorder.getVolume_remain();
    }

    private void initialize_sellorder_parameters(View_trade_systemsevetype view_trade_systemsevetype) throws DBException {
        sellsystemPK = new SystemPK(view_trade_systemsevetype.getSystemsell());
        sellordersI = blorders.load_sellorders4systemevetype(sellsystemPK, evetypePK).iterator();
        sellorder = sellordersI.next();
        sellorderasked = sellorder.getVolume_remain();
    }

    private void save_tradecombined_buffers() throws DBException {
        toutput = sqlwriter.Commit2DB(transactionqueue);
        if(toutput.getHaserror())
            marketstatus.addMessage(toutput.getErrormessage());
        toutput = sqlwriter.Commit2DB(transactionqueue);
        if(toutput.getHaserror())
            marketstatus.addMessage(toutput.getErrormessage());
    }

    private void create_new_tradecombination_sell() {
        amount = Math.min(buyorderasked, sellorderasked);
        bltradecombined_sell.addStatement(transactionqueue, build_tradecombined_sell_statement().toString());
        insertcounter++;
        buyorderasked -= amount;
        sellorderasked -= amount;
        if(buyorderasked==0 && buyordersI.hasNext())
            get_next_buyorder();
        if(sellorderasked==0 && sellordersI.hasNext())
            get_next_sellorder();
        hasprofit = buyorder.getPrice()*perc_net>sellorder.getPrice();
        ordersavailable = buyorderasked>0 && sellorderasked>0;
    }

    private void get_next_sellorder() {
        sellorder = sellordersI.next();
        sellorderasked += sellorder.getVolume_remain();
    }

    private void get_next_buyorder() {
        buyorder = buyordersI.next();
        buyorderasked += buyorder.getVolume_remain();
    }

    private StringBuilder build_tradecombined_statement(View_trade_systemsevetype view_trade_systemsevetype) {
        StringBuilder sql = new StringBuilder("insert into tradecombined values (");
        sql.append(sellsystemPK.getId()).append(",");
        sql.append(buysystemPK.getId()).append(",");
        sql.append(evetypePK.getId()).append(",");
        sql.append(view_trade_systemsevetype.getJumps()).append(",");
        sql.append(view_trade_systemsevetype.getJumpslowsec()).append(",");
        sql.append(view_trade_systemsevetype.getJumpsnullsec()).append(")");
        return sql;
    }
    
    private StringBuilder build_tradecombined_sell_statement() {
        StringBuilder sql = new StringBuilder("insert into tradecombined_sell values (");
        sql.append(sellsystemPK.getId()).append(",");
        sql.append(buysystemPK.getId()).append(",");
        sql.append(evetypePK.getId()).append(",");
        sql.append(buyorder.getPrimaryKey().getId()).append(",");
        sql.append(sellorder.getPrimaryKey().getId()).append(",");
        sql.append(amount).append(",");
        sql.append(buyorder.getPrice() * amount).append(",");
        sql.append(sellorder.getPrice() * amount).append(",");
        sql.append((buyorder.getPrice() * perc_net - sellorder.getPrice()) * amount).append(")");
        return sql;
    }

    private long stocksystemid;
    private SystemPK stocksystemPK;
    private Iterator<Stock> stockI;
    private Iterator<Orders> ordersI;
    private StocktradePK stocktradePK;
    private Stocktrade stocktrade;
    private long stockamount;
    private long tradeamount;
    
    private void processStock() throws DBException, DataException {
        marketstatus.addMessage("Construct stocktrade table");        
        delete_all_stocktrade();
        load_stocktrade_candidates();
        while(keeprunning && stockI.hasNext())
            process_stock_line(stockI.next());
        save_stocktrade_buffer();
    }

    private void load_stocktrade_candidates() throws DBException {
        stocksystemPK = new SystemPK(stocksystemid);
        stockI = blstock.getStock4user(username).iterator();
    }

    private void delete_all_stocktrade() throws DataException, DBException {
        blstocktrade.deletestocktrade(transactionqueue, username);
        sqlwriter.Commit2DB(transactionqueue);
    }

    private void process_stock_line(Stock stock) throws DataException, DBException {
        stockamount = stock.getAmount();
        ordersI = blorders.load_buyorders4evetype(stocksystemPK, stock.getPrimaryKey().getEvetypePK()).iterator();
        while(ordersI.hasNext() && stockamount>0)
            process_order_for_stocktrade(stock, ordersI.next());
    }

    private void process_order_for_stocktrade(Stock stock, Orders order) throws DBException, DataException {
        tradeamount = Math.min(order.getVolume_remain(), stockamount);
        if(tradeamount>=order.getMin_volume())
            create_new_stocktrade(stock, order);
    }

    private void create_new_stocktrade(Stock stock, Orders order) throws DBException, DataException {
        stocktradePK = new StocktradePK();
        stocktradePK.setStockPK(stock.getPrimaryKey());
        stocktradePK.setOrderid(order.getPrimaryKey().getId());
        stocktrade = new Stocktrade(stocktradePK);
        stocktrade.setSellamount(tradeamount);
        blstocktrade.insertStocktrade(transactionqueue, stocktrade);
        stockamount -= tradeamount;
    }

    private void save_stocktrade_buffer() throws DBException {
        toutput = sqlwriter.Commit2DB(transactionqueue);
        if(toutput.getHaserror())
            marketstatus.addMessage(toutput.getErrormessage());
    }
}
