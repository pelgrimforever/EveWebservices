/*
 * WSRace.java
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
import eve.interfaces.searchentity.IRacesearch;
import eve.interfaces.webservice.WSIRace;
import eve.logicentity.Race;
import eve.searchentity.Racesearch;
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
@WebService(endpointInterface = "eve.interfaces.webservice.WSIRace")
public class WSRace extends RS_json_login implements WSIRace {

    private Security_usecases security_usecases = new Security_usecases();
    
    private JSONArray toJSONArray(ArrayList races) {
        JSONArray jsonraces = new JSONArray();
        Iterator racesI = races.iterator();
        while(racesI.hasNext()) {
            jsonraces.add(JSONRace.toJSON((Race)racesI.next()));
        }
        return jsonraces;
    }

    //@WebMethod(operationName = "getRaces")
    @Override
    public String getRaces() {
        try {
            Race_usecases raceusecases = new Race_usecases(loggedin);
            return get_all_race(raceusecases);
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
            Race_usecases raceusecases = new Race_usecases(loggedin);
            return search_race(raceusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "getRace")
    @Override
    public String getRace(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Race_usecases raceusecases = new Race_usecases(loggedin);
            return get_race_with_primarykey(raceusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "insertRace")
    @Override
    public void insertRace(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Race_usecases raceusecases = new Race_usecases(loggedin);
            insert_race(raceusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "updateRace")
    @Override
    public void updateRace(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Race_usecases raceusecases = new Race_usecases(loggedin);
            update_race(raceusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "deleteRace")
    @Override
    public void deleteRace(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Race_usecases raceusecases = new Race_usecases(loggedin);
            delete_race(raceusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getRaces4faction")
    @Override
    public String getRaces4faction(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Race_usecases raceusecases = new Race_usecases(loggedin);
            return get_race_with_foreignkey_faction(raceusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "delete4faction")
    @Override
    public void delete4faction(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Race_usecases raceusecases = new Race_usecases(loggedin);
            delete_race(raceusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }


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

    private void insert_race(Race_usecases raceusecases, JSONObject json) throws ParseException, CustomException {
        IRace race = (IRace)JSONRace.toRace((JSONObject)json.get("race"));
        raceusecases.insertRace(race);
        setReturnstatus("OK");
    }

    private void update_race(Race_usecases raceusecases, JSONObject json) throws ParseException, CustomException {
        IRace race = (IRace)JSONRace.toRace((JSONObject)json.get("race"));
        raceusecases.updateRace(race);
        setReturnstatus("OK");
    }

    private void delete_race(Race_usecases raceusecases, JSONObject json) throws ParseException, CustomException {
        IRace race = (IRace)JSONRace.toRace((JSONObject)json.get("race"));
        raceusecases.deleteRace(race);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Faction(Race_usecases raceusecases, JSONObject json) throws ParseException, CustomException {
        IFactionPK factionPK = (IFactionPK)JSONFaction.toFactionPK((JSONObject)json.get("factionpk"));
        raceusecases.delete_all_containing_Faction(factionPK);
        setReturnstatus("OK");
    }

}

