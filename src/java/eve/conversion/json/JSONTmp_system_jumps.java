/*
 * JSONTmp_system_jumps.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 30.10.2021 10:3
 *
 */
 
package eve.conversion.json;

import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.interfaces.db.EntityPK;
import data.interfaces.db.Fieldsearcher;
import data.json.piJson;
import eve.entity.pk.Tmp_system_jumpsPK;
import eve.interfaces.entity.pk.ITmp_system_jumpsPK;
import eve.interfaces.logicentity.ITmp_system_jumps;
import eve.logicentity.Tmp_system_jumps;
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
public class JSONTmp_system_jumps {
    
    public static JSONArray toJSONArray(ArrayList tmp_system_jumpss) {
        JSONArray jsontmp_system_jumpss = new JSONArray();
        Iterator tmp_system_jumpssI = tmp_system_jumpss.iterator();
        while(tmp_system_jumpssI.hasNext()) {
            jsontmp_system_jumpss.add(toJSON((Tmp_system_jumps)tmp_system_jumpssI.next()));
        }
        return jsontmp_system_jumpss;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(ITmp_system_jumpsPK tmp_system_jumpsPK) {
        JSONObject json = null;
        if(tmp_system_jumpsPK!=null) {
            json = new JSONObject();
            json.put("system", String.valueOf(tmp_system_jumpsPK.getSystem()));
        }
        return json;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(ITmp_system_jumps tmp_system_jumps) {
        JSONObject json = new JSONObject();
        json.put("PK", toJSON(tmp_system_jumps.getPrimaryKey()));
        json.put("jump", tmp_system_jumps.getJump());
        json.put("maxjumps", tmp_system_jumps.getMaxjumps());
        json.put("previoussystem", String.valueOf(tmp_system_jumps.getPrevioussystem()));
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(Tmp_system_jumpssearch tmp_system_jumpssearch) {
        JSONObject json = new JSONObject();
        if(tmp_system_jumpssearch.used()) {
            byte andoroperator = tmp_system_jumpssearch.getAndoroperator();
            int maxresults = tmp_system_jumpssearch.getMaxresults();
            boolean docount = tmp_system_jumpssearch.getDocount();
            Iterator<EntityPK> primarykeysI = tmp_system_jumpssearch.getPrimarykeys().iterator();
            Iterator<Fieldsearcher> fieldsearchersI = tmp_system_jumpssearch.getFieldsearchers().iterator();
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

    /**
     * 
     * @param json: JSONObject with the Filmsearch parameters
     * @return 
     */
    public static Tmp_system_jumpssearch toTmp_system_jumpssearch(JSONObject json) {
        Tmp_system_jumpssearch tmp_system_jumpssearch = new Tmp_system_jumpssearch();
        tmp_system_jumpssearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        tmp_system_jumpssearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        tmp_system_jumpssearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONArray pks = (JSONArray)json.get("primarykeys");
        for(int i=0; i<pks.size(); i++) {
            tmp_system_jumpssearch.addPrimarykey(Tmp_system_jumpsPK.getKey((String)pks.get(i)));
        }
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("system");
        if(field!=null) {
            long[] valuearray = JSONConversion.getLongvalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            tmp_system_jumpssearch.system(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("jump");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            tmp_system_jumpssearch.jump(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("maxjumps");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            tmp_system_jumpssearch.maxjumps(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("previoussystem");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            tmp_system_jumpssearch.previoussystem(valuearray, operators, andor);
        }
        JSONObject kss = (JSONObject)json.get("keysearch");
        JSONArray keysearch;
        return tmp_system_jumpssearch;
    }
    
    public static Tmp_system_jumpsPK toTmp_system_jumpsPK(JSONObject json) {
        Tmp_system_jumpsPK tmp_system_jumpsPK = null;
        if(json!=null) {
            tmp_system_jumpsPK = new Tmp_system_jumpsPK(JSONConversion.getlong(json, "system"));
        }
        return tmp_system_jumpsPK;
    }

    public static Tmp_system_jumps toTmp_system_jumps(JSONObject json) {
        Tmp_system_jumps tmp_system_jumps = new Tmp_system_jumps(toTmp_system_jumpsPK((JSONObject)json.get("PK")));
        updateTmp_system_jumps(tmp_system_jumps, json);
        return tmp_system_jumps;
    }

    public static void updateTmp_system_jumps(ITmp_system_jumps tmp_system_jumps, JSONObject json) {
        tmp_system_jumps.setJump(JSONConversion.getint(json, "jump"));
        tmp_system_jumps.setMaxjumps(JSONConversion.getint(json, "maxjumps"));
        tmp_system_jumps.setPrevioussystem(JSONConversion.getlong(json, "previoussystem"));
    }

    public static Tmp_system_jumps initTmp_system_jumps(JSONObject json) {
        Tmp_system_jumps tmp_system_jumps = new Tmp_system_jumps(toTmp_system_jumpsPK((JSONObject)json.get("PK")));
        tmp_system_jumps.initJump(JSONConversion.getint(json, "jump"));
        tmp_system_jumps.initMaxjumps(JSONConversion.getint(json, "maxjumps"));
        tmp_system_jumps.initPrevioussystem(JSONConversion.getlong(json, "previoussystem"));
        return tmp_system_jumps;
    }
}

