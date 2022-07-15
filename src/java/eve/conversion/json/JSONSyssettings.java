/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 13.6.2022 11:21
 */
 
package eve.conversion.json;

import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.interfaces.db.EntityPK;
import data.interfaces.db.Fieldsearcher;
import data.json.piJson;
import eve.entity.pk.SyssettingsPK;
import eve.interfaces.entity.pk.ISyssettingsPK;
import eve.interfaces.logicentity.ISyssettings;
import eve.logicentity.Syssettings;
import eve.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * @author Franky Laseure
 */
public class JSONSyssettings {
    
    public static JSONArray toJSONArray(ArrayList syssettingss) {
        JSONArray jsonsyssettingss = new JSONArray();
        Iterator syssettingssI = syssettingss.iterator();
        while(syssettingssI.hasNext()) {
            jsonsyssettingss.add(toJSON((Syssettings)syssettingssI.next()));
        }
        return jsonsyssettingss;
    }

    public static JSONObject toJSON(ISyssettingsPK syssettingsPK) {
        JSONObject json = null;
        if(syssettingsPK!=null) {
            json = new JSONObject();
            json.put("name", syssettingsPK.getName());
        }
        return json;
    }

    public static JSONObject toJSON(ISyssettings syssettings) {
        JSONObject json = new JSONObject();
        json.put("PK", toJSON(syssettings.getPrimaryKey()));
        json.put("value", syssettings.getValue());
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    public static JSONObject toJSON(Syssettingssearch syssettingssearch) {
        JSONObject json = new JSONObject();
        if(syssettingssearch.used()) {
            byte andoroperator = syssettingssearch.getAndoroperator();
            int maxresults = syssettingssearch.getMaxresults();
            boolean docount = syssettingssearch.getDocount();
            Iterator<EntityPK> primarykeysI = syssettingssearch.getPrimarykeys().iterator();
            Iterator<Fieldsearcher> fieldsearchersI = syssettingssearch.getFieldsearchers().iterator();
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
            json.put("keysearch", kss);
        }
        return json;
    }

    public static Syssettingssearch toSyssettingssearch(JSONObject json) {
        Syssettingssearch syssettingssearch = new Syssettingssearch();
        syssettingssearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        syssettingssearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        syssettingssearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONArray pks = (JSONArray)json.get("primarykeys");
        for(int i=0; i<pks.size(); i++) {
            syssettingssearch.addPrimarykey(SyssettingsPK.getKey((String)pks.get(i)));
        }
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("name");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            syssettingssearch.name(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("value");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            syssettingssearch.value(valuearray, compareoperator, andor);
        }
        JSONObject kss = (JSONObject)json.get("keysearch");
        JSONArray keysearch;
        return syssettingssearch;
    }
    
    public static SyssettingsPK toSyssettingsPK(JSONObject json) {
        SyssettingsPK syssettingsPK = null;
        if(json!=null) {
            syssettingsPK = new SyssettingsPK(JSONConversion.getString(json, "name"));
        }
        return syssettingsPK;
    }

    public static Syssettings toSyssettings(JSONObject json) {
        Syssettings syssettings = new Syssettings(toSyssettingsPK((JSONObject)json.get("PK")));
        updateSyssettings(syssettings, json);
        return syssettings;
    }

    public static void updateSyssettings(ISyssettings syssettings, JSONObject json) {
        syssettings.setValue(JSONConversion.getString(json, "value"));
    }

    public static Syssettings initSyssettings(JSONObject json) {
        Syssettings syssettings = new Syssettings(toSyssettingsPK((JSONObject)json.get("PK")));
        syssettings.initValue(JSONConversion.getString(json, "value"));
        return syssettings;
    }
}

