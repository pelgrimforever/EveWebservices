/*
 * RSSystemjumps.java
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
import eve.interfaces.searchentity.ISystemjumpssearch;
import eve.interfaces.servlet.ISystemjumpsOperation;
import eve.logicentity.Systemjumps;
import eve.searchentity.Systemjumpssearch;
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
@Path("rssystemjumps")
public class RSSystemjumps {

    /**
     * Creates a new instance of HelloWorld
     */
    public RSSystemjumps() {
    }

    /**
     * Retrieves representation of an instance of systemjumps.restservices.RSSystemjumps
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{json}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@PathParam("json") String jsonstring) {
        try {
            BLsystemjumps blsystemjumps = new BLsystemjumps();
            ArrayList systemjumpss = blsystemjumps.getAll();
            JSONArray jsonsystemjumpss = JSONSystemjumps.toJSONArray(systemjumpss);
            return jsonsystemjumpss.toJSONString();
        }
        catch(DBException e) {
            return "{ \"status\": \"error\"}";
        }
    }

    /**
     * Retrieves representation of an instance of systemjumps.restservices.RSSystemjumps
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        String result = "";
        BLsystemjumps blsystemjumps = new BLsystemjumps();
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject)parser.parse(jsonstring);
            JSONObject jsonoperation = (JSONObject)json.get("operation");
            byte operationtype = JSONConversion.getbyte(jsonoperation, "type");
            byte operation = JSONConversion.getbyte(jsonoperation, "operation");
            ISystemjumpsPK systemjumpsPK;
            ISystemjumps systemjumps;
//Security parameters
            boolean loggedin = RSsecurity.check(json);
            blsystemjumps.setAuthenticated(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    switch(operation) {
                        case ISystemjumpsOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blsystemjumps.count());
                            result = jsoncount.toJSONString();
                            break;
                        case ISystemjumpsOperation.SELECT_ALL:
                            result = JSONSystemjumps.toJSONArray(blsystemjumps.getSystemjumpss()).toJSONString();
                            break;
                        case ISystemjumpsOperation.SELECT_SYSTEMJUMPS:
                            systemjumpsPK = (ISystemjumpsPK)JSONSystemjumps.toSystemjumpsPK((JSONObject)json.get("systemjumpspk"));
                            result = JSONSystemjumps.toJSON(blsystemjumps.getSystemjumps(systemjumpsPK)).toJSONString();
                            break;
                        case ISystemjumpsOperation.SELECT_Systemsystem_end:
                            ISystemPK systemSystem_endPK = (ISystemPK)JSONSystem.toSystemPK((JSONObject)json.get("systempk"));
                            result = JSONSystemjumps.toJSONArray(blsystemjumps.getSystemjumpss4systemSystem_end(systemSystem_endPK)).toJSONString();
                            break;
                        case ISystemjumpsOperation.SELECT_Systemsystem_start:
                            ISystemPK systemSystem_startPK = (ISystemPK)JSONSystem.toSystemPK((JSONObject)json.get("systempk"));
                            result = JSONSystemjumps.toJSONArray(blsystemjumps.getSystemjumpss4systemSystem_start(systemSystem_startPK)).toJSONString();
                            break;
                        case ISystemjumpsOperation.SELECT_SEARCH:
                            ISystemjumpssearch search = (ISystemjumpssearch)JSONSystemjumps.toSystemjumpssearch((JSONObject)json.get("search"));
                            result = JSONSystemjumps.toJSONArray(blsystemjumps.search(search)).toJSONString();
                            break;
                        case ISystemjumpsOperation.SELECT_SEARCHCOUNT:
                            ISystemjumpssearch systemjumpssearch = (ISystemjumpssearch)JSONSystemjumps.toSystemjumpssearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blsystemjumps.searchcount(systemjumpssearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(operation) {
                        case ISystemjumpsOperation.INSERT_SYSTEMJUMPS:
                            systemjumps = (ISystemjumps)JSONSystemjumps.toSystemjumps((JSONObject)json.get("systemjumps"));
                            blsystemjumps.insertSystemjumps(systemjumps);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(operation) {
                        case ISystemjumpsOperation.UPDATE_SYSTEMJUMPS:
                            JSONObject jsonsystemjumps = (JSONObject)json.get("systemjumps");
                            systemjumpsPK = JSONSystemjumps.toSystemjumpsPK((JSONObject)jsonsystemjumps.get("PK"));
                            systemjumps = blsystemjumps.getSystemjumps(systemjumpsPK);
                            JSONSystemjumps.updateSystemjumps(systemjumps, jsonsystemjumps);
                            blsystemjumps.updateSystemjumps(systemjumps);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(operation) {
                        case ISystemjumpsOperation.DELETE_SYSTEMJUMPS:
                            systemjumps = (ISystemjumps)JSONSystemjumps.toSystemjumps((JSONObject)json.get("systemjumps"));
                            blsystemjumps.deleteSystemjumps(systemjumps);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECURESELECT:
                    switch(operation) {
                        case ISystemjumpsOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blsystemjumps.count());
                            result = jsoncount.toJSONString();
                            break;
                        case ISystemjumpsOperation.SELECT_ALL:
                            result = JSONSystemjumps.toJSONArray(blsystemjumps.getSystemjumpss()).toJSONString();
                            break;
                        case ISystemjumpsOperation.SELECT_SYSTEMJUMPS:
                            systemjumpsPK = (ISystemjumpsPK)JSONSystemjumps.toSystemjumpsPK((JSONObject)json.get("systemjumpspk"));
                            result = JSONSystemjumps.toJSON(blsystemjumps.getSystemjumps(systemjumpsPK)).toJSONString();
                            break;
                        case ISystemjumpsOperation.SELECT_Systemsystem_end:
                            ISystemPK systemSystem_endPK = (ISystemPK)JSONSystem.toSystemPK((JSONObject)json.get("systempk"));
                            result = JSONSystemjumps.toJSONArray(blsystemjumps.getSystemjumpss4systemSystem_end(systemSystem_endPK)).toJSONString();
                            break;
                        case ISystemjumpsOperation.SELECT_Systemsystem_start:
                            ISystemPK systemSystem_startPK = (ISystemPK)JSONSystem.toSystemPK((JSONObject)json.get("systempk"));
                            result = JSONSystemjumps.toJSONArray(blsystemjumps.getSystemjumpss4systemSystem_start(systemSystem_startPK)).toJSONString();
                            break;
                        case ISystemjumpsOperation.SELECT_SEARCH:
                            ISystemjumpssearch search = (ISystemjumpssearch)JSONSystemjumps.toSystemjumpssearch((JSONObject)json.get("search"));
                            result = JSONSystemjumps.toJSONArray(blsystemjumps.search(search)).toJSONString();
                            break;
                        case ISystemjumpsOperation.SELECT_SEARCHCOUNT:
                            ISystemjumpssearch systemjumpssearch = (ISystemjumpssearch)JSONSystemjumps.toSystemjumpssearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blsystemjumps.searchcount(systemjumpssearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREINSERT:
                    switch(operation) {
                        case ISystemjumpsOperation.INSERT_SYSTEMJUMPS:
                            systemjumps = (ISystemjumps)JSONSystemjumps.toSystemjumps((JSONObject)json.get("systemjumps"));
                            blsystemjumps.secureinsertSystemjumps(systemjumps);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREUPDATE:
                    switch(operation) {
                        case ISystemjumpsOperation.UPDATE_SYSTEMJUMPS:
                            JSONObject jsonsystemjumps = (JSONObject)json.get("systemjumps");
                            systemjumpsPK = JSONSystemjumps.toSystemjumpsPK((JSONObject)jsonsystemjumps.get("PK"));
                            systemjumps = blsystemjumps.getSystemjumps(systemjumpsPK);
                            JSONSystemjumps.updateSystemjumps(systemjumps, jsonsystemjumps);
                            blsystemjumps.secureupdateSystemjumps(systemjumps);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREDELETE:
                    switch(operation) {
                        case ISystemjumpsOperation.DELETE_SYSTEMJUMPS:
                            systemjumps = (ISystemjumps)JSONSystemjumps.toSystemjumps((JSONObject)json.get("systemjumps"));
                            blsystemjumps.securedeleteSystemjumps(systemjumps);
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
     * PUT method for updating or creating an instance of RSSystemjumps
     * @param content representation for the resource
     */
    @PUT
    @Consumes("text/html")
    public void put(String content) {
    }
}

