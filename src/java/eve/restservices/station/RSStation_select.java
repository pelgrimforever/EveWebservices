/*
 * Generated on 23.8.2022 14:38
 * @author Franky Laseure
 */

package eve.restservices.station;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.usecases.*;
import eve.usecases.custom.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.searchentity.IStationsearch;
import eve.interfaces.servlet.IStationOperation;
import eve.logicentity.Station;
import eve.searchentity.Stationsearch;
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

@Path("rsstation_select")
public class RSStation_select extends RS_json_login {

    private Security_usecases security_usecases = new Security_usecases();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Station_usecases stationusecases = new Station_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IStationOperation.SELECT_COUNT:
                    result = count_records(stationusecases);
                    break;
                case IStationOperation.SELECT_ALL:
                    result = get_all_station(stationusecases);
                    break;
                case IStationOperation.SELECT_STATION:
                    result = get_station_with_primarykey(stationusecases, json);
                    break;
                case IStationOperation.SELECT_Race:
                    result = get_station_with_foreignkey_race(stationusecases, json);
                    break;
                case IStationOperation.SELECT_Evetype:
                    result = get_station_with_foreignkey_evetype(stationusecases, json);
                    break;
                case IStationOperation.SELECT_System:
                    result = get_station_with_foreignkey_system(stationusecases, json);
                    break;
                case IStationOperation.SELECT_Station_service:
                    result = get_station_with_externalforeignkey_station_service(stationusecases, json);
                    break;
                case IStationOperation.SELECT_SEARCH:
                    result = search_station(stationusecases, json);
                    break;
                case IStationOperation.SELECT_SEARCHCOUNT:
                    result = search_station_count(stationusecases, json);
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
}

