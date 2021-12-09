/*
 * WSOrders.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 9.11.2021 14:30
 *
 */

package eve.webservices;

import eve.BusinessObject.Logic.*;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.webservice.WSIOrders;
import eve.logicentity.Orders;
import eve.searchentity.Orderssearch;
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
@WebService(endpointInterface = "eve.interfaces.webservice.WSIOrders")
public class WSOrders implements WSIOrders {

    private JSONArray toJSONArray(ArrayList orderss) {
        JSONArray jsonorderss = new JSONArray();
        Iterator orderssI = orderss.iterator();
        while(orderssI.hasNext()) {
            jsonorderss.add(JSONOrders.toJSON((Orders)orderssI.next()));
        }
        return jsonorderss;
    }

    /**
     * Web service operation
     */
    //@WebMethod(operationName = "getOrderss")
    @Override
    public String getOrderss() {
        try {
            BLorders blorders = new BLorders();
            ArrayList orderss = blorders.getAll();
            JSONArray jsonorderss = toJSONArray(orderss);
            return jsonorderss.toJSONString();
        }
        catch(DBException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "search")
    @Override
    public String search(String json) {
        BLorders blorders = new BLorders();
        JSONParser parser = new JSONParser();
        String result = "";
        Orders orders;
        try {
            Orderssearch orderssearch = JSONOrders.toOrderssearch((JSONObject)parser.parse(json));
            ArrayList orderss = blorders.search(orderssearch);
            JSONArray jsonorderss = toJSONArray(orderss);
            result = jsonorderss.toJSONString();
        }
        catch(ParseException e) {
            result = "";
        }
        catch(DBException e) {
            result = "";
        }
        return result;
    }

    //@WebMethod(operationName = "getOrders")
    @Override
    public String getOrders(String json) {
        BLorders blorders = new BLorders();
        JSONParser parser = new JSONParser();
        String result = "";
        Orders orders;
        try {
            OrdersPK ordersPK = JSONOrders.toOrdersPK((JSONObject)parser.parse(json));
            orders = blorders.getOrders(ordersPK);
            if(orders!=null) {
                result = JSONOrders.toJSON(orders).toJSONString();
            }
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
        return result;
    }

    //@WebMethod(operationName = "insertOrders")
    @Override
    public void insertOrders(String json) {
        BLorders blorders = new BLorders();
        JSONParser parser = new JSONParser();
        try {
            IOrders orders = JSONOrders.toOrders((JSONObject)parser.parse(json));
            blorders.insertOrders(orders);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "updateOrders")
    @Override
    public void updateOrders(String json) {
        BLorders blorders = new BLorders();
        JSONParser parser = new JSONParser();
        try {
            IOrders orders = JSONOrders.toOrders((JSONObject)parser.parse(json));
            blorders.updateOrders(orders);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "deleteOrders")
    @Override
    public void deleteOrders(String json) {
        BLorders blorders = new BLorders();
        JSONParser parser = new JSONParser();
        try {
            IOrders orders = JSONOrders.toOrders((JSONObject)parser.parse(json));
            blorders.deleteOrders(orders);
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "getOrderss4evetype")
    @Override
    public String getOrderss4evetype(String json) {
        BLorders blorders = new BLorders();
        JSONParser parser = new JSONParser();
        Orders orders;
        try {
            IEvetypePK evetypePK = JSONEvetype.toEvetypePK((JSONObject)parser.parse(json));
            ArrayList orderss = blorders.getOrderss4evetype(evetypePK);
            JSONArray jsonorderss = toJSONArray(orderss);
            return jsonorderss.toJSONString();
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
        BLorders blorders = new BLorders();
        JSONParser parser = new JSONParser();
        Orders orders;
        try {
            IEvetypePK evetypePK = JSONEvetype.toEvetypePK((JSONObject)parser.parse(json));
            blorders.delete4evetype(evetypePK);
        }
        catch(ParseException e) {
        }
    }

    //@WebMethod(operationName = "getOrderss4system")
    @Override
    public String getOrderss4system(String json) {
        BLorders blorders = new BLorders();
        JSONParser parser = new JSONParser();
        Orders orders;
        try {
            ISystemPK systemPK = JSONSystem.toSystemPK((JSONObject)parser.parse(json));
            ArrayList orderss = blorders.getOrderss4system(systemPK);
            JSONArray jsonorderss = toJSONArray(orderss);
            return jsonorderss.toJSONString();
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
        BLorders blorders = new BLorders();
        JSONParser parser = new JSONParser();
        Orders orders;
        try {
            ISystemPK systemPK = JSONSystem.toSystemPK((JSONObject)parser.parse(json));
            blorders.delete4system(systemPK);
        }
        catch(ParseException e) {
        }
    }

    //@WebMethod(operationName = "getOrderss4tradecombined_sellBuy_order_id")
    @Override
    public String getOrderss4tradecombined_sellBuy_order_id(String json) {
        BLorders blorders = new BLorders();
        JSONParser parser = new JSONParser();
        Orders orders;
        try {
            String result = null;
            ITradecombined_sellPK tradecombined_sellBuy_order_idPK = JSONTradecombined_sell.toTradecombined_sellPK((JSONObject)parser.parse(json));
            orders = (Orders)blorders.getTradecombined_sellbuy_order_id(tradecombined_sellBuy_order_idPK);
            if(orders!=null) {
                result = JSONOrders.toJSON(orders).toJSONString();
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

    //@WebMethod(operationName = "getOrderss4tradecombined_sellSell_order_id")
    @Override
    public String getOrderss4tradecombined_sellSell_order_id(String json) {
        BLorders blorders = new BLorders();
        JSONParser parser = new JSONParser();
        Orders orders;
        try {
            String result = null;
            ITradecombined_sellPK tradecombined_sellSell_order_idPK = JSONTradecombined_sell.toTradecombined_sellPK((JSONObject)parser.parse(json));
            orders = (Orders)blorders.getTradecombined_sellsell_order_id(tradecombined_sellSell_order_idPK);
            if(orders!=null) {
                result = JSONOrders.toJSON(orders).toJSONString();
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

    //@WebMethod(operationName = "getOrderss4tradeSell_order_id")
    @Override
    public String getOrderss4tradeSell_order_id(String json) {
        BLorders blorders = new BLorders();
        JSONParser parser = new JSONParser();
        Orders orders;
        try {
            String result = null;
            ITradePK tradeSell_order_idPK = JSONTrade.toTradePK((JSONObject)parser.parse(json));
            orders = (Orders)blorders.getTradesell_order_id(tradeSell_order_idPK);
            if(orders!=null) {
                result = JSONOrders.toJSON(orders).toJSONString();
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

    //@WebMethod(operationName = "getOrderss4tradeBuy_order_id")
    @Override
    public String getOrderss4tradeBuy_order_id(String json) {
        BLorders blorders = new BLorders();
        JSONParser parser = new JSONParser();
        Orders orders;
        try {
            String result = null;
            ITradePK tradeBuy_order_idPK = JSONTrade.toTradePK((JSONObject)parser.parse(json));
            orders = (Orders)blorders.getTradebuy_order_id(tradeBuy_order_idPK);
            if(orders!=null) {
                result = JSONOrders.toJSON(orders).toJSONString();
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

