/*
 * Generated on 23.8.2022 14:38
 * @author Franky Laseure
 */

package eve.restservices.shipfitorder;

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
import eve.interfaces.searchentity.IShipfitordersearch;
import eve.interfaces.servlet.IShipfitorderOperation;
import eve.logicentity.Shipfitorder;
import eve.searchentity.Shipfitordersearch;
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

@Path("rsshipfitorder_delete")
public class RSShipfitorder_delete extends RS_json_login {

    private Security_usecases security_usecases = new Security_usecases();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Shipfitorder_usecases shipfitorderusecases = new Shipfitorder_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IShipfitorderOperation.DELETE_SHIPFITORDER:
                    delete_shipfitorder(shipfitorderusecases, json);
                    break;
                case IShipfitorderOperation.DELETE_Shipfit:
                    delete_shipfitorder(shipfitorderusecases, json);
                    break;
                case IShipfitorderOperation.DELETE_Evetype:
                    delete_shipfitorder(shipfitorderusecases, json);
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

    private void delete_shipfitorder(Shipfitorder_usecases shipfitorderusecases, JSONObject json) throws ParseException, CustomException {
        IShipfitorder shipfitorder = (IShipfitorder)JSONShipfitorder.toShipfitorder((JSONObject)json.get("shipfitorder"));
        shipfitorderusecases.deleteShipfitorder(shipfitorder);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Shipfit(Shipfitorder_usecases shipfitorderusecases, JSONObject json) throws ParseException, CustomException {
        IShipfitPK shipfitPK = (IShipfitPK)JSONShipfit.toShipfitPK((JSONObject)json.get("shipfitpk"));
        shipfitorderusecases.delete_all_containing_Shipfit(shipfitPK);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Evetype(Shipfitorder_usecases shipfitorderusecases, JSONObject json) throws ParseException, CustomException {
        IEvetypePK evetypePK = (IEvetypePK)JSONEvetype.toEvetypePK((JSONObject)json.get("evetypepk"));
        shipfitorderusecases.delete_all_containing_Evetype(evetypePK);
        setReturnstatus("OK");
    }

}

