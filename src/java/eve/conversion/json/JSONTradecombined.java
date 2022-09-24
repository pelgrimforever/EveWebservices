/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 23.8.2022 14:38
 * @author Franky Laseure
 */
 
package eve.conversion.json;

import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.interfaces.db.EntityPK;
import data.interfaces.db.Fieldsearcher;
import data.json.piJson;
import eve.entity.pk.TradecombinedPK;
import eve.interfaces.entity.pk.ITradecombinedPK;
import eve.interfaces.logicentity.ITradecombined;
import eve.logicentity.Tradecombined;
import eve.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JSONTradecombined {
    
    public static JSONArray toJSONArray(ArrayList tradecombineds) {
        JSONArray jsontradecombineds = new JSONArray();
        Iterator tradecombinedsI = tradecombineds.iterator();
        while(tradecombinedsI.hasNext()) {
            jsontradecombineds.add(toJSON((Tradecombined)tradecombinedsI.next()));
        }
        return jsontradecombineds;
    }

    public static JSONObject toJSON(ITradecombinedPK tradecombinedPK) {
        JSONObject json = null;
        if(tradecombinedPK!=null) {
            json = new JSONObject();
            json.put("sell_system", String.valueOf(tradecombinedPK.getSell_system()));
            json.put("buy_system", String.valueOf(tradecombinedPK.getBuy_system()));
            json.put("evetype", String.valueOf(tradecombinedPK.getEvetype()));
        }
        return json;
    }

    public static JSONObject toJSON(ITradecombined tradecombined) {
        JSONObject json = new JSONObject();
        json.put("PK", toJSON(tradecombined.getPrimaryKey()));
        json.put("jumps", tradecombined.getJumps());
        json.put("jumpslowsec", tradecombined.getJumpslowsec());
        json.put("jumpsnullsec", tradecombined.getJumpsnullsec());
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    public static JSONObject toJSON(Tradecombinedsearch tradecombinedsearch) {
        JSONObject json = new JSONObject();
        if(tradecombinedsearch.used()) {
            byte andoroperator = tradecombinedsearch.getAndoroperator();
            int maxresults = tradecombinedsearch.getMaxresults();
            boolean docount = tradecombinedsearch.getDocount();
            Iterator<EntityPK> primarykeysI = tradecombinedsearch.getPrimarykeys().iterator();
            Iterator<Fieldsearcher> fieldsearchersI = tradecombinedsearch.getFieldsearchers().iterator();
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
            if(tradecombinedsearch.getEvetypesearch()!=null && tradecombinedsearch.getEvetypesearch().used()) {
                kss.put("evetypesearcher", JSONEvetype.toJSON((Evetypesearch)tradecombinedsearch.getEvetypesearch()));
            }
            if(tradecombinedsearch.getSystembuy_systemsearch()!=null && tradecombinedsearch.getSystembuy_systemsearch().used()) {
                kss.put("systemBuy_systemsearcher", JSONSystem.toJSON((Systemsearch)tradecombinedsearch.getSystembuy_systemsearch()));
            }
            if(tradecombinedsearch.getSystemsell_systemsearch()!=null && tradecombinedsearch.getSystemsell_systemsearch().used()) {
                kss.put("systemSell_systemsearcher", JSONSystem.toJSON((Systemsearch)tradecombinedsearch.getSystemsell_systemsearch()));
            }
            if(tradecombinedsearch.getTradecombined_sellsearch()!=null && tradecombinedsearch.getTradecombined_sellsearch().used()) {
                kss.put("tradecombined_sellsearcher", JSONTradecombined_sell.toJSON((Tradecombined_sellsearch)tradecombinedsearch.getTradecombined_sellsearch()));
            }
            if(tradecombinedsearch.getRelOrders1search()!=null && tradecombinedsearch.getRelOrders1search().used()) {
                kss.put("orders1searcher", JSONTradecombined_sell.toJSON((Tradecombined_sellsearch)tradecombinedsearch.getRelOrders1search()));
            }
            if(tradecombinedsearch.getRelOrders2search()!=null && tradecombinedsearch.getRelOrders2search().used()) {
                kss.put("orders2searcher", JSONTradecombined_sell.toJSON((Tradecombined_sellsearch)tradecombinedsearch.getRelOrders2search()));
            }
            json.put("keysearch", kss);
        }
        return json;
    }

    public static Tradecombinedsearch toTradecombinedsearch(JSONObject json) {
        Tradecombinedsearch tradecombinedsearch = new Tradecombinedsearch();
        tradecombinedsearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        tradecombinedsearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        tradecombinedsearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONArray pks = (JSONArray)json.get("primarykeys");
        for(int i=0; i<pks.size(); i++) {
            tradecombinedsearch.addPrimarykey(TradecombinedPK.getKey((String)pks.get(i)));
        }
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("jumps");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            tradecombinedsearch.jumps(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("jumpslowsec");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            tradecombinedsearch.jumpslowsec(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("jumpsnullsec");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            tradecombinedsearch.jumpsnullsec(valuearray, operators, andor);
        }
        JSONObject kss = (JSONObject)json.get("keysearch");
        JSONArray keysearch;
        keysearch = (JSONArray)kss.get("evetypesearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Evetypesearch evetypesearch = JSONEvetype.toEvetypesearch((JSONObject)keysearch.get(i));
                tradecombinedsearch.evetype(evetypesearch);
            }
        }
        keysearch = (JSONArray)kss.get("systemBuy_systemsearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Systemsearch systemBuy_systemsearch = JSONSystem.toSystemsearch((JSONObject)keysearch.get(i));
                tradecombinedsearch.systemBuy_system(systemBuy_systemsearch);
            }
        }
        keysearch = (JSONArray)kss.get("systemSell_systemsearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Systemsearch systemSell_systemsearch = JSONSystem.toSystemsearch((JSONObject)keysearch.get(i));
                tradecombinedsearch.systemSell_system(systemSell_systemsearch);
            }
        }
        keysearch = (JSONArray)kss.get("tradecombined_sellsearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Tradecombined_sellsearch tradecombined_sellsearch = JSONTradecombined_sell.toTradecombined_sellsearch((JSONObject)keysearch.get(i));
                tradecombinedsearch.tradecombined_sell(tradecombined_sellsearch);
            }
        }
        keysearch = (JSONArray)kss.get("orders1searcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Orderssearch orders1search = JSONOrders.toOrderssearch((JSONObject)keysearch.get(i));
                tradecombinedsearch.relorders1(orders1search);
            }
        }
        keysearch = (JSONArray)kss.get("orders2searcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Orderssearch orders2search = JSONOrders.toOrderssearch((JSONObject)keysearch.get(i));
                tradecombinedsearch.relorders2(orders2search);
            }
        }
        return tradecombinedsearch;
    }
    
    public static TradecombinedPK toTradecombinedPK(JSONObject json) {
        TradecombinedPK tradecombinedPK = null;
        if(json!=null) {
            tradecombinedPK = new TradecombinedPK(JSONConversion.getlong(json, "sell_system"), JSONConversion.getlong(json, "buy_system"), JSONConversion.getlong(json, "evetype"));
        }
        return tradecombinedPK;
    }

    public static Tradecombined toTradecombined(JSONObject json) {
        Tradecombined tradecombined = new Tradecombined(toTradecombinedPK((JSONObject)json.get("PK")));
        updateTradecombined(tradecombined, json);
        return tradecombined;
    }

    public static void updateTradecombined(ITradecombined tradecombined, JSONObject json) {
        tradecombined.setJumps(JSONConversion.getint(json, "jumps"));
        tradecombined.setJumpslowsec(JSONConversion.getint(json, "jumpslowsec"));
        tradecombined.setJumpsnullsec(JSONConversion.getint(json, "jumpsnullsec"));
    }

    public static Tradecombined initTradecombined(JSONObject json) {
        Tradecombined tradecombined = new Tradecombined(toTradecombinedPK((JSONObject)json.get("PK")));
        tradecombined.initJumps(JSONConversion.getint(json, "jumps"));
        tradecombined.initJumpslowsec(JSONConversion.getint(json, "jumpslowsec"));
        tradecombined.initJumpsnullsec(JSONConversion.getint(json, "jumpsnullsec"));
        return tradecombined;
    }
}

