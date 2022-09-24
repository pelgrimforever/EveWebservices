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
import eve.interfaces.searchentity.IOrder_history_monthsearch;
import eve.interfaces.webservice.WSIOrder_history_month;
import eve.logicentity.Order_history_month;
import eve.searchentity.Order_history_monthsearch;
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

@WebService(endpointInterface = "eve.interfaces.webservice.WSIOrder_history_month")
public class WSOrder_history_month extends RS_json_login implements WSIOrder_history_month {

    private Security_usecases security_usecases = new Security_usecases();
    
    private JSONArray toJSONArray(ArrayList order_history_months) {
        JSONArray jsonorder_history_months = new JSONArray();
        Iterator order_history_monthsI = order_history_months.iterator();
        while(order_history_monthsI.hasNext()) {
            jsonorder_history_months.add(JSONOrder_history_month.toJSON((Order_history_month)order_history_monthsI.next()));
        }
        return jsonorder_history_months;
    }

    //@WebMethod(operationName = "getOrder_history_months")
    @Override
    public String getOrder_history_months() {
        try {
            Order_history_month_usecases order_history_monthusecases = new Order_history_month_usecases(loggedin);
            return get_all_order_history_month(order_history_monthusecases);
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
            Order_history_month_usecases order_history_monthusecases = new Order_history_month_usecases(loggedin);
            return search_order_history_month(order_history_monthusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "getOrder_history_month")
    @Override
    public String getOrder_history_month(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Order_history_month_usecases order_history_monthusecases = new Order_history_month_usecases(loggedin);
            return get_order_history_month_with_primarykey(order_history_monthusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "insertOrder_history_month")
    @Override
    public void insertOrder_history_month(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Order_history_month_usecases order_history_monthusecases = new Order_history_month_usecases(loggedin);
            insert_order_history_month(order_history_monthusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "updateOrder_history_month")
    @Override
    public void updateOrder_history_month(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Order_history_month_usecases order_history_monthusecases = new Order_history_month_usecases(loggedin);
            update_order_history_month(order_history_monthusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "deleteOrder_history_month")
    @Override
    public void deleteOrder_history_month(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Order_history_month_usecases order_history_monthusecases = new Order_history_month_usecases(loggedin);
            delete_order_history_month(order_history_monthusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getOrder_history_months4evetype")
    @Override
    public String getOrder_history_months4evetype(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Order_history_month_usecases order_history_monthusecases = new Order_history_month_usecases(loggedin);
            return get_order_history_month_with_foreignkey_evetype(order_history_monthusecases, json);
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
            Order_history_month_usecases order_history_monthusecases = new Order_history_month_usecases(loggedin);
            delete_order_history_month(order_history_monthusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getOrder_history_months4region")
    @Override
    public String getOrder_history_months4region(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Order_history_month_usecases order_history_monthusecases = new Order_history_month_usecases(loggedin);
            return get_order_history_month_with_foreignkey_region(order_history_monthusecases, json);
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
            Order_history_month_usecases order_history_monthusecases = new Order_history_month_usecases(loggedin);
            delete_order_history_month(order_history_monthusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }


    private String count_records(Order_history_month_usecases order_history_monthusecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", order_history_monthusecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_order_history_month(Order_history_month_usecases order_history_monthusecases) throws ParseException, CustomException {
    	return JSONOrder_history_month.toJSONArray(order_history_monthusecases.get_all()).toJSONString();
    }
    
    private String get_order_history_month_with_primarykey(Order_history_month_usecases order_history_monthusecases, JSONObject json) throws ParseException, CustomException {
        IOrder_history_monthPK order_history_monthPK = (IOrder_history_monthPK)JSONOrder_history_month.toOrder_history_monthPK((JSONObject)json.get("order_history_monthpk"));
	return JSONOrder_history_month.toJSON(order_history_monthusecases.get_order_history_month_by_primarykey(order_history_monthPK)).toJSONString();
    }
    
    private String get_order_history_month_with_foreignkey_evetype(Order_history_month_usecases order_history_monthusecases, JSONObject json) throws ParseException, CustomException {
        IEvetypePK evetypePK = (IEvetypePK)JSONEvetype.toEvetypePK((JSONObject)json.get("evetypepk"));
        return JSONOrder_history_month.toJSONArray(order_history_monthusecases.get_order_history_month_with_foreignkey_evetype(evetypePK)).toJSONString();
    }
    
    private String get_order_history_month_with_foreignkey_region(Order_history_month_usecases order_history_monthusecases, JSONObject json) throws ParseException, CustomException {
        IRegionPK regionPK = (IRegionPK)JSONRegion.toRegionPK((JSONObject)json.get("regionpk"));
        return JSONOrder_history_month.toJSONArray(order_history_monthusecases.get_order_history_month_with_foreignkey_region(regionPK)).toJSONString();
    }
    
    private String search_order_history_month(Order_history_month_usecases order_history_monthusecases, JSONObject json) throws ParseException, CustomException {
        IOrder_history_monthsearch search = (IOrder_history_monthsearch)JSONOrder_history_month.toOrder_history_monthsearch((JSONObject)json.get("search"));
        return JSONOrder_history_month.toJSONArray(order_history_monthusecases.search_order_history_month(search)).toJSONString();
    }
    
    private String search_order_history_month_count(Order_history_month_usecases order_history_monthusecases, JSONObject json) throws ParseException, CustomException {
        IOrder_history_monthsearch order_history_monthsearch = (IOrder_history_monthsearch)JSONOrder_history_month.toOrder_history_monthsearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", order_history_monthusecases.search_order_history_month_count(order_history_monthsearch));
        return jsonsearchcount.toJSONString();
    }

    private void insert_order_history_month(Order_history_month_usecases order_history_monthusecases, JSONObject json) throws ParseException, CustomException {
        IOrder_history_month order_history_month = (IOrder_history_month)JSONOrder_history_month.toOrder_history_month((JSONObject)json.get("order_history_month"));
        order_history_monthusecases.insertOrder_history_month(order_history_month);
        setReturnstatus("OK");
    }

    private void update_order_history_month(Order_history_month_usecases order_history_monthusecases, JSONObject json) throws ParseException, CustomException {
        IOrder_history_month order_history_month = (IOrder_history_month)JSONOrder_history_month.toOrder_history_month((JSONObject)json.get("order_history_month"));
        order_history_monthusecases.updateOrder_history_month(order_history_month);
        setReturnstatus("OK");
    }

    private void delete_order_history_month(Order_history_month_usecases order_history_monthusecases, JSONObject json) throws ParseException, CustomException {
        IOrder_history_month order_history_month = (IOrder_history_month)JSONOrder_history_month.toOrder_history_month((JSONObject)json.get("order_history_month"));
        order_history_monthusecases.deleteOrder_history_month(order_history_month);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Evetype(Order_history_month_usecases order_history_monthusecases, JSONObject json) throws ParseException, CustomException {
        IEvetypePK evetypePK = (IEvetypePK)JSONEvetype.toEvetypePK((JSONObject)json.get("evetypepk"));
        order_history_monthusecases.delete_all_containing_Evetype(evetypePK);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Region(Order_history_month_usecases order_history_monthusecases, JSONObject json) throws ParseException, CustomException {
        IRegionPK regionPK = (IRegionPK)JSONRegion.toRegionPK((JSONObject)json.get("regionpk"));
        order_history_monthusecases.delete_all_containing_Region(regionPK);
        setReturnstatus("OK");
    }

}

