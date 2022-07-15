package eve.conversion.json;

import data.conversion.JSONConversion;
import eve.logicview.View_trade;
import eve.searchentity.View_tradesearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONView_tradeTest {
    
    public JSONView_tradeTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        View_trade view_trade = new View_trade();
        ArrayList<View_trade> view_tradelist = new ArrayList<>();
        view_tradelist.add(view_trade);
        JSONArray jsonview_tradearray = JSONView_trade.toJSONArray(view_tradelist);
        JSONObject jsonview_trade = (JSONObject)jsonview_tradearray.get(0);
        view_trade = JSONView_trade.toView_trade(jsonview_trade);
    }
    
//Custom code, do not change this line
    @Test
    public void test_defaultfunctionality_extrafields() {
        View_trade view_trade = new View_trade();
        long expected_start_system = 100000;
        view_trade.setStart_system(expected_start_system);
        int expected_start_system_jumps = 20;
        view_trade.setStart_system_jumps(expected_start_system_jumps);
        JSONObject json = JSONView_trade.toJSON(view_trade);
        long result_start_system = JSONConversion.getlong(json, "start_system");
        int result_start_system_jumps = JSONConversion.getint(json, "start_system_jumps");
        Assert.assertEquals(expected_start_system, result_start_system);
        Assert.assertEquals(expected_start_system_jumps, result_start_system_jumps);
    }
//Custom code, do not change this line
}

