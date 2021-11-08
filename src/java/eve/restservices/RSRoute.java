/*
 * RSRoute.java
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
import eve.interfaces.searchentity.IRoutesearch;
import eve.interfaces.servlet.IRouteOperation;
import eve.logicentity.Route;
import eve.searchentity.Routesearch;
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
@Path("rsroute")
public class RSRoute {

    /**
     * Creates a new instance of HelloWorld
     */
    public RSRoute() {
    }

    /**
     * Retrieves representation of an instance of route.restservices.RSRoute
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{json}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@PathParam("json") String jsonstring) {
        try {
            BLroute blroute = new BLroute();
            ArrayList routes = blroute.getAll();
            JSONArray jsonroutes = JSONRoute.toJSONArray(routes);
            return jsonroutes.toJSONString();
        }
        catch(DBException e) {
            return "{ \"status\": \"error\"}";
        }
    }

    /**
     * Retrieves representation of an instance of route.restservices.RSRoute
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        String result = "";
        BLroute blroute = new BLroute();
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject)parser.parse(jsonstring);
            JSONObject jsonoperation = (JSONObject)json.get("operation");
            byte operationtype = JSONConversion.getbyte(jsonoperation, "type");
            byte operation = JSONConversion.getbyte(jsonoperation, "operation");
            IRoutePK routePK;
            IRoute route;
//Security parameters
            boolean loggedin = RSsecurity.check(json);
            blroute.setAuthenticated(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    switch(operation) {
                        case IRouteOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blroute.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IRouteOperation.SELECT_ALL:
                            result = JSONRoute.toJSONArray(blroute.getRoutes()).toJSONString();
                            break;
                        case IRouteOperation.SELECT_ROUTE:
                            routePK = (IRoutePK)JSONRoute.toRoutePK((JSONObject)json.get("routepk"));
                            result = JSONRoute.toJSON(blroute.getRoute(routePK)).toJSONString();
                            break;
                        case IRouteOperation.SELECT_Routetype:
                            IRoutetypePK routetypePK = (IRoutetypePK)JSONRoutetype.toRoutetypePK((JSONObject)json.get("routetypepk"));
                            result = JSONRoute.toJSONArray(blroute.getRoutes4routetype(routetypePK)).toJSONString();
                            break;
                        case IRouteOperation.SELECT_System:
                            ISystemPK systemPK = (ISystemPK)JSONSystem.toSystemPK((JSONObject)json.get("systempk"));
                            result = JSONRoute.toJSONArray(blroute.getRoutes4system(systemPK)).toJSONString();
                            break;
                        case IRouteOperation.SELECT_SEARCH:
                            IRoutesearch search = (IRoutesearch)JSONRoute.toRoutesearch((JSONObject)json.get("search"));
                            result = JSONRoute.toJSONArray(blroute.search(search)).toJSONString();
                            break;
                        case IRouteOperation.SELECT_SEARCHCOUNT:
                            IRoutesearch routesearch = (IRoutesearch)JSONRoute.toRoutesearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blroute.searchcount(routesearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(operation) {
                        case IRouteOperation.INSERT_ROUTE:
                            route = (IRoute)JSONRoute.toRoute((JSONObject)json.get("route"));
                            blroute.insertRoute(route);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(operation) {
                        case IRouteOperation.UPDATE_ROUTE:
                            JSONObject jsonroute = (JSONObject)json.get("route");
                            routePK = JSONRoute.toRoutePK((JSONObject)jsonroute.get("PK"));
                            route = blroute.getRoute(routePK);
                            JSONRoute.updateRoute(route, jsonroute);
                            blroute.updateRoute(route);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(operation) {
                        case IRouteOperation.DELETE_ROUTE:
                            route = (IRoute)JSONRoute.toRoute((JSONObject)json.get("route"));
                            blroute.deleteRoute(route);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECURESELECT:
                    switch(operation) {
                        case IRouteOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blroute.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IRouteOperation.SELECT_ALL:
                            result = JSONRoute.toJSONArray(blroute.getRoutes()).toJSONString();
                            break;
                        case IRouteOperation.SELECT_ROUTE:
                            routePK = (IRoutePK)JSONRoute.toRoutePK((JSONObject)json.get("routepk"));
                            result = JSONRoute.toJSON(blroute.getRoute(routePK)).toJSONString();
                            break;
                        case IRouteOperation.SELECT_Routetype:
                            IRoutetypePK routetypePK = (IRoutetypePK)JSONRoutetype.toRoutetypePK((JSONObject)json.get("routetypepk"));
                            result = JSONRoute.toJSONArray(blroute.getRoutes4routetype(routetypePK)).toJSONString();
                            break;
                        case IRouteOperation.SELECT_System:
                            ISystemPK systemPK = (ISystemPK)JSONSystem.toSystemPK((JSONObject)json.get("systempk"));
                            result = JSONRoute.toJSONArray(blroute.getRoutes4system(systemPK)).toJSONString();
                            break;
                        case IRouteOperation.SELECT_SEARCH:
                            IRoutesearch search = (IRoutesearch)JSONRoute.toRoutesearch((JSONObject)json.get("search"));
                            result = JSONRoute.toJSONArray(blroute.search(search)).toJSONString();
                            break;
                        case IRouteOperation.SELECT_SEARCHCOUNT:
                            IRoutesearch routesearch = (IRoutesearch)JSONRoute.toRoutesearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blroute.searchcount(routesearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREINSERT:
                    switch(operation) {
                        case IRouteOperation.INSERT_ROUTE:
                            route = (IRoute)JSONRoute.toRoute((JSONObject)json.get("route"));
                            blroute.secureinsertRoute(route);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREUPDATE:
                    switch(operation) {
                        case IRouteOperation.UPDATE_ROUTE:
                            JSONObject jsonroute = (JSONObject)json.get("route");
                            routePK = JSONRoute.toRoutePK((JSONObject)jsonroute.get("PK"));
                            route = blroute.getRoute(routePK);
                            JSONRoute.updateRoute(route, jsonroute);
                            blroute.secureupdateRoute(route);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREDELETE:
                    switch(operation) {
                        case IRouteOperation.DELETE_ROUTE:
                            route = (IRoute)JSONRoute.toRoute((JSONObject)json.get("route"));
                            blroute.securedeleteRoute(route);
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
     * PUT method for updating or creating an instance of RSRoute
     * @param content representation for the resource
     */
    @PUT
    @Consumes("text/html")
    public void put(String content) {
    }
}

