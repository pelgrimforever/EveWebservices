/*
 * Create routes in database
 */
package eve.restservices;

import data.conversion.JSONConversion;
import eve.BusinessObject.Logic.BLshipfitorderselected;
import eve.conversion.json.JSONView_system;
import eve.logicview.View_system;
import general.exception.DBException;
import general.exception.DatahandlerException;
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
@Path("rscreateshipfitroute")
public class RScreateshipfitroute {
    
    @Context
    private UriInfo context;
    
    /**
     * Creates a new instance of RStest
     */
    public RScreateshipfitroute() {
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
//Security parameters
            boolean loggedin = RSsecurity.check(json);
            
            BLshipfitorderselected blshipfitorderselected = new BLshipfitorderselected();
            blshipfitorderselected.setAuthenticated(loggedin);
            
            String username = JSONConversion.getString(json, "username");
            long origin = JSONConversion.getlong(json, "origin");
            long destination = JSONConversion.getlong(json, "destination");
            ArrayList<View_system> systems = blshipfitorderselected.calculateroute(username, origin, destination);
            result = JSONView_system.toJSONArray(systems).toJSONString();
        }
        catch(ParseException e) {
            result = returnstatus(e.getMessage());
        }
        catch(DBException | DatahandlerException e) {
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
