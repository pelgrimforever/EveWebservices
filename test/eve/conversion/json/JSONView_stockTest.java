package eve.conversion.json;

import data.conversion.JSONConversion;
import eve.logicview.View_stock;
import eve.searchentity.View_stocksearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONView_stockTest {
    
    public JSONView_stockTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        View_stock view_stock = new View_stock();
        ArrayList<View_stock> view_stocklist = new ArrayList<>();
        view_stocklist.add(view_stock);
        JSONArray jsonview_stockarray = JSONView_stock.toJSONArray(view_stocklist);
        JSONObject jsonview_stock = (JSONObject)jsonview_stockarray.get(0);
        view_stock = JSONView_stock.toView_stock(jsonview_stock);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

