package eve.restservices;

import base.restservices.RS_json;
import base.restservices.RS_json_admin;
import eve.BusinessObject.service.UniverseService;
import eve.BusinessObject.service.UniverseService.UniverseStatus;
import eve.usecases.Security_usecases;
import general.exception.CustomException;
import general.exception.DatahandlerException;
import java.io.IOException;
import java.util.Iterator;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
@Path("rsdownloaduniverse")
public class RSdownloaduniverse extends RS_json_admin {
    
    private static Thread universedownloader = null;
    private static UniverseService universeservice = null;
    private static boolean keeprunning = false;
    private static int count = 0;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(Security_usecases.check_authorization(authorisationstring));
            setIsadmin(Security_usecases.isadmin(authorisationstring));
            boolean start_requested = json.containsKey("start") && (Boolean)json.get("start");
            boolean stop_requested = json.containsKey("stop") && (Boolean)json.get("stop");
            boolean isuniverseservice_running = universeservice!=null;
            boolean isuniverseservice_done = isuniverseservice_running && universeservice.getStatus().isDone();
            boolean isuniversedownloader_not_running = universedownloader==null;
            if(isadmin && start_requested)
                start_reset_universeservice();
            if(isadmin && stop_requested && isuniverseservice_running)
                stop_universeservice();
            JSONObject jsonstatus = build_JSON_response();
            result = jsonstatus.toJSONString();
        }
        catch(ParseException | CustomException | IOException e) {
            result = returnstatus(e.getMessage());
        }
        return result;
    }

    private void stop_universeservice() {
        universeservice.stoprunning();
        keeprunning = false;
        universedownloader.interrupt();
        universedownloader = null;
        universeservice = null;
    }

    private void start_reset_universeservice() {
        keeprunning = true;
        if(universeservice!=null && universeservice.getStatus().isDone())
            resetUniverse();
        if(universedownloader==null)
            start_universeservice();
    }

    private void start_universeservice() {
        universeservice = new UniverseService();
        universedownloader = new Thread(universeservice);
        universedownloader.setPriority(Thread.MIN_PRIORITY);
        universedownloader.start();
    }

    private void resetUniverse() {
        universedownloader = null;
        universeservice = null;
    }

    private JSONObject build_JSON_response() {
        JSONObject jsonstatus = new JSONObject();
        JSONObject jsonuniverse = new JSONObject();
        JSONArray jsonmessages = new JSONArray();
        jsonstatus.put("universe", jsonuniverse);
        jsonstatus.put("messages", jsonmessages);
        jsonstatus.put("done", true);
        if(universeservice!=null)
            build_JSON_response_universeservice_details(jsonuniverse, jsonmessages, jsonstatus);
        jsonstatus.put("status", "OK");
        return jsonstatus;
    }

    private void build_JSON_response_universeservice_details(JSONObject jsonuniverse, JSONArray jsonmessages, JSONObject jsonstatus) {
        UniverseStatus universestatus = universeservice.getStatus();
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
        jsonuniverse.put("alliances", universestatus.getAlliances());
        jsonuniverse.put("totalalliances", universestatus.getTotalalliances());
        jsonuniverse.put("alliances", universestatus.getAlliances());
        Iterator<String> messagesI = universestatus.getMessages().iterator();
        while(messagesI.hasNext())
            jsonmessages.add(messagesI.next());
        jsonstatus.put("done", universestatus.isDone());
        if(universestatus.isDone())
            resetUniverse();
    }
    
    private String returnstatus(String status) {
        JSONObject json = new JSONObject();
        json.put("status", status);
        return json.toJSONString();
    }
    
}
