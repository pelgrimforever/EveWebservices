/*
 * WSContract.java
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
import eve.interfaces.webservice.WSIContract;
import eve.logicentity.Contract;
import eve.searchentity.Contractsearch;
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
@WebService(endpointInterface = "eve.interfaces.webservice.WSIContract")
public class WSContract implements WSIContract {

    private JSONArray toJSONArray(ArrayList contracts) {
        JSONArray jsoncontracts = new JSONArray();
        Iterator contractsI = contracts.iterator();
        while(contractsI.hasNext()) {
            jsoncontracts.add(JSONContract.toJSON((Contract)contractsI.next()));
        }
        return jsoncontracts;
    }

    /**
     * Web service operation
     */
    //@WebMethod(operationName = "getContracts")
    @Override
    public String getContracts() {
        try {
            BLcontract blcontract = new BLcontract();
            ArrayList contracts = blcontract.getAll();
            JSONArray jsoncontracts = toJSONArray(contracts);
            return jsoncontracts.toJSONString();
        }
        catch(DBException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "search")
    @Override
    public String search(String json) {
        BLcontract blcontract = new BLcontract();
        JSONParser parser = new JSONParser();
        String result = "";
        Contract contract;
        try {
            Contractsearch contractsearch = JSONContract.toContractsearch((JSONObject)parser.parse(json));
            ArrayList contracts = blcontract.search(contractsearch);
            JSONArray jsoncontracts = toJSONArray(contracts);
            result = jsoncontracts.toJSONString();
        }
        catch(ParseException e) {
            result = "";
        }
        catch(DBException e) {
            result = "";
        }
        return result;
    }

    //@WebMethod(operationName = "getContract")
    @Override
    public String getContract(String json) {
        BLcontract blcontract = new BLcontract();
        JSONParser parser = new JSONParser();
        String result = "";
        Contract contract;
        try {
            ContractPK contractPK = JSONContract.toContractPK((JSONObject)parser.parse(json));
            contract = blcontract.getContract(contractPK);
            if(contract!=null) {
                result = JSONContract.toJSON(contract).toJSONString();
            }
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
        return result;
    }

    //@WebMethod(operationName = "insertContract")
    @Override
    public void insertContract(String json) {
        BLcontract blcontract = new BLcontract();
        JSONParser parser = new JSONParser();
        try {
            IContract contract = JSONContract.toContract((JSONObject)parser.parse(json));
            blcontract.insertContract(contract);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "updateContract")
    @Override
    public void updateContract(String json) {
        BLcontract blcontract = new BLcontract();
        JSONParser parser = new JSONParser();
        try {
            IContract contract = JSONContract.toContract((JSONObject)parser.parse(json));
            blcontract.updateContract(contract);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "deleteContract")
    @Override
    public void deleteContract(String json) {
        BLcontract blcontract = new BLcontract();
        JSONParser parser = new JSONParser();
        try {
            IContract contract = JSONContract.toContract((JSONObject)parser.parse(json));
            blcontract.deleteContract(contract);
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
    }


}

