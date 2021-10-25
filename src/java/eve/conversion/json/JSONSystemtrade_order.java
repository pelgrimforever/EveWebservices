/*
 * JSONSystemtrade_order.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 25.9.2021 15:16
 *
 */
 
package eve.conversion.json;

import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.interfaces.db.EntityPK;
import data.interfaces.db.Fieldsearcher;
import data.json.piJson;
import eve.entity.pk.Systemtrade_orderPK;
import eve.interfaces.entity.pk.ISystemtrade_orderPK;
import eve.interfaces.logicentity.ISystemtrade_order;
import eve.logicentity.Systemtrade_order;
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
public class JSONSystemtrade_order {
    
    public static JSONArray toJSONArray(ArrayList systemtrade_orders) {
        JSONArray jsonsystemtrade_orders = new JSONArray();
        Iterator systemtrade_ordersI = systemtrade_orders.iterator();
        while(systemtrade_ordersI.hasNext()) {
            jsonsystemtrade_orders.add(toJSON((Systemtrade_order)systemtrade_ordersI.next()));
        }
        return jsonsystemtrade_orders;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(ISystemtrade_orderPK systemtrade_orderPK) {
        JSONObject json = null;
        if(systemtrade_orderPK!=null) {
            json = new JSONObject();
            json.put("sell_system", String.valueOf(systemtrade_orderPK.getSell_system()));
            json.put("buy_system", String.valueOf(systemtrade_orderPK.getBuy_system()));
            json.put("sell_order", String.valueOf(systemtrade_orderPK.getSell_order()));
            json.put("buy_order", String.valueOf(systemtrade_orderPK.getBuy_order()));
        }
        return json;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(ISystemtrade_order systemtrade_order) {
        JSONObject json = new JSONObject();
        json.put("PK", toJSON(systemtrade_order.getPrimaryKey()));
        json.put("amount", String.valueOf(systemtrade_order.getAmount()));
        json.put("sellprice", systemtrade_order.getSellprice());
        json.put("buyprice", systemtrade_order.getBuyprice());
        json.put("profit", systemtrade_order.getProfit());
        json.put("cargovolume", systemtrade_order.getCargovolume());
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(Systemtrade_ordersearch systemtrade_ordersearch) {
        JSONObject json = new JSONObject();
        if(systemtrade_ordersearch.used()) {
            byte andoroperator = systemtrade_ordersearch.getAndoroperator();
            int maxresults = systemtrade_ordersearch.getMaxresults();
            boolean docount = systemtrade_ordersearch.getDocount();
            Iterator<EntityPK> primarykeysI = systemtrade_ordersearch.getPrimarykeys().iterator();
            Iterator<Fieldsearcher> fieldsearchersI = systemtrade_ordersearch.getFieldsearchers().iterator();
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
            if(systemtrade_ordersearch.getOrdersbuy_ordersearch()!=null && systemtrade_ordersearch.getOrdersbuy_ordersearch().used()) {
                kss.put("ordersBuy_ordersearcher", JSONOrders.toJSON((Orderssearch)systemtrade_ordersearch.getOrdersbuy_ordersearch()));
            }
            if(systemtrade_ordersearch.getOrderssell_ordersearch()!=null && systemtrade_ordersearch.getOrderssell_ordersearch().used()) {
                kss.put("ordersSell_ordersearcher", JSONOrders.toJSON((Orderssearch)systemtrade_ordersearch.getOrderssell_ordersearch()));
            }
            if(systemtrade_ordersearch.getSystemtradesearch()!=null && systemtrade_ordersearch.getSystemtradesearch().used()) {
                kss.put("systemtradesearcher", JSONSystemtrade.toJSON((Systemtradesearch)systemtrade_ordersearch.getSystemtradesearch()));
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
    public static Systemtrade_ordersearch toSystemtrade_ordersearch(JSONObject json) {
        Systemtrade_ordersearch systemtrade_ordersearch = new Systemtrade_ordersearch();
        systemtrade_ordersearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        systemtrade_ordersearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        systemtrade_ordersearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONArray pks = (JSONArray)json.get("primarykeys");
        for(int i=0; i<pks.size(); i++) {
            systemtrade_ordersearch.addPrimarykey(Systemtrade_orderPK.getKey((String)pks.get(i)));
        }
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("amount");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            systemtrade_ordersearch.amount(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("sellprice");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            systemtrade_ordersearch.sellprice(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("buyprice");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            systemtrade_ordersearch.buyprice(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("profit");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            systemtrade_ordersearch.profit(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("cargovolume");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            systemtrade_ordersearch.cargovolume(valuearray, operators, andor);
        }
        JSONObject kss = (JSONObject)json.get("keysearch");
        JSONArray keysearch;
        keysearch = (JSONArray)kss.get("ordersBuy_ordersearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Orderssearch ordersBuy_ordersearch = JSONOrders.toOrderssearch((JSONObject)keysearch.get(i));
                systemtrade_ordersearch.ordersBuy_order(ordersBuy_ordersearch);
            }
        }
        keysearch = (JSONArray)kss.get("ordersSell_ordersearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Orderssearch ordersSell_ordersearch = JSONOrders.toOrderssearch((JSONObject)keysearch.get(i));
                systemtrade_ordersearch.ordersSell_order(ordersSell_ordersearch);
            }
        }
        keysearch = (JSONArray)kss.get("systemtradesearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Systemtradesearch systemtradesearch = JSONSystemtrade.toSystemtradesearch((JSONObject)keysearch.get(i));
                systemtrade_ordersearch.systemtrade(systemtradesearch);
            }
        }
        return systemtrade_ordersearch;
    }
    
    public static Systemtrade_orderPK toSystemtrade_orderPK(JSONObject json) {
        Systemtrade_orderPK systemtrade_orderPK = null;
        if(json!=null) {
            systemtrade_orderPK = new Systemtrade_orderPK(JSONConversion.getlong(json, "sell_system"), JSONConversion.getlong(json, "buy_system"), JSONConversion.getlong(json, "sell_order"), JSONConversion.getlong(json, "buy_order"));
        }
        return systemtrade_orderPK;
    }

    public static Systemtrade_order toSystemtrade_order(JSONObject json) {
        Systemtrade_order systemtrade_order = new Systemtrade_order(toSystemtrade_orderPK((JSONObject)json.get("PK")));
        updateSystemtrade_order(systemtrade_order, json);
        return systemtrade_order;
    }

    public static void updateSystemtrade_order(ISystemtrade_order systemtrade_order, JSONObject json) {
        systemtrade_order.setAmount(JSONConversion.getlong(json, "amount"));
        systemtrade_order.setSellprice(JSONConversion.getdouble(json, "sellprice"));
        systemtrade_order.setBuyprice(JSONConversion.getdouble(json, "buyprice"));
        systemtrade_order.setProfit(JSONConversion.getdouble(json, "profit"));
        systemtrade_order.setCargovolume(JSONConversion.getdouble(json, "cargovolume"));
    }

    public static Systemtrade_order initSystemtrade_order(JSONObject json) {
        Systemtrade_order systemtrade_order = new Systemtrade_order(toSystemtrade_orderPK((JSONObject)json.get("PK")));
        systemtrade_order.initAmount(JSONConversion.getlong(json, "amount"));
        systemtrade_order.initSellprice(JSONConversion.getdouble(json, "sellprice"));
        systemtrade_order.initBuyprice(JSONConversion.getdouble(json, "buyprice"));
        systemtrade_order.initProfit(JSONConversion.getdouble(json, "profit"));
        systemtrade_order.initCargovolume(JSONConversion.getdouble(json, "cargovolume"));
        return systemtrade_order;
    }
}

