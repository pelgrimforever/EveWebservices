/*
 * RSShipfit.java
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
import eve.interfaces.searchentity.IShipfitsearch;
import eve.interfaces.servlet.IShipfitOperation;
import eve.logicentity.Shipfit;
import eve.searchentity.Shipfitsearch;
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
@Path("rsshipfit")
public class RSShipfit {

    /**
     * Creates a new instance of HelloWorld
     */
    public RSShipfit() {
    }

    /**
     * Retrieves representation of an instance of shipfit.restservices.RSShipfit
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{json}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@PathParam("json") String jsonstring) {
        try {
            BLshipfit blshipfit = new BLshipfit();
            ArrayList shipfits = blshipfit.getAll();
            JSONArray jsonshipfits = JSONShipfit.toJSONArray(shipfits);
            return jsonshipfits.toJSONString();
        }
        catch(DBException e) {
            return "{ \"status\": \"error\"}";
        }
    }

    /**
     * Retrieves representation of an instance of shipfit.restservices.RSShipfit
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        String result = "";
        BLshipfit blshipfit = new BLshipfit();
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject)parser.parse(jsonstring);
            JSONObject jsonoperation = (JSONObject)json.get("operation");
            byte operationtype = JSONConversion.getbyte(jsonoperation, "type");
            byte operation = JSONConversion.getbyte(jsonoperation, "operation");
            IShipfitPK shipfitPK;
            IShipfit shipfit;
//Security parameters
            boolean loggedin = RSsecurity.check(json);
            blshipfit.setAuthenticated(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    switch(operation) {
                        case IShipfitOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blshipfit.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IShipfitOperation.SELECT_ALL:
                            result = JSONShipfit.toJSONArray(blshipfit.getShipfits()).toJSONString();
                            break;
                        case IShipfitOperation.SELECT_SHIPFIT:
                            shipfitPK = (IShipfitPK)JSONShipfit.toShipfitPK((JSONObject)json.get("shipfitpk"));
                            result = JSONShipfit.toJSON(blshipfit.getShipfit(shipfitPK)).toJSONString();
                            break;
                        case IShipfitOperation.SELECT_Evetype:
                            IEvetypePK evetypePK = (IEvetypePK)JSONEvetype.toEvetypePK((JSONObject)json.get("evetypepk"));
                            result = JSONShipfit.toJSONArray(blshipfit.getShipfits4evetype(evetypePK)).toJSONString();
                            break;
                        case IShipfitOperation.SELECT_Shipfitmodule:
                            IShipfitmodulePK shipfitmodulePK = (IShipfitmodulePK)JSONShipfitmodule.toShipfitmodulePK((JSONObject)json.get("shipfitmodulepk"));
                            result = JSONShipfit.toJSON(blshipfit.getShipfitmodule(shipfitmodulePK)).toJSONString();
                            break;
                        case IShipfitOperation.SELECT_Shipfitorder:
                            IShipfitorderPK shipfitorderPK = (IShipfitorderPK)JSONShipfitorder.toShipfitorderPK((JSONObject)json.get("shipfitorderpk"));
                            result = JSONShipfit.toJSON(blshipfit.getShipfitorder(shipfitorderPK)).toJSONString();
                            break;
                        case IShipfitOperation.SELECT_SEARCH:
                            IShipfitsearch search = (IShipfitsearch)JSONShipfit.toShipfitsearch((JSONObject)json.get("search"));
                            result = JSONShipfit.toJSONArray(blshipfit.search(search)).toJSONString();
                            break;
                        case IShipfitOperation.SELECT_SEARCHCOUNT:
                            IShipfitsearch shipfitsearch = (IShipfitsearch)JSONShipfit.toShipfitsearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blshipfit.searchcount(shipfitsearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(operation) {
                        case IShipfitOperation.INSERT_SHIPFIT:
                            shipfit = (IShipfit)JSONShipfit.toShipfit((JSONObject)json.get("shipfit"));
                            blshipfit.insertShipfit(shipfit);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(operation) {
                        case IShipfitOperation.UPDATE_SHIPFIT:
                            JSONObject jsonshipfit = (JSONObject)json.get("shipfit");
                            shipfitPK = JSONShipfit.toShipfitPK((JSONObject)jsonshipfit.get("PK"));
                            shipfit = blshipfit.getShipfit(shipfitPK);
                            JSONShipfit.updateShipfit(shipfit, jsonshipfit);
                            blshipfit.updateShipfit(shipfit);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(operation) {
                        case IShipfitOperation.DELETE_SHIPFIT:
                            shipfit = (IShipfit)JSONShipfit.toShipfit((JSONObject)json.get("shipfit"));
                            blshipfit.deleteShipfit(shipfit);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECURESELECT:
                    switch(operation) {
                        case IShipfitOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blshipfit.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IShipfitOperation.SELECT_ALL:
                            result = JSONShipfit.toJSONArray(blshipfit.getShipfits()).toJSONString();
                            break;
                        case IShipfitOperation.SELECT_SHIPFIT:
                            shipfitPK = (IShipfitPK)JSONShipfit.toShipfitPK((JSONObject)json.get("shipfitpk"));
                            result = JSONShipfit.toJSON(blshipfit.getShipfit(shipfitPK)).toJSONString();
                            break;
                        case IShipfitOperation.SELECT_Evetype:
                            IEvetypePK evetypePK = (IEvetypePK)JSONEvetype.toEvetypePK((JSONObject)json.get("evetypepk"));
                            result = JSONShipfit.toJSONArray(blshipfit.getShipfits4evetype(evetypePK)).toJSONString();
                            break;
                        case IShipfitOperation.SELECT_Shipfitmodule:
                            IShipfitmodulePK shipfitmodulePK = (IShipfitmodulePK)JSONShipfitmodule.toShipfitmodulePK((JSONObject)json.get("shipfitmodulepk"));
                            result = JSONShipfit.toJSON(blshipfit.getShipfitmodule(shipfitmodulePK)).toJSONString();
                            break;
                        case IShipfitOperation.SELECT_Shipfitorder:
                            IShipfitorderPK shipfitorderPK = (IShipfitorderPK)JSONShipfitorder.toShipfitorderPK((JSONObject)json.get("shipfitorderpk"));
                            result = JSONShipfit.toJSON(blshipfit.getShipfitorder(shipfitorderPK)).toJSONString();
                            break;
                        case IShipfitOperation.SELECT_SEARCH:
                            IShipfitsearch search = (IShipfitsearch)JSONShipfit.toShipfitsearch((JSONObject)json.get("search"));
                            result = JSONShipfit.toJSONArray(blshipfit.search(search)).toJSONString();
                            break;
                        case IShipfitOperation.SELECT_SEARCHCOUNT:
                            IShipfitsearch shipfitsearch = (IShipfitsearch)JSONShipfit.toShipfitsearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blshipfit.searchcount(shipfitsearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
                        case IShipfitOperation.SELECT_ADDORDERShipfit:
                            shipfitPK = (IShipfitPK)JSONShipfit.toShipfitPK((JSONObject)json.get("shipfitpk"));
                            blshipfit.addOrder(shipfitPK);
                            break;
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREINSERT:
                    switch(operation) {
                        case IShipfitOperation.INSERT_SHIPFIT:
                            shipfit = (IShipfit)JSONShipfit.toShipfit((JSONObject)json.get("shipfit"));
                            blshipfit.secureinsertShipfit(shipfit);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREUPDATE:
                    switch(operation) {
                        case IShipfitOperation.UPDATE_SHIPFIT:
                            JSONObject jsonshipfit = (JSONObject)json.get("shipfit");
                            shipfitPK = JSONShipfit.toShipfitPK((JSONObject)jsonshipfit.get("PK"));
                            shipfit = blshipfit.getShipfit(shipfitPK);
                            JSONShipfit.updateShipfit(shipfit, jsonshipfit);
                            blshipfit.secureupdateShipfit(shipfit);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREDELETE:
                    switch(operation) {
                        case IShipfitOperation.DELETE_SHIPFIT:
                            shipfit = (IShipfit)JSONShipfit.toShipfit((JSONObject)json.get("shipfit"));
                            blshipfit.securedeleteShipfit(shipfit);
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
     * PUT method for updating or creating an instance of RSShipfit
     * @param content representation for the resource
     */
    @PUT
    @Consumes("text/html")
    public void put(String content) {
    }
}

