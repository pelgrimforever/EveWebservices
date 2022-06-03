/*
 * Generated on 20.4.2022 10:3
 */

package eve.restservices.market_group;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.usecases.Market_group_usecases;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.searchentity.IMarket_groupsearch;
import eve.interfaces.servlet.IMarket_groupOperation;
import eve.logicentity.Market_group;
import eve.searchentity.Market_groupsearch;
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
@Path("rsmarket_group_select")
public class RSMarket_group_select extends RS_json_login {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(Security_usecases.check_authorization(authorisationstring));
            IMarket_groupPK market_groupPK;
            IMarket_group market_group;
            Market_group_usecases market_groupusecases = new Market_group_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IMarket_groupOperation.SELECT_COUNT:
                    result = count_records(market_groupusecases);
                    break;
                case IMarket_groupOperation.SELECT_ALL:
                    result = get_all_market_group(market_groupusecases);
                    break;
                case IMarket_groupOperation.SELECT_MARKET_GROUP:
                    result = get_market_group_with_primarykey(market_groupusecases, json);
                    break;
                case IMarket_groupOperation.SELECT_Market_groupparent_id:
                    result = get_market_group_with_foreignkey_market_groupParent_id(market_groupusecases, json);
                    break;
                case IMarket_groupOperation.SELECT_SEARCH:
                    result = search_market_group(market_groupusecases, json);
                    break;
                case IMarket_groupOperation.SELECT_SEARCHCOUNT:
                    result = search_market_group_count(market_groupusecases, json);
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

    private String count_records(Market_group_usecases market_groupusecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", market_groupusecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_market_group(Market_group_usecases market_groupusecases) throws ParseException, CustomException {
    	return JSONMarket_group.toJSONArray(market_groupusecases.get_all()).toJSONString();
    }
    
    private String get_market_group_with_primarykey(Market_group_usecases market_groupusecases, JSONObject json) throws ParseException, CustomException {
        IMarket_groupPK market_groupPK = (IMarket_groupPK)JSONMarket_group.toMarket_groupPK((JSONObject)json.get("market_grouppk"));
	return JSONMarket_group.toJSON(market_groupusecases.get_market_group_by_primarykey(market_groupPK)).toJSONString();
    }
    
    private String get_market_group_with_foreignkey_market_groupParent_id(Market_group_usecases market_groupusecases, JSONObject json) throws ParseException, CustomException {
        IMarket_groupPK market_groupParent_idPK = (IMarket_groupPK)JSONMarket_group.toMarket_groupPK((JSONObject)json.get("market_grouppk"));
        return JSONMarket_group.toJSONArray(market_groupusecases.get_market_group_with_foreignkey_market_groupParent_id(market_groupParent_idPK)).toJSONString();
    }
    
    private String search_market_group(Market_group_usecases market_groupusecases, JSONObject json) throws ParseException, CustomException {
        IMarket_groupsearch search = (IMarket_groupsearch)JSONMarket_group.toMarket_groupsearch((JSONObject)json.get("search"));
        return JSONMarket_group.toJSONArray(market_groupusecases.search_market_group(search)).toJSONString();
    }
    
    private String search_market_group_count(Market_group_usecases market_groupusecases, JSONObject json) throws ParseException, CustomException {
        IMarket_groupsearch market_groupsearch = (IMarket_groupsearch)JSONMarket_group.toMarket_groupsearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", market_groupusecases.search_market_group_count(market_groupsearch));
        return jsonsearchcount.toJSONString();
    }
}

