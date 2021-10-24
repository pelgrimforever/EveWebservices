/*
 * WSTmp_system_jumps.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 24.9.2021 14:40
 *
 */

package eve.webservices;

import eve.BusinessObject.Logic.*;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.webservice.WSITmp_system_jumps;
import eve.logicentity.Tmp_system_jumps;
import eve.searchentity.Tmp_system_jumpssearch;
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
@WebService(endpointInterface = "eve.interfaces.webservice.WSITmp_system_jumps")
public class WSTmp_system_jumps implements WSITmp_system_jumps {

    private JSONArray toJSONArray(ArrayList tmp_system_jumpss) {
        JSONArray jsontmp_system_jumpss = new JSONArray();
        Iterator tmp_system_jumpssI = tmp_system_jumpss.iterator();
        while(tmp_system_jumpssI.hasNext()) {
            jsontmp_system_jumpss.add(JSONTmp_system_jumps.toJSON((Tmp_system_jumps)tmp_system_jumpssI.next()));
        }
        return jsontmp_system_jumpss;
    }

    /**
     * Web service operation
     */
    //@WebMethod(operationName = "getTmp_system_jumpss")
    @Override
    public String getTmp_system_jumpss() {
        try {
            BLtmp_system_jumps bltmp_system_jumps = new BLtmp_system_jumps();
            ArrayList tmp_system_jumpss = bltmp_system_jumps.getAll();
            JSONArray jsontmp_system_jumpss = toJSONArray(tmp_system_jumpss);
            return jsontmp_system_jumpss.toJSONString();
        }
        catch(DBException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "search")
    @Override
    public String search(String json) {
        BLtmp_system_jumps bltmp_system_jumps = new BLtmp_system_jumps();
        JSONParser parser = new JSONParser();
        String result = "";
        Tmp_system_jumps tmp_system_jumps;
        try {
            Tmp_system_jumpssearch tmp_system_jumpssearch = JSONTmp_system_jumps.toTmp_system_jumpssearch((JSONObject)parser.parse(json));
            ArrayList tmp_system_jumpss = bltmp_system_jumps.search(tmp_system_jumpssearch);
            JSONArray jsontmp_system_jumpss = toJSONArray(tmp_system_jumpss);
            result = jsontmp_system_jumpss.toJSONString();
        }
        catch(ParseException e) {
            result = "";
        }
        catch(DBException e) {
            result = "";
        }
        return result;
    }

    //@WebMethod(operationName = "getTmp_system_jumps")
    @Override
    public String getTmp_system_jumps(String json) {
        BLtmp_system_jumps bltmp_system_jumps = new BLtmp_system_jumps();
        JSONParser parser = new JSONParser();
        String result = "";
        Tmp_system_jumps tmp_system_jumps;
        try {
            Tmp_system_jumpsPK tmp_system_jumpsPK = JSONTmp_system_jumps.toTmp_system_jumpsPK((JSONObject)parser.parse(json));
            tmp_system_jumps = bltmp_system_jumps.getTmp_system_jumps(tmp_system_jumpsPK);
            if(tmp_system_jumps!=null) {
                result = JSONTmp_system_jumps.toJSON(tmp_system_jumps).toJSONString();
            }
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
        return result;
    }

    //@WebMethod(operationName = "insertTmp_system_jumps")
    @Override
    public void insertTmp_system_jumps(String json) {
        BLtmp_system_jumps bltmp_system_jumps = new BLtmp_system_jumps();
        JSONParser parser = new JSONParser();
        try {
            ITmp_system_jumps tmp_system_jumps = JSONTmp_system_jumps.toTmp_system_jumps((JSONObject)parser.parse(json));
            bltmp_system_jumps.insertTmp_system_jumps(tmp_system_jumps);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "updateTmp_system_jumps")
    @Override
    public void updateTmp_system_jumps(String json) {
        BLtmp_system_jumps bltmp_system_jumps = new BLtmp_system_jumps();
        JSONParser parser = new JSONParser();
        try {
            ITmp_system_jumps tmp_system_jumps = JSONTmp_system_jumps.toTmp_system_jumps((JSONObject)parser.parse(json));
            bltmp_system_jumps.updateTmp_system_jumps(tmp_system_jumps);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "deleteTmp_system_jumps")
    @Override
    public void deleteTmp_system_jumps(String json) {
        BLtmp_system_jumps bltmp_system_jumps = new BLtmp_system_jumps();
        JSONParser parser = new JSONParser();
        try {
            ITmp_system_jumps tmp_system_jumps = JSONTmp_system_jumps.toTmp_system_jumps((JSONObject)parser.parse(json));
            bltmp_system_jumps.deleteTmp_system_jumps(tmp_system_jumps);
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
    }


}

