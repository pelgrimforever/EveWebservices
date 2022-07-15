package eve.conversion.json;

import data.conversion.JSONConversion;
import eve.logicentity.Systemjumps;
import eve.searchentity.Systemjumpssearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONSystemjumpsTest {
    
    public JSONSystemjumpsTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        Systemjumps systemjumps = new Systemjumps();
        ArrayList<Systemjumps> systemjumpslist = new ArrayList<>();
        systemjumpslist.add(systemjumps);
        JSONArray jsonsystemjumpsarray = JSONSystemjumps.toJSONArray(systemjumpslist);
        JSONObject jsonsystemjumps = (JSONObject)jsonsystemjumpsarray.get(0);
        systemjumps = JSONSystemjumps.toSystemjumps(jsonsystemjumps);
        systemjumps = JSONSystemjumps.initSystemjumps(jsonsystemjumps);
        JSONSystemjumps.updateSystemjumps(systemjumps, jsonsystemjumps);
        Systemjumpssearch search = new Systemjumpssearch();
        JSONObject jsonsearch = JSONSystemjumps.toJSON(search);
        jsonsearch.put("andor", 0);
        jsonsearch.put("maxresults", 0);
        jsonsearch.put("docount", false);
        jsonsearch.put("primarykeys", new JSONArray());
        jsonsearch.put("fields", new JSONObject());
        jsonsearch.put("keysearch", new JSONObject());
        search = JSONSystemjumps.toSystemjumpssearch(jsonsearch);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

