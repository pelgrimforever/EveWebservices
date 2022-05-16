/*
 * WSSystemactivity.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 5.3.2022 17:21
 *
 */

package eve.webservices;

import eve.BusinessObject.Logic.*;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.webservice.WSISystemactivity;
import eve.logicentity.Systemactivity;
import eve.searchentity.Systemactivitysearch;
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
@WebService(endpointInterface = "eve.interfaces.webservice.WSISystemactivity")
public class WSSystemactivity implements WSISystemactivity {

    private JSONArray toJSONArray(ArrayList systemactivitys) {
        JSONArray jsonsystemactivitys = new JSONArray();
        Iterator systemactivitysI = systemactivitys.iterator();
        while(systemactivitysI.hasNext()) {
            jsonsystemactivitys.add(JSONSystemactivity.toJSON((Systemactivity)systemactivitysI.next()));
        }
        return jsonsystemactivitys;
    }

    /**
     * Web service operation
     */
    //@WebMethod(operationName = "getSystemactivitys")
    @Override
    public String getSystemactivitys() {
        try {
            BLsystemactivity blsystemactivity = new BLsystemactivity();
            ArrayList systemactivitys = blsystemactivity.getAll();
            JSONArray jsonsystemactivitys = toJSONArray(systemactivitys);
            return jsonsystemactivitys.toJSONString();
        }
        catch(DBException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "search")
    @Override
    public String search(String json) {
        BLsystemactivity blsystemactivity = new BLsystemactivity();
        JSONParser parser = new JSONParser();
        String result = "";
        Systemactivity systemactivity;
        try {
            Systemactivitysearch systemactivitysearch = JSONSystemactivity.toSystemactivitysearch((JSONObject)parser.parse(json));
            ArrayList systemactivitys = blsystemactivity.search(systemactivitysearch);
            JSONArray jsonsystemactivitys = toJSONArray(systemactivitys);
            result = jsonsystemactivitys.toJSONString();
        }
        catch(ParseException e) {
            result = "";
        }
        catch(DBException e) {
            result = "";
        }
        return result;
    }

    //@WebMethod(operationName = "getSystemactivity")
    @Override
    public String getSystemactivity(String json) {
        BLsystemactivity blsystemactivity = new BLsystemactivity();
        JSONParser parser = new JSONParser();
        String result = "";
        Systemactivity systemactivity;
        try {
            SystemactivityPK systemactivityPK = JSONSystemactivity.toSystemactivityPK((JSONObject)parser.parse(json));
            systemactivity = blsystemactivity.getSystemactivity(systemactivityPK);
            if(systemactivity!=null) {
                result = JSONSystemactivity.toJSON(systemactivity).toJSONString();
            }
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
        return result;
    }

    //@WebMethod(operationName = "insertSystemactivity")
    @Override
    public void insertSystemactivity(String json) {
        BLsystemactivity blsystemactivity = new BLsystemactivity();
        JSONParser parser = new JSONParser();
        try {
            ISystemactivity systemactivity = JSONSystemactivity.toSystemactivity((JSONObject)parser.parse(json));
            blsystemactivity.insertSystemactivity(systemactivity);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "updateSystemactivity")
    @Override
    public void updateSystemactivity(String json) {
        BLsystemactivity blsystemactivity = new BLsystemactivity();
        JSONParser parser = new JSONParser();
        try {
            ISystemactivity systemactivity = JSONSystemactivity.toSystemactivity((JSONObject)parser.parse(json));
            blsystemactivity.updateSystemactivity(systemactivity);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "deleteSystemactivity")
    @Override
    public void deleteSystemactivity(String json) {
        BLsystemactivity blsystemactivity = new BLsystemactivity();
        JSONParser parser = new JSONParser();
        try {
            ISystemactivity systemactivity = JSONSystemactivity.toSystemactivity((JSONObject)parser.parse(json));
            blsystemactivity.deleteSystemactivity(systemactivity);
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "getSystemactivitys4system")
    @Override
    public String getSystemactivitys4system(String json) {
        BLsystemactivity blsystemactivity = new BLsystemactivity();
        JSONParser parser = new JSONParser();
        Systemactivity systemactivity;
        try {
            ISystemPK systemPK = JSONSystem.toSystemPK((JSONObject)parser.parse(json));
            ArrayList systemactivitys = blsystemactivity.getSystemactivitys4system(systemPK);
            JSONArray jsonsystemactivitys = toJSONArray(systemactivitys);
            return jsonsystemactivitys.toJSONString();
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

    //@WebMethod(operationName = "delete4system")
    @Override
    public void delete4system(String json) {
        BLsystemactivity blsystemactivity = new BLsystemactivity();
        JSONParser parser = new JSONParser();
        Systemactivity systemactivity;
        try {
            ISystemPK systemPK = JSONSystem.toSystemPK((JSONObject)parser.parse(json));
            blsystemactivity.delete4system(systemPK);
        }
        catch(ParseException e) {
        }
    }


}

