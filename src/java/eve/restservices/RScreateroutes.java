/*
 * Create routes in database
 */
package eve.restservices;

import data.conversion.JSONConversion;
import eve.BusinessObject.service.RouteService;
import eve.conversion.json.JSONSystem;
import eve.data.Swagger;
import eve.entity.pk.SystemPK;
import java.util.ArrayList;
import java.util.Iterator;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author pelgrim
 */
@Path("rscreateroutes")
public class RScreateroutes {
    
    @Context
    private UriInfo context;
    
    private static RouteService routeservice = null;

    /**
     * Creates a new instance of RStest
     */
    public RScreateroutes() {
    }

    @GET
    @Path("{json}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get() {
        return "";
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        String result = "";
        try {
            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject)parser.parse(jsonstring);
            long origin = JSONConversion.getlong(json, "origin");
            long destination = JSONConversion.getlong(json, "destination");
            JSONArray jsonviasystems = (JSONArray)json.get("viasystems");
            JSONArray jsonavoidsystems = (JSONArray)json.get("avoidsystems");
            boolean secure = JSONConversion.getboolean(json, "secure");
            ArrayList<Long> viasystems = new ArrayList<>();
            Iterator<String> jsonviasystemsI = jsonviasystems.iterator();
            while(jsonviasystemsI.hasNext()) {
                viasystems.add(Long.valueOf(jsonviasystemsI.next()));
            }
            ArrayList<Long> avoidsystems = new ArrayList<>();
            Iterator<String> jsonavoidsystemsI = jsonavoidsystems.iterator();
            while(jsonavoidsystemsI.hasNext()) {
                avoidsystems.add(Long.valueOf(jsonavoidsystemsI.next()));
            }
            if(routeservice==null) {
                routeservice = new RouteService();
            }
            ArrayList<Long> route = routeservice.getRoute(origin, destination, avoidsystems, viasystems, secure);

            //add kill info to the systems
            JSONArray jsonsystemkills;
            JSONObject jsongatechecks;
            eve.logicentity.System system;
            //get kills from Eve Swagger
            jsonsystemkills = Swagger.getSystemkills();
            //get kills from Eve gatecheck
            jsongatechecks = Swagger.getEveGatecheck(route);
            //build route systems array
            ArrayList systems = new ArrayList();
            JSONObject systemkill;
            JSONObject gatecheckkill;
            for(Long systemid: route) {
                system = routeservice.getSystem(systemid);
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
                systems.add(system);
            }
            result = JSONSystem.toJSONArray(systems).toJSONString();
        }
        catch(ParseException e) {
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
