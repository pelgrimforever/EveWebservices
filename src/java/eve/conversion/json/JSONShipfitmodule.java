/*
 * JSONShipfitmodule.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 17.11.2021 15:34
 *
 */
 
package eve.conversion.json;

import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.interfaces.db.EntityPK;
import data.interfaces.db.Fieldsearcher;
import data.json.piJson;
import eve.entity.pk.ShipfitmodulePK;
import eve.interfaces.entity.pk.IShipfitmodulePK;
import eve.interfaces.logicentity.IShipfitmodule;
import eve.logicentity.Shipfitmodule;
import eve.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * JSON fields are by default ignored
 * @author Franky Laseure
 */
public class JSONShipfitmodule {
    
    public static JSONArray toJSONArray(ArrayList shipfitmodules) {
        JSONArray jsonshipfitmodules = new JSONArray();
        Iterator shipfitmodulesI = shipfitmodules.iterator();
        while(shipfitmodulesI.hasNext()) {
            jsonshipfitmodules.add(toJSON((Shipfitmodule)shipfitmodulesI.next()));
        }
        return jsonshipfitmodules;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(IShipfitmodulePK shipfitmodulePK) {
        JSONObject json = null;
        if(shipfitmodulePK!=null) {
            json = new JSONObject();
            json.put("username", shipfitmodulePK.getUsername());
            json.put("shipname", shipfitmodulePK.getShipname());
            json.put("moduletype", String.valueOf(shipfitmodulePK.getModuletype()));
        }
        return json;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(IShipfitmodule shipfitmodule) {
        JSONObject json = new JSONObject();
        json.put("PK", toJSON(shipfitmodule.getPrimaryKey()));
        json.put("amount", shipfitmodule.getAmount());
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(Shipfitmodulesearch shipfitmodulesearch) {
        JSONObject json = new JSONObject();
        if(shipfitmodulesearch.used()) {
            byte andoroperator = shipfitmodulesearch.getAndoroperator();
            int maxresults = shipfitmodulesearch.getMaxresults();
            boolean docount = shipfitmodulesearch.getDocount();
            Iterator<EntityPK> primarykeysI = shipfitmodulesearch.getPrimarykeys().iterator();
            Iterator<Fieldsearcher> fieldsearchersI = shipfitmodulesearch.getFieldsearchers().iterator();
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
            if(shipfitmodulesearch.getEvetypesearch()!=null && shipfitmodulesearch.getEvetypesearch().used()) {
                kss.put("evetypesearcher", JSONEvetype.toJSON((Evetypesearch)shipfitmodulesearch.getEvetypesearch()));
            }
            if(shipfitmodulesearch.getShipfitsearch()!=null && shipfitmodulesearch.getShipfitsearch().used()) {
                kss.put("shipfitsearcher", JSONShipfit.toJSON((Shipfitsearch)shipfitmodulesearch.getShipfitsearch()));
            }
            json.put("keysearch", kss);
        }
        return json;
    }

    /**
     * 
     * @param json: JSONObject with the Filmsearch parameters
     * @return 
     */
    public static Shipfitmodulesearch toShipfitmodulesearch(JSONObject json) {
        Shipfitmodulesearch shipfitmodulesearch = new Shipfitmodulesearch();
        shipfitmodulesearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        shipfitmodulesearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        shipfitmodulesearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONArray pks = (JSONArray)json.get("primarykeys");
        for(int i=0; i<pks.size(); i++) {
            shipfitmodulesearch.addPrimarykey(ShipfitmodulePK.getKey((String)pks.get(i)));
        }
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("amount");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            shipfitmodulesearch.amount(valuearray, operators, andor);
        }
        JSONObject kss = (JSONObject)json.get("keysearch");
        JSONArray keysearch;
        keysearch = (JSONArray)kss.get("evetypesearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Evetypesearch evetypesearch = JSONEvetype.toEvetypesearch((JSONObject)keysearch.get(i));
                shipfitmodulesearch.evetype(evetypesearch);
            }
        }
        keysearch = (JSONArray)kss.get("shipfitsearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Shipfitsearch shipfitsearch = JSONShipfit.toShipfitsearch((JSONObject)keysearch.get(i));
                shipfitmodulesearch.shipfit(shipfitsearch);
            }
        }
        return shipfitmodulesearch;
    }
    
    public static ShipfitmodulePK toShipfitmodulePK(JSONObject json) {
        ShipfitmodulePK shipfitmodulePK = null;
        if(json!=null) {
            shipfitmodulePK = new ShipfitmodulePK(JSONConversion.getString(json, "username"), JSONConversion.getString(json, "shipname"), JSONConversion.getlong(json, "moduletype"));
        }
        return shipfitmodulePK;
    }

    public static Shipfitmodule toShipfitmodule(JSONObject json) {
        Shipfitmodule shipfitmodule = new Shipfitmodule(toShipfitmodulePK((JSONObject)json.get("PK")));
        updateShipfitmodule(shipfitmodule, json);
        return shipfitmodule;
    }

    public static void updateShipfitmodule(IShipfitmodule shipfitmodule, JSONObject json) {
        shipfitmodule.setAmount(JSONConversion.getint(json, "amount"));
    }

    public static Shipfitmodule initShipfitmodule(JSONObject json) {
        Shipfitmodule shipfitmodule = new Shipfitmodule(toShipfitmodulePK((JSONObject)json.get("PK")));
        shipfitmodule.initAmount(JSONConversion.getint(json, "amount"));
        return shipfitmodule;
    }
}

