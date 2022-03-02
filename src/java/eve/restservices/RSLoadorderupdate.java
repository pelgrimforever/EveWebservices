package eve.restservices;

import data.conversion.JSONConversion;
import eve.BusinessObject.Logic.*;
import eve.conversion.json.*;
import eve.data.Swagger;
import eve.entity.pk.OrdersPK;
import eve.logicentity.Constellation;
import eve.logicentity.Orders;
import eve.logicview.View_order;
import general.exception.CustomException;
import general.exception.DBException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * REST Web Service
 *
 * @author Franky Laseure
 */
@Path("rsloadorderupdate")
public class RSLoadorderupdate {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of HelloWorld
     */
    public RSLoadorderupdate() {
    }

    /**
     * Retrieves representation of an instance of orders.restservices.RSOrders
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{json}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@PathParam("json") String jsonstring) {
        try {
            BLorders blorders = new BLorders();
            ArrayList orderss = blorders.getAll();
            JSONArray jsonorderss = JSONOrders.toJSONArray(orderss);
            return jsonorderss.toJSONString();
        }
        catch(DBException e) {
            return "{ \"status\": \"error\"}";
        }
    }

    /**
     * Retrieves representation of an instance of orders.restservices.RSOrders
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        String result = "";
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject)parser.parse(jsonstring);
//Security parameters
            boolean loggedin = RSsecurity.check(json);
            BLview_order blview_order = new BLview_order();
            blview_order.setAuthenticated(loggedin);
            BLsystem blsystem = new BLsystem();
            blsystem.setAuthenticated(loggedin);
            BLconstellation blconstellation = new BLconstellation();
            blconstellation.setAuthenticated(loggedin);

            OrdersPK sellordersPK = new OrdersPK(JSONConversion.getlong(json, "sellorderid"));
            OrdersPK buyordersPK = new OrdersPK(JSONConversion.getlong(json, "buyorderid"));
            View_order sellorder = blview_order.getView_order(sellordersPK);
            View_order buyorder = blview_order.getView_order(buyordersPK);
            
            //search orders in swagger
            //search on previous page if not found anymore
            JSONObject jsonsellorder = Swaggerorder.findOrder(sellorder.getRegion(), sellorder.getPage(), sellordersPK.getId());
            JSONObject jsonbuyorder = Swaggerorder.findOrder(buyorder.getRegion(), buyorder.getPage(), buyordersPK.getId());
            JSONObject orderupdate = new JSONObject();
            if(jsonsellorder!=null) {
                orderupdate.put("sellamount", JSONConversion.getLong(jsonsellorder, "volume_remain"));
            } else {
                orderupdate.put("sellamount", "0");                
            }
            if(jsonbuyorder!=null) {
                orderupdate.put("buyamount", JSONConversion.getLong(jsonbuyorder, "volume_remain"));
            } else {
                orderupdate.put("buyamount", "0");                
            }
            result = orderupdate.toJSONString();
        }
        catch(ParseException e) {
            result = returnstatus(e.getMessage());
        }
        catch(CustomException e) {
            result = returnstatus(e.getMessage());
        }
        return result;
    }

    private String returnstatus(String status) {
        JSONObject json = new JSONObject();
        json.put("status", status);
        return json.toJSONString();
    }
    
    private JSONObject findOrder(JSONArray jsonorders, long orderid) {
        JSONObject result = null;
        JSONObject jsonorder;
        Iterator<JSONObject> jsonordersI = jsonorders.iterator();
        boolean keeprunning = true;
        while(jsonordersI.hasNext() && keeprunning) {
            jsonorder = jsonordersI.next();
            if(JSONConversion.getLong(jsonorder, "order_id")==orderid) {
                result = jsonorder;
                keeprunning = false;
            }
        }
        return result;
    }

}

