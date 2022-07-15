package eve.conversion.json;

import data.conversion.JSONConversion;
import eve.logicentity.Race;
import eve.searchentity.Racesearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONRaceTest {
    
    public JSONRaceTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        Race race = new Race();
        ArrayList<Race> racelist = new ArrayList<>();
        racelist.add(race);
        JSONArray jsonracearray = JSONRace.toJSONArray(racelist);
        JSONObject jsonrace = (JSONObject)jsonracearray.get(0);
        race = JSONRace.toRace(jsonrace);
        race = JSONRace.initRace(jsonrace);
        JSONRace.updateRace(race, jsonrace);
        Racesearch search = new Racesearch();
        JSONObject jsonsearch = JSONRace.toJSON(search);
        jsonsearch.put("andor", 0);
        jsonsearch.put("maxresults", 0);
        jsonsearch.put("docount", false);
        jsonsearch.put("primarykeys", new JSONArray());
        jsonsearch.put("fields", new JSONObject());
        jsonsearch.put("keysearch", new JSONObject());
        search = JSONRace.toRacesearch(jsonsearch);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

