package eve.conversion.json;

import data.conversion.JSONConversion;
import eve.logicview.View_materialinput;
import eve.searchentity.View_materialinputsearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONView_materialinputTest {
    
    public JSONView_materialinputTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        View_materialinput view_materialinput = new View_materialinput();
        ArrayList<View_materialinput> view_materialinputlist = new ArrayList<>();
        view_materialinputlist.add(view_materialinput);
        JSONArray jsonview_materialinputarray = JSONView_materialinput.toJSONArray(view_materialinputlist);
        JSONObject jsonview_materialinput = (JSONObject)jsonview_materialinputarray.get(0);
        view_materialinput = JSONView_materialinput.toView_materialinput(jsonview_materialinput);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

