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
import eve.interfaces.searchentity.ITypegroupsearch;
import eve.interfaces.webservice.WSITypegroup;
import eve.logicentity.Typegroup;
import eve.searchentity.Typegroupsearch;
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

@WebService(endpointInterface = "eve.interfaces.webservice.WSITypegroup")
public class WSTypegroup extends RS_json_login implements WSITypegroup {

    private Security_usecases security_usecases = new Security_usecases();
    
    private JSONArray toJSONArray(ArrayList typegroups) {
        JSONArray jsontypegroups = new JSONArray();
        Iterator typegroupsI = typegroups.iterator();
        while(typegroupsI.hasNext()) {
            jsontypegroups.add(JSONTypegroup.toJSON((Typegroup)typegroupsI.next()));
        }
        return jsontypegroups;
    }

    //@WebMethod(operationName = "getTypegroups")
    @Override
    public String getTypegroups() {
        try {
            Typegroup_usecases typegroupusecases = new Typegroup_usecases(loggedin);
            return get_all_typegroup(typegroupusecases);
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
            Typegroup_usecases typegroupusecases = new Typegroup_usecases(loggedin);
            return search_typegroup(typegroupusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "getTypegroup")
    @Override
    public String getTypegroup(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Typegroup_usecases typegroupusecases = new Typegroup_usecases(loggedin);
            return get_typegroup_with_primarykey(typegroupusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "insertTypegroup")
    @Override
    public void insertTypegroup(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Typegroup_usecases typegroupusecases = new Typegroup_usecases(loggedin);
            insert_typegroup(typegroupusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "updateTypegroup")
    @Override
    public void updateTypegroup(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Typegroup_usecases typegroupusecases = new Typegroup_usecases(loggedin);
            update_typegroup(typegroupusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "deleteTypegroup")
    @Override
    public void deleteTypegroup(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Typegroup_usecases typegroupusecases = new Typegroup_usecases(loggedin);
            delete_typegroup(typegroupusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getTypegroups4category")
    @Override
    public String getTypegroups4category(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Typegroup_usecases typegroupusecases = new Typegroup_usecases(loggedin);
            return get_typegroup_with_foreignkey_category(typegroupusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "delete4category")
    @Override
    public void delete4category(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Typegroup_usecases typegroupusecases = new Typegroup_usecases(loggedin);
            delete_typegroup(typegroupusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }


    private String count_records(Typegroup_usecases typegroupusecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", typegroupusecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_typegroup(Typegroup_usecases typegroupusecases) throws ParseException, CustomException {
    	return JSONTypegroup.toJSONArray(typegroupusecases.get_all()).toJSONString();
    }
    
    private String get_typegroup_with_primarykey(Typegroup_usecases typegroupusecases, JSONObject json) throws ParseException, CustomException {
        ITypegroupPK typegroupPK = (ITypegroupPK)JSONTypegroup.toTypegroupPK((JSONObject)json.get("typegrouppk"));
	return JSONTypegroup.toJSON(typegroupusecases.get_typegroup_by_primarykey(typegroupPK)).toJSONString();
    }
    
    private String get_typegroup_with_foreignkey_category(Typegroup_usecases typegroupusecases, JSONObject json) throws ParseException, CustomException {
        ICategoryPK categoryPK = (ICategoryPK)JSONCategory.toCategoryPK((JSONObject)json.get("categorypk"));
        return JSONTypegroup.toJSONArray(typegroupusecases.get_typegroup_with_foreignkey_category(categoryPK)).toJSONString();
    }
    
    private String search_typegroup(Typegroup_usecases typegroupusecases, JSONObject json) throws ParseException, CustomException {
        ITypegroupsearch search = (ITypegroupsearch)JSONTypegroup.toTypegroupsearch((JSONObject)json.get("search"));
        return JSONTypegroup.toJSONArray(typegroupusecases.search_typegroup(search)).toJSONString();
    }
    
    private String search_typegroup_count(Typegroup_usecases typegroupusecases, JSONObject json) throws ParseException, CustomException {
        ITypegroupsearch typegroupsearch = (ITypegroupsearch)JSONTypegroup.toTypegroupsearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", typegroupusecases.search_typegroup_count(typegroupsearch));
        return jsonsearchcount.toJSONString();
    }

    private void insert_typegroup(Typegroup_usecases typegroupusecases, JSONObject json) throws ParseException, CustomException {
        ITypegroup typegroup = (ITypegroup)JSONTypegroup.toTypegroup((JSONObject)json.get("typegroup"));
        typegroupusecases.insertTypegroup(typegroup);
        setReturnstatus("OK");
    }

    private void update_typegroup(Typegroup_usecases typegroupusecases, JSONObject json) throws ParseException, CustomException {
        ITypegroup typegroup = (ITypegroup)JSONTypegroup.toTypegroup((JSONObject)json.get("typegroup"));
        typegroupusecases.updateTypegroup(typegroup);
        setReturnstatus("OK");
    }

    private void delete_typegroup(Typegroup_usecases typegroupusecases, JSONObject json) throws ParseException, CustomException {
        ITypegroup typegroup = (ITypegroup)JSONTypegroup.toTypegroup((JSONObject)json.get("typegroup"));
        typegroupusecases.deleteTypegroup(typegroup);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Category(Typegroup_usecases typegroupusecases, JSONObject json) throws ParseException, CustomException {
        ICategoryPK categoryPK = (ICategoryPK)JSONCategory.toCategoryPK((JSONObject)json.get("categorypk"));
        typegroupusecases.delete_all_containing_Category(categoryPK);
        setReturnstatus("OK");
    }

}

