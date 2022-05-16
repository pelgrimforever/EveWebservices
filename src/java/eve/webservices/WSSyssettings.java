/*
 * WSSyssettings.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 11.4.2022 9:13
 *
 */

package eve.webservices;

import eve.BusinessObject.Logic.*;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.webservice.WSISyssettings;
import eve.logicentity.Syssettings;
import eve.searchentity.Syssettingssearch;
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
@WebService(endpointInterface = "eve.interfaces.webservice.WSISyssettings")
public class WSSyssettings implements WSISyssettings {

    private JSONArray toJSONArray(ArrayList syssettingss) {
        JSONArray jsonsyssettingss = new JSONArray();
        Iterator syssettingssI = syssettingss.iterator();
        while(syssettingssI.hasNext()) {
            jsonsyssettingss.add(JSONSyssettings.toJSON((Syssettings)syssettingssI.next()));
        }
        return jsonsyssettingss;
    }

    /**
     * Web service operation
     */
    //@WebMethod(operationName = "getSyssettingss")
    @Override
    public String getSyssettingss() {
        try {
            BLsyssettings blsyssettings = new BLsyssettings();
            ArrayList syssettingss = blsyssettings.getAll();
            JSONArray jsonsyssettingss = toJSONArray(syssettingss);
            return jsonsyssettingss.toJSONString();
        }
        catch(DBException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "search")
    @Override
    public String search(String json) {
        BLsyssettings blsyssettings = new BLsyssettings();
        JSONParser parser = new JSONParser();
        String result = "";
        Syssettings syssettings;
        try {
            Syssettingssearch syssettingssearch = JSONSyssettings.toSyssettingssearch((JSONObject)parser.parse(json));
            ArrayList syssettingss = blsyssettings.search(syssettingssearch);
            JSONArray jsonsyssettingss = toJSONArray(syssettingss);
            result = jsonsyssettingss.toJSONString();
        }
        catch(ParseException e) {
            result = "";
        }
        catch(DBException e) {
            result = "";
        }
        return result;
    }

    //@WebMethod(operationName = "getSyssettings")
    @Override
    public String getSyssettings(String json) {
        BLsyssettings blsyssettings = new BLsyssettings();
        JSONParser parser = new JSONParser();
        String result = "";
        Syssettings syssettings;
        try {
            SyssettingsPK syssettingsPK = JSONSyssettings.toSyssettingsPK((JSONObject)parser.parse(json));
            syssettings = blsyssettings.getSyssettings(syssettingsPK);
            if(syssettings!=null) {
                result = JSONSyssettings.toJSON(syssettings).toJSONString();
            }
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
        return result;
    }

    //@WebMethod(operationName = "insertSyssettings")
    @Override
    public void insertSyssettings(String json) {
        BLsyssettings blsyssettings = new BLsyssettings();
        JSONParser parser = new JSONParser();
        try {
            ISyssettings syssettings = JSONSyssettings.toSyssettings((JSONObject)parser.parse(json));
            blsyssettings.insertSyssettings(syssettings);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "updateSyssettings")
    @Override
    public void updateSyssettings(String json) {
        BLsyssettings blsyssettings = new BLsyssettings();
        JSONParser parser = new JSONParser();
        try {
            ISyssettings syssettings = JSONSyssettings.toSyssettings((JSONObject)parser.parse(json));
            blsyssettings.updateSyssettings(syssettings);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "deleteSyssettings")
    @Override
    public void deleteSyssettings(String json) {
        BLsyssettings blsyssettings = new BLsyssettings();
        JSONParser parser = new JSONParser();
        try {
            ISyssettings syssettings = JSONSyssettings.toSyssettings((JSONObject)parser.parse(json));
            blsyssettings.deleteSyssettings(syssettings);
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
    }


}

