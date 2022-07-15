package eve.conversion.json;

import data.conversion.JSONConversion;
import eve.logicentity.Corporation;
import eve.searchentity.Corporationsearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONCorporationTest {
    
    public JSONCorporationTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        Corporation corporation = new Corporation();
        ArrayList<Corporation> corporationlist = new ArrayList<>();
        corporationlist.add(corporation);
        JSONArray jsoncorporationarray = JSONCorporation.toJSONArray(corporationlist);
        JSONObject jsoncorporation = (JSONObject)jsoncorporationarray.get(0);
        corporation = JSONCorporation.toCorporation(jsoncorporation);
        corporation = JSONCorporation.initCorporation(jsoncorporation);
        JSONCorporation.updateCorporation(corporation, jsoncorporation);
        Corporationsearch search = new Corporationsearch();
        JSONObject jsonsearch = JSONCorporation.toJSON(search);
        jsonsearch.put("andor", 0);
        jsonsearch.put("maxresults", 0);
        jsonsearch.put("docount", false);
        jsonsearch.put("primarykeys", new JSONArray());
        jsonsearch.put("fields", new JSONObject());
        jsonsearch.put("keysearch", new JSONObject());
        search = JSONCorporation.toCorporationsearch(jsonsearch);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

