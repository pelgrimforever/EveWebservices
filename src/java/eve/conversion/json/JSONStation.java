/*
 * JSONStation.java
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
import eve.entity.pk.StationPK;
import eve.interfaces.entity.pk.IStationPK;
import eve.interfaces.logicentity.IStation;
import eve.logicentity.Station;
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
public class JSONStation {
    
    public static JSONArray toJSONArray(ArrayList stations) {
        JSONArray jsonstations = new JSONArray();
        Iterator stationsI = stations.iterator();
        while(stationsI.hasNext()) {
            jsonstations.add(toJSON((Station)stationsI.next()));
        }
        return jsonstations;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(IStationPK stationPK) {
        JSONObject json = null;
        if(stationPK!=null) {
            json = new JSONObject();
            json.put("id", String.valueOf(stationPK.getId()));
        }
        return json;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(IStation station) {
        JSONObject json = new JSONObject();
        json.put("PK", toJSON(station.getPrimaryKey()));
        json.put("racePK", JSONRace.toJSON(station.getRacePK()));
        json.put("evetypePK", JSONEvetype.toJSON(station.getEvetypePK()));
        json.put("systemPK", JSONSystem.toJSON(station.getSystemPK()));
        json.put("name", station.getName());
        json.put("office_rental_cost", station.getOffice_rental_cost());
        json.put("reprocessing_efficiency", station.getReprocessing_efficiency());
        json.put("reprocessing_stations_take", station.getReprocessing_stations_take());
        json.put("max_dockable_ship_volume", station.getMax_dockable_ship_volume());
        json.put("owner", String.valueOf(station.getOwner()));
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(Stationsearch stationsearch) {
        JSONObject json = new JSONObject();
        if(stationsearch.used()) {
            byte andoroperator = stationsearch.getAndoroperator();
            int maxresults = stationsearch.getMaxresults();
            boolean docount = stationsearch.getDocount();
            Iterator<EntityPK> primarykeysI = stationsearch.getPrimarykeys().iterator();
            Iterator<Fieldsearcher> fieldsearchersI = stationsearch.getFieldsearchers().iterator();
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
            if(stationsearch.getRacesearch()!=null && stationsearch.getRacesearch().used()) {
                kss.put("racesearcher", JSONRace.toJSON((Racesearch)stationsearch.getRacesearch()));
            }
            if(stationsearch.getEvetypesearch()!=null && stationsearch.getEvetypesearch().used()) {
                kss.put("evetypesearcher", JSONEvetype.toJSON((Evetypesearch)stationsearch.getEvetypesearch()));
            }
            if(stationsearch.getSystemsearch()!=null && stationsearch.getSystemsearch().used()) {
                kss.put("systemsearcher", JSONSystem.toJSON((Systemsearch)stationsearch.getSystemsearch()));
            }
            if(stationsearch.getStation_servicesearch()!=null && stationsearch.getStation_servicesearch().used()) {
                kss.put("station_servicesearcher", JSONStation_service.toJSON((Station_servicesearch)stationsearch.getStation_servicesearch()));
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
    public static Stationsearch toStationsearch(JSONObject json) {
        Stationsearch stationsearch = new Stationsearch();
        stationsearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        stationsearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        stationsearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONArray pks = (JSONArray)json.get("primarykeys");
        for(int i=0; i<pks.size(); i++) {
            stationsearch.addPrimarykey(StationPK.getKey((String)pks.get(i)));
        }
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("id");
        if(field!=null) {
            long[] valuearray = JSONConversion.getLongvalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            stationsearch.id(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("name");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            stationsearch.name(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("office_rental_cost");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            stationsearch.office_rental_cost(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("reprocessing_efficiency");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            stationsearch.reprocessing_efficiency(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("reprocessing_stations_take");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            stationsearch.reprocessing_stations_take(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("max_dockable_ship_volume");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            stationsearch.max_dockable_ship_volume(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("owner");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            stationsearch.owner(valuearray, operators, andor);
        }
        JSONObject kss = (JSONObject)json.get("keysearch");
        JSONArray keysearch;
        keysearch = (JSONArray)kss.get("racesearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Racesearch racesearch = JSONRace.toRacesearch((JSONObject)keysearch.get(i));
                stationsearch.race(racesearch);
            }
        }
        keysearch = (JSONArray)kss.get("evetypesearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Evetypesearch evetypesearch = JSONEvetype.toEvetypesearch((JSONObject)keysearch.get(i));
                stationsearch.evetype(evetypesearch);
            }
        }
        keysearch = (JSONArray)kss.get("systemsearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Systemsearch systemsearch = JSONSystem.toSystemsearch((JSONObject)keysearch.get(i));
                stationsearch.system(systemsearch);
            }
        }
        keysearch = (JSONArray)kss.get("station_servicesearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Station_servicesearch station_servicesearch = JSONStation_service.toStation_servicesearch((JSONObject)keysearch.get(i));
                stationsearch.station_service(station_servicesearch);
            }
        }
        return stationsearch;
    }
    
    public static StationPK toStationPK(JSONObject json) {
        StationPK stationPK = null;
        if(json!=null) {
            stationPK = new StationPK(JSONConversion.getlong(json, "id"));
        }
        return stationPK;
    }

    public static Station toStation(JSONObject json) {
        Station station = new Station(toStationPK((JSONObject)json.get("PK")));
        updateStation(station, json);
        return station;
    }

    public static void updateStation(IStation station, JSONObject json) {
        station.setRacePK(JSONRace.toRacePK((JSONObject)json.get("racePK")));
        station.setEvetypePK(JSONEvetype.toEvetypePK((JSONObject)json.get("evetypePK")));
        station.setSystemPK(JSONSystem.toSystemPK((JSONObject)json.get("systemPK")));
        station.setName(JSONConversion.getString(json, "name"));
        station.setOffice_rental_cost(JSONConversion.getdouble(json, "office_rental_cost"));
        station.setReprocessing_efficiency(JSONConversion.getdouble(json, "reprocessing_efficiency"));
        station.setReprocessing_stations_take(JSONConversion.getdouble(json, "reprocessing_stations_take"));
        station.setMax_dockable_ship_volume(JSONConversion.getdouble(json, "max_dockable_ship_volume"));
        station.setOwner(JSONConversion.getlong(json, "owner"));
    }

    public static Station initStation(JSONObject json) {
        Station station = new Station(toStationPK((JSONObject)json.get("PK")));
        station.initRacePK(JSONRace.toRacePK((JSONObject)json.get("racePK")));
        station.initEvetypePK(JSONEvetype.toEvetypePK((JSONObject)json.get("evetypePK")));
        station.initSystemPK(JSONSystem.toSystemPK((JSONObject)json.get("systemPK")));
        station.initName(JSONConversion.getString(json, "name"));
        station.initOffice_rental_cost(JSONConversion.getdouble(json, "office_rental_cost"));
        station.initReprocessing_efficiency(JSONConversion.getdouble(json, "reprocessing_efficiency"));
        station.initReprocessing_stations_take(JSONConversion.getdouble(json, "reprocessing_stations_take"));
        station.initMax_dockable_ship_volume(JSONConversion.getdouble(json, "max_dockable_ship_volume"));
        station.initOwner(JSONConversion.getlong(json, "owner"));
        return station;
    }
}

