package eve.conversion.json;

import data.conversion.JSONConversion;
import eve.logicentity.Settings;
import eve.searchentity.Settingssearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONSettingsTest {
    
    public JSONSettingsTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        Settings settings = new Settings();
        ArrayList<Settings> settingslist = new ArrayList<>();
        settingslist.add(settings);
        JSONArray jsonsettingsarray = JSONSettings.toJSONArray(settingslist);
        JSONObject jsonsettings = (JSONObject)jsonsettingsarray.get(0);
        settings = JSONSettings.toSettings(jsonsettings);
        settings = JSONSettings.initSettings(jsonsettings);
        JSONSettings.updateSettings(settings, jsonsettings);
        Settingssearch search = new Settingssearch();
        JSONObject jsonsearch = JSONSettings.toJSON(search);
        jsonsearch.put("andor", 0);
        jsonsearch.put("maxresults", 0);
        jsonsearch.put("docount", false);
        jsonsearch.put("primarykeys", new JSONArray());
        jsonsearch.put("fields", new JSONObject());
        jsonsearch.put("keysearch", new JSONObject());
        search = JSONSettings.toSettingssearch(jsonsearch);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

