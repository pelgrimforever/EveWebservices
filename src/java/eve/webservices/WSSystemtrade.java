/*
 * WSSystemtrade.java
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
import eve.interfaces.webservice.WSISystemtrade;
import eve.logicentity.Systemtrade;
import eve.searchentity.Systemtradesearch;
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
@WebService(endpointInterface = "eve.interfaces.webservice.WSISystemtrade")
public class WSSystemtrade implements WSISystemtrade {

    private JSONArray toJSONArray(ArrayList systemtrades) {
        JSONArray jsonsystemtrades = new JSONArray();
        Iterator systemtradesI = systemtrades.iterator();
        while(systemtradesI.hasNext()) {
            jsonsystemtrades.add(JSONSystemtrade.toJSON((Systemtrade)systemtradesI.next()));
        }
        return jsonsystemtrades;
    }

    /**
     * Web service operation
     */
    //@WebMethod(operationName = "getSystemtrades")
    @Override
    public String getSystemtrades() {
        try {
            BLsystemtrade blsystemtrade = new BLsystemtrade();
            ArrayList systemtrades = blsystemtrade.getAll();
            JSONArray jsonsystemtrades = toJSONArray(systemtrades);
            return jsonsystemtrades.toJSONString();
        }
        catch(DBException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "search")
    @Override
    public String search(String json) {
        BLsystemtrade blsystemtrade = new BLsystemtrade();
        JSONParser parser = new JSONParser();
        String result = "";
        Systemtrade systemtrade;
        try {
            Systemtradesearch systemtradesearch = JSONSystemtrade.toSystemtradesearch((JSONObject)parser.parse(json));
            ArrayList systemtrades = blsystemtrade.search(systemtradesearch);
            JSONArray jsonsystemtrades = toJSONArray(systemtrades);
            result = jsonsystemtrades.toJSONString();
        }
        catch(ParseException e) {
            result = "";
        }
        catch(DBException e) {
            result = "";
        }
        return result;
    }

    //@WebMethod(operationName = "getSystemtrade")
    @Override
    public String getSystemtrade(String json) {
        BLsystemtrade blsystemtrade = new BLsystemtrade();
        JSONParser parser = new JSONParser();
        String result = "";
        Systemtrade systemtrade;
        try {
            SystemtradePK systemtradePK = JSONSystemtrade.toSystemtradePK((JSONObject)parser.parse(json));
            systemtrade = blsystemtrade.getSystemtrade(systemtradePK);
            if(systemtrade!=null) {
                result = JSONSystemtrade.toJSON(systemtrade).toJSONString();
            }
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
        return result;
    }

    //@WebMethod(operationName = "insertSystemtrade")
    @Override
    public void insertSystemtrade(String json) {
        BLsystemtrade blsystemtrade = new BLsystemtrade();
        JSONParser parser = new JSONParser();
        try {
            ISystemtrade systemtrade = JSONSystemtrade.toSystemtrade((JSONObject)parser.parse(json));
            blsystemtrade.insertSystemtrade(systemtrade);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "updateSystemtrade")
    @Override
    public void updateSystemtrade(String json) {
        BLsystemtrade blsystemtrade = new BLsystemtrade();
        JSONParser parser = new JSONParser();
        try {
            ISystemtrade systemtrade = JSONSystemtrade.toSystemtrade((JSONObject)parser.parse(json));
            blsystemtrade.updateSystemtrade(systemtrade);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "deleteSystemtrade")
    @Override
    public void deleteSystemtrade(String json) {
        BLsystemtrade blsystemtrade = new BLsystemtrade();
        JSONParser parser = new JSONParser();
        try {
            ISystemtrade systemtrade = JSONSystemtrade.toSystemtrade((JSONObject)parser.parse(json));
            blsystemtrade.deleteSystemtrade(systemtrade);
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "getSystemtrades4systemSell_system")
    @Override
    public String getSystemtrades4systemSell_system(String json) {
        BLsystemtrade blsystemtrade = new BLsystemtrade();
        JSONParser parser = new JSONParser();
        Systemtrade systemtrade;
        try {
            ISystemPK systemSell_systemPK = JSONSystem.toSystemPK((JSONObject)parser.parse(json));
            ArrayList systemtrades = blsystemtrade.getSystemtrades4systemSell_system(systemSell_systemPK);
            JSONArray jsonsystemtrades = toJSONArray(systemtrades);
            return jsonsystemtrades.toJSONString();
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

    //@WebMethod(operationName = "delete4systemSell_system")
    @Override
    public void delete4systemSell_system(String json) {
        BLsystemtrade blsystemtrade = new BLsystemtrade();
        JSONParser parser = new JSONParser();
        Systemtrade systemtrade;
        try {
            ISystemPK systemSell_systemPK = JSONSystem.toSystemPK((JSONObject)parser.parse(json));
            blsystemtrade.delete4systemSell_system(systemSell_systemPK);
        }
        catch(ParseException e) {
        }
    }

    //@WebMethod(operationName = "getSystemtrades4systemBuy_system")
    @Override
    public String getSystemtrades4systemBuy_system(String json) {
        BLsystemtrade blsystemtrade = new BLsystemtrade();
        JSONParser parser = new JSONParser();
        Systemtrade systemtrade;
        try {
            ISystemPK systemBuy_systemPK = JSONSystem.toSystemPK((JSONObject)parser.parse(json));
            ArrayList systemtrades = blsystemtrade.getSystemtrades4systemBuy_system(systemBuy_systemPK);
            JSONArray jsonsystemtrades = toJSONArray(systemtrades);
            return jsonsystemtrades.toJSONString();
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

    //@WebMethod(operationName = "delete4systemBuy_system")
    @Override
    public void delete4systemBuy_system(String json) {
        BLsystemtrade blsystemtrade = new BLsystemtrade();
        JSONParser parser = new JSONParser();
        Systemtrade systemtrade;
        try {
            ISystemPK systemBuy_systemPK = JSONSystem.toSystemPK((JSONObject)parser.parse(json));
            blsystemtrade.delete4systemBuy_system(systemBuy_systemPK);
        }
        catch(ParseException e) {
        }
    }

    //@WebMethod(operationName = "getSystemtrades4systemtrade_order")
    @Override
    public String getSystemtrades4systemtrade_order(String json) {
        BLsystemtrade blsystemtrade = new BLsystemtrade();
        JSONParser parser = new JSONParser();
        Systemtrade systemtrade;
        try {
            String result = null;
            ISystemtrade_orderPK systemtrade_orderPK = JSONSystemtrade_order.toSystemtrade_orderPK((JSONObject)parser.parse(json));
            systemtrade = (Systemtrade)blsystemtrade.getSystemtrade_order(systemtrade_orderPK);
            if(systemtrade!=null) {
                result = JSONSystemtrade.toJSON(systemtrade).toJSONString();
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

