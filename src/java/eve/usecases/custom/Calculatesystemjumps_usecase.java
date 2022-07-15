package eve.usecases.custom;

import db.SQLTwriter;
import db.SQLreader;
import eve.BusinessObject.service.SystemjumpsService;
import eve.data.Staticdata;

/**
 * @author Franky Laseure
 */
public class Calculatesystemjumps_usecase {

    private Thread systemjumpsservice_thread;
    private SystemjumpsService systemjumpsservice;
    private SQLreader sqlreader = new SQLreader();
    private SQLTwriter sqlwriter = new SQLTwriter();
    
    public Calculatesystemjumps_usecase() {
        systemjumpsservice_thread = Staticdata.getSystemjumpsservice_thread();
        systemjumpsservice = Staticdata.getSystemjumpsservice();
    }
    
    public void processRequest(boolean isadmin, boolean start_requested, boolean stop_requested) {
        boolean issystemjumpservice_running = isServiceRunning();
        boolean issystemjumpservice_done = issystemjumpservice_running && Staticdata.getSystemjumpsservice().getStatus().isDone();
        boolean isjumpcalculator_not_running = !isCalculatorRunning();
        if(isadmin && start_requested)
            start_reset_jumpservice(issystemjumpservice_done, isjumpcalculator_not_running);
        if(isadmin && stop_requested && issystemjumpservice_running)
            stop_jumpservice();
    }

    public boolean isServiceRunning() {
        return systemjumpsservice!=null;
    }
    
    public SystemjumpsService.SystemjumpsStatus getStatus() {
        return systemjumpsservice.getStatus();
    }
    
    private boolean isCalculatorRunning() {
        return systemjumpsservice_thread!=null;
    }

    private void start_reset_jumpservice(boolean issystemjumpservice_done, boolean isjumpcalculator_not_running) {
        if(issystemjumpservice_done)
            resetSystemjumpsservice();
        if(isjumpcalculator_not_running)
            start_jumpservice();
    }

    private void stop_jumpservice() {
        systemjumpsservice.stoprunning();
        systemjumpsservice_thread.interrupt();
        resetSystemjumpsservice();
    }

    private void start_jumpservice() {
        SystemjumpsService systemjumpsservice = new SystemjumpsService(sqlreader, sqlwriter);
        systemjumpsservice_thread = new Thread(systemjumpsservice);
        systemjumpsservice_thread.setPriority(Thread.MIN_PRIORITY);
        systemjumpsservice_thread.start();
        storeStaticdata();
    }

    public void resetSystemjumpsservice() {
        systemjumpsservice = null;
        systemjumpsservice_thread = null;
        storeStaticdata();
    }
    
    private void storeStaticdata() {
        Staticdata.setSystemjumpsservice(systemjumpsservice);
        Staticdata.setSystemjumpsservice_thread(systemjumpsservice_thread);
    }
}
