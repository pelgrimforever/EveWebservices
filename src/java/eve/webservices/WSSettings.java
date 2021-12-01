/*
 * WSSettings.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 30.10.2021 10:3
 *
 */

package eve.webservices;

import eve.BusinessObject.Logic.*;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.webservice.WSISettings;
import eve.logicentity.Settings;
import eve.searchentity.Settingssearch;
import general.exception.CustomException;
import general.exception.DataException;
import general.exception.DBException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.jws.WebMethod;
import javax.jws.WebService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Franky Laseure
 */
@WebService(endpointInterface = "eve.interfaces.webservice.WSISettings")
public class WSSettings implements WSISettings {

    private JSONArray toJSONArray(ArrayList settingss) {
        JSONArray jsonsettingss = new JSONArray();
        Iterator settingssI = settingss.iterator();
        while(settingssI.hasNext()) {
            jsonsettingss.add(JSONSettings.toJSON((Settings)settingssI.next()));
        }
        return jsonsettingss;
    }

    /**
     * Web service operation
     */
    //@WebMethod(operationName = "getSettingss")
    @Override
    public String getSettingss() {
        try {
            BLsettings blsettings = new BLsettings();
            ArrayList settingss = blsettings.getAll();
            JSONArray jsonsettingss = toJSONArray(settingss);
            return jsonsettingss.toJSONString();
        }
        catch(DBException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "search")
    @Override
    public String search(String json) {
        BLsettings blsettings = new BLsettings();
        JSONParser parser = new JSONParser();
        String result = "";
        Settings settings;
        try {
            Settingssearch settingssearch = JSONSettings.toSettingssearch((JSONObject)parser.parse(json));
            ArrayList settingss = blsettings.search(settingssearch);
            JSONArray jsonsettingss = toJSONArray(settingss);
            result = jsonsettingss.toJSONString();
        }
        catch(ParseException e) {
            result = "";
        }
        catch(DBException e) {
            result = "";
        }
        return result;
    }

    //@WebMethod(operationName = "getSettings")
    @Override
    public String getSettings(String json) {
        BLsettings blsettings = new BLsettings();
        JSONParser parser = new JSONParser();
        String result = "";
        Settings settings;
        try {
            SettingsPK settingsPK = JSONSettings.toSettingsPK((JSONObject)parser.parse(json));
            settings = blsettings.getSettings(settingsPK);
            if(settings!=null) {
                result = JSONSettings.toJSON(settings).toJSONString();
            }
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
        return result;
    }

    //@WebMethod(operationName = "insertSettings")
    @Override
    public void insertSettings(String json) {
        BLsettings blsettings = new BLsettings();
        JSONParser parser = new JSONParser();
        try {
            ISettings settings = JSONSettings.toSettings((JSONObject)parser.parse(json));
            blsettings.insertSettings(settings);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "updateSettings")
    @Override
    public void updateSettings(String json) {
        BLsettings blsettings = new BLsettings();
        JSONParser parser = new JSONParser();
        try {
            ISettings settings = JSONSettings.toSettings((JSONObject)parser.parse(json));
            blsettings.updateSettings(settings);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "deleteSettings")
    @Override
    public void deleteSettings(String json) {
        BLsettings blsettings = new BLsettings();
        JSONParser parser = new JSONParser();
        try {
            ISettings settings = JSONSettings.toSettings((JSONObject)parser.parse(json));
            blsettings.deleteSettings(settings);
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "getSettingss4usersettings")
    @Override
    public String getSettingss4usersettings(String json) {
        BLsettings blsettings = new BLsettings();
        JSONParser parser = new JSONParser();
        Settings settings;
        try {
            String result = null;
            IUsersettingsPK usersettingsPK = JSONUsersettings.toUsersettingsPK((JSONObject)parser.parse(json));
            settings = (Settings)blsettings.getUsersettings(usersettingsPK);
            if(settings!=null) {
                result = JSONSettings.toJSON(settings).toJSONString();
            }
            return result;
        }
        catch(ParseException e) {
            return null;
        }
        catch(DBException e) {
            return null;
        }
        catch(CustomException e) {
            return null;
        }
    }


}

