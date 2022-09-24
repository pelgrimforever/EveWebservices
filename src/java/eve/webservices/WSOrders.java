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
import eve.interfaces.searchentity.IOrderssearch;
import eve.interfaces.webservice.WSIOrders;
import eve.logicentity.Orders;
import eve.searchentity.Orderssearch;
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

@WebService(endpointInterface = "eve.interfaces.webservice.WSIOrders")
public class WSOrders extends RS_json_login implements WSIOrders {

    private Security_usecases security_usecases = new Security_usecases();
    
    private JSONArray toJSONArray(ArrayList orderss) {
        JSONArray jsonorderss = new JSONArray();
        Iterator orderssI = orderss.iterator();
        while(orderssI.hasNext()) {
            jsonorderss.add(JSONOrders.toJSON((Orders)orderssI.next()));
        }
        return jsonorderss;
    }

    //@WebMethod(operationName = "getOrderss")
    @Override
    public String getOrderss() {
        try {
            Orders_usecases ordersusecases = new Orders_usecases(loggedin);
            return get_all_orders(ordersusecases);
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
            Orders_usecases ordersusecases = new Orders_usecases(loggedin);
            return search_orders(ordersusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "getOrders")
    @Override
    public String getOrders(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Orders_usecases ordersusecases = new Orders_usecases(loggedin);
            return get_orders_with_primarykey(ordersusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "insertOrders")
    @Override
    public void insertOrders(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Orders_usecases ordersusecases = new Orders_usecases(loggedin);
            insert_orders(ordersusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "updateOrders")
    @Override
    public void updateOrders(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Orders_usecases ordersusecases = new Orders_usecases(loggedin);
            update_orders(ordersusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "deleteOrders")
    @Override
    public void deleteOrders(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Orders_usecases ordersusecases = new Orders_usecases(loggedin);
            delete_orders(ordersusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getOrderss4evetype")
    @Override
    public String getOrderss4evetype(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Orders_usecases ordersusecases = new Orders_usecases(loggedin);
            return get_orders_with_foreignkey_evetype(ordersusecases, json);
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
            Orders_usecases ordersusecases = new Orders_usecases(loggedin);
            delete_orders(ordersusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getOrderss4system")
    @Override
    public String getOrderss4system(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Orders_usecases ordersusecases = new Orders_usecases(loggedin);
            return get_orders_with_foreignkey_system(ordersusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "delete4system")
    @Override
    public void delete4system(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Orders_usecases ordersusecases = new Orders_usecases(loggedin);
            delete_orders(ordersusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getOrderss4tradecombined_sellBuy_order_id")
    @Override
    public String getOrderss4tradecombined_sellBuy_order_id(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Orders_usecases ordersusecases = new Orders_usecases(loggedin);
            return get_orders_with_externalforeignkey_tradecombined_sellBuy_order_id(ordersusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "getOrderss4tradecombined_sellSell_order_id")
    @Override
    public String getOrderss4tradecombined_sellSell_order_id(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Orders_usecases ordersusecases = new Orders_usecases(loggedin);
            return get_orders_with_externalforeignkey_tradecombined_sellSell_order_id(ordersusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "getOrderss4shipfitorderselected")
    @Override
    public String getOrderss4shipfitorderselected(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Orders_usecases ordersusecases = new Orders_usecases(loggedin);
            return get_orders_with_externalforeignkey_shipfitorderselected(ordersusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "getOrderss4tradeSell_order_id")
    @Override
    public String getOrderss4tradeSell_order_id(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Orders_usecases ordersusecases = new Orders_usecases(loggedin);
            return get_orders_with_externalforeignkey_tradeSell_order_id(ordersusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "getOrderss4tradeBuy_order_id")
    @Override
    public String getOrderss4tradeBuy_order_id(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Orders_usecases ordersusecases = new Orders_usecases(loggedin);
            return get_orders_with_externalforeignkey_tradeBuy_order_id(ordersusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }


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

    private void insert_orders(Orders_usecases ordersusecases, JSONObject json) throws ParseException, CustomException {
        IOrders orders = (IOrders)JSONOrders.toOrders((JSONObject)json.get("orders"));
        ordersusecases.insertOrders(orders);
        setReturnstatus("OK");
    }

    private void update_orders(Orders_usecases ordersusecases, JSONObject json) throws ParseException, CustomException {
        IOrders orders = (IOrders)JSONOrders.toOrders((JSONObject)json.get("orders"));
        ordersusecases.updateOrders(orders);
        setReturnstatus("OK");
    }

    private void delete_orders(Orders_usecases ordersusecases, JSONObject json) throws ParseException, CustomException {
        IOrders orders = (IOrders)JSONOrders.toOrders((JSONObject)json.get("orders"));
        ordersusecases.deleteOrders(orders);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Evetype(Orders_usecases ordersusecases, JSONObject json) throws ParseException, CustomException {
        IEvetypePK evetypePK = (IEvetypePK)JSONEvetype.toEvetypePK((JSONObject)json.get("evetypepk"));
        ordersusecases.delete_all_containing_Evetype(evetypePK);
        setReturnstatus("OK");
    }

    private void delete_all_containing_System(Orders_usecases ordersusecases, JSONObject json) throws ParseException, CustomException {
        ISystemPK systemPK = (ISystemPK)JSONSystem.toSystemPK((JSONObject)json.get("systempk"));
        ordersusecases.delete_all_containing_System(systemPK);
        setReturnstatus("OK");
    }

}

