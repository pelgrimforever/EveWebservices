/*
 * Generated on 17.6.2022 13:4
 */

package eve.restservices.view_materialinputavg;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import eve.BusinessObject.Logic.*;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.interfaces.logicview.IView_materialinputavg;
import eve.interfaces.servlet.IView_materialinputavgOperation;
import eve.usecases.View_materialinputavg_usecases;
import eve.logicview.View_materialinputavg;
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
@Path("rsview_materialinputavg_select")
public class RSView_materialinputavg_select extends RS_json_login {

    private Security_usecases security_usecases = new Security_usecases();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            View_materialinputavg_usecases view_materialinputavgusecases = new View_materialinputavg_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IView_materialinputavgOperation.SELECT_ALL:
                    result = get_all_view_materialinputavg(view_materialinputavgusecases);
                    break;
//Custom code, do not change this line
//add here custom operations
                case IView_materialinputavgOperation.SELECT_4USER:
                    result = getView_materialinputavgs_for_user(view_materialinputavgusecases, json);
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
    private String getView_materialinputavgs_for_user(View_materialinputavg_usecases view_materialinputavginteractor, JSONObject json) throws ParseException, CustomException {
        String username = JSONConversion.getString(json, "username");
    	return JSONView_materialinputavg.toJSONArray(view_materialinputavginteractor.getView_materialinputavgs_for_user_usecase(username)).toJSONString();
    }
//Custom code, do not change this line   

    private String get_all_view_materialinputavg(View_materialinputavg_usecases view_materialinputavgusecases) throws ParseException, CustomException {
    	return JSONView_materialinputavg.toJSONArray(view_materialinputavgusecases.get_all()).toJSONString();
    }
}

