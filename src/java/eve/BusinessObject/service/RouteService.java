/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eve.BusinessObject.service;

import eve.BusinessObject.Logic.BLstargate;
import eve.BusinessObject.Logic.BLsystem;
import eve.logicentity.Stargate;
import general.exception.DBException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 *
 * @author pelgrim
 */
public class RouteService {
    
    HashMap<Long, Systemdata> systemhash = new HashMap<>();
    
    public RouteService() {
        try {
            BLsystem blsystem = new BLsystem();
            ArrayList<eve.logicentity.System> systems = blsystem.getSystems();
            for(eve.logicentity.System system: systems) {
                systemhash.put(system.getPrimaryKey().getId(), new Systemdata(system));
            }
            BLstargate blstargate = new BLstargate();
            ArrayList<Stargate> stargates = blstargate.getAll();
            Systemdata systemdata;
            for(Stargate stargate: stargates) {
                systemdata = systemhash.get(stargate.getSystemsystemPK().getId());
                systemdata.addConnection(systemhash.get(stargate.getSystemto_systemPK().getId()));
            }
        }
        catch(DBException e) {
        }
    }

    public eve.logicentity.System getSystem(long systemid) {
        return systemhash.get(systemid).getSystem();
    }
    
    public Systemdata getRoute(long startpoint, long endpoint, ArrayList<Long> avoidlist, ArrayList<Long> viasystems, boolean safe) {
        //build routelist
        ArrayList<Long> routelist = new ArrayList();
        routelist.add(startpoint);
        routelist.addAll(viasystems);
        routelist.add(endpoint);
        
        Iterator<Long> routelistI = routelist.iterator();
        long systemstart = routelistI.next();
        long systemend;
        Systemdata endnode = new Systemdata(null);
        ArrayList<Long> gatechecksystems = new ArrayList();
        int lowsecjumps = 0;
        int nullsecjumps = 0;
        gatechecksystems.add(startpoint);
        while(routelistI.hasNext()) {
            systemend = routelistI.next();
            if(safe) {
                endnode = getRouteSafe(systemstart, systemend, avoidlist);
            } else {
                endnode = getRoute(systemstart, systemend, avoidlist);
            }
            gatechecksystems.addAll(endnode.getRoute());
            lowsecjumps += endnode.getLowsecjumps();
            nullsecjumps += endnode.getNullsecjumps();
            systemstart = systemend;
        }
        endnode.forceroute(gatechecksystems, lowsecjumps, nullsecjumps);
        return endnode;
    }
    
    private Systemdata getRoute(long startpoint, long endpoint, ArrayList<Long> avoidlist) {
        //initialize for new starting point
        for(Systemdata systeminit: systemhash.values()) {
            systeminit.reset();
        }
        for(Long systemid: avoidlist) {
            systemhash.get(systemid).avoid();
        }
        //calculate routes
        ArrayList<Systemdata> checkedsystems;
        ArrayList<Systemdata> activesystems;
        ArrayList<Systemdata> connections;
        Systemdata newconnection;
        int counter = 0;
        Systemdata startsystem = systemhash.get(startpoint);
        Systemdata endsystem = systemhash.get(endpoint);
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
            for(Systemdata activesystem: activesystems) {
                for(Systemdata connection: activesystem.getConnections()) {
                    if(connection.isAvailable()) {
                        connection.setRoute(activesystem);
                        connections.add(connection);
                    }
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
    
    private Systemdata getRouteSafe(long startpoint, long endpoint, ArrayList<Long> avoidlist) {
        //initialize for new starting point
        for(Systemdata systeminit: systemhash.values()) {
            systeminit.reset();
        }
        for(Long systemid: avoidlist) {
            systemhash.get(systemid).avoid();
        }
        //calculate routes
        ArrayList<Systemdata> checkedsystems;
        ArrayList<Systemdata> activesystems;
        ArrayList<Systemdata> connections;
        Systemdata newconnection;
        int counter = 0;
        Systemdata startsystem = systemhash.get(startpoint);
        Systemdata endsystem = systemhash.get(endpoint);
        startsystem.setStartingpoint();
        checkedsystems = new ArrayList<>();
        checkedsystems.add(startsystem);
        activesystems = new ArrayList<>();
        activesystems.add(startsystem);
        connections = new ArrayList<>();
        //isolated clusters of systems exists in eve
        //so we check if there are still open connection in stead of looking if all systems are checked
        
        //check highsec routes first
        while(activesystems.size()>0) {
            //process next connections (stargates)
            for(Systemdata activesystem: activesystems) {
                for(Systemdata connection: activesystem.getConnections()) {
                    if(connection.isAvailable() && connection.isHighsec()) {
                        connection.setRoute(activesystem);
                        connections.add(connection);
                    }
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
        
        activesystems.clear();
        activesystems.addAll(checkedsystems);
        //if not found yet, search through low/null sec
        if(!endsystem.isUsed()) {
            while(activesystems.size()>0) {
                //process next connections (stargates)
                for(Systemdata activesystem: activesystems) {
                    for(Systemdata connection: activesystem.getConnections()) {
                        if(connection.isAvailable()) {
                            connection.setRoute(activesystem);
                            connections.add(connection);
                        }
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
        }
        
        return endsystem;
    }    
    
}
