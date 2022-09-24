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
import eve.interfaces.searchentity.IConstellationsearch;
import eve.interfaces.webservice.WSIConstellation;
import eve.logicentity.Constellation;
import eve.searchentity.Constellationsearch;
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

@WebService(endpointInterface = "eve.interfaces.webservice.WSIConstellation")
public class WSConstellation extends RS_json_login implements WSIConstellation {

    private Security_usecases security_usecases = new Security_usecases();
    
    private JSONArray toJSONArray(ArrayList constellations) {
        JSONArray jsonconstellations = new JSONArray();
        Iterator constellationsI = constellations.iterator();
        while(constellationsI.hasNext()) {
            jsonconstellations.add(JSONConstellation.toJSON((Constellation)constellationsI.next()));
        }
        return jsonconstellations;
    }

    //@WebMethod(operationName = "getConstellations")
    @Override
    public String getConstellations() {
        try {
            Constellation_usecases constellationusecases = new Constellation_usecases(loggedin);
            return get_all_constellation(constellationusecases);
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
            Constellation_usecases constellationusecases = new Constellation_usecases(loggedin);
            return search_constellation(constellationusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "getConstellation")
    @Override
    public String getConstellation(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Constellation_usecases constellationusecases = new Constellation_usecases(loggedin);
            return get_constellation_with_primarykey(constellationusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "insertConstellation")
    @Override
    public void insertConstellation(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Constellation_usecases constellationusecases = new Constellation_usecases(loggedin);
            insert_constellation(constellationusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "updateConstellation")
    @Override
    public void updateConstellation(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Constellation_usecases constellationusecases = new Constellation_usecases(loggedin);
            update_constellation(constellationusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "deleteConstellation")
    @Override
    public void deleteConstellation(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Constellation_usecases constellationusecases = new Constellation_usecases(loggedin);
            delete_constellation(constellationusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getConstellations4region")
    @Override
    public String getConstellations4region(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Constellation_usecases constellationusecases = new Constellation_usecases(loggedin);
            return get_constellation_with_foreignkey_region(constellationusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "delete4region")
    @Override
    public void delete4region(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Constellation_usecases constellationusecases = new Constellation_usecases(loggedin);
            delete_constellation(constellationusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getConstellations4constellation_neighbourNeighbour")
    @Override
    public String getConstellations4constellation_neighbourNeighbour(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Constellation_usecases constellationusecases = new Constellation_usecases(loggedin);
            return get_constellation_with_externalforeignkey_constellation_neighbourNeighbour(constellationusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "getConstellations4constellation_neighbourConstellation")
    @Override
    public String getConstellations4constellation_neighbourConstellation(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Constellation_usecases constellationusecases = new Constellation_usecases(loggedin);
            return get_constellation_with_externalforeignkey_constellation_neighbourConstellation(constellationusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }


    private String count_records(Constellation_usecases constellationusecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", constellationusecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_constellation(Constellation_usecases constellationusecases) throws ParseException, CustomException {
    	return JSONConstellation.toJSONArray(constellationusecases.get_all()).toJSONString();
    }
    
    private String get_constellation_with_primarykey(Constellation_usecases constellationusecases, JSONObject json) throws ParseException, CustomException {
        IConstellationPK constellationPK = (IConstellationPK)JSONConstellation.toConstellationPK((JSONObject)json.get("constellationpk"));
	return JSONConstellation.toJSON(constellationusecases.get_constellation_by_primarykey(constellationPK)).toJSONString();
    }
    
    private String get_constellation_with_foreignkey_region(Constellation_usecases constellationusecases, JSONObject json) throws ParseException, CustomException {
        IRegionPK regionPK = (IRegionPK)JSONRegion.toRegionPK((JSONObject)json.get("regionpk"));
        return JSONConstellation.toJSONArray(constellationusecases.get_constellation_with_foreignkey_region(regionPK)).toJSONString();
    }
    
    private String get_constellation_with_externalforeignkey_constellation_neighbourNeighbour(Constellation_usecases constellationusecases, JSONObject json) throws ParseException, CustomException {
        IConstellation_neighbourPK constellation_neighbourNeighbourPK = (IConstellation_neighbourPK)JSONConstellation_neighbour.toConstellation_neighbourPK((JSONObject)json.get("constellation_neighbourpk"));
        return JSONConstellation.toJSON(constellationusecases.get_constellation_with_externalforeignkey_constellation_neighbourNeighbour(constellation_neighbourNeighbourPK)).toJSONString();
    }
    
    private String get_constellation_with_externalforeignkey_constellation_neighbourConstellation(Constellation_usecases constellationusecases, JSONObject json) throws ParseException, CustomException {
        IConstellation_neighbourPK constellation_neighbourConstellationPK = (IConstellation_neighbourPK)JSONConstellation_neighbour.toConstellation_neighbourPK((JSONObject)json.get("constellation_neighbourpk"));
        return JSONConstellation.toJSON(constellationusecases.get_constellation_with_externalforeignkey_constellation_neighbourConstellation(constellation_neighbourConstellationPK)).toJSONString();
    }
    
    private String search_constellation(Constellation_usecases constellationusecases, JSONObject json) throws ParseException, CustomException {
        IConstellationsearch search = (IConstellationsearch)JSONConstellation.toConstellationsearch((JSONObject)json.get("search"));
        return JSONConstellation.toJSONArray(constellationusecases.search_constellation(search)).toJSONString();
    }
    
    private String search_constellation_count(Constellation_usecases constellationusecases, JSONObject json) throws ParseException, CustomException {
        IConstellationsearch constellationsearch = (IConstellationsearch)JSONConstellation.toConstellationsearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", constellationusecases.search_constellation_count(constellationsearch));
        return jsonsearchcount.toJSONString();
    }

    private void insert_constellation(Constellation_usecases constellationusecases, JSONObject json) throws ParseException, CustomException {
        IConstellation constellation = (IConstellation)JSONConstellation.toConstellation((JSONObject)json.get("constellation"));
        constellationusecases.insertConstellation(constellation);
        setReturnstatus("OK");
    }

    private void update_constellation(Constellation_usecases constellationusecases, JSONObject json) throws ParseException, CustomException {
        IConstellation constellation = (IConstellation)JSONConstellation.toConstellation((JSONObject)json.get("constellation"));
        constellationusecases.updateConstellation(constellation);
        setReturnstatus("OK");
    }

    private void delete_constellation(Constellation_usecases constellationusecases, JSONObject json) throws ParseException, CustomException {
        IConstellation constellation = (IConstellation)JSONConstellation.toConstellation((JSONObject)json.get("constellation"));
        constellationusecases.deleteConstellation(constellation);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Region(Constellation_usecases constellationusecases, JSONObject json) throws ParseException, CustomException {
        IRegionPK regionPK = (IRegionPK)JSONRegion.toRegionPK((JSONObject)json.get("regionpk"));
        constellationusecases.delete_all_containing_Region(regionPK);
        setReturnstatus("OK");
    }

}

