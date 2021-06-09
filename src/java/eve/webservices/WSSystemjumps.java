package eve.webservices;

import eve.BusinessObject.Logic.*;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.webservice.WSISystemjumps;
import eve.logicentity.Systemjumps;
import eve.searchentity.Systemjumpssearch;
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
@WebService(endpointInterface = "eve.interfaces.webservice.WSISystemjumps")
public class WSSystemjumps implements WSISystemjumps {

    private JSONArray toJSONArray(ArrayList systemjumpss) {
        JSONArray jsonsystemjumpss = new JSONArray();
        Iterator systemjumpssI = systemjumpss.iterator();
        while(systemjumpssI.hasNext()) {
            jsonsystemjumpss.add(JSONSystemjumps.toJSON((Systemjumps)systemjumpssI.next()));
        }
        return jsonsystemjumpss;
    }

    /**
     * Web service operation
     */
    //@WebMethod(operationName = "getSystemjumpss")
    @Override
    public String getSystemjumpss() {
        try {
            BLsystemjumps blsystemjumps = new BLsystemjumps();
            ArrayList systemjumpss = blsystemjumps.getAll();
            JSONArray jsonsystemjumpss = toJSONArray(systemjumpss);
            return jsonsystemjumpss.toJSONString();
        }
        catch(DBException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "search")
    @Override
    public String search(String json) {
        BLsystemjumps blsystemjumps = new BLsystemjumps();
        JSONParser parser = new JSONParser();
        String result = "";
        Systemjumps systemjumps;
        try {
            Systemjumpssearch systemjumpssearch = JSONSystemjumps.toSystemjumpssearch((JSONObject)parser.parse(json));
            ArrayList systemjumpss = blsystemjumps.search(systemjumpssearch);
            JSONArray jsonsystemjumpss = toJSONArray(systemjumpss);
            result = jsonsystemjumpss.toJSONString();
        }
        catch(ParseException e) {
            result = "";
        }
        catch(DBException e) {
            result = "";
        }
        return result;
    }

    //@WebMethod(operationName = "getSystemjumps")
    @Override
    public String getSystemjumps(String json) {
        BLsystemjumps blsystemjumps = new BLsystemjumps();
        JSONParser parser = new JSONParser();
        String result = "";
        Systemjumps systemjumps;
        try {
            SystemjumpsPK systemjumpsPK = JSONSystemjumps.toSystemjumpsPK((JSONObject)parser.parse(json));
            systemjumps = blsystemjumps.getSystemjumps(systemjumpsPK);
            if(systemjumps!=null) {
                result = JSONSystemjumps.toJSON(systemjumps).toJSONString();
            }
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
        return result;
    }

    //@WebMethod(operationName = "insertSystemjumps")
    @Override
    public void insertSystemjumps(String json) {
        BLsystemjumps blsystemjumps = new BLsystemjumps();
        JSONParser parser = new JSONParser();
        try {
            ISystemjumps systemjumps = JSONSystemjumps.toSystemjumps((JSONObject)parser.parse(json));
            blsystemjumps.insertSystemjumps(systemjumps);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "updateSystemjumps")
    @Override
    public void updateSystemjumps(String json) {
        BLsystemjumps blsystemjumps = new BLsystemjumps();
        JSONParser parser = new JSONParser();
        try {
            ISystemjumps systemjumps = JSONSystemjumps.toSystemjumps((JSONObject)parser.parse(json));
            blsystemjumps.updateSystemjumps(systemjumps);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "deleteSystemjumps")
    @Override
    public void deleteSystemjumps(String json) {
        BLsystemjumps blsystemjumps = new BLsystemjumps();
        JSONParser parser = new JSONParser();
        try {
            ISystemjumps systemjumps = JSONSystemjumps.toSystemjumps((JSONObject)parser.parse(json));
            blsystemjumps.deleteSystemjumps(systemjumps);
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "getSystemjumpss4systemSystem_end")
    @Override
    public String getSystemjumpss4systemSystem_end(String json) {
        BLsystemjumps blsystemjumps = new BLsystemjumps();
        JSONParser parser = new JSONParser();
        Systemjumps systemjumps;
        try {
            ISystemPK systemSystem_endPK = JSONSystem.toSystemPK((JSONObject)parser.parse(json));
            ArrayList systemjumpss = blsystemjumps.getSystemjumpss4systemSystem_end(systemSystem_endPK);
            JSONArray jsonsystemjumpss = toJSONArray(systemjumpss);
            return jsonsystemjumpss.toJSONString();
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

    //@WebMethod(operationName = "delete4systemSystem_end")
    @Override
    public void delete4systemSystem_end(String json) {
        BLsystemjumps blsystemjumps = new BLsystemjumps();
        JSONParser parser = new JSONParser();
        Systemjumps systemjumps;
        try {
            ISystemPK systemSystem_endPK = JSONSystem.toSystemPK((JSONObject)parser.parse(json));
            blsystemjumps.delete4systemSystem_end(this.getClass().getName(), systemSystem_endPK);
        }
        catch(ParseException e) {
        }
    }

    //@WebMethod(operationName = "getSystemjumpss4systemSystem_start")
    @Override
    public String getSystemjumpss4systemSystem_start(String json) {
        BLsystemjumps blsystemjumps = new BLsystemjumps();
        JSONParser parser = new JSONParser();
        Systemjumps systemjumps;
        try {
            ISystemPK systemSystem_startPK = JSONSystem.toSystemPK((JSONObject)parser.parse(json));
            ArrayList systemjumpss = blsystemjumps.getSystemjumpss4systemSystem_start(systemSystem_startPK);
            JSONArray jsonsystemjumpss = toJSONArray(systemjumpss);
            return jsonsystemjumpss.toJSONString();
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

    //@WebMethod(operationName = "delete4systemSystem_start")
    @Override
    public void delete4systemSystem_start(String json) {
        BLsystemjumps blsystemjumps = new BLsystemjumps();
        JSONParser parser = new JSONParser();
        Systemjumps systemjumps;
        try {
            ISystemPK systemSystem_startPK = JSONSystem.toSystemPK((JSONObject)parser.parse(json));
            blsystemjumps.delete4systemSystem_start(this.getClass().getName(), systemSystem_startPK);
        }
        catch(ParseException e) {
        }
    }


}

