package eve.conversion.json;

import data.conversion.JSONConversion;
import eve.logicentity.Eveuser;
import eve.searchentity.Eveusersearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONEveuserTest {
    
    public JSONEveuserTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        Eveuser eveuser = new Eveuser();
        ArrayList<Eveuser> eveuserlist = new ArrayList<>();
        eveuserlist.add(eveuser);
        JSONArray jsoneveuserarray = JSONEveuser.toJSONArray(eveuserlist);
        JSONObject jsoneveuser = (JSONObject)jsoneveuserarray.get(0);
        eveuser = JSONEveuser.toEveuser(jsoneveuser);
        eveuser = JSONEveuser.initEveuser(jsoneveuser);
        JSONEveuser.updateEveuser(eveuser, jsoneveuser);
        Eveusersearch search = new Eveusersearch();
        JSONObject jsonsearch = JSONEveuser.toJSON(search);
        jsonsearch.put("andor", 0);
        jsonsearch.put("maxresults", 0);
        jsonsearch.put("docount", false);
        jsonsearch.put("primarykeys", new JSONArray());
        jsonsearch.put("fields", new JSONObject());
        jsonsearch.put("keysearch", new JSONObject());
        search = JSONEveuser.toEveusersearch(jsonsearch);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

