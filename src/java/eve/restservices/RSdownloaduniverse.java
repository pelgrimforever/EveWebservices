/*
 * Download methods from Swagger to local database
 */
package eve.restservices;

import eve.BusinessObject.service.UniverseService;
import eve.BusinessObject.service.UniverseService.UniverseStatus;
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
@Path("rsdownloaduniverse")
public class RSdownloaduniverse {
    
    @Context
    private UriInfo context;
    
    private static Thread universedownloader = null;
    private static UniverseService universe = null;
    private static boolean keeprunning = false;
    private static int count = 0;

    /**
     * Creates a new instance of RStest
     */
    public RSdownloaduniverse() {
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
            JSONObject jsonuniverse = new JSONObject();
            JSONArray jsonmessages = new JSONArray();
            jsonstatus.put("universe", jsonuniverse);
            jsonstatus.put("messages", jsonmessages);
            jsonstatus.put("done", true);
            
            JSONObject json = (JSONObject)parser.parse(jsonstring);
            if(json.containsKey("start") && (Boolean)json.get("start")) {
                keeprunning = true;
                //reset if previous universe upload was finished
                if(universe!=null && universe.getStatus().isDone()) {
                    resetUniverse();
                }
                //check if no market upload is running before starting one
                if(universedownloader==null) {
                    universe = new UniverseService();
                    universedownloader = new Thread(universe); 
                    universedownloader.setPriority(Thread.MIN_PRIORITY);
                    universedownloader.start();
                }
            }
            if(json.containsKey("stop") && (Boolean)json.get("stop") && universe!=null) {
                universe.stoprunning();
                keeprunning = false;
                universedownloader.interrupt();
                universedownloader = null;
                universe = null;
            }
            if(universe!=null) {
                UniverseStatus universestatus = universe.getStatus();
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
                while(messagesI.hasNext()) {
                    jsonmessages.add(messagesI.next());
                }                
                jsonstatus.put("done", universestatus.isDone());
                if(universestatus.isDone()) {
                    resetUniverse();
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

    private void resetUniverse() {
        universedownloader = null;
        universe = null;
    }
    
    private String returnstatus(String status) {
        JSONObject json = new JSONObject();
        json.put("status", status);
        return json.toJSONString();
    }
    
}
