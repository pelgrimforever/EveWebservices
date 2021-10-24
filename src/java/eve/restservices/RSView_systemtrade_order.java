/*
 * RSView_systemtrade_order.java
 *
 * Generated on 24.9.2021 14:40
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
import eve.interfaces.logicview.IView_systemtrade_order;
import eve.interfaces.servlet.IView_systemtrade_orderOperation;
import eve.logicview.View_systemtrade_order;
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
@Path("rsview_systemtrade_order")
public class RSView_systemtrade_order {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of RSView_systemtrade_order
     */
    public RSView_systemtrade_order() {
    }

    /**
     * Retrieves representation of an instance of view_systemtrade_order.restservices.RSView_systemtrade_order
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{json}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@PathParam("json") String jsonstring) {
        try {
            BLview_systemtrade_order blview_systemtrade_order = new BLview_systemtrade_order();
            ArrayList view_systemtrade_orders = blview_systemtrade_order.getAll();
            JSONArray jsonview_systemtrade_orders = JSONView_systemtrade_order.toJSONArray(view_systemtrade_orders);
            return jsonview_systemtrade_orders.toJSONString();
        }
        catch(DBException e) {
            return "{ \"status\": \"error\"}";
        }
    }

    /**
     * Retrieves representation of an instance of view_systemtrade_order.restservices.RSView_systemtrade_order
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        String result = "";
        BLview_systemtrade_order blview_systemtrade_order = new BLview_systemtrade_order();
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject)parser.parse(jsonstring);
            JSONObject jsonoperation = (JSONObject)json.get("operation");
            byte operationtype = JSONConversion.getbyte(jsonoperation, "type");
            byte operation = JSONConversion.getbyte(jsonoperation, "operation");
            IView_systemtrade_order view_systemtrade_order;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    switch(operation) {
                        case IView_systemtrade_orderOperation.SELECT_ALL:
                            result = JSONView_systemtrade_order.toJSONArray(blview_systemtrade_order.getView_systemtrade_orders()).toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
                        case IView_systemtrade_orderOperation.SELECT_ALL4SYSTEMTRADE:
                            SystemtradePK systemtradePK = (SystemtradePK)JSONSystemtrade.toSystemtradePK((JSONObject)json.get("systemtradepk"));
                            result = JSONView_systemtrade_order.toJSONArray(blview_systemtrade_order.getView_all4systemtrade(systemtradePK)).toJSONString();
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
     * PUT method for updating or creating an instance of RSView_systemtrade_order
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("text/html")
    public void put(String content) {
    }
}

