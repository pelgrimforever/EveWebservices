/*
 * Generated on 20.4.2022 10:3
 */

package eve.restservices.system;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.usecases.System_usecases;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.searchentity.ISystemsearch;
import eve.interfaces.servlet.ISystemOperation;
import eve.logicentity.System;
import eve.searchentity.Systemsearch;
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
@Path("rssystem_select")
public class RSSystem_select extends RS_json_login {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(Security_usecases.check_authorization(authorisationstring));
            ISystemPK systemPK;
            ISystem system;
            System_usecases systemusecases = new System_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case ISystemOperation.SELECT_COUNT:
                    result = count_records(systemusecases);
                    break;
                case ISystemOperation.SELECT_ALL:
                    result = get_all_system(systemusecases);
                    break;
                case ISystemOperation.SELECT_SYSTEM:
                    result = get_system_with_primarykey(systemusecases, json);
                    break;
                case ISystemOperation.SELECT_Security_island:
                    result = get_system_with_foreignkey_security_island(systemusecases, json);
                    break;
                case ISystemOperation.SELECT_Constellation:
                    result = get_system_with_foreignkey_constellation(systemusecases, json);
                    break;
                case ISystemOperation.SELECT_Systemjumpssystem_end:
                    result = get_system_with_externalforeignkey_systemjumpsSystem_end(systemusecases, json);
                    break;
                case ISystemOperation.SELECT_Systemjumpssystem_start:
                    result = get_system_with_externalforeignkey_systemjumpsSystem_start(systemusecases, json);
                    break;
                case ISystemOperation.SELECT_Tradecombinedbuy_system:
                    result = get_system_with_externalforeignkey_tradecombinedBuy_system(systemusecases, json);
                    break;
                case ISystemOperation.SELECT_Tradecombinedsell_system:
                    result = get_system_with_externalforeignkey_tradecombinedSell_system(systemusecases, json);
                    break;
                case ISystemOperation.SELECT_SEARCH:
                    result = search_system(systemusecases, json);
                    break;
                case ISystemOperation.SELECT_SEARCHCOUNT:
                    result = search_system_count(systemusecases, json);
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

    private String count_records(System_usecases systemusecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", systemusecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_system(System_usecases systemusecases) throws ParseException, CustomException {
    	return JSONSystem.toJSONArray(systemusecases.get_all()).toJSONString();
    }
    
    private String get_system_with_primarykey(System_usecases systemusecases, JSONObject json) throws ParseException, CustomException {
        ISystemPK systemPK = (ISystemPK)JSONSystem.toSystemPK((JSONObject)json.get("systempk"));
	return JSONSystem.toJSON(systemusecases.get_system_by_primarykey(systemPK)).toJSONString();
    }
    
    private String get_system_with_foreignkey_security_island(System_usecases systemusecases, JSONObject json) throws ParseException, CustomException {
        ISecurity_islandPK security_islandPK = (ISecurity_islandPK)JSONSecurity_island.toSecurity_islandPK((JSONObject)json.get("security_islandpk"));
        return JSONSystem.toJSONArray(systemusecases.get_system_with_foreignkey_security_island(security_islandPK)).toJSONString();
    }
    
    private String get_system_with_foreignkey_constellation(System_usecases systemusecases, JSONObject json) throws ParseException, CustomException {
        IConstellationPK constellationPK = (IConstellationPK)JSONConstellation.toConstellationPK((JSONObject)json.get("constellationpk"));
        return JSONSystem.toJSONArray(systemusecases.get_system_with_foreignkey_constellation(constellationPK)).toJSONString();
    }
    
    private String get_system_with_externalforeignkey_systemjumpsSystem_end(System_usecases systemusecases, JSONObject json) throws ParseException, CustomException {
        ISystemjumpsPK systemjumpsSystem_endPK = (ISystemjumpsPK)JSONSystemjumps.toSystemjumpsPK((JSONObject)json.get("systemjumpspk"));
        return JSONSystem.toJSON(systemusecases.get_system_with_externalforeignkey_systemjumpsSystem_end(systemjumpsSystem_endPK)).toJSONString();
    }
    
    private String get_system_with_externalforeignkey_systemjumpsSystem_start(System_usecases systemusecases, JSONObject json) throws ParseException, CustomException {
        ISystemjumpsPK systemjumpsSystem_startPK = (ISystemjumpsPK)JSONSystemjumps.toSystemjumpsPK((JSONObject)json.get("systemjumpspk"));
        return JSONSystem.toJSON(systemusecases.get_system_with_externalforeignkey_systemjumpsSystem_start(systemjumpsSystem_startPK)).toJSONString();
    }
    
    private String get_system_with_externalforeignkey_tradecombinedBuy_system(System_usecases systemusecases, JSONObject json) throws ParseException, CustomException {
        ITradecombinedPK tradecombinedBuy_systemPK = (ITradecombinedPK)JSONTradecombined.toTradecombinedPK((JSONObject)json.get("tradecombinedpk"));
        return JSONSystem.toJSON(systemusecases.get_system_with_externalforeignkey_tradecombinedBuy_system(tradecombinedBuy_systemPK)).toJSONString();
    }
    
    private String get_system_with_externalforeignkey_tradecombinedSell_system(System_usecases systemusecases, JSONObject json) throws ParseException, CustomException {
        ITradecombinedPK tradecombinedSell_systemPK = (ITradecombinedPK)JSONTradecombined.toTradecombinedPK((JSONObject)json.get("tradecombinedpk"));
        return JSONSystem.toJSON(systemusecases.get_system_with_externalforeignkey_tradecombinedSell_system(tradecombinedSell_systemPK)).toJSONString();
    }
    
    private String search_system(System_usecases systemusecases, JSONObject json) throws ParseException, CustomException {
        ISystemsearch search = (ISystemsearch)JSONSystem.toSystemsearch((JSONObject)json.get("search"));
        return JSONSystem.toJSONArray(systemusecases.search_system(search)).toJSONString();
    }
    
    private String search_system_count(System_usecases systemusecases, JSONObject json) throws ParseException, CustomException {
        ISystemsearch systemsearch = (ISystemsearch)JSONSystem.toSystemsearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", systemusecases.search_system_count(systemsearch));
        return jsonsearchcount.toJSONString();
    }
}

