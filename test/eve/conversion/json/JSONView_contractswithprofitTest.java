package eve.conversion.json;

import data.conversion.JSONConversion;
import eve.logicview.View_contractswithprofit;
import eve.searchentity.View_contractswithprofitsearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONView_contractswithprofitTest {
    
    public JSONView_contractswithprofitTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        View_contractswithprofit view_contractswithprofit = new View_contractswithprofit();
        ArrayList<View_contractswithprofit> view_contractswithprofitlist = new ArrayList<>();
        view_contractswithprofitlist.add(view_contractswithprofit);
        JSONArray jsonview_contractswithprofitarray = JSONView_contractswithprofit.toJSONArray(view_contractswithprofitlist);
        JSONObject jsonview_contractswithprofit = (JSONObject)jsonview_contractswithprofitarray.get(0);
        view_contractswithprofit = JSONView_contractswithprofit.toView_contractswithprofit(jsonview_contractswithprofit);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

