/*
 * JSONView_systemtrade_order.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 8.10.2021 7:21
 *
 */
 
package eve.conversion.json;

import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import eve.interfaces.logicview.IView_systemtrade_order;
import eve.logicview.View_systemtrade_order;
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
public class JSONView_systemtrade_order {
    
    public static JSONArray toJSONArray(ArrayList view_systemtrade_orders) {
        JSONArray jsonview_systemtrade_orders = new JSONArray();
        Iterator view_systemtrade_ordersI = view_systemtrade_orders.iterator();
        while(view_systemtrade_ordersI.hasNext()) {
            jsonview_systemtrade_orders.add(JSONView_systemtrade_order.toJSON((View_systemtrade_order)view_systemtrade_ordersI.next()));
        }
        return jsonview_systemtrade_orders;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(IView_systemtrade_order view_systemtrade_order) {
        JSONObject json = new JSONObject();
        json.put("sell_system", String.valueOf(view_systemtrade_order.getSell_system()));
        json.put("buy_system", String.valueOf(view_systemtrade_order.getBuy_system()));
        json.put("sell_order", String.valueOf(view_systemtrade_order.getSell_order()));
        json.put("buy_order", String.valueOf(view_systemtrade_order.getBuy_order()));
        json.put("amount", String.valueOf(view_systemtrade_order.getAmount()));
        json.put("sellprice", view_systemtrade_order.getSellprice());
        json.put("buyprice", view_systemtrade_order.getBuyprice());
        json.put("profit", view_systemtrade_order.getProfit());
        json.put("cargovolume", view_systemtrade_order.getCargovolume());
        json.put("evetype", String.valueOf(view_systemtrade_order.getEvetype()));
        json.put("evetypename", view_systemtrade_order.getEvetypename());
        json.put("sell_volume_remain", String.valueOf(view_systemtrade_order.getSell_volume_remain()));
        json.put("sell_price", view_systemtrade_order.getSell_price());
        json.put("sell_station", String.valueOf(view_systemtrade_order.getSell_station()));
        json.put("sell_stationname", view_systemtrade_order.getSell_stationname());
        json.put("buy_volume_remain", String.valueOf(view_systemtrade_order.getBuy_volume_remain()));
        json.put("buy_price", view_systemtrade_order.getBuy_price());
        json.put("buy_station", String.valueOf(view_systemtrade_order.getBuy_station()));
        json.put("buy_stationname", view_systemtrade_order.getBuy_stationname());
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    public static View_systemtrade_order toView_systemtrade_order(JSONObject json) {
        View_systemtrade_order view_systemtrade_order = new View_systemtrade_order();
        view_systemtrade_order.setSell_system(JSONConversion.getlong(json, "sell_system"));
        view_systemtrade_order.setBuy_system(JSONConversion.getlong(json, "buy_system"));
        view_systemtrade_order.setSell_order(JSONConversion.getlong(json, "sell_order"));
        view_systemtrade_order.setBuy_order(JSONConversion.getlong(json, "buy_order"));
        view_systemtrade_order.setAmount(JSONConversion.getlong(json, "amount"));
        view_systemtrade_order.setSellprice(JSONConversion.getdouble(json, "sellprice"));
        view_systemtrade_order.setBuyprice(JSONConversion.getdouble(json, "buyprice"));
        view_systemtrade_order.setProfit(JSONConversion.getdouble(json, "profit"));
        view_systemtrade_order.setCargovolume(JSONConversion.getdouble(json, "cargovolume"));
        view_systemtrade_order.setEvetype(JSONConversion.getlong(json, "evetype"));
        view_systemtrade_order.setEvetypename(JSONConversion.getString(json, "evetypename"));
        view_systemtrade_order.setSell_volume_remain(JSONConversion.getlong(json, "sell_volume_remain"));
        view_systemtrade_order.setSell_price(JSONConversion.getdouble(json, "sell_price"));
        view_systemtrade_order.setSell_station(JSONConversion.getlong(json, "sell_station"));
        view_systemtrade_order.setSell_stationname(JSONConversion.getString(json, "sell_stationname"));
        view_systemtrade_order.setBuy_volume_remain(JSONConversion.getlong(json, "buy_volume_remain"));
        view_systemtrade_order.setBuy_price(JSONConversion.getdouble(json, "buy_price"));
        view_systemtrade_order.setBuy_station(JSONConversion.getlong(json, "buy_station"));
        view_systemtrade_order.setBuy_stationname(JSONConversion.getString(json, "buy_stationname"));
        return view_systemtrade_order;
    }

    /**
     * 
     * @param json: JSONObject with the View_systemtrade_ordersearch parameters
     * @return 
     */
    public static View_systemtrade_ordersearch toView_systemtrade_ordersearch(JSONObject json) {
        View_systemtrade_ordersearch view_systemtrade_ordersearch = new View_systemtrade_ordersearch();
        view_systemtrade_ordersearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        view_systemtrade_ordersearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        view_systemtrade_ordersearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("sell_system");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_systemtrade_ordersearch.sell_system(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("buy_system");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_systemtrade_ordersearch.buy_system(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("sell_order");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_systemtrade_ordersearch.sell_order(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("buy_order");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_systemtrade_ordersearch.buy_order(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("amount");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_systemtrade_ordersearch.amount(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("sellprice");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_systemtrade_ordersearch.sellprice(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("buyprice");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_systemtrade_ordersearch.buyprice(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("profit");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_systemtrade_ordersearch.profit(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("cargovolume");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_systemtrade_ordersearch.cargovolume(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("evetype");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_systemtrade_ordersearch.evetype(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("evetypename");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_systemtrade_ordersearch.evetypename(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("sell_volume_remain");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_systemtrade_ordersearch.sell_volume_remain(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("sell_price");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_systemtrade_ordersearch.sell_price(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("sell_station");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_systemtrade_ordersearch.sell_station(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("sell_stationname");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_systemtrade_ordersearch.sell_stationname(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("buy_volume_remain");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_systemtrade_ordersearch.buy_volume_remain(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("buy_price");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_systemtrade_ordersearch.buy_price(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("buy_station");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_systemtrade_ordersearch.buy_station(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("buy_stationname");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_systemtrade_ordersearch.buy_stationname(valuearray, compareoperator, andor);
        }
        return view_systemtrade_ordersearch;
    }
}

