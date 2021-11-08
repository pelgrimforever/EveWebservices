/*
 * JSONOrder_history.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 8.10.2021 7:21
 *
 */
 
package eve.conversion.json;

import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.interfaces.db.EntityPK;
import data.interfaces.db.Fieldsearcher;
import data.json.piJson;
import eve.entity.pk.Order_historyPK;
import eve.interfaces.entity.pk.IOrder_historyPK;
import eve.interfaces.logicentity.IOrder_history;
import eve.logicentity.Order_history;
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
public class JSONOrder_history {
    
    public static JSONArray toJSONArray(ArrayList order_historys) {
        JSONArray jsonorder_historys = new JSONArray();
        Iterator order_historysI = order_historys.iterator();
        while(order_historysI.hasNext()) {
            jsonorder_historys.add(toJSON((Order_history)order_historysI.next()));
        }
        return jsonorder_historys;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(IOrder_historyPK order_historyPK) {
        JSONObject json = null;
        if(order_historyPK!=null) {
            json = new JSONObject();
            json.put("region", String.valueOf(order_historyPK.getRegion()));
            json.put("evetype", String.valueOf(order_historyPK.getEvetype()));
            if(order_historyPK.getDate()!=null) {
                json.put("date", order_historyPK.getDate().getTime());
            }
        }
        return json;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(IOrder_history order_history) {
        JSONObject json = new JSONObject();
        json.put("PK", toJSON(order_history.getPrimaryKey()));
        json.put("average", order_history.getAverage());
        json.put("highest", order_history.getHighest());
        json.put("lowest", order_history.getLowest());
        json.put("volume", order_history.getVolume());
        json.put("order_count", order_history.getOrder_count());
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(Order_historysearch order_historysearch) {
        JSONObject json = new JSONObject();
        if(order_historysearch.used()) {
            byte andoroperator = order_historysearch.getAndoroperator();
            int maxresults = order_historysearch.getMaxresults();
            boolean docount = order_historysearch.getDocount();
            Iterator<EntityPK> primarykeysI = order_historysearch.getPrimarykeys().iterator();
            Iterator<Fieldsearcher> fieldsearchersI = order_historysearch.getFieldsearchers().iterator();
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
            if(order_historysearch.getEvetypesearch()!=null && order_historysearch.getEvetypesearch().used()) {
                kss.put("evetypesearcher", JSONEvetype.toJSON((Evetypesearch)order_historysearch.getEvetypesearch()));
            }
            if(order_historysearch.getRegionsearch()!=null && order_historysearch.getRegionsearch().used()) {
                kss.put("regionsearcher", JSONRegion.toJSON((Regionsearch)order_historysearch.getRegionsearch()));
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
    public static Order_historysearch toOrder_historysearch(JSONObject json) {
        Order_historysearch order_historysearch = new Order_historysearch();
        order_historysearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        order_historysearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        order_historysearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONArray pks = (JSONArray)json.get("primarykeys");
        for(int i=0; i<pks.size(); i++) {
            order_historysearch.addPrimarykey(Order_historyPK.getKey((String)pks.get(i)));
        }
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("date");
        if(field!=null) {
            Date[] valuearray = JSONConversion.getDatevalues(field);
            byte[] operators = JSONConversion.getDateoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            order_historysearch.date(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("average");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            order_historysearch.average(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("highest");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            order_historysearch.highest(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("lowest");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            order_historysearch.lowest(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("volume");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            order_historysearch.volume(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("order_count");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            order_historysearch.order_count(valuearray, operators, andor);
        }
        JSONObject kss = (JSONObject)json.get("keysearch");
        JSONArray keysearch;
        keysearch = (JSONArray)kss.get("evetypesearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Evetypesearch evetypesearch = JSONEvetype.toEvetypesearch((JSONObject)keysearch.get(i));
                order_historysearch.evetype(evetypesearch);
            }
        }
        keysearch = (JSONArray)kss.get("regionsearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Regionsearch regionsearch = JSONRegion.toRegionsearch((JSONObject)keysearch.get(i));
                order_historysearch.region(regionsearch);
            }
        }
        return order_historysearch;
    }
    
    public static Order_historyPK toOrder_historyPK(JSONObject json) {
        Order_historyPK order_historyPK = null;
        if(json!=null) {
            order_historyPK = new Order_historyPK(JSONConversion.getlong(json, "region"), JSONConversion.getlong(json, "evetype"), JSONConversion.getDate(json, "date"));
        }
        return order_historyPK;
    }

    public static Order_history toOrder_history(JSONObject json) {
        Order_history order_history = new Order_history(toOrder_historyPK((JSONObject)json.get("PK")));
        updateOrder_history(order_history, json);
        return order_history;
    }

    public static void updateOrder_history(IOrder_history order_history, JSONObject json) {
        order_history.setAverage(JSONConversion.getdouble(json, "average"));
        order_history.setHighest(JSONConversion.getdouble(json, "highest"));
        order_history.setLowest(JSONConversion.getdouble(json, "lowest"));
        order_history.setVolume(JSONConversion.getint(json, "volume"));
        order_history.setOrder_count(JSONConversion.getint(json, "order_count"));
    }

    public static Order_history initOrder_history(JSONObject json) {
        Order_history order_history = new Order_history(toOrder_historyPK((JSONObject)json.get("PK")));
        order_history.initAverage(JSONConversion.getdouble(json, "average"));
        order_history.initHighest(JSONConversion.getdouble(json, "highest"));
        order_history.initLowest(JSONConversion.getdouble(json, "lowest"));
        order_history.initVolume(JSONConversion.getint(json, "volume"));
        order_history.initOrder_count(JSONConversion.getint(json, "order_count"));
        return order_history;
    }
}

