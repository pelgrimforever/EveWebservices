/*
 * Generated on 17.6.2022 13:4
 */

package eve.restservices.settings;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.usecases.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.searchentity.ISettingssearch;
import eve.interfaces.servlet.ISettingsOperation;
import eve.logicentity.Settings;
import eve.searchentity.Settingssearch;
import eve.servlets.DataServlet;
import eve.usecases.custom.*;
import general.exception.*;
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
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
@Path("rssettings_select")
public class RSSettings_select extends RS_json_login {

    private Security_usecases security_usecases = new Security_usecases();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Settings_usecases settingsusecases = new Settings_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case ISettingsOperation.SELECT_COUNT:
                    result = count_records(settingsusecases);
                    break;
                case ISettingsOperation.SELECT_ALL:
                    result = get_all_settings(settingsusecases);
                    break;
                case ISettingsOperation.SELECT_SETTINGS:
                    result = get_settings_with_primarykey(settingsusecases, json);
                    break;
                case ISettingsOperation.SELECT_Usersettings:
                    result = get_settings_with_externalforeignkey_usersettings(settingsusecases, json);
                    break;
                case ISettingsOperation.SELECT_SEARCH:
                    result = search_settings(settingsusecases, json);
                    break;
                case ISettingsOperation.SELECT_SEARCHCOUNT:
                    result = search_settings_count(settingsusecases, json);
                    break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            }
        }
        catch(ParseException | CustomException | IOException e) {
            setReturnstatus(e.getMessage());
        }
        return result;
    }

//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   

    private String count_records(Settings_usecases settingsusecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", settingsusecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_settings(Settings_usecases settingsusecases) throws ParseException, CustomException {
    	return JSONSettings.toJSONArray(settingsusecases.get_all()).toJSONString();
    }
    
    private String get_settings_with_primarykey(Settings_usecases settingsusecases, JSONObject json) throws ParseException, CustomException {
        ISettingsPK settingsPK = (ISettingsPK)JSONSettings.toSettingsPK((JSONObject)json.get("settingspk"));
	return JSONSettings.toJSON(settingsusecases.get_settings_by_primarykey(settingsPK)).toJSONString();
    }
    
    private String get_settings_with_externalforeignkey_usersettings(Settings_usecases settingsusecases, JSONObject json) throws ParseException, CustomException {
        IUsersettingsPK usersettingsPK = (IUsersettingsPK)JSONUsersettings.toUsersettingsPK((JSONObject)json.get("usersettingspk"));
        return JSONSettings.toJSON(settingsusecases.get_settings_with_externalforeignkey_usersettings(usersettingsPK)).toJSONString();
    }
    
    private String search_settings(Settings_usecases settingsusecases, JSONObject json) throws ParseException, CustomException {
        ISettingssearch search = (ISettingssearch)JSONSettings.toSettingssearch((JSONObject)json.get("search"));
        return JSONSettings.toJSONArray(settingsusecases.search_settings(search)).toJSONString();
    }
    
    private String search_settings_count(Settings_usecases settingsusecases, JSONObject json) throws ParseException, CustomException {
        ISettingssearch settingssearch = (ISettingssearch)JSONSettings.toSettingssearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", settingsusecases.search_settings_count(settingssearch));
        return jsonsearchcount.toJSONString();
    }
}

