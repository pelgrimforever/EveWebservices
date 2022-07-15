package eve.conversion.json;

import data.conversion.JSONConversion;
import eve.logicview.View_shipfitorder;
import eve.searchentity.View_shipfitordersearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONView_shipfitorderTest {
    
    public JSONView_shipfitorderTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        View_shipfitorder view_shipfitorder = new View_shipfitorder();
        ArrayList<View_shipfitorder> view_shipfitorderlist = new ArrayList<>();
        view_shipfitorderlist.add(view_shipfitorder);
        JSONArray jsonview_shipfitorderarray = JSONView_shipfitorder.toJSONArray(view_shipfitorderlist);
        JSONObject jsonview_shipfitorder = (JSONObject)jsonview_shipfitorderarray.get(0);
        view_shipfitorder = JSONView_shipfitorder.toView_shipfitorder(jsonview_shipfitorder);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

