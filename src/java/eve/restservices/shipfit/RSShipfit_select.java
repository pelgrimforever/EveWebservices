/*
 * Generated on 17.6.2022 13:4
 */

package eve.restservices.shipfit;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.usecases.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.searchentity.IShipfitsearch;
import eve.interfaces.servlet.IShipfitOperation;
import eve.logicentity.Shipfit;
import eve.searchentity.Shipfitsearch;
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
@Path("rsshipfit_select")
public class RSShipfit_select extends RS_json_login {

    private Security_usecases security_usecases = new Security_usecases();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Shipfit_usecases shipfitusecases = new Shipfit_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IShipfitOperation.SELECT_COUNT:
                    result = count_records(shipfitusecases);
                    break;
                case IShipfitOperation.SELECT_ALL:
                    result = get_all_shipfit(shipfitusecases);
                    break;
                case IShipfitOperation.SELECT_SHIPFIT:
                    result = get_shipfit_with_primarykey(shipfitusecases, json);
                    break;
                case IShipfitOperation.SELECT_Evetype:
                    result = get_shipfit_with_foreignkey_evetype(shipfitusecases, json);
                    break;
                case IShipfitOperation.SELECT_Shipfitmodule:
                    result = get_shipfit_with_externalforeignkey_shipfitmodule(shipfitusecases, json);
                    break;
                case IShipfitOperation.SELECT_Shipfitorder:
                    result = get_shipfit_with_externalforeignkey_shipfitorder(shipfitusecases, json);
                    break;
                case IShipfitOperation.SELECT_SEARCH:
                    result = search_shipfit(shipfitusecases, json);
                    break;
                case IShipfitOperation.SELECT_SEARCHCOUNT:
                    result = search_shipfit_count(shipfitusecases, json);
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

    private String count_records(Shipfit_usecases shipfitusecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", shipfitusecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_shipfit(Shipfit_usecases shipfitusecases) throws ParseException, CustomException {
    	return JSONShipfit.toJSONArray(shipfitusecases.get_all()).toJSONString();
    }
    
    private String get_shipfit_with_primarykey(Shipfit_usecases shipfitusecases, JSONObject json) throws ParseException, CustomException {
        IShipfitPK shipfitPK = (IShipfitPK)JSONShipfit.toShipfitPK((JSONObject)json.get("shipfitpk"));
	return JSONShipfit.toJSON(shipfitusecases.get_shipfit_by_primarykey(shipfitPK)).toJSONString();
    }
    
    private String get_shipfit_with_foreignkey_evetype(Shipfit_usecases shipfitusecases, JSONObject json) throws ParseException, CustomException {
        IEvetypePK evetypePK = (IEvetypePK)JSONEvetype.toEvetypePK((JSONObject)json.get("evetypepk"));
        return JSONShipfit.toJSONArray(shipfitusecases.get_shipfit_with_foreignkey_evetype(evetypePK)).toJSONString();
    }
    
    private String get_shipfit_with_externalforeignkey_shipfitmodule(Shipfit_usecases shipfitusecases, JSONObject json) throws ParseException, CustomException {
        IShipfitmodulePK shipfitmodulePK = (IShipfitmodulePK)JSONShipfitmodule.toShipfitmodulePK((JSONObject)json.get("shipfitmodulepk"));
        return JSONShipfit.toJSON(shipfitusecases.get_shipfit_with_externalforeignkey_shipfitmodule(shipfitmodulePK)).toJSONString();
    }
    
    private String get_shipfit_with_externalforeignkey_shipfitorder(Shipfit_usecases shipfitusecases, JSONObject json) throws ParseException, CustomException {
        IShipfitorderPK shipfitorderPK = (IShipfitorderPK)JSONShipfitorder.toShipfitorderPK((JSONObject)json.get("shipfitorderpk"));
        return JSONShipfit.toJSON(shipfitusecases.get_shipfit_with_externalforeignkey_shipfitorder(shipfitorderPK)).toJSONString();
    }
    
    private String search_shipfit(Shipfit_usecases shipfitusecases, JSONObject json) throws ParseException, CustomException {
        IShipfitsearch search = (IShipfitsearch)JSONShipfit.toShipfitsearch((JSONObject)json.get("search"));
        return JSONShipfit.toJSONArray(shipfitusecases.search_shipfit(search)).toJSONString();
    }
    
    private String search_shipfit_count(Shipfit_usecases shipfitusecases, JSONObject json) throws ParseException, CustomException {
        IShipfitsearch shipfitsearch = (IShipfitsearch)JSONShipfit.toShipfitsearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", shipfitusecases.search_shipfit_count(shipfitsearch));
        return jsonsearchcount.toJSONString();
    }
}

