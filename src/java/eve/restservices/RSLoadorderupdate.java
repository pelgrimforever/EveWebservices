package eve.restservices;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import eve.BusinessObject.Logic.*;
import eve.entity.pk.OrdersPK;
import eve.usecases.Orders_usecases;
import eve.usecases.Orders_usecases.Orderupdate_data;
import eve.logicview.View_order;
import eve.usecases.custom.Security_usecases;
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

    private Security_usecases security_usecases = new Security_usecases();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Orders_usecases orders_usecases = new Orders_usecases(loggedin);
            Orders_usecases.Orderupdate_data orderupdate_data = getSwaggerupdate(orders_usecases, json);
            return buildOrdersupdate_JSONresponsestring(orderupdate_data);
        }
        catch(ParseException | CustomException | IOException e) {
            result = returnstatus(e.getMessage());
        }
        return result;
    }

    public Orders_usecases.Orderupdate_data getSwaggerupdate(Orders_usecases orders_usecases, JSONObject json) throws CustomException {
        OrdersPK sellordersPK = new OrdersPK(JSONConversion.getlong(json, "sellorderid"));
        OrdersPK buyordersPK = new OrdersPK(JSONConversion.getlong(json, "buyorderid"));
        return orders_usecases.get_ordersupdate_usecase(sellordersPK, buyordersPK);
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

