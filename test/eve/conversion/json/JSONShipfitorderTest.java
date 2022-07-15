package eve.conversion.json;

import data.conversion.JSONConversion;
import eve.logicentity.Shipfitorder;
import eve.searchentity.Shipfitordersearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONShipfitorderTest {
    
    public JSONShipfitorderTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        Shipfitorder shipfitorder = new Shipfitorder();
        ArrayList<Shipfitorder> shipfitorderlist = new ArrayList<>();
        shipfitorderlist.add(shipfitorder);
        JSONArray jsonshipfitorderarray = JSONShipfitorder.toJSONArray(shipfitorderlist);
        JSONObject jsonshipfitorder = (JSONObject)jsonshipfitorderarray.get(0);
        shipfitorder = JSONShipfitorder.toShipfitorder(jsonshipfitorder);
        shipfitorder = JSONShipfitorder.initShipfitorder(jsonshipfitorder);
        JSONShipfitorder.updateShipfitorder(shipfitorder, jsonshipfitorder);
        Shipfitordersearch search = new Shipfitordersearch();
        JSONObject jsonsearch = JSONShipfitorder.toJSON(search);
        jsonsearch.put("andor", 0);
        jsonsearch.put("maxresults", 0);
        jsonsearch.put("docount", false);
        jsonsearch.put("primarykeys", new JSONArray());
        jsonsearch.put("fields", new JSONObject());
        jsonsearch.put("keysearch", new JSONObject());
        search = JSONShipfitorder.toShipfitordersearch(jsonsearch);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

