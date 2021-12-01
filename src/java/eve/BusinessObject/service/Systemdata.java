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
    private boolean used = false;
    private boolean avoid = false;
    
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
    
    public void reset() {
        route = new ArrayList<>();
        used = false;
        avoid = false;
    }
    
    public void setStartingpoint() {
        used = true;
    }
    
    public void avoid() {
        avoid = true;
    }
    
    public void setRoute(ArrayList<Long> route) {
        this.route.addAll(route);
        this.route.add(this.getId());
        used = true;
    }
    
    public Collection<Systemdata> getConnections() {
        return connections.values();
    }
    
    public ArrayList<Long> getRoute() {
        return route;
    }
    
    public boolean isHighsec() {
        return !(this.system.getSecurity_status()<0.45);
    }
    
    public boolean isUsed() {
        return used;
    }
    
    public boolean isAvailable() {
        return !(used || avoid);
    }
}
