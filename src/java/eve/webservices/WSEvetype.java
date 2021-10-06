/*
 * WSEvetype.java
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
import eve.interfaces.webservice.WSIEvetype;
import eve.logicentity.Evetype;
import eve.searchentity.Evetypesearch;
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
@WebService(endpointInterface = "eve.interfaces.webservice.WSIEvetype")
public class WSEvetype implements WSIEvetype {

    private JSONArray toJSONArray(ArrayList evetypes) {
        JSONArray jsonevetypes = new JSONArray();
        Iterator evetypesI = evetypes.iterator();
        while(evetypesI.hasNext()) {
            jsonevetypes.add(JSONEvetype.toJSON((Evetype)evetypesI.next()));
        }
        return jsonevetypes;
    }

    /**
     * Web service operation
     */
    //@WebMethod(operationName = "getEvetypes")
    @Override
    public String getEvetypes() {
        try {
            BLevetype blevetype = new BLevetype();
            ArrayList evetypes = blevetype.getAll();
            JSONArray jsonevetypes = toJSONArray(evetypes);
            return jsonevetypes.toJSONString();
        }
        catch(DBException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "search")
    @Override
    public String search(String json) {
        BLevetype blevetype = new BLevetype();
        JSONParser parser = new JSONParser();
        String result = "";
        Evetype evetype;
        try {
            Evetypesearch evetypesearch = JSONEvetype.toEvetypesearch((JSONObject)parser.parse(json));
            ArrayList evetypes = blevetype.search(evetypesearch);
            JSONArray jsonevetypes = toJSONArray(evetypes);
            result = jsonevetypes.toJSONString();
        }
        catch(ParseException e) {
            result = "";
        }
        catch(DBException e) {
            result = "";
        }
        return result;
    }

    //@WebMethod(operationName = "getEvetype")
    @Override
    public String getEvetype(String json) {
        BLevetype blevetype = new BLevetype();
        JSONParser parser = new JSONParser();
        String result = "";
        Evetype evetype;
        try {
            EvetypePK evetypePK = JSONEvetype.toEvetypePK((JSONObject)parser.parse(json));
            evetype = blevetype.getEvetype(evetypePK);
            if(evetype!=null) {
                result = JSONEvetype.toJSON(evetype).toJSONString();
            }
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
        return result;
    }

    //@WebMethod(operationName = "insertEvetype")
    @Override
    public void insertEvetype(String json) {
        BLevetype blevetype = new BLevetype();
        JSONParser parser = new JSONParser();
        try {
            IEvetype evetype = JSONEvetype.toEvetype((JSONObject)parser.parse(json));
            blevetype.insertEvetype(evetype);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "updateEvetype")
    @Override
    public void updateEvetype(String json) {
        BLevetype blevetype = new BLevetype();
        JSONParser parser = new JSONParser();
        try {
            IEvetype evetype = JSONEvetype.toEvetype((JSONObject)parser.parse(json));
            blevetype.updateEvetype(evetype);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "deleteEvetype")
    @Override
    public void deleteEvetype(String json) {
        BLevetype blevetype = new BLevetype();
        JSONParser parser = new JSONParser();
        try {
            IEvetype evetype = JSONEvetype.toEvetype((JSONObject)parser.parse(json));
            blevetype.deleteEvetype(evetype);
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "getEvetypes4market_group")
    @Override
    public String getEvetypes4market_group(String json) {
        BLevetype blevetype = new BLevetype();
        JSONParser parser = new JSONParser();
        Evetype evetype;
        try {
            IMarket_groupPK market_groupPK = JSONMarket_group.toMarket_groupPK((JSONObject)parser.parse(json));
            ArrayList evetypes = blevetype.getEvetypes4market_group(market_groupPK);
            JSONArray jsonevetypes = toJSONArray(evetypes);
            return jsonevetypes.toJSONString();
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

    //@WebMethod(operationName = "delete4market_group")
    @Override
    public void delete4market_group(String json) {
        BLevetype blevetype = new BLevetype();
        JSONParser parser = new JSONParser();
        Evetype evetype;
        try {
            IMarket_groupPK market_groupPK = JSONMarket_group.toMarket_groupPK((JSONObject)parser.parse(json));
            blevetype.delete4market_group(this.getClass().getName(), market_groupPK);
        }
        catch(ParseException e) {
        }
    }

    //@WebMethod(operationName = "getEvetypes4typegroup")
    @Override
    public String getEvetypes4typegroup(String json) {
        BLevetype blevetype = new BLevetype();
        JSONParser parser = new JSONParser();
        Evetype evetype;
        try {
            ITypegroupPK typegroupPK = JSONTypegroup.toTypegroupPK((JSONObject)parser.parse(json));
            ArrayList evetypes = blevetype.getEvetypes4typegroup(typegroupPK);
            JSONArray jsonevetypes = toJSONArray(evetypes);
            return jsonevetypes.toJSONString();
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

    //@WebMethod(operationName = "delete4typegroup")
    @Override
    public void delete4typegroup(String json) {
        BLevetype blevetype = new BLevetype();
        JSONParser parser = new JSONParser();
        Evetype evetype;
        try {
            ITypegroupPK typegroupPK = JSONTypegroup.toTypegroupPK((JSONObject)parser.parse(json));
            blevetype.delete4typegroup(this.getClass().getName(), typegroupPK);
        }
        catch(ParseException e) {
        }
    }

    //@WebMethod(operationName = "getEvetypes4graphic")
    @Override
    public String getEvetypes4graphic(String json) {
        BLevetype blevetype = new BLevetype();
        JSONParser parser = new JSONParser();
        Evetype evetype;
        try {
            IGraphicPK graphicPK = JSONGraphic.toGraphicPK((JSONObject)parser.parse(json));
            ArrayList evetypes = blevetype.getEvetypes4graphic(graphicPK);
            JSONArray jsonevetypes = toJSONArray(evetypes);
            return jsonevetypes.toJSONString();
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

    //@WebMethod(operationName = "delete4graphic")
    @Override
    public void delete4graphic(String json) {
        BLevetype blevetype = new BLevetype();
        JSONParser parser = new JSONParser();
        Evetype evetype;
        try {
            IGraphicPK graphicPK = JSONGraphic.toGraphicPK((JSONObject)parser.parse(json));
            blevetype.delete4graphic(this.getClass().getName(), graphicPK);
        }
        catch(ParseException e) {
        }
    }

    //@WebMethod(operationName = "getEvetypes4stock")
    @Override
    public String getEvetypes4stock(String json) {
        BLevetype blevetype = new BLevetype();
        JSONParser parser = new JSONParser();
        Evetype evetype;
        try {
            String result = null;
            IStockPK stockPK = JSONStock.toStockPK((JSONObject)parser.parse(json));
            evetype = (Evetype)blevetype.getStock(stockPK);
            if(evetype!=null) {
                result = JSONEvetype.toJSON(evetype).toJSONString();
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

    //@WebMethod(operationName = "getEvetypes4order_history")
    @Override
    public String getEvetypes4order_history(String json) {
        BLevetype blevetype = new BLevetype();
        JSONParser parser = new JSONParser();
        Evetype evetype;
        try {
            String result = null;
            IOrder_historyPK order_historyPK = JSONOrder_history.toOrder_historyPK((JSONObject)parser.parse(json));
            evetype = (Evetype)blevetype.getOrder_history(order_historyPK);
            if(evetype!=null) {
                result = JSONEvetype.toJSON(evetype).toJSONString();
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

