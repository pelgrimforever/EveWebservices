/*
 * RSBpmaterial.java
 *
 * Generated on 24.0.2022 16:47
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
import eve.interfaces.searchentity.IBpmaterialsearch;
import eve.interfaces.servlet.IBpmaterialOperation;
import eve.logicentity.Bpmaterial;
import eve.searchentity.Bpmaterialsearch;
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
@Path("rsbpmaterial")
public class RSBpmaterial {

    /**
     * Creates a new instance of HelloWorld
     */
    public RSBpmaterial() {
    }

    /**
     * Retrieves representation of an instance of bpmaterial.restservices.RSBpmaterial
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{json}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@PathParam("json") String jsonstring) {
        try {
            BLbpmaterial blbpmaterial = new BLbpmaterial();
            ArrayList bpmaterials = blbpmaterial.getAll();
            JSONArray jsonbpmaterials = JSONBpmaterial.toJSONArray(bpmaterials);
            return jsonbpmaterials.toJSONString();
        }
        catch(DBException e) {
            return "{ \"status\": \"error\"}";
        }
    }

    /**
     * Retrieves representation of an instance of bpmaterial.restservices.RSBpmaterial
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        String result = "";
        BLbpmaterial blbpmaterial = new BLbpmaterial();
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject)parser.parse(jsonstring);
            JSONObject jsonoperation = (JSONObject)json.get("operation");
            byte operationtype = JSONConversion.getbyte(jsonoperation, "type");
            byte operation = JSONConversion.getbyte(jsonoperation, "operation");
            IBpmaterialPK bpmaterialPK;
            IBpmaterial bpmaterial;
//Security parameters
            boolean loggedin = RSsecurity.check(json);
            blbpmaterial.setAuthenticated(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    switch(operation) {
                        case IBpmaterialOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blbpmaterial.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IBpmaterialOperation.SELECT_ALL:
                            result = JSONBpmaterial.toJSONArray(blbpmaterial.getBpmaterials()).toJSONString();
                            break;
                        case IBpmaterialOperation.SELECT_BPMATERIAL:
                            bpmaterialPK = (IBpmaterialPK)JSONBpmaterial.toBpmaterialPK((JSONObject)json.get("bpmaterialpk"));
                            result = JSONBpmaterial.toJSON(blbpmaterial.getBpmaterial(bpmaterialPK)).toJSONString();
                            break;
                        case IBpmaterialOperation.SELECT_Evetypebp:
                            IEvetypePK evetypeBpPK = (IEvetypePK)JSONEvetype.toEvetypePK((JSONObject)json.get("evetypepk"));
                            result = JSONBpmaterial.toJSONArray(blbpmaterial.getBpmaterials4evetypeBp(evetypeBpPK)).toJSONString();
                            break;
                        case IBpmaterialOperation.SELECT_Evetypematerial:
                            IEvetypePK evetypeMaterialPK = (IEvetypePK)JSONEvetype.toEvetypePK((JSONObject)json.get("evetypepk"));
                            result = JSONBpmaterial.toJSONArray(blbpmaterial.getBpmaterials4evetypeMaterial(evetypeMaterialPK)).toJSONString();
                            break;
                        case IBpmaterialOperation.SELECT_SEARCH:
                            IBpmaterialsearch search = (IBpmaterialsearch)JSONBpmaterial.toBpmaterialsearch((JSONObject)json.get("search"));
                            result = JSONBpmaterial.toJSONArray(blbpmaterial.search(search)).toJSONString();
                            break;
                        case IBpmaterialOperation.SELECT_SEARCHCOUNT:
                            IBpmaterialsearch bpmaterialsearch = (IBpmaterialsearch)JSONBpmaterial.toBpmaterialsearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blbpmaterial.searchcount(bpmaterialsearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(operation) {
                        case IBpmaterialOperation.INSERT_BPMATERIAL:
                            bpmaterial = (IBpmaterial)JSONBpmaterial.toBpmaterial((JSONObject)json.get("bpmaterial"));
                            blbpmaterial.insertBpmaterial(bpmaterial);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(operation) {
                        case IBpmaterialOperation.UPDATE_BPMATERIAL:
                            JSONObject jsonbpmaterial = (JSONObject)json.get("bpmaterial");
                            bpmaterialPK = JSONBpmaterial.toBpmaterialPK((JSONObject)jsonbpmaterial.get("PK"));
                            bpmaterial = blbpmaterial.getBpmaterial(bpmaterialPK);
                            JSONBpmaterial.updateBpmaterial(bpmaterial, jsonbpmaterial);
                            blbpmaterial.updateBpmaterial(bpmaterial);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(operation) {
                        case IBpmaterialOperation.DELETE_BPMATERIAL:
                            bpmaterial = (IBpmaterial)JSONBpmaterial.toBpmaterial((JSONObject)json.get("bpmaterial"));
                            blbpmaterial.deleteBpmaterial(bpmaterial);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECURESELECT:
                    switch(operation) {
                        case IBpmaterialOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blbpmaterial.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IBpmaterialOperation.SELECT_ALL:
                            result = JSONBpmaterial.toJSONArray(blbpmaterial.getBpmaterials()).toJSONString();
                            break;
                        case IBpmaterialOperation.SELECT_BPMATERIAL:
                            bpmaterialPK = (IBpmaterialPK)JSONBpmaterial.toBpmaterialPK((JSONObject)json.get("bpmaterialpk"));
                            result = JSONBpmaterial.toJSON(blbpmaterial.getBpmaterial(bpmaterialPK)).toJSONString();
                            break;
                        case IBpmaterialOperation.SELECT_Evetypebp:
                            IEvetypePK evetypeBpPK = (IEvetypePK)JSONEvetype.toEvetypePK((JSONObject)json.get("evetypepk"));
                            result = JSONBpmaterial.toJSONArray(blbpmaterial.getBpmaterials4evetypeBp(evetypeBpPK)).toJSONString();
                            break;
                        case IBpmaterialOperation.SELECT_Evetypematerial:
                            IEvetypePK evetypeMaterialPK = (IEvetypePK)JSONEvetype.toEvetypePK((JSONObject)json.get("evetypepk"));
                            result = JSONBpmaterial.toJSONArray(blbpmaterial.getBpmaterials4evetypeMaterial(evetypeMaterialPK)).toJSONString();
                            break;
                        case IBpmaterialOperation.SELECT_SEARCH:
                            IBpmaterialsearch search = (IBpmaterialsearch)JSONBpmaterial.toBpmaterialsearch((JSONObject)json.get("search"));
                            result = JSONBpmaterial.toJSONArray(blbpmaterial.search(search)).toJSONString();
                            break;
                        case IBpmaterialOperation.SELECT_SEARCHCOUNT:
                            IBpmaterialsearch bpmaterialsearch = (IBpmaterialsearch)JSONBpmaterial.toBpmaterialsearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blbpmaterial.searchcount(bpmaterialsearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREINSERT:
                    switch(operation) {
                        case IBpmaterialOperation.INSERT_BPMATERIAL:
                            bpmaterial = (IBpmaterial)JSONBpmaterial.toBpmaterial((JSONObject)json.get("bpmaterial"));
                            blbpmaterial.secureinsertBpmaterial(bpmaterial);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREUPDATE:
                    switch(operation) {
                        case IBpmaterialOperation.UPDATE_BPMATERIAL:
                            JSONObject jsonbpmaterial = (JSONObject)json.get("bpmaterial");
                            bpmaterialPK = JSONBpmaterial.toBpmaterialPK((JSONObject)jsonbpmaterial.get("PK"));
                            bpmaterial = blbpmaterial.getBpmaterial(bpmaterialPK);
                            JSONBpmaterial.updateBpmaterial(bpmaterial, jsonbpmaterial);
                            blbpmaterial.secureupdateBpmaterial(bpmaterial);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREDELETE:
                    switch(operation) {
                        case IBpmaterialOperation.DELETE_BPMATERIAL:
                            bpmaterial = (IBpmaterial)JSONBpmaterial.toBpmaterial((JSONObject)json.get("bpmaterial"));
                            blbpmaterial.securedeleteBpmaterial(bpmaterial);
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
     * PUT method for updating or creating an instance of RSBpmaterial
     * @param content representation for the resource
     */
    @PUT
    @Consumes("text/html")
    public void put(String content) {
    }
}

