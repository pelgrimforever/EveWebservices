package eve.conversion.json;

import data.conversion.JSONConversion;
import eve.logicentity.Station_service;
import eve.searchentity.Station_servicesearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONStation_serviceTest {
    
    public JSONStation_serviceTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        Station_service station_service = new Station_service();
        ArrayList<Station_service> station_servicelist = new ArrayList<>();
        station_servicelist.add(station_service);
        JSONArray jsonstation_servicearray = JSONStation_service.toJSONArray(station_servicelist);
        JSONObject jsonstation_service = (JSONObject)jsonstation_servicearray.get(0);
        station_service = JSONStation_service.toStation_service(jsonstation_service);
        station_service = JSONStation_service.initStation_service(jsonstation_service);
        JSONStation_service.updateStation_service(station_service, jsonstation_service);
        Station_servicesearch search = new Station_servicesearch();
        JSONObject jsonsearch = JSONStation_service.toJSON(search);
        jsonsearch.put("andor", 0);
        jsonsearch.put("maxresults", 0);
        jsonsearch.put("docount", false);
        jsonsearch.put("primarykeys", new JSONArray());
        jsonsearch.put("fields", new JSONObject());
        jsonsearch.put("keysearch", new JSONObject());
        search = JSONStation_service.toStation_servicesearch(jsonsearch);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

