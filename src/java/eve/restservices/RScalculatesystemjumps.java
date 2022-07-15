package eve.restservices;

import base.restservices.RS_json_admin;
import eve.BusinessObject.service.SystemjumpsService;
import eve.usecases.custom.Security_usecases;
import eve.usecases.custom.Calculatesystemjumps_usecase;
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
@Path("rscalculatesystemjumps")
public class RScalculatesystemjumps extends RS_json_admin {
    
    private Security_usecases security_usecases = new Security_usecases();
    private Calculatesystemjumps_usecase calculatesystemjumps_usecase = new Calculatesystemjumps_usecase();
    
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
            calculatesystemjumps_usecase.processRequest(isadmin, start_requested, stop_requested);
            result = build_JSON_response(calculatesystemjumps_usecase.isServiceRunning()).toJSONString();
        }
        catch(ParseException | CustomException | IOException e) {
            setReturnstatus(e.getMessage());
        }
        return result;
    }

    private JSONObject build_JSON_response(boolean issystemjumpservice_running) {
        JSONObject jsonstatus = new JSONObject();
        JSONObject jsoncalcjump = new JSONObject();
        JSONArray jsonmessages = new JSONArray();
        jsonstatus.put("calcjump", jsoncalcjump);
        jsonstatus.put("messages", jsonmessages);
        jsonstatus.put("done", true);
        if(issystemjumpservice_running)
            build_JSON_response_jumpservicedetails(jsoncalcjump, jsonmessages, jsonstatus);
        jsonstatus.put("status", "OK");
        return jsonstatus;
    }

    private void build_JSON_response_jumpservicedetails(JSONObject jsoncalcjump, JSONArray jsonmessages, JSONObject jsonstatus) {
        SystemjumpsService.SystemjumpsStatus systemjumpsstatus = calculatesystemjumps_usecase.getStatus();
        jsoncalcjump.put("done", systemjumpsstatus.isDone());
        jsoncalcjump.put("totalcombinations", systemjumpsstatus.getTotalcombinations());
        jsoncalcjump.put("combinations", systemjumpsstatus.getCombinations());
        Iterator<String> messagesI = systemjumpsstatus.getMessages().iterator();
        while(messagesI.hasNext())
            jsonmessages.add(messagesI.next());
        jsonstatus.put("done", systemjumpsstatus.isDone());
        if(systemjumpsstatus.isDone())
            calculatesystemjumps_usecase.resetSystemjumpsservice();
    }
}
