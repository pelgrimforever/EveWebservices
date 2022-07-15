package eve.BusinessObject.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

/**
 * @author Franky Laseure
 */
public class Systemdata {
    
    public final static byte STARTROUTE = 0;
    public final static byte ENDROUTE = 1;
    
    private eve.logicentity.System system;
    private HashMap<Long, Systemdata> connections = new HashMap<>();
    private ArrayList<Long> route = new ArrayList<>();
    private int lowsec = 0;
    private int nullsec = 0;
    private boolean used = false;
    private boolean avoid = false;
    private boolean[] usedroute = { false, false};
    
    public Systemdata(eve.logicentity.System system) {
        this.system = system;
        usedroute[STARTROUTE] = false;
        usedroute[ENDROUTE] = false;
    }
    
    public eve.logicentity.System getSystem() {
        return system;
    }
    
    public long getId() {
        return system.getPrimaryKey().getId();
    }
    
    public HashMap<Long, Systemdata> addConnection(Systemdata systemdata) {
        connections.put(systemdata.getId(), systemdata);
        return connections;
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
        usedroute[STARTROUTE] = false;
        usedroute[ENDROUTE] = false;
        avoid = false;
    }
    
    public void setStartingpoint(byte route) {
        used = true;
        usedroute[route] = true;
        if(system.getSecurity_status()<0.45)
            set_lowsec_and_nullsec_counter();
    }

    private void set_lowsec_and_nullsec_counter() {
        if(!(system.getSecurity_status()>0))
            this.nullsec++;
        else
            this.lowsec++;
    }
    
    public void avoid() {
        avoid = true;
    }
    
    public void setRoute(Systemdata previousnode) {
        create_route_from_previousnode(previousnode);
        set_total_lowsec_nullsec_jumps_in_route(previousnode);
        used = true;
        usedroute[0] = previousnode.getUsedroute()[0];
        usedroute[1] = previousnode.getUsedroute()[1];
    }

    private void set_total_lowsec_nullsec_jumps_in_route(Systemdata previousnode) {
        this.lowsec = previousnode.getLowsecjumps();
        this.nullsec = previousnode.getNullsecjumps();
        if(system.getSecurity_status()<0.45)
            set_lowsec_and_nullsec_counter();
    }

    private void create_route_from_previousnode(Systemdata previousnode) {
        this.route.addAll(previousnode.getRoute());
        this.route.add(this.getId());
    }
    
    public Collection<Systemdata> getHighsecConnectedsystems() {
        ArrayList<Systemdata> highsecsystems = new ArrayList<>();
        for(Systemdata system: getConnectedsystems())
            if(system.isHighsec()) highsecsystems.add(system);
        return highsecsystems;
    }
    
    public Collection<Systemdata> getConnectedsystems() {
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
    
    private boolean[] getUsedroute() {
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
