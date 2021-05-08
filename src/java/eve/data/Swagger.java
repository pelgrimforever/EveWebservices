/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eve.data;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import request.jsonrequest;

/**
 *
 * @author pelgrim
 */
public class Swagger {
    
    private static String URL_EVE = "https://esi.evetech.net/";
    private static String URL_Swaggerversion = "latest/";
    private static String URL_Datasource = "?datasource=tranquility";
    private static String URL_server = URL_EVE + URL_Swaggerversion;
    
    private static String URL_universe_graphics = URL_server + "universe/graphics/";
    private static String URL_universe_categories = URL_server + "universe/categories/";
    private static String URL_universe_groups = URL_server + "universe/groups/";
    private static String URL_market_groups = URL_server + "markets/groups/";
    private static String URL_universe_types = URL_server + "universe/types/";
    private static String URL_universe_races = URL_server + "universe/races/";
    private static String URL_universe_regions = URL_server + "universe/regions/";
    private static String URL_universe_names = URL_server + "universe/names/";
    private static String URL_universe_constellations = URL_server + "universe/constellations/";
    private static String URL_universe_systems = URL_server + "universe/systems/";
    private static String URL_universe_stations = URL_server + "universe/stations/";
    
    public static JSONArray getGraphics() {
        return jsonrequest.requestJSONArray(URL_universe_graphics + URL_Datasource);
    }

    public static JSONObject getGraphic(long graphic_id) {
        return jsonrequest.requestJSONObject(URL_universe_graphics + graphic_id + "/" + URL_Datasource);
    }

    public static JSONArray getCategories() {
        return jsonrequest.requestJSONArray(URL_universe_categories + URL_Datasource);
    }

    public static JSONObject getCategory(long category_id) {
        return jsonrequest.requestJSONObject(URL_universe_categories + category_id + "/" + URL_Datasource);
    }

    public static JSONArray getGroups() {
        return jsonrequest.requestJSONArray(URL_universe_groups + URL_Datasource);
    }

    public static JSONObject getGroup(long group_id) {
        return jsonrequest.requestJSONObject(URL_universe_groups + group_id + "/" + URL_Datasource);
    }

    public static JSONArray getMarketgroups() {
        return jsonrequest.requestJSONArray(URL_market_groups + URL_Datasource);
    }

    public static JSONObject getMarketgroup(long marketgroup_id) {
        return jsonrequest.requestJSONObject(URL_market_groups + marketgroup_id + "/" + URL_Datasource);
    }

    public static JSONArray getTypes() {
        return jsonrequest.requestJSONArray(URL_universe_types + URL_Datasource);
    }

    public static JSONObject getType(long type_id) {
        return jsonrequest.requestJSONObject(URL_universe_types + type_id + "/" + URL_Datasource);
    }

    public static JSONArray getRaces() {
        return jsonrequest.requestJSONArray(URL_universe_races + URL_Datasource);
    }
    
    public static JSONArray getRegions() {
        return jsonrequest.requestJSONArray(URL_universe_regions + URL_Datasource);
    }
    
    public static JSONArray getNames(String regions) {
        return jsonrequest.requestJSONArray(URL_universe_names + URL_Datasource, regions);
    }
    
    public static JSONArray getConstellations() {
        return jsonrequest.requestJSONArray(URL_universe_constellations + URL_Datasource);
    }

    public static JSONObject getConstellation(long constellation_id) {
        return jsonrequest.requestJSONObject(URL_universe_constellations + constellation_id + "/" + URL_Datasource);
    }
    
    public static JSONArray getSystems() {
        return jsonrequest.requestJSONArray(URL_universe_systems + URL_Datasource);
    }

    public static JSONObject getSystem(long system_id) {
        return jsonrequest.requestJSONObject(URL_universe_systems + system_id + "/" + URL_Datasource);
    }
    
    public static JSONArray getStations() {
        return jsonrequest.requestJSONArray(URL_universe_stations + URL_Datasource);
    }

    public static JSONObject getStation(long station_id) {
        return jsonrequest.requestJSONObject(URL_universe_stations + station_id + "/" + URL_Datasource);
    }
    
}
