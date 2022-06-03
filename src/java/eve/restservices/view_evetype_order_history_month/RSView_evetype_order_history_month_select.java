/*
 * Generated on 20.4.2022 10:3
 */

package eve.restservices.view_evetype_order_history_month;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import eve.BusinessObject.Logic.*;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.interfaces.logicview.IView_evetype_order_history_month;
import eve.interfaces.servlet.IView_evetype_order_history_monthOperation;
import eve.usecases.View_evetype_order_history_month_usecases;
import eve.logicview.View_evetype_order_history_month;
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
@Path("rsview_evetype_order_history_month_select")
public class RSView_evetype_order_history_month_select extends RS_json_login {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(Security_usecases.check_authorization(authorisationstring));
            IView_evetype_order_history_month view_evetype_order_history_month;
            View_evetype_order_history_month_usecases view_evetype_order_history_monthusecases = new View_evetype_order_history_month_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IView_evetype_order_history_monthOperation.SELECT_ALL:
                    result = get_all_view_evetype_order_history_month(view_evetype_order_history_monthusecases);
                    break;
//Custom code, do not change this line
//add here custom operations
                case IView_evetype_order_history_monthOperation.SELECT_EVETYPE:
                    result = getView_evetype_order_history_months_for_evetype(view_evetype_order_history_monthusecases, json);
                    break;
                case IView_evetype_order_history_monthOperation.SELECT_EVETYPEYM:
                    
                    result = getView_evetype_order_history_monthsYM_for_evetype(view_evetype_order_history_monthusecases, json);
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
    private String getView_evetype_order_history_months_for_evetype(View_evetype_order_history_month_usecases view_evetype_order_history_monthinteractor, JSONObject json) throws ParseException, CustomException {
        EvetypePK evetypePK = (EvetypePK)JSONEvetype.toEvetypePK((JSONObject)json.get("evetypepk"));
    	return JSONView_evetype_order_history_month.toJSONArray(view_evetype_order_history_monthinteractor.getView_evetype_order_history_months_for_evetype_usecase(evetypePK)).toJSONString();
    }

    private String getView_evetype_order_history_monthsYM_for_evetype(View_evetype_order_history_month_usecases view_evetype_order_history_monthinteractor, JSONObject json) throws ParseException, CustomException {
        EvetypePK evetypePKym = (EvetypePK)JSONEvetype.toEvetypePK((JSONObject)json.get("evetypepk"));
    	return JSONView_evetype_order_history_month.toJSONArray(view_evetype_order_history_monthinteractor.getView_evetype_order_history_monthsYM_for_evetype_usecase(evetypePKym)).toJSONString();
    }
//Custom code, do not change this line   

    private String get_all_view_evetype_order_history_month(View_evetype_order_history_month_usecases view_evetype_order_history_monthusecases) throws ParseException, CustomException {
    	return JSONView_evetype_order_history_month.toJSONArray(view_evetype_order_history_monthusecases.get_all()).toJSONString();
    }
}

