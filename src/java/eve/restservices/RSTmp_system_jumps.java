/*
 * RSTmp_system_jumps.java
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
import eve.interfaces.searchentity.ITmp_system_jumpssearch;
import eve.interfaces.servlet.ITmp_system_jumpsOperation;
import eve.logicentity.Tmp_system_jumps;
import eve.searchentity.Tmp_system_jumpssearch;
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
@Path("rstmp_system_jumps")
public class RSTmp_system_jumps {

    /**
     * Creates a new instance of HelloWorld
     */
    public RSTmp_system_jumps() {
    }

    /**
     * Retrieves representation of an instance of tmp_system_jumps.restservices.RSTmp_system_jumps
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{json}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@PathParam("json") String jsonstring) {
        try {
            BLtmp_system_jumps bltmp_system_jumps = new BLtmp_system_jumps();
            ArrayList tmp_system_jumpss = bltmp_system_jumps.getAll();
            JSONArray jsontmp_system_jumpss = JSONTmp_system_jumps.toJSONArray(tmp_system_jumpss);
            return jsontmp_system_jumpss.toJSONString();
        }
        catch(DBException e) {
            return "{ \"status\": \"error\"}";
        }
    }

    /**
     * Retrieves representation of an instance of tmp_system_jumps.restservices.RSTmp_system_jumps
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        String result = "";
        BLtmp_system_jumps bltmp_system_jumps = new BLtmp_system_jumps();
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject)parser.parse(jsonstring);
            JSONObject jsonoperation = (JSONObject)json.get("operation");
            byte operationtype = JSONConversion.getbyte(jsonoperation, "type");
            byte operation = JSONConversion.getbyte(jsonoperation, "operation");
            ITmp_system_jumpsPK tmp_system_jumpsPK;
            ITmp_system_jumps tmp_system_jumps;
//Security parameters
            boolean loggedin = RSsecurity.check(json);
            bltmp_system_jumps.setAuthenticated(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    switch(operation) {
                        case ITmp_system_jumpsOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", bltmp_system_jumps.count());
                            result = jsoncount.toJSONString();
                            break;
                        case ITmp_system_jumpsOperation.SELECT_ALL:
                            result = JSONTmp_system_jumps.toJSONArray(bltmp_system_jumps.getTmp_system_jumpss()).toJSONString();
                            break;
                        case ITmp_system_jumpsOperation.SELECT_TMP_SYSTEM_JUMPS:
                            tmp_system_jumpsPK = (ITmp_system_jumpsPK)JSONTmp_system_jumps.toTmp_system_jumpsPK((JSONObject)json.get("tmp_system_jumpspk"));
                            result = JSONTmp_system_jumps.toJSON(bltmp_system_jumps.getTmp_system_jumps(tmp_system_jumpsPK)).toJSONString();
                            break;
                        case ITmp_system_jumpsOperation.SELECT_SEARCH:
                            ITmp_system_jumpssearch search = (ITmp_system_jumpssearch)JSONTmp_system_jumps.toTmp_system_jumpssearch((JSONObject)json.get("search"));
                            result = JSONTmp_system_jumps.toJSONArray(bltmp_system_jumps.search(search)).toJSONString();
                            break;
                        case ITmp_system_jumpsOperation.SELECT_SEARCHCOUNT:
                            ITmp_system_jumpssearch tmp_system_jumpssearch = (ITmp_system_jumpssearch)JSONTmp_system_jumps.toTmp_system_jumpssearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", bltmp_system_jumps.searchcount(tmp_system_jumpssearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(operation) {
                        case ITmp_system_jumpsOperation.INSERT_TMP_SYSTEM_JUMPS:
                            tmp_system_jumps = (ITmp_system_jumps)JSONTmp_system_jumps.toTmp_system_jumps((JSONObject)json.get("tmp_system_jumps"));
                            bltmp_system_jumps.insertTmp_system_jumps(tmp_system_jumps);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(operation) {
                        case ITmp_system_jumpsOperation.UPDATE_TMP_SYSTEM_JUMPS:
                            JSONObject jsontmp_system_jumps = (JSONObject)json.get("tmp_system_jumps");
                            tmp_system_jumpsPK = JSONTmp_system_jumps.toTmp_system_jumpsPK((JSONObject)jsontmp_system_jumps.get("PK"));
                            tmp_system_jumps = bltmp_system_jumps.getTmp_system_jumps(tmp_system_jumpsPK);
                            JSONTmp_system_jumps.updateTmp_system_jumps(tmp_system_jumps, jsontmp_system_jumps);
                            bltmp_system_jumps.updateTmp_system_jumps(tmp_system_jumps);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(operation) {
                        case ITmp_system_jumpsOperation.DELETE_TMP_SYSTEM_JUMPS:
                            tmp_system_jumps = (ITmp_system_jumps)JSONTmp_system_jumps.toTmp_system_jumps((JSONObject)json.get("tmp_system_jumps"));
                            bltmp_system_jumps.deleteTmp_system_jumps(tmp_system_jumps);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECURESELECT:
                    switch(operation) {
                        case ITmp_system_jumpsOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", bltmp_system_jumps.count());
                            result = jsoncount.toJSONString();
                            break;
                        case ITmp_system_jumpsOperation.SELECT_ALL:
                            result = JSONTmp_system_jumps.toJSONArray(bltmp_system_jumps.getTmp_system_jumpss()).toJSONString();
                            break;
                        case ITmp_system_jumpsOperation.SELECT_TMP_SYSTEM_JUMPS:
                            tmp_system_jumpsPK = (ITmp_system_jumpsPK)JSONTmp_system_jumps.toTmp_system_jumpsPK((JSONObject)json.get("tmp_system_jumpspk"));
                            result = JSONTmp_system_jumps.toJSON(bltmp_system_jumps.getTmp_system_jumps(tmp_system_jumpsPK)).toJSONString();
                            break;
                        case ITmp_system_jumpsOperation.SELECT_SEARCH:
                            ITmp_system_jumpssearch search = (ITmp_system_jumpssearch)JSONTmp_system_jumps.toTmp_system_jumpssearch((JSONObject)json.get("search"));
                            result = JSONTmp_system_jumps.toJSONArray(bltmp_system_jumps.search(search)).toJSONString();
                            break;
                        case ITmp_system_jumpsOperation.SELECT_SEARCHCOUNT:
                            ITmp_system_jumpssearch tmp_system_jumpssearch = (ITmp_system_jumpssearch)JSONTmp_system_jumps.toTmp_system_jumpssearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", bltmp_system_jumps.searchcount(tmp_system_jumpssearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREINSERT:
                    switch(operation) {
                        case ITmp_system_jumpsOperation.INSERT_TMP_SYSTEM_JUMPS:
                            tmp_system_jumps = (ITmp_system_jumps)JSONTmp_system_jumps.toTmp_system_jumps((JSONObject)json.get("tmp_system_jumps"));
                            bltmp_system_jumps.secureinsertTmp_system_jumps(tmp_system_jumps);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREUPDATE:
                    switch(operation) {
                        case ITmp_system_jumpsOperation.UPDATE_TMP_SYSTEM_JUMPS:
                            JSONObject jsontmp_system_jumps = (JSONObject)json.get("tmp_system_jumps");
                            tmp_system_jumpsPK = JSONTmp_system_jumps.toTmp_system_jumpsPK((JSONObject)jsontmp_system_jumps.get("PK"));
                            tmp_system_jumps = bltmp_system_jumps.getTmp_system_jumps(tmp_system_jumpsPK);
                            JSONTmp_system_jumps.updateTmp_system_jumps(tmp_system_jumps, jsontmp_system_jumps);
                            bltmp_system_jumps.secureupdateTmp_system_jumps(tmp_system_jumps);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREDELETE:
                    switch(operation) {
                        case ITmp_system_jumpsOperation.DELETE_TMP_SYSTEM_JUMPS:
                            tmp_system_jumps = (ITmp_system_jumps)JSONTmp_system_jumps.toTmp_system_jumps((JSONObject)json.get("tmp_system_jumps"));
                            bltmp_system_jumps.securedeleteTmp_system_jumps(tmp_system_jumps);
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
     * PUT method for updating or creating an instance of RSTmp_system_jumps
     * @param content representation for the resource
     */
    @PUT
    @Consumes("text/html")
    public void put(String content) {
    }
}

