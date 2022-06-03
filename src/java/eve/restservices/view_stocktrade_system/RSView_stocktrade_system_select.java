/*
 * Generated on 20.4.2022 10:3
 */

package eve.restservices.view_stocktrade_system;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import eve.BusinessObject.Logic.*;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.interfaces.logicview.IView_stocktrade_system;
import eve.interfaces.servlet.IView_stocktrade_systemOperation;
import eve.usecases.View_stocktrade_system_usecases;
import eve.logicview.View_stocktrade_system;
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
@Path("rsview_stocktrade_system_select")
public class RSView_stocktrade_system_select extends RS_json_login {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(Security_usecases.check_authorization(authorisationstring));
            IView_stocktrade_system view_stocktrade_system;
            View_stocktrade_system_usecases view_stocktrade_systemusecases = new View_stocktrade_system_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IView_stocktrade_systemOperation.SELECT_ALL:
                    result = get_all_view_stocktrade_system(view_stocktrade_systemusecases);
                    break;
//Custom code, do not change this line
//add here custom operations
                case IView_stocktrade_systemOperation.SELECT_4USER:
                    String username = JSONConversion.getString(json, "username");
                    result = getView_stocktrade_system4username(view_stocktrade_systemusecases, json);
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
    private String getView_stocktrade_system4username(View_stocktrade_system_usecases view_stocktrade_systeminteractor, JSONObject json) throws ParseException, CustomException {
        String username = JSONConversion.getString(json, "username");
    	return JSONView_stocktrade_system.toJSONArray(view_stocktrade_systeminteractor.getView_stocktrade_system4username_usecase(username)).toJSONString();
    }
//Custom code, do not change this line   

    private String get_all_view_stocktrade_system(View_stocktrade_system_usecases view_stocktrade_systemusecases) throws ParseException, CustomException {
    	return JSONView_stocktrade_system.toJSONArray(view_stocktrade_systemusecases.get_all()).toJSONString();
    }
}

