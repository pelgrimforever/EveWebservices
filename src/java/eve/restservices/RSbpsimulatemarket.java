package eve.restservices;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import eve.conversion.json.JSONView_evetypes;
import eve.conversion.json.JSONView_userbpmaterial;
import eve.usecases.custom.Bpsimulatemarket_usecases;
import eve.usecases.custom.Bpsimulatemarket_parameters;
import eve.logicview.View_evetypes;
import eve.logicview.View_userbpmaterial;
import eve.usecases.Bpproduction_usecases;
import eve.usecases.custom.Security_usecases;
import eve.usecases.View_evetypes_usecases;
import general.exception.CustomException;
import general.exception.DBException;
import general.exception.DatahandlerException;
import java.io.IOException;
import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
@Path("rsbpsimulatemarket")
public class RSbpsimulatemarket extends RS_json_login {
    
    private Security_usecases security_usecases = new Security_usecases();
    private Bpproduction_usecases bpproduction_usecases;
    private View_evetypes_usecases view_evetypes_usecases;
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        String result = "";
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            if(loggedin) {
                Bpsimulatemarket_parameters parameters = new Bpsimulatemarket_parameters();
                parameters.setUsername(JSONConversion.getString(json, "username"));
                parameters.setViewevetype(JSONView_evetypes.toView_evetypes((JSONObject)json.get("viewblueprint")));
                parameters.setBpprice(JSONConversion.getLong(json, "bpprice"));
                parameters.setBpbreakeven(JSONConversion.getint(json, "bpbreakeven"));
                parameters.setBpmaterialefficiency(JSONConversion.getint(json, "bpmaterialefficiency"));
                parameters.setResearchcost(JSONConversion.getLong(json, "researchcost"));
                parameters.setStationfee(JSONConversion.getLong(json, "stationfee"));

                view_evetypes_usecases = new View_evetypes_usecases(loggedin);
                View_evetypes view_evetyperesult = getBlueprintresult(parameters);
                bpproduction_usecases = new Bpproduction_usecases(loggedin);
                ArrayList<View_userbpmaterial> view_userbpmaterials = getView_userbpmaterials_for_blueprint_user(parameters);
                        
                
                Bpsimulatemarket_usecases bpsimulatemarket_usecases = new Bpsimulatemarket_usecases(parameters);
                
                double totalprice_market = bpsimulatemarket_usecases.calculateproductionprice_market_usecase(view_userbpmaterials);
                double totalprice_user = bpsimulatemarket_usecases.calculateproductionprice4user_usecase(view_userbpmaterials);

                JSONObject production = new JSONObject();
                production.put("bpresult", JSONView_evetypes.toJSON(view_evetyperesult));
                production.put("material", JSONView_userbpmaterial.toJSONArray(view_userbpmaterials));
                production.put("totalprice_market", totalprice_market);
                production.put("totalprice_user", totalprice_user);
                result = production.toJSONString();
            } else {
                result = returnstatus("Not authorized");
            }
        }
        catch(ParseException | CustomException | IOException e) {
            result = returnstatus(e.getMessage());
        }
        return result;
    }
    
    public ArrayList<View_userbpmaterial> getView_userbpmaterials_for_blueprint_user(Bpsimulatemarket_parameters parameters) throws DBException, DatahandlerException {
        return bpproduction_usecases.getView_userbpmaterials_for_blueprint_user_usecase(parameters.getViewevetype().getId(), parameters.getUsername());
    }
    
    public View_evetypes getBlueprintresult(Bpsimulatemarket_parameters parameters) throws DBException, DatahandlerException {
        return view_evetypes_usecases.getBlueprintresult_usecase(parameters.getViewevetype());
    }
    
    private String returnstatus(String status) {
        JSONObject json = new JSONObject();
        json.put("status", status);
        return json.toJSONString();
    }
    
}
