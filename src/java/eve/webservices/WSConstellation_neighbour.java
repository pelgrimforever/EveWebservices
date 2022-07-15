/*
 * WSConstellation_neighbour.java
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
import eve.interfaces.searchentity.IConstellation_neighboursearch;
import eve.interfaces.webservice.WSIConstellation_neighbour;
import eve.logicentity.Constellation_neighbour;
import eve.searchentity.Constellation_neighboursearch;
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
@WebService(endpointInterface = "eve.interfaces.webservice.WSIConstellation_neighbour")
public class WSConstellation_neighbour extends RS_json_login implements WSIConstellation_neighbour {

    private Security_usecases security_usecases = new Security_usecases();
    
    private JSONArray toJSONArray(ArrayList constellation_neighbours) {
        JSONArray jsonconstellation_neighbours = new JSONArray();
        Iterator constellation_neighboursI = constellation_neighbours.iterator();
        while(constellation_neighboursI.hasNext()) {
            jsonconstellation_neighbours.add(JSONConstellation_neighbour.toJSON((Constellation_neighbour)constellation_neighboursI.next()));
        }
        return jsonconstellation_neighbours;
    }

    //@WebMethod(operationName = "getConstellation_neighbours")
    @Override
    public String getConstellation_neighbours() {
        try {
            Constellation_neighbour_usecases constellation_neighbourusecases = new Constellation_neighbour_usecases(loggedin);
            return get_all_constellation_neighbour(constellation_neighbourusecases);
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
            Constellation_neighbour_usecases constellation_neighbourusecases = new Constellation_neighbour_usecases(loggedin);
            return search_constellation_neighbour(constellation_neighbourusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "getConstellation_neighbour")
    @Override
    public String getConstellation_neighbour(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Constellation_neighbour_usecases constellation_neighbourusecases = new Constellation_neighbour_usecases(loggedin);
            return get_constellation_neighbour_with_primarykey(constellation_neighbourusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "insertConstellation_neighbour")
    @Override
    public void insertConstellation_neighbour(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Constellation_neighbour_usecases constellation_neighbourusecases = new Constellation_neighbour_usecases(loggedin);
            insert_constellation_neighbour(constellation_neighbourusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "updateConstellation_neighbour")
    @Override
    public void updateConstellation_neighbour(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Constellation_neighbour_usecases constellation_neighbourusecases = new Constellation_neighbour_usecases(loggedin);
            update_constellation_neighbour(constellation_neighbourusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "deleteConstellation_neighbour")
    @Override
    public void deleteConstellation_neighbour(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Constellation_neighbour_usecases constellation_neighbourusecases = new Constellation_neighbour_usecases(loggedin);
            delete_constellation_neighbour(constellation_neighbourusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getConstellation_neighbours4constellationNeighbour")
    @Override
    public String getConstellation_neighbours4constellationNeighbour(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Constellation_neighbour_usecases constellation_neighbourusecases = new Constellation_neighbour_usecases(loggedin);
            return get_constellation_neighbour_with_foreignkey_constellationNeighbour(constellation_neighbourusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "delete4constellationNeighbour")
    @Override
    public void delete4constellationNeighbour(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Constellation_neighbour_usecases constellation_neighbourusecases = new Constellation_neighbour_usecases(loggedin);
            delete_constellation_neighbour(constellation_neighbourusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getConstellation_neighbours4constellationConstellation")
    @Override
    public String getConstellation_neighbours4constellationConstellation(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Constellation_neighbour_usecases constellation_neighbourusecases = new Constellation_neighbour_usecases(loggedin);
            return get_constellation_neighbour_with_foreignkey_constellationConstellation(constellation_neighbourusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "delete4constellationConstellation")
    @Override
    public void delete4constellationConstellation(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Constellation_neighbour_usecases constellation_neighbourusecases = new Constellation_neighbour_usecases(loggedin);
            delete_constellation_neighbour(constellation_neighbourusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }


    private String count_records(Constellation_neighbour_usecases constellation_neighbourusecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", constellation_neighbourusecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_constellation_neighbour(Constellation_neighbour_usecases constellation_neighbourusecases) throws ParseException, CustomException {
    	return JSONConstellation_neighbour.toJSONArray(constellation_neighbourusecases.get_all()).toJSONString();
    }
    
    private String get_constellation_neighbour_with_primarykey(Constellation_neighbour_usecases constellation_neighbourusecases, JSONObject json) throws ParseException, CustomException {
        IConstellation_neighbourPK constellation_neighbourPK = (IConstellation_neighbourPK)JSONConstellation_neighbour.toConstellation_neighbourPK((JSONObject)json.get("constellation_neighbourpk"));
	return JSONConstellation_neighbour.toJSON(constellation_neighbourusecases.get_constellation_neighbour_by_primarykey(constellation_neighbourPK)).toJSONString();
    }
    
    private String get_constellation_neighbour_with_foreignkey_constellationNeighbour(Constellation_neighbour_usecases constellation_neighbourusecases, JSONObject json) throws ParseException, CustomException {
        IConstellationPK constellationNeighbourPK = (IConstellationPK)JSONConstellation.toConstellationPK((JSONObject)json.get("constellationpk"));
        return JSONConstellation_neighbour.toJSONArray(constellation_neighbourusecases.get_constellation_neighbour_with_foreignkey_constellationNeighbour(constellationNeighbourPK)).toJSONString();
    }
    
    private String get_constellation_neighbour_with_foreignkey_constellationConstellation(Constellation_neighbour_usecases constellation_neighbourusecases, JSONObject json) throws ParseException, CustomException {
        IConstellationPK constellationConstellationPK = (IConstellationPK)JSONConstellation.toConstellationPK((JSONObject)json.get("constellationpk"));
        return JSONConstellation_neighbour.toJSONArray(constellation_neighbourusecases.get_constellation_neighbour_with_foreignkey_constellationConstellation(constellationConstellationPK)).toJSONString();
    }
    
    private String search_constellation_neighbour(Constellation_neighbour_usecases constellation_neighbourusecases, JSONObject json) throws ParseException, CustomException {
        IConstellation_neighboursearch search = (IConstellation_neighboursearch)JSONConstellation_neighbour.toConstellation_neighboursearch((JSONObject)json.get("search"));
        return JSONConstellation_neighbour.toJSONArray(constellation_neighbourusecases.search_constellation_neighbour(search)).toJSONString();
    }
    
    private String search_constellation_neighbour_count(Constellation_neighbour_usecases constellation_neighbourusecases, JSONObject json) throws ParseException, CustomException {
        IConstellation_neighboursearch constellation_neighboursearch = (IConstellation_neighboursearch)JSONConstellation_neighbour.toConstellation_neighboursearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", constellation_neighbourusecases.search_constellation_neighbour_count(constellation_neighboursearch));
        return jsonsearchcount.toJSONString();
    }

    private void insert_constellation_neighbour(Constellation_neighbour_usecases constellation_neighbourusecases, JSONObject json) throws ParseException, CustomException {
        IConstellation_neighbour constellation_neighbour = (IConstellation_neighbour)JSONConstellation_neighbour.toConstellation_neighbour((JSONObject)json.get("constellation_neighbour"));
        constellation_neighbourusecases.insertConstellation_neighbour(constellation_neighbour);
        setReturnstatus("OK");
    }

    private void update_constellation_neighbour(Constellation_neighbour_usecases constellation_neighbourusecases, JSONObject json) throws ParseException, CustomException {
        IConstellation_neighbour constellation_neighbour = (IConstellation_neighbour)JSONConstellation_neighbour.toConstellation_neighbour((JSONObject)json.get("constellation_neighbour"));
        constellation_neighbourusecases.updateConstellation_neighbour(constellation_neighbour);
        setReturnstatus("OK");
    }

    private void delete_constellation_neighbour(Constellation_neighbour_usecases constellation_neighbourusecases, JSONObject json) throws ParseException, CustomException {
        IConstellation_neighbour constellation_neighbour = (IConstellation_neighbour)JSONConstellation_neighbour.toConstellation_neighbour((JSONObject)json.get("constellation_neighbour"));
        constellation_neighbourusecases.deleteConstellation_neighbour(constellation_neighbour);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Constellationneighbour(Constellation_neighbour_usecases constellation_neighbourusecases, JSONObject json) throws ParseException, CustomException {
        IConstellationPK constellationNeighbourPK = (IConstellationPK)JSONConstellation.toConstellationPK((JSONObject)json.get("constellationpk"));
        constellation_neighbourusecases.delete_all_containing_Constellationneighbour(constellationNeighbourPK);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Constellationconstellation(Constellation_neighbour_usecases constellation_neighbourusecases, JSONObject json) throws ParseException, CustomException {
        IConstellationPK constellationConstellationPK = (IConstellationPK)JSONConstellation.toConstellationPK((JSONObject)json.get("constellationpk"));
        constellation_neighbourusecases.delete_all_containing_Constellationconstellation(constellationConstellationPK);
        setReturnstatus("OK");
    }

}

