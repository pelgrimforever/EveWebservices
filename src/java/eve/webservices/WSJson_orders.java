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
import eve.interfaces.searchentity.IJson_orderssearch;
import eve.interfaces.webservice.WSIJson_orders;
import eve.logicentity.Json_orders;
import eve.searchentity.Json_orderssearch;
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

@WebService(endpointInterface = "eve.interfaces.webservice.WSIJson_orders")
public class WSJson_orders extends RS_json_login implements WSIJson_orders {

    private Security_usecases security_usecases = new Security_usecases();
    
    private JSONArray toJSONArray(ArrayList json_orderss) {
        JSONArray jsonjson_orderss = new JSONArray();
        Iterator json_orderssI = json_orderss.iterator();
        while(json_orderssI.hasNext()) {
            jsonjson_orderss.add(JSONJson_orders.toJSON((Json_orders)json_orderssI.next()));
        }
        return jsonjson_orderss;
    }

    //@WebMethod(operationName = "getJson_orderss")
    @Override
    public String getJson_orderss() {
        try {
            Json_orders_usecases json_ordersusecases = new Json_orders_usecases(loggedin);
            return get_all_json_orders(json_ordersusecases);
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
            Json_orders_usecases json_ordersusecases = new Json_orders_usecases(loggedin);
            return search_json_orders(json_ordersusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "getJson_orders")
    @Override
    public String getJson_orders(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Json_orders_usecases json_ordersusecases = new Json_orders_usecases(loggedin);
            return get_json_orders_with_primarykey(json_ordersusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "insertJson_orders")
    @Override
    public void insertJson_orders(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Json_orders_usecases json_ordersusecases = new Json_orders_usecases(loggedin);
            insert_json_orders(json_ordersusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "updateJson_orders")
    @Override
    public void updateJson_orders(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Json_orders_usecases json_ordersusecases = new Json_orders_usecases(loggedin);
            update_json_orders(json_ordersusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "deleteJson_orders")
    @Override
    public void deleteJson_orders(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Json_orders_usecases json_ordersusecases = new Json_orders_usecases(loggedin);
            delete_json_orders(json_ordersusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }


    private String count_records(Json_orders_usecases json_ordersusecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", json_ordersusecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_json_orders(Json_orders_usecases json_ordersusecases) throws ParseException, CustomException {
    	return JSONJson_orders.toJSONArray(json_ordersusecases.get_all()).toJSONString();
    }
    
    private String get_json_orders_with_primarykey(Json_orders_usecases json_ordersusecases, JSONObject json) throws ParseException, CustomException {
        IJson_ordersPK json_ordersPK = (IJson_ordersPK)JSONJson_orders.toJson_ordersPK((JSONObject)json.get("json_orderspk"));
	return JSONJson_orders.toJSON(json_ordersusecases.get_json_orders_by_primarykey(json_ordersPK)).toJSONString();
    }
    
    private String search_json_orders(Json_orders_usecases json_ordersusecases, JSONObject json) throws ParseException, CustomException {
        IJson_orderssearch search = (IJson_orderssearch)JSONJson_orders.toJson_orderssearch((JSONObject)json.get("search"));
        return JSONJson_orders.toJSONArray(json_ordersusecases.search_json_orders(search)).toJSONString();
    }
    
    private String search_json_orders_count(Json_orders_usecases json_ordersusecases, JSONObject json) throws ParseException, CustomException {
        IJson_orderssearch json_orderssearch = (IJson_orderssearch)JSONJson_orders.toJson_orderssearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", json_ordersusecases.search_json_orders_count(json_orderssearch));
        return jsonsearchcount.toJSONString();
    }

    private void insert_json_orders(Json_orders_usecases json_ordersusecases, JSONObject json) throws ParseException, CustomException {
        IJson_orders json_orders = (IJson_orders)JSONJson_orders.toJson_orders((JSONObject)json.get("json_orders"));
        json_ordersusecases.insertJson_orders(json_orders);
        setReturnstatus("OK");
    }

    private void update_json_orders(Json_orders_usecases json_ordersusecases, JSONObject json) throws ParseException, CustomException {
        IJson_orders json_orders = (IJson_orders)JSONJson_orders.toJson_orders((JSONObject)json.get("json_orders"));
        json_ordersusecases.updateJson_orders(json_orders);
        setReturnstatus("OK");
    }

    private void delete_json_orders(Json_orders_usecases json_ordersusecases, JSONObject json) throws ParseException, CustomException {
        IJson_orders json_orders = (IJson_orders)JSONJson_orders.toJson_orders((JSONObject)json.get("json_orders"));
        json_ordersusecases.deleteJson_orders(json_orders);
        setReturnstatus("OK");
    }

}

