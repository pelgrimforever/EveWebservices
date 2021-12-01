/*
 * RSSettings.java
 *
 * Generated on 30.10.2021 10:3
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
import eve.interfaces.searchentity.ISettingssearch;
import eve.interfaces.servlet.ISettingsOperation;
import eve.logicentity.Settings;
import eve.searchentity.Settingssearch;
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
@Path("rssettings")
public class RSSettings {

    /**
     * Creates a new instance of HelloWorld
     */
    public RSSettings() {
    }

    /**
     * Retrieves representation of an instance of settings.restservices.RSSettings
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{json}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@PathParam("json") String jsonstring) {
        try {
            BLsettings blsettings = new BLsettings();
            ArrayList settingss = blsettings.getAll();
            JSONArray jsonsettingss = JSONSettings.toJSONArray(settingss);
            return jsonsettingss.toJSONString();
        }
        catch(DBException e) {
            return "{ \"status\": \"error\"}";
        }
    }

    /**
     * Retrieves representation of an instance of settings.restservices.RSSettings
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        String result = "";
        BLsettings blsettings = new BLsettings();
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject)parser.parse(jsonstring);
            JSONObject jsonoperation = (JSONObject)json.get("operation");
            byte operationtype = JSONConversion.getbyte(jsonoperation, "type");
            byte operation = JSONConversion.getbyte(jsonoperation, "operation");
            ISettingsPK settingsPK;
            ISettings settings;
//Security parameters
            boolean loggedin = RSsecurity.check(json);
            blsettings.setAuthenticated(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    switch(operation) {
                        case ISettingsOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blsettings.count());
                            result = jsoncount.toJSONString();
                            break;
                        case ISettingsOperation.SELECT_ALL:
                            result = JSONSettings.toJSONArray(blsettings.getSettingss()).toJSONString();
                            break;
                        case ISettingsOperation.SELECT_SETTINGS:
                            settingsPK = (ISettingsPK)JSONSettings.toSettingsPK((JSONObject)json.get("settingspk"));
                            result = JSONSettings.toJSON(blsettings.getSettings(settingsPK)).toJSONString();
                            break;
                        case ISettingsOperation.SELECT_Usersettings:
                            IUsersettingsPK usersettingsPK = (IUsersettingsPK)JSONUsersettings.toUsersettingsPK((JSONObject)json.get("usersettingspk"));
                            result = JSONSettings.toJSON(blsettings.getUsersettings(usersettingsPK)).toJSONString();
                            break;
                        case ISettingsOperation.SELECT_SEARCH:
                            ISettingssearch search = (ISettingssearch)JSONSettings.toSettingssearch((JSONObject)json.get("search"));
                            result = JSONSettings.toJSONArray(blsettings.search(search)).toJSONString();
                            break;
                        case ISettingsOperation.SELECT_SEARCHCOUNT:
                            ISettingssearch settingssearch = (ISettingssearch)JSONSettings.toSettingssearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blsettings.searchcount(settingssearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(operation) {
                        case ISettingsOperation.INSERT_SETTINGS:
                            settings = (ISettings)JSONSettings.toSettings((JSONObject)json.get("settings"));
                            blsettings.insertSettings(settings);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(operation) {
                        case ISettingsOperation.UPDATE_SETTINGS:
                            JSONObject jsonsettings = (JSONObject)json.get("settings");
                            settingsPK = JSONSettings.toSettingsPK((JSONObject)jsonsettings.get("PK"));
                            settings = blsettings.getSettings(settingsPK);
                            JSONSettings.updateSettings(settings, jsonsettings);
                            blsettings.updateSettings(settings);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(operation) {
                        case ISettingsOperation.DELETE_SETTINGS:
                            settings = (ISettings)JSONSettings.toSettings((JSONObject)json.get("settings"));
                            blsettings.deleteSettings(settings);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECURESELECT:
                    switch(operation) {
                        case ISettingsOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blsettings.count());
                            result = jsoncount.toJSONString();
                            break;
                        case ISettingsOperation.SELECT_ALL:
                            result = JSONSettings.toJSONArray(blsettings.getSettingss()).toJSONString();
                            break;
                        case ISettingsOperation.SELECT_SETTINGS:
                            settingsPK = (ISettingsPK)JSONSettings.toSettingsPK((JSONObject)json.get("settingspk"));
                            result = JSONSettings.toJSON(blsettings.getSettings(settingsPK)).toJSONString();
                            break;
                        case ISettingsOperation.SELECT_Usersettings:
                            IUsersettingsPK usersettingsPK = (IUsersettingsPK)JSONUsersettings.toUsersettingsPK((JSONObject)json.get("usersettingspk"));
                            result = JSONSettings.toJSON(blsettings.getUsersettings(usersettingsPK)).toJSONString();
                            break;
                        case ISettingsOperation.SELECT_SEARCH:
                            ISettingssearch search = (ISettingssearch)JSONSettings.toSettingssearch((JSONObject)json.get("search"));
                            result = JSONSettings.toJSONArray(blsettings.search(search)).toJSONString();
                            break;
                        case ISettingsOperation.SELECT_SEARCHCOUNT:
                            ISettingssearch settingssearch = (ISettingssearch)JSONSettings.toSettingssearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blsettings.searchcount(settingssearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREINSERT:
                    switch(operation) {
                        case ISettingsOperation.INSERT_SETTINGS:
                            settings = (ISettings)JSONSettings.toSettings((JSONObject)json.get("settings"));
                            blsettings.secureinsertSettings(settings);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREUPDATE:
                    switch(operation) {
                        case ISettingsOperation.UPDATE_SETTINGS:
                            JSONObject jsonsettings = (JSONObject)json.get("settings");
                            settingsPK = JSONSettings.toSettingsPK((JSONObject)jsonsettings.get("PK"));
                            settings = blsettings.getSettings(settingsPK);
                            JSONSettings.updateSettings(settings, jsonsettings);
                            blsettings.secureupdateSettings(settings);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREDELETE:
                    switch(operation) {
                        case ISettingsOperation.DELETE_SETTINGS:
                            settings = (ISettings)JSONSettings.toSettings((JSONObject)json.get("settings"));
                            blsettings.securedeleteSettings(settings);
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
     * PUT method for updating or creating an instance of RSSettings
     * @param content representation for the resource
     */
    @PUT
    @Consumes("text/html")
    public void put(String content) {
    }
}

