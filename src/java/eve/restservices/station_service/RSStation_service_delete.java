/*
 * Generated on 23.8.2022 14:38
 * @author Franky Laseure
 */

package eve.restservices.station_service;

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
import eve.interfaces.searchentity.IStation_servicesearch;
import eve.interfaces.servlet.IStation_serviceOperation;
import eve.logicentity.Station_service;
import eve.searchentity.Station_servicesearch;
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

@Path("rsstation_service_delete")
public class RSStation_service_delete extends RS_json_login {

    private Security_usecases security_usecases = new Security_usecases();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Station_service_usecases station_serviceusecases = new Station_service_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IStation_serviceOperation.DELETE_STATION_SERVICE:
                    delete_station_service(station_serviceusecases, json);
                    break;
                case IStation_serviceOperation.DELETE_Station:
                    delete_station_service(station_serviceusecases, json);
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

