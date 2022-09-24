/*
 * Generated on 23.8.2022 14:38
 * @author Franky Laseure
 */

package eve.restservices.shipfitorderselected;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.usecases.*;
import eve.usecases.custom.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.searchentity.IShipfitorderselectedsearch;
import eve.interfaces.servlet.IShipfitorderselectedOperation;
import eve.logicentity.Shipfitorderselected;
import eve.searchentity.Shipfitorderselectedsearch;
import eve.servlets.DataServlet;
import eve.usecases.*;
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

@Path("rsshipfitorderselected_update")
public class RSShipfitorderselected_update extends RS_json_login {

    private Security_usecases security_usecases = new Security_usecases();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Shipfitorderselected_usecases shipfitorderselectedusecases = new Shipfitorderselected_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IShipfitorderselectedOperation.UPDATE_SHIPFITORDERSELECTED:
                    update_shipfitorderselected(shipfitorderselectedusecases, json);
                    break;
//Custom code, do not change this line
//add here custom operations
                case IShipfitorderselectedOperation.UPDATE_CONFIRMORDER:
                    update_shipfitorderselected_with_bought_amount(shipfitorderselectedusecases, json);
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
    private void update_shipfitorderselected_with_bought_amount(Shipfitorderselected_usecases shipfitorderselectedusecases, JSONObject json) throws ParseException, CustomException {
        IShipfitorderselectedPK shipfitorderselectedPK = (IShipfitorderselectedPK)JSONShipfitorderselected.toShipfitorderselectedPK((JSONObject)json.get("shipfitorderselectedpk"));
        int amount = JSONConversion.getint(json, "amount");
        shipfitorderselectedusecases.update_shipfitorderselected_with_bought_amount(shipfitorderselectedPK, amount);
        setReturnstatus("OK");
    }
//Custom code, do not change this line   

    private void update_shipfitorderselected(Shipfitorderselected_usecases shipfitorderselectedusecases, JSONObject json) throws ParseException, CustomException {
        IShipfitorderselected shipfitorderselected = (IShipfitorderselected)JSONShipfitorderselected.toShipfitorderselected((JSONObject)json.get("shipfitorderselected"));
        shipfitorderselectedusecases.updateShipfitorderselected(shipfitorderselected);
        setReturnstatus("OK");
    }
}

