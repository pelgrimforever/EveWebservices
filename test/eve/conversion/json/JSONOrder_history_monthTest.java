package eve.conversion.json;

import data.conversion.JSONConversion;
import eve.logicentity.Order_history_month;
import eve.searchentity.Order_history_monthsearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONOrder_history_monthTest {
    
    public JSONOrder_history_monthTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        Order_history_month order_history_month = new Order_history_month();
        ArrayList<Order_history_month> order_history_monthlist = new ArrayList<>();
        order_history_monthlist.add(order_history_month);
        JSONArray jsonorder_history_montharray = JSONOrder_history_month.toJSONArray(order_history_monthlist);
        JSONObject jsonorder_history_month = (JSONObject)jsonorder_history_montharray.get(0);
        order_history_month = JSONOrder_history_month.toOrder_history_month(jsonorder_history_month);
        order_history_month = JSONOrder_history_month.initOrder_history_month(jsonorder_history_month);
        JSONOrder_history_month.updateOrder_history_month(order_history_month, jsonorder_history_month);
        Order_history_monthsearch search = new Order_history_monthsearch();
        JSONObject jsonsearch = JSONOrder_history_month.toJSON(search);
        jsonsearch.put("andor", 0);
        jsonsearch.put("maxresults", 0);
        jsonsearch.put("docount", false);
        jsonsearch.put("primarykeys", new JSONArray());
        jsonsearch.put("fields", new JSONObject());
        jsonsearch.put("keysearch", new JSONObject());
        search = JSONOrder_history_month.toOrder_history_monthsearch(jsonsearch);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

