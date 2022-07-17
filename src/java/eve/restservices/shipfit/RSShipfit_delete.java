/*
 * Generated on 17.6.2022 13:4
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
@Path("rsshipfit_delete")
public class RSShipfit_delete extends RS_json_login {

    private Security_usecases security_usecases = new Security_usecases();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Shipfit_usecases shipfitusecases = new Shipfit_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IShipfitOperation.DELETE_SHIPFIT:
                    delete_shipfit(shipfitusecases, json);
                    break;
                case IShipfitOperation.DELETE_Evetype:
                    delete_shipfit(shipfitusecases, json);
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

    private void delete_shipfit(Shipfit_usecases shipfitusecases, JSONObject json) throws ParseException, CustomException {
        IShipfit shipfit = (IShipfit)JSONShipfit.toShipfit((JSONObject)json.get("shipfit"));
        shipfitusecases.deleteShipfit(shipfit);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Evetype(Shipfit_usecases shipfitusecases, JSONObject json) throws ParseException, CustomException {
        IEvetypePK evetypePK = (IEvetypePK)JSONEvetype.toEvetypePK((JSONObject)json.get("evetypepk"));
        shipfitusecases.delete_all_containing_Evetype(evetypePK);
        setReturnstatus("OK");
    }

}

