/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eve.data;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import request.jsonrequest;

/**
 *
 * @author pelgrim
 */
public class Swagger {
    
    public static final long EVE_CONST_FACTION_UNKNOWN = 500021;
    public static final double EVE_HIGHSEC_LIMIT = 0.45;
    
    private static final String URL_EVE = "https://esi.evetech.net/";
    private static final String URL_Swaggerversion = "latest/";
    private static final String URL_Datasource = "?datasource=tranquility";
    private static final String URL_server = URL_EVE + URL_Swaggerversion;
    
    //general REST parts
    private static final String REST_page = "&page=";
    private static final String REST_type = "&type_id=";
    private static final String REST_avoid = "&avoid=";
    private static final String REST_flag = "&flag=";
    
    //universe
    private static final String URL_universe_graphics = URL_server + "universe/graphics/";
    private static final String URL_universe_categories = URL_server + "universe/categories/";
    private static final String URL_universe_groups = URL_server + "universe/groups/";
    private static final String URL_market_groups = URL_server + "markets/groups/";
    private static final String URL_universe_types = URL_server + "universe/types/";
    private static final String URL_universe_factions = URL_server + "universe/factions/";
    private static final String URL_universe_races = URL_server + "universe/races/";
    private static final String URL_universe_regions = URL_server + "universe/regions/";
    private static final String URL_universe_names = URL_server + "universe/names/";
    private static final String URL_universe_constellations = URL_server + "universe/constellations/";
    private static final String URL_universe_systems = URL_server + "universe/systems/";
    private static final String URL_universe_stargates = URL_server + "universe/stargates/";
    private static final String URL_universe_stations = URL_server + "universe/stations/";
    private static final String URL_corporations_npccorps = URL_server + "corporations/npccorps/";
    private static final String URL_corporations_corporations = URL_server + "corporations/";
    private static final String URL_alliances_alliances = URL_server + "alliances/";
    private static final String URL_universe_systemkills = URL_server + "universe/system_kills/";
    
    //market data
    private static final String URL_markets = URL_server + "markets/";
    private static final String REST_market_orders = "/orders/";
    private static final String REST_market_history = "/history/";
    
    //market data
    private static final String URL_routes = URL_server + "route/";
    
    //static data
    private static final String URL_flag_shortest = "shortest";
    
    //external sites
    private static final String URL_eve_gatecheck = "https://eve-gatecheck.space/eve/get_kills.php?systems=";

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

    public static JSONArray getFactions() {
        return jsonrequest.requestJSONArray(URL_universe_factions + URL_Datasource);
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
    
    public static JSONObject getStargate(long stargate_id) {
        return jsonrequest.requestJSONObject(URL_universe_stargates + stargate_id + "/" + URL_Datasource);
    }
    
    public static JSONArray getStations() {
        return jsonrequest.requestJSONArray(URL_universe_stations + URL_Datasource);
    }

    public static JSONObject getStation(long station_id) {
        return jsonrequest.requestJSONObject(URL_universe_stations + station_id + "/" + URL_Datasource);
    }
    
    public static JSONArray getNpccorps() {
        return jsonrequest.requestJSONArray(URL_corporations_npccorps + URL_Datasource);
    }

    public static JSONObject getCorporation(long corporation_id) {
        return jsonrequest.requestJSONObject(URL_corporations_corporations + corporation_id + "/" + URL_Datasource);
    }
    
    public static JSONArray getAlliances() {
        return jsonrequest.requestJSONArray(URL_alliances_alliances + URL_Datasource);
    }

    public static JSONObject getAlliance(long alliance_id) {
        return jsonrequest.requestJSONObject(URL_alliances_alliances + alliance_id + "/" + URL_Datasource);
    }

    //market data
    
    public static JSONArray getMarket_region_orders(long region_id, int pagenr) {
        JSONArray page;
        try {
            page = jsonrequest.requestJSONArray(URL_markets + region_id + REST_market_orders + URL_Datasource + REST_page + pagenr);
        }
        catch(Exception e) {
            page = new JSONArray();
        }
        return page;
    }
    
    public static JSONArray getMarket_history(long region_id, long type_id) {
        JSONArray history;
        try {
            history = jsonrequest.requestJSONArray(URL_markets + region_id + REST_market_history + URL_Datasource + REST_type + type_id);
        }
        catch(Exception e) {
            history = new JSONArray();
        }
        return history;
    }
    
    public static JSONArray getRoute(long origin, long destination, ArrayList<Long> avoidsystems) {
        JSONArray route;
        try {
            String avoid = "";
            if(avoidsystems!=null && avoidsystems.size()>0) {
                avoid = REST_avoid;
                int l = avoidsystems.size();
                for(int i=0; i<l; i++) {
                    if(i>0) {
                        avoid += ",";
                    }
                    avoid += avoidsystems.get(i);
                }
            }
            route = jsonrequest.requestJSONArray(URL_routes + origin + "/" + destination + URL_Datasource + avoid + REST_flag + URL_flag_shortest);
        }
        catch(Exception e) {
            route = new JSONArray();
        }
        return route;
    }
    
    public static JSONArray getSystemkills() {
        return jsonrequest.requestJSONArray(URL_universe_systemkills + URL_Datasource);
    }

    public static JSONObject getEveGatecheck(ArrayList systems) {
        String systemlist = "";
        if(systems!=null && systems.size()>0) {
            int l = systems.size();
            for(int i=0; i<l; i++) {
                if(i>0) {
                    systemlist += ",";
                }
                systemlist += systems.get(i);
            }
        }
        return jsonrequest.requestJSONObject(URL_eve_gatecheck + systemlist);
    }

    //data conversion
    private static final DateTimeFormatter datetimeinputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.UK);
    private static final SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd");
    
    /**
     * convert swagger datetime string to java Timestamp, offset 1
     * @param datetimestring: datetime of format yyyy-MM-dd'T'HH:mm:ss'Z'
     * @return 
     */
    public static Timestamp datetimestring2Timestamp(String datetimestring) {
        LocalDateTime date = LocalDateTime.parse(datetimestring, datetimeinputFormatter);      
        return Timestamp.valueOf(date.atZone(ZoneId.systemDefault()).toLocalDateTime());
    }

    /**
     * convert swagger date string to java Date
     * @param datestring: date of format yyyy-MM-dd
     * @return 
     */
    public static Date datestring2Date(String datetimestring) {
        try {
            return new Date(simpledateformat.parse(datetimestring).getTime());
        }
        catch(ParseException e) {
            return new Date(System.currentTimeMillis());
        }
    }

}
