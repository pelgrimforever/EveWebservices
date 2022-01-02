/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eve.BusinessObject.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

/**
 *
 * @author pelgrim
 */
public class Systemdata {
    
    private eve.logicentity.System system;
    private HashMap<Long, Systemdata> connections = new HashMap<>();
    //calculated data for 1 route
    private ArrayList<Long> route = new ArrayList<>();
    private int lowsec = 0;
    private int nullsec = 0;
    private boolean used = false;
    private boolean avoid = false;
    private boolean[] usedroute = { false, false}; //usedroute[0] route from starting system, usedroute[1] route from end system
    
    public Systemdata(eve.logicentity.System system) {
        this.system = system;
    }
    
    public eve.logicentity.System getSystem() {
        return system;
    }
    
    public long getId() {
        return system.getPrimaryKey().getId();
    }
    
    public void addConnection(Systemdata systemdata) {
        connections.put(systemdata.getId(), systemdata);
    }
    
    public void forceroute(ArrayList<Long> route, int lowsecjumps, int nullsecjumps) {
        this.route = route;
        this.lowsec = lowsecjumps;
        this.nullsec = nullsecjumps;
    }
    
    public void reset() {
        route = new ArrayList<>();
        lowsec = 0;
        nullsec = 0;
        used = false;
        usedroute[0] = false;
        usedroute[1] = false;
        avoid = false;
    }
    
    public void setStartingpoint(byte route) {
        used = true;
        usedroute[route] = true;
        if(system.getSecurity_status()<0.45) {
            if(!(system.getSecurity_status()>0)) {
                this.nullsec++;
            } else {
                this.lowsec++;
            }
        }
    }
    
    public void avoid() {
        avoid = true;
    }
    
    public void setRoute(Systemdata previousnode) {
        this.route.addAll(previousnode.getRoute());
        this.route.add(this.getId());
        this.lowsec = previousnode.getLowsecjumps();
        this.nullsec = previousnode.getNullsecjumps();
        if(system.getSecurity_status()<0.45) {
            if(!(system.getSecurity_status()>0)) {
                this.nullsec++;
            } else {
                this.lowsec++;
            }
        }
        used = true;
        usedroute[0] = previousnode.getUsedroute()[0];
        usedroute[1] = previousnode.getUsedroute()[1];
    }
    
    public Collection<Systemdata> getConnections() {
        return connections.values();
    }
    
    public ArrayList<Long> getRoute() {
        return route;
    }
    
    public int getLowsecjumps() {
        return lowsec;
    }
    
    public int getNullsecjumps() {
        return nullsec;
    }
    
    public boolean isHighsec() {
        return !(this.system.getSecurity_status()<0.45);
    }
    
    public boolean isUsed() {
        return used;
    }
    
    public boolean[] getUsedroute() {
        return usedroute;
    }
    
    public boolean isAvailable() {
        return !(used || avoid);
    }
    
    public boolean isAvailable(byte routenumber) {
        return !(usedroute[routenumber] || avoid);
    }
    
    public boolean hasConnected2Route(byte routenumber) {
        return usedroute[routenumber];
    }
}
