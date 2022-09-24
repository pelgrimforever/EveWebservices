/*
 * Generated on 23.8.2022 14:38
 * @author Franky Laseure
 */

package eve.restservices.frontendpage_auth;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.usecases.*;
import eve.usecases.custom.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.searchentity.IFrontendpage_authsearch;
import eve.interfaces.servlet.IFrontendpage_authOperation;
import eve.logicentity.Frontendpage_auth;
import eve.searchentity.Frontendpage_authsearch;
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

@Path("rsfrontendpage_auth_delete")
public class RSFrontendpage_auth_delete extends RS_json_login {

    private Security_usecases security_usecases = new Security_usecases();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Frontendpage_auth_usecases frontendpage_authusecases = new Frontendpage_auth_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IFrontendpage_authOperation.DELETE_FRONTENDPAGE_AUTH:
                    delete_frontendpage_auth(frontendpage_authusecases, json);
                    break;
                case IFrontendpage_authOperation.DELETE_Frontendpage:
                    delete_frontendpage_auth(frontendpage_authusecases, json);
                    break;
                case IFrontendpage_authOperation.DELETE_Eveuser:
                    delete_frontendpage_auth(frontendpage_authusecases, json);
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

    private void delete_frontendpage_auth(Frontendpage_auth_usecases frontendpage_authusecases, JSONObject json) throws ParseException, CustomException {
        IFrontendpage_auth frontendpage_auth = (IFrontendpage_auth)JSONFrontendpage_auth.toFrontendpage_auth((JSONObject)json.get("frontendpage_auth"));
        frontendpage_authusecases.deleteFrontendpage_auth(frontendpage_auth);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Frontendpage(Frontendpage_auth_usecases frontendpage_authusecases, JSONObject json) throws ParseException, CustomException {
        IFrontendpagePK frontendpagePK = (IFrontendpagePK)JSONFrontendpage.toFrontendpagePK((JSONObject)json.get("frontendpagepk"));
        frontendpage_authusecases.delete_all_containing_Frontendpage(frontendpagePK);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Eveuser(Frontendpage_auth_usecases frontendpage_authusecases, JSONObject json) throws ParseException, CustomException {
        IEveuserPK eveuserPK = (IEveuserPK)JSONEveuser.toEveuserPK((JSONObject)json.get("eveuserpk"));
        frontendpage_authusecases.delete_all_containing_Eveuser(eveuserPK);
        setReturnstatus("OK");
    }

}

