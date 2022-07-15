package eve.BusinessObject.service;

import eve.entity.pk.StargatePK;
import eve.entity.pk.SystemPK;
import eve.logicentity.Stargate;
import eve.usecases.custom.Loadroute_parameters;
import java.util.ArrayList;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Franky Laseure
 */
public class RouteServiceTest {
    
    private long system100 = 100;
    private long system101 = 101;
    private long system102 = 102;
    private long system103 = 103;
    private long system104 = 104;
    private long system105 = 105;
    private long system106 = 106;
    private long system107 = 107;
    private long system108 = 108;
    private ArrayList<eve.logicentity.System> systems = buildsystems();
    private ArrayList<Stargate> stargates = buildstargates();
    private RouteService routeservice_mock = new RouteService(systems, stargates);

    private ArrayList<eve.logicentity.System> buildsystems() {
        ArrayList<eve.logicentity.System> systems = new ArrayList<>();
        addSystem(systems, system100, 0);
        addSystem(systems, system101, 0);
        addSystem(systems, system102, 1);
        addSystem(systems, system103, 1);
        addSystem(systems, system104, 1);
        addSystem(systems, system105, 1);
        addSystem(systems, system106, 1);
        addSystem(systems, system107, 0);
        addSystem(systems, system108, 0);
        return systems;
    }
    
    private void addSystem(ArrayList<eve.logicentity.System> systems, long systemid, double sec) {
        eve.logicentity.System system = new eve.logicentity.System(new SystemPK(systemid));
        system.setSecurity_status(sec);
        systems.add(system);
    }
    
    private ArrayList<Stargate> buildstargates() {
        ArrayList<Stargate> stargates = new ArrayList<>();
        long key = 0;
        addStargates(stargates, system100, system101, key);
        addStargates(stargates, system101, system102, key);
        addStargates(stargates, system102, system104, key);
        addStargates(stargates, system104, system106, key);
        addStargates(stargates, system106, system108, key);
        addStargates(stargates, system101, system103, key);
        addStargates(stargates, system103, system105, key);
        addStargates(stargates, system105, system104, key);
        addStargates(stargates, system105, system107, key);
        addStargates(stargates, system107, system108, key);
        addStargates(stargates, system101, system107, key);
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
    
    public RouteServiceTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_origin_destination_neighbours() {
        routeparameters = new Loadroute_parameters();
        routeparameters.setOrigin(system102);
        routeparameters.setDestination(system104);
        routeparameters.setAvoidsystems(new ArrayList<Long>());
        routeparameters.setRoutesegmentlist(new ArrayList<Long>());
        routeparameters.setSecure(true);                
        ArrayList<Long> systemids = routeservice_mock.getRoute(routeparameters);
        int expectedsize = 2;
        Assert.assertEquals(expectedsize, systemids.size());
    }
    
    @Test
    public void test_shortestroute_highsec() {
        routeparameters = new Loadroute_parameters();
        routeparameters.setOrigin(system101);
        routeparameters.setDestination(system106);
        routeparameters.setAvoidsystems(new ArrayList<Long>());
        routeparameters.setRoutesegmentlist(new ArrayList<Long>());
        routeparameters.setSecure(true);                
        ArrayList<Long> systemids = routeservice_mock.getRoute(routeparameters);
        int expectedsize = 4;
        Assert.assertEquals(expectedsize, systemids.size());
    }
    
    @Test
    public void test_shortestroute_perfer_highsec() {
        routeparameters = new Loadroute_parameters();
        routeparameters.setOrigin(system105);
        routeparameters.setDestination(system108);
        routeparameters.setAvoidsystems(new ArrayList<Long>());
        routeparameters.setRoutesegmentlist(new ArrayList<Long>());
        routeparameters.setSecure(true);                
        ArrayList<Long> systemids = routeservice_mock.getRoute(routeparameters);
        int expectedsize = 4;
        Assert.assertEquals(systemids.get(1).longValue(), system104);
        Assert.assertEquals(expectedsize, systemids.size());
    }
    
    @Test
    public void test_shortestroute_perfer_anysec() {
        routeparameters = new Loadroute_parameters();
        routeparameters.setOrigin(system105);
        routeparameters.setDestination(system108);
        routeparameters.setAvoidsystems(new ArrayList<Long>());
        routeparameters.setRoutesegmentlist(new ArrayList<Long>());
        routeparameters.setSecure(false);                
        ArrayList<Long> systemids = routeservice_mock.getRoute(routeparameters);
        int expectedsize = 3;
        Assert.assertEquals(systemids.get(1).longValue(), system107);
        Assert.assertEquals(expectedsize, systemids.size());
    }
    
    @Test
    public void test_shortestroute_perfer_anysec_starting_in_lowsec_ending_in_highsec() {
        routeparameters = new Loadroute_parameters();
        routeparameters.setOrigin(system100);
        routeparameters.setDestination(system108);
        routeparameters.setAvoidsystems(new ArrayList<Long>());
        routeparameters.setRoutesegmentlist(new ArrayList<Long>());
        routeparameters.setSecure(false);                
        ArrayList<Long> systemids = routeservice_mock.getRoute(routeparameters);
        int expectedsize = 4;
        Assert.assertEquals(systemids.get(2).longValue(), system107);
        Assert.assertEquals(expectedsize, systemids.size());
    }

    @Test
    public void test_shortestroute_perfer_highsec_starting_in_lowsec_ending_in_highsec() {
        routeparameters = new Loadroute_parameters();
        routeparameters.setOrigin(system100);
        routeparameters.setDestination(system108);
        routeparameters.setAvoidsystems(new ArrayList<Long>());
        routeparameters.setRoutesegmentlist(new ArrayList<Long>());
        routeparameters.setSecure(true);                
        ArrayList<Long> systemids = routeservice_mock.getRoute(routeparameters);
        int expectedsize = 6;
        Assert.assertEquals(systemids.get(2).longValue(), system102);
        Assert.assertEquals(expectedsize, systemids.size());
    }
    
}
