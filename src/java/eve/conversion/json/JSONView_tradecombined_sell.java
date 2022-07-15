/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 13.6.2022 11:21
 */
 
package eve.conversion.json;

import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import eve.interfaces.logicview.IView_tradecombined_sell;
import eve.logicview.View_tradecombined_sell;
import eve.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * @author Franky Laseure
 */
public class JSONView_tradecombined_sell {
    
    public static JSONArray toJSONArray(ArrayList view_tradecombined_sells) {
        JSONArray jsonview_tradecombined_sells = new JSONArray();
        Iterator view_tradecombined_sellsI = view_tradecombined_sells.iterator();
        while(view_tradecombined_sellsI.hasNext()) {
            jsonview_tradecombined_sells.add(JSONView_tradecombined_sell.toJSON((View_tradecombined_sell)view_tradecombined_sellsI.next()));
        }
        return jsonview_tradecombined_sells;
    }

    public static JSONObject toJSON(IView_tradecombined_sell view_tradecombined_sell) {
        JSONObject json = new JSONObject();
        json.put("sell_system", String.valueOf(view_tradecombined_sell.getSell_system()));
        json.put("buy_system", String.valueOf(view_tradecombined_sell.getBuy_system()));
        json.put("orderamount", String.valueOf(view_tradecombined_sell.getOrderamount()));
        json.put("buy_order_value", view_tradecombined_sell.getBuy_order_value());
        json.put("sell_order_value", view_tradecombined_sell.getSell_order_value());
        json.put("profit", view_tradecombined_sell.getProfit());
        json.put("sell_locationid", String.valueOf(view_tradecombined_sell.getSell_locationid()));
        json.put("sell_stationname", view_tradecombined_sell.getSell_stationname());
        json.put("evetype_id", String.valueOf(view_tradecombined_sell.getEvetype_id()));
        json.put("evetype_name", view_tradecombined_sell.getEvetype_name());
        json.put("packaged_volume", view_tradecombined_sell.getPackaged_volume());
        json.put("sell_id", String.valueOf(view_tradecombined_sell.getSell_id()));
        json.put("sell_volume_total", String.valueOf(view_tradecombined_sell.getSell_volume_total()));
        json.put("sell_volume_remain", String.valueOf(view_tradecombined_sell.getSell_volume_remain()));
        json.put("sell_min_volume", view_tradecombined_sell.getSell_min_volume());
        json.put("sell_updated", String.valueOf(view_tradecombined_sell.getSell_updated()));
        json.put("buy_id", String.valueOf(view_tradecombined_sell.getBuy_id()));
        json.put("sell_price", view_tradecombined_sell.getSell_price());
        json.put("buy_volume_total", String.valueOf(view_tradecombined_sell.getBuy_volume_total()));
        json.put("buy_volume_remain", String.valueOf(view_tradecombined_sell.getBuy_volume_remain()));
        json.put("buy_min_volume", view_tradecombined_sell.getBuy_min_volume());
        json.put("buy_updated", String.valueOf(view_tradecombined_sell.getBuy_updated()));
        json.put("buy_price", view_tradecombined_sell.getBuy_price());
        json.put("buy_locationid", String.valueOf(view_tradecombined_sell.getBuy_locationid()));
        json.put("buy_stationname", view_tradecombined_sell.getBuy_stationname());
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    public static View_tradecombined_sell toView_tradecombined_sell(JSONObject json) {
        View_tradecombined_sell view_tradecombined_sell = new View_tradecombined_sell();
        view_tradecombined_sell.setSell_system(JSONConversion.getlong(json, "sell_system"));
        view_tradecombined_sell.setBuy_system(JSONConversion.getlong(json, "buy_system"));
        view_tradecombined_sell.setOrderamount(JSONConversion.getlong(json, "orderamount"));
        view_tradecombined_sell.setBuy_order_value(JSONConversion.getdouble(json, "buy_order_value"));
        view_tradecombined_sell.setSell_order_value(JSONConversion.getdouble(json, "sell_order_value"));
        view_tradecombined_sell.setProfit(JSONConversion.getdouble(json, "profit"));
        view_tradecombined_sell.setSell_locationid(JSONConversion.getlong(json, "sell_locationid"));
        view_tradecombined_sell.setSell_stationname(JSONConversion.getString(json, "sell_stationname"));
        view_tradecombined_sell.setEvetype_id(JSONConversion.getlong(json, "evetype_id"));
        view_tradecombined_sell.setEvetype_name(JSONConversion.getString(json, "evetype_name"));
        view_tradecombined_sell.setPackaged_volume(JSONConversion.getdouble(json, "packaged_volume"));
        view_tradecombined_sell.setSell_id(JSONConversion.getlong(json, "sell_id"));
        view_tradecombined_sell.setSell_volume_total(JSONConversion.getlong(json, "sell_volume_total"));
        view_tradecombined_sell.setSell_volume_remain(JSONConversion.getlong(json, "sell_volume_remain"));
        view_tradecombined_sell.setSell_min_volume(JSONConversion.getint(json, "sell_min_volume"));
        view_tradecombined_sell.setSell_updated(JSONConversion.getlong(json, "sell_updated"));
        view_tradecombined_sell.setBuy_id(JSONConversion.getlong(json, "buy_id"));
        view_tradecombined_sell.setSell_price(JSONConversion.getdouble(json, "sell_price"));
        view_tradecombined_sell.setBuy_volume_total(JSONConversion.getlong(json, "buy_volume_total"));
        view_tradecombined_sell.setBuy_volume_remain(JSONConversion.getlong(json, "buy_volume_remain"));
        view_tradecombined_sell.setBuy_min_volume(JSONConversion.getint(json, "buy_min_volume"));
        view_tradecombined_sell.setBuy_updated(JSONConversion.getlong(json, "buy_updated"));
        view_tradecombined_sell.setBuy_price(JSONConversion.getdouble(json, "buy_price"));
        view_tradecombined_sell.setBuy_locationid(JSONConversion.getlong(json, "buy_locationid"));
        view_tradecombined_sell.setBuy_stationname(JSONConversion.getString(json, "buy_stationname"));
        return view_tradecombined_sell;
    }

    public static View_tradecombined_sellsearch toView_tradecombined_sellsearch(JSONObject json) {
        View_tradecombined_sellsearch view_tradecombined_sellsearch = new View_tradecombined_sellsearch();
        view_tradecombined_sellsearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        view_tradecombined_sellsearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        view_tradecombined_sellsearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("sell_system");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradecombined_sellsearch.sell_system(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("buy_system");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradecombined_sellsearch.buy_system(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("orderamount");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradecombined_sellsearch.orderamount(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("buy_order_value");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradecombined_sellsearch.buy_order_value(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("sell_order_value");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradecombined_sellsearch.sell_order_value(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("profit");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradecombined_sellsearch.profit(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("sell_locationid");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradecombined_sellsearch.sell_locationid(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("sell_stationname");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradecombined_sellsearch.sell_stationname(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("evetype_id");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradecombined_sellsearch.evetype_id(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("evetype_name");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradecombined_sellsearch.evetype_name(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("packaged_volume");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradecombined_sellsearch.packaged_volume(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("sell_id");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradecombined_sellsearch.sell_id(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("sell_volume_total");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradecombined_sellsearch.sell_volume_total(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("sell_volume_remain");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradecombined_sellsearch.sell_volume_remain(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("sell_min_volume");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradecombined_sellsearch.sell_min_volume(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("sell_updated");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradecombined_sellsearch.sell_updated(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("buy_id");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradecombined_sellsearch.buy_id(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("sell_price");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradecombined_sellsearch.sell_price(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("buy_volume_total");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradecombined_sellsearch.buy_volume_total(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("buy_volume_remain");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradecombined_sellsearch.buy_volume_remain(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("buy_min_volume");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradecombined_sellsearch.buy_min_volume(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("buy_updated");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradecombined_sellsearch.buy_updated(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("buy_price");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradecombined_sellsearch.buy_price(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("buy_locationid");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradecombined_sellsearch.buy_locationid(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("buy_stationname");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradecombined_sellsearch.buy_stationname(valuearray, compareoperator, andor);
        }
        return view_tradecombined_sellsearch;
    }
}

