/*
 * WSAlliance.java
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
import eve.interfaces.searchentity.IAlliancesearch;
import eve.interfaces.webservice.WSIAlliance;
import eve.logicentity.Alliance;
import eve.searchentity.Alliancesearch;
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
@WebService(endpointInterface = "eve.interfaces.webservice.WSIAlliance")
public class WSAlliance extends RS_json_login implements WSIAlliance {

    private Security_usecases security_usecases = new Security_usecases();
    
    private JSONArray toJSONArray(ArrayList alliances) {
        JSONArray jsonalliances = new JSONArray();
        Iterator alliancesI = alliances.iterator();
        while(alliancesI.hasNext()) {
            jsonalliances.add(JSONAlliance.toJSON((Alliance)alliancesI.next()));
        }
        return jsonalliances;
    }

    //@WebMethod(operationName = "getAlliances")
    @Override
    public String getAlliances() {
        try {
            Alliance_usecases allianceusecases = new Alliance_usecases(loggedin);
            return get_all_alliance(allianceusecases);
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
            Alliance_usecases allianceusecases = new Alliance_usecases(loggedin);
            return search_alliance(allianceusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "getAlliance")
    @Override
    public String getAlliance(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Alliance_usecases allianceusecases = new Alliance_usecases(loggedin);
            return get_alliance_with_primarykey(allianceusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "insertAlliance")
    @Override
    public void insertAlliance(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Alliance_usecases allianceusecases = new Alliance_usecases(loggedin);
            insert_alliance(allianceusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "updateAlliance")
    @Override
    public void updateAlliance(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Alliance_usecases allianceusecases = new Alliance_usecases(loggedin);
            update_alliance(allianceusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "deleteAlliance")
    @Override
    public void deleteAlliance(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Alliance_usecases allianceusecases = new Alliance_usecases(loggedin);
            delete_alliance(allianceusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getAlliances4corporationCreator_corporation")
    @Override
    public String getAlliances4corporationCreator_corporation(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Alliance_usecases allianceusecases = new Alliance_usecases(loggedin);
            return get_alliance_with_foreignkey_corporationCreator_corporation(allianceusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "delete4corporationCreator_corporation")
    @Override
    public void delete4corporationCreator_corporation(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Alliance_usecases allianceusecases = new Alliance_usecases(loggedin);
            delete_alliance(allianceusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getAlliances4corporationExecutor_corporation")
    @Override
    public String getAlliances4corporationExecutor_corporation(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Alliance_usecases allianceusecases = new Alliance_usecases(loggedin);
            return get_alliance_with_foreignkey_corporationExecutor_corporation(allianceusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "delete4corporationExecutor_corporation")
    @Override
    public void delete4corporationExecutor_corporation(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Alliance_usecases allianceusecases = new Alliance_usecases(loggedin);
            delete_alliance(allianceusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }


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

    private void insert_alliance(Alliance_usecases allianceusecases, JSONObject json) throws ParseException, CustomException {
        IAlliance alliance = (IAlliance)JSONAlliance.toAlliance((JSONObject)json.get("alliance"));
        allianceusecases.insertAlliance(alliance);
        setReturnstatus("OK");
    }

    private void update_alliance(Alliance_usecases allianceusecases, JSONObject json) throws ParseException, CustomException {
        IAlliance alliance = (IAlliance)JSONAlliance.toAlliance((JSONObject)json.get("alliance"));
        allianceusecases.updateAlliance(alliance);
        setReturnstatus("OK");
    }

    private void delete_alliance(Alliance_usecases allianceusecases, JSONObject json) throws ParseException, CustomException {
        IAlliance alliance = (IAlliance)JSONAlliance.toAlliance((JSONObject)json.get("alliance"));
        allianceusecases.deleteAlliance(alliance);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Corporationcreator_corporation(Alliance_usecases allianceusecases, JSONObject json) throws ParseException, CustomException {
        ICorporationPK corporationCreator_corporationPK = (ICorporationPK)JSONCorporation.toCorporationPK((JSONObject)json.get("corporationpk"));
        allianceusecases.delete_all_containing_Corporationcreator_corporation(corporationCreator_corporationPK);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Corporationexecutor_corporation(Alliance_usecases allianceusecases, JSONObject json) throws ParseException, CustomException {
        ICorporationPK corporationExecutor_corporationPK = (ICorporationPK)JSONCorporation.toCorporationPK((JSONObject)json.get("corporationpk"));
        allianceusecases.delete_all_containing_Corporationexecutor_corporation(corporationExecutor_corporationPK);
        setReturnstatus("OK");
    }

}

