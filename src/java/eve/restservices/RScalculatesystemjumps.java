package eve.restservices;

import base.restservices.RS_json_admin;
import eve.BusinessObject.service.SystemjumpsService;
import eve.usecases.Security_usecases;
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
    
    private static Thread jumpcalculator = null;
    private static SystemjumpsService systemjumpsservice = null;

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
            boolean issystemjumpservice_running = systemjumpsservice!=null;
            boolean issystemjumpservice_done = issystemjumpservice_running && systemjumpsservice.getStatus().isDone();
            boolean isjumpcalculator_not_running = jumpcalculator==null;
            
            if(isadmin && start_requested)
                start_reset_jumpservice(issystemjumpservice_done, isjumpcalculator_not_running);
            if(isadmin && stop_requested && issystemjumpservice_running)
                stop_jumpservice();
            
            result = build_JSON_response(issystemjumpservice_running).toJSONString();
        }
        catch(ParseException | CustomException | IOException e) {
            result = returnstatus(e.getMessage());
        }
        return result;
    }

    private void start_reset_jumpservice(boolean issystemjumpservice_done, boolean isjumpcalculator_not_running) {
        if(issystemjumpservice_done)
            resetSystemjumpsservice();
        if(isjumpcalculator_not_running)
            start_jumpservice();
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
        SystemjumpsService.SystemjumpsStatus systemjumpsstatus = systemjumpsservice.getStatus();
        jsoncalcjump.put("done", systemjumpsstatus.isDone());
        jsoncalcjump.put("totalcombinations", systemjumpsstatus.getTotalcombinations());
        jsoncalcjump.put("combinations", systemjumpsstatus.getCombinations());
        Iterator<String> messagesI = systemjumpsstatus.getMessages().iterator();
        while(messagesI.hasNext())
            jsonmessages.add(messagesI.next());
        jsonstatus.put("done", systemjumpsstatus.isDone());
        if(systemjumpsstatus.isDone())
            resetSystemjumpsservice();
    }
    
    private void stop_jumpservice() {
        systemjumpsservice.stoprunning();
        jumpcalculator.interrupt();
        jumpcalculator = null;
        systemjumpsservice = null;
    }

    private void start_jumpservice() {
        systemjumpsservice = new SystemjumpsService();
        jumpcalculator = new Thread(systemjumpsservice);
        jumpcalculator.setPriority(Thread.MIN_PRIORITY);
        jumpcalculator.start();
    }

    private void resetSystemjumpsservice() {
        jumpcalculator = null;
        systemjumpsservice = null;
    }
    
    private String returnstatus(String status) {
        JSONObject json = new JSONObject();
        json.put("status", status);
        return json.toJSONString();
    }
    
}
