/*
 * Generated on 20.4.2022 10:3
 */

package eve.restservices.tradecombined;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.usecases.Tradecombined_usecases;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.searchentity.ITradecombinedsearch;
import eve.interfaces.servlet.ITradecombinedOperation;
import eve.logicentity.Tradecombined;
import eve.searchentity.Tradecombinedsearch;
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
@Path("rstradecombined_select")
public class RSTradecombined_select extends RS_json_login {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(Security_usecases.check_authorization(authorisationstring));
            ITradecombinedPK tradecombinedPK;
            ITradecombined tradecombined;
            Tradecombined_usecases tradecombinedusecases = new Tradecombined_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case ITradecombinedOperation.SELECT_COUNT:
                    result = count_records(tradecombinedusecases);
                    break;
                case ITradecombinedOperation.SELECT_ALL:
                    result = get_all_tradecombined(tradecombinedusecases);
                    break;
                case ITradecombinedOperation.SELECT_TRADECOMBINED:
                    result = get_tradecombined_with_primarykey(tradecombinedusecases, json);
                    break;
                case ITradecombinedOperation.SELECT_Evetype:
                    result = get_tradecombined_with_foreignkey_evetype(tradecombinedusecases, json);
                    break;
                case ITradecombinedOperation.SELECT_Systembuy_system:
                    result = get_tradecombined_with_foreignkey_systemBuy_system(tradecombinedusecases, json);
                    break;
                case ITradecombinedOperation.SELECT_Systemsell_system:
                    result = get_tradecombined_with_foreignkey_systemSell_system(tradecombinedusecases, json);
                    break;
                case ITradecombinedOperation.SELECT_Tradecombined_sell:
                    result = get_tradecombined_with_externalforeignkey_tradecombined_sell(tradecombinedusecases, json);
                    break;
                case ITradecombinedOperation.SELECT_SEARCH:
                    result = search_tradecombined(tradecombinedusecases, json);
                    break;
                case ITradecombinedOperation.SELECT_SEARCHCOUNT:
                    result = search_tradecombined_count(tradecombinedusecases, json);
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

    private String count_records(Tradecombined_usecases tradecombinedusecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", tradecombinedusecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_tradecombined(Tradecombined_usecases tradecombinedusecases) throws ParseException, CustomException {
    	return JSONTradecombined.toJSONArray(tradecombinedusecases.get_all()).toJSONString();
    }
    
    private String get_tradecombined_with_primarykey(Tradecombined_usecases tradecombinedusecases, JSONObject json) throws ParseException, CustomException {
        ITradecombinedPK tradecombinedPK = (ITradecombinedPK)JSONTradecombined.toTradecombinedPK((JSONObject)json.get("tradecombinedpk"));
	return JSONTradecombined.toJSON(tradecombinedusecases.get_tradecombined_by_primarykey(tradecombinedPK)).toJSONString();
    }
    
    private String get_tradecombined_with_foreignkey_evetype(Tradecombined_usecases tradecombinedusecases, JSONObject json) throws ParseException, CustomException {
        IEvetypePK evetypePK = (IEvetypePK)JSONEvetype.toEvetypePK((JSONObject)json.get("evetypepk"));
        return JSONTradecombined.toJSONArray(tradecombinedusecases.get_tradecombined_with_foreignkey_evetype(evetypePK)).toJSONString();
    }
    
    private String get_tradecombined_with_foreignkey_systemBuy_system(Tradecombined_usecases tradecombinedusecases, JSONObject json) throws ParseException, CustomException {
        ISystemPK systemBuy_systemPK = (ISystemPK)JSONSystem.toSystemPK((JSONObject)json.get("systempk"));
        return JSONTradecombined.toJSONArray(tradecombinedusecases.get_tradecombined_with_foreignkey_systemBuy_system(systemBuy_systemPK)).toJSONString();
    }
    
    private String get_tradecombined_with_foreignkey_systemSell_system(Tradecombined_usecases tradecombinedusecases, JSONObject json) throws ParseException, CustomException {
        ISystemPK systemSell_systemPK = (ISystemPK)JSONSystem.toSystemPK((JSONObject)json.get("systempk"));
        return JSONTradecombined.toJSONArray(tradecombinedusecases.get_tradecombined_with_foreignkey_systemSell_system(systemSell_systemPK)).toJSONString();
    }
    
    private String get_tradecombined_with_externalforeignkey_tradecombined_sell(Tradecombined_usecases tradecombinedusecases, JSONObject json) throws ParseException, CustomException {
        ITradecombined_sellPK tradecombined_sellPK = (ITradecombined_sellPK)JSONTradecombined_sell.toTradecombined_sellPK((JSONObject)json.get("tradecombined_sellpk"));
        return JSONTradecombined.toJSON(tradecombinedusecases.get_tradecombined_with_externalforeignkey_tradecombined_sell(tradecombined_sellPK)).toJSONString();
    }
    
    private String search_tradecombined(Tradecombined_usecases tradecombinedusecases, JSONObject json) throws ParseException, CustomException {
        ITradecombinedsearch search = (ITradecombinedsearch)JSONTradecombined.toTradecombinedsearch((JSONObject)json.get("search"));
        return JSONTradecombined.toJSONArray(tradecombinedusecases.search_tradecombined(search)).toJSONString();
    }
    
    private String search_tradecombined_count(Tradecombined_usecases tradecombinedusecases, JSONObject json) throws ParseException, CustomException {
        ITradecombinedsearch tradecombinedsearch = (ITradecombinedsearch)JSONTradecombined.toTradecombinedsearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", tradecombinedusecases.search_tradecombined_count(tradecombinedsearch));
        return jsonsearchcount.toJSONString();
    }
}

