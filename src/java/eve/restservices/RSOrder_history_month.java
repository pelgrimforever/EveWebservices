/*
 * RSOrder_history_month.java
 *
 * Generated on 16.11.2021 15:46
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
import eve.interfaces.searchentity.IOrder_history_monthsearch;
import eve.interfaces.servlet.IOrder_history_monthOperation;
import eve.logicentity.Order_history_month;
import eve.searchentity.Order_history_monthsearch;
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
@Path("rsorder_history_month")
public class RSOrder_history_month {

    /**
     * Creates a new instance of HelloWorld
     */
    public RSOrder_history_month() {
    }

    /**
     * Retrieves representation of an instance of order_history_month.restservices.RSOrder_history_month
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{json}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@PathParam("json") String jsonstring) {
        try {
            BLorder_history_month blorder_history_month = new BLorder_history_month();
            ArrayList order_history_months = blorder_history_month.getAll();
            JSONArray jsonorder_history_months = JSONOrder_history_month.toJSONArray(order_history_months);
            return jsonorder_history_months.toJSONString();
        }
        catch(DBException e) {
            return "{ \"status\": \"error\"}";
        }
    }

    /**
     * Retrieves representation of an instance of order_history_month.restservices.RSOrder_history_month
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        String result = "";
        BLorder_history_month blorder_history_month = new BLorder_history_month();
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject)parser.parse(jsonstring);
            JSONObject jsonoperation = (JSONObject)json.get("operation");
            byte operationtype = JSONConversion.getbyte(jsonoperation, "type");
            byte operation = JSONConversion.getbyte(jsonoperation, "operation");
            IOrder_history_monthPK order_history_monthPK;
            IOrder_history_month order_history_month;
//Security parameters
            boolean loggedin = RSsecurity.check(json);
            blorder_history_month.setAuthenticated(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    switch(operation) {
                        case IOrder_history_monthOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blorder_history_month.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IOrder_history_monthOperation.SELECT_ALL:
                            result = JSONOrder_history_month.toJSONArray(blorder_history_month.getOrder_history_months()).toJSONString();
                            break;
                        case IOrder_history_monthOperation.SELECT_ORDER_HISTORY_MONTH:
                            order_history_monthPK = (IOrder_history_monthPK)JSONOrder_history_month.toOrder_history_monthPK((JSONObject)json.get("order_history_monthpk"));
                            result = JSONOrder_history_month.toJSON(blorder_history_month.getOrder_history_month(order_history_monthPK)).toJSONString();
                            break;
                        case IOrder_history_monthOperation.SELECT_Evetype:
                            IEvetypePK evetypePK = (IEvetypePK)JSONEvetype.toEvetypePK((JSONObject)json.get("evetypepk"));
                            result = JSONOrder_history_month.toJSONArray(blorder_history_month.getOrder_history_months4evetype(evetypePK)).toJSONString();
                            break;
                        case IOrder_history_monthOperation.SELECT_Region:
                            IRegionPK regionPK = (IRegionPK)JSONRegion.toRegionPK((JSONObject)json.get("regionpk"));
                            result = JSONOrder_history_month.toJSONArray(blorder_history_month.getOrder_history_months4region(regionPK)).toJSONString();
                            break;
                        case IOrder_history_monthOperation.SELECT_SEARCH:
                            IOrder_history_monthsearch search = (IOrder_history_monthsearch)JSONOrder_history_month.toOrder_history_monthsearch((JSONObject)json.get("search"));
                            result = JSONOrder_history_month.toJSONArray(blorder_history_month.search(search)).toJSONString();
                            break;
                        case IOrder_history_monthOperation.SELECT_SEARCHCOUNT:
                            IOrder_history_monthsearch order_history_monthsearch = (IOrder_history_monthsearch)JSONOrder_history_month.toOrder_history_monthsearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blorder_history_month.searchcount(order_history_monthsearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(operation) {
                        case IOrder_history_monthOperation.INSERT_ORDER_HISTORY_MONTH:
                            order_history_month = (IOrder_history_month)JSONOrder_history_month.toOrder_history_month((JSONObject)json.get("order_history_month"));
                            blorder_history_month.insertOrder_history_month(order_history_month);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(operation) {
                        case IOrder_history_monthOperation.UPDATE_ORDER_HISTORY_MONTH:
                            JSONObject jsonorder_history_month = (JSONObject)json.get("order_history_month");
                            order_history_monthPK = JSONOrder_history_month.toOrder_history_monthPK((JSONObject)jsonorder_history_month.get("PK"));
                            order_history_month = blorder_history_month.getOrder_history_month(order_history_monthPK);
                            JSONOrder_history_month.updateOrder_history_month(order_history_month, jsonorder_history_month);
                            blorder_history_month.updateOrder_history_month(order_history_month);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(operation) {
                        case IOrder_history_monthOperation.DELETE_ORDER_HISTORY_MONTH:
                            order_history_month = (IOrder_history_month)JSONOrder_history_month.toOrder_history_month((JSONObject)json.get("order_history_month"));
                            blorder_history_month.deleteOrder_history_month(order_history_month);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECURESELECT:
                    switch(operation) {
                        case IOrder_history_monthOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blorder_history_month.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IOrder_history_monthOperation.SELECT_ALL:
                            result = JSONOrder_history_month.toJSONArray(blorder_history_month.getOrder_history_months()).toJSONString();
                            break;
                        case IOrder_history_monthOperation.SELECT_ORDER_HISTORY_MONTH:
                            order_history_monthPK = (IOrder_history_monthPK)JSONOrder_history_month.toOrder_history_monthPK((JSONObject)json.get("order_history_monthpk"));
                            result = JSONOrder_history_month.toJSON(blorder_history_month.getOrder_history_month(order_history_monthPK)).toJSONString();
                            break;
                        case IOrder_history_monthOperation.SELECT_Evetype:
                            IEvetypePK evetypePK = (IEvetypePK)JSONEvetype.toEvetypePK((JSONObject)json.get("evetypepk"));
                            result = JSONOrder_history_month.toJSONArray(blorder_history_month.getOrder_history_months4evetype(evetypePK)).toJSONString();
                            break;
                        case IOrder_history_monthOperation.SELECT_Region:
                            IRegionPK regionPK = (IRegionPK)JSONRegion.toRegionPK((JSONObject)json.get("regionpk"));
                            result = JSONOrder_history_month.toJSONArray(blorder_history_month.getOrder_history_months4region(regionPK)).toJSONString();
                            break;
                        case IOrder_history_monthOperation.SELECT_SEARCH:
                            IOrder_history_monthsearch search = (IOrder_history_monthsearch)JSONOrder_history_month.toOrder_history_monthsearch((JSONObject)json.get("search"));
                            result = JSONOrder_history_month.toJSONArray(blorder_history_month.search(search)).toJSONString();
                            break;
                        case IOrder_history_monthOperation.SELECT_SEARCHCOUNT:
                            IOrder_history_monthsearch order_history_monthsearch = (IOrder_history_monthsearch)JSONOrder_history_month.toOrder_history_monthsearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blorder_history_month.searchcount(order_history_monthsearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREINSERT:
                    switch(operation) {
                        case IOrder_history_monthOperation.INSERT_ORDER_HISTORY_MONTH:
                            order_history_month = (IOrder_history_month)JSONOrder_history_month.toOrder_history_month((JSONObject)json.get("order_history_month"));
                            blorder_history_month.secureinsertOrder_history_month(order_history_month);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREUPDATE:
                    switch(operation) {
                        case IOrder_history_monthOperation.UPDATE_ORDER_HISTORY_MONTH:
                            JSONObject jsonorder_history_month = (JSONObject)json.get("order_history_month");
                            order_history_monthPK = JSONOrder_history_month.toOrder_history_monthPK((JSONObject)jsonorder_history_month.get("PK"));
                            order_history_month = blorder_history_month.getOrder_history_month(order_history_monthPK);
                            JSONOrder_history_month.updateOrder_history_month(order_history_month, jsonorder_history_month);
                            blorder_history_month.secureupdateOrder_history_month(order_history_month);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREDELETE:
                    switch(operation) {
                        case IOrder_history_monthOperation.DELETE_ORDER_HISTORY_MONTH:
                            order_history_month = (IOrder_history_month)JSONOrder_history_month.toOrder_history_month((JSONObject)json.get("order_history_month"));
                            blorder_history_month.securedeleteOrder_history_month(order_history_month);
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
     * PUT method for updating or creating an instance of RSOrder_history_month
     * @param content representation for the resource
     */
    @PUT
    @Consumes("text/html")
    public void put(String content) {
    }
}

