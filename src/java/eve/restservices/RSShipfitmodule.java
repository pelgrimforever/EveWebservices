/*
 * RSShipfitmodule.java
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
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.searchentity.IShipfitmodulesearch;
import eve.interfaces.servlet.IShipfitmoduleOperation;
import eve.logicentity.Shipfitmodule;
import eve.searchentity.Shipfitmodulesearch;
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
@Path("rsshipfitmodule")
public class RSShipfitmodule {

    /**
     * Creates a new instance of HelloWorld
     */
    public RSShipfitmodule() {
    }

    /**
     * Retrieves representation of an instance of shipfitmodule.restservices.RSShipfitmodule
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{json}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@PathParam("json") String jsonstring) {
        try {
            BLshipfitmodule blshipfitmodule = new BLshipfitmodule();
            ArrayList shipfitmodules = blshipfitmodule.getAll();
            JSONArray jsonshipfitmodules = JSONShipfitmodule.toJSONArray(shipfitmodules);
            return jsonshipfitmodules.toJSONString();
        }
        catch(DBException e) {
            return "{ \"status\": \"error\"}";
        }
    }

    /**
     * Retrieves representation of an instance of shipfitmodule.restservices.RSShipfitmodule
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        String result = "";
        BLshipfitmodule blshipfitmodule = new BLshipfitmodule();
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject)parser.parse(jsonstring);
            JSONObject jsonoperation = (JSONObject)json.get("operation");
            byte operationtype = JSONConversion.getbyte(jsonoperation, "type");
            byte operation = JSONConversion.getbyte(jsonoperation, "operation");
            IShipfitmodulePK shipfitmodulePK;
            IShipfitmodule shipfitmodule;
//Security parameters
            boolean loggedin = RSsecurity.check(json);
            blshipfitmodule.setAuthenticated(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    switch(operation) {
                        case IShipfitmoduleOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blshipfitmodule.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IShipfitmoduleOperation.SELECT_ALL:
                            result = JSONShipfitmodule.toJSONArray(blshipfitmodule.getShipfitmodules()).toJSONString();
                            break;
                        case IShipfitmoduleOperation.SELECT_SHIPFITMODULE:
                            shipfitmodulePK = (IShipfitmodulePK)JSONShipfitmodule.toShipfitmodulePK((JSONObject)json.get("shipfitmodulepk"));
                            result = JSONShipfitmodule.toJSON(blshipfitmodule.getShipfitmodule(shipfitmodulePK)).toJSONString();
                            break;
                        case IShipfitmoduleOperation.SELECT_Evetype:
                            IEvetypePK evetypePK = (IEvetypePK)JSONEvetype.toEvetypePK((JSONObject)json.get("evetypepk"));
                            result = JSONShipfitmodule.toJSONArray(blshipfitmodule.getShipfitmodules4evetype(evetypePK)).toJSONString();
                            break;
                        case IShipfitmoduleOperation.SELECT_Shipfit:
                            IShipfitPK shipfitPK = (IShipfitPK)JSONShipfit.toShipfitPK((JSONObject)json.get("shipfitpk"));
                            result = JSONShipfitmodule.toJSONArray(blshipfitmodule.getShipfitmodules4shipfit(shipfitPK)).toJSONString();
                            break;
                        case IShipfitmoduleOperation.SELECT_SEARCH:
                            IShipfitmodulesearch search = (IShipfitmodulesearch)JSONShipfitmodule.toShipfitmodulesearch((JSONObject)json.get("search"));
                            result = JSONShipfitmodule.toJSONArray(blshipfitmodule.search(search)).toJSONString();
                            break;
                        case IShipfitmoduleOperation.SELECT_SEARCHCOUNT:
                            IShipfitmodulesearch shipfitmodulesearch = (IShipfitmodulesearch)JSONShipfitmodule.toShipfitmodulesearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blshipfitmodule.searchcount(shipfitmodulesearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(operation) {
                        case IShipfitmoduleOperation.INSERT_SHIPFITMODULE:
                            shipfitmodule = (IShipfitmodule)JSONShipfitmodule.toShipfitmodule((JSONObject)json.get("shipfitmodule"));
                            blshipfitmodule.insertShipfitmodule(shipfitmodule);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(operation) {
                        case IShipfitmoduleOperation.UPDATE_SHIPFITMODULE:
                            JSONObject jsonshipfitmodule = (JSONObject)json.get("shipfitmodule");
                            shipfitmodulePK = JSONShipfitmodule.toShipfitmodulePK((JSONObject)jsonshipfitmodule.get("PK"));
                            shipfitmodule = blshipfitmodule.getShipfitmodule(shipfitmodulePK);
                            JSONShipfitmodule.updateShipfitmodule(shipfitmodule, jsonshipfitmodule);
                            blshipfitmodule.updateShipfitmodule(shipfitmodule);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(operation) {
                        case IShipfitmoduleOperation.DELETE_SHIPFITMODULE:
                            shipfitmodule = (IShipfitmodule)JSONShipfitmodule.toShipfitmodule((JSONObject)json.get("shipfitmodule"));
                            blshipfitmodule.deleteShipfitmodule(shipfitmodule);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECURESELECT:
                    switch(operation) {
                        case IShipfitmoduleOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blshipfitmodule.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IShipfitmoduleOperation.SELECT_ALL:
                            result = JSONShipfitmodule.toJSONArray(blshipfitmodule.getShipfitmodules()).toJSONString();
                            break;
                        case IShipfitmoduleOperation.SELECT_SHIPFITMODULE:
                            shipfitmodulePK = (IShipfitmodulePK)JSONShipfitmodule.toShipfitmodulePK((JSONObject)json.get("shipfitmodulepk"));
                            result = JSONShipfitmodule.toJSON(blshipfitmodule.getShipfitmodule(shipfitmodulePK)).toJSONString();
                            break;
                        case IShipfitmoduleOperation.SELECT_Evetype:
                            IEvetypePK evetypePK = (IEvetypePK)JSONEvetype.toEvetypePK((JSONObject)json.get("evetypepk"));
                            result = JSONShipfitmodule.toJSONArray(blshipfitmodule.getShipfitmodules4evetype(evetypePK)).toJSONString();
                            break;
                        case IShipfitmoduleOperation.SELECT_Shipfit:
                            IShipfitPK shipfitPK = (IShipfitPK)JSONShipfit.toShipfitPK((JSONObject)json.get("shipfitpk"));
                            result = JSONShipfitmodule.toJSONArray(blshipfitmodule.getShipfitmodules4shipfit(shipfitPK)).toJSONString();
                            break;
                        case IShipfitmoduleOperation.SELECT_SEARCH:
                            IShipfitmodulesearch search = (IShipfitmodulesearch)JSONShipfitmodule.toShipfitmodulesearch((JSONObject)json.get("search"));
                            result = JSONShipfitmodule.toJSONArray(blshipfitmodule.search(search)).toJSONString();
                            break;
                        case IShipfitmoduleOperation.SELECT_SEARCHCOUNT:
                            IShipfitmodulesearch shipfitmodulesearch = (IShipfitmodulesearch)JSONShipfitmodule.toShipfitmodulesearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blshipfitmodule.searchcount(shipfitmodulesearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREINSERT:
                    switch(operation) {
                        case IShipfitmoduleOperation.INSERT_SHIPFITMODULE:
                            shipfitmodule = (IShipfitmodule)JSONShipfitmodule.toShipfitmodule((JSONObject)json.get("shipfitmodule"));
                            blshipfitmodule.secureinsertShipfitmodule(shipfitmodule);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREUPDATE:
                    switch(operation) {
                        case IShipfitmoduleOperation.UPDATE_SHIPFITMODULE:
                            JSONObject jsonshipfitmodule = (JSONObject)json.get("shipfitmodule");
                            shipfitmodulePK = JSONShipfitmodule.toShipfitmodulePK((JSONObject)jsonshipfitmodule.get("PK"));
                            shipfitmodule = blshipfitmodule.getShipfitmodule(shipfitmodulePK);
                            JSONShipfitmodule.updateShipfitmodule(shipfitmodule, jsonshipfitmodule);
                            blshipfitmodule.secureupdateShipfitmodule(shipfitmodule);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREDELETE:
                    switch(operation) {
                        case IShipfitmoduleOperation.DELETE_SHIPFITMODULE:
                            shipfitmodule = (IShipfitmodule)JSONShipfitmodule.toShipfitmodule((JSONObject)json.get("shipfitmodule"));
                            blshipfitmodule.securedeleteShipfitmodule(shipfitmodule);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
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
     * PUT method for updating or creating an instance of RSShipfitmodule
     * @param content representation for the resource
     */
    @PUT
    @Consumes("text/html")
    public void put(String content) {
    }
}

