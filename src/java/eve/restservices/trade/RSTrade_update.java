/*
 * Generated on 20.4.2022 10:3
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
@Path("rstrade_update")
public class RSTrade_update extends RS_json_login {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(Security_usecases.check_authorization(authorisationstring));
            Trade_usecases tradeusecases = new Trade_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case ITradeOperation.UPDATE_TRADE:
                    update_trade(tradeusecases, json);
                    break;
//Custom code, do not change this line
//add here custom operations
                case ITradeOperation.UPDATE_TRADING:
                    executetrade(tradeusecases, json);
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
    private void executetrade(Trade_usecases tradeusecases, JSONObject json) throws ParseException, CustomException {
        ITradePK tradePK = JSONTrade.toTradePK((JSONObject)json.get("tradepk"));
        long volume = JSONConversion.getlong(json, "volume");
        tradeusecases.executetrade(tradePK, volume);
        setReturnstatus("OK");
    }
//Custom code, do not change this line   

    private void update_trade(Trade_usecases tradeusecases, JSONObject json) throws ParseException, CustomException {
        ITrade trade = (ITrade)JSONTrade.toTrade((JSONObject)json.get("trade"));
        tradeusecases.secureupdateTrade(trade);
        setReturnstatus("OK");
    }
}

