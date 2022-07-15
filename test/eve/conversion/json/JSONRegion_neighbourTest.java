package eve.conversion.json;

import data.conversion.JSONConversion;
import eve.logicentity.Region_neighbour;
import eve.searchentity.Region_neighboursearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONRegion_neighbourTest {
    
    public JSONRegion_neighbourTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        Region_neighbour region_neighbour = new Region_neighbour();
        ArrayList<Region_neighbour> region_neighbourlist = new ArrayList<>();
        region_neighbourlist.add(region_neighbour);
        JSONArray jsonregion_neighbourarray = JSONRegion_neighbour.toJSONArray(region_neighbourlist);
        JSONObject jsonregion_neighbour = (JSONObject)jsonregion_neighbourarray.get(0);
        region_neighbour = JSONRegion_neighbour.toRegion_neighbour(jsonregion_neighbour);
        region_neighbour = JSONRegion_neighbour.initRegion_neighbour(jsonregion_neighbour);
        JSONRegion_neighbour.updateRegion_neighbour(region_neighbour, jsonregion_neighbour);
        Region_neighboursearch search = new Region_neighboursearch();
        JSONObject jsonsearch = JSONRegion_neighbour.toJSON(search);
        jsonsearch.put("andor", 0);
        jsonsearch.put("maxresults", 0);
        jsonsearch.put("docount", false);
        jsonsearch.put("primarykeys", new JSONArray());
        jsonsearch.put("fields", new JSONObject());
        jsonsearch.put("keysearch", new JSONObject());
        search = JSONRegion_neighbour.toRegion_neighboursearch(jsonsearch);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

