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
import eve.entity.pk.ShipfitPK;
import eve.interfaces.entity.pk.IShipfitPK;
import eve.interfaces.logicentity.IShipfit;
import eve.logicentity.Shipfit;
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
public class JSONShipfit {
    
    public static JSONArray toJSONArray(ArrayList shipfits) {
        JSONArray jsonshipfits = new JSONArray();
        Iterator shipfitsI = shipfits.iterator();
        while(shipfitsI.hasNext()) {
            jsonshipfits.add(toJSON((Shipfit)shipfitsI.next()));
        }
        return jsonshipfits;
    }

    public static JSONObject toJSON(IShipfitPK shipfitPK) {
        JSONObject json = null;
        if(shipfitPK!=null) {
            json = new JSONObject();
            json.put("username", shipfitPK.getUsername());
            json.put("shipname", shipfitPK.getShipname());
        }
        return json;
    }

    public static JSONObject toJSON(IShipfit shipfit) {
        JSONObject json = new JSONObject();
        json.put("PK", toJSON(shipfit.getPrimaryKey()));
        json.put("evetypePK", JSONEvetype.toJSON(shipfit.getEvetypePK()));
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    public static JSONObject toJSON(Shipfitsearch shipfitsearch) {
        JSONObject json = new JSONObject();
        if(shipfitsearch.used()) {
            byte andoroperator = shipfitsearch.getAndoroperator();
            int maxresults = shipfitsearch.getMaxresults();
            boolean docount = shipfitsearch.getDocount();
            Iterator<EntityPK> primarykeysI = shipfitsearch.getPrimarykeys().iterator();
            Iterator<Fieldsearcher> fieldsearchersI = shipfitsearch.getFieldsearchers().iterator();
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
            if(shipfitsearch.getEvetypesearch()!=null && shipfitsearch.getEvetypesearch().used()) {
                kss.put("evetypesearcher", JSONEvetype.toJSON((Evetypesearch)shipfitsearch.getEvetypesearch()));
            }
            if(shipfitsearch.getShipfitmodulesearch()!=null && shipfitsearch.getShipfitmodulesearch().used()) {
                kss.put("shipfitmodulesearcher", JSONShipfitmodule.toJSON((Shipfitmodulesearch)shipfitsearch.getShipfitmodulesearch()));
            }
            if(shipfitsearch.getShipfitordersearch()!=null && shipfitsearch.getShipfitordersearch().used()) {
                kss.put("shipfitordersearcher", JSONShipfitorder.toJSON((Shipfitordersearch)shipfitsearch.getShipfitordersearch()));
            }
            json.put("keysearch", kss);
        }
        return json;
    }

    public static Shipfitsearch toShipfitsearch(JSONObject json) {
        Shipfitsearch shipfitsearch = new Shipfitsearch();
        shipfitsearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        shipfitsearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        shipfitsearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONArray pks = (JSONArray)json.get("primarykeys");
        for(int i=0; i<pks.size(); i++) {
            shipfitsearch.addPrimarykey(ShipfitPK.getKey((String)pks.get(i)));
        }
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("username");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            shipfitsearch.username(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("shipname");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            shipfitsearch.shipname(valuearray, compareoperator, andor);
        }
        JSONObject kss = (JSONObject)json.get("keysearch");
        JSONArray keysearch;
        keysearch = (JSONArray)kss.get("evetypesearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Evetypesearch evetypesearch = JSONEvetype.toEvetypesearch((JSONObject)keysearch.get(i));
                shipfitsearch.evetype(evetypesearch);
            }
        }
        keysearch = (JSONArray)kss.get("shipfitmodulesearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Shipfitmodulesearch shipfitmodulesearch = JSONShipfitmodule.toShipfitmodulesearch((JSONObject)keysearch.get(i));
                shipfitsearch.shipfitmodule(shipfitmodulesearch);
            }
        }
        keysearch = (JSONArray)kss.get("shipfitordersearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Shipfitordersearch shipfitordersearch = JSONShipfitorder.toShipfitordersearch((JSONObject)keysearch.get(i));
                shipfitsearch.shipfitorder(shipfitordersearch);
            }
        }
        return shipfitsearch;
    }
    
    public static ShipfitPK toShipfitPK(JSONObject json) {
        ShipfitPK shipfitPK = null;
        if(json!=null) {
            shipfitPK = new ShipfitPK(JSONConversion.getString(json, "username"), JSONConversion.getString(json, "shipname"));
        }
        return shipfitPK;
    }

    public static Shipfit toShipfit(JSONObject json) {
        Shipfit shipfit = new Shipfit(toShipfitPK((JSONObject)json.get("PK")));
        updateShipfit(shipfit, json);
        return shipfit;
    }

    public static void updateShipfit(IShipfit shipfit, JSONObject json) {
        shipfit.setEvetypePK(JSONEvetype.toEvetypePK((JSONObject)json.get("evetypePK")));
    }

    public static Shipfit initShipfit(JSONObject json) {
        Shipfit shipfit = new Shipfit(toShipfitPK((JSONObject)json.get("PK")));
        shipfit.initEvetypePK(JSONEvetype.toEvetypePK((JSONObject)json.get("evetypePK")));
        return shipfit;
    }
}

