/*
 * WSRoutetype.java
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
import eve.interfaces.searchentity.IRoutetypesearch;
import eve.interfaces.webservice.WSIRoutetype;
import eve.logicentity.Routetype;
import eve.searchentity.Routetypesearch;
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
@WebService(endpointInterface = "eve.interfaces.webservice.WSIRoutetype")
public class WSRoutetype extends RS_json_login implements WSIRoutetype {

    private Security_usecases security_usecases = new Security_usecases();
    
    private JSONArray toJSONArray(ArrayList routetypes) {
        JSONArray jsonroutetypes = new JSONArray();
        Iterator routetypesI = routetypes.iterator();
        while(routetypesI.hasNext()) {
            jsonroutetypes.add(JSONRoutetype.toJSON((Routetype)routetypesI.next()));
        }
        return jsonroutetypes;
    }

    //@WebMethod(operationName = "getRoutetypes")
    @Override
    public String getRoutetypes() {
        try {
            Routetype_usecases routetypeusecases = new Routetype_usecases(loggedin);
            return get_all_routetype(routetypeusecases);
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
            Routetype_usecases routetypeusecases = new Routetype_usecases(loggedin);
            return search_routetype(routetypeusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "getRoutetype")
    @Override
    public String getRoutetype(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Routetype_usecases routetypeusecases = new Routetype_usecases(loggedin);
            return get_routetype_with_primarykey(routetypeusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "insertRoutetype")
    @Override
    public void insertRoutetype(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Routetype_usecases routetypeusecases = new Routetype_usecases(loggedin);
            insert_routetype(routetypeusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "updateRoutetype")
    @Override
    public void updateRoutetype(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Routetype_usecases routetypeusecases = new Routetype_usecases(loggedin);
            update_routetype(routetypeusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "deleteRoutetype")
    @Override
    public void deleteRoutetype(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Routetype_usecases routetypeusecases = new Routetype_usecases(loggedin);
            delete_routetype(routetypeusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getRoutetypes4security_island")
    @Override
    public String getRoutetypes4security_island(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Routetype_usecases routetypeusecases = new Routetype_usecases(loggedin);
            return get_routetype_with_foreignkey_security_island(routetypeusecases, json);
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
            Routetype_usecases routetypeusecases = new Routetype_usecases(loggedin);
            delete_routetype(routetypeusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }


    private String count_records(Routetype_usecases routetypeusecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", routetypeusecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_routetype(Routetype_usecases routetypeusecases) throws ParseException, CustomException {
    	return JSONRoutetype.toJSONArray(routetypeusecases.get_all()).toJSONString();
    }
    
    private String get_routetype_with_primarykey(Routetype_usecases routetypeusecases, JSONObject json) throws ParseException, CustomException {
        IRoutetypePK routetypePK = (IRoutetypePK)JSONRoutetype.toRoutetypePK((JSONObject)json.get("routetypepk"));
	return JSONRoutetype.toJSON(routetypeusecases.get_routetype_by_primarykey(routetypePK)).toJSONString();
    }
    
    private String get_routetype_with_foreignkey_security_island(Routetype_usecases routetypeusecases, JSONObject json) throws ParseException, CustomException {
        ISecurity_islandPK security_islandPK = (ISecurity_islandPK)JSONSecurity_island.toSecurity_islandPK((JSONObject)json.get("security_islandpk"));
        return JSONRoutetype.toJSONArray(routetypeusecases.get_routetype_with_foreignkey_security_island(security_islandPK)).toJSONString();
    }
    
    private String search_routetype(Routetype_usecases routetypeusecases, JSONObject json) throws ParseException, CustomException {
        IRoutetypesearch search = (IRoutetypesearch)JSONRoutetype.toRoutetypesearch((JSONObject)json.get("search"));
        return JSONRoutetype.toJSONArray(routetypeusecases.search_routetype(search)).toJSONString();
    }
    
    private String search_routetype_count(Routetype_usecases routetypeusecases, JSONObject json) throws ParseException, CustomException {
        IRoutetypesearch routetypesearch = (IRoutetypesearch)JSONRoutetype.toRoutetypesearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", routetypeusecases.search_routetype_count(routetypesearch));
        return jsonsearchcount.toJSONString();
    }

    private void insert_routetype(Routetype_usecases routetypeusecases, JSONObject json) throws ParseException, CustomException {
        IRoutetype routetype = (IRoutetype)JSONRoutetype.toRoutetype((JSONObject)json.get("routetype"));
        routetypeusecases.insertRoutetype(routetype);
        setReturnstatus("OK");
    }

    private void update_routetype(Routetype_usecases routetypeusecases, JSONObject json) throws ParseException, CustomException {
        IRoutetype routetype = (IRoutetype)JSONRoutetype.toRoutetype((JSONObject)json.get("routetype"));
        routetypeusecases.updateRoutetype(routetype);
        setReturnstatus("OK");
    }

    private void delete_routetype(Routetype_usecases routetypeusecases, JSONObject json) throws ParseException, CustomException {
        IRoutetype routetype = (IRoutetype)JSONRoutetype.toRoutetype((JSONObject)json.get("routetype"));
        routetypeusecases.deleteRoutetype(routetype);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Security_island(Routetype_usecases routetypeusecases, JSONObject json) throws ParseException, CustomException {
        ISecurity_islandPK security_islandPK = (ISecurity_islandPK)JSONSecurity_island.toSecurity_islandPK((JSONObject)json.get("security_islandpk"));
        routetypeusecases.delete_all_containing_Security_island(security_islandPK);
        setReturnstatus("OK");
    }

}

