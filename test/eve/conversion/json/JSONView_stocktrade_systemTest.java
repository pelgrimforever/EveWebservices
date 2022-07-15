package eve.conversion.json;

import data.conversion.JSONConversion;
import eve.logicview.View_stocktrade_system;
import eve.searchentity.View_stocktrade_systemsearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONView_stocktrade_systemTest {
    
    public JSONView_stocktrade_systemTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        View_stocktrade_system view_stocktrade_system = new View_stocktrade_system();
        ArrayList<View_stocktrade_system> view_stocktrade_systemlist = new ArrayList<>();
        view_stocktrade_systemlist.add(view_stocktrade_system);
        JSONArray jsonview_stocktrade_systemarray = JSONView_stocktrade_system.toJSONArray(view_stocktrade_systemlist);
        JSONObject jsonview_stocktrade_system = (JSONObject)jsonview_stocktrade_systemarray.get(0);
        view_stocktrade_system = JSONView_stocktrade_system.toView_stocktrade_system(jsonview_stocktrade_system);
    }
    
//Custom code, do not change this line
    @Test
    public void test_defaultfunctionality_extrafields() {
        View_stocktrade_system view_stocktrade_system = new View_stocktrade_system();
        long expected_start_system = 100000;
        view_stocktrade_system.setStart_system(expected_start_system);
        int expected_start_system_jumps = 20;
        view_stocktrade_system.setStart_system_jumps(expected_start_system_jumps);
        JSONObject json = JSONView_stocktrade_system.toJSON(view_stocktrade_system);
        long result_start_system = JSONConversion.getlong(json, "start_system");
        int result_start_system_jumps = JSONConversion.getint(json, "start_system_jumps");
        Assert.assertEquals(expected_start_system, result_start_system);
        Assert.assertEquals(expected_start_system_jumps, result_start_system_jumps);
    }
//Custom code, do not change this line
}

