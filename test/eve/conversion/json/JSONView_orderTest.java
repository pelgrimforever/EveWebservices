package eve.conversion.json;

import data.conversion.JSONConversion;
import eve.logicview.View_order;
import eve.searchentity.View_ordersearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONView_orderTest {
    
    public JSONView_orderTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        View_order view_order = new View_order();
        ArrayList<View_order> view_orderlist = new ArrayList<>();
        view_orderlist.add(view_order);
        JSONArray jsonview_orderarray = JSONView_order.toJSONArray(view_orderlist);
        JSONObject jsonview_order = (JSONObject)jsonview_orderarray.get(0);
        view_order = JSONView_order.toView_order(jsonview_order);
    }
    
//Custom code, do not change this line
    @Test
    public void test_defaultfunctionality_extrafields() {
        View_order view_order = new View_order();
        int expected_start_system_jumps = 20;
        view_order.setStart_system_jumps(expected_start_system_jumps);
        int expected_start_system_jumpslowsec = 5;
        view_order.setStart_system_jumpslowsec(expected_start_system_jumpslowsec);
        int expected_start_system_jumpsnullsec = 10;
        view_order.setStart_system_jumpsnullsec(expected_start_system_jumpsnullsec);
        JSONObject json = JSONView_order.toJSON(view_order);
        int result_start_system_jumps = JSONConversion.getint(json, "startsystem_jumps");
        int result_start_system_jumpslowsec = JSONConversion.getint(json, "startsystem_jumpslowsec");
        int result_start_system_jumpsnullsec = JSONConversion.getint(json, "startsystem_jumpsnullsec");
        Assert.assertEquals(expected_start_system_jumps, result_start_system_jumps);
        Assert.assertEquals(expected_start_system_jumpslowsec, result_start_system_jumpslowsec);
        Assert.assertEquals(expected_start_system_jumpsnullsec, result_start_system_jumpsnullsec);
    }
//Custom code, do not change this line
}

