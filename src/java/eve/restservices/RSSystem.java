/*
 * RSSystem.java
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
import eve.interfaces.searchentity.ISystemsearch;
import eve.interfaces.servlet.ISystemOperation;
import eve.logicentity.System;
import eve.searchentity.Systemsearch;
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
@Path("rssystem")
public class RSSystem {

    /**
     * Creates a new instance of HelloWorld
     */
    public RSSystem() {
    }

    /**
     * Retrieves representation of an instance of system.restservices.RSSystem
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{json}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@PathParam("json") String jsonstring) {
        try {
            BLsystem blsystem = new BLsystem();
            ArrayList systems = blsystem.getAll();
            JSONArray jsonsystems = JSONSystem.toJSONArray(systems);
            return jsonsystems.toJSONString();
        }
        catch(DBException e) {
            return "{ \"status\": \"error\"}";
        }
    }

    /**
     * Retrieves representation of an instance of system.restservices.RSSystem
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        String result = "";
        BLsystem blsystem = new BLsystem();
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject)parser.parse(jsonstring);
            JSONObject jsonoperation = (JSONObject)json.get("operation");
            byte operationtype = JSONConversion.getbyte(jsonoperation, "type");
            byte operation = JSONConversion.getbyte(jsonoperation, "operation");
            ISystemPK systemPK;
            ISystem system;
//Security parameters
            boolean loggedin = RSsecurity.check(json);
            blsystem.setAuthenticated(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    switch(operation) {
                        case ISystemOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blsystem.count());
                            result = jsoncount.toJSONString();
                            break;
                        case ISystemOperation.SELECT_ALL:
                            result = JSONSystem.toJSONArray(blsystem.getSystems()).toJSONString();
                            break;
                        case ISystemOperation.SELECT_SYSTEM:
                            systemPK = (ISystemPK)JSONSystem.toSystemPK((JSONObject)json.get("systempk"));
                            result = JSONSystem.toJSON(blsystem.getSystem(systemPK)).toJSONString();
                            break;
                        case ISystemOperation.SELECT_Security_island:
                            ISecurity_islandPK security_islandPK = (ISecurity_islandPK)JSONSecurity_island.toSecurity_islandPK((JSONObject)json.get("security_islandpk"));
                            result = JSONSystem.toJSONArray(blsystem.getSystems4security_island(security_islandPK)).toJSONString();
                            break;
                        case ISystemOperation.SELECT_Constellation:
                            IConstellationPK constellationPK = (IConstellationPK)JSONConstellation.toConstellationPK((JSONObject)json.get("constellationpk"));
                            result = JSONSystem.toJSONArray(blsystem.getSystems4constellation(constellationPK)).toJSONString();
                            break;
                        case ISystemOperation.SELECT_Systemjumpssystem_end:
                            ISystemjumpsPK systemjumpsSystem_endPK = (ISystemjumpsPK)JSONSystemjumps.toSystemjumpsPK((JSONObject)json.get("systemjumpspk"));
                            result = JSONSystem.toJSON(blsystem.getSystemjumpssystem_end(systemjumpsSystem_endPK)).toJSONString();
                            break;
                        case ISystemOperation.SELECT_Systemjumpssystem_start:
                            ISystemjumpsPK systemjumpsSystem_startPK = (ISystemjumpsPK)JSONSystemjumps.toSystemjumpsPK((JSONObject)json.get("systemjumpspk"));
                            result = JSONSystem.toJSON(blsystem.getSystemjumpssystem_start(systemjumpsSystem_startPK)).toJSONString();
                            break;
                        case ISystemOperation.SELECT_Route:
                            IRoutePK routePK = (IRoutePK)JSONRoute.toRoutePK((JSONObject)json.get("routepk"));
                            result = JSONSystem.toJSON(blsystem.getRoute(routePK)).toJSONString();
                            break;
                        case ISystemOperation.SELECT_Systemtradesell_system:
                            ISystemtradePK systemtradeSell_systemPK = (ISystemtradePK)JSONSystemtrade.toSystemtradePK((JSONObject)json.get("systemtradepk"));
                            result = JSONSystem.toJSON(blsystem.getSystemtradesell_system(systemtradeSell_systemPK)).toJSONString();
                            break;
                        case ISystemOperation.SELECT_Systemtradebuy_system:
                            ISystemtradePK systemtradeBuy_systemPK = (ISystemtradePK)JSONSystemtrade.toSystemtradePK((JSONObject)json.get("systemtradepk"));
                            result = JSONSystem.toJSON(blsystem.getSystemtradebuy_system(systemtradeBuy_systemPK)).toJSONString();
                            break;
                        case ISystemOperation.SELECT_SEARCH:
                            ISystemsearch search = (ISystemsearch)JSONSystem.toSystemsearch((JSONObject)json.get("search"));
                            result = JSONSystem.toJSONArray(blsystem.search(search)).toJSONString();
                            break;
                        case ISystemOperation.SELECT_SEARCHCOUNT:
                            ISystemsearch systemsearch = (ISystemsearch)JSONSystem.toSystemsearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blsystem.searchcount(systemsearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(operation) {
                        case ISystemOperation.INSERT_SYSTEM:
                            system = (ISystem)JSONSystem.toSystem((JSONObject)json.get("system"));
                            blsystem.insertSystem(system);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(operation) {
                        case ISystemOperation.UPDATE_SYSTEM:
                            JSONObject jsonsystem = (JSONObject)json.get("system");
                            systemPK = JSONSystem.toSystemPK((JSONObject)jsonsystem.get("PK"));
                            system = blsystem.getSystem(systemPK);
                            JSONSystem.updateSystem(system, jsonsystem);
                            blsystem.updateSystem(system);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(operation) {
                        case ISystemOperation.DELETE_SYSTEM:
                            system = (ISystem)JSONSystem.toSystem((JSONObject)json.get("system"));
                            blsystem.deleteSystem(system);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECURESELECT:
                    switch(operation) {
                        case ISystemOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blsystem.count());
                            result = jsoncount.toJSONString();
                            break;
                        case ISystemOperation.SELECT_ALL:
                            result = JSONSystem.toJSONArray(blsystem.getSystems()).toJSONString();
                            break;
                        case ISystemOperation.SELECT_SYSTEM:
                            systemPK = (ISystemPK)JSONSystem.toSystemPK((JSONObject)json.get("systempk"));
                            result = JSONSystem.toJSON(blsystem.getSystem(systemPK)).toJSONString();
                            break;
                        case ISystemOperation.SELECT_Security_island:
                            ISecurity_islandPK security_islandPK = (ISecurity_islandPK)JSONSecurity_island.toSecurity_islandPK((JSONObject)json.get("security_islandpk"));
                            result = JSONSystem.toJSONArray(blsystem.getSystems4security_island(security_islandPK)).toJSONString();
                            break;
                        case ISystemOperation.SELECT_Constellation:
                            IConstellationPK constellationPK = (IConstellationPK)JSONConstellation.toConstellationPK((JSONObject)json.get("constellationpk"));
                            result = JSONSystem.toJSONArray(blsystem.getSystems4constellation(constellationPK)).toJSONString();
                            break;
                        case ISystemOperation.SELECT_Systemjumpssystem_end:
                            ISystemjumpsPK systemjumpsSystem_endPK = (ISystemjumpsPK)JSONSystemjumps.toSystemjumpsPK((JSONObject)json.get("systemjumpspk"));
                            result = JSONSystem.toJSON(blsystem.getSystemjumpssystem_end(systemjumpsSystem_endPK)).toJSONString();
                            break;
                        case ISystemOperation.SELECT_Systemjumpssystem_start:
                            ISystemjumpsPK systemjumpsSystem_startPK = (ISystemjumpsPK)JSONSystemjumps.toSystemjumpsPK((JSONObject)json.get("systemjumpspk"));
                            result = JSONSystem.toJSON(blsystem.getSystemjumpssystem_start(systemjumpsSystem_startPK)).toJSONString();
                            break;
                        case ISystemOperation.SELECT_Route:
                            IRoutePK routePK = (IRoutePK)JSONRoute.toRoutePK((JSONObject)json.get("routepk"));
                            result = JSONSystem.toJSON(blsystem.getRoute(routePK)).toJSONString();
                            break;
                        case ISystemOperation.SELECT_Systemtradesell_system:
                            ISystemtradePK systemtradeSell_systemPK = (ISystemtradePK)JSONSystemtrade.toSystemtradePK((JSONObject)json.get("systemtradepk"));
                            result = JSONSystem.toJSON(blsystem.getSystemtradesell_system(systemtradeSell_systemPK)).toJSONString();
                            break;
                        case ISystemOperation.SELECT_Systemtradebuy_system:
                            ISystemtradePK systemtradeBuy_systemPK = (ISystemtradePK)JSONSystemtrade.toSystemtradePK((JSONObject)json.get("systemtradepk"));
                            result = JSONSystem.toJSON(blsystem.getSystemtradebuy_system(systemtradeBuy_systemPK)).toJSONString();
                            break;
                        case ISystemOperation.SELECT_SEARCH:
                            ISystemsearch search = (ISystemsearch)JSONSystem.toSystemsearch((JSONObject)json.get("search"));
                            result = JSONSystem.toJSONArray(blsystem.search(search)).toJSONString();
                            break;
                        case ISystemOperation.SELECT_SEARCHCOUNT:
                            ISystemsearch systemsearch = (ISystemsearch)JSONSystem.toSystemsearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blsystem.searchcount(systemsearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREINSERT:
                    switch(operation) {
                        case ISystemOperation.INSERT_SYSTEM:
                            system = (ISystem)JSONSystem.toSystem((JSONObject)json.get("system"));
                            blsystem.secureinsertSystem(system);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREUPDATE:
                    switch(operation) {
                        case ISystemOperation.UPDATE_SYSTEM:
                            JSONObject jsonsystem = (JSONObject)json.get("system");
                            systemPK = JSONSystem.toSystemPK((JSONObject)jsonsystem.get("PK"));
                            system = blsystem.getSystem(systemPK);
                            JSONSystem.updateSystem(system, jsonsystem);
                            blsystem.secureupdateSystem(system);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREDELETE:
                    switch(operation) {
                        case ISystemOperation.DELETE_SYSTEM:
                            system = (ISystem)JSONSystem.toSystem((JSONObject)json.get("system"));
                            blsystem.securedeleteSystem(system);
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
     * PUT method for updating or creating an instance of RSSystem
     * @param content representation for the resource
     */
    @PUT
    @Consumes("text/html")
    public void put(String content) {
    }
}

