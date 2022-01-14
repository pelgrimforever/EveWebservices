/*
 * JSONAllnodes_stargate.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 8.0.2022 19:32
 *
 */
 
package eve.conversion.json;

import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.interfaces.db.EntityPK;
import data.interfaces.db.Fieldsearcher;
import data.json.piJson;
import eve.entity.pk.Allnodes_stargatePK;
import eve.interfaces.entity.pk.IAllnodes_stargatePK;
import eve.interfaces.logicentity.IAllnodes_stargate;
import eve.logicentity.Allnodes_stargate;
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
public class JSONAllnodes_stargate {
    
    public static JSONArray toJSONArray(ArrayList allnodes_stargates) {
        JSONArray jsonallnodes_stargates = new JSONArray();
        Iterator allnodes_stargatesI = allnodes_stargates.iterator();
        while(allnodes_stargatesI.hasNext()) {
            jsonallnodes_stargates.add(toJSON((Allnodes_stargate)allnodes_stargatesI.next()));
        }
        return jsonallnodes_stargates;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(IAllnodes_stargatePK allnodes_stargatePK) {
        JSONObject json = null;
        if(allnodes_stargatePK!=null) {
            json = new JSONObject();
            json.put("id", String.valueOf(allnodes_stargatePK.getId()));
        }
        return json;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(IAllnodes_stargate allnodes_stargate) {
        JSONObject json = new JSONObject();
        json.put("PK", toJSON(allnodes_stargate.getPrimaryKey()));
        json.put("to_stargate", String.valueOf(allnodes_stargate.getTo_stargate()));
        json.put("system", String.valueOf(allnodes_stargate.getSystem()));
        json.put("to_system", String.valueOf(allnodes_stargate.getTo_system()));
        json.put("deadend", allnodes_stargate.getDeadend());
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(Allnodes_stargatesearch allnodes_stargatesearch) {
        JSONObject json = new JSONObject();
        if(allnodes_stargatesearch.used()) {
            byte andoroperator = allnodes_stargatesearch.getAndoroperator();
            int maxresults = allnodes_stargatesearch.getMaxresults();
            boolean docount = allnodes_stargatesearch.getDocount();
            Iterator<EntityPK> primarykeysI = allnodes_stargatesearch.getPrimarykeys().iterator();
            Iterator<Fieldsearcher> fieldsearchersI = allnodes_stargatesearch.getFieldsearchers().iterator();
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
    public static Allnodes_stargatesearch toAllnodes_stargatesearch(JSONObject json) {
        Allnodes_stargatesearch allnodes_stargatesearch = new Allnodes_stargatesearch();
        allnodes_stargatesearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        allnodes_stargatesearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        allnodes_stargatesearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONArray pks = (JSONArray)json.get("primarykeys");
        for(int i=0; i<pks.size(); i++) {
            allnodes_stargatesearch.addPrimarykey(Allnodes_stargatePK.getKey((String)pks.get(i)));
        }
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("id");
        if(field!=null) {
            long[] valuearray = JSONConversion.getLongvalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            allnodes_stargatesearch.id(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("to_stargate");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            allnodes_stargatesearch.to_stargate(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("system");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            allnodes_stargatesearch.system(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("to_system");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            allnodes_stargatesearch.to_system(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("deadend");
        if(field!=null) {
            boolean value = JSONConversion.getBooleanvalue(field);
            allnodes_stargatesearch.deadend(value);
        }
        JSONObject kss = (JSONObject)json.get("keysearch");
        JSONArray keysearch;
        return allnodes_stargatesearch;
    }
    
    public static Allnodes_stargatePK toAllnodes_stargatePK(JSONObject json) {
        Allnodes_stargatePK allnodes_stargatePK = null;
        if(json!=null) {
            allnodes_stargatePK = new Allnodes_stargatePK(JSONConversion.getlong(json, "id"));
        }
        return allnodes_stargatePK;
    }

    public static Allnodes_stargate toAllnodes_stargate(JSONObject json) {
        Allnodes_stargate allnodes_stargate = new Allnodes_stargate(toAllnodes_stargatePK((JSONObject)json.get("PK")));
        updateAllnodes_stargate(allnodes_stargate, json);
        return allnodes_stargate;
    }

    public static void updateAllnodes_stargate(IAllnodes_stargate allnodes_stargate, JSONObject json) {
        allnodes_stargate.setTo_stargate(JSONConversion.getlong(json, "to_stargate"));
        allnodes_stargate.setSystem(JSONConversion.getlong(json, "system"));
        allnodes_stargate.setTo_system(JSONConversion.getlong(json, "to_system"));
        allnodes_stargate.setDeadend(JSONConversion.getboolean(json, "deadend"));
    }

    public static Allnodes_stargate initAllnodes_stargate(JSONObject json) {
        Allnodes_stargate allnodes_stargate = new Allnodes_stargate(toAllnodes_stargatePK((JSONObject)json.get("PK")));
        allnodes_stargate.initTo_stargate(JSONConversion.getlong(json, "to_stargate"));
        allnodes_stargate.initSystem(JSONConversion.getlong(json, "system"));
        allnodes_stargate.initTo_system(JSONConversion.getlong(json, "to_system"));
        allnodes_stargate.initDeadend(JSONConversion.getboolean(json, "deadend"));
        return allnodes_stargate;
    }
}

