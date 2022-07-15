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
import eve.entity.pk.SystemjumpsPK;
import eve.interfaces.entity.pk.ISystemjumpsPK;
import eve.interfaces.logicentity.ISystemjumps;
import eve.logicentity.Systemjumps;
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
public class JSONSystemjumps {
    
    public static JSONArray toJSONArray(ArrayList systemjumpss) {
        JSONArray jsonsystemjumpss = new JSONArray();
        Iterator systemjumpssI = systemjumpss.iterator();
        while(systemjumpssI.hasNext()) {
            jsonsystemjumpss.add(toJSON((Systemjumps)systemjumpssI.next()));
        }
        return jsonsystemjumpss;
    }

    public static JSONObject toJSON(ISystemjumpsPK systemjumpsPK) {
        JSONObject json = null;
        if(systemjumpsPK!=null) {
            json = new JSONObject();
            json.put("system_start", String.valueOf(systemjumpsPK.getSystem_start()));
            json.put("system_end", String.valueOf(systemjumpsPK.getSystem_end()));
        }
        return json;
    }

    public static JSONObject toJSON(ISystemjumps systemjumps) {
        JSONObject json = new JSONObject();
        json.put("PK", toJSON(systemjumps.getPrimaryKey()));
        json.put("jumps", systemjumps.getJumps());
        json.put("jumpslowsec", systemjumps.getJumpslowsec());
        json.put("jumpsnullsec", systemjumps.getJumpsnullsec());
        json.put("jumpssafe", systemjumps.getJumpssafe());
        json.put("jumpssafelowsec", systemjumps.getJumpssafelowsec());
        json.put("jumpssafenullsec", systemjumps.getJumpssafenullsec());
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    public static JSONObject toJSON(Systemjumpssearch systemjumpssearch) {
        JSONObject json = new JSONObject();
        if(systemjumpssearch.used()) {
            byte andoroperator = systemjumpssearch.getAndoroperator();
            int maxresults = systemjumpssearch.getMaxresults();
            boolean docount = systemjumpssearch.getDocount();
            Iterator<EntityPK> primarykeysI = systemjumpssearch.getPrimarykeys().iterator();
            Iterator<Fieldsearcher> fieldsearchersI = systemjumpssearch.getFieldsearchers().iterator();
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
            if(systemjumpssearch.getSystemsystem_endsearch()!=null && systemjumpssearch.getSystemsystem_endsearch().used()) {
                kss.put("systemSystem_endsearcher", JSONSystem.toJSON((Systemsearch)systemjumpssearch.getSystemsystem_endsearch()));
            }
            if(systemjumpssearch.getSystemsystem_startsearch()!=null && systemjumpssearch.getSystemsystem_startsearch().used()) {
                kss.put("systemSystem_startsearcher", JSONSystem.toJSON((Systemsearch)systemjumpssearch.getSystemsystem_startsearch()));
            }
            json.put("keysearch", kss);
        }
        return json;
    }

    public static Systemjumpssearch toSystemjumpssearch(JSONObject json) {
        Systemjumpssearch systemjumpssearch = new Systemjumpssearch();
        systemjumpssearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        systemjumpssearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        systemjumpssearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONArray pks = (JSONArray)json.get("primarykeys");
        for(int i=0; i<pks.size(); i++) {
            systemjumpssearch.addPrimarykey(SystemjumpsPK.getKey((String)pks.get(i)));
        }
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("jumps");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            systemjumpssearch.jumps(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("jumpslowsec");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            systemjumpssearch.jumpslowsec(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("jumpsnullsec");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            systemjumpssearch.jumpsnullsec(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("jumpssafe");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            systemjumpssearch.jumpssafe(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("jumpssafelowsec");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            systemjumpssearch.jumpssafelowsec(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("jumpssafenullsec");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            systemjumpssearch.jumpssafenullsec(valuearray, operators, andor);
        }
        JSONObject kss = (JSONObject)json.get("keysearch");
        JSONArray keysearch;
        keysearch = (JSONArray)kss.get("systemSystem_endsearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Systemsearch systemSystem_endsearch = JSONSystem.toSystemsearch((JSONObject)keysearch.get(i));
                systemjumpssearch.systemSystem_end(systemSystem_endsearch);
            }
        }
        keysearch = (JSONArray)kss.get("systemSystem_startsearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Systemsearch systemSystem_startsearch = JSONSystem.toSystemsearch((JSONObject)keysearch.get(i));
                systemjumpssearch.systemSystem_start(systemSystem_startsearch);
            }
        }
        return systemjumpssearch;
    }
    
    public static SystemjumpsPK toSystemjumpsPK(JSONObject json) {
        SystemjumpsPK systemjumpsPK = null;
        if(json!=null) {
            systemjumpsPK = new SystemjumpsPK(JSONConversion.getlong(json, "system_start"), JSONConversion.getlong(json, "system_end"));
        }
        return systemjumpsPK;
    }

    public static Systemjumps toSystemjumps(JSONObject json) {
        Systemjumps systemjumps = new Systemjumps(toSystemjumpsPK((JSONObject)json.get("PK")));
        updateSystemjumps(systemjumps, json);
        return systemjumps;
    }

    public static void updateSystemjumps(ISystemjumps systemjumps, JSONObject json) {
        systemjumps.setJumps(JSONConversion.getint(json, "jumps"));
        systemjumps.setJumpslowsec(JSONConversion.getint(json, "jumpslowsec"));
        systemjumps.setJumpsnullsec(JSONConversion.getint(json, "jumpsnullsec"));
        systemjumps.setJumpssafe(JSONConversion.getint(json, "jumpssafe"));
        systemjumps.setJumpssafelowsec(JSONConversion.getint(json, "jumpssafelowsec"));
        systemjumps.setJumpssafenullsec(JSONConversion.getint(json, "jumpssafenullsec"));
    }

    public static Systemjumps initSystemjumps(JSONObject json) {
        Systemjumps systemjumps = new Systemjumps(toSystemjumpsPK((JSONObject)json.get("PK")));
        systemjumps.initJumps(JSONConversion.getint(json, "jumps"));
        systemjumps.initJumpslowsec(JSONConversion.getint(json, "jumpslowsec"));
        systemjumps.initJumpsnullsec(JSONConversion.getint(json, "jumpsnullsec"));
        systemjumps.initJumpssafe(JSONConversion.getint(json, "jumpssafe"));
        systemjumps.initJumpssafelowsec(JSONConversion.getint(json, "jumpssafelowsec"));
        systemjumps.initJumpssafenullsec(JSONConversion.getint(json, "jumpssafenullsec"));
        return systemjumps;
    }
}

