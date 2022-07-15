package eve.conversion.json;

import data.conversion.JSONConversion;
import eve.logicentity.Materialinput;
import eve.searchentity.Materialinputsearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONMaterialinputTest {
    
    public JSONMaterialinputTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        Materialinput materialinput = new Materialinput();
        ArrayList<Materialinput> materialinputlist = new ArrayList<>();
        materialinputlist.add(materialinput);
        JSONArray jsonmaterialinputarray = JSONMaterialinput.toJSONArray(materialinputlist);
        JSONObject jsonmaterialinput = (JSONObject)jsonmaterialinputarray.get(0);
        materialinput = JSONMaterialinput.toMaterialinput(jsonmaterialinput);
        materialinput = JSONMaterialinput.initMaterialinput(jsonmaterialinput);
        JSONMaterialinput.updateMaterialinput(materialinput, jsonmaterialinput);
        Materialinputsearch search = new Materialinputsearch();
        JSONObject jsonsearch = JSONMaterialinput.toJSON(search);
        jsonsearch.put("andor", 0);
        jsonsearch.put("maxresults", 0);
        jsonsearch.put("docount", false);
        jsonsearch.put("primarykeys", new JSONArray());
        jsonsearch.put("fields", new JSONObject());
        jsonsearch.put("keysearch", new JSONObject());
        search = JSONMaterialinput.toMaterialinputsearch(jsonsearch);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

