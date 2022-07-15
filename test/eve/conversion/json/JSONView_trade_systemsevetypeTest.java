package eve.conversion.json;

import data.conversion.JSONConversion;
import eve.logicview.View_trade_systemsevetype;
import eve.searchentity.View_trade_systemsevetypesearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONView_trade_systemsevetypeTest {
    
    public JSONView_trade_systemsevetypeTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        View_trade_systemsevetype view_trade_systemsevetype = new View_trade_systemsevetype();
        ArrayList<View_trade_systemsevetype> view_trade_systemsevetypelist = new ArrayList<>();
        view_trade_systemsevetypelist.add(view_trade_systemsevetype);
        JSONArray jsonview_trade_systemsevetypearray = JSONView_trade_systemsevetype.toJSONArray(view_trade_systemsevetypelist);
        JSONObject jsonview_trade_systemsevetype = (JSONObject)jsonview_trade_systemsevetypearray.get(0);
        view_trade_systemsevetype = JSONView_trade_systemsevetype.toView_trade_systemsevetype(jsonview_trade_systemsevetype);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

