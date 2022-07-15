package eve.conversion.json;

import data.conversion.JSONConversion;
import eve.logicview.View_tradecombined_sell;
import eve.searchentity.View_tradecombined_sellsearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONView_tradecombined_sellTest {
    
    public JSONView_tradecombined_sellTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        View_tradecombined_sell view_tradecombined_sell = new View_tradecombined_sell();
        ArrayList<View_tradecombined_sell> view_tradecombined_selllist = new ArrayList<>();
        view_tradecombined_selllist.add(view_tradecombined_sell);
        JSONArray jsonview_tradecombined_sellarray = JSONView_tradecombined_sell.toJSONArray(view_tradecombined_selllist);
        JSONObject jsonview_tradecombined_sell = (JSONObject)jsonview_tradecombined_sellarray.get(0);
        view_tradecombined_sell = JSONView_tradecombined_sell.toView_tradecombined_sell(jsonview_tradecombined_sell);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

