/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 23.8.2022 14:38
 * @author Franky Laseure
 */

package eve.webservices;

import base.restservices.RS_json_login;
import eve.BusinessObject.Logic.*;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.searchentity.IStationsearch;
import eve.interfaces.webservice.WSIStation;
import eve.logicentity.Station;
import eve.searchentity.Stationsearch;
import eve.usecases.*;
import general.exception.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.jws.WebMethod;
import javax.jws.WebService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import eve.usecases.custom.Security_usecases;

@WebService(endpointInterface = "eve.interfaces.webservice.WSIStation")
public class WSStation extends RS_json_login implements WSIStation {

    private Security_usecases security_usecases = new Security_usecases();
    
    private JSONArray toJSONArray(ArrayList stations) {
        JSONArray jsonstations = new JSONArray();
        Iterator stationsI = stations.iterator();
        while(stationsI.hasNext()) {
            jsonstations.add(JSONStation.toJSON((Station)stationsI.next()));
        }
        return jsonstations;
    }

    //@WebMethod(operationName = "getStations")
    @Override
    public String getStations() {
        try {
            Station_usecases stationusecases = new Station_usecases(loggedin);
            return get_all_station(stationusecases);
        }
        catch(CustomException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "search")
    @Override
    public String search(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Station_usecases stationusecases = new Station_usecases(loggedin);
            return search_station(stationusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "getStation")
    @Override
    public String getStation(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Station_usecases stationusecases = new Station_usecases(loggedin);
            return get_station_with_primarykey(stationusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "insertStation")
    @Override
    public void insertStation(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Station_usecases stationusecases = new Station_usecases(loggedin);
            insert_station(stationusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "updateStation")
    @Override
    public void updateStation(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Station_usecases stationusecases = new Station_usecases(loggedin);
            update_station(stationusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "deleteStation")
    @Override
    public void deleteStation(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Station_usecases stationusecases = new Station_usecases(loggedin);
            delete_station(stationusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getStations4race")
    @Override
    public String getStations4race(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Station_usecases stationusecases = new Station_usecases(loggedin);
            return get_station_with_foreignkey_race(stationusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "delete4race")
    @Override
    public void delete4race(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Station_usecases stationusecases = new Station_usecases(loggedin);
            delete_station(stationusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getStations4evetype")
    @Override
    public String getStations4evetype(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Station_usecases stationusecases = new Station_usecases(loggedin);
            return get_station_with_foreignkey_evetype(stationusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "delete4evetype")
    @Override
    public void delete4evetype(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Station_usecases stationusecases = new Station_usecases(loggedin);
            delete_station(stationusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getStations4system")
    @Override
    public String getStations4system(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Station_usecases stationusecases = new Station_usecases(loggedin);
            return get_station_with_foreignkey_system(stationusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "delete4system")
    @Override
    public void delete4system(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Station_usecases stationusecases = new Station_usecases(loggedin);
            delete_station(stationusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getStations4station_service")
    @Override
    public String getStations4station_service(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Station_usecases stationusecases = new Station_usecases(loggedin);
            return get_station_with_externalforeignkey_station_service(stationusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }


    private String count_records(Station_usecases stationusecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", stationusecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_station(Station_usecases stationusecases) throws ParseException, CustomException {
    	return JSONStation.toJSONArray(stationusecases.get_all()).toJSONString();
    }
    
    private String get_station_with_primarykey(Station_usecases stationusecases, JSONObject json) throws ParseException, CustomException {
        IStationPK stationPK = (IStationPK)JSONStation.toStationPK((JSONObject)json.get("stationpk"));
	return JSONStation.toJSON(stationusecases.get_station_by_primarykey(stationPK)).toJSONString();
    }
    
    private String get_station_with_foreignkey_race(Station_usecases stationusecases, JSONObject json) throws ParseException, CustomException {
        IRacePK racePK = (IRacePK)JSONRace.toRacePK((JSONObject)json.get("racepk"));
        return JSONStation.toJSONArray(stationusecases.get_station_with_foreignkey_race(racePK)).toJSONString();
    }
    
    private String get_station_with_foreignkey_evetype(Station_usecases stationusecases, JSONObject json) throws ParseException, CustomException {
        IEvetypePK evetypePK = (IEvetypePK)JSONEvetype.toEvetypePK((JSONObject)json.get("evetypepk"));
        return JSONStation.toJSONArray(stationusecases.get_station_with_foreignkey_evetype(evetypePK)).toJSONString();
    }
    
    private String get_station_with_foreignkey_system(Station_usecases stationusecases, JSONObject json) throws ParseException, CustomException {
        ISystemPK systemPK = (ISystemPK)JSONSystem.toSystemPK((JSONObject)json.get("systempk"));
        return JSONStation.toJSONArray(stationusecases.get_station_with_foreignkey_system(systemPK)).toJSONString();
    }
    
    private String get_station_with_externalforeignkey_station_service(Station_usecases stationusecases, JSONObject json) throws ParseException, CustomException {
        IStation_servicePK station_servicePK = (IStation_servicePK)JSONStation_service.toStation_servicePK((JSONObject)json.get("station_servicepk"));
        return JSONStation.toJSON(stationusecases.get_station_with_externalforeignkey_station_service(station_servicePK)).toJSONString();
    }
    
    private String search_station(Station_usecases stationusecases, JSONObject json) throws ParseException, CustomException {
        IStationsearch search = (IStationsearch)JSONStation.toStationsearch((JSONObject)json.get("search"));
        return JSONStation.toJSONArray(stationusecases.search_station(search)).toJSONString();
    }
    
    private String search_station_count(Station_usecases stationusecases, JSONObject json) throws ParseException, CustomException {
        IStationsearch stationsearch = (IStationsearch)JSONStation.toStationsearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", stationusecases.search_station_count(stationsearch));
        return jsonsearchcount.toJSONString();
    }

    private void insert_station(Station_usecases stationusecases, JSONObject json) throws ParseException, CustomException {
        IStation station = (IStation)JSONStation.toStation((JSONObject)json.get("station"));
        stationusecases.insertStation(station);
        setReturnstatus("OK");
    }

    private void update_station(Station_usecases stationusecases, JSONObject json) throws ParseException, CustomException {
        IStation station = (IStation)JSONStation.toStation((JSONObject)json.get("station"));
        stationusecases.updateStation(station);
        setReturnstatus("OK");
    }

    private void delete_station(Station_usecases stationusecases, JSONObject json) throws ParseException, CustomException {
        IStation station = (IStation)JSONStation.toStation((JSONObject)json.get("station"));
        stationusecases.deleteStation(station);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Race(Station_usecases stationusecases, JSONObject json) throws ParseException, CustomException {
        IRacePK racePK = (IRacePK)JSONRace.toRacePK((JSONObject)json.get("racepk"));
        stationusecases.delete_all_containing_Race(racePK);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Evetype(Station_usecases stationusecases, JSONObject json) throws ParseException, CustomException {
        IEvetypePK evetypePK = (IEvetypePK)JSONEvetype.toEvetypePK((JSONObject)json.get("evetypepk"));
        stationusecases.delete_all_containing_Evetype(evetypePK);
        setReturnstatus("OK");
    }

    private void delete_all_containing_System(Station_usecases stationusecases, JSONObject json) throws ParseException, CustomException {
        ISystemPK systemPK = (ISystemPK)JSONSystem.toSystemPK((JSONObject)json.get("systempk"));
        stationusecases.delete_all_containing_System(systemPK);
        setReturnstatus("OK");
    }

}

