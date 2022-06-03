/*
 * Generated on 20.4.2022 10:3
 */

package eve.restservices.view_trade;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import eve.BusinessObject.Logic.*;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.interfaces.logicview.IView_trade;
import eve.interfaces.servlet.IView_tradeOperation;
import eve.usecases.View_trade_usecases;
import eve.logicview.View_trade;
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
@Path("rsview_trade_select")
public class RSView_trade_select extends RS_json_login {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(Security_usecases.check_authorization(authorisationstring));
            IView_trade view_trade;
            View_trade_usecases view_tradeusecases = new View_trade_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IView_tradeOperation.SELECT_ALL:
                    result = get_all_view_trade(view_tradeusecases);
                    break;
//Custom code, do not change this line
//add here custom operations
                case IView_tradeOperation.SELECT_ALL_STARTSYSTEM:
                    
                    result = getView_trades_Startsystem(view_tradeusecases, json);
                    break;
                case IView_tradeOperation.SELECT_STARTENDSYSTEM:
                    result = getView_trades_Startendsystem(view_tradeusecases, json);
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
    private String getView_trades_Startsystem(View_trade_usecases view_tradeinteractor, JSONObject json) throws ParseException, CustomException {
        eve.entity.pk.SystemPK systemPK = (eve.entity.pk.SystemPK)JSONSystem.toSystemPK((JSONObject)json.get("systempk"));
    	return JSONView_trade.toJSONArray(view_tradeinteractor.getView_trades_Startsystem_usecase(systemPK)).toJSONString();
    }

    private String getView_trades_Startendsystem(View_trade_usecases view_tradeinteractor, JSONObject json) throws ParseException, CustomException {
        eve.entity.pk.SystemPK startsystemPK = (eve.entity.pk.SystemPK)JSONSystem.toSystemPK((JSONObject)json.get("startsystempk"));
        eve.entity.pk.SystemPK endsystemPK = (eve.entity.pk.SystemPK)JSONSystem.toSystemPK((JSONObject)json.get("endsystempk"));
    	return JSONView_trade.toJSONArray(view_tradeinteractor.getView_trades_Startendsystem_usecase(startsystemPK, endsystemPK)).toJSONString();
    }
//Custom code, do not change this line   

    private String get_all_view_trade(View_trade_usecases view_tradeusecases) throws ParseException, CustomException {
    	return JSONView_trade.toJSONArray(view_tradeusecases.get_all()).toJSONString();
    }
}

