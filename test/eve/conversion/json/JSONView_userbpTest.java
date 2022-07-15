package eve.conversion.json;

import data.conversion.JSONConversion;
import eve.logicview.View_userbp;
import eve.searchentity.View_userbpsearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONView_userbpTest {
    
    public JSONView_userbpTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        View_userbp view_userbp = new View_userbp();
        ArrayList<View_userbp> view_userbplist = new ArrayList<>();
        view_userbplist.add(view_userbp);
        JSONArray jsonview_userbparray = JSONView_userbp.toJSONArray(view_userbplist);
        JSONObject jsonview_userbp = (JSONObject)jsonview_userbparray.get(0);
        view_userbp = JSONView_userbp.toView_userbp(jsonview_userbp);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

