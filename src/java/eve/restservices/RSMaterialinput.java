/*
 * RSMaterialinput.java
 *
 * Generated on 17.0.2022 13:37
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
import eve.interfaces.searchentity.IMaterialinputsearch;
import eve.interfaces.servlet.IMaterialinputOperation;
import eve.logicentity.Materialinput;
import eve.searchentity.Materialinputsearch;
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
@Path("rsmaterialinput")
public class RSMaterialinput {

    /**
     * Creates a new instance of HelloWorld
     */
    public RSMaterialinput() {
    }

    /**
     * Retrieves representation of an instance of materialinput.restservices.RSMaterialinput
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{json}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@PathParam("json") String jsonstring) {
        try {
            BLmaterialinput blmaterialinput = new BLmaterialinput();
            ArrayList materialinputs = blmaterialinput.getAll();
            JSONArray jsonmaterialinputs = JSONMaterialinput.toJSONArray(materialinputs);
            return jsonmaterialinputs.toJSONString();
        }
        catch(DBException e) {
            return "{ \"status\": \"error\"}";
        }
    }

    /**
     * Retrieves representation of an instance of materialinput.restservices.RSMaterialinput
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        String result = "";
        BLmaterialinput blmaterialinput = new BLmaterialinput();
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject)parser.parse(jsonstring);
            JSONObject jsonoperation = (JSONObject)json.get("operation");
            byte operationtype = JSONConversion.getbyte(jsonoperation, "type");
            byte operation = JSONConversion.getbyte(jsonoperation, "operation");
            IMaterialinputPK materialinputPK;
            IMaterialinput materialinput;
//Security parameters
            boolean loggedin = RSsecurity.check(json);
            blmaterialinput.setAuthenticated(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    switch(operation) {
                        case IMaterialinputOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blmaterialinput.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IMaterialinputOperation.SELECT_ALL:
                            result = JSONMaterialinput.toJSONArray(blmaterialinput.getMaterialinputs()).toJSONString();
                            break;
                        case IMaterialinputOperation.SELECT_MATERIALINPUT:
                            materialinputPK = (IMaterialinputPK)JSONMaterialinput.toMaterialinputPK((JSONObject)json.get("materialinputpk"));
                            result = JSONMaterialinput.toJSON(blmaterialinput.getMaterialinput(materialinputPK)).toJSONString();
                            break;
                        case IMaterialinputOperation.SELECT_Evetype:
                            IEvetypePK evetypePK = (IEvetypePK)JSONEvetype.toEvetypePK((JSONObject)json.get("evetypepk"));
                            result = JSONMaterialinput.toJSONArray(blmaterialinput.getMaterialinputs4evetype(evetypePK)).toJSONString();
                            break;
                        case IMaterialinputOperation.SELECT_SEARCH:
                            IMaterialinputsearch search = (IMaterialinputsearch)JSONMaterialinput.toMaterialinputsearch((JSONObject)json.get("search"));
                            result = JSONMaterialinput.toJSONArray(blmaterialinput.search(search)).toJSONString();
                            break;
                        case IMaterialinputOperation.SELECT_SEARCHCOUNT:
                            IMaterialinputsearch materialinputsearch = (IMaterialinputsearch)JSONMaterialinput.toMaterialinputsearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blmaterialinput.searchcount(materialinputsearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(operation) {
                        case IMaterialinputOperation.INSERT_MATERIALINPUT:
                            materialinput = (IMaterialinput)JSONMaterialinput.toMaterialinput((JSONObject)json.get("materialinput"));
                            blmaterialinput.insertMaterialinput(materialinput);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(operation) {
                        case IMaterialinputOperation.UPDATE_MATERIALINPUT:
                            JSONObject jsonmaterialinput = (JSONObject)json.get("materialinput");
                            materialinputPK = JSONMaterialinput.toMaterialinputPK((JSONObject)jsonmaterialinput.get("PK"));
                            materialinput = blmaterialinput.getMaterialinput(materialinputPK);
                            JSONMaterialinput.updateMaterialinput(materialinput, jsonmaterialinput);
                            blmaterialinput.updateMaterialinput(materialinput);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(operation) {
                        case IMaterialinputOperation.DELETE_MATERIALINPUT:
                            materialinput = (IMaterialinput)JSONMaterialinput.toMaterialinput((JSONObject)json.get("materialinput"));
                            blmaterialinput.deleteMaterialinput(materialinput);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECURESELECT:
                    switch(operation) {
                        case IMaterialinputOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blmaterialinput.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IMaterialinputOperation.SELECT_ALL:
                            result = JSONMaterialinput.toJSONArray(blmaterialinput.getMaterialinputs()).toJSONString();
                            break;
                        case IMaterialinputOperation.SELECT_MATERIALINPUT:
                            materialinputPK = (IMaterialinputPK)JSONMaterialinput.toMaterialinputPK((JSONObject)json.get("materialinputpk"));
                            result = JSONMaterialinput.toJSON(blmaterialinput.getMaterialinput(materialinputPK)).toJSONString();
                            break;
                        case IMaterialinputOperation.SELECT_Evetype:
                            IEvetypePK evetypePK = (IEvetypePK)JSONEvetype.toEvetypePK((JSONObject)json.get("evetypepk"));
                            result = JSONMaterialinput.toJSONArray(blmaterialinput.getMaterialinputs4evetype(evetypePK)).toJSONString();
                            break;
                        case IMaterialinputOperation.SELECT_SEARCH:
                            IMaterialinputsearch search = (IMaterialinputsearch)JSONMaterialinput.toMaterialinputsearch((JSONObject)json.get("search"));
                            result = JSONMaterialinput.toJSONArray(blmaterialinput.search(search)).toJSONString();
                            break;
                        case IMaterialinputOperation.SELECT_SEARCHCOUNT:
                            IMaterialinputsearch materialinputsearch = (IMaterialinputsearch)JSONMaterialinput.toMaterialinputsearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blmaterialinput.searchcount(materialinputsearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREINSERT:
                    switch(operation) {
                        case IMaterialinputOperation.INSERT_MATERIALINPUT:
                            materialinput = (IMaterialinput)JSONMaterialinput.toMaterialinput((JSONObject)json.get("materialinput"));
                            blmaterialinput.secureinsertMaterialinput(materialinput);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREUPDATE:
                    switch(operation) {
                        case IMaterialinputOperation.UPDATE_MATERIALINPUT:
                            JSONObject jsonmaterialinput = (JSONObject)json.get("materialinput");
                            materialinputPK = JSONMaterialinput.toMaterialinputPK((JSONObject)jsonmaterialinput.get("PK"));
                            materialinput = blmaterialinput.getMaterialinput(materialinputPK);
                            JSONMaterialinput.updateMaterialinput(materialinput, jsonmaterialinput);
                            blmaterialinput.secureupdateMaterialinput(materialinput);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREDELETE:
                    switch(operation) {
                        case IMaterialinputOperation.DELETE_MATERIALINPUT:
                            materialinput = (IMaterialinput)JSONMaterialinput.toMaterialinput((JSONObject)json.get("materialinput"));
                            blmaterialinput.securedeleteMaterialinput(materialinput);
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
     * PUT method for updating or creating an instance of RSMaterialinput
     * @param content representation for the resource
     */
    @PUT
    @Consumes("text/html")
    public void put(String content) {
    }
}

