/*
 * Generated on 23.8.2022 14:38
 * @author Franky Laseure
 */

package eve.restservices.shipfitmodule;

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
import eve.interfaces.searchentity.IShipfitmodulesearch;
import eve.interfaces.servlet.IShipfitmoduleOperation;
import eve.logicentity.Shipfitmodule;
import eve.searchentity.Shipfitmodulesearch;
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

@Path("rsshipfitmodule_insert")
public class RSShipfitmodule_insert extends RS_json_login {

    private Security_usecases security_usecases = new Security_usecases();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Shipfitmodule_usecases shipfitmoduleusecases = new Shipfitmodule_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IShipfitmoduleOperation.INSERT_SHIPFITMODULE:
                    insert_shipfitmodule(shipfitmoduleusecases, json);
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

    private void insert_shipfitmodule(Shipfitmodule_usecases shipfitmoduleusecases, JSONObject json) throws ParseException, CustomException {
        IShipfitmodule shipfitmodule = (IShipfitmodule)JSONShipfitmodule.toShipfitmodule((JSONObject)json.get("shipfitmodule"));
        shipfitmoduleusecases.insertShipfitmodule(shipfitmodule);
        setReturnstatus("OK");
    }
}

