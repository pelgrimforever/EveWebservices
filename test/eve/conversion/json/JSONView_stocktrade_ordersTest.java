package eve.conversion.json;

import data.conversion.JSONConversion;
import eve.logicview.View_stocktrade_orders;
import eve.searchentity.View_stocktrade_orderssearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONView_stocktrade_ordersTest {
    
    public JSONView_stocktrade_ordersTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        View_stocktrade_orders view_stocktrade_orders = new View_stocktrade_orders();
        ArrayList<View_stocktrade_orders> view_stocktrade_orderslist = new ArrayList<>();
        view_stocktrade_orderslist.add(view_stocktrade_orders);
        JSONArray jsonview_stocktrade_ordersarray = JSONView_stocktrade_orders.toJSONArray(view_stocktrade_orderslist);
        JSONObject jsonview_stocktrade_orders = (JSONObject)jsonview_stocktrade_ordersarray.get(0);
        view_stocktrade_orders = JSONView_stocktrade_orders.toView_stocktrade_orders(jsonview_stocktrade_orders);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

