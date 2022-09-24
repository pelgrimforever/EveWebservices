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
import eve.interfaces.searchentity.ILocationsearch;
import eve.interfaces.webservice.WSILocation;
import eve.logicentity.Location;
import eve.searchentity.Locationsearch;
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

@WebService(endpointInterface = "eve.interfaces.webservice.WSILocation")
public class WSLocation extends RS_json_login implements WSILocation {

    private Security_usecases security_usecases = new Security_usecases();
    
    private JSONArray toJSONArray(ArrayList locations) {
        JSONArray jsonlocations = new JSONArray();
        Iterator locationsI = locations.iterator();
        while(locationsI.hasNext()) {
            jsonlocations.add(JSONLocation.toJSON((Location)locationsI.next()));
        }
        return jsonlocations;
    }

    //@WebMethod(operationName = "getLocations")
    @Override
    public String getLocations() {
        try {
            Location_usecases locationusecases = new Location_usecases(loggedin);
            return get_all_location(locationusecases);
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
            Location_usecases locationusecases = new Location_usecases(loggedin);
            return search_location(locationusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "getLocation")
    @Override
    public String getLocation(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Location_usecases locationusecases = new Location_usecases(loggedin);
            return get_location_with_primarykey(locationusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "insertLocation")
    @Override
    public void insertLocation(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Location_usecases locationusecases = new Location_usecases(loggedin);
            insert_location(locationusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "updateLocation")
    @Override
    public void updateLocation(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Location_usecases locationusecases = new Location_usecases(loggedin);
            update_location(locationusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "deleteLocation")
    @Override
    public void deleteLocation(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Location_usecases locationusecases = new Location_usecases(loggedin);
            delete_location(locationusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getLocations4system")
    @Override
    public String getLocations4system(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Location_usecases locationusecases = new Location_usecases(loggedin);
            return get_location_with_foreignkey_system(locationusecases, json);
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
            Location_usecases locationusecases = new Location_usecases(loggedin);
            delete_location(locationusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }


    private String count_records(Location_usecases locationusecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", locationusecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_location(Location_usecases locationusecases) throws ParseException, CustomException {
    	return JSONLocation.toJSONArray(locationusecases.get_all()).toJSONString();
    }
    
    private String get_location_with_primarykey(Location_usecases locationusecases, JSONObject json) throws ParseException, CustomException {
        ILocationPK locationPK = (ILocationPK)JSONLocation.toLocationPK((JSONObject)json.get("locationpk"));
	return JSONLocation.toJSON(locationusecases.get_location_by_primarykey(locationPK)).toJSONString();
    }
    
    private String get_location_with_foreignkey_system(Location_usecases locationusecases, JSONObject json) throws ParseException, CustomException {
        ISystemPK systemPK = (ISystemPK)JSONSystem.toSystemPK((JSONObject)json.get("systempk"));
        return JSONLocation.toJSONArray(locationusecases.get_location_with_foreignkey_system(systemPK)).toJSONString();
    }
    
    private String search_location(Location_usecases locationusecases, JSONObject json) throws ParseException, CustomException {
        ILocationsearch search = (ILocationsearch)JSONLocation.toLocationsearch((JSONObject)json.get("search"));
        return JSONLocation.toJSONArray(locationusecases.search_location(search)).toJSONString();
    }
    
    private String search_location_count(Location_usecases locationusecases, JSONObject json) throws ParseException, CustomException {
        ILocationsearch locationsearch = (ILocationsearch)JSONLocation.toLocationsearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", locationusecases.search_location_count(locationsearch));
        return jsonsearchcount.toJSONString();
    }

    private void insert_location(Location_usecases locationusecases, JSONObject json) throws ParseException, CustomException {
        ILocation location = (ILocation)JSONLocation.toLocation((JSONObject)json.get("location"));
        locationusecases.insertLocation(location);
        setReturnstatus("OK");
    }

    private void update_location(Location_usecases locationusecases, JSONObject json) throws ParseException, CustomException {
        ILocation location = (ILocation)JSONLocation.toLocation((JSONObject)json.get("location"));
        locationusecases.updateLocation(location);
        setReturnstatus("OK");
    }

    private void delete_location(Location_usecases locationusecases, JSONObject json) throws ParseException, CustomException {
        ILocation location = (ILocation)JSONLocation.toLocation((JSONObject)json.get("location"));
        locationusecases.deleteLocation(location);
        setReturnstatus("OK");
    }

    private void delete_all_containing_System(Location_usecases locationusecases, JSONObject json) throws ParseException, CustomException {
        ISystemPK systemPK = (ISystemPK)JSONSystem.toSystemPK((JSONObject)json.get("systempk"));
        locationusecases.delete_all_containing_System(systemPK);
        setReturnstatus("OK");
    }

}

