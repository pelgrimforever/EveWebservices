package eve.conversion.json;

import data.conversion.JSONConversion;
import eve.logicview.View_order_region_evetype;
import eve.searchentity.View_order_region_evetypesearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONView_order_region_evetypeTest {
    
    public JSONView_order_region_evetypeTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        View_order_region_evetype view_order_region_evetype = new View_order_region_evetype();
        ArrayList<View_order_region_evetype> view_order_region_evetypelist = new ArrayList<>();
        view_order_region_evetypelist.add(view_order_region_evetype);
        JSONArray jsonview_order_region_evetypearray = JSONView_order_region_evetype.toJSONArray(view_order_region_evetypelist);
        JSONObject jsonview_order_region_evetype = (JSONObject)jsonview_order_region_evetypearray.get(0);
        view_order_region_evetype = JSONView_order_region_evetype.toView_order_region_evetype(jsonview_order_region_evetype);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

