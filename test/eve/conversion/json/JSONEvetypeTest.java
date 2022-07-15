package eve.conversion.json;

import data.conversion.JSONConversion;
import eve.logicentity.Evetype;
import eve.searchentity.Evetypesearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONEvetypeTest {
    
    public JSONEvetypeTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        Evetype evetype = new Evetype();
        ArrayList<Evetype> evetypelist = new ArrayList<>();
        evetypelist.add(evetype);
        JSONArray jsonevetypearray = JSONEvetype.toJSONArray(evetypelist);
        JSONObject jsonevetype = (JSONObject)jsonevetypearray.get(0);
        evetype = JSONEvetype.toEvetype(jsonevetype);
        evetype = JSONEvetype.initEvetype(jsonevetype);
        JSONEvetype.updateEvetype(evetype, jsonevetype);
        Evetypesearch search = new Evetypesearch();
        JSONObject jsonsearch = JSONEvetype.toJSON(search);
        jsonsearch.put("andor", 0);
        jsonsearch.put("maxresults", 0);
        jsonsearch.put("docount", false);
        jsonsearch.put("primarykeys", new JSONArray());
        jsonsearch.put("fields", new JSONObject());
        jsonsearch.put("keysearch", new JSONObject());
        search = JSONEvetype.toEvetypesearch(jsonsearch);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

