package eve.conversion.json;

import data.conversion.JSONConversion;
import eve.logicentity.Stargate;
import eve.searchentity.Stargatesearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONStargateTest {
    
    public JSONStargateTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        Stargate stargate = new Stargate();
        ArrayList<Stargate> stargatelist = new ArrayList<>();
        stargatelist.add(stargate);
        JSONArray jsonstargatearray = JSONStargate.toJSONArray(stargatelist);
        JSONObject jsonstargate = (JSONObject)jsonstargatearray.get(0);
        stargate = JSONStargate.toStargate(jsonstargate);
        stargate = JSONStargate.initStargate(jsonstargate);
        JSONStargate.updateStargate(stargate, jsonstargate);
        Stargatesearch search = new Stargatesearch();
        JSONObject jsonsearch = JSONStargate.toJSON(search);
        jsonsearch.put("andor", 0);
        jsonsearch.put("maxresults", 0);
        jsonsearch.put("docount", false);
        jsonsearch.put("primarykeys", new JSONArray());
        jsonsearch.put("fields", new JSONObject());
        jsonsearch.put("keysearch", new JSONObject());
        search = JSONStargate.toStargatesearch(jsonsearch);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

