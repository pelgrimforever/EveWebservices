package eve.restservices;

import base.restservices.RS_json_admin;
import base.servlets.Securitycheck;
import eve.BusinessObject.Logic.BLfrontendpage;
import eve.BusinessObject.Logic.BLfrontendpage_auth;
import eve.BusinessObject.service.MarketService;
import eve.BusinessObject.service.MarketService.MarketStatus;
import eve.usecases.Frontendpage_auth_usecases;
import eve.usecases.Security_usecases;
import general.exception.DBException;
import general.exception.DatahandlerException;
import java.io.IOException;
import java.util.Iterator;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
@Path("rsdownloadswagger")
public class RSdownloadswagger extends RS_json_admin {
    
    private static Thread swaggerdownloader = null;
    private static MarketService marketservice = null;
    private static boolean keeprunning = false;
    private static int count = 0;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        String result = "";
        JSONParser parser = new JSONParser();
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(Security_usecases.check_authorization(authorisationstring));
            setIsadmin(Security_usecases.isadmin(authorisationstring));
            Frontendpage_auth_usecases frontendpage_auth_usecases = new Frontendpage_auth_usecases(loggedin);
            loggedin = loggedin && frontendpage_auth_usecases.check_userauthorisation_for_page(authorisationstring, eve.BusinessObject.Logic.BLfrontendpage.DOWNLOADTRADE);            
            boolean start_requested = json.containsKey("start") && (Boolean)json.get("start");
            boolean stop_requested = json.containsKey("stop") && (Boolean)json.get("stop");
            boolean ismarketservice_running = marketservice!=null;
            boolean ismarketservice_done = ismarketservice_running && marketservice.getStatus().isDone();
            boolean isswaggerdownloader_not_running = swaggerdownloader==null;
            String username = Securitycheck.getUsername(authorisationstring);
            if(loggedin && start_requested)
                start_reset_marketservice(username);
            if(loggedin && stop_requested && ismarketservice_running)
                stop_marketservice();
            result = build_JSON_response().toJSONString();
        }
        catch(ParseException | DBException | DatahandlerException | IOException e) {
            result = returnstatus(e.getMessage());
        }
        return result;
    }

    private void start_reset_marketservice(String username) {
        keeprunning = true;
        boolean ismarketservice_running = marketservice!=null;
        boolean ismarketservice_done = ismarketservice_running && marketservice.getStatus().isDone();
        if(ismarketservice_done)
            resetMarket();
        boolean isswaggerdownloader_not_running = swaggerdownloader==null;
        if(isswaggerdownloader_not_running)
            start_marketservice(username);
    }

    private void start_marketservice(String username) {
        marketservice = new MarketService(username);
        swaggerdownloader = new Thread(marketservice);
        swaggerdownloader.setPriority(Thread.MIN_PRIORITY);
        swaggerdownloader.start();
    }

    private void stop_marketservice() {
        marketservice.stoprunning();
        keeprunning = false;
        swaggerdownloader.interrupt();
        swaggerdownloader = null;
        marketservice = null;
    }

    private JSONObject build_JSON_response() {
        JSONObject jsonstatus = new JSONObject();
        JSONArray jsonregions = new JSONArray();
        JSONArray jsonmessages = new JSONArray();
        jsonstatus.put("regions", jsonregions);
        jsonstatus.put("messages", jsonmessages);
        jsonstatus.put("done", true);
        boolean ismarketservice_running = marketservice!=null;
        if(ismarketservice_running)
            build_JSON_response_marketdetails(jsonregions, jsonmessages, jsonstatus);
        jsonstatus.put("status", "OK");
        return jsonstatus;
    }

    private void build_JSON_response_marketdetails(JSONArray jsonregions, JSONArray jsonmessages, JSONObject jsonstatus) {
        MarketStatus status = marketservice.getStatus();
        status.getRegions().forEach((regionid, regionstatus) -> {
            JSONObject jsonregion = new JSONObject();
            jsonregion.put("region", regionid);
            jsonregion.put("name", regionstatus.getName());
            jsonregion.put("totalpages", regionstatus.getTotalpages());
            jsonregion.put("orders", regionstatus.getOrders());
            jsonregion.put("page", regionstatus.getPage());
            jsonregion.put("done", regionstatus.isDone());
            jsonregions.add(jsonregion);
        });
        Iterator<String> messagesI = status.getMessages().iterator();
        while(messagesI.hasNext())
            jsonmessages.add(messagesI.next());
        jsonstatus.put("done", status.isDone());
        if(status.isDone())
            resetMarket();
    }

    private void resetMarket() {
        swaggerdownloader = null;
        marketservice = null;
    }
    
    private String returnstatus(String status) {
        JSONObject json = new JSONObject();
        json.put("status", status);
        return json.toJSONString();
    }
    
}
