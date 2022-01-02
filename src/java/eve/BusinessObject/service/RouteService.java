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
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

/**
 *
 * @author pelgrim
 */
public class RouteService {
    
    private HashMap<Long, Systemdata> systemhash = new HashMap<>();
    private byte STARTROUTE = 0;
    private byte ENDROUTE = 1;
    
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
                endnode = getRouteSafe2(systemstart, systemend, avoidlist);
            } else {
                endnode = getRoute2(systemstart, systemend, avoidlist);
            }
            gatechecksystems.addAll(endnode.getRoute());
            lowsecjumps += endnode.getLowsecjumps();
            nullsecjumps += endnode.getNullsecjumps();
            systemstart = systemend;
        }
        endnode.forceroute(gatechecksystems, lowsecjumps, nullsecjumps);
        return endnode;
    }
    
    private Systemdata getRoute2(long startpoint, long endpoint, ArrayList<Long> avoidlist) {
        //initialize for new starting point
        for(Systemdata systeminit: systemhash.values()) {
            systeminit.reset();
        }
        for(Long systemid: avoidlist) {
            systemhash.get(systemid).avoid();
        }
        //calculate routes
        ArrayList<Systemdata> checkedsystems;
        ArrayList<Systemdata> activesystems1, activesystems2;
        ArrayList<Systemdata> connections1, connections2;
        Systemdata newconnection;
        int counter = 0;
        Systemdata startsystem = systemhash.get(startpoint);
        Systemdata endsystem = systemhash.get(endpoint);
        startsystem.setStartingpoint(STARTROUTE);
        endsystem.setStartingpoint(ENDROUTE);
        checkedsystems = new ArrayList<>();
        checkedsystems.add(startsystem);
        checkedsystems.add(endsystem);
        activesystems1 = new ArrayList<>();
        activesystems1.add(startsystem);
        activesystems2 = new ArrayList<>();
        activesystems2.add(endsystem);
        connections1 = new ArrayList<>();
        connections2 = new ArrayList<>();
        Systemdata middlesystem1 = null;
        Systemdata middlesystem2 = null;
        //isolated clusters of systems exists in eve
        //so we check if there are still open connection in stead of looking if all systems are checked
        while(activesystems1.size()>0 || activesystems2.size()>0) {
            //process next connections (stargates)
            for(Systemdata activesystem: activesystems1) {
                for(Systemdata connection: activesystem.getConnections()) {
                    if(connection.isAvailable(STARTROUTE)) {
                        if(connection.hasConnected2Route(ENDROUTE)) {
                            middlesystem1 = activesystem;
                            middlesystem2 = connection;
                            break;
                        } else {
                            connection.setRoute(activesystem);
                            connections1.add(connection);
                        }
                    }
                }
                if(middlesystem1!=null) {
                    break;
                }
            }
            //gather active connections for next loop
            checkedsystems.addAll(connections1);
            activesystems1.clear();
            if(middlesystem1==null) {
                activesystems1.addAll(connections1);
            }
            connections1.clear();
            //process next connections (stargates)
            if(middlesystem1==null) {
                for(Systemdata activesystem: activesystems2) {
                    for(Systemdata connection: activesystem.getConnections()) {
                        if(connection.isAvailable(ENDROUTE)) {
                            if(connection.hasConnected2Route(STARTROUTE)) {
                                middlesystem1 = connection;
                                middlesystem2 = activesystem;
                                break;
                            } else {
                                connection.setRoute(activesystem);
                                connections2.add(connection);
                            }
                        }
                    }
                    if(middlesystem1!=null) {
                        break;
                    }
                }
                //gather active connections for next loop
                checkedsystems.addAll(connections2);
                activesystems2.clear();
                if(middlesystem1==null) {
                    activesystems2.addAll(connections2);
                }
                connections2.clear();
            }
            if(middlesystem1!=null) {
                activesystems1.clear();
                activesystems2.clear();
            }
        }
        //reverse route 2 part to connect with route1
        ArrayList<Long> route2 = middlesystem2.getRoute();
        Collections.reverse(route2);
        Systemdata systemdata;
        for(long systemid: route2) {
            systemdata = systemhash.get(systemid);
            systemdata.reset();
            systemdata.setRoute(middlesystem1);
            middlesystem1 = systemdata;
        }
        endsystem.setRoute(middlesystem1);
        return endsystem;
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
        startsystem.setStartingpoint(STARTROUTE);
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
        startsystem.setStartingpoint(STARTROUTE);
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
    
    private Systemdata getRouteSafe2(long startpoint, long endpoint, ArrayList<Long> avoidlist) {
        //initialize for new starting point
        for(Systemdata systeminit: systemhash.values()) {
            systeminit.reset();
        }
        for(Long systemid: avoidlist) {
            systemhash.get(systemid).avoid();
        }
        //calculate routes
        ArrayList<Systemdata> checkedsystems1, checkedsystems2;
        ArrayList<Systemdata> activesystems1, activesystems2;
        ArrayList<Systemdata> connections1, connections2;
        Systemdata newconnection;
        int counter = 0;
        Systemdata startsystem = systemhash.get(startpoint);
        Systemdata endsystem = systemhash.get(endpoint);
        startsystem.setStartingpoint(STARTROUTE);
        endsystem.setStartingpoint(ENDROUTE);
        checkedsystems1 = new ArrayList<>();
        checkedsystems2 = new ArrayList<>();
        checkedsystems1.add(startsystem);
        checkedsystems2.add(endsystem);
        activesystems1 = new ArrayList<>();
        activesystems1.add(startsystem);
        activesystems2 = new ArrayList<>();
        activesystems2.add(endsystem);
        connections1 = new ArrayList<>();
        connections2 = new ArrayList<>();
        Systemdata middlesystem1 = null;
        Systemdata middlesystem2 = null;
        //isolated clusters of systems exists in eve
        //so we check if there are still open connection in stead of looking if all systems are checked
        //check highsec first
        while(middlesystem1==null && (activesystems1.size()>0 || activesystems2.size()>0)) {
            while(activesystems1.size()>0 || activesystems2.size()>0) {
                //process next connections (stargates)
                for(Systemdata activesystem: activesystems1) {
                    for(Systemdata connection: activesystem.getConnections()) {
                        if(connection.isAvailable(STARTROUTE) && connection.isHighsec()) {
                            if(connection.hasConnected2Route(ENDROUTE)) {
                                middlesystem1 = activesystem;
                                middlesystem2 = connection;
                                break;
                            } else {
                                connection.setRoute(activesystem);
                                connections1.add(connection);
                            }
                        }
                    }
                    if(middlesystem1!=null) {
                        break;
                    }
                }
                //gather active connections for next loop
                checkedsystems1.addAll(connections1);
                activesystems1.clear();
                if(middlesystem1==null) {
                    activesystems1.addAll(connections1);
                }
                connections1.clear();
                //process next connections (stargates)
                if(middlesystem1==null) {
                    for(Systemdata activesystem: activesystems2) {
                        for(Systemdata connection: activesystem.getConnections()) {
                            if(connection.isAvailable(ENDROUTE) && connection.isHighsec()) {
                                if(connection.hasConnected2Route(STARTROUTE)) {
                                    middlesystem1 = connection;
                                    middlesystem2 = activesystem;
                                    break;
                                } else {
                                    connection.setRoute(activesystem);
                                    connections2.add(connection);
                                }
                            }
                        }
                        if(middlesystem1!=null) {
                            break;
                        }
                    }
                    //gather active connections for next loop
                    checkedsystems2.addAll(connections2);
                    activesystems2.clear();
                    if(middlesystem1==null) {
                        activesystems2.addAll(connections2);
                    }
                    connections2.clear();
                }
                if(middlesystem1!=null) {
                    activesystems1.clear();
                    activesystems2.clear();
                }
            }
            //if not found yet, check also low/null sec until connection is made or a highsec system is found
            if(middlesystem1==null) {
                boolean highsecfound1 = false;
                boolean highsecfound2 = false;
                activesystems1.clear();
                activesystems1.addAll(checkedsystems1);
                activesystems2.clear();
                activesystems2.addAll(checkedsystems2);
                while((activesystems1.size()>0 || activesystems2.size()>0) && !highsecfound1 && !highsecfound2 ) {
                    //process next connections (stargates)
                    for(Systemdata activesystem: activesystems1) {
                        for(Systemdata connection: activesystem.getConnections()) {
                            if(connection.isAvailable(STARTROUTE)) {
                                if(connection.hasConnected2Route(ENDROUTE)) {
                                    middlesystem1 = activesystem;
                                    middlesystem2 = connection;
                                    break;
                                } else {
                                    connection.setRoute(activesystem);
                                    connections1.add(connection);
                                    highsecfound1 = connection.isHighsec();
                                }
                            }
                        }
                        if(middlesystem1!=null) {
                            break;
                        }
                    }
                    //gather active connections for next loop
                    checkedsystems1.addAll(connections1);
                    activesystems1.clear();
                    if(middlesystem1==null) {
                        activesystems1.addAll(connections1);
                        if(highsecfound1) {
                            activesystems1.removeIf(s -> !s.isHighsec());
                        }
                    }
                    connections1.clear();
                    //process next connections (stargates)
                    if(middlesystem1==null) {
                        for(Systemdata activesystem: activesystems2) {
                            for(Systemdata connection: activesystem.getConnections()) {
                                if(connection.isAvailable(ENDROUTE)) {
                                    if(connection.hasConnected2Route(STARTROUTE)) {
                                        middlesystem1 = connection;
                                        middlesystem2 = activesystem;
                                        highsecfound2 = connection.isHighsec();
                                        break;
                                    } else {
                                        connection.setRoute(activesystem);
                                        connections2.add(connection);
                                    }
                                }
                            }
                            if(middlesystem1!=null) {
                                break;
                            }
                        }
                        //gather active connections for next loop
                        checkedsystems2.addAll(connections2);
                        activesystems2.clear();
                        if(middlesystem1==null) {
                            activesystems2.addAll(connections2);
                            if(highsecfound2) {
                                activesystems2.removeIf(s -> !s.isHighsec());
                            }
                        }
                        connections2.clear();
                    }
                    if(middlesystem1!=null) {
                        activesystems1.clear();
                        activesystems2.clear();
                    }
                }
            }
        }
        
        //reverse route 2 part to connect with route1
        if(middlesystem1!=null) {
            ArrayList<Long> route2 = middlesystem2.getRoute();
            Collections.reverse(route2);
            Systemdata systemdata;
            for(long systemid: route2) {
                systemdata = systemhash.get(systemid);
                systemdata.reset();
                systemdata.setRoute(middlesystem1);
                middlesystem1 = systemdata;
            }
            endsystem.setRoute(middlesystem1);
        }
        return endsystem;
    }
    
}
