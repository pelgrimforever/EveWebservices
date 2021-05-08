package eve.webservices;

import eve.BusinessObject.Logic.*;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.webservice.WSICategory;
import eve.logicentity.Category;
import eve.searchentity.Categorysearch;
import general.exception.CustomException;
import general.exception.DataException;
import general.exception.DBException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.jws.WebMethod;
import javax.jws.WebService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Franky Laseure
 */
@WebService(endpointInterface = "eve.interfaces.webservice.WSICategory")
public class WSCategory implements WSICategory {

    private JSONArray toJSONArray(ArrayList categorys) {
        JSONArray jsoncategorys = new JSONArray();
        Iterator categorysI = categorys.iterator();
        while(categorysI.hasNext()) {
            jsoncategorys.add(JSONCategory.toJSON((Category)categorysI.next()));
        }
        return jsoncategorys;
    }

    /**
     * Web service operation
     */
    //@WebMethod(operationName = "getCategorys")
    @Override
    public String getCategorys() {
        try {
            BLcategory blcategory = new BLcategory();
            ArrayList categorys = blcategory.getAll();
            JSONArray jsoncategorys = toJSONArray(categorys);
            return jsoncategorys.toJSONString();
        }
        catch(DBException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "search")
    @Override
    public String search(String json) {
        BLcategory blcategory = new BLcategory();
        JSONParser parser = new JSONParser();
        String result = "";
        Category category;
        try {
            Categorysearch categorysearch = JSONCategory.toCategorysearch((JSONObject)parser.parse(json));
            ArrayList categorys = blcategory.search(categorysearch);
            JSONArray jsoncategorys = toJSONArray(categorys);
            result = jsoncategorys.toJSONString();
        }
        catch(ParseException e) {
            result = "";
        }
        catch(DBException e) {
            result = "";
        }
        return result;
    }

    //@WebMethod(operationName = "getCategory")
    @Override
    public String getCategory(String json) {
        BLcategory blcategory = new BLcategory();
        JSONParser parser = new JSONParser();
        String result = "";
        Category category;
        try {
            CategoryPK categoryPK = JSONCategory.toCategoryPK((JSONObject)parser.parse(json));
            category = blcategory.getCategory(categoryPK);
            if(category!=null) {
                result = JSONCategory.toJSON(category).toJSONString();
            }
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
        return result;
    }

    //@WebMethod(operationName = "insertCategory")
    @Override
    public void insertCategory(String json) {
        BLcategory blcategory = new BLcategory();
        JSONParser parser = new JSONParser();
        try {
            ICategory category = JSONCategory.toCategory((JSONObject)parser.parse(json));
            blcategory.insertCategory(category);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "updateCategory")
    @Override
    public void updateCategory(String json) {
        BLcategory blcategory = new BLcategory();
        JSONParser parser = new JSONParser();
        try {
            ICategory category = JSONCategory.toCategory((JSONObject)parser.parse(json));
            blcategory.updateCategory(category);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "deleteCategory")
    @Override
    public void deleteCategory(String json) {
        BLcategory blcategory = new BLcategory();
        JSONParser parser = new JSONParser();
        try {
            ICategory category = JSONCategory.toCategory((JSONObject)parser.parse(json));
            blcategory.deleteCategory(category);
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
    }


}

