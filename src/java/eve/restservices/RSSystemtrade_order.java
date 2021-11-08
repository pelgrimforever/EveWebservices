/*
 * RSSystemtrade_order.java
 *
 * Generated on 8.10.2021 7:21
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
import eve.interfaces.searchentity.ISystemtrade_ordersearch;
import eve.interfaces.servlet.ISystemtrade_orderOperation;
import eve.logicentity.Systemtrade_order;
import eve.searchentity.Systemtrade_ordersearch;
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
@Path("rssystemtrade_order")
public class RSSystemtrade_order {

    /**
     * Creates a new instance of HelloWorld
     */
    public RSSystemtrade_order() {
    }

    /**
     * Retrieves representation of an instance of systemtrade_order.restservices.RSSystemtrade_order
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{json}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@PathParam("json") String jsonstring) {
        try {
            BLsystemtrade_order blsystemtrade_order = new BLsystemtrade_order();
            ArrayList systemtrade_orders = blsystemtrade_order.getAll();
            JSONArray jsonsystemtrade_orders = JSONSystemtrade_order.toJSONArray(systemtrade_orders);
            return jsonsystemtrade_orders.toJSONString();
        }
        catch(DBException e) {
            return "{ \"status\": \"error\"}";
        }
    }

    /**
     * Retrieves representation of an instance of systemtrade_order.restservices.RSSystemtrade_order
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        String result = "";
        BLsystemtrade_order blsystemtrade_order = new BLsystemtrade_order();
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject)parser.parse(jsonstring);
            JSONObject jsonoperation = (JSONObject)json.get("operation");
            byte operationtype = JSONConversion.getbyte(jsonoperation, "type");
            byte operation = JSONConversion.getbyte(jsonoperation, "operation");
            ISystemtrade_orderPK systemtrade_orderPK;
            ISystemtrade_order systemtrade_order;
//Security parameters
            boolean loggedin = RSsecurity.check(json);
            blsystemtrade_order.setAuthenticated(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    switch(operation) {
                        case ISystemtrade_orderOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blsystemtrade_order.count());
                            result = jsoncount.toJSONString();
                            break;
                        case ISystemtrade_orderOperation.SELECT_ALL:
                            result = JSONSystemtrade_order.toJSONArray(blsystemtrade_order.getSystemtrade_orders()).toJSONString();
                            break;
                        case ISystemtrade_orderOperation.SELECT_SYSTEMTRADE_ORDER:
                            systemtrade_orderPK = (ISystemtrade_orderPK)JSONSystemtrade_order.toSystemtrade_orderPK((JSONObject)json.get("systemtrade_orderpk"));
                            result = JSONSystemtrade_order.toJSON(blsystemtrade_order.getSystemtrade_order(systemtrade_orderPK)).toJSONString();
                            break;
                        case ISystemtrade_orderOperation.SELECT_Ordersbuy_order:
                            IOrdersPK ordersBuy_orderPK = (IOrdersPK)JSONOrders.toOrdersPK((JSONObject)json.get("orderspk"));
                            result = JSONSystemtrade_order.toJSONArray(blsystemtrade_order.getSystemtrade_orders4ordersBuy_order(ordersBuy_orderPK)).toJSONString();
                            break;
                        case ISystemtrade_orderOperation.SELECT_Orderssell_order:
                            IOrdersPK ordersSell_orderPK = (IOrdersPK)JSONOrders.toOrdersPK((JSONObject)json.get("orderspk"));
                            result = JSONSystemtrade_order.toJSONArray(blsystemtrade_order.getSystemtrade_orders4ordersSell_order(ordersSell_orderPK)).toJSONString();
                            break;
                        case ISystemtrade_orderOperation.SELECT_Systemtrade:
                            ISystemtradePK systemtradePK = (ISystemtradePK)JSONSystemtrade.toSystemtradePK((JSONObject)json.get("systemtradepk"));
                            result = JSONSystemtrade_order.toJSONArray(blsystemtrade_order.getSystemtrade_orders4systemtrade(systemtradePK)).toJSONString();
                            break;
                        case ISystemtrade_orderOperation.SELECT_SEARCH:
                            ISystemtrade_ordersearch search = (ISystemtrade_ordersearch)JSONSystemtrade_order.toSystemtrade_ordersearch((JSONObject)json.get("search"));
                            result = JSONSystemtrade_order.toJSONArray(blsystemtrade_order.search(search)).toJSONString();
                            break;
                        case ISystemtrade_orderOperation.SELECT_SEARCHCOUNT:
                            ISystemtrade_ordersearch systemtrade_ordersearch = (ISystemtrade_ordersearch)JSONSystemtrade_order.toSystemtrade_ordersearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blsystemtrade_order.searchcount(systemtrade_ordersearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(operation) {
                        case ISystemtrade_orderOperation.INSERT_SYSTEMTRADE_ORDER:
                            systemtrade_order = (ISystemtrade_order)JSONSystemtrade_order.toSystemtrade_order((JSONObject)json.get("systemtrade_order"));
                            blsystemtrade_order.insertSystemtrade_order(systemtrade_order);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(operation) {
                        case ISystemtrade_orderOperation.UPDATE_SYSTEMTRADE_ORDER:
                            JSONObject jsonsystemtrade_order = (JSONObject)json.get("systemtrade_order");
                            systemtrade_orderPK = JSONSystemtrade_order.toSystemtrade_orderPK((JSONObject)jsonsystemtrade_order.get("PK"));
                            systemtrade_order = blsystemtrade_order.getSystemtrade_order(systemtrade_orderPK);
                            JSONSystemtrade_order.updateSystemtrade_order(systemtrade_order, jsonsystemtrade_order);
                            blsystemtrade_order.updateSystemtrade_order(systemtrade_order);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(operation) {
                        case ISystemtrade_orderOperation.DELETE_SYSTEMTRADE_ORDER:
                            systemtrade_order = (ISystemtrade_order)JSONSystemtrade_order.toSystemtrade_order((JSONObject)json.get("systemtrade_order"));
                            blsystemtrade_order.deleteSystemtrade_order(systemtrade_order);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECURESELECT:
                    switch(operation) {
                        case ISystemtrade_orderOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blsystemtrade_order.count());
                            result = jsoncount.toJSONString();
                            break;
                        case ISystemtrade_orderOperation.SELECT_ALL:
                            result = JSONSystemtrade_order.toJSONArray(blsystemtrade_order.getSystemtrade_orders()).toJSONString();
                            break;
                        case ISystemtrade_orderOperation.SELECT_SYSTEMTRADE_ORDER:
                            systemtrade_orderPK = (ISystemtrade_orderPK)JSONSystemtrade_order.toSystemtrade_orderPK((JSONObject)json.get("systemtrade_orderpk"));
                            result = JSONSystemtrade_order.toJSON(blsystemtrade_order.getSystemtrade_order(systemtrade_orderPK)).toJSONString();
                            break;
                        case ISystemtrade_orderOperation.SELECT_Ordersbuy_order:
                            IOrdersPK ordersBuy_orderPK = (IOrdersPK)JSONOrders.toOrdersPK((JSONObject)json.get("orderspk"));
                            result = JSONSystemtrade_order.toJSONArray(blsystemtrade_order.getSystemtrade_orders4ordersBuy_order(ordersBuy_orderPK)).toJSONString();
                            break;
                        case ISystemtrade_orderOperation.SELECT_Orderssell_order:
                            IOrdersPK ordersSell_orderPK = (IOrdersPK)JSONOrders.toOrdersPK((JSONObject)json.get("orderspk"));
                            result = JSONSystemtrade_order.toJSONArray(blsystemtrade_order.getSystemtrade_orders4ordersSell_order(ordersSell_orderPK)).toJSONString();
                            break;
                        case ISystemtrade_orderOperation.SELECT_Systemtrade:
                            ISystemtradePK systemtradePK = (ISystemtradePK)JSONSystemtrade.toSystemtradePK((JSONObject)json.get("systemtradepk"));
                            result = JSONSystemtrade_order.toJSONArray(blsystemtrade_order.getSystemtrade_orders4systemtrade(systemtradePK)).toJSONString();
                            break;
                        case ISystemtrade_orderOperation.SELECT_SEARCH:
                            ISystemtrade_ordersearch search = (ISystemtrade_ordersearch)JSONSystemtrade_order.toSystemtrade_ordersearch((JSONObject)json.get("search"));
                            result = JSONSystemtrade_order.toJSONArray(blsystemtrade_order.search(search)).toJSONString();
                            break;
                        case ISystemtrade_orderOperation.SELECT_SEARCHCOUNT:
                            ISystemtrade_ordersearch systemtrade_ordersearch = (ISystemtrade_ordersearch)JSONSystemtrade_order.toSystemtrade_ordersearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blsystemtrade_order.searchcount(systemtrade_ordersearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREINSERT:
                    switch(operation) {
                        case ISystemtrade_orderOperation.INSERT_SYSTEMTRADE_ORDER:
                            systemtrade_order = (ISystemtrade_order)JSONSystemtrade_order.toSystemtrade_order((JSONObject)json.get("systemtrade_order"));
                            blsystemtrade_order.secureinsertSystemtrade_order(systemtrade_order);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREUPDATE:
                    switch(operation) {
                        case ISystemtrade_orderOperation.UPDATE_SYSTEMTRADE_ORDER:
                            JSONObject jsonsystemtrade_order = (JSONObject)json.get("systemtrade_order");
                            systemtrade_orderPK = JSONSystemtrade_order.toSystemtrade_orderPK((JSONObject)jsonsystemtrade_order.get("PK"));
                            systemtrade_order = blsystemtrade_order.getSystemtrade_order(systemtrade_orderPK);
                            JSONSystemtrade_order.updateSystemtrade_order(systemtrade_order, jsonsystemtrade_order);
                            blsystemtrade_order.secureupdateSystemtrade_order(systemtrade_order);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREDELETE:
                    switch(operation) {
                        case ISystemtrade_orderOperation.DELETE_SYSTEMTRADE_ORDER:
                            systemtrade_order = (ISystemtrade_order)JSONSystemtrade_order.toSystemtrade_order((JSONObject)json.get("systemtrade_order"));
                            blsystemtrade_order.securedeleteSystemtrade_order(systemtrade_order);
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
     * PUT method for updating or creating an instance of RSSystemtrade_order
     * @param content representation for the resource
     */
    @PUT
    @Consumes("text/html")
    public void put(String content) {
    }
}

