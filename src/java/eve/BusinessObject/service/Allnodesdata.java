/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eve.BusinessObject.service;

import eve.logicentity.Allnodes_system;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

/**
 *
 * @author pelgrim
 */
public class Allnodesdata {
    
    private Allnodes_system system;
    private HashMap<Long, Allnodesdata> connections = new HashMap<>();
    //calculated data for 1 route
    private ArrayList<Long> route = new ArrayList<>();
    
    //deadend parameters
    private HashMap<Long, Allnodesdata> deadendconnections = new HashMap<>();
    private boolean deadend = false;
    private int deadendpos = 0;
    
    //circle parameters
    private ArrayList<Integer> circleids = new ArrayList<>(); //each circle get's unique id
    private ArrayList<Allnodesdata> circleconnection = new ArrayList<>(); //only remember next node in circle
    private boolean circle = false;
    private int step = 0;
    
    private boolean used = false;
    
    public Allnodesdata(Allnodes_system system) {
        this.system = system;
    }
    
    public Allnodes_system getSystem() {
        return system;
    }
    
    public long getId() {
        return system.getPrimaryKey().getId();
    }
    
    public void addConnection(Allnodesdata systemdata) {
        connections.put(systemdata.getId(), systemdata);
    }
    
    public void reset() {
        route = new ArrayList<>();
        circle = false;
        step = 0;
        used = false;
    }
    
    public boolean isDeadend() {
        return deadend;
    }
    
    /**
     * mark as deadend
     * set parent connections as deadendconnection
     */
    public void setDeadend() {
        deadend = true;
        deadendpos++;
        //there is only 1, but for convenience a for loop
        for(Allnodesdata node: connections.values()) {
            node.setDeadendParent(system.getPrimaryKey().getId());
        }
        //if this node is a deadendparent, increase all child positions with 1
        for(Allnodesdata node: deadendconnections.values()) {
            node.incDeadendposition();
        }
    }
    
    private void setDeadendParent(long systemid) {
        deadendconnections.put(systemid, connections.get(systemid));
        connections.remove(systemid);
    }
    
    private void incDeadendposition() {
        deadendpos++;
    }
    
    public boolean isConnectedToDeadend() {
        //deadendpos == 0 => is not part of a deadend branch
        return this.deadendconnections.size()>0 && deadendpos==0;
    }
    
    public void setStartingpoint() {
        used = true;
    }
    
    public void setRoute(Allnodesdata previousnode, int step) {
        this.route.addAll(previousnode.getRoute());
        this.route.add(this.getId());
        this.step = step;
        used = true;
    }
    
    public void setCircle(Allnodesdata nextnode, int circleid) {
        this.circleconnection.add(nextnode);
        this.circleids.add(circleid);
    }
    
    public Allnodesdata getNextCirclenode(int circleid) {
        //find circleid position
        int pos = -1;
        int arraysize = circleids.size();
        for(int i=0; i<arraysize; i++) {
            if(circleids.get(i)==circleid) {
                pos = i;
                break;
            }
        }
        if(pos==-1) {
            return null;
        } else {
            return this.circleconnection.get(pos);
        }
    }
    
    public Collection<Allnodesdata> getConnections() {
        return connections.values();
    }
    
    public Collection<Allnodesdata> getDeadendonnections() {
        return deadendconnections.values();
    }
    
    public ArrayList<Long> getRoute() {
        return route;
    }
    
    public long getFirstroutenode() {
        return route.get(0);
    }
    
    public int getStep() {
        return step;
    }
    
    public boolean isUsed() {
        return used;
    }
}
