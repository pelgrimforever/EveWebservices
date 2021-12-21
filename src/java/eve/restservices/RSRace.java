/*
 * RSRace.java
 *
 * Generated on 16.11.2021 15:46
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
import eve.interfaces.searchentity.IRacesearch;
import eve.interfaces.servlet.IRaceOperation;
import eve.logicentity.Race;
import eve.searchentity.Racesearch;
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
@Path("rsrace")
public class RSRace {

    /**
     * Creates a new instance of HelloWorld
     */
    public RSRace() {
    }

    /**
     * Retrieves representation of an instance of race.restservices.RSRace
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{json}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@PathParam("json") String jsonstring) {
        try {
            BLrace blrace = new BLrace();
            ArrayList races = blrace.getAll();
            JSONArray jsonraces = JSONRace.toJSONArray(races);
            return jsonraces.toJSONString();
        }
        catch(DBException e) {
            return "{ \"status\": \"error\"}";
        }
    }

    /**
     * Retrieves representation of an instance of race.restservices.RSRace
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        String result = "";
        BLrace blrace = new BLrace();
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject)parser.parse(jsonstring);
            JSONObject jsonoperation = (JSONObject)json.get("operation");
            byte operationtype = JSONConversion.getbyte(jsonoperation, "type");
            byte operation = JSONConversion.getbyte(jsonoperation, "operation");
            IRacePK racePK;
            IRace race;
//Security parameters
            boolean loggedin = RSsecurity.check(json);
            blrace.setAuthenticated(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    switch(operation) {
                        case IRaceOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blrace.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IRaceOperation.SELECT_ALL:
                            result = JSONRace.toJSONArray(blrace.getRaces()).toJSONString();
                            break;
                        case IRaceOperation.SELECT_RACE:
                            racePK = (IRacePK)JSONRace.toRacePK((JSONObject)json.get("racepk"));
                            result = JSONRace.toJSON(blrace.getRace(racePK)).toJSONString();
                            break;
                        case IRaceOperation.SELECT_Faction:
                            IFactionPK factionPK = (IFactionPK)JSONFaction.toFactionPK((JSONObject)json.get("factionpk"));
                            result = JSONRace.toJSONArray(blrace.getRaces4faction(factionPK)).toJSONString();
                            break;
                        case IRaceOperation.SELECT_SEARCH:
                            IRacesearch search = (IRacesearch)JSONRace.toRacesearch((JSONObject)json.get("search"));
                            result = JSONRace.toJSONArray(blrace.search(search)).toJSONString();
                            break;
                        case IRaceOperation.SELECT_SEARCHCOUNT:
                            IRacesearch racesearch = (IRacesearch)JSONRace.toRacesearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blrace.searchcount(racesearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(operation) {
                        case IRaceOperation.INSERT_RACE:
                            race = (IRace)JSONRace.toRace((JSONObject)json.get("race"));
                            blrace.insertRace(race);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(operation) {
                        case IRaceOperation.UPDATE_RACE:
                            JSONObject jsonrace = (JSONObject)json.get("race");
                            racePK = JSONRace.toRacePK((JSONObject)jsonrace.get("PK"));
                            race = blrace.getRace(racePK);
                            JSONRace.updateRace(race, jsonrace);
                            blrace.updateRace(race);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(operation) {
                        case IRaceOperation.DELETE_RACE:
                            race = (IRace)JSONRace.toRace((JSONObject)json.get("race"));
                            blrace.deleteRace(race);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECURESELECT:
                    switch(operation) {
                        case IRaceOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blrace.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IRaceOperation.SELECT_ALL:
                            result = JSONRace.toJSONArray(blrace.getRaces()).toJSONString();
                            break;
                        case IRaceOperation.SELECT_RACE:
                            racePK = (IRacePK)JSONRace.toRacePK((JSONObject)json.get("racepk"));
                            result = JSONRace.toJSON(blrace.getRace(racePK)).toJSONString();
                            break;
                        case IRaceOperation.SELECT_Faction:
                            IFactionPK factionPK = (IFactionPK)JSONFaction.toFactionPK((JSONObject)json.get("factionpk"));
                            result = JSONRace.toJSONArray(blrace.getRaces4faction(factionPK)).toJSONString();
                            break;
                        case IRaceOperation.SELECT_SEARCH:
                            IRacesearch search = (IRacesearch)JSONRace.toRacesearch((JSONObject)json.get("search"));
                            result = JSONRace.toJSONArray(blrace.search(search)).toJSONString();
                            break;
                        case IRaceOperation.SELECT_SEARCHCOUNT:
                            IRacesearch racesearch = (IRacesearch)JSONRace.toRacesearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blrace.searchcount(racesearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREINSERT:
                    switch(operation) {
                        case IRaceOperation.INSERT_RACE:
                            race = (IRace)JSONRace.toRace((JSONObject)json.get("race"));
                            blrace.secureinsertRace(race);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREUPDATE:
                    switch(operation) {
                        case IRaceOperation.UPDATE_RACE:
                            JSONObject jsonrace = (JSONObject)json.get("race");
                            racePK = JSONRace.toRacePK((JSONObject)jsonrace.get("PK"));
                            race = blrace.getRace(racePK);
                            JSONRace.updateRace(race, jsonrace);
                            blrace.secureupdateRace(race);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREDELETE:
                    switch(operation) {
                        case IRaceOperation.DELETE_RACE:
                            race = (IRace)JSONRace.toRace((JSONObject)json.get("race"));
                            blrace.securedeleteRace(race);
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
     * PUT method for updating or creating an instance of RSRace
     * @param content representation for the resource
     */
    @PUT
    @Consumes("text/html")
    public void put(String content) {
    }
}

