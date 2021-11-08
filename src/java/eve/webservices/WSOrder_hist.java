/*
 * WSOrder_hist.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 8.10.2021 7:21
 *
 */

package eve.webservices;

import eve.BusinessObject.Logic.*;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.webservice.WSIOrder_hist;
import eve.logicentity.Order_hist;
import eve.searchentity.Order_histsearch;
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
@WebService(endpointInterface = "eve.interfaces.webservice.WSIOrder_hist")
public class WSOrder_hist implements WSIOrder_hist {

    private JSONArray toJSONArray(ArrayList order_hists) {
        JSONArray jsonorder_hists = new JSONArray();
        Iterator order_histsI = order_hists.iterator();
        while(order_histsI.hasNext()) {
            jsonorder_hists.add(JSONOrder_hist.toJSON((Order_hist)order_histsI.next()));
        }
        return jsonorder_hists;
    }

    /**
     * Web service operation
     */
    //@WebMethod(operationName = "getOrder_hists")
    @Override
    public String getOrder_hists() {
        try {
            BLorder_hist blorder_hist = new BLorder_hist();
            ArrayList order_hists = blorder_hist.getAll();
            JSONArray jsonorder_hists = toJSONArray(order_hists);
            return jsonorder_hists.toJSONString();
        }
        catch(DBException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "search")
    @Override
    public String search(String json) {
        BLorder_hist blorder_hist = new BLorder_hist();
        JSONParser parser = new JSONParser();
        String result = "";
        Order_hist order_hist;
        try {
            Order_histsearch order_histsearch = JSONOrder_hist.toOrder_histsearch((JSONObject)parser.parse(json));
            ArrayList order_hists = blorder_hist.search(order_histsearch);
            JSONArray jsonorder_hists = toJSONArray(order_hists);
            result = jsonorder_hists.toJSONString();
        }
        catch(ParseException e) {
            result = "";
        }
        catch(DBException e) {
            result = "";
        }
        return result;
    }

    //@WebMethod(operationName = "getOrder_hist")
    @Override
    public String getOrder_hist(String json) {
        BLorder_hist blorder_hist = new BLorder_hist();
        JSONParser parser = new JSONParser();
        String result = "";
        Order_hist order_hist;
        try {
            Order_histPK order_histPK = JSONOrder_hist.toOrder_histPK((JSONObject)parser.parse(json));
            order_hist = blorder_hist.getOrder_hist(order_histPK);
            if(order_hist!=null) {
                result = JSONOrder_hist.toJSON(order_hist).toJSONString();
            }
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
        return result;
    }

    //@WebMethod(operationName = "insertOrder_hist")
    @Override
    public void insertOrder_hist(String json) {
        BLorder_hist blorder_hist = new BLorder_hist();
        JSONParser parser = new JSONParser();
        try {
            IOrder_hist order_hist = JSONOrder_hist.toOrder_hist((JSONObject)parser.parse(json));
            blorder_hist.insertOrder_hist(order_hist);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "updateOrder_hist")
    @Override
    public void updateOrder_hist(String json) {
        BLorder_hist blorder_hist = new BLorder_hist();
        JSONParser parser = new JSONParser();
        try {
            IOrder_hist order_hist = JSONOrder_hist.toOrder_hist((JSONObject)parser.parse(json));
            blorder_hist.updateOrder_hist(order_hist);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "deleteOrder_hist")
    @Override
    public void deleteOrder_hist(String json) {
        BLorder_hist blorder_hist = new BLorder_hist();
        JSONParser parser = new JSONParser();
        try {
            IOrder_hist order_hist = JSONOrder_hist.toOrder_hist((JSONObject)parser.parse(json));
            blorder_hist.deleteOrder_hist(order_hist);
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "getOrder_hists4evetype")
    @Override
    public String getOrder_hists4evetype(String json) {
        BLorder_hist blorder_hist = new BLorder_hist();
        JSONParser parser = new JSONParser();
        Order_hist order_hist;
        try {
            IEvetypePK evetypePK = JSONEvetype.toEvetypePK((JSONObject)parser.parse(json));
            ArrayList order_hists = blorder_hist.getOrder_hists4evetype(evetypePK);
            JSONArray jsonorder_hists = toJSONArray(order_hists);
            return jsonorder_hists.toJSONString();
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
        BLorder_hist blorder_hist = new BLorder_hist();
        JSONParser parser = new JSONParser();
        Order_hist order_hist;
        try {
            IEvetypePK evetypePK = JSONEvetype.toEvetypePK((JSONObject)parser.parse(json));
            blorder_hist.delete4evetype(evetypePK);
        }
        catch(ParseException e) {
        }
    }

    //@WebMethod(operationName = "getOrder_hists4system")
    @Override
    public String getOrder_hists4system(String json) {
        BLorder_hist blorder_hist = new BLorder_hist();
        JSONParser parser = new JSONParser();
        Order_hist order_hist;
        try {
            ISystemPK systemPK = JSONSystem.toSystemPK((JSONObject)parser.parse(json));
            ArrayList order_hists = blorder_hist.getOrder_hists4system(systemPK);
            JSONArray jsonorder_hists = toJSONArray(order_hists);
            return jsonorder_hists.toJSONString();
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

    //@WebMethod(operationName = "delete4system")
    @Override
    public void delete4system(String json) {
        BLorder_hist blorder_hist = new BLorder_hist();
        JSONParser parser = new JSONParser();
        Order_hist order_hist;
        try {
            ISystemPK systemPK = JSONSystem.toSystemPK((JSONObject)parser.parse(json));
            blorder_hist.delete4system(systemPK);
        }
        catch(ParseException e) {
        }
    }


}

