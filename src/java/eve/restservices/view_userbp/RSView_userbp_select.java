/*
 * Generated on 20.4.2022 10:3
 */

package eve.restservices.view_userbp;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import eve.BusinessObject.Logic.*;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.interfaces.logicview.IView_userbp;
import eve.interfaces.servlet.IView_userbpOperation;
import eve.usecases.View_userbp_usecases;
import eve.logicview.View_userbp;
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
@Path("rsview_userbp_select")
public class RSView_userbp_select extends RS_json_login {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(Security_usecases.check_authorization(authorisationstring));
            IView_userbp view_userbp;
            View_userbp_usecases view_userbpusecases = new View_userbp_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IView_userbpOperation.SELECT_ALL:
                    result = get_all_view_userbp(view_userbpusecases);
                    break;
//Custom code, do not change this line
//add here custom operations
                case IView_userbpOperation.SELECT4USER:
                    result = getView_userbps_for_user(view_userbpusecases, json);
                    break;
                case IView_userbpOperation.SELECT4USERBP:
                    result = getView_userbps_for_user_blueprint(view_userbpusecases, json);
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
    private String getView_userbps_for_user(View_userbp_usecases view_userbpinteractor, JSONObject json) throws ParseException, CustomException {
        String username = JSONConversion.getString(json, "username");
    	return JSONView_userbp.toJSONArray(view_userbpinteractor.getView_userbps_for_user_usecase(username)).toJSONString();
    }

    private String getView_userbps_for_user_blueprint(View_userbp_usecases view_userbpinteractor, JSONObject json) throws ParseException, CustomException {
        String username = JSONConversion.getString(json, "username");
        long bp = JSONConversion.getlong(json, "bp");
    	return JSONView_userbp.toJSONArray(view_userbpinteractor.getView_userbps_for_user_blueprint_usecase(username, bp)).toJSONString();
    }
//Custom code, do not change this line   

    private String get_all_view_userbp(View_userbp_usecases view_userbpusecases) throws ParseException, CustomException {
    	return JSONView_userbp.toJSONArray(view_userbpusecases.get_all()).toJSONString();
    }
}

