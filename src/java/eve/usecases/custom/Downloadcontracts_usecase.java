package eve.usecases.custom;

import db.SQLTwriter;
import db.SQLreader;
import eve.BusinessObject.Logic.BLfrontendpage;
import eve.BusinessObject.Logic.BLfrontendpage_auth;
import eve.BusinessObject.service.ContractService;
import eve.data.Staticdata;

/**
 * @author Franky Laseure
 */
public class Downloadcontracts_usecase {

    private SQLreader sqlreader = new SQLreader();
    private SQLTwriter sqlwriter = new SQLTwriter();
    private static Thread contractservice_thread = null;
    private static ContractService contractservice = null;
    private static int count = 0;

    public Downloadcontracts_usecase() {
        contractservice_thread = Staticdata.getContractservice_thread();
        contractservice = Staticdata.getContractservice();
    }
    
    public void processRequest(boolean loggedin, String username, boolean start_requested, boolean stop_requested) {
        boolean iscontractservice_running = isServiceRunning();
        boolean iscontractservice_done = iscontractservice_running && getStatus().isDone();
        boolean isswaggerdownloader_not_running = !isDownloaderRunning();
        if(loggedin && start_requested)
            start_reset_contractservice(username);
        if(loggedin && stop_requested && iscontractservice_running)
            stop_contractservice();
    }

    public boolean isServiceRunning() {
        return contractservice!=null;
    }
    
    public ContractService.ContractStatus getStatus() {
        return contractservice.getStatus();
    }
    
    private boolean isDownloaderRunning() {
        return contractservice_thread!=null;
    }

    private void stop_contractservice() {
        contractservice.stoprunning();
        contractservice_thread.interrupt();
        contractservice_thread = null;
        contractservice = null;
        storeStaticdata();
    }

    private void start_reset_contractservice(String username) {
        boolean iscontractservice_running = contractservice!=null;
        boolean iscontractservice_done = iscontractservice_running && contractservice.getStatus().isDone();
        if(iscontractservice_done)
            resetContracts();
        boolean isswaggerdownloader_not_running = contractservice_thread==null;
        if(isswaggerdownloader_not_running)
            start_contractservice(username);
    }

    private void start_contractservice(String username) {
        contractservice = new ContractService(username, sqlreader, sqlwriter);
        contractservice_thread = new Thread(contractservice);
        contractservice_thread.setPriority(Thread.MIN_PRIORITY);
        contractservice_thread.start();
        storeStaticdata();
    }

    public void resetContracts() {
        contractservice_thread = null;
        contractservice = null;
        storeStaticdata();
    }

    private void storeStaticdata() {
        Staticdata.setContractservice_thread(contractservice_thread);
        Staticdata.setContractservice(contractservice);
    }
}
