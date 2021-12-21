/*
 * RSView_evetype_order_history.java
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
import eve.interfaces.logicview.IView_evetype_order_history;
import eve.interfaces.servlet.IView_evetype_order_historyOperation;
import eve.logicview.View_evetype_order_history;
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
@Path("rsview_evetype_order_history")
public class RSView_evetype_order_history {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of RSView_evetype_order_history
     */
    public RSView_evetype_order_history() {
    }

    /**
     * Retrieves representation of an instance of view_evetype_order_history.restservices.RSView_evetype_order_history
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{json}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@PathParam("json") String jsonstring) {
        try {
            BLview_evetype_order_history blview_evetype_order_history = new BLview_evetype_order_history();
            ArrayList view_evetype_order_historys = blview_evetype_order_history.getAll();
            JSONArray jsonview_evetype_order_historys = JSONView_evetype_order_history.toJSONArray(view_evetype_order_historys);
            return jsonview_evetype_order_historys.toJSONString();
        }
        catch(DBException e) {
            return "{ \"status\": \"error\"}";
        }
    }

    /**
     * Retrieves representation of an instance of view_evetype_order_history.restservices.RSView_evetype_order_history
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        String result = "";
        BLview_evetype_order_history blview_evetype_order_history = new BLview_evetype_order_history();
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject)parser.parse(jsonstring);
            JSONObject jsonoperation = (JSONObject)json.get("operation");
            byte operationtype = JSONConversion.getbyte(jsonoperation, "type");
            byte operation = JSONConversion.getbyte(jsonoperation, "operation");
            IView_evetype_order_history view_evetype_order_history;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    switch(operation) {
                        case IView_evetype_order_historyOperation.SELECT_ALL:
                            result = JSONView_evetype_order_history.toJSONArray(blview_evetype_order_history.getView_evetype_order_historys()).toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
                        case IView_evetype_order_historyOperation.SELECT_EVETYPE:
                            EvetypePK evetypePK = (EvetypePK)JSONEvetype.toEvetypePK((JSONObject)json.get("evetypepk"));
                            result = JSONView_evetype_order_history.toJSONArray(blview_evetype_order_history.getView_evetype_order_historys(evetypePK)).toJSONString();
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
     * PUT method for updating or creating an instance of RSView_evetype_order_history
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("text/html")
    public void put(String content) {
    }
}

