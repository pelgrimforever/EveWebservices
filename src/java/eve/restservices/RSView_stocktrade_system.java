/*
 * RSView_stocktrade_system.java
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
import eve.interfaces.logicview.IView_stocktrade_system;
import eve.interfaces.servlet.IView_stocktrade_systemOperation;
import eve.logicview.View_stocktrade_system;
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
@Path("rsview_stocktrade_system")
public class RSView_stocktrade_system {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of RSView_stocktrade_system
     */
    public RSView_stocktrade_system() {
    }

    /**
     * Retrieves representation of an instance of view_stocktrade_system.restservices.RSView_stocktrade_system
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{json}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@PathParam("json") String jsonstring) {
        try {
            BLview_stocktrade_system blview_stocktrade_system = new BLview_stocktrade_system();
            ArrayList view_stocktrade_systems = blview_stocktrade_system.getAll();
            JSONArray jsonview_stocktrade_systems = JSONView_stocktrade_system.toJSONArray(view_stocktrade_systems);
            return jsonview_stocktrade_systems.toJSONString();
        }
        catch(DBException e) {
            return "{ \"status\": \"error\"}";
        }
    }

    /**
     * Retrieves representation of an instance of view_stocktrade_system.restservices.RSView_stocktrade_system
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        String result = "";
        BLview_stocktrade_system blview_stocktrade_system = new BLview_stocktrade_system();
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject)parser.parse(jsonstring);
            JSONObject jsonoperation = (JSONObject)json.get("operation");
            byte operationtype = JSONConversion.getbyte(jsonoperation, "type");
            byte operation = JSONConversion.getbyte(jsonoperation, "operation");
            IView_stocktrade_system view_stocktrade_system;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    switch(operation) {
                        case IView_stocktrade_systemOperation.SELECT_ALL:
                            result = JSONView_stocktrade_system.toJSONArray(blview_stocktrade_system.getView_stocktrade_systems()).toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
                        case IView_stocktrade_systemOperation.SELECT_4USER:
                            String username = JSONConversion.getString(json, "username");
                            result = JSONView_stocktrade_system.toJSONArray(blview_stocktrade_system.getView_stocktrade_system4username(username)).toJSONString();
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
     * PUT method for updating or creating an instance of RSView_stocktrade_system
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("text/html")
    public void put(String content) {
    }
}

