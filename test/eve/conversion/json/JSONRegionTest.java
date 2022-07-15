package eve.conversion.json;

import data.conversion.JSONConversion;
import eve.logicentity.Region;
import eve.searchentity.Regionsearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONRegionTest {
    
    public JSONRegionTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        Region region = new Region();
        ArrayList<Region> regionlist = new ArrayList<>();
        regionlist.add(region);
        JSONArray jsonregionarray = JSONRegion.toJSONArray(regionlist);
        JSONObject jsonregion = (JSONObject)jsonregionarray.get(0);
        region = JSONRegion.toRegion(jsonregion);
        region = JSONRegion.initRegion(jsonregion);
        JSONRegion.updateRegion(region, jsonregion);
        Regionsearch search = new Regionsearch();
        JSONObject jsonsearch = JSONRegion.toJSON(search);
        jsonsearch.put("andor", 0);
        jsonsearch.put("maxresults", 0);
        jsonsearch.put("docount", false);
        jsonsearch.put("primarykeys", new JSONArray());
        jsonsearch.put("fields", new JSONObject());
        jsonsearch.put("keysearch", new JSONObject());
        search = JSONRegion.toRegionsearch(jsonsearch);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

