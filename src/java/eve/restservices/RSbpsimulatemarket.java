/*
 * Create routes in database
 */
package eve.restservices;

import data.conversion.JSONConversion;
import eve.BusinessObject.Logic.BLview_evetypes;
import eve.BusinessObject.Logic.BLview_userbpmaterial;
import eve.BusinessObject.service.AllnodesService;
import eve.conversion.json.JSONView_evetypes;
import eve.conversion.json.JSONView_userbpmaterial;
import eve.logicview.View_evetypes;
import eve.logicview.View_userbpmaterial;
import general.exception.DBException;
import general.exception.DatahandlerException;
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
@Path("rsbpsimulatemarket")
public class RSbpsimulatemarket {
    
    @Context
    private UriInfo context;
    
    /**
     * Creates a new instance of RStest
     */
    public RSbpsimulatemarket() {
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

//Security parameters
            boolean loggedin = RSsecurity.check(json);
            if(loggedin) {
                BLview_evetypes blview_evetypes = new BLview_evetypes();
                blview_evetypes.setAuthenticated(loggedin);

                String username = JSONConversion.getString(json, "username");
                View_evetypes viewevetype = JSONView_evetypes.toView_evetypes((JSONObject)json.get("viewblueprint"));
                long bpprice = JSONConversion.getLong(json, "bpprice");
                int bpbreakeven = JSONConversion.getint(json, "bpbreakeven");
                int bpmaterialefficiency = JSONConversion.getint(json, "bpmaterialefficiency");
                long researchcost = JSONConversion.getLong(json, "researchcost");
                long stationfee = JSONConversion.getLong(json, "stationfee");

                JSONObject production = new JSONObject();
                //gather material data
                View_evetypes view_evetyperesult = blview_evetypes.getBlueprintresult(viewevetype);

                BLview_userbpmaterial blview_userbpmaterial = new BLview_userbpmaterial();
                blview_userbpmaterial.setAuthenticated(loggedin);
                ArrayList<View_userbpmaterial> view_userbpmaterials = blview_userbpmaterial.getView_userbpmaterials(viewevetype.getId(), username);

                double bppartialcost = ((double)bpprice + researchcost) / bpbreakeven;
                double totalprice_market = calculateproductionprice_market(view_userbpmaterials, stationfee, bpmaterialefficiency);
                double totalprice_user = calculateproductionprice4user(view_userbpmaterials, stationfee, bpmaterialefficiency);

                production.put("bpresult", JSONView_evetypes.toJSON(view_evetyperesult).toJSONString());
                production.put("material", JSONView_userbpmaterial.toJSONArray(view_userbpmaterials));
                production.put("totalprice_market", totalprice_market + bppartialcost);
                production.put("totalprice_user", totalprice_user + bppartialcost);

                result = production.toJSONString();
            } else {
                result = returnstatus("Not authorized");
            }
        }
        catch(ParseException e) {
            result = returnstatus(e.getMessage());
        }
        catch(DBException | DatahandlerException e) {
            result = returnstatus(e.getMessage());
        }
        return result;
    }

    private double calculateproductionprice_market(ArrayList<View_userbpmaterial> view_userbpmaterials, long stationfee, int materialefficiency) {
        double totalprice = stationfee;
        for(View_userbpmaterial mat: view_userbpmaterials) {
            //put division last to avoid rounding errors, all numbers are type long
            totalprice += mat.getMarketaverage() * Math.ceil((double)mat.getAmount() * (100-materialefficiency) / 100);
        }
        return totalprice;
    }
    
    public double calculateproductionprice4user(ArrayList<View_userbpmaterial> view_userbpmaterials, long stationfee, int materialefficiency) throws DBException {
        double totalprice = stationfee;
        double matprice = 0;
        for(View_userbpmaterial mat: view_userbpmaterials) {
            if(mat.getMaterialinputaverage()==0) {
                matprice = mat.getMarketaverage();
            } else {
                matprice = mat.getMaterialinputaverage();
            }
            //put division last to avoid rounding errors, all numbers are type long
            totalprice += matprice * Math.ceil(mat.getAmount() * (100-materialefficiency) / 100);
        }
        return totalprice;
    }
    
    private String returnstatus(String status) {
        JSONObject json = new JSONObject();
        json.put("status", status);
        return json.toJSONString();
    }
    
}
