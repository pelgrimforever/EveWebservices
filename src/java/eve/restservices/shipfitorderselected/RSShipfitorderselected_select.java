/*
 * Generated on 17.6.2022 13:4
 */

package eve.restservices.shipfitorderselected;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.usecases.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.searchentity.IShipfitorderselectedsearch;
import eve.interfaces.servlet.IShipfitorderselectedOperation;
import eve.logicentity.Shipfitorderselected;
import eve.searchentity.Shipfitorderselectedsearch;
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
@Path("rsshipfitorderselected_select")
public class RSShipfitorderselected_select extends RS_json_login {

    private Security_usecases security_usecases = new Security_usecases();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Shipfitorderselected_usecases shipfitorderselectedusecases = new Shipfitorderselected_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IShipfitorderselectedOperation.SELECT_COUNT:
                    result = count_records(shipfitorderselectedusecases);
                    break;
                case IShipfitorderselectedOperation.SELECT_ALL:
                    result = get_all_shipfitorderselected(shipfitorderselectedusecases);
                    break;
                case IShipfitorderselectedOperation.SELECT_SHIPFITORDERSELECTED:
                    result = get_shipfitorderselected_with_primarykey(shipfitorderselectedusecases, json);
                    break;
                case IShipfitorderselectedOperation.SELECT_Orders:
                    result = get_shipfitorderselected_with_foreignkey_orders(shipfitorderselectedusecases, json);
                    break;
                case IShipfitorderselectedOperation.SELECT_Shipfitorder:
                    result = get_shipfitorderselected_with_foreignkey_shipfitorder(shipfitorderselectedusecases, json);
                    break;
                case IShipfitorderselectedOperation.SELECT_SEARCH:
                    result = search_shipfitorderselected(shipfitorderselectedusecases, json);
                    break;
                case IShipfitorderselectedOperation.SELECT_SEARCHCOUNT:
                    result = search_shipfitorderselected_count(shipfitorderselectedusecases, json);
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

    private String count_records(Shipfitorderselected_usecases shipfitorderselectedusecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", shipfitorderselectedusecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_shipfitorderselected(Shipfitorderselected_usecases shipfitorderselectedusecases) throws ParseException, CustomException {
    	return JSONShipfitorderselected.toJSONArray(shipfitorderselectedusecases.get_all()).toJSONString();
    }
    
    private String get_shipfitorderselected_with_primarykey(Shipfitorderselected_usecases shipfitorderselectedusecases, JSONObject json) throws ParseException, CustomException {
        IShipfitorderselectedPK shipfitorderselectedPK = (IShipfitorderselectedPK)JSONShipfitorderselected.toShipfitorderselectedPK((JSONObject)json.get("shipfitorderselectedpk"));
	return JSONShipfitorderselected.toJSON(shipfitorderselectedusecases.get_shipfitorderselected_by_primarykey(shipfitorderselectedPK)).toJSONString();
    }
    
    private String get_shipfitorderselected_with_foreignkey_orders(Shipfitorderselected_usecases shipfitorderselectedusecases, JSONObject json) throws ParseException, CustomException {
        IOrdersPK ordersPK = (IOrdersPK)JSONOrders.toOrdersPK((JSONObject)json.get("orderspk"));
        return JSONShipfitorderselected.toJSONArray(shipfitorderselectedusecases.get_shipfitorderselected_with_foreignkey_orders(ordersPK)).toJSONString();
    }
    
    private String get_shipfitorderselected_with_foreignkey_shipfitorder(Shipfitorderselected_usecases shipfitorderselectedusecases, JSONObject json) throws ParseException, CustomException {
        IShipfitorderPK shipfitorderPK = (IShipfitorderPK)JSONShipfitorder.toShipfitorderPK((JSONObject)json.get("shipfitorderpk"));
        return JSONShipfitorderselected.toJSONArray(shipfitorderselectedusecases.get_shipfitorderselected_with_foreignkey_shipfitorder(shipfitorderPK)).toJSONString();
    }
    
    private String search_shipfitorderselected(Shipfitorderselected_usecases shipfitorderselectedusecases, JSONObject json) throws ParseException, CustomException {
        IShipfitorderselectedsearch search = (IShipfitorderselectedsearch)JSONShipfitorderselected.toShipfitorderselectedsearch((JSONObject)json.get("search"));
        return JSONShipfitorderselected.toJSONArray(shipfitorderselectedusecases.search_shipfitorderselected(search)).toJSONString();
    }
    
    private String search_shipfitorderselected_count(Shipfitorderselected_usecases shipfitorderselectedusecases, JSONObject json) throws ParseException, CustomException {
        IShipfitorderselectedsearch shipfitorderselectedsearch = (IShipfitorderselectedsearch)JSONShipfitorderselected.toShipfitorderselectedsearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", shipfitorderselectedusecases.search_shipfitorderselected_count(shipfitorderselectedsearch));
        return jsonsearchcount.toJSONString();
    }
}

