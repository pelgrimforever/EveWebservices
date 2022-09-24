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
import eve.interfaces.searchentity.IStocksearch;
import eve.interfaces.webservice.WSIStock;
import eve.logicentity.Stock;
import eve.searchentity.Stocksearch;
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

@WebService(endpointInterface = "eve.interfaces.webservice.WSIStock")
public class WSStock extends RS_json_login implements WSIStock {

    private Security_usecases security_usecases = new Security_usecases();
    
    private JSONArray toJSONArray(ArrayList stocks) {
        JSONArray jsonstocks = new JSONArray();
        Iterator stocksI = stocks.iterator();
        while(stocksI.hasNext()) {
            jsonstocks.add(JSONStock.toJSON((Stock)stocksI.next()));
        }
        return jsonstocks;
    }

    //@WebMethod(operationName = "getStocks")
    @Override
    public String getStocks() {
        try {
            Stock_usecases stockusecases = new Stock_usecases(loggedin);
            return get_all_stock(stockusecases);
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
            Stock_usecases stockusecases = new Stock_usecases(loggedin);
            return search_stock(stockusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "getStock")
    @Override
    public String getStock(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Stock_usecases stockusecases = new Stock_usecases(loggedin);
            return get_stock_with_primarykey(stockusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "insertStock")
    @Override
    public void insertStock(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Stock_usecases stockusecases = new Stock_usecases(loggedin);
            insert_stock(stockusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "updateStock")
    @Override
    public void updateStock(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Stock_usecases stockusecases = new Stock_usecases(loggedin);
            update_stock(stockusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "deleteStock")
    @Override
    public void deleteStock(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Stock_usecases stockusecases = new Stock_usecases(loggedin);
            delete_stock(stockusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getStocks4evetype")
    @Override
    public String getStocks4evetype(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Stock_usecases stockusecases = new Stock_usecases(loggedin);
            return get_stock_with_foreignkey_evetype(stockusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "delete4evetype")
    @Override
    public void delete4evetype(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Stock_usecases stockusecases = new Stock_usecases(loggedin);
            delete_stock(stockusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getStocks4stocktrade")
    @Override
    public String getStocks4stocktrade(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Stock_usecases stockusecases = new Stock_usecases(loggedin);
            return get_stock_with_externalforeignkey_stocktrade(stockusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }


    private String count_records(Stock_usecases stockusecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", stockusecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_stock(Stock_usecases stockusecases) throws ParseException, CustomException {
    	return JSONStock.toJSONArray(stockusecases.get_all()).toJSONString();
    }
    
    private String get_stock_with_primarykey(Stock_usecases stockusecases, JSONObject json) throws ParseException, CustomException {
        IStockPK stockPK = (IStockPK)JSONStock.toStockPK((JSONObject)json.get("stockpk"));
	return JSONStock.toJSON(stockusecases.get_stock_by_primarykey(stockPK)).toJSONString();
    }
    
    private String get_stock_with_foreignkey_evetype(Stock_usecases stockusecases, JSONObject json) throws ParseException, CustomException {
        IEvetypePK evetypePK = (IEvetypePK)JSONEvetype.toEvetypePK((JSONObject)json.get("evetypepk"));
        return JSONStock.toJSONArray(stockusecases.get_stock_with_foreignkey_evetype(evetypePK)).toJSONString();
    }
    
    private String get_stock_with_externalforeignkey_stocktrade(Stock_usecases stockusecases, JSONObject json) throws ParseException, CustomException {
        IStocktradePK stocktradePK = (IStocktradePK)JSONStocktrade.toStocktradePK((JSONObject)json.get("stocktradepk"));
        return JSONStock.toJSON(stockusecases.get_stock_with_externalforeignkey_stocktrade(stocktradePK)).toJSONString();
    }
    
    private String search_stock(Stock_usecases stockusecases, JSONObject json) throws ParseException, CustomException {
        IStocksearch search = (IStocksearch)JSONStock.toStocksearch((JSONObject)json.get("search"));
        return JSONStock.toJSONArray(stockusecases.search_stock(search)).toJSONString();
    }
    
    private String search_stock_count(Stock_usecases stockusecases, JSONObject json) throws ParseException, CustomException {
        IStocksearch stocksearch = (IStocksearch)JSONStock.toStocksearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", stockusecases.search_stock_count(stocksearch));
        return jsonsearchcount.toJSONString();
    }

    private void insert_stock(Stock_usecases stockusecases, JSONObject json) throws ParseException, CustomException {
        IStock stock = (IStock)JSONStock.toStock((JSONObject)json.get("stock"));
        stockusecases.insertStock(stock);
        setReturnstatus("OK");
    }

    private void update_stock(Stock_usecases stockusecases, JSONObject json) throws ParseException, CustomException {
        IStock stock = (IStock)JSONStock.toStock((JSONObject)json.get("stock"));
        stockusecases.updateStock(stock);
        setReturnstatus("OK");
    }

    private void delete_stock(Stock_usecases stockusecases, JSONObject json) throws ParseException, CustomException {
        IStock stock = (IStock)JSONStock.toStock((JSONObject)json.get("stock"));
        stockusecases.deleteStock(stock);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Evetype(Stock_usecases stockusecases, JSONObject json) throws ParseException, CustomException {
        IEvetypePK evetypePK = (IEvetypePK)JSONEvetype.toEvetypePK((JSONObject)json.get("evetypepk"));
        stockusecases.delete_all_containing_Evetype(evetypePK);
        setReturnstatus("OK");
    }

}

