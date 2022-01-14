/*
 * WSOrder_history_month.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 14.0.2022 16:56
 *
 */

package eve.webservices;

import eve.BusinessObject.Logic.*;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.webservice.WSIOrder_history_month;
import eve.logicentity.Order_history_month;
import eve.searchentity.Order_history_monthsearch;
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
@WebService(endpointInterface = "eve.interfaces.webservice.WSIOrder_history_month")
public class WSOrder_history_month implements WSIOrder_history_month {

    private JSONArray toJSONArray(ArrayList order_history_months) {
        JSONArray jsonorder_history_months = new JSONArray();
        Iterator order_history_monthsI = order_history_months.iterator();
        while(order_history_monthsI.hasNext()) {
            jsonorder_history_months.add(JSONOrder_history_month.toJSON((Order_history_month)order_history_monthsI.next()));
        }
        return jsonorder_history_months;
    }

    /**
     * Web service operation
     */
    //@WebMethod(operationName = "getOrder_history_months")
    @Override
    public String getOrder_history_months() {
        try {
            BLorder_history_month blorder_history_month = new BLorder_history_month();
            ArrayList order_history_months = blorder_history_month.getAll();
            JSONArray jsonorder_history_months = toJSONArray(order_history_months);
            return jsonorder_history_months.toJSONString();
        }
        catch(DBException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "search")
    @Override
    public String search(String json) {
        BLorder_history_month blorder_history_month = new BLorder_history_month();
        JSONParser parser = new JSONParser();
        String result = "";
        Order_history_month order_history_month;
        try {
            Order_history_monthsearch order_history_monthsearch = JSONOrder_history_month.toOrder_history_monthsearch((JSONObject)parser.parse(json));
            ArrayList order_history_months = blorder_history_month.search(order_history_monthsearch);
            JSONArray jsonorder_history_months = toJSONArray(order_history_months);
            result = jsonorder_history_months.toJSONString();
        }
        catch(ParseException e) {
            result = "";
        }
        catch(DBException e) {
            result = "";
        }
        return result;
    }

    //@WebMethod(operationName = "getOrder_history_month")
    @Override
    public String getOrder_history_month(String json) {
        BLorder_history_month blorder_history_month = new BLorder_history_month();
        JSONParser parser = new JSONParser();
        String result = "";
        Order_history_month order_history_month;
        try {
            Order_history_monthPK order_history_monthPK = JSONOrder_history_month.toOrder_history_monthPK((JSONObject)parser.parse(json));
            order_history_month = blorder_history_month.getOrder_history_month(order_history_monthPK);
            if(order_history_month!=null) {
                result = JSONOrder_history_month.toJSON(order_history_month).toJSONString();
            }
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
        return result;
    }

    //@WebMethod(operationName = "insertOrder_history_month")
    @Override
    public void insertOrder_history_month(String json) {
        BLorder_history_month blorder_history_month = new BLorder_history_month();
        JSONParser parser = new JSONParser();
        try {
            IOrder_history_month order_history_month = JSONOrder_history_month.toOrder_history_month((JSONObject)parser.parse(json));
            blorder_history_month.insertOrder_history_month(order_history_month);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "updateOrder_history_month")
    @Override
    public void updateOrder_history_month(String json) {
        BLorder_history_month blorder_history_month = new BLorder_history_month();
        JSONParser parser = new JSONParser();
        try {
            IOrder_history_month order_history_month = JSONOrder_history_month.toOrder_history_month((JSONObject)parser.parse(json));
            blorder_history_month.updateOrder_history_month(order_history_month);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "deleteOrder_history_month")
    @Override
    public void deleteOrder_history_month(String json) {
        BLorder_history_month blorder_history_month = new BLorder_history_month();
        JSONParser parser = new JSONParser();
        try {
            IOrder_history_month order_history_month = JSONOrder_history_month.toOrder_history_month((JSONObject)parser.parse(json));
            blorder_history_month.deleteOrder_history_month(order_history_month);
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "getOrder_history_months4evetype")
    @Override
    public String getOrder_history_months4evetype(String json) {
        BLorder_history_month blorder_history_month = new BLorder_history_month();
        JSONParser parser = new JSONParser();
        Order_history_month order_history_month;
        try {
            IEvetypePK evetypePK = JSONEvetype.toEvetypePK((JSONObject)parser.parse(json));
            ArrayList order_history_months = blorder_history_month.getOrder_history_months4evetype(evetypePK);
            JSONArray jsonorder_history_months = toJSONArray(order_history_months);
            return jsonorder_history_months.toJSONString();
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
        BLorder_history_month blorder_history_month = new BLorder_history_month();
        JSONParser parser = new JSONParser();
        Order_history_month order_history_month;
        try {
            IEvetypePK evetypePK = JSONEvetype.toEvetypePK((JSONObject)parser.parse(json));
            blorder_history_month.delete4evetype(evetypePK);
        }
        catch(ParseException e) {
        }
    }

    //@WebMethod(operationName = "getOrder_history_months4region")
    @Override
    public String getOrder_history_months4region(String json) {
        BLorder_history_month blorder_history_month = new BLorder_history_month();
        JSONParser parser = new JSONParser();
        Order_history_month order_history_month;
        try {
            IRegionPK regionPK = JSONRegion.toRegionPK((JSONObject)parser.parse(json));
            ArrayList order_history_months = blorder_history_month.getOrder_history_months4region(regionPK);
            JSONArray jsonorder_history_months = toJSONArray(order_history_months);
            return jsonorder_history_months.toJSONString();
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
        BLorder_history_month blorder_history_month = new BLorder_history_month();
        JSONParser parser = new JSONParser();
        Order_history_month order_history_month;
        try {
            IRegionPK regionPK = JSONRegion.toRegionPK((JSONObject)parser.parse(json));
            blorder_history_month.delete4region(regionPK);
        }
        catch(ParseException e) {
        }
    }


}

