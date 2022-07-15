/*
 * WSRegion.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 13.6.2022 18:20
 *
 */

package eve.webservices;

import base.restservices.RS_json_login;
import eve.BusinessObject.Logic.*;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.searchentity.IRegionsearch;
import eve.interfaces.webservice.WSIRegion;
import eve.logicentity.Region;
import eve.searchentity.Regionsearch;
import eve.usecases.*;
import general.exception.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.jws.WebMethod;
import javax.jws.WebService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import eve.usecases.custom.Security_usecases;

/**
 *
 * @author Franky Laseure
 */
@WebService(endpointInterface = "eve.interfaces.webservice.WSIRegion")
public class WSRegion extends RS_json_login implements WSIRegion {

    private Security_usecases security_usecases = new Security_usecases();
    
    private JSONArray toJSONArray(ArrayList regions) {
        JSONArray jsonregions = new JSONArray();
        Iterator regionsI = regions.iterator();
        while(regionsI.hasNext()) {
            jsonregions.add(JSONRegion.toJSON((Region)regionsI.next()));
        }
        return jsonregions;
    }

    //@WebMethod(operationName = "getRegions")
    @Override
    public String getRegions() {
        try {
            Region_usecases regionusecases = new Region_usecases(loggedin);
            return get_all_region(regionusecases);
        }
        catch(CustomException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "search")
    @Override
    public String search(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Region_usecases regionusecases = new Region_usecases(loggedin);
            return search_region(regionusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "getRegion")
    @Override
    public String getRegion(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Region_usecases regionusecases = new Region_usecases(loggedin);
            return get_region_with_primarykey(regionusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "insertRegion")
    @Override
    public void insertRegion(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Region_usecases regionusecases = new Region_usecases(loggedin);
            insert_region(regionusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "updateRegion")
    @Override
    public void updateRegion(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Region_usecases regionusecases = new Region_usecases(loggedin);
            update_region(regionusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "deleteRegion")
    @Override
    public void deleteRegion(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Region_usecases regionusecases = new Region_usecases(loggedin);
            delete_region(regionusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getRegions4order_history_month")
    @Override
    public String getRegions4order_history_month(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Region_usecases regionusecases = new Region_usecases(loggedin);
            return get_region_with_externalforeignkey_order_history_month(regionusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "getRegions4order_history")
    @Override
    public String getRegions4order_history(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Region_usecases regionusecases = new Region_usecases(loggedin);
            return get_region_with_externalforeignkey_order_history(regionusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "getRegions4region_neighbourRegion")
    @Override
    public String getRegions4region_neighbourRegion(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Region_usecases regionusecases = new Region_usecases(loggedin);
            return get_region_with_externalforeignkey_region_neighbourRegion(regionusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "getRegions4region_neighbourNeighbour")
    @Override
    public String getRegions4region_neighbourNeighbour(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Region_usecases regionusecases = new Region_usecases(loggedin);
            return get_region_with_externalforeignkey_region_neighbourNeighbour(regionusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }


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

    private void insert_region(Region_usecases regionusecases, JSONObject json) throws ParseException, CustomException {
        IRegion region = (IRegion)JSONRegion.toRegion((JSONObject)json.get("region"));
        regionusecases.insertRegion(region);
        setReturnstatus("OK");
    }

    private void update_region(Region_usecases regionusecases, JSONObject json) throws ParseException, CustomException {
        IRegion region = (IRegion)JSONRegion.toRegion((JSONObject)json.get("region"));
        regionusecases.updateRegion(region);
        setReturnstatus("OK");
    }

    private void delete_region(Region_usecases regionusecases, JSONObject json) throws ParseException, CustomException {
        IRegion region = (IRegion)JSONRegion.toRegion((JSONObject)json.get("region"));
        regionusecases.deleteRegion(region);
        setReturnstatus("OK");
    }

}

