/*
 * WSShipfit.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 14.0.2022 16:56
 *
 */

package eve.webservices;

import eve.BusinessObject.Logic.*;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.webservice.WSIShipfit;
import eve.logicentity.Shipfit;
import eve.searchentity.Shipfitsearch;
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
@WebService(endpointInterface = "eve.interfaces.webservice.WSIShipfit")
public class WSShipfit implements WSIShipfit {

    private JSONArray toJSONArray(ArrayList shipfits) {
        JSONArray jsonshipfits = new JSONArray();
        Iterator shipfitsI = shipfits.iterator();
        while(shipfitsI.hasNext()) {
            jsonshipfits.add(JSONShipfit.toJSON((Shipfit)shipfitsI.next()));
        }
        return jsonshipfits;
    }

    /**
     * Web service operation
     */
    //@WebMethod(operationName = "getShipfits")
    @Override
    public String getShipfits() {
        try {
            BLshipfit blshipfit = new BLshipfit();
            ArrayList shipfits = blshipfit.getAll();
            JSONArray jsonshipfits = toJSONArray(shipfits);
            return jsonshipfits.toJSONString();
        }
        catch(DBException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "search")
    @Override
    public String search(String json) {
        BLshipfit blshipfit = new BLshipfit();
        JSONParser parser = new JSONParser();
        String result = "";
        Shipfit shipfit;
        try {
            Shipfitsearch shipfitsearch = JSONShipfit.toShipfitsearch((JSONObject)parser.parse(json));
            ArrayList shipfits = blshipfit.search(shipfitsearch);
            JSONArray jsonshipfits = toJSONArray(shipfits);
            result = jsonshipfits.toJSONString();
        }
        catch(ParseException e) {
            result = "";
        }
        catch(DBException e) {
            result = "";
        }
        return result;
    }

    //@WebMethod(operationName = "getShipfit")
    @Override
    public String getShipfit(String json) {
        BLshipfit blshipfit = new BLshipfit();
        JSONParser parser = new JSONParser();
        String result = "";
        Shipfit shipfit;
        try {
            ShipfitPK shipfitPK = JSONShipfit.toShipfitPK((JSONObject)parser.parse(json));
            shipfit = blshipfit.getShipfit(shipfitPK);
            if(shipfit!=null) {
                result = JSONShipfit.toJSON(shipfit).toJSONString();
            }
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
        return result;
    }

    //@WebMethod(operationName = "insertShipfit")
    @Override
    public void insertShipfit(String json) {
        BLshipfit blshipfit = new BLshipfit();
        JSONParser parser = new JSONParser();
        try {
            IShipfit shipfit = JSONShipfit.toShipfit((JSONObject)parser.parse(json));
            blshipfit.insertShipfit(shipfit);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "updateShipfit")
    @Override
    public void updateShipfit(String json) {
        BLshipfit blshipfit = new BLshipfit();
        JSONParser parser = new JSONParser();
        try {
            IShipfit shipfit = JSONShipfit.toShipfit((JSONObject)parser.parse(json));
            blshipfit.updateShipfit(shipfit);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "deleteShipfit")
    @Override
    public void deleteShipfit(String json) {
        BLshipfit blshipfit = new BLshipfit();
        JSONParser parser = new JSONParser();
        try {
            IShipfit shipfit = JSONShipfit.toShipfit((JSONObject)parser.parse(json));
            blshipfit.deleteShipfit(shipfit);
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "getShipfits4evetype")
    @Override
    public String getShipfits4evetype(String json) {
        BLshipfit blshipfit = new BLshipfit();
        JSONParser parser = new JSONParser();
        Shipfit shipfit;
        try {
            IEvetypePK evetypePK = JSONEvetype.toEvetypePK((JSONObject)parser.parse(json));
            ArrayList shipfits = blshipfit.getShipfits4evetype(evetypePK);
            JSONArray jsonshipfits = toJSONArray(shipfits);
            return jsonshipfits.toJSONString();
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
        BLshipfit blshipfit = new BLshipfit();
        JSONParser parser = new JSONParser();
        Shipfit shipfit;
        try {
            IEvetypePK evetypePK = JSONEvetype.toEvetypePK((JSONObject)parser.parse(json));
            blshipfit.delete4evetype(evetypePK);
        }
        catch(ParseException e) {
        }
    }

    //@WebMethod(operationName = "getShipfits4shipfitmodule")
    @Override
    public String getShipfits4shipfitmodule(String json) {
        BLshipfit blshipfit = new BLshipfit();
        JSONParser parser = new JSONParser();
        Shipfit shipfit;
        try {
            String result = null;
            IShipfitmodulePK shipfitmodulePK = JSONShipfitmodule.toShipfitmodulePK((JSONObject)parser.parse(json));
            shipfit = (Shipfit)blshipfit.getShipfitmodule(shipfitmodulePK);
            if(shipfit!=null) {
                result = JSONShipfit.toJSON(shipfit).toJSONString();
            }
            return result;
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

    //@WebMethod(operationName = "getShipfits4shipfitorder")
    @Override
    public String getShipfits4shipfitorder(String json) {
        BLshipfit blshipfit = new BLshipfit();
        JSONParser parser = new JSONParser();
        Shipfit shipfit;
        try {
            String result = null;
            IShipfitorderPK shipfitorderPK = JSONShipfitorder.toShipfitorderPK((JSONObject)parser.parse(json));
            shipfit = (Shipfit)blshipfit.getShipfitorder(shipfitorderPK);
            if(shipfit!=null) {
                result = JSONShipfit.toJSON(shipfit).toJSONString();
            }
            return result;
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


}

