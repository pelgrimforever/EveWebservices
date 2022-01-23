/*
 * JSONView_materialinputavg.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 23.0.2022 17:52
 *
 */
 
package eve.conversion.json;

import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import eve.interfaces.logicview.IView_materialinputavg;
import eve.logicview.View_materialinputavg;
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
public class JSONView_materialinputavg {
    
    public static JSONArray toJSONArray(ArrayList view_materialinputavgs) {
        JSONArray jsonview_materialinputavgs = new JSONArray();
        Iterator view_materialinputavgsI = view_materialinputavgs.iterator();
        while(view_materialinputavgsI.hasNext()) {
            jsonview_materialinputavgs.add(JSONView_materialinputavg.toJSON((View_materialinputavg)view_materialinputavgsI.next()));
        }
        return jsonview_materialinputavgs;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(IView_materialinputavg view_materialinputavg) {
        JSONObject json = new JSONObject();
        json.put("username", view_materialinputavg.getUsername());
        json.put("evetype", String.valueOf(view_materialinputavg.getEvetype()));
        if(view_materialinputavg.getLastbuytimestamp()!=null) {
	        json.put("lastbuytimestamp", view_materialinputavg.getLastbuytimestamp().getTime());
        }
        json.put("totalamount", view_materialinputavg.getTotalamount());
        json.put("avgunitprice", view_materialinputavg.getAvgunitprice());
        json.put("totalusedamount", view_materialinputavg.getTotalusedamount());
        json.put("name", view_materialinputavg.getName());
        json.put("packaged_volume", view_materialinputavg.getPackaged_volume());
        json.put("average", view_materialinputavg.getAverage());
        json.put("highest", view_materialinputavg.getHighest());
        json.put("lowest", view_materialinputavg.getLowest());
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    public static View_materialinputavg toView_materialinputavg(JSONObject json) {
        View_materialinputavg view_materialinputavg = new View_materialinputavg();
        view_materialinputavg.setUsername(JSONConversion.getString(json, "username"));
        view_materialinputavg.setEvetype(JSONConversion.getlong(json, "evetype"));
        view_materialinputavg.setLastbuytimestamp(JSONConversion.getTimestamp(json, "lastbuytimestamp"));
        view_materialinputavg.setTotalamount(JSONConversion.getfloat(json, "totalamount"));
        view_materialinputavg.setAvgunitprice(JSONConversion.getdouble(json, "avgunitprice"));
        view_materialinputavg.setTotalusedamount(JSONConversion.getfloat(json, "totalusedamount"));
        view_materialinputavg.setName(JSONConversion.getString(json, "name"));
        view_materialinputavg.setPackaged_volume(JSONConversion.getdouble(json, "packaged_volume"));
        view_materialinputavg.setAverage(JSONConversion.getdouble(json, "average"));
        view_materialinputavg.setHighest(JSONConversion.getdouble(json, "highest"));
        view_materialinputavg.setLowest(JSONConversion.getdouble(json, "lowest"));
        return view_materialinputavg;
    }

    /**
     * 
     * @param json: JSONObject with the View_materialinputavgsearch parameters
     * @return 
     */
    public static View_materialinputavgsearch toView_materialinputavgsearch(JSONObject json) {
        View_materialinputavgsearch view_materialinputavgsearch = new View_materialinputavgsearch();
        view_materialinputavgsearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        view_materialinputavgsearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        view_materialinputavgsearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("username");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_materialinputavgsearch.username(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("evetype");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_materialinputavgsearch.evetype(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("totalamount");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_materialinputavgsearch.totalamount(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("avgunitprice");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_materialinputavgsearch.avgunitprice(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("totalusedamount");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_materialinputavgsearch.totalusedamount(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("name");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_materialinputavgsearch.name(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("packaged_volume");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_materialinputavgsearch.packaged_volume(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("average");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_materialinputavgsearch.average(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("highest");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_materialinputavgsearch.highest(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("lowest");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_materialinputavgsearch.lowest(valuearray, operators, andor);
        }
        return view_materialinputavgsearch;
    }
}

