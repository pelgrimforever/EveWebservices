/*
 * RSMarket_group.java
 *
 * Generated on 9.11.2021 14:30
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
import eve.interfaces.searchentity.IMarket_groupsearch;
import eve.interfaces.servlet.IMarket_groupOperation;
import eve.logicentity.Market_group;
import eve.searchentity.Market_groupsearch;
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
@Path("rsmarket_group")
public class RSMarket_group {

    /**
     * Creates a new instance of HelloWorld
     */
    public RSMarket_group() {
    }

    /**
     * Retrieves representation of an instance of market_group.restservices.RSMarket_group
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{json}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@PathParam("json") String jsonstring) {
        try {
            BLmarket_group blmarket_group = new BLmarket_group();
            ArrayList market_groups = blmarket_group.getAll();
            JSONArray jsonmarket_groups = JSONMarket_group.toJSONArray(market_groups);
            return jsonmarket_groups.toJSONString();
        }
        catch(DBException e) {
            return "{ \"status\": \"error\"}";
        }
    }

    /**
     * Retrieves representation of an instance of market_group.restservices.RSMarket_group
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        String result = "";
        BLmarket_group blmarket_group = new BLmarket_group();
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject)parser.parse(jsonstring);
            JSONObject jsonoperation = (JSONObject)json.get("operation");
            byte operationtype = JSONConversion.getbyte(jsonoperation, "type");
            byte operation = JSONConversion.getbyte(jsonoperation, "operation");
            IMarket_groupPK market_groupPK;
            IMarket_group market_group;
//Security parameters
            boolean loggedin = RSsecurity.check(json);
            blmarket_group.setAuthenticated(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    switch(operation) {
                        case IMarket_groupOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blmarket_group.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IMarket_groupOperation.SELECT_ALL:
                            result = JSONMarket_group.toJSONArray(blmarket_group.getMarket_groups()).toJSONString();
                            break;
                        case IMarket_groupOperation.SELECT_MARKET_GROUP:
                            market_groupPK = (IMarket_groupPK)JSONMarket_group.toMarket_groupPK((JSONObject)json.get("market_grouppk"));
                            result = JSONMarket_group.toJSON(blmarket_group.getMarket_group(market_groupPK)).toJSONString();
                            break;
                        case IMarket_groupOperation.SELECT_Market_groupparent_id:
                            IMarket_groupPK market_groupParent_idPK = (IMarket_groupPK)JSONMarket_group.toMarket_groupPK((JSONObject)json.get("market_grouppk"));
                            result = JSONMarket_group.toJSONArray(blmarket_group.getMarket_groups4market_groupParent_id(market_groupParent_idPK)).toJSONString();
                            break;
                        case IMarket_groupOperation.SELECT_SEARCH:
                            IMarket_groupsearch search = (IMarket_groupsearch)JSONMarket_group.toMarket_groupsearch((JSONObject)json.get("search"));
                            result = JSONMarket_group.toJSONArray(blmarket_group.search(search)).toJSONString();
                            break;
                        case IMarket_groupOperation.SELECT_SEARCHCOUNT:
                            IMarket_groupsearch market_groupsearch = (IMarket_groupsearch)JSONMarket_group.toMarket_groupsearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blmarket_group.searchcount(market_groupsearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(operation) {
                        case IMarket_groupOperation.INSERT_MARKET_GROUP:
                            market_group = (IMarket_group)JSONMarket_group.toMarket_group((JSONObject)json.get("market_group"));
                            blmarket_group.insertMarket_group(market_group);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(operation) {
                        case IMarket_groupOperation.UPDATE_MARKET_GROUP:
                            JSONObject jsonmarket_group = (JSONObject)json.get("market_group");
                            market_groupPK = JSONMarket_group.toMarket_groupPK((JSONObject)jsonmarket_group.get("PK"));
                            market_group = blmarket_group.getMarket_group(market_groupPK);
                            JSONMarket_group.updateMarket_group(market_group, jsonmarket_group);
                            blmarket_group.updateMarket_group(market_group);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(operation) {
                        case IMarket_groupOperation.DELETE_MARKET_GROUP:
                            market_group = (IMarket_group)JSONMarket_group.toMarket_group((JSONObject)json.get("market_group"));
                            blmarket_group.deleteMarket_group(market_group);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECURESELECT:
                    switch(operation) {
                        case IMarket_groupOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blmarket_group.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IMarket_groupOperation.SELECT_ALL:
                            result = JSONMarket_group.toJSONArray(blmarket_group.getMarket_groups()).toJSONString();
                            break;
                        case IMarket_groupOperation.SELECT_MARKET_GROUP:
                            market_groupPK = (IMarket_groupPK)JSONMarket_group.toMarket_groupPK((JSONObject)json.get("market_grouppk"));
                            result = JSONMarket_group.toJSON(blmarket_group.getMarket_group(market_groupPK)).toJSONString();
                            break;
                        case IMarket_groupOperation.SELECT_Market_groupparent_id:
                            IMarket_groupPK market_groupParent_idPK = (IMarket_groupPK)JSONMarket_group.toMarket_groupPK((JSONObject)json.get("market_grouppk"));
                            result = JSONMarket_group.toJSONArray(blmarket_group.getMarket_groups4market_groupParent_id(market_groupParent_idPK)).toJSONString();
                            break;
                        case IMarket_groupOperation.SELECT_SEARCH:
                            IMarket_groupsearch search = (IMarket_groupsearch)JSONMarket_group.toMarket_groupsearch((JSONObject)json.get("search"));
                            result = JSONMarket_group.toJSONArray(blmarket_group.search(search)).toJSONString();
                            break;
                        case IMarket_groupOperation.SELECT_SEARCHCOUNT:
                            IMarket_groupsearch market_groupsearch = (IMarket_groupsearch)JSONMarket_group.toMarket_groupsearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blmarket_group.searchcount(market_groupsearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREINSERT:
                    switch(operation) {
                        case IMarket_groupOperation.INSERT_MARKET_GROUP:
                            market_group = (IMarket_group)JSONMarket_group.toMarket_group((JSONObject)json.get("market_group"));
                            blmarket_group.secureinsertMarket_group(market_group);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREUPDATE:
                    switch(operation) {
                        case IMarket_groupOperation.UPDATE_MARKET_GROUP:
                            JSONObject jsonmarket_group = (JSONObject)json.get("market_group");
                            market_groupPK = JSONMarket_group.toMarket_groupPK((JSONObject)jsonmarket_group.get("PK"));
                            market_group = blmarket_group.getMarket_group(market_groupPK);
                            JSONMarket_group.updateMarket_group(market_group, jsonmarket_group);
                            blmarket_group.secureupdateMarket_group(market_group);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREDELETE:
                    switch(operation) {
                        case IMarket_groupOperation.DELETE_MARKET_GROUP:
                            market_group = (IMarket_group)JSONMarket_group.toMarket_group((JSONObject)json.get("market_group"));
                            blmarket_group.securedeleteMarket_group(market_group);
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
     * PUT method for updating or creating an instance of RSMarket_group
     * @param content representation for the resource
     */
    @PUT
    @Consumes("text/html")
    public void put(String content) {
    }
}

