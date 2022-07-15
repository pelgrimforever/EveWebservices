package eve.conversion.json;

import data.conversion.JSONConversion;
import eve.logicview.View_evetype_order_history;
import eve.searchentity.View_evetype_order_historysearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONView_evetype_order_historyTest {
    
    public JSONView_evetype_order_historyTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        View_evetype_order_history view_evetype_order_history = new View_evetype_order_history();
        ArrayList<View_evetype_order_history> view_evetype_order_historylist = new ArrayList<>();
        view_evetype_order_historylist.add(view_evetype_order_history);
        JSONArray jsonview_evetype_order_historyarray = JSONView_evetype_order_history.toJSONArray(view_evetype_order_historylist);
        JSONObject jsonview_evetype_order_history = (JSONObject)jsonview_evetype_order_historyarray.get(0);
        view_evetype_order_history = JSONView_evetype_order_history.toView_evetype_order_history(jsonview_evetype_order_history);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

