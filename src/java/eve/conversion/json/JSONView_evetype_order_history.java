/*
 * JSONView_evetype_order_history.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 16.11.2021 15:46
 *
 */
 
package eve.conversion.json;

import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import eve.interfaces.logicview.IView_evetype_order_history;
import eve.logicview.View_evetype_order_history;
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
public class JSONView_evetype_order_history {
    
    public static JSONArray toJSONArray(ArrayList view_evetype_order_historys) {
        JSONArray jsonview_evetype_order_historys = new JSONArray();
        Iterator view_evetype_order_historysI = view_evetype_order_historys.iterator();
        while(view_evetype_order_historysI.hasNext()) {
            jsonview_evetype_order_historys.add(JSONView_evetype_order_history.toJSON((View_evetype_order_history)view_evetype_order_historysI.next()));
        }
        return jsonview_evetype_order_historys;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(IView_evetype_order_history view_evetype_order_history) {
        JSONObject json = new JSONObject();
        json.put("evetype", String.valueOf(view_evetype_order_history.getEvetype()));
        if(view_evetype_order_history.getDate()!=null) {
	        json.put("date", view_evetype_order_history.getDate().getTime());
        }
        json.put("average", view_evetype_order_history.getAverage());
        json.put("highest", view_evetype_order_history.getHighest());
        json.put("lowest", view_evetype_order_history.getLowest());
        json.put("volume", String.valueOf(view_evetype_order_history.getVolume()));
        json.put("ordercount", String.valueOf(view_evetype_order_history.getOrdercount()));
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    public static View_evetype_order_history toView_evetype_order_history(JSONObject json) {
        View_evetype_order_history view_evetype_order_history = new View_evetype_order_history();
        view_evetype_order_history.setEvetype(JSONConversion.getlong(json, "evetype"));
        view_evetype_order_history.setDate(JSONConversion.getDate(json, "date"));
        view_evetype_order_history.setAverage(JSONConversion.getdouble(json, "average"));
        view_evetype_order_history.setHighest(JSONConversion.getdouble(json, "highest"));
        view_evetype_order_history.setLowest(JSONConversion.getdouble(json, "lowest"));
        view_evetype_order_history.setVolume(JSONConversion.getlong(json, "volume"));
        view_evetype_order_history.setOrdercount(JSONConversion.getlong(json, "ordercount"));
        return view_evetype_order_history;
    }

    /**
     * 
     * @param json: JSONObject with the View_evetype_order_historysearch parameters
     * @return 
     */
    public static View_evetype_order_historysearch toView_evetype_order_historysearch(JSONObject json) {
        View_evetype_order_historysearch view_evetype_order_historysearch = new View_evetype_order_historysearch();
        view_evetype_order_historysearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        view_evetype_order_historysearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        view_evetype_order_historysearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("evetype");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_evetype_order_historysearch.evetype(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("date");
        if(field!=null) {
            Date[] valuearray = JSONConversion.getDatevalues(field);
            byte[] operators = JSONConversion.getDateoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_evetype_order_historysearch.date(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("average");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_evetype_order_historysearch.average(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("highest");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_evetype_order_historysearch.highest(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("lowest");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_evetype_order_historysearch.lowest(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("volume");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_evetype_order_historysearch.volume(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("ordercount");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_evetype_order_historysearch.ordercount(valuearray, operators, andor);
        }
        return view_evetype_order_historysearch;
    }
}

