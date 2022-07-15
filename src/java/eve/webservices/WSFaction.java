/*
 * WSFaction.java
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
import eve.interfaces.searchentity.IFactionsearch;
import eve.interfaces.webservice.WSIFaction;
import eve.logicentity.Faction;
import eve.searchentity.Factionsearch;
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
@WebService(endpointInterface = "eve.interfaces.webservice.WSIFaction")
public class WSFaction extends RS_json_login implements WSIFaction {

    private Security_usecases security_usecases = new Security_usecases();
    
    private JSONArray toJSONArray(ArrayList factions) {
        JSONArray jsonfactions = new JSONArray();
        Iterator factionsI = factions.iterator();
        while(factionsI.hasNext()) {
            jsonfactions.add(JSONFaction.toJSON((Faction)factionsI.next()));
        }
        return jsonfactions;
    }

    //@WebMethod(operationName = "getFactions")
    @Override
    public String getFactions() {
        try {
            Faction_usecases factionusecases = new Faction_usecases(loggedin);
            return get_all_faction(factionusecases);
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
            Faction_usecases factionusecases = new Faction_usecases(loggedin);
            return search_faction(factionusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "getFaction")
    @Override
    public String getFaction(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Faction_usecases factionusecases = new Faction_usecases(loggedin);
            return get_faction_with_primarykey(factionusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "insertFaction")
    @Override
    public void insertFaction(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Faction_usecases factionusecases = new Faction_usecases(loggedin);
            insert_faction(factionusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "updateFaction")
    @Override
    public void updateFaction(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Faction_usecases factionusecases = new Faction_usecases(loggedin);
            update_faction(factionusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "deleteFaction")
    @Override
    public void deleteFaction(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Faction_usecases factionusecases = new Faction_usecases(loggedin);
            delete_faction(factionusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getFactions4system")
    @Override
    public String getFactions4system(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Faction_usecases factionusecases = new Faction_usecases(loggedin);
            return get_faction_with_foreignkey_system(factionusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "delete4system")
    @Override
    public void delete4system(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Faction_usecases factionusecases = new Faction_usecases(loggedin);
            delete_faction(factionusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }


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

    private void insert_faction(Faction_usecases factionusecases, JSONObject json) throws ParseException, CustomException {
        IFaction faction = (IFaction)JSONFaction.toFaction((JSONObject)json.get("faction"));
        factionusecases.insertFaction(faction);
        setReturnstatus("OK");
    }

    private void update_faction(Faction_usecases factionusecases, JSONObject json) throws ParseException, CustomException {
        IFaction faction = (IFaction)JSONFaction.toFaction((JSONObject)json.get("faction"));
        factionusecases.updateFaction(faction);
        setReturnstatus("OK");
    }

    private void delete_faction(Faction_usecases factionusecases, JSONObject json) throws ParseException, CustomException {
        IFaction faction = (IFaction)JSONFaction.toFaction((JSONObject)json.get("faction"));
        factionusecases.deleteFaction(faction);
        setReturnstatus("OK");
    }

    private void delete_all_containing_System(Faction_usecases factionusecases, JSONObject json) throws ParseException, CustomException {
        ISystemPK systemPK = (ISystemPK)JSONSystem.toSystemPK((JSONObject)json.get("systempk"));
        factionusecases.delete_all_containing_System(systemPK);
        setReturnstatus("OK");
    }

}

