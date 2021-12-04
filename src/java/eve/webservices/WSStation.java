/*
 * WSStation.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 4.11.2021 14:51
 *
 */

package eve.webservices;

import eve.BusinessObject.Logic.*;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.webservice.WSIStation;
import eve.logicentity.Station;
import eve.searchentity.Stationsearch;
import general.exception.CustomException;
import general.exception.DataException;
import general.exception.DBException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.jws.WebMethod;
import javax.jws.WebService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Franky Laseure
 */
@WebService(endpointInterface = "eve.interfaces.webservice.WSIStation")
public class WSStation implements WSIStation {

    private JSONArray toJSONArray(ArrayList stations) {
        JSONArray jsonstations = new JSONArray();
        Iterator stationsI = stations.iterator();
        while(stationsI.hasNext()) {
            jsonstations.add(JSONStation.toJSON((Station)stationsI.next()));
        }
        return jsonstations;
    }

    /**
     * Web service operation
     */
    //@WebMethod(operationName = "getStations")
    @Override
    public String getStations() {
        try {
            BLstation blstation = new BLstation();
            ArrayList stations = blstation.getAll();
            JSONArray jsonstations = toJSONArray(stations);
            return jsonstations.toJSONString();
        }
        catch(DBException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "search")
    @Override
    public String search(String json) {
        BLstation blstation = new BLstation();
        JSONParser parser = new JSONParser();
        String result = "";
        Station station;
        try {
            Stationsearch stationsearch = JSONStation.toStationsearch((JSONObject)parser.parse(json));
            ArrayList stations = blstation.search(stationsearch);
            JSONArray jsonstations = toJSONArray(stations);
            result = jsonstations.toJSONString();
        }
        catch(ParseException e) {
            result = "";
        }
        catch(DBException e) {
            result = "";
        }
        return result;
    }

    //@WebMethod(operationName = "getStation")
    @Override
    public String getStation(String json) {
        BLstation blstation = new BLstation();
        JSONParser parser = new JSONParser();
        String result = "";
        Station station;
        try {
            StationPK stationPK = JSONStation.toStationPK((JSONObject)parser.parse(json));
            station = blstation.getStation(stationPK);
            if(station!=null) {
                result = JSONStation.toJSON(station).toJSONString();
            }
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
        return result;
    }

    //@WebMethod(operationName = "insertStation")
    @Override
    public void insertStation(String json) {
        BLstation blstation = new BLstation();
        JSONParser parser = new JSONParser();
        try {
            IStation station = JSONStation.toStation((JSONObject)parser.parse(json));
            blstation.insertStation(station);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "updateStation")
    @Override
    public void updateStation(String json) {
        BLstation blstation = new BLstation();
        JSONParser parser = new JSONParser();
        try {
            IStation station = JSONStation.toStation((JSONObject)parser.parse(json));
            blstation.updateStation(station);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "deleteStation")
    @Override
    public void deleteStation(String json) {
        BLstation blstation = new BLstation();
        JSONParser parser = new JSONParser();
        try {
            IStation station = JSONStation.toStation((JSONObject)parser.parse(json));
            blstation.deleteStation(station);
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "getStations4race")
    @Override
    public String getStations4race(String json) {
        BLstation blstation = new BLstation();
        JSONParser parser = new JSONParser();
        Station station;
        try {
            IRacePK racePK = JSONRace.toRacePK((JSONObject)parser.parse(json));
            ArrayList stations = blstation.getStations4race(racePK);
            JSONArray jsonstations = toJSONArray(stations);
            return jsonstations.toJSONString();
        }
        catch(ParseException e) {
            return null;
        }
        catch(DBException e) {
            return null;
        }
        catch(CustomException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "delete4race")
    @Override
    public void delete4race(String json) {
        BLstation blstation = new BLstation();
        JSONParser parser = new JSONParser();
        Station station;
        try {
            IRacePK racePK = JSONRace.toRacePK((JSONObject)parser.parse(json));
            blstation.delete4race(racePK);
        }
        catch(ParseException e) {
        }
    }

    //@WebMethod(operationName = "getStations4evetype")
    @Override
    public String getStations4evetype(String json) {
        BLstation blstation = new BLstation();
        JSONParser parser = new JSONParser();
        Station station;
        try {
            IEvetypePK evetypePK = JSONEvetype.toEvetypePK((JSONObject)parser.parse(json));
            ArrayList stations = blstation.getStations4evetype(evetypePK);
            JSONArray jsonstations = toJSONArray(stations);
            return jsonstations.toJSONString();
        }
        catch(ParseException e) {
            return null;
        }
        catch(DBException e) {
            return null;
        }
        catch(CustomException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "delete4evetype")
    @Override
    public void delete4evetype(String json) {
        BLstation blstation = new BLstation();
        JSONParser parser = new JSONParser();
        Station station;
        try {
            IEvetypePK evetypePK = JSONEvetype.toEvetypePK((JSONObject)parser.parse(json));
            blstation.delete4evetype(evetypePK);
        }
        catch(ParseException e) {
        }
    }

    //@WebMethod(operationName = "getStations4system")
    @Override
    public String getStations4system(String json) {
        BLstation blstation = new BLstation();
        JSONParser parser = new JSONParser();
        Station station;
        try {
            ISystemPK systemPK = JSONSystem.toSystemPK((JSONObject)parser.parse(json));
            ArrayList stations = blstation.getStations4system(systemPK);
            JSONArray jsonstations = toJSONArray(stations);
            return jsonstations.toJSONString();
        }
        catch(ParseException e) {
            return null;
        }
        catch(DBException e) {
            return null;
        }
        catch(CustomException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "delete4system")
    @Override
    public void delete4system(String json) {
        BLstation blstation = new BLstation();
        JSONParser parser = new JSONParser();
        Station station;
        try {
            ISystemPK systemPK = JSONSystem.toSystemPK((JSONObject)parser.parse(json));
            blstation.delete4system(systemPK);
        }
        catch(ParseException e) {
        }
    }

    //@WebMethod(operationName = "getStations4station_service")
    @Override
    public String getStations4station_service(String json) {
        BLstation blstation = new BLstation();
        JSONParser parser = new JSONParser();
        Station station;
        try {
            String result = null;
            IStation_servicePK station_servicePK = JSONStation_service.toStation_servicePK((JSONObject)parser.parse(json));
            station = (Station)blstation.getStation_service(station_servicePK);
            if(station!=null) {
                result = JSONStation.toJSON(station).toJSONString();
            }
            return result;
        }
        catch(ParseException e) {
            return null;
        }
        catch(DBException e) {
            return null;
        }
        catch(CustomException e) {
            return null;
        }
    }


}

