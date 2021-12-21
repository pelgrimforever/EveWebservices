/*
 * RSShipfitorder.java
 *
 * Generated on 20.11.2021 17:22
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
import eve.interfaces.searchentity.IShipfitordersearch;
import eve.interfaces.servlet.IShipfitorderOperation;
import eve.logicentity.Shipfitorder;
import eve.searchentity.Shipfitordersearch;
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
@Path("rsshipfitorder")
public class RSShipfitorder {

    /**
     * Creates a new instance of HelloWorld
     */
    public RSShipfitorder() {
    }

    /**
     * Retrieves representation of an instance of shipfitorder.restservices.RSShipfitorder
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{json}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@PathParam("json") String jsonstring) {
        try {
            BLshipfitorder blshipfitorder = new BLshipfitorder();
            ArrayList shipfitorders = blshipfitorder.getAll();
            JSONArray jsonshipfitorders = JSONShipfitorder.toJSONArray(shipfitorders);
            return jsonshipfitorders.toJSONString();
        }
        catch(DBException e) {
            return "{ \"status\": \"error\"}";
        }
    }

    /**
     * Retrieves representation of an instance of shipfitorder.restservices.RSShipfitorder
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        String result = "";
        BLshipfitorder blshipfitorder = new BLshipfitorder();
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject)parser.parse(jsonstring);
            JSONObject jsonoperation = (JSONObject)json.get("operation");
            byte operationtype = JSONConversion.getbyte(jsonoperation, "type");
            byte operation = JSONConversion.getbyte(jsonoperation, "operation");
            IShipfitorderPK shipfitorderPK;
            IShipfitorder shipfitorder;
//Security parameters
            boolean loggedin = RSsecurity.check(json);
            blshipfitorder.setAuthenticated(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    switch(operation) {
                        case IShipfitorderOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blshipfitorder.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IShipfitorderOperation.SELECT_ALL:
                            result = JSONShipfitorder.toJSONArray(blshipfitorder.getShipfitorders()).toJSONString();
                            break;
                        case IShipfitorderOperation.SELECT_SHIPFITORDER:
                            shipfitorderPK = (IShipfitorderPK)JSONShipfitorder.toShipfitorderPK((JSONObject)json.get("shipfitorderpk"));
                            result = JSONShipfitorder.toJSON(blshipfitorder.getShipfitorder(shipfitorderPK)).toJSONString();
                            break;
                        case IShipfitorderOperation.SELECT_Shipfit:
                            IShipfitPK shipfitPK = (IShipfitPK)JSONShipfit.toShipfitPK((JSONObject)json.get("shipfitpk"));
                            result = JSONShipfitorder.toJSONArray(blshipfitorder.getShipfitorders4shipfit(shipfitPK)).toJSONString();
                            break;
                        case IShipfitorderOperation.SELECT_Evetype:
                            IEvetypePK evetypePK = (IEvetypePK)JSONEvetype.toEvetypePK((JSONObject)json.get("evetypepk"));
                            result = JSONShipfitorder.toJSONArray(blshipfitorder.getShipfitorders4evetype(evetypePK)).toJSONString();
                            break;
                        case IShipfitorderOperation.SELECT_Shipfitorderselected:
                            IShipfitorderselectedPK shipfitorderselectedPK = (IShipfitorderselectedPK)JSONShipfitorderselected.toShipfitorderselectedPK((JSONObject)json.get("shipfitorderselectedpk"));
                            result = JSONShipfitorder.toJSON(blshipfitorder.getShipfitorderselected(shipfitorderselectedPK)).toJSONString();
                            break;
                        case IShipfitorderOperation.SELECT_SEARCH:
                            IShipfitordersearch search = (IShipfitordersearch)JSONShipfitorder.toShipfitordersearch((JSONObject)json.get("search"));
                            result = JSONShipfitorder.toJSONArray(blshipfitorder.search(search)).toJSONString();
                            break;
                        case IShipfitorderOperation.SELECT_SEARCHCOUNT:
                            IShipfitordersearch shipfitordersearch = (IShipfitordersearch)JSONShipfitorder.toShipfitordersearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blshipfitorder.searchcount(shipfitordersearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(operation) {
                        case IShipfitorderOperation.INSERT_SHIPFITORDER:
                            shipfitorder = (IShipfitorder)JSONShipfitorder.toShipfitorder((JSONObject)json.get("shipfitorder"));
                            blshipfitorder.insertShipfitorder(shipfitorder);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(operation) {
                        case IShipfitorderOperation.UPDATE_SHIPFITORDER:
                            JSONObject jsonshipfitorder = (JSONObject)json.get("shipfitorder");
                            shipfitorderPK = JSONShipfitorder.toShipfitorderPK((JSONObject)jsonshipfitorder.get("PK"));
                            shipfitorder = blshipfitorder.getShipfitorder(shipfitorderPK);
                            JSONShipfitorder.updateShipfitorder(shipfitorder, jsonshipfitorder);
                            blshipfitorder.updateShipfitorder(shipfitorder);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
                        case IShipfitorderOperation.UPDATE_ORDERAMOUNT:
                            shipfitorderPK = (IShipfitorderPK)JSONShipfitorder.toShipfitorderPK((JSONObject)json.get("shipfitorderpk"));
                            int amount = JSONConversion.getint(json, "amount");
                            blshipfitorder.updateAmount(shipfitorderPK, amount);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(operation) {
                        case IShipfitorderOperation.DELETE_SHIPFITORDER:
                            shipfitorder = (IShipfitorder)JSONShipfitorder.toShipfitorder((JSONObject)json.get("shipfitorder"));
                            blshipfitorder.deleteShipfitorder(shipfitorder);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECURESELECT:
                    switch(operation) {
                        case IShipfitorderOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blshipfitorder.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IShipfitorderOperation.SELECT_ALL:
                            result = JSONShipfitorder.toJSONArray(blshipfitorder.getShipfitorders()).toJSONString();
                            break;
                        case IShipfitorderOperation.SELECT_SHIPFITORDER:
                            shipfitorderPK = (IShipfitorderPK)JSONShipfitorder.toShipfitorderPK((JSONObject)json.get("shipfitorderpk"));
                            result = JSONShipfitorder.toJSON(blshipfitorder.getShipfitorder(shipfitorderPK)).toJSONString();
                            break;
                        case IShipfitorderOperation.SELECT_Shipfit:
                            IShipfitPK shipfitPK = (IShipfitPK)JSONShipfit.toShipfitPK((JSONObject)json.get("shipfitpk"));
                            result = JSONShipfitorder.toJSONArray(blshipfitorder.getShipfitorders4shipfit(shipfitPK)).toJSONString();
                            break;
                        case IShipfitorderOperation.SELECT_Evetype:
                            IEvetypePK evetypePK = (IEvetypePK)JSONEvetype.toEvetypePK((JSONObject)json.get("evetypepk"));
                            result = JSONShipfitorder.toJSONArray(blshipfitorder.getShipfitorders4evetype(evetypePK)).toJSONString();
                            break;
                        case IShipfitorderOperation.SELECT_Shipfitorderselected:
                            IShipfitorderselectedPK shipfitorderselectedPK = (IShipfitorderselectedPK)JSONShipfitorderselected.toShipfitorderselectedPK((JSONObject)json.get("shipfitorderselectedpk"));
                            result = JSONShipfitorder.toJSON(blshipfitorder.getShipfitorderselected(shipfitorderselectedPK)).toJSONString();
                            break;
                        case IShipfitorderOperation.SELECT_SEARCH:
                            IShipfitordersearch search = (IShipfitordersearch)JSONShipfitorder.toShipfitordersearch((JSONObject)json.get("search"));
                            result = JSONShipfitorder.toJSONArray(blshipfitorder.search(search)).toJSONString();
                            break;
                        case IShipfitorderOperation.SELECT_SEARCHCOUNT:
                            IShipfitordersearch shipfitordersearch = (IShipfitordersearch)JSONShipfitorder.toShipfitordersearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blshipfitorder.searchcount(shipfitordersearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREINSERT:
                    switch(operation) {
                        case IShipfitorderOperation.INSERT_SHIPFITORDER:
                            shipfitorder = (IShipfitorder)JSONShipfitorder.toShipfitorder((JSONObject)json.get("shipfitorder"));
                            blshipfitorder.secureinsertShipfitorder(shipfitorder);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREUPDATE:
                    switch(operation) {
                        case IShipfitorderOperation.UPDATE_SHIPFITORDER:
                            JSONObject jsonshipfitorder = (JSONObject)json.get("shipfitorder");
                            shipfitorderPK = JSONShipfitorder.toShipfitorderPK((JSONObject)jsonshipfitorder.get("PK"));
                            shipfitorder = blshipfitorder.getShipfitorder(shipfitorderPK);
                            JSONShipfitorder.updateShipfitorder(shipfitorder, jsonshipfitorder);
                            blshipfitorder.secureupdateShipfitorder(shipfitorder);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREDELETE:
                    switch(operation) {
                        case IShipfitorderOperation.DELETE_SHIPFITORDER:
                            shipfitorder = (IShipfitorder)JSONShipfitorder.toShipfitorder((JSONObject)json.get("shipfitorder"));
                            blshipfitorder.securedeleteShipfitorder(shipfitorder);
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
     * PUT method for updating or creating an instance of RSShipfitorder
     * @param content representation for the resource
     */
    @PUT
    @Consumes("text/html")
    public void put(String content) {
    }
}

