/*
 * Generated on 17.6.2022 13:4
 */

package eve.restservices.view_stocktrade_orders;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import eve.BusinessObject.Logic.*;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.interfaces.logicview.IView_stocktrade_orders;
import eve.interfaces.servlet.IView_stocktrade_ordersOperation;
import eve.usecases.View_stocktrade_orders_usecases;
import eve.logicview.View_stocktrade_orders;
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
@Path("rsview_stocktrade_orders_select")
public class RSView_stocktrade_orders_select extends RS_json_login {

    private Security_usecases security_usecases = new Security_usecases();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            View_stocktrade_orders_usecases view_stocktrade_ordersusecases = new View_stocktrade_orders_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IView_stocktrade_ordersOperation.SELECT_ALL:
                    result = get_all_view_stocktrade_orders(view_stocktrade_ordersusecases);
                    break;
//Custom code, do not change this line
//add here custom operations
                case IView_stocktrade_ordersOperation.SELECT_4USERNAME_SYSTEM:
                    result = getView_stocktrade_orders4usernamesystem(view_stocktrade_ordersusecases, json);
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
    private String getView_stocktrade_orders4usernamesystem(View_stocktrade_orders_usecases view_stocktrade_ordersinteractor, JSONObject json) throws ParseException, CustomException {
        String username = JSONConversion.getString(json, "username");
        long system = JSONConversion.getlong(json, "system");
    	return JSONView_stocktrade_orders.toJSONArray(view_stocktrade_ordersinteractor.getView_stocktrade_orders4usernamesystem_usecase(username, system)).toJSONString();
    }
//Custom code, do not change this line   

    private String get_all_view_stocktrade_orders(View_stocktrade_orders_usecases view_stocktrade_ordersusecases) throws ParseException, CustomException {
    	return JSONView_stocktrade_orders.toJSONArray(view_stocktrade_ordersusecases.get_all()).toJSONString();
    }
}

