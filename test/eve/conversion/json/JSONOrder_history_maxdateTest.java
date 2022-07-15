package eve.conversion.json;

import data.conversion.JSONConversion;
import eve.logicview.Order_history_maxdate;
import eve.searchentity.Order_history_maxdatesearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONOrder_history_maxdateTest {
    
    public JSONOrder_history_maxdateTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        Order_history_maxdate order_history_maxdate = new Order_history_maxdate();
        ArrayList<Order_history_maxdate> order_history_maxdatelist = new ArrayList<>();
        order_history_maxdatelist.add(order_history_maxdate);
        JSONArray jsonorder_history_maxdatearray = JSONOrder_history_maxdate.toJSONArray(order_history_maxdatelist);
        JSONObject jsonorder_history_maxdate = (JSONObject)jsonorder_history_maxdatearray.get(0);
        order_history_maxdate = JSONOrder_history_maxdate.toOrder_history_maxdate(jsonorder_history_maxdate);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

