/*
 * Download methods from Swagger to local database
 */
package eve.restservices;

import eve.BusinessObject.service.Markethistory;
import eve.BusinessObject.service.Markethistory.MarkethistoryStatus;
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
@Path("rsdownloadmarkethistory")
public class RSdownloadmarkethistory {
    
    @Context
    private UriInfo context;
    
    private static Thread historydownloader = null;
    private static Markethistory history = null;
    private static boolean keeprunning = false;
    private static int count = 0;

    /**
     * Creates a new instance of RStest
     */
    public RSdownloadmarkethistory() {
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
            JSONObject jsonhistory = new JSONObject();
            JSONArray jsonmessages = new JSONArray();
            jsonstatus.put("history", jsonhistory);
            jsonstatus.put("messages", jsonmessages);
            jsonstatus.put("done", true);
            
            JSONObject json = (JSONObject)parser.parse(jsonstring);
            if(json.containsKey("start") && (Boolean)json.get("start")) {
                keeprunning = true;
                //reset if previous history upload was finished
                if(history!=null && history.getStatus().isDone()) {
                    resetHistory();
                }
                //check if no market upload is running before starting one
                if(historydownloader==null) {
                    history = new Markethistory();
                    historydownloader = new Thread(history); 
                    historydownloader.setPriority(Thread.MIN_PRIORITY);
                    historydownloader.start();
                }
            }
            if(json.containsKey("stop") && (Boolean)json.get("stop") && history!=null) {
                history.stoprunning();
                keeprunning = false;
                historydownloader.interrupt();
                historydownloader = null;
                history = null;
            }
            if(history!=null) {
                MarkethistoryStatus historystatus = history.getStatus();
                jsonhistory.put("done", historystatus.isDone());
                jsonhistory.put("totalmarkethistorylines", historystatus.getTotalmarkethistorylines());
                jsonhistory.put("markethistorylines", historystatus.getMarkethistorylines());
                Iterator<String> messagesI = historystatus.getMessages().iterator();
                while(messagesI.hasNext()) {
                    jsonmessages.add(messagesI.next());
                }                
                jsonstatus.put("done", historystatus.isDone());
                if(historystatus.isDone()) {
                    resetHistory();
                }
            }
            jsonstatus.put("status", "OK");
            result = jsonstatus.toJSONString();
        }
        catch(ParseException e) {
            result = returnstatus(e.getMessage());
        }
        return result;
    }

    private void resetHistory() {
        historydownloader = null;
        history = null;
    }
    
    private String returnstatus(String status) {
        JSONObject json = new JSONObject();
        json.put("status", status);
        return json.toJSONString();
    }
    
}
