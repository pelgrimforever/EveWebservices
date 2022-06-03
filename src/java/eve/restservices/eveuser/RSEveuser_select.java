/*
 * Generated on 20.4.2022 10:3
 */

package eve.restservices.eveuser;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.usecases.Eveuser_usecases;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.searchentity.IEveusersearch;
import eve.interfaces.servlet.IEveuserOperation;
import eve.logicentity.Eveuser;
import eve.searchentity.Eveusersearch;
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
@Path("rseveuser_select")
public class RSEveuser_select extends RS_json_login {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(Security_usecases.check_authorization(authorisationstring));
            IEveuserPK eveuserPK;
            IEveuser eveuser;
            Eveuser_usecases eveuserusecases = new Eveuser_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
            //Select is allowed for all, anything else needs USERS authorization
            String username = Security_usecases.getUsername(super.authorisationstring);
            eve.BusinessObject.Logic.BLfrontendpage_auth blfrontendpage_auth = new eve.BusinessObject.Logic.BLfrontendpage_auth();
            blfrontendpage_auth.setAuthenticated(true);
            loggedin = loggedin && blfrontendpage_auth.checkAuth(username, eve.BusinessObject.Logic.BLfrontendpage.USERS);
            eveuserusecases = new Eveuser_usecases(loggedin);
//Custom code, do not change this line   
            switch(operation) {
                case IEveuserOperation.SELECT_COUNT:
                    result = count_records(eveuserusecases);
                    break;
                case IEveuserOperation.SELECT_ALL:
                    result = get_all_eveuser(eveuserusecases);
                    break;
                case IEveuserOperation.SELECT_EVEUSER:
                    result = get_eveuser_with_primarykey(eveuserusecases, json);
                    break;
                case IEveuserOperation.SELECT_Frontendpage_auth:
                    result = get_eveuser_with_externalforeignkey_frontendpage_auth(eveuserusecases, json);
                    break;
                case IEveuserOperation.SELECT_SEARCH:
                    result = search_eveuser(eveuserusecases, json);
                    break;
                case IEveuserOperation.SELECT_SEARCHCOUNT:
                    result = search_eveuser_count(eveuserusecases, json);
                    break;
//Custom code, do not change this line
//add here custom operations
                case IEveuserOperation.SELECT_ISADMIN:
                    boolean isadmin = Security_usecases.isadmin(super.authorisationstring);
                    break;
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

    private String count_records(Eveuser_usecases eveuserusecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", eveuserusecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_eveuser(Eveuser_usecases eveuserusecases) throws ParseException, CustomException {
    	return JSONEveuser.toJSONArray(eveuserusecases.get_all()).toJSONString();
    }
    
    private String get_eveuser_with_primarykey(Eveuser_usecases eveuserusecases, JSONObject json) throws ParseException, CustomException {
        IEveuserPK eveuserPK = (IEveuserPK)JSONEveuser.toEveuserPK((JSONObject)json.get("eveuserpk"));
	return JSONEveuser.toJSON(eveuserusecases.get_eveuser_by_primarykey(eveuserPK)).toJSONString();
    }
    
    private String get_eveuser_with_externalforeignkey_frontendpage_auth(Eveuser_usecases eveuserusecases, JSONObject json) throws ParseException, CustomException {
        IFrontendpage_authPK frontendpage_authPK = (IFrontendpage_authPK)JSONFrontendpage_auth.toFrontendpage_authPK((JSONObject)json.get("frontendpage_authpk"));
        return JSONEveuser.toJSON(eveuserusecases.get_eveuser_with_externalforeignkey_frontendpage_auth(frontendpage_authPK)).toJSONString();
    }
    
    private String search_eveuser(Eveuser_usecases eveuserusecases, JSONObject json) throws ParseException, CustomException {
        IEveusersearch search = (IEveusersearch)JSONEveuser.toEveusersearch((JSONObject)json.get("search"));
        return JSONEveuser.toJSONArray(eveuserusecases.search_eveuser(search)).toJSONString();
    }
    
    private String search_eveuser_count(Eveuser_usecases eveuserusecases, JSONObject json) throws ParseException, CustomException {
        IEveusersearch eveusersearch = (IEveusersearch)JSONEveuser.toEveusersearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", eveuserusecases.search_eveuser_count(eveusersearch));
        return jsonsearchcount.toJSONString();
    }
}

