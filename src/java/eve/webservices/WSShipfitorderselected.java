/*
 * WSShipfitorderselected.java
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
import eve.interfaces.webservice.WSIShipfitorderselected;
import eve.logicentity.Shipfitorderselected;
import eve.searchentity.Shipfitorderselectedsearch;
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
@WebService(endpointInterface = "eve.interfaces.webservice.WSIShipfitorderselected")
public class WSShipfitorderselected implements WSIShipfitorderselected {

    private JSONArray toJSONArray(ArrayList shipfitorderselecteds) {
        JSONArray jsonshipfitorderselecteds = new JSONArray();
        Iterator shipfitorderselectedsI = shipfitorderselecteds.iterator();
        while(shipfitorderselectedsI.hasNext()) {
            jsonshipfitorderselecteds.add(JSONShipfitorderselected.toJSON((Shipfitorderselected)shipfitorderselectedsI.next()));
        }
        return jsonshipfitorderselecteds;
    }

    /**
     * Web service operation
     */
    //@WebMethod(operationName = "getShipfitorderselecteds")
    @Override
    public String getShipfitorderselecteds() {
        try {
            BLshipfitorderselected blshipfitorderselected = new BLshipfitorderselected();
            ArrayList shipfitorderselecteds = blshipfitorderselected.getAll();
            JSONArray jsonshipfitorderselecteds = toJSONArray(shipfitorderselecteds);
            return jsonshipfitorderselecteds.toJSONString();
        }
        catch(DBException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "search")
    @Override
    public String search(String json) {
        BLshipfitorderselected blshipfitorderselected = new BLshipfitorderselected();
        JSONParser parser = new JSONParser();
        String result = "";
        Shipfitorderselected shipfitorderselected;
        try {
            Shipfitorderselectedsearch shipfitorderselectedsearch = JSONShipfitorderselected.toShipfitorderselectedsearch((JSONObject)parser.parse(json));
            ArrayList shipfitorderselecteds = blshipfitorderselected.search(shipfitorderselectedsearch);
            JSONArray jsonshipfitorderselecteds = toJSONArray(shipfitorderselecteds);
            result = jsonshipfitorderselecteds.toJSONString();
        }
        catch(ParseException e) {
            result = "";
        }
        catch(DBException e) {
            result = "";
        }
        return result;
    }

    //@WebMethod(operationName = "getShipfitorderselected")
    @Override
    public String getShipfitorderselected(String json) {
        BLshipfitorderselected blshipfitorderselected = new BLshipfitorderselected();
        JSONParser parser = new JSONParser();
        String result = "";
        Shipfitorderselected shipfitorderselected;
        try {
            ShipfitorderselectedPK shipfitorderselectedPK = JSONShipfitorderselected.toShipfitorderselectedPK((JSONObject)parser.parse(json));
            shipfitorderselected = blshipfitorderselected.getShipfitorderselected(shipfitorderselectedPK);
            if(shipfitorderselected!=null) {
                result = JSONShipfitorderselected.toJSON(shipfitorderselected).toJSONString();
            }
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
        return result;
    }

    //@WebMethod(operationName = "insertShipfitorderselected")
    @Override
    public void insertShipfitorderselected(String json) {
        BLshipfitorderselected blshipfitorderselected = new BLshipfitorderselected();
        JSONParser parser = new JSONParser();
        try {
            IShipfitorderselected shipfitorderselected = JSONShipfitorderselected.toShipfitorderselected((JSONObject)parser.parse(json));
            blshipfitorderselected.insertShipfitorderselected(shipfitorderselected);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "updateShipfitorderselected")
    @Override
    public void updateShipfitorderselected(String json) {
        BLshipfitorderselected blshipfitorderselected = new BLshipfitorderselected();
        JSONParser parser = new JSONParser();
        try {
            IShipfitorderselected shipfitorderselected = JSONShipfitorderselected.toShipfitorderselected((JSONObject)parser.parse(json));
            blshipfitorderselected.updateShipfitorderselected(shipfitorderselected);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "deleteShipfitorderselected")
    @Override
    public void deleteShipfitorderselected(String json) {
        BLshipfitorderselected blshipfitorderselected = new BLshipfitorderselected();
        JSONParser parser = new JSONParser();
        try {
            IShipfitorderselected shipfitorderselected = JSONShipfitorderselected.toShipfitorderselected((JSONObject)parser.parse(json));
            blshipfitorderselected.deleteShipfitorderselected(shipfitorderselected);
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "getShipfitorderselecteds4orders")
    @Override
    public String getShipfitorderselecteds4orders(String json) {
        BLshipfitorderselected blshipfitorderselected = new BLshipfitorderselected();
        JSONParser parser = new JSONParser();
        Shipfitorderselected shipfitorderselected;
        try {
            IOrdersPK ordersPK = JSONOrders.toOrdersPK((JSONObject)parser.parse(json));
            ArrayList shipfitorderselecteds = blshipfitorderselected.getShipfitorderselecteds4orders(ordersPK);
            JSONArray jsonshipfitorderselecteds = toJSONArray(shipfitorderselecteds);
            return jsonshipfitorderselecteds.toJSONString();
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

    //@WebMethod(operationName = "delete4orders")
    @Override
    public void delete4orders(String json) {
        BLshipfitorderselected blshipfitorderselected = new BLshipfitorderselected();
        JSONParser parser = new JSONParser();
        Shipfitorderselected shipfitorderselected;
        try {
            IOrdersPK ordersPK = JSONOrders.toOrdersPK((JSONObject)parser.parse(json));
            blshipfitorderselected.delete4orders(ordersPK);
        }
        catch(ParseException e) {
        }
    }

    //@WebMethod(operationName = "getShipfitorderselecteds4shipfitorder")
    @Override
    public String getShipfitorderselecteds4shipfitorder(String json) {
        BLshipfitorderselected blshipfitorderselected = new BLshipfitorderselected();
        JSONParser parser = new JSONParser();
        Shipfitorderselected shipfitorderselected;
        try {
            IShipfitorderPK shipfitorderPK = JSONShipfitorder.toShipfitorderPK((JSONObject)parser.parse(json));
            ArrayList shipfitorderselecteds = blshipfitorderselected.getShipfitorderselecteds4shipfitorder(shipfitorderPK);
            JSONArray jsonshipfitorderselecteds = toJSONArray(shipfitorderselecteds);
            return jsonshipfitorderselecteds.toJSONString();
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

    //@WebMethod(operationName = "delete4shipfitorder")
    @Override
    public void delete4shipfitorder(String json) {
        BLshipfitorderselected blshipfitorderselected = new BLshipfitorderselected();
        JSONParser parser = new JSONParser();
        Shipfitorderselected shipfitorderselected;
        try {
            IShipfitorderPK shipfitorderPK = JSONShipfitorder.toShipfitorderPK((JSONObject)parser.parse(json));
            blshipfitorderselected.delete4shipfitorder(shipfitorderPK);
        }
        catch(ParseException e) {
        }
    }


}

