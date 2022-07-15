/*
 * WSEveuser.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 13.6.2022 18:20
 *
 */

package eve.webservices;

import base.restservices.RS_json_login;
import eve.BusinessObject.Logic.*;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.searchentity.IEveusersearch;
import eve.interfaces.webservice.WSIEveuser;
import eve.logicentity.Eveuser;
import eve.searchentity.Eveusersearch;
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

/**
 *
 * @author Franky Laseure
 */
@WebService(endpointInterface = "eve.interfaces.webservice.WSIEveuser")
public class WSEveuser extends RS_json_login implements WSIEveuser {

    private Security_usecases security_usecases = new Security_usecases();
    
    private JSONArray toJSONArray(ArrayList eveusers) {
        JSONArray jsoneveusers = new JSONArray();
        Iterator eveusersI = eveusers.iterator();
        while(eveusersI.hasNext()) {
            jsoneveusers.add(JSONEveuser.toJSON((Eveuser)eveusersI.next()));
        }
        return jsoneveusers;
    }

    //@WebMethod(operationName = "getEveusers")
    @Override
    public String getEveusers() {
        try {
            Eveuser_usecases eveuserusecases = new Eveuser_usecases(loggedin);
            return get_all_eveuser(eveuserusecases);
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
            Eveuser_usecases eveuserusecases = new Eveuser_usecases(loggedin);
            return search_eveuser(eveuserusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "getEveuser")
    @Override
    public String getEveuser(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Eveuser_usecases eveuserusecases = new Eveuser_usecases(loggedin);
            return get_eveuser_with_primarykey(eveuserusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "insertEveuser")
    @Override
    public void insertEveuser(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Eveuser_usecases eveuserusecases = new Eveuser_usecases(loggedin);
            insert_eveuser(eveuserusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "updateEveuser")
    @Override
    public void updateEveuser(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Eveuser_usecases eveuserusecases = new Eveuser_usecases(loggedin);
            update_eveuser(eveuserusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "deleteEveuser")
    @Override
    public void deleteEveuser(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Eveuser_usecases eveuserusecases = new Eveuser_usecases(loggedin);
            delete_eveuser(eveuserusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getEveusers4frontendpage_auth")
    @Override
    public String getEveusers4frontendpage_auth(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Eveuser_usecases eveuserusecases = new Eveuser_usecases(loggedin);
            return get_eveuser_with_externalforeignkey_frontendpage_auth(eveuserusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }


    private String count_records(Eveuser_usecases eveuserusecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", eveuserusecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_eveuser(Eveuser_usecases eveuserusecases) throws ParseException, CustomException {
    	return JSONEveuser.toJSONArray(eveuserusecases.get_all()).toJSONString();
    }
    
    private String get_eveuser_with_primarykey(Eveuser_usecases eveuserusecases, JSONObject json) throws ParseException, CustomException {
        IEveuserPK eveuserPK = (IEveuserPK)JSONEveuser.toEveuserPK((JSONObject)json.get("eveuserpk"));
	return JSONEveuser.toJSON(eveuserusecases.get_eveuser_by_primarykey(eveuserPK)).toJSONString();
    }
    
    private String get_eveuser_with_externalforeignkey_frontendpage_auth(Eveuser_usecases eveuserusecases, JSONObject json) throws ParseException, CustomException {
        IFrontendpage_authPK frontendpage_authPK = (IFrontendpage_authPK)JSONFrontendpage_auth.toFrontendpage_authPK((JSONObject)json.get("frontendpage_authpk"));
        return JSONEveuser.toJSON(eveuserusecases.get_eveuser_with_externalforeignkey_frontendpage_auth(frontendpage_authPK)).toJSONString();
    }
    
    private String search_eveuser(Eveuser_usecases eveuserusecases, JSONObject json) throws ParseException, CustomException {
        IEveusersearch search = (IEveusersearch)JSONEveuser.toEveusersearch((JSONObject)json.get("search"));
        return JSONEveuser.toJSONArray(eveuserusecases.search_eveuser(search)).toJSONString();
    }
    
    private String search_eveuser_count(Eveuser_usecases eveuserusecases, JSONObject json) throws ParseException, CustomException {
        IEveusersearch eveusersearch = (IEveusersearch)JSONEveuser.toEveusersearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", eveuserusecases.search_eveuser_count(eveusersearch));
        return jsonsearchcount.toJSONString();
    }

    private void insert_eveuser(Eveuser_usecases eveuserusecases, JSONObject json) throws ParseException, CustomException {
        IEveuser eveuser = (IEveuser)JSONEveuser.toEveuser((JSONObject)json.get("eveuser"));
        eveuserusecases.insertEveuser(eveuser);
        setReturnstatus("OK");
    }

    private void update_eveuser(Eveuser_usecases eveuserusecases, JSONObject json) throws ParseException, CustomException {
        IEveuser eveuser = (IEveuser)JSONEveuser.toEveuser((JSONObject)json.get("eveuser"));
        eveuserusecases.updateEveuser(eveuser);
        setReturnstatus("OK");
    }

    private void delete_eveuser(Eveuser_usecases eveuserusecases, JSONObject json) throws ParseException, CustomException {
        IEveuser eveuser = (IEveuser)JSONEveuser.toEveuser((JSONObject)json.get("eveuser"));
        eveuserusecases.deleteEveuser(eveuser);
        setReturnstatus("OK");
    }

}

