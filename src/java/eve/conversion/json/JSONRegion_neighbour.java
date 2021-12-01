/*
 * JSONRegion_neighbour.java
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
import eve.entity.pk.Region_neighbourPK;
import eve.interfaces.entity.pk.IRegion_neighbourPK;
import eve.interfaces.logicentity.IRegion_neighbour;
import eve.logicentity.Region_neighbour;
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
public class JSONRegion_neighbour {
    
    public static JSONArray toJSONArray(ArrayList region_neighbours) {
        JSONArray jsonregion_neighbours = new JSONArray();
        Iterator region_neighboursI = region_neighbours.iterator();
        while(region_neighboursI.hasNext()) {
            jsonregion_neighbours.add(toJSON((Region_neighbour)region_neighboursI.next()));
        }
        return jsonregion_neighbours;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(IRegion_neighbourPK region_neighbourPK) {
        JSONObject json = null;
        if(region_neighbourPK!=null) {
            json = new JSONObject();
            json.put("region", String.valueOf(region_neighbourPK.getRegion()));
            json.put("neighbour", String.valueOf(region_neighbourPK.getNeighbour()));
        }
        return json;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(IRegion_neighbour region_neighbour) {
        JSONObject json = new JSONObject();
        json.put("PK", toJSON(region_neighbour.getPrimaryKey()));
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(Region_neighboursearch region_neighboursearch) {
        JSONObject json = new JSONObject();
        if(region_neighboursearch.used()) {
            byte andoroperator = region_neighboursearch.getAndoroperator();
            int maxresults = region_neighboursearch.getMaxresults();
            boolean docount = region_neighboursearch.getDocount();
            Iterator<EntityPK> primarykeysI = region_neighboursearch.getPrimarykeys().iterator();
            Iterator<Fieldsearcher> fieldsearchersI = region_neighboursearch.getFieldsearchers().iterator();
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
            if(region_neighboursearch.getRegionregionsearch()!=null && region_neighboursearch.getRegionregionsearch().used()) {
                kss.put("regionRegionsearcher", JSONRegion.toJSON((Regionsearch)region_neighboursearch.getRegionregionsearch()));
            }
            if(region_neighboursearch.getRegionneighboursearch()!=null && region_neighboursearch.getRegionneighboursearch().used()) {
                kss.put("regionNeighboursearcher", JSONRegion.toJSON((Regionsearch)region_neighboursearch.getRegionneighboursearch()));
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
    public static Region_neighboursearch toRegion_neighboursearch(JSONObject json) {
        Region_neighboursearch region_neighboursearch = new Region_neighboursearch();
        region_neighboursearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        region_neighboursearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        region_neighboursearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONArray pks = (JSONArray)json.get("primarykeys");
        for(int i=0; i<pks.size(); i++) {
            region_neighboursearch.addPrimarykey(Region_neighbourPK.getKey((String)pks.get(i)));
        }
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        JSONObject kss = (JSONObject)json.get("keysearch");
        JSONArray keysearch;
        keysearch = (JSONArray)kss.get("regionRegionsearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Regionsearch regionRegionsearch = JSONRegion.toRegionsearch((JSONObject)keysearch.get(i));
                region_neighboursearch.regionRegion(regionRegionsearch);
            }
        }
        keysearch = (JSONArray)kss.get("regionNeighboursearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Regionsearch regionNeighboursearch = JSONRegion.toRegionsearch((JSONObject)keysearch.get(i));
                region_neighboursearch.regionNeighbour(regionNeighboursearch);
            }
        }
        return region_neighboursearch;
    }
    
    public static Region_neighbourPK toRegion_neighbourPK(JSONObject json) {
        Region_neighbourPK region_neighbourPK = null;
        if(json!=null) {
            region_neighbourPK = new Region_neighbourPK(JSONConversion.getlong(json, "region"), JSONConversion.getlong(json, "neighbour"));
        }
        return region_neighbourPK;
    }

    public static Region_neighbour toRegion_neighbour(JSONObject json) {
        Region_neighbour region_neighbour = new Region_neighbour(toRegion_neighbourPK((JSONObject)json.get("PK")));
        updateRegion_neighbour(region_neighbour, json);
        return region_neighbour;
    }

    public static void updateRegion_neighbour(IRegion_neighbour region_neighbour, JSONObject json) {
    }

    public static Region_neighbour initRegion_neighbour(JSONObject json) {
        Region_neighbour region_neighbour = new Region_neighbour(toRegion_neighbourPK((JSONObject)json.get("PK")));
        return region_neighbour;
    }
}

