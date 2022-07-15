package eve.usecases.custom;

import db.SQLreader;
import eve.BusinessObject.service.RouteService;
import eve.data.Staticdata;
import eve.entity.pk.SystemPK;
import eve.logicentity.Stargate;
import eve.usecases.Stargate_usecases;
import eve.usecases.System_usecases;
import general.exception.DBException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Franky Laseure
 */
public class Loadroute_usecases {

    private RouteService routeservice = null;
    private Swagger_route_usecases swagger_route_usecases = new Swagger_route_usecases();
    private System_usecases system_usecases;
    private Stargate_usecases stargate_usecases;
    
    private Loadroute_parameters routeparameters;
    private ArrayList<Swagger_route_usecases.Systemkill_data> systemkills;
    private ArrayList<Swagger_route_usecases.EveGatecheck_data> evegatechecks;
    
    private SQLreader sqlreader;
    private long systemstart;
    private long systemend;
    
    public Loadroute_usecases() {
        sqlreader = new SQLreader();
        system_usecases = new System_usecases(true);
        stargate_usecases = new Stargate_usecases(true);
    }
    
    public ArrayList<eve.logicentity.System> Loadroute_withswagger_usecase(Loadroute_parameters routeparameters) throws DBException {
        this.routeparameters = routeparameters;
        ArrayList<Long> route_systemids = construct_route_withswagger();
        ArrayList<eve.logicentity.System> route = add_extra_route_information(route_systemids);
        return route;
    }

    public ArrayList<eve.logicentity.System> Loadroute_localservice_usecase(Loadroute_parameters routeparameters) throws DBException {
        if(routeservice==null)
            loadRouteservice();
        this.routeparameters = routeparameters;
        ArrayList<Long> route_systems = routeservice.getRoute(routeparameters);
        ArrayList<eve.logicentity.System> route = add_extra_route_information(route_systems);
        return route;
    }
    
    public void loadRouteservice() throws DBException {
        if(Staticdata.getRouteservice()==null)
            create_routeservice();
        else
            routeservice = Staticdata.getRouteservice();
    }

    private void create_routeservice() throws DBException {
        ArrayList<eve.logicentity.System> systems = system_usecases.get_all();
        ArrayList<Stargate> stargates = stargate_usecases.get_all();
        routeservice = new RouteService(systems, stargates);
        Staticdata.setRouteservice(routeservice);
    }

    private ArrayList<Long> construct_route_withswagger() {
        ArrayList<Long> route = initialize_route();
        ArrayList<Long> route_endpoints = create_route_endpoint_list();
        systemstart = routeparameters.getOrigin();
        route.add(systemstart);
        Iterator<Long> route_endpointsI = route_endpoints.iterator();
        while(route_endpointsI.hasNext())
            add_route_segment_from_previous_to_active_sytem(route_endpointsI.next(), route);
        return route;
    }

    private void add_route_segment_from_previous_to_active_sytem(long systemend, ArrayList<Long> route) {
        add_new_route_segment(route, systemstart, systemend);
        systemstart = systemend;
    }

    private ArrayList<Long> initialize_route() {
        ArrayList<Long> route = new ArrayList();
        return route;
    }

    private ArrayList<Long> create_route_endpoint_list() {
        ArrayList<Long> route_endpoints = new ArrayList();
        route_endpoints.addAll(routeparameters.getRoutesegmentlist());
        route_endpoints.add(routeparameters.getDestination());
        return route_endpoints;
    }
    
    
    private void add_new_route_segment(ArrayList<Long> route, long systemstart, long systemend) {
        ArrayList<Long> routesegment = swagger_route_usecases.getRoute_usecase(systemstart, systemend, routeparameters.getAvoidsystems(), routeparameters.isSecure());
        int l = routesegment.size();
        for(int i=1; i<l; i++)
            route.add(routesegment.get(i));
    }
    
    private ArrayList<eve.logicentity.System> add_extra_route_information(ArrayList<Long> route_systemids) throws DBException {
        ArrayList<eve.logicentity.System> route = new ArrayList<>();
        download_all_systems_information(route_systemids);
        Iterator<Long> gatechecksystemsI = route_systemids.iterator();
        while(gatechecksystemsI.hasNext())
            route.add(build_System_data(gatechecksystemsI.next()));        
        return route;
    }
    
    private void download_all_systems_information(ArrayList<Long> route_systemids) {
        systemkills = swagger_route_usecases.getSystemkills_usecase();
        evegatechecks = swagger_route_usecases.getGatecheck_for_systems_usecase(route_systemids);
    }
    
    private eve.logicentity.System build_System_data(long systemid) throws DBException {
        eve.logicentity.System system = system_usecases.get_system_by_primarykey(new SystemPK(systemid));
        Swagger_route_usecases.Systemkill_data systemkill = findSystemkill(systemid);
        if(systemkill!=null)
            add_systemkillinfo_to_system(system, systemkill);
        Swagger_route_usecases.EveGatecheck_data gatecheckkill = findGatecheckkill(systemid);
        if(gatecheckkill!=null)
            add_evegatecheckinfo_to_system(system, gatecheckkill);
        return system;
    }
    
    private void add_systemkillinfo_to_system(eve.logicentity.System system, Swagger_route_usecases.Systemkill_data systemkill) {
        system.setNpc_kills(systemkill.getNpc_kills());
        system.setPod_kills(systemkill.getPod_kills());
        system.setShip_kills(systemkill.getShip_kills());
    }
    
    private void add_evegatecheckinfo_to_system(eve.logicentity.System system, Swagger_route_usecases.EveGatecheck_data gatecheckkill) {
        system.setKillmailcount(gatecheckkill.getKillmails());
        system.setKillmailgatecount(gatecheckkill.getKillmailgatekills());
        system.setKillmaildata(gatecheckkill.getKillmaildata());
    }
    
    private Swagger_route_usecases.Systemkill_data findSystemkill(long systemid) {
        Iterator<Swagger_route_usecases.Systemkill_data> jsonsystemkillsI = systemkills.iterator();
        Swagger_route_usecases.Systemkill_data systemkill_data;
        while(jsonsystemkillsI.hasNext()) {
            systemkill_data = jsonsystemkillsI.next();
            if(systemid==systemkill_data.getSystem_id())
                return systemkill_data;
        }
        return null;
    }

    private Swagger_route_usecases.EveGatecheck_data findGatecheckkill(long systemid) {
        Iterator<Swagger_route_usecases.EveGatecheck_data> evegatechecksI = evegatechecks.iterator();
        Swagger_route_usecases.EveGatecheck_data evegatecheck_data;
        while(evegatechecksI.hasNext()) {
            evegatecheck_data = evegatechecksI.next();
            if(systemid==evegatecheck_data.getSystem_id()) {
                return evegatecheck_data;
            }
        }
        return null;
    }

}
