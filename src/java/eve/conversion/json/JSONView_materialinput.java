/*
 * JSONView_materialinput.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 19.0.2022 21:56
 *
 */
 
package eve.conversion.json;

import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import eve.interfaces.logicview.IView_materialinput;
import eve.logicview.View_materialinput;
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
public class JSONView_materialinput {
    
    public static JSONArray toJSONArray(ArrayList view_materialinputs) {
        JSONArray jsonview_materialinputs = new JSONArray();
        Iterator view_materialinputsI = view_materialinputs.iterator();
        while(view_materialinputsI.hasNext()) {
            jsonview_materialinputs.add(JSONView_materialinput.toJSON((View_materialinput)view_materialinputsI.next()));
        }
        return jsonview_materialinputs;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(IView_materialinput view_materialinput) {
        JSONObject json = new JSONObject();
        json.put("username", view_materialinput.getUsername());
        json.put("evetype", String.valueOf(view_materialinput.getEvetype()));
        if(view_materialinput.getAddtimestamp()!=null) {
	        json.put("addtimestamp", view_materialinput.getAddtimestamp().getTime());
        }
        json.put("amount", String.valueOf(view_materialinput.getAmount()));
        json.put("unitprice", view_materialinput.getUnitprice());
        json.put("usedamount", String.valueOf(view_materialinput.getUsedamount()));
        json.put("name", view_materialinput.getName());
        json.put("packaged_volume", view_materialinput.getPackaged_volume());
        json.put("average", view_materialinput.getAverage());
        json.put("highest", view_materialinput.getHighest());
        json.put("lowest", view_materialinput.getLowest());
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    public static View_materialinput toView_materialinput(JSONObject json) {
        View_materialinput view_materialinput = new View_materialinput();
        view_materialinput.setUsername(JSONConversion.getString(json, "username"));
        view_materialinput.setEvetype(JSONConversion.getlong(json, "evetype"));
        view_materialinput.setAddtimestamp(JSONConversion.getTimestamp(json, "addtimestamp"));
        view_materialinput.setAmount(JSONConversion.getlong(json, "amount"));
        view_materialinput.setUnitprice(JSONConversion.getdouble(json, "unitprice"));
        view_materialinput.setUsedamount(JSONConversion.getlong(json, "usedamount"));
        view_materialinput.setName(JSONConversion.getString(json, "name"));
        view_materialinput.setPackaged_volume(JSONConversion.getdouble(json, "packaged_volume"));
        view_materialinput.setAverage(JSONConversion.getdouble(json, "average"));
        view_materialinput.setHighest(JSONConversion.getdouble(json, "highest"));
        view_materialinput.setLowest(JSONConversion.getdouble(json, "lowest"));
        return view_materialinput;
    }

    /**
     * 
     * @param json: JSONObject with the View_materialinputsearch parameters
     * @return 
     */
    public static View_materialinputsearch toView_materialinputsearch(JSONObject json) {
        View_materialinputsearch view_materialinputsearch = new View_materialinputsearch();
        view_materialinputsearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        view_materialinputsearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        view_materialinputsearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("username");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_materialinputsearch.username(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("evetype");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_materialinputsearch.evetype(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("amount");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_materialinputsearch.amount(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("unitprice");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_materialinputsearch.unitprice(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("usedamount");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_materialinputsearch.usedamount(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("name");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_materialinputsearch.name(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("packaged_volume");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_materialinputsearch.packaged_volume(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("average");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_materialinputsearch.average(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("highest");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_materialinputsearch.highest(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("lowest");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_materialinputsearch.lowest(valuearray, operators, andor);
        }
        return view_materialinputsearch;
    }
}

