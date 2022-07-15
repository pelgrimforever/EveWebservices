/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eve.BusinessObject.service;

import db.SQLTwriter;
import db.SQLTqueue;
import db.SQLreader;
import eve.BusinessObject.Logic.BLallnodes_stargate;
import eve.BusinessObject.Logic.BLallnodes_system;
import eve.BusinessObject.Logic.BLsystem;
import eve.entity.pk.SystemPK;
import eve.logicentity.Allnodes_system;
import eve.logicentity.Allnodes_stargate;
import general.exception.DBException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author pelgrim
 */
public class AllnodesService {
    
    SQLreader sqlreader;
    SQLTwriter sqlwriter;
    HashMap<Long, Allnodesdata> systemhash = new HashMap<>();
    
    public AllnodesService() {
        try {
            sqlreader = new SQLreader();
            sqlwriter = new SQLTwriter();
            BLallnodes_system blsystem = new BLallnodes_system(sqlreader);
            ArrayList<Allnodes_system> systems = blsystem.getAllnodes_systems();
            for(Allnodes_system system: systems) {
                systemhash.put(system.getPrimaryKey().getId(), new Allnodesdata(system));
            }
            BLallnodes_stargate blstargate = new BLallnodes_stargate(sqlreader);
            ArrayList<Allnodes_stargate> stargates = blstargate.getAllnodes_stargates();
            Allnodesdata systemdata;
            for(Allnodes_stargate stargate: stargates) {
                systemdata = systemhash.get(stargate.getSystem());
                systemdata.addConnection(systemhash.get(stargate.getTo_system()));
            }
        }
        catch(DBException e) {
        }
    }

    public Allnodes_system getSystem(long systemid) {
        return systemhash.get(systemid).getSystem();
    }

    public void performAlgorithmDB() {
        try {
            SQLTqueue transactionqueue = new SQLTqueue();
            BLallnodes_system blsystem = new BLallnodes_system(sqlreader);
            BLallnodes_stargate blstargate = new BLallnodes_stargate(blsystem);
            //reload all data
            blsystem.reload(transactionqueue);
            blstargate.reload(transactionqueue);
            sqlwriter.Commit2DB(transactionqueue);
            //find dead ends until none found
            long deadends = 0;
            long previousdeadends = 0;
            do {
                blsystem.markdeadends(transactionqueue);
                blstargate.markdeadends(transactionqueue);
                sqlwriter.Commit2DB(transactionqueue);
                previousdeadends = deadends;
                deadends = blsystem.getDeadendscount();
            } while(previousdeadends<deadends);
            
        }
        catch(DBException e) {
            
        }        
    }
    
    public void performAlgorithm() {
        boolean debug = true;
        //find dead ends until none found
        int deadendfound = 0;
        do {
            deadendfound = 0;
            for(Allnodesdata system: systemhash.values()) {
                if(system.getId()==30003565) {
                    boolean stop = true;
                }
                if(!system.isDeadend() && system.getConnections().size()==1) {
                    deadendfound++;
                    system.setDeadend();
                }
            }
        } while(deadendfound>0);
        //find nodes in a circle of all systems connected to deadends (but not part of a deadend)
        int circleid = 0;
        boolean circlefound = false;
        ArrayList<Allnodesdata> activesystems;
        ArrayList<Allnodesdata> connections;
        ArrayList<Long> circleroute, circleroutetemp;
        int step;
        Allnodesdata circlemiddle1, circlemiddle2, previouscirclenode, circlenode;
        
//debug
if(debug) {
    try {
        eve.logicentity.System deadendsystem;
        BLsystem blsystem = new BLsystem(sqlreader);
        for(Allnodesdata system: systemhash.values()) {
            if(system.isConnectedToDeadend()) {
                deadendsystem = blsystem.getSystem(new SystemPK(system.getId()));
                System.out.println(deadendsystem.getPrimaryKey().getId() + " " + deadendsystem.getName());
                for(Allnodesdata deadend: system.getDeadendonnections()) {
                    deadendsystem = blsystem.getSystem(new SystemPK(deadend.getId()));
                    System.out.println("  " + deadendsystem.getPrimaryKey().getId() + " " + deadendsystem.getName());
                }
            }
        }
    }
    catch(DBException e) {
    }
}

        for(Allnodesdata system: systemhash.values()) {
            if(system.isConnectedToDeadend()) {
                //reset cicle parameters
                for(Allnodesdata resetsystem: systemhash.values()) {
                    resetsystem.reset();
                }
                activesystems = new ArrayList<>();
                activesystems.add(system);
                system.setStartingpoint();
                connections = new ArrayList<>();
                //create routes starting from system until a cicle is found or no more connections are found
                circlefound = false;
                circlemiddle1 = null;
                circlemiddle2 = null;
                step = 0;
                boolean connectionsfound = true;
                while(activesystems.size()>0 && connectionsfound && !circlefound) {
                    step++;
                    connectionsfound = false;
                    for(Allnodesdata activesystem: activesystems) {
                        for(Allnodesdata connection: activesystem.getConnections()) {
                            if(connection.isUsed()) {
                                //meeting a previous step = circle found (step==2 => jump back to previous system)
                                if(connection.getStep()+1==step) {
                                    //make sure a small circle is not found in the same direction
                                    if(connection.getFirstroutenode()!=activesystem.getFirstroutenode()) {
                                        circlefound = true;
                                        circlemiddle1 = activesystem;
                                        circlemiddle2 = connection;
                                        break;
                                    }
                                }
                            } else {
                                connection.setRoute(activesystem, step);
                                connections.add(connection);
                                connectionsfound = true;
                            }
                        }
                        if(circlefound) break;
                    }
                    activesystems.clear();
                    if(!circlefound) {
                        activesystems.addAll(connections);
                    }
                    connections.clear();
                    if(circlefound) {
                        circleid++;
                        circleroute = new ArrayList<>();
                        circleroute.add(system.getId());
                        circleroute.addAll(circlemiddle1.getRoute());
                        circleroutetemp = circlemiddle2.getRoute();
                        //second half of route, but not the starting point, is already included
                        for(int i=circleroutetemp.size()-1; i>-1; i--) {
                            circleroute.add(circleroutetemp.get(i));
                        }
                        int circlesize = circleroute.size();
                        previouscirclenode = systemhash.get(circleroute.get(circlesize-1));
                        previouscirclenode.setCircle(null, circleid);
                        for(int i=circlesize-2; i>-1 ; i--) {
                            circlenode = systemhash.get(circleroute.get(i));
                            circlenode.setCircle(previouscirclenode, circleid);
                            previouscirclenode = circlenode;
                        }
                    }
                }
//debug
if(debug) {
    System.out.println("CIRCLES");
    try {
        BLsystem blsystem = new BLsystem(sqlreader);
        eve.logicentity.System evesystem = blsystem.getSystem(new SystemPK(system.getId()));
        if(circlefound) {
            System.out.println(evesystem.getPrimaryKey().getId() + " " + evesystem.getName());
            Allnodesdata circlesystem = system.getNextCirclenode(circleid);
            while(circlesystem!=null) {
                evesystem = blsystem.getSystem(new SystemPK(circlesystem.getId()));
                System.out.println("  " + evesystem.getPrimaryKey().getId() + " " + evesystem.getName());
                circlesystem = circlesystem.getNextCirclenode(circleid);
            }
        } else {
            System.out.println("NO CIRCLE " + evesystem.getPrimaryKey().getId() + " " + evesystem.getName());
        }
    }
    catch(DBException e) {
    }
}
            }
        }
        
    }
    
    private Allnodesdata getRoute(long startpoint, long endpoint) {
        //initialize for new starting point
        for(Allnodesdata systeminit: systemhash.values()) {
            systeminit.reset();
        }
        //calculate routes
        ArrayList<Allnodesdata> checkedsystems;
        ArrayList<Allnodesdata> activesystems;
        ArrayList<Allnodesdata> connections;
        Allnodesdata newconnection;
        int counter = 0;
        Allnodesdata startsystem = systemhash.get(startpoint);
        Allnodesdata endsystem = systemhash.get(endpoint);
        startsystem.setStartingpoint();
        checkedsystems = new ArrayList<>();
        checkedsystems.add(startsystem);
        activesystems = new ArrayList<>();
        activesystems.add(startsystem);
        connections = new ArrayList<>();
        //isolated clusters of systems exists in eve
        //so we check if there are still open connection in stead of looking if all systems are checked
        while(activesystems.size()>0) {
            //process next connections (stargates)
            for(Allnodesdata activesystem: activesystems) {
                for(Allnodesdata connection: activesystem.getConnections()) {
//                    connection.setRoute(activesystem);
//                    connections.add(connection);
                }
            }
            //gather active connections for next loop
            checkedsystems.addAll(connections);
            activesystems.clear();
            if(!endsystem.isUsed()) {
                activesystems.addAll(connections);
            }
            connections.clear();
        }
        return endsystem;
    }
    
}
