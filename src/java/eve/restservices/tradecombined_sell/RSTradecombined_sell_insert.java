/*
 * Generated on 13.6.2022 18:20
 */

package eve.restservices.tradecombined_sell;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.usecases.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.searchentity.ITradecombined_sellsearch;
import eve.interfaces.servlet.ITradecombined_sellOperation;
import eve.logicentity.Tradecombined_sell;
import eve.searchentity.Tradecombined_sellsearch;
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
@Path("rstradecombined_sell_insert")
public class RSTradecombined_sell_insert extends RS_json_login {

    private Security_usecases security_usecases = new Security_usecases();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Tradecombined_sell_usecases tradecombined_sellusecases = new Tradecombined_sell_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case ITradecombined_sellOperation.INSERT_TRADECOMBINED_SELL:
                    insert_tradecombined_sell(tradecombined_sellusecases, json);
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

    private void insert_tradecombined_sell(Tradecombined_sell_usecases tradecombined_sellusecases, JSONObject json) throws ParseException, CustomException {
        ITradecombined_sell tradecombined_sell = (ITradecombined_sell)JSONTradecombined_sell.toTradecombined_sell((JSONObject)json.get("tradecombined_sell"));
        tradecombined_sellusecases.insertTradecombined_sell(tradecombined_sell);
        setReturnstatus("OK");
    }
}

