package eve.conversion.json;

import data.conversion.JSONConversion;
import eve.logicentity.Orders;
import eve.searchentity.Orderssearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONOrdersTest {
    
    public JSONOrdersTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        Orders orders = new Orders();
        ArrayList<Orders> orderslist = new ArrayList<>();
        orderslist.add(orders);
        JSONArray jsonordersarray = JSONOrders.toJSONArray(orderslist);
        JSONObject jsonorders = (JSONObject)jsonordersarray.get(0);
        orders = JSONOrders.toOrders(jsonorders);
        orders = JSONOrders.initOrders(jsonorders);
        JSONOrders.updateOrders(orders, jsonorders);
        Orderssearch search = new Orderssearch();
        JSONObject jsonsearch = JSONOrders.toJSON(search);
        jsonsearch.put("andor", 0);
        jsonsearch.put("maxresults", 0);
        jsonsearch.put("docount", false);
        jsonsearch.put("primarykeys", new JSONArray());
        jsonsearch.put("fields", new JSONObject());
        jsonsearch.put("keysearch", new JSONObject());
        search = JSONOrders.toOrderssearch(jsonsearch);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

