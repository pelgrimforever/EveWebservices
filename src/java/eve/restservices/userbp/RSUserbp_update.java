/*
 * Generated on 13.4.2022 19:13
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
@Path("rsuserbp_update")
public class RSUserbp_update extends RS_json_login {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(Security_usecases.check_authorization(authorisationstring));
            Userbp_usecases userbpusecases = new Userbp_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IUserbpOperation.UPDATE_USERBP:
                    update_userbp(userbpusecases, json);
                    break;
//Custom code, do not change this line
//add here custom operations
                case IUserbpOperation.UPDATE_PROPERTIES:
                    update_properties(userbpusecases, json);
                    break;
                case IUserbpOperation.UPDATE_RUNBP:
                    run_blueprint(userbpusecases, json);
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
    private void update_properties(Userbp_usecases userbpusecases, JSONObject json) throws ParseException, CustomException {
        JSONObject jsonuserbpprop = (JSONObject)json.get("userbp");
        IUserbp userbp = JSONUserbp.toUserbp((JSONObject)jsonuserbpprop);
        userbpusecases.updateProperties(userbp);
        setReturnstatus("OK");
    }

    private void run_blueprint(Userbp_usecases userbpusecases, JSONObject json) throws ParseException, CustomException {
        UserbpPK userbpPK_torun = JSONUserbp.toUserbpPK((JSONObject)json.get("userbppk"));
        int amount = JSONConversion.getint(json, "amount");
        userbpusecases.run_blueprint(userbpPK_torun, amount);
        setReturnstatus("OK");
    }
//Custom code, do not change this line   

    private void update_userbp(Userbp_usecases userbpusecases, JSONObject json) throws ParseException, CustomException {
        IUserbp userbp = (IUserbp)JSONUserbp.toUserbp((JSONObject)json.get("userbp"));
        userbpusecases.secureupdateUserbp(userbp);
        setReturnstatus("OK");
    }
}

