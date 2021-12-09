/*
 * RSUsersettings.java
 *
 * Generated on 9.11.2021 14:30
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
import eve.interfaces.searchentity.IUsersettingssearch;
import eve.interfaces.servlet.IUsersettingsOperation;
import eve.logicentity.Usersettings;
import eve.searchentity.Usersettingssearch;
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
@Path("rsusersettings")
public class RSUsersettings {

    /**
     * Creates a new instance of HelloWorld
     */
    public RSUsersettings() {
    }

    /**
     * Retrieves representation of an instance of usersettings.restservices.RSUsersettings
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{json}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@PathParam("json") String jsonstring) {
        try {
            BLusersettings blusersettings = new BLusersettings();
            ArrayList usersettingss = blusersettings.getAll();
            JSONArray jsonusersettingss = JSONUsersettings.toJSONArray(usersettingss);
            return jsonusersettingss.toJSONString();
        }
        catch(DBException e) {
            return "{ \"status\": \"error\"}";
        }
    }

    /**
     * Retrieves representation of an instance of usersettings.restservices.RSUsersettings
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        String result = "";
        BLusersettings blusersettings = new BLusersettings();
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject)parser.parse(jsonstring);
            JSONObject jsonoperation = (JSONObject)json.get("operation");
            byte operationtype = JSONConversion.getbyte(jsonoperation, "type");
            byte operation = JSONConversion.getbyte(jsonoperation, "operation");
            IUsersettingsPK usersettingsPK;
            IUsersettings usersettings;
//Security parameters
            boolean loggedin = RSsecurity.check(json);
            blusersettings.setAuthenticated(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    switch(operation) {
                        case IUsersettingsOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blusersettings.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IUsersettingsOperation.SELECT_ALL:
                            result = JSONUsersettings.toJSONArray(blusersettings.getUsersettingss()).toJSONString();
                            break;
                        case IUsersettingsOperation.SELECT_USERSETTINGS:
                            usersettingsPK = (IUsersettingsPK)JSONUsersettings.toUsersettingsPK((JSONObject)json.get("usersettingspk"));
                            result = JSONUsersettings.toJSON(blusersettings.getUsersettings(usersettingsPK)).toJSONString();
                            break;
                        case IUsersettingsOperation.SELECT_Settings:
                            ISettingsPK settingsPK = (ISettingsPK)JSONSettings.toSettingsPK((JSONObject)json.get("settingspk"));
                            result = JSONUsersettings.toJSONArray(blusersettings.getUsersettingss4settings(settingsPK)).toJSONString();
                            break;
                        case IUsersettingsOperation.SELECT_SEARCH:
                            IUsersettingssearch search = (IUsersettingssearch)JSONUsersettings.toUsersettingssearch((JSONObject)json.get("search"));
                            result = JSONUsersettings.toJSONArray(blusersettings.search(search)).toJSONString();
                            break;
                        case IUsersettingsOperation.SELECT_SEARCHCOUNT:
                            IUsersettingssearch usersettingssearch = (IUsersettingssearch)JSONUsersettings.toUsersettingssearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blusersettings.searchcount(usersettingssearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
                        case IUsersettingsOperation.SELECT_4USER:
                            String username = JSONConversion.getString(json, "username");
                            result = JSONUsersettings.toJSONArray(blusersettings.getUsersettings(username)).toJSONString();
                            break;
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(operation) {
                        case IUsersettingsOperation.INSERT_USERSETTINGS:
                            usersettings = (IUsersettings)JSONUsersettings.toUsersettings((JSONObject)json.get("usersettings"));
                            blusersettings.insertUsersettings(usersettings);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(operation) {
                        case IUsersettingsOperation.UPDATE_USERSETTINGS:
                            JSONObject jsonusersettings = (JSONObject)json.get("usersettings");
                            usersettingsPK = JSONUsersettings.toUsersettingsPK((JSONObject)jsonusersettings.get("PK"));
                            usersettings = blusersettings.getUsersettings(usersettingsPK);
                            JSONUsersettings.updateUsersettings(usersettings, jsonusersettings);
                            blusersettings.updateUsersettings(usersettings);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(operation) {
                        case IUsersettingsOperation.DELETE_USERSETTINGS:
                            usersettings = (IUsersettings)JSONUsersettings.toUsersettings((JSONObject)json.get("usersettings"));
                            blusersettings.deleteUsersettings(usersettings);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECURESELECT:
                    switch(operation) {
                        case IUsersettingsOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blusersettings.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IUsersettingsOperation.SELECT_ALL:
                            result = JSONUsersettings.toJSONArray(blusersettings.getUsersettingss()).toJSONString();
                            break;
                        case IUsersettingsOperation.SELECT_USERSETTINGS:
                            usersettingsPK = (IUsersettingsPK)JSONUsersettings.toUsersettingsPK((JSONObject)json.get("usersettingspk"));
                            result = JSONUsersettings.toJSON(blusersettings.getUsersettings(usersettingsPK)).toJSONString();
                            break;
                        case IUsersettingsOperation.SELECT_Settings:
                            ISettingsPK settingsPK = (ISettingsPK)JSONSettings.toSettingsPK((JSONObject)json.get("settingspk"));
                            result = JSONUsersettings.toJSONArray(blusersettings.getUsersettingss4settings(settingsPK)).toJSONString();
                            break;
                        case IUsersettingsOperation.SELECT_SEARCH:
                            IUsersettingssearch search = (IUsersettingssearch)JSONUsersettings.toUsersettingssearch((JSONObject)json.get("search"));
                            result = JSONUsersettings.toJSONArray(blusersettings.search(search)).toJSONString();
                            break;
                        case IUsersettingsOperation.SELECT_SEARCHCOUNT:
                            IUsersettingssearch usersettingssearch = (IUsersettingssearch)JSONUsersettings.toUsersettingssearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blusersettings.searchcount(usersettingssearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREINSERT:
                    switch(operation) {
                        case IUsersettingsOperation.INSERT_USERSETTINGS:
                            usersettings = (IUsersettings)JSONUsersettings.toUsersettings((JSONObject)json.get("usersettings"));
                            blusersettings.secureinsertUsersettings(usersettings);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREUPDATE:
                    switch(operation) {
                        case IUsersettingsOperation.UPDATE_USERSETTINGS:
                            JSONObject jsonusersettings = (JSONObject)json.get("usersettings");
                            usersettingsPK = JSONUsersettings.toUsersettingsPK((JSONObject)jsonusersettings.get("PK"));
                            usersettings = blusersettings.getUsersettings(usersettingsPK);
                            JSONUsersettings.updateUsersettings(usersettings, jsonusersettings);
                            blusersettings.secureupdateUsersettings(usersettings);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREDELETE:
                    switch(operation) {
                        case IUsersettingsOperation.DELETE_USERSETTINGS:
                            usersettings = (IUsersettings)JSONUsersettings.toUsersettings((JSONObject)json.get("usersettings"));
                            blusersettings.securedeleteUsersettings(usersettings);
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
     * PUT method for updating or creating an instance of RSUsersettings
     * @param content representation for the resource
     */
    @PUT
    @Consumes("text/html")
    public void put(String content) {
    }
}

