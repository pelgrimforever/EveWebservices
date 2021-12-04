/*
 * JSONOrders.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 4.11.2021 14:51
 *
 */
 
package eve.conversion.json;

import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.interfaces.db.EntityPK;
import data.interfaces.db.Fieldsearcher;
import data.json.piJson;
import eve.entity.pk.OrdersPK;
import eve.interfaces.entity.pk.IOrdersPK;
import eve.interfaces.logicentity.IOrders;
import eve.logicentity.Orders;
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
public class JSONOrders {
    
    public static JSONArray toJSONArray(ArrayList orderss) {
        JSONArray jsonorderss = new JSONArray();
        Iterator orderssI = orderss.iterator();
        while(orderssI.hasNext()) {
            jsonorderss.add(toJSON((Orders)orderssI.next()));
        }
        return jsonorderss;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(IOrdersPK ordersPK) {
        JSONObject json = null;
        if(ordersPK!=null) {
            json = new JSONObject();
            json.put("id", String.valueOf(ordersPK.getId()));
        }
        return json;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(IOrders orders) {
        JSONObject json = new JSONObject();
        json.put("PK", toJSON(orders.getPrimaryKey()));
        json.put("evetypePK", JSONEvetype.toJSON(orders.getEvetypePK()));
        json.put("systemPK", JSONSystem.toJSON(orders.getSystemPK()));
        json.put("isopen", orders.getIsopen());
        json.put("volume_total", String.valueOf(orders.getVolume_total()));
        json.put("volume_remain", String.valueOf(orders.getVolume_remain()));
        json.put("range", orders.getRange());
        json.put("range_number", orders.getRange_number());
        json.put("price", orders.getPrice());
        json.put("min_volume", orders.getMin_volume());
        json.put("location", String.valueOf(orders.getLocation()));
        json.put("is_buy_order", orders.getIs_buy_order());
        if(orders.getIssued()!=null) {
	        json.put("issued", orders.getIssued().getTime());
        }
        json.put("duration", orders.getDuration());
        json.put("page", orders.getPage());
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(Orderssearch orderssearch) {
        JSONObject json = new JSONObject();
        if(orderssearch.used()) {
            byte andoroperator = orderssearch.getAndoroperator();
            int maxresults = orderssearch.getMaxresults();
            boolean docount = orderssearch.getDocount();
            Iterator<EntityPK> primarykeysI = orderssearch.getPrimarykeys().iterator();
            Iterator<Fieldsearcher> fieldsearchersI = orderssearch.getFieldsearchers().iterator();
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
            if(orderssearch.getEvetypesearch()!=null && orderssearch.getEvetypesearch().used()) {
                kss.put("evetypesearcher", JSONEvetype.toJSON((Evetypesearch)orderssearch.getEvetypesearch()));
            }
            if(orderssearch.getSystemsearch()!=null && orderssearch.getSystemsearch().used()) {
                kss.put("systemsearcher", JSONSystem.toJSON((Systemsearch)orderssearch.getSystemsearch()));
            }
            if(orderssearch.getTradecombined_sellbuy_order_idsearch()!=null && orderssearch.getTradecombined_sellbuy_order_idsearch().used()) {
                kss.put("tradecombined_sellBuy_order_idsearcher", JSONTradecombined_sell.toJSON((Tradecombined_sellsearch)orderssearch.getTradecombined_sellbuy_order_idsearch()));
            }
            if(orderssearch.getRelTradecombined1search()!=null && orderssearch.getRelTradecombined1search().used()) {
                kss.put("tradecombined1searcher", JSONTradecombined_sell.toJSON((Tradecombined_sellsearch)orderssearch.getRelTradecombined1search()));
            }
            if(orderssearch.getTradecombined_sellsell_order_idsearch()!=null && orderssearch.getTradecombined_sellsell_order_idsearch().used()) {
                kss.put("tradecombined_sellSell_order_idsearcher", JSONTradecombined_sell.toJSON((Tradecombined_sellsearch)orderssearch.getTradecombined_sellsell_order_idsearch()));
            }
            if(orderssearch.getRelTradecombined2search()!=null && orderssearch.getRelTradecombined2search().used()) {
                kss.put("tradecombined2searcher", JSONTradecombined_sell.toJSON((Tradecombined_sellsearch)orderssearch.getRelTradecombined2search()));
            }
            if(orderssearch.getTradesell_order_idsearch()!=null && orderssearch.getTradesell_order_idsearch().used()) {
                kss.put("tradeSell_order_idsearcher", JSONTrade.toJSON((Tradesearch)orderssearch.getTradesell_order_idsearch()));
            }
            if(orderssearch.getTradebuy_order_idsearch()!=null && orderssearch.getTradebuy_order_idsearch().used()) {
                kss.put("tradeBuy_order_idsearcher", JSONTrade.toJSON((Tradesearch)orderssearch.getTradebuy_order_idsearch()));
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
    public static Orderssearch toOrderssearch(JSONObject json) {
        Orderssearch orderssearch = new Orderssearch();
        orderssearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        orderssearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        orderssearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONArray pks = (JSONArray)json.get("primarykeys");
        for(int i=0; i<pks.size(); i++) {
            orderssearch.addPrimarykey(OrdersPK.getKey((String)pks.get(i)));
        }
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("id");
        if(field!=null) {
            long[] valuearray = JSONConversion.getLongvalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            orderssearch.id(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("isopen");
        if(field!=null) {
            boolean value = JSONConversion.getBooleanvalue(field);
            orderssearch.isopen(value);
        }
        field = (JSONObject)fss.get("volume_total");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            orderssearch.volume_total(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("volume_remain");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            orderssearch.volume_remain(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("range");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            orderssearch.range(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("range_number");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            orderssearch.range_number(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("price");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            orderssearch.price(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("min_volume");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            orderssearch.min_volume(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("location");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            orderssearch.location(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("is_buy_order");
        if(field!=null) {
            boolean value = JSONConversion.getBooleanvalue(field);
            orderssearch.is_buy_order(value);
        }
        field = (JSONObject)fss.get("issued");
        if(field!=null) {
            Timestamp[] valuearray = JSONConversion.getTimestampvalues(field);
            byte[] operators = JSONConversion.getTimeoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            orderssearch.issued(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("duration");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            orderssearch.duration(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("page");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            orderssearch.page(valuearray, operators, andor);
        }
        JSONObject kss = (JSONObject)json.get("keysearch");
        JSONArray keysearch;
        keysearch = (JSONArray)kss.get("evetypesearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Evetypesearch evetypesearch = JSONEvetype.toEvetypesearch((JSONObject)keysearch.get(i));
                orderssearch.evetype(evetypesearch);
            }
        }
        keysearch = (JSONArray)kss.get("systemsearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Systemsearch systemsearch = JSONSystem.toSystemsearch((JSONObject)keysearch.get(i));
                orderssearch.system(systemsearch);
            }
        }
        keysearch = (JSONArray)kss.get("tradecombined_sellBuy_order_idsearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Tradecombined_sellsearch tradecombined_sellBuy_order_idsearch = JSONTradecombined_sell.toTradecombined_sellsearch((JSONObject)keysearch.get(i));
                orderssearch.tradecombined_sellBuy_order_id(tradecombined_sellBuy_order_idsearch);
            }
        }
        keysearch = (JSONArray)kss.get("tradecombined1searcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Tradecombinedsearch tradecombined1search = JSONTradecombined.toTradecombinedsearch((JSONObject)keysearch.get(i));
                orderssearch.reltradecombined1(tradecombined1search);
            }
        }
        keysearch = (JSONArray)kss.get("tradecombined_sellSell_order_idsearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Tradecombined_sellsearch tradecombined_sellSell_order_idsearch = JSONTradecombined_sell.toTradecombined_sellsearch((JSONObject)keysearch.get(i));
                orderssearch.tradecombined_sellSell_order_id(tradecombined_sellSell_order_idsearch);
            }
        }
        keysearch = (JSONArray)kss.get("tradecombined2searcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Tradecombinedsearch tradecombined2search = JSONTradecombined.toTradecombinedsearch((JSONObject)keysearch.get(i));
                orderssearch.reltradecombined2(tradecombined2search);
            }
        }
        keysearch = (JSONArray)kss.get("tradeSell_order_idsearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Tradesearch tradeSell_order_idsearch = JSONTrade.toTradesearch((JSONObject)keysearch.get(i));
                orderssearch.tradeSell_order_id(tradeSell_order_idsearch);
            }
        }
        keysearch = (JSONArray)kss.get("tradeBuy_order_idsearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Tradesearch tradeBuy_order_idsearch = JSONTrade.toTradesearch((JSONObject)keysearch.get(i));
                orderssearch.tradeBuy_order_id(tradeBuy_order_idsearch);
            }
        }
        return orderssearch;
    }
    
    public static OrdersPK toOrdersPK(JSONObject json) {
        OrdersPK ordersPK = null;
        if(json!=null) {
            ordersPK = new OrdersPK(JSONConversion.getlong(json, "id"));
        }
        return ordersPK;
    }

    public static Orders toOrders(JSONObject json) {
        Orders orders = new Orders(toOrdersPK((JSONObject)json.get("PK")));
        updateOrders(orders, json);
        return orders;
    }

    public static void updateOrders(IOrders orders, JSONObject json) {
        orders.setEvetypePK(JSONEvetype.toEvetypePK((JSONObject)json.get("evetypePK")));
        orders.setSystemPK(JSONSystem.toSystemPK((JSONObject)json.get("systemPK")));
        orders.setIsopen(JSONConversion.getboolean(json, "isopen"));
        orders.setVolume_total(JSONConversion.getlong(json, "volume_total"));
        orders.setVolume_remain(JSONConversion.getlong(json, "volume_remain"));
        orders.setRange(JSONConversion.getString(json, "range"));
        orders.setRange_number(JSONConversion.getint(json, "range_number"));
        orders.setPrice(JSONConversion.getdouble(json, "price"));
        orders.setMin_volume(JSONConversion.getint(json, "min_volume"));
        orders.setLocation(JSONConversion.getlong(json, "location"));
        orders.setIs_buy_order(JSONConversion.getboolean(json, "is_buy_order"));
        orders.setIssued(JSONConversion.getTimestamp(json, "issued"));
        orders.setDuration(JSONConversion.getint(json, "duration"));
        orders.setPage(JSONConversion.getint(json, "page"));
    }

    public static Orders initOrders(JSONObject json) {
        Orders orders = new Orders(toOrdersPK((JSONObject)json.get("PK")));
        orders.initEvetypePK(JSONEvetype.toEvetypePK((JSONObject)json.get("evetypePK")));
        orders.initSystemPK(JSONSystem.toSystemPK((JSONObject)json.get("systemPK")));
        orders.initIsopen(JSONConversion.getboolean(json, "isopen"));
        orders.initVolume_total(JSONConversion.getlong(json, "volume_total"));
        orders.initVolume_remain(JSONConversion.getlong(json, "volume_remain"));
        orders.initRange(JSONConversion.getString(json, "range"));
        orders.initRange_number(JSONConversion.getint(json, "range_number"));
        orders.initPrice(JSONConversion.getdouble(json, "price"));
        orders.initMin_volume(JSONConversion.getint(json, "min_volume"));
        orders.initLocation(JSONConversion.getlong(json, "location"));
        orders.initIs_buy_order(JSONConversion.getboolean(json, "is_buy_order"));
        orders.initIssued(JSONConversion.getTimestamp(json, "issued"));
        orders.initDuration(JSONConversion.getint(json, "duration"));
        orders.initPage(JSONConversion.getint(json, "page"));
        return orders;
    }
}

