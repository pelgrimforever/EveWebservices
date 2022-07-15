package eve.conversion.json;

import data.conversion.JSONConversion;
import eve.logicentity.Market_group;
import eve.searchentity.Market_groupsearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONMarket_groupTest {
    
    public JSONMarket_groupTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        Market_group market_group = new Market_group();
        ArrayList<Market_group> market_grouplist = new ArrayList<>();
        market_grouplist.add(market_group);
        JSONArray jsonmarket_grouparray = JSONMarket_group.toJSONArray(market_grouplist);
        JSONObject jsonmarket_group = (JSONObject)jsonmarket_grouparray.get(0);
        market_group = JSONMarket_group.toMarket_group(jsonmarket_group);
        market_group = JSONMarket_group.initMarket_group(jsonmarket_group);
        JSONMarket_group.updateMarket_group(market_group, jsonmarket_group);
        Market_groupsearch search = new Market_groupsearch();
        JSONObject jsonsearch = JSONMarket_group.toJSON(search);
        jsonsearch.put("andor", 0);
        jsonsearch.put("maxresults", 0);
        jsonsearch.put("docount", false);
        jsonsearch.put("primarykeys", new JSONArray());
        jsonsearch.put("fields", new JSONObject());
        jsonsearch.put("keysearch", new JSONObject());
        search = JSONMarket_group.toMarket_groupsearch(jsonsearch);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

