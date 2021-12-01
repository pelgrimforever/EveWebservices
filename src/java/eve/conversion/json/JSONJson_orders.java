/*
 * JSONJson_orders.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 30.10.2021 10:3
 *
 */
 
package eve.conversion.json;

import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.interfaces.db.EntityPK;
import data.interfaces.db.Fieldsearcher;
import data.json.piJson;
import eve.entity.pk.Json_ordersPK;
import eve.interfaces.entity.pk.IJson_ordersPK;
import eve.interfaces.logicentity.IJson_orders;
import eve.logicentity.Json_orders;
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
public class JSONJson_orders {
    
    public static JSONArray toJSONArray(ArrayList json_orderss) {
        JSONArray jsonjson_orderss = new JSONArray();
        Iterator json_orderssI = json_orderss.iterator();
        while(json_orderssI.hasNext()) {
            jsonjson_orderss.add(toJSON((Json_orders)json_orderssI.next()));
        }
        return jsonjson_orderss;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(IJson_ordersPK json_ordersPK) {
        JSONObject json = null;
        if(json_ordersPK!=null) {
            json = new JSONObject();
            json.put("id", json_ordersPK.getId());
        }
        return json;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(IJson_orders json_orders) {
        JSONObject json = new JSONObject();
        json.put("PK", toJSON(json_orders.getPrimaryKey()));
        if(json_orders.getJson()!=null) {
            json.put("json", "");
        }
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(Json_orderssearch json_orderssearch) {
        JSONObject json = new JSONObject();
        if(json_orderssearch.used()) {
            byte andoroperator = json_orderssearch.getAndoroperator();
            int maxresults = json_orderssearch.getMaxresults();
            boolean docount = json_orderssearch.getDocount();
            Iterator<EntityPK> primarykeysI = json_orderssearch.getPrimarykeys().iterator();
            Iterator<Fieldsearcher> fieldsearchersI = json_orderssearch.getFieldsearchers().iterator();
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
            json.put("keysearch", kss);
        }
        return json;
    }

    /**
     * 
     * @param json: JSONObject with the Filmsearch parameters
     * @return 
     */
    public static Json_orderssearch toJson_orderssearch(JSONObject json) {
        Json_orderssearch json_orderssearch = new Json_orderssearch();
        json_orderssearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        json_orderssearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        json_orderssearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONArray pks = (JSONArray)json.get("primarykeys");
        for(int i=0; i<pks.size(); i++) {
            json_orderssearch.addPrimarykey(Json_ordersPK.getKey((String)pks.get(i)));
        }
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("id");
        if(field!=null) {
            long[] valuearray = JSONConversion.getLongvalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            json_orderssearch.id(valuearray, operators, andor);
        }
        JSONObject kss = (JSONObject)json.get("keysearch");
        JSONArray keysearch;
        return json_orderssearch;
    }
    
    public static Json_ordersPK toJson_ordersPK(JSONObject json) {
        Json_ordersPK json_ordersPK = null;
        if(json!=null) {
            json_ordersPK = new Json_ordersPK(JSONConversion.getint(json, "id"));
        }
        return json_ordersPK;
    }

    public static Json_orders toJson_orders(JSONObject json) {
        Json_orders json_orders = new Json_orders(toJson_ordersPK((JSONObject)json.get("PK")));
        updateJson_orders(json_orders, json);
        return json_orders;
    }

    public static void updateJson_orders(IJson_orders json_orders, JSONObject json) {
    }

    public static Json_orders initJson_orders(JSONObject json) {
        Json_orders json_orders = new Json_orders(toJson_ordersPK((JSONObject)json.get("PK")));
        return json_orders;
    }
}

