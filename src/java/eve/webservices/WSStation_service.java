/*
 * WSStation_service.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 14.0.2022 16:56
 *
 */

package eve.webservices;

import eve.BusinessObject.Logic.*;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.webservice.WSIStation_service;
import eve.logicentity.Station_service;
import eve.searchentity.Station_servicesearch;
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
@WebService(endpointInterface = "eve.interfaces.webservice.WSIStation_service")
public class WSStation_service implements WSIStation_service {

    private JSONArray toJSONArray(ArrayList station_services) {
        JSONArray jsonstation_services = new JSONArray();
        Iterator station_servicesI = station_services.iterator();
        while(station_servicesI.hasNext()) {
            jsonstation_services.add(JSONStation_service.toJSON((Station_service)station_servicesI.next()));
        }
        return jsonstation_services;
    }

    /**
     * Web service operation
     */
    //@WebMethod(operationName = "getStation_services")
    @Override
    public String getStation_services() {
        try {
            BLstation_service blstation_service = new BLstation_service();
            ArrayList station_services = blstation_service.getAll();
            JSONArray jsonstation_services = toJSONArray(station_services);
            return jsonstation_services.toJSONString();
        }
        catch(DBException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "search")
    @Override
    public String search(String json) {
        BLstation_service blstation_service = new BLstation_service();
        JSONParser parser = new JSONParser();
        String result = "";
        Station_service station_service;
        try {
            Station_servicesearch station_servicesearch = JSONStation_service.toStation_servicesearch((JSONObject)parser.parse(json));
            ArrayList station_services = blstation_service.search(station_servicesearch);
            JSONArray jsonstation_services = toJSONArray(station_services);
            result = jsonstation_services.toJSONString();
        }
        catch(ParseException e) {
            result = "";
        }
        catch(DBException e) {
            result = "";
        }
        return result;
    }

    //@WebMethod(operationName = "getStation_service")
    @Override
    public String getStation_service(String json) {
        BLstation_service blstation_service = new BLstation_service();
        JSONParser parser = new JSONParser();
        String result = "";
        Station_service station_service;
        try {
            Station_servicePK station_servicePK = JSONStation_service.toStation_servicePK((JSONObject)parser.parse(json));
            station_service = blstation_service.getStation_service(station_servicePK);
            if(station_service!=null) {
                result = JSONStation_service.toJSON(station_service).toJSONString();
            }
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
        return result;
    }

    //@WebMethod(operationName = "insertStation_service")
    @Override
    public void insertStation_service(String json) {
        BLstation_service blstation_service = new BLstation_service();
        JSONParser parser = new JSONParser();
        try {
            IStation_service station_service = JSONStation_service.toStation_service((JSONObject)parser.parse(json));
            blstation_service.insertStation_service(station_service);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "updateStation_service")
    @Override
    public void updateStation_service(String json) {
        BLstation_service blstation_service = new BLstation_service();
        JSONParser parser = new JSONParser();
        try {
            IStation_service station_service = JSONStation_service.toStation_service((JSONObject)parser.parse(json));
            blstation_service.updateStation_service(station_service);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "deleteStation_service")
    @Override
    public void deleteStation_service(String json) {
        BLstation_service blstation_service = new BLstation_service();
        JSONParser parser = new JSONParser();
        try {
            IStation_service station_service = JSONStation_service.toStation_service((JSONObject)parser.parse(json));
            blstation_service.deleteStation_service(station_service);
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "getStation_services4station")
    @Override
    public String getStation_services4station(String json) {
        BLstation_service blstation_service = new BLstation_service();
        JSONParser parser = new JSONParser();
        Station_service station_service;
        try {
            IStationPK stationPK = JSONStation.toStationPK((JSONObject)parser.parse(json));
            ArrayList station_services = blstation_service.getStation_services4station(stationPK);
            JSONArray jsonstation_services = toJSONArray(station_services);
            return jsonstation_services.toJSONString();
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

    //@WebMethod(operationName = "delete4station")
    @Override
    public void delete4station(String json) {
        BLstation_service blstation_service = new BLstation_service();
        JSONParser parser = new JSONParser();
        Station_service station_service;
        try {
            IStationPK stationPK = JSONStation.toStationPK((JSONObject)parser.parse(json));
            blstation_service.delete4station(stationPK);
        }
        catch(ParseException e) {
        }
    }


}

