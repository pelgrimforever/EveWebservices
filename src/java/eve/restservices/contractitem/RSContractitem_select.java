/*
 * Generated on 17.6.2022 13:4
 */

package eve.restservices.contractitem;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.usecases.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.searchentity.IContractitemsearch;
import eve.interfaces.servlet.IContractitemOperation;
import eve.logicentity.Contractitem;
import eve.searchentity.Contractitemsearch;
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
@Path("rscontractitem_select")
public class RSContractitem_select extends RS_json_login {

    private Security_usecases security_usecases = new Security_usecases();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Contractitem_usecases contractitemusecases = new Contractitem_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IContractitemOperation.SELECT_COUNT:
                    result = count_records(contractitemusecases);
                    break;
                case IContractitemOperation.SELECT_ALL:
                    result = get_all_contractitem(contractitemusecases);
                    break;
                case IContractitemOperation.SELECT_CONTRACTITEM:
                    result = get_contractitem_with_primarykey(contractitemusecases, json);
                    break;
                case IContractitemOperation.SELECT_Evetype:
                    result = get_contractitem_with_foreignkey_evetype(contractitemusecases, json);
                    break;
                case IContractitemOperation.SELECT_Contract:
                    result = get_contractitem_with_foreignkey_contract(contractitemusecases, json);
                    break;
                case IContractitemOperation.SELECT_SEARCH:
                    result = search_contractitem(contractitemusecases, json);
                    break;
                case IContractitemOperation.SELECT_SEARCHCOUNT:
                    result = search_contractitem_count(contractitemusecases, json);
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
}

