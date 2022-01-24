/*
 * RSView_shipfitmodule.java
 *
 * Generated on 14.0.2022 16:56
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
import eve.interfaces.logicview.IView_shipfitmodule;
import eve.interfaces.servlet.IView_shipfitmoduleOperation;
import eve.logicview.View_shipfitmodule;
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
@Path("rsview_shipfitmodule")
public class RSView_shipfitmodule {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of RSView_shipfitmodule
     */
    public RSView_shipfitmodule() {
    }

    /**
     * Retrieves representation of an instance of view_shipfitmodule.restservices.RSView_shipfitmodule
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{json}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@PathParam("json") String jsonstring) {
        try {
            BLview_shipfitmodule blview_shipfitmodule = new BLview_shipfitmodule();
            ArrayList view_shipfitmodules = blview_shipfitmodule.getAll();
            JSONArray jsonview_shipfitmodules = JSONView_shipfitmodule.toJSONArray(view_shipfitmodules);
            return jsonview_shipfitmodules.toJSONString();
        }
        catch(DBException e) {
            return "{ \"status\": \"error\"}";
        }
    }

    /**
     * Retrieves representation of an instance of view_shipfitmodule.restservices.RSView_shipfitmodule
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        String result = "";
        BLview_shipfitmodule blview_shipfitmodule = new BLview_shipfitmodule();
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject)parser.parse(jsonstring);
            JSONObject jsonoperation = (JSONObject)json.get("operation");
            byte operationtype = JSONConversion.getbyte(jsonoperation, "type");
            byte operation = JSONConversion.getbyte(jsonoperation, "operation");
            IView_shipfitmodule view_shipfitmodule;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    switch(operation) {
                        case IView_shipfitmoduleOperation.SELECT_ALL:
                            result = JSONView_shipfitmodule.toJSONArray(blview_shipfitmodule.getView_shipfitmodules()).toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
                        case IView_shipfitmoduleOperation.SELECT4Shipfit:
                            String username = JSONConversion.getString(json, "username");
                            String shipname = JSONConversion.getString(json, "shipname");
                            result = JSONView_shipfitmodule.toJSONArray(blview_shipfitmodule.getview_shipfitmodules(username, shipname)).toJSONString();
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
     * PUT method for updating or creating an instance of RSView_shipfitmodule
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("text/html")
    public void put(String content) {
    }
}
