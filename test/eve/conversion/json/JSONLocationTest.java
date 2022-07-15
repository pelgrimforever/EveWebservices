package eve.conversion.json;

import data.conversion.JSONConversion;
import eve.logicentity.Location;
import eve.searchentity.Locationsearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONLocationTest {
    
    public JSONLocationTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        Location location = new Location();
        ArrayList<Location> locationlist = new ArrayList<>();
        locationlist.add(location);
        JSONArray jsonlocationarray = JSONLocation.toJSONArray(locationlist);
        JSONObject jsonlocation = (JSONObject)jsonlocationarray.get(0);
        location = JSONLocation.toLocation(jsonlocation);
        location = JSONLocation.initLocation(jsonlocation);
        JSONLocation.updateLocation(location, jsonlocation);
        Locationsearch search = new Locationsearch();
        JSONObject jsonsearch = JSONLocation.toJSON(search);
        jsonsearch.put("andor", 0);
        jsonsearch.put("maxresults", 0);
        jsonsearch.put("docount", false);
        jsonsearch.put("primarykeys", new JSONArray());
        jsonsearch.put("fields", new JSONObject());
        jsonsearch.put("keysearch", new JSONObject());
        search = JSONLocation.toLocationsearch(jsonsearch);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

