/*
 * JSONView_tradeorders.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 25.9.2021 15:16
 *
 */
 
package eve.conversion.json;

import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import eve.interfaces.logicview.IView_tradeorders;
import eve.logicview.View_tradeorders;
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
public class JSONView_tradeorders {
    
    public static JSONArray toJSONArray(ArrayList view_tradeorderss) {
        JSONArray jsonview_tradeorderss = new JSONArray();
        Iterator view_tradeorderssI = view_tradeorderss.iterator();
        while(view_tradeorderssI.hasNext()) {
            jsonview_tradeorderss.add(JSONView_tradeorders.toJSON((View_tradeorders)view_tradeorderssI.next()));
        }
        return jsonview_tradeorderss;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(IView_tradeorders view_tradeorders) {
        JSONObject json = new JSONObject();
        json.put("tradevolume", String.valueOf(view_tradeorders.getTradevolume()));
        json.put("buy_totalprice", view_tradeorders.getBuy_totalprice());
        json.put("sell_totalprice", view_tradeorders.getSell_totalprice());
        json.put("cargo_volume", view_tradeorders.getCargo_volume());
        json.put("sell_id", String.valueOf(view_tradeorders.getSell_id()));
        json.put("sell_system", String.valueOf(view_tradeorders.getSell_system()));
        json.put("sell_location", String.valueOf(view_tradeorders.getSell_location()));
        json.put("sell_evetype", String.valueOf(view_tradeorders.getSell_evetype()));
        json.put("sell_packaged_volume", view_tradeorders.getSell_packaged_volume());
        json.put("sell_volume_remain", String.valueOf(view_tradeorders.getSell_volume_remain()));
        json.put("sell_price", view_tradeorders.getSell_price());
        json.put("security_island", String.valueOf(view_tradeorders.getSecurity_island()));
        json.put("buy_id", String.valueOf(view_tradeorders.getBuy_id()));
        json.put("buy_system", String.valueOf(view_tradeorders.getBuy_system()));
        json.put("buy_location", String.valueOf(view_tradeorders.getBuy_location()));
        json.put("buy_volume_remain", String.valueOf(view_tradeorders.getBuy_volume_remain()));
        json.put("buy_price", view_tradeorders.getBuy_price());
        json.put("jumps", view_tradeorders.getJumps());
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    public static View_tradeorders toView_tradeorders(JSONObject json) {
        View_tradeorders view_tradeorders = new View_tradeorders();
        view_tradeorders.setTradevolume(JSONConversion.getlong(json, "tradevolume"));
        view_tradeorders.setBuy_totalprice(JSONConversion.getdouble(json, "buy_totalprice"));
        view_tradeorders.setSell_totalprice(JSONConversion.getdouble(json, "sell_totalprice"));
        view_tradeorders.setCargo_volume(JSONConversion.getdouble(json, "cargo_volume"));
        view_tradeorders.setSell_id(JSONConversion.getlong(json, "sell_id"));
        view_tradeorders.setSell_system(JSONConversion.getlong(json, "sell_system"));
        view_tradeorders.setSell_location(JSONConversion.getlong(json, "sell_location"));
        view_tradeorders.setSell_evetype(JSONConversion.getlong(json, "sell_evetype"));
        view_tradeorders.setSell_packaged_volume(JSONConversion.getdouble(json, "sell_packaged_volume"));
        view_tradeorders.setSell_volume_remain(JSONConversion.getlong(json, "sell_volume_remain"));
        view_tradeorders.setSell_price(JSONConversion.getdouble(json, "sell_price"));
        view_tradeorders.setSecurity_island(JSONConversion.getlong(json, "security_island"));
        view_tradeorders.setBuy_id(JSONConversion.getlong(json, "buy_id"));
        view_tradeorders.setBuy_system(JSONConversion.getlong(json, "buy_system"));
        view_tradeorders.setBuy_location(JSONConversion.getlong(json, "buy_location"));
        view_tradeorders.setBuy_volume_remain(JSONConversion.getlong(json, "buy_volume_remain"));
        view_tradeorders.setBuy_price(JSONConversion.getdouble(json, "buy_price"));
        view_tradeorders.setJumps(JSONConversion.getint(json, "jumps"));
        return view_tradeorders;
    }

    /**
     * 
     * @param json: JSONObject with the View_tradeorderssearch parameters
     * @return 
     */
    public static View_tradeorderssearch toView_tradeorderssearch(JSONObject json) {
        View_tradeorderssearch view_tradeorderssearch = new View_tradeorderssearch();
        view_tradeorderssearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        view_tradeorderssearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        view_tradeorderssearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("tradevolume");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradeorderssearch.tradevolume(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("buy_totalprice");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradeorderssearch.buy_totalprice(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("sell_totalprice");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradeorderssearch.sell_totalprice(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("cargo_volume");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradeorderssearch.cargo_volume(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("sell_id");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradeorderssearch.sell_id(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("sell_system");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradeorderssearch.sell_system(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("sell_location");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradeorderssearch.sell_location(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("sell_evetype");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradeorderssearch.sell_evetype(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("sell_packaged_volume");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradeorderssearch.sell_packaged_volume(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("sell_volume_remain");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradeorderssearch.sell_volume_remain(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("sell_price");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradeorderssearch.sell_price(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("security_island");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradeorderssearch.security_island(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("buy_id");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradeorderssearch.buy_id(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("buy_system");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradeorderssearch.buy_system(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("buy_location");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradeorderssearch.buy_location(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("buy_volume_remain");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradeorderssearch.buy_volume_remain(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("buy_price");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradeorderssearch.buy_price(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("jumps");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradeorderssearch.jumps(valuearray, operators, andor);
        }
        return view_tradeorderssearch;
    }
}

