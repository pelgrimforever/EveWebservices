/*
 * Generated on 13.6.2022 18:20
 */

package eve.restservices.shipfitorderselected;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.usecases.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.searchentity.IShipfitorderselectedsearch;
import eve.interfaces.servlet.IShipfitorderselectedOperation;
import eve.logicentity.Shipfitorderselected;
import eve.searchentity.Shipfitorderselectedsearch;
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
@Path("rsshipfitorderselected_delete")
public class RSShipfitorderselected_delete extends RS_json_login {

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
                case IShipfitorderselectedOperation.DELETE_SHIPFITORDERSELECTED:
                    delete_shipfitorderselected(shipfitorderselectedusecases, json);
                    break;
                case IShipfitorderselectedOperation.DELETE_Orders:
                    delete_shipfitorderselected(shipfitorderselectedusecases, json);
                    break;
                case IShipfitorderselectedOperation.DELETE_Shipfitorder:
                    delete_shipfitorderselected(shipfitorderselectedusecases, json);
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

    private void delete_shipfitorderselected(Shipfitorderselected_usecases shipfitorderselectedusecases, JSONObject json) throws ParseException, CustomException {
        IShipfitorderselected shipfitorderselected = (IShipfitorderselected)JSONShipfitorderselected.toShipfitorderselected((JSONObject)json.get("shipfitorderselected"));
        shipfitorderselectedusecases.deleteShipfitorderselected(shipfitorderselected);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Orders(Shipfitorderselected_usecases shipfitorderselectedusecases, JSONObject json) throws ParseException, CustomException {
        IOrdersPK ordersPK = (IOrdersPK)JSONOrders.toOrdersPK((JSONObject)json.get("orderspk"));
        shipfitorderselectedusecases.delete_all_containing_Orders(ordersPK);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Shipfitorder(Shipfitorderselected_usecases shipfitorderselectedusecases, JSONObject json) throws ParseException, CustomException {
        IShipfitorderPK shipfitorderPK = (IShipfitorderPK)JSONShipfitorder.toShipfitorderPK((JSONObject)json.get("shipfitorderpk"));
        shipfitorderselectedusecases.delete_all_containing_Shipfitorder(shipfitorderPK);
        setReturnstatus("OK");
    }

}

