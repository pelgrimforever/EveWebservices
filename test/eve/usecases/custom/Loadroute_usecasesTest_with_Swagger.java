package eve.usecases.custom;

import eve.entity.pk.SystemPK;
import eve.usecases.System_usecases;
import eve.usecases.custom.Swagger_route_usecases.Systemkill_data;
import general.exception.DBException;
import java.util.ArrayList;
import junit.framework.Assert;
import org.json.simple.JSONObject;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.anyLong;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.doReturn;
import org.mockito.MockitoAnnotations;

/**
 * @author Franky Laseure
 */
public class Loadroute_usecasesTest_with_Swagger {
    
    private long originid = 30002512;
    private long viaid = 1l;
    private long destinationid = 30002507;
    private Loadroute_parameters routeparameters;
    
    @Mock(name="swagger_route_usecases")
    private Swagger_route_usecases swagger_route_usecases_mock = new Swagger_route_usecases();
    
    @Mock(name="system_usecases")
    private System_usecases system_usecases_mock = new System_usecases(true);
    
    @InjectMocks
    Loadroute_usecases loadroute_usecases_mock = new Loadroute_usecases();
    
    public Loadroute_usecasesTest_with_Swagger() {
    }
    
    @Before
    public void setUp() {
        try {
            MockitoAnnotations.initMocks(this);
            ArrayList<Swagger_route_usecases.Systemkill_data> systemkills_list = new ArrayList<>();
            doReturn(systemkills_list).when(swagger_route_usecases_mock).getSystemkills_usecase();
            ArrayList<Swagger_route_usecases.EveGatecheck_data> gatecheck_list = new ArrayList<>();
            doReturn(gatecheck_list).when(swagger_route_usecases_mock).getGatecheck_for_systems_usecase(any(ArrayList.class));
            eve.logicentity.System system = new eve.logicentity.System();
            doReturn(system).when(system_usecases_mock).get_system_by_primarykey(any(SystemPK.class));
        }
        catch(DBException e) {
        }
    }

    @Test
    public void Loadroute_withswagger_usecase_test_origin_destination_neighbours() {
        ArrayList<Long> routesegment = new ArrayList<>();
        routesegment.add(originid);
        routesegment.add(destinationid);
        doReturn(routesegment).when(swagger_route_usecases_mock).getRoute_usecase(anyLong(), anyLong(), any(ArrayList.class), anyBoolean());

        routeparameters = new Loadroute_parameters();
        routeparameters.setOrigin(originid);
        routeparameters.setDestination(destinationid);
        routeparameters.setAvoidsystems(new ArrayList<Long>());
        routeparameters.setRoutesegmentlist(new ArrayList<Long>());
        routeparameters.setSecure(true);
        try {
            ArrayList<eve.logicentity.System> systems = loadroute_usecases_mock.Loadroute_withswagger_usecase(routeparameters);
            int expectedsize = 2;
            Assert.assertEquals(expectedsize, systems.size());
        }
        catch(DBException e) {
        }
    }
    
    @Test
    public void Loadroute_withswagger_usecase_test_origin_destination_via_3rdsystem() {
        ArrayList<Long> routesegment = new ArrayList<>();
        routesegment.add(originid);
        routesegment.add(destinationid);
        doReturn(routesegment).when(swagger_route_usecases_mock).getRoute_usecase(anyLong(), anyLong(), any(ArrayList.class), anyBoolean());

        routeparameters = new Loadroute_parameters();
        routeparameters.setOrigin(originid);
        routeparameters.setDestination(destinationid);
        routeparameters.setAvoidsystems(new ArrayList<Long>());
        ArrayList<Long> routesegmentlist = new ArrayList<Long>();
        routesegmentlist.add(viaid);
        routeparameters.setRoutesegmentlist(routesegmentlist);
        routeparameters.setSecure(true);
        try {
            ArrayList<eve.logicentity.System> systems = loadroute_usecases_mock.Loadroute_withswagger_usecase(routeparameters);
            int expectedsize = 3;
            Assert.assertEquals(expectedsize, systems.size());
        }
        catch(DBException e) {
        }
    }
    
    @Test
    public void Loadroute_withswagger_usecase_test_origin_destination_via_3rdsystem_that_hass_kills() {
        ArrayList<Long> routesegment1 = new ArrayList<>();
        routesegment1.add(originid);
        routesegment1.add(viaid);
        ArrayList<Long> routesegment2 = new ArrayList<>();
        routesegment2.add(viaid);
        routesegment2.add(destinationid);
        doReturn(routesegment1).doReturn(routesegment2).when(swagger_route_usecases_mock).getRoute_usecase(anyLong(), anyLong(), any(ArrayList.class), anyBoolean());
        
        ArrayList<Swagger_route_usecases.Systemkill_data> systemkills_list = new ArrayList<>();
        Swagger_route_usecases.Systemkill_data systemkill_data = swagger_route_usecases_mock.new Systemkill_data();
        systemkill_data.setSystem_id(viaid);
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
        try {
            ArrayList<eve.logicentity.System> systems = loadroute_usecases_mock.Loadroute_withswagger_usecase(routeparameters);
            eve.logicentity.System secondsystem = systems.get(1);
            Assert.assertEquals(secondsystem.getNpc_kills(), expectednpckills);
            Assert.assertEquals(secondsystem.getPod_kills(), expectedpodkills);
            Assert.assertEquals(secondsystem.getShip_kills(), expectedshipkills);
        }
        catch(DBException e) {
        }
    }
    
    @Test
    public void Loadroute_withswagger_usecase_test_origin_destination_via_3rdsystem_that_hass_gatecheckdata() {
        ArrayList<Long> routesegment1 = new ArrayList<>();
        routesegment1.add(originid);
        routesegment1.add(viaid);
        ArrayList<Long> routesegment2 = new ArrayList<>();
        routesegment2.add(viaid);
        routesegment2.add(destinationid);
        doReturn(routesegment1).doReturn(routesegment2).when(swagger_route_usecases_mock).getRoute_usecase(anyLong(), anyLong(), any(ArrayList.class), anyBoolean());
        
        ArrayList<Swagger_route_usecases.Systemkill_data> systemkills_list = new ArrayList<>();
        Swagger_route_usecases.Systemkill_data systemkill_data = swagger_route_usecases_mock.new Systemkill_data();
        systemkill_data.setSystem_id(viaid);
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
        evegatecheck_data.setSystem_id(viaid);
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
        try {
            ArrayList<eve.logicentity.System> systems = loadroute_usecases_mock.Loadroute_withswagger_usecase(routeparameters);
            eve.logicentity.System secondsystem = systems.get(1);
            Assert.assertEquals(secondsystem.getKillmaildata().toJSONString(), expectedkillmaildata.toJSONString());
            Assert.assertEquals(secondsystem.getKillmailgatecount(), expectedgatekills);
            Assert.assertEquals(secondsystem.getKillmailcount(), expectedkillmails);
        }
        catch(DBException e) {
        }
    }
}
