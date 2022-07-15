package eve.conversion.json;

import data.conversion.JSONConversion;
import eve.logicentity.System;
import eve.searchentity.Systemsearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONSystemTest {
    
    public JSONSystemTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        System system = new System();
        ArrayList<System> systemlist = new ArrayList<>();
        systemlist.add(system);
        JSONArray jsonsystemarray = JSONSystem.toJSONArray(systemlist);
        JSONObject jsonsystem = (JSONObject)jsonsystemarray.get(0);
        system = JSONSystem.toSystem(jsonsystem);
        system = JSONSystem.initSystem(jsonsystem);
        JSONSystem.updateSystem(system, jsonsystem);
        Systemsearch search = new Systemsearch();
        JSONObject jsonsearch = JSONSystem.toJSON(search);
        jsonsearch.put("andor", 0);
        jsonsearch.put("maxresults", 0);
        jsonsearch.put("docount", false);
        jsonsearch.put("primarykeys", new JSONArray());
        jsonsearch.put("fields", new JSONObject());
        jsonsearch.put("keysearch", new JSONObject());
        search = JSONSystem.toSystemsearch(jsonsearch);
    }
    
//Custom code, do not change this line
    @Test
    public void test_defaultfunctionality_extrafields() {
        System system = new System();
        int expected_npc_kills = 20;
        system.setNpc_kills(expected_npc_kills);
        int expected_pod_kills = 5;
        system.setPod_kills(expected_pod_kills);
        int expected_ship_kills = 10;
        system.setShip_kills(expected_ship_kills);
        int expected_killmailcount = 8;
        system.setKillmailcount(expected_killmailcount);
        int expected_killmailgatecount = 5;
        system.setKillmailgatecount(expected_killmailgatecount);
        JSONObject expected_killmaildata = new JSONObject();
        system.setKillmaildata(expected_killmaildata);
        JSONObject json = JSONSystem.toJSON(system);
        int result_npc_kills = JSONConversion.getint(json, "npc_kills");
        int result_pod_kills = JSONConversion.getint(json, "pod_kills");
        int result_ship_kills = JSONConversion.getint(json, "ship_kills");
        int result_killmailcount = JSONConversion.getint(json, "killmailcount");
        int result_killmailgatecount = JSONConversion.getint(json, "killmailgatecount");
        JSONObject result_killmaildata = (JSONObject)json.get("killmaildata");
        Assert.assertEquals(expected_npc_kills, result_npc_kills);
        Assert.assertEquals(expected_pod_kills, result_pod_kills);
        Assert.assertEquals(expected_ship_kills, result_ship_kills);
        Assert.assertEquals(expected_killmailcount, result_killmailcount);
        Assert.assertEquals(expected_killmailgatecount, result_killmailgatecount);
        Assert.assertEquals(expected_killmaildata, result_killmaildata);
    }
//Custom code, do not change this line
}

