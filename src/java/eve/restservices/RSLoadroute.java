package eve.restservices;

import base.restservices.RS_json;
import data.conversion.JSONConversion;
import eve.conversion.json.*;
import eve.usecases.custom.Loadroute_usecases;
import eve.usecases.custom.Loadroute_parameters;
import general.exception.CustomException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
@Path("rsloadroute")
public class RSLoadroute extends RS_json {

    Loadroute_usecases loadroute_usecases = new Loadroute_usecases();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            result = findroute(json);
        }
        catch(CustomException | ParseException e) {
            setReturnstatus(e.getMessage());
        }
        return result;
    }

    private String findroute(JSONObject json) throws CustomException {
        Loadroute_parameters routeparameters = new Loadroute_parameters();
        routeparameters.setOrigin(JSONConversion.getlong(json, "origin"));
        routeparameters.setDestination(JSONConversion.getlong(json, "destination"));
        routeparameters.setAvoidsystems(extract_avoidsystems_from_jsoninput(json));
        routeparameters.setRoutesegmentlist(extract_routestoppoints_from_jsoninput(json));
        routeparameters.setSecure(JSONConversion.getboolean(json, "secure"));
        ArrayList systems = loadroute_usecases.Loadroute_withswagger_usecase(routeparameters);
        return JSONSystem.toJSONArray(systems).toJSONString();
    }
    
    private ArrayList<Long> extract_avoidsystems_from_jsoninput(JSONObject json) {
        JSONArray jsonavoidsystems = (JSONArray)json.get("avoidsystems");
        ArrayList<Long> avoidsystems = new ArrayList<>();
        Iterator<String> jsonavoidsystemsI = jsonavoidsystems.iterator();
        while(jsonavoidsystemsI.hasNext())
            avoidsystems.add(Long.valueOf(jsonavoidsystemsI.next()));
        return avoidsystems;
    }

    private ArrayList<Long> extract_routestoppoints_from_jsoninput(JSONObject json) {
        JSONArray jsonviasystems = (JSONArray)json.get("viasystems");
        Iterator<String> jsonviasystemsI = jsonviasystems.iterator();
        ArrayList<Long> routelist = new ArrayList();
        while(jsonviasystemsI.hasNext())
            routelist.add(Long.valueOf(jsonviasystemsI.next()));
        return routelist;
    }
}

