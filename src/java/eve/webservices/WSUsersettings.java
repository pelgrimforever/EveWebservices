/*
 * WSUsersettings.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 13.6.2022 18:20
 *
 */

package eve.webservices;

import base.restservices.RS_json_login;
import eve.BusinessObject.Logic.*;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.searchentity.IUsersettingssearch;
import eve.interfaces.webservice.WSIUsersettings;
import eve.logicentity.Usersettings;
import eve.searchentity.Usersettingssearch;
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

/**
 *
 * @author Franky Laseure
 */
@WebService(endpointInterface = "eve.interfaces.webservice.WSIUsersettings")
public class WSUsersettings extends RS_json_login implements WSIUsersettings {

    private Security_usecases security_usecases = new Security_usecases();
    
    private JSONArray toJSONArray(ArrayList usersettingss) {
        JSONArray jsonusersettingss = new JSONArray();
        Iterator usersettingssI = usersettingss.iterator();
        while(usersettingssI.hasNext()) {
            jsonusersettingss.add(JSONUsersettings.toJSON((Usersettings)usersettingssI.next()));
        }
        return jsonusersettingss;
    }

    //@WebMethod(operationName = "getUsersettingss")
    @Override
    public String getUsersettingss() {
        try {
            Usersettings_usecases usersettingsusecases = new Usersettings_usecases(loggedin);
            return get_all_usersettings(usersettingsusecases);
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
            Usersettings_usecases usersettingsusecases = new Usersettings_usecases(loggedin);
            return search_usersettings(usersettingsusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "getUsersettings")
    @Override
    public String getUsersettings(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Usersettings_usecases usersettingsusecases = new Usersettings_usecases(loggedin);
            return get_usersettings_with_primarykey(usersettingsusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "insertUsersettings")
    @Override
    public void insertUsersettings(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Usersettings_usecases usersettingsusecases = new Usersettings_usecases(loggedin);
            insert_usersettings(usersettingsusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "updateUsersettings")
    @Override
    public void updateUsersettings(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Usersettings_usecases usersettingsusecases = new Usersettings_usecases(loggedin);
            update_usersettings(usersettingsusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "deleteUsersettings")
    @Override
    public void deleteUsersettings(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Usersettings_usecases usersettingsusecases = new Usersettings_usecases(loggedin);
            delete_usersettings(usersettingsusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getUsersettingss4settings")
    @Override
    public String getUsersettingss4settings(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Usersettings_usecases usersettingsusecases = new Usersettings_usecases(loggedin);
            return get_usersettings_with_foreignkey_settings(usersettingsusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "delete4settings")
    @Override
    public void delete4settings(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Usersettings_usecases usersettingsusecases = new Usersettings_usecases(loggedin);
            delete_usersettings(usersettingsusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }


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

    private void insert_usersettings(Usersettings_usecases usersettingsusecases, JSONObject json) throws ParseException, CustomException {
        IUsersettings usersettings = (IUsersettings)JSONUsersettings.toUsersettings((JSONObject)json.get("usersettings"));
        usersettingsusecases.insertUsersettings(usersettings);
        setReturnstatus("OK");
    }

    private void update_usersettings(Usersettings_usecases usersettingsusecases, JSONObject json) throws ParseException, CustomException {
        IUsersettings usersettings = (IUsersettings)JSONUsersettings.toUsersettings((JSONObject)json.get("usersettings"));
        usersettingsusecases.updateUsersettings(usersettings);
        setReturnstatus("OK");
    }

    private void delete_usersettings(Usersettings_usecases usersettingsusecases, JSONObject json) throws ParseException, CustomException {
        IUsersettings usersettings = (IUsersettings)JSONUsersettings.toUsersettings((JSONObject)json.get("usersettings"));
        usersettingsusecases.deleteUsersettings(usersettings);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Settings(Usersettings_usecases usersettingsusecases, JSONObject json) throws ParseException, CustomException {
        ISettingsPK settingsPK = (ISettingsPK)JSONSettings.toSettingsPK((JSONObject)json.get("settingspk"));
        usersettingsusecases.delete_all_containing_Settings(settingsPK);
        setReturnstatus("OK");
    }

}

