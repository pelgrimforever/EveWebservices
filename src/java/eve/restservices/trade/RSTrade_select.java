/*
 * Generated on 17.6.2022 13:4
 */

package eve.restservices.trade;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.usecases.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.searchentity.ITradesearch;
import eve.interfaces.servlet.ITradeOperation;
import eve.logicentity.Trade;
import eve.searchentity.Tradesearch;
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
@Path("rstrade_select")
public class RSTrade_select extends RS_json_login {

    private Security_usecases security_usecases = new Security_usecases();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Trade_usecases tradeusecases = new Trade_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case ITradeOperation.SELECT_COUNT:
                    result = count_records(tradeusecases);
                    break;
                case ITradeOperation.SELECT_ALL:
                    result = get_all_trade(tradeusecases);
                    break;
                case ITradeOperation.SELECT_TRADE:
                    result = get_trade_with_primarykey(tradeusecases, json);
                    break;
                case ITradeOperation.SELECT_Orderssell_order_id:
                    result = get_trade_with_foreignkey_ordersSell_order_id(tradeusecases, json);
                    break;
                case ITradeOperation.SELECT_Ordersbuy_order_id:
                    result = get_trade_with_foreignkey_ordersBuy_order_id(tradeusecases, json);
                    break;
                case ITradeOperation.SELECT_SEARCH:
                    result = search_trade(tradeusecases, json);
                    break;
                case ITradeOperation.SELECT_SEARCHCOUNT:
                    result = search_trade_count(tradeusecases, json);
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
}

