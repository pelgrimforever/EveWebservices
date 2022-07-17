/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 17.6.2022 13:4
 */
 
package eve.conversion.json;

import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.interfaces.db.EntityPK;
import data.interfaces.db.Fieldsearcher;
import data.json.piJson;
import eve.entity.pk.ShipfitorderPK;
import eve.interfaces.entity.pk.IShipfitorderPK;
import eve.interfaces.logicentity.IShipfitorder;
import eve.logicentity.Shipfitorder;
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
public class JSONShipfitorder {
    
    public static JSONArray toJSONArray(ArrayList shipfitorders) {
        JSONArray jsonshipfitorders = new JSONArray();
        Iterator shipfitordersI = shipfitorders.iterator();
        while(shipfitordersI.hasNext()) {
            jsonshipfitorders.add(toJSON((Shipfitorder)shipfitordersI.next()));
        }
        return jsonshipfitorders;
    }

    public static JSONObject toJSON(IShipfitorderPK shipfitorderPK) {
        JSONObject json = null;
        if(shipfitorderPK!=null) {
            json = new JSONObject();
            json.put("username", shipfitorderPK.getUsername());
            json.put("shipname", shipfitorderPK.getShipname());
            json.put("evetype", String.valueOf(shipfitorderPK.getEvetype()));
        }
        return json;
    }

    public static JSONObject toJSON(IShipfitorder shipfitorder) {
        JSONObject json = new JSONObject();
        json.put("PK", toJSON(shipfitorder.getPrimaryKey()));
        json.put("amountwanted", shipfitorder.getAmountwanted());
        json.put("amountinstock", shipfitorder.getAmountinstock());
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    public static JSONObject toJSON(Shipfitordersearch shipfitordersearch) {
        JSONObject json = new JSONObject();
        if(shipfitordersearch.used()) {
            byte andoroperator = shipfitordersearch.getAndoroperator();
            int maxresults = shipfitordersearch.getMaxresults();
            boolean docount = shipfitordersearch.getDocount();
            Iterator<EntityPK> primarykeysI = shipfitordersearch.getPrimarykeys().iterator();
            Iterator<Fieldsearcher> fieldsearchersI = shipfitordersearch.getFieldsearchers().iterator();
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
            if(shipfitordersearch.getShipfitsearch()!=null && shipfitordersearch.getShipfitsearch().used()) {
                kss.put("shipfitsearcher", JSONShipfit.toJSON((Shipfitsearch)shipfitordersearch.getShipfitsearch()));
            }
            if(shipfitordersearch.getEvetypesearch()!=null && shipfitordersearch.getEvetypesearch().used()) {
                kss.put("evetypesearcher", JSONEvetype.toJSON((Evetypesearch)shipfitordersearch.getEvetypesearch()));
            }
            if(shipfitordersearch.getShipfitorderselectedsearch()!=null && shipfitordersearch.getShipfitorderselectedsearch().used()) {
                kss.put("shipfitorderselectedsearcher", JSONShipfitorderselected.toJSON((Shipfitorderselectedsearch)shipfitordersearch.getShipfitorderselectedsearch()));
            }
            if(shipfitordersearch.getRelOrderssearch()!=null && shipfitordersearch.getRelOrderssearch().used()) {
                kss.put("orderssearcher", JSONShipfitorderselected.toJSON((Shipfitorderselectedsearch)shipfitordersearch.getRelOrderssearch()));
            }
            json.put("keysearch", kss);
        }
        return json;
    }

    public static Shipfitordersearch toShipfitordersearch(JSONObject json) {
        Shipfitordersearch shipfitordersearch = new Shipfitordersearch();
        shipfitordersearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        shipfitordersearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        shipfitordersearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONArray pks = (JSONArray)json.get("primarykeys");
        for(int i=0; i<pks.size(); i++) {
            shipfitordersearch.addPrimarykey(ShipfitorderPK.getKey((String)pks.get(i)));
        }
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("amountwanted");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            shipfitordersearch.amountwanted(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("amountinstock");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            shipfitordersearch.amountinstock(valuearray, operators, andor);
        }
        JSONObject kss = (JSONObject)json.get("keysearch");
        JSONArray keysearch;
        keysearch = (JSONArray)kss.get("shipfitsearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Shipfitsearch shipfitsearch = JSONShipfit.toShipfitsearch((JSONObject)keysearch.get(i));
                shipfitordersearch.shipfit(shipfitsearch);
            }
        }
        keysearch = (JSONArray)kss.get("evetypesearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Evetypesearch evetypesearch = JSONEvetype.toEvetypesearch((JSONObject)keysearch.get(i));
                shipfitordersearch.evetype(evetypesearch);
            }
        }
        keysearch = (JSONArray)kss.get("shipfitorderselectedsearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Shipfitorderselectedsearch shipfitorderselectedsearch = JSONShipfitorderselected.toShipfitorderselectedsearch((JSONObject)keysearch.get(i));
                shipfitordersearch.shipfitorderselected(shipfitorderselectedsearch);
            }
        }
        keysearch = (JSONArray)kss.get("orderssearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Orderssearch orderssearch = JSONOrders.toOrderssearch((JSONObject)keysearch.get(i));
                shipfitordersearch.relorders(orderssearch);
            }
        }
        return shipfitordersearch;
    }
    
    public static ShipfitorderPK toShipfitorderPK(JSONObject json) {
        ShipfitorderPK shipfitorderPK = null;
        if(json!=null) {
            shipfitorderPK = new ShipfitorderPK(JSONConversion.getString(json, "username"), JSONConversion.getString(json, "shipname"), JSONConversion.getlong(json, "evetype"));
        }
        return shipfitorderPK;
    }

    public static Shipfitorder toShipfitorder(JSONObject json) {
        Shipfitorder shipfitorder = new Shipfitorder(toShipfitorderPK((JSONObject)json.get("PK")));
        updateShipfitorder(shipfitorder, json);
        return shipfitorder;
    }

    public static void updateShipfitorder(IShipfitorder shipfitorder, JSONObject json) {
        shipfitorder.setAmountwanted(JSONConversion.getint(json, "amountwanted"));
        shipfitorder.setAmountinstock(JSONConversion.getint(json, "amountinstock"));
    }

    public static Shipfitorder initShipfitorder(JSONObject json) {
        Shipfitorder shipfitorder = new Shipfitorder(toShipfitorderPK((JSONObject)json.get("PK")));
        shipfitorder.initAmountwanted(JSONConversion.getint(json, "amountwanted"));
        shipfitorder.initAmountinstock(JSONConversion.getint(json, "amountinstock"));
        return shipfitorder;
    }
}

