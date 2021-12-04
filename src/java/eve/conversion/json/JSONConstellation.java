/*
 * JSONConstellation.java
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
import eve.entity.pk.ConstellationPK;
import eve.interfaces.entity.pk.IConstellationPK;
import eve.interfaces.logicentity.IConstellation;
import eve.logicentity.Constellation;
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
public class JSONConstellation {
    
    public static JSONArray toJSONArray(ArrayList constellations) {
        JSONArray jsonconstellations = new JSONArray();
        Iterator constellationsI = constellations.iterator();
        while(constellationsI.hasNext()) {
            jsonconstellations.add(toJSON((Constellation)constellationsI.next()));
        }
        return jsonconstellations;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(IConstellationPK constellationPK) {
        JSONObject json = null;
        if(constellationPK!=null) {
            json = new JSONObject();
            json.put("id", String.valueOf(constellationPK.getId()));
        }
        return json;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(IConstellation constellation) {
        JSONObject json = new JSONObject();
        json.put("PK", toJSON(constellation.getPrimaryKey()));
        json.put("regionPK", JSONRegion.toJSON(constellation.getRegionPK()));
        json.put("name", constellation.getName());
        json.put("noaccess", constellation.getNoaccess());
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(Constellationsearch constellationsearch) {
        JSONObject json = new JSONObject();
        if(constellationsearch.used()) {
            byte andoroperator = constellationsearch.getAndoroperator();
            int maxresults = constellationsearch.getMaxresults();
            boolean docount = constellationsearch.getDocount();
            Iterator<EntityPK> primarykeysI = constellationsearch.getPrimarykeys().iterator();
            Iterator<Fieldsearcher> fieldsearchersI = constellationsearch.getFieldsearchers().iterator();
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
            if(constellationsearch.getRegionsearch()!=null && constellationsearch.getRegionsearch().used()) {
                kss.put("regionsearcher", JSONRegion.toJSON((Regionsearch)constellationsearch.getRegionsearch()));
            }
            if(constellationsearch.getConstellation_neighbourneighboursearch()!=null && constellationsearch.getConstellation_neighbourneighboursearch().used()) {
                kss.put("constellation_neighbourNeighboursearcher", JSONConstellation_neighbour.toJSON((Constellation_neighboursearch)constellationsearch.getConstellation_neighbourneighboursearch()));
            }
            if(constellationsearch.getConstellation_neighbourconstellationsearch()!=null && constellationsearch.getConstellation_neighbourconstellationsearch().used()) {
                kss.put("constellation_neighbourConstellationsearcher", JSONConstellation_neighbour.toJSON((Constellation_neighboursearch)constellationsearch.getConstellation_neighbourconstellationsearch()));
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
    public static Constellationsearch toConstellationsearch(JSONObject json) {
        Constellationsearch constellationsearch = new Constellationsearch();
        constellationsearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        constellationsearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        constellationsearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONArray pks = (JSONArray)json.get("primarykeys");
        for(int i=0; i<pks.size(); i++) {
            constellationsearch.addPrimarykey(ConstellationPK.getKey((String)pks.get(i)));
        }
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("id");
        if(field!=null) {
            long[] valuearray = JSONConversion.getLongvalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            constellationsearch.id(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("name");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            constellationsearch.name(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("noaccess");
        if(field!=null) {
            boolean value = JSONConversion.getBooleanvalue(field);
            constellationsearch.noaccess(value);
        }
        JSONObject kss = (JSONObject)json.get("keysearch");
        JSONArray keysearch;
        keysearch = (JSONArray)kss.get("regionsearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Regionsearch regionsearch = JSONRegion.toRegionsearch((JSONObject)keysearch.get(i));
                constellationsearch.region(regionsearch);
            }
        }
        keysearch = (JSONArray)kss.get("constellation_neighbourNeighboursearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Constellation_neighboursearch constellation_neighbourNeighboursearch = JSONConstellation_neighbour.toConstellation_neighboursearch((JSONObject)keysearch.get(i));
                constellationsearch.constellation_neighbourNeighbour(constellation_neighbourNeighboursearch);
            }
        }
        keysearch = (JSONArray)kss.get("constellation_neighbourConstellationsearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Constellation_neighboursearch constellation_neighbourConstellationsearch = JSONConstellation_neighbour.toConstellation_neighboursearch((JSONObject)keysearch.get(i));
                constellationsearch.constellation_neighbourConstellation(constellation_neighbourConstellationsearch);
            }
        }
        return constellationsearch;
    }
    
    public static ConstellationPK toConstellationPK(JSONObject json) {
        ConstellationPK constellationPK = null;
        if(json!=null) {
            constellationPK = new ConstellationPK(JSONConversion.getlong(json, "id"));
        }
        return constellationPK;
    }

    public static Constellation toConstellation(JSONObject json) {
        Constellation constellation = new Constellation(toConstellationPK((JSONObject)json.get("PK")));
        updateConstellation(constellation, json);
        return constellation;
    }

    public static void updateConstellation(IConstellation constellation, JSONObject json) {
        constellation.setRegionPK(JSONRegion.toRegionPK((JSONObject)json.get("regionPK")));
        constellation.setName(JSONConversion.getString(json, "name"));
        constellation.setNoaccess(JSONConversion.getboolean(json, "noaccess"));
    }

    public static Constellation initConstellation(JSONObject json) {
        Constellation constellation = new Constellation(toConstellationPK((JSONObject)json.get("PK")));
        constellation.initRegionPK(JSONRegion.toRegionPK((JSONObject)json.get("regionPK")));
        constellation.initName(JSONConversion.getString(json, "name"));
        constellation.initNoaccess(JSONConversion.getboolean(json, "noaccess"));
        return constellation;
    }
}

