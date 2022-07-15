package eve.conversion.json;

import data.conversion.JSONConversion;
import eve.logicentity.Alliance;
import eve.searchentity.Alliancesearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONAllianceTest {
    
    public JSONAllianceTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        Alliance alliance = new Alliance();
        ArrayList<Alliance> alliancelist = new ArrayList<>();
        alliancelist.add(alliance);
        JSONArray jsonalliancearray = JSONAlliance.toJSONArray(alliancelist);
        JSONObject jsonalliance = (JSONObject)jsonalliancearray.get(0);
        alliance = JSONAlliance.toAlliance(jsonalliance);
        alliance = JSONAlliance.initAlliance(jsonalliance);
        JSONAlliance.updateAlliance(alliance, jsonalliance);
        Alliancesearch search = new Alliancesearch();
        JSONObject jsonsearch = JSONAlliance.toJSON(search);
        jsonsearch.put("andor", 0);
        jsonsearch.put("maxresults", 0);
        jsonsearch.put("docount", false);
        jsonsearch.put("primarykeys", new JSONArray());
        jsonsearch.put("fields", new JSONObject());
        jsonsearch.put("keysearch", new JSONObject());
        search = JSONAlliance.toAlliancesearch(jsonsearch);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

