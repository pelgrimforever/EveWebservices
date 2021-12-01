/*
 * JSONSecurity_island.java
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
import eve.entity.pk.Security_islandPK;
import eve.interfaces.entity.pk.ISecurity_islandPK;
import eve.interfaces.logicentity.ISecurity_island;
import eve.logicentity.Security_island;
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
public class JSONSecurity_island {
    
    public static JSONArray toJSONArray(ArrayList security_islands) {
        JSONArray jsonsecurity_islands = new JSONArray();
        Iterator security_islandsI = security_islands.iterator();
        while(security_islandsI.hasNext()) {
            jsonsecurity_islands.add(toJSON((Security_island)security_islandsI.next()));
        }
        return jsonsecurity_islands;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(ISecurity_islandPK security_islandPK) {
        JSONObject json = null;
        if(security_islandPK!=null) {
            json = new JSONObject();
            json.put("id", String.valueOf(security_islandPK.getId()));
        }
        return json;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(ISecurity_island security_island) {
        JSONObject json = new JSONObject();
        json.put("PK", toJSON(security_island.getPrimaryKey()));
        json.put("name", security_island.getName());
        json.put("security_status", security_island.getSecurity_status());
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(Security_islandsearch security_islandsearch) {
        JSONObject json = new JSONObject();
        if(security_islandsearch.used()) {
            byte andoroperator = security_islandsearch.getAndoroperator();
            int maxresults = security_islandsearch.getMaxresults();
            boolean docount = security_islandsearch.getDocount();
            Iterator<EntityPK> primarykeysI = security_islandsearch.getPrimarykeys().iterator();
            Iterator<Fieldsearcher> fieldsearchersI = security_islandsearch.getFieldsearchers().iterator();
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
    public static Security_islandsearch toSecurity_islandsearch(JSONObject json) {
        Security_islandsearch security_islandsearch = new Security_islandsearch();
        security_islandsearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        security_islandsearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        security_islandsearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONArray pks = (JSONArray)json.get("primarykeys");
        for(int i=0; i<pks.size(); i++) {
            security_islandsearch.addPrimarykey(Security_islandPK.getKey((String)pks.get(i)));
        }
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("id");
        if(field!=null) {
            long[] valuearray = JSONConversion.getLongvalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            security_islandsearch.id(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("name");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            security_islandsearch.name(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("security_status");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            security_islandsearch.security_status(valuearray, operators, andor);
        }
        JSONObject kss = (JSONObject)json.get("keysearch");
        JSONArray keysearch;
        return security_islandsearch;
    }
    
    public static Security_islandPK toSecurity_islandPK(JSONObject json) {
        Security_islandPK security_islandPK = null;
        if(json!=null) {
            security_islandPK = new Security_islandPK(JSONConversion.getlong(json, "id"));
        }
        return security_islandPK;
    }

    public static Security_island toSecurity_island(JSONObject json) {
        Security_island security_island = new Security_island(toSecurity_islandPK((JSONObject)json.get("PK")));
        updateSecurity_island(security_island, json);
        return security_island;
    }

    public static void updateSecurity_island(ISecurity_island security_island, JSONObject json) {
        security_island.setName(JSONConversion.getString(json, "name"));
        security_island.setSecurity_status(JSONConversion.getdouble(json, "security_status"));
    }

    public static Security_island initSecurity_island(JSONObject json) {
        Security_island security_island = new Security_island(toSecurity_islandPK((JSONObject)json.get("PK")));
        security_island.initName(JSONConversion.getString(json, "name"));
        security_island.initSecurity_status(JSONConversion.getdouble(json, "security_status"));
        return security_island;
    }
}

