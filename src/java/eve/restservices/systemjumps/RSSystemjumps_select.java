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

@Path("rssystemjumps_select")
public class RSSystemjumps_select extends RS_json_login {

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
                case ISystemjumpsOperation.SELECT_COUNT:
                    result = count_records(systemjumpsusecases);
                    break;
                case ISystemjumpsOperation.SELECT_ALL:
                    result = get_all_systemjumps(systemjumpsusecases);
                    break;
                case ISystemjumpsOperation.SELECT_SYSTEMJUMPS:
                    result = get_systemjumps_with_primarykey(systemjumpsusecases, json);
                    break;
                case ISystemjumpsOperation.SELECT_Systemsystem_end:
                    result = get_systemjumps_with_foreignkey_systemSystem_end(systemjumpsusecases, json);
                    break;
                case ISystemjumpsOperation.SELECT_Systemsystem_start:
                    result = get_systemjumps_with_foreignkey_systemSystem_start(systemjumpsusecases, json);
                    break;
                case ISystemjumpsOperation.SELECT_SEARCH:
                    result = search_systemjumps(systemjumpsusecases, json);
                    break;
                case ISystemjumpsOperation.SELECT_SEARCHCOUNT:
                    result = search_systemjumps_count(systemjumpsusecases, json);
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

    private String count_records(Systemjumps_usecases systemjumpsusecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", systemjumpsusecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_systemjumps(Systemjumps_usecases systemjumpsusecases) throws ParseException, CustomException {
    	return JSONSystemjumps.toJSONArray(systemjumpsusecases.get_all()).toJSONString();
    }
    
    private String get_systemjumps_with_primarykey(Systemjumps_usecases systemjumpsusecases, JSONObject json) throws ParseException, CustomException {
        ISystemjumpsPK systemjumpsPK = (ISystemjumpsPK)JSONSystemjumps.toSystemjumpsPK((JSONObject)json.get("systemjumpspk"));
	return JSONSystemjumps.toJSON(systemjumpsusecases.get_systemjumps_by_primarykey(systemjumpsPK)).toJSONString();
    }
    
    private String get_systemjumps_with_foreignkey_systemSystem_end(Systemjumps_usecases systemjumpsusecases, JSONObject json) throws ParseException, CustomException {
        ISystemPK systemSystem_endPK = (ISystemPK)JSONSystem.toSystemPK((JSONObject)json.get("systempk"));
        return JSONSystemjumps.toJSONArray(systemjumpsusecases.get_systemjumps_with_foreignkey_systemSystem_end(systemSystem_endPK)).toJSONString();
    }
    
    private String get_systemjumps_with_foreignkey_systemSystem_start(Systemjumps_usecases systemjumpsusecases, JSONObject json) throws ParseException, CustomException {
        ISystemPK systemSystem_startPK = (ISystemPK)JSONSystem.toSystemPK((JSONObject)json.get("systempk"));
        return JSONSystemjumps.toJSONArray(systemjumpsusecases.get_systemjumps_with_foreignkey_systemSystem_start(systemSystem_startPK)).toJSONString();
    }
    
    private String search_systemjumps(Systemjumps_usecases systemjumpsusecases, JSONObject json) throws ParseException, CustomException {
        ISystemjumpssearch search = (ISystemjumpssearch)JSONSystemjumps.toSystemjumpssearch((JSONObject)json.get("search"));
        return JSONSystemjumps.toJSONArray(systemjumpsusecases.search_systemjumps(search)).toJSONString();
    }
    
    private String search_systemjumps_count(Systemjumps_usecases systemjumpsusecases, JSONObject json) throws ParseException, CustomException {
        ISystemjumpssearch systemjumpssearch = (ISystemjumpssearch)JSONSystemjumps.toSystemjumpssearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", systemjumpsusecases.search_systemjumps_count(systemjumpssearch));
        return jsonsearchcount.toJSONString();
    }
}

