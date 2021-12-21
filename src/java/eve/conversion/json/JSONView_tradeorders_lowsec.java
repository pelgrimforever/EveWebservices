/*
 * JSONView_tradeorders_lowsec.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 16.11.2021 15:46
 *
 */
 
package eve.conversion.json;

import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import eve.interfaces.logicview.IView_tradeorders_lowsec;
import eve.logicview.View_tradeorders_lowsec;
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
public class JSONView_tradeorders_lowsec {
    
    public static JSONArray toJSONArray(ArrayList view_tradeorders_lowsecs) {
        JSONArray jsonview_tradeorders_lowsecs = new JSONArray();
        Iterator view_tradeorders_lowsecsI = view_tradeorders_lowsecs.iterator();
        while(view_tradeorders_lowsecsI.hasNext()) {
            jsonview_tradeorders_lowsecs.add(JSONView_tradeorders_lowsec.toJSON((View_tradeorders_lowsec)view_tradeorders_lowsecsI.next()));
        }
        return jsonview_tradeorders_lowsecs;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(IView_tradeorders_lowsec view_tradeorders_lowsec) {
        JSONObject json = new JSONObject();
        json.put("tradevolume", String.valueOf(view_tradeorders_lowsec.getTradevolume()));
        json.put("buy_totalprice", view_tradeorders_lowsec.getBuy_totalprice());
        json.put("sell_totalprice", view_tradeorders_lowsec.getSell_totalprice());
        json.put("cargo_volume", view_tradeorders_lowsec.getCargo_volume());
        json.put("sell_id", String.valueOf(view_tradeorders_lowsec.getSell_id()));
        json.put("sell_system", String.valueOf(view_tradeorders_lowsec.getSell_system()));
        json.put("sell_location", String.valueOf(view_tradeorders_lowsec.getSell_location()));
        json.put("sell_evetype", String.valueOf(view_tradeorders_lowsec.getSell_evetype()));
        json.put("sell_packaged_volume", view_tradeorders_lowsec.getSell_packaged_volume());
        json.put("sell_volume_remain", String.valueOf(view_tradeorders_lowsec.getSell_volume_remain()));
        json.put("sell_price", view_tradeorders_lowsec.getSell_price());
        json.put("security_island", String.valueOf(view_tradeorders_lowsec.getSecurity_island()));
        json.put("buy_id", String.valueOf(view_tradeorders_lowsec.getBuy_id()));
        json.put("buy_system", String.valueOf(view_tradeorders_lowsec.getBuy_system()));
        json.put("buy_location", String.valueOf(view_tradeorders_lowsec.getBuy_location()));
        json.put("buy_volume_remain", String.valueOf(view_tradeorders_lowsec.getBuy_volume_remain()));
        json.put("buy_price", view_tradeorders_lowsec.getBuy_price());
        json.put("jumps", view_tradeorders_lowsec.getJumps());
        json.put("jumpslowsec", view_tradeorders_lowsec.getJumpslowsec());
        json.put("jumpsnullsec", view_tradeorders_lowsec.getJumpsnullsec());
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    public static View_tradeorders_lowsec toView_tradeorders_lowsec(JSONObject json) {
        View_tradeorders_lowsec view_tradeorders_lowsec = new View_tradeorders_lowsec();
        view_tradeorders_lowsec.setTradevolume(JSONConversion.getlong(json, "tradevolume"));
        view_tradeorders_lowsec.setBuy_totalprice(JSONConversion.getdouble(json, "buy_totalprice"));
        view_tradeorders_lowsec.setSell_totalprice(JSONConversion.getdouble(json, "sell_totalprice"));
        view_tradeorders_lowsec.setCargo_volume(JSONConversion.getdouble(json, "cargo_volume"));
        view_tradeorders_lowsec.setSell_id(JSONConversion.getlong(json, "sell_id"));
        view_tradeorders_lowsec.setSell_system(JSONConversion.getlong(json, "sell_system"));
        view_tradeorders_lowsec.setSell_location(JSONConversion.getlong(json, "sell_location"));
        view_tradeorders_lowsec.setSell_evetype(JSONConversion.getlong(json, "sell_evetype"));
        view_tradeorders_lowsec.setSell_packaged_volume(JSONConversion.getdouble(json, "sell_packaged_volume"));
        view_tradeorders_lowsec.setSell_volume_remain(JSONConversion.getlong(json, "sell_volume_remain"));
        view_tradeorders_lowsec.setSell_price(JSONConversion.getdouble(json, "sell_price"));
        view_tradeorders_lowsec.setSecurity_island(JSONConversion.getlong(json, "security_island"));
        view_tradeorders_lowsec.setBuy_id(JSONConversion.getlong(json, "buy_id"));
        view_tradeorders_lowsec.setBuy_system(JSONConversion.getlong(json, "buy_system"));
        view_tradeorders_lowsec.setBuy_location(JSONConversion.getlong(json, "buy_location"));
        view_tradeorders_lowsec.setBuy_volume_remain(JSONConversion.getlong(json, "buy_volume_remain"));
        view_tradeorders_lowsec.setBuy_price(JSONConversion.getdouble(json, "buy_price"));
        view_tradeorders_lowsec.setJumps(JSONConversion.getint(json, "jumps"));
        view_tradeorders_lowsec.setJumpslowsec(JSONConversion.getint(json, "jumpslowsec"));
        view_tradeorders_lowsec.setJumpsnullsec(JSONConversion.getint(json, "jumpsnullsec"));
        return view_tradeorders_lowsec;
    }

    /**
     * 
     * @param json: JSONObject with the View_tradeorders_lowsecsearch parameters
     * @return 
     */
    public static View_tradeorders_lowsecsearch toView_tradeorders_lowsecsearch(JSONObject json) {
        View_tradeorders_lowsecsearch view_tradeorders_lowsecsearch = new View_tradeorders_lowsecsearch();
        view_tradeorders_lowsecsearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        view_tradeorders_lowsecsearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        view_tradeorders_lowsecsearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("tradevolume");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradeorders_lowsecsearch.tradevolume(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("buy_totalprice");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradeorders_lowsecsearch.buy_totalprice(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("sell_totalprice");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradeorders_lowsecsearch.sell_totalprice(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("cargo_volume");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradeorders_lowsecsearch.cargo_volume(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("sell_id");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradeorders_lowsecsearch.sell_id(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("sell_system");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradeorders_lowsecsearch.sell_system(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("sell_location");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradeorders_lowsecsearch.sell_location(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("sell_evetype");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradeorders_lowsecsearch.sell_evetype(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("sell_packaged_volume");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradeorders_lowsecsearch.sell_packaged_volume(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("sell_volume_remain");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradeorders_lowsecsearch.sell_volume_remain(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("sell_price");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradeorders_lowsecsearch.sell_price(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("security_island");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradeorders_lowsecsearch.security_island(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("buy_id");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradeorders_lowsecsearch.buy_id(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("buy_system");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradeorders_lowsecsearch.buy_system(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("buy_location");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradeorders_lowsecsearch.buy_location(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("buy_volume_remain");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradeorders_lowsecsearch.buy_volume_remain(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("buy_price");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradeorders_lowsecsearch.buy_price(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("jumps");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradeorders_lowsecsearch.jumps(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("jumpslowsec");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradeorders_lowsecsearch.jumpslowsec(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("jumpsnullsec");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradeorders_lowsecsearch.jumpsnullsec(valuearray, operators, andor);
        }
        return view_tradeorders_lowsecsearch;
    }
}

