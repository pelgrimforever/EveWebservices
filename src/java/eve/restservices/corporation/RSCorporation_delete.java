/*
 * Generated on 23.8.2022 14:38
 * @author Franky Laseure
 */

package eve.restservices.corporation;

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
import eve.interfaces.searchentity.ICorporationsearch;
import eve.interfaces.servlet.ICorporationOperation;
import eve.logicentity.Corporation;
import eve.searchentity.Corporationsearch;
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

@Path("rscorporation_delete")
public class RSCorporation_delete extends RS_json_login {

    private Security_usecases security_usecases = new Security_usecases();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Corporation_usecases corporationusecases = new Corporation_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case ICorporationOperation.DELETE_CORPORATION:
                    delete_corporation(corporationusecases, json);
                    break;
                case ICorporationOperation.DELETE_Station:
                    delete_corporation(corporationusecases, json);
                    break;
                case ICorporationOperation.DELETE_Faction:
                    delete_corporation(corporationusecases, json);
                    break;
                case ICorporationOperation.DELETE_Alliance:
                    delete_corporation(corporationusecases, json);
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

    private void delete_corporation(Corporation_usecases corporationusecases, JSONObject json) throws ParseException, CustomException {
        ICorporation corporation = (ICorporation)JSONCorporation.toCorporation((JSONObject)json.get("corporation"));
        corporationusecases.deleteCorporation(corporation);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Station(Corporation_usecases corporationusecases, JSONObject json) throws ParseException, CustomException {
        IStationPK stationPK = (IStationPK)JSONStation.toStationPK((JSONObject)json.get("stationpk"));
        corporationusecases.delete_all_containing_Station(stationPK);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Faction(Corporation_usecases corporationusecases, JSONObject json) throws ParseException, CustomException {
        IFactionPK factionPK = (IFactionPK)JSONFaction.toFactionPK((JSONObject)json.get("factionpk"));
        corporationusecases.delete_all_containing_Faction(factionPK);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Alliance(Corporation_usecases corporationusecases, JSONObject json) throws ParseException, CustomException {
        IAlliancePK alliancePK = (IAlliancePK)JSONAlliance.toAlliancePK((JSONObject)json.get("alliancepk"));
        corporationusecases.delete_all_containing_Alliance(alliancePK);
        setReturnstatus("OK");
    }

}

