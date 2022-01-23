/*
 * RSView_materialinputavg.java
 *
 * Generated on 23.0.2022 17:52
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
import eve.interfaces.logicview.IView_materialinputavg;
import eve.interfaces.servlet.IView_materialinputavgOperation;
import eve.logicview.View_materialinputavg;
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
@Path("rsview_materialinputavg")
public class RSView_materialinputavg {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of RSView_materialinputavg
     */
    public RSView_materialinputavg() {
    }

    /**
     * Retrieves representation of an instance of view_materialinputavg.restservices.RSView_materialinputavg
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{json}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@PathParam("json") String jsonstring) {
        try {
            BLview_materialinputavg blview_materialinputavg = new BLview_materialinputavg();
            ArrayList view_materialinputavgs = blview_materialinputavg.getAll();
            JSONArray jsonview_materialinputavgs = JSONView_materialinputavg.toJSONArray(view_materialinputavgs);
            return jsonview_materialinputavgs.toJSONString();
        }
        catch(DBException e) {
            return "{ \"status\": \"error\"}";
        }
    }

    /**
     * Retrieves representation of an instance of view_materialinputavg.restservices.RSView_materialinputavg
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        String result = "";
        BLview_materialinputavg blview_materialinputavg = new BLview_materialinputavg();
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject)parser.parse(jsonstring);
            JSONObject jsonoperation = (JSONObject)json.get("operation");
            byte operationtype = JSONConversion.getbyte(jsonoperation, "type");
            byte operation = JSONConversion.getbyte(jsonoperation, "operation");
            IView_materialinputavg view_materialinputavg;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    switch(operation) {
                        case IView_materialinputavgOperation.SELECT_ALL:
                            result = JSONView_materialinputavg.toJSONArray(blview_materialinputavg.getView_materialinputavgs()).toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
                        case IView_materialinputavgOperation.SELECT_4USER:
                            String username = JSONConversion.getString(json, "username");
                            result = JSONView_materialinputavg.toJSONArray(blview_materialinputavg.getView_materialinputavgs(username)).toJSONString();
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
     * PUT method for updating or creating an instance of RSView_materialinputavg
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("text/html")
    public void put(String content) {
    }
}

