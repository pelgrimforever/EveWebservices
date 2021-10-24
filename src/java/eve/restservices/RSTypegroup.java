/*
 * RSTypegroup.java
 *
 * Generated on 24.9.2021 14:40
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
import eve.interfaces.searchentity.ITypegroupsearch;
import eve.interfaces.servlet.ITypegroupOperation;
import eve.logicentity.Typegroup;
import eve.searchentity.Typegroupsearch;
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
@Path("rstypegroup")
public class RSTypegroup {

    /**
     * Creates a new instance of HelloWorld
     */
    public RSTypegroup() {
    }

    /**
     * Retrieves representation of an instance of typegroup.restservices.RSTypegroup
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{json}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@PathParam("json") String jsonstring) {
        try {
            BLtypegroup bltypegroup = new BLtypegroup();
            ArrayList typegroups = bltypegroup.getAll();
            JSONArray jsontypegroups = JSONTypegroup.toJSONArray(typegroups);
            return jsontypegroups.toJSONString();
        }
        catch(DBException e) {
            return "{ \"status\": \"error\"}";
        }
    }

    /**
     * Retrieves representation of an instance of typegroup.restservices.RSTypegroup
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        String result = "";
        BLtypegroup bltypegroup = new BLtypegroup();
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject)parser.parse(jsonstring);
            JSONObject jsonoperation = (JSONObject)json.get("operation");
            byte operationtype = JSONConversion.getbyte(jsonoperation, "type");
            byte operation = JSONConversion.getbyte(jsonoperation, "operation");
            ITypegroupPK typegroupPK;
            ITypegroup typegroup;
//Security parameters
            boolean loggedin = RSsecurity.check(json);
            bltypegroup.setAuthenticated(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    switch(operation) {
                        case ITypegroupOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", bltypegroup.count());
                            result = jsoncount.toJSONString();
                            break;
                        case ITypegroupOperation.SELECT_ALL:
                            result = JSONTypegroup.toJSONArray(bltypegroup.getTypegroups()).toJSONString();
                            break;
                        case ITypegroupOperation.SELECT_TYPEGROUP:
                            typegroupPK = (ITypegroupPK)JSONTypegroup.toTypegroupPK((JSONObject)json.get("typegrouppk"));
                            result = JSONTypegroup.toJSON(bltypegroup.getTypegroup(typegroupPK)).toJSONString();
                            break;
                        case ITypegroupOperation.SELECT_Category:
                            ICategoryPK categoryPK = (ICategoryPK)JSONCategory.toCategoryPK((JSONObject)json.get("categorypk"));
                            result = JSONTypegroup.toJSONArray(bltypegroup.getTypegroups4category(categoryPK)).toJSONString();
                            break;
                        case ITypegroupOperation.SELECT_SEARCH:
                            ITypegroupsearch search = (ITypegroupsearch)JSONTypegroup.toTypegroupsearch((JSONObject)json.get("search"));
                            result = JSONTypegroup.toJSONArray(bltypegroup.search(search)).toJSONString();
                            break;
                        case ITypegroupOperation.SELECT_SEARCHCOUNT:
                            ITypegroupsearch typegroupsearch = (ITypegroupsearch)JSONTypegroup.toTypegroupsearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", bltypegroup.searchcount(typegroupsearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(operation) {
                        case ITypegroupOperation.INSERT_TYPEGROUP:
                            typegroup = (ITypegroup)JSONTypegroup.toTypegroup((JSONObject)json.get("typegroup"));
                            bltypegroup.insertTypegroup(typegroup);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(operation) {
                        case ITypegroupOperation.UPDATE_TYPEGROUP:
                            JSONObject jsontypegroup = (JSONObject)json.get("typegroup");
                            typegroupPK = JSONTypegroup.toTypegroupPK((JSONObject)jsontypegroup.get("PK"));
                            typegroup = bltypegroup.getTypegroup(typegroupPK);
                            JSONTypegroup.updateTypegroup(typegroup, jsontypegroup);
                            bltypegroup.updateTypegroup(typegroup);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(operation) {
                        case ITypegroupOperation.DELETE_TYPEGROUP:
                            typegroup = (ITypegroup)JSONTypegroup.toTypegroup((JSONObject)json.get("typegroup"));
                            bltypegroup.deleteTypegroup(typegroup);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECURESELECT:
                    switch(operation) {
                        case ITypegroupOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", bltypegroup.count());
                            result = jsoncount.toJSONString();
                            break;
                        case ITypegroupOperation.SELECT_ALL:
                            result = JSONTypegroup.toJSONArray(bltypegroup.getTypegroups()).toJSONString();
                            break;
                        case ITypegroupOperation.SELECT_TYPEGROUP:
                            typegroupPK = (ITypegroupPK)JSONTypegroup.toTypegroupPK((JSONObject)json.get("typegrouppk"));
                            result = JSONTypegroup.toJSON(bltypegroup.getTypegroup(typegroupPK)).toJSONString();
                            break;
                        case ITypegroupOperation.SELECT_Category:
                            ICategoryPK categoryPK = (ICategoryPK)JSONCategory.toCategoryPK((JSONObject)json.get("categorypk"));
                            result = JSONTypegroup.toJSONArray(bltypegroup.getTypegroups4category(categoryPK)).toJSONString();
                            break;
                        case ITypegroupOperation.SELECT_SEARCH:
                            ITypegroupsearch search = (ITypegroupsearch)JSONTypegroup.toTypegroupsearch((JSONObject)json.get("search"));
                            result = JSONTypegroup.toJSONArray(bltypegroup.search(search)).toJSONString();
                            break;
                        case ITypegroupOperation.SELECT_SEARCHCOUNT:
                            ITypegroupsearch typegroupsearch = (ITypegroupsearch)JSONTypegroup.toTypegroupsearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", bltypegroup.searchcount(typegroupsearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREINSERT:
                    switch(operation) {
                        case ITypegroupOperation.INSERT_TYPEGROUP:
                            typegroup = (ITypegroup)JSONTypegroup.toTypegroup((JSONObject)json.get("typegroup"));
                            bltypegroup.secureinsertTypegroup(typegroup);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREUPDATE:
                    switch(operation) {
                        case ITypegroupOperation.UPDATE_TYPEGROUP:
                            JSONObject jsontypegroup = (JSONObject)json.get("typegroup");
                            typegroupPK = JSONTypegroup.toTypegroupPK((JSONObject)jsontypegroup.get("PK"));
                            typegroup = bltypegroup.getTypegroup(typegroupPK);
                            JSONTypegroup.updateTypegroup(typegroup, jsontypegroup);
                            bltypegroup.secureupdateTypegroup(typegroup);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREDELETE:
                    switch(operation) {
                        case ITypegroupOperation.DELETE_TYPEGROUP:
                            typegroup = (ITypegroup)JSONTypegroup.toTypegroup((JSONObject)json.get("typegroup"));
                            bltypegroup.securedeleteTypegroup(typegroup);
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
     * PUT method for updating or creating an instance of RSTypegroup
     * @param content representation for the resource
     */
    @PUT
    @Consumes("text/html")
    public void put(String content) {
    }
}

