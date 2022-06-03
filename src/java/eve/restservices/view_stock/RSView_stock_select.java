/*
 * Generated on 20.4.2022 10:3
 */

package eve.restservices.view_stock;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import eve.BusinessObject.Logic.*;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.interfaces.logicview.IView_stock;
import eve.interfaces.servlet.IView_stockOperation;
import eve.usecases.View_stock_usecases;
import eve.logicview.View_stock;
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
@Path("rsview_stock_select")
public class RSView_stock_select extends RS_json_login {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(Security_usecases.check_authorization(authorisationstring));
            IView_stock view_stock;
            View_stock_usecases view_stockusecases = new View_stock_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IView_stockOperation.SELECT_ALL:
                    result = get_all_view_stock(view_stockusecases);
                    break;
//Custom code, do not change this line
//add here custom operations
                case IView_stockOperation.SELECT_4USER:
                    result = getView_stock4username(view_stockusecases, json);
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
    private String getView_stock4username(View_stock_usecases view_stockinteractor, JSONObject json) throws ParseException, CustomException {
        String username = JSONConversion.getString(json, "username");
    	return JSONView_stock.toJSONArray(view_stockinteractor.getView_stock4username_usecase(username)).toJSONString();
    }
//Custom code, do not change this line   

    private String get_all_view_stock(View_stock_usecases view_stockusecases) throws ParseException, CustomException {
    	return JSONView_stock.toJSONArray(view_stockusecases.get_all()).toJSONString();
    }
}

