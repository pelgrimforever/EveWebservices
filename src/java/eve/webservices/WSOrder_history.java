/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 23.8.2022 14:38
 * @author Franky Laseure
 */

package eve.webservices;

import base.restservices.RS_json_login;
import eve.BusinessObject.Logic.*;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.searchentity.IOrder_historysearch;
import eve.interfaces.webservice.WSIOrder_history;
import eve.logicentity.Order_history;
import eve.searchentity.Order_historysearch;
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

@WebService(endpointInterface = "eve.interfaces.webservice.WSIOrder_history")
public class WSOrder_history extends RS_json_login implements WSIOrder_history {

    private Security_usecases security_usecases = new Security_usecases();
    
    private JSONArray toJSONArray(ArrayList order_historys) {
        JSONArray jsonorder_historys = new JSONArray();
        Iterator order_historysI = order_historys.iterator();
        while(order_historysI.hasNext()) {
            jsonorder_historys.add(JSONOrder_history.toJSON((Order_history)order_historysI.next()));
        }
        return jsonorder_historys;
    }

    //@WebMethod(operationName = "getOrder_historys")
    @Override
    public String getOrder_historys() {
        try {
            Order_history_usecases order_historyusecases = new Order_history_usecases(loggedin);
            return get_all_order_history(order_historyusecases);
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
            Order_history_usecases order_historyusecases = new Order_history_usecases(loggedin);
            return search_order_history(order_historyusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "getOrder_history")
    @Override
    public String getOrder_history(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Order_history_usecases order_historyusecases = new Order_history_usecases(loggedin);
            return get_order_history_with_primarykey(order_historyusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "insertOrder_history")
    @Override
    public void insertOrder_history(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Order_history_usecases order_historyusecases = new Order_history_usecases(loggedin);
            insert_order_history(order_historyusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "updateOrder_history")
    @Override
    public void updateOrder_history(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Order_history_usecases order_historyusecases = new Order_history_usecases(loggedin);
            update_order_history(order_historyusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "deleteOrder_history")
    @Override
    public void deleteOrder_history(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Order_history_usecases order_historyusecases = new Order_history_usecases(loggedin);
            delete_order_history(order_historyusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getOrder_historys4evetype")
    @Override
    public String getOrder_historys4evetype(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Order_history_usecases order_historyusecases = new Order_history_usecases(loggedin);
            return get_order_history_with_foreignkey_evetype(order_historyusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "delete4evetype")
    @Override
    public void delete4evetype(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Order_history_usecases order_historyusecases = new Order_history_usecases(loggedin);
            delete_order_history(order_historyusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getOrder_historys4region")
    @Override
    public String getOrder_historys4region(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Order_history_usecases order_historyusecases = new Order_history_usecases(loggedin);
            return get_order_history_with_foreignkey_region(order_historyusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "delete4region")
    @Override
    public void delete4region(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Order_history_usecases order_historyusecases = new Order_history_usecases(loggedin);
            delete_order_history(order_historyusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }


    private String count_records(Order_history_usecases order_historyusecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", order_historyusecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_order_history(Order_history_usecases order_historyusecases) throws ParseException, CustomException {
    	return JSONOrder_history.toJSONArray(order_historyusecases.get_all()).toJSONString();
    }
    
    private String get_order_history_with_primarykey(Order_history_usecases order_historyusecases, JSONObject json) throws ParseException, CustomException {
        IOrder_historyPK order_historyPK = (IOrder_historyPK)JSONOrder_history.toOrder_historyPK((JSONObject)json.get("order_historypk"));
	return JSONOrder_history.toJSON(order_historyusecases.get_order_history_by_primarykey(order_historyPK)).toJSONString();
    }
    
    private String get_order_history_with_foreignkey_evetype(Order_history_usecases order_historyusecases, JSONObject json) throws ParseException, CustomException {
        IEvetypePK evetypePK = (IEvetypePK)JSONEvetype.toEvetypePK((JSONObject)json.get("evetypepk"));
        return JSONOrder_history.toJSONArray(order_historyusecases.get_order_history_with_foreignkey_evetype(evetypePK)).toJSONString();
    }
    
    private String get_order_history_with_foreignkey_region(Order_history_usecases order_historyusecases, JSONObject json) throws ParseException, CustomException {
        IRegionPK regionPK = (IRegionPK)JSONRegion.toRegionPK((JSONObject)json.get("regionpk"));
        return JSONOrder_history.toJSONArray(order_historyusecases.get_order_history_with_foreignkey_region(regionPK)).toJSONString();
    }
    
    private String search_order_history(Order_history_usecases order_historyusecases, JSONObject json) throws ParseException, CustomException {
        IOrder_historysearch search = (IOrder_historysearch)JSONOrder_history.toOrder_historysearch((JSONObject)json.get("search"));
        return JSONOrder_history.toJSONArray(order_historyusecases.search_order_history(search)).toJSONString();
    }
    
    private String search_order_history_count(Order_history_usecases order_historyusecases, JSONObject json) throws ParseException, CustomException {
        IOrder_historysearch order_historysearch = (IOrder_historysearch)JSONOrder_history.toOrder_historysearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", order_historyusecases.search_order_history_count(order_historysearch));
        return jsonsearchcount.toJSONString();
    }

    private void insert_order_history(Order_history_usecases order_historyusecases, JSONObject json) throws ParseException, CustomException {
        IOrder_history order_history = (IOrder_history)JSONOrder_history.toOrder_history((JSONObject)json.get("order_history"));
        order_historyusecases.insertOrder_history(order_history);
        setReturnstatus("OK");
    }

    private void update_order_history(Order_history_usecases order_historyusecases, JSONObject json) throws ParseException, CustomException {
        IOrder_history order_history = (IOrder_history)JSONOrder_history.toOrder_history((JSONObject)json.get("order_history"));
        order_historyusecases.updateOrder_history(order_history);
        setReturnstatus("OK");
    }

    private void delete_order_history(Order_history_usecases order_historyusecases, JSONObject json) throws ParseException, CustomException {
        IOrder_history order_history = (IOrder_history)JSONOrder_history.toOrder_history((JSONObject)json.get("order_history"));
        order_historyusecases.deleteOrder_history(order_history);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Evetype(Order_history_usecases order_historyusecases, JSONObject json) throws ParseException, CustomException {
        IEvetypePK evetypePK = (IEvetypePK)JSONEvetype.toEvetypePK((JSONObject)json.get("evetypepk"));
        order_historyusecases.delete_all_containing_Evetype(evetypePK);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Region(Order_history_usecases order_historyusecases, JSONObject json) throws ParseException, CustomException {
        IRegionPK regionPK = (IRegionPK)JSONRegion.toRegionPK((JSONObject)json.get("regionpk"));
        order_historyusecases.delete_all_containing_Region(regionPK);
        setReturnstatus("OK");
    }

}

