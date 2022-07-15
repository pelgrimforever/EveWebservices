/*
 * WSStocktrade.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 13.6.2022 18:20
 *
 */

package eve.webservices;

import base.restservices.RS_json_login;
import eve.BusinessObject.Logic.*;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.searchentity.IStocktradesearch;
import eve.interfaces.webservice.WSIStocktrade;
import eve.logicentity.Stocktrade;
import eve.searchentity.Stocktradesearch;
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

/**
 *
 * @author Franky Laseure
 */
@WebService(endpointInterface = "eve.interfaces.webservice.WSIStocktrade")
public class WSStocktrade extends RS_json_login implements WSIStocktrade {

    private Security_usecases security_usecases = new Security_usecases();
    
    private JSONArray toJSONArray(ArrayList stocktrades) {
        JSONArray jsonstocktrades = new JSONArray();
        Iterator stocktradesI = stocktrades.iterator();
        while(stocktradesI.hasNext()) {
            jsonstocktrades.add(JSONStocktrade.toJSON((Stocktrade)stocktradesI.next()));
        }
        return jsonstocktrades;
    }

    //@WebMethod(operationName = "getStocktrades")
    @Override
    public String getStocktrades() {
        try {
            Stocktrade_usecases stocktradeusecases = new Stocktrade_usecases(loggedin);
            return get_all_stocktrade(stocktradeusecases);
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
            Stocktrade_usecases stocktradeusecases = new Stocktrade_usecases(loggedin);
            return search_stocktrade(stocktradeusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "getStocktrade")
    @Override
    public String getStocktrade(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Stocktrade_usecases stocktradeusecases = new Stocktrade_usecases(loggedin);
            return get_stocktrade_with_primarykey(stocktradeusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "insertStocktrade")
    @Override
    public void insertStocktrade(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Stocktrade_usecases stocktradeusecases = new Stocktrade_usecases(loggedin);
            insert_stocktrade(stocktradeusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "updateStocktrade")
    @Override
    public void updateStocktrade(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Stocktrade_usecases stocktradeusecases = new Stocktrade_usecases(loggedin);
            update_stocktrade(stocktradeusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "deleteStocktrade")
    @Override
    public void deleteStocktrade(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Stocktrade_usecases stocktradeusecases = new Stocktrade_usecases(loggedin);
            delete_stocktrade(stocktradeusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getStocktrades4stock")
    @Override
    public String getStocktrades4stock(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Stocktrade_usecases stocktradeusecases = new Stocktrade_usecases(loggedin);
            return get_stocktrade_with_foreignkey_stock(stocktradeusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "delete4stock")
    @Override
    public void delete4stock(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Stocktrade_usecases stocktradeusecases = new Stocktrade_usecases(loggedin);
            delete_stocktrade(stocktradeusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }


    private String count_records(Stocktrade_usecases stocktradeusecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", stocktradeusecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_stocktrade(Stocktrade_usecases stocktradeusecases) throws ParseException, CustomException {
    	return JSONStocktrade.toJSONArray(stocktradeusecases.get_all()).toJSONString();
    }
    
    private String get_stocktrade_with_primarykey(Stocktrade_usecases stocktradeusecases, JSONObject json) throws ParseException, CustomException {
        IStocktradePK stocktradePK = (IStocktradePK)JSONStocktrade.toStocktradePK((JSONObject)json.get("stocktradepk"));
	return JSONStocktrade.toJSON(stocktradeusecases.get_stocktrade_by_primarykey(stocktradePK)).toJSONString();
    }
    
    private String get_stocktrade_with_foreignkey_stock(Stocktrade_usecases stocktradeusecases, JSONObject json) throws ParseException, CustomException {
        IStockPK stockPK = (IStockPK)JSONStock.toStockPK((JSONObject)json.get("stockpk"));
        return JSONStocktrade.toJSONArray(stocktradeusecases.get_stocktrade_with_foreignkey_stock(stockPK)).toJSONString();
    }
    
    private String search_stocktrade(Stocktrade_usecases stocktradeusecases, JSONObject json) throws ParseException, CustomException {
        IStocktradesearch search = (IStocktradesearch)JSONStocktrade.toStocktradesearch((JSONObject)json.get("search"));
        return JSONStocktrade.toJSONArray(stocktradeusecases.search_stocktrade(search)).toJSONString();
    }
    
    private String search_stocktrade_count(Stocktrade_usecases stocktradeusecases, JSONObject json) throws ParseException, CustomException {
        IStocktradesearch stocktradesearch = (IStocktradesearch)JSONStocktrade.toStocktradesearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", stocktradeusecases.search_stocktrade_count(stocktradesearch));
        return jsonsearchcount.toJSONString();
    }

    private void insert_stocktrade(Stocktrade_usecases stocktradeusecases, JSONObject json) throws ParseException, CustomException {
        IStocktrade stocktrade = (IStocktrade)JSONStocktrade.toStocktrade((JSONObject)json.get("stocktrade"));
        stocktradeusecases.insertStocktrade(stocktrade);
        setReturnstatus("OK");
    }

    private void update_stocktrade(Stocktrade_usecases stocktradeusecases, JSONObject json) throws ParseException, CustomException {
        IStocktrade stocktrade = (IStocktrade)JSONStocktrade.toStocktrade((JSONObject)json.get("stocktrade"));
        stocktradeusecases.updateStocktrade(stocktrade);
        setReturnstatus("OK");
    }

    private void delete_stocktrade(Stocktrade_usecases stocktradeusecases, JSONObject json) throws ParseException, CustomException {
        IStocktrade stocktrade = (IStocktrade)JSONStocktrade.toStocktrade((JSONObject)json.get("stocktrade"));
        stocktradeusecases.deleteStocktrade(stocktrade);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Stock(Stocktrade_usecases stocktradeusecases, JSONObject json) throws ParseException, CustomException {
        IStockPK stockPK = (IStockPK)JSONStock.toStockPK((JSONObject)json.get("stockpk"));
        stocktradeusecases.delete_all_containing_Stock(stockPK);
        setReturnstatus("OK");
    }

}

