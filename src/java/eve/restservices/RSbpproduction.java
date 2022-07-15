package eve.restservices;

import base.restservices.RS_json_login;
import eve.BusinessObject.Logic.BLuserbp;
import eve.BusinessObject.Logic.BLview_userbpmaterial;
import eve.conversion.json.JSONView_userbp;
import eve.conversion.json.JSONView_userbpmaterial;
import eve.usecases.Bpproduction_usecases;
import eve.logicview.View_userbp;
import eve.logicview.View_userbpmaterial;
import eve.usecases.custom.Security_usecases;
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
    
    private Security_usecases security_usecases = new Security_usecases();
    private Bpproduction_usecases bpproduction_usecases;
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        String result = "";
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            View_userbp view_userbp = JSONView_userbp.toView_userbp((JSONObject)json.get("viewuserbp"));
            bpproduction_usecases = new Bpproduction_usecases(loggedin);
            
            JSONObject production = new JSONObject();
            ArrayList<View_userbpmaterial> view_userbpmaterials = find_user_materials_for_blueprint(view_userbp);
            production.put("material", JSONView_userbpmaterial.toJSONArray(view_userbpmaterials));
            production.put("totalprice_market", bpproduction_usecases.calculateproductionprice_market_usecase(view_userbp, view_userbpmaterials));
            production.put("totalprice_user", bpproduction_usecases.calculateproductionprice4user_usecase(view_userbp, view_userbpmaterials));
            
            result = production.toJSONString();
        }
        catch(ParseException | CustomException | IOException e) {
            result = returnstatus(e.getMessage());
        }
        return result;
    }

    public ArrayList<View_userbpmaterial> find_user_materials_for_blueprint(View_userbp view_userbp) throws DBException, DatahandlerException {
        return bpproduction_usecases.find_user_materials_for_blueprint_usecase(view_userbp.getBp(), view_userbp.getSerialnumber(), view_userbp.getUsername());
    }
    
    private String returnstatus(String status) {
        JSONObject json = new JSONObject();
        json.put("status", status);
        return json.toJSONString();
    }
    
}
