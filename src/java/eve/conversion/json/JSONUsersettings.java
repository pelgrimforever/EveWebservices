/*
 * JSONUsersettings.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 4.11.2021 14:51
 *
 */
 
package eve.conversion.json;

import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.interfaces.db.EntityPK;
import data.interfaces.db.Fieldsearcher;
import data.json.piJson;
import eve.entity.pk.UsersettingsPK;
import eve.interfaces.entity.pk.IUsersettingsPK;
import eve.interfaces.logicentity.IUsersettings;
import eve.logicentity.Usersettings;
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
public class JSONUsersettings {
    
    public static JSONArray toJSONArray(ArrayList usersettingss) {
        JSONArray jsonusersettingss = new JSONArray();
        Iterator usersettingssI = usersettingss.iterator();
        while(usersettingssI.hasNext()) {
            jsonusersettingss.add(toJSON((Usersettings)usersettingssI.next()));
        }
        return jsonusersettingss;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(IUsersettingsPK usersettingsPK) {
        JSONObject json = null;
        if(usersettingsPK!=null) {
            json = new JSONObject();
            json.put("username", usersettingsPK.getUsername());
            json.put("name", usersettingsPK.getName());
        }
        return json;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(IUsersettings usersettings) {
        JSONObject json = new JSONObject();
        json.put("PK", toJSON(usersettings.getPrimaryKey()));
        json.put("value", usersettings.getValue());
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(Usersettingssearch usersettingssearch) {
        JSONObject json = new JSONObject();
        if(usersettingssearch.used()) {
            byte andoroperator = usersettingssearch.getAndoroperator();
            int maxresults = usersettingssearch.getMaxresults();
            boolean docount = usersettingssearch.getDocount();
            Iterator<EntityPK> primarykeysI = usersettingssearch.getPrimarykeys().iterator();
            Iterator<Fieldsearcher> fieldsearchersI = usersettingssearch.getFieldsearchers().iterator();
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
            if(usersettingssearch.getSettingssearch()!=null && usersettingssearch.getSettingssearch().used()) {
                kss.put("settingssearcher", JSONSettings.toJSON((Settingssearch)usersettingssearch.getSettingssearch()));
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
    public static Usersettingssearch toUsersettingssearch(JSONObject json) {
        Usersettingssearch usersettingssearch = new Usersettingssearch();
        usersettingssearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        usersettingssearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        usersettingssearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONArray pks = (JSONArray)json.get("primarykeys");
        for(int i=0; i<pks.size(); i++) {
            usersettingssearch.addPrimarykey(UsersettingsPK.getKey((String)pks.get(i)));
        }
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("username");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            usersettingssearch.username(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("value");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            usersettingssearch.value(valuearray, compareoperator, andor);
        }
        JSONObject kss = (JSONObject)json.get("keysearch");
        JSONArray keysearch;
        keysearch = (JSONArray)kss.get("settingssearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Settingssearch settingssearch = JSONSettings.toSettingssearch((JSONObject)keysearch.get(i));
                usersettingssearch.settings(settingssearch);
            }
        }
        return usersettingssearch;
    }
    
    public static UsersettingsPK toUsersettingsPK(JSONObject json) {
        UsersettingsPK usersettingsPK = null;
        if(json!=null) {
            usersettingsPK = new UsersettingsPK(JSONConversion.getString(json, "username"), JSONConversion.getString(json, "name"));
        }
        return usersettingsPK;
    }

    public static Usersettings toUsersettings(JSONObject json) {
        Usersettings usersettings = new Usersettings(toUsersettingsPK((JSONObject)json.get("PK")));
        updateUsersettings(usersettings, json);
        return usersettings;
    }

    public static void updateUsersettings(IUsersettings usersettings, JSONObject json) {
        usersettings.setValue(JSONConversion.getString(json, "value"));
    }

    public static Usersettings initUsersettings(JSONObject json) {
        Usersettings usersettings = new Usersettings(toUsersettingsPK((JSONObject)json.get("PK")));
        usersettings.initValue(JSONConversion.getString(json, "value"));
        return usersettings;
    }
}

