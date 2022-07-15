package eve.conversion.json;

import data.conversion.JSONConversion;
import eve.logicentity.Routetype;
import eve.searchentity.Routetypesearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONRoutetypeTest {
    
    public JSONRoutetypeTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        Routetype routetype = new Routetype();
        ArrayList<Routetype> routetypelist = new ArrayList<>();
        routetypelist.add(routetype);
        JSONArray jsonroutetypearray = JSONRoutetype.toJSONArray(routetypelist);
        JSONObject jsonroutetype = (JSONObject)jsonroutetypearray.get(0);
        routetype = JSONRoutetype.toRoutetype(jsonroutetype);
        routetype = JSONRoutetype.initRoutetype(jsonroutetype);
        JSONRoutetype.updateRoutetype(routetype, jsonroutetype);
        Routetypesearch search = new Routetypesearch();
        JSONObject jsonsearch = JSONRoutetype.toJSON(search);
        jsonsearch.put("andor", 0);
        jsonsearch.put("maxresults", 0);
        jsonsearch.put("docount", false);
        jsonsearch.put("primarykeys", new JSONArray());
        jsonsearch.put("fields", new JSONObject());
        jsonsearch.put("keysearch", new JSONObject());
        search = JSONRoutetype.toRoutetypesearch(jsonsearch);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

