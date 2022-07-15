/*
 * WSRegion_neighbour.java
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
import eve.interfaces.searchentity.IRegion_neighboursearch;
import eve.interfaces.webservice.WSIRegion_neighbour;
import eve.logicentity.Region_neighbour;
import eve.searchentity.Region_neighboursearch;
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
@WebService(endpointInterface = "eve.interfaces.webservice.WSIRegion_neighbour")
public class WSRegion_neighbour extends RS_json_login implements WSIRegion_neighbour {

    private Security_usecases security_usecases = new Security_usecases();
    
    private JSONArray toJSONArray(ArrayList region_neighbours) {
        JSONArray jsonregion_neighbours = new JSONArray();
        Iterator region_neighboursI = region_neighbours.iterator();
        while(region_neighboursI.hasNext()) {
            jsonregion_neighbours.add(JSONRegion_neighbour.toJSON((Region_neighbour)region_neighboursI.next()));
        }
        return jsonregion_neighbours;
    }

    //@WebMethod(operationName = "getRegion_neighbours")
    @Override
    public String getRegion_neighbours() {
        try {
            Region_neighbour_usecases region_neighbourusecases = new Region_neighbour_usecases(loggedin);
            return get_all_region_neighbour(region_neighbourusecases);
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
            Region_neighbour_usecases region_neighbourusecases = new Region_neighbour_usecases(loggedin);
            return search_region_neighbour(region_neighbourusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "getRegion_neighbour")
    @Override
    public String getRegion_neighbour(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Region_neighbour_usecases region_neighbourusecases = new Region_neighbour_usecases(loggedin);
            return get_region_neighbour_with_primarykey(region_neighbourusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "insertRegion_neighbour")
    @Override
    public void insertRegion_neighbour(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Region_neighbour_usecases region_neighbourusecases = new Region_neighbour_usecases(loggedin);
            insert_region_neighbour(region_neighbourusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "updateRegion_neighbour")
    @Override
    public void updateRegion_neighbour(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Region_neighbour_usecases region_neighbourusecases = new Region_neighbour_usecases(loggedin);
            update_region_neighbour(region_neighbourusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "deleteRegion_neighbour")
    @Override
    public void deleteRegion_neighbour(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Region_neighbour_usecases region_neighbourusecases = new Region_neighbour_usecases(loggedin);
            delete_region_neighbour(region_neighbourusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getRegion_neighbours4regionRegion")
    @Override
    public String getRegion_neighbours4regionRegion(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Region_neighbour_usecases region_neighbourusecases = new Region_neighbour_usecases(loggedin);
            return get_region_neighbour_with_foreignkey_regionRegion(region_neighbourusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "delete4regionRegion")
    @Override
    public void delete4regionRegion(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Region_neighbour_usecases region_neighbourusecases = new Region_neighbour_usecases(loggedin);
            delete_region_neighbour(region_neighbourusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getRegion_neighbours4regionNeighbour")
    @Override
    public String getRegion_neighbours4regionNeighbour(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Region_neighbour_usecases region_neighbourusecases = new Region_neighbour_usecases(loggedin);
            return get_region_neighbour_with_foreignkey_regionNeighbour(region_neighbourusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "delete4regionNeighbour")
    @Override
    public void delete4regionNeighbour(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Region_neighbour_usecases region_neighbourusecases = new Region_neighbour_usecases(loggedin);
            delete_region_neighbour(region_neighbourusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }


    private String count_records(Region_neighbour_usecases region_neighbourusecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", region_neighbourusecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_region_neighbour(Region_neighbour_usecases region_neighbourusecases) throws ParseException, CustomException {
    	return JSONRegion_neighbour.toJSONArray(region_neighbourusecases.get_all()).toJSONString();
    }
    
    private String get_region_neighbour_with_primarykey(Region_neighbour_usecases region_neighbourusecases, JSONObject json) throws ParseException, CustomException {
        IRegion_neighbourPK region_neighbourPK = (IRegion_neighbourPK)JSONRegion_neighbour.toRegion_neighbourPK((JSONObject)json.get("region_neighbourpk"));
	return JSONRegion_neighbour.toJSON(region_neighbourusecases.get_region_neighbour_by_primarykey(region_neighbourPK)).toJSONString();
    }
    
    private String get_region_neighbour_with_foreignkey_regionRegion(Region_neighbour_usecases region_neighbourusecases, JSONObject json) throws ParseException, CustomException {
        IRegionPK regionRegionPK = (IRegionPK)JSONRegion.toRegionPK((JSONObject)json.get("regionpk"));
        return JSONRegion_neighbour.toJSONArray(region_neighbourusecases.get_region_neighbour_with_foreignkey_regionRegion(regionRegionPK)).toJSONString();
    }
    
    private String get_region_neighbour_with_foreignkey_regionNeighbour(Region_neighbour_usecases region_neighbourusecases, JSONObject json) throws ParseException, CustomException {
        IRegionPK regionNeighbourPK = (IRegionPK)JSONRegion.toRegionPK((JSONObject)json.get("regionpk"));
        return JSONRegion_neighbour.toJSONArray(region_neighbourusecases.get_region_neighbour_with_foreignkey_regionNeighbour(regionNeighbourPK)).toJSONString();
    }
    
    private String search_region_neighbour(Region_neighbour_usecases region_neighbourusecases, JSONObject json) throws ParseException, CustomException {
        IRegion_neighboursearch search = (IRegion_neighboursearch)JSONRegion_neighbour.toRegion_neighboursearch((JSONObject)json.get("search"));
        return JSONRegion_neighbour.toJSONArray(region_neighbourusecases.search_region_neighbour(search)).toJSONString();
    }
    
    private String search_region_neighbour_count(Region_neighbour_usecases region_neighbourusecases, JSONObject json) throws ParseException, CustomException {
        IRegion_neighboursearch region_neighboursearch = (IRegion_neighboursearch)JSONRegion_neighbour.toRegion_neighboursearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", region_neighbourusecases.search_region_neighbour_count(region_neighboursearch));
        return jsonsearchcount.toJSONString();
    }

    private void insert_region_neighbour(Region_neighbour_usecases region_neighbourusecases, JSONObject json) throws ParseException, CustomException {
        IRegion_neighbour region_neighbour = (IRegion_neighbour)JSONRegion_neighbour.toRegion_neighbour((JSONObject)json.get("region_neighbour"));
        region_neighbourusecases.insertRegion_neighbour(region_neighbour);
        setReturnstatus("OK");
    }

    private void update_region_neighbour(Region_neighbour_usecases region_neighbourusecases, JSONObject json) throws ParseException, CustomException {
        IRegion_neighbour region_neighbour = (IRegion_neighbour)JSONRegion_neighbour.toRegion_neighbour((JSONObject)json.get("region_neighbour"));
        region_neighbourusecases.updateRegion_neighbour(region_neighbour);
        setReturnstatus("OK");
    }

    private void delete_region_neighbour(Region_neighbour_usecases region_neighbourusecases, JSONObject json) throws ParseException, CustomException {
        IRegion_neighbour region_neighbour = (IRegion_neighbour)JSONRegion_neighbour.toRegion_neighbour((JSONObject)json.get("region_neighbour"));
        region_neighbourusecases.deleteRegion_neighbour(region_neighbour);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Regionregion(Region_neighbour_usecases region_neighbourusecases, JSONObject json) throws ParseException, CustomException {
        IRegionPK regionRegionPK = (IRegionPK)JSONRegion.toRegionPK((JSONObject)json.get("regionpk"));
        region_neighbourusecases.delete_all_containing_Regionregion(regionRegionPK);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Regionneighbour(Region_neighbour_usecases region_neighbourusecases, JSONObject json) throws ParseException, CustomException {
        IRegionPK regionNeighbourPK = (IRegionPK)JSONRegion.toRegionPK((JSONObject)json.get("regionpk"));
        region_neighbourusecases.delete_all_containing_Regionneighbour(regionNeighbourPK);
        setReturnstatus("OK");
    }

}

