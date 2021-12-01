/*
 * WSStocktrade.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 30.10.2021 10:3
 *
 */

package eve.webservices;

import eve.BusinessObject.Logic.*;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.webservice.WSIStocktrade;
import eve.logicentity.Stocktrade;
import eve.searchentity.Stocktradesearch;
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
@WebService(endpointInterface = "eve.interfaces.webservice.WSIStocktrade")
public class WSStocktrade implements WSIStocktrade {

    private JSONArray toJSONArray(ArrayList stocktrades) {
        JSONArray jsonstocktrades = new JSONArray();
        Iterator stocktradesI = stocktrades.iterator();
        while(stocktradesI.hasNext()) {
            jsonstocktrades.add(JSONStocktrade.toJSON((Stocktrade)stocktradesI.next()));
        }
        return jsonstocktrades;
    }

    /**
     * Web service operation
     */
    //@WebMethod(operationName = "getStocktrades")
    @Override
    public String getStocktrades() {
        try {
            BLstocktrade blstocktrade = new BLstocktrade();
            ArrayList stocktrades = blstocktrade.getAll();
            JSONArray jsonstocktrades = toJSONArray(stocktrades);
            return jsonstocktrades.toJSONString();
        }
        catch(DBException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "search")
    @Override
    public String search(String json) {
        BLstocktrade blstocktrade = new BLstocktrade();
        JSONParser parser = new JSONParser();
        String result = "";
        Stocktrade stocktrade;
        try {
            Stocktradesearch stocktradesearch = JSONStocktrade.toStocktradesearch((JSONObject)parser.parse(json));
            ArrayList stocktrades = blstocktrade.search(stocktradesearch);
            JSONArray jsonstocktrades = toJSONArray(stocktrades);
            result = jsonstocktrades.toJSONString();
        }
        catch(ParseException e) {
            result = "";
        }
        catch(DBException e) {
            result = "";
        }
        return result;
    }

    //@WebMethod(operationName = "getStocktrade")
    @Override
    public String getStocktrade(String json) {
        BLstocktrade blstocktrade = new BLstocktrade();
        JSONParser parser = new JSONParser();
        String result = "";
        Stocktrade stocktrade;
        try {
            StocktradePK stocktradePK = JSONStocktrade.toStocktradePK((JSONObject)parser.parse(json));
            stocktrade = blstocktrade.getStocktrade(stocktradePK);
            if(stocktrade!=null) {
                result = JSONStocktrade.toJSON(stocktrade).toJSONString();
            }
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
        return result;
    }

    //@WebMethod(operationName = "insertStocktrade")
    @Override
    public void insertStocktrade(String json) {
        BLstocktrade blstocktrade = new BLstocktrade();
        JSONParser parser = new JSONParser();
        try {
            IStocktrade stocktrade = JSONStocktrade.toStocktrade((JSONObject)parser.parse(json));
            blstocktrade.insertStocktrade(stocktrade);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "updateStocktrade")
    @Override
    public void updateStocktrade(String json) {
        BLstocktrade blstocktrade = new BLstocktrade();
        JSONParser parser = new JSONParser();
        try {
            IStocktrade stocktrade = JSONStocktrade.toStocktrade((JSONObject)parser.parse(json));
            blstocktrade.updateStocktrade(stocktrade);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "deleteStocktrade")
    @Override
    public void deleteStocktrade(String json) {
        BLstocktrade blstocktrade = new BLstocktrade();
        JSONParser parser = new JSONParser();
        try {
            IStocktrade stocktrade = JSONStocktrade.toStocktrade((JSONObject)parser.parse(json));
            blstocktrade.deleteStocktrade(stocktrade);
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "getStocktrades4stock")
    @Override
    public String getStocktrades4stock(String json) {
        BLstocktrade blstocktrade = new BLstocktrade();
        JSONParser parser = new JSONParser();
        Stocktrade stocktrade;
        try {
            IStockPK stockPK = JSONStock.toStockPK((JSONObject)parser.parse(json));
            ArrayList stocktrades = blstocktrade.getStocktrades4stock(stockPK);
            JSONArray jsonstocktrades = toJSONArray(stocktrades);
            return jsonstocktrades.toJSONString();
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

    //@WebMethod(operationName = "delete4stock")
    @Override
    public void delete4stock(String json) {
        BLstocktrade blstocktrade = new BLstocktrade();
        JSONParser parser = new JSONParser();
        Stocktrade stocktrade;
        try {
            IStockPK stockPK = JSONStock.toStockPK((JSONObject)parser.parse(json));
            blstocktrade.delete4stock(stockPK);
        }
        catch(ParseException e) {
        }
    }


}

