/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 17.6.2022 13:4
 */
 
package eve.conversion.json;

import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.interfaces.db.EntityPK;
import data.interfaces.db.Fieldsearcher;
import data.json.piJson;
import eve.entity.pk.Allnodes_systemPK;
import eve.interfaces.entity.pk.IAllnodes_systemPK;
import eve.interfaces.logicentity.IAllnodes_system;
import eve.logicentity.Allnodes_system;
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
public class JSONAllnodes_system {
    
    public static JSONArray toJSONArray(ArrayList allnodes_systems) {
        JSONArray jsonallnodes_systems = new JSONArray();
        Iterator allnodes_systemsI = allnodes_systems.iterator();
        while(allnodes_systemsI.hasNext()) {
            jsonallnodes_systems.add(toJSON((Allnodes_system)allnodes_systemsI.next()));
        }
        return jsonallnodes_systems;
    }

    public static JSONObject toJSON(IAllnodes_systemPK allnodes_systemPK) {
        JSONObject json = null;
        if(allnodes_systemPK!=null) {
            json = new JSONObject();
            json.put("id", String.valueOf(allnodes_systemPK.getId()));
        }
        return json;
    }

    public static JSONObject toJSON(IAllnodes_system allnodes_system) {
        JSONObject json = new JSONObject();
        json.put("PK", toJSON(allnodes_system.getPrimaryKey()));
        json.put("deadend", allnodes_system.getDeadend());
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    public static JSONObject toJSON(Allnodes_systemsearch allnodes_systemsearch) {
        JSONObject json = new JSONObject();
        if(allnodes_systemsearch.used()) {
            byte andoroperator = allnodes_systemsearch.getAndoroperator();
            int maxresults = allnodes_systemsearch.getMaxresults();
            boolean docount = allnodes_systemsearch.getDocount();
            Iterator<EntityPK> primarykeysI = allnodes_systemsearch.getPrimarykeys().iterator();
            Iterator<Fieldsearcher> fieldsearchersI = allnodes_systemsearch.getFieldsearchers().iterator();
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

    public static Allnodes_systemsearch toAllnodes_systemsearch(JSONObject json) {
        Allnodes_systemsearch allnodes_systemsearch = new Allnodes_systemsearch();
        allnodes_systemsearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        allnodes_systemsearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        allnodes_systemsearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONArray pks = (JSONArray)json.get("primarykeys");
        for(int i=0; i<pks.size(); i++) {
            allnodes_systemsearch.addPrimarykey(Allnodes_systemPK.getKey((String)pks.get(i)));
        }
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("id");
        if(field!=null) {
            long[] valuearray = JSONConversion.getLongvalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            allnodes_systemsearch.id(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("deadend");
        if(field!=null) {
            boolean value = JSONConversion.getBooleanvalue(field);
            allnodes_systemsearch.deadend(value);
        }
        JSONObject kss = (JSONObject)json.get("keysearch");
        JSONArray keysearch;
        return allnodes_systemsearch;
    }
    
    public static Allnodes_systemPK toAllnodes_systemPK(JSONObject json) {
        Allnodes_systemPK allnodes_systemPK = null;
        if(json!=null) {
            allnodes_systemPK = new Allnodes_systemPK(JSONConversion.getlong(json, "id"));
        }
        return allnodes_systemPK;
    }

    public static Allnodes_system toAllnodes_system(JSONObject json) {
        Allnodes_system allnodes_system = new Allnodes_system(toAllnodes_systemPK((JSONObject)json.get("PK")));
        updateAllnodes_system(allnodes_system, json);
        return allnodes_system;
    }

    public static void updateAllnodes_system(IAllnodes_system allnodes_system, JSONObject json) {
        allnodes_system.setDeadend(JSONConversion.getboolean(json, "deadend"));
    }

    public static Allnodes_system initAllnodes_system(JSONObject json) {
        Allnodes_system allnodes_system = new Allnodes_system(toAllnodes_systemPK((JSONObject)json.get("PK")));
        allnodes_system.initDeadend(JSONConversion.getboolean(json, "deadend"));
        return allnodes_system;
    }
}

