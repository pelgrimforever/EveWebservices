/*
 * JSONView_order.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 25.9.2021 15:16
 *
 */
 
package eve.conversion.json;

import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import eve.interfaces.logicview.IView_order;
import eve.logicview.View_order;
import eve.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author Franky Laseure
 */
public class JSONView_order {
    
    public static JSONArray toJSONArray(ArrayList view_orders) {
        JSONArray jsonview_orders = new JSONArray();
        Iterator view_ordersI = view_orders.iterator();
        while(view_ordersI.hasNext()) {
            jsonview_orders.add(JSONView_order.toJSON((View_order)view_ordersI.next()));
        }
        return jsonview_orders;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(IView_order view_order) {
        JSONObject json = new JSONObject();
        json.put("id", String.valueOf(view_order.getId()));
        json.put("isopen", view_order.getIsopen());
        json.put("system", String.valueOf(view_order.getSystem()));
        json.put("evetype", String.valueOf(view_order.getEvetype()));
        json.put("volume_total", String.valueOf(view_order.getVolume_total()));
        json.put("volume_remain", String.valueOf(view_order.getVolume_remain()));
        json.put("range", view_order.getRange());
        json.put("range_number", view_order.getRange_number());
        json.put("price", view_order.getPrice());
        json.put("min_volume", view_order.getMin_volume());
        json.put("location", String.valueOf(view_order.getLocation()));
        json.put("is_buy_order", view_order.getIs_buy_order());
        if(view_order.getIssued()!=null) {
	        json.put("issued", view_order.getIssued().getTime());
        }
        json.put("duration", view_order.getDuration());
        json.put("page", view_order.getPage());
        json.put("stationid", String.valueOf(view_order.getStationid()));
        json.put("stationname", view_order.getStationname());
        json.put("locationid", String.valueOf(view_order.getLocationid()));
        json.put("locationname", view_order.getLocationname());
        json.put("systemname", view_order.getSystemname());
        json.put("security_status", view_order.getSecurity_status());
        json.put("constellation", String.valueOf(view_order.getConstellation()));
        json.put("constellationname", view_order.getConstellationname());
        json.put("region", String.valueOf(view_order.getRegion()));
        json.put("regionname", view_order.getRegionname());
        json.put("evetypename", view_order.getEvetypename());
        json.put("packaged_volume", view_order.getPackaged_volume());
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    public static View_order toView_order(JSONObject json) {
        View_order view_order = new View_order();
        view_order.setId(JSONConversion.getlong(json, "id"));
        view_order.setIsopen(JSONConversion.getboolean(json, "isopen"));
        view_order.setSystem(JSONConversion.getlong(json, "system"));
        view_order.setEvetype(JSONConversion.getlong(json, "evetype"));
        view_order.setVolume_total(JSONConversion.getlong(json, "volume_total"));
        view_order.setVolume_remain(JSONConversion.getlong(json, "volume_remain"));
        view_order.setRange(JSONConversion.getString(json, "range"));
        view_order.setRange_number(JSONConversion.getint(json, "range_number"));
        view_order.setPrice(JSONConversion.getdouble(json, "price"));
        view_order.setMin_volume(JSONConversion.getint(json, "min_volume"));
        view_order.setLocation(JSONConversion.getlong(json, "location"));
        view_order.setIs_buy_order(JSONConversion.getboolean(json, "is_buy_order"));
        view_order.setIssued(JSONConversion.getTimestamp(json, "issued"));
        view_order.setDuration(JSONConversion.getint(json, "duration"));
        view_order.setPage(JSONConversion.getint(json, "page"));
        view_order.setStationid(JSONConversion.getlong(json, "stationid"));
        view_order.setStationname(JSONConversion.getString(json, "stationname"));
        view_order.setLocationid(JSONConversion.getlong(json, "locationid"));
        view_order.setLocationname(JSONConversion.getString(json, "locationname"));
        view_order.setSystemname(JSONConversion.getString(json, "systemname"));
        view_order.setSecurity_status(JSONConversion.getdouble(json, "security_status"));
        view_order.setConstellation(JSONConversion.getlong(json, "constellation"));
        view_order.setConstellationname(JSONConversion.getString(json, "constellationname"));
        view_order.setRegion(JSONConversion.getlong(json, "region"));
        view_order.setRegionname(JSONConversion.getString(json, "regionname"));
        view_order.setEvetypename(JSONConversion.getString(json, "evetypename"));
        view_order.setPackaged_volume(JSONConversion.getdouble(json, "packaged_volume"));
        return view_order;
    }

    /**
     * 
     * @param json: JSONObject with the View_ordersearch parameters
     * @return 
     */
    public static View_ordersearch toView_ordersearch(JSONObject json) {
        View_ordersearch view_ordersearch = new View_ordersearch();
        view_ordersearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        view_ordersearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        view_ordersearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("id");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_ordersearch.id(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("isopen");
        if(field!=null) {
            boolean value = JSONConversion.getBooleanvalue(field);
            view_ordersearch.isopen(value);
        }
        field = (JSONObject)fss.get("system");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_ordersearch.system(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("evetype");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_ordersearch.evetype(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("volume_total");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_ordersearch.volume_total(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("volume_remain");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_ordersearch.volume_remain(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("range");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_ordersearch.range(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("range_number");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_ordersearch.range_number(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("price");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_ordersearch.price(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("min_volume");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_ordersearch.min_volume(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("location");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_ordersearch.location(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("is_buy_order");
        if(field!=null) {
            boolean value = JSONConversion.getBooleanvalue(field);
            view_ordersearch.is_buy_order(value);
        }
        field = (JSONObject)fss.get("duration");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_ordersearch.duration(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("page");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_ordersearch.page(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("stationid");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_ordersearch.stationid(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("stationname");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_ordersearch.stationname(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("locationid");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_ordersearch.locationid(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("locationname");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_ordersearch.locationname(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("systemname");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_ordersearch.systemname(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("security_status");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_ordersearch.security_status(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("constellation");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_ordersearch.constellation(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("constellationname");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_ordersearch.constellationname(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("region");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_ordersearch.region(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("regionname");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_ordersearch.regionname(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("evetypename");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_ordersearch.evetypename(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("packaged_volume");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_ordersearch.packaged_volume(valuearray, operators, andor);
        }
        return view_ordersearch;
    }
}

