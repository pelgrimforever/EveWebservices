/*
 * WSContractitem.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 13.6.2022 18:20
 *
 */

package eve.webservices;

import base.restservices.RS_json_login;
import eve.BusinessObject.Logic.*;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.searchentity.IContractitemsearch;
import eve.interfaces.webservice.WSIContractitem;
import eve.logicentity.Contractitem;
import eve.searchentity.Contractitemsearch;
import eve.usecases.*;
import general.exception.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.jws.WebMethod;
import javax.jws.WebService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import eve.usecases.custom.Security_usecases;

/**
 *
 * @author Franky Laseure
 */
@WebService(endpointInterface = "eve.interfaces.webservice.WSIContractitem")
public class WSContractitem extends RS_json_login implements WSIContractitem {

    private Security_usecases security_usecases = new Security_usecases();
    
    private JSONArray toJSONArray(ArrayList contractitems) {
        JSONArray jsoncontractitems = new JSONArray();
        Iterator contractitemsI = contractitems.iterator();
        while(contractitemsI.hasNext()) {
            jsoncontractitems.add(JSONContractitem.toJSON((Contractitem)contractitemsI.next()));
        }
        return jsoncontractitems;
    }

    //@WebMethod(operationName = "getContractitems")
    @Override
    public String getContractitems() {
        try {
            Contractitem_usecases contractitemusecases = new Contractitem_usecases(loggedin);
            return get_all_contractitem(contractitemusecases);
        }
        catch(CustomException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "search")
    @Override
    public String search(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Contractitem_usecases contractitemusecases = new Contractitem_usecases(loggedin);
            return search_contractitem(contractitemusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "getContractitem")
    @Override
    public String getContractitem(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Contractitem_usecases contractitemusecases = new Contractitem_usecases(loggedin);
            return get_contractitem_with_primarykey(contractitemusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "insertContractitem")
    @Override
    public void insertContractitem(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Contractitem_usecases contractitemusecases = new Contractitem_usecases(loggedin);
            insert_contractitem(contractitemusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "updateContractitem")
    @Override
    public void updateContractitem(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Contractitem_usecases contractitemusecases = new Contractitem_usecases(loggedin);
            update_contractitem(contractitemusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "deleteContractitem")
    @Override
    public void deleteContractitem(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Contractitem_usecases contractitemusecases = new Contractitem_usecases(loggedin);
            delete_contractitem(contractitemusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getContractitems4evetype")
    @Override
    public String getContractitems4evetype(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Contractitem_usecases contractitemusecases = new Contractitem_usecases(loggedin);
            return get_contractitem_with_foreignkey_evetype(contractitemusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "delete4evetype")
    @Override
    public void delete4evetype(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Contractitem_usecases contractitemusecases = new Contractitem_usecases(loggedin);
            delete_contractitem(contractitemusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getContractitems4contract")
    @Override
    public String getContractitems4contract(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Contractitem_usecases contractitemusecases = new Contractitem_usecases(loggedin);
            return get_contractitem_with_foreignkey_contract(contractitemusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "delete4contract")
    @Override
    public void delete4contract(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Contractitem_usecases contractitemusecases = new Contractitem_usecases(loggedin);
            delete_contractitem(contractitemusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }


    private String count_records(Contractitem_usecases contractitemusecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", contractitemusecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_contractitem(Contractitem_usecases contractitemusecases) throws ParseException, CustomException {
    	return JSONContractitem.toJSONArray(contractitemusecases.get_all()).toJSONString();
    }
    
    private String get_contractitem_with_primarykey(Contractitem_usecases contractitemusecases, JSONObject json) throws ParseException, CustomException {
        IContractitemPK contractitemPK = (IContractitemPK)JSONContractitem.toContractitemPK((JSONObject)json.get("contractitempk"));
	return JSONContractitem.toJSON(contractitemusecases.get_contractitem_by_primarykey(contractitemPK)).toJSONString();
    }
    
    private String get_contractitem_with_foreignkey_evetype(Contractitem_usecases contractitemusecases, JSONObject json) throws ParseException, CustomException {
        IEvetypePK evetypePK = (IEvetypePK)JSONEvetype.toEvetypePK((JSONObject)json.get("evetypepk"));
        return JSONContractitem.toJSONArray(contractitemusecases.get_contractitem_with_foreignkey_evetype(evetypePK)).toJSONString();
    }
    
    private String get_contractitem_with_foreignkey_contract(Contractitem_usecases contractitemusecases, JSONObject json) throws ParseException, CustomException {
        IContractPK contractPK = (IContractPK)JSONContract.toContractPK((JSONObject)json.get("contractpk"));
        return JSONContractitem.toJSONArray(contractitemusecases.get_contractitem_with_foreignkey_contract(contractPK)).toJSONString();
    }
    
    private String search_contractitem(Contractitem_usecases contractitemusecases, JSONObject json) throws ParseException, CustomException {
        IContractitemsearch search = (IContractitemsearch)JSONContractitem.toContractitemsearch((JSONObject)json.get("search"));
        return JSONContractitem.toJSONArray(contractitemusecases.search_contractitem(search)).toJSONString();
    }
    
    private String search_contractitem_count(Contractitem_usecases contractitemusecases, JSONObject json) throws ParseException, CustomException {
        IContractitemsearch contractitemsearch = (IContractitemsearch)JSONContractitem.toContractitemsearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", contractitemusecases.search_contractitem_count(contractitemsearch));
        return jsonsearchcount.toJSONString();
    }

    private void insert_contractitem(Contractitem_usecases contractitemusecases, JSONObject json) throws ParseException, CustomException {
        IContractitem contractitem = (IContractitem)JSONContractitem.toContractitem((JSONObject)json.get("contractitem"));
        contractitemusecases.insertContractitem(contractitem);
        setReturnstatus("OK");
    }

    private void update_contractitem(Contractitem_usecases contractitemusecases, JSONObject json) throws ParseException, CustomException {
        IContractitem contractitem = (IContractitem)JSONContractitem.toContractitem((JSONObject)json.get("contractitem"));
        contractitemusecases.updateContractitem(contractitem);
        setReturnstatus("OK");
    }

    private void delete_contractitem(Contractitem_usecases contractitemusecases, JSONObject json) throws ParseException, CustomException {
        IContractitem contractitem = (IContractitem)JSONContractitem.toContractitem((JSONObject)json.get("contractitem"));
        contractitemusecases.deleteContractitem(contractitem);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Evetype(Contractitem_usecases contractitemusecases, JSONObject json) throws ParseException, CustomException {
        IEvetypePK evetypePK = (IEvetypePK)JSONEvetype.toEvetypePK((JSONObject)json.get("evetypepk"));
        contractitemusecases.delete_all_containing_Evetype(evetypePK);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Contract(Contractitem_usecases contractitemusecases, JSONObject json) throws ParseException, CustomException {
        IContractPK contractPK = (IContractPK)JSONContract.toContractPK((JSONObject)json.get("contractpk"));
        contractitemusecases.delete_all_containing_Contract(contractPK);
        setReturnstatus("OK");
    }

}

