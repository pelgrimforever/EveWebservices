/*
 * JSONFaction.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 24.9.2021 14:40
 *
 */
 
package eve.conversion.json;

import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.interfaces.db.EntityPK;
import data.interfaces.db.Fieldsearcher;
import data.json.piJson;
import eve.entity.pk.FactionPK;
import eve.interfaces.entity.pk.IFactionPK;
import eve.interfaces.logicentity.IFaction;
import eve.logicentity.Faction;
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
public class JSONFaction {
    
    public static JSONArray toJSONArray(ArrayList factions) {
        JSONArray jsonfactions = new JSONArray();
        Iterator factionsI = factions.iterator();
        while(factionsI.hasNext()) {
            jsonfactions.add(toJSON((Faction)factionsI.next()));
        }
        return jsonfactions;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(IFactionPK factionPK) {
        JSONObject json = null;
        if(factionPK!=null) {
            json = new JSONObject();
            json.put("id", String.valueOf(factionPK.getId()));
        }
        return json;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(IFaction faction) {
        JSONObject json = new JSONObject();
        json.put("PK", toJSON(faction.getPrimaryKey()));
        json.put("systemPK", JSONSystem.toJSON(faction.getSystemPK()));
        json.put("name", faction.getName());
        json.put("description", faction.getDescription());
        json.put("is_unique", faction.getIs_unique());
        json.put("size_factor", faction.getSize_factor());
        json.put("station_count", faction.getStation_count());
        json.put("station_system_count", faction.getStation_system_count());
        json.put("corporation", String.valueOf(faction.getCorporation()));
        json.put("militia_corporation", String.valueOf(faction.getMilitia_corporation()));
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(Factionsearch factionsearch) {
        JSONObject json = new JSONObject();
        if(factionsearch.used()) {
            byte andoroperator = factionsearch.getAndoroperator();
            int maxresults = factionsearch.getMaxresults();
            boolean docount = factionsearch.getDocount();
            Iterator<EntityPK> primarykeysI = factionsearch.getPrimarykeys().iterator();
            Iterator<Fieldsearcher> fieldsearchersI = factionsearch.getFieldsearchers().iterator();
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
            if(factionsearch.getSystemsearch()!=null && factionsearch.getSystemsearch().used()) {
                kss.put("systemsearcher", JSONSystem.toJSON((Systemsearch)factionsearch.getSystemsearch()));
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
    public static Factionsearch toFactionsearch(JSONObject json) {
        Factionsearch factionsearch = new Factionsearch();
        factionsearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        factionsearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        factionsearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONArray pks = (JSONArray)json.get("primarykeys");
        for(int i=0; i<pks.size(); i++) {
            factionsearch.addPrimarykey(FactionPK.getKey((String)pks.get(i)));
        }
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("id");
        if(field!=null) {
            long[] valuearray = JSONConversion.getLongvalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            factionsearch.id(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("name");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            factionsearch.name(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("description");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            factionsearch.description(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("is_unique");
        if(field!=null) {
            boolean value = JSONConversion.getBooleanvalue(field);
            factionsearch.is_unique(value);
        }
        field = (JSONObject)fss.get("size_factor");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            factionsearch.size_factor(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("station_count");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            factionsearch.station_count(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("station_system_count");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            factionsearch.station_system_count(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("corporation");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            factionsearch.corporation(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("militia_corporation");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            factionsearch.militia_corporation(valuearray, operators, andor);
        }
        JSONObject kss = (JSONObject)json.get("keysearch");
        JSONArray keysearch;
        keysearch = (JSONArray)kss.get("systemsearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Systemsearch systemsearch = JSONSystem.toSystemsearch((JSONObject)keysearch.get(i));
                factionsearch.system(systemsearch);
            }
        }
        return factionsearch;
    }
    
    public static FactionPK toFactionPK(JSONObject json) {
        FactionPK factionPK = null;
        if(json!=null) {
            factionPK = new FactionPK(JSONConversion.getlong(json, "id"));
        }
        return factionPK;
    }

    public static Faction toFaction(JSONObject json) {
        Faction faction = new Faction(toFactionPK((JSONObject)json.get("PK")));
        updateFaction(faction, json);
        return faction;
    }

    public static void updateFaction(IFaction faction, JSONObject json) {
        faction.setSystemPK(JSONSystem.toSystemPK((JSONObject)json.get("systemPK")));
        faction.setName(JSONConversion.getString(json, "name"));
        faction.setDescription(JSONConversion.getString(json, "description"));
        faction.setIs_unique(JSONConversion.getboolean(json, "is_unique"));
        faction.setSize_factor(JSONConversion.getdouble(json, "size_factor"));
        faction.setStation_count(JSONConversion.getint(json, "station_count"));
        faction.setStation_system_count(JSONConversion.getint(json, "station_system_count"));
        faction.setCorporation(JSONConversion.getlong(json, "corporation"));
        faction.setMilitia_corporation(JSONConversion.getlong(json, "militia_corporation"));
    }

    public static Faction initFaction(JSONObject json) {
        Faction faction = new Faction(toFactionPK((JSONObject)json.get("PK")));
        faction.initSystemPK(JSONSystem.toSystemPK((JSONObject)json.get("systemPK")));
        faction.initName(JSONConversion.getString(json, "name"));
        faction.initDescription(JSONConversion.getString(json, "description"));
        faction.initIs_unique(JSONConversion.getboolean(json, "is_unique"));
        faction.initSize_factor(JSONConversion.getdouble(json, "size_factor"));
        faction.initStation_count(JSONConversion.getint(json, "station_count"));
        faction.initStation_system_count(JSONConversion.getint(json, "station_system_count"));
        faction.initCorporation(JSONConversion.getlong(json, "corporation"));
        faction.initMilitia_corporation(JSONConversion.getlong(json, "militia_corporation"));
        return faction;
    }
}

