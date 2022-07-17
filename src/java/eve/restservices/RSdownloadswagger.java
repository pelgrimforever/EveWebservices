package eve.restservices;

import base.restservices.RS_json_admin;
import base.servlets.Securitycheck;
import eve.BusinessObject.Logic.BLfrontendpage;
import eve.BusinessObject.Logic.BLfrontendpage_auth;
import eve.BusinessObject.service.MarketService;
import eve.BusinessObject.service.MarketService.MarketStatus;
import eve.usecases.Frontendpage_auth_usecases;
import eve.usecases.custom.Security_usecases;
import eve.usecases.custom.Downloadmarket_usecase;
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
    
    private Security_usecases security_usecases = new Security_usecases();
    private Frontendpage_auth_usecases frontendpage_auth_usecases;
    private Downloadmarket_usecase downloadmarket_usecase = new Downloadmarket_usecase();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            setIsadmin(security_usecases.isadmin(authorisationstring));
            frontendpage_auth_usecases = new Frontendpage_auth_usecases(loggedin);
            boolean authorised = loggedin && isauthorized();
            boolean start_requested = json.containsKey("start") && (Boolean)json.get("start");
            boolean stop_requested = json.containsKey("stop") && (Boolean)json.get("stop");
            String username = Securitycheck.getUsername(authorisationstring);
            downloadmarket_usecase.processRequest(authorised, username, start_requested, stop_requested);
            result = build_JSON_response().toJSONString();
        }
        catch(ParseException | DBException | DatahandlerException | IOException e) {
            result = returnstatus(e.getMessage());
        }
        return result;
    }

    public boolean isauthorized() throws DBException, IOException {
        return loggedin && frontendpage_auth_usecases.check_userauthorisation_for_page(authorisationstring, eve.BusinessObject.Logic.BLfrontendpage.DOWNLOADTRADE);
    }
    
    private JSONObject build_JSON_response() {
        JSONObject jsonstatus = new JSONObject();
        JSONArray jsonregions = new JSONArray();
        JSONArray jsonmessages = new JSONArray();
        jsonstatus.put("regions", jsonregions);
        jsonstatus.put("messages", jsonmessages);
        jsonstatus.put("done", true);
        boolean ismarketservice_running = downloadmarket_usecase.isServiceRunning();
        if(ismarketservice_running)
            build_JSON_response_marketdetails(jsonregions, jsonmessages, jsonstatus);
        jsonstatus.put("status", "OK");
        return jsonstatus;
    }

    private void build_JSON_response_marketdetails(JSONArray jsonregions, JSONArray jsonmessages, JSONObject jsonstatus) {
        MarketStatus status = downloadmarket_usecase.getStatus();
        if(status!=null) {
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
                downloadmarket_usecase.resetMarket();
        }
    }
    
    public String returnstatus(String status) {
        JSONObject json = new JSONObject();
        json.put("status", status);
        return json.toJSONString();
    }
    
}
