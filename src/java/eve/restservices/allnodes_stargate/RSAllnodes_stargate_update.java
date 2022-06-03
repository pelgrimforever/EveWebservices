/*
 * Generated on 20.4.2022 10:3
 */

package eve.restservices.allnodes_stargate;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.usecases.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.searchentity.IAllnodes_stargatesearch;
import eve.interfaces.servlet.IAllnodes_stargateOperation;
import eve.logicentity.Allnodes_stargate;
import eve.searchentity.Allnodes_stargatesearch;
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
@Path("rsallnodes_stargate_update")
public class RSAllnodes_stargate_update extends RS_json_login {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(Security_usecases.check_authorization(authorisationstring));
            Allnodes_stargate_usecases allnodes_stargateusecases = new Allnodes_stargate_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IAllnodes_stargateOperation.UPDATE_ALLNODES_STARGATE:
                    update_allnodes_stargate(allnodes_stargateusecases, json);
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

    private void update_allnodes_stargate(Allnodes_stargate_usecases allnodes_stargateusecases, JSONObject json) throws ParseException, CustomException {
        IAllnodes_stargate allnodes_stargate = (IAllnodes_stargate)JSONAllnodes_stargate.toAllnodes_stargate((JSONObject)json.get("allnodes_stargate"));
        allnodes_stargateusecases.secureupdateAllnodes_stargate(allnodes_stargate);
        setReturnstatus("OK");
    }
}

