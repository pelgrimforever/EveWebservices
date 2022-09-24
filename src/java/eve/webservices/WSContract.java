/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 23.8.2022 14:38
 * @author Franky Laseure
 */

package eve.webservices;

import base.restservices.RS_json_login;
import eve.BusinessObject.Logic.*;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.searchentity.IContractsearch;
import eve.interfaces.webservice.WSIContract;
import eve.logicentity.Contract;
import eve.searchentity.Contractsearch;
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

@WebService(endpointInterface = "eve.interfaces.webservice.WSIContract")
public class WSContract extends RS_json_login implements WSIContract {

    private Security_usecases security_usecases = new Security_usecases();
    
    private JSONArray toJSONArray(ArrayList contracts) {
        JSONArray jsoncontracts = new JSONArray();
        Iterator contractsI = contracts.iterator();
        while(contractsI.hasNext()) {
            jsoncontracts.add(JSONContract.toJSON((Contract)contractsI.next()));
        }
        return jsoncontracts;
    }

    //@WebMethod(operationName = "getContracts")
    @Override
    public String getContracts() {
        try {
            Contract_usecases contractusecases = new Contract_usecases(loggedin);
            return get_all_contract(contractusecases);
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
            Contract_usecases contractusecases = new Contract_usecases(loggedin);
            return search_contract(contractusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "getContract")
    @Override
    public String getContract(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Contract_usecases contractusecases = new Contract_usecases(loggedin);
            return get_contract_with_primarykey(contractusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "insertContract")
    @Override
    public void insertContract(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Contract_usecases contractusecases = new Contract_usecases(loggedin);
            insert_contract(contractusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "updateContract")
    @Override
    public void updateContract(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Contract_usecases contractusecases = new Contract_usecases(loggedin);
            update_contract(contractusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "deleteContract")
    @Override
    public void deleteContract(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Contract_usecases contractusecases = new Contract_usecases(loggedin);
            delete_contract(contractusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }


    private String count_records(Contract_usecases contractusecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", contractusecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_contract(Contract_usecases contractusecases) throws ParseException, CustomException {
    	return JSONContract.toJSONArray(contractusecases.get_all()).toJSONString();
    }
    
    private String get_contract_with_primarykey(Contract_usecases contractusecases, JSONObject json) throws ParseException, CustomException {
        IContractPK contractPK = (IContractPK)JSONContract.toContractPK((JSONObject)json.get("contractpk"));
	return JSONContract.toJSON(contractusecases.get_contract_by_primarykey(contractPK)).toJSONString();
    }
    
    private String search_contract(Contract_usecases contractusecases, JSONObject json) throws ParseException, CustomException {
        IContractsearch search = (IContractsearch)JSONContract.toContractsearch((JSONObject)json.get("search"));
        return JSONContract.toJSONArray(contractusecases.search_contract(search)).toJSONString();
    }
    
    private String search_contract_count(Contract_usecases contractusecases, JSONObject json) throws ParseException, CustomException {
        IContractsearch contractsearch = (IContractsearch)JSONContract.toContractsearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", contractusecases.search_contract_count(contractsearch));
        return jsonsearchcount.toJSONString();
    }

    private void insert_contract(Contract_usecases contractusecases, JSONObject json) throws ParseException, CustomException {
        IContract contract = (IContract)JSONContract.toContract((JSONObject)json.get("contract"));
        contractusecases.insertContract(contract);
        setReturnstatus("OK");
    }

    private void update_contract(Contract_usecases contractusecases, JSONObject json) throws ParseException, CustomException {
        IContract contract = (IContract)JSONContract.toContract((JSONObject)json.get("contract"));
        contractusecases.updateContract(contract);
        setReturnstatus("OK");
    }

    private void delete_contract(Contract_usecases contractusecases, JSONObject json) throws ParseException, CustomException {
        IContract contract = (IContract)JSONContract.toContract((JSONObject)json.get("contract"));
        contractusecases.deleteContract(contract);
        setReturnstatus("OK");
    }

}

