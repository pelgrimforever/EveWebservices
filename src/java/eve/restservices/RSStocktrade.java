/*
 * RSStocktrade.java
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
import eve.interfaces.searchentity.IStocktradesearch;
import eve.interfaces.servlet.IStocktradeOperation;
import eve.logicentity.Stocktrade;
import eve.searchentity.Stocktradesearch;
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
@Path("rsstocktrade")
public class RSStocktrade {

    /**
     * Creates a new instance of HelloWorld
     */
    public RSStocktrade() {
    }

    /**
     * Retrieves representation of an instance of stocktrade.restservices.RSStocktrade
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{json}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@PathParam("json") String jsonstring) {
        try {
            BLstocktrade blstocktrade = new BLstocktrade();
            ArrayList stocktrades = blstocktrade.getAll();
            JSONArray jsonstocktrades = JSONStocktrade.toJSONArray(stocktrades);
            return jsonstocktrades.toJSONString();
        }
        catch(DBException e) {
            return "{ \"status\": \"error\"}";
        }
    }

    /**
     * Retrieves representation of an instance of stocktrade.restservices.RSStocktrade
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        String result = "";
        BLstocktrade blstocktrade = new BLstocktrade();
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject)parser.parse(jsonstring);
            JSONObject jsonoperation = (JSONObject)json.get("operation");
            byte operationtype = JSONConversion.getbyte(jsonoperation, "type");
            byte operation = JSONConversion.getbyte(jsonoperation, "operation");
            IStocktradePK stocktradePK;
            IStocktrade stocktrade;
//Security parameters
            boolean loggedin = RSsecurity.check(json);
            blstocktrade.setAuthenticated(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    switch(operation) {
                        case IStocktradeOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blstocktrade.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IStocktradeOperation.SELECT_ALL:
                            result = JSONStocktrade.toJSONArray(blstocktrade.getStocktrades()).toJSONString();
                            break;
                        case IStocktradeOperation.SELECT_STOCKTRADE:
                            stocktradePK = (IStocktradePK)JSONStocktrade.toStocktradePK((JSONObject)json.get("stocktradepk"));
                            result = JSONStocktrade.toJSON(blstocktrade.getStocktrade(stocktradePK)).toJSONString();
                            break;
                        case IStocktradeOperation.SELECT_Stock:
                            IStockPK stockPK = (IStockPK)JSONStock.toStockPK((JSONObject)json.get("stockpk"));
                            result = JSONStocktrade.toJSONArray(blstocktrade.getStocktrades4stock(stockPK)).toJSONString();
                            break;
                        case IStocktradeOperation.SELECT_SEARCH:
                            IStocktradesearch search = (IStocktradesearch)JSONStocktrade.toStocktradesearch((JSONObject)json.get("search"));
                            result = JSONStocktrade.toJSONArray(blstocktrade.search(search)).toJSONString();
                            break;
                        case IStocktradeOperation.SELECT_SEARCHCOUNT:
                            IStocktradesearch stocktradesearch = (IStocktradesearch)JSONStocktrade.toStocktradesearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blstocktrade.searchcount(stocktradesearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(operation) {
                        case IStocktradeOperation.INSERT_STOCKTRADE:
                            stocktrade = (IStocktrade)JSONStocktrade.toStocktrade((JSONObject)json.get("stocktrade"));
                            blstocktrade.insertStocktrade(stocktrade);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(operation) {
                        case IStocktradeOperation.UPDATE_STOCKTRADE:
                            JSONObject jsonstocktrade = (JSONObject)json.get("stocktrade");
                            stocktradePK = JSONStocktrade.toStocktradePK((JSONObject)jsonstocktrade.get("PK"));
                            stocktrade = blstocktrade.getStocktrade(stocktradePK);
                            JSONStocktrade.updateStocktrade(stocktrade, jsonstocktrade);
                            blstocktrade.updateStocktrade(stocktrade);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(operation) {
                        case IStocktradeOperation.DELETE_STOCKTRADE:
                            stocktrade = (IStocktrade)JSONStocktrade.toStocktrade((JSONObject)json.get("stocktrade"));
                            blstocktrade.deleteStocktrade(stocktrade);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECURESELECT:
                    switch(operation) {
                        case IStocktradeOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blstocktrade.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IStocktradeOperation.SELECT_ALL:
                            result = JSONStocktrade.toJSONArray(blstocktrade.getStocktrades()).toJSONString();
                            break;
                        case IStocktradeOperation.SELECT_STOCKTRADE:
                            stocktradePK = (IStocktradePK)JSONStocktrade.toStocktradePK((JSONObject)json.get("stocktradepk"));
                            result = JSONStocktrade.toJSON(blstocktrade.getStocktrade(stocktradePK)).toJSONString();
                            break;
                        case IStocktradeOperation.SELECT_Stock:
                            IStockPK stockPK = (IStockPK)JSONStock.toStockPK((JSONObject)json.get("stockpk"));
                            result = JSONStocktrade.toJSONArray(blstocktrade.getStocktrades4stock(stockPK)).toJSONString();
                            break;
                        case IStocktradeOperation.SELECT_SEARCH:
                            IStocktradesearch search = (IStocktradesearch)JSONStocktrade.toStocktradesearch((JSONObject)json.get("search"));
                            result = JSONStocktrade.toJSONArray(blstocktrade.search(search)).toJSONString();
                            break;
                        case IStocktradeOperation.SELECT_SEARCHCOUNT:
                            IStocktradesearch stocktradesearch = (IStocktradesearch)JSONStocktrade.toStocktradesearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blstocktrade.searchcount(stocktradesearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREINSERT:
                    switch(operation) {
                        case IStocktradeOperation.INSERT_STOCKTRADE:
                            stocktrade = (IStocktrade)JSONStocktrade.toStocktrade((JSONObject)json.get("stocktrade"));
                            blstocktrade.secureinsertStocktrade(stocktrade);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREUPDATE:
                    switch(operation) {
                        case IStocktradeOperation.UPDATE_STOCKTRADE:
                            JSONObject jsonstocktrade = (JSONObject)json.get("stocktrade");
                            stocktradePK = JSONStocktrade.toStocktradePK((JSONObject)jsonstocktrade.get("PK"));
                            stocktrade = blstocktrade.getStocktrade(stocktradePK);
                            JSONStocktrade.updateStocktrade(stocktrade, jsonstocktrade);
                            blstocktrade.secureupdateStocktrade(stocktrade);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREDELETE:
                    switch(operation) {
                        case IStocktradeOperation.DELETE_STOCKTRADE:
                            stocktrade = (IStocktrade)JSONStocktrade.toStocktrade((JSONObject)json.get("stocktrade"));
                            blstocktrade.securedeleteStocktrade(stocktrade);
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
     * PUT method for updating or creating an instance of RSStocktrade
     * @param content representation for the resource
     */
    @PUT
    @Consumes("text/html")
    public void put(String content) {
    }
}

