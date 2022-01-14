/*
 * JSONStation_service.java
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
import eve.entity.pk.Station_servicePK;
import eve.interfaces.entity.pk.IStation_servicePK;
import eve.interfaces.logicentity.IStation_service;
import eve.logicentity.Station_service;
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
public class JSONStation_service {
    
    public static JSONArray toJSONArray(ArrayList station_services) {
        JSONArray jsonstation_services = new JSONArray();
        Iterator station_servicesI = station_services.iterator();
        while(station_servicesI.hasNext()) {
            jsonstation_services.add(toJSON((Station_service)station_servicesI.next()));
        }
        return jsonstation_services;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(IStation_servicePK station_servicePK) {
        JSONObject json = null;
        if(station_servicePK!=null) {
            json = new JSONObject();
            json.put("station", String.valueOf(station_servicePK.getStation()));
            json.put("service", station_servicePK.getService());
        }
        return json;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(IStation_service station_service) {
        JSONObject json = new JSONObject();
        json.put("PK", toJSON(station_service.getPrimaryKey()));
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(Station_servicesearch station_servicesearch) {
        JSONObject json = new JSONObject();
        if(station_servicesearch.used()) {
            byte andoroperator = station_servicesearch.getAndoroperator();
            int maxresults = station_servicesearch.getMaxresults();
            boolean docount = station_servicesearch.getDocount();
            Iterator<EntityPK> primarykeysI = station_servicesearch.getPrimarykeys().iterator();
            Iterator<Fieldsearcher> fieldsearchersI = station_servicesearch.getFieldsearchers().iterator();
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
            if(station_servicesearch.getStationsearch()!=null && station_servicesearch.getStationsearch().used()) {
                kss.put("stationsearcher", JSONStation.toJSON((Stationsearch)station_servicesearch.getStationsearch()));
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
    public static Station_servicesearch toStation_servicesearch(JSONObject json) {
        Station_servicesearch station_servicesearch = new Station_servicesearch();
        station_servicesearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        station_servicesearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        station_servicesearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONArray pks = (JSONArray)json.get("primarykeys");
        for(int i=0; i<pks.size(); i++) {
            station_servicesearch.addPrimarykey(Station_servicePK.getKey((String)pks.get(i)));
        }
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("service");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            station_servicesearch.service(valuearray, compareoperator, andor);
        }
        JSONObject kss = (JSONObject)json.get("keysearch");
        JSONArray keysearch;
        keysearch = (JSONArray)kss.get("stationsearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Stationsearch stationsearch = JSONStation.toStationsearch((JSONObject)keysearch.get(i));
                station_servicesearch.station(stationsearch);
            }
        }
        return station_servicesearch;
    }
    
    public static Station_servicePK toStation_servicePK(JSONObject json) {
        Station_servicePK station_servicePK = null;
        if(json!=null) {
            station_servicePK = new Station_servicePK(JSONConversion.getlong(json, "station"), JSONConversion.getString(json, "service"));
        }
        return station_servicePK;
    }

    public static Station_service toStation_service(JSONObject json) {
        Station_service station_service = new Station_service(toStation_servicePK((JSONObject)json.get("PK")));
        updateStation_service(station_service, json);
        return station_service;
    }

    public static void updateStation_service(IStation_service station_service, JSONObject json) {
    }

    public static Station_service initStation_service(JSONObject json) {
        Station_service station_service = new Station_service(toStation_servicePK((JSONObject)json.get("PK")));
        return station_service;
    }
}

