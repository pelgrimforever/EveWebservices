package eve.conversion.json;

import data.conversion.JSONConversion;
import eve.logicview.View_system;
import eve.searchentity.View_systemsearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONView_systemTest {
    
    public JSONView_systemTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        View_system view_system = new View_system();
        ArrayList<View_system> view_systemlist = new ArrayList<>();
        view_systemlist.add(view_system);
        JSONArray jsonview_systemarray = JSONView_system.toJSONArray(view_systemlist);
        JSONObject jsonview_system = (JSONObject)jsonview_systemarray.get(0);
        view_system = JSONView_system.toView_system(jsonview_system);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

