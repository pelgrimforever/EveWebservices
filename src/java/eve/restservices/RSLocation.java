/*
 * RSLocation.java
 *
 * Generated on 8.10.2021 7:21
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
import eve.interfaces.searchentity.ILocationsearch;
import eve.interfaces.servlet.ILocationOperation;
import eve.logicentity.Location;
import eve.searchentity.Locationsearch;
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
@Path("rslocation")
public class RSLocation {

    /**
     * Creates a new instance of HelloWorld
     */
    public RSLocation() {
    }

    /**
     * Retrieves representation of an instance of location.restservices.RSLocation
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{json}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@PathParam("json") String jsonstring) {
        try {
            BLlocation bllocation = new BLlocation();
            ArrayList locations = bllocation.getAll();
            JSONArray jsonlocations = JSONLocation.toJSONArray(locations);
            return jsonlocations.toJSONString();
        }
        catch(DBException e) {
            return "{ \"status\": \"error\"}";
        }
    }

    /**
     * Retrieves representation of an instance of location.restservices.RSLocation
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        String result = "";
        BLlocation bllocation = new BLlocation();
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject)parser.parse(jsonstring);
            JSONObject jsonoperation = (JSONObject)json.get("operation");
            byte operationtype = JSONConversion.getbyte(jsonoperation, "type");
            byte operation = JSONConversion.getbyte(jsonoperation, "operation");
            ILocationPK locationPK;
            ILocation location;
//Security parameters
            boolean loggedin = RSsecurity.check(json);
            bllocation.setAuthenticated(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    switch(operation) {
                        case ILocationOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", bllocation.count());
                            result = jsoncount.toJSONString();
                            break;
                        case ILocationOperation.SELECT_ALL:
                            result = JSONLocation.toJSONArray(bllocation.getLocations()).toJSONString();
                            break;
                        case ILocationOperation.SELECT_LOCATION:
                            locationPK = (ILocationPK)JSONLocation.toLocationPK((JSONObject)json.get("locationpk"));
                            result = JSONLocation.toJSON(bllocation.getLocation(locationPK)).toJSONString();
                            break;
                        case ILocationOperation.SELECT_System:
                            ISystemPK systemPK = (ISystemPK)JSONSystem.toSystemPK((JSONObject)json.get("systempk"));
                            result = JSONLocation.toJSONArray(bllocation.getLocations4system(systemPK)).toJSONString();
                            break;
                        case ILocationOperation.SELECT_SEARCH:
                            ILocationsearch search = (ILocationsearch)JSONLocation.toLocationsearch((JSONObject)json.get("search"));
                            result = JSONLocation.toJSONArray(bllocation.search(search)).toJSONString();
                            break;
                        case ILocationOperation.SELECT_SEARCHCOUNT:
                            ILocationsearch locationsearch = (ILocationsearch)JSONLocation.toLocationsearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", bllocation.searchcount(locationsearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(operation) {
                        case ILocationOperation.INSERT_LOCATION:
                            location = (ILocation)JSONLocation.toLocation((JSONObject)json.get("location"));
                            bllocation.insertLocation(location);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(operation) {
                        case ILocationOperation.UPDATE_LOCATION:
                            JSONObject jsonlocation = (JSONObject)json.get("location");
                            locationPK = JSONLocation.toLocationPK((JSONObject)jsonlocation.get("PK"));
                            location = bllocation.getLocation(locationPK);
                            JSONLocation.updateLocation(location, jsonlocation);
                            bllocation.updateLocation(location);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(operation) {
                        case ILocationOperation.DELETE_LOCATION:
                            location = (ILocation)JSONLocation.toLocation((JSONObject)json.get("location"));
                            bllocation.deleteLocation(location);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECURESELECT:
                    switch(operation) {
                        case ILocationOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", bllocation.count());
                            result = jsoncount.toJSONString();
                            break;
                        case ILocationOperation.SELECT_ALL:
                            result = JSONLocation.toJSONArray(bllocation.getLocations()).toJSONString();
                            break;
                        case ILocationOperation.SELECT_LOCATION:
                            locationPK = (ILocationPK)JSONLocation.toLocationPK((JSONObject)json.get("locationpk"));
                            result = JSONLocation.toJSON(bllocation.getLocation(locationPK)).toJSONString();
                            break;
                        case ILocationOperation.SELECT_System:
                            ISystemPK systemPK = (ISystemPK)JSONSystem.toSystemPK((JSONObject)json.get("systempk"));
                            result = JSONLocation.toJSONArray(bllocation.getLocations4system(systemPK)).toJSONString();
                            break;
                        case ILocationOperation.SELECT_SEARCH:
                            ILocationsearch search = (ILocationsearch)JSONLocation.toLocationsearch((JSONObject)json.get("search"));
                            result = JSONLocation.toJSONArray(bllocation.search(search)).toJSONString();
                            break;
                        case ILocationOperation.SELECT_SEARCHCOUNT:
                            ILocationsearch locationsearch = (ILocationsearch)JSONLocation.toLocationsearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", bllocation.searchcount(locationsearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREINSERT:
                    switch(operation) {
                        case ILocationOperation.INSERT_LOCATION:
                            location = (ILocation)JSONLocation.toLocation((JSONObject)json.get("location"));
                            bllocation.secureinsertLocation(location);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREUPDATE:
                    switch(operation) {
                        case ILocationOperation.UPDATE_LOCATION:
                            JSONObject jsonlocation = (JSONObject)json.get("location");
                            locationPK = JSONLocation.toLocationPK((JSONObject)jsonlocation.get("PK"));
                            location = bllocation.getLocation(locationPK);
                            JSONLocation.updateLocation(location, jsonlocation);
                            bllocation.secureupdateLocation(location);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREDELETE:
                    switch(operation) {
                        case ILocationOperation.DELETE_LOCATION:
                            location = (ILocation)JSONLocation.toLocation((JSONObject)json.get("location"));
                            bllocation.securedeleteLocation(location);
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
     * PUT method for updating or creating an instance of RSLocation
     * @param content representation for the resource
     */
    @PUT
    @Consumes("text/html")
    public void put(String content) {
    }
}

