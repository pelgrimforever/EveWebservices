/*
 * WSUsersettings.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 16.11.2021 15:46
 *
 */

package eve.webservices;

import eve.BusinessObject.Logic.*;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.webservice.WSIUsersettings;
import eve.logicentity.Usersettings;
import eve.searchentity.Usersettingssearch;
import general.exception.CustomException;
import general.exception.DataException;
import general.exception.DBException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.jws.WebMethod;
import javax.jws.WebService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Franky Laseure
 */
@WebService(endpointInterface = "eve.interfaces.webservice.WSIUsersettings")
public class WSUsersettings implements WSIUsersettings {

    private JSONArray toJSONArray(ArrayList usersettingss) {
        JSONArray jsonusersettingss = new JSONArray();
        Iterator usersettingssI = usersettingss.iterator();
        while(usersettingssI.hasNext()) {
            jsonusersettingss.add(JSONUsersettings.toJSON((Usersettings)usersettingssI.next()));
        }
        return jsonusersettingss;
    }

    /**
     * Web service operation
     */
    //@WebMethod(operationName = "getUsersettingss")
    @Override
    public String getUsersettingss() {
        try {
            BLusersettings blusersettings = new BLusersettings();
            ArrayList usersettingss = blusersettings.getAll();
            JSONArray jsonusersettingss = toJSONArray(usersettingss);
            return jsonusersettingss.toJSONString();
        }
        catch(DBException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "search")
    @Override
    public String search(String json) {
        BLusersettings blusersettings = new BLusersettings();
        JSONParser parser = new JSONParser();
        String result = "";
        Usersettings usersettings;
        try {
            Usersettingssearch usersettingssearch = JSONUsersettings.toUsersettingssearch((JSONObject)parser.parse(json));
            ArrayList usersettingss = blusersettings.search(usersettingssearch);
            JSONArray jsonusersettingss = toJSONArray(usersettingss);
            result = jsonusersettingss.toJSONString();
        }
        catch(ParseException e) {
            result = "";
        }
        catch(DBException e) {
            result = "";
        }
        return result;
    }

    //@WebMethod(operationName = "getUsersettings")
    @Override
    public String getUsersettings(String json) {
        BLusersettings blusersettings = new BLusersettings();
        JSONParser parser = new JSONParser();
        String result = "";
        Usersettings usersettings;
        try {
            UsersettingsPK usersettingsPK = JSONUsersettings.toUsersettingsPK((JSONObject)parser.parse(json));
            usersettings = blusersettings.getUsersettings(usersettingsPK);
            if(usersettings!=null) {
                result = JSONUsersettings.toJSON(usersettings).toJSONString();
            }
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
        return result;
    }

    //@WebMethod(operationName = "insertUsersettings")
    @Override
    public void insertUsersettings(String json) {
        BLusersettings blusersettings = new BLusersettings();
        JSONParser parser = new JSONParser();
        try {
            IUsersettings usersettings = JSONUsersettings.toUsersettings((JSONObject)parser.parse(json));
            blusersettings.insertUsersettings(usersettings);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "updateUsersettings")
    @Override
    public void updateUsersettings(String json) {
        BLusersettings blusersettings = new BLusersettings();
        JSONParser parser = new JSONParser();
        try {
            IUsersettings usersettings = JSONUsersettings.toUsersettings((JSONObject)parser.parse(json));
            blusersettings.updateUsersettings(usersettings);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "deleteUsersettings")
    @Override
    public void deleteUsersettings(String json) {
        BLusersettings blusersettings = new BLusersettings();
        JSONParser parser = new JSONParser();
        try {
            IUsersettings usersettings = JSONUsersettings.toUsersettings((JSONObject)parser.parse(json));
            blusersettings.deleteUsersettings(usersettings);
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "getUsersettingss4settings")
    @Override
    public String getUsersettingss4settings(String json) {
        BLusersettings blusersettings = new BLusersettings();
        JSONParser parser = new JSONParser();
        Usersettings usersettings;
        try {
            ISettingsPK settingsPK = JSONSettings.toSettingsPK((JSONObject)parser.parse(json));
            ArrayList usersettingss = blusersettings.getUsersettingss4settings(settingsPK);
            JSONArray jsonusersettingss = toJSONArray(usersettingss);
            return jsonusersettingss.toJSONString();
        }
        catch(ParseException e) {
            return null;
        }
        catch(DBException e) {
            return null;
        }
        catch(CustomException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "delete4settings")
    @Override
    public void delete4settings(String json) {
        BLusersettings blusersettings = new BLusersettings();
        JSONParser parser = new JSONParser();
        Usersettings usersettings;
        try {
            ISettingsPK settingsPK = JSONSettings.toSettingsPK((JSONObject)parser.parse(json));
            blusersettings.delete4settings(settingsPK);
        }
        catch(ParseException e) {
        }
    }


}

