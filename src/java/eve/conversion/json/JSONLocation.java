/*
 * JSONLocation.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 25.9.2021 15:16
 *
 */
 
package eve.conversion.json;

import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.interfaces.db.EntityPK;
import data.interfaces.db.Fieldsearcher;
import data.json.piJson;
import eve.entity.pk.LocationPK;
import eve.interfaces.entity.pk.ILocationPK;
import eve.interfaces.logicentity.ILocation;
import eve.logicentity.Location;
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
public class JSONLocation {
    
    public static JSONArray toJSONArray(ArrayList locations) {
        JSONArray jsonlocations = new JSONArray();
        Iterator locationsI = locations.iterator();
        while(locationsI.hasNext()) {
            jsonlocations.add(toJSON((Location)locationsI.next()));
        }
        return jsonlocations;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(ILocationPK locationPK) {
        JSONObject json = null;
        if(locationPK!=null) {
            json = new JSONObject();
            json.put("id", String.valueOf(locationPK.getId()));
        }
        return json;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(ILocation location) {
        JSONObject json = new JSONObject();
        json.put("PK", toJSON(location.getPrimaryKey()));
        json.put("systemPK", JSONSystem.toJSON(location.getSystemPK()));
        json.put("name", location.getName());
        json.put("visited", location.getVisited());
        json.put("access", location.getAccess());
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(Locationsearch locationsearch) {
        JSONObject json = new JSONObject();
        if(locationsearch.used()) {
            byte andoroperator = locationsearch.getAndoroperator();
            int maxresults = locationsearch.getMaxresults();
            boolean docount = locationsearch.getDocount();
            Iterator<EntityPK> primarykeysI = locationsearch.getPrimarykeys().iterator();
            Iterator<Fieldsearcher> fieldsearchersI = locationsearch.getFieldsearchers().iterator();
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
            if(locationsearch.getSystemsearch()!=null && locationsearch.getSystemsearch().used()) {
                kss.put("systemsearcher", JSONSystem.toJSON((Systemsearch)locationsearch.getSystemsearch()));
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
    public static Locationsearch toLocationsearch(JSONObject json) {
        Locationsearch locationsearch = new Locationsearch();
        locationsearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        locationsearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        locationsearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONArray pks = (JSONArray)json.get("primarykeys");
        for(int i=0; i<pks.size(); i++) {
            locationsearch.addPrimarykey(LocationPK.getKey((String)pks.get(i)));
        }
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("id");
        if(field!=null) {
            long[] valuearray = JSONConversion.getLongvalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            locationsearch.id(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("name");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            locationsearch.name(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("visited");
        if(field!=null) {
            boolean value = JSONConversion.getBooleanvalue(field);
            locationsearch.visited(value);
        }
        field = (JSONObject)fss.get("access");
        if(field!=null) {
            boolean value = JSONConversion.getBooleanvalue(field);
            locationsearch.access(value);
        }
        JSONObject kss = (JSONObject)json.get("keysearch");
        JSONArray keysearch;
        keysearch = (JSONArray)kss.get("systemsearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Systemsearch systemsearch = JSONSystem.toSystemsearch((JSONObject)keysearch.get(i));
                locationsearch.system(systemsearch);
            }
        }
        return locationsearch;
    }
    
    public static LocationPK toLocationPK(JSONObject json) {
        LocationPK locationPK = null;
        if(json!=null) {
            locationPK = new LocationPK(JSONConversion.getlong(json, "id"));
        }
        return locationPK;
    }

    public static Location toLocation(JSONObject json) {
        Location location = new Location(toLocationPK((JSONObject)json.get("PK")));
        updateLocation(location, json);
        return location;
    }

    public static void updateLocation(ILocation location, JSONObject json) {
        location.setSystemPK(JSONSystem.toSystemPK((JSONObject)json.get("systemPK")));
        location.setName(JSONConversion.getString(json, "name"));
        location.setVisited(JSONConversion.getboolean(json, "visited"));
        location.setAccess(JSONConversion.getboolean(json, "access"));
    }

    public static Location initLocation(JSONObject json) {
        Location location = new Location(toLocationPK((JSONObject)json.get("PK")));
        location.initSystemPK(JSONSystem.toSystemPK((JSONObject)json.get("systemPK")));
        location.initName(JSONConversion.getString(json, "name"));
        location.initVisited(JSONConversion.getboolean(json, "visited"));
        location.initAccess(JSONConversion.getboolean(json, "access"));
        return location;
    }
}

