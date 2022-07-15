package eve.conversion.json;

import data.conversion.JSONConversion;
import eve.logicview.View_evetype_order_history_month;
import eve.searchentity.View_evetype_order_history_monthsearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONView_evetype_order_history_monthTest {
    
    public JSONView_evetype_order_history_monthTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        View_evetype_order_history_month view_evetype_order_history_month = new View_evetype_order_history_month();
        ArrayList<View_evetype_order_history_month> view_evetype_order_history_monthlist = new ArrayList<>();
        view_evetype_order_history_monthlist.add(view_evetype_order_history_month);
        JSONArray jsonview_evetype_order_history_montharray = JSONView_evetype_order_history_month.toJSONArray(view_evetype_order_history_monthlist);
        JSONObject jsonview_evetype_order_history_month = (JSONObject)jsonview_evetype_order_history_montharray.get(0);
        view_evetype_order_history_month = JSONView_evetype_order_history_month.toView_evetype_order_history_month(jsonview_evetype_order_history_month);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

