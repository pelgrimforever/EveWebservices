package eve.conversion.json;

import data.conversion.JSONConversion;
import eve.logicentity.Tradecombined;
import eve.searchentity.Tradecombinedsearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONTradecombinedTest {
    
    public JSONTradecombinedTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        Tradecombined tradecombined = new Tradecombined();
        ArrayList<Tradecombined> tradecombinedlist = new ArrayList<>();
        tradecombinedlist.add(tradecombined);
        JSONArray jsontradecombinedarray = JSONTradecombined.toJSONArray(tradecombinedlist);
        JSONObject jsontradecombined = (JSONObject)jsontradecombinedarray.get(0);
        tradecombined = JSONTradecombined.toTradecombined(jsontradecombined);
        tradecombined = JSONTradecombined.initTradecombined(jsontradecombined);
        JSONTradecombined.updateTradecombined(tradecombined, jsontradecombined);
        Tradecombinedsearch search = new Tradecombinedsearch();
        JSONObject jsonsearch = JSONTradecombined.toJSON(search);
        jsonsearch.put("andor", 0);
        jsonsearch.put("maxresults", 0);
        jsonsearch.put("docount", false);
        jsonsearch.put("primarykeys", new JSONArray());
        jsonsearch.put("fields", new JSONObject());
        jsonsearch.put("keysearch", new JSONObject());
        search = JSONTradecombined.toTradecombinedsearch(jsonsearch);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

