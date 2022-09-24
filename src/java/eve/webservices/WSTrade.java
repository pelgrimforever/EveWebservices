/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 23.8.2022 14:38
 * @author Franky Laseure
 */

package eve.webservices;

import base.restservices.RS_json_login;
import eve.BusinessObject.Logic.*;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.searchentity.ITradesearch;
import eve.interfaces.webservice.WSITrade;
import eve.logicentity.Trade;
import eve.searchentity.Tradesearch;
import eve.usecases.*;
import general.exception.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.jws.WebMethod;
import javax.jws.WebService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import eve.usecases.custom.Security_usecases;

@WebService(endpointInterface = "eve.interfaces.webservice.WSITrade")
public class WSTrade extends RS_json_login implements WSITrade {

    private Security_usecases security_usecases = new Security_usecases();
    
    private JSONArray toJSONArray(ArrayList trades) {
        JSONArray jsontrades = new JSONArray();
        Iterator tradesI = trades.iterator();
        while(tradesI.hasNext()) {
            jsontrades.add(JSONTrade.toJSON((Trade)tradesI.next()));
        }
        return jsontrades;
    }

    //@WebMethod(operationName = "getTrades")
    @Override
    public String getTrades() {
        try {
            Trade_usecases tradeusecases = new Trade_usecases(loggedin);
            return get_all_trade(tradeusecases);
        }
        catch(CustomException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "search")
    @Override
    public String search(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Trade_usecases tradeusecases = new Trade_usecases(loggedin);
            return search_trade(tradeusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "getTrade")
    @Override
    public String getTrade(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Trade_usecases tradeusecases = new Trade_usecases(loggedin);
            return get_trade_with_primarykey(tradeusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "insertTrade")
    @Override
    public void insertTrade(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Trade_usecases tradeusecases = new Trade_usecases(loggedin);
            insert_trade(tradeusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "updateTrade")
    @Override
    public void updateTrade(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Trade_usecases tradeusecases = new Trade_usecases(loggedin);
            update_trade(tradeusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "deleteTrade")
    @Override
    public void deleteTrade(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Trade_usecases tradeusecases = new Trade_usecases(loggedin);
            delete_trade(tradeusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getTrades4ordersSell_order_id")
    @Override
    public String getTrades4ordersSell_order_id(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Trade_usecases tradeusecases = new Trade_usecases(loggedin);
            return get_trade_with_foreignkey_ordersSell_order_id(tradeusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "delete4ordersSell_order_id")
    @Override
    public void delete4ordersSell_order_id(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Trade_usecases tradeusecases = new Trade_usecases(loggedin);
            delete_trade(tradeusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getTrades4ordersBuy_order_id")
    @Override
    public String getTrades4ordersBuy_order_id(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Trade_usecases tradeusecases = new Trade_usecases(loggedin);
            return get_trade_with_foreignkey_ordersBuy_order_id(tradeusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "delete4ordersBuy_order_id")
    @Override
    public void delete4ordersBuy_order_id(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Trade_usecases tradeusecases = new Trade_usecases(loggedin);
            delete_trade(tradeusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }


    private String count_records(Trade_usecases tradeusecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", tradeusecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_trade(Trade_usecases tradeusecases) throws ParseException, CustomException {
    	return JSONTrade.toJSONArray(tradeusecases.get_all()).toJSONString();
    }
    
    private String get_trade_with_primarykey(Trade_usecases tradeusecases, JSONObject json) throws ParseException, CustomException {
        ITradePK tradePK = (ITradePK)JSONTrade.toTradePK((JSONObject)json.get("tradepk"));
	return JSONTrade.toJSON(tradeusecases.get_trade_by_primarykey(tradePK)).toJSONString();
    }
    
    private String get_trade_with_foreignkey_ordersSell_order_id(Trade_usecases tradeusecases, JSONObject json) throws ParseException, CustomException {
        IOrdersPK ordersSell_order_idPK = (IOrdersPK)JSONOrders.toOrdersPK((JSONObject)json.get("orderspk"));
        return JSONTrade.toJSONArray(tradeusecases.get_trade_with_foreignkey_ordersSell_order_id(ordersSell_order_idPK)).toJSONString();
    }
    
    private String get_trade_with_foreignkey_ordersBuy_order_id(Trade_usecases tradeusecases, JSONObject json) throws ParseException, CustomException {
        IOrdersPK ordersBuy_order_idPK = (IOrdersPK)JSONOrders.toOrdersPK((JSONObject)json.get("orderspk"));
        return JSONTrade.toJSONArray(tradeusecases.get_trade_with_foreignkey_ordersBuy_order_id(ordersBuy_order_idPK)).toJSONString();
    }
    
    private String search_trade(Trade_usecases tradeusecases, JSONObject json) throws ParseException, CustomException {
        ITradesearch search = (ITradesearch)JSONTrade.toTradesearch((JSONObject)json.get("search"));
        return JSONTrade.toJSONArray(tradeusecases.search_trade(search)).toJSONString();
    }
    
    private String search_trade_count(Trade_usecases tradeusecases, JSONObject json) throws ParseException, CustomException {
        ITradesearch tradesearch = (ITradesearch)JSONTrade.toTradesearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", tradeusecases.search_trade_count(tradesearch));
        return jsonsearchcount.toJSONString();
    }

    private void insert_trade(Trade_usecases tradeusecases, JSONObject json) throws ParseException, CustomException {
        ITrade trade = (ITrade)JSONTrade.toTrade((JSONObject)json.get("trade"));
        tradeusecases.insertTrade(trade);
        setReturnstatus("OK");
    }

    private void update_trade(Trade_usecases tradeusecases, JSONObject json) throws ParseException, CustomException {
        ITrade trade = (ITrade)JSONTrade.toTrade((JSONObject)json.get("trade"));
        tradeusecases.updateTrade(trade);
        setReturnstatus("OK");
    }

    private void delete_trade(Trade_usecases tradeusecases, JSONObject json) throws ParseException, CustomException {
        ITrade trade = (ITrade)JSONTrade.toTrade((JSONObject)json.get("trade"));
        tradeusecases.deleteTrade(trade);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Orderssell_order_id(Trade_usecases tradeusecases, JSONObject json) throws ParseException, CustomException {
        IOrdersPK ordersSell_order_idPK = (IOrdersPK)JSONOrders.toOrdersPK((JSONObject)json.get("orderspk"));
        tradeusecases.delete_all_containing_Orderssell_order_id(ordersSell_order_idPK);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Ordersbuy_order_id(Trade_usecases tradeusecases, JSONObject json) throws ParseException, CustomException {
        IOrdersPK ordersBuy_order_idPK = (IOrdersPK)JSONOrders.toOrdersPK((JSONObject)json.get("orderspk"));
        tradeusecases.delete_all_containing_Ordersbuy_order_id(ordersBuy_order_idPK);
        setReturnstatus("OK");
    }

}

