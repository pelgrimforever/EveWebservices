/*
 * Generated on 13.4.2022 19:13
 */

package eve.restservices.view_tradesystem;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import eve.BusinessObject.Logic.*;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.interfaces.logicview.IView_tradesystem;
import eve.interfaces.servlet.IView_tradesystemOperation;
import eve.usecases.View_tradesystem_usecases;
import eve.logicview.View_tradesystem;
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
@Path("rsview_tradesystem_select")
public class RSView_tradesystem_select extends RS_json_login {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(Security_usecases.check_authorization(authorisationstring));
            IView_tradesystem view_tradesystem;
            View_tradesystem_usecases view_tradesystemusecases = new View_tradesystem_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IView_tradesystemOperation.SELECT_ALL:
                    result = get_all_view_tradesystem(view_tradesystemusecases);
                    break;
//Custom code, do not change this line
//add here custom operations
                case IView_tradesystemOperation.SELECT_ALL_STARTSYSTEM:
                    result = getView_tradesystem_for_startsystem(view_tradesystemusecases, json);
                    break;
                case IView_tradesystemOperation.SELECT4SELLBUYSYSTEM:
                    result = getView_tradesystem_for_sell_buy_system(view_tradesystemusecases, json);
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
    private String getView_tradesystem_for_startsystem(View_tradesystem_usecases view_tradesysteminteractor, JSONObject json) throws ParseException, CustomException {
        eve.entity.pk.SystemPK systemPK = (eve.entity.pk.SystemPK)JSONSystem.toSystemPK((JSONObject)json.get("systempk"));
    	return JSONView_tradesystem.toJSONArray(view_tradesysteminteractor.getView_tradesystem_for_startsystem_usecase(systemPK)).toJSONString();
    }

    private String getView_tradesystem_for_sell_buy_system(View_tradesystem_usecases view_tradesysteminteractor, JSONObject json) throws ParseException, CustomException {
        eve.entity.pk.SystemPK sell_systemPK = (eve.entity.pk.SystemPK)JSONSystem.toSystemPK((JSONObject)json.get("sell_systempk"));
        eve.entity.pk.SystemPK buy_systemPK = (eve.entity.pk.SystemPK)JSONSystem.toSystemPK((JSONObject)json.get("buy_systempk"));
        View_tradesystem viewtradesystem = view_tradesysteminteractor.getView_tradesystem_for_sell_buy_system_usecase(sell_systemPK, buy_systemPK);
        if(viewtradesystem!=null) {
            return JSONView_tradesystem.toJSON(viewtradesystem).toJSONString();
        } else {
            return "";
        }
    }
//Custom code, do not change this line   

    private String get_all_view_tradesystem(View_tradesystem_usecases view_tradesystemusecases) throws ParseException, CustomException {
    	return JSONView_tradesystem.toJSONArray(view_tradesystemusecases.get_all()).toJSONString();
    }
}

