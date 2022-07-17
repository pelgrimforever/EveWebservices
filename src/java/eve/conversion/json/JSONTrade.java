/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 17.6.2022 13:4
 */
 
package eve.conversion.json;

import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.interfaces.db.EntityPK;
import data.interfaces.db.Fieldsearcher;
import data.json.piJson;
import eve.entity.pk.TradePK;
import eve.interfaces.entity.pk.ITradePK;
import eve.interfaces.logicentity.ITrade;
import eve.logicentity.Trade;
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
public class JSONTrade {
    
    public static JSONArray toJSONArray(ArrayList trades) {
        JSONArray jsontrades = new JSONArray();
        Iterator tradesI = trades.iterator();
        while(tradesI.hasNext()) {
            jsontrades.add(toJSON((Trade)tradesI.next()));
        }
        return jsontrades;
    }

    public static JSONObject toJSON(ITradePK tradePK) {
        JSONObject json = null;
        if(tradePK!=null) {
            json = new JSONObject();
            json.put("sell_order_id", String.valueOf(tradePK.getSell_order_id()));
            json.put("buy_order_id", String.valueOf(tradePK.getBuy_order_id()));
        }
        return json;
    }

    public static JSONObject toJSON(ITrade trade) {
        JSONObject json = new JSONObject();
        json.put("PK", toJSON(trade.getPrimaryKey()));
        json.put("total_volume", trade.getTotal_volume());
        json.put("buy_order_value", trade.getBuy_order_value());
        json.put("sell_order_value", trade.getSell_order_value());
        json.put("profit", trade.getProfit());
        json.put("jumps", trade.getJumps());
        json.put("runs", trade.getRuns());
        json.put("total_jumps", trade.getTotal_jumps());
        json.put("profit_per_jump", trade.getProfit_per_jump());
        json.put("singlerun_profit_per_jump", trade.getSinglerun_profit_per_jump());
        json.put("maxunits_per_run", trade.getMaxunits_per_run());
        json.put("jumpslowsec", trade.getJumpslowsec());
        json.put("jumpsnullsec", trade.getJumpsnullsec());
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    public static JSONObject toJSON(Tradesearch tradesearch) {
        JSONObject json = new JSONObject();
        if(tradesearch.used()) {
            byte andoroperator = tradesearch.getAndoroperator();
            int maxresults = tradesearch.getMaxresults();
            boolean docount = tradesearch.getDocount();
            Iterator<EntityPK> primarykeysI = tradesearch.getPrimarykeys().iterator();
            Iterator<Fieldsearcher> fieldsearchersI = tradesearch.getFieldsearchers().iterator();
            EntityPK primarykey;
            Fieldsearcher fieldsearcher;
            
            json.put("andor", andoroperator);
            json.put("maxresults", maxresults);
            json.put("docount", docount);
            JSONArray pks = new JSONArray();
            int i = 0;
            while(primarykeysI.hasNext()) {
                primarykey = primarykeysI.next();
                pks.add(primarykey.getKeystring());
            }
            json.put("primarykeys", pks);
            JSONObject fss = new JSONObject();
            while(fieldsearchersI.hasNext()) {
                fieldsearcher = fieldsearchersI.next();
                if(fieldsearcher.used()) {
                    fss.put(fieldsearcher.getShortFieldname(), JSONConversion.toJSON(fieldsearcher));
                }
            }
            json.put("fields", fss);
            JSONObject kss = new JSONObject();
            if(tradesearch.getOrderssell_order_idsearch()!=null && tradesearch.getOrderssell_order_idsearch().used()) {
                kss.put("ordersSell_order_idsearcher", JSONOrders.toJSON((Orderssearch)tradesearch.getOrderssell_order_idsearch()));
            }
            if(tradesearch.getOrdersbuy_order_idsearch()!=null && tradesearch.getOrdersbuy_order_idsearch().used()) {
                kss.put("ordersBuy_order_idsearcher", JSONOrders.toJSON((Orderssearch)tradesearch.getOrdersbuy_order_idsearch()));
            }
            json.put("keysearch", kss);
        }
        return json;
    }

    public static Tradesearch toTradesearch(JSONObject json) {
        Tradesearch tradesearch = new Tradesearch();
        tradesearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        tradesearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        tradesearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONArray pks = (JSONArray)json.get("primarykeys");
        for(int i=0; i<pks.size(); i++) {
            tradesearch.addPrimarykey(TradePK.getKey((String)pks.get(i)));
        }
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("total_volume");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            tradesearch.total_volume(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("buy_order_value");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            tradesearch.buy_order_value(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("sell_order_value");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            tradesearch.sell_order_value(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("profit");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            tradesearch.profit(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("jumps");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            tradesearch.jumps(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("runs");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            tradesearch.runs(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("total_jumps");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            tradesearch.total_jumps(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("profit_per_jump");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            tradesearch.profit_per_jump(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("singlerun_profit_per_jump");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            tradesearch.singlerun_profit_per_jump(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("maxunits_per_run");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            tradesearch.maxunits_per_run(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("jumpslowsec");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            tradesearch.jumpslowsec(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("jumpsnullsec");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            tradesearch.jumpsnullsec(valuearray, operators, andor);
        }
        JSONObject kss = (JSONObject)json.get("keysearch");
        JSONArray keysearch;
        keysearch = (JSONArray)kss.get("ordersSell_order_idsearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Orderssearch ordersSell_order_idsearch = JSONOrders.toOrderssearch((JSONObject)keysearch.get(i));
                tradesearch.ordersSell_order_id(ordersSell_order_idsearch);
            }
        }
        keysearch = (JSONArray)kss.get("ordersBuy_order_idsearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Orderssearch ordersBuy_order_idsearch = JSONOrders.toOrderssearch((JSONObject)keysearch.get(i));
                tradesearch.ordersBuy_order_id(ordersBuy_order_idsearch);
            }
        }
        return tradesearch;
    }
    
    public static TradePK toTradePK(JSONObject json) {
        TradePK tradePK = null;
        if(json!=null) {
            tradePK = new TradePK(JSONConversion.getlong(json, "sell_order_id"), JSONConversion.getlong(json, "buy_order_id"));
        }
        return tradePK;
    }

    public static Trade toTrade(JSONObject json) {
        Trade trade = new Trade(toTradePK((JSONObject)json.get("PK")));
        updateTrade(trade, json);
        return trade;
    }

    public static void updateTrade(ITrade trade, JSONObject json) {
        trade.setTotal_volume(JSONConversion.getdouble(json, "total_volume"));
        trade.setBuy_order_value(JSONConversion.getdouble(json, "buy_order_value"));
        trade.setSell_order_value(JSONConversion.getdouble(json, "sell_order_value"));
        trade.setProfit(JSONConversion.getdouble(json, "profit"));
        trade.setJumps(JSONConversion.getint(json, "jumps"));
        trade.setRuns(JSONConversion.getint(json, "runs"));
        trade.setTotal_jumps(JSONConversion.getint(json, "total_jumps"));
        trade.setProfit_per_jump(JSONConversion.getdouble(json, "profit_per_jump"));
        trade.setSinglerun_profit_per_jump(JSONConversion.getdouble(json, "singlerun_profit_per_jump"));
        trade.setMaxunits_per_run(JSONConversion.getint(json, "maxunits_per_run"));
        trade.setJumpslowsec(JSONConversion.getint(json, "jumpslowsec"));
        trade.setJumpsnullsec(JSONConversion.getint(json, "jumpsnullsec"));
    }

    public static Trade initTrade(JSONObject json) {
        Trade trade = new Trade(toTradePK((JSONObject)json.get("PK")));
        trade.initTotal_volume(JSONConversion.getdouble(json, "total_volume"));
        trade.initBuy_order_value(JSONConversion.getdouble(json, "buy_order_value"));
        trade.initSell_order_value(JSONConversion.getdouble(json, "sell_order_value"));
        trade.initProfit(JSONConversion.getdouble(json, "profit"));
        trade.initJumps(JSONConversion.getint(json, "jumps"));
        trade.initRuns(JSONConversion.getint(json, "runs"));
        trade.initTotal_jumps(JSONConversion.getint(json, "total_jumps"));
        trade.initProfit_per_jump(JSONConversion.getdouble(json, "profit_per_jump"));
        trade.initSinglerun_profit_per_jump(JSONConversion.getdouble(json, "singlerun_profit_per_jump"));
        trade.initMaxunits_per_run(JSONConversion.getint(json, "maxunits_per_run"));
        trade.initJumpslowsec(JSONConversion.getint(json, "jumpslowsec"));
        trade.initJumpsnullsec(JSONConversion.getint(json, "jumpsnullsec"));
        return trade;
    }
}

