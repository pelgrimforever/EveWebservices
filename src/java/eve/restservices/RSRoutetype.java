/*
 * RSRoutetype.java
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
import eve.interfaces.searchentity.IRoutetypesearch;
import eve.interfaces.servlet.IRoutetypeOperation;
import eve.logicentity.Routetype;
import eve.searchentity.Routetypesearch;
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
@Path("rsroutetype")
public class RSRoutetype {

    /**
     * Creates a new instance of HelloWorld
     */
    public RSRoutetype() {
    }

    /**
     * Retrieves representation of an instance of routetype.restservices.RSRoutetype
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{json}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@PathParam("json") String jsonstring) {
        try {
            BLroutetype blroutetype = new BLroutetype();
            ArrayList routetypes = blroutetype.getAll();
            JSONArray jsonroutetypes = JSONRoutetype.toJSONArray(routetypes);
            return jsonroutetypes.toJSONString();
        }
        catch(DBException e) {
            return "{ \"status\": \"error\"}";
        }
    }

    /**
     * Retrieves representation of an instance of routetype.restservices.RSRoutetype
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        String result = "";
        BLroutetype blroutetype = new BLroutetype();
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject)parser.parse(jsonstring);
            JSONObject jsonoperation = (JSONObject)json.get("operation");
            byte operationtype = JSONConversion.getbyte(jsonoperation, "type");
            byte operation = JSONConversion.getbyte(jsonoperation, "operation");
            IRoutetypePK routetypePK;
            IRoutetype routetype;
//Security parameters
            boolean loggedin = RSsecurity.check(json);
            blroutetype.setAuthenticated(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    switch(operation) {
                        case IRoutetypeOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blroutetype.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IRoutetypeOperation.SELECT_ALL:
                            result = JSONRoutetype.toJSONArray(blroutetype.getRoutetypes()).toJSONString();
                            break;
                        case IRoutetypeOperation.SELECT_ROUTETYPE:
                            routetypePK = (IRoutetypePK)JSONRoutetype.toRoutetypePK((JSONObject)json.get("routetypepk"));
                            result = JSONRoutetype.toJSON(blroutetype.getRoutetype(routetypePK)).toJSONString();
                            break;
                        case IRoutetypeOperation.SELECT_Security_island:
                            ISecurity_islandPK security_islandPK = (ISecurity_islandPK)JSONSecurity_island.toSecurity_islandPK((JSONObject)json.get("security_islandpk"));
                            result = JSONRoutetype.toJSONArray(blroutetype.getRoutetypes4security_island(security_islandPK)).toJSONString();
                            break;
                        case IRoutetypeOperation.SELECT_Route:
                            IRoutePK routePK = (IRoutePK)JSONRoute.toRoutePK((JSONObject)json.get("routepk"));
                            result = JSONRoutetype.toJSON(blroutetype.getRoute(routePK)).toJSONString();
                            break;
                        case IRoutetypeOperation.SELECT_SEARCH:
                            IRoutetypesearch search = (IRoutetypesearch)JSONRoutetype.toRoutetypesearch((JSONObject)json.get("search"));
                            result = JSONRoutetype.toJSONArray(blroutetype.search(search)).toJSONString();
                            break;
                        case IRoutetypeOperation.SELECT_SEARCHCOUNT:
                            IRoutetypesearch routetypesearch = (IRoutetypesearch)JSONRoutetype.toRoutetypesearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blroutetype.searchcount(routetypesearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(operation) {
                        case IRoutetypeOperation.INSERT_ROUTETYPE:
                            routetype = (IRoutetype)JSONRoutetype.toRoutetype((JSONObject)json.get("routetype"));
                            blroutetype.insertRoutetype(routetype);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(operation) {
                        case IRoutetypeOperation.UPDATE_ROUTETYPE:
                            JSONObject jsonroutetype = (JSONObject)json.get("routetype");
                            routetypePK = JSONRoutetype.toRoutetypePK((JSONObject)jsonroutetype.get("PK"));
                            routetype = blroutetype.getRoutetype(routetypePK);
                            JSONRoutetype.updateRoutetype(routetype, jsonroutetype);
                            blroutetype.updateRoutetype(routetype);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(operation) {
                        case IRoutetypeOperation.DELETE_ROUTETYPE:
                            routetype = (IRoutetype)JSONRoutetype.toRoutetype((JSONObject)json.get("routetype"));
                            blroutetype.deleteRoutetype(routetype);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECURESELECT:
                    switch(operation) {
                        case IRoutetypeOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blroutetype.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IRoutetypeOperation.SELECT_ALL:
                            result = JSONRoutetype.toJSONArray(blroutetype.getRoutetypes()).toJSONString();
                            break;
                        case IRoutetypeOperation.SELECT_ROUTETYPE:
                            routetypePK = (IRoutetypePK)JSONRoutetype.toRoutetypePK((JSONObject)json.get("routetypepk"));
                            result = JSONRoutetype.toJSON(blroutetype.getRoutetype(routetypePK)).toJSONString();
                            break;
                        case IRoutetypeOperation.SELECT_Security_island:
                            ISecurity_islandPK security_islandPK = (ISecurity_islandPK)JSONSecurity_island.toSecurity_islandPK((JSONObject)json.get("security_islandpk"));
                            result = JSONRoutetype.toJSONArray(blroutetype.getRoutetypes4security_island(security_islandPK)).toJSONString();
                            break;
                        case IRoutetypeOperation.SELECT_Route:
                            IRoutePK routePK = (IRoutePK)JSONRoute.toRoutePK((JSONObject)json.get("routepk"));
                            result = JSONRoutetype.toJSON(blroutetype.getRoute(routePK)).toJSONString();
                            break;
                        case IRoutetypeOperation.SELECT_SEARCH:
                            IRoutetypesearch search = (IRoutetypesearch)JSONRoutetype.toRoutetypesearch((JSONObject)json.get("search"));
                            result = JSONRoutetype.toJSONArray(blroutetype.search(search)).toJSONString();
                            break;
                        case IRoutetypeOperation.SELECT_SEARCHCOUNT:
                            IRoutetypesearch routetypesearch = (IRoutetypesearch)JSONRoutetype.toRoutetypesearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blroutetype.searchcount(routetypesearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREINSERT:
                    switch(operation) {
                        case IRoutetypeOperation.INSERT_ROUTETYPE:
                            routetype = (IRoutetype)JSONRoutetype.toRoutetype((JSONObject)json.get("routetype"));
                            blroutetype.secureinsertRoutetype(routetype);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREUPDATE:
                    switch(operation) {
                        case IRoutetypeOperation.UPDATE_ROUTETYPE:
                            JSONObject jsonroutetype = (JSONObject)json.get("routetype");
                            routetypePK = JSONRoutetype.toRoutetypePK((JSONObject)jsonroutetype.get("PK"));
                            routetype = blroutetype.getRoutetype(routetypePK);
                            JSONRoutetype.updateRoutetype(routetype, jsonroutetype);
                            blroutetype.secureupdateRoutetype(routetype);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREDELETE:
                    switch(operation) {
                        case IRoutetypeOperation.DELETE_ROUTETYPE:
                            routetype = (IRoutetype)JSONRoutetype.toRoutetype((JSONObject)json.get("routetype"));
                            blroutetype.securedeleteRoutetype(routetype);
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
     * PUT method for updating or creating an instance of RSRoutetype
     * @param content representation for the resource
     */
    @PUT
    @Consumes("text/html")
    public void put(String content) {
    }
}

