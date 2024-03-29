/*
 * Generated on 23.8.2022 14:38
 * @author Franky Laseure
 */

package eve.restservices.order_history;

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
import eve.interfaces.searchentity.IOrder_historysearch;
import eve.interfaces.servlet.IOrder_historyOperation;
import eve.logicentity.Order_history;
import eve.searchentity.Order_historysearch;
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

@Path("rsorder_history_select")
public class RSOrder_history_select extends RS_json_login {

    private Security_usecases security_usecases = new Security_usecases();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Order_history_usecases order_historyusecases = new Order_history_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IOrder_historyOperation.SELECT_COUNT:
                    result = count_records(order_historyusecases);
                    break;
                case IOrder_historyOperation.SELECT_ALL:
                    result = get_all_order_history(order_historyusecases);
                    break;
                case IOrder_historyOperation.SELECT_ORDER_HISTORY:
                    result = get_order_history_with_primarykey(order_historyusecases, json);
                    break;
                case IOrder_historyOperation.SELECT_Evetype:
                    result = get_order_history_with_foreignkey_evetype(order_historyusecases, json);
                    break;
                case IOrder_historyOperation.SELECT_Region:
                    result = get_order_history_with_foreignkey_region(order_historyusecases, json);
                    break;
                case IOrder_historyOperation.SELECT_SEARCH:
                    result = search_order_history(order_historyusecases, json);
                    break;
                case IOrder_historyOperation.SELECT_SEARCHCOUNT:
                    result = search_order_history_count(order_historyusecases, json);
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

    private String count_records(Order_history_usecases order_historyusecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", order_historyusecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_order_history(Order_history_usecases order_historyusecases) throws ParseException, CustomException {
    	return JSONOrder_history.toJSONArray(order_historyusecases.get_all()).toJSONString();
    }
    
    private String get_order_history_with_primarykey(Order_history_usecases order_historyusecases, JSONObject json) throws ParseException, CustomException {
        IOrder_historyPK order_historyPK = (IOrder_historyPK)JSONOrder_history.toOrder_historyPK((JSONObject)json.get("order_historypk"));
	return JSONOrder_history.toJSON(order_historyusecases.get_order_history_by_primarykey(order_historyPK)).toJSONString();
    }
    
    private String get_order_history_with_foreignkey_evetype(Order_history_usecases order_historyusecases, JSONObject json) throws ParseException, CustomException {
        IEvetypePK evetypePK = (IEvetypePK)JSONEvetype.toEvetypePK((JSONObject)json.get("evetypepk"));
        return JSONOrder_history.toJSONArray(order_historyusecases.get_order_history_with_foreignkey_evetype(evetypePK)).toJSONString();
    }
    
    private String get_order_history_with_foreignkey_region(Order_history_usecases order_historyusecases, JSONObject json) throws ParseException, CustomException {
        IRegionPK regionPK = (IRegionPK)JSONRegion.toRegionPK((JSONObject)json.get("regionpk"));
        return JSONOrder_history.toJSONArray(order_historyusecases.get_order_history_with_foreignkey_region(regionPK)).toJSONString();
    }
    
    private String search_order_history(Order_history_usecases order_historyusecases, JSONObject json) throws ParseException, CustomException {
        IOrder_historysearch search = (IOrder_historysearch)JSONOrder_history.toOrder_historysearch((JSONObject)json.get("search"));
        return JSONOrder_history.toJSONArray(order_historyusecases.search_order_history(search)).toJSONString();
    }
    
    private String search_order_history_count(Order_history_usecases order_historyusecases, JSONObject json) throws ParseException, CustomException {
        IOrder_historysearch order_historysearch = (IOrder_historysearch)JSONOrder_history.toOrder_historysearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", order_historyusecases.search_order_history_count(order_historysearch));
        return jsonsearchcount.toJSONString();
    }
}

