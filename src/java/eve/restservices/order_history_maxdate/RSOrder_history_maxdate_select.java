/*
 * Generated on 13.4.2022 19:13
 */

package eve.restservices.order_history_maxdate;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import eve.BusinessObject.Logic.*;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.interfaces.logicview.IOrder_history_maxdate;
import eve.interfaces.servlet.IOrder_history_maxdateOperation;
import eve.usecases.Order_history_maxdate_usecases;
import eve.logicview.Order_history_maxdate;
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
@Path("rsorder_history_maxdate_select")
public class RSOrder_history_maxdate_select extends RS_json_login {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(Security_usecases.check_authorization(authorisationstring));
            IOrder_history_maxdate order_history_maxdate;
            Order_history_maxdate_usecases order_history_maxdateusecases = new Order_history_maxdate_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IOrder_history_maxdateOperation.SELECT_ALL:
                    result = get_all_order_history_maxdate(order_history_maxdateusecases);
                    break;
//Custom code, do not change this line
//add here custom operations
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
//Custom code, do not change this line   

    private String get_all_order_history_maxdate(Order_history_maxdate_usecases order_history_maxdateusecases) throws ParseException, CustomException {
    	return JSONOrder_history_maxdate.toJSONArray(order_history_maxdateusecases.get_all()).toJSONString();
    }
}

