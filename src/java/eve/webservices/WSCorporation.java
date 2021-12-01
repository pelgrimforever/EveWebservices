/*
 * WSCorporation.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 30.10.2021 10:3
 *
 */

package eve.webservices;

import eve.BusinessObject.Logic.*;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.webservice.WSICorporation;
import eve.logicentity.Corporation;
import eve.searchentity.Corporationsearch;
import general.exception.CustomException;
import general.exception.DataException;
import general.exception.DBException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.jws.WebMethod;
import javax.jws.WebService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Franky Laseure
 */
@WebService(endpointInterface = "eve.interfaces.webservice.WSICorporation")
public class WSCorporation implements WSICorporation {

    private JSONArray toJSONArray(ArrayList corporations) {
        JSONArray jsoncorporations = new JSONArray();
        Iterator corporationsI = corporations.iterator();
        while(corporationsI.hasNext()) {
            jsoncorporations.add(JSONCorporation.toJSON((Corporation)corporationsI.next()));
        }
        return jsoncorporations;
    }

    /**
     * Web service operation
     */
    //@WebMethod(operationName = "getCorporations")
    @Override
    public String getCorporations() {
        try {
            BLcorporation blcorporation = new BLcorporation();
            ArrayList corporations = blcorporation.getAll();
            JSONArray jsoncorporations = toJSONArray(corporations);
            return jsoncorporations.toJSONString();
        }
        catch(DBException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "search")
    @Override
    public String search(String json) {
        BLcorporation blcorporation = new BLcorporation();
        JSONParser parser = new JSONParser();
        String result = "";
        Corporation corporation;
        try {
            Corporationsearch corporationsearch = JSONCorporation.toCorporationsearch((JSONObject)parser.parse(json));
            ArrayList corporations = blcorporation.search(corporationsearch);
            JSONArray jsoncorporations = toJSONArray(corporations);
            result = jsoncorporations.toJSONString();
        }
        catch(ParseException e) {
            result = "";
        }
        catch(DBException e) {
            result = "";
        }
        return result;
    }

    //@WebMethod(operationName = "getCorporation")
    @Override
    public String getCorporation(String json) {
        BLcorporation blcorporation = new BLcorporation();
        JSONParser parser = new JSONParser();
        String result = "";
        Corporation corporation;
        try {
            CorporationPK corporationPK = JSONCorporation.toCorporationPK((JSONObject)parser.parse(json));
            corporation = blcorporation.getCorporation(corporationPK);
            if(corporation!=null) {
                result = JSONCorporation.toJSON(corporation).toJSONString();
            }
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
        return result;
    }

    //@WebMethod(operationName = "insertCorporation")
    @Override
    public void insertCorporation(String json) {
        BLcorporation blcorporation = new BLcorporation();
        JSONParser parser = new JSONParser();
        try {
            ICorporation corporation = JSONCorporation.toCorporation((JSONObject)parser.parse(json));
            blcorporation.insertCorporation(corporation);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "updateCorporation")
    @Override
    public void updateCorporation(String json) {
        BLcorporation blcorporation = new BLcorporation();
        JSONParser parser = new JSONParser();
        try {
            ICorporation corporation = JSONCorporation.toCorporation((JSONObject)parser.parse(json));
            blcorporation.updateCorporation(corporation);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "deleteCorporation")
    @Override
    public void deleteCorporation(String json) {
        BLcorporation blcorporation = new BLcorporation();
        JSONParser parser = new JSONParser();
        try {
            ICorporation corporation = JSONCorporation.toCorporation((JSONObject)parser.parse(json));
            blcorporation.deleteCorporation(corporation);
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "getCorporations4station")
    @Override
    public String getCorporations4station(String json) {
        BLcorporation blcorporation = new BLcorporation();
        JSONParser parser = new JSONParser();
        Corporation corporation;
        try {
            IStationPK stationPK = JSONStation.toStationPK((JSONObject)parser.parse(json));
            ArrayList corporations = blcorporation.getCorporations4station(stationPK);
            JSONArray jsoncorporations = toJSONArray(corporations);
            return jsoncorporations.toJSONString();
        }
        catch(ParseException e) {
            return null;
        }
        catch(DBException e) {
            return null;
        }
        catch(CustomException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "delete4station")
    @Override
    public void delete4station(String json) {
        BLcorporation blcorporation = new BLcorporation();
        JSONParser parser = new JSONParser();
        Corporation corporation;
        try {
            IStationPK stationPK = JSONStation.toStationPK((JSONObject)parser.parse(json));
            blcorporation.delete4station(stationPK);
        }
        catch(ParseException e) {
        }
    }

    //@WebMethod(operationName = "getCorporations4faction")
    @Override
    public String getCorporations4faction(String json) {
        BLcorporation blcorporation = new BLcorporation();
        JSONParser parser = new JSONParser();
        Corporation corporation;
        try {
            IFactionPK factionPK = JSONFaction.toFactionPK((JSONObject)parser.parse(json));
            ArrayList corporations = blcorporation.getCorporations4faction(factionPK);
            JSONArray jsoncorporations = toJSONArray(corporations);
            return jsoncorporations.toJSONString();
        }
        catch(ParseException e) {
            return null;
        }
        catch(DBException e) {
            return null;
        }
        catch(CustomException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "delete4faction")
    @Override
    public void delete4faction(String json) {
        BLcorporation blcorporation = new BLcorporation();
        JSONParser parser = new JSONParser();
        Corporation corporation;
        try {
            IFactionPK factionPK = JSONFaction.toFactionPK((JSONObject)parser.parse(json));
            blcorporation.delete4faction(factionPK);
        }
        catch(ParseException e) {
        }
    }

    //@WebMethod(operationName = "getCorporations4alliance")
    @Override
    public String getCorporations4alliance(String json) {
        BLcorporation blcorporation = new BLcorporation();
        JSONParser parser = new JSONParser();
        Corporation corporation;
        try {
            IAlliancePK alliancePK = JSONAlliance.toAlliancePK((JSONObject)parser.parse(json));
            ArrayList corporations = blcorporation.getCorporations4alliance(alliancePK);
            JSONArray jsoncorporations = toJSONArray(corporations);
            return jsoncorporations.toJSONString();
        }
        catch(ParseException e) {
            return null;
        }
        catch(DBException e) {
            return null;
        }
        catch(CustomException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "delete4alliance")
    @Override
    public void delete4alliance(String json) {
        BLcorporation blcorporation = new BLcorporation();
        JSONParser parser = new JSONParser();
        Corporation corporation;
        try {
            IAlliancePK alliancePK = JSONAlliance.toAlliancePK((JSONObject)parser.parse(json));
            blcorporation.delete4alliance(alliancePK);
        }
        catch(ParseException e) {
        }
    }


}

