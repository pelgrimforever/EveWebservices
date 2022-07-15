package eve.conversion.json;

import data.conversion.JSONConversion;
import eve.logicview.View_tradeorders;
import eve.searchentity.View_tradeorderssearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONView_tradeordersTest {
    
    public JSONView_tradeordersTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        View_tradeorders view_tradeorders = new View_tradeorders();
        ArrayList<View_tradeorders> view_tradeorderslist = new ArrayList<>();
        view_tradeorderslist.add(view_tradeorders);
        JSONArray jsonview_tradeordersarray = JSONView_tradeorders.toJSONArray(view_tradeorderslist);
        JSONObject jsonview_tradeorders = (JSONObject)jsonview_tradeordersarray.get(0);
        view_tradeorders = JSONView_tradeorders.toView_tradeorders(jsonview_tradeorders);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

