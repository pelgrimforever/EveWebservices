package eve.restservices;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import eve.BusinessObject.Logic.*;
import eve.entity.pk.OrdersPK;
import eve.usecases.Orders_usecases;
import eve.usecases.Orders_usecases.Orderupdate_data;
import eve.logicview.View_order;
import eve.usecases.Security_usecases;
import general.exception.CustomException;
import java.io.IOException;
import java.util.Iterator;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
@Path("rsloadorderupdate")
public class RSLoadorderupdate extends RS_json_login {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(Security_usecases.check_authorization(authorisationstring));
            Orders_usecases ordersinteractor = new Orders_usecases(loggedin);
            result = getOrdersupdate(ordersinteractor, json);
        }
        catch(ParseException | CustomException | IOException e) {
            result = returnstatus(e.getMessage());
        }
        return result;
    }

    private String getOrdersupdate(Orders_usecases ordersinteractor, JSONObject json) throws CustomException {
        OrdersPK sellordersPK = new OrdersPK(JSONConversion.getlong(json, "sellorderid"));
        OrdersPK buyordersPK = new OrdersPK(JSONConversion.getlong(json, "buyorderid"));
        Orders_usecases.Orderupdate_data orderupdate_data = ordersinteractor.get_ordersupdate_usecase(sellordersPK, buyordersPK);
        return buildOrdersupdate_JSONresponsestring(orderupdate_data);
    }
    
    private String buildOrdersupdate_JSONresponsestring(Orders_usecases.Orderupdate_data orderupdate_data) {
        JSONObject orderupdate = new JSONObject();
        orderupdate.put("sellamount", orderupdate_data.getSellamount());
        orderupdate.put("buyamount", orderupdate_data.getBuyamount());
        return orderupdate.toJSONString();
    }
    
    private String returnstatus(String status) {
        JSONObject json = new JSONObject();
        json.put("status", status);
        return json.toJSONString();
    }
}

