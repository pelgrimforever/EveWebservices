package eve.conversion.json;

import data.conversion.JSONConversion;
import eve.logicview.View_bpmaterial;
import eve.searchentity.View_bpmaterialsearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONView_bpmaterialTest {
    
    public JSONView_bpmaterialTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        View_bpmaterial view_bpmaterial = new View_bpmaterial();
        ArrayList<View_bpmaterial> view_bpmateriallist = new ArrayList<>();
        view_bpmateriallist.add(view_bpmaterial);
        JSONArray jsonview_bpmaterialarray = JSONView_bpmaterial.toJSONArray(view_bpmateriallist);
        JSONObject jsonview_bpmaterial = (JSONObject)jsonview_bpmaterialarray.get(0);
        view_bpmaterial = JSONView_bpmaterial.toView_bpmaterial(jsonview_bpmaterial);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

