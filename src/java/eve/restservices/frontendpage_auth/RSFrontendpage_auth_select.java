/*
 * Generated on 13.4.2022 19:13
 */

package eve.restservices.frontendpage_auth;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.usecases.Frontendpage_auth_usecases;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.searchentity.IFrontendpage_authsearch;
import eve.interfaces.servlet.IFrontendpage_authOperation;
import eve.logicentity.Frontendpage_auth;
import eve.searchentity.Frontendpage_authsearch;
import eve.servlets.DataServlet;
import eve.usecases.Security_usecases;
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
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
@Path("rsfrontendpage_auth_select")
public class RSFrontendpage_auth_select extends RS_json_login {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(Security_usecases.check_authorization(authorisationstring));
            IFrontendpage_authPK frontendpage_authPK;
            IFrontendpage_auth frontendpage_auth;
            Frontendpage_auth_usecases frontendpage_authusecases = new Frontendpage_auth_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IFrontendpage_authOperation.SELECT_COUNT:
                    result = count_records(frontendpage_authusecases);
                    break;
                case IFrontendpage_authOperation.SELECT_ALL:
                    result = get_all_frontendpage_auth(frontendpage_authusecases);
                    break;
                case IFrontendpage_authOperation.SELECT_FRONTENDPAGE_AUTH:
                    result = get_frontendpage_auth_with_primarykey(frontendpage_authusecases, json);
                    break;
                case IFrontendpage_authOperation.SELECT_Frontendpage:
                    result = get_frontendpage_auth_with_foreignkey_frontendpage(frontendpage_authusecases, json);
                    break;
                case IFrontendpage_authOperation.SELECT_Eveuser:
                    result = get_frontendpage_auth_with_foreignkey_eveuser(frontendpage_authusecases, json);
                    break;
                case IFrontendpage_authOperation.SELECT_SEARCH:
                    result = search_frontendpage_auth(frontendpage_authusecases, json);
                    break;
                case IFrontendpage_authOperation.SELECT_SEARCHCOUNT:
                    result = search_frontendpage_auth_count(frontendpage_authusecases, json);
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

    private String count_records(Frontendpage_auth_usecases frontendpage_authusecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", frontendpage_authusecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_frontendpage_auth(Frontendpage_auth_usecases frontendpage_authusecases) throws ParseException, CustomException {
    	return JSONFrontendpage_auth.toJSONArray(frontendpage_authusecases.get_all()).toJSONString();
    }
    
    private String get_frontendpage_auth_with_primarykey(Frontendpage_auth_usecases frontendpage_authusecases, JSONObject json) throws ParseException, CustomException {
        IFrontendpage_authPK frontendpage_authPK = (IFrontendpage_authPK)JSONFrontendpage_auth.toFrontendpage_authPK((JSONObject)json.get("frontendpage_authpk"));
	return JSONFrontendpage_auth.toJSON(frontendpage_authusecases.get_frontendpage_auth_by_primarykey(frontendpage_authPK)).toJSONString();
    }
    
    private String get_frontendpage_auth_with_foreignkey_frontendpage(Frontendpage_auth_usecases frontendpage_authusecases, JSONObject json) throws ParseException, CustomException {
        IFrontendpagePK frontendpagePK = (IFrontendpagePK)JSONFrontendpage.toFrontendpagePK((JSONObject)json.get("frontendpagepk"));
        return JSONFrontendpage_auth.toJSONArray(frontendpage_authusecases.get_frontendpage_auth_with_foreignkey_frontendpage(frontendpagePK)).toJSONString();
    }
    
    private String get_frontendpage_auth_with_foreignkey_eveuser(Frontendpage_auth_usecases frontendpage_authusecases, JSONObject json) throws ParseException, CustomException {
        IEveuserPK eveuserPK = (IEveuserPK)JSONEveuser.toEveuserPK((JSONObject)json.get("eveuserpk"));
        return JSONFrontendpage_auth.toJSONArray(frontendpage_authusecases.get_frontendpage_auth_with_foreignkey_eveuser(eveuserPK)).toJSONString();
    }
    
    private String search_frontendpage_auth(Frontendpage_auth_usecases frontendpage_authusecases, JSONObject json) throws ParseException, CustomException {
        IFrontendpage_authsearch search = (IFrontendpage_authsearch)JSONFrontendpage_auth.toFrontendpage_authsearch((JSONObject)json.get("search"));
        return JSONFrontendpage_auth.toJSONArray(frontendpage_authusecases.search_frontendpage_auth(search)).toJSONString();
    }
    
    private String search_frontendpage_auth_count(Frontendpage_auth_usecases frontendpage_authusecases, JSONObject json) throws ParseException, CustomException {
        IFrontendpage_authsearch frontendpage_authsearch = (IFrontendpage_authsearch)JSONFrontendpage_auth.toFrontendpage_authsearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", frontendpage_authusecases.search_frontendpage_auth_count(frontendpage_authsearch));
        return jsonsearchcount.toJSONString();
    }
}

