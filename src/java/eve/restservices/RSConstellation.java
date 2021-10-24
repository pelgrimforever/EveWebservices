/*
 * RSConstellation.java
 *
 * Generated on 24.9.2021 14:40
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
import eve.interfaces.searchentity.IConstellationsearch;
import eve.interfaces.servlet.IConstellationOperation;
import eve.logicentity.Constellation;
import eve.searchentity.Constellationsearch;
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
@Path("rsconstellation")
public class RSConstellation {

    /**
     * Creates a new instance of HelloWorld
     */
    public RSConstellation() {
    }

    /**
     * Retrieves representation of an instance of constellation.restservices.RSConstellation
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{json}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@PathParam("json") String jsonstring) {
        try {
            BLconstellation blconstellation = new BLconstellation();
            ArrayList constellations = blconstellation.getAll();
            JSONArray jsonconstellations = JSONConstellation.toJSONArray(constellations);
            return jsonconstellations.toJSONString();
        }
        catch(DBException e) {
            return "{ \"status\": \"error\"}";
        }
    }

    /**
     * Retrieves representation of an instance of constellation.restservices.RSConstellation
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        String result = "";
        BLconstellation blconstellation = new BLconstellation();
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject)parser.parse(jsonstring);
            JSONObject jsonoperation = (JSONObject)json.get("operation");
            byte operationtype = JSONConversion.getbyte(jsonoperation, "type");
            byte operation = JSONConversion.getbyte(jsonoperation, "operation");
            IConstellationPK constellationPK;
            IConstellation constellation;
//Security parameters
            boolean loggedin = RSsecurity.check(json);
            blconstellation.setAuthenticated(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    switch(operation) {
                        case IConstellationOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blconstellation.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IConstellationOperation.SELECT_ALL:
                            result = JSONConstellation.toJSONArray(blconstellation.getConstellations()).toJSONString();
                            break;
                        case IConstellationOperation.SELECT_CONSTELLATION:
                            constellationPK = (IConstellationPK)JSONConstellation.toConstellationPK((JSONObject)json.get("constellationpk"));
                            result = JSONConstellation.toJSON(blconstellation.getConstellation(constellationPK)).toJSONString();
                            break;
                        case IConstellationOperation.SELECT_Region:
                            IRegionPK regionPK = (IRegionPK)JSONRegion.toRegionPK((JSONObject)json.get("regionpk"));
                            result = JSONConstellation.toJSONArray(blconstellation.getConstellations4region(regionPK)).toJSONString();
                            break;
                        case IConstellationOperation.SELECT_Constellation_neighbourneighbour:
                            IConstellation_neighbourPK constellation_neighbourNeighbourPK = (IConstellation_neighbourPK)JSONConstellation_neighbour.toConstellation_neighbourPK((JSONObject)json.get("constellation_neighbourpk"));
                            result = JSONConstellation.toJSON(blconstellation.getConstellation_neighbourneighbour(constellation_neighbourNeighbourPK)).toJSONString();
                            break;
                        case IConstellationOperation.SELECT_Constellation_neighbourconstellation:
                            IConstellation_neighbourPK constellation_neighbourConstellationPK = (IConstellation_neighbourPK)JSONConstellation_neighbour.toConstellation_neighbourPK((JSONObject)json.get("constellation_neighbourpk"));
                            result = JSONConstellation.toJSON(blconstellation.getConstellation_neighbourconstellation(constellation_neighbourConstellationPK)).toJSONString();
                            break;
                        case IConstellationOperation.SELECT_SEARCH:
                            IConstellationsearch search = (IConstellationsearch)JSONConstellation.toConstellationsearch((JSONObject)json.get("search"));
                            result = JSONConstellation.toJSONArray(blconstellation.search(search)).toJSONString();
                            break;
                        case IConstellationOperation.SELECT_SEARCHCOUNT:
                            IConstellationsearch constellationsearch = (IConstellationsearch)JSONConstellation.toConstellationsearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blconstellation.searchcount(constellationsearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(operation) {
                        case IConstellationOperation.INSERT_CONSTELLATION:
                            constellation = (IConstellation)JSONConstellation.toConstellation((JSONObject)json.get("constellation"));
                            blconstellation.insertConstellation(constellation);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(operation) {
                        case IConstellationOperation.UPDATE_CONSTELLATION:
                            JSONObject jsonconstellation = (JSONObject)json.get("constellation");
                            constellationPK = JSONConstellation.toConstellationPK((JSONObject)jsonconstellation.get("PK"));
                            constellation = blconstellation.getConstellation(constellationPK);
                            JSONConstellation.updateConstellation(constellation, jsonconstellation);
                            blconstellation.updateConstellation(constellation);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(operation) {
                        case IConstellationOperation.DELETE_CONSTELLATION:
                            constellation = (IConstellation)JSONConstellation.toConstellation((JSONObject)json.get("constellation"));
                            blconstellation.deleteConstellation(constellation);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECURESELECT:
                    switch(operation) {
                        case IConstellationOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blconstellation.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IConstellationOperation.SELECT_ALL:
                            result = JSONConstellation.toJSONArray(blconstellation.getConstellations()).toJSONString();
                            break;
                        case IConstellationOperation.SELECT_CONSTELLATION:
                            constellationPK = (IConstellationPK)JSONConstellation.toConstellationPK((JSONObject)json.get("constellationpk"));
                            result = JSONConstellation.toJSON(blconstellation.getConstellation(constellationPK)).toJSONString();
                            break;
                        case IConstellationOperation.SELECT_Region:
                            IRegionPK regionPK = (IRegionPK)JSONRegion.toRegionPK((JSONObject)json.get("regionpk"));
                            result = JSONConstellation.toJSONArray(blconstellation.getConstellations4region(regionPK)).toJSONString();
                            break;
                        case IConstellationOperation.SELECT_Constellation_neighbourneighbour:
                            IConstellation_neighbourPK constellation_neighbourNeighbourPK = (IConstellation_neighbourPK)JSONConstellation_neighbour.toConstellation_neighbourPK((JSONObject)json.get("constellation_neighbourpk"));
                            result = JSONConstellation.toJSON(blconstellation.getConstellation_neighbourneighbour(constellation_neighbourNeighbourPK)).toJSONString();
                            break;
                        case IConstellationOperation.SELECT_Constellation_neighbourconstellation:
                            IConstellation_neighbourPK constellation_neighbourConstellationPK = (IConstellation_neighbourPK)JSONConstellation_neighbour.toConstellation_neighbourPK((JSONObject)json.get("constellation_neighbourpk"));
                            result = JSONConstellation.toJSON(blconstellation.getConstellation_neighbourconstellation(constellation_neighbourConstellationPK)).toJSONString();
                            break;
                        case IConstellationOperation.SELECT_SEARCH:
                            IConstellationsearch search = (IConstellationsearch)JSONConstellation.toConstellationsearch((JSONObject)json.get("search"));
                            result = JSONConstellation.toJSONArray(blconstellation.search(search)).toJSONString();
                            break;
                        case IConstellationOperation.SELECT_SEARCHCOUNT:
                            IConstellationsearch constellationsearch = (IConstellationsearch)JSONConstellation.toConstellationsearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blconstellation.searchcount(constellationsearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREINSERT:
                    switch(operation) {
                        case IConstellationOperation.INSERT_CONSTELLATION:
                            constellation = (IConstellation)JSONConstellation.toConstellation((JSONObject)json.get("constellation"));
                            blconstellation.secureinsertConstellation(constellation);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREUPDATE:
                    switch(operation) {
                        case IConstellationOperation.UPDATE_CONSTELLATION:
                            JSONObject jsonconstellation = (JSONObject)json.get("constellation");
                            constellationPK = JSONConstellation.toConstellationPK((JSONObject)jsonconstellation.get("PK"));
                            constellation = blconstellation.getConstellation(constellationPK);
                            JSONConstellation.updateConstellation(constellation, jsonconstellation);
                            blconstellation.secureupdateConstellation(constellation);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREDELETE:
                    switch(operation) {
                        case IConstellationOperation.DELETE_CONSTELLATION:
                            constellation = (IConstellation)JSONConstellation.toConstellation((JSONObject)json.get("constellation"));
                            blconstellation.securedeleteConstellation(constellation);
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
     * PUT method for updating or creating an instance of RSConstellation
     * @param content representation for the resource
     */
    @PUT
    @Consumes("text/html")
    public void put(String content) {
    }
}

