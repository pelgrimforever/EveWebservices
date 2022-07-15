package eve.conversion.json;

import data.conversion.JSONConversion;
import eve.logicentity.Security_island;
import eve.searchentity.Security_islandsearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONSecurity_islandTest {
    
    public JSONSecurity_islandTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        Security_island security_island = new Security_island();
        ArrayList<Security_island> security_islandlist = new ArrayList<>();
        security_islandlist.add(security_island);
        JSONArray jsonsecurity_islandarray = JSONSecurity_island.toJSONArray(security_islandlist);
        JSONObject jsonsecurity_island = (JSONObject)jsonsecurity_islandarray.get(0);
        security_island = JSONSecurity_island.toSecurity_island(jsonsecurity_island);
        security_island = JSONSecurity_island.initSecurity_island(jsonsecurity_island);
        JSONSecurity_island.updateSecurity_island(security_island, jsonsecurity_island);
        Security_islandsearch search = new Security_islandsearch();
        JSONObject jsonsearch = JSONSecurity_island.toJSON(search);
        jsonsearch.put("andor", 0);
        jsonsearch.put("maxresults", 0);
        jsonsearch.put("docount", false);
        jsonsearch.put("primarykeys", new JSONArray());
        jsonsearch.put("fields", new JSONObject());
        jsonsearch.put("keysearch", new JSONObject());
        search = JSONSecurity_island.toSecurity_islandsearch(jsonsearch);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

