package eve.conversion.json;

import data.conversion.JSONConversion;
import eve.logicentity.Shipfit;
import eve.searchentity.Shipfitsearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONShipfitTest {
    
    public JSONShipfitTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        Shipfit shipfit = new Shipfit();
        ArrayList<Shipfit> shipfitlist = new ArrayList<>();
        shipfitlist.add(shipfit);
        JSONArray jsonshipfitarray = JSONShipfit.toJSONArray(shipfitlist);
        JSONObject jsonshipfit = (JSONObject)jsonshipfitarray.get(0);
        shipfit = JSONShipfit.toShipfit(jsonshipfit);
        shipfit = JSONShipfit.initShipfit(jsonshipfit);
        JSONShipfit.updateShipfit(shipfit, jsonshipfit);
        Shipfitsearch search = new Shipfitsearch();
        JSONObject jsonsearch = JSONShipfit.toJSON(search);
        jsonsearch.put("andor", 0);
        jsonsearch.put("maxresults", 0);
        jsonsearch.put("docount", false);
        jsonsearch.put("primarykeys", new JSONArray());
        jsonsearch.put("fields", new JSONObject());
        jsonsearch.put("keysearch", new JSONObject());
        search = JSONShipfit.toShipfitsearch(jsonsearch);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

