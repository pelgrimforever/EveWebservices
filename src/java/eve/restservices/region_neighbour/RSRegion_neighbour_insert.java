/*
 * Generated on 20.4.2022 10:3
 */

package eve.restservices.region_neighbour;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.usecases.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.searchentity.IRegion_neighboursearch;
import eve.interfaces.servlet.IRegion_neighbourOperation;
import eve.logicentity.Region_neighbour;
import eve.searchentity.Region_neighboursearch;
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
@Path("rsregion_neighbour_insert")
public class RSRegion_neighbour_insert extends RS_json_login {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(Security_usecases.check_authorization(authorisationstring));
            Region_neighbour_usecases region_neighbourusecases = new Region_neighbour_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IRegion_neighbourOperation.INSERT_REGION_NEIGHBOUR:
                    insert_region_neighbour(region_neighbourusecases, json);
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

    private void insert_region_neighbour(Region_neighbour_usecases region_neighbourusecases, JSONObject json) throws ParseException, CustomException {
        IRegion_neighbour region_neighbour = (IRegion_neighbour)JSONRegion_neighbour.toRegion_neighbour((JSONObject)json.get("region_neighbour"));
        region_neighbourusecases.secureinsertRegion_neighbour(region_neighbour);
        setReturnstatus("OK");
    }
}

