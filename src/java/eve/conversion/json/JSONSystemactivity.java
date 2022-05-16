/*
 * JSONSystemactivity.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 5.3.2022 17:21
 *
 */
 
package eve.conversion.json;

import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.interfaces.db.EntityPK;
import data.interfaces.db.Fieldsearcher;
import data.json.piJson;
import eve.entity.pk.SystemactivityPK;
import eve.interfaces.entity.pk.ISystemactivityPK;
import eve.interfaces.logicentity.ISystemactivity;
import eve.logicentity.Systemactivity;
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
public class JSONSystemactivity {
    
    public static JSONArray toJSONArray(ArrayList systemactivitys) {
        JSONArray jsonsystemactivitys = new JSONArray();
        Iterator systemactivitysI = systemactivitys.iterator();
        while(systemactivitysI.hasNext()) {
            jsonsystemactivitys.add(toJSON((Systemactivity)systemactivitysI.next()));
        }
        return jsonsystemactivitys;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(ISystemactivityPK systemactivityPK) {
        JSONObject json = null;
        if(systemactivityPK!=null) {
            json = new JSONObject();
            json.put("systemid", String.valueOf(systemactivityPK.getSystemid()));
            if(systemactivityPK.getTimeslot()!=null) {
                json.put("timeslot", systemactivityPK.getTimeslot().getTime());
            }
        }
        return json;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(ISystemactivity systemactivity) {
        JSONObject json = new JSONObject();
        json.put("PK", toJSON(systemactivity.getPrimaryKey()));
        json.put("ship_jumps", String.valueOf(systemactivity.getShip_jumps()));
        json.put("npc_kills", String.valueOf(systemactivity.getNpc_kills()));
        json.put("ship_kills", String.valueOf(systemactivity.getShip_kills()));
        json.put("pod_kills", String.valueOf(systemactivity.getPod_kills()));
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(Systemactivitysearch systemactivitysearch) {
        JSONObject json = new JSONObject();
        if(systemactivitysearch.used()) {
            byte andoroperator = systemactivitysearch.getAndoroperator();
            int maxresults = systemactivitysearch.getMaxresults();
            boolean docount = systemactivitysearch.getDocount();
            Iterator<EntityPK> primarykeysI = systemactivitysearch.getPrimarykeys().iterator();
            Iterator<Fieldsearcher> fieldsearchersI = systemactivitysearch.getFieldsearchers().iterator();
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
            if(systemactivitysearch.getSystemsearch()!=null && systemactivitysearch.getSystemsearch().used()) {
                kss.put("systemsearcher", JSONSystem.toJSON((Systemsearch)systemactivitysearch.getSystemsearch()));
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
    public static Systemactivitysearch toSystemactivitysearch(JSONObject json) {
        Systemactivitysearch systemactivitysearch = new Systemactivitysearch();
        systemactivitysearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        systemactivitysearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        systemactivitysearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONArray pks = (JSONArray)json.get("primarykeys");
        for(int i=0; i<pks.size(); i++) {
            systemactivitysearch.addPrimarykey(SystemactivityPK.getKey((String)pks.get(i)));
        }
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("timeslot");
        if(field!=null) {
            Timestamp[] valuearray = JSONConversion.getTimestampvalues(field);
            byte[] operators = JSONConversion.getTimeoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            systemactivitysearch.timeslot(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("ship_jumps");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            systemactivitysearch.ship_jumps(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("npc_kills");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            systemactivitysearch.npc_kills(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("ship_kills");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            systemactivitysearch.ship_kills(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("pod_kills");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            systemactivitysearch.pod_kills(valuearray, operators, andor);
        }
        JSONObject kss = (JSONObject)json.get("keysearch");
        JSONArray keysearch;
        keysearch = (JSONArray)kss.get("systemsearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Systemsearch systemsearch = JSONSystem.toSystemsearch((JSONObject)keysearch.get(i));
                systemactivitysearch.system(systemsearch);
            }
        }
        return systemactivitysearch;
    }
    
    public static SystemactivityPK toSystemactivityPK(JSONObject json) {
        SystemactivityPK systemactivityPK = null;
        if(json!=null) {
            systemactivityPK = new SystemactivityPK(JSONConversion.getlong(json, "systemid"), JSONConversion.getTimestamp(json, "timeslot"));
        }
        return systemactivityPK;
    }

    public static Systemactivity toSystemactivity(JSONObject json) {
        Systemactivity systemactivity = new Systemactivity(toSystemactivityPK((JSONObject)json.get("PK")));
        updateSystemactivity(systemactivity, json);
        return systemactivity;
    }

    public static void updateSystemactivity(ISystemactivity systemactivity, JSONObject json) {
        systemactivity.setShip_jumps(JSONConversion.getlong(json, "ship_jumps"));
        systemactivity.setNpc_kills(JSONConversion.getlong(json, "npc_kills"));
        systemactivity.setShip_kills(JSONConversion.getlong(json, "ship_kills"));
        systemactivity.setPod_kills(JSONConversion.getlong(json, "pod_kills"));
    }

    public static Systemactivity initSystemactivity(JSONObject json) {
        Systemactivity systemactivity = new Systemactivity(toSystemactivityPK((JSONObject)json.get("PK")));
        systemactivity.initShip_jumps(JSONConversion.getlong(json, "ship_jumps"));
        systemactivity.initNpc_kills(JSONConversion.getlong(json, "npc_kills"));
        systemactivity.initShip_kills(JSONConversion.getlong(json, "ship_kills"));
        systemactivity.initPod_kills(JSONConversion.getlong(json, "pod_kills"));
        return systemactivity;
    }
}

