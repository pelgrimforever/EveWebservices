/*
 * RSStargate.java
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
import eve.interfaces.searchentity.IStargatesearch;
import eve.interfaces.servlet.IStargateOperation;
import eve.logicentity.Stargate;
import eve.searchentity.Stargatesearch;
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
@Path("rsstargate")
public class RSStargate {

    /**
     * Creates a new instance of HelloWorld
     */
    public RSStargate() {
    }

    /**
     * Retrieves representation of an instance of stargate.restservices.RSStargate
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{json}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@PathParam("json") String jsonstring) {
        try {
            BLstargate blstargate = new BLstargate();
            ArrayList stargates = blstargate.getAll();
            JSONArray jsonstargates = JSONStargate.toJSONArray(stargates);
            return jsonstargates.toJSONString();
        }
        catch(DBException e) {
            return "{ \"status\": \"error\"}";
        }
    }

    /**
     * Retrieves representation of an instance of stargate.restservices.RSStargate
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        String result = "";
        BLstargate blstargate = new BLstargate();
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject)parser.parse(jsonstring);
            JSONObject jsonoperation = (JSONObject)json.get("operation");
            byte operationtype = JSONConversion.getbyte(jsonoperation, "type");
            byte operation = JSONConversion.getbyte(jsonoperation, "operation");
            IStargatePK stargatePK;
            IStargate stargate;
//Security parameters
            boolean loggedin = RSsecurity.check(json);
            blstargate.setAuthenticated(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    switch(operation) {
                        case IStargateOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blstargate.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IStargateOperation.SELECT_ALL:
                            result = JSONStargate.toJSONArray(blstargate.getStargates()).toJSONString();
                            break;
                        case IStargateOperation.SELECT_STARGATE:
                            stargatePK = (IStargatePK)JSONStargate.toStargatePK((JSONObject)json.get("stargatepk"));
                            result = JSONStargate.toJSON(blstargate.getStargate(stargatePK)).toJSONString();
                            break;
                        case IStargateOperation.SELECT_Systemsystem:
                            ISystemPK systemSystemPK = (ISystemPK)JSONSystem.toSystemPK((JSONObject)json.get("systempk"));
                            result = JSONStargate.toJSONArray(blstargate.getStargates4systemSystem(systemSystemPK)).toJSONString();
                            break;
                        case IStargateOperation.SELECT_Systemto_system:
                            ISystemPK systemTo_systemPK = (ISystemPK)JSONSystem.toSystemPK((JSONObject)json.get("systempk"));
                            result = JSONStargate.toJSONArray(blstargate.getStargates4systemTo_system(systemTo_systemPK)).toJSONString();
                            break;
                        case IStargateOperation.SELECT_SEARCH:
                            IStargatesearch search = (IStargatesearch)JSONStargate.toStargatesearch((JSONObject)json.get("search"));
                            result = JSONStargate.toJSONArray(blstargate.search(search)).toJSONString();
                            break;
                        case IStargateOperation.SELECT_SEARCHCOUNT:
                            IStargatesearch stargatesearch = (IStargatesearch)JSONStargate.toStargatesearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blstargate.searchcount(stargatesearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(operation) {
                        case IStargateOperation.INSERT_STARGATE:
                            stargate = (IStargate)JSONStargate.toStargate((JSONObject)json.get("stargate"));
                            blstargate.insertStargate(stargate);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(operation) {
                        case IStargateOperation.UPDATE_STARGATE:
                            JSONObject jsonstargate = (JSONObject)json.get("stargate");
                            stargatePK = JSONStargate.toStargatePK((JSONObject)jsonstargate.get("PK"));
                            stargate = blstargate.getStargate(stargatePK);
                            JSONStargate.updateStargate(stargate, jsonstargate);
                            blstargate.updateStargate(stargate);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(operation) {
                        case IStargateOperation.DELETE_STARGATE:
                            stargate = (IStargate)JSONStargate.toStargate((JSONObject)json.get("stargate"));
                            blstargate.deleteStargate(stargate);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECURESELECT:
                    switch(operation) {
                        case IStargateOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blstargate.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IStargateOperation.SELECT_ALL:
                            result = JSONStargate.toJSONArray(blstargate.getStargates()).toJSONString();
                            break;
                        case IStargateOperation.SELECT_STARGATE:
                            stargatePK = (IStargatePK)JSONStargate.toStargatePK((JSONObject)json.get("stargatepk"));
                            result = JSONStargate.toJSON(blstargate.getStargate(stargatePK)).toJSONString();
                            break;
                        case IStargateOperation.SELECT_Systemsystem:
                            ISystemPK systemSystemPK = (ISystemPK)JSONSystem.toSystemPK((JSONObject)json.get("systempk"));
                            result = JSONStargate.toJSONArray(blstargate.getStargates4systemSystem(systemSystemPK)).toJSONString();
                            break;
                        case IStargateOperation.SELECT_Systemto_system:
                            ISystemPK systemTo_systemPK = (ISystemPK)JSONSystem.toSystemPK((JSONObject)json.get("systempk"));
                            result = JSONStargate.toJSONArray(blstargate.getStargates4systemTo_system(systemTo_systemPK)).toJSONString();
                            break;
                        case IStargateOperation.SELECT_SEARCH:
                            IStargatesearch search = (IStargatesearch)JSONStargate.toStargatesearch((JSONObject)json.get("search"));
                            result = JSONStargate.toJSONArray(blstargate.search(search)).toJSONString();
                            break;
                        case IStargateOperation.SELECT_SEARCHCOUNT:
                            IStargatesearch stargatesearch = (IStargatesearch)JSONStargate.toStargatesearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blstargate.searchcount(stargatesearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREINSERT:
                    switch(operation) {
                        case IStargateOperation.INSERT_STARGATE:
                            stargate = (IStargate)JSONStargate.toStargate((JSONObject)json.get("stargate"));
                            blstargate.secureinsertStargate(stargate);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREUPDATE:
                    switch(operation) {
                        case IStargateOperation.UPDATE_STARGATE:
                            JSONObject jsonstargate = (JSONObject)json.get("stargate");
                            stargatePK = JSONStargate.toStargatePK((JSONObject)jsonstargate.get("PK"));
                            stargate = blstargate.getStargate(stargatePK);
                            JSONStargate.updateStargate(stargate, jsonstargate);
                            blstargate.secureupdateStargate(stargate);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREDELETE:
                    switch(operation) {
                        case IStargateOperation.DELETE_STARGATE:
                            stargate = (IStargate)JSONStargate.toStargate((JSONObject)json.get("stargate"));
                            blstargate.securedeleteStargate(stargate);
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
     * PUT method for updating or creating an instance of RSStargate
     * @param content representation for the resource
     */
    @PUT
    @Consumes("text/html")
    public void put(String content) {
    }
}

