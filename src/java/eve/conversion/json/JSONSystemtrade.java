/*
 * JSONSystemtrade.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 24.9.2021 14:40
 *
 */
 
package eve.conversion.json;

import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.interfaces.db.EntityPK;
import data.interfaces.db.Fieldsearcher;
import data.json.piJson;
import eve.entity.pk.SystemtradePK;
import eve.interfaces.entity.pk.ISystemtradePK;
import eve.interfaces.logicentity.ISystemtrade;
import eve.logicentity.Systemtrade;
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
public class JSONSystemtrade {
    
    public static JSONArray toJSONArray(ArrayList systemtrades) {
        JSONArray jsonsystemtrades = new JSONArray();
        Iterator systemtradesI = systemtrades.iterator();
        while(systemtradesI.hasNext()) {
            jsonsystemtrades.add(toJSON((Systemtrade)systemtradesI.next()));
        }
        return jsonsystemtrades;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(ISystemtradePK systemtradePK) {
        JSONObject json = null;
        if(systemtradePK!=null) {
            json = new JSONObject();
            json.put("sell_system", String.valueOf(systemtradePK.getSell_system()));
            json.put("buy_system", String.valueOf(systemtradePK.getBuy_system()));
        }
        return json;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(ISystemtrade systemtrade) {
        JSONObject json = new JSONObject();
        json.put("PK", toJSON(systemtrade.getPrimaryKey()));
        json.put("profit", systemtrade.getProfit());
        json.put("total_cargo_volume", systemtrade.getTotal_cargo_volume());
        json.put("jumps", systemtrade.getJumps());
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(Systemtradesearch systemtradesearch) {
        JSONObject json = new JSONObject();
        if(systemtradesearch.used()) {
            byte andoroperator = systemtradesearch.getAndoroperator();
            int maxresults = systemtradesearch.getMaxresults();
            boolean docount = systemtradesearch.getDocount();
            Iterator<EntityPK> primarykeysI = systemtradesearch.getPrimarykeys().iterator();
            Iterator<Fieldsearcher> fieldsearchersI = systemtradesearch.getFieldsearchers().iterator();
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
            if(systemtradesearch.getSystemsell_systemsearch()!=null && systemtradesearch.getSystemsell_systemsearch().used()) {
                kss.put("systemSell_systemsearcher", JSONSystem.toJSON((Systemsearch)systemtradesearch.getSystemsell_systemsearch()));
            }
            if(systemtradesearch.getSystembuy_systemsearch()!=null && systemtradesearch.getSystembuy_systemsearch().used()) {
                kss.put("systemBuy_systemsearcher", JSONSystem.toJSON((Systemsearch)systemtradesearch.getSystembuy_systemsearch()));
            }
            if(systemtradesearch.getSystemtrade_ordersearch()!=null && systemtradesearch.getSystemtrade_ordersearch().used()) {
                kss.put("systemtrade_ordersearcher", JSONSystemtrade_order.toJSON((Systemtrade_ordersearch)systemtradesearch.getSystemtrade_ordersearch()));
            }
            if(systemtradesearch.getOrders1search()!=null && systemtradesearch.getOrders1search().used()) {
                kss.put("orders1searcher", JSONSystemtrade_order.toJSON((Systemtrade_ordersearch)systemtradesearch.getOrders1search()));
            }
            if(systemtradesearch.getOrders2search()!=null && systemtradesearch.getOrders2search().used()) {
                kss.put("orders2searcher", JSONSystemtrade_order.toJSON((Systemtrade_ordersearch)systemtradesearch.getOrders2search()));
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
    public static Systemtradesearch toSystemtradesearch(JSONObject json) {
        Systemtradesearch systemtradesearch = new Systemtradesearch();
        systemtradesearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        systemtradesearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        systemtradesearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONArray pks = (JSONArray)json.get("primarykeys");
        for(int i=0; i<pks.size(); i++) {
            systemtradesearch.addPrimarykey(SystemtradePK.getKey((String)pks.get(i)));
        }
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("profit");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            systemtradesearch.profit(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("total_cargo_volume");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            systemtradesearch.total_cargo_volume(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("jumps");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            systemtradesearch.jumps(valuearray, operators, andor);
        }
        JSONObject kss = (JSONObject)json.get("keysearch");
        JSONArray keysearch;
        keysearch = (JSONArray)kss.get("systemSell_systemsearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Systemsearch systemSell_systemsearch = JSONSystem.toSystemsearch((JSONObject)keysearch.get(i));
                systemtradesearch.systemSell_system(systemSell_systemsearch);
            }
        }
        keysearch = (JSONArray)kss.get("systemBuy_systemsearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Systemsearch systemBuy_systemsearch = JSONSystem.toSystemsearch((JSONObject)keysearch.get(i));
                systemtradesearch.systemBuy_system(systemBuy_systemsearch);
            }
        }
        keysearch = (JSONArray)kss.get("systemtrade_ordersearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Systemtrade_ordersearch systemtrade_ordersearch = JSONSystemtrade_order.toSystemtrade_ordersearch((JSONObject)keysearch.get(i));
                systemtradesearch.systemtrade_order(systemtrade_ordersearch);
            }
        }
        keysearch = (JSONArray)kss.get("orders1searcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Orderssearch orders1search = JSONOrders.toOrderssearch((JSONObject)keysearch.get(i));
                systemtradesearch.orders1(orders1search);
            }
        }
        keysearch = (JSONArray)kss.get("orders2searcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Orderssearch orders2search = JSONOrders.toOrderssearch((JSONObject)keysearch.get(i));
                systemtradesearch.orders2(orders2search);
            }
        }
        return systemtradesearch;
    }
    
    public static SystemtradePK toSystemtradePK(JSONObject json) {
        SystemtradePK systemtradePK = null;
        if(json!=null) {
            systemtradePK = new SystemtradePK(JSONConversion.getlong(json, "sell_system"), JSONConversion.getlong(json, "buy_system"));
        }
        return systemtradePK;
    }

    public static Systemtrade toSystemtrade(JSONObject json) {
        Systemtrade systemtrade = new Systemtrade(toSystemtradePK((JSONObject)json.get("PK")));
        updateSystemtrade(systemtrade, json);
        return systemtrade;
    }

    public static void updateSystemtrade(ISystemtrade systemtrade, JSONObject json) {
        systemtrade.setProfit(JSONConversion.getdouble(json, "profit"));
        systemtrade.setTotal_cargo_volume(JSONConversion.getdouble(json, "total_cargo_volume"));
        systemtrade.setJumps(JSONConversion.getint(json, "jumps"));
    }

    public static Systemtrade initSystemtrade(JSONObject json) {
        Systemtrade systemtrade = new Systemtrade(toSystemtradePK((JSONObject)json.get("PK")));
        systemtrade.initProfit(JSONConversion.getdouble(json, "profit"));
        systemtrade.initTotal_cargo_volume(JSONConversion.getdouble(json, "total_cargo_volume"));
        systemtrade.initJumps(JSONConversion.getint(json, "jumps"));
        return systemtrade;
    }
}

