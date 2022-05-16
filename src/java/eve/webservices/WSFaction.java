/*
 * WSFaction.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 11.4.2022 9:13
 *
 */

package eve.webservices;

import eve.BusinessObject.Logic.*;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.webservice.WSIFaction;
import eve.logicentity.Faction;
import eve.searchentity.Factionsearch;
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
@WebService(endpointInterface = "eve.interfaces.webservice.WSIFaction")
public class WSFaction implements WSIFaction {

    private JSONArray toJSONArray(ArrayList factions) {
        JSONArray jsonfactions = new JSONArray();
        Iterator factionsI = factions.iterator();
        while(factionsI.hasNext()) {
            jsonfactions.add(JSONFaction.toJSON((Faction)factionsI.next()));
        }
        return jsonfactions;
    }

    /**
     * Web service operation
     */
    //@WebMethod(operationName = "getFactions")
    @Override
    public String getFactions() {
        try {
            BLfaction blfaction = new BLfaction();
            ArrayList factions = blfaction.getAll();
            JSONArray jsonfactions = toJSONArray(factions);
            return jsonfactions.toJSONString();
        }
        catch(DBException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "search")
    @Override
    public String search(String json) {
        BLfaction blfaction = new BLfaction();
        JSONParser parser = new JSONParser();
        String result = "";
        Faction faction;
        try {
            Factionsearch factionsearch = JSONFaction.toFactionsearch((JSONObject)parser.parse(json));
            ArrayList factions = blfaction.search(factionsearch);
            JSONArray jsonfactions = toJSONArray(factions);
            result = jsonfactions.toJSONString();
        }
        catch(ParseException e) {
            result = "";
        }
        catch(DBException e) {
            result = "";
        }
        return result;
    }

    //@WebMethod(operationName = "getFaction")
    @Override
    public String getFaction(String json) {
        BLfaction blfaction = new BLfaction();
        JSONParser parser = new JSONParser();
        String result = "";
        Faction faction;
        try {
            FactionPK factionPK = JSONFaction.toFactionPK((JSONObject)parser.parse(json));
            faction = blfaction.getFaction(factionPK);
            if(faction!=null) {
                result = JSONFaction.toJSON(faction).toJSONString();
            }
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
        return result;
    }

    //@WebMethod(operationName = "insertFaction")
    @Override
    public void insertFaction(String json) {
        BLfaction blfaction = new BLfaction();
        JSONParser parser = new JSONParser();
        try {
            IFaction faction = JSONFaction.toFaction((JSONObject)parser.parse(json));
            blfaction.insertFaction(faction);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "updateFaction")
    @Override
    public void updateFaction(String json) {
        BLfaction blfaction = new BLfaction();
        JSONParser parser = new JSONParser();
        try {
            IFaction faction = JSONFaction.toFaction((JSONObject)parser.parse(json));
            blfaction.updateFaction(faction);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "deleteFaction")
    @Override
    public void deleteFaction(String json) {
        BLfaction blfaction = new BLfaction();
        JSONParser parser = new JSONParser();
        try {
            IFaction faction = JSONFaction.toFaction((JSONObject)parser.parse(json));
            blfaction.deleteFaction(faction);
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "getFactions4system")
    @Override
    public String getFactions4system(String json) {
        BLfaction blfaction = new BLfaction();
        JSONParser parser = new JSONParser();
        Faction faction;
        try {
            ISystemPK systemPK = JSONSystem.toSystemPK((JSONObject)parser.parse(json));
            ArrayList factions = blfaction.getFactions4system(systemPK);
            JSONArray jsonfactions = toJSONArray(factions);
            return jsonfactions.toJSONString();
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

    //@WebMethod(operationName = "delete4system")
    @Override
    public void delete4system(String json) {
        BLfaction blfaction = new BLfaction();
        JSONParser parser = new JSONParser();
        Faction faction;
        try {
            ISystemPK systemPK = JSONSystem.toSystemPK((JSONObject)parser.parse(json));
            blfaction.delete4system(systemPK);
        }
        catch(ParseException e) {
        }
    }


}

