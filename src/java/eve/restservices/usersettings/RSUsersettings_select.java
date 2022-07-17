/*
 * Generated on 17.6.2022 13:4
 */

package eve.restservices.usersettings;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.usecases.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.searchentity.IUsersettingssearch;
import eve.interfaces.servlet.IUsersettingsOperation;
import eve.logicentity.Usersettings;
import eve.searchentity.Usersettingssearch;
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
@Path("rsusersettings_select")
public class RSUsersettings_select extends RS_json_login {

    private Security_usecases security_usecases = new Security_usecases();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Usersettings_usecases usersettingsusecases = new Usersettings_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IUsersettingsOperation.SELECT_COUNT:
                    result = count_records(usersettingsusecases);
                    break;
                case IUsersettingsOperation.SELECT_ALL:
                    result = get_all_usersettings(usersettingsusecases);
                    break;
                case IUsersettingsOperation.SELECT_USERSETTINGS:
                    result = get_usersettings_with_primarykey(usersettingsusecases, json);
                    break;
                case IUsersettingsOperation.SELECT_Settings:
                    result = get_usersettings_with_foreignkey_settings(usersettingsusecases, json);
                    break;
                case IUsersettingsOperation.SELECT_SEARCH:
                    result = search_usersettings(usersettingsusecases, json);
                    break;
                case IUsersettingsOperation.SELECT_SEARCHCOUNT:
                    result = search_usersettings_count(usersettingsusecases, json);
                    break;
//Custom code, do not change this line
//add here custom operations
                case IUsersettingsOperation.SELECT_4USER:
                    result = get_usersettings_4user(usersettingsusecases, json);
                    break;
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
    private String get_usersettings_4user(Usersettings_usecases usersettingsinteractor, JSONObject json) throws ParseException, CustomException {
        String username = JSONConversion.getString(json, "username");
    	return JSONUsersettings.toJSONArray(usersettingsinteractor.get_all_4user_usecase(username)).toJSONString();
    }
    
//Custom code, do not change this line   

    private String count_records(Usersettings_usecases usersettingsusecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", usersettingsusecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_usersettings(Usersettings_usecases usersettingsusecases) throws ParseException, CustomException {
    	return JSONUsersettings.toJSONArray(usersettingsusecases.get_all()).toJSONString();
    }
    
    private String get_usersettings_with_primarykey(Usersettings_usecases usersettingsusecases, JSONObject json) throws ParseException, CustomException {
        IUsersettingsPK usersettingsPK = (IUsersettingsPK)JSONUsersettings.toUsersettingsPK((JSONObject)json.get("usersettingspk"));
	return JSONUsersettings.toJSON(usersettingsusecases.get_usersettings_by_primarykey(usersettingsPK)).toJSONString();
    }
    
    private String get_usersettings_with_foreignkey_settings(Usersettings_usecases usersettingsusecases, JSONObject json) throws ParseException, CustomException {
        ISettingsPK settingsPK = (ISettingsPK)JSONSettings.toSettingsPK((JSONObject)json.get("settingspk"));
        return JSONUsersettings.toJSONArray(usersettingsusecases.get_usersettings_with_foreignkey_settings(settingsPK)).toJSONString();
    }
    
    private String search_usersettings(Usersettings_usecases usersettingsusecases, JSONObject json) throws ParseException, CustomException {
        IUsersettingssearch search = (IUsersettingssearch)JSONUsersettings.toUsersettingssearch((JSONObject)json.get("search"));
        return JSONUsersettings.toJSONArray(usersettingsusecases.search_usersettings(search)).toJSONString();
    }
    
    private String search_usersettings_count(Usersettings_usecases usersettingsusecases, JSONObject json) throws ParseException, CustomException {
        IUsersettingssearch usersettingssearch = (IUsersettingssearch)JSONUsersettings.toUsersettingssearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", usersettingsusecases.search_usersettings_count(usersettingssearch));
        return jsonsearchcount.toJSONString();
    }
}

