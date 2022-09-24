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
import eve.interfaces.searchentity.ISyssettingssearch;
import eve.interfaces.webservice.WSISyssettings;
import eve.logicentity.Syssettings;
import eve.searchentity.Syssettingssearch;
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

@WebService(endpointInterface = "eve.interfaces.webservice.WSISyssettings")
public class WSSyssettings extends RS_json_login implements WSISyssettings {

    private Security_usecases security_usecases = new Security_usecases();
    
    private JSONArray toJSONArray(ArrayList syssettingss) {
        JSONArray jsonsyssettingss = new JSONArray();
        Iterator syssettingssI = syssettingss.iterator();
        while(syssettingssI.hasNext()) {
            jsonsyssettingss.add(JSONSyssettings.toJSON((Syssettings)syssettingssI.next()));
        }
        return jsonsyssettingss;
    }

    //@WebMethod(operationName = "getSyssettingss")
    @Override
    public String getSyssettingss() {
        try {
            Syssettings_usecases syssettingsusecases = new Syssettings_usecases(loggedin);
            return get_all_syssettings(syssettingsusecases);
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
            Syssettings_usecases syssettingsusecases = new Syssettings_usecases(loggedin);
            return search_syssettings(syssettingsusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "getSyssettings")
    @Override
    public String getSyssettings(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Syssettings_usecases syssettingsusecases = new Syssettings_usecases(loggedin);
            return get_syssettings_with_primarykey(syssettingsusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "insertSyssettings")
    @Override
    public void insertSyssettings(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Syssettings_usecases syssettingsusecases = new Syssettings_usecases(loggedin);
            insert_syssettings(syssettingsusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "updateSyssettings")
    @Override
    public void updateSyssettings(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Syssettings_usecases syssettingsusecases = new Syssettings_usecases(loggedin);
            update_syssettings(syssettingsusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "deleteSyssettings")
    @Override
    public void deleteSyssettings(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Syssettings_usecases syssettingsusecases = new Syssettings_usecases(loggedin);
            delete_syssettings(syssettingsusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }


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

    private void insert_syssettings(Syssettings_usecases syssettingsusecases, JSONObject json) throws ParseException, CustomException {
        ISyssettings syssettings = (ISyssettings)JSONSyssettings.toSyssettings((JSONObject)json.get("syssettings"));
        syssettingsusecases.insertSyssettings(syssettings);
        setReturnstatus("OK");
    }

    private void update_syssettings(Syssettings_usecases syssettingsusecases, JSONObject json) throws ParseException, CustomException {
        ISyssettings syssettings = (ISyssettings)JSONSyssettings.toSyssettings((JSONObject)json.get("syssettings"));
        syssettingsusecases.updateSyssettings(syssettings);
        setReturnstatus("OK");
    }

    private void delete_syssettings(Syssettings_usecases syssettingsusecases, JSONObject json) throws ParseException, CustomException {
        ISyssettings syssettings = (ISyssettings)JSONSyssettings.toSyssettings((JSONObject)json.get("syssettings"));
        syssettingsusecases.deleteSyssettings(syssettings);
        setReturnstatus("OK");
    }

}

