package eve.conversion.json;

import data.conversion.JSONConversion;
import eve.logicview.View_shipfitorderselected;
import eve.searchentity.View_shipfitorderselectedsearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONView_shipfitorderselectedTest {
    
    public JSONView_shipfitorderselectedTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        View_shipfitorderselected view_shipfitorderselected = new View_shipfitorderselected();
        ArrayList<View_shipfitorderselected> view_shipfitorderselectedlist = new ArrayList<>();
        view_shipfitorderselectedlist.add(view_shipfitorderselected);
        JSONArray jsonview_shipfitorderselectedarray = JSONView_shipfitorderselected.toJSONArray(view_shipfitorderselectedlist);
        JSONObject jsonview_shipfitorderselected = (JSONObject)jsonview_shipfitorderselectedarray.get(0);
        view_shipfitorderselected = JSONView_shipfitorderselected.toView_shipfitorderselected(jsonview_shipfitorderselected);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

