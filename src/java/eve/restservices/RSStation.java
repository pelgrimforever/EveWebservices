/*
 * RSStation.java
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
import eve.interfaces.searchentity.IStationsearch;
import eve.interfaces.servlet.IStationOperation;
import eve.logicentity.Station;
import eve.searchentity.Stationsearch;
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
@Path("rsstation")
public class RSStation {

    /**
     * Creates a new instance of HelloWorld
     */
    public RSStation() {
    }

    /**
     * Retrieves representation of an instance of station.restservices.RSStation
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{json}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@PathParam("json") String jsonstring) {
        try {
            BLstation blstation = new BLstation();
            ArrayList stations = blstation.getAll();
            JSONArray jsonstations = JSONStation.toJSONArray(stations);
            return jsonstations.toJSONString();
        }
        catch(DBException e) {
            return "{ \"status\": \"error\"}";
        }
    }

    /**
     * Retrieves representation of an instance of station.restservices.RSStation
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        String result = "";
        BLstation blstation = new BLstation();
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject)parser.parse(jsonstring);
            JSONObject jsonoperation = (JSONObject)json.get("operation");
            byte operationtype = JSONConversion.getbyte(jsonoperation, "type");
            byte operation = JSONConversion.getbyte(jsonoperation, "operation");
            IStationPK stationPK;
            IStation station;
//Security parameters
            boolean loggedin = RSsecurity.check(json);
            blstation.setAuthenticated(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    switch(operation) {
                        case IStationOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blstation.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IStationOperation.SELECT_ALL:
                            result = JSONStation.toJSONArray(blstation.getStations()).toJSONString();
                            break;
                        case IStationOperation.SELECT_STATION:
                            stationPK = (IStationPK)JSONStation.toStationPK((JSONObject)json.get("stationpk"));
                            result = JSONStation.toJSON(blstation.getStation(stationPK)).toJSONString();
                            break;
                        case IStationOperation.SELECT_Race:
                            IRacePK racePK = (IRacePK)JSONRace.toRacePK((JSONObject)json.get("racepk"));
                            result = JSONStation.toJSONArray(blstation.getStations4race(racePK)).toJSONString();
                            break;
                        case IStationOperation.SELECT_Evetype:
                            IEvetypePK evetypePK = (IEvetypePK)JSONEvetype.toEvetypePK((JSONObject)json.get("evetypepk"));
                            result = JSONStation.toJSONArray(blstation.getStations4evetype(evetypePK)).toJSONString();
                            break;
                        case IStationOperation.SELECT_System:
                            ISystemPK systemPK = (ISystemPK)JSONSystem.toSystemPK((JSONObject)json.get("systempk"));
                            result = JSONStation.toJSONArray(blstation.getStations4system(systemPK)).toJSONString();
                            break;
                        case IStationOperation.SELECT_Station_service:
                            IStation_servicePK station_servicePK = (IStation_servicePK)JSONStation_service.toStation_servicePK((JSONObject)json.get("station_servicepk"));
                            result = JSONStation.toJSON(blstation.getStation_service(station_servicePK)).toJSONString();
                            break;
                        case IStationOperation.SELECT_SEARCH:
                            IStationsearch search = (IStationsearch)JSONStation.toStationsearch((JSONObject)json.get("search"));
                            result = JSONStation.toJSONArray(blstation.search(search)).toJSONString();
                            break;
                        case IStationOperation.SELECT_SEARCHCOUNT:
                            IStationsearch stationsearch = (IStationsearch)JSONStation.toStationsearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blstation.searchcount(stationsearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(operation) {
                        case IStationOperation.INSERT_STATION:
                            station = (IStation)JSONStation.toStation((JSONObject)json.get("station"));
                            blstation.insertStation(station);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(operation) {
                        case IStationOperation.UPDATE_STATION:
                            JSONObject jsonstation = (JSONObject)json.get("station");
                            stationPK = JSONStation.toStationPK((JSONObject)jsonstation.get("PK"));
                            station = blstation.getStation(stationPK);
                            JSONStation.updateStation(station, jsonstation);
                            blstation.updateStation(station);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(operation) {
                        case IStationOperation.DELETE_STATION:
                            station = (IStation)JSONStation.toStation((JSONObject)json.get("station"));
                            blstation.deleteStation(station);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECURESELECT:
                    switch(operation) {
                        case IStationOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blstation.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IStationOperation.SELECT_ALL:
                            result = JSONStation.toJSONArray(blstation.getStations()).toJSONString();
                            break;
                        case IStationOperation.SELECT_STATION:
                            stationPK = (IStationPK)JSONStation.toStationPK((JSONObject)json.get("stationpk"));
                            result = JSONStation.toJSON(blstation.getStation(stationPK)).toJSONString();
                            break;
                        case IStationOperation.SELECT_Race:
                            IRacePK racePK = (IRacePK)JSONRace.toRacePK((JSONObject)json.get("racepk"));
                            result = JSONStation.toJSONArray(blstation.getStations4race(racePK)).toJSONString();
                            break;
                        case IStationOperation.SELECT_Evetype:
                            IEvetypePK evetypePK = (IEvetypePK)JSONEvetype.toEvetypePK((JSONObject)json.get("evetypepk"));
                            result = JSONStation.toJSONArray(blstation.getStations4evetype(evetypePK)).toJSONString();
                            break;
                        case IStationOperation.SELECT_System:
                            ISystemPK systemPK = (ISystemPK)JSONSystem.toSystemPK((JSONObject)json.get("systempk"));
                            result = JSONStation.toJSONArray(blstation.getStations4system(systemPK)).toJSONString();
                            break;
                        case IStationOperation.SELECT_Station_service:
                            IStation_servicePK station_servicePK = (IStation_servicePK)JSONStation_service.toStation_servicePK((JSONObject)json.get("station_servicepk"));
                            result = JSONStation.toJSON(blstation.getStation_service(station_servicePK)).toJSONString();
                            break;
                        case IStationOperation.SELECT_SEARCH:
                            IStationsearch search = (IStationsearch)JSONStation.toStationsearch((JSONObject)json.get("search"));
                            result = JSONStation.toJSONArray(blstation.search(search)).toJSONString();
                            break;
                        case IStationOperation.SELECT_SEARCHCOUNT:
                            IStationsearch stationsearch = (IStationsearch)JSONStation.toStationsearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blstation.searchcount(stationsearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREINSERT:
                    switch(operation) {
                        case IStationOperation.INSERT_STATION:
                            station = (IStation)JSONStation.toStation((JSONObject)json.get("station"));
                            blstation.secureinsertStation(station);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREUPDATE:
                    switch(operation) {
                        case IStationOperation.UPDATE_STATION:
                            JSONObject jsonstation = (JSONObject)json.get("station");
                            stationPK = JSONStation.toStationPK((JSONObject)jsonstation.get("PK"));
                            station = blstation.getStation(stationPK);
                            JSONStation.updateStation(station, jsonstation);
                            blstation.secureupdateStation(station);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREDELETE:
                    switch(operation) {
                        case IStationOperation.DELETE_STATION:
                            station = (IStation)JSONStation.toStation((JSONObject)json.get("station"));
                            blstation.securedeleteStation(station);
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
     * PUT method for updating or creating an instance of RSStation
     * @param content representation for the resource
     */
    @PUT
    @Consumes("text/html")
    public void put(String content) {
    }
}

