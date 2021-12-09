/*
 * RSJson_orders.java
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
import eve.interfaces.searchentity.IJson_orderssearch;
import eve.interfaces.servlet.IJson_ordersOperation;
import eve.logicentity.Json_orders;
import eve.searchentity.Json_orderssearch;
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
@Path("rsjson_orders")
public class RSJson_orders {

    /**
     * Creates a new instance of HelloWorld
     */
    public RSJson_orders() {
    }

    /**
     * Retrieves representation of an instance of json_orders.restservices.RSJson_orders
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{json}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@PathParam("json") String jsonstring) {
        try {
            BLjson_orders bljson_orders = new BLjson_orders();
            ArrayList json_orderss = bljson_orders.getAll();
            JSONArray jsonjson_orderss = JSONJson_orders.toJSONArray(json_orderss);
            return jsonjson_orderss.toJSONString();
        }
        catch(DBException e) {
            return "{ \"status\": \"error\"}";
        }
    }

    /**
     * Retrieves representation of an instance of json_orders.restservices.RSJson_orders
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        String result = "";
        BLjson_orders bljson_orders = new BLjson_orders();
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject)parser.parse(jsonstring);
            JSONObject jsonoperation = (JSONObject)json.get("operation");
            byte operationtype = JSONConversion.getbyte(jsonoperation, "type");
            byte operation = JSONConversion.getbyte(jsonoperation, "operation");
            IJson_ordersPK json_ordersPK;
            IJson_orders json_orders;
//Security parameters
            boolean loggedin = RSsecurity.check(json);
            bljson_orders.setAuthenticated(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    switch(operation) {
                        case IJson_ordersOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", bljson_orders.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IJson_ordersOperation.SELECT_ALL:
                            result = JSONJson_orders.toJSONArray(bljson_orders.getJson_orderss()).toJSONString();
                            break;
                        case IJson_ordersOperation.SELECT_JSON_ORDERS:
                            json_ordersPK = (IJson_ordersPK)JSONJson_orders.toJson_ordersPK((JSONObject)json.get("json_orderspk"));
                            result = JSONJson_orders.toJSON(bljson_orders.getJson_orders(json_ordersPK)).toJSONString();
                            break;
                        case IJson_ordersOperation.SELECT_SEARCH:
                            IJson_orderssearch search = (IJson_orderssearch)JSONJson_orders.toJson_orderssearch((JSONObject)json.get("search"));
                            result = JSONJson_orders.toJSONArray(bljson_orders.search(search)).toJSONString();
                            break;
                        case IJson_ordersOperation.SELECT_SEARCHCOUNT:
                            IJson_orderssearch json_orderssearch = (IJson_orderssearch)JSONJson_orders.toJson_orderssearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", bljson_orders.searchcount(json_orderssearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(operation) {
                        case IJson_ordersOperation.INSERT_JSON_ORDERS:
                            json_orders = (IJson_orders)JSONJson_orders.toJson_orders((JSONObject)json.get("json_orders"));
                            bljson_orders.insertJson_orders(json_orders);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(operation) {
                        case IJson_ordersOperation.UPDATE_JSON_ORDERS:
                            JSONObject jsonjson_orders = (JSONObject)json.get("json_orders");
                            json_ordersPK = JSONJson_orders.toJson_ordersPK((JSONObject)jsonjson_orders.get("PK"));
                            json_orders = bljson_orders.getJson_orders(json_ordersPK);
                            JSONJson_orders.updateJson_orders(json_orders, jsonjson_orders);
                            bljson_orders.updateJson_orders(json_orders);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(operation) {
                        case IJson_ordersOperation.DELETE_JSON_ORDERS:
                            json_orders = (IJson_orders)JSONJson_orders.toJson_orders((JSONObject)json.get("json_orders"));
                            bljson_orders.deleteJson_orders(json_orders);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECURESELECT:
                    switch(operation) {
                        case IJson_ordersOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", bljson_orders.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IJson_ordersOperation.SELECT_ALL:
                            result = JSONJson_orders.toJSONArray(bljson_orders.getJson_orderss()).toJSONString();
                            break;
                        case IJson_ordersOperation.SELECT_JSON_ORDERS:
                            json_ordersPK = (IJson_ordersPK)JSONJson_orders.toJson_ordersPK((JSONObject)json.get("json_orderspk"));
                            result = JSONJson_orders.toJSON(bljson_orders.getJson_orders(json_ordersPK)).toJSONString();
                            break;
                        case IJson_ordersOperation.SELECT_SEARCH:
                            IJson_orderssearch search = (IJson_orderssearch)JSONJson_orders.toJson_orderssearch((JSONObject)json.get("search"));
                            result = JSONJson_orders.toJSONArray(bljson_orders.search(search)).toJSONString();
                            break;
                        case IJson_ordersOperation.SELECT_SEARCHCOUNT:
                            IJson_orderssearch json_orderssearch = (IJson_orderssearch)JSONJson_orders.toJson_orderssearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", bljson_orders.searchcount(json_orderssearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREINSERT:
                    switch(operation) {
                        case IJson_ordersOperation.INSERT_JSON_ORDERS:
                            json_orders = (IJson_orders)JSONJson_orders.toJson_orders((JSONObject)json.get("json_orders"));
                            bljson_orders.secureinsertJson_orders(json_orders);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREUPDATE:
                    switch(operation) {
                        case IJson_ordersOperation.UPDATE_JSON_ORDERS:
                            JSONObject jsonjson_orders = (JSONObject)json.get("json_orders");
                            json_ordersPK = JSONJson_orders.toJson_ordersPK((JSONObject)jsonjson_orders.get("PK"));
                            json_orders = bljson_orders.getJson_orders(json_ordersPK);
                            JSONJson_orders.updateJson_orders(json_orders, jsonjson_orders);
                            bljson_orders.secureupdateJson_orders(json_orders);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREDELETE:
                    switch(operation) {
                        case IJson_ordersOperation.DELETE_JSON_ORDERS:
                            json_orders = (IJson_orders)JSONJson_orders.toJson_orders((JSONObject)json.get("json_orders"));
                            bljson_orders.securedeleteJson_orders(json_orders);
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
     * PUT method for updating or creating an instance of RSJson_orders
     * @param content representation for the resource
     */
    @PUT
    @Consumes("text/html")
    public void put(String content) {
    }
}

