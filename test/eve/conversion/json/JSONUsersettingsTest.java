package eve.conversion.json;

import data.conversion.JSONConversion;
import eve.logicentity.Usersettings;
import eve.searchentity.Usersettingssearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONUsersettingsTest {
    
    public JSONUsersettingsTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        Usersettings usersettings = new Usersettings();
        ArrayList<Usersettings> usersettingslist = new ArrayList<>();
        usersettingslist.add(usersettings);
        JSONArray jsonusersettingsarray = JSONUsersettings.toJSONArray(usersettingslist);
        JSONObject jsonusersettings = (JSONObject)jsonusersettingsarray.get(0);
        usersettings = JSONUsersettings.toUsersettings(jsonusersettings);
        usersettings = JSONUsersettings.initUsersettings(jsonusersettings);
        JSONUsersettings.updateUsersettings(usersettings, jsonusersettings);
        Usersettingssearch search = new Usersettingssearch();
        JSONObject jsonsearch = JSONUsersettings.toJSON(search);
        jsonsearch.put("andor", 0);
        jsonsearch.put("maxresults", 0);
        jsonsearch.put("docount", false);
        jsonsearch.put("primarykeys", new JSONArray());
        jsonsearch.put("fields", new JSONObject());
        jsonsearch.put("keysearch", new JSONObject());
        search = JSONUsersettings.toUsersettingssearch(jsonsearch);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

