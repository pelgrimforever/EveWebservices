/*
 * RSOrder_hist.java
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
import eve.interfaces.searchentity.IOrder_histsearch;
import eve.interfaces.servlet.IOrder_histOperation;
import eve.logicentity.Order_hist;
import eve.searchentity.Order_histsearch;
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
@Path("rsorder_hist")
public class RSOrder_hist {

    /**
     * Creates a new instance of HelloWorld
     */
    public RSOrder_hist() {
    }

    /**
     * Retrieves representation of an instance of order_hist.restservices.RSOrder_hist
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{json}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@PathParam("json") String jsonstring) {
        try {
            BLorder_hist blorder_hist = new BLorder_hist();
            ArrayList order_hists = blorder_hist.getAll();
            JSONArray jsonorder_hists = JSONOrder_hist.toJSONArray(order_hists);
            return jsonorder_hists.toJSONString();
        }
        catch(DBException e) {
            return "{ \"status\": \"error\"}";
        }
    }

    /**
     * Retrieves representation of an instance of order_hist.restservices.RSOrder_hist
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        String result = "";
        BLorder_hist blorder_hist = new BLorder_hist();
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject)parser.parse(jsonstring);
            JSONObject jsonoperation = (JSONObject)json.get("operation");
            byte operationtype = JSONConversion.getbyte(jsonoperation, "type");
            byte operation = JSONConversion.getbyte(jsonoperation, "operation");
            IOrder_histPK order_histPK;
            IOrder_hist order_hist;
//Security parameters
            boolean loggedin = RSsecurity.check(json);
            blorder_hist.setAuthenticated(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    switch(operation) {
                        case IOrder_histOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blorder_hist.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IOrder_histOperation.SELECT_ALL:
                            result = JSONOrder_hist.toJSONArray(blorder_hist.getOrder_hists()).toJSONString();
                            break;
                        case IOrder_histOperation.SELECT_ORDER_HIST:
                            order_histPK = (IOrder_histPK)JSONOrder_hist.toOrder_histPK((JSONObject)json.get("order_histpk"));
                            result = JSONOrder_hist.toJSON(blorder_hist.getOrder_hist(order_histPK)).toJSONString();
                            break;
                        case IOrder_histOperation.SELECT_Evetype:
                            IEvetypePK evetypePK = (IEvetypePK)JSONEvetype.toEvetypePK((JSONObject)json.get("evetypepk"));
                            result = JSONOrder_hist.toJSONArray(blorder_hist.getOrder_hists4evetype(evetypePK)).toJSONString();
                            break;
                        case IOrder_histOperation.SELECT_System:
                            ISystemPK systemPK = (ISystemPK)JSONSystem.toSystemPK((JSONObject)json.get("systempk"));
                            result = JSONOrder_hist.toJSONArray(blorder_hist.getOrder_hists4system(systemPK)).toJSONString();
                            break;
                        case IOrder_histOperation.SELECT_SEARCH:
                            IOrder_histsearch search = (IOrder_histsearch)JSONOrder_hist.toOrder_histsearch((JSONObject)json.get("search"));
                            result = JSONOrder_hist.toJSONArray(blorder_hist.search(search)).toJSONString();
                            break;
                        case IOrder_histOperation.SELECT_SEARCHCOUNT:
                            IOrder_histsearch order_histsearch = (IOrder_histsearch)JSONOrder_hist.toOrder_histsearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blorder_hist.searchcount(order_histsearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(operation) {
                        case IOrder_histOperation.INSERT_ORDER_HIST:
                            order_hist = (IOrder_hist)JSONOrder_hist.toOrder_hist((JSONObject)json.get("order_hist"));
                            blorder_hist.insertOrder_hist(order_hist);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(operation) {
                        case IOrder_histOperation.UPDATE_ORDER_HIST:
                            JSONObject jsonorder_hist = (JSONObject)json.get("order_hist");
                            order_histPK = JSONOrder_hist.toOrder_histPK((JSONObject)jsonorder_hist.get("PK"));
                            order_hist = blorder_hist.getOrder_hist(order_histPK);
                            JSONOrder_hist.updateOrder_hist(order_hist, jsonorder_hist);
                            blorder_hist.updateOrder_hist(order_hist);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(operation) {
                        case IOrder_histOperation.DELETE_ORDER_HIST:
                            order_hist = (IOrder_hist)JSONOrder_hist.toOrder_hist((JSONObject)json.get("order_hist"));
                            blorder_hist.deleteOrder_hist(order_hist);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECURESELECT:
                    switch(operation) {
                        case IOrder_histOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blorder_hist.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IOrder_histOperation.SELECT_ALL:
                            result = JSONOrder_hist.toJSONArray(blorder_hist.getOrder_hists()).toJSONString();
                            break;
                        case IOrder_histOperation.SELECT_ORDER_HIST:
                            order_histPK = (IOrder_histPK)JSONOrder_hist.toOrder_histPK((JSONObject)json.get("order_histpk"));
                            result = JSONOrder_hist.toJSON(blorder_hist.getOrder_hist(order_histPK)).toJSONString();
                            break;
                        case IOrder_histOperation.SELECT_Evetype:
                            IEvetypePK evetypePK = (IEvetypePK)JSONEvetype.toEvetypePK((JSONObject)json.get("evetypepk"));
                            result = JSONOrder_hist.toJSONArray(blorder_hist.getOrder_hists4evetype(evetypePK)).toJSONString();
                            break;
                        case IOrder_histOperation.SELECT_System:
                            ISystemPK systemPK = (ISystemPK)JSONSystem.toSystemPK((JSONObject)json.get("systempk"));
                            result = JSONOrder_hist.toJSONArray(blorder_hist.getOrder_hists4system(systemPK)).toJSONString();
                            break;
                        case IOrder_histOperation.SELECT_SEARCH:
                            IOrder_histsearch search = (IOrder_histsearch)JSONOrder_hist.toOrder_histsearch((JSONObject)json.get("search"));
                            result = JSONOrder_hist.toJSONArray(blorder_hist.search(search)).toJSONString();
                            break;
                        case IOrder_histOperation.SELECT_SEARCHCOUNT:
                            IOrder_histsearch order_histsearch = (IOrder_histsearch)JSONOrder_hist.toOrder_histsearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blorder_hist.searchcount(order_histsearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREINSERT:
                    switch(operation) {
                        case IOrder_histOperation.INSERT_ORDER_HIST:
                            order_hist = (IOrder_hist)JSONOrder_hist.toOrder_hist((JSONObject)json.get("order_hist"));
                            blorder_hist.secureinsertOrder_hist(order_hist);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREUPDATE:
                    switch(operation) {
                        case IOrder_histOperation.UPDATE_ORDER_HIST:
                            JSONObject jsonorder_hist = (JSONObject)json.get("order_hist");
                            order_histPK = JSONOrder_hist.toOrder_histPK((JSONObject)jsonorder_hist.get("PK"));
                            order_hist = blorder_hist.getOrder_hist(order_histPK);
                            JSONOrder_hist.updateOrder_hist(order_hist, jsonorder_hist);
                            blorder_hist.secureupdateOrder_hist(order_hist);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREDELETE:
                    switch(operation) {
                        case IOrder_histOperation.DELETE_ORDER_HIST:
                            order_hist = (IOrder_hist)JSONOrder_hist.toOrder_hist((JSONObject)json.get("order_hist"));
                            blorder_hist.securedeleteOrder_hist(order_hist);
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
     * PUT method for updating or creating an instance of RSOrder_hist
     * @param content representation for the resource
     */
    @PUT
    @Consumes("text/html")
    public void put(String content) {
    }
}

