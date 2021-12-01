/*
 * RSAlliance.java
 *
 * Generated on 30.10.2021 10:3
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
import eve.interfaces.searchentity.IAlliancesearch;
import eve.interfaces.servlet.IAllianceOperation;
import eve.logicentity.Alliance;
import eve.searchentity.Alliancesearch;
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
@Path("rsalliance")
public class RSAlliance {

    /**
     * Creates a new instance of HelloWorld
     */
    public RSAlliance() {
    }

    /**
     * Retrieves representation of an instance of alliance.restservices.RSAlliance
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{json}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@PathParam("json") String jsonstring) {
        try {
            BLalliance blalliance = new BLalliance();
            ArrayList alliances = blalliance.getAll();
            JSONArray jsonalliances = JSONAlliance.toJSONArray(alliances);
            return jsonalliances.toJSONString();
        }
        catch(DBException e) {
            return "{ \"status\": \"error\"}";
        }
    }

    /**
     * Retrieves representation of an instance of alliance.restservices.RSAlliance
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        String result = "";
        BLalliance blalliance = new BLalliance();
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject)parser.parse(jsonstring);
            JSONObject jsonoperation = (JSONObject)json.get("operation");
            byte operationtype = JSONConversion.getbyte(jsonoperation, "type");
            byte operation = JSONConversion.getbyte(jsonoperation, "operation");
            IAlliancePK alliancePK;
            IAlliance alliance;
//Security parameters
            boolean loggedin = RSsecurity.check(json);
            blalliance.setAuthenticated(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    switch(operation) {
                        case IAllianceOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blalliance.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IAllianceOperation.SELECT_ALL:
                            result = JSONAlliance.toJSONArray(blalliance.getAlliances()).toJSONString();
                            break;
                        case IAllianceOperation.SELECT_ALLIANCE:
                            alliancePK = (IAlliancePK)JSONAlliance.toAlliancePK((JSONObject)json.get("alliancepk"));
                            result = JSONAlliance.toJSON(blalliance.getAlliance(alliancePK)).toJSONString();
                            break;
                        case IAllianceOperation.SELECT_Corporationcreator_corporation:
                            ICorporationPK corporationCreator_corporationPK = (ICorporationPK)JSONCorporation.toCorporationPK((JSONObject)json.get("corporationpk"));
                            result = JSONAlliance.toJSONArray(blalliance.getAlliances4corporationCreator_corporation(corporationCreator_corporationPK)).toJSONString();
                            break;
                        case IAllianceOperation.SELECT_Corporationexecutor_corporation:
                            ICorporationPK corporationExecutor_corporationPK = (ICorporationPK)JSONCorporation.toCorporationPK((JSONObject)json.get("corporationpk"));
                            result = JSONAlliance.toJSONArray(blalliance.getAlliances4corporationExecutor_corporation(corporationExecutor_corporationPK)).toJSONString();
                            break;
                        case IAllianceOperation.SELECT_SEARCH:
                            IAlliancesearch search = (IAlliancesearch)JSONAlliance.toAlliancesearch((JSONObject)json.get("search"));
                            result = JSONAlliance.toJSONArray(blalliance.search(search)).toJSONString();
                            break;
                        case IAllianceOperation.SELECT_SEARCHCOUNT:
                            IAlliancesearch alliancesearch = (IAlliancesearch)JSONAlliance.toAlliancesearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blalliance.searchcount(alliancesearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(operation) {
                        case IAllianceOperation.INSERT_ALLIANCE:
                            alliance = (IAlliance)JSONAlliance.toAlliance((JSONObject)json.get("alliance"));
                            blalliance.insertAlliance(alliance);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(operation) {
                        case IAllianceOperation.UPDATE_ALLIANCE:
                            JSONObject jsonalliance = (JSONObject)json.get("alliance");
                            alliancePK = JSONAlliance.toAlliancePK((JSONObject)jsonalliance.get("PK"));
                            alliance = blalliance.getAlliance(alliancePK);
                            JSONAlliance.updateAlliance(alliance, jsonalliance);
                            blalliance.updateAlliance(alliance);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(operation) {
                        case IAllianceOperation.DELETE_ALLIANCE:
                            alliance = (IAlliance)JSONAlliance.toAlliance((JSONObject)json.get("alliance"));
                            blalliance.deleteAlliance(alliance);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECURESELECT:
                    switch(operation) {
                        case IAllianceOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blalliance.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IAllianceOperation.SELECT_ALL:
                            result = JSONAlliance.toJSONArray(blalliance.getAlliances()).toJSONString();
                            break;
                        case IAllianceOperation.SELECT_ALLIANCE:
                            alliancePK = (IAlliancePK)JSONAlliance.toAlliancePK((JSONObject)json.get("alliancepk"));
                            result = JSONAlliance.toJSON(blalliance.getAlliance(alliancePK)).toJSONString();
                            break;
                        case IAllianceOperation.SELECT_Corporationcreator_corporation:
                            ICorporationPK corporationCreator_corporationPK = (ICorporationPK)JSONCorporation.toCorporationPK((JSONObject)json.get("corporationpk"));
                            result = JSONAlliance.toJSONArray(blalliance.getAlliances4corporationCreator_corporation(corporationCreator_corporationPK)).toJSONString();
                            break;
                        case IAllianceOperation.SELECT_Corporationexecutor_corporation:
                            ICorporationPK corporationExecutor_corporationPK = (ICorporationPK)JSONCorporation.toCorporationPK((JSONObject)json.get("corporationpk"));
                            result = JSONAlliance.toJSONArray(blalliance.getAlliances4corporationExecutor_corporation(corporationExecutor_corporationPK)).toJSONString();
                            break;
                        case IAllianceOperation.SELECT_SEARCH:
                            IAlliancesearch search = (IAlliancesearch)JSONAlliance.toAlliancesearch((JSONObject)json.get("search"));
                            result = JSONAlliance.toJSONArray(blalliance.search(search)).toJSONString();
                            break;
                        case IAllianceOperation.SELECT_SEARCHCOUNT:
                            IAlliancesearch alliancesearch = (IAlliancesearch)JSONAlliance.toAlliancesearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blalliance.searchcount(alliancesearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREINSERT:
                    switch(operation) {
                        case IAllianceOperation.INSERT_ALLIANCE:
                            alliance = (IAlliance)JSONAlliance.toAlliance((JSONObject)json.get("alliance"));
                            blalliance.secureinsertAlliance(alliance);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREUPDATE:
                    switch(operation) {
                        case IAllianceOperation.UPDATE_ALLIANCE:
                            JSONObject jsonalliance = (JSONObject)json.get("alliance");
                            alliancePK = JSONAlliance.toAlliancePK((JSONObject)jsonalliance.get("PK"));
                            alliance = blalliance.getAlliance(alliancePK);
                            JSONAlliance.updateAlliance(alliance, jsonalliance);
                            blalliance.secureupdateAlliance(alliance);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREDELETE:
                    switch(operation) {
                        case IAllianceOperation.DELETE_ALLIANCE:
                            alliance = (IAlliance)JSONAlliance.toAlliance((JSONObject)json.get("alliance"));
                            blalliance.securedeleteAlliance(alliance);
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
     * PUT method for updating or creating an instance of RSAlliance
     * @param content representation for the resource
     */
    @PUT
    @Consumes("text/html")
    public void put(String content) {
    }
}

