/*
 * Generated on 13.6.2022 18:20
 */

package eve.restservices.evetype;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.usecases.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.searchentity.IEvetypesearch;
import eve.interfaces.servlet.IEvetypeOperation;
import eve.logicentity.Evetype;
import eve.searchentity.Evetypesearch;
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
@Path("rsevetype_select")
public class RSEvetype_select extends RS_json_login {

    private Security_usecases security_usecases = new Security_usecases();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Evetype_usecases evetypeusecases = new Evetype_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IEvetypeOperation.SELECT_COUNT:
                    result = count_records(evetypeusecases);
                    break;
                case IEvetypeOperation.SELECT_ALL:
                    result = get_all_evetype(evetypeusecases);
                    break;
                case IEvetypeOperation.SELECT_EVETYPE:
                    result = get_evetype_with_primarykey(evetypeusecases, json);
                    break;
                case IEvetypeOperation.SELECT_Market_group:
                    result = get_evetype_with_foreignkey_market_group(evetypeusecases, json);
                    break;
                case IEvetypeOperation.SELECT_Typegroup:
                    result = get_evetype_with_foreignkey_typegroup(evetypeusecases, json);
                    break;
                case IEvetypeOperation.SELECT_Graphic:
                    result = get_evetype_with_foreignkey_graphic(evetypeusecases, json);
                    break;
                case IEvetypeOperation.SELECT_Wishlist:
                    result = get_evetype_with_externalforeignkey_wishlist(evetypeusecases, json);
                    break;
                case IEvetypeOperation.SELECT_Materialinput:
                    result = get_evetype_with_externalforeignkey_materialinput(evetypeusecases, json);
                    break;
                case IEvetypeOperation.SELECT_Bpmaterialbp:
                    result = get_evetype_with_externalforeignkey_bpmaterialBp(evetypeusecases, json);
                    break;
                case IEvetypeOperation.SELECT_Bpmaterialmaterial:
                    result = get_evetype_with_externalforeignkey_bpmaterialMaterial(evetypeusecases, json);
                    break;
                case IEvetypeOperation.SELECT_Order_history_month:
                    result = get_evetype_with_externalforeignkey_order_history_month(evetypeusecases, json);
                    break;
                case IEvetypeOperation.SELECT_Stock:
                    result = get_evetype_with_externalforeignkey_stock(evetypeusecases, json);
                    break;
                case IEvetypeOperation.SELECT_Order_history:
                    result = get_evetype_with_externalforeignkey_order_history(evetypeusecases, json);
                    break;
                case IEvetypeOperation.SELECT_Shipfitmodule:
                    result = get_evetype_with_externalforeignkey_shipfitmodule(evetypeusecases, json);
                    break;
                case IEvetypeOperation.SELECT_Shipfitorder:
                    result = get_evetype_with_externalforeignkey_shipfitorder(evetypeusecases, json);
                    break;
                case IEvetypeOperation.SELECT_Tradecombined:
                    result = get_evetype_with_externalforeignkey_tradecombined(evetypeusecases, json);
                    break;
                case IEvetypeOperation.SELECT_Userbp:
                    result = get_evetype_with_externalforeignkey_userbp(evetypeusecases, json);
                    break;
                case IEvetypeOperation.SELECT_SEARCH:
                    result = search_evetype(evetypeusecases, json);
                    break;
                case IEvetypeOperation.SELECT_SEARCHCOUNT:
                    result = search_evetype_count(evetypeusecases, json);
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
}

