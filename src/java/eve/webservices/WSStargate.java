/*
 * WSStargate.java
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
import eve.interfaces.searchentity.IStargatesearch;
import eve.interfaces.webservice.WSIStargate;
import eve.logicentity.Stargate;
import eve.searchentity.Stargatesearch;
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
@WebService(endpointInterface = "eve.interfaces.webservice.WSIStargate")
public class WSStargate extends RS_json_login implements WSIStargate {

    private Security_usecases security_usecases = new Security_usecases();
    
    private JSONArray toJSONArray(ArrayList stargates) {
        JSONArray jsonstargates = new JSONArray();
        Iterator stargatesI = stargates.iterator();
        while(stargatesI.hasNext()) {
            jsonstargates.add(JSONStargate.toJSON((Stargate)stargatesI.next()));
        }
        return jsonstargates;
    }

    //@WebMethod(operationName = "getStargates")
    @Override
    public String getStargates() {
        try {
            Stargate_usecases stargateusecases = new Stargate_usecases(loggedin);
            return get_all_stargate(stargateusecases);
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
            Stargate_usecases stargateusecases = new Stargate_usecases(loggedin);
            return search_stargate(stargateusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "getStargate")
    @Override
    public String getStargate(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Stargate_usecases stargateusecases = new Stargate_usecases(loggedin);
            return get_stargate_with_primarykey(stargateusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "insertStargate")
    @Override
    public void insertStargate(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Stargate_usecases stargateusecases = new Stargate_usecases(loggedin);
            insert_stargate(stargateusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "updateStargate")
    @Override
    public void updateStargate(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Stargate_usecases stargateusecases = new Stargate_usecases(loggedin);
            update_stargate(stargateusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "deleteStargate")
    @Override
    public void deleteStargate(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Stargate_usecases stargateusecases = new Stargate_usecases(loggedin);
            delete_stargate(stargateusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getStargates4systemSystem")
    @Override
    public String getStargates4systemSystem(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Stargate_usecases stargateusecases = new Stargate_usecases(loggedin);
            return get_stargate_with_foreignkey_systemSystem(stargateusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "delete4systemSystem")
    @Override
    public void delete4systemSystem(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Stargate_usecases stargateusecases = new Stargate_usecases(loggedin);
            delete_stargate(stargateusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getStargates4systemTo_system")
    @Override
    public String getStargates4systemTo_system(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Stargate_usecases stargateusecases = new Stargate_usecases(loggedin);
            return get_stargate_with_foreignkey_systemTo_system(stargateusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "delete4systemTo_system")
    @Override
    public void delete4systemTo_system(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Stargate_usecases stargateusecases = new Stargate_usecases(loggedin);
            delete_stargate(stargateusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }


    private String count_records(Stargate_usecases stargateusecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", stargateusecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_stargate(Stargate_usecases stargateusecases) throws ParseException, CustomException {
    	return JSONStargate.toJSONArray(stargateusecases.get_all()).toJSONString();
    }
    
    private String get_stargate_with_primarykey(Stargate_usecases stargateusecases, JSONObject json) throws ParseException, CustomException {
        IStargatePK stargatePK = (IStargatePK)JSONStargate.toStargatePK((JSONObject)json.get("stargatepk"));
	return JSONStargate.toJSON(stargateusecases.get_stargate_by_primarykey(stargatePK)).toJSONString();
    }
    
    private String get_stargate_with_foreignkey_systemSystem(Stargate_usecases stargateusecases, JSONObject json) throws ParseException, CustomException {
        ISystemPK systemSystemPK = (ISystemPK)JSONSystem.toSystemPK((JSONObject)json.get("systempk"));
        return JSONStargate.toJSONArray(stargateusecases.get_stargate_with_foreignkey_systemSystem(systemSystemPK)).toJSONString();
    }
    
    private String get_stargate_with_foreignkey_systemTo_system(Stargate_usecases stargateusecases, JSONObject json) throws ParseException, CustomException {
        ISystemPK systemTo_systemPK = (ISystemPK)JSONSystem.toSystemPK((JSONObject)json.get("systempk"));
        return JSONStargate.toJSONArray(stargateusecases.get_stargate_with_foreignkey_systemTo_system(systemTo_systemPK)).toJSONString();
    }
    
    private String search_stargate(Stargate_usecases stargateusecases, JSONObject json) throws ParseException, CustomException {
        IStargatesearch search = (IStargatesearch)JSONStargate.toStargatesearch((JSONObject)json.get("search"));
        return JSONStargate.toJSONArray(stargateusecases.search_stargate(search)).toJSONString();
    }
    
    private String search_stargate_count(Stargate_usecases stargateusecases, JSONObject json) throws ParseException, CustomException {
        IStargatesearch stargatesearch = (IStargatesearch)JSONStargate.toStargatesearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", stargateusecases.search_stargate_count(stargatesearch));
        return jsonsearchcount.toJSONString();
    }

    private void insert_stargate(Stargate_usecases stargateusecases, JSONObject json) throws ParseException, CustomException {
        IStargate stargate = (IStargate)JSONStargate.toStargate((JSONObject)json.get("stargate"));
        stargateusecases.insertStargate(stargate);
        setReturnstatus("OK");
    }

    private void update_stargate(Stargate_usecases stargateusecases, JSONObject json) throws ParseException, CustomException {
        IStargate stargate = (IStargate)JSONStargate.toStargate((JSONObject)json.get("stargate"));
        stargateusecases.updateStargate(stargate);
        setReturnstatus("OK");
    }

    private void delete_stargate(Stargate_usecases stargateusecases, JSONObject json) throws ParseException, CustomException {
        IStargate stargate = (IStargate)JSONStargate.toStargate((JSONObject)json.get("stargate"));
        stargateusecases.deleteStargate(stargate);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Systemsystem(Stargate_usecases stargateusecases, JSONObject json) throws ParseException, CustomException {
        ISystemPK systemSystemPK = (ISystemPK)JSONSystem.toSystemPK((JSONObject)json.get("systempk"));
        stargateusecases.delete_all_containing_Systemsystem(systemSystemPK);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Systemto_system(Stargate_usecases stargateusecases, JSONObject json) throws ParseException, CustomException {
        ISystemPK systemTo_systemPK = (ISystemPK)JSONSystem.toSystemPK((JSONObject)json.get("systempk"));
        stargateusecases.delete_all_containing_Systemto_system(systemTo_systemPK);
        setReturnstatus("OK");
    }

}

