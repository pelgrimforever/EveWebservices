/*
 * Generated on 13.4.2022 19:13
 */

package eve.restservices.order_history_month;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.usecases.Order_history_month_usecases;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.searchentity.IOrder_history_monthsearch;
import eve.interfaces.servlet.IOrder_history_monthOperation;
import eve.logicentity.Order_history_month;
import eve.searchentity.Order_history_monthsearch;
import eve.servlets.DataServlet;
import eve.usecases.Security_usecases;
import general.exception.CustomException;
import general.exception.DataException;
import general.exception.DBException;
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
@Path("rsorder_history_month_select")
public class RSOrder_history_month_select extends RS_json_login {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(Security_usecases.check_authorization(authorisationstring));
            IOrder_history_monthPK order_history_monthPK;
            IOrder_history_month order_history_month;
            Order_history_month_usecases order_history_monthusecases = new Order_history_month_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IOrder_history_monthOperation.SELECT_COUNT:
                    result = count_records(order_history_monthusecases);
                    break;
                case IOrder_history_monthOperation.SELECT_ALL:
                    result = get_all_order_history_month(order_history_monthusecases);
                    break;
                case IOrder_history_monthOperation.SELECT_ORDER_HISTORY_MONTH:
                    result = get_order_history_month_with_primarykey(order_history_monthusecases, json);
                    break;
                case IOrder_history_monthOperation.SELECT_Evetype:
                    result = get_order_history_month_with_foreignkey_evetype(order_history_monthusecases, json);
                    break;
                case IOrder_history_monthOperation.SELECT_Region:
                    result = get_order_history_month_with_foreignkey_region(order_history_monthusecases, json);
                    break;
                case IOrder_history_monthOperation.SELECT_SEARCH:
                    result = search_order_history_month(order_history_monthusecases, json);
                    break;
                case IOrder_history_monthOperation.SELECT_SEARCHCOUNT:
                    result = search_order_history_month_count(order_history_monthusecases, json);
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

    private String count_records(Order_history_month_usecases order_history_monthusecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", order_history_monthusecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_order_history_month(Order_history_month_usecases order_history_monthusecases) throws ParseException, CustomException {
    	return JSONOrder_history_month.toJSONArray(order_history_monthusecases.get_all()).toJSONString();
    }
    
    private String get_order_history_month_with_primarykey(Order_history_month_usecases order_history_monthusecases, JSONObject json) throws ParseException, CustomException {
        IOrder_history_monthPK order_history_monthPK = (IOrder_history_monthPK)JSONOrder_history_month.toOrder_history_monthPK((JSONObject)json.get("order_history_monthpk"));
	return JSONOrder_history_month.toJSON(order_history_monthusecases.get_order_history_month_by_primarykey(order_history_monthPK)).toJSONString();
    }
    
    private String get_order_history_month_with_foreignkey_evetype(Order_history_month_usecases order_history_monthusecases, JSONObject json) throws ParseException, CustomException {
        IEvetypePK evetypePK = (IEvetypePK)JSONEvetype.toEvetypePK((JSONObject)json.get("evetypepk"));
        return JSONOrder_history_month.toJSONArray(order_history_monthusecases.get_order_history_month_with_foreignkey_evetype(evetypePK)).toJSONString();
    }
    
    private String get_order_history_month_with_foreignkey_region(Order_history_month_usecases order_history_monthusecases, JSONObject json) throws ParseException, CustomException {
        IRegionPK regionPK = (IRegionPK)JSONRegion.toRegionPK((JSONObject)json.get("regionpk"));
        return JSONOrder_history_month.toJSONArray(order_history_monthusecases.get_order_history_month_with_foreignkey_region(regionPK)).toJSONString();
    }
    
    private String search_order_history_month(Order_history_month_usecases order_history_monthusecases, JSONObject json) throws ParseException, CustomException {
        IOrder_history_monthsearch search = (IOrder_history_monthsearch)JSONOrder_history_month.toOrder_history_monthsearch((JSONObject)json.get("search"));
        return JSONOrder_history_month.toJSONArray(order_history_monthusecases.search_order_history_month(search)).toJSONString();
    }
    
    private String search_order_history_month_count(Order_history_month_usecases order_history_monthusecases, JSONObject json) throws ParseException, CustomException {
        IOrder_history_monthsearch order_history_monthsearch = (IOrder_history_monthsearch)JSONOrder_history_month.toOrder_history_monthsearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", order_history_monthusecases.search_order_history_month_count(order_history_monthsearch));
        return jsonsearchcount.toJSONString();
    }
}

