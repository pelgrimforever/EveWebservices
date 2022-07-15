package eve.conversion.json;

import data.conversion.JSONConversion;
import eve.logicentity.Userbp;
import eve.searchentity.Userbpsearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONUserbpTest {
    
    public JSONUserbpTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        Userbp userbp = new Userbp();
        ArrayList<Userbp> userbplist = new ArrayList<>();
        userbplist.add(userbp);
        JSONArray jsonuserbparray = JSONUserbp.toJSONArray(userbplist);
        JSONObject jsonuserbp = (JSONObject)jsonuserbparray.get(0);
        userbp = JSONUserbp.toUserbp(jsonuserbp);
        userbp = JSONUserbp.initUserbp(jsonuserbp);
        JSONUserbp.updateUserbp(userbp, jsonuserbp);
        Userbpsearch search = new Userbpsearch();
        JSONObject jsonsearch = JSONUserbp.toJSON(search);
        jsonsearch.put("andor", 0);
        jsonsearch.put("maxresults", 0);
        jsonsearch.put("docount", false);
        jsonsearch.put("primarykeys", new JSONArray());
        jsonsearch.put("fields", new JSONObject());
        jsonsearch.put("keysearch", new JSONObject());
        search = JSONUserbp.toUserbpsearch(jsonsearch);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

