/*
 * WSStock.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 11.4.2022 9:13
 *
 */

package eve.webservices;

import eve.BusinessObject.Logic.*;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.webservice.WSIStock;
import eve.logicentity.Stock;
import eve.searchentity.Stocksearch;
import general.exception.CustomException;
import general.exception.DataException;
import general.exception.DBException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.jws.WebMethod;
import javax.jws.WebService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Franky Laseure
 */
@WebService(endpointInterface = "eve.interfaces.webservice.WSIStock")
public class WSStock implements WSIStock {

    private JSONArray toJSONArray(ArrayList stocks) {
        JSONArray jsonstocks = new JSONArray();
        Iterator stocksI = stocks.iterator();
        while(stocksI.hasNext()) {
            jsonstocks.add(JSONStock.toJSON((Stock)stocksI.next()));
        }
        return jsonstocks;
    }

    /**
     * Web service operation
     */
    //@WebMethod(operationName = "getStocks")
    @Override
    public String getStocks() {
        try {
            BLstock blstock = new BLstock();
            ArrayList stocks = blstock.getAll();
            JSONArray jsonstocks = toJSONArray(stocks);
            return jsonstocks.toJSONString();
        }
        catch(DBException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "search")
    @Override
    public String search(String json) {
        BLstock blstock = new BLstock();
        JSONParser parser = new JSONParser();
        String result = "";
        Stock stock;
        try {
            Stocksearch stocksearch = JSONStock.toStocksearch((JSONObject)parser.parse(json));
            ArrayList stocks = blstock.search(stocksearch);
            JSONArray jsonstocks = toJSONArray(stocks);
            result = jsonstocks.toJSONString();
        }
        catch(ParseException e) {
            result = "";
        }
        catch(DBException e) {
            result = "";
        }
        return result;
    }

    //@WebMethod(operationName = "getStock")
    @Override
    public String getStock(String json) {
        BLstock blstock = new BLstock();
        JSONParser parser = new JSONParser();
        String result = "";
        Stock stock;
        try {
            StockPK stockPK = JSONStock.toStockPK((JSONObject)parser.parse(json));
            stock = blstock.getStock(stockPK);
            if(stock!=null) {
                result = JSONStock.toJSON(stock).toJSONString();
            }
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
        return result;
    }

    //@WebMethod(operationName = "insertStock")
    @Override
    public void insertStock(String json) {
        BLstock blstock = new BLstock();
        JSONParser parser = new JSONParser();
        try {
            IStock stock = JSONStock.toStock((JSONObject)parser.parse(json));
            blstock.insertStock(stock);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "updateStock")
    @Override
    public void updateStock(String json) {
        BLstock blstock = new BLstock();
        JSONParser parser = new JSONParser();
        try {
            IStock stock = JSONStock.toStock((JSONObject)parser.parse(json));
            blstock.updateStock(stock);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "deleteStock")
    @Override
    public void deleteStock(String json) {
        BLstock blstock = new BLstock();
        JSONParser parser = new JSONParser();
        try {
            IStock stock = JSONStock.toStock((JSONObject)parser.parse(json));
            blstock.deleteStock(stock);
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "getStocks4evetype")
    @Override
    public String getStocks4evetype(String json) {
        BLstock blstock = new BLstock();
        JSONParser parser = new JSONParser();
        Stock stock;
        try {
            IEvetypePK evetypePK = JSONEvetype.toEvetypePK((JSONObject)parser.parse(json));
            ArrayList stocks = blstock.getStocks4evetype(evetypePK);
            JSONArray jsonstocks = toJSONArray(stocks);
            return jsonstocks.toJSONString();
        }
        catch(ParseException e) {
            return null;
        }
        catch(DBException e) {
            return null;
        }
        catch(CustomException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "delete4evetype")
    @Override
    public void delete4evetype(String json) {
        BLstock blstock = new BLstock();
        JSONParser parser = new JSONParser();
        Stock stock;
        try {
            IEvetypePK evetypePK = JSONEvetype.toEvetypePK((JSONObject)parser.parse(json));
            blstock.delete4evetype(evetypePK);
        }
        catch(ParseException e) {
        }
    }

    //@WebMethod(operationName = "getStocks4stocktrade")
    @Override
    public String getStocks4stocktrade(String json) {
        BLstock blstock = new BLstock();
        JSONParser parser = new JSONParser();
        Stock stock;
        try {
            String result = null;
            IStocktradePK stocktradePK = JSONStocktrade.toStocktradePK((JSONObject)parser.parse(json));
            stock = (Stock)blstock.getStocktrade(stocktradePK);
            if(stock!=null) {
                result = JSONStock.toJSON(stock).toJSONString();
            }
            return result;
        }
        catch(ParseException e) {
            return null;
        }
        catch(DBException e) {
            return null;
        }
        catch(CustomException e) {
            return null;
        }
    }


}

