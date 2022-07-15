package eve.conversion.json;

import data.conversion.JSONConversion;
import eve.logicview.View_materialinputavg;
import eve.searchentity.View_materialinputavgsearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONView_materialinputavgTest {
    
    public JSONView_materialinputavgTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        View_materialinputavg view_materialinputavg = new View_materialinputavg();
        ArrayList<View_materialinputavg> view_materialinputavglist = new ArrayList<>();
        view_materialinputavglist.add(view_materialinputavg);
        JSONArray jsonview_materialinputavgarray = JSONView_materialinputavg.toJSONArray(view_materialinputavglist);
        JSONObject jsonview_materialinputavg = (JSONObject)jsonview_materialinputavgarray.get(0);
        view_materialinputavg = JSONView_materialinputavg.toView_materialinputavg(jsonview_materialinputavg);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

