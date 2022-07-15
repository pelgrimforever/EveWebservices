package eve.conversion.json;

import data.conversion.JSONConversion;
import eve.logicentity.Constellation;
import eve.searchentity.Constellationsearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONConstellationTest {
    
    public JSONConstellationTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        Constellation constellation = new Constellation();
        ArrayList<Constellation> constellationlist = new ArrayList<>();
        constellationlist.add(constellation);
        JSONArray jsonconstellationarray = JSONConstellation.toJSONArray(constellationlist);
        JSONObject jsonconstellation = (JSONObject)jsonconstellationarray.get(0);
        constellation = JSONConstellation.toConstellation(jsonconstellation);
        constellation = JSONConstellation.initConstellation(jsonconstellation);
        JSONConstellation.updateConstellation(constellation, jsonconstellation);
        Constellationsearch search = new Constellationsearch();
        JSONObject jsonsearch = JSONConstellation.toJSON(search);
        jsonsearch.put("andor", 0);
        jsonsearch.put("maxresults", 0);
        jsonsearch.put("docount", false);
        jsonsearch.put("primarykeys", new JSONArray());
        jsonsearch.put("fields", new JSONObject());
        jsonsearch.put("keysearch", new JSONObject());
        search = JSONConstellation.toConstellationsearch(jsonsearch);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

