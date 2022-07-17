/*
 * Generated on 17.6.2022 13:4
 */

package eve.restservices.faction;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.usecases.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.searchentity.IFactionsearch;
import eve.interfaces.servlet.IFactionOperation;
import eve.logicentity.Faction;
import eve.searchentity.Factionsearch;
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
@Path("rsfaction_select")
public class RSFaction_select extends RS_json_login {

    private Security_usecases security_usecases = new Security_usecases();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Faction_usecases factionusecases = new Faction_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IFactionOperation.SELECT_COUNT:
                    result = count_records(factionusecases);
                    break;
                case IFactionOperation.SELECT_ALL:
                    result = get_all_faction(factionusecases);
                    break;
                case IFactionOperation.SELECT_FACTION:
                    result = get_faction_with_primarykey(factionusecases, json);
                    break;
                case IFactionOperation.SELECT_System:
                    result = get_faction_with_foreignkey_system(factionusecases, json);
                    break;
                case IFactionOperation.SELECT_SEARCH:
                    result = search_faction(factionusecases, json);
                    break;
                case IFactionOperation.SELECT_SEARCHCOUNT:
                    result = search_faction_count(factionusecases, json);
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

    private String count_records(Faction_usecases factionusecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", factionusecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_faction(Faction_usecases factionusecases) throws ParseException, CustomException {
    	return JSONFaction.toJSONArray(factionusecases.get_all()).toJSONString();
    }
    
    private String get_faction_with_primarykey(Faction_usecases factionusecases, JSONObject json) throws ParseException, CustomException {
        IFactionPK factionPK = (IFactionPK)JSONFaction.toFactionPK((JSONObject)json.get("factionpk"));
	return JSONFaction.toJSON(factionusecases.get_faction_by_primarykey(factionPK)).toJSONString();
    }
    
    private String get_faction_with_foreignkey_system(Faction_usecases factionusecases, JSONObject json) throws ParseException, CustomException {
        ISystemPK systemPK = (ISystemPK)JSONSystem.toSystemPK((JSONObject)json.get("systempk"));
        return JSONFaction.toJSONArray(factionusecases.get_faction_with_foreignkey_system(systemPK)).toJSONString();
    }
    
    private String search_faction(Faction_usecases factionusecases, JSONObject json) throws ParseException, CustomException {
        IFactionsearch search = (IFactionsearch)JSONFaction.toFactionsearch((JSONObject)json.get("search"));
        return JSONFaction.toJSONArray(factionusecases.search_faction(search)).toJSONString();
    }
    
    private String search_faction_count(Faction_usecases factionusecases, JSONObject json) throws ParseException, CustomException {
        IFactionsearch factionsearch = (IFactionsearch)JSONFaction.toFactionsearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", factionusecases.search_faction_count(factionsearch));
        return jsonsearchcount.toJSONString();
    }
}

