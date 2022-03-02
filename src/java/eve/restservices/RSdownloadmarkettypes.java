/*
 * Download methods from Swagger to local database
 */
package eve.restservices;

import eve.BusinessObject.service.CategoryService;
import eve.BusinessObject.service.CategoryService.CategoryStatus;
import eve.BusinessObject.service.Market_groupService;
import eve.BusinessObject.service.Market_groupService.Market_groupStatus;
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
@Path("rsdownloadmarkettypes")
public class RSdownloadmarkettypes {
    
    @Context
    private UriInfo context;
    
    private static Thread marketgroupdownloader = null;
    private static Market_groupService market_group = null;
    private static Thread categorydownloader = null;
    private static CategoryService category = null;
    private static boolean keeprunning = false;
    private static int count = 0;

    /**
     * Creates a new instance of RStest
     */
    public RSdownloadmarkettypes() {
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
            JSONObject jsonmarket_groups = new JSONObject();
            JSONObject jsoncategories = new JSONObject();
            JSONArray jsonmessages = new JSONArray();
            jsonstatus.put("market_groups", jsonmarket_groups);
            jsonstatus.put("categories", jsoncategories);
            jsonstatus.put("messages", jsonmessages);
            jsonstatus.put("done", true);
            
            JSONObject json = (JSONObject)parser.parse(jsonstring);
            boolean loggedin = RSsecurity.check(json);
            String auth = (String)json.get("auth");
            boolean isadmin = RSsecurity.isadmin(auth);
            if(isadmin && json.containsKey("start") && (Boolean)json.get("start")) {
                keeprunning = true;
                //reset if previous market_group upload was finished
                if(market_group!=null && market_group.getStatus().isDone() &&
                        category!=null && category.getStatus().isDone()) {
                    resetMarkettypes();
                }
                //check if no market upload is running before starting one
                if(marketgroupdownloader==null) {
                    market_group = new Market_groupService();
                    marketgroupdownloader = new Thread(market_group); 
                    marketgroupdownloader.setPriority(Thread.MIN_PRIORITY);
                    marketgroupdownloader.start();
                }
                if(categorydownloader==null) {
                    category = new CategoryService();
                    categorydownloader = new Thread(category); 
                    categorydownloader.setPriority(Thread.MIN_PRIORITY);
                    categorydownloader.start();
                }
            }
            if(json.containsKey("stop") && (Boolean)json.get("stop") && market_group!=null) {
                market_group.stoprunning();
                category.stoprunning();
                keeprunning = false;
                marketgroupdownloader.interrupt();
                marketgroupdownloader = null;
                categorydownloader.interrupt();
                categorydownloader = null;
                market_group = null;
                category = null;
            }
            if(market_group!=null) {
                Market_groupStatus market_groupstatus = market_group.getStatus();
                CategoryStatus categorystatus = category.getStatus();
                jsonmarket_groups.put("done", market_groupstatus.isDone());
                jsonmarket_groups.put("totalmarketgroups", market_groupstatus.getTotalmarketgroups());
                jsonmarket_groups.put("marketgroups", market_groupstatus.getMarketgroups());
                JSONObject jsonmarket_group = new JSONObject();
                jsoncategories.put("done", categorystatus.isDone());
                jsoncategories.put("totalcategories", categorystatus.getTotalcategories());
                jsoncategories.put("categories", categorystatus.getCategories());
                jsoncategories.put("totaltypegroups", categorystatus.getTotaltypegroups());
                jsoncategories.put("typegroups", categorystatus.getTypegroups());
                jsoncategories.put("totaltypes", categorystatus.getTotaltypes());
                jsoncategories.put("types", categorystatus.getTypes());
                Iterator<String> messagesI = market_groupstatus.getMessages().iterator();
                while(messagesI.hasNext()) {
                    jsonmessages.add(messagesI.next());
                }                
                messagesI = categorystatus.getMessages().iterator();
                while(messagesI.hasNext()) {
                    jsonmessages.add(messagesI.next());
                }                
                jsonstatus.put("done", categorystatus.isDone() && market_groupstatus.isDone());
                if(market_groupstatus.isDone() && categorystatus.isDone()) {
                    resetMarkettypes();
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

    private void resetMarkettypes() {
        marketgroupdownloader = null;
        market_group = null;
        categorydownloader = null;
        category = null;
    }
    
    private String returnstatus(String status) {
        JSONObject json = new JSONObject();
        json.put("status", status);
        return json.toJSONString();
    }
    
}
