/*
 * JSONOrder_hist.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 4.11.2021 14:51
 *
 */
 
package eve.conversion.json;

import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.interfaces.db.EntityPK;
import data.interfaces.db.Fieldsearcher;
import data.json.piJson;
import eve.entity.pk.Order_histPK;
import eve.interfaces.entity.pk.IOrder_histPK;
import eve.interfaces.logicentity.IOrder_hist;
import eve.logicentity.Order_hist;
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
public class JSONOrder_hist {
    
    public static JSONArray toJSONArray(ArrayList order_hists) {
        JSONArray jsonorder_hists = new JSONArray();
        Iterator order_histsI = order_hists.iterator();
        while(order_histsI.hasNext()) {
            jsonorder_hists.add(toJSON((Order_hist)order_histsI.next()));
        }
        return jsonorder_hists;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(IOrder_histPK order_histPK) {
        JSONObject json = null;
        if(order_histPK!=null) {
            json = new JSONObject();
            json.put("id", String.valueOf(order_histPK.getId()));
        }
        return json;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(IOrder_hist order_hist) {
        JSONObject json = new JSONObject();
        json.put("PK", toJSON(order_hist.getPrimaryKey()));
        json.put("evetypePK", JSONEvetype.toJSON(order_hist.getEvetypePK()));
        json.put("systemPK", JSONSystem.toJSON(order_hist.getSystemPK()));
        json.put("isopen", order_hist.getIsopen());
        json.put("volume_total", order_hist.getVolume_total());
        json.put("volume_remain", order_hist.getVolume_remain());
        json.put("range", order_hist.getRange());
        json.put("range_number", order_hist.getRange_number());
        json.put("price", order_hist.getPrice());
        json.put("min_volume", order_hist.getMin_volume());
        json.put("location", String.valueOf(order_hist.getLocation()));
        json.put("is_buy_order", order_hist.getIs_buy_order());
        if(order_hist.getIssued()!=null) {
	        json.put("issued", order_hist.getIssued().getTime());
        }
        json.put("duration", order_hist.getDuration());
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(Order_histsearch order_histsearch) {
        JSONObject json = new JSONObject();
        if(order_histsearch.used()) {
            byte andoroperator = order_histsearch.getAndoroperator();
            int maxresults = order_histsearch.getMaxresults();
            boolean docount = order_histsearch.getDocount();
            Iterator<EntityPK> primarykeysI = order_histsearch.getPrimarykeys().iterator();
            Iterator<Fieldsearcher> fieldsearchersI = order_histsearch.getFieldsearchers().iterator();
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
            if(order_histsearch.getEvetypesearch()!=null && order_histsearch.getEvetypesearch().used()) {
                kss.put("evetypesearcher", JSONEvetype.toJSON((Evetypesearch)order_histsearch.getEvetypesearch()));
            }
            if(order_histsearch.getSystemsearch()!=null && order_histsearch.getSystemsearch().used()) {
                kss.put("systemsearcher", JSONSystem.toJSON((Systemsearch)order_histsearch.getSystemsearch()));
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
    public static Order_histsearch toOrder_histsearch(JSONObject json) {
        Order_histsearch order_histsearch = new Order_histsearch();
        order_histsearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        order_histsearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        order_histsearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONArray pks = (JSONArray)json.get("primarykeys");
        for(int i=0; i<pks.size(); i++) {
            order_histsearch.addPrimarykey(Order_histPK.getKey((String)pks.get(i)));
        }
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("id");
        if(field!=null) {
            long[] valuearray = JSONConversion.getLongvalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            order_histsearch.id(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("isopen");
        if(field!=null) {
            boolean value = JSONConversion.getBooleanvalue(field);
            order_histsearch.isopen(value);
        }
        field = (JSONObject)fss.get("volume_total");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            order_histsearch.volume_total(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("volume_remain");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            order_histsearch.volume_remain(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("range");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            order_histsearch.range(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("range_number");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            order_histsearch.range_number(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("price");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            order_histsearch.price(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("min_volume");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            order_histsearch.min_volume(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("location");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            order_histsearch.location(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("is_buy_order");
        if(field!=null) {
            boolean value = JSONConversion.getBooleanvalue(field);
            order_histsearch.is_buy_order(value);
        }
        field = (JSONObject)fss.get("issued");
        if(field!=null) {
            Timestamp[] valuearray = JSONConversion.getTimestampvalues(field);
            byte[] operators = JSONConversion.getTimeoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            order_histsearch.issued(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("duration");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            order_histsearch.duration(valuearray, operators, andor);
        }
        JSONObject kss = (JSONObject)json.get("keysearch");
        JSONArray keysearch;
        keysearch = (JSONArray)kss.get("evetypesearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Evetypesearch evetypesearch = JSONEvetype.toEvetypesearch((JSONObject)keysearch.get(i));
                order_histsearch.evetype(evetypesearch);
            }
        }
        keysearch = (JSONArray)kss.get("systemsearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Systemsearch systemsearch = JSONSystem.toSystemsearch((JSONObject)keysearch.get(i));
                order_histsearch.system(systemsearch);
            }
        }
        return order_histsearch;
    }
    
    public static Order_histPK toOrder_histPK(JSONObject json) {
        Order_histPK order_histPK = null;
        if(json!=null) {
            order_histPK = new Order_histPK(JSONConversion.getlong(json, "id"));
        }
        return order_histPK;
    }

    public static Order_hist toOrder_hist(JSONObject json) {
        Order_hist order_hist = new Order_hist(toOrder_histPK((JSONObject)json.get("PK")));
        updateOrder_hist(order_hist, json);
        return order_hist;
    }

    public static void updateOrder_hist(IOrder_hist order_hist, JSONObject json) {
        order_hist.setEvetypePK(JSONEvetype.toEvetypePK((JSONObject)json.get("evetypePK")));
        order_hist.setSystemPK(JSONSystem.toSystemPK((JSONObject)json.get("systemPK")));
        order_hist.setIsopen(JSONConversion.getboolean(json, "isopen"));
        order_hist.setVolume_total(JSONConversion.getint(json, "volume_total"));
        order_hist.setVolume_remain(JSONConversion.getint(json, "volume_remain"));
        order_hist.setRange(JSONConversion.getString(json, "range"));
        order_hist.setRange_number(JSONConversion.getint(json, "range_number"));
        order_hist.setPrice(JSONConversion.getdouble(json, "price"));
        order_hist.setMin_volume(JSONConversion.getint(json, "min_volume"));
        order_hist.setLocation(JSONConversion.getlong(json, "location"));
        order_hist.setIs_buy_order(JSONConversion.getboolean(json, "is_buy_order"));
        order_hist.setIssued(JSONConversion.getTimestamp(json, "issued"));
        order_hist.setDuration(JSONConversion.getint(json, "duration"));
    }

    public static Order_hist initOrder_hist(JSONObject json) {
        Order_hist order_hist = new Order_hist(toOrder_histPK((JSONObject)json.get("PK")));
        order_hist.initEvetypePK(JSONEvetype.toEvetypePK((JSONObject)json.get("evetypePK")));
        order_hist.initSystemPK(JSONSystem.toSystemPK((JSONObject)json.get("systemPK")));
        order_hist.initIsopen(JSONConversion.getboolean(json, "isopen"));
        order_hist.initVolume_total(JSONConversion.getint(json, "volume_total"));
        order_hist.initVolume_remain(JSONConversion.getint(json, "volume_remain"));
        order_hist.initRange(JSONConversion.getString(json, "range"));
        order_hist.initRange_number(JSONConversion.getint(json, "range_number"));
        order_hist.initPrice(JSONConversion.getdouble(json, "price"));
        order_hist.initMin_volume(JSONConversion.getint(json, "min_volume"));
        order_hist.initLocation(JSONConversion.getlong(json, "location"));
        order_hist.initIs_buy_order(JSONConversion.getboolean(json, "is_buy_order"));
        order_hist.initIssued(JSONConversion.getTimestamp(json, "issued"));
        order_hist.initDuration(JSONConversion.getint(json, "duration"));
        return order_hist;
    }
}

