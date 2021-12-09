/*
 * RSCorporation.java
 *
 * Generated on 9.11.2021 14:30
 *
 */

package eve.restservices;

import base.servlets.Securitycheck;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import eve.BusinessObject.Logic.*;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.searchentity.ICorporationsearch;
import eve.interfaces.servlet.ICorporationOperation;
import eve.logicentity.Corporation;
import eve.searchentity.Corporationsearch;
import eve.servlets.DataServlet;
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
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * REST Web Service
 *
 * @author Franky Laseure
 */
@Path("rscorporation")
public class RSCorporation {

    /**
     * Creates a new instance of HelloWorld
     */
    public RSCorporation() {
    }

    /**
     * Retrieves representation of an instance of corporation.restservices.RSCorporation
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{json}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@PathParam("json") String jsonstring) {
        try {
            BLcorporation blcorporation = new BLcorporation();
            ArrayList corporations = blcorporation.getAll();
            JSONArray jsoncorporations = JSONCorporation.toJSONArray(corporations);
            return jsoncorporations.toJSONString();
        }
        catch(DBException e) {
            return "{ \"status\": \"error\"}";
        }
    }

    /**
     * Retrieves representation of an instance of corporation.restservices.RSCorporation
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        String result = "";
        BLcorporation blcorporation = new BLcorporation();
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject)parser.parse(jsonstring);
            JSONObject jsonoperation = (JSONObject)json.get("operation");
            byte operationtype = JSONConversion.getbyte(jsonoperation, "type");
            byte operation = JSONConversion.getbyte(jsonoperation, "operation");
            ICorporationPK corporationPK;
            ICorporation corporation;
//Security parameters
            boolean loggedin = RSsecurity.check(json);
            blcorporation.setAuthenticated(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    switch(operation) {
                        case ICorporationOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blcorporation.count());
                            result = jsoncount.toJSONString();
                            break;
                        case ICorporationOperation.SELECT_ALL:
                            result = JSONCorporation.toJSONArray(blcorporation.getCorporations()).toJSONString();
                            break;
                        case ICorporationOperation.SELECT_CORPORATION:
                            corporationPK = (ICorporationPK)JSONCorporation.toCorporationPK((JSONObject)json.get("corporationpk"));
                            result = JSONCorporation.toJSON(blcorporation.getCorporation(corporationPK)).toJSONString();
                            break;
                        case ICorporationOperation.SELECT_Station:
                            IStationPK stationPK = (IStationPK)JSONStation.toStationPK((JSONObject)json.get("stationpk"));
                            result = JSONCorporation.toJSONArray(blcorporation.getCorporations4station(stationPK)).toJSONString();
                            break;
                        case ICorporationOperation.SELECT_Faction:
                            IFactionPK factionPK = (IFactionPK)JSONFaction.toFactionPK((JSONObject)json.get("factionpk"));
                            result = JSONCorporation.toJSONArray(blcorporation.getCorporations4faction(factionPK)).toJSONString();
                            break;
                        case ICorporationOperation.SELECT_Alliance:
                            IAlliancePK alliancePK = (IAlliancePK)JSONAlliance.toAlliancePK((JSONObject)json.get("alliancepk"));
                            result = JSONCorporation.toJSONArray(blcorporation.getCorporations4alliance(alliancePK)).toJSONString();
                            break;
                        case ICorporationOperation.SELECT_SEARCH:
                            ICorporationsearch search = (ICorporationsearch)JSONCorporation.toCorporationsearch((JSONObject)json.get("search"));
                            result = JSONCorporation.toJSONArray(blcorporation.search(search)).toJSONString();
                            break;
                        case ICorporationOperation.SELECT_SEARCHCOUNT:
                            ICorporationsearch corporationsearch = (ICorporationsearch)JSONCorporation.toCorporationsearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blcorporation.searchcount(corporationsearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(operation) {
                        case ICorporationOperation.INSERT_CORPORATION:
                            corporation = (ICorporation)JSONCorporation.toCorporation((JSONObject)json.get("corporation"));
                            blcorporation.insertCorporation(corporation);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(operation) {
                        case ICorporationOperation.UPDATE_CORPORATION:
                            JSONObject jsoncorporation = (JSONObject)json.get("corporation");
                            corporationPK = JSONCorporation.toCorporationPK((JSONObject)jsoncorporation.get("PK"));
                            corporation = blcorporation.getCorporation(corporationPK);
                            JSONCorporation.updateCorporation(corporation, jsoncorporation);
                            blcorporation.updateCorporation(corporation);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(operation) {
                        case ICorporationOperation.DELETE_CORPORATION:
                            corporation = (ICorporation)JSONCorporation.toCorporation((JSONObject)json.get("corporation"));
                            blcorporation.deleteCorporation(corporation);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECURESELECT:
                    switch(operation) {
                        case ICorporationOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blcorporation.count());
                            result = jsoncount.toJSONString();
                            break;
                        case ICorporationOperation.SELECT_ALL:
                            result = JSONCorporation.toJSONArray(blcorporation.getCorporations()).toJSONString();
                            break;
                        case ICorporationOperation.SELECT_CORPORATION:
                            corporationPK = (ICorporationPK)JSONCorporation.toCorporationPK((JSONObject)json.get("corporationpk"));
                            result = JSONCorporation.toJSON(blcorporation.getCorporation(corporationPK)).toJSONString();
                            break;
                        case ICorporationOperation.SELECT_Station:
                            IStationPK stationPK = (IStationPK)JSONStation.toStationPK((JSONObject)json.get("stationpk"));
                            result = JSONCorporation.toJSONArray(blcorporation.getCorporations4station(stationPK)).toJSONString();
                            break;
                        case ICorporationOperation.SELECT_Faction:
                            IFactionPK factionPK = (IFactionPK)JSONFaction.toFactionPK((JSONObject)json.get("factionpk"));
                            result = JSONCorporation.toJSONArray(blcorporation.getCorporations4faction(factionPK)).toJSONString();
                            break;
                        case ICorporationOperation.SELECT_Alliance:
                            IAlliancePK alliancePK = (IAlliancePK)JSONAlliance.toAlliancePK((JSONObject)json.get("alliancepk"));
                            result = JSONCorporation.toJSONArray(blcorporation.getCorporations4alliance(alliancePK)).toJSONString();
                            break;
                        case ICorporationOperation.SELECT_SEARCH:
                            ICorporationsearch search = (ICorporationsearch)JSONCorporation.toCorporationsearch((JSONObject)json.get("search"));
                            result = JSONCorporation.toJSONArray(blcorporation.search(search)).toJSONString();
                            break;
                        case ICorporationOperation.SELECT_SEARCHCOUNT:
                            ICorporationsearch corporationsearch = (ICorporationsearch)JSONCorporation.toCorporationsearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blcorporation.searchcount(corporationsearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREINSERT:
                    switch(operation) {
                        case ICorporationOperation.INSERT_CORPORATION:
                            corporation = (ICorporation)JSONCorporation.toCorporation((JSONObject)json.get("corporation"));
                            blcorporation.secureinsertCorporation(corporation);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREUPDATE:
                    switch(operation) {
                        case ICorporationOperation.UPDATE_CORPORATION:
                            JSONObject jsoncorporation = (JSONObject)json.get("corporation");
                            corporationPK = JSONCorporation.toCorporationPK((JSONObject)jsoncorporation.get("PK"));
                            corporation = blcorporation.getCorporation(corporationPK);
                            JSONCorporation.updateCorporation(corporation, jsoncorporation);
                            blcorporation.secureupdateCorporation(corporation);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREDELETE:
                    switch(operation) {
                        case ICorporationOperation.DELETE_CORPORATION:
                            corporation = (ICorporation)JSONCorporation.toCorporation((JSONObject)json.get("corporation"));
                            blcorporation.securedeleteCorporation(corporation);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
            }
        }
        catch(ParseException e) {
            result = returnstatus(e.getMessage());
        }
        catch(CustomException e) {
            result = returnstatus(e.getMessage());
        }
        return result;
    }

    private String returnstatus(String status) {
        JSONObject json = new JSONObject();
        json.put("status", status);
        return json.toJSONString();
    }

    /**
     * PUT method for updating or creating an instance of RSCorporation
     * @param content representation for the resource
     */
    @PUT
    @Consumes("text/html")
    public void put(String content) {
    }
}

