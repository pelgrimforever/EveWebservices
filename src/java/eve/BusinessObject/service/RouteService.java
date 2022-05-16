package eve.BusinessObject.service;

import eve.BusinessObject.Logic.BLstargate;
import eve.BusinessObject.Logic.BLsystem;
import static eve.BusinessObject.service.Systemdata.ENDROUTE;
import static eve.BusinessObject.service.Systemdata.STARTROUTE;
import eve.usecases.Loadroute_parameters;
import eve.logicentity.Stargate;
import general.exception.DBException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

/**
 * @author Franky Laseure
 */
public class RouteService {
    private Loadroute_parameters loadrouteparameters;
    private long systemstart;
    private long systemend;
    private HashMap<Long, Systemdata> systemhash = new HashMap<>();
    private Partial_route partial_route;
    private Systemdata systemdata;
    private Systemdata endnode;
    
    public RouteService() {
        try {
            loadsystems();
            connect_systems_with_stargateconnections();
        }
        catch(DBException e) {
        }
    }

    private void connect_systems_with_stargateconnections() throws DBException {
        BLstargate blstargate = new BLstargate();
        ArrayList<Stargate> stargates = blstargate.getAll();
        for(Stargate stargate: stargates)
            connect_system(stargate);
    }

    private void connect_system(Stargate stargate) {
        systemdata = systemhash.get(stargate.getSystemsystemPK().getId());
        systemdata.addConnection(systemhash.get(stargate.getSystemto_systemPK().getId()));
    }

    private void loadsystems() throws DBException {
        BLsystem blsystem = new BLsystem();
        blsystem.setAuthenticated(true);
        ArrayList<eve.logicentity.System> systems = blsystem.getSystems();
        for(eve.logicentity.System system: systems)
            systemhash.put(system.getPrimaryKey().getId(), new Systemdata(system));
    }

    private eve.logicentity.System getSystem(long systemid) {
        return systemhash.get(systemid).getSystem();
    }
    
    public ArrayList<Long> getRoute(Loadroute_parameters loadrouteparameters) {
        return getRoute_Systemdata(loadrouteparameters).getRoute();
    }
    
    public Systemdata getRoute_Systemdata(Loadroute_parameters loadrouteparameters) {
        this.loadrouteparameters = loadrouteparameters;
        ArrayList<Long> route_endpoints = create_route_endpoints_list();
        partial_route = partial_route_initialize();
        systemstart = loadrouteparameters.getOrigin();
        endnode = new Systemdata(null);
        Iterator<Long> route_endpointsI = route_endpoints.iterator();
        while(route_endpointsI.hasNext())
            calculate_next_route_segment(route_endpointsI.next());
        partial_route.copy_values_to_endnode(endnode);
        return endnode;
    }

    private void calculate_next_route_segment(long route_endpoint) {
        systemend = route_endpoint;
        endnode = get_new_route_segment(systemstart, systemend);
        partial_route.add_endnode(endnode);
        systemstart = systemend;
    }
    
    private Partial_route partial_route_initialize() {
        Partial_route partial_route = new Partial_route();
        partial_route.gatechecksystems.add(loadrouteparameters.getOrigin());
        return partial_route;
    }
    
    private class Partial_route {
        public ArrayList<Long> gatechecksystems = new ArrayList();
        public int lowsecjumps = 0;
        public int nullsecjumps = 0;        
        
        public void add_endnode(Systemdata endnode) {
            gatechecksystems.addAll(endnode.getRoute());
            lowsecjumps += endnode.getLowsecjumps();
            nullsecjumps += endnode.getNullsecjumps();
        }
        
        public void copy_values_to_endnode(Systemdata endnode) {
            endnode.forceroute(gatechecksystems, lowsecjumps, nullsecjumps);
        }
    }
    
    private ArrayList<Long> create_route_endpoints_list() {
        ArrayList<Long> route_endpoints = new ArrayList();
        route_endpoints.addAll(loadrouteparameters.getRoutesegmentlist());
        route_endpoints.add(loadrouteparameters.getDestination());
        return route_endpoints;
    }

    private Systemdata get_new_route_segment(long systemstart, long systemend) {
        Route_calculator routecalculator = new Route_calculator(systemstart, systemend, loadrouteparameters.getAvoidsystems());
        if(loadrouteparameters.isSecure())
            return routecalculator.calculate_saferoute();
        else
            return routecalculator.calculate_shortroute();
    }
    
    private class Route_calculator {
        
        private long startpoint;
        private long endpoint;
        private ArrayList<Long> avoidlist;
        private ArrayList<Systemdata> checkedsystems_startside, checkedsystems_endside;
        private ArrayList<Systemdata> activesystems_startside, activesystems_endside;
        private ArrayList<Systemdata> new_connections_startside, new_connections_endside;
        private Systemdata tempsystemdata;
        private Systemdata newconnection;
        private int counter;
        private Systemdata startsystem;
        private Systemdata endsystem;
        private Systemdata middlesystem_startside, middlesystem_endside;
        private boolean highsecfound_start_side;
        private boolean highsecfound_end_side;
        
        public Route_calculator(long startpoint, long endpoint, ArrayList<Long> avoidlist) {
            this.startpoint = startpoint;
            this.endpoint = endpoint;
            this.avoidlist = avoidlist;
        }

        public Systemdata calculate_saferoute() {
            initializesystemhash(avoidlist);
            initialize();
            //isolated clusters of systems exists in eve
            //so we check if there are still open connectedsystem in stead of looking if all systems are checked
            while(!are_start_side_end_side_connected() && start_side_end_side_has_active_connections())
                find_next_connectedsystems_on_start_end_priority_highsec();
            if(are_start_side_end_side_connected())
                link_route_startside_endside();
            return endsystem;
        }

        public Systemdata calculate_shortroute() {
            initializesystemhash(avoidlist);
            initialize();
            //isolated clusters of systems exists in eve
            //so we check if there are still open connectedsystem in stead of looking if all systems are checked
            while(start_side_end_side_has_active_connections())
                find_next_connectedsystems_on_start_end_anysec();
            if(are_start_side_end_side_connected())
                link_route_startside_endside();
            return endsystem;
        }
        
        private void find_next_connectedsystems_on_start_end_priority_highsec() {
            while(start_side_end_side_has_active_connections())
                find_next_connectedsystems_on_start_end_highsec();
            if(!are_start_side_end_side_connected())
                find_next_connectedsystems_on_start_end_lowsec();
        }
        
        private void find_next_connectedsystems_on_start_end_highsec() {
            find_connectedsystems_on_startside_highsec();
            find_connectedsystems_on_endside_highsec_when_not_connected_yet();
            if(are_start_side_end_side_connected())
                clear_remaining_activesystems();
        }

        private void clear_remaining_activesystems() {
            activesystems_startside.clear();
            activesystems_endside.clear();
        }
        
        private void find_connectedsystems_on_startside_highsec() {
            for(Systemdata activesystem_startside: activesystems_startside)
                if(is_activesystem_startside_connectedwith_endside(activesystem_startside)) break;
            gather_active_connections_startside_for_next_iteration();
            if(!are_start_side_end_side_connected())
                activesystems_startside.addAll(new_connections_startside);
            new_connections_startside.clear();
        }

        private void gather_active_connections_startside_for_next_iteration() {
            checkedsystems_startside.addAll(new_connections_startside);
            activesystems_startside.clear();
        }

        private boolean is_activesystem_startside_connectedwith_endside(Systemdata activesystem_startside) {
            find_connectedsystems_on_startside_highsec_for_1_system(activesystem_startside);
            if (are_start_side_end_side_connected())
                return true;
            return false;
        }

        private void find_connectedsystems_on_startside_highsec_for_1_system(Systemdata activesystem_startside) {
            for(Systemdata connectedsystem: activesystem_startside.getConnectedsystems())
                if(is_connectedsystem_on_startside_available_and_highsec_and_connectedto_endside(connectedsystem, activesystem_startside)) break;
        }

        private boolean is_connectedsystem_on_startside_available_and_highsec_and_connectedto_endside(Systemdata connectedsystem, Systemdata activesystem_startside) {
            if (connectedsystem.isAvailable(STARTROUTE) && connectedsystem.isHighsec())
                if (is_system_connected_with_endside(connectedsystem, activesystem_startside))
                    return link_startside_with_endside(activesystem_startside, connectedsystem);
            return false;
        }

        private boolean is_system_connected_with_endside(Systemdata connectedsystem, Systemdata activesystem_startside) {
            if (connectedsystem.hasConnected2Route(ENDROUTE))
                return true;
            else
                link_connectedsystem_to_route_on_startside(connectedsystem, activesystem_startside);
            return false;
        }

        private void link_connectedsystem_to_route_on_startside(Systemdata connectedsystem, Systemdata activesystem_startside) {
            connectedsystem.setRoute(activesystem_startside);
            new_connections_startside.add(connectedsystem);
            highsecfound_start_side = connectedsystem.isHighsec();
        }

        private boolean link_startside_with_endside(Systemdata activesystem_startside, Systemdata connectedsystem) {
            middlesystem_startside = activesystem_startside;
            middlesystem_endside = connectedsystem;
            highsecfound_end_side = activesystem_startside.isHighsec();
            return true;
        }
        
        private void find_connectedsystems_on_endside_highsec_when_not_connected_yet() {
            if(!are_start_side_end_side_connected())
                find_connectedsystems_on_endside_highsec();
        }

        private void find_connectedsystems_on_endside_highsec() {
            for(Systemdata activesystem_endside: activesystems_endside)
                if(is_connectedsystem_on_endside_available_and_highsec_and_connectedto_startside(activesystem_endside)) break;
            gather_active_connections_endside_for_next_iteration();
            if(!are_start_side_end_side_connected())
                activesystems_endside.addAll(new_connections_endside);
            new_connections_endside.clear();
        }

        private void gather_active_connections_endside_for_next_iteration() {
            checkedsystems_endside.addAll(new_connections_endside);
            activesystems_endside.clear();
        }

        private boolean is_connectedsystem_on_endside_available_and_highsec_and_connectedto_startside(Systemdata activesystem_endside) {
            find_connectedsystems_on_endside_highsec_for_1_system(activesystem_endside);
            if (are_start_side_end_side_connected())
                return true;
            return false;
        }

        private void find_connectedsystems_on_endside_highsec_for_1_system(Systemdata activesystem_endside) {
            for(Systemdata connectedsystem: activesystem_endside.getConnectedsystems())
                if(is_connectedsystem_on_endside_available_and_highsec_and_connectedto_startside(connectedsystem, activesystem_endside)) break;
        }

        private boolean is_connectedsystem_on_endside_available_and_highsec_and_connectedto_startside(Systemdata connectedsystem, Systemdata activesystem_endside) {
            if (connectedsystem.isAvailable(ENDROUTE) && connectedsystem.isHighsec())
                if (is_system_connected_with_startside(connectedsystem, activesystem_endside)) return link_startside_with_endside(connectedsystem, activesystem_endside);
            return false;
        }

        private boolean is_system_connected_with_startside(Systemdata connectedsystem, Systemdata activesystem_endside) {
            if (connectedsystem.hasConnected2Route(STARTROUTE))
                return true;
            else
                link_connectedsystem_to_route_on_endside(connectedsystem, activesystem_endside);
            return false;
        }
        
        private void find_next_connectedsystems_on_start_end_lowsec() {
            initialize_find_next_connectedsystems_on_start_end_lowsec();
            while(start_side_end_side_has_active_connections() && !highsecfound_start_side && !highsecfound_end_side ) {
                find_next_connectedsystem_on_start_end_lowsec();
            }
        }

        private void find_next_connectedsystem_on_start_end_lowsec() {
            find_connectedsystems_on_startside_lowsec();
            if(!are_start_side_end_side_connected())
                find_connectedsystems_on_endside_lowsec();
            else
                clear_remaining_activesystems();
        }
        
        private void find_connectedsystems_on_startside_lowsec() {
            for(Systemdata activesystem_startside: activesystems_startside)
                if(is_activesystem_startside_connectedwith_endside_lowsec(activesystem_startside))
                    break;
            gather_active_connections_startside_for_next_iteration();
            if(!are_start_side_end_side_connected())
                add_new_connectedsystems_to_activesystems_startside();
            new_connections_startside.clear();
        }

        private void add_new_connectedsystems_to_activesystems_startside() {
            activesystems_startside.addAll(new_connections_startside);
            if(highsecfound_start_side)
                activesystems_startside.removeIf(s -> !s.isHighsec());
        }

        private boolean is_activesystem_startside_connectedwith_endside_lowsec(Systemdata activesystem_startside) {
            find_connectedsystems_on_startside_lowsec_for_1_system(activesystem_startside);
            if (are_start_side_end_side_connected()) {
                return true;
            }
            return false;
        }

        private void find_connectedsystems_on_startside_lowsec_for_1_system(Systemdata activesystem_startside) {
            for(Systemdata connectedsystem: activesystem_startside.getConnectedsystems())
                if(is_connectedsystem_on_startside_available_and_connectedto_endside(connectedsystem, activesystem_startside)) break;
        }

        private boolean is_connectedsystem_on_startside_available_and_connectedto_endside(Systemdata connectedsystem, Systemdata activesystem_startside) {
            if (connectedsystem.isAvailable(STARTROUTE)) {
                if (connectedsystem.hasConnected2Route(ENDROUTE))
                    return link_startside_with_endside(activesystem_startside, connectedsystem);
                else
                    link_connectedsystem_to_route_on_startside(connectedsystem, activesystem_startside);
            }
            return false;
        }

        private void find_connectedsystems_on_endside_lowsec() {
            for(Systemdata activesystem: activesystems_endside)
                if(is_activesystem_endside_connectedwith_endside_lowsec(activesystem)) break;
            gather_active_connections_endside_for_next_iteration();
            if(!are_start_side_end_side_connected())
                add_new_connectedsystems_to_activesystems_endside();
            new_connections_endside.clear();
        }

        private void add_new_connectedsystems_to_activesystems_endside() {
            activesystems_endside.addAll(new_connections_endside);
            if(highsecfound_end_side)
                activesystems_endside.removeIf(s -> !s.isHighsec());
        }

        private boolean is_activesystem_endside_connectedwith_endside_lowsec(Systemdata activesystem) {
            find_connectedsystems_on_endside_lowsec_for_1_system(activesystem);
            if (are_start_side_end_side_connected())
                return true;
            return false;
        }

        private void find_connectedsystems_on_endside_lowsec_for_1_system(Systemdata activesystem) {
            for(Systemdata connection: activesystem.getConnectedsystems())
                if(is_connectedsystem_on_endside_available_and_connectedto_startside(connection, activesystem)) break;
        }

        private boolean is_connectedsystem_on_endside_available_and_connectedto_startside(Systemdata connection, Systemdata activesystem) {
            if (connection.isAvailable(ENDROUTE)) {
                if (connection.hasConnected2Route(STARTROUTE)) {
                    link_startside_with_endside(connection, activesystem);
                } else {
                    link_connectedsystem_to_route_on_endside(connection, activesystem);
                }
            }
            return false;
        }

        private void initialize_find_next_connectedsystems_on_start_end_lowsec() {
            highsecfound_start_side = false;
            highsecfound_end_side = false;
            activesystems_startside.clear();
            activesystems_startside.addAll(checkedsystems_startside);
            activesystems_endside.clear();
            activesystems_endside.addAll(checkedsystems_endside);
        }
        
        private void find_next_connectedsystems_on_start_end_anysec() {
            find_connectedsystems_on_startside_anysec();
            find_connectedsystems_on_endside_anysec();
            if(are_start_side_end_side_connected())
                clear_remaining_activesystems();
        }
        
        private void find_connectedsystems_on_startside_anysec() {
            for(Systemdata activesystem_startside: activesystems_startside) {
                if(is_activesystem_startside_connectedwith_endside_anysec(activesystem_startside))
                    break;
            }
            gather_active_connections_startside_for_next_iteration();
            if(!are_start_side_end_side_connected())
                activesystems_startside.addAll(new_connections_startside);
            new_connections_startside.clear();
        }

        private boolean is_activesystem_startside_connectedwith_endside_anysec(Systemdata activesystem_startside) {
            find_connectedsystems_on_startside_anysec_for_1_system(activesystem_startside);
            if (are_start_side_end_side_connected())
                return true;
            return false;
        }

        private void find_connectedsystems_on_startside_anysec_for_1_system(Systemdata activesystem_startside) {
            for(Systemdata connectedsystem: activesystem_startside.getConnectedsystems())
                if(find_connectedsystems_on_startside_anysec_for_1_system_isavailable(connectedsystem, activesystem_startside)) break;
        }

        private boolean find_connectedsystems_on_startside_anysec_for_1_system_isavailable(Systemdata connectedsystem, Systemdata activesystem_startside) {
            if (connectedsystem.isAvailable(STARTROUTE))
                if (is_system_connected_with_endside(connectedsystem, activesystem_startside)) 
                    return link_startside_with_endside(activesystem_startside, connectedsystem);
            return false;
        }

        private void find_connectedsystems_on_endside_anysec() {
            if(!are_start_side_end_side_connected()) {
                for(Systemdata activesystem_endside: activesystems_endside) {
                    if(is_activesystem_endside_connectedwith_startside_anysec(activesystem_endside))
                        break;
                }
                //gather active connections for next loop
                checkedsystems_startside.addAll(new_connections_endside);
                activesystems_endside.clear();
                if(!are_start_side_end_side_connected())
                    activesystems_endside.addAll(new_connections_endside);
                new_connections_endside.clear();
            }
        }

        private boolean is_activesystem_endside_connectedwith_startside_anysec(Systemdata activesystem_endside) {
            find_connectedsystems_on_endside_anysec_for_1_system(activesystem_endside);
            if (are_start_side_end_side_connected())
                return true;
            return false;
        }

        private void find_connectedsystems_on_endside_anysec_for_1_system(Systemdata activesystem_endside) {
            for(Systemdata connectedsystem: activesystem_endside.getConnectedsystems())
                if(find_connectedsystems_on_endside_anysec_for_1_system_isavailable(connectedsystem, activesystem_endside)) break;
        }

        private boolean find_connectedsystems_on_endside_anysec_for_1_system_isavailable(Systemdata connectedsystem, Systemdata activesystem_endside) {
            if (connectedsystem.isAvailable(ENDROUTE)) {
                if (is_system_connected_with_startside(connectedsystem, activesystem_endside)) return link_startside_with_endside(connectedsystem, activesystem_endside);
            }
            return false;
        }

        private void link_connectedsystem_to_route_on_endside(Systemdata connectedsystem, Systemdata activesystem_endside) {
            connectedsystem.setRoute(activesystem_endside);
            new_connections_endside.add(connectedsystem);
        }

        private void link_route_startside_endside() {
            ArrayList<Long> route2 = reverse_route_endside();
            for(long systemid: route2)
                connect_route_endside_on_route_startside(systemid);
            endsystem.setRoute(middlesystem_startside);
        }
        
        private ArrayList<Long> reverse_route_endside() {
            ArrayList<Long> route2 = middlesystem_endside.getRoute();
            Collections.reverse(route2);
            return route2;
        }
        
        private void connect_route_endside_on_route_startside(long systemid) {
            tempsystemdata = systemhash.get(systemid);
            tempsystemdata.reset();
            tempsystemdata.setRoute(middlesystem_startside);
            middlesystem_startside = tempsystemdata;
        }
        
        private void initializesystemhash(ArrayList<Long> avoidlist) {
            for(Systemdata systeminit: systemhash.values())
                systeminit.reset();
            for(Long systemid: avoidlist)
                systemhash.get(systemid).avoid();
        }

        private void initialize() {
            counter = 0;
            startsystem = systemhash.get(startpoint);
            endsystem = systemhash.get(endpoint);
            startsystem.setStartingpoint(STARTROUTE);
            endsystem.setStartingpoint(ENDROUTE);
            checkedsystems_startside = new ArrayList<>();
            checkedsystems_endside = new ArrayList<>();
            checkedsystems_startside.add(startsystem);
            checkedsystems_endside.add(endsystem);
            activesystems_startside = new ArrayList<>();
            activesystems_startside.add(startsystem);
            activesystems_endside = new ArrayList<>();
            activesystems_endside.add(endsystem);
            new_connections_startside = new ArrayList<>();
            new_connections_endside = new ArrayList<>();
            middlesystem_startside = null;
            middlesystem_endside = null;
        }
        
        private boolean are_start_side_end_side_connected() {
            return middlesystem_startside!=null;
        }
        
        private boolean start_side_end_side_has_active_connections() {
            return activesystems_startside.size()>0 && activesystems_endside.size()>0;
        }
    }
}
