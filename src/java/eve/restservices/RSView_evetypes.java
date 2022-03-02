/*
 * RSView_evetypes.java
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
import eve.interfaces.logicview.IView_evetypes;
import eve.interfaces.servlet.IView_evetypesOperation;
import eve.logicview.View_evetypes;
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
@Path("rsview_evetypes")
public class RSView_evetypes {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of RSView_evetypes
     */
    public RSView_evetypes() {
    }

    /**
     * Retrieves representation of an instance of view_evetypes.restservices.RSView_evetypes
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{json}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@PathParam("json") String jsonstring) {
        try {
            BLview_evetypes blview_evetypes = new BLview_evetypes();
            ArrayList view_evetypess = blview_evetypes.getAll();
            JSONArray jsonview_evetypess = JSONView_evetypes.toJSONArray(view_evetypess);
            return jsonview_evetypess.toJSONString();
        }
        catch(DBException e) {
            return "{ \"status\": \"error\"}";
        }
    }

    /**
     * Retrieves representation of an instance of view_evetypes.restservices.RSView_evetypes
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        String result = "";
        BLview_evetypes blview_evetypes = new BLview_evetypes();
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject)parser.parse(jsonstring);
            JSONObject jsonoperation = (JSONObject)json.get("operation");
            byte operationtype = JSONConversion.getbyte(jsonoperation, "type");
            byte operation = JSONConversion.getbyte(jsonoperation, "operation");
            IView_evetypes view_evetypes;
//Security parameters
            boolean loggedin = RSsecurity.check(json);
            blview_evetypes.setAuthenticated(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    switch(operation) {
                        case IView_evetypesOperation.SELECT_ALL:
                            result = JSONView_evetypes.toJSONArray(blview_evetypes.getView_evetypess()).toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                case DataServlet.OPERATIONTYPE_SECURESELECT:
                    switch(operation) {
                        case IView_evetypesOperation.SELECT_ALL:
                            result = JSONView_evetypes.toJSONArray(blview_evetypes.getView_evetypess()).toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
                        case IView_evetypesOperation.SELECT_SHIPS:
                            result = JSONView_evetypes.toJSONArray(blview_evetypes.getShips()).toJSONString();
                            break;
                        case IView_evetypesOperation.SELECT_MODULES:
                            result = JSONView_evetypes.toJSONArray(blview_evetypes.getModules()).toJSONString();
                            break;
                        case IView_evetypesOperation.SELECT_CHARGES:
                            result = JSONView_evetypes.toJSONArray(blview_evetypes.getCharges()).toJSONString();
                            break;
                        case IView_evetypesOperation.SELECT_DRONES:
                            result = JSONView_evetypes.toJSONArray(blview_evetypes.getDrones()).toJSONString();
                            break;
                        case IView_evetypesOperation.SELECT_DEPLOYABLES:
                            result = JSONView_evetypes.toJSONArray(blview_evetypes.getDeployables()).toJSONString();
                            break;
                        case IView_evetypesOperation.SELECT_MINERALS:
                            result = JSONView_evetypes.toJSONArray(blview_evetypes.getMinerals()).toJSONString();
                            break;
                        case IView_evetypesOperation.SELECT_SALVAGED:
                            result = JSONView_evetypes.toJSONArray(blview_evetypes.getSalvagedmaterials()).toJSONString();
                            break;
                        case IView_evetypesOperation.SELECT_BLEUPRINT:
                            String searchstring = JSONConversion.getString(json, "searchstring");
                            result = JSONView_evetypes.toJSONArray(blview_evetypes.getBlueprints(searchstring)).toJSONString();
                            break;
                        case IView_evetypesOperation.SELECT_BLEUPRINTRESULT:
                            View_evetypes viewevetype = JSONView_evetypes.toView_evetypes((JSONObject)json.get("viewblueprint"));
                            result = JSONView_evetypes.toJSON(blview_evetypes.getBlueprintresult(viewevetype)).toJSONString();
                            break;
                        case IView_evetypesOperation.SELECT_COMMODITY:
                            String searchstring2 = JSONConversion.getString(json, "searchstring");
                            result = JSONView_evetypes.toJSONArray(blview_evetypes.getCommodities(searchstring2)).toJSONString();
                            break;
                        case IView_evetypesOperation.SELECT_MATERIAL:
                            result = JSONView_evetypes.toJSONArray(blview_evetypes.getMaterials()).toJSONString();
                            break;
                        case IView_evetypesOperation.SELECT_PLANETARYCOMMODITY:
                            result = JSONView_evetypes.toJSONArray(blview_evetypes.getPlanetarycommodities()).toJSONString();
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
     * PUT method for updating or creating an instance of RSView_evetypes
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("text/html")
    public void put(String content) {
    }
}

