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
import eve.interfaces.searchentity.IEvetypesearch;
import eve.interfaces.webservice.WSIEvetype;
import eve.logicentity.Evetype;
import eve.searchentity.Evetypesearch;
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

@WebService(endpointInterface = "eve.interfaces.webservice.WSIEvetype")
public class WSEvetype extends RS_json_login implements WSIEvetype {

    private Security_usecases security_usecases = new Security_usecases();
    
    private JSONArray toJSONArray(ArrayList evetypes) {
        JSONArray jsonevetypes = new JSONArray();
        Iterator evetypesI = evetypes.iterator();
        while(evetypesI.hasNext()) {
            jsonevetypes.add(JSONEvetype.toJSON((Evetype)evetypesI.next()));
        }
        return jsonevetypes;
    }

    //@WebMethod(operationName = "getEvetypes")
    @Override
    public String getEvetypes() {
        try {
            Evetype_usecases evetypeusecases = new Evetype_usecases(loggedin);
            return get_all_evetype(evetypeusecases);
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
            Evetype_usecases evetypeusecases = new Evetype_usecases(loggedin);
            return search_evetype(evetypeusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "getEvetype")
    @Override
    public String getEvetype(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Evetype_usecases evetypeusecases = new Evetype_usecases(loggedin);
            return get_evetype_with_primarykey(evetypeusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "insertEvetype")
    @Override
    public void insertEvetype(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Evetype_usecases evetypeusecases = new Evetype_usecases(loggedin);
            insert_evetype(evetypeusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "updateEvetype")
    @Override
    public void updateEvetype(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Evetype_usecases evetypeusecases = new Evetype_usecases(loggedin);
            update_evetype(evetypeusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "deleteEvetype")
    @Override
    public void deleteEvetype(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Evetype_usecases evetypeusecases = new Evetype_usecases(loggedin);
            delete_evetype(evetypeusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getEvetypes4market_group")
    @Override
    public String getEvetypes4market_group(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Evetype_usecases evetypeusecases = new Evetype_usecases(loggedin);
            return get_evetype_with_foreignkey_market_group(evetypeusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "delete4market_group")
    @Override
    public void delete4market_group(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Evetype_usecases evetypeusecases = new Evetype_usecases(loggedin);
            delete_evetype(evetypeusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getEvetypes4typegroup")
    @Override
    public String getEvetypes4typegroup(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Evetype_usecases evetypeusecases = new Evetype_usecases(loggedin);
            return get_evetype_with_foreignkey_typegroup(evetypeusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "delete4typegroup")
    @Override
    public void delete4typegroup(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Evetype_usecases evetypeusecases = new Evetype_usecases(loggedin);
            delete_evetype(evetypeusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getEvetypes4graphic")
    @Override
    public String getEvetypes4graphic(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Evetype_usecases evetypeusecases = new Evetype_usecases(loggedin);
            return get_evetype_with_foreignkey_graphic(evetypeusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "delete4graphic")
    @Override
    public void delete4graphic(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Evetype_usecases evetypeusecases = new Evetype_usecases(loggedin);
            delete_evetype(evetypeusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getEvetypes4wishlist")
    @Override
    public String getEvetypes4wishlist(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Evetype_usecases evetypeusecases = new Evetype_usecases(loggedin);
            return get_evetype_with_externalforeignkey_wishlist(evetypeusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "getEvetypes4materialinput")
    @Override
    public String getEvetypes4materialinput(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Evetype_usecases evetypeusecases = new Evetype_usecases(loggedin);
            return get_evetype_with_externalforeignkey_materialinput(evetypeusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "getEvetypes4bpmaterialBp")
    @Override
    public String getEvetypes4bpmaterialBp(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Evetype_usecases evetypeusecases = new Evetype_usecases(loggedin);
            return get_evetype_with_externalforeignkey_bpmaterialBp(evetypeusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "getEvetypes4bpmaterialMaterial")
    @Override
    public String getEvetypes4bpmaterialMaterial(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Evetype_usecases evetypeusecases = new Evetype_usecases(loggedin);
            return get_evetype_with_externalforeignkey_bpmaterialMaterial(evetypeusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "getEvetypes4order_history_month")
    @Override
    public String getEvetypes4order_history_month(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Evetype_usecases evetypeusecases = new Evetype_usecases(loggedin);
            return get_evetype_with_externalforeignkey_order_history_month(evetypeusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "getEvetypes4stock")
    @Override
    public String getEvetypes4stock(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Evetype_usecases evetypeusecases = new Evetype_usecases(loggedin);
            return get_evetype_with_externalforeignkey_stock(evetypeusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "getEvetypes4order_history")
    @Override
    public String getEvetypes4order_history(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Evetype_usecases evetypeusecases = new Evetype_usecases(loggedin);
            return get_evetype_with_externalforeignkey_order_history(evetypeusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "getEvetypes4shipfitmodule")
    @Override
    public String getEvetypes4shipfitmodule(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Evetype_usecases evetypeusecases = new Evetype_usecases(loggedin);
            return get_evetype_with_externalforeignkey_shipfitmodule(evetypeusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "getEvetypes4shipfitorder")
    @Override
    public String getEvetypes4shipfitorder(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Evetype_usecases evetypeusecases = new Evetype_usecases(loggedin);
            return get_evetype_with_externalforeignkey_shipfitorder(evetypeusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "getEvetypes4tradecombined")
    @Override
    public String getEvetypes4tradecombined(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Evetype_usecases evetypeusecases = new Evetype_usecases(loggedin);
            return get_evetype_with_externalforeignkey_tradecombined(evetypeusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "getEvetypes4userbp")
    @Override
    public String getEvetypes4userbp(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Evetype_usecases evetypeusecases = new Evetype_usecases(loggedin);
            return get_evetype_with_externalforeignkey_userbp(evetypeusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }


    private String count_records(Evetype_usecases evetypeusecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", evetypeusecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_evetype(Evetype_usecases evetypeusecases) throws ParseException, CustomException {
    	return JSONEvetype.toJSONArray(evetypeusecases.get_all()).toJSONString();
    }
    
    private String get_evetype_with_primarykey(Evetype_usecases evetypeusecases, JSONObject json) throws ParseException, CustomException {
        IEvetypePK evetypePK = (IEvetypePK)JSONEvetype.toEvetypePK((JSONObject)json.get("evetypepk"));
	return JSONEvetype.toJSON(evetypeusecases.get_evetype_by_primarykey(evetypePK)).toJSONString();
    }
    
    private String get_evetype_with_foreignkey_market_group(Evetype_usecases evetypeusecases, JSONObject json) throws ParseException, CustomException {
        IMarket_groupPK market_groupPK = (IMarket_groupPK)JSONMarket_group.toMarket_groupPK((JSONObject)json.get("market_grouppk"));
        return JSONEvetype.toJSONArray(evetypeusecases.get_evetype_with_foreignkey_market_group(market_groupPK)).toJSONString();
    }
    
    private String get_evetype_with_foreignkey_typegroup(Evetype_usecases evetypeusecases, JSONObject json) throws ParseException, CustomException {
        ITypegroupPK typegroupPK = (ITypegroupPK)JSONTypegroup.toTypegroupPK((JSONObject)json.get("typegrouppk"));
        return JSONEvetype.toJSONArray(evetypeusecases.get_evetype_with_foreignkey_typegroup(typegroupPK)).toJSONString();
    }
    
    private String get_evetype_with_foreignkey_graphic(Evetype_usecases evetypeusecases, JSONObject json) throws ParseException, CustomException {
        IGraphicPK graphicPK = (IGraphicPK)JSONGraphic.toGraphicPK((JSONObject)json.get("graphicpk"));
        return JSONEvetype.toJSONArray(evetypeusecases.get_evetype_with_foreignkey_graphic(graphicPK)).toJSONString();
    }
    
    private String get_evetype_with_externalforeignkey_wishlist(Evetype_usecases evetypeusecases, JSONObject json) throws ParseException, CustomException {
        IWishlistPK wishlistPK = (IWishlistPK)JSONWishlist.toWishlistPK((JSONObject)json.get("wishlistpk"));
        return JSONEvetype.toJSON(evetypeusecases.get_evetype_with_externalforeignkey_wishlist(wishlistPK)).toJSONString();
    }
    
    private String get_evetype_with_externalforeignkey_materialinput(Evetype_usecases evetypeusecases, JSONObject json) throws ParseException, CustomException {
        IMaterialinputPK materialinputPK = (IMaterialinputPK)JSONMaterialinput.toMaterialinputPK((JSONObject)json.get("materialinputpk"));
        return JSONEvetype.toJSON(evetypeusecases.get_evetype_with_externalforeignkey_materialinput(materialinputPK)).toJSONString();
    }
    
    private String get_evetype_with_externalforeignkey_bpmaterialBp(Evetype_usecases evetypeusecases, JSONObject json) throws ParseException, CustomException {
        IBpmaterialPK bpmaterialBpPK = (IBpmaterialPK)JSONBpmaterial.toBpmaterialPK((JSONObject)json.get("bpmaterialpk"));
        return JSONEvetype.toJSON(evetypeusecases.get_evetype_with_externalforeignkey_bpmaterialBp(bpmaterialBpPK)).toJSONString();
    }
    
    private String get_evetype_with_externalforeignkey_bpmaterialMaterial(Evetype_usecases evetypeusecases, JSONObject json) throws ParseException, CustomException {
        IBpmaterialPK bpmaterialMaterialPK = (IBpmaterialPK)JSONBpmaterial.toBpmaterialPK((JSONObject)json.get("bpmaterialpk"));
        return JSONEvetype.toJSON(evetypeusecases.get_evetype_with_externalforeignkey_bpmaterialMaterial(bpmaterialMaterialPK)).toJSONString();
    }
    
    private String get_evetype_with_externalforeignkey_order_history_month(Evetype_usecases evetypeusecases, JSONObject json) throws ParseException, CustomException {
        IOrder_history_monthPK order_history_monthPK = (IOrder_history_monthPK)JSONOrder_history_month.toOrder_history_monthPK((JSONObject)json.get("order_history_monthpk"));
        return JSONEvetype.toJSON(evetypeusecases.get_evetype_with_externalforeignkey_order_history_month(order_history_monthPK)).toJSONString();
    }
    
    private String get_evetype_with_externalforeignkey_stock(Evetype_usecases evetypeusecases, JSONObject json) throws ParseException, CustomException {
        IStockPK stockPK = (IStockPK)JSONStock.toStockPK((JSONObject)json.get("stockpk"));
        return JSONEvetype.toJSON(evetypeusecases.get_evetype_with_externalforeignkey_stock(stockPK)).toJSONString();
    }
    
    private String get_evetype_with_externalforeignkey_order_history(Evetype_usecases evetypeusecases, JSONObject json) throws ParseException, CustomException {
        IOrder_historyPK order_historyPK = (IOrder_historyPK)JSONOrder_history.toOrder_historyPK((JSONObject)json.get("order_historypk"));
        return JSONEvetype.toJSON(evetypeusecases.get_evetype_with_externalforeignkey_order_history(order_historyPK)).toJSONString();
    }
    
    private String get_evetype_with_externalforeignkey_shipfitmodule(Evetype_usecases evetypeusecases, JSONObject json) throws ParseException, CustomException {
        IShipfitmodulePK shipfitmodulePK = (IShipfitmodulePK)JSONShipfitmodule.toShipfitmodulePK((JSONObject)json.get("shipfitmodulepk"));
        return JSONEvetype.toJSON(evetypeusecases.get_evetype_with_externalforeignkey_shipfitmodule(shipfitmodulePK)).toJSONString();
    }
    
    private String get_evetype_with_externalforeignkey_shipfitorder(Evetype_usecases evetypeusecases, JSONObject json) throws ParseException, CustomException {
        IShipfitorderPK shipfitorderPK = (IShipfitorderPK)JSONShipfitorder.toShipfitorderPK((JSONObject)json.get("shipfitorderpk"));
        return JSONEvetype.toJSON(evetypeusecases.get_evetype_with_externalforeignkey_shipfitorder(shipfitorderPK)).toJSONString();
    }
    
    private String get_evetype_with_externalforeignkey_tradecombined(Evetype_usecases evetypeusecases, JSONObject json) throws ParseException, CustomException {
        ITradecombinedPK tradecombinedPK = (ITradecombinedPK)JSONTradecombined.toTradecombinedPK((JSONObject)json.get("tradecombinedpk"));
        return JSONEvetype.toJSON(evetypeusecases.get_evetype_with_externalforeignkey_tradecombined(tradecombinedPK)).toJSONString();
    }
    
    private String get_evetype_with_externalforeignkey_userbp(Evetype_usecases evetypeusecases, JSONObject json) throws ParseException, CustomException {
        IUserbpPK userbpPK = (IUserbpPK)JSONUserbp.toUserbpPK((JSONObject)json.get("userbppk"));
        return JSONEvetype.toJSON(evetypeusecases.get_evetype_with_externalforeignkey_userbp(userbpPK)).toJSONString();
    }
    
    private String search_evetype(Evetype_usecases evetypeusecases, JSONObject json) throws ParseException, CustomException {
        IEvetypesearch search = (IEvetypesearch)JSONEvetype.toEvetypesearch((JSONObject)json.get("search"));
        return JSONEvetype.toJSONArray(evetypeusecases.search_evetype(search)).toJSONString();
    }
    
    private String search_evetype_count(Evetype_usecases evetypeusecases, JSONObject json) throws ParseException, CustomException {
        IEvetypesearch evetypesearch = (IEvetypesearch)JSONEvetype.toEvetypesearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", evetypeusecases.search_evetype_count(evetypesearch));
        return jsonsearchcount.toJSONString();
    }

    private void insert_evetype(Evetype_usecases evetypeusecases, JSONObject json) throws ParseException, CustomException {
        IEvetype evetype = (IEvetype)JSONEvetype.toEvetype((JSONObject)json.get("evetype"));
        evetypeusecases.insertEvetype(evetype);
        setReturnstatus("OK");
    }

    private void update_evetype(Evetype_usecases evetypeusecases, JSONObject json) throws ParseException, CustomException {
        IEvetype evetype = (IEvetype)JSONEvetype.toEvetype((JSONObject)json.get("evetype"));
        evetypeusecases.updateEvetype(evetype);
        setReturnstatus("OK");
    }

    private void delete_evetype(Evetype_usecases evetypeusecases, JSONObject json) throws ParseException, CustomException {
        IEvetype evetype = (IEvetype)JSONEvetype.toEvetype((JSONObject)json.get("evetype"));
        evetypeusecases.deleteEvetype(evetype);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Market_group(Evetype_usecases evetypeusecases, JSONObject json) throws ParseException, CustomException {
        IMarket_groupPK market_groupPK = (IMarket_groupPK)JSONMarket_group.toMarket_groupPK((JSONObject)json.get("market_grouppk"));
        evetypeusecases.delete_all_containing_Market_group(market_groupPK);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Typegroup(Evetype_usecases evetypeusecases, JSONObject json) throws ParseException, CustomException {
        ITypegroupPK typegroupPK = (ITypegroupPK)JSONTypegroup.toTypegroupPK((JSONObject)json.get("typegrouppk"));
        evetypeusecases.delete_all_containing_Typegroup(typegroupPK);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Graphic(Evetype_usecases evetypeusecases, JSONObject json) throws ParseException, CustomException {
        IGraphicPK graphicPK = (IGraphicPK)JSONGraphic.toGraphicPK((JSONObject)json.get("graphicpk"));
        evetypeusecases.delete_all_containing_Graphic(graphicPK);
        setReturnstatus("OK");
    }

}

