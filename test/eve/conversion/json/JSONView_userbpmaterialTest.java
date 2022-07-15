package eve.conversion.json;

import data.conversion.JSONConversion;
import eve.logicview.View_userbpmaterial;
import eve.searchentity.View_userbpmaterialsearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONView_userbpmaterialTest {
    
    public JSONView_userbpmaterialTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        View_userbpmaterial view_userbpmaterial = new View_userbpmaterial();
        ArrayList<View_userbpmaterial> view_userbpmateriallist = new ArrayList<>();
        view_userbpmateriallist.add(view_userbpmaterial);
        JSONArray jsonview_userbpmaterialarray = JSONView_userbpmaterial.toJSONArray(view_userbpmateriallist);
        JSONObject jsonview_userbpmaterial = (JSONObject)jsonview_userbpmaterialarray.get(0);
        view_userbpmaterial = JSONView_userbpmaterial.toView_userbpmaterial(jsonview_userbpmaterial);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

