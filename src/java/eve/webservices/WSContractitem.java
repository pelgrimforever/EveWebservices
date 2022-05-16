/*
 * WSContractitem.java
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
import eve.interfaces.webservice.WSIContractitem;
import eve.logicentity.Contractitem;
import eve.searchentity.Contractitemsearch;
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
@WebService(endpointInterface = "eve.interfaces.webservice.WSIContractitem")
public class WSContractitem implements WSIContractitem {

    private JSONArray toJSONArray(ArrayList contractitems) {
        JSONArray jsoncontractitems = new JSONArray();
        Iterator contractitemsI = contractitems.iterator();
        while(contractitemsI.hasNext()) {
            jsoncontractitems.add(JSONContractitem.toJSON((Contractitem)contractitemsI.next()));
        }
        return jsoncontractitems;
    }

    /**
     * Web service operation
     */
    //@WebMethod(operationName = "getContractitems")
    @Override
    public String getContractitems() {
        try {
            BLcontractitem blcontractitem = new BLcontractitem();
            ArrayList contractitems = blcontractitem.getAll();
            JSONArray jsoncontractitems = toJSONArray(contractitems);
            return jsoncontractitems.toJSONString();
        }
        catch(DBException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "search")
    @Override
    public String search(String json) {
        BLcontractitem blcontractitem = new BLcontractitem();
        JSONParser parser = new JSONParser();
        String result = "";
        Contractitem contractitem;
        try {
            Contractitemsearch contractitemsearch = JSONContractitem.toContractitemsearch((JSONObject)parser.parse(json));
            ArrayList contractitems = blcontractitem.search(contractitemsearch);
            JSONArray jsoncontractitems = toJSONArray(contractitems);
            result = jsoncontractitems.toJSONString();
        }
        catch(ParseException e) {
            result = "";
        }
        catch(DBException e) {
            result = "";
        }
        return result;
    }

    //@WebMethod(operationName = "getContractitem")
    @Override
    public String getContractitem(String json) {
        BLcontractitem blcontractitem = new BLcontractitem();
        JSONParser parser = new JSONParser();
        String result = "";
        Contractitem contractitem;
        try {
            ContractitemPK contractitemPK = JSONContractitem.toContractitemPK((JSONObject)parser.parse(json));
            contractitem = blcontractitem.getContractitem(contractitemPK);
            if(contractitem!=null) {
                result = JSONContractitem.toJSON(contractitem).toJSONString();
            }
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
        return result;
    }

    //@WebMethod(operationName = "insertContractitem")
    @Override
    public void insertContractitem(String json) {
        BLcontractitem blcontractitem = new BLcontractitem();
        JSONParser parser = new JSONParser();
        try {
            IContractitem contractitem = JSONContractitem.toContractitem((JSONObject)parser.parse(json));
            blcontractitem.insertContractitem(contractitem);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "updateContractitem")
    @Override
    public void updateContractitem(String json) {
        BLcontractitem blcontractitem = new BLcontractitem();
        JSONParser parser = new JSONParser();
        try {
            IContractitem contractitem = JSONContractitem.toContractitem((JSONObject)parser.parse(json));
            blcontractitem.updateContractitem(contractitem);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "deleteContractitem")
    @Override
    public void deleteContractitem(String json) {
        BLcontractitem blcontractitem = new BLcontractitem();
        JSONParser parser = new JSONParser();
        try {
            IContractitem contractitem = JSONContractitem.toContractitem((JSONObject)parser.parse(json));
            blcontractitem.deleteContractitem(contractitem);
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "getContractitems4evetype")
    @Override
    public String getContractitems4evetype(String json) {
        BLcontractitem blcontractitem = new BLcontractitem();
        JSONParser parser = new JSONParser();
        Contractitem contractitem;
        try {
            IEvetypePK evetypePK = JSONEvetype.toEvetypePK((JSONObject)parser.parse(json));
            ArrayList contractitems = blcontractitem.getContractitems4evetype(evetypePK);
            JSONArray jsoncontractitems = toJSONArray(contractitems);
            return jsoncontractitems.toJSONString();
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
        BLcontractitem blcontractitem = new BLcontractitem();
        JSONParser parser = new JSONParser();
        Contractitem contractitem;
        try {
            IEvetypePK evetypePK = JSONEvetype.toEvetypePK((JSONObject)parser.parse(json));
            blcontractitem.delete4evetype(evetypePK);
        }
        catch(ParseException e) {
        }
    }

    //@WebMethod(operationName = "getContractitems4contract")
    @Override
    public String getContractitems4contract(String json) {
        BLcontractitem blcontractitem = new BLcontractitem();
        JSONParser parser = new JSONParser();
        Contractitem contractitem;
        try {
            IContractPK contractPK = JSONContract.toContractPK((JSONObject)parser.parse(json));
            ArrayList contractitems = blcontractitem.getContractitems4contract(contractPK);
            JSONArray jsoncontractitems = toJSONArray(contractitems);
            return jsoncontractitems.toJSONString();
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

    //@WebMethod(operationName = "delete4contract")
    @Override
    public void delete4contract(String json) {
        BLcontractitem blcontractitem = new BLcontractitem();
        JSONParser parser = new JSONParser();
        Contractitem contractitem;
        try {
            IContractPK contractPK = JSONContract.toContractPK((JSONObject)parser.parse(json));
            blcontractitem.delete4contract(contractPK);
        }
        catch(ParseException e) {
        }
    }


}

