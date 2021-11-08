/*
 * WSSystem.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 8.10.2021 7:21
 *
 */

package eve.webservices;

import eve.BusinessObject.Logic.*;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.webservice.WSISystem;
import eve.logicentity.System;
import eve.searchentity.Systemsearch;
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
@WebService(endpointInterface = "eve.interfaces.webservice.WSISystem")
public class WSSystem implements WSISystem {

    private JSONArray toJSONArray(ArrayList systems) {
        JSONArray jsonsystems = new JSONArray();
        Iterator systemsI = systems.iterator();
        while(systemsI.hasNext()) {
            jsonsystems.add(JSONSystem.toJSON((System)systemsI.next()));
        }
        return jsonsystems;
    }

    /**
     * Web service operation
     */
    //@WebMethod(operationName = "getSystems")
    @Override
    public String getSystems() {
        try {
            BLsystem blsystem = new BLsystem();
            ArrayList systems = blsystem.getAll();
            JSONArray jsonsystems = toJSONArray(systems);
            return jsonsystems.toJSONString();
        }
        catch(DBException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "search")
    @Override
    public String search(String json) {
        BLsystem blsystem = new BLsystem();
        JSONParser parser = new JSONParser();
        String result = "";
        System system;
        try {
            Systemsearch systemsearch = JSONSystem.toSystemsearch((JSONObject)parser.parse(json));
            ArrayList systems = blsystem.search(systemsearch);
            JSONArray jsonsystems = toJSONArray(systems);
            result = jsonsystems.toJSONString();
        }
        catch(ParseException e) {
            result = "";
        }
        catch(DBException e) {
            result = "";
        }
        return result;
    }

    //@WebMethod(operationName = "getSystem")
    @Override
    public String getSystem(String json) {
        BLsystem blsystem = new BLsystem();
        JSONParser parser = new JSONParser();
        String result = "";
        System system;
        try {
            SystemPK systemPK = JSONSystem.toSystemPK((JSONObject)parser.parse(json));
            system = blsystem.getSystem(systemPK);
            if(system!=null) {
                result = JSONSystem.toJSON(system).toJSONString();
            }
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
        return result;
    }

    //@WebMethod(operationName = "insertSystem")
    @Override
    public void insertSystem(String json) {
        BLsystem blsystem = new BLsystem();
        JSONParser parser = new JSONParser();
        try {
            ISystem system = JSONSystem.toSystem((JSONObject)parser.parse(json));
            blsystem.insertSystem(system);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "updateSystem")
    @Override
    public void updateSystem(String json) {
        BLsystem blsystem = new BLsystem();
        JSONParser parser = new JSONParser();
        try {
            ISystem system = JSONSystem.toSystem((JSONObject)parser.parse(json));
            blsystem.updateSystem(system);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "deleteSystem")
    @Override
    public void deleteSystem(String json) {
        BLsystem blsystem = new BLsystem();
        JSONParser parser = new JSONParser();
        try {
            ISystem system = JSONSystem.toSystem((JSONObject)parser.parse(json));
            blsystem.deleteSystem(system);
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "getSystems4security_island")
    @Override
    public String getSystems4security_island(String json) {
        BLsystem blsystem = new BLsystem();
        JSONParser parser = new JSONParser();
        System system;
        try {
            ISecurity_islandPK security_islandPK = JSONSecurity_island.toSecurity_islandPK((JSONObject)parser.parse(json));
            ArrayList systems = blsystem.getSystems4security_island(security_islandPK);
            JSONArray jsonsystems = toJSONArray(systems);
            return jsonsystems.toJSONString();
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

    //@WebMethod(operationName = "delete4security_island")
    @Override
    public void delete4security_island(String json) {
        BLsystem blsystem = new BLsystem();
        JSONParser parser = new JSONParser();
        System system;
        try {
            ISecurity_islandPK security_islandPK = JSONSecurity_island.toSecurity_islandPK((JSONObject)parser.parse(json));
            blsystem.delete4security_island(security_islandPK);
        }
        catch(ParseException e) {
        }
    }

    //@WebMethod(operationName = "getSystems4constellation")
    @Override
    public String getSystems4constellation(String json) {
        BLsystem blsystem = new BLsystem();
        JSONParser parser = new JSONParser();
        System system;
        try {
            IConstellationPK constellationPK = JSONConstellation.toConstellationPK((JSONObject)parser.parse(json));
            ArrayList systems = blsystem.getSystems4constellation(constellationPK);
            JSONArray jsonsystems = toJSONArray(systems);
            return jsonsystems.toJSONString();
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

    //@WebMethod(operationName = "delete4constellation")
    @Override
    public void delete4constellation(String json) {
        BLsystem blsystem = new BLsystem();
        JSONParser parser = new JSONParser();
        System system;
        try {
            IConstellationPK constellationPK = JSONConstellation.toConstellationPK((JSONObject)parser.parse(json));
            blsystem.delete4constellation(constellationPK);
        }
        catch(ParseException e) {
        }
    }

    //@WebMethod(operationName = "getSystems4systemjumpsSystem_end")
    @Override
    public String getSystems4systemjumpsSystem_end(String json) {
        BLsystem blsystem = new BLsystem();
        JSONParser parser = new JSONParser();
        System system;
        try {
            String result = null;
            ISystemjumpsPK systemjumpsSystem_endPK = JSONSystemjumps.toSystemjumpsPK((JSONObject)parser.parse(json));
            system = (System)blsystem.getSystemjumpssystem_end(systemjumpsSystem_endPK);
            if(system!=null) {
                result = JSONSystem.toJSON(system).toJSONString();
            }
            return result;
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

    //@WebMethod(operationName = "getSystems4systemjumpsSystem_start")
    @Override
    public String getSystems4systemjumpsSystem_start(String json) {
        BLsystem blsystem = new BLsystem();
        JSONParser parser = new JSONParser();
        System system;
        try {
            String result = null;
            ISystemjumpsPK systemjumpsSystem_startPK = JSONSystemjumps.toSystemjumpsPK((JSONObject)parser.parse(json));
            system = (System)blsystem.getSystemjumpssystem_start(systemjumpsSystem_startPK);
            if(system!=null) {
                result = JSONSystem.toJSON(system).toJSONString();
            }
            return result;
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

    //@WebMethod(operationName = "getSystems4route")
    @Override
    public String getSystems4route(String json) {
        BLsystem blsystem = new BLsystem();
        JSONParser parser = new JSONParser();
        System system;
        try {
            String result = null;
            IRoutePK routePK = JSONRoute.toRoutePK((JSONObject)parser.parse(json));
            system = (System)blsystem.getRoute(routePK);
            if(system!=null) {
                result = JSONSystem.toJSON(system).toJSONString();
            }
            return result;
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

    //@WebMethod(operationName = "getSystems4systemtradeSell_system")
    @Override
    public String getSystems4systemtradeSell_system(String json) {
        BLsystem blsystem = new BLsystem();
        JSONParser parser = new JSONParser();
        System system;
        try {
            String result = null;
            ISystemtradePK systemtradeSell_systemPK = JSONSystemtrade.toSystemtradePK((JSONObject)parser.parse(json));
            system = (System)blsystem.getSystemtradesell_system(systemtradeSell_systemPK);
            if(system!=null) {
                result = JSONSystem.toJSON(system).toJSONString();
            }
            return result;
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

    //@WebMethod(operationName = "getSystems4systemtradeBuy_system")
    @Override
    public String getSystems4systemtradeBuy_system(String json) {
        BLsystem blsystem = new BLsystem();
        JSONParser parser = new JSONParser();
        System system;
        try {
            String result = null;
            ISystemtradePK systemtradeBuy_systemPK = JSONSystemtrade.toSystemtradePK((JSONObject)parser.parse(json));
            system = (System)blsystem.getSystemtradebuy_system(systemtradeBuy_systemPK);
            if(system!=null) {
                result = JSONSystem.toJSON(system).toJSONString();
            }
            return result;
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


}

