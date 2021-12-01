/*
 * RSView_stocktrade_orders.java
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
import eve.interfaces.logicview.IView_stocktrade_orders;
import eve.interfaces.servlet.IView_stocktrade_ordersOperation;
import eve.logicview.View_stocktrade_orders;
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
@Path("rsview_stocktrade_orders")
public class RSView_stocktrade_orders {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of RSView_stocktrade_orders
     */
    public RSView_stocktrade_orders() {
    }

    /**
     * Retrieves representation of an instance of view_stocktrade_orders.restservices.RSView_stocktrade_orders
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{json}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@PathParam("json") String jsonstring) {
        try {
            BLview_stocktrade_orders blview_stocktrade_orders = new BLview_stocktrade_orders();
            ArrayList view_stocktrade_orderss = blview_stocktrade_orders.getAll();
            JSONArray jsonview_stocktrade_orderss = JSONView_stocktrade_orders.toJSONArray(view_stocktrade_orderss);
            return jsonview_stocktrade_orderss.toJSONString();
        }
        catch(DBException e) {
            return "{ \"status\": \"error\"}";
        }
    }

    /**
     * Retrieves representation of an instance of view_stocktrade_orders.restservices.RSView_stocktrade_orders
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        String result = "";
        BLview_stocktrade_orders blview_stocktrade_orders = new BLview_stocktrade_orders();
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject)parser.parse(jsonstring);
            JSONObject jsonoperation = (JSONObject)json.get("operation");
            byte operationtype = JSONConversion.getbyte(jsonoperation, "type");
            byte operation = JSONConversion.getbyte(jsonoperation, "operation");
            IView_stocktrade_orders view_stocktrade_orders;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    switch(operation) {
                        case IView_stocktrade_ordersOperation.SELECT_ALL:
                            result = JSONView_stocktrade_orders.toJSONArray(blview_stocktrade_orders.getView_stocktrade_orderss()).toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
                        case IView_stocktrade_ordersOperation.SELECT_4USERNAME_SYSTEM:
                            String username = JSONConversion.getString(json, "username");
                            long system = JSONConversion.getlong(json, "system");
                            result = JSONView_stocktrade_orders.toJSONArray(blview_stocktrade_orders.getView_stocktrade_orders4usernamesystem(username, system)).toJSONString();
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
     * PUT method for updating or creating an instance of RSView_stocktrade_orders
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("text/html")
    public void put(String content) {
    }
}

