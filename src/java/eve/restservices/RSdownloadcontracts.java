package eve.restservices;

import base.restservices.RS_json_admin;
import base.servlets.Securitycheck;
import db.SQLreader;
import eve.BusinessObject.Logic.BLfrontendpage;
import eve.BusinessObject.Logic.BLfrontendpage_auth;
import eve.BusinessObject.service.ContractService;
import eve.BusinessObject.service.ContractService.ContractStatus;
import eve.usecases.Frontendpage_auth_usecases;
import eve.usecases.custom.Security_usecases;
import eve.usecases.custom.Downloadcontracts_usecase;
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
@Path("rsdownloadcontracts")
public class RSdownloadcontracts extends RS_json_admin {
    
    private Security_usecases security_usecases = new Security_usecases();
    private Frontendpage_auth_usecases frontendpage_auth_usecases;
    private Downloadcontracts_usecase downloadcontracts_usecase = new Downloadcontracts_usecase();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        String result = "";
        JSONParser parser = new JSONParser();
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            setIsadmin(security_usecases.isadmin(authorisationstring));
            frontendpage_auth_usecases = new Frontendpage_auth_usecases(loggedin);
            boolean authorised = isauthorized();
            String username = Securitycheck.getUsername(authorisationstring);            
            boolean start_requested = json.containsKey("start") && (Boolean)json.get("start");
            boolean stop_requested = json.containsKey("stop") && (Boolean)json.get("stop");
            downloadcontracts_usecase.processRequest(authorised, username, start_requested, stop_requested);
            result = build_JSON_response();
        }
        catch(ParseException | DBException | DatahandlerException | IOException e) {
            result = returnstatus(e.getMessage());
        }
        return result;
    }
    
    public boolean isauthorized() throws DBException, IOException {
        return loggedin && frontendpage_auth_usecases.check_userauthorisation_for_page(authorisationstring, eve.BusinessObject.Logic.BLfrontendpage.DOWNLOADCONTRACT);
    }
    
    private String build_JSON_response() {
        String result;
        JSONObject jsonstatus = new JSONObject();
        JSONArray jsonregions = new JSONArray();
        JSONArray jsonmessages = new JSONArray();
        jsonstatus.put("regions", jsonregions);
        jsonstatus.put("messages", jsonmessages);
        jsonstatus.put("done", true);
        boolean iscontractservice_running = downloadcontracts_usecase.isServiceRunning();
        if(iscontractservice_running)
            build_JSON_response_contractservice_details(jsonregions, jsonmessages, jsonstatus);
        jsonstatus.put("status", "OK");
        result = jsonstatus.toJSONString();
        return result;
    }

    private void build_JSON_response_contractservice_details(JSONArray jsonregions, JSONArray jsonmessages, JSONObject jsonstatus) {
        ContractStatus status = downloadcontracts_usecase.getStatus();
        status.getRegions().forEach((regionid, regionstatus) -> {
            build_JSON_response_contractservice_details_add_region(regionid, regionstatus, jsonregions);
        });
        Iterator<String> messagesI = status.getMessages().iterator();
        while(messagesI.hasNext())
            jsonmessages.add(messagesI.next());
        jsonstatus.put("done", status.isDone());
        if(status.isDone())
            downloadcontracts_usecase.resetContracts();
    }

    private void build_JSON_response_contractservice_details_add_region(Long regionid, ContractService.RegionStatus regionstatus, JSONArray jsonregions) {
        JSONObject jsonregion = new JSONObject();
        jsonregion.put("region", regionid);
        jsonregion.put("name", regionstatus.getName());
        jsonregion.put("totalpages", regionstatus.getTotalpages());
        jsonregion.put("contracts", regionstatus.getContracts());
        jsonregion.put("page", regionstatus.getPage());
        jsonregion.put("done", regionstatus.isDone());
        jsonregions.add(jsonregion);
    }

    private String returnstatus(String status) {
        JSONObject json = new JSONObject();
        json.put("status", status);
        return json.toJSONString();
    }
    
}
