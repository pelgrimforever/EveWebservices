/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 23.8.2022 14:38
 * @author Franky Laseure
 */
 
package eve.conversion.json;

import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import eve.interfaces.logicview.IView_shipfitorderselected;
import eve.logicview.View_shipfitorderselected;
import eve.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JSONView_shipfitorderselected {
    
    public static JSONArray toJSONArray(ArrayList view_shipfitorderselecteds) {
        JSONArray jsonview_shipfitorderselecteds = new JSONArray();
        Iterator view_shipfitorderselectedsI = view_shipfitorderselecteds.iterator();
        while(view_shipfitorderselectedsI.hasNext()) {
            jsonview_shipfitorderselecteds.add(JSONView_shipfitorderselected.toJSON((View_shipfitorderselected)view_shipfitorderselectedsI.next()));
        }
        return jsonview_shipfitorderselecteds;
    }

    public static JSONObject toJSON(IView_shipfitorderselected view_shipfitorderselected) {
        JSONObject json = new JSONObject();
        json.put("username", view_shipfitorderselected.getUsername());
        json.put("shipname", view_shipfitorderselected.getShipname());
        json.put("amountneeded", view_shipfitorderselected.getAmountneeded());
        json.put("id", String.valueOf(view_shipfitorderselected.getId()));
        json.put("isopen", view_shipfitorderselected.getIsopen());
        json.put("system", String.valueOf(view_shipfitorderselected.getSystem()));
        json.put("evetype", String.valueOf(view_shipfitorderselected.getEvetype()));
        json.put("volume_total", String.valueOf(view_shipfitorderselected.getVolume_total()));
        json.put("volume_remain", String.valueOf(view_shipfitorderselected.getVolume_remain()));
        json.put("range", view_shipfitorderselected.getRange());
        json.put("range_number", view_shipfitorderselected.getRange_number());
        json.put("price", view_shipfitorderselected.getPrice());
        json.put("min_volume", view_shipfitorderselected.getMin_volume());
        json.put("location", String.valueOf(view_shipfitorderselected.getLocation()));
        json.put("is_buy_order", view_shipfitorderselected.getIs_buy_order());
        if(view_shipfitorderselected.getIssued()!=null) {
	        json.put("issued", view_shipfitorderselected.getIssued().getTime());
        }
        json.put("duration", view_shipfitorderselected.getDuration());
        json.put("page", view_shipfitorderselected.getPage());
        json.put("stationid", String.valueOf(view_shipfitorderselected.getStationid()));
        json.put("stationname", view_shipfitorderselected.getStationname());
        json.put("locationid", String.valueOf(view_shipfitorderselected.getLocationid()));
        json.put("locationname", view_shipfitorderselected.getLocationname());
        json.put("systemname", view_shipfitorderselected.getSystemname());
        json.put("security_status", view_shipfitorderselected.getSecurity_status());
        json.put("constellation", String.valueOf(view_shipfitorderselected.getConstellation()));
        json.put("constellationname", view_shipfitorderselected.getConstellationname());
        json.put("region", String.valueOf(view_shipfitorderselected.getRegion()));
        json.put("regionname", view_shipfitorderselected.getRegionname());
        json.put("evetypename", view_shipfitorderselected.getEvetypename());
        json.put("packaged_volume", view_shipfitorderselected.getPackaged_volume());
        json.put("avg_buyorder", view_shipfitorderselected.getAvg_buyorder());
        json.put("avg_sellorder", view_shipfitorderselected.getAvg_sellorder());
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    public static View_shipfitorderselected toView_shipfitorderselected(JSONObject json) {
        View_shipfitorderselected view_shipfitorderselected = new View_shipfitorderselected();
        view_shipfitorderselected.setUsername(JSONConversion.getString(json, "username"));
        view_shipfitorderselected.setShipname(JSONConversion.getString(json, "shipname"));
        view_shipfitorderselected.setAmountneeded(JSONConversion.getint(json, "amountneeded"));
        view_shipfitorderselected.setId(JSONConversion.getlong(json, "id"));
        view_shipfitorderselected.setIsopen(JSONConversion.getboolean(json, "isopen"));
        view_shipfitorderselected.setSystem(JSONConversion.getlong(json, "system"));
        view_shipfitorderselected.setEvetype(JSONConversion.getlong(json, "evetype"));
        view_shipfitorderselected.setVolume_total(JSONConversion.getlong(json, "volume_total"));
        view_shipfitorderselected.setVolume_remain(JSONConversion.getlong(json, "volume_remain"));
        view_shipfitorderselected.setRange(JSONConversion.getString(json, "range"));
        view_shipfitorderselected.setRange_number(JSONConversion.getint(json, "range_number"));
        view_shipfitorderselected.setPrice(JSONConversion.getdouble(json, "price"));
        view_shipfitorderselected.setMin_volume(JSONConversion.getint(json, "min_volume"));
        view_shipfitorderselected.setLocation(JSONConversion.getlong(json, "location"));
        view_shipfitorderselected.setIs_buy_order(JSONConversion.getboolean(json, "is_buy_order"));
        view_shipfitorderselected.setIssued(JSONConversion.getTimestamp(json, "issued"));
        view_shipfitorderselected.setDuration(JSONConversion.getint(json, "duration"));
        view_shipfitorderselected.setPage(JSONConversion.getint(json, "page"));
        view_shipfitorderselected.setStationid(JSONConversion.getlong(json, "stationid"));
        view_shipfitorderselected.setStationname(JSONConversion.getString(json, "stationname"));
        view_shipfitorderselected.setLocationid(JSONConversion.getlong(json, "locationid"));
        view_shipfitorderselected.setLocationname(JSONConversion.getString(json, "locationname"));
        view_shipfitorderselected.setSystemname(JSONConversion.getString(json, "systemname"));
        view_shipfitorderselected.setSecurity_status(JSONConversion.getdouble(json, "security_status"));
        view_shipfitorderselected.setConstellation(JSONConversion.getlong(json, "constellation"));
        view_shipfitorderselected.setConstellationname(JSONConversion.getString(json, "constellationname"));
        view_shipfitorderselected.setRegion(JSONConversion.getlong(json, "region"));
        view_shipfitorderselected.setRegionname(JSONConversion.getString(json, "regionname"));
        view_shipfitorderselected.setEvetypename(JSONConversion.getString(json, "evetypename"));
        view_shipfitorderselected.setPackaged_volume(JSONConversion.getdouble(json, "packaged_volume"));
        view_shipfitorderselected.setAvg_buyorder(JSONConversion.getdouble(json, "avg_buyorder"));
        view_shipfitorderselected.setAvg_sellorder(JSONConversion.getdouble(json, "avg_sellorder"));
        return view_shipfitorderselected;
    }

    public static View_shipfitorderselectedsearch toView_shipfitorderselectedsearch(JSONObject json) {
        View_shipfitorderselectedsearch view_shipfitorderselectedsearch = new View_shipfitorderselectedsearch();
        view_shipfitorderselectedsearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        view_shipfitorderselectedsearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        view_shipfitorderselectedsearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("username");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_shipfitorderselectedsearch.username(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("shipname");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_shipfitorderselectedsearch.shipname(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("amountneeded");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_shipfitorderselectedsearch.amountneeded(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("id");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_shipfitorderselectedsearch.id(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("isopen");
        if(field!=null) {
            boolean value = JSONConversion.getBooleanvalue(field);
            view_shipfitorderselectedsearch.isopen(value);
        }
        field = (JSONObject)fss.get("system");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_shipfitorderselectedsearch.system(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("evetype");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_shipfitorderselectedsearch.evetype(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("volume_total");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_shipfitorderselectedsearch.volume_total(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("volume_remain");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_shipfitorderselectedsearch.volume_remain(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("range");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_shipfitorderselectedsearch.range(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("range_number");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_shipfitorderselectedsearch.range_number(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("price");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_shipfitorderselectedsearch.price(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("min_volume");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_shipfitorderselectedsearch.min_volume(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("location");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_shipfitorderselectedsearch.location(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("is_buy_order");
        if(field!=null) {
            boolean value = JSONConversion.getBooleanvalue(field);
            view_shipfitorderselectedsearch.is_buy_order(value);
        }
        field = (JSONObject)fss.get("duration");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_shipfitorderselectedsearch.duration(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("page");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_shipfitorderselectedsearch.page(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("stationid");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_shipfitorderselectedsearch.stationid(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("stationname");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_shipfitorderselectedsearch.stationname(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("locationid");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_shipfitorderselectedsearch.locationid(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("locationname");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_shipfitorderselectedsearch.locationname(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("systemname");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_shipfitorderselectedsearch.systemname(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("security_status");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_shipfitorderselectedsearch.security_status(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("constellation");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_shipfitorderselectedsearch.constellation(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("constellationname");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_shipfitorderselectedsearch.constellationname(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("region");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_shipfitorderselectedsearch.region(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("regionname");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_shipfitorderselectedsearch.regionname(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("evetypename");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_shipfitorderselectedsearch.evetypename(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("packaged_volume");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_shipfitorderselectedsearch.packaged_volume(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("avg_buyorder");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_shipfitorderselectedsearch.avg_buyorder(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("avg_sellorder");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_shipfitorderselectedsearch.avg_sellorder(valuearray, operators, andor);
        }
        return view_shipfitorderselectedsearch;
    }
}

