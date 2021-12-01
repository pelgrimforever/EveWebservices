/*
 * WSTradecombined.java
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
import eve.interfaces.webservice.WSITradecombined;
import eve.logicentity.Tradecombined;
import eve.searchentity.Tradecombinedsearch;
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
@WebService(endpointInterface = "eve.interfaces.webservice.WSITradecombined")
public class WSTradecombined implements WSITradecombined {

    private JSONArray toJSONArray(ArrayList tradecombineds) {
        JSONArray jsontradecombineds = new JSONArray();
        Iterator tradecombinedsI = tradecombineds.iterator();
        while(tradecombinedsI.hasNext()) {
            jsontradecombineds.add(JSONTradecombined.toJSON((Tradecombined)tradecombinedsI.next()));
        }
        return jsontradecombineds;
    }

    /**
     * Web service operation
     */
    //@WebMethod(operationName = "getTradecombineds")
    @Override
    public String getTradecombineds() {
        try {
            BLtradecombined bltradecombined = new BLtradecombined();
            ArrayList tradecombineds = bltradecombined.getAll();
            JSONArray jsontradecombineds = toJSONArray(tradecombineds);
            return jsontradecombineds.toJSONString();
        }
        catch(DBException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "search")
    @Override
    public String search(String json) {
        BLtradecombined bltradecombined = new BLtradecombined();
        JSONParser parser = new JSONParser();
        String result = "";
        Tradecombined tradecombined;
        try {
            Tradecombinedsearch tradecombinedsearch = JSONTradecombined.toTradecombinedsearch((JSONObject)parser.parse(json));
            ArrayList tradecombineds = bltradecombined.search(tradecombinedsearch);
            JSONArray jsontradecombineds = toJSONArray(tradecombineds);
            result = jsontradecombineds.toJSONString();
        }
        catch(ParseException e) {
            result = "";
        }
        catch(DBException e) {
            result = "";
        }
        return result;
    }

    //@WebMethod(operationName = "getTradecombined")
    @Override
    public String getTradecombined(String json) {
        BLtradecombined bltradecombined = new BLtradecombined();
        JSONParser parser = new JSONParser();
        String result = "";
        Tradecombined tradecombined;
        try {
            TradecombinedPK tradecombinedPK = JSONTradecombined.toTradecombinedPK((JSONObject)parser.parse(json));
            tradecombined = bltradecombined.getTradecombined(tradecombinedPK);
            if(tradecombined!=null) {
                result = JSONTradecombined.toJSON(tradecombined).toJSONString();
            }
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
        return result;
    }

    //@WebMethod(operationName = "insertTradecombined")
    @Override
    public void insertTradecombined(String json) {
        BLtradecombined bltradecombined = new BLtradecombined();
        JSONParser parser = new JSONParser();
        try {
            ITradecombined tradecombined = JSONTradecombined.toTradecombined((JSONObject)parser.parse(json));
            bltradecombined.insertTradecombined(tradecombined);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "updateTradecombined")
    @Override
    public void updateTradecombined(String json) {
        BLtradecombined bltradecombined = new BLtradecombined();
        JSONParser parser = new JSONParser();
        try {
            ITradecombined tradecombined = JSONTradecombined.toTradecombined((JSONObject)parser.parse(json));
            bltradecombined.updateTradecombined(tradecombined);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "deleteTradecombined")
    @Override
    public void deleteTradecombined(String json) {
        BLtradecombined bltradecombined = new BLtradecombined();
        JSONParser parser = new JSONParser();
        try {
            ITradecombined tradecombined = JSONTradecombined.toTradecombined((JSONObject)parser.parse(json));
            bltradecombined.deleteTradecombined(tradecombined);
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "getTradecombineds4evetype")
    @Override
    public String getTradecombineds4evetype(String json) {
        BLtradecombined bltradecombined = new BLtradecombined();
        JSONParser parser = new JSONParser();
        Tradecombined tradecombined;
        try {
            IEvetypePK evetypePK = JSONEvetype.toEvetypePK((JSONObject)parser.parse(json));
            ArrayList tradecombineds = bltradecombined.getTradecombineds4evetype(evetypePK);
            JSONArray jsontradecombineds = toJSONArray(tradecombineds);
            return jsontradecombineds.toJSONString();
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

    //@WebMethod(operationName = "delete4evetype")
    @Override
    public void delete4evetype(String json) {
        BLtradecombined bltradecombined = new BLtradecombined();
        JSONParser parser = new JSONParser();
        Tradecombined tradecombined;
        try {
            IEvetypePK evetypePK = JSONEvetype.toEvetypePK((JSONObject)parser.parse(json));
            bltradecombined.delete4evetype(evetypePK);
        }
        catch(ParseException e) {
        }
    }

    //@WebMethod(operationName = "getTradecombineds4systemBuy_system")
    @Override
    public String getTradecombineds4systemBuy_system(String json) {
        BLtradecombined bltradecombined = new BLtradecombined();
        JSONParser parser = new JSONParser();
        Tradecombined tradecombined;
        try {
            ISystemPK systemBuy_systemPK = JSONSystem.toSystemPK((JSONObject)parser.parse(json));
            ArrayList tradecombineds = bltradecombined.getTradecombineds4systemBuy_system(systemBuy_systemPK);
            JSONArray jsontradecombineds = toJSONArray(tradecombineds);
            return jsontradecombineds.toJSONString();
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
        BLtradecombined bltradecombined = new BLtradecombined();
        JSONParser parser = new JSONParser();
        Tradecombined tradecombined;
        try {
            ISystemPK systemBuy_systemPK = JSONSystem.toSystemPK((JSONObject)parser.parse(json));
            bltradecombined.delete4systemBuy_system(systemBuy_systemPK);
        }
        catch(ParseException e) {
        }
    }

    //@WebMethod(operationName = "getTradecombineds4systemSell_system")
    @Override
    public String getTradecombineds4systemSell_system(String json) {
        BLtradecombined bltradecombined = new BLtradecombined();
        JSONParser parser = new JSONParser();
        Tradecombined tradecombined;
        try {
            ISystemPK systemSell_systemPK = JSONSystem.toSystemPK((JSONObject)parser.parse(json));
            ArrayList tradecombineds = bltradecombined.getTradecombineds4systemSell_system(systemSell_systemPK);
            JSONArray jsontradecombineds = toJSONArray(tradecombineds);
            return jsontradecombineds.toJSONString();
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
        BLtradecombined bltradecombined = new BLtradecombined();
        JSONParser parser = new JSONParser();
        Tradecombined tradecombined;
        try {
            ISystemPK systemSell_systemPK = JSONSystem.toSystemPK((JSONObject)parser.parse(json));
            bltradecombined.delete4systemSell_system(systemSell_systemPK);
        }
        catch(ParseException e) {
        }
    }

    //@WebMethod(operationName = "getTradecombineds4tradecombined_sell")
    @Override
    public String getTradecombineds4tradecombined_sell(String json) {
        BLtradecombined bltradecombined = new BLtradecombined();
        JSONParser parser = new JSONParser();
        Tradecombined tradecombined;
        try {
            String result = null;
            ITradecombined_sellPK tradecombined_sellPK = JSONTradecombined_sell.toTradecombined_sellPK((JSONObject)parser.parse(json));
            tradecombined = (Tradecombined)bltradecombined.getTradecombined_sell(tradecombined_sellPK);
            if(tradecombined!=null) {
                result = JSONTradecombined.toJSON(tradecombined).toJSONString();
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

