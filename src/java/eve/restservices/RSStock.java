/*
 * RSStock.java
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
import eve.interfaces.searchentity.IStocksearch;
import eve.interfaces.servlet.IStockOperation;
import eve.logicentity.Stock;
import eve.searchentity.Stocksearch;
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
@Path("rsstock")
public class RSStock {

    /**
     * Creates a new instance of HelloWorld
     */
    public RSStock() {
    }

    /**
     * Retrieves representation of an instance of stock.restservices.RSStock
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{json}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@PathParam("json") String jsonstring) {
        try {
            BLstock blstock = new BLstock();
            ArrayList stocks = blstock.getAll();
            JSONArray jsonstocks = JSONStock.toJSONArray(stocks);
            return jsonstocks.toJSONString();
        }
        catch(DBException e) {
            return "{ \"status\": \"error\"}";
        }
    }

    /**
     * Retrieves representation of an instance of stock.restservices.RSStock
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        String result = "";
        BLstock blstock = new BLstock();
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject)parser.parse(jsonstring);
            JSONObject jsonoperation = (JSONObject)json.get("operation");
            byte operationtype = JSONConversion.getbyte(jsonoperation, "type");
            byte operation = JSONConversion.getbyte(jsonoperation, "operation");
            IStockPK stockPK;
            IStock stock;
//Security parameters
            boolean loggedin = RSsecurity.check(json);
            blstock.setAuthenticated(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    switch(operation) {
                        case IStockOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blstock.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IStockOperation.SELECT_ALL:
                            result = JSONStock.toJSONArray(blstock.getStocks()).toJSONString();
                            break;
                        case IStockOperation.SELECT_STOCK:
                            stockPK = (IStockPK)JSONStock.toStockPK((JSONObject)json.get("stockpk"));
                            result = JSONStock.toJSON(blstock.getStock(stockPK)).toJSONString();
                            break;
                        case IStockOperation.SELECT_Evetype:
                            IEvetypePK evetypePK = (IEvetypePK)JSONEvetype.toEvetypePK((JSONObject)json.get("evetypepk"));
                            result = JSONStock.toJSONArray(blstock.getStocks4evetype(evetypePK)).toJSONString();
                            break;
                        case IStockOperation.SELECT_Stocktrade:
                            IStocktradePK stocktradePK = (IStocktradePK)JSONStocktrade.toStocktradePK((JSONObject)json.get("stocktradepk"));
                            result = JSONStock.toJSON(blstock.getStocktrade(stocktradePK)).toJSONString();
                            break;
                        case IStockOperation.SELECT_SEARCH:
                            IStocksearch search = (IStocksearch)JSONStock.toStocksearch((JSONObject)json.get("search"));
                            result = JSONStock.toJSONArray(blstock.search(search)).toJSONString();
                            break;
                        case IStockOperation.SELECT_SEARCHCOUNT:
                            IStocksearch stocksearch = (IStocksearch)JSONStock.toStocksearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blstock.searchcount(stocksearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(operation) {
                        case IStockOperation.INSERT_STOCK:
                            stock = (IStock)JSONStock.toStock((JSONObject)json.get("stock"));
                            blstock.insertStock(stock);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(operation) {
                        case IStockOperation.UPDATE_STOCK:
                            JSONObject jsonstock = (JSONObject)json.get("stock");
                            stockPK = JSONStock.toStockPK((JSONObject)jsonstock.get("PK"));
                            stock = blstock.getStock(stockPK);
                            JSONStock.updateStock(stock, jsonstock);
                            blstock.updateStock(stock);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
                        case IStockOperation.UPDATE_ADDSTOCK:
                            JSONObject jsonaddstock = (JSONObject)json.get("stock");
                            stock = JSONStock.toStock(jsonaddstock);
                            blstock.addStock(stock);
                            result = returnstatus("OK");
                            break;
                        case IStockOperation.UPDATE_REMOVESTOCK:
                            JSONObject jsonremovestock = (JSONObject)json.get("stock");
                            stock = JSONStock.toStock(jsonremovestock);
                            blstock.removeStock(stock);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(operation) {
                        case IStockOperation.DELETE_STOCK:
                            stock = (IStock)JSONStock.toStock((JSONObject)json.get("stock"));
                            blstock.deleteStock(stock);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECURESELECT:
                    switch(operation) {
                        case IStockOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blstock.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IStockOperation.SELECT_ALL:
                            result = JSONStock.toJSONArray(blstock.getStocks()).toJSONString();
                            break;
                        case IStockOperation.SELECT_STOCK:
                            stockPK = (IStockPK)JSONStock.toStockPK((JSONObject)json.get("stockpk"));
                            result = JSONStock.toJSON(blstock.getStock(stockPK)).toJSONString();
                            break;
                        case IStockOperation.SELECT_Evetype:
                            IEvetypePK evetypePK = (IEvetypePK)JSONEvetype.toEvetypePK((JSONObject)json.get("evetypepk"));
                            result = JSONStock.toJSONArray(blstock.getStocks4evetype(evetypePK)).toJSONString();
                            break;
                        case IStockOperation.SELECT_Stocktrade:
                            IStocktradePK stocktradePK = (IStocktradePK)JSONStocktrade.toStocktradePK((JSONObject)json.get("stocktradepk"));
                            result = JSONStock.toJSON(blstock.getStocktrade(stocktradePK)).toJSONString();
                            break;
                        case IStockOperation.SELECT_SEARCH:
                            IStocksearch search = (IStocksearch)JSONStock.toStocksearch((JSONObject)json.get("search"));
                            result = JSONStock.toJSONArray(blstock.search(search)).toJSONString();
                            break;
                        case IStockOperation.SELECT_SEARCHCOUNT:
                            IStocksearch stocksearch = (IStocksearch)JSONStock.toStocksearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blstock.searchcount(stocksearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREINSERT:
                    switch(operation) {
                        case IStockOperation.INSERT_STOCK:
                            stock = (IStock)JSONStock.toStock((JSONObject)json.get("stock"));
                            blstock.secureinsertStock(stock);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREUPDATE:
                    switch(operation) {
                        case IStockOperation.UPDATE_STOCK:
                            JSONObject jsonstock = (JSONObject)json.get("stock");
                            stockPK = JSONStock.toStockPK((JSONObject)jsonstock.get("PK"));
                            stock = blstock.getStock(stockPK);
                            JSONStock.updateStock(stock, jsonstock);
                            blstock.secureupdateStock(stock);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREDELETE:
                    switch(operation) {
                        case IStockOperation.DELETE_STOCK:
                            stock = (IStock)JSONStock.toStock((JSONObject)json.get("stock"));
                            blstock.securedeleteStock(stock);
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
     * PUT method for updating or creating an instance of RSStock
     * @param content representation for the resource
     */
    @PUT
    @Consumes("text/html")
    public void put(String content) {
    }
}

