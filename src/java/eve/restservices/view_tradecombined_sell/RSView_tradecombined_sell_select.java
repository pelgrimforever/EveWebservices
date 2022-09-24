/*
 * Generated on 23.8.2022 14:38
 * @author Franky Laseure
 */

package eve.restservices.view_tradecombined_sell;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import eve.BusinessObject.Logic.*;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.interfaces.logicview.IView_tradecombined_sell;
import eve.interfaces.servlet.IView_tradecombined_sellOperation;
import eve.usecases.View_tradecombined_sell_usecases;
import eve.logicview.View_tradecombined_sell;
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

@Path("rsview_tradecombined_sell_select")
public class RSView_tradecombined_sell_select extends RS_json_login {

    private Security_usecases security_usecases = new Security_usecases();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            View_tradecombined_sell_usecases view_tradecombined_sellusecases = new View_tradecombined_sell_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IView_tradecombined_sellOperation.SELECT_ALL:
                    result = get_all_view_tradecombined_sell(view_tradecombined_sellusecases);
                    break;
//Custom code, do not change this line
//add here custom operations
                case IView_tradecombined_sellOperation.SELECT4TRADECOMBINED:
                    result = getView_tradecombined_sells_for_primarykey(view_tradecombined_sellusecases, json);
                    break;
                case IView_tradecombined_sellOperation.SELECT4TRADESYSTEMS:
                    result = get_all_view_tradecombined_sell(view_tradecombined_sellusecases, json);
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
    private String getView_tradecombined_sells_for_primarykey(View_tradecombined_sell_usecases view_tradecombined_sellinteractor, JSONObject json) throws ParseException, CustomException {
        TradecombinedPK tradecombinedPK = (TradecombinedPK)JSONTradecombined.toTradecombinedPK((JSONObject)json.get("tradecombinedpk"));
    	return JSONView_tradecombined_sell.toJSONArray(view_tradecombined_sellinteractor.getView_tradecombined_sells_for_evetype(tradecombinedPK)).toJSONString();
    }

    private String get_all_view_tradecombined_sell(View_tradecombined_sell_usecases view_tradecombined_sellinteractor, JSONObject json) throws ParseException, CustomException {
        SystemPK sell_systemPK = (SystemPK)JSONSystem.toSystemPK((JSONObject)json.get("sell_systempk"));
        SystemPK buy_systemPK = (SystemPK)JSONSystem.toSystemPK((JSONObject)json.get("buy_systempk"));
    	return JSONView_tradecombined_sell.toJSONArray(view_tradecombined_sellinteractor.getView_tradecombined_sells_for_all_evetypes(sell_systemPK, buy_systemPK)).toJSONString();
    }
//Custom code, do not change this line   

    private String get_all_view_tradecombined_sell(View_tradecombined_sell_usecases view_tradecombined_sellusecases) throws ParseException, CustomException {
    	return JSONView_tradecombined_sell.toJSONArray(view_tradecombined_sellusecases.get_all()).toJSONString();
    }
}

