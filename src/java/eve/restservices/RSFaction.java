/*
 * RSFaction.java
 *
 * Generated on 6.9.2021 16:29
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
import eve.interfaces.searchentity.IFactionsearch;
import eve.interfaces.servlet.IFactionOperation;
import eve.logicentity.Faction;
import eve.searchentity.Factionsearch;
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
@Path("rsfaction")
public class RSFaction {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of HelloWorld
     */
    public RSFaction() {
    }

    /**
     * Retrieves representation of an instance of faction.restservices.RSFaction
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{json}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@PathParam("json") String jsonstring) {
        try {
            BLfaction blfaction = new BLfaction();
            ArrayList factions = blfaction.getAll();
            JSONArray jsonfactions = JSONFaction.toJSONArray(factions);
            return jsonfactions.toJSONString();
        }
        catch(DBException e) {
            return "{ \"status\": \"error\"}";
        }
    }

    /**
     * Retrieves representation of an instance of faction.restservices.RSFaction
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        String result = "";
        BLfaction blfaction = new BLfaction();
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject)parser.parse(jsonstring);
            JSONObject jsonoperation = (JSONObject)json.get("operation");
            byte operationtype = JSONConversion.getbyte(jsonoperation, "type");
            byte operation = JSONConversion.getbyte(jsonoperation, "operation");
            IFactionPK factionPK;
            IFaction faction;
//Security parameters
            boolean loggedin = RSsecurity.check(json);
            blfaction.setAuthenticated(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    switch(operation) {
                        case IFactionOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blfaction.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IFactionOperation.SELECT_ALL:
                            result = JSONFaction.toJSONArray(blfaction.getFactions()).toJSONString();
                            break;
                        case IFactionOperation.SELECT_FACTION:
                            factionPK = (IFactionPK)JSONFaction.toFactionPK((JSONObject)json.get("factionpk"));
                            result = JSONFaction.toJSON(blfaction.getFaction(factionPK)).toJSONString();
                            break;
                        case IFactionOperation.SELECT_System:
                            ISystemPK systemPK = (ISystemPK)JSONSystem.toSystemPK((JSONObject)json.get("systempk"));
                            result = JSONFaction.toJSONArray(blfaction.getFactions4system(systemPK)).toJSONString();
                            break;
                        case IFactionOperation.SELECT_SEARCH:
                            IFactionsearch search = (IFactionsearch)JSONFaction.toFactionsearch((JSONObject)json.get("search"));
                            result = JSONFaction.toJSONArray(blfaction.search(search)).toJSONString();
                            break;
                        case IFactionOperation.SELECT_SEARCHCOUNT:
                            IFactionsearch factionsearch = (IFactionsearch)JSONFaction.toFactionsearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blfaction.searchcount(factionsearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(operation) {
                        case IFactionOperation.INSERT_FACTION:
                            faction = (IFaction)JSONFaction.toFaction((JSONObject)json.get("faction"));
                            blfaction.insertFaction(faction);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(operation) {
                        case IFactionOperation.UPDATE_FACTION:
                            JSONObject jsonfaction = (JSONObject)json.get("faction");
                            factionPK = JSONFaction.toFactionPK((JSONObject)jsonfaction.get("PK"));
                            faction = blfaction.getFaction(factionPK);
                            JSONFaction.updateFaction(faction, jsonfaction);
                            blfaction.updateFaction(faction);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(operation) {
                        case IFactionOperation.DELETE_FACTION:
                            faction = (IFaction)JSONFaction.toFaction((JSONObject)json.get("faction"));
                            blfaction.deleteFaction(faction);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECURESELECT:
                    switch(operation) {
                        case IFactionOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blfaction.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IFactionOperation.SELECT_ALL:
                            result = JSONFaction.toJSONArray(blfaction.getFactions()).toJSONString();
                            break;
                        case IFactionOperation.SELECT_FACTION:
                            factionPK = (IFactionPK)JSONFaction.toFactionPK((JSONObject)json.get("factionpk"));
                            result = JSONFaction.toJSON(blfaction.getFaction(factionPK)).toJSONString();
                            break;
                        case IFactionOperation.SELECT_System:
                            ISystemPK systemPK = (ISystemPK)JSONSystem.toSystemPK((JSONObject)json.get("systempk"));
                            result = JSONFaction.toJSONArray(blfaction.getFactions4system(systemPK)).toJSONString();
                            break;
                        case IFactionOperation.SELECT_SEARCH:
                            IFactionsearch search = (IFactionsearch)JSONFaction.toFactionsearch((JSONObject)json.get("search"));
                            result = JSONFaction.toJSONArray(blfaction.search(search)).toJSONString();
                            break;
                        case IFactionOperation.SELECT_SEARCHCOUNT:
                            IFactionsearch factionsearch = (IFactionsearch)JSONFaction.toFactionsearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blfaction.searchcount(factionsearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREINSERT:
                    switch(operation) {
                        case IFactionOperation.INSERT_FACTION:
                            faction = (IFaction)JSONFaction.toFaction((JSONObject)json.get("faction"));
                            blfaction.secureinsertFaction(faction);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREUPDATE:
                    switch(operation) {
                        case IFactionOperation.UPDATE_FACTION:
                            JSONObject jsonfaction = (JSONObject)json.get("faction");
                            factionPK = JSONFaction.toFactionPK((JSONObject)jsonfaction.get("PK"));
                            faction = blfaction.getFaction(factionPK);
                            JSONFaction.updateFaction(faction, jsonfaction);
                            blfaction.secureupdateFaction(faction);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREDELETE:
                    switch(operation) {
                        case IFactionOperation.DELETE_FACTION:
                            faction = (IFaction)JSONFaction.toFaction((JSONObject)json.get("faction"));
                            blfaction.securedeleteFaction(faction);
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
     * PUT method for updating or creating an instance of RSFaction
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("text/html")
    public void put(String content) {
    }
}

