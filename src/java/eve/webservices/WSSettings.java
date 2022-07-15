/*
 * WSSettings.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 13.6.2022 18:20
 *
 */

package eve.webservices;

import base.restservices.RS_json_login;
import eve.BusinessObject.Logic.*;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.searchentity.ISettingssearch;
import eve.interfaces.webservice.WSISettings;
import eve.logicentity.Settings;
import eve.searchentity.Settingssearch;
import eve.usecases.*;
import general.exception.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.jws.WebMethod;
import javax.jws.WebService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import eve.usecases.custom.Security_usecases;

/**
 *
 * @author Franky Laseure
 */
@WebService(endpointInterface = "eve.interfaces.webservice.WSISettings")
public class WSSettings extends RS_json_login implements WSISettings {

    private Security_usecases security_usecases = new Security_usecases();
    
    private JSONArray toJSONArray(ArrayList settingss) {
        JSONArray jsonsettingss = new JSONArray();
        Iterator settingssI = settingss.iterator();
        while(settingssI.hasNext()) {
            jsonsettingss.add(JSONSettings.toJSON((Settings)settingssI.next()));
        }
        return jsonsettingss;
    }

    //@WebMethod(operationName = "getSettingss")
    @Override
    public String getSettingss() {
        try {
            Settings_usecases settingsusecases = new Settings_usecases(loggedin);
            return get_all_settings(settingsusecases);
        }
        catch(CustomException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "search")
    @Override
    public String search(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Settings_usecases settingsusecases = new Settings_usecases(loggedin);
            return search_settings(settingsusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "getSettings")
    @Override
    public String getSettings(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Settings_usecases settingsusecases = new Settings_usecases(loggedin);
            return get_settings_with_primarykey(settingsusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "insertSettings")
    @Override
    public void insertSettings(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Settings_usecases settingsusecases = new Settings_usecases(loggedin);
            insert_settings(settingsusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "updateSettings")
    @Override
    public void updateSettings(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Settings_usecases settingsusecases = new Settings_usecases(loggedin);
            update_settings(settingsusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "deleteSettings")
    @Override
    public void deleteSettings(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Settings_usecases settingsusecases = new Settings_usecases(loggedin);
            delete_settings(settingsusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getSettingss4usersettings")
    @Override
    public String getSettingss4usersettings(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Settings_usecases settingsusecases = new Settings_usecases(loggedin);
            return get_settings_with_externalforeignkey_usersettings(settingsusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }


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

    private void insert_settings(Settings_usecases settingsusecases, JSONObject json) throws ParseException, CustomException {
        ISettings settings = (ISettings)JSONSettings.toSettings((JSONObject)json.get("settings"));
        settingsusecases.insertSettings(settings);
        setReturnstatus("OK");
    }

    private void update_settings(Settings_usecases settingsusecases, JSONObject json) throws ParseException, CustomException {
        ISettings settings = (ISettings)JSONSettings.toSettings((JSONObject)json.get("settings"));
        settingsusecases.updateSettings(settings);
        setReturnstatus("OK");
    }

    private void delete_settings(Settings_usecases settingsusecases, JSONObject json) throws ParseException, CustomException {
        ISettings settings = (ISettings)JSONSettings.toSettings((JSONObject)json.get("settings"));
        settingsusecases.deleteSettings(settings);
        setReturnstatus("OK");
    }

}

