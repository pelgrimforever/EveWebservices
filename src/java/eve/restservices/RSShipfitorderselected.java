/*
 * RSShipfitorderselected.java
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
import eve.interfaces.searchentity.IShipfitorderselectedsearch;
import eve.interfaces.servlet.IShipfitorderselectedOperation;
import eve.logicentity.Shipfitorderselected;
import eve.searchentity.Shipfitorderselectedsearch;
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
@Path("rsshipfitorderselected")
public class RSShipfitorderselected {

    /**
     * Creates a new instance of HelloWorld
     */
    public RSShipfitorderselected() {
    }

    /**
     * Retrieves representation of an instance of shipfitorderselected.restservices.RSShipfitorderselected
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{json}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@PathParam("json") String jsonstring) {
        try {
            BLshipfitorderselected blshipfitorderselected = new BLshipfitorderselected();
            ArrayList shipfitorderselecteds = blshipfitorderselected.getAll();
            JSONArray jsonshipfitorderselecteds = JSONShipfitorderselected.toJSONArray(shipfitorderselecteds);
            return jsonshipfitorderselecteds.toJSONString();
        }
        catch(DBException e) {
            return "{ \"status\": \"error\"}";
        }
    }

    /**
     * Retrieves representation of an instance of shipfitorderselected.restservices.RSShipfitorderselected
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        String result = "";
        BLshipfitorderselected blshipfitorderselected = new BLshipfitorderselected();
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject)parser.parse(jsonstring);
            JSONObject jsonoperation = (JSONObject)json.get("operation");
            byte operationtype = JSONConversion.getbyte(jsonoperation, "type");
            byte operation = JSONConversion.getbyte(jsonoperation, "operation");
            IShipfitorderselectedPK shipfitorderselectedPK;
            IShipfitorderselected shipfitorderselected;
//Security parameters
            boolean loggedin = RSsecurity.check(json);
            blshipfitorderselected.setAuthenticated(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    switch(operation) {
                        case IShipfitorderselectedOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blshipfitorderselected.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IShipfitorderselectedOperation.SELECT_ALL:
                            result = JSONShipfitorderselected.toJSONArray(blshipfitorderselected.getShipfitorderselecteds()).toJSONString();
                            break;
                        case IShipfitorderselectedOperation.SELECT_SHIPFITORDERSELECTED:
                            shipfitorderselectedPK = (IShipfitorderselectedPK)JSONShipfitorderselected.toShipfitorderselectedPK((JSONObject)json.get("shipfitorderselectedpk"));
                            result = JSONShipfitorderselected.toJSON(blshipfitorderselected.getShipfitorderselected(shipfitorderselectedPK)).toJSONString();
                            break;
                        case IShipfitorderselectedOperation.SELECT_Orders:
                            IOrdersPK ordersPK = (IOrdersPK)JSONOrders.toOrdersPK((JSONObject)json.get("orderspk"));
                            result = JSONShipfitorderselected.toJSONArray(blshipfitorderselected.getShipfitorderselecteds4orders(ordersPK)).toJSONString();
                            break;
                        case IShipfitorderselectedOperation.SELECT_Shipfitorder:
                            IShipfitorderPK shipfitorderPK = (IShipfitorderPK)JSONShipfitorder.toShipfitorderPK((JSONObject)json.get("shipfitorderpk"));
                            result = JSONShipfitorderselected.toJSONArray(blshipfitorderselected.getShipfitorderselecteds4shipfitorder(shipfitorderPK)).toJSONString();
                            break;
                        case IShipfitorderselectedOperation.SELECT_SEARCH:
                            IShipfitorderselectedsearch search = (IShipfitorderselectedsearch)JSONShipfitorderselected.toShipfitorderselectedsearch((JSONObject)json.get("search"));
                            result = JSONShipfitorderselected.toJSONArray(blshipfitorderselected.search(search)).toJSONString();
                            break;
                        case IShipfitorderselectedOperation.SELECT_SEARCHCOUNT:
                            IShipfitorderselectedsearch shipfitorderselectedsearch = (IShipfitorderselectedsearch)JSONShipfitorderselected.toShipfitorderselectedsearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blshipfitorderselected.searchcount(shipfitorderselectedsearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(operation) {
                        case IShipfitorderselectedOperation.INSERT_SHIPFITORDERSELECTED:
                            shipfitorderselected = (IShipfitorderselected)JSONShipfitorderselected.toShipfitorderselected((JSONObject)json.get("shipfitorderselected"));
                            blshipfitorderselected.insertShipfitorderselected(shipfitorderselected);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
                        case IShipfitorderselectedOperation.INSERT_ORDERID:
                            IShipfitorderPK shipfitorderPK = (IShipfitorderPK)JSONShipfitorder.toShipfitorderPK((JSONObject)json.get("shipfitorderpk"));
                            IOrdersPK ordersPK = (IOrdersPK)JSONOrders.toOrdersPK((JSONObject)json.get("orderspk"));
                            blshipfitorderselected.addOrderid(shipfitorderPK, ordersPK);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(operation) {
                        case IShipfitorderselectedOperation.UPDATE_SHIPFITORDERSELECTED:
                            JSONObject jsonshipfitorderselected = (JSONObject)json.get("shipfitorderselected");
                            shipfitorderselectedPK = JSONShipfitorderselected.toShipfitorderselectedPK((JSONObject)jsonshipfitorderselected.get("PK"));
                            shipfitorderselected = blshipfitorderselected.getShipfitorderselected(shipfitorderselectedPK);
                            JSONShipfitorderselected.updateShipfitorderselected(shipfitorderselected, jsonshipfitorderselected);
                            blshipfitorderselected.updateShipfitorderselected(shipfitorderselected);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(operation) {
                        case IShipfitorderselectedOperation.DELETE_SHIPFITORDERSELECTED:
                            shipfitorderselected = (IShipfitorderselected)JSONShipfitorderselected.toShipfitorderselected((JSONObject)json.get("shipfitorderselected"));
                            blshipfitorderselected.deleteShipfitorderselected(shipfitorderselected);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECURESELECT:
                    switch(operation) {
                        case IShipfitorderselectedOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blshipfitorderselected.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IShipfitorderselectedOperation.SELECT_ALL:
                            result = JSONShipfitorderselected.toJSONArray(blshipfitorderselected.getShipfitorderselecteds()).toJSONString();
                            break;
                        case IShipfitorderselectedOperation.SELECT_SHIPFITORDERSELECTED:
                            shipfitorderselectedPK = (IShipfitorderselectedPK)JSONShipfitorderselected.toShipfitorderselectedPK((JSONObject)json.get("shipfitorderselectedpk"));
                            result = JSONShipfitorderselected.toJSON(blshipfitorderselected.getShipfitorderselected(shipfitorderselectedPK)).toJSONString();
                            break;
                        case IShipfitorderselectedOperation.SELECT_Orders:
                            IOrdersPK ordersPK = (IOrdersPK)JSONOrders.toOrdersPK((JSONObject)json.get("orderspk"));
                            result = JSONShipfitorderselected.toJSONArray(blshipfitorderselected.getShipfitorderselecteds4orders(ordersPK)).toJSONString();
                            break;
                        case IShipfitorderselectedOperation.SELECT_Shipfitorder:
                            IShipfitorderPK shipfitorderPK = (IShipfitorderPK)JSONShipfitorder.toShipfitorderPK((JSONObject)json.get("shipfitorderpk"));
                            result = JSONShipfitorderselected.toJSONArray(blshipfitorderselected.getShipfitorderselecteds4shipfitorder(shipfitorderPK)).toJSONString();
                            break;
                        case IShipfitorderselectedOperation.SELECT_SEARCH:
                            IShipfitorderselectedsearch search = (IShipfitorderselectedsearch)JSONShipfitorderselected.toShipfitorderselectedsearch((JSONObject)json.get("search"));
                            result = JSONShipfitorderselected.toJSONArray(blshipfitorderselected.search(search)).toJSONString();
                            break;
                        case IShipfitorderselectedOperation.SELECT_SEARCHCOUNT:
                            IShipfitorderselectedsearch shipfitorderselectedsearch = (IShipfitorderselectedsearch)JSONShipfitorderselected.toShipfitorderselectedsearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blshipfitorderselected.searchcount(shipfitorderselectedsearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREINSERT:
                    switch(operation) {
                        case IShipfitorderselectedOperation.INSERT_SHIPFITORDERSELECTED:
                            shipfitorderselected = (IShipfitorderselected)JSONShipfitorderselected.toShipfitorderselected((JSONObject)json.get("shipfitorderselected"));
                            blshipfitorderselected.secureinsertShipfitorderselected(shipfitorderselected);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREUPDATE:
                    switch(operation) {
                        case IShipfitorderselectedOperation.UPDATE_SHIPFITORDERSELECTED:
                            JSONObject jsonshipfitorderselected = (JSONObject)json.get("shipfitorderselected");
                            shipfitorderselectedPK = JSONShipfitorderselected.toShipfitorderselectedPK((JSONObject)jsonshipfitorderselected.get("PK"));
                            shipfitorderselected = blshipfitorderselected.getShipfitorderselected(shipfitorderselectedPK);
                            JSONShipfitorderselected.updateShipfitorderselected(shipfitorderselected, jsonshipfitorderselected);
                            blshipfitorderselected.secureupdateShipfitorderselected(shipfitorderselected);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREDELETE:
                    switch(operation) {
                        case IShipfitorderselectedOperation.DELETE_SHIPFITORDERSELECTED:
                            shipfitorderselected = (IShipfitorderselected)JSONShipfitorderselected.toShipfitorderselected((JSONObject)json.get("shipfitorderselected"));
                            blshipfitorderselected.securedeleteShipfitorderselected(shipfitorderselected);
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
     * PUT method for updating or creating an instance of RSShipfitorderselected
     * @param content representation for the resource
     */
    @PUT
    @Consumes("text/html")
    public void put(String content) {
    }
}

