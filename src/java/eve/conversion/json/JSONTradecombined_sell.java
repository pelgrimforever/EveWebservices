/*
 * JSONTradecombined_sell.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 8.0.2022 19:32
 *
 */
 
package eve.conversion.json;

import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.interfaces.db.EntityPK;
import data.interfaces.db.Fieldsearcher;
import data.json.piJson;
import eve.entity.pk.Tradecombined_sellPK;
import eve.interfaces.entity.pk.ITradecombined_sellPK;
import eve.interfaces.logicentity.ITradecombined_sell;
import eve.logicentity.Tradecombined_sell;
import eve.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * JSON fields are by default ignored
 * @author Franky Laseure
 */
public class JSONTradecombined_sell {
    
    public static JSONArray toJSONArray(ArrayList tradecombined_sells) {
        JSONArray jsontradecombined_sells = new JSONArray();
        Iterator tradecombined_sellsI = tradecombined_sells.iterator();
        while(tradecombined_sellsI.hasNext()) {
            jsontradecombined_sells.add(toJSON((Tradecombined_sell)tradecombined_sellsI.next()));
        }
        return jsontradecombined_sells;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(ITradecombined_sellPK tradecombined_sellPK) {
        JSONObject json = null;
        if(tradecombined_sellPK!=null) {
            json = new JSONObject();
            json.put("sell_system", String.valueOf(tradecombined_sellPK.getSell_system()));
            json.put("buy_system", String.valueOf(tradecombined_sellPK.getBuy_system()));
            json.put("evetype", String.valueOf(tradecombined_sellPK.getEvetype()));
            json.put("buy_order_id", String.valueOf(tradecombined_sellPK.getBuy_order_id()));
            json.put("sell_order_id", String.valueOf(tradecombined_sellPK.getSell_order_id()));
        }
        return json;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(ITradecombined_sell tradecombined_sell) {
        JSONObject json = new JSONObject();
        json.put("PK", toJSON(tradecombined_sell.getPrimaryKey()));
        json.put("amount", String.valueOf(tradecombined_sell.getAmount()));
        json.put("buy_order_value", tradecombined_sell.getBuy_order_value());
        json.put("sell_order_value", tradecombined_sell.getSell_order_value());
        json.put("profit", tradecombined_sell.getProfit());
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(Tradecombined_sellsearch tradecombined_sellsearch) {
        JSONObject json = new JSONObject();
        if(tradecombined_sellsearch.used()) {
            byte andoroperator = tradecombined_sellsearch.getAndoroperator();
            int maxresults = tradecombined_sellsearch.getMaxresults();
            boolean docount = tradecombined_sellsearch.getDocount();
            Iterator<EntityPK> primarykeysI = tradecombined_sellsearch.getPrimarykeys().iterator();
            Iterator<Fieldsearcher> fieldsearchersI = tradecombined_sellsearch.getFieldsearchers().iterator();
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
            if(tradecombined_sellsearch.getOrdersbuy_order_idsearch()!=null && tradecombined_sellsearch.getOrdersbuy_order_idsearch().used()) {
                kss.put("ordersBuy_order_idsearcher", JSONOrders.toJSON((Orderssearch)tradecombined_sellsearch.getOrdersbuy_order_idsearch()));
            }
            if(tradecombined_sellsearch.getOrderssell_order_idsearch()!=null && tradecombined_sellsearch.getOrderssell_order_idsearch().used()) {
                kss.put("ordersSell_order_idsearcher", JSONOrders.toJSON((Orderssearch)tradecombined_sellsearch.getOrderssell_order_idsearch()));
            }
            if(tradecombined_sellsearch.getTradecombinedsearch()!=null && tradecombined_sellsearch.getTradecombinedsearch().used()) {
                kss.put("tradecombinedsearcher", JSONTradecombined.toJSON((Tradecombinedsearch)tradecombined_sellsearch.getTradecombinedsearch()));
            }
            json.put("keysearch", kss);
        }
        return json;
    }

    /**
     * 
     * @param json: JSONObject with the Filmsearch parameters
     * @return 
     */
    public static Tradecombined_sellsearch toTradecombined_sellsearch(JSONObject json) {
        Tradecombined_sellsearch tradecombined_sellsearch = new Tradecombined_sellsearch();
        tradecombined_sellsearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        tradecombined_sellsearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        tradecombined_sellsearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONArray pks = (JSONArray)json.get("primarykeys");
        for(int i=0; i<pks.size(); i++) {
            tradecombined_sellsearch.addPrimarykey(Tradecombined_sellPK.getKey((String)pks.get(i)));
        }
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("amount");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            tradecombined_sellsearch.amount(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("buy_order_value");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            tradecombined_sellsearch.buy_order_value(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("sell_order_value");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            tradecombined_sellsearch.sell_order_value(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("profit");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            tradecombined_sellsearch.profit(valuearray, operators, andor);
        }
        JSONObject kss = (JSONObject)json.get("keysearch");
        JSONArray keysearch;
        keysearch = (JSONArray)kss.get("ordersBuy_order_idsearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Orderssearch ordersBuy_order_idsearch = JSONOrders.toOrderssearch((JSONObject)keysearch.get(i));
                tradecombined_sellsearch.ordersBuy_order_id(ordersBuy_order_idsearch);
            }
        }
        keysearch = (JSONArray)kss.get("ordersSell_order_idsearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Orderssearch ordersSell_order_idsearch = JSONOrders.toOrderssearch((JSONObject)keysearch.get(i));
                tradecombined_sellsearch.ordersSell_order_id(ordersSell_order_idsearch);
            }
        }
        keysearch = (JSONArray)kss.get("tradecombinedsearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Tradecombinedsearch tradecombinedsearch = JSONTradecombined.toTradecombinedsearch((JSONObject)keysearch.get(i));
                tradecombined_sellsearch.tradecombined(tradecombinedsearch);
            }
        }
        return tradecombined_sellsearch;
    }
    
    public static Tradecombined_sellPK toTradecombined_sellPK(JSONObject json) {
        Tradecombined_sellPK tradecombined_sellPK = null;
        if(json!=null) {
            tradecombined_sellPK = new Tradecombined_sellPK(JSONConversion.getlong(json, "sell_system"), JSONConversion.getlong(json, "buy_system"), JSONConversion.getlong(json, "evetype"), JSONConversion.getlong(json, "buy_order_id"), JSONConversion.getlong(json, "sell_order_id"));
        }
        return tradecombined_sellPK;
    }

    public static Tradecombined_sell toTradecombined_sell(JSONObject json) {
        Tradecombined_sell tradecombined_sell = new Tradecombined_sell(toTradecombined_sellPK((JSONObject)json.get("PK")));
        updateTradecombined_sell(tradecombined_sell, json);
        return tradecombined_sell;
    }

    public static void updateTradecombined_sell(ITradecombined_sell tradecombined_sell, JSONObject json) {
        tradecombined_sell.setAmount(JSONConversion.getlong(json, "amount"));
        tradecombined_sell.setBuy_order_value(JSONConversion.getdouble(json, "buy_order_value"));
        tradecombined_sell.setSell_order_value(JSONConversion.getdouble(json, "sell_order_value"));
        tradecombined_sell.setProfit(JSONConversion.getdouble(json, "profit"));
    }

    public static Tradecombined_sell initTradecombined_sell(JSONObject json) {
        Tradecombined_sell tradecombined_sell = new Tradecombined_sell(toTradecombined_sellPK((JSONObject)json.get("PK")));
        tradecombined_sell.initAmount(JSONConversion.getlong(json, "amount"));
        tradecombined_sell.initBuy_order_value(JSONConversion.getdouble(json, "buy_order_value"));
        tradecombined_sell.initSell_order_value(JSONConversion.getdouble(json, "sell_order_value"));
        tradecombined_sell.initProfit(JSONConversion.getdouble(json, "profit"));
        return tradecombined_sell;
    }
}

