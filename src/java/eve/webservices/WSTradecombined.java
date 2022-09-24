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
import eve.interfaces.searchentity.ITradecombinedsearch;
import eve.interfaces.webservice.WSITradecombined;
import eve.logicentity.Tradecombined;
import eve.searchentity.Tradecombinedsearch;
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

@WebService(endpointInterface = "eve.interfaces.webservice.WSITradecombined")
public class WSTradecombined extends RS_json_login implements WSITradecombined {

    private Security_usecases security_usecases = new Security_usecases();
    
    private JSONArray toJSONArray(ArrayList tradecombineds) {
        JSONArray jsontradecombineds = new JSONArray();
        Iterator tradecombinedsI = tradecombineds.iterator();
        while(tradecombinedsI.hasNext()) {
            jsontradecombineds.add(JSONTradecombined.toJSON((Tradecombined)tradecombinedsI.next()));
        }
        return jsontradecombineds;
    }

    //@WebMethod(operationName = "getTradecombineds")
    @Override
    public String getTradecombineds() {
        try {
            Tradecombined_usecases tradecombinedusecases = new Tradecombined_usecases(loggedin);
            return get_all_tradecombined(tradecombinedusecases);
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
            Tradecombined_usecases tradecombinedusecases = new Tradecombined_usecases(loggedin);
            return search_tradecombined(tradecombinedusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "getTradecombined")
    @Override
    public String getTradecombined(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Tradecombined_usecases tradecombinedusecases = new Tradecombined_usecases(loggedin);
            return get_tradecombined_with_primarykey(tradecombinedusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "insertTradecombined")
    @Override
    public void insertTradecombined(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Tradecombined_usecases tradecombinedusecases = new Tradecombined_usecases(loggedin);
            insert_tradecombined(tradecombinedusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "updateTradecombined")
    @Override
    public void updateTradecombined(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Tradecombined_usecases tradecombinedusecases = new Tradecombined_usecases(loggedin);
            update_tradecombined(tradecombinedusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "deleteTradecombined")
    @Override
    public void deleteTradecombined(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Tradecombined_usecases tradecombinedusecases = new Tradecombined_usecases(loggedin);
            delete_tradecombined(tradecombinedusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getTradecombineds4evetype")
    @Override
    public String getTradecombineds4evetype(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Tradecombined_usecases tradecombinedusecases = new Tradecombined_usecases(loggedin);
            return get_tradecombined_with_foreignkey_evetype(tradecombinedusecases, json);
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
            Tradecombined_usecases tradecombinedusecases = new Tradecombined_usecases(loggedin);
            delete_tradecombined(tradecombinedusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getTradecombineds4systemBuy_system")
    @Override
    public String getTradecombineds4systemBuy_system(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Tradecombined_usecases tradecombinedusecases = new Tradecombined_usecases(loggedin);
            return get_tradecombined_with_foreignkey_systemBuy_system(tradecombinedusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "delete4systemBuy_system")
    @Override
    public void delete4systemBuy_system(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Tradecombined_usecases tradecombinedusecases = new Tradecombined_usecases(loggedin);
            delete_tradecombined(tradecombinedusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getTradecombineds4systemSell_system")
    @Override
    public String getTradecombineds4systemSell_system(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Tradecombined_usecases tradecombinedusecases = new Tradecombined_usecases(loggedin);
            return get_tradecombined_with_foreignkey_systemSell_system(tradecombinedusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "delete4systemSell_system")
    @Override
    public void delete4systemSell_system(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Tradecombined_usecases tradecombinedusecases = new Tradecombined_usecases(loggedin);
            delete_tradecombined(tradecombinedusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getTradecombineds4tradecombined_sell")
    @Override
    public String getTradecombineds4tradecombined_sell(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Tradecombined_usecases tradecombinedusecases = new Tradecombined_usecases(loggedin);
            return get_tradecombined_with_externalforeignkey_tradecombined_sell(tradecombinedusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }


    private String count_records(Tradecombined_usecases tradecombinedusecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", tradecombinedusecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_tradecombined(Tradecombined_usecases tradecombinedusecases) throws ParseException, CustomException {
    	return JSONTradecombined.toJSONArray(tradecombinedusecases.get_all()).toJSONString();
    }
    
    private String get_tradecombined_with_primarykey(Tradecombined_usecases tradecombinedusecases, JSONObject json) throws ParseException, CustomException {
        ITradecombinedPK tradecombinedPK = (ITradecombinedPK)JSONTradecombined.toTradecombinedPK((JSONObject)json.get("tradecombinedpk"));
	return JSONTradecombined.toJSON(tradecombinedusecases.get_tradecombined_by_primarykey(tradecombinedPK)).toJSONString();
    }
    
    private String get_tradecombined_with_foreignkey_evetype(Tradecombined_usecases tradecombinedusecases, JSONObject json) throws ParseException, CustomException {
        IEvetypePK evetypePK = (IEvetypePK)JSONEvetype.toEvetypePK((JSONObject)json.get("evetypepk"));
        return JSONTradecombined.toJSONArray(tradecombinedusecases.get_tradecombined_with_foreignkey_evetype(evetypePK)).toJSONString();
    }
    
    private String get_tradecombined_with_foreignkey_systemBuy_system(Tradecombined_usecases tradecombinedusecases, JSONObject json) throws ParseException, CustomException {
        ISystemPK systemBuy_systemPK = (ISystemPK)JSONSystem.toSystemPK((JSONObject)json.get("systempk"));
        return JSONTradecombined.toJSONArray(tradecombinedusecases.get_tradecombined_with_foreignkey_systemBuy_system(systemBuy_systemPK)).toJSONString();
    }
    
    private String get_tradecombined_with_foreignkey_systemSell_system(Tradecombined_usecases tradecombinedusecases, JSONObject json) throws ParseException, CustomException {
        ISystemPK systemSell_systemPK = (ISystemPK)JSONSystem.toSystemPK((JSONObject)json.get("systempk"));
        return JSONTradecombined.toJSONArray(tradecombinedusecases.get_tradecombined_with_foreignkey_systemSell_system(systemSell_systemPK)).toJSONString();
    }
    
    private String get_tradecombined_with_externalforeignkey_tradecombined_sell(Tradecombined_usecases tradecombinedusecases, JSONObject json) throws ParseException, CustomException {
        ITradecombined_sellPK tradecombined_sellPK = (ITradecombined_sellPK)JSONTradecombined_sell.toTradecombined_sellPK((JSONObject)json.get("tradecombined_sellpk"));
        return JSONTradecombined.toJSON(tradecombinedusecases.get_tradecombined_with_externalforeignkey_tradecombined_sell(tradecombined_sellPK)).toJSONString();
    }
    
    private String search_tradecombined(Tradecombined_usecases tradecombinedusecases, JSONObject json) throws ParseException, CustomException {
        ITradecombinedsearch search = (ITradecombinedsearch)JSONTradecombined.toTradecombinedsearch((JSONObject)json.get("search"));
        return JSONTradecombined.toJSONArray(tradecombinedusecases.search_tradecombined(search)).toJSONString();
    }
    
    private String search_tradecombined_count(Tradecombined_usecases tradecombinedusecases, JSONObject json) throws ParseException, CustomException {
        ITradecombinedsearch tradecombinedsearch = (ITradecombinedsearch)JSONTradecombined.toTradecombinedsearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", tradecombinedusecases.search_tradecombined_count(tradecombinedsearch));
        return jsonsearchcount.toJSONString();
    }

    private void insert_tradecombined(Tradecombined_usecases tradecombinedusecases, JSONObject json) throws ParseException, CustomException {
        ITradecombined tradecombined = (ITradecombined)JSONTradecombined.toTradecombined((JSONObject)json.get("tradecombined"));
        tradecombinedusecases.insertTradecombined(tradecombined);
        setReturnstatus("OK");
    }

    private void update_tradecombined(Tradecombined_usecases tradecombinedusecases, JSONObject json) throws ParseException, CustomException {
        ITradecombined tradecombined = (ITradecombined)JSONTradecombined.toTradecombined((JSONObject)json.get("tradecombined"));
        tradecombinedusecases.updateTradecombined(tradecombined);
        setReturnstatus("OK");
    }

    private void delete_tradecombined(Tradecombined_usecases tradecombinedusecases, JSONObject json) throws ParseException, CustomException {
        ITradecombined tradecombined = (ITradecombined)JSONTradecombined.toTradecombined((JSONObject)json.get("tradecombined"));
        tradecombinedusecases.deleteTradecombined(tradecombined);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Evetype(Tradecombined_usecases tradecombinedusecases, JSONObject json) throws ParseException, CustomException {
        IEvetypePK evetypePK = (IEvetypePK)JSONEvetype.toEvetypePK((JSONObject)json.get("evetypepk"));
        tradecombinedusecases.delete_all_containing_Evetype(evetypePK);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Systembuy_system(Tradecombined_usecases tradecombinedusecases, JSONObject json) throws ParseException, CustomException {
        ISystemPK systemBuy_systemPK = (ISystemPK)JSONSystem.toSystemPK((JSONObject)json.get("systempk"));
        tradecombinedusecases.delete_all_containing_Systembuy_system(systemBuy_systemPK);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Systemsell_system(Tradecombined_usecases tradecombinedusecases, JSONObject json) throws ParseException, CustomException {
        ISystemPK systemSell_systemPK = (ISystemPK)JSONSystem.toSystemPK((JSONObject)json.get("systempk"));
        tradecombinedusecases.delete_all_containing_Systemsell_system(systemSell_systemPK);
        setReturnstatus("OK");
    }

}

