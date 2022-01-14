/*
 * RSAllnodes_system.java
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
import eve.interfaces.searchentity.IAllnodes_systemsearch;
import eve.interfaces.servlet.IAllnodes_systemOperation;
import eve.logicentity.Allnodes_system;
import eve.searchentity.Allnodes_systemsearch;
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
@Path("rsallnodes_system")
public class RSAllnodes_system {

    /**
     * Creates a new instance of HelloWorld
     */
    public RSAllnodes_system() {
    }

    /**
     * Retrieves representation of an instance of allnodes_system.restservices.RSAllnodes_system
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{json}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@PathParam("json") String jsonstring) {
        try {
            BLallnodes_system blallnodes_system = new BLallnodes_system();
            ArrayList allnodes_systems = blallnodes_system.getAll();
            JSONArray jsonallnodes_systems = JSONAllnodes_system.toJSONArray(allnodes_systems);
            return jsonallnodes_systems.toJSONString();
        }
        catch(DBException e) {
            return "{ \"status\": \"error\"}";
        }
    }

    /**
     * Retrieves representation of an instance of allnodes_system.restservices.RSAllnodes_system
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        String result = "";
        BLallnodes_system blallnodes_system = new BLallnodes_system();
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject)parser.parse(jsonstring);
            JSONObject jsonoperation = (JSONObject)json.get("operation");
            byte operationtype = JSONConversion.getbyte(jsonoperation, "type");
            byte operation = JSONConversion.getbyte(jsonoperation, "operation");
            IAllnodes_systemPK allnodes_systemPK;
            IAllnodes_system allnodes_system;
//Security parameters
            boolean loggedin = RSsecurity.check(json);
            blallnodes_system.setAuthenticated(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    switch(operation) {
                        case IAllnodes_systemOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blallnodes_system.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IAllnodes_systemOperation.SELECT_ALL:
                            result = JSONAllnodes_system.toJSONArray(blallnodes_system.getAllnodes_systems()).toJSONString();
                            break;
                        case IAllnodes_systemOperation.SELECT_ALLNODES_SYSTEM:
                            allnodes_systemPK = (IAllnodes_systemPK)JSONAllnodes_system.toAllnodes_systemPK((JSONObject)json.get("allnodes_systempk"));
                            result = JSONAllnodes_system.toJSON(blallnodes_system.getAllnodes_system(allnodes_systemPK)).toJSONString();
                            break;
                        case IAllnodes_systemOperation.SELECT_SEARCH:
                            IAllnodes_systemsearch search = (IAllnodes_systemsearch)JSONAllnodes_system.toAllnodes_systemsearch((JSONObject)json.get("search"));
                            result = JSONAllnodes_system.toJSONArray(blallnodes_system.search(search)).toJSONString();
                            break;
                        case IAllnodes_systemOperation.SELECT_SEARCHCOUNT:
                            IAllnodes_systemsearch allnodes_systemsearch = (IAllnodes_systemsearch)JSONAllnodes_system.toAllnodes_systemsearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blallnodes_system.searchcount(allnodes_systemsearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(operation) {
                        case IAllnodes_systemOperation.INSERT_ALLNODES_SYSTEM:
                            allnodes_system = (IAllnodes_system)JSONAllnodes_system.toAllnodes_system((JSONObject)json.get("allnodes_system"));
                            blallnodes_system.insertAllnodes_system(allnodes_system);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(operation) {
                        case IAllnodes_systemOperation.UPDATE_ALLNODES_SYSTEM:
                            JSONObject jsonallnodes_system = (JSONObject)json.get("allnodes_system");
                            allnodes_systemPK = JSONAllnodes_system.toAllnodes_systemPK((JSONObject)jsonallnodes_system.get("PK"));
                            allnodes_system = blallnodes_system.getAllnodes_system(allnodes_systemPK);
                            JSONAllnodes_system.updateAllnodes_system(allnodes_system, jsonallnodes_system);
                            blallnodes_system.updateAllnodes_system(allnodes_system);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(operation) {
                        case IAllnodes_systemOperation.DELETE_ALLNODES_SYSTEM:
                            allnodes_system = (IAllnodes_system)JSONAllnodes_system.toAllnodes_system((JSONObject)json.get("allnodes_system"));
                            blallnodes_system.deleteAllnodes_system(allnodes_system);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECURESELECT:
                    switch(operation) {
                        case IAllnodes_systemOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blallnodes_system.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IAllnodes_systemOperation.SELECT_ALL:
                            result = JSONAllnodes_system.toJSONArray(blallnodes_system.getAllnodes_systems()).toJSONString();
                            break;
                        case IAllnodes_systemOperation.SELECT_ALLNODES_SYSTEM:
                            allnodes_systemPK = (IAllnodes_systemPK)JSONAllnodes_system.toAllnodes_systemPK((JSONObject)json.get("allnodes_systempk"));
                            result = JSONAllnodes_system.toJSON(blallnodes_system.getAllnodes_system(allnodes_systemPK)).toJSONString();
                            break;
                        case IAllnodes_systemOperation.SELECT_SEARCH:
                            IAllnodes_systemsearch search = (IAllnodes_systemsearch)JSONAllnodes_system.toAllnodes_systemsearch((JSONObject)json.get("search"));
                            result = JSONAllnodes_system.toJSONArray(blallnodes_system.search(search)).toJSONString();
                            break;
                        case IAllnodes_systemOperation.SELECT_SEARCHCOUNT:
                            IAllnodes_systemsearch allnodes_systemsearch = (IAllnodes_systemsearch)JSONAllnodes_system.toAllnodes_systemsearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blallnodes_system.searchcount(allnodes_systemsearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREINSERT:
                    switch(operation) {
                        case IAllnodes_systemOperation.INSERT_ALLNODES_SYSTEM:
                            allnodes_system = (IAllnodes_system)JSONAllnodes_system.toAllnodes_system((JSONObject)json.get("allnodes_system"));
                            blallnodes_system.secureinsertAllnodes_system(allnodes_system);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREUPDATE:
                    switch(operation) {
                        case IAllnodes_systemOperation.UPDATE_ALLNODES_SYSTEM:
                            JSONObject jsonallnodes_system = (JSONObject)json.get("allnodes_system");
                            allnodes_systemPK = JSONAllnodes_system.toAllnodes_systemPK((JSONObject)jsonallnodes_system.get("PK"));
                            allnodes_system = blallnodes_system.getAllnodes_system(allnodes_systemPK);
                            JSONAllnodes_system.updateAllnodes_system(allnodes_system, jsonallnodes_system);
                            blallnodes_system.secureupdateAllnodes_system(allnodes_system);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREDELETE:
                    switch(operation) {
                        case IAllnodes_systemOperation.DELETE_ALLNODES_SYSTEM:
                            allnodes_system = (IAllnodes_system)JSONAllnodes_system.toAllnodes_system((JSONObject)json.get("allnodes_system"));
                            blallnodes_system.securedeleteAllnodes_system(allnodes_system);
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
     * PUT method for updating or creating an instance of RSAllnodes_system
     * @param content representation for the resource
     */
    @PUT
    @Consumes("text/html")
    public void put(String content) {
    }
}

