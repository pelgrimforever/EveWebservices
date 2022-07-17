/*
 * Generated on 17.6.2022 13:4
 */

package eve.restservices.alliance;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.usecases.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.searchentity.IAlliancesearch;
import eve.interfaces.servlet.IAllianceOperation;
import eve.logicentity.Alliance;
import eve.searchentity.Alliancesearch;
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
@Path("rsalliance_delete")
public class RSAlliance_delete extends RS_json_login {

    private Security_usecases security_usecases = new Security_usecases();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Alliance_usecases allianceusecases = new Alliance_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IAllianceOperation.DELETE_ALLIANCE:
                    delete_alliance(allianceusecases, json);
                    break;
                case IAllianceOperation.DELETE_Corporationcreator_corporation:
                    delete_alliance(allianceusecases, json);
                    break;
                case IAllianceOperation.DELETE_Corporationexecutor_corporation:
                    delete_alliance(allianceusecases, json);
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

    private void delete_alliance(Alliance_usecases allianceusecases, JSONObject json) throws ParseException, CustomException {
        IAlliance alliance = (IAlliance)JSONAlliance.toAlliance((JSONObject)json.get("alliance"));
        allianceusecases.deleteAlliance(alliance);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Corporationcreator_corporation(Alliance_usecases allianceusecases, JSONObject json) throws ParseException, CustomException {
        ICorporationPK corporationCreator_corporationPK = (ICorporationPK)JSONCorporation.toCorporationPK((JSONObject)json.get("corporationpk"));
        allianceusecases.delete_all_containing_Corporationcreator_corporation(corporationCreator_corporationPK);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Corporationexecutor_corporation(Alliance_usecases allianceusecases, JSONObject json) throws ParseException, CustomException {
        ICorporationPK corporationExecutor_corporationPK = (ICorporationPK)JSONCorporation.toCorporationPK((JSONObject)json.get("corporationpk"));
        allianceusecases.delete_all_containing_Corporationexecutor_corporation(corporationExecutor_corporationPK);
        setReturnstatus("OK");
    }

}

