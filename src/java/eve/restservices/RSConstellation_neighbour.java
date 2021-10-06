/*
 * RSConstellation_neighbour.java
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
import eve.interfaces.searchentity.IConstellation_neighboursearch;
import eve.interfaces.servlet.IConstellation_neighbourOperation;
import eve.logicentity.Constellation_neighbour;
import eve.searchentity.Constellation_neighboursearch;
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
@Path("rsconstellation_neighbour")
public class RSConstellation_neighbour {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of HelloWorld
     */
    public RSConstellation_neighbour() {
    }

    /**
     * Retrieves representation of an instance of constellation_neighbour.restservices.RSConstellation_neighbour
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{json}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@PathParam("json") String jsonstring) {
        try {
            BLconstellation_neighbour blconstellation_neighbour = new BLconstellation_neighbour();
            ArrayList constellation_neighbours = blconstellation_neighbour.getAll();
            JSONArray jsonconstellation_neighbours = JSONConstellation_neighbour.toJSONArray(constellation_neighbours);
            return jsonconstellation_neighbours.toJSONString();
        }
        catch(DBException e) {
            return "{ \"status\": \"error\"}";
        }
    }

    /**
     * Retrieves representation of an instance of constellation_neighbour.restservices.RSConstellation_neighbour
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        String result = "";
        BLconstellation_neighbour blconstellation_neighbour = new BLconstellation_neighbour();
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject)parser.parse(jsonstring);
            JSONObject jsonoperation = (JSONObject)json.get("operation");
            byte operationtype = JSONConversion.getbyte(jsonoperation, "type");
            byte operation = JSONConversion.getbyte(jsonoperation, "operation");
            IConstellation_neighbourPK constellation_neighbourPK;
            IConstellation_neighbour constellation_neighbour;
//Security parameters
            boolean loggedin = RSsecurity.check(json);
            blconstellation_neighbour.setAuthenticated(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    switch(operation) {
                        case IConstellation_neighbourOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blconstellation_neighbour.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IConstellation_neighbourOperation.SELECT_ALL:
                            result = JSONConstellation_neighbour.toJSONArray(blconstellation_neighbour.getConstellation_neighbours()).toJSONString();
                            break;
                        case IConstellation_neighbourOperation.SELECT_CONSTELLATION_NEIGHBOUR:
                            constellation_neighbourPK = (IConstellation_neighbourPK)JSONConstellation_neighbour.toConstellation_neighbourPK((JSONObject)json.get("constellation_neighbourpk"));
                            result = JSONConstellation_neighbour.toJSON(blconstellation_neighbour.getConstellation_neighbour(constellation_neighbourPK)).toJSONString();
                            break;
                        case IConstellation_neighbourOperation.SELECT_Constellationneighbour:
                            IConstellationPK constellationNeighbourPK = (IConstellationPK)JSONConstellation.toConstellationPK((JSONObject)json.get("constellationpk"));
                            result = JSONConstellation_neighbour.toJSONArray(blconstellation_neighbour.getConstellation_neighbours4constellationNeighbour(constellationNeighbourPK)).toJSONString();
                            break;
                        case IConstellation_neighbourOperation.SELECT_Constellationconstellation:
                            IConstellationPK constellationConstellationPK = (IConstellationPK)JSONConstellation.toConstellationPK((JSONObject)json.get("constellationpk"));
                            result = JSONConstellation_neighbour.toJSONArray(blconstellation_neighbour.getConstellation_neighbours4constellationConstellation(constellationConstellationPK)).toJSONString();
                            break;
                        case IConstellation_neighbourOperation.SELECT_SEARCH:
                            IConstellation_neighboursearch search = (IConstellation_neighboursearch)JSONConstellation_neighbour.toConstellation_neighboursearch((JSONObject)json.get("search"));
                            result = JSONConstellation_neighbour.toJSONArray(blconstellation_neighbour.search(search)).toJSONString();
                            break;
                        case IConstellation_neighbourOperation.SELECT_SEARCHCOUNT:
                            IConstellation_neighboursearch constellation_neighboursearch = (IConstellation_neighboursearch)JSONConstellation_neighbour.toConstellation_neighboursearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blconstellation_neighbour.searchcount(constellation_neighboursearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(operation) {
                        case IConstellation_neighbourOperation.INSERT_CONSTELLATION_NEIGHBOUR:
                            constellation_neighbour = (IConstellation_neighbour)JSONConstellation_neighbour.toConstellation_neighbour((JSONObject)json.get("constellation_neighbour"));
                            blconstellation_neighbour.insertConstellation_neighbour(constellation_neighbour);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(operation) {
                        case IConstellation_neighbourOperation.UPDATE_CONSTELLATION_NEIGHBOUR:
                            JSONObject jsonconstellation_neighbour = (JSONObject)json.get("constellation_neighbour");
                            constellation_neighbourPK = JSONConstellation_neighbour.toConstellation_neighbourPK((JSONObject)jsonconstellation_neighbour.get("PK"));
                            constellation_neighbour = blconstellation_neighbour.getConstellation_neighbour(constellation_neighbourPK);
                            JSONConstellation_neighbour.updateConstellation_neighbour(constellation_neighbour, jsonconstellation_neighbour);
                            blconstellation_neighbour.updateConstellation_neighbour(constellation_neighbour);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(operation) {
                        case IConstellation_neighbourOperation.DELETE_CONSTELLATION_NEIGHBOUR:
                            constellation_neighbour = (IConstellation_neighbour)JSONConstellation_neighbour.toConstellation_neighbour((JSONObject)json.get("constellation_neighbour"));
                            blconstellation_neighbour.deleteConstellation_neighbour(constellation_neighbour);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECURESELECT:
                    switch(operation) {
                        case IConstellation_neighbourOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blconstellation_neighbour.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IConstellation_neighbourOperation.SELECT_ALL:
                            result = JSONConstellation_neighbour.toJSONArray(blconstellation_neighbour.getConstellation_neighbours()).toJSONString();
                            break;
                        case IConstellation_neighbourOperation.SELECT_CONSTELLATION_NEIGHBOUR:
                            constellation_neighbourPK = (IConstellation_neighbourPK)JSONConstellation_neighbour.toConstellation_neighbourPK((JSONObject)json.get("constellation_neighbourpk"));
                            result = JSONConstellation_neighbour.toJSON(blconstellation_neighbour.getConstellation_neighbour(constellation_neighbourPK)).toJSONString();
                            break;
                        case IConstellation_neighbourOperation.SELECT_Constellationneighbour:
                            IConstellationPK constellationNeighbourPK = (IConstellationPK)JSONConstellation.toConstellationPK((JSONObject)json.get("constellationpk"));
                            result = JSONConstellation_neighbour.toJSONArray(blconstellation_neighbour.getConstellation_neighbours4constellationNeighbour(constellationNeighbourPK)).toJSONString();
                            break;
                        case IConstellation_neighbourOperation.SELECT_Constellationconstellation:
                            IConstellationPK constellationConstellationPK = (IConstellationPK)JSONConstellation.toConstellationPK((JSONObject)json.get("constellationpk"));
                            result = JSONConstellation_neighbour.toJSONArray(blconstellation_neighbour.getConstellation_neighbours4constellationConstellation(constellationConstellationPK)).toJSONString();
                            break;
                        case IConstellation_neighbourOperation.SELECT_SEARCH:
                            IConstellation_neighboursearch search = (IConstellation_neighboursearch)JSONConstellation_neighbour.toConstellation_neighboursearch((JSONObject)json.get("search"));
                            result = JSONConstellation_neighbour.toJSONArray(blconstellation_neighbour.search(search)).toJSONString();
                            break;
                        case IConstellation_neighbourOperation.SELECT_SEARCHCOUNT:
                            IConstellation_neighboursearch constellation_neighboursearch = (IConstellation_neighboursearch)JSONConstellation_neighbour.toConstellation_neighboursearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blconstellation_neighbour.searchcount(constellation_neighboursearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREINSERT:
                    switch(operation) {
                        case IConstellation_neighbourOperation.INSERT_CONSTELLATION_NEIGHBOUR:
                            constellation_neighbour = (IConstellation_neighbour)JSONConstellation_neighbour.toConstellation_neighbour((JSONObject)json.get("constellation_neighbour"));
                            blconstellation_neighbour.secureinsertConstellation_neighbour(constellation_neighbour);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREUPDATE:
                    switch(operation) {
                        case IConstellation_neighbourOperation.UPDATE_CONSTELLATION_NEIGHBOUR:
                            JSONObject jsonconstellation_neighbour = (JSONObject)json.get("constellation_neighbour");
                            constellation_neighbourPK = JSONConstellation_neighbour.toConstellation_neighbourPK((JSONObject)jsonconstellation_neighbour.get("PK"));
                            constellation_neighbour = blconstellation_neighbour.getConstellation_neighbour(constellation_neighbourPK);
                            JSONConstellation_neighbour.updateConstellation_neighbour(constellation_neighbour, jsonconstellation_neighbour);
                            blconstellation_neighbour.secureupdateConstellation_neighbour(constellation_neighbour);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREDELETE:
                    switch(operation) {
                        case IConstellation_neighbourOperation.DELETE_CONSTELLATION_NEIGHBOUR:
                            constellation_neighbour = (IConstellation_neighbour)JSONConstellation_neighbour.toConstellation_neighbour((JSONObject)json.get("constellation_neighbour"));
                            blconstellation_neighbour.securedeleteConstellation_neighbour(constellation_neighbour);
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
     * PUT method for updating or creating an instance of RSConstellation_neighbour
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("text/html")
    public void put(String content) {
    }
}

