/*
 * RSView_tradecombined_sell.java
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
import eve.interfaces.logicview.IView_tradecombined_sell;
import eve.interfaces.servlet.IView_tradecombined_sellOperation;
import eve.logicview.View_tradecombined_sell;
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
@Path("rsview_tradecombined_sell")
public class RSView_tradecombined_sell {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of RSView_tradecombined_sell
     */
    public RSView_tradecombined_sell() {
    }

    /**
     * Retrieves representation of an instance of view_tradecombined_sell.restservices.RSView_tradecombined_sell
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{json}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@PathParam("json") String jsonstring) {
        try {
            BLview_tradecombined_sell blview_tradecombined_sell = new BLview_tradecombined_sell();
            ArrayList view_tradecombined_sells = blview_tradecombined_sell.getAll();
            JSONArray jsonview_tradecombined_sells = JSONView_tradecombined_sell.toJSONArray(view_tradecombined_sells);
            return jsonview_tradecombined_sells.toJSONString();
        }
        catch(DBException e) {
            return "{ \"status\": \"error\"}";
        }
    }

    /**
     * Retrieves representation of an instance of view_tradecombined_sell.restservices.RSView_tradecombined_sell
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        String result = "";
        BLview_tradecombined_sell blview_tradecombined_sell = new BLview_tradecombined_sell();
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject)parser.parse(jsonstring);
            JSONObject jsonoperation = (JSONObject)json.get("operation");
            byte operationtype = JSONConversion.getbyte(jsonoperation, "type");
            byte operation = JSONConversion.getbyte(jsonoperation, "operation");
            IView_tradecombined_sell view_tradecombined_sell;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    switch(operation) {
                        case IView_tradecombined_sellOperation.SELECT_ALL:
                            result = JSONView_tradecombined_sell.toJSONArray(blview_tradecombined_sell.getView_tradecombined_sells()).toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
                        case IView_tradecombined_sellOperation.SELECT4TRADECOMBINED:
                            TradecombinedPK tradecombinedPK = (TradecombinedPK)JSONTradecombined.toTradecombinedPK((JSONObject)json.get("tradecombinedpk"));
                            result = JSONView_tradecombined_sell.toJSONArray(blview_tradecombined_sell.getView_tradecombined_sells(tradecombinedPK)).toJSONString();
                            break;
                        case IView_tradecombined_sellOperation.SELECT4TRADESYSTEMS:
                            SystemPK sell_systemPK = (SystemPK)JSONSystem.toSystemPK((JSONObject)json.get("sell_systempk"));
                            SystemPK buy_systemPK = (SystemPK)JSONSystem.toSystemPK((JSONObject)json.get("buy_systempk"));
                            result = JSONView_tradecombined_sell.toJSONArray(blview_tradecombined_sell.getView_tradecombined_sells(sell_systemPK, buy_systemPK)).toJSONString();
                            break;
//Custom code, do not change this line   
                    }
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
     * PUT method for updating or creating an instance of RSView_tradecombined_sell
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("text/html")
    public void put(String content) {
    }
}

