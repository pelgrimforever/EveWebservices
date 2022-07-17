/*
 * Generated on 17.6.2022 13:4
 */

package eve.restservices.orders;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.usecases.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.searchentity.IOrderssearch;
import eve.interfaces.servlet.IOrdersOperation;
import eve.logicentity.Orders;
import eve.searchentity.Orderssearch;
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
@Path("rsorders_delete")
public class RSOrders_delete extends RS_json_login {

    private Security_usecases security_usecases = new Security_usecases();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Orders_usecases ordersusecases = new Orders_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IOrdersOperation.DELETE_ORDERS:
                    delete_orders(ordersusecases, json);
                    break;
                case IOrdersOperation.DELETE_Evetype:
                    delete_orders(ordersusecases, json);
                    break;
                case IOrdersOperation.DELETE_System:
                    delete_orders(ordersusecases, json);
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

    private void delete_orders(Orders_usecases ordersusecases, JSONObject json) throws ParseException, CustomException {
        IOrders orders = (IOrders)JSONOrders.toOrders((JSONObject)json.get("orders"));
        ordersusecases.deleteOrders(orders);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Evetype(Orders_usecases ordersusecases, JSONObject json) throws ParseException, CustomException {
        IEvetypePK evetypePK = (IEvetypePK)JSONEvetype.toEvetypePK((JSONObject)json.get("evetypepk"));
        ordersusecases.delete_all_containing_Evetype(evetypePK);
        setReturnstatus("OK");
    }

    private void delete_all_containing_System(Orders_usecases ordersusecases, JSONObject json) throws ParseException, CustomException {
        ISystemPK systemPK = (ISystemPK)JSONSystem.toSystemPK((JSONObject)json.get("systempk"));
        ordersusecases.delete_all_containing_System(systemPK);
        setReturnstatus("OK");
    }

}

