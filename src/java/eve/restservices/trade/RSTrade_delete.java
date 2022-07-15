/*
 * Generated on 13.6.2022 18:20
 */

package eve.restservices.trade;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.usecases.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.searchentity.ITradesearch;
import eve.interfaces.servlet.ITradeOperation;
import eve.logicentity.Trade;
import eve.searchentity.Tradesearch;
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
@Path("rstrade_delete")
public class RSTrade_delete extends RS_json_login {

    private Security_usecases security_usecases = new Security_usecases();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Trade_usecases tradeusecases = new Trade_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case ITradeOperation.DELETE_TRADE:
                    delete_trade(tradeusecases, json);
                    break;
                case ITradeOperation.DELETE_Orderssell_order_id:
                    delete_trade(tradeusecases, json);
                    break;
                case ITradeOperation.DELETE_Ordersbuy_order_id:
                    delete_trade(tradeusecases, json);
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

    private void delete_trade(Trade_usecases tradeusecases, JSONObject json) throws ParseException, CustomException {
        ITrade trade = (ITrade)JSONTrade.toTrade((JSONObject)json.get("trade"));
        tradeusecases.deleteTrade(trade);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Orderssell_order_id(Trade_usecases tradeusecases, JSONObject json) throws ParseException, CustomException {
        IOrdersPK ordersSell_order_idPK = (IOrdersPK)JSONOrders.toOrdersPK((JSONObject)json.get("orderspk"));
        tradeusecases.delete_all_containing_Orderssell_order_id(ordersSell_order_idPK);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Ordersbuy_order_id(Trade_usecases tradeusecases, JSONObject json) throws ParseException, CustomException {
        IOrdersPK ordersBuy_order_idPK = (IOrdersPK)JSONOrders.toOrdersPK((JSONObject)json.get("orderspk"));
        tradeusecases.delete_all_containing_Ordersbuy_order_id(ordersBuy_order_idPK);
        setReturnstatus("OK");
    }

}

