/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 * Market loader service
 * @author pelgrim
 */
public class ContractService implements Runnable {
    
    private String username;
    private ContractStatus contractstatus;
    private boolean keeprunning = true;
    private int maxtransactions = 50;
    
    protected Marketdata data;
    protected ArrayList<ContractRegionDownloader> downloaders;
    protected ArrayList<Thread> marketthreads;

    public void stoprunning() {
        this.keeprunning = false;
        this.AskStopthreads();
    }
    
    public ContractStatus getStatus() {
        return contractstatus;
    }
    
    public class ContractStatus {

        private HashMap<Long, RegionStatus> regions = new HashMap<>();
        private ArrayList<String> messages = new ArrayList<>();
        private boolean done = false;
        
        public ContractStatus() throws DBException {
            BLregion blregion = new BLregion();
            Iterator<Region> regionI = blregion.getAll().iterator();
            Region region;
            while(regionI.hasNext()) {
                region = regionI.next();
                regions.put(region.getPrimaryKey().getId(), new RegionStatus(region));
            }
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
        this.username = username;
        try {
            contractstatus = new ContractStatus();
            BLregion blregion = new BLregion();
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
            BLcontract blcontract = new BLcontract();
            //more contracts to order_hist
            contractstatus.addMessage("Deactivate contracts");
            if(blcontract.count()>0) {
                blcontract.deactivatecontracts();
            }
        }
        catch(DBException e) {
            contractstatus.addMessage(e.getMessage());
        }
        contractstatus.addMessage("Download contracts");

        downloaders = new ArrayList<>();
        marketthreads = new ArrayList<>();
        ContractRegionDownloader downloader;
        Thread marketthread;
        int p;
        //start all threads
        long start = System.currentTimeMillis();
        try {
            if(processorsasked>maxprocessors) processors = maxprocessors;
            for(p=0; p<processorsasked && p<processors; p++) {
                downloader = new ContractRegionDownloader(data, contractstatus, p);
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
        try {
            BLcontract blcontract = new BLcontract();
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
}
