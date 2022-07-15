package eve.usecases.custom;

import db.SQLTwriter;
import db.SQLreader;
import eve.BusinessObject.service.Markethistory;
import eve.data.Staticdata;

/**
 * @author Franky Laseure
 */
public class Downloadmarkethistory_usecase {

    private Thread historyservice_thread = null;
    private Markethistory historyservice = null;
    private boolean keeprunning = false;
    private int count = 0;

    public Downloadmarkethistory_usecase() {
        historyservice_thread = Staticdata.getHistoryservice_thread();
        historyservice = Staticdata.getHistoryservice();
    }
    
    public void processRequest(boolean isadmin, boolean start_requested, boolean stop_requested) {
        boolean ishistoryservice_running = isServiceRunning();
        boolean ishistoryservice_done = ishistoryservice_running && getStatus().isDone();
        if(isadmin && start_requested)
            start_reset_history_service(ishistoryservice_done);
        if(isadmin && stop_requested && ishistoryservice_running)
            stop_historyservice();
    }
    
    public boolean isServiceRunning() {
        return historyservice!=null;
    }
    
    public Markethistory.MarkethistoryStatus getStatus() {
        return historyservice.getStatus();
    }
    
    private boolean isDownloaderRunning() {
        return historyservice_thread!=null;
    }

    private void stop_historyservice() {
        historyservice.stoprunning();
        keeprunning = false;
        historyservice_thread.interrupt();
        historyservice_thread = null;
        historyservice = null;
        storeStaticdata();
    }

    private void start_reset_history_service(boolean ishistoryservice_done) {
        keeprunning = true;
        if(ishistoryservice_done) {
            resetHistory();
        }
        if(historyservice_thread==null) {
            SQLreader sqlreader = new SQLreader();
            SQLTwriter sqlwriter = new SQLTwriter();
            historyservice = new Markethistory(sqlreader, sqlwriter);
            historyservice_thread = new Thread(historyservice);
            historyservice_thread.setPriority(Thread.MIN_PRIORITY);
            historyservice_thread.start();
            storeStaticdata();
        }
    }

    public void resetHistory() {
        historyservice_thread = null;
        historyservice = null;
        storeStaticdata();
    }

    private void storeStaticdata() {
        Staticdata.setHistoryservice(historyservice);
        Staticdata.setHistoryservice_thread(historyservice_thread);
    }
}
