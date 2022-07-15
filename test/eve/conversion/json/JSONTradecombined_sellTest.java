package eve.conversion.json;

import data.conversion.JSONConversion;
import eve.logicentity.Tradecombined_sell;
import eve.searchentity.Tradecombined_sellsearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONTradecombined_sellTest {
    
    public JSONTradecombined_sellTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        Tradecombined_sell tradecombined_sell = new Tradecombined_sell();
        ArrayList<Tradecombined_sell> tradecombined_selllist = new ArrayList<>();
        tradecombined_selllist.add(tradecombined_sell);
        JSONArray jsontradecombined_sellarray = JSONTradecombined_sell.toJSONArray(tradecombined_selllist);
        JSONObject jsontradecombined_sell = (JSONObject)jsontradecombined_sellarray.get(0);
        tradecombined_sell = JSONTradecombined_sell.toTradecombined_sell(jsontradecombined_sell);
        tradecombined_sell = JSONTradecombined_sell.initTradecombined_sell(jsontradecombined_sell);
        JSONTradecombined_sell.updateTradecombined_sell(tradecombined_sell, jsontradecombined_sell);
        Tradecombined_sellsearch search = new Tradecombined_sellsearch();
        JSONObject jsonsearch = JSONTradecombined_sell.toJSON(search);
        jsonsearch.put("andor", 0);
        jsonsearch.put("maxresults", 0);
        jsonsearch.put("docount", false);
        jsonsearch.put("primarykeys", new JSONArray());
        jsonsearch.put("fields", new JSONObject());
        jsonsearch.put("keysearch", new JSONObject());
        search = JSONTradecombined_sell.toTradecombined_sellsearch(jsonsearch);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

