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
import eve.interfaces.searchentity.ITradecombined_sellsearch;
import eve.interfaces.webservice.WSITradecombined_sell;
import eve.logicentity.Tradecombined_sell;
import eve.searchentity.Tradecombined_sellsearch;
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

@WebService(endpointInterface = "eve.interfaces.webservice.WSITradecombined_sell")
public class WSTradecombined_sell extends RS_json_login implements WSITradecombined_sell {

    private Security_usecases security_usecases = new Security_usecases();
    
    private JSONArray toJSONArray(ArrayList tradecombined_sells) {
        JSONArray jsontradecombined_sells = new JSONArray();
        Iterator tradecombined_sellsI = tradecombined_sells.iterator();
        while(tradecombined_sellsI.hasNext()) {
            jsontradecombined_sells.add(JSONTradecombined_sell.toJSON((Tradecombined_sell)tradecombined_sellsI.next()));
        }
        return jsontradecombined_sells;
    }

    //@WebMethod(operationName = "getTradecombined_sells")
    @Override
    public String getTradecombined_sells() {
        try {
            Tradecombined_sell_usecases tradecombined_sellusecases = new Tradecombined_sell_usecases(loggedin);
            return get_all_tradecombined_sell(tradecombined_sellusecases);
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
            Tradecombined_sell_usecases tradecombined_sellusecases = new Tradecombined_sell_usecases(loggedin);
            return search_tradecombined_sell(tradecombined_sellusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "getTradecombined_sell")
    @Override
    public String getTradecombined_sell(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Tradecombined_sell_usecases tradecombined_sellusecases = new Tradecombined_sell_usecases(loggedin);
            return get_tradecombined_sell_with_primarykey(tradecombined_sellusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "insertTradecombined_sell")
    @Override
    public void insertTradecombined_sell(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Tradecombined_sell_usecases tradecombined_sellusecases = new Tradecombined_sell_usecases(loggedin);
            insert_tradecombined_sell(tradecombined_sellusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "updateTradecombined_sell")
    @Override
    public void updateTradecombined_sell(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Tradecombined_sell_usecases tradecombined_sellusecases = new Tradecombined_sell_usecases(loggedin);
            update_tradecombined_sell(tradecombined_sellusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "deleteTradecombined_sell")
    @Override
    public void deleteTradecombined_sell(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Tradecombined_sell_usecases tradecombined_sellusecases = new Tradecombined_sell_usecases(loggedin);
            delete_tradecombined_sell(tradecombined_sellusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getTradecombined_sells4ordersBuy_order_id")
    @Override
    public String getTradecombined_sells4ordersBuy_order_id(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Tradecombined_sell_usecases tradecombined_sellusecases = new Tradecombined_sell_usecases(loggedin);
            return get_tradecombined_sell_with_foreignkey_ordersBuy_order_id(tradecombined_sellusecases, json);
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
            Tradecombined_sell_usecases tradecombined_sellusecases = new Tradecombined_sell_usecases(loggedin);
            delete_tradecombined_sell(tradecombined_sellusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getTradecombined_sells4ordersSell_order_id")
    @Override
    public String getTradecombined_sells4ordersSell_order_id(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Tradecombined_sell_usecases tradecombined_sellusecases = new Tradecombined_sell_usecases(loggedin);
            return get_tradecombined_sell_with_foreignkey_ordersSell_order_id(tradecombined_sellusecases, json);
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
            Tradecombined_sell_usecases tradecombined_sellusecases = new Tradecombined_sell_usecases(loggedin);
            delete_tradecombined_sell(tradecombined_sellusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getTradecombined_sells4tradecombined")
    @Override
    public String getTradecombined_sells4tradecombined(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Tradecombined_sell_usecases tradecombined_sellusecases = new Tradecombined_sell_usecases(loggedin);
            return get_tradecombined_sell_with_foreignkey_tradecombined(tradecombined_sellusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "delete4tradecombined")
    @Override
    public void delete4tradecombined(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Tradecombined_sell_usecases tradecombined_sellusecases = new Tradecombined_sell_usecases(loggedin);
            delete_tradecombined_sell(tradecombined_sellusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }


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

    private void insert_tradecombined_sell(Tradecombined_sell_usecases tradecombined_sellusecases, JSONObject json) throws ParseException, CustomException {
        ITradecombined_sell tradecombined_sell = (ITradecombined_sell)JSONTradecombined_sell.toTradecombined_sell((JSONObject)json.get("tradecombined_sell"));
        tradecombined_sellusecases.insertTradecombined_sell(tradecombined_sell);
        setReturnstatus("OK");
    }

    private void update_tradecombined_sell(Tradecombined_sell_usecases tradecombined_sellusecases, JSONObject json) throws ParseException, CustomException {
        ITradecombined_sell tradecombined_sell = (ITradecombined_sell)JSONTradecombined_sell.toTradecombined_sell((JSONObject)json.get("tradecombined_sell"));
        tradecombined_sellusecases.updateTradecombined_sell(tradecombined_sell);
        setReturnstatus("OK");
    }

    private void delete_tradecombined_sell(Tradecombined_sell_usecases tradecombined_sellusecases, JSONObject json) throws ParseException, CustomException {
        ITradecombined_sell tradecombined_sell = (ITradecombined_sell)JSONTradecombined_sell.toTradecombined_sell((JSONObject)json.get("tradecombined_sell"));
        tradecombined_sellusecases.deleteTradecombined_sell(tradecombined_sell);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Ordersbuy_order_id(Tradecombined_sell_usecases tradecombined_sellusecases, JSONObject json) throws ParseException, CustomException {
        IOrdersPK ordersBuy_order_idPK = (IOrdersPK)JSONOrders.toOrdersPK((JSONObject)json.get("orderspk"));
        tradecombined_sellusecases.delete_all_containing_Ordersbuy_order_id(ordersBuy_order_idPK);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Orderssell_order_id(Tradecombined_sell_usecases tradecombined_sellusecases, JSONObject json) throws ParseException, CustomException {
        IOrdersPK ordersSell_order_idPK = (IOrdersPK)JSONOrders.toOrdersPK((JSONObject)json.get("orderspk"));
        tradecombined_sellusecases.delete_all_containing_Orderssell_order_id(ordersSell_order_idPK);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Tradecombined(Tradecombined_sell_usecases tradecombined_sellusecases, JSONObject json) throws ParseException, CustomException {
        ITradecombinedPK tradecombinedPK = (ITradecombinedPK)JSONTradecombined.toTradecombinedPK((JSONObject)json.get("tradecombinedpk"));
        tradecombined_sellusecases.delete_all_containing_Tradecombined(tradecombinedPK);
        setReturnstatus("OK");
    }

}

