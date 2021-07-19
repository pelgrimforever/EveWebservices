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
            ArrayList avoidsystems = new ArrayList();
            
            //search orders in swagger
            //search on previous page if not found anymore
            JSONArray jsonroute;
            JSONArray jsonsystemkills;
            long systemid;
            eve.logicentity.System system;
            jsonroute = Swagger.getRoute(origin, destination, avoidsystems);
            jsonsystemkills = Swagger.getSystemkills();
            Iterator<Long> jsonrouteI = jsonroute.iterator();
            ArrayList systems = new ArrayList();
            JSONObject systemkill;
            while(jsonrouteI.hasNext()) {
                systemid = (long)jsonrouteI.next();
                system = blsystem.getSystem(new SystemPK(systemid));
                systemkill = findSystemkill(jsonsystemkills, systemid);
                if(systemkill!=null) {
                    add kill properties to system
                }
                systems.add(system);
            }
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
}

