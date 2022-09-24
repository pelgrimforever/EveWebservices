/*
 * Generated on 23.8.2022 14:38
 * @author Franky Laseure
 */

package eve.restservices.orders;

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
import eve.interfaces.searchentity.IOrderssearch;
import eve.interfaces.servlet.IOrdersOperation;
import eve.logicentity.Orders;
import eve.searchentity.Orderssearch;
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

@Path("rsorders_select")
public class RSOrders_select extends RS_json_login {

    private Security_usecases security_usecases = new Security_usecases();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Orders_usecases ordersusecases = new Orders_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IOrdersOperation.SELECT_COUNT:
                    result = count_records(ordersusecases);
                    break;
                case IOrdersOperation.SELECT_ALL:
                    result = get_all_orders(ordersusecases);
                    break;
                case IOrdersOperation.SELECT_ORDERS:
                    result = get_orders_with_primarykey(ordersusecases, json);
                    break;
                case IOrdersOperation.SELECT_Evetype:
                    result = get_orders_with_foreignkey_evetype(ordersusecases, json);
                    break;
                case IOrdersOperation.SELECT_System:
                    result = get_orders_with_foreignkey_system(ordersusecases, json);
                    break;
                case IOrdersOperation.SELECT_Tradecombined_sellbuy_order_id:
                    result = get_orders_with_externalforeignkey_tradecombined_sellBuy_order_id(ordersusecases, json);
                    break;
                case IOrdersOperation.SELECT_Tradecombined_sellsell_order_id:
                    result = get_orders_with_externalforeignkey_tradecombined_sellSell_order_id(ordersusecases, json);
                    break;
                case IOrdersOperation.SELECT_Shipfitorderselected:
                    result = get_orders_with_externalforeignkey_shipfitorderselected(ordersusecases, json);
                    break;
                case IOrdersOperation.SELECT_Tradesell_order_id:
                    result = get_orders_with_externalforeignkey_tradeSell_order_id(ordersusecases, json);
                    break;
                case IOrdersOperation.SELECT_Tradebuy_order_id:
                    result = get_orders_with_externalforeignkey_tradeBuy_order_id(ordersusecases, json);
                    break;
                case IOrdersOperation.SELECT_SEARCH:
                    result = search_orders(ordersusecases, json);
                    break;
                case IOrdersOperation.SELECT_SEARCHCOUNT:
                    result = search_orders_count(ordersusecases, json);
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

    private String count_records(Orders_usecases ordersusecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", ordersusecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_orders(Orders_usecases ordersusecases) throws ParseException, CustomException {
    	return JSONOrders.toJSONArray(ordersusecases.get_all()).toJSONString();
    }
    
    private String get_orders_with_primarykey(Orders_usecases ordersusecases, JSONObject json) throws ParseException, CustomException {
        IOrdersPK ordersPK = (IOrdersPK)JSONOrders.toOrdersPK((JSONObject)json.get("orderspk"));
	return JSONOrders.toJSON(ordersusecases.get_orders_by_primarykey(ordersPK)).toJSONString();
    }
    
    private String get_orders_with_foreignkey_evetype(Orders_usecases ordersusecases, JSONObject json) throws ParseException, CustomException {
        IEvetypePK evetypePK = (IEvetypePK)JSONEvetype.toEvetypePK((JSONObject)json.get("evetypepk"));
        return JSONOrders.toJSONArray(ordersusecases.get_orders_with_foreignkey_evetype(evetypePK)).toJSONString();
    }
    
    private String get_orders_with_foreignkey_system(Orders_usecases ordersusecases, JSONObject json) throws ParseException, CustomException {
        ISystemPK systemPK = (ISystemPK)JSONSystem.toSystemPK((JSONObject)json.get("systempk"));
        return JSONOrders.toJSONArray(ordersusecases.get_orders_with_foreignkey_system(systemPK)).toJSONString();
    }
    
    private String get_orders_with_externalforeignkey_tradecombined_sellBuy_order_id(Orders_usecases ordersusecases, JSONObject json) throws ParseException, CustomException {
        ITradecombined_sellPK tradecombined_sellBuy_order_idPK = (ITradecombined_sellPK)JSONTradecombined_sell.toTradecombined_sellPK((JSONObject)json.get("tradecombined_sellpk"));
        return JSONOrders.toJSON(ordersusecases.get_orders_with_externalforeignkey_tradecombined_sellBuy_order_id(tradecombined_sellBuy_order_idPK)).toJSONString();
    }
    
    private String get_orders_with_externalforeignkey_tradecombined_sellSell_order_id(Orders_usecases ordersusecases, JSONObject json) throws ParseException, CustomException {
        ITradecombined_sellPK tradecombined_sellSell_order_idPK = (ITradecombined_sellPK)JSONTradecombined_sell.toTradecombined_sellPK((JSONObject)json.get("tradecombined_sellpk"));
        return JSONOrders.toJSON(ordersusecases.get_orders_with_externalforeignkey_tradecombined_sellSell_order_id(tradecombined_sellSell_order_idPK)).toJSONString();
    }
    
    private String get_orders_with_externalforeignkey_shipfitorderselected(Orders_usecases ordersusecases, JSONObject json) throws ParseException, CustomException {
        IShipfitorderselectedPK shipfitorderselectedPK = (IShipfitorderselectedPK)JSONShipfitorderselected.toShipfitorderselectedPK((JSONObject)json.get("shipfitorderselectedpk"));
        return JSONOrders.toJSON(ordersusecases.get_orders_with_externalforeignkey_shipfitorderselected(shipfitorderselectedPK)).toJSONString();
    }
    
    private String get_orders_with_externalforeignkey_tradeSell_order_id(Orders_usecases ordersusecases, JSONObject json) throws ParseException, CustomException {
        ITradePK tradeSell_order_idPK = (ITradePK)JSONTrade.toTradePK((JSONObject)json.get("tradepk"));
        return JSONOrders.toJSON(ordersusecases.get_orders_with_externalforeignkey_tradeSell_order_id(tradeSell_order_idPK)).toJSONString();
    }
    
    private String get_orders_with_externalforeignkey_tradeBuy_order_id(Orders_usecases ordersusecases, JSONObject json) throws ParseException, CustomException {
        ITradePK tradeBuy_order_idPK = (ITradePK)JSONTrade.toTradePK((JSONObject)json.get("tradepk"));
        return JSONOrders.toJSON(ordersusecases.get_orders_with_externalforeignkey_tradeBuy_order_id(tradeBuy_order_idPK)).toJSONString();
    }
    
    private String search_orders(Orders_usecases ordersusecases, JSONObject json) throws ParseException, CustomException {
        IOrderssearch search = (IOrderssearch)JSONOrders.toOrderssearch((JSONObject)json.get("search"));
        return JSONOrders.toJSONArray(ordersusecases.search_orders(search)).toJSONString();
    }
    
    private String search_orders_count(Orders_usecases ordersusecases, JSONObject json) throws ParseException, CustomException {
        IOrderssearch orderssearch = (IOrderssearch)JSONOrders.toOrderssearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", ordersusecases.search_orders_count(orderssearch));
        return jsonsearchcount.toJSONString();
    }
}

