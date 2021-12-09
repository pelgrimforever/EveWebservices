/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eve.BusinessObject.service;

import db.TransactionOutput;
import eve.BusinessObject.Logic.BLsystem;
import eve.BusinessObject.Logic.BLsystemjumps;
import eve.conversion.entity.EMsystemjumps;
import eve.searchentity.Systemsearch;
import general.exception.DBException;
import java.util.ArrayList;

/**
 * Market loader service
 * @author pelgrim
 */
public class SystemjumpsService implements Runnable {
    
    private SystemjumpsStatus systemjumpsstatus;
    private boolean keeprunning = true;
    
    public void stoprunning() {
        this.keeprunning = false;
    }
    
    public SystemjumpsStatus getStatus() {
        return systemjumpsstatus;
    }
    
    public class SystemjumpsStatus {
        private long combinations = 0;
        private long totalcombinations = 1;
        
        private ArrayList<String> messages = new ArrayList<>();
        private boolean done = false;
        
        public SystemjumpsStatus() {
            try {
                totalcombinations = (new BLsystemjumps()).count();
            }
            catch(DBException e) {
                
            }
        }
        
        public void setDone() {
            this.done = true;
        }

        public long getCombinations() {
            return combinations;
        }

        public void incCombinations() {
            this.combinations++;
        }

        public long getTotalcombinations() {
            return totalcombinations;
        }

        public void addMessage(String message) {
            messages.add(message);
        }

        public ArrayList getMessages() {
            return this.messages;
        }

        public boolean isDone() {
            return this.done;
        }
    }
    
    public SystemjumpsService() {
        systemjumpsstatus = new SystemjumpsStatus();
    }
    
    @Override
    public void run() {
        long start = System.currentTimeMillis();

        calculate();
        
        long end = System.currentTimeMillis();
        systemjumpsstatus.addMessage("Calculation time " + ((end - start)/1000) + "sec.");
        systemjumpsstatus.setDone();
    }

    private void calculate() {
        try {
            BLsystem blsystem = new BLsystem();
            BLsystemjumps blsystemjumps = new BLsystemjumps();
            RouteService routeservice = new RouteService();
            ArrayList<eve.logicentity.System> systems = blsystem.getSystemLowHisec();
            systemjumpsstatus.addMessage("Calculate all combinations of " + systems.size() + " systems");
            //jump to same systems don't need to be recalculated
            systemjumpsstatus.combinations += systems.size();
            TransactionOutput toutput;
            int startcounter = 0;
            int endcounter = 0;
            int insertcounter = 0;
            int jumps = 0;
            int jumpssafe = 0;
            long startid, endid;
            ArrayList<Long> dummy = new ArrayList<>();
            for(eve.logicentity.System start: systems) {
                startid = start.getPrimaryKey().getId();
                endcounter = 0;
                if(!keeprunning) break;
                for(eve.logicentity.System end: systems) {
                    if(endcounter==startcounter) {
                        break;
                    }
                    endid = end.getPrimaryKey().getId();
                    Systemdata route = routeservice.getRoute(startid, endid, dummy, dummy, false);
                    Systemdata routesafe = routeservice.getRoute(startid, endid, dummy, dummy, true);
                    blsystemjumps.addStatement(composeSQLupdate(startid, endid, route, routesafe));
                    blsystemjumps.addStatement(composeSQLupdate(endid, startid, route, routesafe));
                    systemjumpsstatus.incCombinations();
                    systemjumpsstatus.incCombinations();
                    insertcounter++;
                    if(insertcounter==200) {
                        insertcounter = 0;
                        if(!keeprunning) break;
                        toutput = blsystemjumps.Commit2DB();
                        if(toutput.getHaserror()) {
                            systemjumpsstatus.addMessage("Jump calculator " + toutput.getErrormessage());
                        }
                    }
                    endcounter++;
                }
                startcounter++;
            }
            if(keeprunning) {
                toutput = blsystemjumps.Commit2DB();
                if(toutput.getHaserror()) {
                    systemjumpsstatus.addMessage("Jump calculator " + toutput.getErrormessage());
                }
            }
        }
        catch(DBException e) {
            systemjumpsstatus.addMessage(e.getMessage());
        }
    }
    
    private String composeSQLupdate(long startid, long endid, Systemdata route, Systemdata routesafe) {
        StringBuilder sqlb = new StringBuilder();
        sqlb.append("update systemjumps set ");
        sqlb.append("jumps = ").append(route.getRoute().size()).append(",");
        sqlb.append("jumpslowsec = ").append(route.getLowsecjumps()).append(",");
        sqlb.append("jumpsnullsec = ").append(route.getNullsecjumps()).append(",");
        sqlb.append("jumpssafe = ").append(routesafe.getRoute().size()).append(",");
        sqlb.append("jumpssafelowsec = ").append(routesafe.getLowsecjumps()).append(",");
        sqlb.append("jumpssafenullsec = ").append(routesafe.getNullsecjumps());
        sqlb.append(" where system_start = ").append(startid).append(" and");
        sqlb.append(" system_end = ").append(endid);
        return sqlb.toString();
    }

}
