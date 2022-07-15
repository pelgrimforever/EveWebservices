package eve.usecases.custom;

import eve.entity.pk.SystemPK;
import eve.logicentity.Systemjumps;
import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Franky Laseure
 */
public class Multistoproutecalculator_usecasesTest {
    
    private eve.logicentity.System startsystem = new eve.logicentity.System(new SystemPK(0));
    private eve.logicentity.System endsystem = new eve.logicentity.System(new SystemPK(1)); 
    private ArrayList<Systemjumps> systemjumpslist = new ArrayList<>();
    private Multistoproutecalculator_usecases multistoproutecalculator_usecases = new Multistoproutecalculator_usecases();
    
    public Multistoproutecalculator_usecasesTest() {
    }
    
    @Before
    public void setUp() {
        addSystemjumps(0, 1, 20);
        addSystemjumps(0, 10, 12);
        addSystemjumps(10, 1, 13);
        addSystemjumps(0, 20, 20);
        addSystemjumps(20, 1, 10);
        addSystemjumps(10, 20, 5);
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
    public void calculateroute_nostops() {
        ArrayList<eve.logicentity.System> systemstops = new ArrayList<>();
        ArrayList<eve.logicentity.System> result = multistoproutecalculator_usecases.calculateroute(startsystem, endsystem, systemstops, systemjumpslist);
        int expectedroutelength = 2;
        Assert.assertEquals(result.size(), expectedroutelength);
    }
    
    @Test
    public void calculateroute_onestop() {
        ArrayList<eve.logicentity.System> systemstops = new ArrayList<>();
        eve.logicentity.System systemstop1 = new eve.logicentity.System(new SystemPK(10));
        systemstops.add(systemstop1);
        ArrayList<eve.logicentity.System> result = multistoproutecalculator_usecases.calculateroute(startsystem, endsystem, systemstops, systemjumpslist);
        int expectedroutelength = 3;
        Assert.assertEquals(result.size(), expectedroutelength);
        Assert.assertEquals(result.get(1).getPrimaryKey().getId(), 10);
    }
    
    @Test
    public void calculateroute_2stops() {
        ArrayList<eve.logicentity.System> systemstops = new ArrayList<>();
        eve.logicentity.System systemstop1 = new eve.logicentity.System(new SystemPK(10));
        systemstops.add(systemstop1);
        eve.logicentity.System systemstop2 = new eve.logicentity.System(new SystemPK(20));
        systemstops.add(systemstop2);
        ArrayList<eve.logicentity.System> result = multistoproutecalculator_usecases.calculateroute(startsystem, endsystem, systemstops, systemjumpslist);
        int expectedroutelength = 4;
        Assert.assertEquals(result.size(), expectedroutelength);
        Assert.assertEquals(result.get(1).getPrimaryKey().getId(), 10);
        Assert.assertEquals(result.get(2).getPrimaryKey().getId(), 20);
    }
}
