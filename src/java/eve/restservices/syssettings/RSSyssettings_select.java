/*
 * Generated on 13.6.2022 18:20
 */

package eve.restservices.syssettings;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.usecases.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.searchentity.ISyssettingssearch;
import eve.interfaces.servlet.ISyssettingsOperation;
import eve.logicentity.Syssettings;
import eve.searchentity.Syssettingssearch;
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
@Path("rssyssettings_select")
public class RSSyssettings_select extends RS_json_login {

    private Security_usecases security_usecases = new Security_usecases();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Syssettings_usecases syssettingsusecases = new Syssettings_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case ISyssettingsOperation.SELECT_COUNT:
                    result = count_records(syssettingsusecases);
                    break;
                case ISyssettingsOperation.SELECT_ALL:
                    result = get_all_syssettings(syssettingsusecases);
                    break;
                case ISyssettingsOperation.SELECT_SYSSETTINGS:
                    result = get_syssettings_with_primarykey(syssettingsusecases, json);
                    break;
                case ISyssettingsOperation.SELECT_SEARCH:
                    result = search_syssettings(syssettingsusecases, json);
                    break;
                case ISyssettingsOperation.SELECT_SEARCHCOUNT:
                    result = search_syssettings_count(syssettingsusecases, json);
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

    private String count_records(Syssettings_usecases syssettingsusecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", syssettingsusecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_syssettings(Syssettings_usecases syssettingsusecases) throws ParseException, CustomException {
    	return JSONSyssettings.toJSONArray(syssettingsusecases.get_all()).toJSONString();
    }
    
    private String get_syssettings_with_primarykey(Syssettings_usecases syssettingsusecases, JSONObject json) throws ParseException, CustomException {
        ISyssettingsPK syssettingsPK = (ISyssettingsPK)JSONSyssettings.toSyssettingsPK((JSONObject)json.get("syssettingspk"));
	return JSONSyssettings.toJSON(syssettingsusecases.get_syssettings_by_primarykey(syssettingsPK)).toJSONString();
    }
    
    private String search_syssettings(Syssettings_usecases syssettingsusecases, JSONObject json) throws ParseException, CustomException {
        ISyssettingssearch search = (ISyssettingssearch)JSONSyssettings.toSyssettingssearch((JSONObject)json.get("search"));
        return JSONSyssettings.toJSONArray(syssettingsusecases.search_syssettings(search)).toJSONString();
    }
    
    private String search_syssettings_count(Syssettings_usecases syssettingsusecases, JSONObject json) throws ParseException, CustomException {
        ISyssettingssearch syssettingssearch = (ISyssettingssearch)JSONSyssettings.toSyssettingssearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", syssettingsusecases.search_syssettings_count(syssettingssearch));
        return jsonsearchcount.toJSONString();
    }
}

