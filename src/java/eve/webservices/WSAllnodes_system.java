/*
 * WSAllnodes_system.java
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
import eve.interfaces.searchentity.IAllnodes_systemsearch;
import eve.interfaces.webservice.WSIAllnodes_system;
import eve.logicentity.Allnodes_system;
import eve.searchentity.Allnodes_systemsearch;
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
@WebService(endpointInterface = "eve.interfaces.webservice.WSIAllnodes_system")
public class WSAllnodes_system extends RS_json_login implements WSIAllnodes_system {

    private Security_usecases security_usecases = new Security_usecases();
    
    private JSONArray toJSONArray(ArrayList allnodes_systems) {
        JSONArray jsonallnodes_systems = new JSONArray();
        Iterator allnodes_systemsI = allnodes_systems.iterator();
        while(allnodes_systemsI.hasNext()) {
            jsonallnodes_systems.add(JSONAllnodes_system.toJSON((Allnodes_system)allnodes_systemsI.next()));
        }
        return jsonallnodes_systems;
    }

    //@WebMethod(operationName = "getAllnodes_systems")
    @Override
    public String getAllnodes_systems() {
        try {
            Allnodes_system_usecases allnodes_systemusecases = new Allnodes_system_usecases(loggedin);
            return get_all_allnodes_system(allnodes_systemusecases);
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
            Allnodes_system_usecases allnodes_systemusecases = new Allnodes_system_usecases(loggedin);
            return search_allnodes_system(allnodes_systemusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "getAllnodes_system")
    @Override
    public String getAllnodes_system(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Allnodes_system_usecases allnodes_systemusecases = new Allnodes_system_usecases(loggedin);
            return get_allnodes_system_with_primarykey(allnodes_systemusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "insertAllnodes_system")
    @Override
    public void insertAllnodes_system(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Allnodes_system_usecases allnodes_systemusecases = new Allnodes_system_usecases(loggedin);
            insert_allnodes_system(allnodes_systemusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "updateAllnodes_system")
    @Override
    public void updateAllnodes_system(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Allnodes_system_usecases allnodes_systemusecases = new Allnodes_system_usecases(loggedin);
            update_allnodes_system(allnodes_systemusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "deleteAllnodes_system")
    @Override
    public void deleteAllnodes_system(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Allnodes_system_usecases allnodes_systemusecases = new Allnodes_system_usecases(loggedin);
            delete_allnodes_system(allnodes_systemusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }


    private String count_records(Allnodes_system_usecases allnodes_systemusecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", allnodes_systemusecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_allnodes_system(Allnodes_system_usecases allnodes_systemusecases) throws ParseException, CustomException {
    	return JSONAllnodes_system.toJSONArray(allnodes_systemusecases.get_all()).toJSONString();
    }
    
    private String get_allnodes_system_with_primarykey(Allnodes_system_usecases allnodes_systemusecases, JSONObject json) throws ParseException, CustomException {
        IAllnodes_systemPK allnodes_systemPK = (IAllnodes_systemPK)JSONAllnodes_system.toAllnodes_systemPK((JSONObject)json.get("allnodes_systempk"));
	return JSONAllnodes_system.toJSON(allnodes_systemusecases.get_allnodes_system_by_primarykey(allnodes_systemPK)).toJSONString();
    }
    
    private String search_allnodes_system(Allnodes_system_usecases allnodes_systemusecases, JSONObject json) throws ParseException, CustomException {
        IAllnodes_systemsearch search = (IAllnodes_systemsearch)JSONAllnodes_system.toAllnodes_systemsearch((JSONObject)json.get("search"));
        return JSONAllnodes_system.toJSONArray(allnodes_systemusecases.search_allnodes_system(search)).toJSONString();
    }
    
    private String search_allnodes_system_count(Allnodes_system_usecases allnodes_systemusecases, JSONObject json) throws ParseException, CustomException {
        IAllnodes_systemsearch allnodes_systemsearch = (IAllnodes_systemsearch)JSONAllnodes_system.toAllnodes_systemsearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", allnodes_systemusecases.search_allnodes_system_count(allnodes_systemsearch));
        return jsonsearchcount.toJSONString();
    }

    private void insert_allnodes_system(Allnodes_system_usecases allnodes_systemusecases, JSONObject json) throws ParseException, CustomException {
        IAllnodes_system allnodes_system = (IAllnodes_system)JSONAllnodes_system.toAllnodes_system((JSONObject)json.get("allnodes_system"));
        allnodes_systemusecases.insertAllnodes_system(allnodes_system);
        setReturnstatus("OK");
    }

    private void update_allnodes_system(Allnodes_system_usecases allnodes_systemusecases, JSONObject json) throws ParseException, CustomException {
        IAllnodes_system allnodes_system = (IAllnodes_system)JSONAllnodes_system.toAllnodes_system((JSONObject)json.get("allnodes_system"));
        allnodes_systemusecases.updateAllnodes_system(allnodes_system);
        setReturnstatus("OK");
    }

    private void delete_allnodes_system(Allnodes_system_usecases allnodes_systemusecases, JSONObject json) throws ParseException, CustomException {
        IAllnodes_system allnodes_system = (IAllnodes_system)JSONAllnodes_system.toAllnodes_system((JSONObject)json.get("allnodes_system"));
        allnodes_systemusecases.deleteAllnodes_system(allnodes_system);
        setReturnstatus("OK");
    }

}

