/*
 * Generated on 20.4.2022 10:3
 */

package eve.restservices.constellation_neighbour;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.usecases.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.searchentity.IConstellation_neighboursearch;
import eve.interfaces.servlet.IConstellation_neighbourOperation;
import eve.logicentity.Constellation_neighbour;
import eve.searchentity.Constellation_neighboursearch;
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
@Path("rsconstellation_neighbour_update")
public class RSConstellation_neighbour_update extends RS_json_login {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(Security_usecases.check_authorization(authorisationstring));
            Constellation_neighbour_usecases constellation_neighbourusecases = new Constellation_neighbour_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IConstellation_neighbourOperation.UPDATE_CONSTELLATION_NEIGHBOUR:
                    update_constellation_neighbour(constellation_neighbourusecases, json);
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

    private void update_constellation_neighbour(Constellation_neighbour_usecases constellation_neighbourusecases, JSONObject json) throws ParseException, CustomException {
        IConstellation_neighbour constellation_neighbour = (IConstellation_neighbour)JSONConstellation_neighbour.toConstellation_neighbour((JSONObject)json.get("constellation_neighbour"));
        constellation_neighbourusecases.secureupdateConstellation_neighbour(constellation_neighbour);
        setReturnstatus("OK");
    }
}

