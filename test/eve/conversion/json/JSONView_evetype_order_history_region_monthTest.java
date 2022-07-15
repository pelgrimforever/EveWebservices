package eve.conversion.json;

import data.conversion.JSONConversion;
import eve.logicview.View_evetype_order_history_region_month;
import eve.searchentity.View_evetype_order_history_region_monthsearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONView_evetype_order_history_region_monthTest {
    
    public JSONView_evetype_order_history_region_monthTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        View_evetype_order_history_region_month view_evetype_order_history_region_month = new View_evetype_order_history_region_month();
        ArrayList<View_evetype_order_history_region_month> view_evetype_order_history_region_monthlist = new ArrayList<>();
        view_evetype_order_history_region_monthlist.add(view_evetype_order_history_region_month);
        JSONArray jsonview_evetype_order_history_region_montharray = JSONView_evetype_order_history_region_month.toJSONArray(view_evetype_order_history_region_monthlist);
        JSONObject jsonview_evetype_order_history_region_month = (JSONObject)jsonview_evetype_order_history_region_montharray.get(0);
        view_evetype_order_history_region_month = JSONView_evetype_order_history_region_month.toView_evetype_order_history_region_month(jsonview_evetype_order_history_region_month);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

