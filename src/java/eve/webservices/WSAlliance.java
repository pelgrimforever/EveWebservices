/*
 * WSAlliance.java
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
import eve.interfaces.webservice.WSIAlliance;
import eve.logicentity.Alliance;
import eve.searchentity.Alliancesearch;
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
@WebService(endpointInterface = "eve.interfaces.webservice.WSIAlliance")
public class WSAlliance implements WSIAlliance {

    private JSONArray toJSONArray(ArrayList alliances) {
        JSONArray jsonalliances = new JSONArray();
        Iterator alliancesI = alliances.iterator();
        while(alliancesI.hasNext()) {
            jsonalliances.add(JSONAlliance.toJSON((Alliance)alliancesI.next()));
        }
        return jsonalliances;
    }

    /**
     * Web service operation
     */
    //@WebMethod(operationName = "getAlliances")
    @Override
    public String getAlliances() {
        try {
            BLalliance blalliance = new BLalliance();
            ArrayList alliances = blalliance.getAll();
            JSONArray jsonalliances = toJSONArray(alliances);
            return jsonalliances.toJSONString();
        }
        catch(DBException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "search")
    @Override
    public String search(String json) {
        BLalliance blalliance = new BLalliance();
        JSONParser parser = new JSONParser();
        String result = "";
        Alliance alliance;
        try {
            Alliancesearch alliancesearch = JSONAlliance.toAlliancesearch((JSONObject)parser.parse(json));
            ArrayList alliances = blalliance.search(alliancesearch);
            JSONArray jsonalliances = toJSONArray(alliances);
            result = jsonalliances.toJSONString();
        }
        catch(ParseException e) {
            result = "";
        }
        catch(DBException e) {
            result = "";
        }
        return result;
    }

    //@WebMethod(operationName = "getAlliance")
    @Override
    public String getAlliance(String json) {
        BLalliance blalliance = new BLalliance();
        JSONParser parser = new JSONParser();
        String result = "";
        Alliance alliance;
        try {
            AlliancePK alliancePK = JSONAlliance.toAlliancePK((JSONObject)parser.parse(json));
            alliance = blalliance.getAlliance(alliancePK);
            if(alliance!=null) {
                result = JSONAlliance.toJSON(alliance).toJSONString();
            }
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
        return result;
    }

    //@WebMethod(operationName = "insertAlliance")
    @Override
    public void insertAlliance(String json) {
        BLalliance blalliance = new BLalliance();
        JSONParser parser = new JSONParser();
        try {
            IAlliance alliance = JSONAlliance.toAlliance((JSONObject)parser.parse(json));
            blalliance.insertAlliance(alliance);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "updateAlliance")
    @Override
    public void updateAlliance(String json) {
        BLalliance blalliance = new BLalliance();
        JSONParser parser = new JSONParser();
        try {
            IAlliance alliance = JSONAlliance.toAlliance((JSONObject)parser.parse(json));
            blalliance.updateAlliance(alliance);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "deleteAlliance")
    @Override
    public void deleteAlliance(String json) {
        BLalliance blalliance = new BLalliance();
        JSONParser parser = new JSONParser();
        try {
            IAlliance alliance = JSONAlliance.toAlliance((JSONObject)parser.parse(json));
            blalliance.deleteAlliance(alliance);
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "getAlliances4corporationCreator_corporation")
    @Override
    public String getAlliances4corporationCreator_corporation(String json) {
        BLalliance blalliance = new BLalliance();
        JSONParser parser = new JSONParser();
        Alliance alliance;
        try {
            ICorporationPK corporationCreator_corporationPK = JSONCorporation.toCorporationPK((JSONObject)parser.parse(json));
            ArrayList alliances = blalliance.getAlliances4corporationCreator_corporation(corporationCreator_corporationPK);
            JSONArray jsonalliances = toJSONArray(alliances);
            return jsonalliances.toJSONString();
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

    //@WebMethod(operationName = "delete4corporationCreator_corporation")
    @Override
    public void delete4corporationCreator_corporation(String json) {
        BLalliance blalliance = new BLalliance();
        JSONParser parser = new JSONParser();
        Alliance alliance;
        try {
            ICorporationPK corporationCreator_corporationPK = JSONCorporation.toCorporationPK((JSONObject)parser.parse(json));
            blalliance.delete4corporationCreator_corporation(corporationCreator_corporationPK);
        }
        catch(ParseException e) {
        }
    }

    //@WebMethod(operationName = "getAlliances4corporationExecutor_corporation")
    @Override
    public String getAlliances4corporationExecutor_corporation(String json) {
        BLalliance blalliance = new BLalliance();
        JSONParser parser = new JSONParser();
        Alliance alliance;
        try {
            ICorporationPK corporationExecutor_corporationPK = JSONCorporation.toCorporationPK((JSONObject)parser.parse(json));
            ArrayList alliances = blalliance.getAlliances4corporationExecutor_corporation(corporationExecutor_corporationPK);
            JSONArray jsonalliances = toJSONArray(alliances);
            return jsonalliances.toJSONString();
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

    //@WebMethod(operationName = "delete4corporationExecutor_corporation")
    @Override
    public void delete4corporationExecutor_corporation(String json) {
        BLalliance blalliance = new BLalliance();
        JSONParser parser = new JSONParser();
        Alliance alliance;
        try {
            ICorporationPK corporationExecutor_corporationPK = JSONCorporation.toCorporationPK((JSONObject)parser.parse(json));
            blalliance.delete4corporationExecutor_corporation(corporationExecutor_corporationPK);
        }
        catch(ParseException e) {
        }
    }


}

