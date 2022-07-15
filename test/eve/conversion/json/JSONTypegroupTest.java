package eve.conversion.json;

import data.conversion.JSONConversion;
import eve.logicentity.Typegroup;
import eve.searchentity.Typegroupsearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONTypegroupTest {
    
    public JSONTypegroupTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        Typegroup typegroup = new Typegroup();
        ArrayList<Typegroup> typegrouplist = new ArrayList<>();
        typegrouplist.add(typegroup);
        JSONArray jsontypegrouparray = JSONTypegroup.toJSONArray(typegrouplist);
        JSONObject jsontypegroup = (JSONObject)jsontypegrouparray.get(0);
        typegroup = JSONTypegroup.toTypegroup(jsontypegroup);
        typegroup = JSONTypegroup.initTypegroup(jsontypegroup);
        JSONTypegroup.updateTypegroup(typegroup, jsontypegroup);
        Typegroupsearch search = new Typegroupsearch();
        JSONObject jsonsearch = JSONTypegroup.toJSON(search);
        jsonsearch.put("andor", 0);
        jsonsearch.put("maxresults", 0);
        jsonsearch.put("docount", false);
        jsonsearch.put("primarykeys", new JSONArray());
        jsonsearch.put("fields", new JSONObject());
        jsonsearch.put("keysearch", new JSONObject());
        search = JSONTypegroup.toTypegroupsearch(jsonsearch);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

