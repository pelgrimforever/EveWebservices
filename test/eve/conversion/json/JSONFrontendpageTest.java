package eve.conversion.json;

import data.conversion.JSONConversion;
import eve.logicentity.Frontendpage;
import eve.searchentity.Frontendpagesearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONFrontendpageTest {
    
    public JSONFrontendpageTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        Frontendpage frontendpage = new Frontendpage();
        ArrayList<Frontendpage> frontendpagelist = new ArrayList<>();
        frontendpagelist.add(frontendpage);
        JSONArray jsonfrontendpagearray = JSONFrontendpage.toJSONArray(frontendpagelist);
        JSONObject jsonfrontendpage = (JSONObject)jsonfrontendpagearray.get(0);
        frontendpage = JSONFrontendpage.toFrontendpage(jsonfrontendpage);
        frontendpage = JSONFrontendpage.initFrontendpage(jsonfrontendpage);
        JSONFrontendpage.updateFrontendpage(frontendpage, jsonfrontendpage);
        Frontendpagesearch search = new Frontendpagesearch();
        JSONObject jsonsearch = JSONFrontendpage.toJSON(search);
        jsonsearch.put("andor", 0);
        jsonsearch.put("maxresults", 0);
        jsonsearch.put("docount", false);
        jsonsearch.put("primarykeys", new JSONArray());
        jsonsearch.put("fields", new JSONObject());
        jsonsearch.put("keysearch", new JSONObject());
        search = JSONFrontendpage.toFrontendpagesearch(jsonsearch);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

