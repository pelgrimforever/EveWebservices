package eve.restservices;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import eve.conversion.json.JSONView_evetypes;
import eve.conversion.json.JSONView_userbpmaterial;
import eve.usecases.Bpsimulatemarket_usecases;
import eve.usecases.Bpsimulatemarket_parameters;
import eve.logicview.View_evetypes;
import eve.logicview.View_userbpmaterial;
import eve.usecases.Security_usecases;
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
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
@Path("rsbpsimulatemarket")
public class RSbpsimulatemarket extends RS_json_login {
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        String result = "";
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(Security_usecases.check_authorization(authorisationstring));
            if(loggedin) {
                Bpsimulatemarket_parameters parameters = new Bpsimulatemarket_parameters();
                parameters.setUsername(JSONConversion.getString(json, "username"));
                parameters.setViewevetype(JSONView_evetypes.toView_evetypes((JSONObject)json.get("viewblueprint")));
                parameters.setBpprice(JSONConversion.getLong(json, "bpprice"));
                parameters.setBpbreakeven(JSONConversion.getint(json, "bpbreakeven"));
                parameters.setBpmaterialefficiency(JSONConversion.getint(json, "bpmaterialefficiency"));
                parameters.setResearchcost(JSONConversion.getLong(json, "researchcost"));
                parameters.setStationfee(JSONConversion.getLong(json, "stationfee"));

                Bpsimulatemarket_usecases bpsimulatemarket_interactor = new Bpsimulatemarket_usecases(loggedin, parameters);
                View_evetypes view_evetyperesult = bpsimulatemarket_interactor.getBlueprintresult_usecase();
                ArrayList<View_userbpmaterial> view_userbpmaterials = bpsimulatemarket_interactor.getView_userbpmaterials();
                double totalprice_market = bpsimulatemarket_interactor.calculateproductionprice_market_usecase();
                double totalprice_user = bpsimulatemarket_interactor.calculateproductionprice4user_usecase();

                JSONObject production = new JSONObject();
                production.put("bpresult", JSONView_evetypes.toJSON(view_evetyperesult).toJSONString());
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
    
    private String returnstatus(String status) {
        JSONObject json = new JSONObject();
        json.put("status", status);
        return json.toJSONString();
    }
    
}
