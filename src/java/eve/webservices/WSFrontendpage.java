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
import eve.interfaces.searchentity.IFrontendpagesearch;
import eve.interfaces.webservice.WSIFrontendpage;
import eve.logicentity.Frontendpage;
import eve.searchentity.Frontendpagesearch;
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

@WebService(endpointInterface = "eve.interfaces.webservice.WSIFrontendpage")
public class WSFrontendpage extends RS_json_login implements WSIFrontendpage {

    private Security_usecases security_usecases = new Security_usecases();
    
    private JSONArray toJSONArray(ArrayList frontendpages) {
        JSONArray jsonfrontendpages = new JSONArray();
        Iterator frontendpagesI = frontendpages.iterator();
        while(frontendpagesI.hasNext()) {
            jsonfrontendpages.add(JSONFrontendpage.toJSON((Frontendpage)frontendpagesI.next()));
        }
        return jsonfrontendpages;
    }

    //@WebMethod(operationName = "getFrontendpages")
    @Override
    public String getFrontendpages() {
        try {
            Frontendpage_usecases frontendpageusecases = new Frontendpage_usecases(loggedin);
            return get_all_frontendpage(frontendpageusecases);
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
            Frontendpage_usecases frontendpageusecases = new Frontendpage_usecases(loggedin);
            return search_frontendpage(frontendpageusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "getFrontendpage")
    @Override
    public String getFrontendpage(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Frontendpage_usecases frontendpageusecases = new Frontendpage_usecases(loggedin);
            return get_frontendpage_with_primarykey(frontendpageusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "insertFrontendpage")
    @Override
    public void insertFrontendpage(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Frontendpage_usecases frontendpageusecases = new Frontendpage_usecases(loggedin);
            insert_frontendpage(frontendpageusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "updateFrontendpage")
    @Override
    public void updateFrontendpage(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Frontendpage_usecases frontendpageusecases = new Frontendpage_usecases(loggedin);
            update_frontendpage(frontendpageusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "deleteFrontendpage")
    @Override
    public void deleteFrontendpage(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Frontendpage_usecases frontendpageusecases = new Frontendpage_usecases(loggedin);
            delete_frontendpage(frontendpageusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getFrontendpages4frontendpage_auth")
    @Override
    public String getFrontendpages4frontendpage_auth(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Frontendpage_usecases frontendpageusecases = new Frontendpage_usecases(loggedin);
            return get_frontendpage_with_externalforeignkey_frontendpage_auth(frontendpageusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }


    private String count_records(Frontendpage_usecases frontendpageusecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", frontendpageusecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_frontendpage(Frontendpage_usecases frontendpageusecases) throws ParseException, CustomException {
    	return JSONFrontendpage.toJSONArray(frontendpageusecases.get_all()).toJSONString();
    }
    
    private String get_frontendpage_with_primarykey(Frontendpage_usecases frontendpageusecases, JSONObject json) throws ParseException, CustomException {
        IFrontendpagePK frontendpagePK = (IFrontendpagePK)JSONFrontendpage.toFrontendpagePK((JSONObject)json.get("frontendpagepk"));
	return JSONFrontendpage.toJSON(frontendpageusecases.get_frontendpage_by_primarykey(frontendpagePK)).toJSONString();
    }
    
    private String get_frontendpage_with_externalforeignkey_frontendpage_auth(Frontendpage_usecases frontendpageusecases, JSONObject json) throws ParseException, CustomException {
        IFrontendpage_authPK frontendpage_authPK = (IFrontendpage_authPK)JSONFrontendpage_auth.toFrontendpage_authPK((JSONObject)json.get("frontendpage_authpk"));
        return JSONFrontendpage.toJSON(frontendpageusecases.get_frontendpage_with_externalforeignkey_frontendpage_auth(frontendpage_authPK)).toJSONString();
    }
    
    private String search_frontendpage(Frontendpage_usecases frontendpageusecases, JSONObject json) throws ParseException, CustomException {
        IFrontendpagesearch search = (IFrontendpagesearch)JSONFrontendpage.toFrontendpagesearch((JSONObject)json.get("search"));
        return JSONFrontendpage.toJSONArray(frontendpageusecases.search_frontendpage(search)).toJSONString();
    }
    
    private String search_frontendpage_count(Frontendpage_usecases frontendpageusecases, JSONObject json) throws ParseException, CustomException {
        IFrontendpagesearch frontendpagesearch = (IFrontendpagesearch)JSONFrontendpage.toFrontendpagesearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", frontendpageusecases.search_frontendpage_count(frontendpagesearch));
        return jsonsearchcount.toJSONString();
    }

    private void insert_frontendpage(Frontendpage_usecases frontendpageusecases, JSONObject json) throws ParseException, CustomException {
        IFrontendpage frontendpage = (IFrontendpage)JSONFrontendpage.toFrontendpage((JSONObject)json.get("frontendpage"));
        frontendpageusecases.insertFrontendpage(frontendpage);
        setReturnstatus("OK");
    }

    private void update_frontendpage(Frontendpage_usecases frontendpageusecases, JSONObject json) throws ParseException, CustomException {
        IFrontendpage frontendpage = (IFrontendpage)JSONFrontendpage.toFrontendpage((JSONObject)json.get("frontendpage"));
        frontendpageusecases.updateFrontendpage(frontendpage);
        setReturnstatus("OK");
    }

    private void delete_frontendpage(Frontendpage_usecases frontendpageusecases, JSONObject json) throws ParseException, CustomException {
        IFrontendpage frontendpage = (IFrontendpage)JSONFrontendpage.toFrontendpage((JSONObject)json.get("frontendpage"));
        frontendpageusecases.deleteFrontendpage(frontendpage);
        setReturnstatus("OK");
    }

}

