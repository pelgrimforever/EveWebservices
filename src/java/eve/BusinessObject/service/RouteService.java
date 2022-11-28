package eve.BusinessObject.service;

import static eve.BusinessObject.service.Systemdata.ENDROUTE;
import static eve.BusinessObject.service.Systemdata.STARTROUTE;
import eve.usecases.custom.Loadroute_parameters;
import eve.logicentity.Stargate;
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
    
    public RouteService(ArrayList<eve.logicentity.System> systems, ArrayList<Stargate> stargates) {
        loadsystems(systems);
        connect_systems_with_stargateconnections(stargates);
    }

    private void connect_systems_with_stargateconnections(ArrayList<Stargate> stargates) {
        for(Stargate stargate: stargates)
            connect_system(stargate);
    }

    private void connect_system(Stargate stargate) {
        systemdata = systemhash.get(stargate.getSystemsystemPK().getId());
        systemdata.addConnection(systemhash.get(stargate.getSystemto_systemPK().getId()));
    }

    private void loadsystems(ArrayList<eve.logicentity.System> systems) {
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
        Route_calculator routecalculator = new Route_calculator();
        if(loadrouteparameters.isSecure())
            return routecalculator.calculate_saferoute(systemstart, systemend, loadrouteparameters.getAvoidsystems());
        else
            return routecalculator.calculate_shortroute(systemstart, systemend, loadrouteparameters.getAvoidsystems());
    }
    
    private class Route_calculator {
        
        private long startpoint;
        private long endpoint;
        private ArrayList<Long> avoidlist;
        private boolean findsaferoute = true;
        private Route_parameters startsideparams = new Route_parameters();
        private Route_parameters endsideparams = new Route_parameters();
        private Systemdata tempsystemdata;

        private class Route_parameters {
            Systemdata system;
            ArrayList<Systemdata> checkedsystems;
            ArrayList<Systemdata> activesystems;
            ArrayList<Systemdata> new_connections;
            Systemdata middlesystem;
            boolean highsec_connection_found = false;

            public void initialize(long systemid, byte STARTENDROUTECONST) {
                system = systemhash.get(systemid);
                system.setStartingpoint(STARTENDROUTECONST);
                checkedsystems = new ArrayList<>();
                checkedsystems.add(system);
                activesystems = new ArrayList<>();
                activesystems.add(system);
                new_connections = new ArrayList<>();
                middlesystem = null;
            }

            public void reset_activesystems() {
                activesystems.clear();
            }

            public void init_lowsecsearch() {
                highsec_connection_found = false;
                activesystems.clear();
                activesystems.addAll(checkedsystems);
            }

            public void process_new_connections(boolean findsaferoute) {
                checkedsystems.addAll(new_connections);
                activesystems.clear();
                if(!is_route_complete()) {
                    activesystems.addAll(new_connections);
                    if(findsaferoute && highsec_connection_found)
                        activesystems.removeIf(s -> !s.isHighsec());
                }
                new_connections.clear();            
            }
        }

        public boolean hasnot_highsec_connection() {
            return !startsideparams.highsec_connection_found && !endsideparams.highsec_connection_found;
        }

        public Route_calculator() {
        }

        public Systemdata calculate_saferoute(long startpoint, long endpoint, ArrayList<Long> avoidlist) {
            this.startpoint = startpoint;
            this.endpoint = endpoint;
            this.avoidlist = avoidlist;
            this.findsaferoute = true;
            initialize();
            //isolated clusters of systems exists in eve
            //so we check if there are still open connection in stead of looking if all systems are checked
            while(!is_route_complete() && has_unexplored_connections()) {
                while(has_unexplored_connections())
                    explore_active_highsecconnections();
                if(!is_route_complete())
                    explore_active_lowsecconnections();
            }
            if(is_route_complete())
                link_route_startside_endside();
            return endsideparams.system;
        }

        private void explore_active_highsecconnections() {
            explore_active_highsecconnections_startside();
            if(!is_route_complete())
                explore_active_highsecconnections_endside();
            if(is_route_complete()) {
                startsideparams.reset_activesystems();
                endsideparams.reset_activesystems();
            }
        }

        private void explore_active_lowsecconnections() {
            startsideparams.init_lowsecsearch();
            endsideparams.init_lowsecsearch();
            while(has_unexplored_connections() && hasnot_highsec_connection() ) {
                explore_activeconnections();
            }
        }

        private void explore_active_highsecconnections_startside() {
            for(Systemdata activesystem: startsideparams.activesystems) {
                check_all_highsecconnections_startside(activesystem);
                if(is_route_complete()) break;
            }
            startsideparams.process_new_connections(findsaferoute);
        }

        private void explore_active_highsecconnections_endside() {
            for(Systemdata activesystem: endsideparams.activesystems) {
                check_all_highsecconnections_endside(activesystem);
                if(is_route_complete()) break;
            }
            endsideparams.process_new_connections(findsaferoute);
        }

        private void check_all_highsecconnections_startside(Systemdata activesystem) {
            for(Systemdata connection: activesystem.getHighsecConnectedsystems()) {
                check_connections_startside(activesystem, connection);
                if(is_route_complete()) break;
            }
        }

        private void check_all_highsecconnections_endside(Systemdata activesystem) {
            for(Systemdata connection: activesystem.getHighsecConnectedsystems()) {
                check_connections_endside(activesystem, connection);
                if(is_route_complete()) break;
            }
        }

        private void check_all_connections_startside(Systemdata activesystem) {
            for(Systemdata connection: activesystem.getConnectedsystems()) {
                startsideparams.highsec_connection_found |= connection.isAvailable(STARTROUTE) && connection.isHighsec();
                check_connections_startside(activesystem, connection);
                if(is_route_complete()) break;
            }
        }

        private void check_all_connections_endside(Systemdata activesystem) {
            for(Systemdata connection: activesystem.getConnectedsystems()) {
                endsideparams.highsec_connection_found |= connection.isAvailable(ENDROUTE) && connection.isHighsec();
                check_connections_endside(activesystem, connection);
                if(is_route_complete()) break;
            }
        }

        public Systemdata calculate_shortroute(long startpoint, long endpoint, ArrayList<Long> avoidlist) {
            this.startpoint = startpoint;
            this.endpoint = endpoint;
            this.avoidlist = avoidlist;
            this.findsaferoute = false;
            initialize();
            while(has_unexplored_connections())
                explore_activeconnections();
            if(is_route_complete())
                link_route_startside_endside();
            return endsideparams.system;
        }

        private void explore_activeconnections() {
            explore_activeconnections_startside();
            if(!is_route_complete())
                explore_activeconnections_endside();
            if(is_route_complete()) {
                startsideparams.reset_activesystems();
                endsideparams.reset_activesystems();
            }
        }

        private void explore_activeconnections_startside() {
            for(Systemdata activesystem: startsideparams.activesystems) {
                check_all_connections_startside(activesystem);
                if(is_route_complete()) break;
            }
            startsideparams.process_new_connections(findsaferoute);
        }

        private void explore_activeconnections_endside() {
            for(Systemdata activesystem: endsideparams.activesystems) {
                check_all_connections_endside(activesystem);
                if(is_route_complete()) break;
            }
            endsideparams.process_new_connections(findsaferoute);
        }

        private void initialize() {
            for(Systemdata systeminit: systemhash.values())
                systeminit.reset();
            for(Long systemid: avoidlist)
                systemhash.get(systemid).avoid();
            startsideparams.initialize(startpoint, STARTROUTE);
            endsideparams.initialize(endpoint, ENDROUTE);
        }

        private boolean is_route_complete() {
            return startsideparams.middlesystem!=null;
        }

        private boolean has_unexplored_connections() {
            return startsideparams.activesystems.size()>0 || endsideparams.activesystems.size()>0;
        }

        private void check_connections_startside(Systemdata system, Systemdata connection) {
            if(connection.isAvailable(STARTROUTE)) {
                add_connection_to_startside(connection, system);
            }
        }

        private void add_connection_to_startside(Systemdata connection, Systemdata system) {
            if(connection.hasConnected2Route(ENDROUTE)) {
                startsideparams.middlesystem = system;
                endsideparams.middlesystem = connection;
            } else {
                connection.setRoute(system);
                startsideparams.new_connections.add(connection);
            }
        }

        private void check_connections_endside(Systemdata system, Systemdata connection) {
            if(connection.isAvailable(ENDROUTE))
                add_connection_to_endside(connection, system);
        }

        private void add_connection_to_endside(Systemdata connection, Systemdata system) {
            if(connection.hasConnected2Route(STARTROUTE)) {
                startsideparams.middlesystem = connection;
                endsideparams.middlesystem = system;
            } else {
                connection.setRoute(system);
                endsideparams.new_connections.add(connection);
            }
        }

        private void link_route_startside_endside() {
            ArrayList<Long> route2 = reverse_route_endside();
            for(long systemid: route2)
                connect_route_endside_on_route_startside(systemid);
            endsideparams.system.setRoute(startsideparams.middlesystem);
        }

        private ArrayList<Long> reverse_route_endside() {
            ArrayList<Long> route2 = endsideparams.middlesystem.getRoute();
            Collections.reverse(route2);
            return route2;
        }

        private void connect_route_endside_on_route_startside(long systemid) {
            tempsystemdata = systemhash.get(systemid);
            tempsystemdata.reset();
            tempsystemdata.setRoute(startsideparams.middlesystem);
            startsideparams.middlesystem = tempsystemdata;
        }
    }
}
