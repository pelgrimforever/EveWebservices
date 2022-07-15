package eve.conversion.json;

import data.conversion.JSONConversion;
import eve.logicview.View_evetypes;
import eve.searchentity.View_evetypessearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONView_evetypesTest {
    
    public JSONView_evetypesTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        View_evetypes view_evetypes = new View_evetypes();
        ArrayList<View_evetypes> view_evetypeslist = new ArrayList<>();
        view_evetypeslist.add(view_evetypes);
        JSONArray jsonview_evetypesarray = JSONView_evetypes.toJSONArray(view_evetypeslist);
        JSONObject jsonview_evetypes = (JSONObject)jsonview_evetypesarray.get(0);
        view_evetypes = JSONView_evetypes.toView_evetypes(jsonview_evetypes);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

