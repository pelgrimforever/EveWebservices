package eve.conversion.json;

import data.conversion.JSONConversion;
import eve.logicview.View_security_island_systemcount;
import eve.searchentity.View_security_island_systemcountsearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONView_security_island_systemcountTest {
    
    public JSONView_security_island_systemcountTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        View_security_island_systemcount view_security_island_systemcount = new View_security_island_systemcount();
        ArrayList<View_security_island_systemcount> view_security_island_systemcountlist = new ArrayList<>();
        view_security_island_systemcountlist.add(view_security_island_systemcount);
        JSONArray jsonview_security_island_systemcountarray = JSONView_security_island_systemcount.toJSONArray(view_security_island_systemcountlist);
        JSONObject jsonview_security_island_systemcount = (JSONObject)jsonview_security_island_systemcountarray.get(0);
        view_security_island_systemcount = JSONView_security_island_systemcount.toView_security_island_systemcount(jsonview_security_island_systemcount);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

