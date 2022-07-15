package eve.conversion.json;

import data.conversion.JSONConversion;
import eve.logicentity.Faction;
import eve.searchentity.Factionsearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONFactionTest {
    
    public JSONFactionTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        Faction faction = new Faction();
        ArrayList<Faction> factionlist = new ArrayList<>();
        factionlist.add(faction);
        JSONArray jsonfactionarray = JSONFaction.toJSONArray(factionlist);
        JSONObject jsonfaction = (JSONObject)jsonfactionarray.get(0);
        faction = JSONFaction.toFaction(jsonfaction);
        faction = JSONFaction.initFaction(jsonfaction);
        JSONFaction.updateFaction(faction, jsonfaction);
        Factionsearch search = new Factionsearch();
        JSONObject jsonsearch = JSONFaction.toJSON(search);
        jsonsearch.put("andor", 0);
        jsonsearch.put("maxresults", 0);
        jsonsearch.put("docount", false);
        jsonsearch.put("primarykeys", new JSONArray());
        jsonsearch.put("fields", new JSONObject());
        jsonsearch.put("keysearch", new JSONObject());
        search = JSONFaction.toFactionsearch(jsonsearch);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

