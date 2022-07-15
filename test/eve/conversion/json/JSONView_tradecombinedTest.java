package eve.conversion.json;

import data.conversion.JSONConversion;
import eve.logicview.View_tradecombined;
import eve.searchentity.View_tradecombinedsearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONView_tradecombinedTest {
    
    public JSONView_tradecombinedTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        View_tradecombined view_tradecombined = new View_tradecombined();
        ArrayList<View_tradecombined> view_tradecombinedlist = new ArrayList<>();
        view_tradecombinedlist.add(view_tradecombined);
        JSONArray jsonview_tradecombinedarray = JSONView_tradecombined.toJSONArray(view_tradecombinedlist);
        JSONObject jsonview_tradecombined = (JSONObject)jsonview_tradecombinedarray.get(0);
        view_tradecombined = JSONView_tradecombined.toView_tradecombined(jsonview_tradecombined);
    }
    
//Custom code, do not change this line
    @Test
    public void test_defaultfunctionality_extrafields() {
        View_tradecombined view_tradecombined = new View_tradecombined();
        long expected_start_system = 100000;
        view_tradecombined.setStart_system(expected_start_system);
        int expected_start_system_jumps = 20;
        view_tradecombined.setStart_system_jumps(expected_start_system_jumps);
        JSONObject json = JSONView_tradecombined.toJSON(view_tradecombined);
        long result_start_system = JSONConversion.getlong(json, "start_system");
        int result_start_system_jumps = JSONConversion.getint(json, "start_system_jumps");
        Assert.assertEquals(expected_start_system, result_start_system);
        Assert.assertEquals(expected_start_system_jumps, result_start_system_jumps);
    }
//Custom code, do not change this line
}

