/*
 * WSOrder_history.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 30.10.2021 10:3
 *
 */

package eve.webservices;

import eve.BusinessObject.Logic.*;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.webservice.WSIOrder_history;
import eve.logicentity.Order_history;
import eve.searchentity.Order_historysearch;
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
@WebService(endpointInterface = "eve.interfaces.webservice.WSIOrder_history")
public class WSOrder_history implements WSIOrder_history {

    private JSONArray toJSONArray(ArrayList order_historys) {
        JSONArray jsonorder_historys = new JSONArray();
        Iterator order_historysI = order_historys.iterator();
        while(order_historysI.hasNext()) {
            jsonorder_historys.add(JSONOrder_history.toJSON((Order_history)order_historysI.next()));
        }
        return jsonorder_historys;
    }

    /**
     * Web service operation
     */
    //@WebMethod(operationName = "getOrder_historys")
    @Override
    public String getOrder_historys() {
        try {
            BLorder_history blorder_history = new BLorder_history();
            ArrayList order_historys = blorder_history.getAll();
            JSONArray jsonorder_historys = toJSONArray(order_historys);
            return jsonorder_historys.toJSONString();
        }
        catch(DBException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "search")
    @Override
    public String search(String json) {
        BLorder_history blorder_history = new BLorder_history();
        JSONParser parser = new JSONParser();
        String result = "";
        Order_history order_history;
        try {
            Order_historysearch order_historysearch = JSONOrder_history.toOrder_historysearch((JSONObject)parser.parse(json));
            ArrayList order_historys = blorder_history.search(order_historysearch);
            JSONArray jsonorder_historys = toJSONArray(order_historys);
            result = jsonorder_historys.toJSONString();
        }
        catch(ParseException e) {
            result = "";
        }
        catch(DBException e) {
            result = "";
        }
        return result;
    }

    //@WebMethod(operationName = "getOrder_history")
    @Override
    public String getOrder_history(String json) {
        BLorder_history blorder_history = new BLorder_history();
        JSONParser parser = new JSONParser();
        String result = "";
        Order_history order_history;
        try {
            Order_historyPK order_historyPK = JSONOrder_history.toOrder_historyPK((JSONObject)parser.parse(json));
            order_history = blorder_history.getOrder_history(order_historyPK);
            if(order_history!=null) {
                result = JSONOrder_history.toJSON(order_history).toJSONString();
            }
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
        return result;
    }

    //@WebMethod(operationName = "insertOrder_history")
    @Override
    public void insertOrder_history(String json) {
        BLorder_history blorder_history = new BLorder_history();
        JSONParser parser = new JSONParser();
        try {
            IOrder_history order_history = JSONOrder_history.toOrder_history((JSONObject)parser.parse(json));
            blorder_history.insertOrder_history(order_history);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "updateOrder_history")
    @Override
    public void updateOrder_history(String json) {
        BLorder_history blorder_history = new BLorder_history();
        JSONParser parser = new JSONParser();
        try {
            IOrder_history order_history = JSONOrder_history.toOrder_history((JSONObject)parser.parse(json));
            blorder_history.updateOrder_history(order_history);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "deleteOrder_history")
    @Override
    public void deleteOrder_history(String json) {
        BLorder_history blorder_history = new BLorder_history();
        JSONParser parser = new JSONParser();
        try {
            IOrder_history order_history = JSONOrder_history.toOrder_history((JSONObject)parser.parse(json));
            blorder_history.deleteOrder_history(order_history);
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "getOrder_historys4evetype")
    @Override
    public String getOrder_historys4evetype(String json) {
        BLorder_history blorder_history = new BLorder_history();
        JSONParser parser = new JSONParser();
        Order_history order_history;
        try {
            IEvetypePK evetypePK = JSONEvetype.toEvetypePK((JSONObject)parser.parse(json));
            ArrayList order_historys = blorder_history.getOrder_historys4evetype(evetypePK);
            JSONArray jsonorder_historys = toJSONArray(order_historys);
            return jsonorder_historys.toJSONString();
        }
        catch(ParseException e) {
            return null;
        }
        catch(DBException e) {
            return null;
        }
        catch(CustomException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "delete4evetype")
    @Override
    public void delete4evetype(String json) {
        BLorder_history blorder_history = new BLorder_history();
        JSONParser parser = new JSONParser();
        Order_history order_history;
        try {
            IEvetypePK evetypePK = JSONEvetype.toEvetypePK((JSONObject)parser.parse(json));
            blorder_history.delete4evetype(evetypePK);
        }
        catch(ParseException e) {
        }
    }

    //@WebMethod(operationName = "getOrder_historys4region")
    @Override
    public String getOrder_historys4region(String json) {
        BLorder_history blorder_history = new BLorder_history();
        JSONParser parser = new JSONParser();
        Order_history order_history;
        try {
            IRegionPK regionPK = JSONRegion.toRegionPK((JSONObject)parser.parse(json));
            ArrayList order_historys = blorder_history.getOrder_historys4region(regionPK);
            JSONArray jsonorder_historys = toJSONArray(order_historys);
            return jsonorder_historys.toJSONString();
        }
        catch(ParseException e) {
            return null;
        }
        catch(DBException e) {
            return null;
        }
        catch(CustomException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "delete4region")
    @Override
    public void delete4region(String json) {
        BLorder_history blorder_history = new BLorder_history();
        JSONParser parser = new JSONParser();
        Order_history order_history;
        try {
            IRegionPK regionPK = JSONRegion.toRegionPK((JSONObject)parser.parse(json));
            blorder_history.delete4region(regionPK);
        }
        catch(ParseException e) {
        }
    }


}

