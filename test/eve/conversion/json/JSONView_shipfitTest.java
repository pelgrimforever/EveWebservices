package eve.conversion.json;

import data.conversion.JSONConversion;
import eve.logicview.View_shipfit;
import eve.searchentity.View_shipfitsearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONView_shipfitTest {
    
    public JSONView_shipfitTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        View_shipfit view_shipfit = new View_shipfit();
        ArrayList<View_shipfit> view_shipfitlist = new ArrayList<>();
        view_shipfitlist.add(view_shipfit);
        JSONArray jsonview_shipfitarray = JSONView_shipfit.toJSONArray(view_shipfitlist);
        JSONObject jsonview_shipfit = (JSONObject)jsonview_shipfitarray.get(0);
        view_shipfit = JSONView_shipfit.toView_shipfit(jsonview_shipfit);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

