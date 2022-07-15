package eve.conversion.json;

import data.conversion.JSONConversion;
import eve.logicentity.Syssettings;
import eve.searchentity.Syssettingssearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONSyssettingsTest {
    
    public JSONSyssettingsTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        Syssettings syssettings = new Syssettings();
        ArrayList<Syssettings> syssettingslist = new ArrayList<>();
        syssettingslist.add(syssettings);
        JSONArray jsonsyssettingsarray = JSONSyssettings.toJSONArray(syssettingslist);
        JSONObject jsonsyssettings = (JSONObject)jsonsyssettingsarray.get(0);
        syssettings = JSONSyssettings.toSyssettings(jsonsyssettings);
        syssettings = JSONSyssettings.initSyssettings(jsonsyssettings);
        JSONSyssettings.updateSyssettings(syssettings, jsonsyssettings);
        Syssettingssearch search = new Syssettingssearch();
        JSONObject jsonsearch = JSONSyssettings.toJSON(search);
        jsonsearch.put("andor", 0);
        jsonsearch.put("maxresults", 0);
        jsonsearch.put("docount", false);
        jsonsearch.put("primarykeys", new JSONArray());
        jsonsearch.put("fields", new JSONObject());
        jsonsearch.put("keysearch", new JSONObject());
        search = JSONSyssettings.toSyssettingssearch(jsonsearch);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

