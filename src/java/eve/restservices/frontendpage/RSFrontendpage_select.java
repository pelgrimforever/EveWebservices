/*
 * Generated on 13.6.2022 18:20
 */

package eve.restservices.frontendpage;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.usecases.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.searchentity.IFrontendpagesearch;
import eve.interfaces.servlet.IFrontendpageOperation;
import eve.logicentity.Frontendpage;
import eve.searchentity.Frontendpagesearch;
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
@Path("rsfrontendpage_select")
public class RSFrontendpage_select extends RS_json_login {

    private Security_usecases security_usecases = new Security_usecases();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Frontendpage_usecases frontendpageusecases = new Frontendpage_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IFrontendpageOperation.SELECT_COUNT:
                    result = count_records(frontendpageusecases);
                    break;
                case IFrontendpageOperation.SELECT_ALL:
                    result = get_all_frontendpage(frontendpageusecases);
                    break;
                case IFrontendpageOperation.SELECT_FRONTENDPAGE:
                    result = get_frontendpage_with_primarykey(frontendpageusecases, json);
                    break;
                case IFrontendpageOperation.SELECT_Frontendpage_auth:
                    result = get_frontendpage_with_externalforeignkey_frontendpage_auth(frontendpageusecases, json);
                    break;
                case IFrontendpageOperation.SELECT_SEARCH:
                    result = search_frontendpage(frontendpageusecases, json);
                    break;
                case IFrontendpageOperation.SELECT_SEARCHCOUNT:
                    result = search_frontendpage_count(frontendpageusecases, json);
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

    private String count_records(Frontendpage_usecases frontendpageusecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", frontendpageusecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_frontendpage(Frontendpage_usecases frontendpageusecases) throws ParseException, CustomException {
    	return JSONFrontendpage.toJSONArray(frontendpageusecases.get_all()).toJSONString();
    }
    
    private String get_frontendpage_with_primarykey(Frontendpage_usecases frontendpageusecases, JSONObject json) throws ParseException, CustomException {
        IFrontendpagePK frontendpagePK = (IFrontendpagePK)JSONFrontendpage.toFrontendpagePK((JSONObject)json.get("frontendpagepk"));
	return JSONFrontendpage.toJSON(frontendpageusecases.get_frontendpage_by_primarykey(frontendpagePK)).toJSONString();
    }
    
    private String get_frontendpage_with_externalforeignkey_frontendpage_auth(Frontendpage_usecases frontendpageusecases, JSONObject json) throws ParseException, CustomException {
        IFrontendpage_authPK frontendpage_authPK = (IFrontendpage_authPK)JSONFrontendpage_auth.toFrontendpage_authPK((JSONObject)json.get("frontendpage_authpk"));
        return JSONFrontendpage.toJSON(frontendpageusecases.get_frontendpage_with_externalforeignkey_frontendpage_auth(frontendpage_authPK)).toJSONString();
    }
    
    private String search_frontendpage(Frontendpage_usecases frontendpageusecases, JSONObject json) throws ParseException, CustomException {
        IFrontendpagesearch search = (IFrontendpagesearch)JSONFrontendpage.toFrontendpagesearch((JSONObject)json.get("search"));
        return JSONFrontendpage.toJSONArray(frontendpageusecases.search_frontendpage(search)).toJSONString();
    }
    
    private String search_frontendpage_count(Frontendpage_usecases frontendpageusecases, JSONObject json) throws ParseException, CustomException {
        IFrontendpagesearch frontendpagesearch = (IFrontendpagesearch)JSONFrontendpage.toFrontendpagesearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", frontendpageusecases.search_frontendpage_count(frontendpagesearch));
        return jsonsearchcount.toJSONString();
    }
}

