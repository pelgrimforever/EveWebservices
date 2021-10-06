/*
 * WSSystemtrade_order.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 6.9.2021 16:29
 *
 */

package eve.webservices;

import eve.BusinessObject.Logic.*;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.webservice.WSISystemtrade_order;
import eve.logicentity.Systemtrade_order;
import eve.searchentity.Systemtrade_ordersearch;
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
@WebService(endpointInterface = "eve.interfaces.webservice.WSISystemtrade_order")
public class WSSystemtrade_order implements WSISystemtrade_order {

    private JSONArray toJSONArray(ArrayList systemtrade_orders) {
        JSONArray jsonsystemtrade_orders = new JSONArray();
        Iterator systemtrade_ordersI = systemtrade_orders.iterator();
        while(systemtrade_ordersI.hasNext()) {
            jsonsystemtrade_orders.add(JSONSystemtrade_order.toJSON((Systemtrade_order)systemtrade_ordersI.next()));
        }
        return jsonsystemtrade_orders;
    }

    /**
     * Web service operation
     */
    //@WebMethod(operationName = "getSystemtrade_orders")
    @Override
    public String getSystemtrade_orders() {
        try {
            BLsystemtrade_order blsystemtrade_order = new BLsystemtrade_order();
            ArrayList systemtrade_orders = blsystemtrade_order.getAll();
            JSONArray jsonsystemtrade_orders = toJSONArray(systemtrade_orders);
            return jsonsystemtrade_orders.toJSONString();
        }
        catch(DBException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "search")
    @Override
    public String search(String json) {
        BLsystemtrade_order blsystemtrade_order = new BLsystemtrade_order();
        JSONParser parser = new JSONParser();
        String result = "";
        Systemtrade_order systemtrade_order;
        try {
            Systemtrade_ordersearch systemtrade_ordersearch = JSONSystemtrade_order.toSystemtrade_ordersearch((JSONObject)parser.parse(json));
            ArrayList systemtrade_orders = blsystemtrade_order.search(systemtrade_ordersearch);
            JSONArray jsonsystemtrade_orders = toJSONArray(systemtrade_orders);
            result = jsonsystemtrade_orders.toJSONString();
        }
        catch(ParseException e) {
            result = "";
        }
        catch(DBException e) {
            result = "";
        }
        return result;
    }

    //@WebMethod(operationName = "getSystemtrade_order")
    @Override
    public String getSystemtrade_order(String json) {
        BLsystemtrade_order blsystemtrade_order = new BLsystemtrade_order();
        JSONParser parser = new JSONParser();
        String result = "";
        Systemtrade_order systemtrade_order;
        try {
            Systemtrade_orderPK systemtrade_orderPK = JSONSystemtrade_order.toSystemtrade_orderPK((JSONObject)parser.parse(json));
            systemtrade_order = blsystemtrade_order.getSystemtrade_order(systemtrade_orderPK);
            if(systemtrade_order!=null) {
                result = JSONSystemtrade_order.toJSON(systemtrade_order).toJSONString();
            }
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
        return result;
    }

    //@WebMethod(operationName = "insertSystemtrade_order")
    @Override
    public void insertSystemtrade_order(String json) {
        BLsystemtrade_order blsystemtrade_order = new BLsystemtrade_order();
        JSONParser parser = new JSONParser();
        try {
            ISystemtrade_order systemtrade_order = JSONSystemtrade_order.toSystemtrade_order((JSONObject)parser.parse(json));
            blsystemtrade_order.insertSystemtrade_order(systemtrade_order);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "updateSystemtrade_order")
    @Override
    public void updateSystemtrade_order(String json) {
        BLsystemtrade_order blsystemtrade_order = new BLsystemtrade_order();
        JSONParser parser = new JSONParser();
        try {
            ISystemtrade_order systemtrade_order = JSONSystemtrade_order.toSystemtrade_order((JSONObject)parser.parse(json));
            blsystemtrade_order.updateSystemtrade_order(systemtrade_order);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "deleteSystemtrade_order")
    @Override
    public void deleteSystemtrade_order(String json) {
        BLsystemtrade_order blsystemtrade_order = new BLsystemtrade_order();
        JSONParser parser = new JSONParser();
        try {
            ISystemtrade_order systemtrade_order = JSONSystemtrade_order.toSystemtrade_order((JSONObject)parser.parse(json));
            blsystemtrade_order.deleteSystemtrade_order(systemtrade_order);
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "getSystemtrade_orders4ordersBuy_order")
    @Override
    public String getSystemtrade_orders4ordersBuy_order(String json) {
        BLsystemtrade_order blsystemtrade_order = new BLsystemtrade_order();
        JSONParser parser = new JSONParser();
        Systemtrade_order systemtrade_order;
        try {
            IOrdersPK ordersBuy_orderPK = JSONOrders.toOrdersPK((JSONObject)parser.parse(json));
            ArrayList systemtrade_orders = blsystemtrade_order.getSystemtrade_orders4ordersBuy_order(ordersBuy_orderPK);
            JSONArray jsonsystemtrade_orders = toJSONArray(systemtrade_orders);
            return jsonsystemtrade_orders.toJSONString();
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

    //@WebMethod(operationName = "delete4ordersBuy_order")
    @Override
    public void delete4ordersBuy_order(String json) {
        BLsystemtrade_order blsystemtrade_order = new BLsystemtrade_order();
        JSONParser parser = new JSONParser();
        Systemtrade_order systemtrade_order;
        try {
            IOrdersPK ordersBuy_orderPK = JSONOrders.toOrdersPK((JSONObject)parser.parse(json));
            blsystemtrade_order.delete4ordersBuy_order(this.getClass().getName(), ordersBuy_orderPK);
        }
        catch(ParseException e) {
        }
    }

    //@WebMethod(operationName = "getSystemtrade_orders4ordersSell_order")
    @Override
    public String getSystemtrade_orders4ordersSell_order(String json) {
        BLsystemtrade_order blsystemtrade_order = new BLsystemtrade_order();
        JSONParser parser = new JSONParser();
        Systemtrade_order systemtrade_order;
        try {
            IOrdersPK ordersSell_orderPK = JSONOrders.toOrdersPK((JSONObject)parser.parse(json));
            ArrayList systemtrade_orders = blsystemtrade_order.getSystemtrade_orders4ordersSell_order(ordersSell_orderPK);
            JSONArray jsonsystemtrade_orders = toJSONArray(systemtrade_orders);
            return jsonsystemtrade_orders.toJSONString();
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

    //@WebMethod(operationName = "delete4ordersSell_order")
    @Override
    public void delete4ordersSell_order(String json) {
        BLsystemtrade_order blsystemtrade_order = new BLsystemtrade_order();
        JSONParser parser = new JSONParser();
        Systemtrade_order systemtrade_order;
        try {
            IOrdersPK ordersSell_orderPK = JSONOrders.toOrdersPK((JSONObject)parser.parse(json));
            blsystemtrade_order.delete4ordersSell_order(this.getClass().getName(), ordersSell_orderPK);
        }
        catch(ParseException e) {
        }
    }

    //@WebMethod(operationName = "getSystemtrade_orders4systemtrade")
    @Override
    public String getSystemtrade_orders4systemtrade(String json) {
        BLsystemtrade_order blsystemtrade_order = new BLsystemtrade_order();
        JSONParser parser = new JSONParser();
        Systemtrade_order systemtrade_order;
        try {
            ISystemtradePK systemtradePK = JSONSystemtrade.toSystemtradePK((JSONObject)parser.parse(json));
            ArrayList systemtrade_orders = blsystemtrade_order.getSystemtrade_orders4systemtrade(systemtradePK);
            JSONArray jsonsystemtrade_orders = toJSONArray(systemtrade_orders);
            return jsonsystemtrade_orders.toJSONString();
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

    //@WebMethod(operationName = "delete4systemtrade")
    @Override
    public void delete4systemtrade(String json) {
        BLsystemtrade_order blsystemtrade_order = new BLsystemtrade_order();
        JSONParser parser = new JSONParser();
        Systemtrade_order systemtrade_order;
        try {
            ISystemtradePK systemtradePK = JSONSystemtrade.toSystemtradePK((JSONObject)parser.parse(json));
            blsystemtrade_order.delete4systemtrade(this.getClass().getName(), systemtradePK);
        }
        catch(ParseException e) {
        }
    }


}

