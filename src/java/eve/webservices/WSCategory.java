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
import eve.interfaces.searchentity.ICategorysearch;
import eve.interfaces.webservice.WSICategory;
import eve.logicentity.Category;
import eve.searchentity.Categorysearch;
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

@WebService(endpointInterface = "eve.interfaces.webservice.WSICategory")
public class WSCategory extends RS_json_login implements WSICategory {

    private Security_usecases security_usecases = new Security_usecases();
    
    private JSONArray toJSONArray(ArrayList categorys) {
        JSONArray jsoncategorys = new JSONArray();
        Iterator categorysI = categorys.iterator();
        while(categorysI.hasNext()) {
            jsoncategorys.add(JSONCategory.toJSON((Category)categorysI.next()));
        }
        return jsoncategorys;
    }

    //@WebMethod(operationName = "getCategorys")
    @Override
    public String getCategorys() {
        try {
            Category_usecases categoryusecases = new Category_usecases(loggedin);
            return get_all_category(categoryusecases);
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
            Category_usecases categoryusecases = new Category_usecases(loggedin);
            return search_category(categoryusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "getCategory")
    @Override
    public String getCategory(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Category_usecases categoryusecases = new Category_usecases(loggedin);
            return get_category_with_primarykey(categoryusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "insertCategory")
    @Override
    public void insertCategory(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Category_usecases categoryusecases = new Category_usecases(loggedin);
            insert_category(categoryusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "updateCategory")
    @Override
    public void updateCategory(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Category_usecases categoryusecases = new Category_usecases(loggedin);
            update_category(categoryusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "deleteCategory")
    @Override
    public void deleteCategory(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Category_usecases categoryusecases = new Category_usecases(loggedin);
            delete_category(categoryusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }


    private String count_records(Category_usecases categoryusecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", categoryusecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_category(Category_usecases categoryusecases) throws ParseException, CustomException {
    	return JSONCategory.toJSONArray(categoryusecases.get_all()).toJSONString();
    }
    
    private String get_category_with_primarykey(Category_usecases categoryusecases, JSONObject json) throws ParseException, CustomException {
        ICategoryPK categoryPK = (ICategoryPK)JSONCategory.toCategoryPK((JSONObject)json.get("categorypk"));
	return JSONCategory.toJSON(categoryusecases.get_category_by_primarykey(categoryPK)).toJSONString();
    }
    
    private String search_category(Category_usecases categoryusecases, JSONObject json) throws ParseException, CustomException {
        ICategorysearch search = (ICategorysearch)JSONCategory.toCategorysearch((JSONObject)json.get("search"));
        return JSONCategory.toJSONArray(categoryusecases.search_category(search)).toJSONString();
    }
    
    private String search_category_count(Category_usecases categoryusecases, JSONObject json) throws ParseException, CustomException {
        ICategorysearch categorysearch = (ICategorysearch)JSONCategory.toCategorysearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", categoryusecases.search_category_count(categorysearch));
        return jsonsearchcount.toJSONString();
    }

    private void insert_category(Category_usecases categoryusecases, JSONObject json) throws ParseException, CustomException {
        ICategory category = (ICategory)JSONCategory.toCategory((JSONObject)json.get("category"));
        categoryusecases.insertCategory(category);
        setReturnstatus("OK");
    }

    private void update_category(Category_usecases categoryusecases, JSONObject json) throws ParseException, CustomException {
        ICategory category = (ICategory)JSONCategory.toCategory((JSONObject)json.get("category"));
        categoryusecases.updateCategory(category);
        setReturnstatus("OK");
    }

    private void delete_category(Category_usecases categoryusecases, JSONObject json) throws ParseException, CustomException {
        ICategory category = (ICategory)JSONCategory.toCategory((JSONObject)json.get("category"));
        categoryusecases.deleteCategory(category);
        setReturnstatus("OK");
    }

}

