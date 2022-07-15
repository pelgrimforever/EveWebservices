package eve.conversion.json;

import data.conversion.JSONConversion;
import eve.logicentity.Constellation_neighbour;
import eve.searchentity.Constellation_neighboursearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONConstellation_neighbourTest {
    
    public JSONConstellation_neighbourTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        Constellation_neighbour constellation_neighbour = new Constellation_neighbour();
        ArrayList<Constellation_neighbour> constellation_neighbourlist = new ArrayList<>();
        constellation_neighbourlist.add(constellation_neighbour);
        JSONArray jsonconstellation_neighbourarray = JSONConstellation_neighbour.toJSONArray(constellation_neighbourlist);
        JSONObject jsonconstellation_neighbour = (JSONObject)jsonconstellation_neighbourarray.get(0);
        constellation_neighbour = JSONConstellation_neighbour.toConstellation_neighbour(jsonconstellation_neighbour);
        constellation_neighbour = JSONConstellation_neighbour.initConstellation_neighbour(jsonconstellation_neighbour);
        JSONConstellation_neighbour.updateConstellation_neighbour(constellation_neighbour, jsonconstellation_neighbour);
        Constellation_neighboursearch search = new Constellation_neighboursearch();
        JSONObject jsonsearch = JSONConstellation_neighbour.toJSON(search);
        jsonsearch.put("andor", 0);
        jsonsearch.put("maxresults", 0);
        jsonsearch.put("docount", false);
        jsonsearch.put("primarykeys", new JSONArray());
        jsonsearch.put("fields", new JSONObject());
        jsonsearch.put("keysearch", new JSONObject());
        search = JSONConstellation_neighbour.toConstellation_neighboursearch(jsonsearch);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

