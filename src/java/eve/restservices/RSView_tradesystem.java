/*
 * RSView_tradesystem.java
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
import eve.interfaces.logicview.IView_tradesystem;
import eve.interfaces.servlet.IView_tradesystemOperation;
import eve.logicview.View_tradesystem;
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
@Path("rsview_tradesystem")
public class RSView_tradesystem {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of RSView_tradesystem
     */
    public RSView_tradesystem() {
    }

    /**
     * Retrieves representation of an instance of view_tradesystem.restservices.RSView_tradesystem
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{json}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@PathParam("json") String jsonstring) {
        try {
            BLview_tradesystem blview_tradesystem = new BLview_tradesystem();
            ArrayList view_tradesystems = blview_tradesystem.getAll();
            JSONArray jsonview_tradesystems = JSONView_tradesystem.toJSONArray(view_tradesystems);
            return jsonview_tradesystems.toJSONString();
        }
        catch(DBException e) {
            return "{ \"status\": \"error\"}";
        }
    }

    /**
     * Retrieves representation of an instance of view_tradesystem.restservices.RSView_tradesystem
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        String result = "";
        BLview_tradesystem blview_tradesystem = new BLview_tradesystem();
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject)parser.parse(jsonstring);
            JSONObject jsonoperation = (JSONObject)json.get("operation");
            byte operationtype = JSONConversion.getbyte(jsonoperation, "type");
            byte operation = JSONConversion.getbyte(jsonoperation, "operation");
            IView_tradesystem view_tradesystem;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    switch(operation) {
                        case IView_tradesystemOperation.SELECT_ALL:
                            result = JSONView_tradesystem.toJSONArray(blview_tradesystem.getView_tradesystems()).toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
                        case IView_tradesystemOperation.SELECT_ALL_STARTSYSTEM:
                            eve.entity.pk.SystemPK systemPK = (eve.entity.pk.SystemPK)JSONSystem.toSystemPK((JSONObject)json.get("systempk"));
                            result = JSONView_tradesystem.toJSONArray(blview_tradesystem.getView_tradesystem_Startsystem(systemPK)).toJSONString();
                            break;
                        case IView_tradesystemOperation.SELECT4SELLBUYSYSTEM:
                            eve.entity.pk.SystemPK sell_systemPK = (eve.entity.pk.SystemPK)JSONSystem.toSystemPK((JSONObject)json.get("sell_systempk"));
                            eve.entity.pk.SystemPK buy_systemPK = (eve.entity.pk.SystemPK)JSONSystem.toSystemPK((JSONObject)json.get("buy_systempk"));
                            View_tradesystem viewtradesystem = blview_tradesystem.getView_tradesystem(sell_systemPK, buy_systemPK);
                            if(viewtradesystem!=null) {
                                result = JSONView_tradesystem.toJSON(viewtradesystem).toJSONString();
                            } else {
                                result = "";
                            }
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
     * PUT method for updating or creating an instance of RSView_tradesystem
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("text/html")
    public void put(String content) {
    }
}

