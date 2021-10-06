/*
 * RSRegion_neighbour.java
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
import eve.interfaces.searchentity.IRegion_neighboursearch;
import eve.interfaces.servlet.IRegion_neighbourOperation;
import eve.logicentity.Region_neighbour;
import eve.searchentity.Region_neighboursearch;
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
@Path("rsregion_neighbour")
public class RSRegion_neighbour {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of HelloWorld
     */
    public RSRegion_neighbour() {
    }

    /**
     * Retrieves representation of an instance of region_neighbour.restservices.RSRegion_neighbour
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{json}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@PathParam("json") String jsonstring) {
        try {
            BLregion_neighbour blregion_neighbour = new BLregion_neighbour();
            ArrayList region_neighbours = blregion_neighbour.getAll();
            JSONArray jsonregion_neighbours = JSONRegion_neighbour.toJSONArray(region_neighbours);
            return jsonregion_neighbours.toJSONString();
        }
        catch(DBException e) {
            return "{ \"status\": \"error\"}";
        }
    }

    /**
     * Retrieves representation of an instance of region_neighbour.restservices.RSRegion_neighbour
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        String result = "";
        BLregion_neighbour blregion_neighbour = new BLregion_neighbour();
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject)parser.parse(jsonstring);
            JSONObject jsonoperation = (JSONObject)json.get("operation");
            byte operationtype = JSONConversion.getbyte(jsonoperation, "type");
            byte operation = JSONConversion.getbyte(jsonoperation, "operation");
            IRegion_neighbourPK region_neighbourPK;
            IRegion_neighbour region_neighbour;
//Security parameters
            boolean loggedin = RSsecurity.check(json);
            blregion_neighbour.setAuthenticated(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    switch(operation) {
                        case IRegion_neighbourOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blregion_neighbour.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IRegion_neighbourOperation.SELECT_ALL:
                            result = JSONRegion_neighbour.toJSONArray(blregion_neighbour.getRegion_neighbours()).toJSONString();
                            break;
                        case IRegion_neighbourOperation.SELECT_REGION_NEIGHBOUR:
                            region_neighbourPK = (IRegion_neighbourPK)JSONRegion_neighbour.toRegion_neighbourPK((JSONObject)json.get("region_neighbourpk"));
                            result = JSONRegion_neighbour.toJSON(blregion_neighbour.getRegion_neighbour(region_neighbourPK)).toJSONString();
                            break;
                        case IRegion_neighbourOperation.SELECT_Regionregion:
                            IRegionPK regionRegionPK = (IRegionPK)JSONRegion.toRegionPK((JSONObject)json.get("regionpk"));
                            result = JSONRegion_neighbour.toJSONArray(blregion_neighbour.getRegion_neighbours4regionRegion(regionRegionPK)).toJSONString();
                            break;
                        case IRegion_neighbourOperation.SELECT_Regionneighbour:
                            IRegionPK regionNeighbourPK = (IRegionPK)JSONRegion.toRegionPK((JSONObject)json.get("regionpk"));
                            result = JSONRegion_neighbour.toJSONArray(blregion_neighbour.getRegion_neighbours4regionNeighbour(regionNeighbourPK)).toJSONString();
                            break;
                        case IRegion_neighbourOperation.SELECT_SEARCH:
                            IRegion_neighboursearch search = (IRegion_neighboursearch)JSONRegion_neighbour.toRegion_neighboursearch((JSONObject)json.get("search"));
                            result = JSONRegion_neighbour.toJSONArray(blregion_neighbour.search(search)).toJSONString();
                            break;
                        case IRegion_neighbourOperation.SELECT_SEARCHCOUNT:
                            IRegion_neighboursearch region_neighboursearch = (IRegion_neighboursearch)JSONRegion_neighbour.toRegion_neighboursearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blregion_neighbour.searchcount(region_neighboursearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(operation) {
                        case IRegion_neighbourOperation.INSERT_REGION_NEIGHBOUR:
                            region_neighbour = (IRegion_neighbour)JSONRegion_neighbour.toRegion_neighbour((JSONObject)json.get("region_neighbour"));
                            blregion_neighbour.insertRegion_neighbour(region_neighbour);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(operation) {
                        case IRegion_neighbourOperation.UPDATE_REGION_NEIGHBOUR:
                            JSONObject jsonregion_neighbour = (JSONObject)json.get("region_neighbour");
                            region_neighbourPK = JSONRegion_neighbour.toRegion_neighbourPK((JSONObject)jsonregion_neighbour.get("PK"));
                            region_neighbour = blregion_neighbour.getRegion_neighbour(region_neighbourPK);
                            JSONRegion_neighbour.updateRegion_neighbour(region_neighbour, jsonregion_neighbour);
                            blregion_neighbour.updateRegion_neighbour(region_neighbour);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(operation) {
                        case IRegion_neighbourOperation.DELETE_REGION_NEIGHBOUR:
                            region_neighbour = (IRegion_neighbour)JSONRegion_neighbour.toRegion_neighbour((JSONObject)json.get("region_neighbour"));
                            blregion_neighbour.deleteRegion_neighbour(region_neighbour);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECURESELECT:
                    switch(operation) {
                        case IRegion_neighbourOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blregion_neighbour.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IRegion_neighbourOperation.SELECT_ALL:
                            result = JSONRegion_neighbour.toJSONArray(blregion_neighbour.getRegion_neighbours()).toJSONString();
                            break;
                        case IRegion_neighbourOperation.SELECT_REGION_NEIGHBOUR:
                            region_neighbourPK = (IRegion_neighbourPK)JSONRegion_neighbour.toRegion_neighbourPK((JSONObject)json.get("region_neighbourpk"));
                            result = JSONRegion_neighbour.toJSON(blregion_neighbour.getRegion_neighbour(region_neighbourPK)).toJSONString();
                            break;
                        case IRegion_neighbourOperation.SELECT_Regionregion:
                            IRegionPK regionRegionPK = (IRegionPK)JSONRegion.toRegionPK((JSONObject)json.get("regionpk"));
                            result = JSONRegion_neighbour.toJSONArray(blregion_neighbour.getRegion_neighbours4regionRegion(regionRegionPK)).toJSONString();
                            break;
                        case IRegion_neighbourOperation.SELECT_Regionneighbour:
                            IRegionPK regionNeighbourPK = (IRegionPK)JSONRegion.toRegionPK((JSONObject)json.get("regionpk"));
                            result = JSONRegion_neighbour.toJSONArray(blregion_neighbour.getRegion_neighbours4regionNeighbour(regionNeighbourPK)).toJSONString();
                            break;
                        case IRegion_neighbourOperation.SELECT_SEARCH:
                            IRegion_neighboursearch search = (IRegion_neighboursearch)JSONRegion_neighbour.toRegion_neighboursearch((JSONObject)json.get("search"));
                            result = JSONRegion_neighbour.toJSONArray(blregion_neighbour.search(search)).toJSONString();
                            break;
                        case IRegion_neighbourOperation.SELECT_SEARCHCOUNT:
                            IRegion_neighboursearch region_neighboursearch = (IRegion_neighboursearch)JSONRegion_neighbour.toRegion_neighboursearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blregion_neighbour.searchcount(region_neighboursearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREINSERT:
                    switch(operation) {
                        case IRegion_neighbourOperation.INSERT_REGION_NEIGHBOUR:
                            region_neighbour = (IRegion_neighbour)JSONRegion_neighbour.toRegion_neighbour((JSONObject)json.get("region_neighbour"));
                            blregion_neighbour.secureinsertRegion_neighbour(region_neighbour);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREUPDATE:
                    switch(operation) {
                        case IRegion_neighbourOperation.UPDATE_REGION_NEIGHBOUR:
                            JSONObject jsonregion_neighbour = (JSONObject)json.get("region_neighbour");
                            region_neighbourPK = JSONRegion_neighbour.toRegion_neighbourPK((JSONObject)jsonregion_neighbour.get("PK"));
                            region_neighbour = blregion_neighbour.getRegion_neighbour(region_neighbourPK);
                            JSONRegion_neighbour.updateRegion_neighbour(region_neighbour, jsonregion_neighbour);
                            blregion_neighbour.secureupdateRegion_neighbour(region_neighbour);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREDELETE:
                    switch(operation) {
                        case IRegion_neighbourOperation.DELETE_REGION_NEIGHBOUR:
                            region_neighbour = (IRegion_neighbour)JSONRegion_neighbour.toRegion_neighbour((JSONObject)json.get("region_neighbour"));
                            blregion_neighbour.securedeleteRegion_neighbour(region_neighbour);
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
     * PUT method for updating or creating an instance of RSRegion_neighbour
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("text/html")
    public void put(String content) {
    }
}

