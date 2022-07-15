/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 13.6.2022 11:21
 */
 
package eve.conversion.json;

import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import eve.interfaces.logicview.IView_evetype_order_history_month;
import eve.logicview.View_evetype_order_history_month;
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
public class JSONView_evetype_order_history_month {
    
    public static JSONArray toJSONArray(ArrayList view_evetype_order_history_months) {
        JSONArray jsonview_evetype_order_history_months = new JSONArray();
        Iterator view_evetype_order_history_monthsI = view_evetype_order_history_months.iterator();
        while(view_evetype_order_history_monthsI.hasNext()) {
            jsonview_evetype_order_history_months.add(JSONView_evetype_order_history_month.toJSON((View_evetype_order_history_month)view_evetype_order_history_monthsI.next()));
        }
        return jsonview_evetype_order_history_months;
    }

    public static JSONObject toJSON(IView_evetype_order_history_month view_evetype_order_history_month) {
        JSONObject json = new JSONObject();
        json.put("evetype", String.valueOf(view_evetype_order_history_month.getEvetype()));
        json.put("year", view_evetype_order_history_month.getYear());
        json.put("month", view_evetype_order_history_month.getMonth());
        json.put("average", view_evetype_order_history_month.getAverage());
        json.put("highest", view_evetype_order_history_month.getHighest());
        json.put("lowest", view_evetype_order_history_month.getLowest());
        json.put("volume", view_evetype_order_history_month.getVolume());
        json.put("ordercount", view_evetype_order_history_month.getOrdercount());
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    public static View_evetype_order_history_month toView_evetype_order_history_month(JSONObject json) {
        View_evetype_order_history_month view_evetype_order_history_month = new View_evetype_order_history_month();
        view_evetype_order_history_month.setEvetype(JSONConversion.getlong(json, "evetype"));
        view_evetype_order_history_month.setYear(JSONConversion.getint(json, "year"));
        view_evetype_order_history_month.setMonth(JSONConversion.getint(json, "month"));
        view_evetype_order_history_month.setAverage(JSONConversion.getdouble(json, "average"));
        view_evetype_order_history_month.setHighest(JSONConversion.getdouble(json, "highest"));
        view_evetype_order_history_month.setLowest(JSONConversion.getdouble(json, "lowest"));
        view_evetype_order_history_month.setVolume(JSONConversion.getfloat(json, "volume"));
        view_evetype_order_history_month.setOrdercount(JSONConversion.getfloat(json, "ordercount"));
        return view_evetype_order_history_month;
    }

    public static View_evetype_order_history_monthsearch toView_evetype_order_history_monthsearch(JSONObject json) {
        View_evetype_order_history_monthsearch view_evetype_order_history_monthsearch = new View_evetype_order_history_monthsearch();
        view_evetype_order_history_monthsearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        view_evetype_order_history_monthsearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        view_evetype_order_history_monthsearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("evetype");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_evetype_order_history_monthsearch.evetype(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("year");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_evetype_order_history_monthsearch.year(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("month");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_evetype_order_history_monthsearch.month(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("average");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_evetype_order_history_monthsearch.average(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("highest");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_evetype_order_history_monthsearch.highest(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("lowest");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_evetype_order_history_monthsearch.lowest(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("volume");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_evetype_order_history_monthsearch.volume(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("ordercount");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_evetype_order_history_monthsearch.ordercount(valuearray, operators, andor);
        }
        return view_evetype_order_history_monthsearch;
    }
}

