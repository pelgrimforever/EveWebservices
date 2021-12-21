/*
 * WSShipfitmodule.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 17.11.2021 15:31
 *
 */

package eve.webservices;

import eve.BusinessObject.Logic.*;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.webservice.WSIShipfitmodule;
import eve.logicentity.Shipfitmodule;
import eve.searchentity.Shipfitmodulesearch;
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
@WebService(endpointInterface = "eve.interfaces.webservice.WSIShipfitmodule")
public class WSShipfitmodule implements WSIShipfitmodule {

    private JSONArray toJSONArray(ArrayList shipfitmodules) {
        JSONArray jsonshipfitmodules = new JSONArray();
        Iterator shipfitmodulesI = shipfitmodules.iterator();
        while(shipfitmodulesI.hasNext()) {
            jsonshipfitmodules.add(JSONShipfitmodule.toJSON((Shipfitmodule)shipfitmodulesI.next()));
        }
        return jsonshipfitmodules;
    }

    /**
     * Web service operation
     */
    //@WebMethod(operationName = "getShipfitmodules")
    @Override
    public String getShipfitmodules() {
        try {
            BLshipfitmodule blshipfitmodule = new BLshipfitmodule();
            ArrayList shipfitmodules = blshipfitmodule.getAll();
            JSONArray jsonshipfitmodules = toJSONArray(shipfitmodules);
            return jsonshipfitmodules.toJSONString();
        }
        catch(DBException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "search")
    @Override
    public String search(String json) {
        BLshipfitmodule blshipfitmodule = new BLshipfitmodule();
        JSONParser parser = new JSONParser();
        String result = "";
        Shipfitmodule shipfitmodule;
        try {
            Shipfitmodulesearch shipfitmodulesearch = JSONShipfitmodule.toShipfitmodulesearch((JSONObject)parser.parse(json));
            ArrayList shipfitmodules = blshipfitmodule.search(shipfitmodulesearch);
            JSONArray jsonshipfitmodules = toJSONArray(shipfitmodules);
            result = jsonshipfitmodules.toJSONString();
        }
        catch(ParseException e) {
            result = "";
        }
        catch(DBException e) {
            result = "";
        }
        return result;
    }

    //@WebMethod(operationName = "getShipfitmodule")
    @Override
    public String getShipfitmodule(String json) {
        BLshipfitmodule blshipfitmodule = new BLshipfitmodule();
        JSONParser parser = new JSONParser();
        String result = "";
        Shipfitmodule shipfitmodule;
        try {
            ShipfitmodulePK shipfitmodulePK = JSONShipfitmodule.toShipfitmodulePK((JSONObject)parser.parse(json));
            shipfitmodule = blshipfitmodule.getShipfitmodule(shipfitmodulePK);
            if(shipfitmodule!=null) {
                result = JSONShipfitmodule.toJSON(shipfitmodule).toJSONString();
            }
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
        return result;
    }

    //@WebMethod(operationName = "insertShipfitmodule")
    @Override
    public void insertShipfitmodule(String json) {
        BLshipfitmodule blshipfitmodule = new BLshipfitmodule();
        JSONParser parser = new JSONParser();
        try {
            IShipfitmodule shipfitmodule = JSONShipfitmodule.toShipfitmodule((JSONObject)parser.parse(json));
            blshipfitmodule.insertShipfitmodule(shipfitmodule);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "updateShipfitmodule")
    @Override
    public void updateShipfitmodule(String json) {
        BLshipfitmodule blshipfitmodule = new BLshipfitmodule();
        JSONParser parser = new JSONParser();
        try {
            IShipfitmodule shipfitmodule = JSONShipfitmodule.toShipfitmodule((JSONObject)parser.parse(json));
            blshipfitmodule.updateShipfitmodule(shipfitmodule);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "deleteShipfitmodule")
    @Override
    public void deleteShipfitmodule(String json) {
        BLshipfitmodule blshipfitmodule = new BLshipfitmodule();
        JSONParser parser = new JSONParser();
        try {
            IShipfitmodule shipfitmodule = JSONShipfitmodule.toShipfitmodule((JSONObject)parser.parse(json));
            blshipfitmodule.deleteShipfitmodule(shipfitmodule);
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "getShipfitmodules4evetype")
    @Override
    public String getShipfitmodules4evetype(String json) {
        BLshipfitmodule blshipfitmodule = new BLshipfitmodule();
        JSONParser parser = new JSONParser();
        Shipfitmodule shipfitmodule;
        try {
            IEvetypePK evetypePK = JSONEvetype.toEvetypePK((JSONObject)parser.parse(json));
            ArrayList shipfitmodules = blshipfitmodule.getShipfitmodules4evetype(evetypePK);
            JSONArray jsonshipfitmodules = toJSONArray(shipfitmodules);
            return jsonshipfitmodules.toJSONString();
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

    //@WebMethod(operationName = "delete4evetype")
    @Override
    public void delete4evetype(String json) {
        BLshipfitmodule blshipfitmodule = new BLshipfitmodule();
        JSONParser parser = new JSONParser();
        Shipfitmodule shipfitmodule;
        try {
            IEvetypePK evetypePK = JSONEvetype.toEvetypePK((JSONObject)parser.parse(json));
            blshipfitmodule.delete4evetype(evetypePK);
        }
        catch(ParseException e) {
        }
    }

    //@WebMethod(operationName = "getShipfitmodules4shipfit")
    @Override
    public String getShipfitmodules4shipfit(String json) {
        BLshipfitmodule blshipfitmodule = new BLshipfitmodule();
        JSONParser parser = new JSONParser();
        Shipfitmodule shipfitmodule;
        try {
            IShipfitPK shipfitPK = JSONShipfit.toShipfitPK((JSONObject)parser.parse(json));
            ArrayList shipfitmodules = blshipfitmodule.getShipfitmodules4shipfit(shipfitPK);
            JSONArray jsonshipfitmodules = toJSONArray(shipfitmodules);
            return jsonshipfitmodules.toJSONString();
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

    //@WebMethod(operationName = "delete4shipfit")
    @Override
    public void delete4shipfit(String json) {
        BLshipfitmodule blshipfitmodule = new BLshipfitmodule();
        JSONParser parser = new JSONParser();
        Shipfitmodule shipfitmodule;
        try {
            IShipfitPK shipfitPK = JSONShipfit.toShipfitPK((JSONObject)parser.parse(json));
            blshipfitmodule.delete4shipfit(shipfitPK);
        }
        catch(ParseException e) {
        }
    }


}

