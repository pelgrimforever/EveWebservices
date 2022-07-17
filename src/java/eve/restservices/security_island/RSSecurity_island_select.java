/*
 * Generated on 17.6.2022 13:4
 */

package eve.restservices.security_island;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.usecases.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.searchentity.ISecurity_islandsearch;
import eve.interfaces.servlet.ISecurity_islandOperation;
import eve.logicentity.Security_island;
import eve.searchentity.Security_islandsearch;
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
@Path("rssecurity_island_select")
public class RSSecurity_island_select extends RS_json_login {

    private Security_usecases security_usecases = new Security_usecases();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Security_island_usecases security_islandusecases = new Security_island_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case ISecurity_islandOperation.SELECT_COUNT:
                    result = count_records(security_islandusecases);
                    break;
                case ISecurity_islandOperation.SELECT_ALL:
                    result = get_all_security_island(security_islandusecases);
                    break;
                case ISecurity_islandOperation.SELECT_SECURITY_ISLAND:
                    result = get_security_island_with_primarykey(security_islandusecases, json);
                    break;
                case ISecurity_islandOperation.SELECT_SEARCH:
                    result = search_security_island(security_islandusecases, json);
                    break;
                case ISecurity_islandOperation.SELECT_SEARCHCOUNT:
                    result = search_security_island_count(security_islandusecases, json);
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

    private String count_records(Security_island_usecases security_islandusecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", security_islandusecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_security_island(Security_island_usecases security_islandusecases) throws ParseException, CustomException {
    	return JSONSecurity_island.toJSONArray(security_islandusecases.get_all()).toJSONString();
    }
    
    private String get_security_island_with_primarykey(Security_island_usecases security_islandusecases, JSONObject json) throws ParseException, CustomException {
        ISecurity_islandPK security_islandPK = (ISecurity_islandPK)JSONSecurity_island.toSecurity_islandPK((JSONObject)json.get("security_islandpk"));
	return JSONSecurity_island.toJSON(security_islandusecases.get_security_island_by_primarykey(security_islandPK)).toJSONString();
    }
    
    private String search_security_island(Security_island_usecases security_islandusecases, JSONObject json) throws ParseException, CustomException {
        ISecurity_islandsearch search = (ISecurity_islandsearch)JSONSecurity_island.toSecurity_islandsearch((JSONObject)json.get("search"));
        return JSONSecurity_island.toJSONArray(security_islandusecases.search_security_island(search)).toJSONString();
    }
    
    private String search_security_island_count(Security_island_usecases security_islandusecases, JSONObject json) throws ParseException, CustomException {
        ISecurity_islandsearch security_islandsearch = (ISecurity_islandsearch)JSONSecurity_island.toSecurity_islandsearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", security_islandusecases.search_security_island_count(security_islandsearch));
        return jsonsearchcount.toJSONString();
    }
}

