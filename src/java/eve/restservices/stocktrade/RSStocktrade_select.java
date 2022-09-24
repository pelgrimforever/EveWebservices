/*
 * Generated on 23.8.2022 14:38
 * @author Franky Laseure
 */

package eve.restservices.stocktrade;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.usecases.*;
import eve.usecases.custom.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.searchentity.IStocktradesearch;
import eve.interfaces.servlet.IStocktradeOperation;
import eve.logicentity.Stocktrade;
import eve.searchentity.Stocktradesearch;
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

@Path("rsstocktrade_select")
public class RSStocktrade_select extends RS_json_login {

    private Security_usecases security_usecases = new Security_usecases();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Stocktrade_usecases stocktradeusecases = new Stocktrade_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IStocktradeOperation.SELECT_COUNT:
                    result = count_records(stocktradeusecases);
                    break;
                case IStocktradeOperation.SELECT_ALL:
                    result = get_all_stocktrade(stocktradeusecases);
                    break;
                case IStocktradeOperation.SELECT_STOCKTRADE:
                    result = get_stocktrade_with_primarykey(stocktradeusecases, json);
                    break;
                case IStocktradeOperation.SELECT_Stock:
                    result = get_stocktrade_with_foreignkey_stock(stocktradeusecases, json);
                    break;
                case IStocktradeOperation.SELECT_SEARCH:
                    result = search_stocktrade(stocktradeusecases, json);
                    break;
                case IStocktradeOperation.SELECT_SEARCHCOUNT:
                    result = search_stocktrade_count(stocktradeusecases, json);
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
}

