/*
 * Generated on 13.4.2022 19:13
 */

package eve.restservices.eveuser;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.usecases.*;
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
@Path("rseveuser_update")
public class RSEveuser_update extends RS_json_login {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(Security_usecases.check_authorization(authorisationstring));
            Eveuser_usecases eveuserusecases = new Eveuser_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
            Frontendpage_auth_usecases frontendpage_auth_usecases = new Frontendpage_auth_usecases(loggedin);
            loggedin = loggedin && frontendpage_auth_usecases.check_userauthorisation_for_page(authorisationstring, eve.BusinessObject.Logic.BLfrontendpage.USERS);
            eveuserusecases = new Eveuser_usecases(loggedin);
//Custom code, do not change this line   
            switch(operation) {
                case IEveuserOperation.UPDATE_EVEUSER:
                    update_eveuser(eveuserusecases, json);
                    break;
//Custom code, do not change this line
//add here custom operations
            case IEveuserOperation.UPDATE_EVEUSERPASS:
                update_password(eveuserusecases, json);
                break;
            case IEveuserOperation.UPDATE_EVEUSERRESET:
                reset_eveuser(eveuserusecases, json);
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
    private void update_password(Eveuser_usecases eveuserusecases, JSONObject json) throws ParseException, CustomException, IOException {
        String newauth = JSONConversion.getString(json, "newauth");
        String resultmessage = eveuserusecases.update_password(authorisationstring, newauth);
        setReturnstatus(resultmessage);
    }

    private void reset_eveuser(Eveuser_usecases eveuserusecases, JSONObject json) throws ParseException, CustomException, IOException {
        IEveuser eveuser = (IEveuser)JSONEveuser.toEveuser((JSONObject)json.get("eveuser"));
        String resultmessage = eveuserusecases.reset(authorisationstring, eveuser);
        setReturnstatus(resultmessage);
    }
//Custom code, do not change this line   

    private void update_eveuser(Eveuser_usecases eveuserusecases, JSONObject json) throws ParseException, CustomException {
        IEveuser eveuser = (IEveuser)JSONEveuser.toEveuser((JSONObject)json.get("eveuser"));
        eveuserusecases.secureupdateEveuser(eveuser);
        setReturnstatus("OK");
    }
}

