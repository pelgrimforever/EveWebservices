/*
 * RSOrders.java
 *
 * Generated on 25.9.2021 15:16
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
import eve.interfaces.searchentity.IOrderssearch;
import eve.interfaces.servlet.IOrdersOperation;
import eve.logicentity.Orders;
import eve.searchentity.Orderssearch;
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
@Path("rsorders")
public class RSOrders {

    /**
     * Creates a new instance of HelloWorld
     */
    public RSOrders() {
    }

    /**
     * Retrieves representation of an instance of orders.restservices.RSOrders
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{json}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@PathParam("json") String jsonstring) {
        try {
            BLorders blorders = new BLorders();
            ArrayList orderss = blorders.getAll();
            JSONArray jsonorderss = JSONOrders.toJSONArray(orderss);
            return jsonorderss.toJSONString();
        }
        catch(DBException e) {
            return "{ \"status\": \"error\"}";
        }
    }

    /**
     * Retrieves representation of an instance of orders.restservices.RSOrders
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        String result = "";
        BLorders blorders = new BLorders();
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject)parser.parse(jsonstring);
            JSONObject jsonoperation = (JSONObject)json.get("operation");
            byte operationtype = JSONConversion.getbyte(jsonoperation, "type");
            byte operation = JSONConversion.getbyte(jsonoperation, "operation");
            IOrdersPK ordersPK;
            IOrders orders;
//Security parameters
            boolean loggedin = RSsecurity.check(json);
            blorders.setAuthenticated(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    switch(operation) {
                        case IOrdersOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blorders.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IOrdersOperation.SELECT_ALL:
                            result = JSONOrders.toJSONArray(blorders.getOrderss()).toJSONString();
                            break;
                        case IOrdersOperation.SELECT_ORDERS:
                            ordersPK = (IOrdersPK)JSONOrders.toOrdersPK((JSONObject)json.get("orderspk"));
                            result = JSONOrders.toJSON(blorders.getOrders(ordersPK)).toJSONString();
                            break;
                        case IOrdersOperation.SELECT_Evetype:
                            IEvetypePK evetypePK = (IEvetypePK)JSONEvetype.toEvetypePK((JSONObject)json.get("evetypepk"));
                            result = JSONOrders.toJSONArray(blorders.getOrderss4evetype(evetypePK)).toJSONString();
                            break;
                        case IOrdersOperation.SELECT_System:
                            ISystemPK systemPK = (ISystemPK)JSONSystem.toSystemPK((JSONObject)json.get("systempk"));
                            result = JSONOrders.toJSONArray(blorders.getOrderss4system(systemPK)).toJSONString();
                            break;
                        case IOrdersOperation.SELECT_Systemtrade_orderbuy_order:
                            ISystemtrade_orderPK systemtrade_orderBuy_orderPK = (ISystemtrade_orderPK)JSONSystemtrade_order.toSystemtrade_orderPK((JSONObject)json.get("systemtrade_orderpk"));
                            result = JSONOrders.toJSON(blorders.getSystemtrade_orderbuy_order(systemtrade_orderBuy_orderPK)).toJSONString();
                            break;
                        case IOrdersOperation.SELECT_Systemtrade_ordersell_order:
                            ISystemtrade_orderPK systemtrade_orderSell_orderPK = (ISystemtrade_orderPK)JSONSystemtrade_order.toSystemtrade_orderPK((JSONObject)json.get("systemtrade_orderpk"));
                            result = JSONOrders.toJSON(blorders.getSystemtrade_ordersell_order(systemtrade_orderSell_orderPK)).toJSONString();
                            break;
                        case IOrdersOperation.SELECT_Tradesell_order_id:
                            ITradePK tradeSell_order_idPK = (ITradePK)JSONTrade.toTradePK((JSONObject)json.get("tradepk"));
                            result = JSONOrders.toJSON(blorders.getTradesell_order_id(tradeSell_order_idPK)).toJSONString();
                            break;
                        case IOrdersOperation.SELECT_Tradebuy_order_id:
                            ITradePK tradeBuy_order_idPK = (ITradePK)JSONTrade.toTradePK((JSONObject)json.get("tradepk"));
                            result = JSONOrders.toJSON(blorders.getTradebuy_order_id(tradeBuy_order_idPK)).toJSONString();
                            break;
                        case IOrdersOperation.SELECT_SEARCH:
                            IOrderssearch search = (IOrderssearch)JSONOrders.toOrderssearch((JSONObject)json.get("search"));
                            result = JSONOrders.toJSONArray(blorders.search(search)).toJSONString();
                            break;
                        case IOrdersOperation.SELECT_SEARCHCOUNT:
                            IOrderssearch orderssearch = (IOrderssearch)JSONOrders.toOrderssearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blorders.searchcount(orderssearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(operation) {
                        case IOrdersOperation.INSERT_ORDERS:
                            orders = (IOrders)JSONOrders.toOrders((JSONObject)json.get("orders"));
                            blorders.insertOrders(orders);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(operation) {
                        case IOrdersOperation.UPDATE_ORDERS:
                            JSONObject jsonorders = (JSONObject)json.get("orders");
                            ordersPK = JSONOrders.toOrdersPK((JSONObject)jsonorders.get("PK"));
                            orders = blorders.getOrders(ordersPK);
                            JSONOrders.updateOrders(orders, jsonorders);
                            blorders.updateOrders(orders);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(operation) {
                        case IOrdersOperation.DELETE_ORDERS:
                            orders = (IOrders)JSONOrders.toOrders((JSONObject)json.get("orders"));
                            blorders.deleteOrders(orders);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECURESELECT:
                    switch(operation) {
                        case IOrdersOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blorders.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IOrdersOperation.SELECT_ALL:
                            result = JSONOrders.toJSONArray(blorders.getOrderss()).toJSONString();
                            break;
                        case IOrdersOperation.SELECT_ORDERS:
                            ordersPK = (IOrdersPK)JSONOrders.toOrdersPK((JSONObject)json.get("orderspk"));
                            result = JSONOrders.toJSON(blorders.getOrders(ordersPK)).toJSONString();
                            break;
                        case IOrdersOperation.SELECT_Evetype:
                            IEvetypePK evetypePK = (IEvetypePK)JSONEvetype.toEvetypePK((JSONObject)json.get("evetypepk"));
                            result = JSONOrders.toJSONArray(blorders.getOrderss4evetype(evetypePK)).toJSONString();
                            break;
                        case IOrdersOperation.SELECT_System:
                            ISystemPK systemPK = (ISystemPK)JSONSystem.toSystemPK((JSONObject)json.get("systempk"));
                            result = JSONOrders.toJSONArray(blorders.getOrderss4system(systemPK)).toJSONString();
                            break;
                        case IOrdersOperation.SELECT_Systemtrade_orderbuy_order:
                            ISystemtrade_orderPK systemtrade_orderBuy_orderPK = (ISystemtrade_orderPK)JSONSystemtrade_order.toSystemtrade_orderPK((JSONObject)json.get("systemtrade_orderpk"));
                            result = JSONOrders.toJSON(blorders.getSystemtrade_orderbuy_order(systemtrade_orderBuy_orderPK)).toJSONString();
                            break;
                        case IOrdersOperation.SELECT_Systemtrade_ordersell_order:
                            ISystemtrade_orderPK systemtrade_orderSell_orderPK = (ISystemtrade_orderPK)JSONSystemtrade_order.toSystemtrade_orderPK((JSONObject)json.get("systemtrade_orderpk"));
                            result = JSONOrders.toJSON(blorders.getSystemtrade_ordersell_order(systemtrade_orderSell_orderPK)).toJSONString();
                            break;
                        case IOrdersOperation.SELECT_Tradesell_order_id:
                            ITradePK tradeSell_order_idPK = (ITradePK)JSONTrade.toTradePK((JSONObject)json.get("tradepk"));
                            result = JSONOrders.toJSON(blorders.getTradesell_order_id(tradeSell_order_idPK)).toJSONString();
                            break;
                        case IOrdersOperation.SELECT_Tradebuy_order_id:
                            ITradePK tradeBuy_order_idPK = (ITradePK)JSONTrade.toTradePK((JSONObject)json.get("tradepk"));
                            result = JSONOrders.toJSON(blorders.getTradebuy_order_id(tradeBuy_order_idPK)).toJSONString();
                            break;
                        case IOrdersOperation.SELECT_SEARCH:
                            IOrderssearch search = (IOrderssearch)JSONOrders.toOrderssearch((JSONObject)json.get("search"));
                            result = JSONOrders.toJSONArray(blorders.search(search)).toJSONString();
                            break;
                        case IOrdersOperation.SELECT_SEARCHCOUNT:
                            IOrderssearch orderssearch = (IOrderssearch)JSONOrders.toOrderssearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blorders.searchcount(orderssearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREINSERT:
                    switch(operation) {
                        case IOrdersOperation.INSERT_ORDERS:
                            orders = (IOrders)JSONOrders.toOrders((JSONObject)json.get("orders"));
                            blorders.secureinsertOrders(orders);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREUPDATE:
                    switch(operation) {
                        case IOrdersOperation.UPDATE_ORDERS:
                            JSONObject jsonorders = (JSONObject)json.get("orders");
                            ordersPK = JSONOrders.toOrdersPK((JSONObject)jsonorders.get("PK"));
                            orders = blorders.getOrders(ordersPK);
                            JSONOrders.updateOrders(orders, jsonorders);
                            blorders.secureupdateOrders(orders);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREDELETE:
                    switch(operation) {
                        case IOrdersOperation.DELETE_ORDERS:
                            orders = (IOrders)JSONOrders.toOrders((JSONObject)json.get("orders"));
                            blorders.securedeleteOrders(orders);
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
     * PUT method for updating or creating an instance of RSOrders
     * @param content representation for the resource
     */
    @PUT
    @Consumes("text/html")
    public void put(String content) {
    }
}

