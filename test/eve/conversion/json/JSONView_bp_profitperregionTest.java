package eve.conversion.json;

import data.conversion.JSONConversion;
import eve.logicview.View_bp_profitperregion;
import eve.searchentity.View_bp_profitperregionsearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONView_bp_profitperregionTest {
    
    public JSONView_bp_profitperregionTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        View_bp_profitperregion view_bp_profitperregion = new View_bp_profitperregion();
        ArrayList<View_bp_profitperregion> view_bp_profitperregionlist = new ArrayList<>();
        view_bp_profitperregionlist.add(view_bp_profitperregion);
        JSONArray jsonview_bp_profitperregionarray = JSONView_bp_profitperregion.toJSONArray(view_bp_profitperregionlist);
        JSONObject jsonview_bp_profitperregion = (JSONObject)jsonview_bp_profitperregionarray.get(0);
        view_bp_profitperregion = JSONView_bp_profitperregion.toView_bp_profitperregion(jsonview_bp_profitperregion);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

