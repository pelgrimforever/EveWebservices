/*
 * RSContract.java
 *
 * Generated on 14.0.2022 16:56
 *
 */

package eve.restservices;

import base.servlets.Securitycheck;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import eve.BusinessObject.Logic.*;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.searchentity.IContractsearch;
import eve.interfaces.servlet.IContractOperation;
import eve.logicentity.Contract;
import eve.searchentity.Contractsearch;
import eve.servlets.DataServlet;
import general.exception.CustomException;
import general.exception.DataException;
import general.exception.DBException;
import java.sql.Date;
import java.sql.Time;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * REST Web Service
 *
 * @author Franky Laseure
 */
@Path("rscontract")
public class RSContract {

    /**
     * Creates a new instance of HelloWorld
     */
    public RSContract() {
    }

    /**
     * Retrieves representation of an instance of contract.restservices.RSContract
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{json}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@PathParam("json") String jsonstring) {
        try {
            BLcontract blcontract = new BLcontract();
            ArrayList contracts = blcontract.getAll();
            JSONArray jsoncontracts = JSONContract.toJSONArray(contracts);
            return jsoncontracts.toJSONString();
        }
        catch(DBException e) {
            return "{ \"status\": \"error\"}";
        }
    }

    /**
     * Retrieves representation of an instance of contract.restservices.RSContract
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        String result = "";
        BLcontract blcontract = new BLcontract();
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject)parser.parse(jsonstring);
            JSONObject jsonoperation = (JSONObject)json.get("operation");
            byte operationtype = JSONConversion.getbyte(jsonoperation, "type");
            byte operation = JSONConversion.getbyte(jsonoperation, "operation");
            IContractPK contractPK;
            IContract contract;
//Security parameters
            boolean loggedin = RSsecurity.check(json);
            blcontract.setAuthenticated(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    switch(operation) {
                        case IContractOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blcontract.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IContractOperation.SELECT_ALL:
                            result = JSONContract.toJSONArray(blcontract.getContracts()).toJSONString();
                            break;
                        case IContractOperation.SELECT_CONTRACT:
                            contractPK = (IContractPK)JSONContract.toContractPK((JSONObject)json.get("contractpk"));
                            result = JSONContract.toJSON(blcontract.getContract(contractPK)).toJSONString();
                            break;
                        case IContractOperation.SELECT_SEARCH:
                            IContractsearch search = (IContractsearch)JSONContract.toContractsearch((JSONObject)json.get("search"));
                            result = JSONContract.toJSONArray(blcontract.search(search)).toJSONString();
                            break;
                        case IContractOperation.SELECT_SEARCHCOUNT:
                            IContractsearch contractsearch = (IContractsearch)JSONContract.toContractsearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blcontract.searchcount(contractsearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(operation) {
                        case IContractOperation.INSERT_CONTRACT:
                            contract = (IContract)JSONContract.toContract((JSONObject)json.get("contract"));
                            blcontract.insertContract(contract);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(operation) {
                        case IContractOperation.UPDATE_CONTRACT:
                            JSONObject jsoncontract = (JSONObject)json.get("contract");
                            contractPK = JSONContract.toContractPK((JSONObject)jsoncontract.get("PK"));
                            contract = blcontract.getContract(contractPK);
                            JSONContract.updateContract(contract, jsoncontract);
                            blcontract.updateContract(contract);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(operation) {
                        case IContractOperation.DELETE_CONTRACT:
                            contract = (IContract)JSONContract.toContract((JSONObject)json.get("contract"));
                            blcontract.deleteContract(contract);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECURESELECT:
                    switch(operation) {
                        case IContractOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blcontract.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IContractOperation.SELECT_ALL:
                            result = JSONContract.toJSONArray(blcontract.getContracts()).toJSONString();
                            break;
                        case IContractOperation.SELECT_CONTRACT:
                            contractPK = (IContractPK)JSONContract.toContractPK((JSONObject)json.get("contractpk"));
                            result = JSONContract.toJSON(blcontract.getContract(contractPK)).toJSONString();
                            break;
                        case IContractOperation.SELECT_SEARCH:
                            IContractsearch search = (IContractsearch)JSONContract.toContractsearch((JSONObject)json.get("search"));
                            result = JSONContract.toJSONArray(blcontract.search(search)).toJSONString();
                            break;
                        case IContractOperation.SELECT_SEARCHCOUNT:
                            IContractsearch contractsearch = (IContractsearch)JSONContract.toContractsearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blcontract.searchcount(contractsearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREINSERT:
                    switch(operation) {
                        case IContractOperation.INSERT_CONTRACT:
                            contract = (IContract)JSONContract.toContract((JSONObject)json.get("contract"));
                            blcontract.secureinsertContract(contract);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREUPDATE:
                    switch(operation) {
                        case IContractOperation.UPDATE_CONTRACT:
                            JSONObject jsoncontract = (JSONObject)json.get("contract");
                            contractPK = JSONContract.toContractPK((JSONObject)jsoncontract.get("PK"));
                            contract = blcontract.getContract(contractPK);
                            JSONContract.updateContract(contract, jsoncontract);
                            blcontract.secureupdateContract(contract);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREDELETE:
                    switch(operation) {
                        case IContractOperation.DELETE_CONTRACT:
                            contract = (IContract)JSONContract.toContract((JSONObject)json.get("contract"));
                            blcontract.securedeleteContract(contract);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
            }
        }
        catch(ParseException e) {
            result = returnstatus(e.getMessage());
        }
        catch(CustomException e) {
            result = returnstatus(e.getMessage());
        }
        return result;
    }

    private String returnstatus(String status) {
        JSONObject json = new JSONObject();
        json.put("status", status);
        return json.toJSONString();
    }

    /**
     * PUT method for updating or creating an instance of RSContract
     * @param content representation for the resource
     */
    @PUT
    @Consumes("text/html")
    public void put(String content) {
    }
}

