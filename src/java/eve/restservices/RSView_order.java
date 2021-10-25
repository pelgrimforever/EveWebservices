/*
 * RSView_order.java
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
import eve.interfaces.logicview.IView_order;
import eve.interfaces.servlet.IView_orderOperation;
import eve.logicview.View_order;
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
@Path("rsview_order")
public class RSView_order {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of RSView_order
     */
    public RSView_order() {
    }

    /**
     * Retrieves representation of an instance of view_order.restservices.RSView_order
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{json}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@PathParam("json") String jsonstring) {
        try {
            BLview_order blview_order = new BLview_order();
            ArrayList view_orders = blview_order.getAll();
            JSONArray jsonview_orders = JSONView_order.toJSONArray(view_orders);
            return jsonview_orders.toJSONString();
        }
        catch(DBException e) {
            return "{ \"status\": \"error\"}";
        }
    }

    /**
     * Retrieves representation of an instance of view_order.restservices.RSView_order
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        String result = "";
        BLview_order blview_order = new BLview_order();
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject)parser.parse(jsonstring);
            JSONObject jsonoperation = (JSONObject)json.get("operation");
            byte operationtype = JSONConversion.getbyte(jsonoperation, "type");
            byte operation = JSONConversion.getbyte(jsonoperation, "operation");
            IView_order view_order;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    switch(operation) {
                        case IView_orderOperation.SELECT_ALL:
                            result = JSONView_order.toJSONArray(blview_order.getView_orders()).toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
                        case IView_orderOperation.SELECT_ONE:
                            OrdersPK orderPK = (OrdersPK)JSONOrders.toOrdersPK((JSONObject)json.get("orderpk"));
                            result = JSONView_order.toJSON(blview_order.getView_order(orderPK)).toJSONString();
                            break;
                        case IView_orderOperation.SELECT_EVETYPE_SELL:
                            EvetypePK evetypePKsell = (EvetypePK)JSONEvetype.toEvetypePK((JSONObject)json.get("evetypepk"));
                            result = JSONView_order.toJSONArray(blview_order.getView_orders4evetype_sell(evetypePKsell)).toJSONString();
                            break;
                        case IView_orderOperation.SELECT_EVETYPE_BUY:
                            EvetypePK evetypePKbuy = (EvetypePK)JSONEvetype.toEvetypePK((JSONObject)json.get("evetypepk"));
                            result = JSONView_order.toJSONArray(blview_order.getView_orders4evetype_buy(evetypePKbuy)).toJSONString();
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
     * PUT method for updating or creating an instance of RSView_order
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("text/html")
    public void put(String content) {
    }
}

