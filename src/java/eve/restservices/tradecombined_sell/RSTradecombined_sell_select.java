/*
 * Generated on 17.6.2022 13:4
 */

package eve.restservices.tradecombined_sell;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.usecases.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.searchentity.ITradecombined_sellsearch;
import eve.interfaces.servlet.ITradecombined_sellOperation;
import eve.logicentity.Tradecombined_sell;
import eve.searchentity.Tradecombined_sellsearch;
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
@Path("rstradecombined_sell_select")
public class RSTradecombined_sell_select extends RS_json_login {

    private Security_usecases security_usecases = new Security_usecases();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Tradecombined_sell_usecases tradecombined_sellusecases = new Tradecombined_sell_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case ITradecombined_sellOperation.SELECT_COUNT:
                    result = count_records(tradecombined_sellusecases);
                    break;
                case ITradecombined_sellOperation.SELECT_ALL:
                    result = get_all_tradecombined_sell(tradecombined_sellusecases);
                    break;
                case ITradecombined_sellOperation.SELECT_TRADECOMBINED_SELL:
                    result = get_tradecombined_sell_with_primarykey(tradecombined_sellusecases, json);
                    break;
                case ITradecombined_sellOperation.SELECT_Ordersbuy_order_id:
                    result = get_tradecombined_sell_with_foreignkey_ordersBuy_order_id(tradecombined_sellusecases, json);
                    break;
                case ITradecombined_sellOperation.SELECT_Orderssell_order_id:
                    result = get_tradecombined_sell_with_foreignkey_ordersSell_order_id(tradecombined_sellusecases, json);
                    break;
                case ITradecombined_sellOperation.SELECT_Tradecombined:
                    result = get_tradecombined_sell_with_foreignkey_tradecombined(tradecombined_sellusecases, json);
                    break;
                case ITradecombined_sellOperation.SELECT_SEARCH:
                    result = search_tradecombined_sell(tradecombined_sellusecases, json);
                    break;
                case ITradecombined_sellOperation.SELECT_SEARCHCOUNT:
                    result = search_tradecombined_sell_count(tradecombined_sellusecases, json);
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

    private String count_records(Tradecombined_sell_usecases tradecombined_sellusecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", tradecombined_sellusecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_tradecombined_sell(Tradecombined_sell_usecases tradecombined_sellusecases) throws ParseException, CustomException {
    	return JSONTradecombined_sell.toJSONArray(tradecombined_sellusecases.get_all()).toJSONString();
    }
    
    private String get_tradecombined_sell_with_primarykey(Tradecombined_sell_usecases tradecombined_sellusecases, JSONObject json) throws ParseException, CustomException {
        ITradecombined_sellPK tradecombined_sellPK = (ITradecombined_sellPK)JSONTradecombined_sell.toTradecombined_sellPK((JSONObject)json.get("tradecombined_sellpk"));
	return JSONTradecombined_sell.toJSON(tradecombined_sellusecases.get_tradecombined_sell_by_primarykey(tradecombined_sellPK)).toJSONString();
    }
    
    private String get_tradecombined_sell_with_foreignkey_ordersBuy_order_id(Tradecombined_sell_usecases tradecombined_sellusecases, JSONObject json) throws ParseException, CustomException {
        IOrdersPK ordersBuy_order_idPK = (IOrdersPK)JSONOrders.toOrdersPK((JSONObject)json.get("orderspk"));
        return JSONTradecombined_sell.toJSONArray(tradecombined_sellusecases.get_tradecombined_sell_with_foreignkey_ordersBuy_order_id(ordersBuy_order_idPK)).toJSONString();
    }
    
    private String get_tradecombined_sell_with_foreignkey_ordersSell_order_id(Tradecombined_sell_usecases tradecombined_sellusecases, JSONObject json) throws ParseException, CustomException {
        IOrdersPK ordersSell_order_idPK = (IOrdersPK)JSONOrders.toOrdersPK((JSONObject)json.get("orderspk"));
        return JSONTradecombined_sell.toJSONArray(tradecombined_sellusecases.get_tradecombined_sell_with_foreignkey_ordersSell_order_id(ordersSell_order_idPK)).toJSONString();
    }
    
    private String get_tradecombined_sell_with_foreignkey_tradecombined(Tradecombined_sell_usecases tradecombined_sellusecases, JSONObject json) throws ParseException, CustomException {
        ITradecombinedPK tradecombinedPK = (ITradecombinedPK)JSONTradecombined.toTradecombinedPK((JSONObject)json.get("tradecombinedpk"));
        return JSONTradecombined_sell.toJSONArray(tradecombined_sellusecases.get_tradecombined_sell_with_foreignkey_tradecombined(tradecombinedPK)).toJSONString();
    }
    
    private String search_tradecombined_sell(Tradecombined_sell_usecases tradecombined_sellusecases, JSONObject json) throws ParseException, CustomException {
        ITradecombined_sellsearch search = (ITradecombined_sellsearch)JSONTradecombined_sell.toTradecombined_sellsearch((JSONObject)json.get("search"));
        return JSONTradecombined_sell.toJSONArray(tradecombined_sellusecases.search_tradecombined_sell(search)).toJSONString();
    }
    
    private String search_tradecombined_sell_count(Tradecombined_sell_usecases tradecombined_sellusecases, JSONObject json) throws ParseException, CustomException {
        ITradecombined_sellsearch tradecombined_sellsearch = (ITradecombined_sellsearch)JSONTradecombined_sell.toTradecombined_sellsearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", tradecombined_sellusecases.search_tradecombined_sell_count(tradecombined_sellsearch));
        return jsonsearchcount.toJSONString();
    }
}

