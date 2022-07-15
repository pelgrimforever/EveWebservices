package eve.conversion.json;

import data.conversion.JSONConversion;
import eve.logicentity.Json_orders;
import eve.searchentity.Json_orderssearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONJson_ordersTest {
    
    public JSONJson_ordersTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        Json_orders json_orders = new Json_orders();
        ArrayList<Json_orders> json_orderslist = new ArrayList<>();
        json_orderslist.add(json_orders);
        JSONArray jsonjson_ordersarray = JSONJson_orders.toJSONArray(json_orderslist);
        JSONObject jsonjson_orders = (JSONObject)jsonjson_ordersarray.get(0);
        json_orders = JSONJson_orders.toJson_orders(jsonjson_orders);
        json_orders = JSONJson_orders.initJson_orders(jsonjson_orders);
        JSONJson_orders.updateJson_orders(json_orders, jsonjson_orders);
        Json_orderssearch search = new Json_orderssearch();
        JSONObject jsonsearch = JSONJson_orders.toJSON(search);
        jsonsearch.put("andor", 0);
        jsonsearch.put("maxresults", 0);
        jsonsearch.put("docount", false);
        jsonsearch.put("primarykeys", new JSONArray());
        jsonsearch.put("fields", new JSONObject());
        jsonsearch.put("keysearch", new JSONObject());
        search = JSONJson_orders.toJson_orderssearch(jsonsearch);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

