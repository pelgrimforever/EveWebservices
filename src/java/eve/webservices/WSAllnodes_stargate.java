/*
 * WSAllnodes_stargate.java
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
import eve.interfaces.searchentity.IAllnodes_stargatesearch;
import eve.interfaces.webservice.WSIAllnodes_stargate;
import eve.logicentity.Allnodes_stargate;
import eve.searchentity.Allnodes_stargatesearch;
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
@WebService(endpointInterface = "eve.interfaces.webservice.WSIAllnodes_stargate")
public class WSAllnodes_stargate extends RS_json_login implements WSIAllnodes_stargate {

    private Security_usecases security_usecases = new Security_usecases();
    
    private JSONArray toJSONArray(ArrayList allnodes_stargates) {
        JSONArray jsonallnodes_stargates = new JSONArray();
        Iterator allnodes_stargatesI = allnodes_stargates.iterator();
        while(allnodes_stargatesI.hasNext()) {
            jsonallnodes_stargates.add(JSONAllnodes_stargate.toJSON((Allnodes_stargate)allnodes_stargatesI.next()));
        }
        return jsonallnodes_stargates;
    }

    //@WebMethod(operationName = "getAllnodes_stargates")
    @Override
    public String getAllnodes_stargates() {
        try {
            Allnodes_stargate_usecases allnodes_stargateusecases = new Allnodes_stargate_usecases(loggedin);
            return get_all_allnodes_stargate(allnodes_stargateusecases);
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
            Allnodes_stargate_usecases allnodes_stargateusecases = new Allnodes_stargate_usecases(loggedin);
            return search_allnodes_stargate(allnodes_stargateusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "getAllnodes_stargate")
    @Override
    public String getAllnodes_stargate(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Allnodes_stargate_usecases allnodes_stargateusecases = new Allnodes_stargate_usecases(loggedin);
            return get_allnodes_stargate_with_primarykey(allnodes_stargateusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "insertAllnodes_stargate")
    @Override
    public void insertAllnodes_stargate(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Allnodes_stargate_usecases allnodes_stargateusecases = new Allnodes_stargate_usecases(loggedin);
            insert_allnodes_stargate(allnodes_stargateusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "updateAllnodes_stargate")
    @Override
    public void updateAllnodes_stargate(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Allnodes_stargate_usecases allnodes_stargateusecases = new Allnodes_stargate_usecases(loggedin);
            update_allnodes_stargate(allnodes_stargateusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "deleteAllnodes_stargate")
    @Override
    public void deleteAllnodes_stargate(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Allnodes_stargate_usecases allnodes_stargateusecases = new Allnodes_stargate_usecases(loggedin);
            delete_allnodes_stargate(allnodes_stargateusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }


    private String count_records(Allnodes_stargate_usecases allnodes_stargateusecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", allnodes_stargateusecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_allnodes_stargate(Allnodes_stargate_usecases allnodes_stargateusecases) throws ParseException, CustomException {
    	return JSONAllnodes_stargate.toJSONArray(allnodes_stargateusecases.get_all()).toJSONString();
    }
    
    private String get_allnodes_stargate_with_primarykey(Allnodes_stargate_usecases allnodes_stargateusecases, JSONObject json) throws ParseException, CustomException {
        IAllnodes_stargatePK allnodes_stargatePK = (IAllnodes_stargatePK)JSONAllnodes_stargate.toAllnodes_stargatePK((JSONObject)json.get("allnodes_stargatepk"));
	return JSONAllnodes_stargate.toJSON(allnodes_stargateusecases.get_allnodes_stargate_by_primarykey(allnodes_stargatePK)).toJSONString();
    }
    
    private String search_allnodes_stargate(Allnodes_stargate_usecases allnodes_stargateusecases, JSONObject json) throws ParseException, CustomException {
        IAllnodes_stargatesearch search = (IAllnodes_stargatesearch)JSONAllnodes_stargate.toAllnodes_stargatesearch((JSONObject)json.get("search"));
        return JSONAllnodes_stargate.toJSONArray(allnodes_stargateusecases.search_allnodes_stargate(search)).toJSONString();
    }
    
    private String search_allnodes_stargate_count(Allnodes_stargate_usecases allnodes_stargateusecases, JSONObject json) throws ParseException, CustomException {
        IAllnodes_stargatesearch allnodes_stargatesearch = (IAllnodes_stargatesearch)JSONAllnodes_stargate.toAllnodes_stargatesearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", allnodes_stargateusecases.search_allnodes_stargate_count(allnodes_stargatesearch));
        return jsonsearchcount.toJSONString();
    }

    private void insert_allnodes_stargate(Allnodes_stargate_usecases allnodes_stargateusecases, JSONObject json) throws ParseException, CustomException {
        IAllnodes_stargate allnodes_stargate = (IAllnodes_stargate)JSONAllnodes_stargate.toAllnodes_stargate((JSONObject)json.get("allnodes_stargate"));
        allnodes_stargateusecases.insertAllnodes_stargate(allnodes_stargate);
        setReturnstatus("OK");
    }

    private void update_allnodes_stargate(Allnodes_stargate_usecases allnodes_stargateusecases, JSONObject json) throws ParseException, CustomException {
        IAllnodes_stargate allnodes_stargate = (IAllnodes_stargate)JSONAllnodes_stargate.toAllnodes_stargate((JSONObject)json.get("allnodes_stargate"));
        allnodes_stargateusecases.updateAllnodes_stargate(allnodes_stargate);
        setReturnstatus("OK");
    }

    private void delete_allnodes_stargate(Allnodes_stargate_usecases allnodes_stargateusecases, JSONObject json) throws ParseException, CustomException {
        IAllnodes_stargate allnodes_stargate = (IAllnodes_stargate)JSONAllnodes_stargate.toAllnodes_stargate((JSONObject)json.get("allnodes_stargate"));
        allnodes_stargateusecases.deleteAllnodes_stargate(allnodes_stargate);
        setReturnstatus("OK");
    }

}

