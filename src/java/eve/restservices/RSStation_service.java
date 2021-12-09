/*
 * RSStation_service.java
 *
 * Generated on 9.11.2021 14:30
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
import eve.interfaces.searchentity.IStation_servicesearch;
import eve.interfaces.servlet.IStation_serviceOperation;
import eve.logicentity.Station_service;
import eve.searchentity.Station_servicesearch;
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
@Path("rsstation_service")
public class RSStation_service {

    /**
     * Creates a new instance of HelloWorld
     */
    public RSStation_service() {
    }

    /**
     * Retrieves representation of an instance of station_service.restservices.RSStation_service
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{json}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@PathParam("json") String jsonstring) {
        try {
            BLstation_service blstation_service = new BLstation_service();
            ArrayList station_services = blstation_service.getAll();
            JSONArray jsonstation_services = JSONStation_service.toJSONArray(station_services);
            return jsonstation_services.toJSONString();
        }
        catch(DBException e) {
            return "{ \"status\": \"error\"}";
        }
    }

    /**
     * Retrieves representation of an instance of station_service.restservices.RSStation_service
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        String result = "";
        BLstation_service blstation_service = new BLstation_service();
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject)parser.parse(jsonstring);
            JSONObject jsonoperation = (JSONObject)json.get("operation");
            byte operationtype = JSONConversion.getbyte(jsonoperation, "type");
            byte operation = JSONConversion.getbyte(jsonoperation, "operation");
            IStation_servicePK station_servicePK;
            IStation_service station_service;
//Security parameters
            boolean loggedin = RSsecurity.check(json);
            blstation_service.setAuthenticated(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    switch(operation) {
                        case IStation_serviceOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blstation_service.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IStation_serviceOperation.SELECT_ALL:
                            result = JSONStation_service.toJSONArray(blstation_service.getStation_services()).toJSONString();
                            break;
                        case IStation_serviceOperation.SELECT_STATION_SERVICE:
                            station_servicePK = (IStation_servicePK)JSONStation_service.toStation_servicePK((JSONObject)json.get("station_servicepk"));
                            result = JSONStation_service.toJSON(blstation_service.getStation_service(station_servicePK)).toJSONString();
                            break;
                        case IStation_serviceOperation.SELECT_Station:
                            IStationPK stationPK = (IStationPK)JSONStation.toStationPK((JSONObject)json.get("stationpk"));
                            result = JSONStation_service.toJSONArray(blstation_service.getStation_services4station(stationPK)).toJSONString();
                            break;
                        case IStation_serviceOperation.SELECT_SEARCH:
                            IStation_servicesearch search = (IStation_servicesearch)JSONStation_service.toStation_servicesearch((JSONObject)json.get("search"));
                            result = JSONStation_service.toJSONArray(blstation_service.search(search)).toJSONString();
                            break;
                        case IStation_serviceOperation.SELECT_SEARCHCOUNT:
                            IStation_servicesearch station_servicesearch = (IStation_servicesearch)JSONStation_service.toStation_servicesearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blstation_service.searchcount(station_servicesearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(operation) {
                        case IStation_serviceOperation.INSERT_STATION_SERVICE:
                            station_service = (IStation_service)JSONStation_service.toStation_service((JSONObject)json.get("station_service"));
                            blstation_service.insertStation_service(station_service);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(operation) {
                        case IStation_serviceOperation.UPDATE_STATION_SERVICE:
                            JSONObject jsonstation_service = (JSONObject)json.get("station_service");
                            station_servicePK = JSONStation_service.toStation_servicePK((JSONObject)jsonstation_service.get("PK"));
                            station_service = blstation_service.getStation_service(station_servicePK);
                            JSONStation_service.updateStation_service(station_service, jsonstation_service);
                            blstation_service.updateStation_service(station_service);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(operation) {
                        case IStation_serviceOperation.DELETE_STATION_SERVICE:
                            station_service = (IStation_service)JSONStation_service.toStation_service((JSONObject)json.get("station_service"));
                            blstation_service.deleteStation_service(station_service);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECURESELECT:
                    switch(operation) {
                        case IStation_serviceOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blstation_service.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IStation_serviceOperation.SELECT_ALL:
                            result = JSONStation_service.toJSONArray(blstation_service.getStation_services()).toJSONString();
                            break;
                        case IStation_serviceOperation.SELECT_STATION_SERVICE:
                            station_servicePK = (IStation_servicePK)JSONStation_service.toStation_servicePK((JSONObject)json.get("station_servicepk"));
                            result = JSONStation_service.toJSON(blstation_service.getStation_service(station_servicePK)).toJSONString();
                            break;
                        case IStation_serviceOperation.SELECT_Station:
                            IStationPK stationPK = (IStationPK)JSONStation.toStationPK((JSONObject)json.get("stationpk"));
                            result = JSONStation_service.toJSONArray(blstation_service.getStation_services4station(stationPK)).toJSONString();
                            break;
                        case IStation_serviceOperation.SELECT_SEARCH:
                            IStation_servicesearch search = (IStation_servicesearch)JSONStation_service.toStation_servicesearch((JSONObject)json.get("search"));
                            result = JSONStation_service.toJSONArray(blstation_service.search(search)).toJSONString();
                            break;
                        case IStation_serviceOperation.SELECT_SEARCHCOUNT:
                            IStation_servicesearch station_servicesearch = (IStation_servicesearch)JSONStation_service.toStation_servicesearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blstation_service.searchcount(station_servicesearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREINSERT:
                    switch(operation) {
                        case IStation_serviceOperation.INSERT_STATION_SERVICE:
                            station_service = (IStation_service)JSONStation_service.toStation_service((JSONObject)json.get("station_service"));
                            blstation_service.secureinsertStation_service(station_service);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREUPDATE:
                    switch(operation) {
                        case IStation_serviceOperation.UPDATE_STATION_SERVICE:
                            JSONObject jsonstation_service = (JSONObject)json.get("station_service");
                            station_servicePK = JSONStation_service.toStation_servicePK((JSONObject)jsonstation_service.get("PK"));
                            station_service = blstation_service.getStation_service(station_servicePK);
                            JSONStation_service.updateStation_service(station_service, jsonstation_service);
                            blstation_service.secureupdateStation_service(station_service);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREDELETE:
                    switch(operation) {
                        case IStation_serviceOperation.DELETE_STATION_SERVICE:
                            station_service = (IStation_service)JSONStation_service.toStation_service((JSONObject)json.get("station_service"));
                            blstation_service.securedeleteStation_service(station_service);
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
     * PUT method for updating or creating an instance of RSStation_service
     * @param content representation for the resource
     */
    @PUT
    @Consumes("text/html")
    public void put(String content) {
    }
}

