/*
 * Generated on 17.6.2022 13:4
 */

package eve.restservices.location;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.usecases.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.searchentity.ILocationsearch;
import eve.interfaces.servlet.ILocationOperation;
import eve.logicentity.Location;
import eve.searchentity.Locationsearch;
import eve.servlets.DataServlet;
import eve.usecases.custom.*;
import general.exception.*;
import java.sql.Date;
import java.sql.Time;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
@Path("rslocation_select")
public class RSLocation_select extends RS_json_login {

    private Security_usecases security_usecases = new Security_usecases();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Location_usecases locationusecases = new Location_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case ILocationOperation.SELECT_COUNT:
                    result = count_records(locationusecases);
                    break;
                case ILocationOperation.SELECT_ALL:
                    result = get_all_location(locationusecases);
                    break;
                case ILocationOperation.SELECT_LOCATION:
                    result = get_location_with_primarykey(locationusecases, json);
                    break;
                case ILocationOperation.SELECT_System:
                    result = get_location_with_foreignkey_system(locationusecases, json);
                    break;
                case ILocationOperation.SELECT_SEARCH:
                    result = search_location(locationusecases, json);
                    break;
                case ILocationOperation.SELECT_SEARCHCOUNT:
                    result = search_location_count(locationusecases, json);
                    break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            }
        }
        catch(ParseException | CustomException | IOException e) {
            setReturnstatus(e.getMessage());
        }
        return result;
    }

//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   

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
}

