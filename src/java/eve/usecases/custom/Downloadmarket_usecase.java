package eve.usecases.custom;

import db.SQLTwriter;
import db.SQLreader;
import eve.BusinessObject.service.MarketService;
import eve.data.Staticdata;

/**
 * @author Franky Laseure
 */
public class Downloadmarket_usecase {

    private SQLreader sqlreader = new SQLreader();
    private SQLTwriter sqlwriter = new SQLTwriter();
    private Thread marketservice_thread = null;
    private MarketService marketservice = null;
    private boolean keeprunning = false;
    private int count = 0;

    public Downloadmarket_usecase() {
        marketservice_thread = Staticdata.getMarketservice_thread();
        marketservice = Staticdata.getMarketservice();
    }
    
    public void processRequest(boolean loggedin, String username, boolean start_requested, boolean stop_requested) {
        boolean ismarketservice_running = isServiceRunning();
        boolean ismarketservice_done = ismarketservice_running && getStatus().isDone();
        boolean isswaggerdownloader_not_running = !isDownloaderRunning();
        if(loggedin && start_requested)
            start_reset_marketservice(username);
        if(loggedin && stop_requested && ismarketservice_running)
            stop_marketservice();
    }

    public boolean isServiceRunning() {
        return marketservice!=null;
    }
    
    public MarketService.MarketStatus getStatus() {
        return marketservice.getStatus();
    }
    
    private boolean isDownloaderRunning() {
        return marketservice_thread!=null;
    }
    
    private void start_reset_marketservice(String username) {
        keeprunning = true;
        boolean ismarketservice_running = marketservice!=null;
        boolean ismarketservice_done = ismarketservice_running && marketservice.getStatus().isDone();
        if(ismarketservice_done)
            resetMarket();
        boolean isswaggerdownloader_not_running = marketservice_thread==null;
        if(isswaggerdownloader_not_running)
            start_marketservice(username);
    }

    private void start_marketservice(String username) {
        marketservice = new MarketService(sqlreader, sqlwriter, username);
        marketservice_thread = new Thread(marketservice);
        marketservice_thread.setPriority(Thread.MIN_PRIORITY);
        marketservice_thread.start();
        storeStaticdata();
    }

    private void stop_marketservice() {
        marketservice.stoprunning();
        keeprunning = false;
        marketservice_thread.interrupt();
        marketservice_thread = null;
        marketservice = null;
        storeStaticdata();
    }

    public void resetMarket() {
        marketservice_thread = null;
        marketservice = null;
        storeStaticdata();
    }

    private void storeStaticdata() {
        Staticdata.setMarketservice(marketservice);
        Staticdata.setMarketservice_thread(marketservice_thread);
    }
}
