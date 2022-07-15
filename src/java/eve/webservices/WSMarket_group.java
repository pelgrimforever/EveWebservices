/*
 * WSMarket_group.java
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
import eve.interfaces.searchentity.IMarket_groupsearch;
import eve.interfaces.webservice.WSIMarket_group;
import eve.logicentity.Market_group;
import eve.searchentity.Market_groupsearch;
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
@WebService(endpointInterface = "eve.interfaces.webservice.WSIMarket_group")
public class WSMarket_group extends RS_json_login implements WSIMarket_group {

    private Security_usecases security_usecases = new Security_usecases();
    
    private JSONArray toJSONArray(ArrayList market_groups) {
        JSONArray jsonmarket_groups = new JSONArray();
        Iterator market_groupsI = market_groups.iterator();
        while(market_groupsI.hasNext()) {
            jsonmarket_groups.add(JSONMarket_group.toJSON((Market_group)market_groupsI.next()));
        }
        return jsonmarket_groups;
    }

    //@WebMethod(operationName = "getMarket_groups")
    @Override
    public String getMarket_groups() {
        try {
            Market_group_usecases market_groupusecases = new Market_group_usecases(loggedin);
            return get_all_market_group(market_groupusecases);
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
            Market_group_usecases market_groupusecases = new Market_group_usecases(loggedin);
            return search_market_group(market_groupusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "getMarket_group")
    @Override
    public String getMarket_group(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Market_group_usecases market_groupusecases = new Market_group_usecases(loggedin);
            return get_market_group_with_primarykey(market_groupusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "insertMarket_group")
    @Override
    public void insertMarket_group(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Market_group_usecases market_groupusecases = new Market_group_usecases(loggedin);
            insert_market_group(market_groupusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "updateMarket_group")
    @Override
    public void updateMarket_group(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Market_group_usecases market_groupusecases = new Market_group_usecases(loggedin);
            update_market_group(market_groupusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "deleteMarket_group")
    @Override
    public void deleteMarket_group(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Market_group_usecases market_groupusecases = new Market_group_usecases(loggedin);
            delete_market_group(market_groupusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getMarket_groups4market_groupParent_id")
    @Override
    public String getMarket_groups4market_groupParent_id(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Market_group_usecases market_groupusecases = new Market_group_usecases(loggedin);
            return get_market_group_with_foreignkey_market_groupParent_id(market_groupusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "delete4market_groupParent_id")
    @Override
    public void delete4market_groupParent_id(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Market_group_usecases market_groupusecases = new Market_group_usecases(loggedin);
            delete_market_group(market_groupusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }


    private String count_records(Market_group_usecases market_groupusecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", market_groupusecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_market_group(Market_group_usecases market_groupusecases) throws ParseException, CustomException {
    	return JSONMarket_group.toJSONArray(market_groupusecases.get_all()).toJSONString();
    }
    
    private String get_market_group_with_primarykey(Market_group_usecases market_groupusecases, JSONObject json) throws ParseException, CustomException {
        IMarket_groupPK market_groupPK = (IMarket_groupPK)JSONMarket_group.toMarket_groupPK((JSONObject)json.get("market_grouppk"));
	return JSONMarket_group.toJSON(market_groupusecases.get_market_group_by_primarykey(market_groupPK)).toJSONString();
    }
    
    private String get_market_group_with_foreignkey_market_groupParent_id(Market_group_usecases market_groupusecases, JSONObject json) throws ParseException, CustomException {
        IMarket_groupPK market_groupParent_idPK = (IMarket_groupPK)JSONMarket_group.toMarket_groupPK((JSONObject)json.get("market_grouppk"));
        return JSONMarket_group.toJSONArray(market_groupusecases.get_market_group_with_foreignkey_market_groupParent_id(market_groupParent_idPK)).toJSONString();
    }
    
    private String search_market_group(Market_group_usecases market_groupusecases, JSONObject json) throws ParseException, CustomException {
        IMarket_groupsearch search = (IMarket_groupsearch)JSONMarket_group.toMarket_groupsearch((JSONObject)json.get("search"));
        return JSONMarket_group.toJSONArray(market_groupusecases.search_market_group(search)).toJSONString();
    }
    
    private String search_market_group_count(Market_group_usecases market_groupusecases, JSONObject json) throws ParseException, CustomException {
        IMarket_groupsearch market_groupsearch = (IMarket_groupsearch)JSONMarket_group.toMarket_groupsearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", market_groupusecases.search_market_group_count(market_groupsearch));
        return jsonsearchcount.toJSONString();
    }

    private void insert_market_group(Market_group_usecases market_groupusecases, JSONObject json) throws ParseException, CustomException {
        IMarket_group market_group = (IMarket_group)JSONMarket_group.toMarket_group((JSONObject)json.get("market_group"));
        market_groupusecases.insertMarket_group(market_group);
        setReturnstatus("OK");
    }

    private void update_market_group(Market_group_usecases market_groupusecases, JSONObject json) throws ParseException, CustomException {
        IMarket_group market_group = (IMarket_group)JSONMarket_group.toMarket_group((JSONObject)json.get("market_group"));
        market_groupusecases.updateMarket_group(market_group);
        setReturnstatus("OK");
    }

    private void delete_market_group(Market_group_usecases market_groupusecases, JSONObject json) throws ParseException, CustomException {
        IMarket_group market_group = (IMarket_group)JSONMarket_group.toMarket_group((JSONObject)json.get("market_group"));
        market_groupusecases.deleteMarket_group(market_group);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Market_groupparent_id(Market_group_usecases market_groupusecases, JSONObject json) throws ParseException, CustomException {
        IMarket_groupPK market_groupParent_idPK = (IMarket_groupPK)JSONMarket_group.toMarket_groupPK((JSONObject)json.get("market_grouppk"));
        market_groupusecases.delete_all_containing_Market_groupparent_id(market_groupParent_idPK);
        setReturnstatus("OK");
    }

}

