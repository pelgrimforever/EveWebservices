/*
 * Create routes in database
 */
package eve.restservices;

import data.conversion.JSONConversion;
import eve.BusinessObject.Logic.BLuserbp;
import eve.BusinessObject.Logic.BLview_userbpmaterial;
import eve.BusinessObject.service.AllnodesService;
import eve.conversion.json.JSONView_userbp;
import eve.conversion.json.JSONView_userbpmaterial;
import eve.logicview.View_userbp;
import eve.logicview.View_userbpmaterial;
import general.exception.DBException;
import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author pelgrim
 */
@Path("rsbpproduction")
public class RSbpproduction {
    
    @Context
    private UriInfo context;
    
    /**
     * Creates a new instance of RStest
     */
    public RSbpproduction() {
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
        try {
            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject)parser.parse(jsonstring);
            View_userbp view_userbp = JSONView_userbp.toView_userbp((JSONObject)json.get("viewuserbp"));
            
            JSONObject production = new JSONObject();
            //gather material data
            BLview_userbpmaterial blview_userbpmaterial = new BLview_userbpmaterial();
            ArrayList<View_userbpmaterial> view_userbpmaterials = blview_userbpmaterial.getView_userbpmaterials();
            production.put("material", JSONView_userbpmaterial.toJSONArray(view_userbpmaterials));
            BLuserbp bluserbp = new BLuserbp();
            production.put("totalprice_market", bluserbp.calculateproductionprice_market(view_userbp, view_userbpmaterials));
            production.put("totalprice_user", bluserbp.calculateproductionprice4user(view_userbp, view_userbpmaterials));
            
            result = production.toJSONString();
        }
        catch(ParseException e) {
            result = returnstatus(e.getMessage());
        }
        catch(DBException e) {
            result = returnstatus(e.getMessage());
        }
        return result;
    }

    private String returnstatus(String status) {
        JSONObject json = new JSONObject();
        json.put("status", status);
        return json.toJSONString();
    }
    
}
