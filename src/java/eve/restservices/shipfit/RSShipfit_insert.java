/*
 * Generated on 13.4.2022 19:13
 */

package eve.restservices.shipfit;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.usecases.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.searchentity.IShipfitsearch;
import eve.interfaces.servlet.IShipfitOperation;
import eve.logicentity.Shipfit;
import eve.searchentity.Shipfitsearch;
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
@Path("rsshipfit_insert")
public class RSShipfit_insert extends RS_json_login {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(Security_usecases.check_authorization(authorisationstring));
            Shipfit_usecases shipfitusecases = new Shipfit_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IShipfitOperation.INSERT_SHIPFIT:
                    insert_shipfit(shipfitusecases, json);
                    break;
//Custom code, do not change this line
//add here custom operations
                case IShipfitOperation.INSERT_ADDORDERShipfit:
                    add_order_shipfit(shipfitusecases, json);
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
    private void add_order_shipfit(Shipfit_usecases shipfitusecases, JSONObject json) throws ParseException, CustomException {
        IShipfitPK shipfitPK = (IShipfitPK)JSONShipfit.toShipfitPK((JSONObject)json.get("shipfitpk"));
        shipfitusecases.order_ship_and_all_modules(shipfitPK);
        setReturnstatus("OK");
    }
//Custom code, do not change this line   

    private void insert_shipfit(Shipfit_usecases shipfitusecases, JSONObject json) throws ParseException, CustomException {
        IShipfit shipfit = (IShipfit)JSONShipfit.toShipfit((JSONObject)json.get("shipfit"));
        shipfitusecases.secureinsertShipfit(shipfit);
        setReturnstatus("OK");
    }
}

