/*
 * Generated on 13.6.2022 18:20
 */

package eve.restservices.allnodes_system;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.usecases.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.searchentity.IAllnodes_systemsearch;
import eve.interfaces.servlet.IAllnodes_systemOperation;
import eve.logicentity.Allnodes_system;
import eve.searchentity.Allnodes_systemsearch;
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
@Path("rsallnodes_system_delete")
public class RSAllnodes_system_delete extends RS_json_login {

    private Security_usecases security_usecases = new Security_usecases();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Allnodes_system_usecases allnodes_systemusecases = new Allnodes_system_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IAllnodes_systemOperation.DELETE_ALLNODES_SYSTEM:
                    delete_allnodes_system(allnodes_systemusecases, json);
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

    private void delete_allnodes_system(Allnodes_system_usecases allnodes_systemusecases, JSONObject json) throws ParseException, CustomException {
        IAllnodes_system allnodes_system = (IAllnodes_system)JSONAllnodes_system.toAllnodes_system((JSONObject)json.get("allnodes_system"));
        allnodes_systemusecases.deleteAllnodes_system(allnodes_system);
        setReturnstatus("OK");
    }

}
