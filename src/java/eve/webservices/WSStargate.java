package eve.webservices;

import eve.BusinessObject.Logic.*;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.webservice.WSIStargate;
import eve.logicentity.Stargate;
import eve.searchentity.Stargatesearch;
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
@WebService(endpointInterface = "eve.interfaces.webservice.WSIStargate")
public class WSStargate implements WSIStargate {

    private JSONArray toJSONArray(ArrayList stargates) {
        JSONArray jsonstargates = new JSONArray();
        Iterator stargatesI = stargates.iterator();
        while(stargatesI.hasNext()) {
            jsonstargates.add(JSONStargate.toJSON((Stargate)stargatesI.next()));
        }
        return jsonstargates;
    }

    /**
     * Web service operation
     */
    //@WebMethod(operationName = "getStargates")
    @Override
    public String getStargates() {
        try {
            BLstargate blstargate = new BLstargate();
            ArrayList stargates = blstargate.getAll();
            JSONArray jsonstargates = toJSONArray(stargates);
            return jsonstargates.toJSONString();
        }
        catch(DBException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "search")
    @Override
    public String search(String json) {
        BLstargate blstargate = new BLstargate();
        JSONParser parser = new JSONParser();
        String result = "";
        Stargate stargate;
        try {
            Stargatesearch stargatesearch = JSONStargate.toStargatesearch((JSONObject)parser.parse(json));
            ArrayList stargates = blstargate.search(stargatesearch);
            JSONArray jsonstargates = toJSONArray(stargates);
            result = jsonstargates.toJSONString();
        }
        catch(ParseException e) {
            result = "";
        }
        catch(DBException e) {
            result = "";
        }
        return result;
    }

    //@WebMethod(operationName = "getStargate")
    @Override
    public String getStargate(String json) {
        BLstargate blstargate = new BLstargate();
        JSONParser parser = new JSONParser();
        String result = "";
        Stargate stargate;
        try {
            StargatePK stargatePK = JSONStargate.toStargatePK((JSONObject)parser.parse(json));
            stargate = blstargate.getStargate(stargatePK);
            if(stargate!=null) {
                result = JSONStargate.toJSON(stargate).toJSONString();
            }
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
        return result;
    }

    //@WebMethod(operationName = "insertStargate")
    @Override
    public void insertStargate(String json) {
        BLstargate blstargate = new BLstargate();
        JSONParser parser = new JSONParser();
        try {
            IStargate stargate = JSONStargate.toStargate((JSONObject)parser.parse(json));
            blstargate.insertStargate(stargate);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "updateStargate")
    @Override
    public void updateStargate(String json) {
        BLstargate blstargate = new BLstargate();
        JSONParser parser = new JSONParser();
        try {
            IStargate stargate = JSONStargate.toStargate((JSONObject)parser.parse(json));
            blstargate.updateStargate(stargate);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "deleteStargate")
    @Override
    public void deleteStargate(String json) {
        BLstargate blstargate = new BLstargate();
        JSONParser parser = new JSONParser();
        try {
            IStargate stargate = JSONStargate.toStargate((JSONObject)parser.parse(json));
            blstargate.deleteStargate(stargate);
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "getStargates4systemSystem")
    @Override
    public String getStargates4systemSystem(String json) {
        BLstargate blstargate = new BLstargate();
        JSONParser parser = new JSONParser();
        Stargate stargate;
        try {
            ISystemPK systemSystemPK = JSONSystem.toSystemPK((JSONObject)parser.parse(json));
            ArrayList stargates = blstargate.getStargates4systemSystem(systemSystemPK);
            JSONArray jsonstargates = toJSONArray(stargates);
            return jsonstargates.toJSONString();
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

    //@WebMethod(operationName = "delete4systemSystem")
    @Override
    public void delete4systemSystem(String json) {
        BLstargate blstargate = new BLstargate();
        JSONParser parser = new JSONParser();
        Stargate stargate;
        try {
            ISystemPK systemSystemPK = JSONSystem.toSystemPK((JSONObject)parser.parse(json));
            blstargate.delete4systemSystem(this.getClass().getName(), systemSystemPK);
        }
        catch(ParseException e) {
        }
    }

    //@WebMethod(operationName = "getStargates4systemTo_system")
    @Override
    public String getStargates4systemTo_system(String json) {
        BLstargate blstargate = new BLstargate();
        JSONParser parser = new JSONParser();
        Stargate stargate;
        try {
            ISystemPK systemTo_systemPK = JSONSystem.toSystemPK((JSONObject)parser.parse(json));
            ArrayList stargates = blstargate.getStargates4systemTo_system(systemTo_systemPK);
            JSONArray jsonstargates = toJSONArray(stargates);
            return jsonstargates.toJSONString();
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

    //@WebMethod(operationName = "delete4systemTo_system")
    @Override
    public void delete4systemTo_system(String json) {
        BLstargate blstargate = new BLstargate();
        JSONParser parser = new JSONParser();
        Stargate stargate;
        try {
            ISystemPK systemTo_systemPK = JSONSystem.toSystemPK((JSONObject)parser.parse(json));
            blstargate.delete4systemTo_system(this.getClass().getName(), systemTo_systemPK);
        }
        catch(ParseException e) {
        }
    }


}

