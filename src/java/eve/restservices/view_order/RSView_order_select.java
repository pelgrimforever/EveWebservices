/*
 * Generated on 13.6.2022 18:20
 */

package eve.restservices.view_order;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import eve.BusinessObject.Logic.*;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.interfaces.logicview.IView_order;
import eve.interfaces.servlet.IView_orderOperation;
import eve.usecases.View_order_usecases;
import eve.logicview.View_order;
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
@Path("rsview_order_select")
public class RSView_order_select extends RS_json_login {

    private Security_usecases security_usecases = new Security_usecases();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            View_order_usecases view_orderusecases = new View_order_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IView_orderOperation.SELECT_ALL:
                    result = get_all_view_order(view_orderusecases);
                    break;
//Custom code, do not change this line
//add here custom operations
                case IView_orderOperation.SELECT_ONE:
                    result = getView_order_for_primarykey(view_orderusecases, json);
                    break;
                case IView_orderOperation.SELECT_EVETYPE_SELL:
                    result = getView_orders4evetype_sell(view_orderusecases, json);
                    break;
                case IView_orderOperation.SELECT_EVETYPE_BUY:
                    EvetypePK evetypePKbuy = (EvetypePK)JSONEvetype.toEvetypePK((JSONObject)json.get("evetypepk"));
                    result = getView_orders4evetype_buy(view_orderusecases, json);
                    break;
                case IView_orderOperation.SELECT_LOWPRICE_SELL:
                    result = getView_ordersAtselllowprice_with_startsystem(view_orderusecases, json);
                    break;
                case IView_orderOperation.SELECT_Wishlistorders:
                    result = getOrders4Wishlist_for_user(view_orderusecases, json);
                    break;
                case IView_orderOperation.SELECT_EVETYPE_REGION_SELL:
                    result = getView_orders4evetyperegion_sell(view_orderusecases, json);
                    break;
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
    private String getView_order_for_primarykey(View_order_usecases view_orderinteractor, JSONObject json) throws ParseException, CustomException {
        OrdersPK orderPK = (OrdersPK)JSONOrders.toOrdersPK((JSONObject)json.get("orderpk"));
        return JSONView_order.toJSON(view_orderinteractor.getView_order_for_primarykey_usecase(orderPK)).toJSONString();
    }

    private String getView_orders4evetype_sell(View_order_usecases view_orderinteractor, JSONObject json) throws ParseException, CustomException {
        EvetypePK evetypePKsell = (EvetypePK)JSONEvetype.toEvetypePK((JSONObject)json.get("evetypepk"));
        return JSONView_order.toJSONArray(view_orderinteractor.getView_orders4evetype_sell_usecase(evetypePKsell)).toJSONString();
    }

    private String getView_orders4evetype_buy(View_order_usecases view_orderinteractor, JSONObject json) throws ParseException, CustomException {
        EvetypePK evetypePKbuy = (EvetypePK)JSONEvetype.toEvetypePK((JSONObject)json.get("evetypepk"));
        return JSONView_order.toJSONArray(view_orderinteractor.getView_orders4evetype_buy_usecase(evetypePKbuy)).toJSONString();
    }

    private String getView_ordersAtselllowprice_with_startsystem(View_order_usecases view_orderinteractor, JSONObject json) throws ParseException, CustomException {
        eve.entity.pk.SystemPK systemPK = (eve.entity.pk.SystemPK)JSONSystem.toSystemPK((JSONObject)json.get("systempk"));
        return JSONView_order.toJSONArray(view_orderinteractor.getView_ordersAtselllowprice_with_startsystem_usecase(systemPK)).toJSONString();
    }

    private String getOrders4Wishlist_for_user(View_order_usecases view_orderinteractor, JSONObject json) throws ParseException, CustomException {
        String username = JSONConversion.getString(json, "username");
        return JSONView_order.toJSONArray(view_orderinteractor.getOrders4Wishlist_for_user_usecase(username)).toJSONString();
    }

    private String getView_orders4evetyperegion_sell(View_order_usecases view_orderinteractor, JSONObject json) throws ParseException, CustomException {
        EvetypePK evetypePKsellr = (EvetypePK)JSONEvetype.toEvetypePK((JSONObject)json.get("evetypepk"));
        RegionPK regionPKsellr = (RegionPK)JSONRegion.toRegionPK((JSONObject)json.get("regionpk"));
        return JSONView_order.toJSONArray(view_orderinteractor.getView_orders4evetyperegion_sell_usecase(evetypePKsellr, regionPKsellr)).toJSONString();
    }
//Custom code, do not change this line   

    private String get_all_view_order(View_order_usecases view_orderusecases) throws ParseException, CustomException {
    	return JSONView_order.toJSONArray(view_orderusecases.get_all()).toJSONString();
    }
}

