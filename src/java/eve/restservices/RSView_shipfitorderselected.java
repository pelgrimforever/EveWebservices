/*
 * RSView_shipfitorderselected.java
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
import eve.interfaces.logicview.IView_shipfitorderselected;
import eve.interfaces.servlet.IView_shipfitorderselectedOperation;
import eve.logicview.View_shipfitorderselected;
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
@Path("rsview_shipfitorderselected")
public class RSView_shipfitorderselected {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of RSView_shipfitorderselected
     */
    public RSView_shipfitorderselected() {
    }

    /**
     * Retrieves representation of an instance of view_shipfitorderselected.restservices.RSView_shipfitorderselected
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{json}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@PathParam("json") String jsonstring) {
        try {
            BLview_shipfitorderselected blview_shipfitorderselected = new BLview_shipfitorderselected();
            ArrayList view_shipfitorderselecteds = blview_shipfitorderselected.getAll();
            JSONArray jsonview_shipfitorderselecteds = JSONView_shipfitorderselected.toJSONArray(view_shipfitorderselecteds);
            return jsonview_shipfitorderselecteds.toJSONString();
        }
        catch(DBException e) {
            return "{ \"status\": \"error\"}";
        }
    }

    /**
     * Retrieves representation of an instance of view_shipfitorderselected.restservices.RSView_shipfitorderselected
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        String result = "";
        BLview_shipfitorderselected blview_shipfitorderselected = new BLview_shipfitorderselected();
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject)parser.parse(jsonstring);
            JSONObject jsonoperation = (JSONObject)json.get("operation");
            byte operationtype = JSONConversion.getbyte(jsonoperation, "type");
            byte operation = JSONConversion.getbyte(jsonoperation, "operation");
            IView_shipfitorderselected view_shipfitorderselected;
//Security parameters
            boolean loggedin = RSsecurity.check(json);
            blview_shipfitorderselected.setAuthenticated(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    switch(operation) {
                        case IView_shipfitorderselectedOperation.SELECT_ALL:
                            result = JSONView_shipfitorderselected.toJSONArray(blview_shipfitorderselected.getView_shipfitorderselecteds()).toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                case DataServlet.OPERATIONTYPE_SECURESELECT:
                    switch(operation) {
                        case IView_shipfitorderselectedOperation.SELECT_ALL:
                            result = JSONView_shipfitorderselected.toJSONArray(blview_shipfitorderselected.getView_shipfitorderselecteds()).toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
                        case IView_shipfitorderselectedOperation.SELECT_4USER:
                            String username = JSONConversion.getString(json, "username");
                            result = JSONView_shipfitorderselected.toJSONArray(blview_shipfitorderselected.getView_shipfitorderselecteds(username)).toJSONString();
                            break;
                        case IView_shipfitorderselectedOperation.SELECT_4USERSYSTEM:
                            String username2 = JSONConversion.getString(json, "username");
                            long systemid = JSONConversion.getlong(json, "systemid");
                            result = JSONView_shipfitorderselected.toJSONArray(blview_shipfitorderselected.getView_shipfitorderselecteds(username2, systemid)).toJSONString();
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
     * PUT method for updating or creating an instance of RSView_shipfitorderselected
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("text/html")
    public void put(String content) {
    }
}

