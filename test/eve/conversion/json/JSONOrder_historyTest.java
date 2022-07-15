package eve.conversion.json;

import data.conversion.JSONConversion;
import eve.logicentity.Order_history;
import eve.searchentity.Order_historysearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONOrder_historyTest {
    
    public JSONOrder_historyTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        Order_history order_history = new Order_history();
        ArrayList<Order_history> order_historylist = new ArrayList<>();
        order_historylist.add(order_history);
        JSONArray jsonorder_historyarray = JSONOrder_history.toJSONArray(order_historylist);
        JSONObject jsonorder_history = (JSONObject)jsonorder_historyarray.get(0);
        order_history = JSONOrder_history.toOrder_history(jsonorder_history);
        order_history = JSONOrder_history.initOrder_history(jsonorder_history);
        JSONOrder_history.updateOrder_history(order_history, jsonorder_history);
        Order_historysearch search = new Order_historysearch();
        JSONObject jsonsearch = JSONOrder_history.toJSON(search);
        jsonsearch.put("andor", 0);
        jsonsearch.put("maxresults", 0);
        jsonsearch.put("docount", false);
        jsonsearch.put("primarykeys", new JSONArray());
        jsonsearch.put("fields", new JSONObject());
        jsonsearch.put("keysearch", new JSONObject());
        search = JSONOrder_history.toOrder_historysearch(jsonsearch);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

