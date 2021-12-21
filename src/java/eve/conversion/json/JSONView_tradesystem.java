/*
 * JSONView_tradesystem.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 16.11.2021 15:46
 *
 */
 
package eve.conversion.json;

import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import eve.interfaces.logicview.IView_tradesystem;
import eve.logicview.View_tradesystem;
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
public class JSONView_tradesystem {
    
    public static JSONArray toJSONArray(ArrayList view_tradesystems) {
        JSONArray jsonview_tradesystems = new JSONArray();
        Iterator view_tradesystemsI = view_tradesystems.iterator();
        while(view_tradesystemsI.hasNext()) {
            jsonview_tradesystems.add(JSONView_tradesystem.toJSON((View_tradesystem)view_tradesystemsI.next()));
        }
        return jsonview_tradesystems;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(IView_tradesystem view_tradesystem) {
        JSONObject json = new JSONObject();
        json.put("sell_regionid", String.valueOf(view_tradesystem.getSell_regionid()));
        json.put("sell_regionname", view_tradesystem.getSell_regionname());
        json.put("sell_systemid", String.valueOf(view_tradesystem.getSell_systemid()));
        json.put("sell_systemname", view_tradesystem.getSell_systemname());
        json.put("orders", view_tradesystem.getOrders());
        json.put("buy_total", view_tradesystem.getBuy_total());
        json.put("sell_total", view_tradesystem.getSell_total());
        json.put("totalprofit", view_tradesystem.getTotalprofit());
        json.put("totalvolume", view_tradesystem.getTotalvolume());
        json.put("buy_systemid", String.valueOf(view_tradesystem.getBuy_systemid()));
        json.put("buy_systemname", view_tradesystem.getBuy_systemname());
        json.put("trade_jumps", view_tradesystem.getTrade_jumps());
        json.put("trade_jumpslowsec", view_tradesystem.getTrade_jumpslowsec());
        json.put("trade_jumpsnullsec", view_tradesystem.getTrade_jumpsnullsec());
//Custom code, do not change this line
        json.put("start_system", String.valueOf(view_tradesystem.getStart_system()));
        json.put("start_system_jumps", view_tradesystem.getStart_system_jumps());
//Custom code, do not change this line
        return json;
    }

    public static View_tradesystem toView_tradesystem(JSONObject json) {
        View_tradesystem view_tradesystem = new View_tradesystem();
        view_tradesystem.setSell_regionid(JSONConversion.getlong(json, "sell_regionid"));
        view_tradesystem.setSell_regionname(JSONConversion.getString(json, "sell_regionname"));
        view_tradesystem.setSell_systemid(JSONConversion.getlong(json, "sell_systemid"));
        view_tradesystem.setSell_systemname(JSONConversion.getString(json, "sell_systemname"));
        view_tradesystem.setOrders(JSONConversion.getfloat(json, "orders"));
        view_tradesystem.setBuy_total(JSONConversion.getdouble(json, "buy_total"));
        view_tradesystem.setSell_total(JSONConversion.getdouble(json, "sell_total"));
        view_tradesystem.setTotalprofit(JSONConversion.getdouble(json, "totalprofit"));
        view_tradesystem.setTotalvolume(JSONConversion.getdouble(json, "totalvolume"));
        view_tradesystem.setBuy_systemid(JSONConversion.getlong(json, "buy_systemid"));
        view_tradesystem.setBuy_systemname(JSONConversion.getString(json, "buy_systemname"));
        view_tradesystem.setTrade_jumps(JSONConversion.getint(json, "trade_jumps"));
        view_tradesystem.setTrade_jumpslowsec(JSONConversion.getint(json, "trade_jumpslowsec"));
        view_tradesystem.setTrade_jumpsnullsec(JSONConversion.getint(json, "trade_jumpsnullsec"));
        return view_tradesystem;
    }

    /**
     * 
     * @param json: JSONObject with the View_tradesystemsearch parameters
     * @return 
     */
    public static View_tradesystemsearch toView_tradesystemsearch(JSONObject json) {
        View_tradesystemsearch view_tradesystemsearch = new View_tradesystemsearch();
        view_tradesystemsearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        view_tradesystemsearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        view_tradesystemsearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("sell_regionid");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradesystemsearch.sell_regionid(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("sell_regionname");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradesystemsearch.sell_regionname(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("sell_systemid");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradesystemsearch.sell_systemid(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("sell_systemname");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradesystemsearch.sell_systemname(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("orders");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradesystemsearch.orders(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("buy_total");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradesystemsearch.buy_total(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("sell_total");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradesystemsearch.sell_total(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("totalprofit");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradesystemsearch.totalprofit(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("totalvolume");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradesystemsearch.totalvolume(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("buy_systemid");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradesystemsearch.buy_systemid(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("buy_systemname");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradesystemsearch.buy_systemname(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("trade_jumps");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradesystemsearch.trade_jumps(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("trade_jumpslowsec");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradesystemsearch.trade_jumpslowsec(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("trade_jumpsnullsec");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradesystemsearch.trade_jumpsnullsec(valuearray, operators, andor);
        }
        return view_tradesystemsearch;
    }
}

