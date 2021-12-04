/*
 * RSTradecombined.java
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
import eve.interfaces.searchentity.ITradecombinedsearch;
import eve.interfaces.servlet.ITradecombinedOperation;
import eve.logicentity.Tradecombined;
import eve.searchentity.Tradecombinedsearch;
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
@Path("rstradecombined")
public class RSTradecombined {

    /**
     * Creates a new instance of HelloWorld
     */
    public RSTradecombined() {
    }

    /**
     * Retrieves representation of an instance of tradecombined.restservices.RSTradecombined
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{json}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@PathParam("json") String jsonstring) {
        try {
            BLtradecombined bltradecombined = new BLtradecombined();
            ArrayList tradecombineds = bltradecombined.getAll();
            JSONArray jsontradecombineds = JSONTradecombined.toJSONArray(tradecombineds);
            return jsontradecombineds.toJSONString();
        }
        catch(DBException e) {
            return "{ \"status\": \"error\"}";
        }
    }

    /**
     * Retrieves representation of an instance of tradecombined.restservices.RSTradecombined
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        String result = "";
        BLtradecombined bltradecombined = new BLtradecombined();
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject)parser.parse(jsonstring);
            JSONObject jsonoperation = (JSONObject)json.get("operation");
            byte operationtype = JSONConversion.getbyte(jsonoperation, "type");
            byte operation = JSONConversion.getbyte(jsonoperation, "operation");
            ITradecombinedPK tradecombinedPK;
            ITradecombined tradecombined;
//Security parameters
            boolean loggedin = RSsecurity.check(json);
            bltradecombined.setAuthenticated(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    switch(operation) {
                        case ITradecombinedOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", bltradecombined.count());
                            result = jsoncount.toJSONString();
                            break;
                        case ITradecombinedOperation.SELECT_ALL:
                            result = JSONTradecombined.toJSONArray(bltradecombined.getTradecombineds()).toJSONString();
                            break;
                        case ITradecombinedOperation.SELECT_TRADECOMBINED:
                            tradecombinedPK = (ITradecombinedPK)JSONTradecombined.toTradecombinedPK((JSONObject)json.get("tradecombinedpk"));
                            result = JSONTradecombined.toJSON(bltradecombined.getTradecombined(tradecombinedPK)).toJSONString();
                            break;
                        case ITradecombinedOperation.SELECT_Evetype:
                            IEvetypePK evetypePK = (IEvetypePK)JSONEvetype.toEvetypePK((JSONObject)json.get("evetypepk"));
                            result = JSONTradecombined.toJSONArray(bltradecombined.getTradecombineds4evetype(evetypePK)).toJSONString();
                            break;
                        case ITradecombinedOperation.SELECT_Systembuy_system:
                            ISystemPK systemBuy_systemPK = (ISystemPK)JSONSystem.toSystemPK((JSONObject)json.get("systempk"));
                            result = JSONTradecombined.toJSONArray(bltradecombined.getTradecombineds4systemBuy_system(systemBuy_systemPK)).toJSONString();
                            break;
                        case ITradecombinedOperation.SELECT_Systemsell_system:
                            ISystemPK systemSell_systemPK = (ISystemPK)JSONSystem.toSystemPK((JSONObject)json.get("systempk"));
                            result = JSONTradecombined.toJSONArray(bltradecombined.getTradecombineds4systemSell_system(systemSell_systemPK)).toJSONString();
                            break;
                        case ITradecombinedOperation.SELECT_Tradecombined_sell:
                            ITradecombined_sellPK tradecombined_sellPK = (ITradecombined_sellPK)JSONTradecombined_sell.toTradecombined_sellPK((JSONObject)json.get("tradecombined_sellpk"));
                            result = JSONTradecombined.toJSON(bltradecombined.getTradecombined_sell(tradecombined_sellPK)).toJSONString();
                            break;
                        case ITradecombinedOperation.SELECT_SEARCH:
                            ITradecombinedsearch search = (ITradecombinedsearch)JSONTradecombined.toTradecombinedsearch((JSONObject)json.get("search"));
                            result = JSONTradecombined.toJSONArray(bltradecombined.search(search)).toJSONString();
                            break;
                        case ITradecombinedOperation.SELECT_SEARCHCOUNT:
                            ITradecombinedsearch tradecombinedsearch = (ITradecombinedsearch)JSONTradecombined.toTradecombinedsearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", bltradecombined.searchcount(tradecombinedsearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(operation) {
                        case ITradecombinedOperation.INSERT_TRADECOMBINED:
                            tradecombined = (ITradecombined)JSONTradecombined.toTradecombined((JSONObject)json.get("tradecombined"));
                            bltradecombined.insertTradecombined(tradecombined);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(operation) {
                        case ITradecombinedOperation.UPDATE_TRADECOMBINED:
                            JSONObject jsontradecombined = (JSONObject)json.get("tradecombined");
                            tradecombinedPK = JSONTradecombined.toTradecombinedPK((JSONObject)jsontradecombined.get("PK"));
                            tradecombined = bltradecombined.getTradecombined(tradecombinedPK);
                            JSONTradecombined.updateTradecombined(tradecombined, jsontradecombined);
                            bltradecombined.updateTradecombined(tradecombined);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(operation) {
                        case ITradecombinedOperation.DELETE_TRADECOMBINED:
                            tradecombined = (ITradecombined)JSONTradecombined.toTradecombined((JSONObject)json.get("tradecombined"));
                            bltradecombined.deleteTradecombined(tradecombined);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECURESELECT:
                    switch(operation) {
                        case ITradecombinedOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", bltradecombined.count());
                            result = jsoncount.toJSONString();
                            break;
                        case ITradecombinedOperation.SELECT_ALL:
                            result = JSONTradecombined.toJSONArray(bltradecombined.getTradecombineds()).toJSONString();
                            break;
                        case ITradecombinedOperation.SELECT_TRADECOMBINED:
                            tradecombinedPK = (ITradecombinedPK)JSONTradecombined.toTradecombinedPK((JSONObject)json.get("tradecombinedpk"));
                            result = JSONTradecombined.toJSON(bltradecombined.getTradecombined(tradecombinedPK)).toJSONString();
                            break;
                        case ITradecombinedOperation.SELECT_Evetype:
                            IEvetypePK evetypePK = (IEvetypePK)JSONEvetype.toEvetypePK((JSONObject)json.get("evetypepk"));
                            result = JSONTradecombined.toJSONArray(bltradecombined.getTradecombineds4evetype(evetypePK)).toJSONString();
                            break;
                        case ITradecombinedOperation.SELECT_Systembuy_system:
                            ISystemPK systemBuy_systemPK = (ISystemPK)JSONSystem.toSystemPK((JSONObject)json.get("systempk"));
                            result = JSONTradecombined.toJSONArray(bltradecombined.getTradecombineds4systemBuy_system(systemBuy_systemPK)).toJSONString();
                            break;
                        case ITradecombinedOperation.SELECT_Systemsell_system:
                            ISystemPK systemSell_systemPK = (ISystemPK)JSONSystem.toSystemPK((JSONObject)json.get("systempk"));
                            result = JSONTradecombined.toJSONArray(bltradecombined.getTradecombineds4systemSell_system(systemSell_systemPK)).toJSONString();
                            break;
                        case ITradecombinedOperation.SELECT_Tradecombined_sell:
                            ITradecombined_sellPK tradecombined_sellPK = (ITradecombined_sellPK)JSONTradecombined_sell.toTradecombined_sellPK((JSONObject)json.get("tradecombined_sellpk"));
                            result = JSONTradecombined.toJSON(bltradecombined.getTradecombined_sell(tradecombined_sellPK)).toJSONString();
                            break;
                        case ITradecombinedOperation.SELECT_SEARCH:
                            ITradecombinedsearch search = (ITradecombinedsearch)JSONTradecombined.toTradecombinedsearch((JSONObject)json.get("search"));
                            result = JSONTradecombined.toJSONArray(bltradecombined.search(search)).toJSONString();
                            break;
                        case ITradecombinedOperation.SELECT_SEARCHCOUNT:
                            ITradecombinedsearch tradecombinedsearch = (ITradecombinedsearch)JSONTradecombined.toTradecombinedsearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", bltradecombined.searchcount(tradecombinedsearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREINSERT:
                    switch(operation) {
                        case ITradecombinedOperation.INSERT_TRADECOMBINED:
                            tradecombined = (ITradecombined)JSONTradecombined.toTradecombined((JSONObject)json.get("tradecombined"));
                            bltradecombined.secureinsertTradecombined(tradecombined);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREUPDATE:
                    switch(operation) {
                        case ITradecombinedOperation.UPDATE_TRADECOMBINED:
                            JSONObject jsontradecombined = (JSONObject)json.get("tradecombined");
                            tradecombinedPK = JSONTradecombined.toTradecombinedPK((JSONObject)jsontradecombined.get("PK"));
                            tradecombined = bltradecombined.getTradecombined(tradecombinedPK);
                            JSONTradecombined.updateTradecombined(tradecombined, jsontradecombined);
                            bltradecombined.secureupdateTradecombined(tradecombined);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREDELETE:
                    switch(operation) {
                        case ITradecombinedOperation.DELETE_TRADECOMBINED:
                            tradecombined = (ITradecombined)JSONTradecombined.toTradecombined((JSONObject)json.get("tradecombined"));
                            bltradecombined.securedeleteTradecombined(tradecombined);
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
     * PUT method for updating or creating an instance of RSTradecombined
     * @param content representation for the resource
     */
    @PUT
    @Consumes("text/html")
    public void put(String content) {
    }
}

