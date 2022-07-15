/*
 * Generated on 13.6.2022 18:20
 */

package eve.restservices.stargate;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.usecases.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.searchentity.IStargatesearch;
import eve.interfaces.servlet.IStargateOperation;
import eve.logicentity.Stargate;
import eve.searchentity.Stargatesearch;
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
@Path("rsstargate_delete")
public class RSStargate_delete extends RS_json_login {

    private Security_usecases security_usecases = new Security_usecases();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Stargate_usecases stargateusecases = new Stargate_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IStargateOperation.DELETE_STARGATE:
                    delete_stargate(stargateusecases, json);
                    break;
                case IStargateOperation.DELETE_Systemsystem:
                    delete_stargate(stargateusecases, json);
                    break;
                case IStargateOperation.DELETE_Systemto_system:
                    delete_stargate(stargateusecases, json);
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

    private void delete_stargate(Stargate_usecases stargateusecases, JSONObject json) throws ParseException, CustomException {
        IStargate stargate = (IStargate)JSONStargate.toStargate((JSONObject)json.get("stargate"));
        stargateusecases.deleteStargate(stargate);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Systemsystem(Stargate_usecases stargateusecases, JSONObject json) throws ParseException, CustomException {
        ISystemPK systemSystemPK = (ISystemPK)JSONSystem.toSystemPK((JSONObject)json.get("systempk"));
        stargateusecases.delete_all_containing_Systemsystem(systemSystemPK);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Systemto_system(Stargate_usecases stargateusecases, JSONObject json) throws ParseException, CustomException {
        ISystemPK systemTo_systemPK = (ISystemPK)JSONSystem.toSystemPK((JSONObject)json.get("systempk"));
        stargateusecases.delete_all_containing_Systemto_system(systemTo_systemPK);
        setReturnstatus("OK");
    }

}

