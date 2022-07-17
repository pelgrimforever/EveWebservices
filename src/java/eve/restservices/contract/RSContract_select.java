/*
 * Generated on 17.6.2022 13:4
 */

package eve.restservices.contract;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.usecases.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.searchentity.IContractsearch;
import eve.interfaces.servlet.IContractOperation;
import eve.logicentity.Contract;
import eve.searchentity.Contractsearch;
import eve.servlets.DataServlet;
import eve.usecases.custom.*;
import general.exception.*;
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
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
@Path("rscontract_select")
public class RSContract_select extends RS_json_login {

    private Security_usecases security_usecases = new Security_usecases();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Contract_usecases contractusecases = new Contract_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IContractOperation.SELECT_COUNT:
                    result = count_records(contractusecases);
                    break;
                case IContractOperation.SELECT_ALL:
                    result = get_all_contract(contractusecases);
                    break;
                case IContractOperation.SELECT_CONTRACT:
                    result = get_contract_with_primarykey(contractusecases, json);
                    break;
                case IContractOperation.SELECT_SEARCH:
                    result = search_contract(contractusecases, json);
                    break;
                case IContractOperation.SELECT_SEARCHCOUNT:
                    result = search_contract_count(contractusecases, json);
                    break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            }
        }
        catch(ParseException | CustomException | IOException e) {
            setReturnstatus(e.getMessage());
        }
        return result;
    }

//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   

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
}

