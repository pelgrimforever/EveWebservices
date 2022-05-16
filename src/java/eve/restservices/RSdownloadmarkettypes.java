package eve.restservices;

import base.restservices.RS_json;
import base.restservices.RS_json_admin;
import eve.BusinessObject.service.CategoryService;
import eve.BusinessObject.service.CategoryService.CategoryStatus;
import eve.BusinessObject.service.Market_groupService;
import eve.BusinessObject.service.Market_groupService.Market_groupStatus;
import eve.usecases.Security_usecases;
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
@Path("rsdownloadmarkettypes")
public class RSdownloadmarkettypes extends RS_json_admin {
    
    private static Thread marketgroupdownloader = null;
    private static Market_groupService market_group_service = null;
    private static Thread categorydownloader = null;
    private static CategoryService category_service = null;
    private static boolean keeprunning = false;
    private static int count = 0;

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
            boolean ismarketgroupservice_running = market_group_service!=null;
            boolean ismarketgroupservice_done = ismarketgroupservice_running && market_group_service.getStatus().isDone();
            boolean ismarketgroupdownloader_not_running = marketgroupdownloader==null;
            boolean iscategoryservice_running = category_service!=null;
            boolean iscategoryservice_done = iscategoryservice_running && category_service.getStatus().isDone();
            boolean iscategorydownloader_not_running = categorydownloader==null;
            if(isadmin && start_requested)
                start_reset_services();
            if(isadmin && stop_requested && ismarketgroupservice_running)
                stop_services();
            result = build_JSON_response().toJSONString();
        }
        catch(ParseException | CustomException | IOException e) {
            result = returnstatus(e.getMessage());
        }
        return result;
    }

    private void start_reset_services() {
        keeprunning = true;
        boolean ismarketgroupservice_running = market_group_service!=null;
        boolean ismarketgroupservice_done = ismarketgroupservice_running && market_group_service.getStatus().isDone();
        boolean iscategoryservice_running = category_service!=null;
        boolean iscategoryservice_done = iscategoryservice_running && category_service.getStatus().isDone();
        if(ismarketgroupservice_done && iscategoryservice_done)
            resetMarkettypes();
        boolean marketgroupdownloader_running = marketgroupdownloader==null;
        if(marketgroupdownloader_running)
            start_marketgroup_service();
        boolean categorydownloader_running = categorydownloader==null;
        if(categorydownloader_running)
            start_categoryservice();
    }

    private void start_marketgroup_service() {
        market_group_service = new Market_groupService();
        marketgroupdownloader = new Thread(market_group_service);
        marketgroupdownloader.setPriority(Thread.MIN_PRIORITY);
        marketgroupdownloader.start();
    }

    private void start_categoryservice() {
        category_service = new CategoryService();
        categorydownloader = new Thread(category_service);
        categorydownloader.setPriority(Thread.MIN_PRIORITY);
        categorydownloader.start();
    }

    private void stop_services() {
        market_group_service.stoprunning();
        category_service.stoprunning();
        keeprunning = false;
        marketgroupdownloader.interrupt();
        marketgroupdownloader = null;
        categorydownloader.interrupt();
        categorydownloader = null;
        market_group_service = null;
        category_service = null;
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
        boolean ismarketgroupservice_running = market_group_service!=null;
        if(ismarketgroupservice_running)
            build_JSON_respoinse_marketgroup_details(jsonmarket_groups, jsoncategories, jsonmessages, jsonstatus);
        jsonstatus.put("status", "OK");
        return jsonstatus;
    }

    private void build_JSON_respoinse_marketgroup_details(JSONObject jsonmarket_groups, JSONObject jsoncategories, JSONArray jsonmessages, JSONObject jsonstatus) {
        Market_groupStatus market_groupstatus = market_group_service.getStatus();
        CategoryStatus categorystatus = category_service.getStatus();
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
            resetMarkettypes();
    }

    private void resetMarkettypes() {
        marketgroupdownloader = null;
        market_group_service = null;
        categorydownloader = null;
        category_service = null;
    }
    
    private String returnstatus(String status) {
        JSONObject json = new JSONObject();
        json.put("status", status);
        return json.toJSONString();
    }
    
}
