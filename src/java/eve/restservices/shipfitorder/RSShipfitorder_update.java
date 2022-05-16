/*
 * Generated on 13.4.2022 19:13
 */

package eve.restservices.shipfitorder;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.usecases.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.searchentity.IShipfitordersearch;
import eve.interfaces.servlet.IShipfitorderOperation;
import eve.logicentity.Shipfitorder;
import eve.searchentity.Shipfitordersearch;
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
@Path("rsshipfitorder_update")
public class RSShipfitorder_update extends RS_json_login {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(Security_usecases.check_authorization(authorisationstring));
            Shipfitorder_usecases shipfitorderusecases = new Shipfitorder_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IShipfitorderOperation.UPDATE_SHIPFITORDER:
                    update_shipfitorder(shipfitorderusecases, json);
                    break;
//Custom code, do not change this line
//add here custom operations
                case IShipfitorderOperation.UPDATE_ORDERAMOUNT:
                    update_shipfitorder_amount(shipfitorderusecases, json);
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
    private void update_shipfitorder_amount(Shipfitorder_usecases shipfitorderusecases, JSONObject json) throws ParseException, CustomException {
        IShipfitorderPK shipfitorderPK = (IShipfitorderPK)JSONShipfitorder.toShipfitorderPK((JSONObject)json.get("shipfitorderpk"));
        int amount = JSONConversion.getint(json, "amount");
        shipfitorderusecases.update_shipfitorder_amount(shipfitorderPK, amount);
        setReturnstatus("OK");
    }
//Custom code, do not change this line   

    private void update_shipfitorder(Shipfitorder_usecases shipfitorderusecases, JSONObject json) throws ParseException, CustomException {
        IShipfitorder shipfitorder = (IShipfitorder)JSONShipfitorder.toShipfitorder((JSONObject)json.get("shipfitorder"));
        shipfitorderusecases.secureupdateShipfitorder(shipfitorder);
        setReturnstatus("OK");
    }
}

