package eve.conversion.json;

import data.conversion.JSONConversion;
import eve.logicentity.Frontendpage_auth;
import eve.searchentity.Frontendpage_authsearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONFrontendpage_authTest {
    
    public JSONFrontendpage_authTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        Frontendpage_auth frontendpage_auth = new Frontendpage_auth();
        ArrayList<Frontendpage_auth> frontendpage_authlist = new ArrayList<>();
        frontendpage_authlist.add(frontendpage_auth);
        JSONArray jsonfrontendpage_autharray = JSONFrontendpage_auth.toJSONArray(frontendpage_authlist);
        JSONObject jsonfrontendpage_auth = (JSONObject)jsonfrontendpage_autharray.get(0);
        frontendpage_auth = JSONFrontendpage_auth.toFrontendpage_auth(jsonfrontendpage_auth);
        frontendpage_auth = JSONFrontendpage_auth.initFrontendpage_auth(jsonfrontendpage_auth);
        JSONFrontendpage_auth.updateFrontendpage_auth(frontendpage_auth, jsonfrontendpage_auth);
        Frontendpage_authsearch search = new Frontendpage_authsearch();
        JSONObject jsonsearch = JSONFrontendpage_auth.toJSON(search);
        jsonsearch.put("andor", 0);
        jsonsearch.put("maxresults", 0);
        jsonsearch.put("docount", false);
        jsonsearch.put("primarykeys", new JSONArray());
        jsonsearch.put("fields", new JSONObject());
        jsonsearch.put("keysearch", new JSONObject());
        search = JSONFrontendpage_auth.toFrontendpage_authsearch(jsonsearch);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

