package eve.restservices;

import base.restservices.RS_json_admin;
import eve.BusinessObject.service.UniverseService;
import eve.BusinessObject.service.UniverseService.UniverseStatus;
import eve.usecases.custom.Security_usecases;
import eve.usecases.custom.Downloaduniverse_usecase;
import general.exception.CustomException;
import java.io.IOException;
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
@Path("rsdownloaduniverse")
public class RSdownloaduniverse extends RS_json_admin {
    
    private Security_usecases security_usecases = new Security_usecases();
    private Downloaduniverse_usecase downloaduniverse_usecase = new Downloaduniverse_usecase();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            setIsadmin(security_usecases.isadmin(authorisationstring));
            boolean start_requested = json.containsKey("start") && (Boolean)json.get("start");
            boolean stop_requested = json.containsKey("stop") && (Boolean)json.get("stop");
            downloaduniverse_usecase.processRequest(isadmin, start_requested, stop_requested);
            JSONObject jsonstatus = build_JSON_response();
            result = jsonstatus.toJSONString();
        }
        catch(ParseException | CustomException | IOException e) {
            result = returnstatus(e.getMessage());
        }
        return result;
    }

    private JSONObject build_JSON_response() {
        JSONObject jsonstatus = new JSONObject();
        JSONObject jsonuniverse = new JSONObject();
        JSONArray jsonmessages = new JSONArray();
        jsonstatus.put("universe", jsonuniverse);
        jsonstatus.put("messages", jsonmessages);
        jsonstatus.put("done", true);
        if(downloaduniverse_usecase.isServiceRunning())
            build_JSON_response_universeservice_details(jsonuniverse, jsonmessages, jsonstatus);
        jsonstatus.put("status", "OK");
        return jsonstatus;
    }

    private void build_JSON_response_universeservice_details(JSONObject jsonuniverse, JSONArray jsonmessages, JSONObject jsonstatus) {
        UniverseStatus universestatus = downloaduniverse_usecase.getStatus();
        jsonuniverse.put("done", universestatus.isDone());
        jsonuniverse.put("totalgraphics", universestatus.getTotalgraphics());
        jsonuniverse.put("graphics", universestatus.getGraphics());
        jsonuniverse.put("totalraces", universestatus.getTotalraces());
        jsonuniverse.put("races", universestatus.getRaces());
        jsonuniverse.put("totalsystems", universestatus.getTotalsystems());
        jsonuniverse.put("constellations", universestatus.getConstellations());
        jsonuniverse.put("totalconstellations", universestatus.getTotalconstellations());
        jsonuniverse.put("systems", universestatus.getSystems());
        jsonuniverse.put("totalstations", universestatus.getTotalstations());
        jsonuniverse.put("stations", universestatus.getStations());
        jsonuniverse.put("totalstargates", universestatus.getTotalstargates());
        jsonuniverse.put("stargates", universestatus.getStargates());
        jsonuniverse.put("totalcorporations", universestatus.getTotalcorporations());
        jsonuniverse.put("corporations", universestatus.getCorporations());
        jsonuniverse.put("totalalliances", universestatus.getTotalalliances());
        jsonuniverse.put("alliances", universestatus.getAlliances());
        Iterator<String> messagesI = universestatus.getMessages().iterator();
        while(messagesI.hasNext())
            jsonmessages.add(messagesI.next());
        jsonstatus.put("done", universestatus.isDone());
        if(universestatus.isDone())
            downloaduniverse_usecase.resetUniverse();
    }
    
    private String returnstatus(String status) {
        JSONObject json = new JSONObject();
        json.put("status", status);
        return json.toJSONString();
    }
    
}
