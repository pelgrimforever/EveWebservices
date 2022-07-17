/*
 * Generated on 17.6.2022 13:4
 */

package eve.restservices.race;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.usecases.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.searchentity.IRacesearch;
import eve.interfaces.servlet.IRaceOperation;
import eve.logicentity.Race;
import eve.searchentity.Racesearch;
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
@Path("rsrace_select")
public class RSRace_select extends RS_json_login {

    private Security_usecases security_usecases = new Security_usecases();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Race_usecases raceusecases = new Race_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IRaceOperation.SELECT_COUNT:
                    result = count_records(raceusecases);
                    break;
                case IRaceOperation.SELECT_ALL:
                    result = get_all_race(raceusecases);
                    break;
                case IRaceOperation.SELECT_RACE:
                    result = get_race_with_primarykey(raceusecases, json);
                    break;
                case IRaceOperation.SELECT_Faction:
                    result = get_race_with_foreignkey_faction(raceusecases, json);
                    break;
                case IRaceOperation.SELECT_SEARCH:
                    result = search_race(raceusecases, json);
                    break;
                case IRaceOperation.SELECT_SEARCHCOUNT:
                    result = search_race_count(raceusecases, json);
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

    private String count_records(Race_usecases raceusecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", raceusecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_race(Race_usecases raceusecases) throws ParseException, CustomException {
    	return JSONRace.toJSONArray(raceusecases.get_all()).toJSONString();
    }
    
    private String get_race_with_primarykey(Race_usecases raceusecases, JSONObject json) throws ParseException, CustomException {
        IRacePK racePK = (IRacePK)JSONRace.toRacePK((JSONObject)json.get("racepk"));
	return JSONRace.toJSON(raceusecases.get_race_by_primarykey(racePK)).toJSONString();
    }
    
    private String get_race_with_foreignkey_faction(Race_usecases raceusecases, JSONObject json) throws ParseException, CustomException {
        IFactionPK factionPK = (IFactionPK)JSONFaction.toFactionPK((JSONObject)json.get("factionpk"));
        return JSONRace.toJSONArray(raceusecases.get_race_with_foreignkey_faction(factionPK)).toJSONString();
    }
    
    private String search_race(Race_usecases raceusecases, JSONObject json) throws ParseException, CustomException {
        IRacesearch search = (IRacesearch)JSONRace.toRacesearch((JSONObject)json.get("search"));
        return JSONRace.toJSONArray(raceusecases.search_race(search)).toJSONString();
    }
    
    private String search_race_count(Race_usecases raceusecases, JSONObject json) throws ParseException, CustomException {
        IRacesearch racesearch = (IRacesearch)JSONRace.toRacesearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", raceusecases.search_race_count(racesearch));
        return jsonsearchcount.toJSONString();
    }
}

