/*
 * Generated on 13.4.2022 19:13
 */

package eve.restservices.view_shipfitmodule;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import eve.BusinessObject.Logic.*;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.interfaces.logicview.IView_shipfitmodule;
import eve.interfaces.servlet.IView_shipfitmoduleOperation;
import eve.usecases.View_shipfitmodule_usecases;
import eve.logicview.View_shipfitmodule;
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
@Path("rsview_shipfitmodule_select")
public class RSView_shipfitmodule_select extends RS_json_login {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(Security_usecases.check_authorization(authorisationstring));
            IView_shipfitmodule view_shipfitmodule;
            View_shipfitmodule_usecases view_shipfitmoduleusecases = new View_shipfitmodule_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IView_shipfitmoduleOperation.SELECT_ALL:
                    result = get_all_view_shipfitmodule(view_shipfitmoduleusecases);
                    break;
//Custom code, do not change this line
//add here custom operations
                case IView_shipfitmoduleOperation.SELECT4Shipfit:
                    result = getview_shipfitmodules_for_shipfit_user(view_shipfitmoduleusecases, json);
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
    private String getview_shipfitmodules_for_shipfit_user(View_shipfitmodule_usecases view_shipfitmoduleinteractor, JSONObject json) throws ParseException, CustomException {
        String username = JSONConversion.getString(json, "username");
        String shipname = JSONConversion.getString(json, "shipname");
        return JSONView_shipfitmodule.toJSONArray(view_shipfitmoduleinteractor.getview_shipfitmodules_for_shipfit_user_usecase(username, shipname)).toJSONString();
    }
//Custom code, do not change this line   

    private String get_all_view_shipfitmodule(View_shipfitmodule_usecases view_shipfitmoduleusecases) throws ParseException, CustomException {
    	return JSONView_shipfitmodule.toJSONArray(view_shipfitmoduleusecases.get_all()).toJSONString();
    }
}

