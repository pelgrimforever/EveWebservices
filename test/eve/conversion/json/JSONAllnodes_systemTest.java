package eve.conversion.json;

import data.conversion.JSONConversion;
import eve.logicentity.Allnodes_system;
import eve.searchentity.Allnodes_systemsearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONAllnodes_systemTest {
    
    public JSONAllnodes_systemTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        Allnodes_system allnodes_system = new Allnodes_system();
        ArrayList<Allnodes_system> allnodes_systemlist = new ArrayList<>();
        allnodes_systemlist.add(allnodes_system);
        JSONArray jsonallnodes_systemarray = JSONAllnodes_system.toJSONArray(allnodes_systemlist);
        JSONObject jsonallnodes_system = (JSONObject)jsonallnodes_systemarray.get(0);
        allnodes_system = JSONAllnodes_system.toAllnodes_system(jsonallnodes_system);
        allnodes_system = JSONAllnodes_system.initAllnodes_system(jsonallnodes_system);
        JSONAllnodes_system.updateAllnodes_system(allnodes_system, jsonallnodes_system);
        Allnodes_systemsearch search = new Allnodes_systemsearch();
        JSONObject jsonsearch = JSONAllnodes_system.toJSON(search);
        jsonsearch.put("andor", 0);
        jsonsearch.put("maxresults", 0);
        jsonsearch.put("docount", false);
        jsonsearch.put("primarykeys", new JSONArray());
        jsonsearch.put("fields", new JSONObject());
        jsonsearch.put("keysearch", new JSONObject());
        search = JSONAllnodes_system.toAllnodes_systemsearch(jsonsearch);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

