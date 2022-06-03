/*
 * Generated on 20.4.2022 10:3
 */

package eve.restservices.json_orders;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.usecases.Json_orders_usecases;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.searchentity.IJson_orderssearch;
import eve.interfaces.servlet.IJson_ordersOperation;
import eve.logicentity.Json_orders;
import eve.searchentity.Json_orderssearch;
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
@Path("rsjson_orders_select")
public class RSJson_orders_select extends RS_json_login {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(Security_usecases.check_authorization(authorisationstring));
            IJson_ordersPK json_ordersPK;
            IJson_orders json_orders;
            Json_orders_usecases json_ordersusecases = new Json_orders_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IJson_ordersOperation.SELECT_COUNT:
                    result = count_records(json_ordersusecases);
                    break;
                case IJson_ordersOperation.SELECT_ALL:
                    result = get_all_json_orders(json_ordersusecases);
                    break;
                case IJson_ordersOperation.SELECT_JSON_ORDERS:
                    result = get_json_orders_with_primarykey(json_ordersusecases, json);
                    break;
                case IJson_ordersOperation.SELECT_SEARCH:
                    result = search_json_orders(json_ordersusecases, json);
                    break;
                case IJson_ordersOperation.SELECT_SEARCHCOUNT:
                    result = search_json_orders_count(json_ordersusecases, json);
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

    private String count_records(Json_orders_usecases json_ordersusecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", json_ordersusecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_json_orders(Json_orders_usecases json_ordersusecases) throws ParseException, CustomException {
    	return JSONJson_orders.toJSONArray(json_ordersusecases.get_all()).toJSONString();
    }
    
    private String get_json_orders_with_primarykey(Json_orders_usecases json_ordersusecases, JSONObject json) throws ParseException, CustomException {
        IJson_ordersPK json_ordersPK = (IJson_ordersPK)JSONJson_orders.toJson_ordersPK((JSONObject)json.get("json_orderspk"));
	return JSONJson_orders.toJSON(json_ordersusecases.get_json_orders_by_primarykey(json_ordersPK)).toJSONString();
    }
    
    private String search_json_orders(Json_orders_usecases json_ordersusecases, JSONObject json) throws ParseException, CustomException {
        IJson_orderssearch search = (IJson_orderssearch)JSONJson_orders.toJson_orderssearch((JSONObject)json.get("search"));
        return JSONJson_orders.toJSONArray(json_ordersusecases.search_json_orders(search)).toJSONString();
    }
    
    private String search_json_orders_count(Json_orders_usecases json_ordersusecases, JSONObject json) throws ParseException, CustomException {
        IJson_orderssearch json_orderssearch = (IJson_orderssearch)JSONJson_orders.toJson_orderssearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", json_ordersusecases.search_json_orders_count(json_orderssearch));
        return jsonsearchcount.toJSONString();
    }
}

