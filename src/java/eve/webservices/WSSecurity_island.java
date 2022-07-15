/*
 * WSSecurity_island.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 13.6.2022 18:20
 *
 */

package eve.webservices;

import base.restservices.RS_json_login;
import eve.BusinessObject.Logic.*;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.searchentity.ISecurity_islandsearch;
import eve.interfaces.webservice.WSISecurity_island;
import eve.logicentity.Security_island;
import eve.searchentity.Security_islandsearch;
import eve.usecases.*;
import general.exception.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.jws.WebMethod;
import javax.jws.WebService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import eve.usecases.custom.Security_usecases;

/**
 *
 * @author Franky Laseure
 */
@WebService(endpointInterface = "eve.interfaces.webservice.WSISecurity_island")
public class WSSecurity_island extends RS_json_login implements WSISecurity_island {

    private Security_usecases security_usecases = new Security_usecases();
    
    private JSONArray toJSONArray(ArrayList security_islands) {
        JSONArray jsonsecurity_islands = new JSONArray();
        Iterator security_islandsI = security_islands.iterator();
        while(security_islandsI.hasNext()) {
            jsonsecurity_islands.add(JSONSecurity_island.toJSON((Security_island)security_islandsI.next()));
        }
        return jsonsecurity_islands;
    }

    //@WebMethod(operationName = "getSecurity_islands")
    @Override
    public String getSecurity_islands() {
        try {
            Security_island_usecases security_islandusecases = new Security_island_usecases(loggedin);
            return get_all_security_island(security_islandusecases);
        }
        catch(CustomException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "search")
    @Override
    public String search(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Security_island_usecases security_islandusecases = new Security_island_usecases(loggedin);
            return search_security_island(security_islandusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "getSecurity_island")
    @Override
    public String getSecurity_island(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Security_island_usecases security_islandusecases = new Security_island_usecases(loggedin);
            return get_security_island_with_primarykey(security_islandusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "insertSecurity_island")
    @Override
    public void insertSecurity_island(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Security_island_usecases security_islandusecases = new Security_island_usecases(loggedin);
            insert_security_island(security_islandusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "updateSecurity_island")
    @Override
    public void updateSecurity_island(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Security_island_usecases security_islandusecases = new Security_island_usecases(loggedin);
            update_security_island(security_islandusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "deleteSecurity_island")
    @Override
    public void deleteSecurity_island(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Security_island_usecases security_islandusecases = new Security_island_usecases(loggedin);
            delete_security_island(security_islandusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }


    private String count_records(Security_island_usecases security_islandusecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", security_islandusecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_security_island(Security_island_usecases security_islandusecases) throws ParseException, CustomException {
    	return JSONSecurity_island.toJSONArray(security_islandusecases.get_all()).toJSONString();
    }
    
    private String get_security_island_with_primarykey(Security_island_usecases security_islandusecases, JSONObject json) throws ParseException, CustomException {
        ISecurity_islandPK security_islandPK = (ISecurity_islandPK)JSONSecurity_island.toSecurity_islandPK((JSONObject)json.get("security_islandpk"));
	return JSONSecurity_island.toJSON(security_islandusecases.get_security_island_by_primarykey(security_islandPK)).toJSONString();
    }
    
    private String search_security_island(Security_island_usecases security_islandusecases, JSONObject json) throws ParseException, CustomException {
        ISecurity_islandsearch search = (ISecurity_islandsearch)JSONSecurity_island.toSecurity_islandsearch((JSONObject)json.get("search"));
        return JSONSecurity_island.toJSONArray(security_islandusecases.search_security_island(search)).toJSONString();
    }
    
    private String search_security_island_count(Security_island_usecases security_islandusecases, JSONObject json) throws ParseException, CustomException {
        ISecurity_islandsearch security_islandsearch = (ISecurity_islandsearch)JSONSecurity_island.toSecurity_islandsearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", security_islandusecases.search_security_island_count(security_islandsearch));
        return jsonsearchcount.toJSONString();
    }

    private void insert_security_island(Security_island_usecases security_islandusecases, JSONObject json) throws ParseException, CustomException {
        ISecurity_island security_island = (ISecurity_island)JSONSecurity_island.toSecurity_island((JSONObject)json.get("security_island"));
        security_islandusecases.insertSecurity_island(security_island);
        setReturnstatus("OK");
    }

    private void update_security_island(Security_island_usecases security_islandusecases, JSONObject json) throws ParseException, CustomException {
        ISecurity_island security_island = (ISecurity_island)JSONSecurity_island.toSecurity_island((JSONObject)json.get("security_island"));
        security_islandusecases.updateSecurity_island(security_island);
        setReturnstatus("OK");
    }

    private void delete_security_island(Security_island_usecases security_islandusecases, JSONObject json) throws ParseException, CustomException {
        ISecurity_island security_island = (ISecurity_island)JSONSecurity_island.toSecurity_island((JSONObject)json.get("security_island"));
        security_islandusecases.deleteSecurity_island(security_island);
        setReturnstatus("OK");
    }

}

