/*
 * Create routes in database
 */
package eve.restservices;

import eve.BusinessObject.service.AllnodesService;
import eve.BusinessObject.service.RouteService;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import org.json.simple.JSONObject;

/**
 *
 * @author pelgrim
 */
@Path("rscreatenodes")
public class RScreatenodes {
    
    @Context
    private UriInfo context;
    
    private static RouteService routeservice = null;

    /**
     * Creates a new instance of RStest
     */
    public RScreatenodes() {
    }

    @GET
    public String get() {
        AllnodesService service = new AllnodesService();
        service.performAlgorithm();
        return "";
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        String result = "";
        AllnodesService service = new AllnodesService();
        service.performAlgorithm();
/*        try {
            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject)parser.parse(jsonstring);
            long origin = JSONConversion.getlong(json, "origin");
            result = JSONSystem.toJSONArray(systems).toJSONString();
        }
        catch(ParseException e) {
            result = returnstatus(e.getMessage());
        }*/
        return result;
    }

    private String returnstatus(String status) {
        JSONObject json = new JSONObject();
        json.put("status", status);
        return json.toJSONString();
    }
    
}
