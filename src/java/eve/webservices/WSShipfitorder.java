/*
 * WSShipfitorder.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 20.11.2021 17:22
 *
 */

package eve.webservices;

import eve.BusinessObject.Logic.*;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.webservice.WSIShipfitorder;
import eve.logicentity.Shipfitorder;
import eve.searchentity.Shipfitordersearch;
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
@WebService(endpointInterface = "eve.interfaces.webservice.WSIShipfitorder")
public class WSShipfitorder implements WSIShipfitorder {

    private JSONArray toJSONArray(ArrayList shipfitorders) {
        JSONArray jsonshipfitorders = new JSONArray();
        Iterator shipfitordersI = shipfitorders.iterator();
        while(shipfitordersI.hasNext()) {
            jsonshipfitorders.add(JSONShipfitorder.toJSON((Shipfitorder)shipfitordersI.next()));
        }
        return jsonshipfitorders;
    }

    /**
     * Web service operation
     */
    //@WebMethod(operationName = "getShipfitorders")
    @Override
    public String getShipfitorders() {
        try {
            BLshipfitorder blshipfitorder = new BLshipfitorder();
            ArrayList shipfitorders = blshipfitorder.getAll();
            JSONArray jsonshipfitorders = toJSONArray(shipfitorders);
            return jsonshipfitorders.toJSONString();
        }
        catch(DBException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "search")
    @Override
    public String search(String json) {
        BLshipfitorder blshipfitorder = new BLshipfitorder();
        JSONParser parser = new JSONParser();
        String result = "";
        Shipfitorder shipfitorder;
        try {
            Shipfitordersearch shipfitordersearch = JSONShipfitorder.toShipfitordersearch((JSONObject)parser.parse(json));
            ArrayList shipfitorders = blshipfitorder.search(shipfitordersearch);
            JSONArray jsonshipfitorders = toJSONArray(shipfitorders);
            result = jsonshipfitorders.toJSONString();
        }
        catch(ParseException e) {
            result = "";
        }
        catch(DBException e) {
            result = "";
        }
        return result;
    }

    //@WebMethod(operationName = "getShipfitorder")
    @Override
    public String getShipfitorder(String json) {
        BLshipfitorder blshipfitorder = new BLshipfitorder();
        JSONParser parser = new JSONParser();
        String result = "";
        Shipfitorder shipfitorder;
        try {
            ShipfitorderPK shipfitorderPK = JSONShipfitorder.toShipfitorderPK((JSONObject)parser.parse(json));
            shipfitorder = blshipfitorder.getShipfitorder(shipfitorderPK);
            if(shipfitorder!=null) {
                result = JSONShipfitorder.toJSON(shipfitorder).toJSONString();
            }
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
        return result;
    }

    //@WebMethod(operationName = "insertShipfitorder")
    @Override
    public void insertShipfitorder(String json) {
        BLshipfitorder blshipfitorder = new BLshipfitorder();
        JSONParser parser = new JSONParser();
        try {
            IShipfitorder shipfitorder = JSONShipfitorder.toShipfitorder((JSONObject)parser.parse(json));
            blshipfitorder.insertShipfitorder(shipfitorder);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "updateShipfitorder")
    @Override
    public void updateShipfitorder(String json) {
        BLshipfitorder blshipfitorder = new BLshipfitorder();
        JSONParser parser = new JSONParser();
        try {
            IShipfitorder shipfitorder = JSONShipfitorder.toShipfitorder((JSONObject)parser.parse(json));
            blshipfitorder.updateShipfitorder(shipfitorder);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "deleteShipfitorder")
    @Override
    public void deleteShipfitorder(String json) {
        BLshipfitorder blshipfitorder = new BLshipfitorder();
        JSONParser parser = new JSONParser();
        try {
            IShipfitorder shipfitorder = JSONShipfitorder.toShipfitorder((JSONObject)parser.parse(json));
            blshipfitorder.deleteShipfitorder(shipfitorder);
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "getShipfitorders4shipfit")
    @Override
    public String getShipfitorders4shipfit(String json) {
        BLshipfitorder blshipfitorder = new BLshipfitorder();
        JSONParser parser = new JSONParser();
        Shipfitorder shipfitorder;
        try {
            IShipfitPK shipfitPK = JSONShipfit.toShipfitPK((JSONObject)parser.parse(json));
            ArrayList shipfitorders = blshipfitorder.getShipfitorders4shipfit(shipfitPK);
            JSONArray jsonshipfitorders = toJSONArray(shipfitorders);
            return jsonshipfitorders.toJSONString();
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
        BLshipfitorder blshipfitorder = new BLshipfitorder();
        JSONParser parser = new JSONParser();
        Shipfitorder shipfitorder;
        try {
            IShipfitPK shipfitPK = JSONShipfit.toShipfitPK((JSONObject)parser.parse(json));
            blshipfitorder.delete4shipfit(shipfitPK);
        }
        catch(ParseException e) {
        }
    }

    //@WebMethod(operationName = "getShipfitorders4evetype")
    @Override
    public String getShipfitorders4evetype(String json) {
        BLshipfitorder blshipfitorder = new BLshipfitorder();
        JSONParser parser = new JSONParser();
        Shipfitorder shipfitorder;
        try {
            IEvetypePK evetypePK = JSONEvetype.toEvetypePK((JSONObject)parser.parse(json));
            ArrayList shipfitorders = blshipfitorder.getShipfitorders4evetype(evetypePK);
            JSONArray jsonshipfitorders = toJSONArray(shipfitorders);
            return jsonshipfitorders.toJSONString();
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
        BLshipfitorder blshipfitorder = new BLshipfitorder();
        JSONParser parser = new JSONParser();
        Shipfitorder shipfitorder;
        try {
            IEvetypePK evetypePK = JSONEvetype.toEvetypePK((JSONObject)parser.parse(json));
            blshipfitorder.delete4evetype(evetypePK);
        }
        catch(ParseException e) {
        }
    }

    //@WebMethod(operationName = "getShipfitorders4shipfitorderselected")
    @Override
    public String getShipfitorders4shipfitorderselected(String json) {
        BLshipfitorder blshipfitorder = new BLshipfitorder();
        JSONParser parser = new JSONParser();
        Shipfitorder shipfitorder;
        try {
            String result = null;
            IShipfitorderselectedPK shipfitorderselectedPK = JSONShipfitorderselected.toShipfitorderselectedPK((JSONObject)parser.parse(json));
            shipfitorder = (Shipfitorder)blshipfitorder.getShipfitorderselected(shipfitorderselectedPK);
            if(shipfitorder!=null) {
                result = JSONShipfitorder.toJSON(shipfitorder).toJSONString();
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

