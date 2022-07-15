package eve.usecases;

import db.SQLreader;
import eve.BusinessObject.Logic.BLshipfitorderselected;
import eve.BusinessObject.Logic.BLsystem;
import eve.BusinessObject.Logic.BLsystemjumps;
import eve.BusinessObject.Logic.BLview_system;
import eve.entity.pk.SystemPK;
import eve.logicentity.Systemjumps;
import eve.logicview.View_system;
import eve.usecases.custom.Multistoproutecalculator_usecases;
import general.exception.DBException;
import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.doReturn;
import org.mockito.MockitoAnnotations;

/**
 * @author Franky Laseure
 */
public class Shipfitorderselected_usecasesTest {
    
    private eve.logicentity.System startsystem = new eve.logicentity.System(new SystemPK(0));
    private eve.logicentity.System endsystem = new eve.logicentity.System(new SystemPK(1)); 
    private ArrayList<Systemjumps> systemjumpslist = new ArrayList<>();
    
    @Mock(name="swaggerorder")
    private SQLreader sqlreader_mock = new SQLreader();

    @Mock(name="blshipfitorderselected")
    private BLshipfitorderselected blshipfitorderselected_mock = new BLshipfitorderselected(sqlreader_mock);
    
    @Mock(name="blsystem")
    private BLsystem blsystem_mock = new BLsystem(sqlreader_mock);

    @Mock(name="blsystemjumps")
    private BLsystemjumps blsystemjumps_mock = new BLsystemjumps(sqlreader_mock);

    @Mock(name="blview_system")
    private BLview_system blview_system_mock = new BLview_system(sqlreader_mock);

    @InjectMocks
    private Shipfitorderselected_usecases shipfitorderselected_usecases;
    
    public Shipfitorderselected_usecasesTest() {
    }
    
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        addSystemjumps(0, 1, 20);
        addSystemjumps(0, 10, 12);
        addSystemjumps(10, 1, 13);
        addSystemjumps(0, 20, 20);
        addSystemjumps(20, 1, 10);
        addSystemjumps(10, 20, 5);
        try {
            View_system view_system = new View_system();
            doReturn(view_system).when(blview_system_mock).getView_systems(anyLong(), anyLong());
        }
        catch(DBException e) {
        }
    }

    private void addSystemjumps(long startsystemid, long endsystemid, int jumps) {
        Systemjumps systemjump = new Systemjumps(startsystemid, endsystemid);
        systemjump.setJumps(jumps);
        systemjumpslist.add(systemjump);
        systemjump = new Systemjumps(endsystemid, startsystemid);
        systemjump.setJumps(jumps);
        systemjumpslist.add(systemjump);
    }
    
    @Test
    public void calculateroute_usecase_nostops() {
        try {
            doReturn(startsystem).doReturn(endsystem).when(blsystem_mock).getSystem(any(SystemPK.class));
            doReturn(systemjumpslist).when(blsystemjumps_mock).getSystemjumps4shiporderselected(anyString(), anyLong(), anyLong());
            ArrayList<eve.logicview.View_system> result = shipfitorderselected_usecases.calculateroute_usecase("", 0, 1);
            int expectedroutelength = 2;
            Assert.assertEquals(result.size(), expectedroutelength);
        }
        catch(DBException e) {
        }
    }
    
    @Test
    public void calculateroute_usecase_onestop() {
        try {
            doReturn(startsystem).doReturn(endsystem).when(blsystem_mock).getSystem(any(SystemPK.class));
            doReturn(systemjumpslist).when(blsystemjumps_mock).getSystemjumps4shiporderselected(anyString(), anyLong(), anyLong());
            ArrayList<eve.logicentity.System> systemstops = new ArrayList<>();
            eve.logicentity.System systemstop1 = new eve.logicentity.System(new SystemPK(10));
            systemstops.add(systemstop1);
            doReturn(systemstops).when(blsystem_mock).getSystems4shipfitorderselected(anyString());
            ArrayList<eve.logicview.View_system> result = shipfitorderselected_usecases.calculateroute_usecase("", 0, 1);
            int expectedroutelength = 3;
            Assert.assertEquals(result.size(), expectedroutelength);
        }
        catch(DBException e) {
        }
    }
    
    @Test
    public void calculateroute_usecase_2stops() {
        try {
            doReturn(startsystem).doReturn(endsystem).when(blsystem_mock).getSystem(any(SystemPK.class));
            doReturn(systemjumpslist).when(blsystemjumps_mock).getSystemjumps4shiporderselected(anyString(), anyLong(), anyLong());
            ArrayList<eve.logicentity.System> systemstops = new ArrayList<>();
            eve.logicentity.System systemstop1 = new eve.logicentity.System(new SystemPK(10));
            systemstops.add(systemstop1);
            eve.logicentity.System systemstop2 = new eve.logicentity.System(new SystemPK(20));
            systemstops.add(systemstop2);
            doReturn(systemstops).when(blsystem_mock).getSystems4shipfitorderselected(anyString());
            ArrayList<eve.logicview.View_system> result = shipfitorderselected_usecases.calculateroute_usecase("", 0, 1);
            int expectedroutelength = 4;
            Assert.assertEquals(result.size(), expectedroutelength);
        }
        catch(DBException e) {
        }
    }
}
