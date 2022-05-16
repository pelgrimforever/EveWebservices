/*
 * Generated on 13.4.2022 19:13
 */

package eve.restservices.station_service;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.usecases.Station_service_usecases;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.searchentity.IStation_servicesearch;
import eve.interfaces.servlet.IStation_serviceOperation;
import eve.logicentity.Station_service;
import eve.searchentity.Station_servicesearch;
import eve.servlets.DataServlet;
import eve.usecases.Security_usecases;
import general.exception.CustomException;
import general.exception.DataException;
import general.exception.DBException;
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
@Path("rsstation_service_select")
public class RSStation_service_select extends RS_json_login {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(Security_usecases.check_authorization(authorisationstring));
            IStation_servicePK station_servicePK;
            IStation_service station_service;
            Station_service_usecases station_serviceusecases = new Station_service_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IStation_serviceOperation.SELECT_COUNT:
                    result = count_records(station_serviceusecases);
                    break;
                case IStation_serviceOperation.SELECT_ALL:
                    result = get_all_station_service(station_serviceusecases);
                    break;
                case IStation_serviceOperation.SELECT_STATION_SERVICE:
                    result = get_station_service_with_primarykey(station_serviceusecases, json);
                    break;
                case IStation_serviceOperation.SELECT_Station:
                    result = get_station_service_with_foreignkey_station(station_serviceusecases, json);
                    break;
                case IStation_serviceOperation.SELECT_SEARCH:
                    result = search_station_service(station_serviceusecases, json);
                    break;
                case IStation_serviceOperation.SELECT_SEARCHCOUNT:
                    result = search_station_service_count(station_serviceusecases, json);
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
}

