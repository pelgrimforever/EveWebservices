/*
 * Download methods from Swagger to local database
 */
package eve.restservices;

import eve.BusinessObject.service.SystemjumpsService;
import eve.BusinessObject.service.UniverseService;
import eve.BusinessObject.service.UniverseService.UniverseStatus;
import general.exception.DatahandlerException;
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
 *
 * @author pelgrim
 */
@Path("rscalculatesystemjumps")
public class RScalculatesystemjumps {
    
    @Context
    private UriInfo context;
    
    private static Thread jumpcalculator = null;
    private static SystemjumpsService systemjumpsservice = null;
    private static boolean keeprunning = false;
    private static int count = 0;

    /**
     * Creates a new instance of RStest
     */
    public RScalculatesystemjumps() {
    }

    @GET
    @Path("{json}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get() {
        return "";
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        String result = "";
        JSONParser parser = new JSONParser();
        try {
            JSONObject jsonstatus = new JSONObject();
            JSONObject jsoncalcjump = new JSONObject();
            JSONArray jsonmessages = new JSONArray();
            jsonstatus.put("calcjump", jsoncalcjump);
            jsonstatus.put("messages", jsonmessages);
            jsonstatus.put("done", true);
            
            JSONObject json = (JSONObject)parser.parse(jsonstring);
            boolean loggedin = RSsecurity.check(json);
            String auth = (String)json.get("auth");
            boolean isadmin = RSsecurity.isadmin(auth);
            if(isadmin && json.containsKey("start") && (Boolean)json.get("start")) {
                keeprunning = true;
                //reset if previous systemjumpsservice upload was finished
                if(systemjumpsservice!=null && systemjumpsservice.getStatus().isDone()) {
                    resetSystemjumpsservice();
                }
                //check if no market upload is running before starting one
                if(jumpcalculator==null) {
                    systemjumpsservice = new SystemjumpsService();
                    jumpcalculator = new Thread(systemjumpsservice); 
                    jumpcalculator.setPriority(Thread.MIN_PRIORITY);
                    jumpcalculator.start();
                }
            }
            if(json.containsKey("stop") && (Boolean)json.get("stop") && systemjumpsservice!=null) {
                systemjumpsservice.stoprunning();
                keeprunning = false;
                jumpcalculator.interrupt();
                jumpcalculator = null;
                systemjumpsservice = null;
            }
            if(systemjumpsservice!=null) {
                SystemjumpsService.SystemjumpsStatus systemjumpsstatus = systemjumpsservice.getStatus();
                jsoncalcjump.put("done", systemjumpsstatus.isDone());
                jsoncalcjump.put("totalcombinations", systemjumpsstatus.getTotalcombinations());
                jsoncalcjump.put("combinations", systemjumpsstatus.getCombinations());
                Iterator<String> messagesI = systemjumpsstatus.getMessages().iterator();
                while(messagesI.hasNext()) {
                    jsonmessages.add(messagesI.next());
                }                
                jsonstatus.put("done", systemjumpsstatus.isDone());
                if(systemjumpsstatus.isDone()) {
                    resetSystemjumpsservice();
                }
            }
            jsonstatus.put("status", "OK");
            result = jsonstatus.toJSONString();
        }
        catch(ParseException | DatahandlerException e) {
            result = returnstatus(e.getMessage());
        }
        return result;
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
