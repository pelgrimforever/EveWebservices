package eve.conversion.json;

import data.conversion.JSONConversion;
import eve.logicentity.Shipfitorderselected;
import eve.searchentity.Shipfitorderselectedsearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONShipfitorderselectedTest {
    
    public JSONShipfitorderselectedTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        Shipfitorderselected shipfitorderselected = new Shipfitorderselected();
        ArrayList<Shipfitorderselected> shipfitorderselectedlist = new ArrayList<>();
        shipfitorderselectedlist.add(shipfitorderselected);
        JSONArray jsonshipfitorderselectedarray = JSONShipfitorderselected.toJSONArray(shipfitorderselectedlist);
        JSONObject jsonshipfitorderselected = (JSONObject)jsonshipfitorderselectedarray.get(0);
        shipfitorderselected = JSONShipfitorderselected.toShipfitorderselected(jsonshipfitorderselected);
        shipfitorderselected = JSONShipfitorderselected.initShipfitorderselected(jsonshipfitorderselected);
        JSONShipfitorderselected.updateShipfitorderselected(shipfitorderselected, jsonshipfitorderselected);
        Shipfitorderselectedsearch search = new Shipfitorderselectedsearch();
        JSONObject jsonsearch = JSONShipfitorderselected.toJSON(search);
        jsonsearch.put("andor", 0);
        jsonsearch.put("maxresults", 0);
        jsonsearch.put("docount", false);
        jsonsearch.put("primarykeys", new JSONArray());
        jsonsearch.put("fields", new JSONObject());
        jsonsearch.put("keysearch", new JSONObject());
        search = JSONShipfitorderselected.toShipfitorderselectedsearch(jsonsearch);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

