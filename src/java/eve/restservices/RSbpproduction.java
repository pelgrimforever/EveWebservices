package eve.restservices;

import base.restservices.RS_json_login;
import eve.BusinessObject.Logic.BLuserbp;
import eve.BusinessObject.Logic.BLview_userbpmaterial;
import eve.conversion.json.JSONView_userbp;
import eve.conversion.json.JSONView_userbpmaterial;
import eve.usecases.Bpproduction_usecases;
import eve.logicview.View_userbp;
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
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
@Path("rsbpproduction")
public class RSbpproduction extends RS_json_login {
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        String result = "";
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(Security_usecases.check_authorization(authorisationstring));
            View_userbp view_userbp = JSONView_userbp.toView_userbp((JSONObject)json.get("viewuserbp"));
            Bpproduction_usecases bpproductioninteractor = new Bpproduction_usecases(loggedin);
            
            JSONObject production = new JSONObject();
            ArrayList<View_userbpmaterial> view_userbpmaterials = 
                    bpproductioninteractor.find_user_materials_for_blueprint_usecase(view_userbp.getBp(), view_userbp.getSerialnumber(), view_userbp.getUsername());
            production.put("material", JSONView_userbpmaterial.toJSONArray(view_userbpmaterials));
            production.put("totalprice_market", bpproductioninteractor.calculateproductionprice_market_usecase(view_userbp, view_userbpmaterials));
            production.put("totalprice_user", bpproductioninteractor.calculateproductionprice4user_usecase(view_userbp, view_userbpmaterials));
            
            result = production.toJSONString();
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
