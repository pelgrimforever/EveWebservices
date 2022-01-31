/*
 * RSUserbp.java
 *
 * Generated on 28.0.2022 15:59
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
import eve.interfaces.searchentity.IUserbpsearch;
import eve.interfaces.servlet.IUserbpOperation;
import eve.logicentity.Userbp;
import eve.searchentity.Userbpsearch;
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
@Path("rsuserbp")
public class RSUserbp {

    /**
     * Creates a new instance of HelloWorld
     */
    public RSUserbp() {
    }

    /**
     * Retrieves representation of an instance of userbp.restservices.RSUserbp
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{json}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@PathParam("json") String jsonstring) {
        try {
            BLuserbp bluserbp = new BLuserbp();
            ArrayList userbps = bluserbp.getAll();
            JSONArray jsonuserbps = JSONUserbp.toJSONArray(userbps);
            return jsonuserbps.toJSONString();
        }
        catch(DBException e) {
            return "{ \"status\": \"error\"}";
        }
    }

    /**
     * Retrieves representation of an instance of userbp.restservices.RSUserbp
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        String result = "";
        BLuserbp bluserbp = new BLuserbp();
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject)parser.parse(jsonstring);
            JSONObject jsonoperation = (JSONObject)json.get("operation");
            byte operationtype = JSONConversion.getbyte(jsonoperation, "type");
            byte operation = JSONConversion.getbyte(jsonoperation, "operation");
            IUserbpPK userbpPK;
            IUserbp userbp;
//Security parameters
            boolean loggedin = RSsecurity.check(json);
            bluserbp.setAuthenticated(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    switch(operation) {
                        case IUserbpOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", bluserbp.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IUserbpOperation.SELECT_ALL:
                            result = JSONUserbp.toJSONArray(bluserbp.getUserbps()).toJSONString();
                            break;
                        case IUserbpOperation.SELECT_USERBP:
                            userbpPK = (IUserbpPK)JSONUserbp.toUserbpPK((JSONObject)json.get("userbppk"));
                            result = JSONUserbp.toJSON(bluserbp.getUserbp(userbpPK)).toJSONString();
                            break;
                        case IUserbpOperation.SELECT_Evetype:
                            IEvetypePK evetypePK = (IEvetypePK)JSONEvetype.toEvetypePK((JSONObject)json.get("evetypepk"));
                            result = JSONUserbp.toJSONArray(bluserbp.getUserbps4evetype(evetypePK)).toJSONString();
                            break;
                        case IUserbpOperation.SELECT_SEARCH:
                            IUserbpsearch search = (IUserbpsearch)JSONUserbp.toUserbpsearch((JSONObject)json.get("search"));
                            result = JSONUserbp.toJSONArray(bluserbp.search(search)).toJSONString();
                            break;
                        case IUserbpOperation.SELECT_SEARCHCOUNT:
                            IUserbpsearch userbpsearch = (IUserbpsearch)JSONUserbp.toUserbpsearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", bluserbp.searchcount(userbpsearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(operation) {
                        case IUserbpOperation.INSERT_USERBP:
                            userbp = (IUserbp)JSONUserbp.toUserbp((JSONObject)json.get("userbp"));
                            bluserbp.insertUserbp(userbp);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
                        case IUserbpOperation.INSERT_ADDBP:
                            userbp = (IUserbp)JSONUserbp.toUserbp((JSONObject)json.get("userbp"));
                            bluserbp.insertNewbp(userbp);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(operation) {
                        case IUserbpOperation.UPDATE_USERBP:
                            JSONObject jsonuserbp = (JSONObject)json.get("userbp");
                            userbpPK = JSONUserbp.toUserbpPK((JSONObject)jsonuserbp.get("PK"));
                            userbp = bluserbp.getUserbp(userbpPK);
                            JSONUserbp.updateUserbp(userbp, jsonuserbp);
                            bluserbp.updateUserbp(userbp);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
                        case IUserbpOperation.UPDATE_PROPERTIES:
                            JSONObject jsonuserbpprop = (JSONObject)json.get("userbp");
                            userbp = JSONUserbp.toUserbp((JSONObject)jsonuserbpprop);
                            bluserbp.updateProperties(userbp);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(operation) {
                        case IUserbpOperation.DELETE_USERBP:
                            userbp = (IUserbp)JSONUserbp.toUserbp((JSONObject)json.get("userbp"));
                            bluserbp.deleteUserbp(userbp);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECURESELECT:
                    switch(operation) {
                        case IUserbpOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", bluserbp.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IUserbpOperation.SELECT_ALL:
                            result = JSONUserbp.toJSONArray(bluserbp.getUserbps()).toJSONString();
                            break;
                        case IUserbpOperation.SELECT_USERBP:
                            userbpPK = (IUserbpPK)JSONUserbp.toUserbpPK((JSONObject)json.get("userbppk"));
                            result = JSONUserbp.toJSON(bluserbp.getUserbp(userbpPK)).toJSONString();
                            break;
                        case IUserbpOperation.SELECT_Evetype:
                            IEvetypePK evetypePK = (IEvetypePK)JSONEvetype.toEvetypePK((JSONObject)json.get("evetypepk"));
                            result = JSONUserbp.toJSONArray(bluserbp.getUserbps4evetype(evetypePK)).toJSONString();
                            break;
                        case IUserbpOperation.SELECT_SEARCH:
                            IUserbpsearch search = (IUserbpsearch)JSONUserbp.toUserbpsearch((JSONObject)json.get("search"));
                            result = JSONUserbp.toJSONArray(bluserbp.search(search)).toJSONString();
                            break;
                        case IUserbpOperation.SELECT_SEARCHCOUNT:
                            IUserbpsearch userbpsearch = (IUserbpsearch)JSONUserbp.toUserbpsearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", bluserbp.searchcount(userbpsearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREINSERT:
                    switch(operation) {
                        case IUserbpOperation.INSERT_USERBP:
                            userbp = (IUserbp)JSONUserbp.toUserbp((JSONObject)json.get("userbp"));
                            bluserbp.secureinsertUserbp(userbp);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREUPDATE:
                    switch(operation) {
                        case IUserbpOperation.UPDATE_USERBP:
                            JSONObject jsonuserbp = (JSONObject)json.get("userbp");
                            userbpPK = JSONUserbp.toUserbpPK((JSONObject)jsonuserbp.get("PK"));
                            userbp = bluserbp.getUserbp(userbpPK);
                            JSONUserbp.updateUserbp(userbp, jsonuserbp);
                            bluserbp.secureupdateUserbp(userbp);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREDELETE:
                    switch(operation) {
                        case IUserbpOperation.DELETE_USERBP:
                            userbp = (IUserbp)JSONUserbp.toUserbp((JSONObject)json.get("userbp"));
                            bluserbp.securedeleteUserbp(userbp);
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
     * PUT method for updating or creating an instance of RSUserbp
     * @param content representation for the resource
     */
    @PUT
    @Consumes("text/html")
    public void put(String content) {
    }
}

