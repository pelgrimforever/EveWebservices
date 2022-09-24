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
import eve.interfaces.searchentity.ISystemsearch;
import eve.interfaces.webservice.WSISystem;
import eve.logicentity.System;
import eve.searchentity.Systemsearch;
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

@WebService(endpointInterface = "eve.interfaces.webservice.WSISystem")
public class WSSystem extends RS_json_login implements WSISystem {

    private Security_usecases security_usecases = new Security_usecases();
    
    private JSONArray toJSONArray(ArrayList systems) {
        JSONArray jsonsystems = new JSONArray();
        Iterator systemsI = systems.iterator();
        while(systemsI.hasNext()) {
            jsonsystems.add(JSONSystem.toJSON((System)systemsI.next()));
        }
        return jsonsystems;
    }

    //@WebMethod(operationName = "getSystems")
    @Override
    public String getSystems() {
        try {
            System_usecases systemusecases = new System_usecases(loggedin);
            return get_all_system(systemusecases);
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
            System_usecases systemusecases = new System_usecases(loggedin);
            return search_system(systemusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "getSystem")
    @Override
    public String getSystem(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            System_usecases systemusecases = new System_usecases(loggedin);
            return get_system_with_primarykey(systemusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "insertSystem")
    @Override
    public void insertSystem(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            System_usecases systemusecases = new System_usecases(loggedin);
            insert_system(systemusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "updateSystem")
    @Override
    public void updateSystem(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            System_usecases systemusecases = new System_usecases(loggedin);
            update_system(systemusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "deleteSystem")
    @Override
    public void deleteSystem(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            System_usecases systemusecases = new System_usecases(loggedin);
            delete_system(systemusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getSystems4security_island")
    @Override
    public String getSystems4security_island(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            System_usecases systemusecases = new System_usecases(loggedin);
            return get_system_with_foreignkey_security_island(systemusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "delete4security_island")
    @Override
    public void delete4security_island(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            System_usecases systemusecases = new System_usecases(loggedin);
            delete_system(systemusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getSystems4constellation")
    @Override
    public String getSystems4constellation(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            System_usecases systemusecases = new System_usecases(loggedin);
            return get_system_with_foreignkey_constellation(systemusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "delete4constellation")
    @Override
    public void delete4constellation(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            System_usecases systemusecases = new System_usecases(loggedin);
            delete_system(systemusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getSystems4systemjumpsSystem_end")
    @Override
    public String getSystems4systemjumpsSystem_end(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            System_usecases systemusecases = new System_usecases(loggedin);
            return get_system_with_externalforeignkey_systemjumpsSystem_end(systemusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "getSystems4systemjumpsSystem_start")
    @Override
    public String getSystems4systemjumpsSystem_start(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            System_usecases systemusecases = new System_usecases(loggedin);
            return get_system_with_externalforeignkey_systemjumpsSystem_start(systemusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "getSystems4tradecombinedBuy_system")
    @Override
    public String getSystems4tradecombinedBuy_system(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            System_usecases systemusecases = new System_usecases(loggedin);
            return get_system_with_externalforeignkey_tradecombinedBuy_system(systemusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "getSystems4tradecombinedSell_system")
    @Override
    public String getSystems4tradecombinedSell_system(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            System_usecases systemusecases = new System_usecases(loggedin);
            return get_system_with_externalforeignkey_tradecombinedSell_system(systemusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }


    private String count_records(System_usecases systemusecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", systemusecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_system(System_usecases systemusecases) throws ParseException, CustomException {
    	return JSONSystem.toJSONArray(systemusecases.get_all()).toJSONString();
    }
    
    private String get_system_with_primarykey(System_usecases systemusecases, JSONObject json) throws ParseException, CustomException {
        ISystemPK systemPK = (ISystemPK)JSONSystem.toSystemPK((JSONObject)json.get("systempk"));
	return JSONSystem.toJSON(systemusecases.get_system_by_primarykey(systemPK)).toJSONString();
    }
    
    private String get_system_with_foreignkey_security_island(System_usecases systemusecases, JSONObject json) throws ParseException, CustomException {
        ISecurity_islandPK security_islandPK = (ISecurity_islandPK)JSONSecurity_island.toSecurity_islandPK((JSONObject)json.get("security_islandpk"));
        return JSONSystem.toJSONArray(systemusecases.get_system_with_foreignkey_security_island(security_islandPK)).toJSONString();
    }
    
    private String get_system_with_foreignkey_constellation(System_usecases systemusecases, JSONObject json) throws ParseException, CustomException {
        IConstellationPK constellationPK = (IConstellationPK)JSONConstellation.toConstellationPK((JSONObject)json.get("constellationpk"));
        return JSONSystem.toJSONArray(systemusecases.get_system_with_foreignkey_constellation(constellationPK)).toJSONString();
    }
    
    private String get_system_with_externalforeignkey_systemjumpsSystem_end(System_usecases systemusecases, JSONObject json) throws ParseException, CustomException {
        ISystemjumpsPK systemjumpsSystem_endPK = (ISystemjumpsPK)JSONSystemjumps.toSystemjumpsPK((JSONObject)json.get("systemjumpspk"));
        return JSONSystem.toJSON(systemusecases.get_system_with_externalforeignkey_systemjumpsSystem_end(systemjumpsSystem_endPK)).toJSONString();
    }
    
    private String get_system_with_externalforeignkey_systemjumpsSystem_start(System_usecases systemusecases, JSONObject json) throws ParseException, CustomException {
        ISystemjumpsPK systemjumpsSystem_startPK = (ISystemjumpsPK)JSONSystemjumps.toSystemjumpsPK((JSONObject)json.get("systemjumpspk"));
        return JSONSystem.toJSON(systemusecases.get_system_with_externalforeignkey_systemjumpsSystem_start(systemjumpsSystem_startPK)).toJSONString();
    }
    
    private String get_system_with_externalforeignkey_tradecombinedBuy_system(System_usecases systemusecases, JSONObject json) throws ParseException, CustomException {
        ITradecombinedPK tradecombinedBuy_systemPK = (ITradecombinedPK)JSONTradecombined.toTradecombinedPK((JSONObject)json.get("tradecombinedpk"));
        return JSONSystem.toJSON(systemusecases.get_system_with_externalforeignkey_tradecombinedBuy_system(tradecombinedBuy_systemPK)).toJSONString();
    }
    
    private String get_system_with_externalforeignkey_tradecombinedSell_system(System_usecases systemusecases, JSONObject json) throws ParseException, CustomException {
        ITradecombinedPK tradecombinedSell_systemPK = (ITradecombinedPK)JSONTradecombined.toTradecombinedPK((JSONObject)json.get("tradecombinedpk"));
        return JSONSystem.toJSON(systemusecases.get_system_with_externalforeignkey_tradecombinedSell_system(tradecombinedSell_systemPK)).toJSONString();
    }
    
    private String search_system(System_usecases systemusecases, JSONObject json) throws ParseException, CustomException {
        ISystemsearch search = (ISystemsearch)JSONSystem.toSystemsearch((JSONObject)json.get("search"));
        return JSONSystem.toJSONArray(systemusecases.search_system(search)).toJSONString();
    }
    
    private String search_system_count(System_usecases systemusecases, JSONObject json) throws ParseException, CustomException {
        ISystemsearch systemsearch = (ISystemsearch)JSONSystem.toSystemsearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", systemusecases.search_system_count(systemsearch));
        return jsonsearchcount.toJSONString();
    }

    private void insert_system(System_usecases systemusecases, JSONObject json) throws ParseException, CustomException {
        ISystem system = (ISystem)JSONSystem.toSystem((JSONObject)json.get("system"));
        systemusecases.insertSystem(system);
        setReturnstatus("OK");
    }

    private void update_system(System_usecases systemusecases, JSONObject json) throws ParseException, CustomException {
        ISystem system = (ISystem)JSONSystem.toSystem((JSONObject)json.get("system"));
        systemusecases.updateSystem(system);
        setReturnstatus("OK");
    }

    private void delete_system(System_usecases systemusecases, JSONObject json) throws ParseException, CustomException {
        ISystem system = (ISystem)JSONSystem.toSystem((JSONObject)json.get("system"));
        systemusecases.deleteSystem(system);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Security_island(System_usecases systemusecases, JSONObject json) throws ParseException, CustomException {
        ISecurity_islandPK security_islandPK = (ISecurity_islandPK)JSONSecurity_island.toSecurity_islandPK((JSONObject)json.get("security_islandpk"));
        systemusecases.delete_all_containing_Security_island(security_islandPK);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Constellation(System_usecases systemusecases, JSONObject json) throws ParseException, CustomException {
        IConstellationPK constellationPK = (IConstellationPK)JSONConstellation.toConstellationPK((JSONObject)json.get("constellationpk"));
        systemusecases.delete_all_containing_Constellation(constellationPK);
        setReturnstatus("OK");
    }

}

