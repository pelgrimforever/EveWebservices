/*
 * Generated on 13.6.2022 18:20
 */

package eve.restservices.system;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.usecases.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.searchentity.ISystemsearch;
import eve.interfaces.servlet.ISystemOperation;
import eve.logicentity.System;
import eve.searchentity.Systemsearch;
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
@Path("rssystem_delete")
public class RSSystem_delete extends RS_json_login {

    private Security_usecases security_usecases = new Security_usecases();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            System_usecases systemusecases = new System_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case ISystemOperation.DELETE_SYSTEM:
                    delete_system(systemusecases, json);
                    break;
                case ISystemOperation.DELETE_Security_island:
                    delete_system(systemusecases, json);
                    break;
                case ISystemOperation.DELETE_Constellation:
                    delete_system(systemusecases, json);
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

    private void delete_system(System_usecases systemusecases, JSONObject json) throws ParseException, CustomException {
        ISystem system = (ISystem)JSONSystem.toSystem((JSONObject)json.get("system"));
        systemusecases.deleteSystem(system);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Security_island(System_usecases systemusecases, JSONObject json) throws ParseException, CustomException {
        ISecurity_islandPK security_islandPK = (ISecurity_islandPK)JSONSecurity_island.toSecurity_islandPK((JSONObject)json.get("security_islandpk"));
        systemusecases.delete_all_containing_Security_island(security_islandPK);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Constellation(System_usecases systemusecases, JSONObject json) throws ParseException, CustomException {
        IConstellationPK constellationPK = (IConstellationPK)JSONConstellation.toConstellationPK((JSONObject)json.get("constellationpk"));
        systemusecases.delete_all_containing_Constellation(constellationPK);
        setReturnstatus("OK");
    }

}

