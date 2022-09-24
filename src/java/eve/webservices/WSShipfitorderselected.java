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
import eve.interfaces.searchentity.IShipfitorderselectedsearch;
import eve.interfaces.webservice.WSIShipfitorderselected;
import eve.logicentity.Shipfitorderselected;
import eve.searchentity.Shipfitorderselectedsearch;
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

@WebService(endpointInterface = "eve.interfaces.webservice.WSIShipfitorderselected")
public class WSShipfitorderselected extends RS_json_login implements WSIShipfitorderselected {

    private Security_usecases security_usecases = new Security_usecases();
    
    private JSONArray toJSONArray(ArrayList shipfitorderselecteds) {
        JSONArray jsonshipfitorderselecteds = new JSONArray();
        Iterator shipfitorderselectedsI = shipfitorderselecteds.iterator();
        while(shipfitorderselectedsI.hasNext()) {
            jsonshipfitorderselecteds.add(JSONShipfitorderselected.toJSON((Shipfitorderselected)shipfitorderselectedsI.next()));
        }
        return jsonshipfitorderselecteds;
    }

    //@WebMethod(operationName = "getShipfitorderselecteds")
    @Override
    public String getShipfitorderselecteds() {
        try {
            Shipfitorderselected_usecases shipfitorderselectedusecases = new Shipfitorderselected_usecases(loggedin);
            return get_all_shipfitorderselected(shipfitorderselectedusecases);
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
            Shipfitorderselected_usecases shipfitorderselectedusecases = new Shipfitorderselected_usecases(loggedin);
            return search_shipfitorderselected(shipfitorderselectedusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "getShipfitorderselected")
    @Override
    public String getShipfitorderselected(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Shipfitorderselected_usecases shipfitorderselectedusecases = new Shipfitorderselected_usecases(loggedin);
            return get_shipfitorderselected_with_primarykey(shipfitorderselectedusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "insertShipfitorderselected")
    @Override
    public void insertShipfitorderselected(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Shipfitorderselected_usecases shipfitorderselectedusecases = new Shipfitorderselected_usecases(loggedin);
            insert_shipfitorderselected(shipfitorderselectedusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "updateShipfitorderselected")
    @Override
    public void updateShipfitorderselected(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Shipfitorderselected_usecases shipfitorderselectedusecases = new Shipfitorderselected_usecases(loggedin);
            update_shipfitorderselected(shipfitorderselectedusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "deleteShipfitorderselected")
    @Override
    public void deleteShipfitorderselected(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Shipfitorderselected_usecases shipfitorderselectedusecases = new Shipfitorderselected_usecases(loggedin);
            delete_shipfitorderselected(shipfitorderselectedusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getShipfitorderselecteds4orders")
    @Override
    public String getShipfitorderselecteds4orders(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Shipfitorderselected_usecases shipfitorderselectedusecases = new Shipfitorderselected_usecases(loggedin);
            return get_shipfitorderselected_with_foreignkey_orders(shipfitorderselectedusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "delete4orders")
    @Override
    public void delete4orders(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Shipfitorderselected_usecases shipfitorderselectedusecases = new Shipfitorderselected_usecases(loggedin);
            delete_shipfitorderselected(shipfitorderselectedusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getShipfitorderselecteds4shipfitorder")
    @Override
    public String getShipfitorderselecteds4shipfitorder(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Shipfitorderselected_usecases shipfitorderselectedusecases = new Shipfitorderselected_usecases(loggedin);
            return get_shipfitorderselected_with_foreignkey_shipfitorder(shipfitorderselectedusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "delete4shipfitorder")
    @Override
    public void delete4shipfitorder(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Shipfitorderselected_usecases shipfitorderselectedusecases = new Shipfitorderselected_usecases(loggedin);
            delete_shipfitorderselected(shipfitorderselectedusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }


    private String count_records(Shipfitorderselected_usecases shipfitorderselectedusecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", shipfitorderselectedusecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_shipfitorderselected(Shipfitorderselected_usecases shipfitorderselectedusecases) throws ParseException, CustomException {
    	return JSONShipfitorderselected.toJSONArray(shipfitorderselectedusecases.get_all()).toJSONString();
    }
    
    private String get_shipfitorderselected_with_primarykey(Shipfitorderselected_usecases shipfitorderselectedusecases, JSONObject json) throws ParseException, CustomException {
        IShipfitorderselectedPK shipfitorderselectedPK = (IShipfitorderselectedPK)JSONShipfitorderselected.toShipfitorderselectedPK((JSONObject)json.get("shipfitorderselectedpk"));
	return JSONShipfitorderselected.toJSON(shipfitorderselectedusecases.get_shipfitorderselected_by_primarykey(shipfitorderselectedPK)).toJSONString();
    }
    
    private String get_shipfitorderselected_with_foreignkey_orders(Shipfitorderselected_usecases shipfitorderselectedusecases, JSONObject json) throws ParseException, CustomException {
        IOrdersPK ordersPK = (IOrdersPK)JSONOrders.toOrdersPK((JSONObject)json.get("orderspk"));
        return JSONShipfitorderselected.toJSONArray(shipfitorderselectedusecases.get_shipfitorderselected_with_foreignkey_orders(ordersPK)).toJSONString();
    }
    
    private String get_shipfitorderselected_with_foreignkey_shipfitorder(Shipfitorderselected_usecases shipfitorderselectedusecases, JSONObject json) throws ParseException, CustomException {
        IShipfitorderPK shipfitorderPK = (IShipfitorderPK)JSONShipfitorder.toShipfitorderPK((JSONObject)json.get("shipfitorderpk"));
        return JSONShipfitorderselected.toJSONArray(shipfitorderselectedusecases.get_shipfitorderselected_with_foreignkey_shipfitorder(shipfitorderPK)).toJSONString();
    }
    
    private String search_shipfitorderselected(Shipfitorderselected_usecases shipfitorderselectedusecases, JSONObject json) throws ParseException, CustomException {
        IShipfitorderselectedsearch search = (IShipfitorderselectedsearch)JSONShipfitorderselected.toShipfitorderselectedsearch((JSONObject)json.get("search"));
        return JSONShipfitorderselected.toJSONArray(shipfitorderselectedusecases.search_shipfitorderselected(search)).toJSONString();
    }
    
    private String search_shipfitorderselected_count(Shipfitorderselected_usecases shipfitorderselectedusecases, JSONObject json) throws ParseException, CustomException {
        IShipfitorderselectedsearch shipfitorderselectedsearch = (IShipfitorderselectedsearch)JSONShipfitorderselected.toShipfitorderselectedsearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", shipfitorderselectedusecases.search_shipfitorderselected_count(shipfitorderselectedsearch));
        return jsonsearchcount.toJSONString();
    }

    private void insert_shipfitorderselected(Shipfitorderselected_usecases shipfitorderselectedusecases, JSONObject json) throws ParseException, CustomException {
        IShipfitorderselected shipfitorderselected = (IShipfitorderselected)JSONShipfitorderselected.toShipfitorderselected((JSONObject)json.get("shipfitorderselected"));
        shipfitorderselectedusecases.insertShipfitorderselected(shipfitorderselected);
        setReturnstatus("OK");
    }

    private void update_shipfitorderselected(Shipfitorderselected_usecases shipfitorderselectedusecases, JSONObject json) throws ParseException, CustomException {
        IShipfitorderselected shipfitorderselected = (IShipfitorderselected)JSONShipfitorderselected.toShipfitorderselected((JSONObject)json.get("shipfitorderselected"));
        shipfitorderselectedusecases.updateShipfitorderselected(shipfitorderselected);
        setReturnstatus("OK");
    }

    private void delete_shipfitorderselected(Shipfitorderselected_usecases shipfitorderselectedusecases, JSONObject json) throws ParseException, CustomException {
        IShipfitorderselected shipfitorderselected = (IShipfitorderselected)JSONShipfitorderselected.toShipfitorderselected((JSONObject)json.get("shipfitorderselected"));
        shipfitorderselectedusecases.deleteShipfitorderselected(shipfitorderselected);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Orders(Shipfitorderselected_usecases shipfitorderselectedusecases, JSONObject json) throws ParseException, CustomException {
        IOrdersPK ordersPK = (IOrdersPK)JSONOrders.toOrdersPK((JSONObject)json.get("orderspk"));
        shipfitorderselectedusecases.delete_all_containing_Orders(ordersPK);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Shipfitorder(Shipfitorderselected_usecases shipfitorderselectedusecases, JSONObject json) throws ParseException, CustomException {
        IShipfitorderPK shipfitorderPK = (IShipfitorderPK)JSONShipfitorder.toShipfitorderPK((JSONObject)json.get("shipfitorderpk"));
        shipfitorderselectedusecases.delete_all_containing_Shipfitorder(shipfitorderPK);
        setReturnstatus("OK");
    }

}

