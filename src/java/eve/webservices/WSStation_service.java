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
import eve.interfaces.searchentity.IStation_servicesearch;
import eve.interfaces.webservice.WSIStation_service;
import eve.logicentity.Station_service;
import eve.searchentity.Station_servicesearch;
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

@WebService(endpointInterface = "eve.interfaces.webservice.WSIStation_service")
public class WSStation_service extends RS_json_login implements WSIStation_service {

    private Security_usecases security_usecases = new Security_usecases();
    
    private JSONArray toJSONArray(ArrayList station_services) {
        JSONArray jsonstation_services = new JSONArray();
        Iterator station_servicesI = station_services.iterator();
        while(station_servicesI.hasNext()) {
            jsonstation_services.add(JSONStation_service.toJSON((Station_service)station_servicesI.next()));
        }
        return jsonstation_services;
    }

    //@WebMethod(operationName = "getStation_services")
    @Override
    public String getStation_services() {
        try {
            Station_service_usecases station_serviceusecases = new Station_service_usecases(loggedin);
            return get_all_station_service(station_serviceusecases);
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
            Station_service_usecases station_serviceusecases = new Station_service_usecases(loggedin);
            return search_station_service(station_serviceusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "getStation_service")
    @Override
    public String getStation_service(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Station_service_usecases station_serviceusecases = new Station_service_usecases(loggedin);
            return get_station_service_with_primarykey(station_serviceusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "insertStation_service")
    @Override
    public void insertStation_service(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Station_service_usecases station_serviceusecases = new Station_service_usecases(loggedin);
            insert_station_service(station_serviceusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "updateStation_service")
    @Override
    public void updateStation_service(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Station_service_usecases station_serviceusecases = new Station_service_usecases(loggedin);
            update_station_service(station_serviceusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "deleteStation_service")
    @Override
    public void deleteStation_service(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Station_service_usecases station_serviceusecases = new Station_service_usecases(loggedin);
            delete_station_service(station_serviceusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getStation_services4station")
    @Override
    public String getStation_services4station(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Station_service_usecases station_serviceusecases = new Station_service_usecases(loggedin);
            return get_station_service_with_foreignkey_station(station_serviceusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "delete4station")
    @Override
    public void delete4station(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Station_service_usecases station_serviceusecases = new Station_service_usecases(loggedin);
            delete_station_service(station_serviceusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }


    private String count_records(Station_service_usecases station_serviceusecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", station_serviceusecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_station_service(Station_service_usecases station_serviceusecases) throws ParseException, CustomException {
    	return JSONStation_service.toJSONArray(station_serviceusecases.get_all()).toJSONString();
    }
    
    private String get_station_service_with_primarykey(Station_service_usecases station_serviceusecases, JSONObject json) throws ParseException, CustomException {
        IStation_servicePK station_servicePK = (IStation_servicePK)JSONStation_service.toStation_servicePK((JSONObject)json.get("station_servicepk"));
	return JSONStation_service.toJSON(station_serviceusecases.get_station_service_by_primarykey(station_servicePK)).toJSONString();
    }
    
    private String get_station_service_with_foreignkey_station(Station_service_usecases station_serviceusecases, JSONObject json) throws ParseException, CustomException {
        IStationPK stationPK = (IStationPK)JSONStation.toStationPK((JSONObject)json.get("stationpk"));
        return JSONStation_service.toJSONArray(station_serviceusecases.get_station_service_with_foreignkey_station(stationPK)).toJSONString();
    }
    
    private String search_station_service(Station_service_usecases station_serviceusecases, JSONObject json) throws ParseException, CustomException {
        IStation_servicesearch search = (IStation_servicesearch)JSONStation_service.toStation_servicesearch((JSONObject)json.get("search"));
        return JSONStation_service.toJSONArray(station_serviceusecases.search_station_service(search)).toJSONString();
    }
    
    private String search_station_service_count(Station_service_usecases station_serviceusecases, JSONObject json) throws ParseException, CustomException {
        IStation_servicesearch station_servicesearch = (IStation_servicesearch)JSONStation_service.toStation_servicesearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", station_serviceusecases.search_station_service_count(station_servicesearch));
        return jsonsearchcount.toJSONString();
    }

    private void insert_station_service(Station_service_usecases station_serviceusecases, JSONObject json) throws ParseException, CustomException {
        IStation_service station_service = (IStation_service)JSONStation_service.toStation_service((JSONObject)json.get("station_service"));
        station_serviceusecases.insertStation_service(station_service);
        setReturnstatus("OK");
    }

    private void update_station_service(Station_service_usecases station_serviceusecases, JSONObject json) throws ParseException, CustomException {
        IStation_service station_service = (IStation_service)JSONStation_service.toStation_service((JSONObject)json.get("station_service"));
        station_serviceusecases.updateStation_service(station_service);
        setReturnstatus("OK");
    }

    private void delete_station_service(Station_service_usecases station_serviceusecases, JSONObject json) throws ParseException, CustomException {
        IStation_service station_service = (IStation_service)JSONStation_service.toStation_service((JSONObject)json.get("station_service"));
        station_serviceusecases.deleteStation_service(station_service);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Station(Station_service_usecases station_serviceusecases, JSONObject json) throws ParseException, CustomException {
        IStationPK stationPK = (IStationPK)JSONStation.toStationPK((JSONObject)json.get("stationpk"));
        station_serviceusecases.delete_all_containing_Station(stationPK);
        setReturnstatus("OK");
    }

}

