/*
 * RSSyssettings.java
 *
 * Generated on 14.0.2022 16:56
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
import eve.interfaces.searchentity.ISyssettingssearch;
import eve.interfaces.servlet.ISyssettingsOperation;
import eve.logicentity.Syssettings;
import eve.searchentity.Syssettingssearch;
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
@Path("rssyssettings")
public class RSSyssettings {

    /**
     * Creates a new instance of HelloWorld
     */
    public RSSyssettings() {
    }

    /**
     * Retrieves representation of an instance of syssettings.restservices.RSSyssettings
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{json}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@PathParam("json") String jsonstring) {
        try {
            BLsyssettings blsyssettings = new BLsyssettings();
            ArrayList syssettingss = blsyssettings.getAll();
            JSONArray jsonsyssettingss = JSONSyssettings.toJSONArray(syssettingss);
            return jsonsyssettingss.toJSONString();
        }
        catch(DBException e) {
            return "{ \"status\": \"error\"}";
        }
    }

    /**
     * Retrieves representation of an instance of syssettings.restservices.RSSyssettings
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        String result = "";
        BLsyssettings blsyssettings = new BLsyssettings();
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject)parser.parse(jsonstring);
            JSONObject jsonoperation = (JSONObject)json.get("operation");
            byte operationtype = JSONConversion.getbyte(jsonoperation, "type");
            byte operation = JSONConversion.getbyte(jsonoperation, "operation");
            ISyssettingsPK syssettingsPK;
            ISyssettings syssettings;
//Security parameters
            boolean loggedin = RSsecurity.check(json);
            blsyssettings.setAuthenticated(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    switch(operation) {
                        case ISyssettingsOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blsyssettings.count());
                            result = jsoncount.toJSONString();
                            break;
                        case ISyssettingsOperation.SELECT_ALL:
                            result = JSONSyssettings.toJSONArray(blsyssettings.getSyssettingss()).toJSONString();
                            break;
                        case ISyssettingsOperation.SELECT_SYSSETTINGS:
                            syssettingsPK = (ISyssettingsPK)JSONSyssettings.toSyssettingsPK((JSONObject)json.get("syssettingspk"));
                            result = JSONSyssettings.toJSON(blsyssettings.getSyssettings(syssettingsPK)).toJSONString();
                            break;
                        case ISyssettingsOperation.SELECT_SEARCH:
                            ISyssettingssearch search = (ISyssettingssearch)JSONSyssettings.toSyssettingssearch((JSONObject)json.get("search"));
                            result = JSONSyssettings.toJSONArray(blsyssettings.search(search)).toJSONString();
                            break;
                        case ISyssettingsOperation.SELECT_SEARCHCOUNT:
                            ISyssettingssearch syssettingssearch = (ISyssettingssearch)JSONSyssettings.toSyssettingssearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blsyssettings.searchcount(syssettingssearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(operation) {
                        case ISyssettingsOperation.INSERT_SYSSETTINGS:
                            syssettings = (ISyssettings)JSONSyssettings.toSyssettings((JSONObject)json.get("syssettings"));
                            blsyssettings.insertSyssettings(syssettings);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(operation) {
                        case ISyssettingsOperation.UPDATE_SYSSETTINGS:
                            JSONObject jsonsyssettings = (JSONObject)json.get("syssettings");
                            syssettingsPK = JSONSyssettings.toSyssettingsPK((JSONObject)jsonsyssettings.get("PK"));
                            syssettings = blsyssettings.getSyssettings(syssettingsPK);
                            JSONSyssettings.updateSyssettings(syssettings, jsonsyssettings);
                            blsyssettings.updateSyssettings(syssettings);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(operation) {
                        case ISyssettingsOperation.DELETE_SYSSETTINGS:
                            syssettings = (ISyssettings)JSONSyssettings.toSyssettings((JSONObject)json.get("syssettings"));
                            blsyssettings.deleteSyssettings(syssettings);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECURESELECT:
                    switch(operation) {
                        case ISyssettingsOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blsyssettings.count());
                            result = jsoncount.toJSONString();
                            break;
                        case ISyssettingsOperation.SELECT_ALL:
                            result = JSONSyssettings.toJSONArray(blsyssettings.getSyssettingss()).toJSONString();
                            break;
                        case ISyssettingsOperation.SELECT_SYSSETTINGS:
                            syssettingsPK = (ISyssettingsPK)JSONSyssettings.toSyssettingsPK((JSONObject)json.get("syssettingspk"));
                            result = JSONSyssettings.toJSON(blsyssettings.getSyssettings(syssettingsPK)).toJSONString();
                            break;
                        case ISyssettingsOperation.SELECT_SEARCH:
                            ISyssettingssearch search = (ISyssettingssearch)JSONSyssettings.toSyssettingssearch((JSONObject)json.get("search"));
                            result = JSONSyssettings.toJSONArray(blsyssettings.search(search)).toJSONString();
                            break;
                        case ISyssettingsOperation.SELECT_SEARCHCOUNT:
                            ISyssettingssearch syssettingssearch = (ISyssettingssearch)JSONSyssettings.toSyssettingssearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blsyssettings.searchcount(syssettingssearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREINSERT:
                    switch(operation) {
                        case ISyssettingsOperation.INSERT_SYSSETTINGS:
                            syssettings = (ISyssettings)JSONSyssettings.toSyssettings((JSONObject)json.get("syssettings"));
                            blsyssettings.secureinsertSyssettings(syssettings);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREUPDATE:
                    switch(operation) {
                        case ISyssettingsOperation.UPDATE_SYSSETTINGS:
                            JSONObject jsonsyssettings = (JSONObject)json.get("syssettings");
                            syssettingsPK = JSONSyssettings.toSyssettingsPK((JSONObject)jsonsyssettings.get("PK"));
                            syssettings = blsyssettings.getSyssettings(syssettingsPK);
                            JSONSyssettings.updateSyssettings(syssettings, jsonsyssettings);
                            blsyssettings.secureupdateSyssettings(syssettings);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREDELETE:
                    switch(operation) {
                        case ISyssettingsOperation.DELETE_SYSSETTINGS:
                            syssettings = (ISyssettings)JSONSyssettings.toSyssettings((JSONObject)json.get("syssettings"));
                            blsyssettings.securedeleteSyssettings(syssettings);
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
     * PUT method for updating or creating an instance of RSSyssettings
     * @param content representation for the resource
     */
    @PUT
    @Consumes("text/html")
    public void put(String content) {
    }
}

