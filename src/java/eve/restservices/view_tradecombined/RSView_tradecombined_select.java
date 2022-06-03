/*
 * Generated on 20.4.2022 10:3
 */

package eve.restservices.view_tradecombined;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import eve.BusinessObject.Logic.*;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.interfaces.logicview.IView_tradecombined;
import eve.interfaces.servlet.IView_tradecombinedOperation;
import eve.usecases.View_tradecombined_usecases;
import eve.logicview.View_tradecombined;
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
@Path("rsview_tradecombined_select")
public class RSView_tradecombined_select extends RS_json_login {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(Security_usecases.check_authorization(authorisationstring));
            IView_tradecombined view_tradecombined;
            View_tradecombined_usecases view_tradecombinedusecases = new View_tradecombined_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IView_tradecombinedOperation.SELECT_ALL:
                    result = get_all_view_tradecombined(view_tradecombinedusecases);
                    break;
//Custom code, do not change this line
//add here custom operations
                case IView_tradecombinedOperation.SELECT_ALL_STARTSYSTEM:
                    result = getView_tradecombined_Startsystem(view_tradecombinedusecases, json);
                    break;
                case IView_tradecombinedOperation.SELECT4TRADECOMBINED:
                    result = getView_tradecombined_for_primarykey(view_tradecombinedusecases, json);
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
    private String getView_tradecombined_Startsystem(View_tradecombined_usecases view_tradecombinedinteractor, JSONObject json) throws ParseException, CustomException {
        eve.entity.pk.SystemPK systemPK = (eve.entity.pk.SystemPK)JSONSystem.toSystemPK((JSONObject)json.get("systempk"));
    	return JSONView_tradecombined.toJSONArray(view_tradecombinedinteractor.getView_tradecombined_Startsystem_usecase(systemPK)).toJSONString();
    }

    private String getView_tradecombined_for_primarykey(View_tradecombined_usecases view_tradecombinedinteractor, JSONObject json) throws ParseException, CustomException {
        TradecombinedPK tradecombinedPK = (TradecombinedPK)JSONTradecombined.toTradecombinedPK((JSONObject)json.get("tradecombinedpk"));
        View_tradecombined viewtradecombined = view_tradecombinedinteractor.getView_tradecombined_for_primarykey_usecase(tradecombinedPK);
        if(viewtradecombined!=null) {
            return JSONView_tradecombined.toJSON(viewtradecombined).toJSONString();
        } else {
            return "";
        }
    }
//Custom code, do not change this line   

    private String get_all_view_tradecombined(View_tradecombined_usecases view_tradecombinedusecases) throws ParseException, CustomException {
    	return JSONView_tradecombined.toJSONArray(view_tradecombinedusecases.get_all()).toJSONString();
    }
}

