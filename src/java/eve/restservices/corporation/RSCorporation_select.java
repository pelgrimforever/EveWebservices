/*
 * Generated on 23.8.2022 14:38
 * @author Franky Laseure
 */

package eve.restservices.corporation;

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
import eve.interfaces.searchentity.ICorporationsearch;
import eve.interfaces.servlet.ICorporationOperation;
import eve.logicentity.Corporation;
import eve.searchentity.Corporationsearch;
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

@Path("rscorporation_select")
public class RSCorporation_select extends RS_json_login {

    private Security_usecases security_usecases = new Security_usecases();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Corporation_usecases corporationusecases = new Corporation_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case ICorporationOperation.SELECT_COUNT:
                    result = count_records(corporationusecases);
                    break;
                case ICorporationOperation.SELECT_ALL:
                    result = get_all_corporation(corporationusecases);
                    break;
                case ICorporationOperation.SELECT_CORPORATION:
                    result = get_corporation_with_primarykey(corporationusecases, json);
                    break;
                case ICorporationOperation.SELECT_Station:
                    result = get_corporation_with_foreignkey_station(corporationusecases, json);
                    break;
                case ICorporationOperation.SELECT_Faction:
                    result = get_corporation_with_foreignkey_faction(corporationusecases, json);
                    break;
                case ICorporationOperation.SELECT_Alliance:
                    result = get_corporation_with_foreignkey_alliance(corporationusecases, json);
                    break;
                case ICorporationOperation.SELECT_SEARCH:
                    result = search_corporation(corporationusecases, json);
                    break;
                case ICorporationOperation.SELECT_SEARCHCOUNT:
                    result = search_corporation_count(corporationusecases, json);
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

    private String count_records(Corporation_usecases corporationusecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", corporationusecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_corporation(Corporation_usecases corporationusecases) throws ParseException, CustomException {
    	return JSONCorporation.toJSONArray(corporationusecases.get_all()).toJSONString();
    }
    
    private String get_corporation_with_primarykey(Corporation_usecases corporationusecases, JSONObject json) throws ParseException, CustomException {
        ICorporationPK corporationPK = (ICorporationPK)JSONCorporation.toCorporationPK((JSONObject)json.get("corporationpk"));
	return JSONCorporation.toJSON(corporationusecases.get_corporation_by_primarykey(corporationPK)).toJSONString();
    }
    
    private String get_corporation_with_foreignkey_station(Corporation_usecases corporationusecases, JSONObject json) throws ParseException, CustomException {
        IStationPK stationPK = (IStationPK)JSONStation.toStationPK((JSONObject)json.get("stationpk"));
        return JSONCorporation.toJSONArray(corporationusecases.get_corporation_with_foreignkey_station(stationPK)).toJSONString();
    }
    
    private String get_corporation_with_foreignkey_faction(Corporation_usecases corporationusecases, JSONObject json) throws ParseException, CustomException {
        IFactionPK factionPK = (IFactionPK)JSONFaction.toFactionPK((JSONObject)json.get("factionpk"));
        return JSONCorporation.toJSONArray(corporationusecases.get_corporation_with_foreignkey_faction(factionPK)).toJSONString();
    }
    
    private String get_corporation_with_foreignkey_alliance(Corporation_usecases corporationusecases, JSONObject json) throws ParseException, CustomException {
        IAlliancePK alliancePK = (IAlliancePK)JSONAlliance.toAlliancePK((JSONObject)json.get("alliancepk"));
        return JSONCorporation.toJSONArray(corporationusecases.get_corporation_with_foreignkey_alliance(alliancePK)).toJSONString();
    }
    
    private String search_corporation(Corporation_usecases corporationusecases, JSONObject json) throws ParseException, CustomException {
        ICorporationsearch search = (ICorporationsearch)JSONCorporation.toCorporationsearch((JSONObject)json.get("search"));
        return JSONCorporation.toJSONArray(corporationusecases.search_corporation(search)).toJSONString();
    }
    
    private String search_corporation_count(Corporation_usecases corporationusecases, JSONObject json) throws ParseException, CustomException {
        ICorporationsearch corporationsearch = (ICorporationsearch)JSONCorporation.toCorporationsearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", corporationusecases.search_corporation_count(corporationsearch));
        return jsonsearchcount.toJSONString();
    }
}

