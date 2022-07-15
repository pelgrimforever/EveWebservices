package eve.conversion.json;

import data.conversion.JSONConversion;
import eve.logicview.View_contractitem;
import eve.searchentity.View_contractitemsearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONView_contractitemTest {
    
    public JSONView_contractitemTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        View_contractitem view_contractitem = new View_contractitem();
        ArrayList<View_contractitem> view_contractitemlist = new ArrayList<>();
        view_contractitemlist.add(view_contractitem);
        JSONArray jsonview_contractitemarray = JSONView_contractitem.toJSONArray(view_contractitemlist);
        JSONObject jsonview_contractitem = (JSONObject)jsonview_contractitemarray.get(0);
        view_contractitem = JSONView_contractitem.toView_contractitem(jsonview_contractitem);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

