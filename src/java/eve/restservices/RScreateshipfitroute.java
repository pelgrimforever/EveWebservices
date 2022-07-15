package eve.restservices;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import eve.conversion.json.JSONView_system;
import eve.usecases.Shipfitorderselected_usecases;
import eve.logicview.View_system;
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
import javax.ws.rs.core.MediaType;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
@Path("rscreateshipfitroute")
public class RScreateshipfitroute extends RS_json_login {
    
    private Security_usecases security_usecases = new Security_usecases();
    private Shipfitorderselected_usecases shipfitorderselected_usecases;
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        String result = "";
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            String username = JSONConversion.getString(json, "username");
            long origin = JSONConversion.getlong(json, "origin");
            long destination = JSONConversion.getlong(json, "destination");
            ArrayList<View_system> systems = calculateroute(username, origin, destination);
            result = JSONView_system.toJSONArray(systems).toJSONString();
        }
        catch(ParseException | CustomException | IOException e) {
            result = returnstatus(e.getMessage());
        }
        return result;
    }

    public ArrayList<View_system> calculateroute(String username, long origin, long destination) throws DBException {
        shipfitorderselected_usecases = new Shipfitorderselected_usecases(loggedin);
        return shipfitorderselected_usecases.calculateroute_usecase(username, origin, destination);
    }
    
    private String returnstatus(String status) {
        JSONObject json = new JSONObject();
        json.put("status", status);
        return json.toJSONString();
    }
}
