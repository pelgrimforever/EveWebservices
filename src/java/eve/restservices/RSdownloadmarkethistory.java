package eve.restservices;

import base.restservices.RS_json;
import base.restservices.RS_json_admin;
import eve.BusinessObject.service.Markethistory;
import eve.BusinessObject.service.Markethistory.MarkethistoryStatus;
import eve.usecases.custom.Security_usecases;
import eve.usecases.custom.Downloadmarkethistory_usecase;
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
@Path("rsdownloadmarkethistory")
public class RSdownloadmarkethistory extends RS_json_admin {
    
    private Security_usecases security_usecases = new Security_usecases();
    private Downloadmarkethistory_usecase downloadmarkethistory_usecase = new Downloadmarkethistory_usecase();
    
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
            downloadmarkethistory_usecase.processRequest(isadmin, start_requested, stop_requested);
            result = build_JSON_response().toJSONString();
        }
        catch(ParseException | CustomException | IOException e) {
            result = returnstatus(e.getMessage());
        }
        return result;
    }

    private JSONObject build_JSON_response() {
        JSONObject jsonstatus = new JSONObject();
        JSONObject jsonhistory = new JSONObject();
        JSONArray jsonmessages = new JSONArray();
        jsonstatus.put("history", jsonhistory);
        jsonstatus.put("messages", jsonmessages);
        jsonstatus.put("done", true);
        boolean ishistoryservice_running = downloadmarkethistory_usecase.isServiceRunning();
        if(ishistoryservice_running)
            build_JSON_response_markethistory_details(jsonhistory, jsonmessages, jsonstatus);
        jsonstatus.put("status", "OK");
        return jsonstatus;
    }

    private void build_JSON_response_markethistory_details(JSONObject jsonhistory, JSONArray jsonmessages, JSONObject jsonstatus) {
        MarkethistoryStatus historystatus = downloadmarkethistory_usecase.getStatus();
        jsonhistory.put("done", historystatus.isDone());
        jsonhistory.put("totalmarkethistorylines", historystatus.getTotalmarkethistorylines());
        jsonhistory.put("markethistorylines", historystatus.getMarkethistorylines());
        Iterator<String> messagesI = historystatus.getMessages().iterator();
        while(messagesI.hasNext())
            jsonmessages.add(messagesI.next());
        jsonstatus.put("done", historystatus.isDone());
        if(historystatus.isDone())
            downloadmarkethistory_usecase.resetHistory();
    }

    private String returnstatus(String status) {
        JSONObject json = new JSONObject();
        json.put("status", status);
        return json.toJSONString();
    }
    
}
