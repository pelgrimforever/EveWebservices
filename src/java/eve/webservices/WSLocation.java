/*
 * WSLocation.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 11.4.2022 9:13
 *
 */

package eve.webservices;

import eve.BusinessObject.Logic.*;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.webservice.WSILocation;
import eve.logicentity.Location;
import eve.searchentity.Locationsearch;
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
@WebService(endpointInterface = "eve.interfaces.webservice.WSILocation")
public class WSLocation implements WSILocation {

    private JSONArray toJSONArray(ArrayList locations) {
        JSONArray jsonlocations = new JSONArray();
        Iterator locationsI = locations.iterator();
        while(locationsI.hasNext()) {
            jsonlocations.add(JSONLocation.toJSON((Location)locationsI.next()));
        }
        return jsonlocations;
    }

    /**
     * Web service operation
     */
    //@WebMethod(operationName = "getLocations")
    @Override
    public String getLocations() {
        try {
            BLlocation bllocation = new BLlocation();
            ArrayList locations = bllocation.getAll();
            JSONArray jsonlocations = toJSONArray(locations);
            return jsonlocations.toJSONString();
        }
        catch(DBException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "search")
    @Override
    public String search(String json) {
        BLlocation bllocation = new BLlocation();
        JSONParser parser = new JSONParser();
        String result = "";
        Location location;
        try {
            Locationsearch locationsearch = JSONLocation.toLocationsearch((JSONObject)parser.parse(json));
            ArrayList locations = bllocation.search(locationsearch);
            JSONArray jsonlocations = toJSONArray(locations);
            result = jsonlocations.toJSONString();
        }
        catch(ParseException e) {
            result = "";
        }
        catch(DBException e) {
            result = "";
        }
        return result;
    }

    //@WebMethod(operationName = "getLocation")
    @Override
    public String getLocation(String json) {
        BLlocation bllocation = new BLlocation();
        JSONParser parser = new JSONParser();
        String result = "";
        Location location;
        try {
            LocationPK locationPK = JSONLocation.toLocationPK((JSONObject)parser.parse(json));
            location = bllocation.getLocation(locationPK);
            if(location!=null) {
                result = JSONLocation.toJSON(location).toJSONString();
            }
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
        return result;
    }

    //@WebMethod(operationName = "insertLocation")
    @Override
    public void insertLocation(String json) {
        BLlocation bllocation = new BLlocation();
        JSONParser parser = new JSONParser();
        try {
            ILocation location = JSONLocation.toLocation((JSONObject)parser.parse(json));
            bllocation.insertLocation(location);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "updateLocation")
    @Override
    public void updateLocation(String json) {
        BLlocation bllocation = new BLlocation();
        JSONParser parser = new JSONParser();
        try {
            ILocation location = JSONLocation.toLocation((JSONObject)parser.parse(json));
            bllocation.updateLocation(location);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "deleteLocation")
    @Override
    public void deleteLocation(String json) {
        BLlocation bllocation = new BLlocation();
        JSONParser parser = new JSONParser();
        try {
            ILocation location = JSONLocation.toLocation((JSONObject)parser.parse(json));
            bllocation.deleteLocation(location);
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "getLocations4system")
    @Override
    public String getLocations4system(String json) {
        BLlocation bllocation = new BLlocation();
        JSONParser parser = new JSONParser();
        Location location;
        try {
            ISystemPK systemPK = JSONSystem.toSystemPK((JSONObject)parser.parse(json));
            ArrayList locations = bllocation.getLocations4system(systemPK);
            JSONArray jsonlocations = toJSONArray(locations);
            return jsonlocations.toJSONString();
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
        BLlocation bllocation = new BLlocation();
        JSONParser parser = new JSONParser();
        Location location;
        try {
            ISystemPK systemPK = JSONSystem.toSystemPK((JSONObject)parser.parse(json));
            bllocation.delete4system(systemPK);
        }
        catch(ParseException e) {
        }
    }


}

