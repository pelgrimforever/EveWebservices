/*
 * RSView_tradecombined.java
 *
 * Generated on 16.11.2021 15:46
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
import eve.interfaces.logicview.IView_tradecombined;
import eve.interfaces.servlet.IView_tradecombinedOperation;
import eve.logicview.View_tradecombined;
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
@Path("rsview_tradecombined")
public class RSView_tradecombined {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of RSView_tradecombined
     */
    public RSView_tradecombined() {
    }

    /**
     * Retrieves representation of an instance of view_tradecombined.restservices.RSView_tradecombined
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{json}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@PathParam("json") String jsonstring) {
        try {
            BLview_tradecombined blview_tradecombined = new BLview_tradecombined();
            ArrayList view_tradecombineds = blview_tradecombined.getAll();
            JSONArray jsonview_tradecombineds = JSONView_tradecombined.toJSONArray(view_tradecombineds);
            return jsonview_tradecombineds.toJSONString();
        }
        catch(DBException e) {
            return "{ \"status\": \"error\"}";
        }
    }

    /**
     * Retrieves representation of an instance of view_tradecombined.restservices.RSView_tradecombined
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        String result = "";
        BLview_tradecombined blview_tradecombined = new BLview_tradecombined();
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject)parser.parse(jsonstring);
            JSONObject jsonoperation = (JSONObject)json.get("operation");
            byte operationtype = JSONConversion.getbyte(jsonoperation, "type");
            byte operation = JSONConversion.getbyte(jsonoperation, "operation");
            IView_tradecombined view_tradecombined;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    switch(operation) {
                        case IView_tradecombinedOperation.SELECT_ALL:
                            result = JSONView_tradecombined.toJSONArray(blview_tradecombined.getView_tradecombineds()).toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
                        case IView_tradecombinedOperation.SELECT_ALL_STARTSYSTEM:
                            eve.entity.pk.SystemPK systemPK = (eve.entity.pk.SystemPK)JSONSystem.toSystemPK((JSONObject)json.get("systempk"));
                            result = JSONView_tradecombined.toJSONArray(blview_tradecombined.getView_tradecombined_Startsystem(systemPK)).toJSONString();
                            break;
                        case IView_tradecombinedOperation.SELECT4TRADECOMBINED:
                            TradecombinedPK tradecombinedPK = (TradecombinedPK)JSONTradecombined.toTradecombinedPK((JSONObject)json.get("tradecombinedpk"));
                            View_tradecombined viewtradecombined = blview_tradecombined.getView_tradecombined(tradecombinedPK);
                            if(viewtradecombined!=null) {
                                result = JSONView_tradecombined.toJSON(viewtradecombined).toJSONString();
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
     * PUT method for updating or creating an instance of RSView_tradecombined
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("text/html")
    public void put(String content) {
    }
}

