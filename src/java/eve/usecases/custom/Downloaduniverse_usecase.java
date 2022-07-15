package eve.usecases.custom;

import db.SQLTwriter;
import db.SQLreader;
import eve.BusinessObject.service.UniverseService;
import eve.data.Staticdata;

/**
 * @author Franky Laseure
 */
public class Downloaduniverse_usecase {

    private Thread universeservice_thread = null;
    private UniverseService universeservice = null;
    private boolean keeprunning = false;
    private int count = 0;
    
    public Downloaduniverse_usecase() {
        universeservice_thread = Staticdata.getUniverseservice_thread();
        universeservice = Staticdata.getUniverseservice();
    }
    
    public void processRequest(boolean isadmin, boolean start_requested, boolean stop_requested) {
        boolean isuniverseservice_running = isServiceRunning();
        boolean isuniverseservice_done = isuniverseservice_running && getStatus().isDone();
        boolean isuniversedownloader_not_running = !isDownloaderRunning();
        if(isadmin && start_requested)
            start_reset_universeservice();
        if(isadmin && stop_requested && isuniverseservice_running)
            stop_universeservice();
    }
    
    public boolean isServiceRunning() {
        return universeservice!=null;
    }
    
    public UniverseService.UniverseStatus getStatus() {
        return universeservice.getStatus();
    }
    
    private boolean isDownloaderRunning() {
        return universeservice_thread!=null;
    }
    
    private void start_reset_universeservice() {
        keeprunning = true;
        if(universeservice!=null && getStatus().isDone())
            resetUniverse();
        if(universeservice_thread==null)
            start_universeservice();
    }
    
    public void resetUniverse() {
        universeservice_thread = null;
        universeservice = null;
        storeStaticdata();
    }
    
    private void start_universeservice() {
        SQLreader sqlreader = new SQLreader();
        SQLTwriter sqlwriter = new SQLTwriter();
        universeservice = new UniverseService(sqlreader, sqlwriter);
        universeservice_thread = new Thread(universeservice);
        universeservice_thread.setPriority(Thread.MIN_PRIORITY);
        universeservice_thread.start();
        storeStaticdata();
    }

    private void stop_universeservice() {
        universeservice.stoprunning();
        keeprunning = false;
        universeservice_thread.interrupt();
        universeservice_thread = null;
        universeservice = null;
        storeStaticdata();
    }
    
    private void storeStaticdata() {
        Staticdata.setUniverseservice(universeservice);
        Staticdata.setUniverseservice_thread(universeservice_thread);
    }
}
