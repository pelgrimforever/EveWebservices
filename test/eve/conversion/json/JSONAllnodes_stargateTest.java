package eve.conversion.json;

import data.conversion.JSONConversion;
import eve.logicentity.Allnodes_stargate;
import eve.searchentity.Allnodes_stargatesearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONAllnodes_stargateTest {
    
    public JSONAllnodes_stargateTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        Allnodes_stargate allnodes_stargate = new Allnodes_stargate();
        ArrayList<Allnodes_stargate> allnodes_stargatelist = new ArrayList<>();
        allnodes_stargatelist.add(allnodes_stargate);
        JSONArray jsonallnodes_stargatearray = JSONAllnodes_stargate.toJSONArray(allnodes_stargatelist);
        JSONObject jsonallnodes_stargate = (JSONObject)jsonallnodes_stargatearray.get(0);
        allnodes_stargate = JSONAllnodes_stargate.toAllnodes_stargate(jsonallnodes_stargate);
        allnodes_stargate = JSONAllnodes_stargate.initAllnodes_stargate(jsonallnodes_stargate);
        JSONAllnodes_stargate.updateAllnodes_stargate(allnodes_stargate, jsonallnodes_stargate);
        Allnodes_stargatesearch search = new Allnodes_stargatesearch();
        JSONObject jsonsearch = JSONAllnodes_stargate.toJSON(search);
        jsonsearch.put("andor", 0);
        jsonsearch.put("maxresults", 0);
        jsonsearch.put("docount", false);
        jsonsearch.put("primarykeys", new JSONArray());
        jsonsearch.put("fields", new JSONObject());
        jsonsearch.put("keysearch", new JSONObject());
        search = JSONAllnodes_stargate.toAllnodes_stargatesearch(jsonsearch);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

