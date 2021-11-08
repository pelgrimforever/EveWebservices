/*
 * JSONSettings.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 8.10.2021 7:21
 *
 */
 
package eve.conversion.json;

import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.interfaces.db.EntityPK;
import data.interfaces.db.Fieldsearcher;
import data.json.piJson;
import eve.entity.pk.SettingsPK;
import eve.interfaces.entity.pk.ISettingsPK;
import eve.interfaces.logicentity.ISettings;
import eve.logicentity.Settings;
import eve.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * JSON fields are by default ignored
 * @author Franky Laseure
 */
public class JSONSettings {
    
    public static JSONArray toJSONArray(ArrayList settingss) {
        JSONArray jsonsettingss = new JSONArray();
        Iterator settingssI = settingss.iterator();
        while(settingssI.hasNext()) {
            jsonsettingss.add(toJSON((Settings)settingssI.next()));
        }
        return jsonsettingss;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(ISettingsPK settingsPK) {
        JSONObject json = null;
        if(settingsPK!=null) {
            json = new JSONObject();
            json.put("name", settingsPK.getName());
        }
        return json;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(ISettings settings) {
        JSONObject json = new JSONObject();
        json.put("PK", toJSON(settings.getPrimaryKey()));
        json.put("value", settings.getValue());
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(Settingssearch settingssearch) {
        JSONObject json = new JSONObject();
        if(settingssearch.used()) {
            byte andoroperator = settingssearch.getAndoroperator();
            int maxresults = settingssearch.getMaxresults();
            boolean docount = settingssearch.getDocount();
            Iterator<EntityPK> primarykeysI = settingssearch.getPrimarykeys().iterator();
            Iterator<Fieldsearcher> fieldsearchersI = settingssearch.getFieldsearchers().iterator();
            EntityPK primarykey;
            Fieldsearcher fieldsearcher;
            
            json.put("andor", andoroperator);
            json.put("maxresults", maxresults);
            json.put("docount", docount);
            JSONArray pks = new JSONArray();
            int i = 0;
            while(primarykeysI.hasNext()) {
                primarykey = primarykeysI.next();
                pks.add(primarykey.getKeystring());
            }
            json.put("primarykeys", pks);
            JSONObject fss = new JSONObject();
            while(fieldsearchersI.hasNext()) {
                fieldsearcher = fieldsearchersI.next();
                if(fieldsearcher.used()) {
                    fss.put(fieldsearcher.getShortFieldname(), JSONConversion.toJSON(fieldsearcher));
                }
            }
            json.put("fields", fss);
            JSONObject kss = new JSONObject();
            if(settingssearch.getUsersettingssearch()!=null && settingssearch.getUsersettingssearch().used()) {
                kss.put("usersettingssearcher", JSONUsersettings.toJSON((Usersettingssearch)settingssearch.getUsersettingssearch()));
            }
            json.put("keysearch", kss);
        }
        return json;
    }

    /**
     * 
     * @param json: JSONObject with the Filmsearch parameters
     * @return 
     */
    public static Settingssearch toSettingssearch(JSONObject json) {
        Settingssearch settingssearch = new Settingssearch();
        settingssearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        settingssearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        settingssearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONArray pks = (JSONArray)json.get("primarykeys");
        for(int i=0; i<pks.size(); i++) {
            settingssearch.addPrimarykey(SettingsPK.getKey((String)pks.get(i)));
        }
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("name");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            settingssearch.name(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("value");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            settingssearch.value(valuearray, operators, andor);
        }
        JSONObject kss = (JSONObject)json.get("keysearch");
        JSONArray keysearch;
        keysearch = (JSONArray)kss.get("usersettingssearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Usersettingssearch usersettingssearch = JSONUsersettings.toUsersettingssearch((JSONObject)keysearch.get(i));
                settingssearch.usersettings(usersettingssearch);
            }
        }
        return settingssearch;
    }
    
    public static SettingsPK toSettingsPK(JSONObject json) {
        SettingsPK settingsPK = null;
        if(json!=null) {
            settingsPK = new SettingsPK(JSONConversion.getString(json, "name"));
        }
        return settingsPK;
    }

    public static Settings toSettings(JSONObject json) {
        Settings settings = new Settings(toSettingsPK((JSONObject)json.get("PK")));
        updateSettings(settings, json);
        return settings;
    }

    public static void updateSettings(ISettings settings, JSONObject json) {
        settings.setValue(JSONConversion.getdouble(json, "value"));
    }

    public static Settings initSettings(JSONObject json) {
        Settings settings = new Settings(toSettingsPK((JSONObject)json.get("PK")));
        settings.initValue(JSONConversion.getdouble(json, "value"));
        return settings;
    }
}

