/*
 * RSCategory.java
 *
 * Generated on 4.11.2021 14:51
 *
 */

package eve.restservices;

import base.servlets.Securitycheck;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import eve.BusinessObject.Logic.*;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.searchentity.ICategorysearch;
import eve.interfaces.servlet.ICategoryOperation;
import eve.logicentity.Category;
import eve.searchentity.Categorysearch;
import eve.servlets.DataServlet;
import general.exception.CustomException;
import general.exception.DataException;
import general.exception.DBException;
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
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * REST Web Service
 *
 * @author Franky Laseure
 */
@Path("rscategory")
public class RSCategory {

    /**
     * Creates a new instance of HelloWorld
     */
    public RSCategory() {
    }

    /**
     * Retrieves representation of an instance of category.restservices.RSCategory
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{json}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@PathParam("json") String jsonstring) {
        try {
            BLcategory blcategory = new BLcategory();
            ArrayList categorys = blcategory.getAll();
            JSONArray jsoncategorys = JSONCategory.toJSONArray(categorys);
            return jsoncategorys.toJSONString();
        }
        catch(DBException e) {
            return "{ \"status\": \"error\"}";
        }
    }

    /**
     * Retrieves representation of an instance of category.restservices.RSCategory
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        String result = "";
        BLcategory blcategory = new BLcategory();
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject)parser.parse(jsonstring);
            JSONObject jsonoperation = (JSONObject)json.get("operation");
            byte operationtype = JSONConversion.getbyte(jsonoperation, "type");
            byte operation = JSONConversion.getbyte(jsonoperation, "operation");
            ICategoryPK categoryPK;
            ICategory category;
//Security parameters
            boolean loggedin = RSsecurity.check(json);
            blcategory.setAuthenticated(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    switch(operation) {
                        case ICategoryOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blcategory.count());
                            result = jsoncount.toJSONString();
                            break;
                        case ICategoryOperation.SELECT_ALL:
                            result = JSONCategory.toJSONArray(blcategory.getCategorys()).toJSONString();
                            break;
                        case ICategoryOperation.SELECT_CATEGORY:
                            categoryPK = (ICategoryPK)JSONCategory.toCategoryPK((JSONObject)json.get("categorypk"));
                            result = JSONCategory.toJSON(blcategory.getCategory(categoryPK)).toJSONString();
                            break;
                        case ICategoryOperation.SELECT_SEARCH:
                            ICategorysearch search = (ICategorysearch)JSONCategory.toCategorysearch((JSONObject)json.get("search"));
                            result = JSONCategory.toJSONArray(blcategory.search(search)).toJSONString();
                            break;
                        case ICategoryOperation.SELECT_SEARCHCOUNT:
                            ICategorysearch categorysearch = (ICategorysearch)JSONCategory.toCategorysearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blcategory.searchcount(categorysearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(operation) {
                        case ICategoryOperation.INSERT_CATEGORY:
                            category = (ICategory)JSONCategory.toCategory((JSONObject)json.get("category"));
                            blcategory.insertCategory(category);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(operation) {
                        case ICategoryOperation.UPDATE_CATEGORY:
                            JSONObject jsoncategory = (JSONObject)json.get("category");
                            categoryPK = JSONCategory.toCategoryPK((JSONObject)jsoncategory.get("PK"));
                            category = blcategory.getCategory(categoryPK);
                            JSONCategory.updateCategory(category, jsoncategory);
                            blcategory.updateCategory(category);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(operation) {
                        case ICategoryOperation.DELETE_CATEGORY:
                            category = (ICategory)JSONCategory.toCategory((JSONObject)json.get("category"));
                            blcategory.deleteCategory(category);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECURESELECT:
                    switch(operation) {
                        case ICategoryOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blcategory.count());
                            result = jsoncount.toJSONString();
                            break;
                        case ICategoryOperation.SELECT_ALL:
                            result = JSONCategory.toJSONArray(blcategory.getCategorys()).toJSONString();
                            break;
                        case ICategoryOperation.SELECT_CATEGORY:
                            categoryPK = (ICategoryPK)JSONCategory.toCategoryPK((JSONObject)json.get("categorypk"));
                            result = JSONCategory.toJSON(blcategory.getCategory(categoryPK)).toJSONString();
                            break;
                        case ICategoryOperation.SELECT_SEARCH:
                            ICategorysearch search = (ICategorysearch)JSONCategory.toCategorysearch((JSONObject)json.get("search"));
                            result = JSONCategory.toJSONArray(blcategory.search(search)).toJSONString();
                            break;
                        case ICategoryOperation.SELECT_SEARCHCOUNT:
                            ICategorysearch categorysearch = (ICategorysearch)JSONCategory.toCategorysearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blcategory.searchcount(categorysearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREINSERT:
                    switch(operation) {
                        case ICategoryOperation.INSERT_CATEGORY:
                            category = (ICategory)JSONCategory.toCategory((JSONObject)json.get("category"));
                            blcategory.secureinsertCategory(category);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREUPDATE:
                    switch(operation) {
                        case ICategoryOperation.UPDATE_CATEGORY:
                            JSONObject jsoncategory = (JSONObject)json.get("category");
                            categoryPK = JSONCategory.toCategoryPK((JSONObject)jsoncategory.get("PK"));
                            category = blcategory.getCategory(categoryPK);
                            JSONCategory.updateCategory(category, jsoncategory);
                            blcategory.secureupdateCategory(category);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREDELETE:
                    switch(operation) {
                        case ICategoryOperation.DELETE_CATEGORY:
                            category = (ICategory)JSONCategory.toCategory((JSONObject)json.get("category"));
                            blcategory.securedeleteCategory(category);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
            }
        }
        catch(ParseException e) {
            result = returnstatus(e.getMessage());
        }
        catch(CustomException e) {
            result = returnstatus(e.getMessage());
        }
        return result;
    }

    private String returnstatus(String status) {
        JSONObject json = new JSONObject();
        json.put("status", status);
        return json.toJSONString();
    }

    /**
     * PUT method for updating or creating an instance of RSCategory
     * @param content representation for the resource
     */
    @PUT
    @Consumes("text/html")
    public void put(String content) {
    }
}

