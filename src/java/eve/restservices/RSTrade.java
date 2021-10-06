/*
 * RSTrade.java
 *
 * Generated on 6.9.2021 16:29
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
import eve.interfaces.searchentity.ITradesearch;
import eve.interfaces.servlet.ITradeOperation;
import eve.logicentity.Trade;
import eve.searchentity.Tradesearch;
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
@Path("rstrade")
public class RSTrade {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of HelloWorld
     */
    public RSTrade() {
    }

    /**
     * Retrieves representation of an instance of trade.restservices.RSTrade
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{json}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@PathParam("json") String jsonstring) {
        try {
            BLtrade bltrade = new BLtrade();
            ArrayList trades = bltrade.getAll();
            JSONArray jsontrades = JSONTrade.toJSONArray(trades);
            return jsontrades.toJSONString();
        }
        catch(DBException e) {
            return "{ \"status\": \"error\"}";
        }
    }

    /**
     * Retrieves representation of an instance of trade.restservices.RSTrade
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        String result = "";
        BLtrade bltrade = new BLtrade();
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject)parser.parse(jsonstring);
            JSONObject jsonoperation = (JSONObject)json.get("operation");
            byte operationtype = JSONConversion.getbyte(jsonoperation, "type");
            byte operation = JSONConversion.getbyte(jsonoperation, "operation");
            ITradePK tradePK;
            ITrade trade;
//Security parameters
            boolean loggedin = RSsecurity.check(json);
            bltrade.setAuthenticated(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    switch(operation) {
                        case ITradeOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", bltrade.count());
                            result = jsoncount.toJSONString();
                            break;
                        case ITradeOperation.SELECT_ALL:
                            result = JSONTrade.toJSONArray(bltrade.getTrades()).toJSONString();
                            break;
                        case ITradeOperation.SELECT_TRADE:
                            tradePK = (ITradePK)JSONTrade.toTradePK((JSONObject)json.get("tradepk"));
                            result = JSONTrade.toJSON(bltrade.getTrade(tradePK)).toJSONString();
                            break;
                        case ITradeOperation.SELECT_Orderssell_order_id:
                            IOrdersPK ordersSell_order_idPK = (IOrdersPK)JSONOrders.toOrdersPK((JSONObject)json.get("orderspk"));
                            result = JSONTrade.toJSONArray(bltrade.getTrades4ordersSell_order_id(ordersSell_order_idPK)).toJSONString();
                            break;
                        case ITradeOperation.SELECT_Ordersbuy_order_id:
                            IOrdersPK ordersBuy_order_idPK = (IOrdersPK)JSONOrders.toOrdersPK((JSONObject)json.get("orderspk"));
                            result = JSONTrade.toJSONArray(bltrade.getTrades4ordersBuy_order_id(ordersBuy_order_idPK)).toJSONString();
                            break;
                        case ITradeOperation.SELECT_SEARCH:
                            ITradesearch search = (ITradesearch)JSONTrade.toTradesearch((JSONObject)json.get("search"));
                            result = JSONTrade.toJSONArray(bltrade.search(search)).toJSONString();
                            break;
                        case ITradeOperation.SELECT_SEARCHCOUNT:
                            ITradesearch tradesearch = (ITradesearch)JSONTrade.toTradesearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", bltrade.searchcount(tradesearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(operation) {
                        case ITradeOperation.INSERT_TRADE:
                            trade = (ITrade)JSONTrade.toTrade((JSONObject)json.get("trade"));
                            bltrade.insertTrade(trade);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(operation) {
                        case ITradeOperation.UPDATE_TRADE:
                            JSONObject jsontrade = (JSONObject)json.get("trade");
                            tradePK = JSONTrade.toTradePK((JSONObject)jsontrade.get("PK"));
                            trade = bltrade.getTrade(tradePK);
                            JSONTrade.updateTrade(trade, jsontrade);
                            bltrade.updateTrade(trade);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
                        case ITradeOperation.UPDATE_TRADING:
                            tradePK = (ITradePK)JSONTrade.toTradePK((JSONObject)json.get("tradepk"));
                            long volume = JSONConversion.getlong(json, "volume");
                            bltrade.executetrade(tradePK, volume);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(operation) {
                        case ITradeOperation.DELETE_TRADE:
                            trade = (ITrade)JSONTrade.toTrade((JSONObject)json.get("trade"));
                            bltrade.deleteTrade(trade);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECURESELECT:
                    switch(operation) {
                        case ITradeOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", bltrade.count());
                            result = jsoncount.toJSONString();
                            break;
                        case ITradeOperation.SELECT_ALL:
                            result = JSONTrade.toJSONArray(bltrade.getTrades()).toJSONString();
                            break;
                        case ITradeOperation.SELECT_TRADE:
                            tradePK = (ITradePK)JSONTrade.toTradePK((JSONObject)json.get("tradepk"));
                            result = JSONTrade.toJSON(bltrade.getTrade(tradePK)).toJSONString();
                            break;
                        case ITradeOperation.SELECT_Orderssell_order_id:
                            IOrdersPK ordersSell_order_idPK = (IOrdersPK)JSONOrders.toOrdersPK((JSONObject)json.get("orderspk"));
                            result = JSONTrade.toJSONArray(bltrade.getTrades4ordersSell_order_id(ordersSell_order_idPK)).toJSONString();
                            break;
                        case ITradeOperation.SELECT_Ordersbuy_order_id:
                            IOrdersPK ordersBuy_order_idPK = (IOrdersPK)JSONOrders.toOrdersPK((JSONObject)json.get("orderspk"));
                            result = JSONTrade.toJSONArray(bltrade.getTrades4ordersBuy_order_id(ordersBuy_order_idPK)).toJSONString();
                            break;
                        case ITradeOperation.SELECT_SEARCH:
                            ITradesearch search = (ITradesearch)JSONTrade.toTradesearch((JSONObject)json.get("search"));
                            result = JSONTrade.toJSONArray(bltrade.search(search)).toJSONString();
                            break;
                        case ITradeOperation.SELECT_SEARCHCOUNT:
                            ITradesearch tradesearch = (ITradesearch)JSONTrade.toTradesearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", bltrade.searchcount(tradesearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREINSERT:
                    switch(operation) {
                        case ITradeOperation.INSERT_TRADE:
                            trade = (ITrade)JSONTrade.toTrade((JSONObject)json.get("trade"));
                            bltrade.secureinsertTrade(trade);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREUPDATE:
                    switch(operation) {
                        case ITradeOperation.UPDATE_TRADE:
                            JSONObject jsontrade = (JSONObject)json.get("trade");
                            tradePK = JSONTrade.toTradePK((JSONObject)jsontrade.get("PK"));
                            trade = bltrade.getTrade(tradePK);
                            JSONTrade.updateTrade(trade, jsontrade);
                            bltrade.secureupdateTrade(trade);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREDELETE:
                    switch(operation) {
                        case ITradeOperation.DELETE_TRADE:
                            trade = (ITrade)JSONTrade.toTrade((JSONObject)json.get("trade"));
                            bltrade.securedeleteTrade(trade);
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
     * PUT method for updating or creating an instance of RSTrade
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("text/html")
    public void put(String content) {
    }
}

