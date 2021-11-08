/*
 * WSMarket_group.java
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
import eve.interfaces.webservice.WSIMarket_group;
import eve.logicentity.Market_group;
import eve.searchentity.Market_groupsearch;
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
@WebService(endpointInterface = "eve.interfaces.webservice.WSIMarket_group")
public class WSMarket_group implements WSIMarket_group {

    private JSONArray toJSONArray(ArrayList market_groups) {
        JSONArray jsonmarket_groups = new JSONArray();
        Iterator market_groupsI = market_groups.iterator();
        while(market_groupsI.hasNext()) {
            jsonmarket_groups.add(JSONMarket_group.toJSON((Market_group)market_groupsI.next()));
        }
        return jsonmarket_groups;
    }

    /**
     * Web service operation
     */
    //@WebMethod(operationName = "getMarket_groups")
    @Override
    public String getMarket_groups() {
        try {
            BLmarket_group blmarket_group = new BLmarket_group();
            ArrayList market_groups = blmarket_group.getAll();
            JSONArray jsonmarket_groups = toJSONArray(market_groups);
            return jsonmarket_groups.toJSONString();
        }
        catch(DBException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "search")
    @Override
    public String search(String json) {
        BLmarket_group blmarket_group = new BLmarket_group();
        JSONParser parser = new JSONParser();
        String result = "";
        Market_group market_group;
        try {
            Market_groupsearch market_groupsearch = JSONMarket_group.toMarket_groupsearch((JSONObject)parser.parse(json));
            ArrayList market_groups = blmarket_group.search(market_groupsearch);
            JSONArray jsonmarket_groups = toJSONArray(market_groups);
            result = jsonmarket_groups.toJSONString();
        }
        catch(ParseException e) {
            result = "";
        }
        catch(DBException e) {
            result = "";
        }
        return result;
    }

    //@WebMethod(operationName = "getMarket_group")
    @Override
    public String getMarket_group(String json) {
        BLmarket_group blmarket_group = new BLmarket_group();
        JSONParser parser = new JSONParser();
        String result = "";
        Market_group market_group;
        try {
            Market_groupPK market_groupPK = JSONMarket_group.toMarket_groupPK((JSONObject)parser.parse(json));
            market_group = blmarket_group.getMarket_group(market_groupPK);
            if(market_group!=null) {
                result = JSONMarket_group.toJSON(market_group).toJSONString();
            }
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
        return result;
    }

    //@WebMethod(operationName = "insertMarket_group")
    @Override
    public void insertMarket_group(String json) {
        BLmarket_group blmarket_group = new BLmarket_group();
        JSONParser parser = new JSONParser();
        try {
            IMarket_group market_group = JSONMarket_group.toMarket_group((JSONObject)parser.parse(json));
            blmarket_group.insertMarket_group(market_group);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "updateMarket_group")
    @Override
    public void updateMarket_group(String json) {
        BLmarket_group blmarket_group = new BLmarket_group();
        JSONParser parser = new JSONParser();
        try {
            IMarket_group market_group = JSONMarket_group.toMarket_group((JSONObject)parser.parse(json));
            blmarket_group.updateMarket_group(market_group);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "deleteMarket_group")
    @Override
    public void deleteMarket_group(String json) {
        BLmarket_group blmarket_group = new BLmarket_group();
        JSONParser parser = new JSONParser();
        try {
            IMarket_group market_group = JSONMarket_group.toMarket_group((JSONObject)parser.parse(json));
            blmarket_group.deleteMarket_group(market_group);
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "getMarket_groups4market_groupParent_id")
    @Override
    public String getMarket_groups4market_groupParent_id(String json) {
        BLmarket_group blmarket_group = new BLmarket_group();
        JSONParser parser = new JSONParser();
        Market_group market_group;
        try {
            IMarket_groupPK market_groupParent_idPK = JSONMarket_group.toMarket_groupPK((JSONObject)parser.parse(json));
            ArrayList market_groups = blmarket_group.getMarket_groups4market_groupParent_id(market_groupParent_idPK);
            JSONArray jsonmarket_groups = toJSONArray(market_groups);
            return jsonmarket_groups.toJSONString();
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

    //@WebMethod(operationName = "delete4market_groupParent_id")
    @Override
    public void delete4market_groupParent_id(String json) {
        BLmarket_group blmarket_group = new BLmarket_group();
        JSONParser parser = new JSONParser();
        Market_group market_group;
        try {
            IMarket_groupPK market_groupParent_idPK = JSONMarket_group.toMarket_groupPK((JSONObject)parser.parse(json));
            blmarket_group.delete4market_groupParent_id(market_groupParent_idPK);
        }
        catch(ParseException e) {
        }
    }


}

