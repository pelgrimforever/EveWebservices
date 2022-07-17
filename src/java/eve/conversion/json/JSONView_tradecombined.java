/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 17.6.2022 13:4
 */
 
package eve.conversion.json;

import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import eve.interfaces.logicview.IView_tradecombined;
import eve.logicview.View_tradecombined;
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
public class JSONView_tradecombined {
    
    public static JSONArray toJSONArray(ArrayList view_tradecombineds) {
        JSONArray jsonview_tradecombineds = new JSONArray();
        Iterator view_tradecombinedsI = view_tradecombineds.iterator();
        while(view_tradecombinedsI.hasNext()) {
            jsonview_tradecombineds.add(JSONView_tradecombined.toJSON((View_tradecombined)view_tradecombinedsI.next()));
        }
        return jsonview_tradecombineds;
    }

    public static JSONObject toJSON(IView_tradecombined view_tradecombined) {
        JSONObject json = new JSONObject();
        json.put("sell_regionid", String.valueOf(view_tradecombined.getSell_regionid()));
        json.put("sell_regionname", view_tradecombined.getSell_regionname());
        json.put("sell_systemid", String.valueOf(view_tradecombined.getSell_systemid()));
        json.put("sell_systemname", view_tradecombined.getSell_systemname());
        json.put("evetype_id", String.valueOf(view_tradecombined.getEvetype_id()));
        json.put("evetype_name", view_tradecombined.getEvetype_name());
        json.put("packaged_volume", view_tradecombined.getPackaged_volume());
        json.put("orders", String.valueOf(view_tradecombined.getOrders()));
        json.put("totalamount", view_tradecombined.getTotalamount());
        json.put("buy_order_total", view_tradecombined.getBuy_order_total());
        json.put("sell_order_total", view_tradecombined.getSell_order_total());
        json.put("totalprofit", view_tradecombined.getTotalprofit());
        json.put("buy_systemid", String.valueOf(view_tradecombined.getBuy_systemid()));
        json.put("buy_systemname", view_tradecombined.getBuy_systemname());
        json.put("trade_jumps", view_tradecombined.getTrade_jumps());
        json.put("trade_jumpslowsec", view_tradecombined.getTrade_jumpslowsec());
        json.put("trade_jumpsnullsec", view_tradecombined.getTrade_jumpsnullsec());
//Custom code, do not change this line
        json.put("start_system", String.valueOf(view_tradecombined.getStart_system()));
        json.put("start_system_jumps", view_tradecombined.getStart_system_jumps());
//Custom code, do not change this line
        return json;
    }

    public static View_tradecombined toView_tradecombined(JSONObject json) {
        View_tradecombined view_tradecombined = new View_tradecombined();
        view_tradecombined.setSell_regionid(JSONConversion.getlong(json, "sell_regionid"));
        view_tradecombined.setSell_regionname(JSONConversion.getString(json, "sell_regionname"));
        view_tradecombined.setSell_systemid(JSONConversion.getlong(json, "sell_systemid"));
        view_tradecombined.setSell_systemname(JSONConversion.getString(json, "sell_systemname"));
        view_tradecombined.setEvetype_id(JSONConversion.getlong(json, "evetype_id"));
        view_tradecombined.setEvetype_name(JSONConversion.getString(json, "evetype_name"));
        view_tradecombined.setPackaged_volume(JSONConversion.getdouble(json, "packaged_volume"));
        view_tradecombined.setOrders(JSONConversion.getlong(json, "orders"));
        view_tradecombined.setTotalamount(JSONConversion.getfloat(json, "totalamount"));
        view_tradecombined.setBuy_order_total(JSONConversion.getdouble(json, "buy_order_total"));
        view_tradecombined.setSell_order_total(JSONConversion.getdouble(json, "sell_order_total"));
        view_tradecombined.setTotalprofit(JSONConversion.getdouble(json, "totalprofit"));
        view_tradecombined.setBuy_systemid(JSONConversion.getlong(json, "buy_systemid"));
        view_tradecombined.setBuy_systemname(JSONConversion.getString(json, "buy_systemname"));
        view_tradecombined.setTrade_jumps(JSONConversion.getint(json, "trade_jumps"));
        view_tradecombined.setTrade_jumpslowsec(JSONConversion.getint(json, "trade_jumpslowsec"));
        view_tradecombined.setTrade_jumpsnullsec(JSONConversion.getint(json, "trade_jumpsnullsec"));
        return view_tradecombined;
    }

    public static View_tradecombinedsearch toView_tradecombinedsearch(JSONObject json) {
        View_tradecombinedsearch view_tradecombinedsearch = new View_tradecombinedsearch();
        view_tradecombinedsearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        view_tradecombinedsearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        view_tradecombinedsearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("sell_regionid");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradecombinedsearch.sell_regionid(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("sell_regionname");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradecombinedsearch.sell_regionname(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("sell_systemid");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradecombinedsearch.sell_systemid(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("sell_systemname");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradecombinedsearch.sell_systemname(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("evetype_id");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradecombinedsearch.evetype_id(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("evetype_name");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradecombinedsearch.evetype_name(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("packaged_volume");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradecombinedsearch.packaged_volume(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("orders");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradecombinedsearch.orders(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("totalamount");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradecombinedsearch.totalamount(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("buy_order_total");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradecombinedsearch.buy_order_total(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("sell_order_total");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradecombinedsearch.sell_order_total(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("totalprofit");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradecombinedsearch.totalprofit(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("buy_systemid");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradecombinedsearch.buy_systemid(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("buy_systemname");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradecombinedsearch.buy_systemname(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("trade_jumps");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradecombinedsearch.trade_jumps(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("trade_jumpslowsec");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradecombinedsearch.trade_jumpslowsec(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("trade_jumpsnullsec");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_tradecombinedsearch.trade_jumpsnullsec(valuearray, operators, andor);
        }
        return view_tradecombinedsearch;
    }
}

