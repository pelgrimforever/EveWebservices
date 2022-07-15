package eve.conversion.json;

import data.conversion.JSONConversion;
import eve.logicview.View_activemodules;
import eve.searchentity.View_activemodulessearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONView_activemodulesTest {
    
    public JSONView_activemodulesTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        View_activemodules view_activemodules = new View_activemodules();
        ArrayList<View_activemodules> view_activemoduleslist = new ArrayList<>();
        view_activemoduleslist.add(view_activemodules);
        JSONArray jsonview_activemodulesarray = JSONView_activemodules.toJSONArray(view_activemoduleslist);
        JSONObject jsonview_activemodules = (JSONObject)jsonview_activemodulesarray.get(0);
        view_activemodules = JSONView_activemodules.toView_activemodules(jsonview_activemodules);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

