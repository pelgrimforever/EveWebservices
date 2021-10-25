/*
 * JSONView_combinedtrade.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 25.9.2021 15:16
 *
 */
 
package eve.conversion.json;

import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import eve.interfaces.logicview.IView_combinedtrade;
import eve.logicview.View_combinedtrade;
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
public class JSONView_combinedtrade {
    
    public static JSONArray toJSONArray(ArrayList view_combinedtrades) {
        JSONArray jsonview_combinedtrades = new JSONArray();
        Iterator view_combinedtradesI = view_combinedtrades.iterator();
        while(view_combinedtradesI.hasNext()) {
            jsonview_combinedtrades.add(JSONView_combinedtrade.toJSON((View_combinedtrade)view_combinedtradesI.next()));
        }
        return jsonview_combinedtrades;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(IView_combinedtrade view_combinedtrade) {
        JSONObject json = new JSONObject();
        json.put("sellregion", view_combinedtrade.getSellregion());
        json.put("buyregion", view_combinedtrade.getBuyregion());
        json.put("sell_systemid", String.valueOf(view_combinedtrade.getSell_systemid()));
        json.put("sellsystem", view_combinedtrade.getSellsystem());
        json.put("buy_systemid", String.valueOf(view_combinedtrade.getBuy_systemid()));
        json.put("buysystem", view_combinedtrade.getBuysystem());
        json.put("total_volume", view_combinedtrade.getTotal_volume());
        json.put("buy_order_value", view_combinedtrade.getBuy_order_value());
        json.put("sell_order_value", view_combinedtrade.getSell_order_value());
        json.put("profit", view_combinedtrade.getProfit());
        json.put("jumps", view_combinedtrade.getJumps());
        json.put("runs", String.valueOf(view_combinedtrade.getRuns()));
        json.put("ordercount", String.valueOf(view_combinedtrade.getOrdercount()));
//Custom code, do not change this line
        json.put("start_system", String.valueOf(view_combinedtrade.getStart_system()));
        json.put("start_system_jumps", view_combinedtrade.getStart_system_jumps());
//Custom code, do not change this line
        return json;
    }

    public static View_combinedtrade toView_combinedtrade(JSONObject json) {
        View_combinedtrade view_combinedtrade = new View_combinedtrade();
        view_combinedtrade.setSellregion(JSONConversion.getString(json, "sellregion"));
        view_combinedtrade.setBuyregion(JSONConversion.getString(json, "buyregion"));
        view_combinedtrade.setSell_systemid(JSONConversion.getlong(json, "sell_systemid"));
        view_combinedtrade.setSellsystem(JSONConversion.getString(json, "sellsystem"));
        view_combinedtrade.setBuy_systemid(JSONConversion.getlong(json, "buy_systemid"));
        view_combinedtrade.setBuysystem(JSONConversion.getString(json, "buysystem"));
        view_combinedtrade.setTotal_volume(JSONConversion.getdouble(json, "total_volume"));
        view_combinedtrade.setBuy_order_value(JSONConversion.getdouble(json, "buy_order_value"));
        view_combinedtrade.setSell_order_value(JSONConversion.getdouble(json, "sell_order_value"));
        view_combinedtrade.setProfit(JSONConversion.getdouble(json, "profit"));
        view_combinedtrade.setJumps(JSONConversion.getint(json, "jumps"));
        view_combinedtrade.setRuns(JSONConversion.getlong(json, "runs"));
        view_combinedtrade.setOrdercount(JSONConversion.getlong(json, "ordercount"));
        return view_combinedtrade;
    }

    /**
     * 
     * @param json: JSONObject with the View_combinedtradesearch parameters
     * @return 
     */
    public static View_combinedtradesearch toView_combinedtradesearch(JSONObject json) {
        View_combinedtradesearch view_combinedtradesearch = new View_combinedtradesearch();
        view_combinedtradesearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        view_combinedtradesearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        view_combinedtradesearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("sellregion");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_combinedtradesearch.sellregion(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("buyregion");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_combinedtradesearch.buyregion(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("sell_systemid");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_combinedtradesearch.sell_systemid(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("sellsystem");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_combinedtradesearch.sellsystem(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("buy_systemid");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_combinedtradesearch.buy_systemid(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("buysystem");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_combinedtradesearch.buysystem(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("total_volume");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_combinedtradesearch.total_volume(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("buy_order_value");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_combinedtradesearch.buy_order_value(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("sell_order_value");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_combinedtradesearch.sell_order_value(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("profit");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_combinedtradesearch.profit(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("jumps");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_combinedtradesearch.jumps(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("runs");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_combinedtradesearch.runs(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("ordercount");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_combinedtradesearch.ordercount(valuearray, operators, andor);
        }
        return view_combinedtradesearch;
    }
}

