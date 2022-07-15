package eve.usecases.custom;

import eve.BusinessObject.service.RouteService;
import eve.entity.pk.StargatePK;
import eve.entity.pk.SystemPK;
import eve.logicentity.Stargate;
import eve.usecases.System_usecases;
import general.exception.DBException;
import java.util.ArrayList;
import junit.framework.Assert;
import org.json.simple.JSONObject;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.doReturn;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

/**
 * @author Franky Laseure
 */
public class Loadroute_usecasesTest_with_localdata {
    
    private long originid = 30002512;
    private long viaid = 1l;
    private long destinationid = 30002507;
    private ArrayList<eve.logicentity.System> systems = buildsystems();
    private ArrayList<Stargate> stargates = new ArrayList<>();

    private ArrayList<eve.logicentity.System> buildsystems() {
        ArrayList<eve.logicentity.System> systems = new ArrayList<>();
        eve.logicentity.System system = new eve.logicentity.System(new SystemPK(originid));
        system.setSecurity_status(1);
        systems.add(system);
        system = new eve.logicentity.System(new SystemPK(destinationid));
        system.setSecurity_status(1);
        systems.add(system);
        system = new eve.logicentity.System(new SystemPK(viaid));
        system.setSecurity_status(1);
        systems.add(system);
        return systems;
    }
    
    private ArrayList<Stargate> buildstargates() {
        ArrayList<Stargate> stargates = new ArrayList<>();
        long key = 0;
        addStargates(stargates, originid, destinationid, key);
        addStargates(stargates, originid, viaid, key);
        addStargates(stargates, viaid, destinationid, key);
        return stargates;
    }
    
    public void addStargates(ArrayList<Stargate> stargates, long systemid1, long systemid2, long key) {
        Stargate stargate = new Stargate(new StargatePK(key*2));
        stargate.setSystemsystemPK(new SystemPK(systemid1));
        stargate.setSystemto_systemPK(new SystemPK(systemid2));
        stargates.add(stargate);
        stargate = new Stargate(new StargatePK(key*2+1));
        stargate.setSystemsystemPK(new SystemPK(systemid2));
        stargate.setSystemto_systemPK(new SystemPK(systemid1));
        stargates.add(stargate);
    }

    private Loadroute_parameters routeparameters;
    
    @Mock(name="routeservice")
    private RouteService routeservice_mock = new RouteService(systems, stargates);
    
    @Mock(name="swagger_route_usecases")
    private Swagger_route_usecases swagger_route_usecases_mock = new Swagger_route_usecases();
    
    @Mock(name="system_usecases")
    private System_usecases system_usecases_mock = new System_usecases(true);
    
    @Spy
    @InjectMocks
    Loadroute_usecases loadroute_usecases_mock = new Loadroute_usecases();
    
    public Loadroute_usecasesTest_with_localdata() {
    }
    
    @Before
    public void setUp() {
        try {
            MockitoAnnotations.initMocks(this);
            Mockito.doNothing().when(loadroute_usecases_mock).loadRouteservice();
            
            ArrayList<Swagger_route_usecases.Systemkill_data> systemkills_list = new ArrayList<>();
            doReturn(systemkills_list).when(swagger_route_usecases_mock).getSystemkills_usecase();
            ArrayList<Swagger_route_usecases.EveGatecheck_data> gatecheck_list = new ArrayList<>();
            doReturn(gatecheck_list).when(swagger_route_usecases_mock).getGatecheck_for_systems_usecase(any(ArrayList.class));
            eve.logicentity.System system = new eve.logicentity.System(new SystemPK(1));
            doReturn(system).when(system_usecases_mock).get_system_by_primarykey(any(SystemPK.class));
        }
        catch(DBException e) {
        }
    }

    @Test
    public void test_origin_destination_neighbours() {
        ArrayList<Long> routesegment = new ArrayList<>();
        routesegment.add(originid);
        routesegment.add(destinationid);

        routeparameters = new Loadroute_parameters();
        routeparameters.setOrigin(originid);
        routeparameters.setDestination(destinationid);
        routeparameters.setAvoidsystems(new ArrayList<Long>());
        routeparameters.setRoutesegmentlist(new ArrayList<Long>());
        routeparameters.setSecure(true);
        doReturn(routesegment).when(routeservice_mock).getRoute(any(Loadroute_parameters.class));
        try {
            ArrayList<eve.logicentity.System> systems = loadroute_usecases_mock.Loadroute_localservice_usecase(routeparameters);
            int expectedsize = 2;
            Assert.assertEquals(expectedsize, systems.size());
        }
        catch(DBException e) {
        }
    }
    
    
    @Test
    public void test_origin_destination_that_hass_kills() {
        ArrayList<Long> routesegment = new ArrayList<>();
        routesegment.add(originid);
        routesegment.add(destinationid);
        
        ArrayList<Swagger_route_usecases.Systemkill_data> systemkills_list = new ArrayList<>();
        Swagger_route_usecases.Systemkill_data systemkill_data = swagger_route_usecases_mock.new Systemkill_data();
        systemkill_data.setSystem_id(originid);
        int expectednpckills = 10;
        systemkill_data.setNpc_kills(expectednpckills);
        int expectedpodkills = 2;
        systemkill_data.setPod_kills(expectedpodkills);
        int expectedshipkills = 1;
        systemkill_data.setShip_kills(expectedshipkills);
        systemkills_list.add(systemkill_data);
        doReturn(systemkills_list).when(swagger_route_usecases_mock).getSystemkills_usecase();
        routeparameters = new Loadroute_parameters();
        routeparameters.setOrigin(originid);
        routeparameters.setDestination(destinationid);
        routeparameters.setAvoidsystems(new ArrayList<Long>());
        ArrayList<Long> routesegmentlist = new ArrayList<Long>();
        routesegmentlist.add(viaid);
        routeparameters.setRoutesegmentlist(routesegmentlist);
        routeparameters.setSecure(true);
        doReturn(routesegment).when(routeservice_mock).getRoute(any(Loadroute_parameters.class));
        try {
            ArrayList<eve.logicentity.System> systems = loadroute_usecases_mock.Loadroute_localservice_usecase(routeparameters);
            eve.logicentity.System secondsystem = systems.get(1);
            Assert.assertEquals(secondsystem.getNpc_kills(), expectednpckills);
            Assert.assertEquals(secondsystem.getPod_kills(), expectedpodkills);
            Assert.assertEquals(secondsystem.getShip_kills(), expectedshipkills);
        }
        catch(DBException e) {
        }
    }
    
    @Test
    public void _test_origin_destination_that_hass_gatecheckdata() {
        ArrayList<Long> routesegment = new ArrayList<>();
        routesegment.add(originid);
        routesegment.add(destinationid);
        
        ArrayList<Swagger_route_usecases.Systemkill_data> systemkills_list = new ArrayList<>();
        Swagger_route_usecases.Systemkill_data systemkill_data = swagger_route_usecases_mock.new Systemkill_data();
        systemkill_data.setSystem_id(originid);
        int expectednpckills = 10;
        systemkill_data.setNpc_kills(expectednpckills);
        int expectedpodkills = 2;
        systemkill_data.setPod_kills(expectedpodkills);
        int expectedshipkills = 1;
        systemkill_data.setShip_kills(expectedshipkills);
        systemkills_list.add(systemkill_data);
        doReturn(systemkills_list).when(swagger_route_usecases_mock).getSystemkills_usecase();
        
        ArrayList<Swagger_route_usecases.EveGatecheck_data> evegatecheck_list = new ArrayList<>();
        Swagger_route_usecases.EveGatecheck_data evegatecheck_data = swagger_route_usecases_mock.new EveGatecheck_data();
        evegatecheck_data.setSystem_id(originid);
        JSONObject expectedkillmaildata = new JSONObject();
        expectedkillmaildata.put("dummy", "dummy");
        evegatecheck_data.setKillmaildata(expectedkillmaildata);
        int expectedgatekills = 1;
        evegatecheck_data.setKillmailgatekills(expectedgatekills);
        int expectedkillmails = 2;
        evegatecheck_data.setKillmails(expectedkillmails);
        evegatecheck_list.add(evegatecheck_data);
        doReturn(evegatecheck_list).when(swagger_route_usecases_mock).getGatecheck_for_systems_usecase(any(ArrayList.class));
        
        routeparameters = new Loadroute_parameters();
        routeparameters.setOrigin(originid);
        routeparameters.setDestination(destinationid);
        routeparameters.setAvoidsystems(new ArrayList<Long>());
        ArrayList<Long> routesegmentlist = new ArrayList<Long>();
        routesegmentlist.add(viaid);
        routeparameters.setRoutesegmentlist(routesegmentlist);
        routeparameters.setSecure(true);
        doReturn(routesegment).when(routeservice_mock).getRoute(any(Loadroute_parameters.class));
        try {
            ArrayList<eve.logicentity.System> systems = loadroute_usecases_mock.Loadroute_localservice_usecase(routeparameters);
            eve.logicentity.System secondsystem = systems.get(1);
            Assert.assertEquals(secondsystem.getKillmaildata().toJSONString(), expectedkillmaildata.toJSONString());
            Assert.assertEquals(secondsystem.getKillmailgatecount(), expectedgatekills);
            Assert.assertEquals(secondsystem.getKillmailcount(), expectedkillmails);
        }
        catch(DBException e) {
        }
    }

}
