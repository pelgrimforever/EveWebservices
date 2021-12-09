/*
 * JSONConstellation_neighbour.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 9.11.2021 14:30
 *
 */
 
package eve.conversion.json;

import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.interfaces.db.EntityPK;
import data.interfaces.db.Fieldsearcher;
import data.json.piJson;
import eve.entity.pk.Constellation_neighbourPK;
import eve.interfaces.entity.pk.IConstellation_neighbourPK;
import eve.interfaces.logicentity.IConstellation_neighbour;
import eve.logicentity.Constellation_neighbour;
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
public class JSONConstellation_neighbour {
    
    public static JSONArray toJSONArray(ArrayList constellation_neighbours) {
        JSONArray jsonconstellation_neighbours = new JSONArray();
        Iterator constellation_neighboursI = constellation_neighbours.iterator();
        while(constellation_neighboursI.hasNext()) {
            jsonconstellation_neighbours.add(toJSON((Constellation_neighbour)constellation_neighboursI.next()));
        }
        return jsonconstellation_neighbours;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(IConstellation_neighbourPK constellation_neighbourPK) {
        JSONObject json = null;
        if(constellation_neighbourPK!=null) {
            json = new JSONObject();
            json.put("constellation", String.valueOf(constellation_neighbourPK.getConstellation()));
            json.put("neighbour", String.valueOf(constellation_neighbourPK.getNeighbour()));
        }
        return json;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(IConstellation_neighbour constellation_neighbour) {
        JSONObject json = new JSONObject();
        json.put("PK", toJSON(constellation_neighbour.getPrimaryKey()));
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(Constellation_neighboursearch constellation_neighboursearch) {
        JSONObject json = new JSONObject();
        if(constellation_neighboursearch.used()) {
            byte andoroperator = constellation_neighboursearch.getAndoroperator();
            int maxresults = constellation_neighboursearch.getMaxresults();
            boolean docount = constellation_neighboursearch.getDocount();
            Iterator<EntityPK> primarykeysI = constellation_neighboursearch.getPrimarykeys().iterator();
            Iterator<Fieldsearcher> fieldsearchersI = constellation_neighboursearch.getFieldsearchers().iterator();
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
            if(constellation_neighboursearch.getConstellationneighboursearch()!=null && constellation_neighboursearch.getConstellationneighboursearch().used()) {
                kss.put("constellationNeighboursearcher", JSONConstellation.toJSON((Constellationsearch)constellation_neighboursearch.getConstellationneighboursearch()));
            }
            if(constellation_neighboursearch.getConstellationconstellationsearch()!=null && constellation_neighboursearch.getConstellationconstellationsearch().used()) {
                kss.put("constellationConstellationsearcher", JSONConstellation.toJSON((Constellationsearch)constellation_neighboursearch.getConstellationconstellationsearch()));
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
    public static Constellation_neighboursearch toConstellation_neighboursearch(JSONObject json) {
        Constellation_neighboursearch constellation_neighboursearch = new Constellation_neighboursearch();
        constellation_neighboursearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        constellation_neighboursearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        constellation_neighboursearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONArray pks = (JSONArray)json.get("primarykeys");
        for(int i=0; i<pks.size(); i++) {
            constellation_neighboursearch.addPrimarykey(Constellation_neighbourPK.getKey((String)pks.get(i)));
        }
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        JSONObject kss = (JSONObject)json.get("keysearch");
        JSONArray keysearch;
        keysearch = (JSONArray)kss.get("constellationNeighboursearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Constellationsearch constellationNeighboursearch = JSONConstellation.toConstellationsearch((JSONObject)keysearch.get(i));
                constellation_neighboursearch.constellationNeighbour(constellationNeighboursearch);
            }
        }
        keysearch = (JSONArray)kss.get("constellationConstellationsearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Constellationsearch constellationConstellationsearch = JSONConstellation.toConstellationsearch((JSONObject)keysearch.get(i));
                constellation_neighboursearch.constellationConstellation(constellationConstellationsearch);
            }
        }
        return constellation_neighboursearch;
    }
    
    public static Constellation_neighbourPK toConstellation_neighbourPK(JSONObject json) {
        Constellation_neighbourPK constellation_neighbourPK = null;
        if(json!=null) {
            constellation_neighbourPK = new Constellation_neighbourPK(JSONConversion.getlong(json, "constellation"), JSONConversion.getlong(json, "neighbour"));
        }
        return constellation_neighbourPK;
    }

    public static Constellation_neighbour toConstellation_neighbour(JSONObject json) {
        Constellation_neighbour constellation_neighbour = new Constellation_neighbour(toConstellation_neighbourPK((JSONObject)json.get("PK")));
        updateConstellation_neighbour(constellation_neighbour, json);
        return constellation_neighbour;
    }

    public static void updateConstellation_neighbour(IConstellation_neighbour constellation_neighbour, JSONObject json) {
    }

    public static Constellation_neighbour initConstellation_neighbour(JSONObject json) {
        Constellation_neighbour constellation_neighbour = new Constellation_neighbour(toConstellation_neighbourPK((JSONObject)json.get("PK")));
        return constellation_neighbour;
    }
}

