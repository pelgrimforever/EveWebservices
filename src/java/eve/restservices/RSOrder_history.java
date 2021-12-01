/*
 * RSOrder_history.java
 *
 * Generated on 30.10.2021 10:3
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
import eve.interfaces.searchentity.IOrder_historysearch;
import eve.interfaces.servlet.IOrder_historyOperation;
import eve.logicentity.Order_history;
import eve.searchentity.Order_historysearch;
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
@Path("rsorder_history")
public class RSOrder_history {

    /**
     * Creates a new instance of HelloWorld
     */
    public RSOrder_history() {
    }

    /**
     * Retrieves representation of an instance of order_history.restservices.RSOrder_history
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{json}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@PathParam("json") String jsonstring) {
        try {
            BLorder_history blorder_history = new BLorder_history();
            ArrayList order_historys = blorder_history.getAll();
            JSONArray jsonorder_historys = JSONOrder_history.toJSONArray(order_historys);
            return jsonorder_historys.toJSONString();
        }
        catch(DBException e) {
            return "{ \"status\": \"error\"}";
        }
    }

    /**
     * Retrieves representation of an instance of order_history.restservices.RSOrder_history
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        String result = "";
        BLorder_history blorder_history = new BLorder_history();
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject)parser.parse(jsonstring);
            JSONObject jsonoperation = (JSONObject)json.get("operation");
            byte operationtype = JSONConversion.getbyte(jsonoperation, "type");
            byte operation = JSONConversion.getbyte(jsonoperation, "operation");
            IOrder_historyPK order_historyPK;
            IOrder_history order_history;
//Security parameters
            boolean loggedin = RSsecurity.check(json);
            blorder_history.setAuthenticated(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    switch(operation) {
                        case IOrder_historyOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blorder_history.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IOrder_historyOperation.SELECT_ALL:
                            result = JSONOrder_history.toJSONArray(blorder_history.getOrder_historys()).toJSONString();
                            break;
                        case IOrder_historyOperation.SELECT_ORDER_HISTORY:
                            order_historyPK = (IOrder_historyPK)JSONOrder_history.toOrder_historyPK((JSONObject)json.get("order_historypk"));
                            result = JSONOrder_history.toJSON(blorder_history.getOrder_history(order_historyPK)).toJSONString();
                            break;
                        case IOrder_historyOperation.SELECT_Evetype:
                            IEvetypePK evetypePK = (IEvetypePK)JSONEvetype.toEvetypePK((JSONObject)json.get("evetypepk"));
                            result = JSONOrder_history.toJSONArray(blorder_history.getOrder_historys4evetype(evetypePK)).toJSONString();
                            break;
                        case IOrder_historyOperation.SELECT_Region:
                            IRegionPK regionPK = (IRegionPK)JSONRegion.toRegionPK((JSONObject)json.get("regionpk"));
                            result = JSONOrder_history.toJSONArray(blorder_history.getOrder_historys4region(regionPK)).toJSONString();
                            break;
                        case IOrder_historyOperation.SELECT_SEARCH:
                            IOrder_historysearch search = (IOrder_historysearch)JSONOrder_history.toOrder_historysearch((JSONObject)json.get("search"));
                            result = JSONOrder_history.toJSONArray(blorder_history.search(search)).toJSONString();
                            break;
                        case IOrder_historyOperation.SELECT_SEARCHCOUNT:
                            IOrder_historysearch order_historysearch = (IOrder_historysearch)JSONOrder_history.toOrder_historysearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blorder_history.searchcount(order_historysearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(operation) {
                        case IOrder_historyOperation.INSERT_ORDER_HISTORY:
                            order_history = (IOrder_history)JSONOrder_history.toOrder_history((JSONObject)json.get("order_history"));
                            blorder_history.insertOrder_history(order_history);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(operation) {
                        case IOrder_historyOperation.UPDATE_ORDER_HISTORY:
                            JSONObject jsonorder_history = (JSONObject)json.get("order_history");
                            order_historyPK = JSONOrder_history.toOrder_historyPK((JSONObject)jsonorder_history.get("PK"));
                            order_history = blorder_history.getOrder_history(order_historyPK);
                            JSONOrder_history.updateOrder_history(order_history, jsonorder_history);
                            blorder_history.updateOrder_history(order_history);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(operation) {
                        case IOrder_historyOperation.DELETE_ORDER_HISTORY:
                            order_history = (IOrder_history)JSONOrder_history.toOrder_history((JSONObject)json.get("order_history"));
                            blorder_history.deleteOrder_history(order_history);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECURESELECT:
                    switch(operation) {
                        case IOrder_historyOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blorder_history.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IOrder_historyOperation.SELECT_ALL:
                            result = JSONOrder_history.toJSONArray(blorder_history.getOrder_historys()).toJSONString();
                            break;
                        case IOrder_historyOperation.SELECT_ORDER_HISTORY:
                            order_historyPK = (IOrder_historyPK)JSONOrder_history.toOrder_historyPK((JSONObject)json.get("order_historypk"));
                            result = JSONOrder_history.toJSON(blorder_history.getOrder_history(order_historyPK)).toJSONString();
                            break;
                        case IOrder_historyOperation.SELECT_Evetype:
                            IEvetypePK evetypePK = (IEvetypePK)JSONEvetype.toEvetypePK((JSONObject)json.get("evetypepk"));
                            result = JSONOrder_history.toJSONArray(blorder_history.getOrder_historys4evetype(evetypePK)).toJSONString();
                            break;
                        case IOrder_historyOperation.SELECT_Region:
                            IRegionPK regionPK = (IRegionPK)JSONRegion.toRegionPK((JSONObject)json.get("regionpk"));
                            result = JSONOrder_history.toJSONArray(blorder_history.getOrder_historys4region(regionPK)).toJSONString();
                            break;
                        case IOrder_historyOperation.SELECT_SEARCH:
                            IOrder_historysearch search = (IOrder_historysearch)JSONOrder_history.toOrder_historysearch((JSONObject)json.get("search"));
                            result = JSONOrder_history.toJSONArray(blorder_history.search(search)).toJSONString();
                            break;
                        case IOrder_historyOperation.SELECT_SEARCHCOUNT:
                            IOrder_historysearch order_historysearch = (IOrder_historysearch)JSONOrder_history.toOrder_historysearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blorder_history.searchcount(order_historysearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREINSERT:
                    switch(operation) {
                        case IOrder_historyOperation.INSERT_ORDER_HISTORY:
                            order_history = (IOrder_history)JSONOrder_history.toOrder_history((JSONObject)json.get("order_history"));
                            blorder_history.secureinsertOrder_history(order_history);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREUPDATE:
                    switch(operation) {
                        case IOrder_historyOperation.UPDATE_ORDER_HISTORY:
                            JSONObject jsonorder_history = (JSONObject)json.get("order_history");
                            order_historyPK = JSONOrder_history.toOrder_historyPK((JSONObject)jsonorder_history.get("PK"));
                            order_history = blorder_history.getOrder_history(order_historyPK);
                            JSONOrder_history.updateOrder_history(order_history, jsonorder_history);
                            blorder_history.secureupdateOrder_history(order_history);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREDELETE:
                    switch(operation) {
                        case IOrder_historyOperation.DELETE_ORDER_HISTORY:
                            order_history = (IOrder_history)JSONOrder_history.toOrder_history((JSONObject)json.get("order_history"));
                            blorder_history.securedeleteOrder_history(order_history);
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
     * PUT method for updating or creating an instance of RSOrder_history
     * @param content representation for the resource
     */
    @PUT
    @Consumes("text/html")
    public void put(String content) {
    }
}

