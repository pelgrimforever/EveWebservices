/*
 * Download methods from Swagger to local database
 */
package eve.restservices;

import base.servlets.Securitycheck;
import eve.BusinessObject.service.ContractService;
import eve.BusinessObject.service.ContractService.ContractStatus;
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
 *
 * @author pelgrim
 */
@Path("rsdownloadcontracts")
public class RSdownloadcontracts {
    
    @Context
    private UriInfo context;
    
    private static Thread swaggerdownloader = null;
    private static ContractService contract = null;
    private static boolean keeprunning = false;
    private static int count = 0;

    /**
     * Creates a new instance of RStest
     */
    public RSdownloadcontracts() {
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
            JSONArray jsonregions = new JSONArray();
            JSONArray jsonmessages = new JSONArray();
            jsonstatus.put("regions", jsonregions);
            jsonstatus.put("messages", jsonmessages);
            jsonstatus.put("done", true);
            JSONObject json = (JSONObject)parser.parse(jsonstring);
            boolean loggedin = RSsecurity.check(json);
            if(loggedin && json.containsKey("start") && (Boolean)json.get("start")) {
                String auth = (String)json.get("auth");
                String username = Securitycheck.getUsername(auth);
                keeprunning = true;
                //reset if previous contract upload was finished
                if(contract!=null && contract.getStatus().isDone()) {
                    resetContracts();
                }
                //check if no contract upload is running before starting one
                if(swaggerdownloader==null) {
                    contract = new ContractService(username);
                    swaggerdownloader = new Thread(contract); 
                    swaggerdownloader.setPriority(Thread.MIN_PRIORITY);
                    swaggerdownloader.start();
                }
            }
            if(loggedin && json.containsKey("stop") && (Boolean)json.get("stop") && contract!=null) {
                contract.stoprunning();
                keeprunning = false;
                swaggerdownloader.interrupt();
                swaggerdownloader = null;
                contract = null;
            }
            if(contract!=null) {
                ContractStatus status = contract.getStatus();
                status.getRegions().forEach((regionid, regionstatus) -> {
                    JSONObject jsonregion = new JSONObject();
                    jsonregion.put("region", regionid);
                    jsonregion.put("name", regionstatus.getName());
                    jsonregion.put("totalpages", regionstatus.getTotalpages());
                    jsonregion.put("contracts", regionstatus.getContracts());
                    jsonregion.put("page", regionstatus.getPage());
                    jsonregion.put("done", regionstatus.isDone());
                    jsonregions.add(jsonregion);
                });
                Iterator<String> messagesI = status.getMessages().iterator();
                while(messagesI.hasNext()) {
                    jsonmessages.add(messagesI.next());
                }                
                jsonstatus.put("done", status.isDone());
                if(status.isDone()) {
                    resetContracts();
                }
            }
            jsonstatus.put("status", "OK");
            result = jsonstatus.toJSONString();
        }
        catch(ParseException | DatahandlerException | IOException e) {
            result = returnstatus(e.getMessage());
        }
        return result;
    }

    private void resetContracts() {
        swaggerdownloader = null;
        contract = null;
    }
    
    private String returnstatus(String status) {
        JSONObject json = new JSONObject();
        json.put("status", status);
        return json.toJSONString();
    }
    
}