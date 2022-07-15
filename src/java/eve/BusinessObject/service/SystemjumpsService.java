package eve.BusinessObject.service;

import db.SQLTwriter;
import db.SQLToutput;
import db.SQLTqueue;
import db.SQLreader;
import eve.BusinessObject.Logic.BLstargate;
import eve.BusinessObject.Logic.BLsystem;
import eve.BusinessObject.Logic.BLsystemjumps;
import eve.logicentity.Stargate;
import eve.usecases.custom.Loadroute_parameters;
import general.exception.DBException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Franky Laseure
 */
public class SystemjumpsService implements Runnable {
    
    private static RouteService routeservice = null;
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
    
    public SystemjumpsService(SQLreader sqlreader, SQLTwriter sqlwriter) {
        this.sqlreader = sqlreader;
        this.sqlwriter = sqlwriter;
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

    private SQLreader sqlreader;
    private SQLTwriter sqlwriter;
    private SQLTqueue transactionqueue;
    private BLsystem blsystem;
    private BLstargate blstargate;
    private BLsystemjumps blsystemjumps;
    private ArrayList<eve.logicentity.System> systems;
    private SQLToutput toutput;
    private int startcounter;
    private int endcounter;
    private int insertcounter;
    private int jumps;
    private int jumpssafe;
    private long startid, endid;
    private ArrayList<Long> dummy;
    
    private void calculate() {
        try {
            transactionqueue = new SQLTqueue();
            initialize();
            Iterator<eve.logicentity.System> systemsstartI = systems.iterator();
            while(systemsstartI.hasNext() && keeprunning)
                calculate_jumps_from_startsystem_to_each_system(systemsstartI.next());
            if(keeprunning)
                commit_calculationresult_to_database();
        }
        catch(DBException e) {
            systemjumpsstatus.addMessage(e.getMessage());
        }
    }

    private void commit_calculationresult_to_database() throws DBException {
        toutput = sqlwriter.Commit2DB(transactionqueue);
        if(toutput.getHaserror())
            systemjumpsstatus.addMessage("Jump calculator " + toutput.getErrormessage());
        insertcounter = 0;
    }

    private void calculate_jumps_from_startsystem_to_each_system(eve.logicentity.System start) throws DBException {
        startid = start.getPrimaryKey().getId();
        endcounter = 0;
        Iterator<eve.logicentity.System> systemsendI = systems.iterator();
        while(systemsendI.hasNext() && keeprunning && endcounter!=startcounter)
            calculate_jumps_between_start_end_system(systemsendI.next());
        startcounter++;
    }

    private void calculate_jumps_between_start_end_system(eve.logicentity.System end) throws DBException {
        endid = end.getPrimaryKey().getId();
        Loadroute_parameters routeparameters = new Loadroute_parameters();
        routeparameters.setOrigin(startid);
        routeparameters.setDestination(endid);
        routeparameters.setAvoidsystems(dummy);
        routeparameters.setRoutesegmentlist(dummy);
        routeparameters.setSecure(false);
        Systemdata route = routeservice.getRoute_Systemdata(routeparameters);
        routeparameters.setSecure(true);
        Systemdata routesafe = routeservice.getRoute_Systemdata(routeparameters);
        blsystemjumps.addStatement(transactionqueue, composeSQLupdate(startid, endid, route, routesafe));
        blsystemjumps.addStatement(transactionqueue, composeSQLupdate(endid, startid, route, routesafe));
        systemjumpsstatus.incCombinations();
        systemjumpsstatus.incCombinations();
        insertcounter++;
        if(insertcounter==200)
            commit_calculationresult_to_database();
        endcounter++;
    }

    private void initialize() throws DBException {
        blsystem = new BLsystem(sqlreader);
        blsystem.setAuthenticated(true);
        blstargate = new BLstargate(sqlreader);
        blstargate.setAuthenticated(true);
        blsystemjumps = new BLsystemjumps(sqlreader);
        blsystemjumps.setAuthenticated(true);
        if(routeservice==null)
            loadRouteservice();
        long systemcount = (new BLsystemjumps(sqlreader)).count();
        systems = blsystem.getSystemLowHisec();
        systemjumpsstatus.addMessage("Calculate all combinations of " + systems.size() + " systems");
        //jump to same systems don't need to be recalculated
        systemjumpsstatus.totalcombinations = systemcount + systems.size();
        startcounter = 0;
        endcounter = 0;
        insertcounter = 0;
        jumps = 0;
        jumpssafe = 0;
        dummy = new ArrayList<>();
    }

    private void loadRouteservice() throws DBException {
        ArrayList<eve.logicentity.System> systems = blsystem.getSystems();
        ArrayList<Stargate> stargates = blstargate.getStargates();
        routeservice = new RouteService(systems, stargates);
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
