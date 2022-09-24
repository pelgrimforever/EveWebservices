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
import eve.interfaces.searchentity.IShipfitmodulesearch;
import eve.interfaces.webservice.WSIShipfitmodule;
import eve.logicentity.Shipfitmodule;
import eve.searchentity.Shipfitmodulesearch;
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

@WebService(endpointInterface = "eve.interfaces.webservice.WSIShipfitmodule")
public class WSShipfitmodule extends RS_json_login implements WSIShipfitmodule {

    private Security_usecases security_usecases = new Security_usecases();
    
    private JSONArray toJSONArray(ArrayList shipfitmodules) {
        JSONArray jsonshipfitmodules = new JSONArray();
        Iterator shipfitmodulesI = shipfitmodules.iterator();
        while(shipfitmodulesI.hasNext()) {
            jsonshipfitmodules.add(JSONShipfitmodule.toJSON((Shipfitmodule)shipfitmodulesI.next()));
        }
        return jsonshipfitmodules;
    }

    //@WebMethod(operationName = "getShipfitmodules")
    @Override
    public String getShipfitmodules() {
        try {
            Shipfitmodule_usecases shipfitmoduleusecases = new Shipfitmodule_usecases(loggedin);
            return get_all_shipfitmodule(shipfitmoduleusecases);
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
            Shipfitmodule_usecases shipfitmoduleusecases = new Shipfitmodule_usecases(loggedin);
            return search_shipfitmodule(shipfitmoduleusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "getShipfitmodule")
    @Override
    public String getShipfitmodule(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Shipfitmodule_usecases shipfitmoduleusecases = new Shipfitmodule_usecases(loggedin);
            return get_shipfitmodule_with_primarykey(shipfitmoduleusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "insertShipfitmodule")
    @Override
    public void insertShipfitmodule(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Shipfitmodule_usecases shipfitmoduleusecases = new Shipfitmodule_usecases(loggedin);
            insert_shipfitmodule(shipfitmoduleusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "updateShipfitmodule")
    @Override
    public void updateShipfitmodule(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Shipfitmodule_usecases shipfitmoduleusecases = new Shipfitmodule_usecases(loggedin);
            update_shipfitmodule(shipfitmoduleusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "deleteShipfitmodule")
    @Override
    public void deleteShipfitmodule(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Shipfitmodule_usecases shipfitmoduleusecases = new Shipfitmodule_usecases(loggedin);
            delete_shipfitmodule(shipfitmoduleusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getShipfitmodules4evetype")
    @Override
    public String getShipfitmodules4evetype(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Shipfitmodule_usecases shipfitmoduleusecases = new Shipfitmodule_usecases(loggedin);
            return get_shipfitmodule_with_foreignkey_evetype(shipfitmoduleusecases, json);
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
            Shipfitmodule_usecases shipfitmoduleusecases = new Shipfitmodule_usecases(loggedin);
            delete_shipfitmodule(shipfitmoduleusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getShipfitmodules4shipfit")
    @Override
    public String getShipfitmodules4shipfit(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Shipfitmodule_usecases shipfitmoduleusecases = new Shipfitmodule_usecases(loggedin);
            return get_shipfitmodule_with_foreignkey_shipfit(shipfitmoduleusecases, json);
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
            Shipfitmodule_usecases shipfitmoduleusecases = new Shipfitmodule_usecases(loggedin);
            delete_shipfitmodule(shipfitmoduleusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }


    private String count_records(Shipfitmodule_usecases shipfitmoduleusecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", shipfitmoduleusecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_shipfitmodule(Shipfitmodule_usecases shipfitmoduleusecases) throws ParseException, CustomException {
    	return JSONShipfitmodule.toJSONArray(shipfitmoduleusecases.get_all()).toJSONString();
    }
    
    private String get_shipfitmodule_with_primarykey(Shipfitmodule_usecases shipfitmoduleusecases, JSONObject json) throws ParseException, CustomException {
        IShipfitmodulePK shipfitmodulePK = (IShipfitmodulePK)JSONShipfitmodule.toShipfitmodulePK((JSONObject)json.get("shipfitmodulepk"));
	return JSONShipfitmodule.toJSON(shipfitmoduleusecases.get_shipfitmodule_by_primarykey(shipfitmodulePK)).toJSONString();
    }
    
    private String get_shipfitmodule_with_foreignkey_evetype(Shipfitmodule_usecases shipfitmoduleusecases, JSONObject json) throws ParseException, CustomException {
        IEvetypePK evetypePK = (IEvetypePK)JSONEvetype.toEvetypePK((JSONObject)json.get("evetypepk"));
        return JSONShipfitmodule.toJSONArray(shipfitmoduleusecases.get_shipfitmodule_with_foreignkey_evetype(evetypePK)).toJSONString();
    }
    
    private String get_shipfitmodule_with_foreignkey_shipfit(Shipfitmodule_usecases shipfitmoduleusecases, JSONObject json) throws ParseException, CustomException {
        IShipfitPK shipfitPK = (IShipfitPK)JSONShipfit.toShipfitPK((JSONObject)json.get("shipfitpk"));
        return JSONShipfitmodule.toJSONArray(shipfitmoduleusecases.get_shipfitmodule_with_foreignkey_shipfit(shipfitPK)).toJSONString();
    }
    
    private String search_shipfitmodule(Shipfitmodule_usecases shipfitmoduleusecases, JSONObject json) throws ParseException, CustomException {
        IShipfitmodulesearch search = (IShipfitmodulesearch)JSONShipfitmodule.toShipfitmodulesearch((JSONObject)json.get("search"));
        return JSONShipfitmodule.toJSONArray(shipfitmoduleusecases.search_shipfitmodule(search)).toJSONString();
    }
    
    private String search_shipfitmodule_count(Shipfitmodule_usecases shipfitmoduleusecases, JSONObject json) throws ParseException, CustomException {
        IShipfitmodulesearch shipfitmodulesearch = (IShipfitmodulesearch)JSONShipfitmodule.toShipfitmodulesearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", shipfitmoduleusecases.search_shipfitmodule_count(shipfitmodulesearch));
        return jsonsearchcount.toJSONString();
    }

    private void insert_shipfitmodule(Shipfitmodule_usecases shipfitmoduleusecases, JSONObject json) throws ParseException, CustomException {
        IShipfitmodule shipfitmodule = (IShipfitmodule)JSONShipfitmodule.toShipfitmodule((JSONObject)json.get("shipfitmodule"));
        shipfitmoduleusecases.insertShipfitmodule(shipfitmodule);
        setReturnstatus("OK");
    }

    private void update_shipfitmodule(Shipfitmodule_usecases shipfitmoduleusecases, JSONObject json) throws ParseException, CustomException {
        IShipfitmodule shipfitmodule = (IShipfitmodule)JSONShipfitmodule.toShipfitmodule((JSONObject)json.get("shipfitmodule"));
        shipfitmoduleusecases.updateShipfitmodule(shipfitmodule);
        setReturnstatus("OK");
    }

    private void delete_shipfitmodule(Shipfitmodule_usecases shipfitmoduleusecases, JSONObject json) throws ParseException, CustomException {
        IShipfitmodule shipfitmodule = (IShipfitmodule)JSONShipfitmodule.toShipfitmodule((JSONObject)json.get("shipfitmodule"));
        shipfitmoduleusecases.deleteShipfitmodule(shipfitmodule);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Evetype(Shipfitmodule_usecases shipfitmoduleusecases, JSONObject json) throws ParseException, CustomException {
        IEvetypePK evetypePK = (IEvetypePK)JSONEvetype.toEvetypePK((JSONObject)json.get("evetypepk"));
        shipfitmoduleusecases.delete_all_containing_Evetype(evetypePK);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Shipfit(Shipfitmodule_usecases shipfitmoduleusecases, JSONObject json) throws ParseException, CustomException {
        IShipfitPK shipfitPK = (IShipfitPK)JSONShipfit.toShipfitPK((JSONObject)json.get("shipfitpk"));
        shipfitmoduleusecases.delete_all_containing_Shipfit(shipfitPK);
        setReturnstatus("OK");
    }

}

