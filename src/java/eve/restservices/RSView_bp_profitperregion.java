/*
 * RSView_bp_profitperregion.java
 *
 * Generated on 22.1.2022 10:57
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
import eve.interfaces.logicview.IView_bp_profitperregion;
import eve.interfaces.servlet.IView_bp_profitperregionOperation;
import eve.logicview.View_bp_profitperregion;
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
@Path("rsview_bp_profitperregion")
public class RSView_bp_profitperregion {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of RSView_bp_profitperregion
     */
    public RSView_bp_profitperregion() {
    }

    /**
     * Retrieves representation of an instance of view_bp_profitperregion.restservices.RSView_bp_profitperregion
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{json}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@PathParam("json") String jsonstring) {
        try {
            BLview_bp_profitperregion blview_bp_profitperregion = new BLview_bp_profitperregion();
            ArrayList view_bp_profitperregions = blview_bp_profitperregion.getAll();
            JSONArray jsonview_bp_profitperregions = JSONView_bp_profitperregion.toJSONArray(view_bp_profitperregions);
            return jsonview_bp_profitperregions.toJSONString();
        }
        catch(DBException e) {
            return "{ \"status\": \"error\"}";
        }
    }

    /**
     * Retrieves representation of an instance of view_bp_profitperregion.restservices.RSView_bp_profitperregion
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        String result = "";
        BLview_bp_profitperregion blview_bp_profitperregion = new BLview_bp_profitperregion();
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject)parser.parse(jsonstring);
            JSONObject jsonoperation = (JSONObject)json.get("operation");
            byte operationtype = JSONConversion.getbyte(jsonoperation, "type");
            byte operation = JSONConversion.getbyte(jsonoperation, "operation");
            IView_bp_profitperregion view_bp_profitperregion;
//Security parameters
            boolean loggedin = RSsecurity.check(json);
            blview_bp_profitperregion.setAuthenticated(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    switch(operation) {
                        case IView_bp_profitperregionOperation.SELECT_ALL:
                            result = JSONView_bp_profitperregion.toJSONArray(blview_bp_profitperregion.getView_bp_profitperregions()).toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                case DataServlet.OPERATIONTYPE_SECURESELECT:
                    switch(operation) {
                        case IView_bp_profitperregionOperation.SELECT_ALL:
                            result = JSONView_bp_profitperregion.toJSONArray(blview_bp_profitperregion.getView_bp_profitperregions()).toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
                        case IView_bp_profitperregionOperation.SELECT_LASTMONTH:
                            result = JSONView_bp_profitperregion.toJSONArray(blview_bp_profitperregion.getView_bp_profitperregions4lastmonth()).toJSONString();
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
     * PUT method for updating or creating an instance of RSView_bp_profitperregion
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("text/html")
    public void put(String content) {
    }
}
