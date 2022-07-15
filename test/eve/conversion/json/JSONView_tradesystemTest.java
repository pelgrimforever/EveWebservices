package eve.conversion.json;

import data.conversion.JSONConversion;
import eve.logicview.View_tradesystem;
import eve.searchentity.View_tradesystemsearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONView_tradesystemTest {
    
    public JSONView_tradesystemTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        View_tradesystem view_tradesystem = new View_tradesystem();
        ArrayList<View_tradesystem> view_tradesystemlist = new ArrayList<>();
        view_tradesystemlist.add(view_tradesystem);
        JSONArray jsonview_tradesystemarray = JSONView_tradesystem.toJSONArray(view_tradesystemlist);
        JSONObject jsonview_tradesystem = (JSONObject)jsonview_tradesystemarray.get(0);
        view_tradesystem = JSONView_tradesystem.toView_tradesystem(jsonview_tradesystem);
    }
    
//Custom code, do not change this line
    @Test
    public void test_defaultfunctionality_extrafields() {
        View_tradesystem view_tradesystem = new View_tradesystem();
        long expected_start_system = 100000;
        view_tradesystem.setStart_system(expected_start_system);
        int expected_start_system_jumps = 20;
        view_tradesystem.setStart_system_jumps(expected_start_system_jumps);
        JSONObject json = JSONView_tradesystem.toJSON(view_tradesystem);
        long result_start_system = JSONConversion.getlong(json, "start_system");
        int result_start_system_jumps = JSONConversion.getint(json, "start_system_jumps");
        Assert.assertEquals(expected_start_system, result_start_system);
        Assert.assertEquals(expected_start_system_jumps, result_start_system_jumps);
    }
//Custom code, do not change this line
}

