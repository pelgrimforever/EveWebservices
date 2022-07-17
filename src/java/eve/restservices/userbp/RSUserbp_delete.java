/*
 * Generated on 17.6.2022 13:4
 */

package eve.restservices.userbp;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.usecases.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.searchentity.IUserbpsearch;
import eve.interfaces.servlet.IUserbpOperation;
import eve.logicentity.Userbp;
import eve.searchentity.Userbpsearch;
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
@Path("rsuserbp_delete")
public class RSUserbp_delete extends RS_json_login {

    private Security_usecases security_usecases = new Security_usecases();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Userbp_usecases userbpusecases = new Userbp_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IUserbpOperation.DELETE_USERBP:
                    delete_userbp(userbpusecases, json);
                    break;
                case IUserbpOperation.DELETE_Evetype:
                    delete_userbp(userbpusecases, json);
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

    private void delete_userbp(Userbp_usecases userbpusecases, JSONObject json) throws ParseException, CustomException {
        IUserbp userbp = (IUserbp)JSONUserbp.toUserbp((JSONObject)json.get("userbp"));
        userbpusecases.deleteUserbp(userbp);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Evetype(Userbp_usecases userbpusecases, JSONObject json) throws ParseException, CustomException {
        IEvetypePK evetypePK = (IEvetypePK)JSONEvetype.toEvetypePK((JSONObject)json.get("evetypepk"));
        userbpusecases.delete_all_containing_Evetype(evetypePK);
        setReturnstatus("OK");
    }

}

