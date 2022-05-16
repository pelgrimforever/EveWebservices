/*
 * WSTrade.java
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
import eve.interfaces.webservice.WSITrade;
import eve.logicentity.Trade;
import eve.searchentity.Tradesearch;
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
@WebService(endpointInterface = "eve.interfaces.webservice.WSITrade")
public class WSTrade implements WSITrade {

    private JSONArray toJSONArray(ArrayList trades) {
        JSONArray jsontrades = new JSONArray();
        Iterator tradesI = trades.iterator();
        while(tradesI.hasNext()) {
            jsontrades.add(JSONTrade.toJSON((Trade)tradesI.next()));
        }
        return jsontrades;
    }

    /**
     * Web service operation
     */
    //@WebMethod(operationName = "getTrades")
    @Override
    public String getTrades() {
        try {
            BLtrade bltrade = new BLtrade();
            ArrayList trades = bltrade.getAll();
            JSONArray jsontrades = toJSONArray(trades);
            return jsontrades.toJSONString();
        }
        catch(DBException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "search")
    @Override
    public String search(String json) {
        BLtrade bltrade = new BLtrade();
        JSONParser parser = new JSONParser();
        String result = "";
        Trade trade;
        try {
            Tradesearch tradesearch = JSONTrade.toTradesearch((JSONObject)parser.parse(json));
            ArrayList trades = bltrade.search(tradesearch);
            JSONArray jsontrades = toJSONArray(trades);
            result = jsontrades.toJSONString();
        }
        catch(ParseException e) {
            result = "";
        }
        catch(DBException e) {
            result = "";
        }
        return result;
    }

    //@WebMethod(operationName = "getTrade")
    @Override
    public String getTrade(String json) {
        BLtrade bltrade = new BLtrade();
        JSONParser parser = new JSONParser();
        String result = "";
        Trade trade;
        try {
            TradePK tradePK = JSONTrade.toTradePK((JSONObject)parser.parse(json));
            trade = bltrade.getTrade(tradePK);
            if(trade!=null) {
                result = JSONTrade.toJSON(trade).toJSONString();
            }
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
        return result;
    }

    //@WebMethod(operationName = "insertTrade")
    @Override
    public void insertTrade(String json) {
        BLtrade bltrade = new BLtrade();
        JSONParser parser = new JSONParser();
        try {
            ITrade trade = JSONTrade.toTrade((JSONObject)parser.parse(json));
            bltrade.insertTrade(trade);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "updateTrade")
    @Override
    public void updateTrade(String json) {
        BLtrade bltrade = new BLtrade();
        JSONParser parser = new JSONParser();
        try {
            ITrade trade = JSONTrade.toTrade((JSONObject)parser.parse(json));
            bltrade.updateTrade(trade);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "deleteTrade")
    @Override
    public void deleteTrade(String json) {
        BLtrade bltrade = new BLtrade();
        JSONParser parser = new JSONParser();
        try {
            ITrade trade = JSONTrade.toTrade((JSONObject)parser.parse(json));
            bltrade.deleteTrade(trade);
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "getTrades4ordersSell_order_id")
    @Override
    public String getTrades4ordersSell_order_id(String json) {
        BLtrade bltrade = new BLtrade();
        JSONParser parser = new JSONParser();
        Trade trade;
        try {
            IOrdersPK ordersSell_order_idPK = JSONOrders.toOrdersPK((JSONObject)parser.parse(json));
            ArrayList trades = bltrade.getTrades4ordersSell_order_id(ordersSell_order_idPK);
            JSONArray jsontrades = toJSONArray(trades);
            return jsontrades.toJSONString();
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

    //@WebMethod(operationName = "delete4ordersSell_order_id")
    @Override
    public void delete4ordersSell_order_id(String json) {
        BLtrade bltrade = new BLtrade();
        JSONParser parser = new JSONParser();
        Trade trade;
        try {
            IOrdersPK ordersSell_order_idPK = JSONOrders.toOrdersPK((JSONObject)parser.parse(json));
            bltrade.delete4ordersSell_order_id(ordersSell_order_idPK);
        }
        catch(ParseException e) {
        }
    }

    //@WebMethod(operationName = "getTrades4ordersBuy_order_id")
    @Override
    public String getTrades4ordersBuy_order_id(String json) {
        BLtrade bltrade = new BLtrade();
        JSONParser parser = new JSONParser();
        Trade trade;
        try {
            IOrdersPK ordersBuy_order_idPK = JSONOrders.toOrdersPK((JSONObject)parser.parse(json));
            ArrayList trades = bltrade.getTrades4ordersBuy_order_id(ordersBuy_order_idPK);
            JSONArray jsontrades = toJSONArray(trades);
            return jsontrades.toJSONString();
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

    //@WebMethod(operationName = "delete4ordersBuy_order_id")
    @Override
    public void delete4ordersBuy_order_id(String json) {
        BLtrade bltrade = new BLtrade();
        JSONParser parser = new JSONParser();
        Trade trade;
        try {
            IOrdersPK ordersBuy_order_idPK = JSONOrders.toOrdersPK((JSONObject)parser.parse(json));
            bltrade.delete4ordersBuy_order_id(ordersBuy_order_idPK);
        }
        catch(ParseException e) {
        }
    }


}

