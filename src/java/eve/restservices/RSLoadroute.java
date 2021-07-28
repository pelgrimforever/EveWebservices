package eve.restservices;

import data.conversion.JSONConversion;
import eve.BusinessObject.Logic.*;
import eve.conversion.json.*;
import eve.data.Swagger;
import eve.entity.pk.SystemPK;
import general.exception.CustomException;
import general.exception.DBException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * REST Web Service
 *
 * @author Franky Laseure
 */
@Path("rsloadroute")
public class RSLoadroute {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of HelloWorld
     */
    public RSLoadroute() {
    }

    /**
     * Retrieves representation of an instance of orders.restservices.RSOrders
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{json}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@PathParam("json") String jsonstring) {
        try {
            BLorders blorders = new BLorders();
            ArrayList orderss = blorders.getAll();
            JSONArray jsonorderss = JSONOrders.toJSONArray(orderss);
            return jsonorderss.toJSONString();
        }
        catch(DBException e) {
            return "{ \"status\": \"error\"}";
        }
    }

    /**
     * Retrieves representation of an instance of orders.restservices.RSOrders
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        String result = "";
        BLsystem blsystem = new BLsystem();
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject)parser.parse(jsonstring);
            long origin = JSONConversion.getlong(json, "origin");
            long destination = JSONConversion.getlong(json, "destination");
            JSONArray jsonviasystems = (JSONArray)json.get("viasystems");
            JSONArray jsonavoidsystems = (JSONArray)json.get("avoidsystems");
            boolean secure = JSONConversion.getboolean(json, "secure");
            ArrayList<Long> avoidsystems = new ArrayList<>();
            Iterator<String> jsonavoidsystemsI = jsonavoidsystems.iterator();
            //build avoidlist
            while(jsonavoidsystemsI.hasNext()) {
                avoidsystems.add(Long.valueOf(jsonavoidsystemsI.next()));
            }
            
            Iterator<String> jsonviasystemsI = jsonviasystems.iterator();
            //build routelist
            ArrayList<Long> routelist = new ArrayList();
            routelist.add(origin);
            while(jsonviasystemsI.hasNext()) {
                routelist.add(Long.valueOf(jsonviasystemsI.next()));
            }
            routelist.add(destination);
            
            JSONArray jsonroute;
            JSONArray jsonsystemkills;
            JSONObject jsongatechecks;
            long systemid;
            eve.logicentity.System system;
            //get routes
            
            Iterator<Long> routelistI = routelist.iterator();
            long systemstart = routelistI.next();
            long systemend;
            ArrayList<Long> gatechecksystems = new ArrayList();
            gatechecksystems.add(origin);
            while(routelistI.hasNext()) {
                systemend = routelistI.next();
                jsonroute = Swagger.getRoute(systemstart, systemend, avoidsystems, secure);
                Iterator<Long> jsonrouteI = jsonroute.iterator();
                //ignore first result
                jsonrouteI.next();
                while(jsonrouteI.hasNext()) {
                    gatechecksystems.add((long)jsonrouteI.next());
                }
                systemstart = systemend;
            }
            //get kills from Eve Swagger
            jsonsystemkills = Swagger.getSystemkills();
            //get kills from Eve gatecheck
            jsongatechecks = Swagger.getEveGatecheck(gatechecksystems);
            Iterator<Long> gatechecksystemsI = gatechecksystems.iterator();
            ArrayList systems = new ArrayList();
            JSONObject systemkill;
            JSONObject gatecheckkill;
            while(gatechecksystemsI.hasNext()) {
                systemid = (long)gatechecksystemsI.next();
                system = blsystem.getSystem(new SystemPK(systemid));
                systemkill = findSystemkill(jsonsystemkills, systemid);
                gatecheckkill = findGatecheckkill(jsongatechecks, systemid);
                if(systemkill!=null) {
                    system.setNpc_kills(JSONConversion.getint(systemkill, "npc_kills"));
                    system.setPod_kills(JSONConversion.getint(systemkill, "pod_kills"));
                    system.setShip_kills(JSONConversion.getint(systemkill, "ship_kills"));
                }
                if(gatecheckkill!=null) {
                    JSONObject kills = (JSONObject)gatecheckkill.get("kills");
                    system.setKillmailcount(JSONConversion.getint(kills, "killCount"));
                    system.setKillmailgatecount(JSONConversion.getint(kills, "gateKillCount"));
                    system.setKillmaildata((JSONObject)kills.get("data"));
                }
                
                /*
{
"premium":false,
"30002765":
	{"kills":
		{"killCount":3,
		"gateKillCount":3,
		"data":
			{"Hatakani":
				{"killCount":2,
				"checks":
					{"smartbombs":null,"dictors":null,"hictors":null}
				},
			"Uedama":
				{"killCount":1,
				"checks":
					{"smartbombs":null,"dictors":null,"hictors":null}
				}
			}
		}
	},
"30000139":{"kills":{"killCount":2,"gateKillCount":2,"data":{"Perimeter":{"killCount":2,"checks":{"smartbombs":null,"dictors":null,"hictors":null}}}}},
"30000142":{"kills":{"killCount":5,"gateKillCount":0,"data":{"Not on a gate":{"killCount":5,"checks":{"smartbombs":null,"dictors":null,"hictors":null}}}}},
"30000144":{"kills":{"killCount":3,"gateKillCount":3,"data":{"Jita":{"killCount":3,"checks":{"smartbombs":null,"dictors":null,"hictors":null}}}}},
"30002633":{"kills":{"killCount":2,"gateKillCount":2,"data":{"Balle":{"killCount":2,"checks":{"smartbombs":null,"dictors":null,"hictors":null}}}}},
"30002768":{"kills":{"killCount":3,"gateKillCount":2,"data":{"Sivala":{"killCount":2,"checks":{"smartbombs":null,"dictors":null,"hictors":null}},"Not on a gate":{"killCount":1,"checks":{"smartbombs":null,"dictors":null,"hictors":null}}}}},                */
                systems.add(system);
            }
            //get kills from eve gatecheck
            result = JSONSystem.toJSONArray(systems).toJSONString();
        }
        catch(ParseException e) {
            result = returnstatus(e.getMessage());
        }
        catch(CustomException e) {
            result = returnstatus(e.getMessage());
        }
        return result;
    }

    private String returnstatus(String status) {
        JSONObject json = new JSONObject();
        json.put("status", status);
        return json.toJSONString();
    }
    
    private JSONObject findSystemkill(JSONArray jsonsystemkills, long systemid) {
        JSONObject result = null;
        Iterator<JSONObject> jsonsystemkillsI = jsonsystemkills.iterator();
        JSONObject json;
        long killsystemid;
        boolean keepsearching = true;
        while(jsonsystemkillsI.hasNext() && keepsearching) {
            json = jsonsystemkillsI.next();
            if(systemid==JSONConversion.getLong(json, "system_id")) {
                result = json;
                keepsearching = true;
            }
        }
        return result;
    }

    private JSONObject findGatecheckkill(JSONObject jsongatecheck, long systemid) {
        JSONObject result = null;
        Iterator<String> jsongatecheckI = jsongatecheck.keySet().iterator();
        JSONObject json;
        long killsystemid;
        boolean keepsearching = true;
        while(jsongatecheckI.hasNext() && keepsearching) {
            String key = jsongatecheckI.next();
            try {
                killsystemid = Long.valueOf(key);
                if(systemid==killsystemid) {
                    result = (JSONObject)jsongatecheck.get(key);
                    keepsearching = true;
                }
            }
            catch(Exception e) {
            }
        }
        return result;
    }
}

