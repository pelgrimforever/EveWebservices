/*
 * RSAllnodes_stargate.java
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
import eve.interfaces.searchentity.IAllnodes_stargatesearch;
import eve.interfaces.servlet.IAllnodes_stargateOperation;
import eve.logicentity.Allnodes_stargate;
import eve.searchentity.Allnodes_stargatesearch;
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
@Path("rsallnodes_stargate")
public class RSAllnodes_stargate {

    /**
     * Creates a new instance of HelloWorld
     */
    public RSAllnodes_stargate() {
    }

    /**
     * Retrieves representation of an instance of allnodes_stargate.restservices.RSAllnodes_stargate
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{json}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@PathParam("json") String jsonstring) {
        try {
            BLallnodes_stargate blallnodes_stargate = new BLallnodes_stargate();
            ArrayList allnodes_stargates = blallnodes_stargate.getAll();
            JSONArray jsonallnodes_stargates = JSONAllnodes_stargate.toJSONArray(allnodes_stargates);
            return jsonallnodes_stargates.toJSONString();
        }
        catch(DBException e) {
            return "{ \"status\": \"error\"}";
        }
    }

    /**
     * Retrieves representation of an instance of allnodes_stargate.restservices.RSAllnodes_stargate
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        String result = "";
        BLallnodes_stargate blallnodes_stargate = new BLallnodes_stargate();
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject)parser.parse(jsonstring);
            JSONObject jsonoperation = (JSONObject)json.get("operation");
            byte operationtype = JSONConversion.getbyte(jsonoperation, "type");
            byte operation = JSONConversion.getbyte(jsonoperation, "operation");
            IAllnodes_stargatePK allnodes_stargatePK;
            IAllnodes_stargate allnodes_stargate;
//Security parameters
            boolean loggedin = RSsecurity.check(json);
            blallnodes_stargate.setAuthenticated(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    switch(operation) {
                        case IAllnodes_stargateOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blallnodes_stargate.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IAllnodes_stargateOperation.SELECT_ALL:
                            result = JSONAllnodes_stargate.toJSONArray(blallnodes_stargate.getAllnodes_stargates()).toJSONString();
                            break;
                        case IAllnodes_stargateOperation.SELECT_ALLNODES_STARGATE:
                            allnodes_stargatePK = (IAllnodes_stargatePK)JSONAllnodes_stargate.toAllnodes_stargatePK((JSONObject)json.get("allnodes_stargatepk"));
                            result = JSONAllnodes_stargate.toJSON(blallnodes_stargate.getAllnodes_stargate(allnodes_stargatePK)).toJSONString();
                            break;
                        case IAllnodes_stargateOperation.SELECT_SEARCH:
                            IAllnodes_stargatesearch search = (IAllnodes_stargatesearch)JSONAllnodes_stargate.toAllnodes_stargatesearch((JSONObject)json.get("search"));
                            result = JSONAllnodes_stargate.toJSONArray(blallnodes_stargate.search(search)).toJSONString();
                            break;
                        case IAllnodes_stargateOperation.SELECT_SEARCHCOUNT:
                            IAllnodes_stargatesearch allnodes_stargatesearch = (IAllnodes_stargatesearch)JSONAllnodes_stargate.toAllnodes_stargatesearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blallnodes_stargate.searchcount(allnodes_stargatesearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(operation) {
                        case IAllnodes_stargateOperation.INSERT_ALLNODES_STARGATE:
                            allnodes_stargate = (IAllnodes_stargate)JSONAllnodes_stargate.toAllnodes_stargate((JSONObject)json.get("allnodes_stargate"));
                            blallnodes_stargate.insertAllnodes_stargate(allnodes_stargate);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(operation) {
                        case IAllnodes_stargateOperation.UPDATE_ALLNODES_STARGATE:
                            JSONObject jsonallnodes_stargate = (JSONObject)json.get("allnodes_stargate");
                            allnodes_stargatePK = JSONAllnodes_stargate.toAllnodes_stargatePK((JSONObject)jsonallnodes_stargate.get("PK"));
                            allnodes_stargate = blallnodes_stargate.getAllnodes_stargate(allnodes_stargatePK);
                            JSONAllnodes_stargate.updateAllnodes_stargate(allnodes_stargate, jsonallnodes_stargate);
                            blallnodes_stargate.updateAllnodes_stargate(allnodes_stargate);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(operation) {
                        case IAllnodes_stargateOperation.DELETE_ALLNODES_STARGATE:
                            allnodes_stargate = (IAllnodes_stargate)JSONAllnodes_stargate.toAllnodes_stargate((JSONObject)json.get("allnodes_stargate"));
                            blallnodes_stargate.deleteAllnodes_stargate(allnodes_stargate);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECURESELECT:
                    switch(operation) {
                        case IAllnodes_stargateOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blallnodes_stargate.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IAllnodes_stargateOperation.SELECT_ALL:
                            result = JSONAllnodes_stargate.toJSONArray(blallnodes_stargate.getAllnodes_stargates()).toJSONString();
                            break;
                        case IAllnodes_stargateOperation.SELECT_ALLNODES_STARGATE:
                            allnodes_stargatePK = (IAllnodes_stargatePK)JSONAllnodes_stargate.toAllnodes_stargatePK((JSONObject)json.get("allnodes_stargatepk"));
                            result = JSONAllnodes_stargate.toJSON(blallnodes_stargate.getAllnodes_stargate(allnodes_stargatePK)).toJSONString();
                            break;
                        case IAllnodes_stargateOperation.SELECT_SEARCH:
                            IAllnodes_stargatesearch search = (IAllnodes_stargatesearch)JSONAllnodes_stargate.toAllnodes_stargatesearch((JSONObject)json.get("search"));
                            result = JSONAllnodes_stargate.toJSONArray(blallnodes_stargate.search(search)).toJSONString();
                            break;
                        case IAllnodes_stargateOperation.SELECT_SEARCHCOUNT:
                            IAllnodes_stargatesearch allnodes_stargatesearch = (IAllnodes_stargatesearch)JSONAllnodes_stargate.toAllnodes_stargatesearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blallnodes_stargate.searchcount(allnodes_stargatesearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREINSERT:
                    switch(operation) {
                        case IAllnodes_stargateOperation.INSERT_ALLNODES_STARGATE:
                            allnodes_stargate = (IAllnodes_stargate)JSONAllnodes_stargate.toAllnodes_stargate((JSONObject)json.get("allnodes_stargate"));
                            blallnodes_stargate.secureinsertAllnodes_stargate(allnodes_stargate);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREUPDATE:
                    switch(operation) {
                        case IAllnodes_stargateOperation.UPDATE_ALLNODES_STARGATE:
                            JSONObject jsonallnodes_stargate = (JSONObject)json.get("allnodes_stargate");
                            allnodes_stargatePK = JSONAllnodes_stargate.toAllnodes_stargatePK((JSONObject)jsonallnodes_stargate.get("PK"));
                            allnodes_stargate = blallnodes_stargate.getAllnodes_stargate(allnodes_stargatePK);
                            JSONAllnodes_stargate.updateAllnodes_stargate(allnodes_stargate, jsonallnodes_stargate);
                            blallnodes_stargate.secureupdateAllnodes_stargate(allnodes_stargate);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREDELETE:
                    switch(operation) {
                        case IAllnodes_stargateOperation.DELETE_ALLNODES_STARGATE:
                            allnodes_stargate = (IAllnodes_stargate)JSONAllnodes_stargate.toAllnodes_stargate((JSONObject)json.get("allnodes_stargate"));
                            blallnodes_stargate.securedeleteAllnodes_stargate(allnodes_stargate);
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
     * PUT method for updating or creating an instance of RSAllnodes_stargate
     * @param content representation for the resource
     */
    @PUT
    @Consumes("text/html")
    public void put(String content) {
    }
}

