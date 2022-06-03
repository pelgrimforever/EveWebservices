/*
 * Generated on 20.4.2022 10:3
 */

package eve.restservices.alliance;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.usecases.Alliance_usecases;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.searchentity.IAlliancesearch;
import eve.interfaces.servlet.IAllianceOperation;
import eve.logicentity.Alliance;
import eve.searchentity.Alliancesearch;
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
@Path("rsalliance_select")
public class RSAlliance_select extends RS_json_login {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(Security_usecases.check_authorization(authorisationstring));
            IAlliancePK alliancePK;
            IAlliance alliance;
            Alliance_usecases allianceusecases = new Alliance_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IAllianceOperation.SELECT_COUNT:
                    result = count_records(allianceusecases);
                    break;
                case IAllianceOperation.SELECT_ALL:
                    result = get_all_alliance(allianceusecases);
                    break;
                case IAllianceOperation.SELECT_ALLIANCE:
                    result = get_alliance_with_primarykey(allianceusecases, json);
                    break;
                case IAllianceOperation.SELECT_Corporationcreator_corporation:
                    result = get_alliance_with_foreignkey_corporationCreator_corporation(allianceusecases, json);
                    break;
                case IAllianceOperation.SELECT_Corporationexecutor_corporation:
                    result = get_alliance_with_foreignkey_corporationExecutor_corporation(allianceusecases, json);
                    break;
                case IAllianceOperation.SELECT_SEARCH:
                    result = search_alliance(allianceusecases, json);
                    break;
                case IAllianceOperation.SELECT_SEARCHCOUNT:
                    result = search_alliance_count(allianceusecases, json);
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

    private String count_records(Alliance_usecases allianceusecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", allianceusecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_alliance(Alliance_usecases allianceusecases) throws ParseException, CustomException {
    	return JSONAlliance.toJSONArray(allianceusecases.get_all()).toJSONString();
    }
    
    private String get_alliance_with_primarykey(Alliance_usecases allianceusecases, JSONObject json) throws ParseException, CustomException {
        IAlliancePK alliancePK = (IAlliancePK)JSONAlliance.toAlliancePK((JSONObject)json.get("alliancepk"));
	return JSONAlliance.toJSON(allianceusecases.get_alliance_by_primarykey(alliancePK)).toJSONString();
    }
    
    private String get_alliance_with_foreignkey_corporationCreator_corporation(Alliance_usecases allianceusecases, JSONObject json) throws ParseException, CustomException {
        ICorporationPK corporationCreator_corporationPK = (ICorporationPK)JSONCorporation.toCorporationPK((JSONObject)json.get("corporationpk"));
        return JSONAlliance.toJSONArray(allianceusecases.get_alliance_with_foreignkey_corporationCreator_corporation(corporationCreator_corporationPK)).toJSONString();
    }
    
    private String get_alliance_with_foreignkey_corporationExecutor_corporation(Alliance_usecases allianceusecases, JSONObject json) throws ParseException, CustomException {
        ICorporationPK corporationExecutor_corporationPK = (ICorporationPK)JSONCorporation.toCorporationPK((JSONObject)json.get("corporationpk"));
        return JSONAlliance.toJSONArray(allianceusecases.get_alliance_with_foreignkey_corporationExecutor_corporation(corporationExecutor_corporationPK)).toJSONString();
    }
    
    private String search_alliance(Alliance_usecases allianceusecases, JSONObject json) throws ParseException, CustomException {
        IAlliancesearch search = (IAlliancesearch)JSONAlliance.toAlliancesearch((JSONObject)json.get("search"));
        return JSONAlliance.toJSONArray(allianceusecases.search_alliance(search)).toJSONString();
    }
    
    private String search_alliance_count(Alliance_usecases allianceusecases, JSONObject json) throws ParseException, CustomException {
        IAlliancesearch alliancesearch = (IAlliancesearch)JSONAlliance.toAlliancesearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", allianceusecases.search_alliance_count(alliancesearch));
        return jsonsearchcount.toJSONString();
    }
}

