/*
 * Generated on 17.6.2022 13:4
 */

package eve.restservices.stock;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.usecases.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.searchentity.IStocksearch;
import eve.interfaces.servlet.IStockOperation;
import eve.logicentity.Stock;
import eve.searchentity.Stocksearch;
import eve.servlets.DataServlet;
import eve.usecases.custom.*;
import general.exception.*;
import java.sql.Date;
import java.sql.Time;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
@Path("rsstock_select")
public class RSStock_select extends RS_json_login {

    private Security_usecases security_usecases = new Security_usecases();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Stock_usecases stockusecases = new Stock_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IStockOperation.SELECT_COUNT:
                    result = count_records(stockusecases);
                    break;
                case IStockOperation.SELECT_ALL:
                    result = get_all_stock(stockusecases);
                    break;
                case IStockOperation.SELECT_STOCK:
                    result = get_stock_with_primarykey(stockusecases, json);
                    break;
                case IStockOperation.SELECT_Evetype:
                    result = get_stock_with_foreignkey_evetype(stockusecases, json);
                    break;
                case IStockOperation.SELECT_Stocktrade:
                    result = get_stock_with_externalforeignkey_stocktrade(stockusecases, json);
                    break;
                case IStockOperation.SELECT_SEARCH:
                    result = search_stock(stockusecases, json);
                    break;
                case IStockOperation.SELECT_SEARCHCOUNT:
                    result = search_stock_count(stockusecases, json);
                    break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            }
        }
        catch(ParseException | CustomException | IOException e) {
            setReturnstatus(e.getMessage());
        }
        return result;
    }

//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   

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
}

