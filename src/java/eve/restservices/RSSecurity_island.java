/*
 * RSSecurity_island.java
 *
 * Generated on 25.9.2021 15:16
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
import eve.interfaces.searchentity.ISecurity_islandsearch;
import eve.interfaces.servlet.ISecurity_islandOperation;
import eve.logicentity.Security_island;
import eve.searchentity.Security_islandsearch;
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
@Path("rssecurity_island")
public class RSSecurity_island {

    /**
     * Creates a new instance of HelloWorld
     */
    public RSSecurity_island() {
    }

    /**
     * Retrieves representation of an instance of security_island.restservices.RSSecurity_island
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{json}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@PathParam("json") String jsonstring) {
        try {
            BLsecurity_island blsecurity_island = new BLsecurity_island();
            ArrayList security_islands = blsecurity_island.getAll();
            JSONArray jsonsecurity_islands = JSONSecurity_island.toJSONArray(security_islands);
            return jsonsecurity_islands.toJSONString();
        }
        catch(DBException e) {
            return "{ \"status\": \"error\"}";
        }
    }

    /**
     * Retrieves representation of an instance of security_island.restservices.RSSecurity_island
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        String result = "";
        BLsecurity_island blsecurity_island = new BLsecurity_island();
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject)parser.parse(jsonstring);
            JSONObject jsonoperation = (JSONObject)json.get("operation");
            byte operationtype = JSONConversion.getbyte(jsonoperation, "type");
            byte operation = JSONConversion.getbyte(jsonoperation, "operation");
            ISecurity_islandPK security_islandPK;
            ISecurity_island security_island;
//Security parameters
            boolean loggedin = RSsecurity.check(json);
            blsecurity_island.setAuthenticated(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    switch(operation) {
                        case ISecurity_islandOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blsecurity_island.count());
                            result = jsoncount.toJSONString();
                            break;
                        case ISecurity_islandOperation.SELECT_ALL:
                            result = JSONSecurity_island.toJSONArray(blsecurity_island.getSecurity_islands()).toJSONString();
                            break;
                        case ISecurity_islandOperation.SELECT_SECURITY_ISLAND:
                            security_islandPK = (ISecurity_islandPK)JSONSecurity_island.toSecurity_islandPK((JSONObject)json.get("security_islandpk"));
                            result = JSONSecurity_island.toJSON(blsecurity_island.getSecurity_island(security_islandPK)).toJSONString();
                            break;
                        case ISecurity_islandOperation.SELECT_SEARCH:
                            ISecurity_islandsearch search = (ISecurity_islandsearch)JSONSecurity_island.toSecurity_islandsearch((JSONObject)json.get("search"));
                            result = JSONSecurity_island.toJSONArray(blsecurity_island.search(search)).toJSONString();
                            break;
                        case ISecurity_islandOperation.SELECT_SEARCHCOUNT:
                            ISecurity_islandsearch security_islandsearch = (ISecurity_islandsearch)JSONSecurity_island.toSecurity_islandsearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blsecurity_island.searchcount(security_islandsearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(operation) {
                        case ISecurity_islandOperation.INSERT_SECURITY_ISLAND:
                            security_island = (ISecurity_island)JSONSecurity_island.toSecurity_island((JSONObject)json.get("security_island"));
                            blsecurity_island.insertSecurity_island(security_island);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(operation) {
                        case ISecurity_islandOperation.UPDATE_SECURITY_ISLAND:
                            JSONObject jsonsecurity_island = (JSONObject)json.get("security_island");
                            security_islandPK = JSONSecurity_island.toSecurity_islandPK((JSONObject)jsonsecurity_island.get("PK"));
                            security_island = blsecurity_island.getSecurity_island(security_islandPK);
                            JSONSecurity_island.updateSecurity_island(security_island, jsonsecurity_island);
                            blsecurity_island.updateSecurity_island(security_island);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(operation) {
                        case ISecurity_islandOperation.DELETE_SECURITY_ISLAND:
                            security_island = (ISecurity_island)JSONSecurity_island.toSecurity_island((JSONObject)json.get("security_island"));
                            blsecurity_island.deleteSecurity_island(security_island);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECURESELECT:
                    switch(operation) {
                        case ISecurity_islandOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blsecurity_island.count());
                            result = jsoncount.toJSONString();
                            break;
                        case ISecurity_islandOperation.SELECT_ALL:
                            result = JSONSecurity_island.toJSONArray(blsecurity_island.getSecurity_islands()).toJSONString();
                            break;
                        case ISecurity_islandOperation.SELECT_SECURITY_ISLAND:
                            security_islandPK = (ISecurity_islandPK)JSONSecurity_island.toSecurity_islandPK((JSONObject)json.get("security_islandpk"));
                            result = JSONSecurity_island.toJSON(blsecurity_island.getSecurity_island(security_islandPK)).toJSONString();
                            break;
                        case ISecurity_islandOperation.SELECT_SEARCH:
                            ISecurity_islandsearch search = (ISecurity_islandsearch)JSONSecurity_island.toSecurity_islandsearch((JSONObject)json.get("search"));
                            result = JSONSecurity_island.toJSONArray(blsecurity_island.search(search)).toJSONString();
                            break;
                        case ISecurity_islandOperation.SELECT_SEARCHCOUNT:
                            ISecurity_islandsearch security_islandsearch = (ISecurity_islandsearch)JSONSecurity_island.toSecurity_islandsearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blsecurity_island.searchcount(security_islandsearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREINSERT:
                    switch(operation) {
                        case ISecurity_islandOperation.INSERT_SECURITY_ISLAND:
                            security_island = (ISecurity_island)JSONSecurity_island.toSecurity_island((JSONObject)json.get("security_island"));
                            blsecurity_island.secureinsertSecurity_island(security_island);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREUPDATE:
                    switch(operation) {
                        case ISecurity_islandOperation.UPDATE_SECURITY_ISLAND:
                            JSONObject jsonsecurity_island = (JSONObject)json.get("security_island");
                            security_islandPK = JSONSecurity_island.toSecurity_islandPK((JSONObject)jsonsecurity_island.get("PK"));
                            security_island = blsecurity_island.getSecurity_island(security_islandPK);
                            JSONSecurity_island.updateSecurity_island(security_island, jsonsecurity_island);
                            blsecurity_island.secureupdateSecurity_island(security_island);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREDELETE:
                    switch(operation) {
                        case ISecurity_islandOperation.DELETE_SECURITY_ISLAND:
                            security_island = (ISecurity_island)JSONSecurity_island.toSecurity_island((JSONObject)json.get("security_island"));
                            blsecurity_island.securedeleteSecurity_island(security_island);
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
     * PUT method for updating or creating an instance of RSSecurity_island
     * @param content representation for the resource
     */
    @PUT
    @Consumes("text/html")
    public void put(String content) {
    }
}

