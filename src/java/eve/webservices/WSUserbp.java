/*
 * WSUserbp.java
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
import eve.interfaces.searchentity.IUserbpsearch;
import eve.interfaces.webservice.WSIUserbp;
import eve.logicentity.Userbp;
import eve.searchentity.Userbpsearch;
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
@WebService(endpointInterface = "eve.interfaces.webservice.WSIUserbp")
public class WSUserbp extends RS_json_login implements WSIUserbp {

    private Security_usecases security_usecases = new Security_usecases();
    
    private JSONArray toJSONArray(ArrayList userbps) {
        JSONArray jsonuserbps = new JSONArray();
        Iterator userbpsI = userbps.iterator();
        while(userbpsI.hasNext()) {
            jsonuserbps.add(JSONUserbp.toJSON((Userbp)userbpsI.next()));
        }
        return jsonuserbps;
    }

    //@WebMethod(operationName = "getUserbps")
    @Override
    public String getUserbps() {
        try {
            Userbp_usecases userbpusecases = new Userbp_usecases(loggedin);
            return get_all_userbp(userbpusecases);
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
            Userbp_usecases userbpusecases = new Userbp_usecases(loggedin);
            return search_userbp(userbpusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "getUserbp")
    @Override
    public String getUserbp(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Userbp_usecases userbpusecases = new Userbp_usecases(loggedin);
            return get_userbp_with_primarykey(userbpusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "insertUserbp")
    @Override
    public void insertUserbp(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Userbp_usecases userbpusecases = new Userbp_usecases(loggedin);
            insert_userbp(userbpusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "updateUserbp")
    @Override
    public void updateUserbp(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Userbp_usecases userbpusecases = new Userbp_usecases(loggedin);
            update_userbp(userbpusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "deleteUserbp")
    @Override
    public void deleteUserbp(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Userbp_usecases userbpusecases = new Userbp_usecases(loggedin);
            delete_userbp(userbpusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getUserbps4evetype")
    @Override
    public String getUserbps4evetype(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Userbp_usecases userbpusecases = new Userbp_usecases(loggedin);
            return get_userbp_with_foreignkey_evetype(userbpusecases, json);
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
            Userbp_usecases userbpusecases = new Userbp_usecases(loggedin);
            delete_userbp(userbpusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }


    private String count_records(Userbp_usecases userbpusecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", userbpusecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_userbp(Userbp_usecases userbpusecases) throws ParseException, CustomException {
    	return JSONUserbp.toJSONArray(userbpusecases.get_all()).toJSONString();
    }
    
    private String get_userbp_with_primarykey(Userbp_usecases userbpusecases, JSONObject json) throws ParseException, CustomException {
        IUserbpPK userbpPK = (IUserbpPK)JSONUserbp.toUserbpPK((JSONObject)json.get("userbppk"));
	return JSONUserbp.toJSON(userbpusecases.get_userbp_by_primarykey(userbpPK)).toJSONString();
    }
    
    private String get_userbp_with_foreignkey_evetype(Userbp_usecases userbpusecases, JSONObject json) throws ParseException, CustomException {
        IEvetypePK evetypePK = (IEvetypePK)JSONEvetype.toEvetypePK((JSONObject)json.get("evetypepk"));
        return JSONUserbp.toJSONArray(userbpusecases.get_userbp_with_foreignkey_evetype(evetypePK)).toJSONString();
    }
    
    private String search_userbp(Userbp_usecases userbpusecases, JSONObject json) throws ParseException, CustomException {
        IUserbpsearch search = (IUserbpsearch)JSONUserbp.toUserbpsearch((JSONObject)json.get("search"));
        return JSONUserbp.toJSONArray(userbpusecases.search_userbp(search)).toJSONString();
    }
    
    private String search_userbp_count(Userbp_usecases userbpusecases, JSONObject json) throws ParseException, CustomException {
        IUserbpsearch userbpsearch = (IUserbpsearch)JSONUserbp.toUserbpsearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", userbpusecases.search_userbp_count(userbpsearch));
        return jsonsearchcount.toJSONString();
    }

    private void insert_userbp(Userbp_usecases userbpusecases, JSONObject json) throws ParseException, CustomException {
        IUserbp userbp = (IUserbp)JSONUserbp.toUserbp((JSONObject)json.get("userbp"));
        userbpusecases.insertUserbp(userbp);
        setReturnstatus("OK");
    }

    private void update_userbp(Userbp_usecases userbpusecases, JSONObject json) throws ParseException, CustomException {
        IUserbp userbp = (IUserbp)JSONUserbp.toUserbp((JSONObject)json.get("userbp"));
        userbpusecases.updateUserbp(userbp);
        setReturnstatus("OK");
    }

    private void delete_userbp(Userbp_usecases userbpusecases, JSONObject json) throws ParseException, CustomException {
        IUserbp userbp = (IUserbp)JSONUserbp.toUserbp((JSONObject)json.get("userbp"));
        userbpusecases.deleteUserbp(userbp);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Evetype(Userbp_usecases userbpusecases, JSONObject json) throws ParseException, CustomException {
        IEvetypePK evetypePK = (IEvetypePK)JSONEvetype.toEvetypePK((JSONObject)json.get("evetypepk"));
        userbpusecases.delete_all_containing_Evetype(evetypePK);
        setReturnstatus("OK");
    }

}

