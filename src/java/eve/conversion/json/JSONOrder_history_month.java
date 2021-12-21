/*
 * JSONOrder_history_month.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 16.11.2021 15:46
 *
 */
 
package eve.conversion.json;

import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.interfaces.db.EntityPK;
import data.interfaces.db.Fieldsearcher;
import data.json.piJson;
import eve.entity.pk.Order_history_monthPK;
import eve.interfaces.entity.pk.IOrder_history_monthPK;
import eve.interfaces.logicentity.IOrder_history_month;
import eve.logicentity.Order_history_month;
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
public class JSONOrder_history_month {
    
    public static JSONArray toJSONArray(ArrayList order_history_months) {
        JSONArray jsonorder_history_months = new JSONArray();
        Iterator order_history_monthsI = order_history_months.iterator();
        while(order_history_monthsI.hasNext()) {
            jsonorder_history_months.add(toJSON((Order_history_month)order_history_monthsI.next()));
        }
        return jsonorder_history_months;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(IOrder_history_monthPK order_history_monthPK) {
        JSONObject json = null;
        if(order_history_monthPK!=null) {
            json = new JSONObject();
            json.put("region", String.valueOf(order_history_monthPK.getRegion()));
            json.put("evetype", String.valueOf(order_history_monthPK.getEvetype()));
            json.put("year", order_history_monthPK.getYear());
            json.put("month", order_history_monthPK.getMonth());
        }
        return json;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(IOrder_history_month order_history_month) {
        JSONObject json = new JSONObject();
        json.put("PK", toJSON(order_history_month.getPrimaryKey()));
        json.put("average", order_history_month.getAverage());
        json.put("highest", order_history_month.getHighest());
        json.put("lowest", order_history_month.getLowest());
        json.put("volume", String.valueOf(order_history_month.getVolume()));
        json.put("order_count", String.valueOf(order_history_month.getOrder_count()));
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(Order_history_monthsearch order_history_monthsearch) {
        JSONObject json = new JSONObject();
        if(order_history_monthsearch.used()) {
            byte andoroperator = order_history_monthsearch.getAndoroperator();
            int maxresults = order_history_monthsearch.getMaxresults();
            boolean docount = order_history_monthsearch.getDocount();
            Iterator<EntityPK> primarykeysI = order_history_monthsearch.getPrimarykeys().iterator();
            Iterator<Fieldsearcher> fieldsearchersI = order_history_monthsearch.getFieldsearchers().iterator();
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
            if(order_history_monthsearch.getEvetypesearch()!=null && order_history_monthsearch.getEvetypesearch().used()) {
                kss.put("evetypesearcher", JSONEvetype.toJSON((Evetypesearch)order_history_monthsearch.getEvetypesearch()));
            }
            if(order_history_monthsearch.getRegionsearch()!=null && order_history_monthsearch.getRegionsearch().used()) {
                kss.put("regionsearcher", JSONRegion.toJSON((Regionsearch)order_history_monthsearch.getRegionsearch()));
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
    public static Order_history_monthsearch toOrder_history_monthsearch(JSONObject json) {
        Order_history_monthsearch order_history_monthsearch = new Order_history_monthsearch();
        order_history_monthsearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        order_history_monthsearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        order_history_monthsearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONArray pks = (JSONArray)json.get("primarykeys");
        for(int i=0; i<pks.size(); i++) {
            order_history_monthsearch.addPrimarykey(Order_history_monthPK.getKey((String)pks.get(i)));
        }
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("year");
        if(field!=null) {
            long[] valuearray = JSONConversion.getLongvalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            order_history_monthsearch.year(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("month");
        if(field!=null) {
            long[] valuearray = JSONConversion.getLongvalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            order_history_monthsearch.month(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("average");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            order_history_monthsearch.average(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("highest");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            order_history_monthsearch.highest(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("lowest");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            order_history_monthsearch.lowest(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("volume");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            order_history_monthsearch.volume(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("order_count");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            order_history_monthsearch.order_count(valuearray, operators, andor);
        }
        JSONObject kss = (JSONObject)json.get("keysearch");
        JSONArray keysearch;
        keysearch = (JSONArray)kss.get("evetypesearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Evetypesearch evetypesearch = JSONEvetype.toEvetypesearch((JSONObject)keysearch.get(i));
                order_history_monthsearch.evetype(evetypesearch);
            }
        }
        keysearch = (JSONArray)kss.get("regionsearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Regionsearch regionsearch = JSONRegion.toRegionsearch((JSONObject)keysearch.get(i));
                order_history_monthsearch.region(regionsearch);
            }
        }
        return order_history_monthsearch;
    }
    
    public static Order_history_monthPK toOrder_history_monthPK(JSONObject json) {
        Order_history_monthPK order_history_monthPK = null;
        if(json!=null) {
            order_history_monthPK = new Order_history_monthPK(JSONConversion.getlong(json, "region"), JSONConversion.getlong(json, "evetype"), JSONConversion.getint(json, "year"), JSONConversion.getint(json, "month"));
        }
        return order_history_monthPK;
    }

    public static Order_history_month toOrder_history_month(JSONObject json) {
        Order_history_month order_history_month = new Order_history_month(toOrder_history_monthPK((JSONObject)json.get("PK")));
        updateOrder_history_month(order_history_month, json);
        return order_history_month;
    }

    public static void updateOrder_history_month(IOrder_history_month order_history_month, JSONObject json) {
        order_history_month.setAverage(JSONConversion.getdouble(json, "average"));
        order_history_month.setHighest(JSONConversion.getdouble(json, "highest"));
        order_history_month.setLowest(JSONConversion.getdouble(json, "lowest"));
        order_history_month.setVolume(JSONConversion.getlong(json, "volume"));
        order_history_month.setOrder_count(JSONConversion.getlong(json, "order_count"));
    }

    public static Order_history_month initOrder_history_month(JSONObject json) {
        Order_history_month order_history_month = new Order_history_month(toOrder_history_monthPK((JSONObject)json.get("PK")));
        order_history_month.initAverage(JSONConversion.getdouble(json, "average"));
        order_history_month.initHighest(JSONConversion.getdouble(json, "highest"));
        order_history_month.initLowest(JSONConversion.getdouble(json, "lowest"));
        order_history_month.initVolume(JSONConversion.getlong(json, "volume"));
        order_history_month.initOrder_count(JSONConversion.getlong(json, "order_count"));
        return order_history_month;
    }
}

