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
import eve.interfaces.searchentity.IFrontendpage_authsearch;
import eve.interfaces.webservice.WSIFrontendpage_auth;
import eve.logicentity.Frontendpage_auth;
import eve.searchentity.Frontendpage_authsearch;
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

@WebService(endpointInterface = "eve.interfaces.webservice.WSIFrontendpage_auth")
public class WSFrontendpage_auth extends RS_json_login implements WSIFrontendpage_auth {

    private Security_usecases security_usecases = new Security_usecases();
    
    private JSONArray toJSONArray(ArrayList frontendpage_auths) {
        JSONArray jsonfrontendpage_auths = new JSONArray();
        Iterator frontendpage_authsI = frontendpage_auths.iterator();
        while(frontendpage_authsI.hasNext()) {
            jsonfrontendpage_auths.add(JSONFrontendpage_auth.toJSON((Frontendpage_auth)frontendpage_authsI.next()));
        }
        return jsonfrontendpage_auths;
    }

    //@WebMethod(operationName = "getFrontendpage_auths")
    @Override
    public String getFrontendpage_auths() {
        try {
            Frontendpage_auth_usecases frontendpage_authusecases = new Frontendpage_auth_usecases(loggedin);
            return get_all_frontendpage_auth(frontendpage_authusecases);
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
            Frontendpage_auth_usecases frontendpage_authusecases = new Frontendpage_auth_usecases(loggedin);
            return search_frontendpage_auth(frontendpage_authusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "getFrontendpage_auth")
    @Override
    public String getFrontendpage_auth(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Frontendpage_auth_usecases frontendpage_authusecases = new Frontendpage_auth_usecases(loggedin);
            return get_frontendpage_auth_with_primarykey(frontendpage_authusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "insertFrontendpage_auth")
    @Override
    public void insertFrontendpage_auth(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Frontendpage_auth_usecases frontendpage_authusecases = new Frontendpage_auth_usecases(loggedin);
            insert_frontendpage_auth(frontendpage_authusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "updateFrontendpage_auth")
    @Override
    public void updateFrontendpage_auth(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Frontendpage_auth_usecases frontendpage_authusecases = new Frontendpage_auth_usecases(loggedin);
            update_frontendpage_auth(frontendpage_authusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "deleteFrontendpage_auth")
    @Override
    public void deleteFrontendpage_auth(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Frontendpage_auth_usecases frontendpage_authusecases = new Frontendpage_auth_usecases(loggedin);
            delete_frontendpage_auth(frontendpage_authusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getFrontendpage_auths4frontendpage")
    @Override
    public String getFrontendpage_auths4frontendpage(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Frontendpage_auth_usecases frontendpage_authusecases = new Frontendpage_auth_usecases(loggedin);
            return get_frontendpage_auth_with_foreignkey_frontendpage(frontendpage_authusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "delete4frontendpage")
    @Override
    public void delete4frontendpage(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Frontendpage_auth_usecases frontendpage_authusecases = new Frontendpage_auth_usecases(loggedin);
            delete_frontendpage_auth(frontendpage_authusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getFrontendpage_auths4eveuser")
    @Override
    public String getFrontendpage_auths4eveuser(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Frontendpage_auth_usecases frontendpage_authusecases = new Frontendpage_auth_usecases(loggedin);
            return get_frontendpage_auth_with_foreignkey_eveuser(frontendpage_authusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "delete4eveuser")
    @Override
    public void delete4eveuser(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Frontendpage_auth_usecases frontendpage_authusecases = new Frontendpage_auth_usecases(loggedin);
            delete_frontendpage_auth(frontendpage_authusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }


    private String count_records(Frontendpage_auth_usecases frontendpage_authusecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", frontendpage_authusecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_frontendpage_auth(Frontendpage_auth_usecases frontendpage_authusecases) throws ParseException, CustomException {
    	return JSONFrontendpage_auth.toJSONArray(frontendpage_authusecases.get_all()).toJSONString();
    }
    
    private String get_frontendpage_auth_with_primarykey(Frontendpage_auth_usecases frontendpage_authusecases, JSONObject json) throws ParseException, CustomException {
        IFrontendpage_authPK frontendpage_authPK = (IFrontendpage_authPK)JSONFrontendpage_auth.toFrontendpage_authPK((JSONObject)json.get("frontendpage_authpk"));
	return JSONFrontendpage_auth.toJSON(frontendpage_authusecases.get_frontendpage_auth_by_primarykey(frontendpage_authPK)).toJSONString();
    }
    
    private String get_frontendpage_auth_with_foreignkey_frontendpage(Frontendpage_auth_usecases frontendpage_authusecases, JSONObject json) throws ParseException, CustomException {
        IFrontendpagePK frontendpagePK = (IFrontendpagePK)JSONFrontendpage.toFrontendpagePK((JSONObject)json.get("frontendpagepk"));
        return JSONFrontendpage_auth.toJSONArray(frontendpage_authusecases.get_frontendpage_auth_with_foreignkey_frontendpage(frontendpagePK)).toJSONString();
    }
    
    private String get_frontendpage_auth_with_foreignkey_eveuser(Frontendpage_auth_usecases frontendpage_authusecases, JSONObject json) throws ParseException, CustomException {
        IEveuserPK eveuserPK = (IEveuserPK)JSONEveuser.toEveuserPK((JSONObject)json.get("eveuserpk"));
        return JSONFrontendpage_auth.toJSONArray(frontendpage_authusecases.get_frontendpage_auth_with_foreignkey_eveuser(eveuserPK)).toJSONString();
    }
    
    private String search_frontendpage_auth(Frontendpage_auth_usecases frontendpage_authusecases, JSONObject json) throws ParseException, CustomException {
        IFrontendpage_authsearch search = (IFrontendpage_authsearch)JSONFrontendpage_auth.toFrontendpage_authsearch((JSONObject)json.get("search"));
        return JSONFrontendpage_auth.toJSONArray(frontendpage_authusecases.search_frontendpage_auth(search)).toJSONString();
    }
    
    private String search_frontendpage_auth_count(Frontendpage_auth_usecases frontendpage_authusecases, JSONObject json) throws ParseException, CustomException {
        IFrontendpage_authsearch frontendpage_authsearch = (IFrontendpage_authsearch)JSONFrontendpage_auth.toFrontendpage_authsearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", frontendpage_authusecases.search_frontendpage_auth_count(frontendpage_authsearch));
        return jsonsearchcount.toJSONString();
    }

    private void insert_frontendpage_auth(Frontendpage_auth_usecases frontendpage_authusecases, JSONObject json) throws ParseException, CustomException {
        IFrontendpage_auth frontendpage_auth = (IFrontendpage_auth)JSONFrontendpage_auth.toFrontendpage_auth((JSONObject)json.get("frontendpage_auth"));
        frontendpage_authusecases.insertFrontendpage_auth(frontendpage_auth);
        setReturnstatus("OK");
    }

    private void update_frontendpage_auth(Frontendpage_auth_usecases frontendpage_authusecases, JSONObject json) throws ParseException, CustomException {
        IFrontendpage_auth frontendpage_auth = (IFrontendpage_auth)JSONFrontendpage_auth.toFrontendpage_auth((JSONObject)json.get("frontendpage_auth"));
        frontendpage_authusecases.updateFrontendpage_auth(frontendpage_auth);
        setReturnstatus("OK");
    }

    private void delete_frontendpage_auth(Frontendpage_auth_usecases frontendpage_authusecases, JSONObject json) throws ParseException, CustomException {
        IFrontendpage_auth frontendpage_auth = (IFrontendpage_auth)JSONFrontendpage_auth.toFrontendpage_auth((JSONObject)json.get("frontendpage_auth"));
        frontendpage_authusecases.deleteFrontendpage_auth(frontendpage_auth);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Frontendpage(Frontendpage_auth_usecases frontendpage_authusecases, JSONObject json) throws ParseException, CustomException {
        IFrontendpagePK frontendpagePK = (IFrontendpagePK)JSONFrontendpage.toFrontendpagePK((JSONObject)json.get("frontendpagepk"));
        frontendpage_authusecases.delete_all_containing_Frontendpage(frontendpagePK);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Eveuser(Frontendpage_auth_usecases frontendpage_authusecases, JSONObject json) throws ParseException, CustomException {
        IEveuserPK eveuserPK = (IEveuserPK)JSONEveuser.toEveuserPK((JSONObject)json.get("eveuserpk"));
        frontendpage_authusecases.delete_all_containing_Eveuser(eveuserPK);
        setReturnstatus("OK");
    }

}

