/*
 * JSONStock.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 8.10.2021 7:21
 *
 */
 
package eve.conversion.json;

import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.interfaces.db.EntityPK;
import data.interfaces.db.Fieldsearcher;
import data.json.piJson;
import eve.entity.pk.StockPK;
import eve.interfaces.entity.pk.IStockPK;
import eve.interfaces.logicentity.IStock;
import eve.logicentity.Stock;
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
public class JSONStock {
    
    public static JSONArray toJSONArray(ArrayList stocks) {
        JSONArray jsonstocks = new JSONArray();
        Iterator stocksI = stocks.iterator();
        while(stocksI.hasNext()) {
            jsonstocks.add(toJSON((Stock)stocksI.next()));
        }
        return jsonstocks;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(IStockPK stockPK) {
        JSONObject json = null;
        if(stockPK!=null) {
            json = new JSONObject();
            json.put("username", stockPK.getUsername());
            json.put("evetype", String.valueOf(stockPK.getEvetype()));
        }
        return json;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(IStock stock) {
        JSONObject json = new JSONObject();
        json.put("PK", toJSON(stock.getPrimaryKey()));
        json.put("amount", String.valueOf(stock.getAmount()));
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(Stocksearch stocksearch) {
        JSONObject json = new JSONObject();
        if(stocksearch.used()) {
            byte andoroperator = stocksearch.getAndoroperator();
            int maxresults = stocksearch.getMaxresults();
            boolean docount = stocksearch.getDocount();
            Iterator<EntityPK> primarykeysI = stocksearch.getPrimarykeys().iterator();
            Iterator<Fieldsearcher> fieldsearchersI = stocksearch.getFieldsearchers().iterator();
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
            if(stocksearch.getEvetypesearch()!=null && stocksearch.getEvetypesearch().used()) {
                kss.put("evetypesearcher", JSONEvetype.toJSON((Evetypesearch)stocksearch.getEvetypesearch()));
            }
            if(stocksearch.getStocktradesearch()!=null && stocksearch.getStocktradesearch().used()) {
                kss.put("stocktradesearcher", JSONStocktrade.toJSON((Stocktradesearch)stocksearch.getStocktradesearch()));
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
    public static Stocksearch toStocksearch(JSONObject json) {
        Stocksearch stocksearch = new Stocksearch();
        stocksearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        stocksearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        stocksearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONArray pks = (JSONArray)json.get("primarykeys");
        for(int i=0; i<pks.size(); i++) {
            stocksearch.addPrimarykey(StockPK.getKey((String)pks.get(i)));
        }
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("username");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            stocksearch.username(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("amount");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            stocksearch.amount(valuearray, operators, andor);
        }
        JSONObject kss = (JSONObject)json.get("keysearch");
        JSONArray keysearch;
        keysearch = (JSONArray)kss.get("evetypesearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Evetypesearch evetypesearch = JSONEvetype.toEvetypesearch((JSONObject)keysearch.get(i));
                stocksearch.evetype(evetypesearch);
            }
        }
        keysearch = (JSONArray)kss.get("stocktradesearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Stocktradesearch stocktradesearch = JSONStocktrade.toStocktradesearch((JSONObject)keysearch.get(i));
                stocksearch.stocktrade(stocktradesearch);
            }
        }
        return stocksearch;
    }
    
    public static StockPK toStockPK(JSONObject json) {
        StockPK stockPK = null;
        if(json!=null) {
            stockPK = new StockPK(JSONConversion.getString(json, "username"), JSONConversion.getlong(json, "evetype"));
        }
        return stockPK;
    }

    public static Stock toStock(JSONObject json) {
        Stock stock = new Stock(toStockPK((JSONObject)json.get("PK")));
        updateStock(stock, json);
        return stock;
    }

    public static void updateStock(IStock stock, JSONObject json) {
        stock.setAmount(JSONConversion.getlong(json, "amount"));
    }

    public static Stock initStock(JSONObject json) {
        Stock stock = new Stock(toStockPK((JSONObject)json.get("PK")));
        stock.initAmount(JSONConversion.getlong(json, "amount"));
        return stock;
    }
}

