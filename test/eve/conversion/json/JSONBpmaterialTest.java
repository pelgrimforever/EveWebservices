package eve.conversion.json;

import data.conversion.JSONConversion;
import eve.logicentity.Bpmaterial;
import eve.searchentity.Bpmaterialsearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONBpmaterialTest {
    
    public JSONBpmaterialTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        Bpmaterial bpmaterial = new Bpmaterial();
        ArrayList<Bpmaterial> bpmateriallist = new ArrayList<>();
        bpmateriallist.add(bpmaterial);
        JSONArray jsonbpmaterialarray = JSONBpmaterial.toJSONArray(bpmateriallist);
        JSONObject jsonbpmaterial = (JSONObject)jsonbpmaterialarray.get(0);
        bpmaterial = JSONBpmaterial.toBpmaterial(jsonbpmaterial);
        bpmaterial = JSONBpmaterial.initBpmaterial(jsonbpmaterial);
        JSONBpmaterial.updateBpmaterial(bpmaterial, jsonbpmaterial);
        Bpmaterialsearch search = new Bpmaterialsearch();
        JSONObject jsonsearch = JSONBpmaterial.toJSON(search);
        jsonsearch.put("andor", 0);
        jsonsearch.put("maxresults", 0);
        jsonsearch.put("docount", false);
        jsonsearch.put("primarykeys", new JSONArray());
        jsonsearch.put("fields", new JSONObject());
        jsonsearch.put("keysearch", new JSONObject());
        search = JSONBpmaterial.toBpmaterialsearch(jsonsearch);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

