/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 17.6.2022 13:4
 */
 
package eve.conversion.json;

import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import eve.interfaces.logicview.IView_evetype_order_history_region_month;
import eve.logicview.View_evetype_order_history_region_month;
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
public class JSONView_evetype_order_history_region_month {
    
    public static JSONArray toJSONArray(ArrayList view_evetype_order_history_region_months) {
        JSONArray jsonview_evetype_order_history_region_months = new JSONArray();
        Iterator view_evetype_order_history_region_monthsI = view_evetype_order_history_region_months.iterator();
        while(view_evetype_order_history_region_monthsI.hasNext()) {
            jsonview_evetype_order_history_region_months.add(JSONView_evetype_order_history_region_month.toJSON((View_evetype_order_history_region_month)view_evetype_order_history_region_monthsI.next()));
        }
        return jsonview_evetype_order_history_region_months;
    }

    public static JSONObject toJSON(IView_evetype_order_history_region_month view_evetype_order_history_region_month) {
        JSONObject json = new JSONObject();
        json.put("region", String.valueOf(view_evetype_order_history_region_month.getRegion()));
        json.put("regionname", view_evetype_order_history_region_month.getRegionname());
        json.put("evetype", String.valueOf(view_evetype_order_history_region_month.getEvetype()));
        json.put("year", view_evetype_order_history_region_month.getYear());
        json.put("month", view_evetype_order_history_region_month.getMonth());
        json.put("average", view_evetype_order_history_region_month.getAverage());
        json.put("highest", view_evetype_order_history_region_month.getHighest());
        json.put("lowest", view_evetype_order_history_region_month.getLowest());
        json.put("volume", view_evetype_order_history_region_month.getVolume());
        json.put("ordercount", view_evetype_order_history_region_month.getOrdercount());
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    public static View_evetype_order_history_region_month toView_evetype_order_history_region_month(JSONObject json) {
        View_evetype_order_history_region_month view_evetype_order_history_region_month = new View_evetype_order_history_region_month();
        view_evetype_order_history_region_month.setRegion(JSONConversion.getlong(json, "region"));
        view_evetype_order_history_region_month.setRegionname(JSONConversion.getString(json, "regionname"));
        view_evetype_order_history_region_month.setEvetype(JSONConversion.getlong(json, "evetype"));
        view_evetype_order_history_region_month.setYear(JSONConversion.getint(json, "year"));
        view_evetype_order_history_region_month.setMonth(JSONConversion.getint(json, "month"));
        view_evetype_order_history_region_month.setAverage(JSONConversion.getdouble(json, "average"));
        view_evetype_order_history_region_month.setHighest(JSONConversion.getdouble(json, "highest"));
        view_evetype_order_history_region_month.setLowest(JSONConversion.getdouble(json, "lowest"));
        view_evetype_order_history_region_month.setVolume(JSONConversion.getfloat(json, "volume"));
        view_evetype_order_history_region_month.setOrdercount(JSONConversion.getfloat(json, "ordercount"));
        return view_evetype_order_history_region_month;
    }

    public static View_evetype_order_history_region_monthsearch toView_evetype_order_history_region_monthsearch(JSONObject json) {
        View_evetype_order_history_region_monthsearch view_evetype_order_history_region_monthsearch = new View_evetype_order_history_region_monthsearch();
        view_evetype_order_history_region_monthsearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        view_evetype_order_history_region_monthsearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        view_evetype_order_history_region_monthsearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("region");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_evetype_order_history_region_monthsearch.region(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("regionname");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_evetype_order_history_region_monthsearch.regionname(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("evetype");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_evetype_order_history_region_monthsearch.evetype(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("year");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_evetype_order_history_region_monthsearch.year(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("month");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_evetype_order_history_region_monthsearch.month(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("average");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_evetype_order_history_region_monthsearch.average(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("highest");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_evetype_order_history_region_monthsearch.highest(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("lowest");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_evetype_order_history_region_monthsearch.lowest(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("volume");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_evetype_order_history_region_monthsearch.volume(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("ordercount");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_evetype_order_history_region_monthsearch.ordercount(valuearray, operators, andor);
        }
        return view_evetype_order_history_region_monthsearch;
    }
}

