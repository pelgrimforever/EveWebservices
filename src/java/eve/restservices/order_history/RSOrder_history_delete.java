/*
 * Generated on 17.6.2022 13:4
 */

package eve.restservices.order_history;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.usecases.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.searchentity.IOrder_historysearch;
import eve.interfaces.servlet.IOrder_historyOperation;
import eve.logicentity.Order_history;
import eve.searchentity.Order_historysearch;
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
@Path("rsorder_history_delete")
public class RSOrder_history_delete extends RS_json_login {

    private Security_usecases security_usecases = new Security_usecases();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Order_history_usecases order_historyusecases = new Order_history_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IOrder_historyOperation.DELETE_ORDER_HISTORY:
                    delete_order_history(order_historyusecases, json);
                    break;
                case IOrder_historyOperation.DELETE_Evetype:
                    delete_order_history(order_historyusecases, json);
                    break;
                case IOrder_historyOperation.DELETE_Region:
                    delete_order_history(order_historyusecases, json);
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

    private void delete_order_history(Order_history_usecases order_historyusecases, JSONObject json) throws ParseException, CustomException {
        IOrder_history order_history = (IOrder_history)JSONOrder_history.toOrder_history((JSONObject)json.get("order_history"));
        order_historyusecases.deleteOrder_history(order_history);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Evetype(Order_history_usecases order_historyusecases, JSONObject json) throws ParseException, CustomException {
        IEvetypePK evetypePK = (IEvetypePK)JSONEvetype.toEvetypePK((JSONObject)json.get("evetypepk"));
        order_historyusecases.delete_all_containing_Evetype(evetypePK);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Region(Order_history_usecases order_historyusecases, JSONObject json) throws ParseException, CustomException {
        IRegionPK regionPK = (IRegionPK)JSONRegion.toRegionPK((JSONObject)json.get("regionpk"));
        order_historyusecases.delete_all_containing_Region(regionPK);
        setReturnstatus("OK");
    }

}

