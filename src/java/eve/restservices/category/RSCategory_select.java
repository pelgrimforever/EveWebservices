/*
 * Generated on 23.8.2022 14:38
 * @author Franky Laseure
 */

package eve.restservices.category;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.usecases.*;
import eve.usecases.custom.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.searchentity.ICategorysearch;
import eve.interfaces.servlet.ICategoryOperation;
import eve.logicentity.Category;
import eve.searchentity.Categorysearch;
import eve.servlets.DataServlet;
import eve.usecases.custom.*;
import general.exception.*;
import java.sql.Date;
import java.sql.Time;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

@Path("rscategory_select")
public class RSCategory_select extends RS_json_login {

    private Security_usecases security_usecases = new Security_usecases();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Category_usecases categoryusecases = new Category_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case ICategoryOperation.SELECT_COUNT:
                    result = count_records(categoryusecases);
                    break;
                case ICategoryOperation.SELECT_ALL:
                    result = get_all_category(categoryusecases);
                    break;
                case ICategoryOperation.SELECT_CATEGORY:
                    result = get_category_with_primarykey(categoryusecases, json);
                    break;
                case ICategoryOperation.SELECT_SEARCH:
                    result = search_category(categoryusecases, json);
                    break;
                case ICategoryOperation.SELECT_SEARCHCOUNT:
                    result = search_category_count(categoryusecases, json);
                    break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            }
        }
        catch(ParseException | CustomException | IOException e) {
            setReturnstatus(e.getMessage());
        }
        return result;
    }

//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   

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
}

