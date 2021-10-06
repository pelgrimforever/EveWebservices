/*
 * RSRegion.java
 *
 * Generated on 6.9.2021 16:29
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
import eve.interfaces.searchentity.IRegionsearch;
import eve.interfaces.servlet.IRegionOperation;
import eve.logicentity.Region;
import eve.searchentity.Regionsearch;
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
@Path("rsregion")
public class RSRegion {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of HelloWorld
     */
    public RSRegion() {
    }

    /**
     * Retrieves representation of an instance of region.restservices.RSRegion
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{json}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@PathParam("json") String jsonstring) {
        try {
            BLregion blregion = new BLregion();
            ArrayList regions = blregion.getAll();
            JSONArray jsonregions = JSONRegion.toJSONArray(regions);
            return jsonregions.toJSONString();
        }
        catch(DBException e) {
            return "{ \"status\": \"error\"}";
        }
    }

    /**
     * Retrieves representation of an instance of region.restservices.RSRegion
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        String result = "";
        BLregion blregion = new BLregion();
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject)parser.parse(jsonstring);
            JSONObject jsonoperation = (JSONObject)json.get("operation");
            byte operationtype = JSONConversion.getbyte(jsonoperation, "type");
            byte operation = JSONConversion.getbyte(jsonoperation, "operation");
            IRegionPK regionPK;
            IRegion region;
//Security parameters
            boolean loggedin = RSsecurity.check(json);
            blregion.setAuthenticated(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    switch(operation) {
                        case IRegionOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blregion.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IRegionOperation.SELECT_ALL:
                            result = JSONRegion.toJSONArray(blregion.getRegions()).toJSONString();
                            break;
                        case IRegionOperation.SELECT_REGION:
                            regionPK = (IRegionPK)JSONRegion.toRegionPK((JSONObject)json.get("regionpk"));
                            result = JSONRegion.toJSON(blregion.getRegion(regionPK)).toJSONString();
                            break;
                        case IRegionOperation.SELECT_Order_history:
                            IOrder_historyPK order_historyPK = (IOrder_historyPK)JSONOrder_history.toOrder_historyPK((JSONObject)json.get("order_historypk"));
                            result = JSONRegion.toJSON(blregion.getOrder_history(order_historyPK)).toJSONString();
                            break;
                        case IRegionOperation.SELECT_Region_neighbourregion:
                            IRegion_neighbourPK region_neighbourRegionPK = (IRegion_neighbourPK)JSONRegion_neighbour.toRegion_neighbourPK((JSONObject)json.get("region_neighbourpk"));
                            result = JSONRegion.toJSON(blregion.getRegion_neighbourregion(region_neighbourRegionPK)).toJSONString();
                            break;
                        case IRegionOperation.SELECT_Region_neighbourneighbour:
                            IRegion_neighbourPK region_neighbourNeighbourPK = (IRegion_neighbourPK)JSONRegion_neighbour.toRegion_neighbourPK((JSONObject)json.get("region_neighbourpk"));
                            result = JSONRegion.toJSON(blregion.getRegion_neighbourneighbour(region_neighbourNeighbourPK)).toJSONString();
                            break;
                        case IRegionOperation.SELECT_SEARCH:
                            IRegionsearch search = (IRegionsearch)JSONRegion.toRegionsearch((JSONObject)json.get("search"));
                            result = JSONRegion.toJSONArray(blregion.search(search)).toJSONString();
                            break;
                        case IRegionOperation.SELECT_SEARCHCOUNT:
                            IRegionsearch regionsearch = (IRegionsearch)JSONRegion.toRegionsearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blregion.searchcount(regionsearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(operation) {
                        case IRegionOperation.INSERT_REGION:
                            region = (IRegion)JSONRegion.toRegion((JSONObject)json.get("region"));
                            blregion.insertRegion(region);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(operation) {
                        case IRegionOperation.UPDATE_REGION:
                            JSONObject jsonregion = (JSONObject)json.get("region");
                            regionPK = JSONRegion.toRegionPK((JSONObject)jsonregion.get("PK"));
                            region = blregion.getRegion(regionPK);
                            JSONRegion.updateRegion(region, jsonregion);
                            blregion.updateRegion(region);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(operation) {
                        case IRegionOperation.DELETE_REGION:
                            region = (IRegion)JSONRegion.toRegion((JSONObject)json.get("region"));
                            blregion.deleteRegion(region);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECURESELECT:
                    switch(operation) {
                        case IRegionOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blregion.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IRegionOperation.SELECT_ALL:
                            result = JSONRegion.toJSONArray(blregion.getRegions()).toJSONString();
                            break;
                        case IRegionOperation.SELECT_REGION:
                            regionPK = (IRegionPK)JSONRegion.toRegionPK((JSONObject)json.get("regionpk"));
                            result = JSONRegion.toJSON(blregion.getRegion(regionPK)).toJSONString();
                            break;
                        case IRegionOperation.SELECT_Order_history:
                            IOrder_historyPK order_historyPK = (IOrder_historyPK)JSONOrder_history.toOrder_historyPK((JSONObject)json.get("order_historypk"));
                            result = JSONRegion.toJSON(blregion.getOrder_history(order_historyPK)).toJSONString();
                            break;
                        case IRegionOperation.SELECT_Region_neighbourregion:
                            IRegion_neighbourPK region_neighbourRegionPK = (IRegion_neighbourPK)JSONRegion_neighbour.toRegion_neighbourPK((JSONObject)json.get("region_neighbourpk"));
                            result = JSONRegion.toJSON(blregion.getRegion_neighbourregion(region_neighbourRegionPK)).toJSONString();
                            break;
                        case IRegionOperation.SELECT_Region_neighbourneighbour:
                            IRegion_neighbourPK region_neighbourNeighbourPK = (IRegion_neighbourPK)JSONRegion_neighbour.toRegion_neighbourPK((JSONObject)json.get("region_neighbourpk"));
                            result = JSONRegion.toJSON(blregion.getRegion_neighbourneighbour(region_neighbourNeighbourPK)).toJSONString();
                            break;
                        case IRegionOperation.SELECT_SEARCH:
                            IRegionsearch search = (IRegionsearch)JSONRegion.toRegionsearch((JSONObject)json.get("search"));
                            result = JSONRegion.toJSONArray(blregion.search(search)).toJSONString();
                            break;
                        case IRegionOperation.SELECT_SEARCHCOUNT:
                            IRegionsearch regionsearch = (IRegionsearch)JSONRegion.toRegionsearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blregion.searchcount(regionsearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREINSERT:
                    switch(operation) {
                        case IRegionOperation.INSERT_REGION:
                            region = (IRegion)JSONRegion.toRegion((JSONObject)json.get("region"));
                            blregion.secureinsertRegion(region);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREUPDATE:
                    switch(operation) {
                        case IRegionOperation.UPDATE_REGION:
                            JSONObject jsonregion = (JSONObject)json.get("region");
                            regionPK = JSONRegion.toRegionPK((JSONObject)jsonregion.get("PK"));
                            region = blregion.getRegion(regionPK);
                            JSONRegion.updateRegion(region, jsonregion);
                            blregion.secureupdateRegion(region);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREDELETE:
                    switch(operation) {
                        case IRegionOperation.DELETE_REGION:
                            region = (IRegion)JSONRegion.toRegion((JSONObject)json.get("region"));
                            blregion.securedeleteRegion(region);
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
     * PUT method for updating or creating an instance of RSRegion
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("text/html")
    public void put(String content) {
    }
}

