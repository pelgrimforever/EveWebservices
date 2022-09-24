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
import eve.interfaces.searchentity.IShipfitsearch;
import eve.interfaces.webservice.WSIShipfit;
import eve.logicentity.Shipfit;
import eve.searchentity.Shipfitsearch;
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

@WebService(endpointInterface = "eve.interfaces.webservice.WSIShipfit")
public class WSShipfit extends RS_json_login implements WSIShipfit {

    private Security_usecases security_usecases = new Security_usecases();
    
    private JSONArray toJSONArray(ArrayList shipfits) {
        JSONArray jsonshipfits = new JSONArray();
        Iterator shipfitsI = shipfits.iterator();
        while(shipfitsI.hasNext()) {
            jsonshipfits.add(JSONShipfit.toJSON((Shipfit)shipfitsI.next()));
        }
        return jsonshipfits;
    }

    //@WebMethod(operationName = "getShipfits")
    @Override
    public String getShipfits() {
        try {
            Shipfit_usecases shipfitusecases = new Shipfit_usecases(loggedin);
            return get_all_shipfit(shipfitusecases);
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
            Shipfit_usecases shipfitusecases = new Shipfit_usecases(loggedin);
            return search_shipfit(shipfitusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "getShipfit")
    @Override
    public String getShipfit(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Shipfit_usecases shipfitusecases = new Shipfit_usecases(loggedin);
            return get_shipfit_with_primarykey(shipfitusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "insertShipfit")
    @Override
    public void insertShipfit(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Shipfit_usecases shipfitusecases = new Shipfit_usecases(loggedin);
            insert_shipfit(shipfitusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "updateShipfit")
    @Override
    public void updateShipfit(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Shipfit_usecases shipfitusecases = new Shipfit_usecases(loggedin);
            update_shipfit(shipfitusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "deleteShipfit")
    @Override
    public void deleteShipfit(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Shipfit_usecases shipfitusecases = new Shipfit_usecases(loggedin);
            delete_shipfit(shipfitusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getShipfits4evetype")
    @Override
    public String getShipfits4evetype(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Shipfit_usecases shipfitusecases = new Shipfit_usecases(loggedin);
            return get_shipfit_with_foreignkey_evetype(shipfitusecases, json);
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
            Shipfit_usecases shipfitusecases = new Shipfit_usecases(loggedin);
            delete_shipfit(shipfitusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getShipfits4shipfitmodule")
    @Override
    public String getShipfits4shipfitmodule(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Shipfit_usecases shipfitusecases = new Shipfit_usecases(loggedin);
            return get_shipfit_with_externalforeignkey_shipfitmodule(shipfitusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "getShipfits4shipfitorder")
    @Override
    public String getShipfits4shipfitorder(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Shipfit_usecases shipfitusecases = new Shipfit_usecases(loggedin);
            return get_shipfit_with_externalforeignkey_shipfitorder(shipfitusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }


    private String count_records(Shipfit_usecases shipfitusecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", shipfitusecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_shipfit(Shipfit_usecases shipfitusecases) throws ParseException, CustomException {
    	return JSONShipfit.toJSONArray(shipfitusecases.get_all()).toJSONString();
    }
    
    private String get_shipfit_with_primarykey(Shipfit_usecases shipfitusecases, JSONObject json) throws ParseException, CustomException {
        IShipfitPK shipfitPK = (IShipfitPK)JSONShipfit.toShipfitPK((JSONObject)json.get("shipfitpk"));
	return JSONShipfit.toJSON(shipfitusecases.get_shipfit_by_primarykey(shipfitPK)).toJSONString();
    }
    
    private String get_shipfit_with_foreignkey_evetype(Shipfit_usecases shipfitusecases, JSONObject json) throws ParseException, CustomException {
        IEvetypePK evetypePK = (IEvetypePK)JSONEvetype.toEvetypePK((JSONObject)json.get("evetypepk"));
        return JSONShipfit.toJSONArray(shipfitusecases.get_shipfit_with_foreignkey_evetype(evetypePK)).toJSONString();
    }
    
    private String get_shipfit_with_externalforeignkey_shipfitmodule(Shipfit_usecases shipfitusecases, JSONObject json) throws ParseException, CustomException {
        IShipfitmodulePK shipfitmodulePK = (IShipfitmodulePK)JSONShipfitmodule.toShipfitmodulePK((JSONObject)json.get("shipfitmodulepk"));
        return JSONShipfit.toJSON(shipfitusecases.get_shipfit_with_externalforeignkey_shipfitmodule(shipfitmodulePK)).toJSONString();
    }
    
    private String get_shipfit_with_externalforeignkey_shipfitorder(Shipfit_usecases shipfitusecases, JSONObject json) throws ParseException, CustomException {
        IShipfitorderPK shipfitorderPK = (IShipfitorderPK)JSONShipfitorder.toShipfitorderPK((JSONObject)json.get("shipfitorderpk"));
        return JSONShipfit.toJSON(shipfitusecases.get_shipfit_with_externalforeignkey_shipfitorder(shipfitorderPK)).toJSONString();
    }
    
    private String search_shipfit(Shipfit_usecases shipfitusecases, JSONObject json) throws ParseException, CustomException {
        IShipfitsearch search = (IShipfitsearch)JSONShipfit.toShipfitsearch((JSONObject)json.get("search"));
        return JSONShipfit.toJSONArray(shipfitusecases.search_shipfit(search)).toJSONString();
    }
    
    private String search_shipfit_count(Shipfit_usecases shipfitusecases, JSONObject json) throws ParseException, CustomException {
        IShipfitsearch shipfitsearch = (IShipfitsearch)JSONShipfit.toShipfitsearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", shipfitusecases.search_shipfit_count(shipfitsearch));
        return jsonsearchcount.toJSONString();
    }

    private void insert_shipfit(Shipfit_usecases shipfitusecases, JSONObject json) throws ParseException, CustomException {
        IShipfit shipfit = (IShipfit)JSONShipfit.toShipfit((JSONObject)json.get("shipfit"));
        shipfitusecases.insertShipfit(shipfit);
        setReturnstatus("OK");
    }

    private void update_shipfit(Shipfit_usecases shipfitusecases, JSONObject json) throws ParseException, CustomException {
        IShipfit shipfit = (IShipfit)JSONShipfit.toShipfit((JSONObject)json.get("shipfit"));
        shipfitusecases.updateShipfit(shipfit);
        setReturnstatus("OK");
    }

    private void delete_shipfit(Shipfit_usecases shipfitusecases, JSONObject json) throws ParseException, CustomException {
        IShipfit shipfit = (IShipfit)JSONShipfit.toShipfit((JSONObject)json.get("shipfit"));
        shipfitusecases.deleteShipfit(shipfit);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Evetype(Shipfit_usecases shipfitusecases, JSONObject json) throws ParseException, CustomException {
        IEvetypePK evetypePK = (IEvetypePK)JSONEvetype.toEvetypePK((JSONObject)json.get("evetypepk"));
        shipfitusecases.delete_all_containing_Evetype(evetypePK);
        setReturnstatus("OK");
    }

}

