package eve.conversion.json;

import data.conversion.JSONConversion;
import eve.logicentity.Station;
import eve.searchentity.Stationsearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONStationTest {
    
    public JSONStationTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        Station station = new Station();
        ArrayList<Station> stationlist = new ArrayList<>();
        stationlist.add(station);
        JSONArray jsonstationarray = JSONStation.toJSONArray(stationlist);
        JSONObject jsonstation = (JSONObject)jsonstationarray.get(0);
        station = JSONStation.toStation(jsonstation);
        station = JSONStation.initStation(jsonstation);
        JSONStation.updateStation(station, jsonstation);
        Stationsearch search = new Stationsearch();
        JSONObject jsonsearch = JSONStation.toJSON(search);
        jsonsearch.put("andor", 0);
        jsonsearch.put("maxresults", 0);
        jsonsearch.put("docount", false);
        jsonsearch.put("primarykeys", new JSONArray());
        jsonsearch.put("fields", new JSONObject());
        jsonsearch.put("keysearch", new JSONObject());
        search = JSONStation.toStationsearch(jsonsearch);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

