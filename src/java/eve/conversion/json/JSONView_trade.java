/*
 * JSONView_trade.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 4.11.2021 14:51
 *
 */
 
package eve.conversion.json;

import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import eve.interfaces.logicview.IView_trade;
import eve.logicview.View_trade;
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
public class JSONView_trade {
    
    public static JSONArray toJSONArray(ArrayList view_trades) {
        JSONArray jsonview_trades = new JSONArray();
        Iterator view_tradesI = view_trades.iterator();
        while(view_tradesI.hasNext()) {
            jsonview_trades.add(JSONView_trade.toJSON((View_trade)view_tradesI.next()));
        }
        return jsonview_trades;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(IView_trade view_trade) {
        JSONObject json = new JSONObject();
        json.put("sell_regionid", String.valueOf(view_trade.getSell_regionid()));
        json.put("sell_regionname", view_trade.getSell_regionname());
        json.put("sell_systemid", String.valueOf(view_trade.getSell_systemid()));
        json.put("sell_systemname", view_trade.getSell_systemname());
        json.put("sell_locationid", String.valueOf(view_trade.getSell_locationid()));
        json.put("sell_stationname", view_trade.getSell_stationname());
        json.put("evetype_id", String.valueOf(view_trade.getEvetype_id()));
        json.put("evetype_name", view_trade.getEvetype_name());
        json.put("packaged_volume", view_trade.getPackaged_volume());
        json.put("sell_id", String.valueOf(view_trade.getSell_id()));
        json.put("buy_id", String.valueOf(view_trade.getBuy_id()));
        json.put("sell_volume_remain", String.valueOf(view_trade.getSell_volume_remain()));
        json.put("sell_price", view_trade.getSell_price());
        json.put("buy_price", view_trade.getBuy_price());
        json.put("buy_systemid", String.valueOf(view_trade.getBuy_systemid()));
        json.put("buy_systemname", view_trade.getBuy_systemname());
        json.put("buy_locationid", String.valueOf(view_trade.getBuy_locationid()));
        json.put("buy_stationname", view_trade.getBuy_stationname());
        json.put("buy_volume_remain", String.valueOf(view_trade.getBuy_volume_remain()));
        json.put("total_volume", view_trade.getTotal_volume());
        json.put("sell_total", view_trade.getSell_total());
        json.put("buy_total", view_trade.getBuy_total());
        json.put("trade_profit", view_trade.getTrade_profit());
        json.put("trade_jumps", view_trade.getTrade_jumps());
        json.put("trade_profit_per_jump", view_trade.getTrade_profit_per_jump());
        json.put("trade_runs", view_trade.getTrade_runs());
        json.put("trade_total_jumps", view_trade.getTrade_total_jumps());
        json.put("trade_singlerunprofit", view_trade.getTrade_singlerunprofit());
        json.put("trade_maxunits_per_run", view_trade.getTrade_maxunits_per_run());
//Custom code, do not change this line
        json.put("start_system", String.valueOf(view_trade.getStart_system()));
        json.put("start_system_jumps", view_trade.getStart_system_jumps());
//Custom code, do not change this line
        return json;
    }

    public static View_trade toView_trade(JSONObject json) {
        View_trade view_trade = new View_trade();
        view_trade.setSell_regionid(JSONConversion.getlong(json, "sell_regionid"));
        view_trade.setSell_regionname(JSONConversion.getString(json, "sell_regionname"));
        view_trade.setSell_systemid(JSONConversion.getlong(json, "sell_systemid"));
        view_trade.setSell_systemname(JSONConversion.getString(json, "sell_systemname"));
        view_trade.setSell_locationid(JSONConversion.getlong(json, "sell_locationid"));
        view_trade.setSell_stationname(JSONConversion.getString(json, "sell_stationname"));
        view_trade.setEvetype_id(JSONConversion.getlong(json, "evetype_id"));
        view_trade.setEvetype_name(JSONConversion.getString(json, "evetype_name"));
        view_trade.setPackaged_volume(JSONConversion.getdouble(json, "packaged_volume"));
        view_trade.setSell_id(JSONConversion.getlong(json, "sell_id"));
        view_trade.setBuy_id(JSONConversion.getlong(json, "buy_id"));
        view_trade.setSell_volume_remain(JSONConversion.getlong(json, "sell_volume_remain"));
        view_trade.setSell_price(JSONConversion.getdouble(json, "sell_price"));
        view_trade.setBuy_price(JSONConversion.getdouble(json, "buy_price"));
        view_trade.setBuy_systemid(JSONConversion.getlong(json, "buy_systemid"));
        view_trade.setBuy_systemname(JSONConversion.getString(json, "buy_systemname"));
        view_trade.setBuy_locationid(JSONConversion.getlong(json, "buy_locationid"));
        view_trade.setBuy_stationname(JSONConversion.getString(json, "buy_stationname"));
        view_trade.setBuy_volume_remain(JSONConversion.getlong(json, "buy_volume_remain"));
        view_trade.setTotal_volume(JSONConversion.getdouble(json, "total_volume"));
        view_trade.setSell_total(JSONConversion.getdouble(json, "sell_total"));
        view_trade.setBuy_total(JSONConversion.getdouble(json, "buy_total"));
        view_trade.setTrade_profit(JSONConversion.getdouble(json, "trade_profit"));
        view_trade.setTrade_jumps(JSONConversion.getint(json, "trade_jumps"));
        view_trade.setTrade_profit_per_jump(JSONConversion.getdouble(json, "trade_profit_per_jump"));
        view_trade.setTrade_runs(JSONConversion.getint(json, "trade_runs"));
        view_trade.setTrade_total_jumps(JSONConversion.getint(json, "trade_total_jumps"));
        view_trade.setTrade_singlerunprofit(JSONConversion.getdouble(json, "trade_singlerunprofit"));
        view_trade.setTrade_maxunits_per_run(JSONConversion.getint(json, "trade_maxunits_per_run"));
        return view_trade;
    }

    /**
     * 
     * @param json: JSONObject with the View_tradesearch parameters
     * @return 
     */
    public static View_tradesearch toView_tradesearch(JSONObject json) {
        View_tradesearch view_tradesearch = new View_tradesearch();
        view_tradesearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        view_tradesearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        view_tradesearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("sell_regionid");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradesearch.sell_regionid(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("sell_regionname");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradesearch.sell_regionname(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("sell_systemid");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradesearch.sell_systemid(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("sell_systemname");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradesearch.sell_systemname(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("sell_locationid");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradesearch.sell_locationid(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("sell_stationname");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradesearch.sell_stationname(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("evetype_id");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradesearch.evetype_id(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("evetype_name");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradesearch.evetype_name(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("packaged_volume");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradesearch.packaged_volume(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("sell_id");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradesearch.sell_id(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("buy_id");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradesearch.buy_id(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("sell_volume_remain");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradesearch.sell_volume_remain(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("sell_price");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradesearch.sell_price(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("buy_price");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradesearch.buy_price(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("buy_systemid");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradesearch.buy_systemid(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("buy_systemname");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradesearch.buy_systemname(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("buy_locationid");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradesearch.buy_locationid(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("buy_stationname");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradesearch.buy_stationname(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("buy_volume_remain");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradesearch.buy_volume_remain(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("total_volume");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradesearch.total_volume(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("sell_total");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradesearch.sell_total(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("buy_total");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradesearch.buy_total(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("trade_profit");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradesearch.trade_profit(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("trade_jumps");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradesearch.trade_jumps(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("trade_profit_per_jump");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradesearch.trade_profit_per_jump(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("trade_runs");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradesearch.trade_runs(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("trade_total_jumps");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradesearch.trade_total_jumps(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("trade_singlerunprofit");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradesearch.trade_singlerunprofit(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("trade_maxunits_per_run");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradesearch.trade_maxunits_per_run(valuearray, operators, andor);
        }
        return view_tradesearch;
    }
}

