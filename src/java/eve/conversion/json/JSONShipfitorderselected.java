/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 13.6.2022 11:21
 */
 
package eve.conversion.json;

import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.interfaces.db.EntityPK;
import data.interfaces.db.Fieldsearcher;
import data.json.piJson;
import eve.entity.pk.ShipfitorderselectedPK;
import eve.interfaces.entity.pk.IShipfitorderselectedPK;
import eve.interfaces.logicentity.IShipfitorderselected;
import eve.logicentity.Shipfitorderselected;
import eve.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * @author Franky Laseure
 */
public class JSONShipfitorderselected {
    
    public static JSONArray toJSONArray(ArrayList shipfitorderselecteds) {
        JSONArray jsonshipfitorderselecteds = new JSONArray();
        Iterator shipfitorderselectedsI = shipfitorderselecteds.iterator();
        while(shipfitorderselectedsI.hasNext()) {
            jsonshipfitorderselecteds.add(toJSON((Shipfitorderselected)shipfitorderselectedsI.next()));
        }
        return jsonshipfitorderselecteds;
    }

    public static JSONObject toJSON(IShipfitorderselectedPK shipfitorderselectedPK) {
        JSONObject json = null;
        if(shipfitorderselectedPK!=null) {
            json = new JSONObject();
            json.put("username", shipfitorderselectedPK.getUsername());
            json.put("shipname", shipfitorderselectedPK.getShipname());
            json.put("evetype", String.valueOf(shipfitorderselectedPK.getEvetype()));
            json.put("orderid", String.valueOf(shipfitorderselectedPK.getOrderid()));
        }
        return json;
    }

    public static JSONObject toJSON(IShipfitorderselected shipfitorderselected) {
        JSONObject json = new JSONObject();
        json.put("PK", toJSON(shipfitorderselected.getPrimaryKey()));
        json.put("amount", shipfitorderselected.getAmount());
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    public static JSONObject toJSON(Shipfitorderselectedsearch shipfitorderselectedsearch) {
        JSONObject json = new JSONObject();
        if(shipfitorderselectedsearch.used()) {
            byte andoroperator = shipfitorderselectedsearch.getAndoroperator();
            int maxresults = shipfitorderselectedsearch.getMaxresults();
            boolean docount = shipfitorderselectedsearch.getDocount();
            Iterator<EntityPK> primarykeysI = shipfitorderselectedsearch.getPrimarykeys().iterator();
            Iterator<Fieldsearcher> fieldsearchersI = shipfitorderselectedsearch.getFieldsearchers().iterator();
            EntityPK primarykey;
            Fieldsearcher fieldsearcher;
            
            json.put("andor", andoroperator);
            json.put("maxresults", maxresults);
            json.put("docount", docount);
            JSONArray pks = new JSONArray();
            int i = 0;
            while(primarykeysI.hasNext()) {
                primarykey = primarykeysI.next();
                pks.add(primarykey.getKeystring());
            }
            json.put("primarykeys", pks);
            JSONObject fss = new JSONObject();
            while(fieldsearchersI.hasNext()) {
                fieldsearcher = fieldsearchersI.next();
                if(fieldsearcher.used()) {
                    fss.put(fieldsearcher.getShortFieldname(), JSONConversion.toJSON(fieldsearcher));
                }
            }
            json.put("fields", fss);
            JSONObject kss = new JSONObject();
            if(shipfitorderselectedsearch.getOrderssearch()!=null && shipfitorderselectedsearch.getOrderssearch().used()) {
                kss.put("orderssearcher", JSONOrders.toJSON((Orderssearch)shipfitorderselectedsearch.getOrderssearch()));
            }
            if(shipfitorderselectedsearch.getShipfitordersearch()!=null && shipfitorderselectedsearch.getShipfitordersearch().used()) {
                kss.put("shipfitordersearcher", JSONShipfitorder.toJSON((Shipfitordersearch)shipfitorderselectedsearch.getShipfitordersearch()));
            }
            json.put("keysearch", kss);
        }
        return json;
    }

    public static Shipfitorderselectedsearch toShipfitorderselectedsearch(JSONObject json) {
        Shipfitorderselectedsearch shipfitorderselectedsearch = new Shipfitorderselectedsearch();
        shipfitorderselectedsearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        shipfitorderselectedsearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        shipfitorderselectedsearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONArray pks = (JSONArray)json.get("primarykeys");
        for(int i=0; i<pks.size(); i++) {
            shipfitorderselectedsearch.addPrimarykey(ShipfitorderselectedPK.getKey((String)pks.get(i)));
        }
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("amount");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            shipfitorderselectedsearch.amount(valuearray, operators, andor);
        }
        JSONObject kss = (JSONObject)json.get("keysearch");
        JSONArray keysearch;
        keysearch = (JSONArray)kss.get("orderssearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Orderssearch orderssearch = JSONOrders.toOrderssearch((JSONObject)keysearch.get(i));
                shipfitorderselectedsearch.orders(orderssearch);
            }
        }
        keysearch = (JSONArray)kss.get("shipfitordersearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Shipfitordersearch shipfitordersearch = JSONShipfitorder.toShipfitordersearch((JSONObject)keysearch.get(i));
                shipfitorderselectedsearch.shipfitorder(shipfitordersearch);
            }
        }
        return shipfitorderselectedsearch;
    }
    
    public static ShipfitorderselectedPK toShipfitorderselectedPK(JSONObject json) {
        ShipfitorderselectedPK shipfitorderselectedPK = null;
        if(json!=null) {
            shipfitorderselectedPK = new ShipfitorderselectedPK(JSONConversion.getString(json, "username"), JSONConversion.getString(json, "shipname"), JSONConversion.getlong(json, "evetype"), JSONConversion.getlong(json, "orderid"));
        }
        return shipfitorderselectedPK;
    }

    public static Shipfitorderselected toShipfitorderselected(JSONObject json) {
        Shipfitorderselected shipfitorderselected = new Shipfitorderselected(toShipfitorderselectedPK((JSONObject)json.get("PK")));
        updateShipfitorderselected(shipfitorderselected, json);
        return shipfitorderselected;
    }

    public static void updateShipfitorderselected(IShipfitorderselected shipfitorderselected, JSONObject json) {
        shipfitorderselected.setAmount(JSONConversion.getint(json, "amount"));
    }

    public static Shipfitorderselected initShipfitorderselected(JSONObject json) {
        Shipfitorderselected shipfitorderselected = new Shipfitorderselected(toShipfitorderselectedPK((JSONObject)json.get("PK")));
        shipfitorderselected.initAmount(JSONConversion.getint(json, "amount"));
        return shipfitorderselected;
    }
}

