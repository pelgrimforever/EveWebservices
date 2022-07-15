package eve.conversion.json;

import data.conversion.JSONConversion;
import eve.logicentity.Shipfitmodule;
import eve.searchentity.Shipfitmodulesearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONShipfitmoduleTest {
    
    public JSONShipfitmoduleTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        Shipfitmodule shipfitmodule = new Shipfitmodule();
        ArrayList<Shipfitmodule> shipfitmodulelist = new ArrayList<>();
        shipfitmodulelist.add(shipfitmodule);
        JSONArray jsonshipfitmodulearray = JSONShipfitmodule.toJSONArray(shipfitmodulelist);
        JSONObject jsonshipfitmodule = (JSONObject)jsonshipfitmodulearray.get(0);
        shipfitmodule = JSONShipfitmodule.toShipfitmodule(jsonshipfitmodule);
        shipfitmodule = JSONShipfitmodule.initShipfitmodule(jsonshipfitmodule);
        JSONShipfitmodule.updateShipfitmodule(shipfitmodule, jsonshipfitmodule);
        Shipfitmodulesearch search = new Shipfitmodulesearch();
        JSONObject jsonsearch = JSONShipfitmodule.toJSON(search);
        jsonsearch.put("andor", 0);
        jsonsearch.put("maxresults", 0);
        jsonsearch.put("docount", false);
        jsonsearch.put("primarykeys", new JSONArray());
        jsonsearch.put("fields", new JSONObject());
        jsonsearch.put("keysearch", new JSONObject());
        search = JSONShipfitmodule.toShipfitmodulesearch(jsonsearch);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

