/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 23.8.2022 14:38
 * @author Franky Laseure
 */

package eve.webservices;

import base.restservices.RS_json_login;
import eve.BusinessObject.Logic.*;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.searchentity.ICorporationsearch;
import eve.interfaces.webservice.WSICorporation;
import eve.logicentity.Corporation;
import eve.searchentity.Corporationsearch;
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

@WebService(endpointInterface = "eve.interfaces.webservice.WSICorporation")
public class WSCorporation extends RS_json_login implements WSICorporation {

    private Security_usecases security_usecases = new Security_usecases();
    
    private JSONArray toJSONArray(ArrayList corporations) {
        JSONArray jsoncorporations = new JSONArray();
        Iterator corporationsI = corporations.iterator();
        while(corporationsI.hasNext()) {
            jsoncorporations.add(JSONCorporation.toJSON((Corporation)corporationsI.next()));
        }
        return jsoncorporations;
    }

    //@WebMethod(operationName = "getCorporations")
    @Override
    public String getCorporations() {
        try {
            Corporation_usecases corporationusecases = new Corporation_usecases(loggedin);
            return get_all_corporation(corporationusecases);
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
            Corporation_usecases corporationusecases = new Corporation_usecases(loggedin);
            return search_corporation(corporationusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "getCorporation")
    @Override
    public String getCorporation(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Corporation_usecases corporationusecases = new Corporation_usecases(loggedin);
            return get_corporation_with_primarykey(corporationusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "insertCorporation")
    @Override
    public void insertCorporation(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Corporation_usecases corporationusecases = new Corporation_usecases(loggedin);
            insert_corporation(corporationusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "updateCorporation")
    @Override
    public void updateCorporation(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Corporation_usecases corporationusecases = new Corporation_usecases(loggedin);
            update_corporation(corporationusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "deleteCorporation")
    @Override
    public void deleteCorporation(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Corporation_usecases corporationusecases = new Corporation_usecases(loggedin);
            delete_corporation(corporationusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getCorporations4station")
    @Override
    public String getCorporations4station(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Corporation_usecases corporationusecases = new Corporation_usecases(loggedin);
            return get_corporation_with_foreignkey_station(corporationusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "delete4station")
    @Override
    public void delete4station(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Corporation_usecases corporationusecases = new Corporation_usecases(loggedin);
            delete_corporation(corporationusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getCorporations4faction")
    @Override
    public String getCorporations4faction(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Corporation_usecases corporationusecases = new Corporation_usecases(loggedin);
            return get_corporation_with_foreignkey_faction(corporationusecases, json);
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
            Corporation_usecases corporationusecases = new Corporation_usecases(loggedin);
            delete_corporation(corporationusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getCorporations4alliance")
    @Override
    public String getCorporations4alliance(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Corporation_usecases corporationusecases = new Corporation_usecases(loggedin);
            return get_corporation_with_foreignkey_alliance(corporationusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "delete4alliance")
    @Override
    public void delete4alliance(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Corporation_usecases corporationusecases = new Corporation_usecases(loggedin);
            delete_corporation(corporationusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }


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

    private void insert_corporation(Corporation_usecases corporationusecases, JSONObject json) throws ParseException, CustomException {
        ICorporation corporation = (ICorporation)JSONCorporation.toCorporation((JSONObject)json.get("corporation"));
        corporationusecases.insertCorporation(corporation);
        setReturnstatus("OK");
    }

    private void update_corporation(Corporation_usecases corporationusecases, JSONObject json) throws ParseException, CustomException {
        ICorporation corporation = (ICorporation)JSONCorporation.toCorporation((JSONObject)json.get("corporation"));
        corporationusecases.updateCorporation(corporation);
        setReturnstatus("OK");
    }

    private void delete_corporation(Corporation_usecases corporationusecases, JSONObject json) throws ParseException, CustomException {
        ICorporation corporation = (ICorporation)JSONCorporation.toCorporation((JSONObject)json.get("corporation"));
        corporationusecases.deleteCorporation(corporation);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Station(Corporation_usecases corporationusecases, JSONObject json) throws ParseException, CustomException {
        IStationPK stationPK = (IStationPK)JSONStation.toStationPK((JSONObject)json.get("stationpk"));
        corporationusecases.delete_all_containing_Station(stationPK);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Faction(Corporation_usecases corporationusecases, JSONObject json) throws ParseException, CustomException {
        IFactionPK factionPK = (IFactionPK)JSONFaction.toFactionPK((JSONObject)json.get("factionpk"));
        corporationusecases.delete_all_containing_Faction(factionPK);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Alliance(Corporation_usecases corporationusecases, JSONObject json) throws ParseException, CustomException {
        IAlliancePK alliancePK = (IAlliancePK)JSONAlliance.toAlliancePK((JSONObject)json.get("alliancepk"));
        corporationusecases.delete_all_containing_Alliance(alliancePK);
        setReturnstatus("OK");
    }

}

