/*
 * Generated on 23.8.2022 14:38
 * @author Franky Laseure
 */

package eve.restservices.shipfitmodule;

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
import eve.interfaces.searchentity.IShipfitmodulesearch;
import eve.interfaces.servlet.IShipfitmoduleOperation;
import eve.logicentity.Shipfitmodule;
import eve.searchentity.Shipfitmodulesearch;
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

@Path("rsshipfitmodule_select")
public class RSShipfitmodule_select extends RS_json_login {

    private Security_usecases security_usecases = new Security_usecases();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Shipfitmodule_usecases shipfitmoduleusecases = new Shipfitmodule_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IShipfitmoduleOperation.SELECT_COUNT:
                    result = count_records(shipfitmoduleusecases);
                    break;
                case IShipfitmoduleOperation.SELECT_ALL:
                    result = get_all_shipfitmodule(shipfitmoduleusecases);
                    break;
                case IShipfitmoduleOperation.SELECT_SHIPFITMODULE:
                    result = get_shipfitmodule_with_primarykey(shipfitmoduleusecases, json);
                    break;
                case IShipfitmoduleOperation.SELECT_Evetype:
                    result = get_shipfitmodule_with_foreignkey_evetype(shipfitmoduleusecases, json);
                    break;
                case IShipfitmoduleOperation.SELECT_Shipfit:
                    result = get_shipfitmodule_with_foreignkey_shipfit(shipfitmoduleusecases, json);
                    break;
                case IShipfitmoduleOperation.SELECT_SEARCH:
                    result = search_shipfitmodule(shipfitmoduleusecases, json);
                    break;
                case IShipfitmoduleOperation.SELECT_SEARCHCOUNT:
                    result = search_shipfitmodule_count(shipfitmoduleusecases, json);
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

    private String count_records(Shipfitmodule_usecases shipfitmoduleusecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", shipfitmoduleusecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_shipfitmodule(Shipfitmodule_usecases shipfitmoduleusecases) throws ParseException, CustomException {
    	return JSONShipfitmodule.toJSONArray(shipfitmoduleusecases.get_all()).toJSONString();
    }
    
    private String get_shipfitmodule_with_primarykey(Shipfitmodule_usecases shipfitmoduleusecases, JSONObject json) throws ParseException, CustomException {
        IShipfitmodulePK shipfitmodulePK = (IShipfitmodulePK)JSONShipfitmodule.toShipfitmodulePK((JSONObject)json.get("shipfitmodulepk"));
	return JSONShipfitmodule.toJSON(shipfitmoduleusecases.get_shipfitmodule_by_primarykey(shipfitmodulePK)).toJSONString();
    }
    
    private String get_shipfitmodule_with_foreignkey_evetype(Shipfitmodule_usecases shipfitmoduleusecases, JSONObject json) throws ParseException, CustomException {
        IEvetypePK evetypePK = (IEvetypePK)JSONEvetype.toEvetypePK((JSONObject)json.get("evetypepk"));
        return JSONShipfitmodule.toJSONArray(shipfitmoduleusecases.get_shipfitmodule_with_foreignkey_evetype(evetypePK)).toJSONString();
    }
    
    private String get_shipfitmodule_with_foreignkey_shipfit(Shipfitmodule_usecases shipfitmoduleusecases, JSONObject json) throws ParseException, CustomException {
        IShipfitPK shipfitPK = (IShipfitPK)JSONShipfit.toShipfitPK((JSONObject)json.get("shipfitpk"));
        return JSONShipfitmodule.toJSONArray(shipfitmoduleusecases.get_shipfitmodule_with_foreignkey_shipfit(shipfitPK)).toJSONString();
    }
    
    private String search_shipfitmodule(Shipfitmodule_usecases shipfitmoduleusecases, JSONObject json) throws ParseException, CustomException {
        IShipfitmodulesearch search = (IShipfitmodulesearch)JSONShipfitmodule.toShipfitmodulesearch((JSONObject)json.get("search"));
        return JSONShipfitmodule.toJSONArray(shipfitmoduleusecases.search_shipfitmodule(search)).toJSONString();
    }
    
    private String search_shipfitmodule_count(Shipfitmodule_usecases shipfitmoduleusecases, JSONObject json) throws ParseException, CustomException {
        IShipfitmodulesearch shipfitmodulesearch = (IShipfitmodulesearch)JSONShipfitmodule.toShipfitmodulesearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", shipfitmoduleusecases.search_shipfitmodule_count(shipfitmodulesearch));
        return jsonsearchcount.toJSONString();
    }
}

