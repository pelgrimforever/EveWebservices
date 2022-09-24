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
import eve.interfaces.searchentity.IShipfitordersearch;
import eve.interfaces.webservice.WSIShipfitorder;
import eve.logicentity.Shipfitorder;
import eve.searchentity.Shipfitordersearch;
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

@WebService(endpointInterface = "eve.interfaces.webservice.WSIShipfitorder")
public class WSShipfitorder extends RS_json_login implements WSIShipfitorder {

    private Security_usecases security_usecases = new Security_usecases();
    
    private JSONArray toJSONArray(ArrayList shipfitorders) {
        JSONArray jsonshipfitorders = new JSONArray();
        Iterator shipfitordersI = shipfitorders.iterator();
        while(shipfitordersI.hasNext()) {
            jsonshipfitorders.add(JSONShipfitorder.toJSON((Shipfitorder)shipfitordersI.next()));
        }
        return jsonshipfitorders;
    }

    //@WebMethod(operationName = "getShipfitorders")
    @Override
    public String getShipfitorders() {
        try {
            Shipfitorder_usecases shipfitorderusecases = new Shipfitorder_usecases(loggedin);
            return get_all_shipfitorder(shipfitorderusecases);
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
            Shipfitorder_usecases shipfitorderusecases = new Shipfitorder_usecases(loggedin);
            return search_shipfitorder(shipfitorderusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "getShipfitorder")
    @Override
    public String getShipfitorder(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Shipfitorder_usecases shipfitorderusecases = new Shipfitorder_usecases(loggedin);
            return get_shipfitorder_with_primarykey(shipfitorderusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "insertShipfitorder")
    @Override
    public void insertShipfitorder(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Shipfitorder_usecases shipfitorderusecases = new Shipfitorder_usecases(loggedin);
            insert_shipfitorder(shipfitorderusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "updateShipfitorder")
    @Override
    public void updateShipfitorder(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Shipfitorder_usecases shipfitorderusecases = new Shipfitorder_usecases(loggedin);
            update_shipfitorder(shipfitorderusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "deleteShipfitorder")
    @Override
    public void deleteShipfitorder(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Shipfitorder_usecases shipfitorderusecases = new Shipfitorder_usecases(loggedin);
            delete_shipfitorder(shipfitorderusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getShipfitorders4shipfit")
    @Override
    public String getShipfitorders4shipfit(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Shipfitorder_usecases shipfitorderusecases = new Shipfitorder_usecases(loggedin);
            return get_shipfitorder_with_foreignkey_shipfit(shipfitorderusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "delete4shipfit")
    @Override
    public void delete4shipfit(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Shipfitorder_usecases shipfitorderusecases = new Shipfitorder_usecases(loggedin);
            delete_shipfitorder(shipfitorderusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getShipfitorders4evetype")
    @Override
    public String getShipfitorders4evetype(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Shipfitorder_usecases shipfitorderusecases = new Shipfitorder_usecases(loggedin);
            return get_shipfitorder_with_foreignkey_evetype(shipfitorderusecases, json);
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
            Shipfitorder_usecases shipfitorderusecases = new Shipfitorder_usecases(loggedin);
            delete_shipfitorder(shipfitorderusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getShipfitorders4shipfitorderselected")
    @Override
    public String getShipfitorders4shipfitorderselected(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Shipfitorder_usecases shipfitorderusecases = new Shipfitorder_usecases(loggedin);
            return get_shipfitorder_with_externalforeignkey_shipfitorderselected(shipfitorderusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }


    private String count_records(Shipfitorder_usecases shipfitorderusecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", shipfitorderusecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_shipfitorder(Shipfitorder_usecases shipfitorderusecases) throws ParseException, CustomException {
    	return JSONShipfitorder.toJSONArray(shipfitorderusecases.get_all()).toJSONString();
    }
    
    private String get_shipfitorder_with_primarykey(Shipfitorder_usecases shipfitorderusecases, JSONObject json) throws ParseException, CustomException {
        IShipfitorderPK shipfitorderPK = (IShipfitorderPK)JSONShipfitorder.toShipfitorderPK((JSONObject)json.get("shipfitorderpk"));
	return JSONShipfitorder.toJSON(shipfitorderusecases.get_shipfitorder_by_primarykey(shipfitorderPK)).toJSONString();
    }
    
    private String get_shipfitorder_with_foreignkey_shipfit(Shipfitorder_usecases shipfitorderusecases, JSONObject json) throws ParseException, CustomException {
        IShipfitPK shipfitPK = (IShipfitPK)JSONShipfit.toShipfitPK((JSONObject)json.get("shipfitpk"));
        return JSONShipfitorder.toJSONArray(shipfitorderusecases.get_shipfitorder_with_foreignkey_shipfit(shipfitPK)).toJSONString();
    }
    
    private String get_shipfitorder_with_foreignkey_evetype(Shipfitorder_usecases shipfitorderusecases, JSONObject json) throws ParseException, CustomException {
        IEvetypePK evetypePK = (IEvetypePK)JSONEvetype.toEvetypePK((JSONObject)json.get("evetypepk"));
        return JSONShipfitorder.toJSONArray(shipfitorderusecases.get_shipfitorder_with_foreignkey_evetype(evetypePK)).toJSONString();
    }
    
    private String get_shipfitorder_with_externalforeignkey_shipfitorderselected(Shipfitorder_usecases shipfitorderusecases, JSONObject json) throws ParseException, CustomException {
        IShipfitorderselectedPK shipfitorderselectedPK = (IShipfitorderselectedPK)JSONShipfitorderselected.toShipfitorderselectedPK((JSONObject)json.get("shipfitorderselectedpk"));
        return JSONShipfitorder.toJSON(shipfitorderusecases.get_shipfitorder_with_externalforeignkey_shipfitorderselected(shipfitorderselectedPK)).toJSONString();
    }
    
    private String search_shipfitorder(Shipfitorder_usecases shipfitorderusecases, JSONObject json) throws ParseException, CustomException {
        IShipfitordersearch search = (IShipfitordersearch)JSONShipfitorder.toShipfitordersearch((JSONObject)json.get("search"));
        return JSONShipfitorder.toJSONArray(shipfitorderusecases.search_shipfitorder(search)).toJSONString();
    }
    
    private String search_shipfitorder_count(Shipfitorder_usecases shipfitorderusecases, JSONObject json) throws ParseException, CustomException {
        IShipfitordersearch shipfitordersearch = (IShipfitordersearch)JSONShipfitorder.toShipfitordersearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", shipfitorderusecases.search_shipfitorder_count(shipfitordersearch));
        return jsonsearchcount.toJSONString();
    }

    private void insert_shipfitorder(Shipfitorder_usecases shipfitorderusecases, JSONObject json) throws ParseException, CustomException {
        IShipfitorder shipfitorder = (IShipfitorder)JSONShipfitorder.toShipfitorder((JSONObject)json.get("shipfitorder"));
        shipfitorderusecases.insertShipfitorder(shipfitorder);
        setReturnstatus("OK");
    }

    private void update_shipfitorder(Shipfitorder_usecases shipfitorderusecases, JSONObject json) throws ParseException, CustomException {
        IShipfitorder shipfitorder = (IShipfitorder)JSONShipfitorder.toShipfitorder((JSONObject)json.get("shipfitorder"));
        shipfitorderusecases.updateShipfitorder(shipfitorder);
        setReturnstatus("OK");
    }

    private void delete_shipfitorder(Shipfitorder_usecases shipfitorderusecases, JSONObject json) throws ParseException, CustomException {
        IShipfitorder shipfitorder = (IShipfitorder)JSONShipfitorder.toShipfitorder((JSONObject)json.get("shipfitorder"));
        shipfitorderusecases.deleteShipfitorder(shipfitorder);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Shipfit(Shipfitorder_usecases shipfitorderusecases, JSONObject json) throws ParseException, CustomException {
        IShipfitPK shipfitPK = (IShipfitPK)JSONShipfit.toShipfitPK((JSONObject)json.get("shipfitpk"));
        shipfitorderusecases.delete_all_containing_Shipfit(shipfitPK);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Evetype(Shipfitorder_usecases shipfitorderusecases, JSONObject json) throws ParseException, CustomException {
        IEvetypePK evetypePK = (IEvetypePK)JSONEvetype.toEvetypePK((JSONObject)json.get("evetypepk"));
        shipfitorderusecases.delete_all_containing_Evetype(evetypePK);
        setReturnstatus("OK");
    }

}

