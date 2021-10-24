/*
 * JSONView_systemtrade.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 24.9.2021 14:40
 *
 */
 
package eve.conversion.json;

import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import eve.interfaces.logicview.IView_systemtrade;
import eve.logicview.View_systemtrade;
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
public class JSONView_systemtrade {
    
    public static JSONArray toJSONArray(ArrayList view_systemtrades) {
        JSONArray jsonview_systemtrades = new JSONArray();
        Iterator view_systemtradesI = view_systemtrades.iterator();
        while(view_systemtradesI.hasNext()) {
            jsonview_systemtrades.add(JSONView_systemtrade.toJSON((View_systemtrade)view_systemtradesI.next()));
        }
        return jsonview_systemtrades;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(IView_systemtrade view_systemtrade) {
        JSONObject json = new JSONObject();
        json.put("sell_system", String.valueOf(view_systemtrade.getSell_system()));
        json.put("buy_system", String.valueOf(view_systemtrade.getBuy_system()));
        json.put("ordercount", String.valueOf(view_systemtrade.getOrdercount()));
        json.put("totalsell", view_systemtrade.getTotalsell());
        json.put("totalbuy", view_systemtrade.getTotalbuy());
        json.put("profit", view_systemtrade.getProfit());
        json.put("total_cargo_volume", view_systemtrade.getTotal_cargo_volume());
        json.put("jumps", view_systemtrade.getJumps());
        json.put("regionsellname", view_systemtrade.getRegionsellname());
        json.put("systemsellname", view_systemtrade.getSystemsellname());
        json.put("regionbuyname", view_systemtrade.getRegionbuyname());
        json.put("systembuyname", view_systemtrade.getSystembuyname());
//Custom code, do not change this line
        json.put("start_system", String.valueOf(view_systemtrade.getStart_system()));
        json.put("start_system_jumps", view_systemtrade.getStart_system_jumps());
//Custom code, do not change this line
        return json;
    }

    public static View_systemtrade toView_systemtrade(JSONObject json) {
        View_systemtrade view_systemtrade = new View_systemtrade();
        view_systemtrade.setSell_system(JSONConversion.getlong(json, "sell_system"));
        view_systemtrade.setBuy_system(JSONConversion.getlong(json, "buy_system"));
        view_systemtrade.setOrdercount(JSONConversion.getlong(json, "ordercount"));
        view_systemtrade.setTotalsell(JSONConversion.getdouble(json, "totalsell"));
        view_systemtrade.setTotalbuy(JSONConversion.getdouble(json, "totalbuy"));
        view_systemtrade.setProfit(JSONConversion.getdouble(json, "profit"));
        view_systemtrade.setTotal_cargo_volume(JSONConversion.getdouble(json, "total_cargo_volume"));
        view_systemtrade.setJumps(JSONConversion.getint(json, "jumps"));
        view_systemtrade.setRegionsellname(JSONConversion.getString(json, "regionsellname"));
        view_systemtrade.setSystemsellname(JSONConversion.getString(json, "systemsellname"));
        view_systemtrade.setRegionbuyname(JSONConversion.getString(json, "regionbuyname"));
        view_systemtrade.setSystembuyname(JSONConversion.getString(json, "systembuyname"));
        return view_systemtrade;
    }

    /**
     * 
     * @param json: JSONObject with the View_systemtradesearch parameters
     * @return 
     */
    public static View_systemtradesearch toView_systemtradesearch(JSONObject json) {
        View_systemtradesearch view_systemtradesearch = new View_systemtradesearch();
        view_systemtradesearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        view_systemtradesearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        view_systemtradesearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("sell_system");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_systemtradesearch.sell_system(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("buy_system");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_systemtradesearch.buy_system(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("ordercount");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_systemtradesearch.ordercount(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("totalsell");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_systemtradesearch.totalsell(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("totalbuy");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_systemtradesearch.totalbuy(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("profit");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_systemtradesearch.profit(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("total_cargo_volume");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_systemtradesearch.total_cargo_volume(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("jumps");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_systemtradesearch.jumps(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("regionsellname");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_systemtradesearch.regionsellname(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("systemsellname");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_systemtradesearch.systemsellname(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("regionbuyname");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_systemtradesearch.regionbuyname(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("systembuyname");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_systemtradesearch.systembuyname(valuearray, compareoperator, andor);
        }
        return view_systemtradesearch;
    }
}

