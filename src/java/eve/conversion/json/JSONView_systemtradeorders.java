/*
 * JSONView_systemtradeorders.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 24.9.2021 14:40
 *
 */
 
package eve.conversion.json;

import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import eve.interfaces.logicview.IView_systemtradeorders;
import eve.logicview.View_systemtradeorders;
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
public class JSONView_systemtradeorders {
    
    public static JSONArray toJSONArray(ArrayList view_systemtradeorderss) {
        JSONArray jsonview_systemtradeorderss = new JSONArray();
        Iterator view_systemtradeorderssI = view_systemtradeorderss.iterator();
        while(view_systemtradeorderssI.hasNext()) {
            jsonview_systemtradeorderss.add(JSONView_systemtradeorders.toJSON((View_systemtradeorders)view_systemtradeorderssI.next()));
        }
        return jsonview_systemtradeorderss;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(IView_systemtradeorders view_systemtradeorders) {
        JSONObject json = new JSONObject();
        json.put("buy_totalprice", view_systemtradeorders.getBuy_totalprice());
        json.put("sell_totalprice", view_systemtradeorders.getSell_totalprice());
        json.put("cargo_volume", view_systemtradeorders.getCargo_volume());
        json.put("sellorderid", String.valueOf(view_systemtradeorders.getSellorderid()));
        json.put("buyorderid", String.valueOf(view_systemtradeorders.getBuyorderid()));
        json.put("evetype", String.valueOf(view_systemtradeorders.getEvetype()));
        json.put("packaged_volume", view_systemtradeorders.getPackaged_volume());
        json.put("security_island", String.valueOf(view_systemtradeorders.getSecurity_island()));
        json.put("sell_system", String.valueOf(view_systemtradeorders.getSell_system()));
        json.put("buy_system", String.valueOf(view_systemtradeorders.getBuy_system()));
        json.put("jumps", view_systemtradeorders.getJumps());
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    public static View_systemtradeorders toView_systemtradeorders(JSONObject json) {
        View_systemtradeorders view_systemtradeorders = new View_systemtradeorders();
        view_systemtradeorders.setBuy_totalprice(JSONConversion.getdouble(json, "buy_totalprice"));
        view_systemtradeorders.setSell_totalprice(JSONConversion.getdouble(json, "sell_totalprice"));
        view_systemtradeorders.setCargo_volume(JSONConversion.getdouble(json, "cargo_volume"));
        view_systemtradeorders.setSellorderid(JSONConversion.getlong(json, "sellorderid"));
        view_systemtradeorders.setBuyorderid(JSONConversion.getlong(json, "buyorderid"));
        view_systemtradeorders.setEvetype(JSONConversion.getlong(json, "evetype"));
        view_systemtradeorders.setPackaged_volume(JSONConversion.getdouble(json, "packaged_volume"));
        view_systemtradeorders.setSecurity_island(JSONConversion.getlong(json, "security_island"));
        view_systemtradeorders.setSell_system(JSONConversion.getlong(json, "sell_system"));
        view_systemtradeorders.setBuy_system(JSONConversion.getlong(json, "buy_system"));
        view_systemtradeorders.setJumps(JSONConversion.getint(json, "jumps"));
        return view_systemtradeorders;
    }

    /**
     * 
     * @param json: JSONObject with the View_systemtradeorderssearch parameters
     * @return 
     */
    public static View_systemtradeorderssearch toView_systemtradeorderssearch(JSONObject json) {
        View_systemtradeorderssearch view_systemtradeorderssearch = new View_systemtradeorderssearch();
        view_systemtradeorderssearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        view_systemtradeorderssearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        view_systemtradeorderssearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("buy_totalprice");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_systemtradeorderssearch.buy_totalprice(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("sell_totalprice");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_systemtradeorderssearch.sell_totalprice(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("cargo_volume");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_systemtradeorderssearch.cargo_volume(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("sellorderid");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_systemtradeorderssearch.sellorderid(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("buyorderid");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_systemtradeorderssearch.buyorderid(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("evetype");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_systemtradeorderssearch.evetype(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("packaged_volume");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_systemtradeorderssearch.packaged_volume(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("security_island");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_systemtradeorderssearch.security_island(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("sell_system");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_systemtradeorderssearch.sell_system(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("buy_system");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_systemtradeorderssearch.buy_system(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("jumps");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_systemtradeorderssearch.jumps(valuearray, operators, andor);
        }
        return view_systemtradeorderssearch;
    }
}

