/*
 * Generated on 17.6.2022 13:4
 */

package eve.restservices.shipfitorder;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.usecases.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.searchentity.IShipfitordersearch;
import eve.interfaces.servlet.IShipfitorderOperation;
import eve.logicentity.Shipfitorder;
import eve.searchentity.Shipfitordersearch;
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
@Path("rsshipfitorder_select")
public class RSShipfitorder_select extends RS_json_login {

    private Security_usecases security_usecases = new Security_usecases();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Shipfitorder_usecases shipfitorderusecases = new Shipfitorder_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IShipfitorderOperation.SELECT_COUNT:
                    result = count_records(shipfitorderusecases);
                    break;
                case IShipfitorderOperation.SELECT_ALL:
                    result = get_all_shipfitorder(shipfitorderusecases);
                    break;
                case IShipfitorderOperation.SELECT_SHIPFITORDER:
                    result = get_shipfitorder_with_primarykey(shipfitorderusecases, json);
                    break;
                case IShipfitorderOperation.SELECT_Shipfit:
                    result = get_shipfitorder_with_foreignkey_shipfit(shipfitorderusecases, json);
                    break;
                case IShipfitorderOperation.SELECT_Evetype:
                    result = get_shipfitorder_with_foreignkey_evetype(shipfitorderusecases, json);
                    break;
                case IShipfitorderOperation.SELECT_Shipfitorderselected:
                    result = get_shipfitorder_with_externalforeignkey_shipfitorderselected(shipfitorderusecases, json);
                    break;
                case IShipfitorderOperation.SELECT_SEARCH:
                    result = search_shipfitorder(shipfitorderusecases, json);
                    break;
                case IShipfitorderOperation.SELECT_SEARCHCOUNT:
                    result = search_shipfitorder_count(shipfitorderusecases, json);
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

    private String count_records(Shipfitorder_usecases shipfitorderusecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", shipfitorderusecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_shipfitorder(Shipfitorder_usecases shipfitorderusecases) throws ParseException, CustomException {
    	return JSONShipfitorder.toJSONArray(shipfitorderusecases.get_all()).toJSONString();
    }
    
    private String get_shipfitorder_with_primarykey(Shipfitorder_usecases shipfitorderusecases, JSONObject json) throws ParseException, CustomException {
        IShipfitorderPK shipfitorderPK = (IShipfitorderPK)JSONShipfitorder.toShipfitorderPK((JSONObject)json.get("shipfitorderpk"));
	return JSONShipfitorder.toJSON(shipfitorderusecases.get_shipfitorder_by_primarykey(shipfitorderPK)).toJSONString();
    }
    
    private String get_shipfitorder_with_foreignkey_shipfit(Shipfitorder_usecases shipfitorderusecases, JSONObject json) throws ParseException, CustomException {
        IShipfitPK shipfitPK = (IShipfitPK)JSONShipfit.toShipfitPK((JSONObject)json.get("shipfitpk"));
        return JSONShipfitorder.toJSONArray(shipfitorderusecases.get_shipfitorder_with_foreignkey_shipfit(shipfitPK)).toJSONString();
    }
    
    private String get_shipfitorder_with_foreignkey_evetype(Shipfitorder_usecases shipfitorderusecases, JSONObject json) throws ParseException, CustomException {
        IEvetypePK evetypePK = (IEvetypePK)JSONEvetype.toEvetypePK((JSONObject)json.get("evetypepk"));
        return JSONShipfitorder.toJSONArray(shipfitorderusecases.get_shipfitorder_with_foreignkey_evetype(evetypePK)).toJSONString();
    }
    
    private String get_shipfitorder_with_externalforeignkey_shipfitorderselected(Shipfitorder_usecases shipfitorderusecases, JSONObject json) throws ParseException, CustomException {
        IShipfitorderselectedPK shipfitorderselectedPK = (IShipfitorderselectedPK)JSONShipfitorderselected.toShipfitorderselectedPK((JSONObject)json.get("shipfitorderselectedpk"));
        return JSONShipfitorder.toJSON(shipfitorderusecases.get_shipfitorder_with_externalforeignkey_shipfitorderselected(shipfitorderselectedPK)).toJSONString();
    }
    
    private String search_shipfitorder(Shipfitorder_usecases shipfitorderusecases, JSONObject json) throws ParseException, CustomException {
        IShipfitordersearch search = (IShipfitordersearch)JSONShipfitorder.toShipfitordersearch((JSONObject)json.get("search"));
        return JSONShipfitorder.toJSONArray(shipfitorderusecases.search_shipfitorder(search)).toJSONString();
    }
    
    private String search_shipfitorder_count(Shipfitorder_usecases shipfitorderusecases, JSONObject json) throws ParseException, CustomException {
        IShipfitordersearch shipfitordersearch = (IShipfitordersearch)JSONShipfitorder.toShipfitordersearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", shipfitorderusecases.search_shipfitorder_count(shipfitordersearch));
        return jsonsearchcount.toJSONString();
    }
}

