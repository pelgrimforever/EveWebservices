package eve.restservices;

import base.restservices.RS_json;
import data.conversion.JSONConversion;
import eve.BusinessObject.service.RouteService;
import eve.conversion.json.JSONSystem;
import eve.usecases.custom.Loadroute_usecases;
import eve.usecases.custom.Loadroute_parameters;
import general.exception.CustomException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
@Path("rscreateroutes")
public class RScreateroutes extends RS_json {
    
    Loadroute_usecases loadroute_usecases = new Loadroute_usecases();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            result = findroute(json);
        }
        catch(ParseException | CustomException e) {
            result = returnstatus(e.getMessage());
        }
        return result;
    }

    private String findroute(JSONObject json) throws CustomException {
        Loadroute_parameters loadrouteparameters = new Loadroute_parameters();
        loadrouteparameters.setOrigin(JSONConversion.getlong(json, "origin"));
        loadrouteparameters.setDestination(JSONConversion.getlong(json, "destination"));
        loadrouteparameters.setAvoidsystems(extract_avoidsystems_from_jsoninput(json));
        loadrouteparameters.setRoutesegmentlist(extract_routestoppoints_from_jsoninput(json));
        loadrouteparameters.setSecure(JSONConversion.getboolean(json, "secure"));
        ArrayList systems = loadroute_usecases.Loadroute_localservice_usecase(loadrouteparameters);
        return JSONSystem.toJSONArray(systems).toJSONString();
    }
    
    private ArrayList<Long> extract_avoidsystems_from_jsoninput(JSONObject json) {
        JSONArray jsonavoidsystems = (JSONArray)json.get("avoidsystems");
        ArrayList<Long> avoidsystems = new ArrayList<>();
        Iterator<String> jsonavoidsystemsI = jsonavoidsystems.iterator();
        while(jsonavoidsystemsI.hasNext()) {
            avoidsystems.add(Long.valueOf(jsonavoidsystemsI.next()));
        }
        return avoidsystems;
    }

    private ArrayList<Long> extract_routestoppoints_from_jsoninput(JSONObject json) {
        JSONArray jsonviasystems = (JSONArray)json.get("viasystems");
        Iterator<String> jsonviasystemsI = jsonviasystems.iterator();
        ArrayList<Long> routelist = new ArrayList();
        while(jsonviasystemsI.hasNext()) {
            routelist.add(Long.valueOf(jsonviasystemsI.next()));
        }
        return routelist;
    }
    
    private String returnstatus(String status) {
        JSONObject json = new JSONObject();
        json.put("status", status);
        return json.toJSONString();
    }    
}
