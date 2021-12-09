/*
 * WSJson_orders.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 9.11.2021 14:30
 *
 */

package eve.webservices;

import eve.BusinessObject.Logic.*;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.webservice.WSIJson_orders;
import eve.logicentity.Json_orders;
import eve.searchentity.Json_orderssearch;
import general.exception.CustomException;
import general.exception.DataException;
import general.exception.DBException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.jws.WebMethod;
import javax.jws.WebService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Franky Laseure
 */
@WebService(endpointInterface = "eve.interfaces.webservice.WSIJson_orders")
public class WSJson_orders implements WSIJson_orders {

    private JSONArray toJSONArray(ArrayList json_orderss) {
        JSONArray jsonjson_orderss = new JSONArray();
        Iterator json_orderssI = json_orderss.iterator();
        while(json_orderssI.hasNext()) {
            jsonjson_orderss.add(JSONJson_orders.toJSON((Json_orders)json_orderssI.next()));
        }
        return jsonjson_orderss;
    }

    /**
     * Web service operation
     */
    //@WebMethod(operationName = "getJson_orderss")
    @Override
    public String getJson_orderss() {
        try {
            BLjson_orders bljson_orders = new BLjson_orders();
            ArrayList json_orderss = bljson_orders.getAll();
            JSONArray jsonjson_orderss = toJSONArray(json_orderss);
            return jsonjson_orderss.toJSONString();
        }
        catch(DBException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "search")
    @Override
    public String search(String json) {
        BLjson_orders bljson_orders = new BLjson_orders();
        JSONParser parser = new JSONParser();
        String result = "";
        Json_orders json_orders;
        try {
            Json_orderssearch json_orderssearch = JSONJson_orders.toJson_orderssearch((JSONObject)parser.parse(json));
            ArrayList json_orderss = bljson_orders.search(json_orderssearch);
            JSONArray jsonjson_orderss = toJSONArray(json_orderss);
            result = jsonjson_orderss.toJSONString();
        }
        catch(ParseException e) {
            result = "";
        }
        catch(DBException e) {
            result = "";
        }
        return result;
    }

    //@WebMethod(operationName = "getJson_orders")
    @Override
    public String getJson_orders(String json) {
        BLjson_orders bljson_orders = new BLjson_orders();
        JSONParser parser = new JSONParser();
        String result = "";
        Json_orders json_orders;
        try {
            Json_ordersPK json_ordersPK = JSONJson_orders.toJson_ordersPK((JSONObject)parser.parse(json));
            json_orders = bljson_orders.getJson_orders(json_ordersPK);
            if(json_orders!=null) {
                result = JSONJson_orders.toJSON(json_orders).toJSONString();
            }
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
        return result;
    }

    //@WebMethod(operationName = "insertJson_orders")
    @Override
    public void insertJson_orders(String json) {
        BLjson_orders bljson_orders = new BLjson_orders();
        JSONParser parser = new JSONParser();
        try {
            IJson_orders json_orders = JSONJson_orders.toJson_orders((JSONObject)parser.parse(json));
            bljson_orders.insertJson_orders(json_orders);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "updateJson_orders")
    @Override
    public void updateJson_orders(String json) {
        BLjson_orders bljson_orders = new BLjson_orders();
        JSONParser parser = new JSONParser();
        try {
            IJson_orders json_orders = JSONJson_orders.toJson_orders((JSONObject)parser.parse(json));
            bljson_orders.updateJson_orders(json_orders);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "deleteJson_orders")
    @Override
    public void deleteJson_orders(String json) {
        BLjson_orders bljson_orders = new BLjson_orders();
        JSONParser parser = new JSONParser();
        try {
            IJson_orders json_orders = JSONJson_orders.toJson_orders((JSONObject)parser.parse(json));
            bljson_orders.deleteJson_orders(json_orders);
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
    }


}

