/*
 * RSTradecombined_sell.java
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
import eve.interfaces.searchentity.ITradecombined_sellsearch;
import eve.interfaces.servlet.ITradecombined_sellOperation;
import eve.logicentity.Tradecombined_sell;
import eve.searchentity.Tradecombined_sellsearch;
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
@Path("rstradecombined_sell")
public class RSTradecombined_sell {

    /**
     * Creates a new instance of HelloWorld
     */
    public RSTradecombined_sell() {
    }

    /**
     * Retrieves representation of an instance of tradecombined_sell.restservices.RSTradecombined_sell
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{json}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@PathParam("json") String jsonstring) {
        try {
            BLtradecombined_sell bltradecombined_sell = new BLtradecombined_sell();
            ArrayList tradecombined_sells = bltradecombined_sell.getAll();
            JSONArray jsontradecombined_sells = JSONTradecombined_sell.toJSONArray(tradecombined_sells);
            return jsontradecombined_sells.toJSONString();
        }
        catch(DBException e) {
            return "{ \"status\": \"error\"}";
        }
    }

    /**
     * Retrieves representation of an instance of tradecombined_sell.restservices.RSTradecombined_sell
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        String result = "";
        BLtradecombined_sell bltradecombined_sell = new BLtradecombined_sell();
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject)parser.parse(jsonstring);
            JSONObject jsonoperation = (JSONObject)json.get("operation");
            byte operationtype = JSONConversion.getbyte(jsonoperation, "type");
            byte operation = JSONConversion.getbyte(jsonoperation, "operation");
            ITradecombined_sellPK tradecombined_sellPK;
            ITradecombined_sell tradecombined_sell;
//Security parameters
            boolean loggedin = RSsecurity.check(json);
            bltradecombined_sell.setAuthenticated(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    switch(operation) {
                        case ITradecombined_sellOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", bltradecombined_sell.count());
                            result = jsoncount.toJSONString();
                            break;
                        case ITradecombined_sellOperation.SELECT_ALL:
                            result = JSONTradecombined_sell.toJSONArray(bltradecombined_sell.getTradecombined_sells()).toJSONString();
                            break;
                        case ITradecombined_sellOperation.SELECT_TRADECOMBINED_SELL:
                            tradecombined_sellPK = (ITradecombined_sellPK)JSONTradecombined_sell.toTradecombined_sellPK((JSONObject)json.get("tradecombined_sellpk"));
                            result = JSONTradecombined_sell.toJSON(bltradecombined_sell.getTradecombined_sell(tradecombined_sellPK)).toJSONString();
                            break;
                        case ITradecombined_sellOperation.SELECT_Ordersbuy_order_id:
                            IOrdersPK ordersBuy_order_idPK = (IOrdersPK)JSONOrders.toOrdersPK((JSONObject)json.get("orderspk"));
                            result = JSONTradecombined_sell.toJSONArray(bltradecombined_sell.getTradecombined_sells4ordersBuy_order_id(ordersBuy_order_idPK)).toJSONString();
                            break;
                        case ITradecombined_sellOperation.SELECT_Orderssell_order_id:
                            IOrdersPK ordersSell_order_idPK = (IOrdersPK)JSONOrders.toOrdersPK((JSONObject)json.get("orderspk"));
                            result = JSONTradecombined_sell.toJSONArray(bltradecombined_sell.getTradecombined_sells4ordersSell_order_id(ordersSell_order_idPK)).toJSONString();
                            break;
                        case ITradecombined_sellOperation.SELECT_Tradecombined:
                            ITradecombinedPK tradecombinedPK = (ITradecombinedPK)JSONTradecombined.toTradecombinedPK((JSONObject)json.get("tradecombinedpk"));
                            result = JSONTradecombined_sell.toJSONArray(bltradecombined_sell.getTradecombined_sells4tradecombined(tradecombinedPK)).toJSONString();
                            break;
                        case ITradecombined_sellOperation.SELECT_SEARCH:
                            ITradecombined_sellsearch search = (ITradecombined_sellsearch)JSONTradecombined_sell.toTradecombined_sellsearch((JSONObject)json.get("search"));
                            result = JSONTradecombined_sell.toJSONArray(bltradecombined_sell.search(search)).toJSONString();
                            break;
                        case ITradecombined_sellOperation.SELECT_SEARCHCOUNT:
                            ITradecombined_sellsearch tradecombined_sellsearch = (ITradecombined_sellsearch)JSONTradecombined_sell.toTradecombined_sellsearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", bltradecombined_sell.searchcount(tradecombined_sellsearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(operation) {
                        case ITradecombined_sellOperation.INSERT_TRADECOMBINED_SELL:
                            tradecombined_sell = (ITradecombined_sell)JSONTradecombined_sell.toTradecombined_sell((JSONObject)json.get("tradecombined_sell"));
                            bltradecombined_sell.insertTradecombined_sell(tradecombined_sell);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(operation) {
                        case ITradecombined_sellOperation.UPDATE_TRADECOMBINED_SELL:
                            JSONObject jsontradecombined_sell = (JSONObject)json.get("tradecombined_sell");
                            tradecombined_sellPK = JSONTradecombined_sell.toTradecombined_sellPK((JSONObject)jsontradecombined_sell.get("PK"));
                            tradecombined_sell = bltradecombined_sell.getTradecombined_sell(tradecombined_sellPK);
                            JSONTradecombined_sell.updateTradecombined_sell(tradecombined_sell, jsontradecombined_sell);
                            bltradecombined_sell.updateTradecombined_sell(tradecombined_sell);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(operation) {
                        case ITradecombined_sellOperation.DELETE_TRADECOMBINED_SELL:
                            tradecombined_sell = (ITradecombined_sell)JSONTradecombined_sell.toTradecombined_sell((JSONObject)json.get("tradecombined_sell"));
                            bltradecombined_sell.deleteTradecombined_sell(tradecombined_sell);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECURESELECT:
                    switch(operation) {
                        case ITradecombined_sellOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", bltradecombined_sell.count());
                            result = jsoncount.toJSONString();
                            break;
                        case ITradecombined_sellOperation.SELECT_ALL:
                            result = JSONTradecombined_sell.toJSONArray(bltradecombined_sell.getTradecombined_sells()).toJSONString();
                            break;
                        case ITradecombined_sellOperation.SELECT_TRADECOMBINED_SELL:
                            tradecombined_sellPK = (ITradecombined_sellPK)JSONTradecombined_sell.toTradecombined_sellPK((JSONObject)json.get("tradecombined_sellpk"));
                            result = JSONTradecombined_sell.toJSON(bltradecombined_sell.getTradecombined_sell(tradecombined_sellPK)).toJSONString();
                            break;
                        case ITradecombined_sellOperation.SELECT_Ordersbuy_order_id:
                            IOrdersPK ordersBuy_order_idPK = (IOrdersPK)JSONOrders.toOrdersPK((JSONObject)json.get("orderspk"));
                            result = JSONTradecombined_sell.toJSONArray(bltradecombined_sell.getTradecombined_sells4ordersBuy_order_id(ordersBuy_order_idPK)).toJSONString();
                            break;
                        case ITradecombined_sellOperation.SELECT_Orderssell_order_id:
                            IOrdersPK ordersSell_order_idPK = (IOrdersPK)JSONOrders.toOrdersPK((JSONObject)json.get("orderspk"));
                            result = JSONTradecombined_sell.toJSONArray(bltradecombined_sell.getTradecombined_sells4ordersSell_order_id(ordersSell_order_idPK)).toJSONString();
                            break;
                        case ITradecombined_sellOperation.SELECT_Tradecombined:
                            ITradecombinedPK tradecombinedPK = (ITradecombinedPK)JSONTradecombined.toTradecombinedPK((JSONObject)json.get("tradecombinedpk"));
                            result = JSONTradecombined_sell.toJSONArray(bltradecombined_sell.getTradecombined_sells4tradecombined(tradecombinedPK)).toJSONString();
                            break;
                        case ITradecombined_sellOperation.SELECT_SEARCH:
                            ITradecombined_sellsearch search = (ITradecombined_sellsearch)JSONTradecombined_sell.toTradecombined_sellsearch((JSONObject)json.get("search"));
                            result = JSONTradecombined_sell.toJSONArray(bltradecombined_sell.search(search)).toJSONString();
                            break;
                        case ITradecombined_sellOperation.SELECT_SEARCHCOUNT:
                            ITradecombined_sellsearch tradecombined_sellsearch = (ITradecombined_sellsearch)JSONTradecombined_sell.toTradecombined_sellsearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", bltradecombined_sell.searchcount(tradecombined_sellsearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREINSERT:
                    switch(operation) {
                        case ITradecombined_sellOperation.INSERT_TRADECOMBINED_SELL:
                            tradecombined_sell = (ITradecombined_sell)JSONTradecombined_sell.toTradecombined_sell((JSONObject)json.get("tradecombined_sell"));
                            bltradecombined_sell.secureinsertTradecombined_sell(tradecombined_sell);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREUPDATE:
                    switch(operation) {
                        case ITradecombined_sellOperation.UPDATE_TRADECOMBINED_SELL:
                            JSONObject jsontradecombined_sell = (JSONObject)json.get("tradecombined_sell");
                            tradecombined_sellPK = JSONTradecombined_sell.toTradecombined_sellPK((JSONObject)jsontradecombined_sell.get("PK"));
                            tradecombined_sell = bltradecombined_sell.getTradecombined_sell(tradecombined_sellPK);
                            JSONTradecombined_sell.updateTradecombined_sell(tradecombined_sell, jsontradecombined_sell);
                            bltradecombined_sell.secureupdateTradecombined_sell(tradecombined_sell);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREDELETE:
                    switch(operation) {
                        case ITradecombined_sellOperation.DELETE_TRADECOMBINED_SELL:
                            tradecombined_sell = (ITradecombined_sell)JSONTradecombined_sell.toTradecombined_sell((JSONObject)json.get("tradecombined_sell"));
                            bltradecombined_sell.securedeleteTradecombined_sell(tradecombined_sell);
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
     * PUT method for updating or creating an instance of RSTradecombined_sell
     * @param content representation for the resource
     */
    @PUT
    @Consumes("text/html")
    public void put(String content) {
    }
}

