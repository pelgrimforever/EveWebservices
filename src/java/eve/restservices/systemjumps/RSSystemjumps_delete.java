/*
 * Generated on 23.8.2022 14:38
 * @author Franky Laseure
 */

package eve.restservices.systemjumps;

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
import eve.interfaces.searchentity.ISystemjumpssearch;
import eve.interfaces.servlet.ISystemjumpsOperation;
import eve.logicentity.Systemjumps;
import eve.searchentity.Systemjumpssearch;
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

@Path("rssystemjumps_delete")
public class RSSystemjumps_delete extends RS_json_login {

    private Security_usecases security_usecases = new Security_usecases();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Systemjumps_usecases systemjumpsusecases = new Systemjumps_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case ISystemjumpsOperation.DELETE_SYSTEMJUMPS:
                    delete_systemjumps(systemjumpsusecases, json);
                    break;
                case ISystemjumpsOperation.DELETE_Systemsystem_end:
                    delete_systemjumps(systemjumpsusecases, json);
                    break;
                case ISystemjumpsOperation.DELETE_Systemsystem_start:
                    delete_systemjumps(systemjumpsusecases, json);
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

    private void delete_systemjumps(Systemjumps_usecases systemjumpsusecases, JSONObject json) throws ParseException, CustomException {
        ISystemjumps systemjumps = (ISystemjumps)JSONSystemjumps.toSystemjumps((JSONObject)json.get("systemjumps"));
        systemjumpsusecases.deleteSystemjumps(systemjumps);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Systemsystem_end(Systemjumps_usecases systemjumpsusecases, JSONObject json) throws ParseException, CustomException {
        ISystemPK systemSystem_endPK = (ISystemPK)JSONSystem.toSystemPK((JSONObject)json.get("systempk"));
        systemjumpsusecases.delete_all_containing_Systemsystem_end(systemSystem_endPK);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Systemsystem_start(Systemjumps_usecases systemjumpsusecases, JSONObject json) throws ParseException, CustomException {
        ISystemPK systemSystem_startPK = (ISystemPK)JSONSystem.toSystemPK((JSONObject)json.get("systempk"));
        systemjumpsusecases.delete_all_containing_Systemsystem_start(systemSystem_startPK);
        setReturnstatus("OK");
    }

}

