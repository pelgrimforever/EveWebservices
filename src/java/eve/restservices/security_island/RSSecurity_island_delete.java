/*
 * Generated on 20.4.2022 10:3
 */

package eve.restservices.security_island;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.usecases.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.searchentity.ISecurity_islandsearch;
import eve.interfaces.servlet.ISecurity_islandOperation;
import eve.logicentity.Security_island;
import eve.searchentity.Security_islandsearch;
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
@Path("rssecurity_island_delete")
public class RSSecurity_island_delete extends RS_json_login {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(Security_usecases.check_authorization(authorisationstring));
            Security_island_usecases security_islandusecases = new Security_island_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case ISecurity_islandOperation.DELETE_SECURITY_ISLAND:
                    delete_security_island(security_islandusecases, json);
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

    private void delete_security_island(Security_island_usecases security_islandusecases, JSONObject json) throws ParseException, CustomException {
        ISecurity_island security_island = (ISecurity_island)JSONSecurity_island.toSecurity_island((JSONObject)json.get("security_island"));
        security_islandusecases.securedeleteSecurity_island(security_island);
        setReturnstatus("OK");
    }
}

