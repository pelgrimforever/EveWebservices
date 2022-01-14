/*
 * WSTradecombined_sell.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 14.0.2022 16:56
 *
 */

package eve.webservices;

import eve.BusinessObject.Logic.*;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.webservice.WSITradecombined_sell;
import eve.logicentity.Tradecombined_sell;
import eve.searchentity.Tradecombined_sellsearch;
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
@WebService(endpointInterface = "eve.interfaces.webservice.WSITradecombined_sell")
public class WSTradecombined_sell implements WSITradecombined_sell {

    private JSONArray toJSONArray(ArrayList tradecombined_sells) {
        JSONArray jsontradecombined_sells = new JSONArray();
        Iterator tradecombined_sellsI = tradecombined_sells.iterator();
        while(tradecombined_sellsI.hasNext()) {
            jsontradecombined_sells.add(JSONTradecombined_sell.toJSON((Tradecombined_sell)tradecombined_sellsI.next()));
        }
        return jsontradecombined_sells;
    }

    /**
     * Web service operation
     */
    //@WebMethod(operationName = "getTradecombined_sells")
    @Override
    public String getTradecombined_sells() {
        try {
            BLtradecombined_sell bltradecombined_sell = new BLtradecombined_sell();
            ArrayList tradecombined_sells = bltradecombined_sell.getAll();
            JSONArray jsontradecombined_sells = toJSONArray(tradecombined_sells);
            return jsontradecombined_sells.toJSONString();
        }
        catch(DBException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "search")
    @Override
    public String search(String json) {
        BLtradecombined_sell bltradecombined_sell = new BLtradecombined_sell();
        JSONParser parser = new JSONParser();
        String result = "";
        Tradecombined_sell tradecombined_sell;
        try {
            Tradecombined_sellsearch tradecombined_sellsearch = JSONTradecombined_sell.toTradecombined_sellsearch((JSONObject)parser.parse(json));
            ArrayList tradecombined_sells = bltradecombined_sell.search(tradecombined_sellsearch);
            JSONArray jsontradecombined_sells = toJSONArray(tradecombined_sells);
            result = jsontradecombined_sells.toJSONString();
        }
        catch(ParseException e) {
            result = "";
        }
        catch(DBException e) {
            result = "";
        }
        return result;
    }

    //@WebMethod(operationName = "getTradecombined_sell")
    @Override
    public String getTradecombined_sell(String json) {
        BLtradecombined_sell bltradecombined_sell = new BLtradecombined_sell();
        JSONParser parser = new JSONParser();
        String result = "";
        Tradecombined_sell tradecombined_sell;
        try {
            Tradecombined_sellPK tradecombined_sellPK = JSONTradecombined_sell.toTradecombined_sellPK((JSONObject)parser.parse(json));
            tradecombined_sell = bltradecombined_sell.getTradecombined_sell(tradecombined_sellPK);
            if(tradecombined_sell!=null) {
                result = JSONTradecombined_sell.toJSON(tradecombined_sell).toJSONString();
            }
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
        return result;
    }

    //@WebMethod(operationName = "insertTradecombined_sell")
    @Override
    public void insertTradecombined_sell(String json) {
        BLtradecombined_sell bltradecombined_sell = new BLtradecombined_sell();
        JSONParser parser = new JSONParser();
        try {
            ITradecombined_sell tradecombined_sell = JSONTradecombined_sell.toTradecombined_sell((JSONObject)parser.parse(json));
            bltradecombined_sell.insertTradecombined_sell(tradecombined_sell);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "updateTradecombined_sell")
    @Override
    public void updateTradecombined_sell(String json) {
        BLtradecombined_sell bltradecombined_sell = new BLtradecombined_sell();
        JSONParser parser = new JSONParser();
        try {
            ITradecombined_sell tradecombined_sell = JSONTradecombined_sell.toTradecombined_sell((JSONObject)parser.parse(json));
            bltradecombined_sell.updateTradecombined_sell(tradecombined_sell);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "deleteTradecombined_sell")
    @Override
    public void deleteTradecombined_sell(String json) {
        BLtradecombined_sell bltradecombined_sell = new BLtradecombined_sell();
        JSONParser parser = new JSONParser();
        try {
            ITradecombined_sell tradecombined_sell = JSONTradecombined_sell.toTradecombined_sell((JSONObject)parser.parse(json));
            bltradecombined_sell.deleteTradecombined_sell(tradecombined_sell);
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "getTradecombined_sells4ordersBuy_order_id")
    @Override
    public String getTradecombined_sells4ordersBuy_order_id(String json) {
        BLtradecombined_sell bltradecombined_sell = new BLtradecombined_sell();
        JSONParser parser = new JSONParser();
        Tradecombined_sell tradecombined_sell;
        try {
            IOrdersPK ordersBuy_order_idPK = JSONOrders.toOrdersPK((JSONObject)parser.parse(json));
            ArrayList tradecombined_sells = bltradecombined_sell.getTradecombined_sells4ordersBuy_order_id(ordersBuy_order_idPK);
            JSONArray jsontradecombined_sells = toJSONArray(tradecombined_sells);
            return jsontradecombined_sells.toJSONString();
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

    //@WebMethod(operationName = "delete4ordersBuy_order_id")
    @Override
    public void delete4ordersBuy_order_id(String json) {
        BLtradecombined_sell bltradecombined_sell = new BLtradecombined_sell();
        JSONParser parser = new JSONParser();
        Tradecombined_sell tradecombined_sell;
        try {
            IOrdersPK ordersBuy_order_idPK = JSONOrders.toOrdersPK((JSONObject)parser.parse(json));
            bltradecombined_sell.delete4ordersBuy_order_id(ordersBuy_order_idPK);
        }
        catch(ParseException e) {
        }
    }

    //@WebMethod(operationName = "getTradecombined_sells4ordersSell_order_id")
    @Override
    public String getTradecombined_sells4ordersSell_order_id(String json) {
        BLtradecombined_sell bltradecombined_sell = new BLtradecombined_sell();
        JSONParser parser = new JSONParser();
        Tradecombined_sell tradecombined_sell;
        try {
            IOrdersPK ordersSell_order_idPK = JSONOrders.toOrdersPK((JSONObject)parser.parse(json));
            ArrayList tradecombined_sells = bltradecombined_sell.getTradecombined_sells4ordersSell_order_id(ordersSell_order_idPK);
            JSONArray jsontradecombined_sells = toJSONArray(tradecombined_sells);
            return jsontradecombined_sells.toJSONString();
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

    //@WebMethod(operationName = "delete4ordersSell_order_id")
    @Override
    public void delete4ordersSell_order_id(String json) {
        BLtradecombined_sell bltradecombined_sell = new BLtradecombined_sell();
        JSONParser parser = new JSONParser();
        Tradecombined_sell tradecombined_sell;
        try {
            IOrdersPK ordersSell_order_idPK = JSONOrders.toOrdersPK((JSONObject)parser.parse(json));
            bltradecombined_sell.delete4ordersSell_order_id(ordersSell_order_idPK);
        }
        catch(ParseException e) {
        }
    }

    //@WebMethod(operationName = "getTradecombined_sells4tradecombined")
    @Override
    public String getTradecombined_sells4tradecombined(String json) {
        BLtradecombined_sell bltradecombined_sell = new BLtradecombined_sell();
        JSONParser parser = new JSONParser();
        Tradecombined_sell tradecombined_sell;
        try {
            ITradecombinedPK tradecombinedPK = JSONTradecombined.toTradecombinedPK((JSONObject)parser.parse(json));
            ArrayList tradecombined_sells = bltradecombined_sell.getTradecombined_sells4tradecombined(tradecombinedPK);
            JSONArray jsontradecombined_sells = toJSONArray(tradecombined_sells);
            return jsontradecombined_sells.toJSONString();
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

    //@WebMethod(operationName = "delete4tradecombined")
    @Override
    public void delete4tradecombined(String json) {
        BLtradecombined_sell bltradecombined_sell = new BLtradecombined_sell();
        JSONParser parser = new JSONParser();
        Tradecombined_sell tradecombined_sell;
        try {
            ITradecombinedPK tradecombinedPK = JSONTradecombined.toTradecombinedPK((JSONObject)parser.parse(json));
            bltradecombined_sell.delete4tradecombined(tradecombinedPK);
        }
        catch(ParseException e) {
        }
    }


}

