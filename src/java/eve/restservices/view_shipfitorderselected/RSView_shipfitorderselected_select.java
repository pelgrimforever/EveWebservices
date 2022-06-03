/*
 * Generated on 20.4.2022 10:3
 */

package eve.restservices.view_shipfitorderselected;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import eve.BusinessObject.Logic.*;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.interfaces.logicview.IView_shipfitorderselected;
import eve.interfaces.servlet.IView_shipfitorderselectedOperation;
import eve.usecases.View_shipfitorderselected_usecases;
import eve.logicview.View_shipfitorderselected;
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
@Path("rsview_shipfitorderselected_select")
public class RSView_shipfitorderselected_select extends RS_json_login {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(Security_usecases.check_authorization(authorisationstring));
            IView_shipfitorderselected view_shipfitorderselected;
            View_shipfitorderselected_usecases view_shipfitorderselectedusecases = new View_shipfitorderselected_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IView_shipfitorderselectedOperation.SELECT_ALL:
                    result = get_all_view_shipfitorderselected(view_shipfitorderselectedusecases);
                    break;
//Custom code, do not change this line
//add here custom operations
                case IView_shipfitorderselectedOperation.SELECT_4USER:
                    result = blview_shipfitorderselected_for_user(view_shipfitorderselectedusecases, json);
                    break;
                case IView_shipfitorderselectedOperation.SELECT_4USERSYSTEM:
                    result = blview_shipfitorderselected_for_user_system(view_shipfitorderselectedusecases, json);
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
    private String blview_shipfitorderselected_for_user(View_shipfitorderselected_usecases view_shipfitorderselectedinteractor, JSONObject json) throws ParseException, CustomException {
        String username = JSONConversion.getString(json, "username");
        return JSONView_shipfitorderselected.toJSONArray(view_shipfitorderselectedinteractor.blview_shipfitorderselected_for_user_usecase(username)).toJSONString();
    }

    private String blview_shipfitorderselected_for_user_system(View_shipfitorderselected_usecases view_shipfitorderselectedinteractor, JSONObject json) throws ParseException, CustomException {
        String username = JSONConversion.getString(json, "username");
        long systemid = JSONConversion.getlong(json, "systemid");
        return JSONView_shipfitorderselected.toJSONArray(view_shipfitorderselectedinteractor.blview_shipfitorderselected_for_user_system_usecase(username, systemid)).toJSONString();
    }
//Custom code, do not change this line   

    private String get_all_view_shipfitorderselected(View_shipfitorderselected_usecases view_shipfitorderselectedusecases) throws ParseException, CustomException {
    	return JSONView_shipfitorderselected.toJSONArray(view_shipfitorderselectedusecases.get_all()).toJSONString();
    }
}

