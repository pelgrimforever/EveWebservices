/*
 * RSSystemtrade.java
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
import eve.interfaces.searchentity.ISystemtradesearch;
import eve.interfaces.servlet.ISystemtradeOperation;
import eve.logicentity.Systemtrade;
import eve.searchentity.Systemtradesearch;
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
@Path("rssystemtrade")
public class RSSystemtrade {

    /**
     * Creates a new instance of HelloWorld
     */
    public RSSystemtrade() {
    }

    /**
     * Retrieves representation of an instance of systemtrade.restservices.RSSystemtrade
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{json}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@PathParam("json") String jsonstring) {
        try {
            BLsystemtrade blsystemtrade = new BLsystemtrade();
            ArrayList systemtrades = blsystemtrade.getAll();
            JSONArray jsonsystemtrades = JSONSystemtrade.toJSONArray(systemtrades);
            return jsonsystemtrades.toJSONString();
        }
        catch(DBException e) {
            return "{ \"status\": \"error\"}";
        }
    }

    /**
     * Retrieves representation of an instance of systemtrade.restservices.RSSystemtrade
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        String result = "";
        BLsystemtrade blsystemtrade = new BLsystemtrade();
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject)parser.parse(jsonstring);
            JSONObject jsonoperation = (JSONObject)json.get("operation");
            byte operationtype = JSONConversion.getbyte(jsonoperation, "type");
            byte operation = JSONConversion.getbyte(jsonoperation, "operation");
            ISystemtradePK systemtradePK;
            ISystemtrade systemtrade;
//Security parameters
            boolean loggedin = RSsecurity.check(json);
            blsystemtrade.setAuthenticated(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    switch(operation) {
                        case ISystemtradeOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blsystemtrade.count());
                            result = jsoncount.toJSONString();
                            break;
                        case ISystemtradeOperation.SELECT_ALL:
                            result = JSONSystemtrade.toJSONArray(blsystemtrade.getSystemtrades()).toJSONString();
                            break;
                        case ISystemtradeOperation.SELECT_SYSTEMTRADE:
                            systemtradePK = (ISystemtradePK)JSONSystemtrade.toSystemtradePK((JSONObject)json.get("systemtradepk"));
                            result = JSONSystemtrade.toJSON(blsystemtrade.getSystemtrade(systemtradePK)).toJSONString();
                            break;
                        case ISystemtradeOperation.SELECT_Systemsell_system:
                            ISystemPK systemSell_systemPK = (ISystemPK)JSONSystem.toSystemPK((JSONObject)json.get("systempk"));
                            result = JSONSystemtrade.toJSONArray(blsystemtrade.getSystemtrades4systemSell_system(systemSell_systemPK)).toJSONString();
                            break;
                        case ISystemtradeOperation.SELECT_Systembuy_system:
                            ISystemPK systemBuy_systemPK = (ISystemPK)JSONSystem.toSystemPK((JSONObject)json.get("systempk"));
                            result = JSONSystemtrade.toJSONArray(blsystemtrade.getSystemtrades4systemBuy_system(systemBuy_systemPK)).toJSONString();
                            break;
                        case ISystemtradeOperation.SELECT_Systemtrade_order:
                            ISystemtrade_orderPK systemtrade_orderPK = (ISystemtrade_orderPK)JSONSystemtrade_order.toSystemtrade_orderPK((JSONObject)json.get("systemtrade_orderpk"));
                            result = JSONSystemtrade.toJSON(blsystemtrade.getSystemtrade_order(systemtrade_orderPK)).toJSONString();
                            break;
                        case ISystemtradeOperation.SELECT_SEARCH:
                            ISystemtradesearch search = (ISystemtradesearch)JSONSystemtrade.toSystemtradesearch((JSONObject)json.get("search"));
                            result = JSONSystemtrade.toJSONArray(blsystemtrade.search(search)).toJSONString();
                            break;
                        case ISystemtradeOperation.SELECT_SEARCHCOUNT:
                            ISystemtradesearch systemtradesearch = (ISystemtradesearch)JSONSystemtrade.toSystemtradesearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blsystemtrade.searchcount(systemtradesearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(operation) {
                        case ISystemtradeOperation.INSERT_SYSTEMTRADE:
                            systemtrade = (ISystemtrade)JSONSystemtrade.toSystemtrade((JSONObject)json.get("systemtrade"));
                            blsystemtrade.insertSystemtrade(systemtrade);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(operation) {
                        case ISystemtradeOperation.UPDATE_SYSTEMTRADE:
                            JSONObject jsonsystemtrade = (JSONObject)json.get("systemtrade");
                            systemtradePK = JSONSystemtrade.toSystemtradePK((JSONObject)jsonsystemtrade.get("PK"));
                            systemtrade = blsystemtrade.getSystemtrade(systemtradePK);
                            JSONSystemtrade.updateSystemtrade(systemtrade, jsonsystemtrade);
                            blsystemtrade.updateSystemtrade(systemtrade);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(operation) {
                        case ISystemtradeOperation.DELETE_SYSTEMTRADE:
                            systemtrade = (ISystemtrade)JSONSystemtrade.toSystemtrade((JSONObject)json.get("systemtrade"));
                            blsystemtrade.deleteSystemtrade(systemtrade);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECURESELECT:
                    switch(operation) {
                        case ISystemtradeOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blsystemtrade.count());
                            result = jsoncount.toJSONString();
                            break;
                        case ISystemtradeOperation.SELECT_ALL:
                            result = JSONSystemtrade.toJSONArray(blsystemtrade.getSystemtrades()).toJSONString();
                            break;
                        case ISystemtradeOperation.SELECT_SYSTEMTRADE:
                            systemtradePK = (ISystemtradePK)JSONSystemtrade.toSystemtradePK((JSONObject)json.get("systemtradepk"));
                            result = JSONSystemtrade.toJSON(blsystemtrade.getSystemtrade(systemtradePK)).toJSONString();
                            break;
                        case ISystemtradeOperation.SELECT_Systemsell_system:
                            ISystemPK systemSell_systemPK = (ISystemPK)JSONSystem.toSystemPK((JSONObject)json.get("systempk"));
                            result = JSONSystemtrade.toJSONArray(blsystemtrade.getSystemtrades4systemSell_system(systemSell_systemPK)).toJSONString();
                            break;
                        case ISystemtradeOperation.SELECT_Systembuy_system:
                            ISystemPK systemBuy_systemPK = (ISystemPK)JSONSystem.toSystemPK((JSONObject)json.get("systempk"));
                            result = JSONSystemtrade.toJSONArray(blsystemtrade.getSystemtrades4systemBuy_system(systemBuy_systemPK)).toJSONString();
                            break;
                        case ISystemtradeOperation.SELECT_Systemtrade_order:
                            ISystemtrade_orderPK systemtrade_orderPK = (ISystemtrade_orderPK)JSONSystemtrade_order.toSystemtrade_orderPK((JSONObject)json.get("systemtrade_orderpk"));
                            result = JSONSystemtrade.toJSON(blsystemtrade.getSystemtrade_order(systemtrade_orderPK)).toJSONString();
                            break;
                        case ISystemtradeOperation.SELECT_SEARCH:
                            ISystemtradesearch search = (ISystemtradesearch)JSONSystemtrade.toSystemtradesearch((JSONObject)json.get("search"));
                            result = JSONSystemtrade.toJSONArray(blsystemtrade.search(search)).toJSONString();
                            break;
                        case ISystemtradeOperation.SELECT_SEARCHCOUNT:
                            ISystemtradesearch systemtradesearch = (ISystemtradesearch)JSONSystemtrade.toSystemtradesearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blsystemtrade.searchcount(systemtradesearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREINSERT:
                    switch(operation) {
                        case ISystemtradeOperation.INSERT_SYSTEMTRADE:
                            systemtrade = (ISystemtrade)JSONSystemtrade.toSystemtrade((JSONObject)json.get("systemtrade"));
                            blsystemtrade.secureinsertSystemtrade(systemtrade);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREUPDATE:
                    switch(operation) {
                        case ISystemtradeOperation.UPDATE_SYSTEMTRADE:
                            JSONObject jsonsystemtrade = (JSONObject)json.get("systemtrade");
                            systemtradePK = JSONSystemtrade.toSystemtradePK((JSONObject)jsonsystemtrade.get("PK"));
                            systemtrade = blsystemtrade.getSystemtrade(systemtradePK);
                            JSONSystemtrade.updateSystemtrade(systemtrade, jsonsystemtrade);
                            blsystemtrade.secureupdateSystemtrade(systemtrade);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREDELETE:
                    switch(operation) {
                        case ISystemtradeOperation.DELETE_SYSTEMTRADE:
                            systemtrade = (ISystemtrade)JSONSystemtrade.toSystemtrade((JSONObject)json.get("systemtrade"));
                            blsystemtrade.securedeleteSystemtrade(systemtrade);
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
     * PUT method for updating or creating an instance of RSSystemtrade
     * @param content representation for the resource
     */
    @PUT
    @Consumes("text/html")
    public void put(String content) {
    }
}

