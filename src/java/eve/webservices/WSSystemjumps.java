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
import eve.interfaces.searchentity.ISystemjumpssearch;
import eve.interfaces.webservice.WSISystemjumps;
import eve.logicentity.Systemjumps;
import eve.searchentity.Systemjumpssearch;
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

@WebService(endpointInterface = "eve.interfaces.webservice.WSISystemjumps")
public class WSSystemjumps extends RS_json_login implements WSISystemjumps {

    private Security_usecases security_usecases = new Security_usecases();
    
    private JSONArray toJSONArray(ArrayList systemjumpss) {
        JSONArray jsonsystemjumpss = new JSONArray();
        Iterator systemjumpssI = systemjumpss.iterator();
        while(systemjumpssI.hasNext()) {
            jsonsystemjumpss.add(JSONSystemjumps.toJSON((Systemjumps)systemjumpssI.next()));
        }
        return jsonsystemjumpss;
    }

    //@WebMethod(operationName = "getSystemjumpss")
    @Override
    public String getSystemjumpss() {
        try {
            Systemjumps_usecases systemjumpsusecases = new Systemjumps_usecases(loggedin);
            return get_all_systemjumps(systemjumpsusecases);
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
            Systemjumps_usecases systemjumpsusecases = new Systemjumps_usecases(loggedin);
            return search_systemjumps(systemjumpsusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "getSystemjumps")
    @Override
    public String getSystemjumps(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Systemjumps_usecases systemjumpsusecases = new Systemjumps_usecases(loggedin);
            return get_systemjumps_with_primarykey(systemjumpsusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "insertSystemjumps")
    @Override
    public void insertSystemjumps(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Systemjumps_usecases systemjumpsusecases = new Systemjumps_usecases(loggedin);
            insert_systemjumps(systemjumpsusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "updateSystemjumps")
    @Override
    public void updateSystemjumps(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Systemjumps_usecases systemjumpsusecases = new Systemjumps_usecases(loggedin);
            update_systemjumps(systemjumpsusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "deleteSystemjumps")
    @Override
    public void deleteSystemjumps(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Systemjumps_usecases systemjumpsusecases = new Systemjumps_usecases(loggedin);
            delete_systemjumps(systemjumpsusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getSystemjumpss4systemSystem_end")
    @Override
    public String getSystemjumpss4systemSystem_end(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Systemjumps_usecases systemjumpsusecases = new Systemjumps_usecases(loggedin);
            return get_systemjumps_with_foreignkey_systemSystem_end(systemjumpsusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "delete4systemSystem_end")
    @Override
    public void delete4systemSystem_end(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Systemjumps_usecases systemjumpsusecases = new Systemjumps_usecases(loggedin);
            delete_systemjumps(systemjumpsusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getSystemjumpss4systemSystem_start")
    @Override
    public String getSystemjumpss4systemSystem_start(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Systemjumps_usecases systemjumpsusecases = new Systemjumps_usecases(loggedin);
            return get_systemjumps_with_foreignkey_systemSystem_start(systemjumpsusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "delete4systemSystem_start")
    @Override
    public void delete4systemSystem_start(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Systemjumps_usecases systemjumpsusecases = new Systemjumps_usecases(loggedin);
            delete_systemjumps(systemjumpsusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }


    private String count_records(Systemjumps_usecases systemjumpsusecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", systemjumpsusecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_systemjumps(Systemjumps_usecases systemjumpsusecases) throws ParseException, CustomException {
    	return JSONSystemjumps.toJSONArray(systemjumpsusecases.get_all()).toJSONString();
    }
    
    private String get_systemjumps_with_primarykey(Systemjumps_usecases systemjumpsusecases, JSONObject json) throws ParseException, CustomException {
        ISystemjumpsPK systemjumpsPK = (ISystemjumpsPK)JSONSystemjumps.toSystemjumpsPK((JSONObject)json.get("systemjumpspk"));
	return JSONSystemjumps.toJSON(systemjumpsusecases.get_systemjumps_by_primarykey(systemjumpsPK)).toJSONString();
    }
    
    private String get_systemjumps_with_foreignkey_systemSystem_end(Systemjumps_usecases systemjumpsusecases, JSONObject json) throws ParseException, CustomException {
        ISystemPK systemSystem_endPK = (ISystemPK)JSONSystem.toSystemPK((JSONObject)json.get("systempk"));
        return JSONSystemjumps.toJSONArray(systemjumpsusecases.get_systemjumps_with_foreignkey_systemSystem_end(systemSystem_endPK)).toJSONString();
    }
    
    private String get_systemjumps_with_foreignkey_systemSystem_start(Systemjumps_usecases systemjumpsusecases, JSONObject json) throws ParseException, CustomException {
        ISystemPK systemSystem_startPK = (ISystemPK)JSONSystem.toSystemPK((JSONObject)json.get("systempk"));
        return JSONSystemjumps.toJSONArray(systemjumpsusecases.get_systemjumps_with_foreignkey_systemSystem_start(systemSystem_startPK)).toJSONString();
    }
    
    private String search_systemjumps(Systemjumps_usecases systemjumpsusecases, JSONObject json) throws ParseException, CustomException {
        ISystemjumpssearch search = (ISystemjumpssearch)JSONSystemjumps.toSystemjumpssearch((JSONObject)json.get("search"));
        return JSONSystemjumps.toJSONArray(systemjumpsusecases.search_systemjumps(search)).toJSONString();
    }
    
    private String search_systemjumps_count(Systemjumps_usecases systemjumpsusecases, JSONObject json) throws ParseException, CustomException {
        ISystemjumpssearch systemjumpssearch = (ISystemjumpssearch)JSONSystemjumps.toSystemjumpssearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", systemjumpsusecases.search_systemjumps_count(systemjumpssearch));
        return jsonsearchcount.toJSONString();
    }

    private void insert_systemjumps(Systemjumps_usecases systemjumpsusecases, JSONObject json) throws ParseException, CustomException {
        ISystemjumps systemjumps = (ISystemjumps)JSONSystemjumps.toSystemjumps((JSONObject)json.get("systemjumps"));
        systemjumpsusecases.insertSystemjumps(systemjumps);
        setReturnstatus("OK");
    }

    private void update_systemjumps(Systemjumps_usecases systemjumpsusecases, JSONObject json) throws ParseException, CustomException {
        ISystemjumps systemjumps = (ISystemjumps)JSONSystemjumps.toSystemjumps((JSONObject)json.get("systemjumps"));
        systemjumpsusecases.updateSystemjumps(systemjumps);
        setReturnstatus("OK");
    }

    private void delete_systemjumps(Systemjumps_usecases systemjumpsusecases, JSONObject json) throws ParseException, CustomException {
        ISystemjumps systemjumps = (ISystemjumps)JSONSystemjumps.toSystemjumps((JSONObject)json.get("systemjumps"));
        systemjumpsusecases.deleteSystemjumps(systemjumps);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Systemsystem_end(Systemjumps_usecases systemjumpsusecases, JSONObject json) throws ParseException, CustomException {
        ISystemPK systemSystem_endPK = (ISystemPK)JSONSystem.toSystemPK((JSONObject)json.get("systempk"));
        systemjumpsusecases.delete_all_containing_Systemsystem_end(systemSystem_endPK);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Systemsystem_start(Systemjumps_usecases systemjumpsusecases, JSONObject json) throws ParseException, CustomException {
        ISystemPK systemSystem_startPK = (ISystemPK)JSONSystem.toSystemPK((JSONObject)json.get("systempk"));
        systemjumpsusecases.delete_all_containing_Systemsystem_start(systemSystem_startPK);
        setReturnstatus("OK");
    }

}

