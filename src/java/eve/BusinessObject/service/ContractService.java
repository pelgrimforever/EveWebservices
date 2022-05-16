package eve.BusinessObject.service;

import eve.BusinessObject.Logic.BLcontract;
import eve.BusinessObject.Logic.BLcontractitem;
import eve.BusinessObject.Logic.BLevetype;
import eve.BusinessObject.Logic.BLregion;
import eve.BusinessObject.Logic.BLsyssettings;
import eve.BusinessObject.Logic.BLsystem;
import eve.interfaces.logicentity.ISyssettings;
import eve.logicentity.Contract;
import eve.logicentity.Contractitem;
import eve.logicentity.Region;
import eve.logicentity.Syssettings;
import general.exception.CustomException;
import general.exception.DBException;
import general.exception.DataException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * @author Franky Laseure
 */
public class ContractService implements Runnable {
    
    private ContractStatus contractstatus;
    
    protected Marketdata data;
    protected ArrayList<ContractRegionDownloader> downloaders;
    protected ArrayList<Thread> marketthreads;

    public void stoprunning() {
        this.AskStopthreads();
    }
    
    public ContractStatus getStatus() {
        return contractstatus;
    }

    public class ContractStatus {

        private HashMap<Long, RegionStatus> regions = new HashMap<>();
        private ArrayList<String> messages = new ArrayList<>();
        private boolean done = false;
        
        public ContractStatus(ArrayList<Region> regionsarray) throws DBException {
            for(Region region: regionsarray)
                regions.put(region.getPrimaryKey().getId(), new RegionStatus(region));
        }
        
        public void updateStatus(long regionid, int page, long contracts) {
            RegionStatus regionstatus = regions.get(regionid);
            regionstatus.setPage(page);
            regionstatus.setContracts(contracts);
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
        private long contracts = 0;
        private int totalpages = 1;
        private boolean done = false;
        
        public RegionStatus(Region region) {
            this.name = region.getName();
            this.totalpages = region.getContractpages();
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
        
        public void setContracts(long contracts) {
            this.contracts = contracts;
        }

        public long getContracts() {
            return this.contracts;
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
    
    public ContractService(String username) {
        try {
            BLregion blregion = new BLregion();
            blregion.setAuthenticated(true);
            ArrayList<Region> regions = blregion.getAll_Contractpages();
            contractstatus = new ContractStatus(regions);
            data = new Marketdata(regions);
        }
        catch(DBException e) {
            System.out.println(e.getMessage());
        }
    }
    
    protected boolean locktoONEprocessor = false;
    private static int processors = Runtime.getRuntime().availableProcessors(); //max number of available processors
    private static int maxprocessors = 4; //max number of available processors
    
    public static int getProcessors() {
        return processors;
    }
    
    public int processorsasked = processors;
    
    private static int processorsactive = 0;
    public static int getProcessorsactive() {
        return processorsactive;
    }
    protected static void setProcessorsactive(int value) {
        processorsactive = value;
    }

    private BLcontract blcontract;
    
    @Override
    public void run() {
        blcontract = new BLcontract();
        blcontract.setAuthenticated(true);        
        deactivate_contracts_in_database();
        
        contractstatus.addMessage("Download contracts");
        long start = System.currentTimeMillis();
        download_contracts();
        try {
            contractstatus.addMessage("Cleanup Deactivated contracts");
            blcontract.deletedeactivatedcontracts();
        }
        catch(DBException e) {
            contractstatus.addMessage(e.getMessage());
        }
        long end = System.currentTimeMillis();
        contractstatus.addMessage("Download time Swagger -> contracts " + ((end - start)/1000) + "sec.");
        contractstatus.setDone();
    }

    private void download_contracts() {
        downloaders = new ArrayList<>();
        marketthreads = new ArrayList<>();
        ContractRegionDownloader downloader;
        Thread marketthread;
        int p;
        try {
            if(processorsasked>maxprocessors) processors = maxprocessors;
            for(p=0; p<processorsasked && p<processors; p++)
                start_contractregiondownloaderthread(p);
            setProcessorsactive(processors);
            for(p=0; p<processorsasked && p<processors; p++)
                join_started_threads(p);
        }
        catch(InterruptedException e) {
        }
    }

    private void join_started_threads(int p) throws InterruptedException {
        Thread marketthread;
        marketthread = marketthreads.get(p);
        marketthread.join();
    }

    private void start_contractregiondownloaderthread(int p) {
        ContractRegionDownloader downloader;
        Thread marketthread;
        downloader = new ContractRegionDownloader(data, contractstatus, p);
        downloaders.add(downloader);
        marketthread = new Thread(downloader);
        marketthreads.add(marketthread);
        marketthread.setPriority(Thread.MIN_PRIORITY);
        marketthread.start();
    }

    private void deactivate_contracts_in_database() {
        try {
            contractstatus.addMessage("Deactivate contracts");
            if(blcontract.count()>0)
                blcontract.deactivatecontracts();
        }
        catch(DBException e) {
            contractstatus.addMessage(e.getMessage());
        }
    }

    /**
     * Shut down all downloads
     */
    public void AskStopthreads() {
        for(int i=0, l=downloaders.size(); i<l; i++)
            downloaders.get(i).stoprunning();
        for(int i=0, l=marketthreads.size(); i<l; i++)
            marketthreads.get(i).interrupt();
        downloaders = new ArrayList<>();
        marketthreads = new ArrayList<>();
    }
}
