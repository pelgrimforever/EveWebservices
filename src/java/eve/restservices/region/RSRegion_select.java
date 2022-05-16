/*
 * Generated on 13.4.2022 19:13
 */

package eve.restservices.region;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.usecases.Region_usecases;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.searchentity.IRegionsearch;
import eve.interfaces.servlet.IRegionOperation;
import eve.logicentity.Region;
import eve.searchentity.Regionsearch;
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
@Path("rsregion_select")
public class RSRegion_select extends RS_json_login {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(Security_usecases.check_authorization(authorisationstring));
            IRegionPK regionPK;
            IRegion region;
            Region_usecases regionusecases = new Region_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IRegionOperation.SELECT_COUNT:
                    result = count_records(regionusecases);
                    break;
                case IRegionOperation.SELECT_ALL:
                    result = get_all_region(regionusecases);
                    break;
                case IRegionOperation.SELECT_REGION:
                    result = get_region_with_primarykey(regionusecases, json);
                    break;
                case IRegionOperation.SELECT_Order_history_month:
                    result = get_region_with_externalforeignkey_order_history_month(regionusecases, json);
                    break;
                case IRegionOperation.SELECT_Order_history:
                    result = get_region_with_externalforeignkey_order_history(regionusecases, json);
                    break;
                case IRegionOperation.SELECT_Region_neighbourregion:
                    result = get_region_with_externalforeignkey_region_neighbourRegion(regionusecases, json);
                    break;
                case IRegionOperation.SELECT_Region_neighbourneighbour:
                    result = get_region_with_externalforeignkey_region_neighbourNeighbour(regionusecases, json);
                    break;
                case IRegionOperation.SELECT_SEARCH:
                    result = search_region(regionusecases, json);
                    break;
                case IRegionOperation.SELECT_SEARCHCOUNT:
                    result = search_region_count(regionusecases, json);
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

    private String count_records(Region_usecases regionusecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", regionusecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_region(Region_usecases regionusecases) throws ParseException, CustomException {
    	return JSONRegion.toJSONArray(regionusecases.get_all()).toJSONString();
    }
    
    private String get_region_with_primarykey(Region_usecases regionusecases, JSONObject json) throws ParseException, CustomException {
        IRegionPK regionPK = (IRegionPK)JSONRegion.toRegionPK((JSONObject)json.get("regionpk"));
	return JSONRegion.toJSON(regionusecases.get_region_by_primarykey(regionPK)).toJSONString();
    }
    
    private String get_region_with_externalforeignkey_order_history_month(Region_usecases regionusecases, JSONObject json) throws ParseException, CustomException {
        IOrder_history_monthPK order_history_monthPK = (IOrder_history_monthPK)JSONOrder_history_month.toOrder_history_monthPK((JSONObject)json.get("order_history_monthpk"));
        return JSONRegion.toJSON(regionusecases.get_region_with_externalforeignkey_order_history_month(order_history_monthPK)).toJSONString();
    }
    
    private String get_region_with_externalforeignkey_order_history(Region_usecases regionusecases, JSONObject json) throws ParseException, CustomException {
        IOrder_historyPK order_historyPK = (IOrder_historyPK)JSONOrder_history.toOrder_historyPK((JSONObject)json.get("order_historypk"));
        return JSONRegion.toJSON(regionusecases.get_region_with_externalforeignkey_order_history(order_historyPK)).toJSONString();
    }
    
    private String get_region_with_externalforeignkey_region_neighbourRegion(Region_usecases regionusecases, JSONObject json) throws ParseException, CustomException {
        IRegion_neighbourPK region_neighbourRegionPK = (IRegion_neighbourPK)JSONRegion_neighbour.toRegion_neighbourPK((JSONObject)json.get("region_neighbourpk"));
        return JSONRegion.toJSON(regionusecases.get_region_with_externalforeignkey_region_neighbourRegion(region_neighbourRegionPK)).toJSONString();
    }
    
    private String get_region_with_externalforeignkey_region_neighbourNeighbour(Region_usecases regionusecases, JSONObject json) throws ParseException, CustomException {
        IRegion_neighbourPK region_neighbourNeighbourPK = (IRegion_neighbourPK)JSONRegion_neighbour.toRegion_neighbourPK((JSONObject)json.get("region_neighbourpk"));
        return JSONRegion.toJSON(regionusecases.get_region_with_externalforeignkey_region_neighbourNeighbour(region_neighbourNeighbourPK)).toJSONString();
    }
    
    private String search_region(Region_usecases regionusecases, JSONObject json) throws ParseException, CustomException {
        IRegionsearch search = (IRegionsearch)JSONRegion.toRegionsearch((JSONObject)json.get("search"));
        return JSONRegion.toJSONArray(regionusecases.search_region(search)).toJSONString();
    }
    
    private String search_region_count(Region_usecases regionusecases, JSONObject json) throws ParseException, CustomException {
        IRegionsearch regionsearch = (IRegionsearch)JSONRegion.toRegionsearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", regionusecases.search_region_count(regionsearch));
        return jsonsearchcount.toJSONString();
    }
}

