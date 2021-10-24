/*
 * JSONStocktrade.java
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
import eve.entity.pk.StocktradePK;
import eve.interfaces.entity.pk.IStocktradePK;
import eve.interfaces.logicentity.IStocktrade;
import eve.logicentity.Stocktrade;
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
public class JSONStocktrade {
    
    public static JSONArray toJSONArray(ArrayList stocktrades) {
        JSONArray jsonstocktrades = new JSONArray();
        Iterator stocktradesI = stocktrades.iterator();
        while(stocktradesI.hasNext()) {
            jsonstocktrades.add(toJSON((Stocktrade)stocktradesI.next()));
        }
        return jsonstocktrades;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(IStocktradePK stocktradePK) {
        JSONObject json = null;
        if(stocktradePK!=null) {
            json = new JSONObject();
            json.put("username", stocktradePK.getUsername());
            json.put("evetype", String.valueOf(stocktradePK.getEvetype()));
            json.put("orderid", String.valueOf(stocktradePK.getOrderid()));
        }
        return json;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(IStocktrade stocktrade) {
        JSONObject json = new JSONObject();
        json.put("PK", toJSON(stocktrade.getPrimaryKey()));
        json.put("sellamount", String.valueOf(stocktrade.getSellamount()));
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(Stocktradesearch stocktradesearch) {
        JSONObject json = new JSONObject();
        if(stocktradesearch.used()) {
            byte andoroperator = stocktradesearch.getAndoroperator();
            int maxresults = stocktradesearch.getMaxresults();
            boolean docount = stocktradesearch.getDocount();
            Iterator<EntityPK> primarykeysI = stocktradesearch.getPrimarykeys().iterator();
            Iterator<Fieldsearcher> fieldsearchersI = stocktradesearch.getFieldsearchers().iterator();
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
            if(stocktradesearch.getStocksearch()!=null && stocktradesearch.getStocksearch().used()) {
                kss.put("stocksearcher", JSONStock.toJSON((Stocksearch)stocktradesearch.getStocksearch()));
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
    public static Stocktradesearch toStocktradesearch(JSONObject json) {
        Stocktradesearch stocktradesearch = new Stocktradesearch();
        stocktradesearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        stocktradesearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        stocktradesearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONArray pks = (JSONArray)json.get("primarykeys");
        for(int i=0; i<pks.size(); i++) {
            stocktradesearch.addPrimarykey(StocktradePK.getKey((String)pks.get(i)));
        }
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("orderid");
        if(field!=null) {
            long[] valuearray = JSONConversion.getLongvalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            stocktradesearch.orderid(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("sellamount");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            stocktradesearch.sellamount(valuearray, operators, andor);
        }
        JSONObject kss = (JSONObject)json.get("keysearch");
        JSONArray keysearch;
        keysearch = (JSONArray)kss.get("stocksearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Stocksearch stocksearch = JSONStock.toStocksearch((JSONObject)keysearch.get(i));
                stocktradesearch.stock(stocksearch);
            }
        }
        return stocktradesearch;
    }
    
    public static StocktradePK toStocktradePK(JSONObject json) {
        StocktradePK stocktradePK = null;
        if(json!=null) {
            stocktradePK = new StocktradePK(JSONConversion.getString(json, "username"), JSONConversion.getlong(json, "evetype"), JSONConversion.getlong(json, "orderid"));
        }
        return stocktradePK;
    }

    public static Stocktrade toStocktrade(JSONObject json) {
        Stocktrade stocktrade = new Stocktrade(toStocktradePK((JSONObject)json.get("PK")));
        updateStocktrade(stocktrade, json);
        return stocktrade;
    }

    public static void updateStocktrade(IStocktrade stocktrade, JSONObject json) {
        stocktrade.setSellamount(JSONConversion.getlong(json, "sellamount"));
    }

    public static Stocktrade initStocktrade(JSONObject json) {
        Stocktrade stocktrade = new Stocktrade(toStocktradePK((JSONObject)json.get("PK")));
        stocktrade.initSellamount(JSONConversion.getlong(json, "sellamount"));
        return stocktrade;
    }
}

