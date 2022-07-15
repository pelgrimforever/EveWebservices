package eve.restservices;

import base.restservices.RS_json_admin;
import eve.BusinessObject.service.CategoryService.CategoryStatus;
import eve.BusinessObject.service.Market_groupService.Market_groupStatus;
import eve.usecases.custom.Security_usecases;
import eve.usecases.custom.Downloadmarkettypes_usecase;
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
@Path("rsdownloadmarkettypes")
public class RSdownloadmarkettypes extends RS_json_admin {
    
    private Security_usecases security_usecases = new Security_usecases();
    private Downloadmarkettypes_usecase downloadmarkettypes_usecase = new Downloadmarkettypes_usecase();
    
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
            downloadmarkettypes_usecase.processRequest(isadmin, start_requested, stop_requested);
            result = build_JSON_response().toJSONString();
        }
        catch(ParseException | CustomException | IOException e) {
            result = returnstatus(e.getMessage());
        }
        return result;
    }

    private JSONObject build_JSON_response() {
        JSONObject jsonstatus = new JSONObject();
        JSONObject jsonmarket_groups = new JSONObject();
        JSONObject jsoncategories = new JSONObject();
        JSONArray jsonmessages = new JSONArray();
        jsonstatus.put("market_groups", jsonmarket_groups);
        jsonstatus.put("categories", jsoncategories);
        jsonstatus.put("messages", jsonmessages);
        jsonstatus.put("done", true);
        boolean ismarketgroupservice_running = downloadmarkettypes_usecase.isMarketgroupServiceRunning();
        if(ismarketgroupservice_running)
            build_JSON_respoinse_marketgroup_details(jsonmarket_groups, jsoncategories, jsonmessages, jsonstatus);
        jsonstatus.put("status", "OK");
        return jsonstatus;
    }

    private void build_JSON_respoinse_marketgroup_details(JSONObject jsonmarket_groups, JSONObject jsoncategories, JSONArray jsonmessages, JSONObject jsonstatus) {
        Market_groupStatus market_groupstatus = downloadmarkettypes_usecase.getMarketgroupStatus();
        CategoryStatus categorystatus = downloadmarkettypes_usecase.getCategoryStatus();
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
        while(messagesI.hasNext())
            jsonmessages.add(messagesI.next());
        messagesI = categorystatus.getMessages().iterator();
        while(messagesI.hasNext())
            jsonmessages.add(messagesI.next());
        jsonstatus.put("done", categorystatus.isDone() && market_groupstatus.isDone());
        if(market_groupstatus.isDone() && categorystatus.isDone())
            downloadmarkettypes_usecase.resetMarkettypes();
    }
    
    private String returnstatus(String status) {
        JSONObject json = new JSONObject();
        json.put("status", status);
        return json.toJSONString();
    }
    
}
