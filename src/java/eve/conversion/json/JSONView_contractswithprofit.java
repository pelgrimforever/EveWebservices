/*
 * JSONView_contractswithprofit.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 8.0.2022 19:19
 *
 */
 
package eve.conversion.json;

import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import eve.interfaces.logicview.IView_contractswithprofit;
import eve.logicview.View_contractswithprofit;
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
public class JSONView_contractswithprofit {
    
    public static JSONArray toJSONArray(ArrayList view_contractswithprofits) {
        JSONArray jsonview_contractswithprofits = new JSONArray();
        Iterator view_contractswithprofitsI = view_contractswithprofits.iterator();
        while(view_contractswithprofitsI.hasNext()) {
            jsonview_contractswithprofits.add(JSONView_contractswithprofit.toJSON((View_contractswithprofit)view_contractswithprofitsI.next()));
        }
        return jsonview_contractswithprofits;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(IView_contractswithprofit view_contractswithprofit) {
        JSONObject json = new JSONObject();
        json.put("id", String.valueOf(view_contractswithprofit.getId()));
        if(view_contractswithprofit.getDate_expired()!=null) {
	        json.put("date_expired", view_contractswithprofit.getDate_expired().getTime());
        }
        if(view_contractswithprofit.getDate_issued()!=null) {
	        json.put("date_issued", view_contractswithprofit.getDate_issued().getTime());
        }
        json.put("days_to_complete", view_contractswithprofit.getDays_to_complete());
        json.put("end_location_id", String.valueOf(view_contractswithprofit.getEnd_location_id()));
        json.put("price", view_contractswithprofit.getPrice());
        json.put("reward", view_contractswithprofit.getReward());
        json.put("start_location_id", String.valueOf(view_contractswithprofit.getStart_location_id()));
        json.put("name", view_contractswithprofit.getName());
        json.put("systemname", view_contractswithprofit.getSystemname());
        json.put("regionname", view_contractswithprofit.getRegionname());
        json.put("title", view_contractswithprofit.getTitle());
        json.put("volume", view_contractswithprofit.getVolume());
        json.put("sellprice", view_contractswithprofit.getSellprice());
        json.put("buyprice", view_contractswithprofit.getBuyprice());
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    public static View_contractswithprofit toView_contractswithprofit(JSONObject json) {
        View_contractswithprofit view_contractswithprofit = new View_contractswithprofit();
        view_contractswithprofit.setId(JSONConversion.getlong(json, "id"));
        view_contractswithprofit.setDate_expired(JSONConversion.getTimestamp(json, "date_expired"));
        view_contractswithprofit.setDate_issued(JSONConversion.getTimestamp(json, "date_issued"));
        view_contractswithprofit.setDays_to_complete(JSONConversion.getint(json, "days_to_complete"));
        view_contractswithprofit.setEnd_location_id(JSONConversion.getlong(json, "end_location_id"));
        view_contractswithprofit.setPrice(JSONConversion.getdouble(json, "price"));
        view_contractswithprofit.setReward(JSONConversion.getdouble(json, "reward"));
        view_contractswithprofit.setStart_location_id(JSONConversion.getlong(json, "start_location_id"));
        view_contractswithprofit.setName(JSONConversion.getString(json, "name"));
        view_contractswithprofit.setSystemname(JSONConversion.getString(json, "systemname"));
        view_contractswithprofit.setRegionname(JSONConversion.getString(json, "regionname"));
        view_contractswithprofit.setTitle(JSONConversion.getString(json, "title"));
        view_contractswithprofit.setVolume(JSONConversion.getdouble(json, "volume"));
        view_contractswithprofit.setSellprice(JSONConversion.getdouble(json, "sellprice"));
        view_contractswithprofit.setBuyprice(JSONConversion.getdouble(json, "buyprice"));
        return view_contractswithprofit;
    }

    /**
     * 
     * @param json: JSONObject with the View_contractswithprofitsearch parameters
     * @return 
     */
    public static View_contractswithprofitsearch toView_contractswithprofitsearch(JSONObject json) {
        View_contractswithprofitsearch view_contractswithprofitsearch = new View_contractswithprofitsearch();
        view_contractswithprofitsearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        view_contractswithprofitsearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        view_contractswithprofitsearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("id");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_contractswithprofitsearch.id(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("days_to_complete");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_contractswithprofitsearch.days_to_complete(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("end_location_id");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_contractswithprofitsearch.end_location_id(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("price");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_contractswithprofitsearch.price(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("reward");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_contractswithprofitsearch.reward(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("start_location_id");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_contractswithprofitsearch.start_location_id(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("name");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_contractswithprofitsearch.name(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("systemname");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_contractswithprofitsearch.systemname(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("regionname");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_contractswithprofitsearch.regionname(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("title");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_contractswithprofitsearch.title(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("volume");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_contractswithprofitsearch.volume(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("sellprice");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_contractswithprofitsearch.sellprice(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("buyprice");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_contractswithprofitsearch.buyprice(valuearray, operators, andor);
        }
        return view_contractswithprofitsearch;
    }
}

