/*
 * RSContractitem.java
 *
 * Generated on 14.0.2022 16:56
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
import eve.interfaces.searchentity.IContractitemsearch;
import eve.interfaces.servlet.IContractitemOperation;
import eve.logicentity.Contractitem;
import eve.searchentity.Contractitemsearch;
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
@Path("rscontractitem")
public class RSContractitem {

    /**
     * Creates a new instance of HelloWorld
     */
    public RSContractitem() {
    }

    /**
     * Retrieves representation of an instance of contractitem.restservices.RSContractitem
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{json}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@PathParam("json") String jsonstring) {
        try {
            BLcontractitem blcontractitem = new BLcontractitem();
            ArrayList contractitems = blcontractitem.getAll();
            JSONArray jsoncontractitems = JSONContractitem.toJSONArray(contractitems);
            return jsoncontractitems.toJSONString();
        }
        catch(DBException e) {
            return "{ \"status\": \"error\"}";
        }
    }

    /**
     * Retrieves representation of an instance of contractitem.restservices.RSContractitem
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        String result = "";
        BLcontractitem blcontractitem = new BLcontractitem();
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject)parser.parse(jsonstring);
            JSONObject jsonoperation = (JSONObject)json.get("operation");
            byte operationtype = JSONConversion.getbyte(jsonoperation, "type");
            byte operation = JSONConversion.getbyte(jsonoperation, "operation");
            IContractitemPK contractitemPK;
            IContractitem contractitem;
//Security parameters
            boolean loggedin = RSsecurity.check(json);
            blcontractitem.setAuthenticated(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    switch(operation) {
                        case IContractitemOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blcontractitem.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IContractitemOperation.SELECT_ALL:
                            result = JSONContractitem.toJSONArray(blcontractitem.getContractitems()).toJSONString();
                            break;
                        case IContractitemOperation.SELECT_CONTRACTITEM:
                            contractitemPK = (IContractitemPK)JSONContractitem.toContractitemPK((JSONObject)json.get("contractitempk"));
                            result = JSONContractitem.toJSON(blcontractitem.getContractitem(contractitemPK)).toJSONString();
                            break;
                        case IContractitemOperation.SELECT_Evetype:
                            IEvetypePK evetypePK = (IEvetypePK)JSONEvetype.toEvetypePK((JSONObject)json.get("evetypepk"));
                            result = JSONContractitem.toJSONArray(blcontractitem.getContractitems4evetype(evetypePK)).toJSONString();
                            break;
                        case IContractitemOperation.SELECT_Contract:
                            IContractPK contractPK = (IContractPK)JSONContract.toContractPK((JSONObject)json.get("contractpk"));
                            result = JSONContractitem.toJSONArray(blcontractitem.getContractitems4contract(contractPK)).toJSONString();
                            break;
                        case IContractitemOperation.SELECT_SEARCH:
                            IContractitemsearch search = (IContractitemsearch)JSONContractitem.toContractitemsearch((JSONObject)json.get("search"));
                            result = JSONContractitem.toJSONArray(blcontractitem.search(search)).toJSONString();
                            break;
                        case IContractitemOperation.SELECT_SEARCHCOUNT:
                            IContractitemsearch contractitemsearch = (IContractitemsearch)JSONContractitem.toContractitemsearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blcontractitem.searchcount(contractitemsearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(operation) {
                        case IContractitemOperation.INSERT_CONTRACTITEM:
                            contractitem = (IContractitem)JSONContractitem.toContractitem((JSONObject)json.get("contractitem"));
                            blcontractitem.insertContractitem(contractitem);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(operation) {
                        case IContractitemOperation.UPDATE_CONTRACTITEM:
                            JSONObject jsoncontractitem = (JSONObject)json.get("contractitem");
                            contractitemPK = JSONContractitem.toContractitemPK((JSONObject)jsoncontractitem.get("PK"));
                            contractitem = blcontractitem.getContractitem(contractitemPK);
                            JSONContractitem.updateContractitem(contractitem, jsoncontractitem);
                            blcontractitem.updateContractitem(contractitem);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(operation) {
                        case IContractitemOperation.DELETE_CONTRACTITEM:
                            contractitem = (IContractitem)JSONContractitem.toContractitem((JSONObject)json.get("contractitem"));
                            blcontractitem.deleteContractitem(contractitem);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECURESELECT:
                    switch(operation) {
                        case IContractitemOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blcontractitem.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IContractitemOperation.SELECT_ALL:
                            result = JSONContractitem.toJSONArray(blcontractitem.getContractitems()).toJSONString();
                            break;
                        case IContractitemOperation.SELECT_CONTRACTITEM:
                            contractitemPK = (IContractitemPK)JSONContractitem.toContractitemPK((JSONObject)json.get("contractitempk"));
                            result = JSONContractitem.toJSON(blcontractitem.getContractitem(contractitemPK)).toJSONString();
                            break;
                        case IContractitemOperation.SELECT_Evetype:
                            IEvetypePK evetypePK = (IEvetypePK)JSONEvetype.toEvetypePK((JSONObject)json.get("evetypepk"));
                            result = JSONContractitem.toJSONArray(blcontractitem.getContractitems4evetype(evetypePK)).toJSONString();
                            break;
                        case IContractitemOperation.SELECT_Contract:
                            IContractPK contractPK = (IContractPK)JSONContract.toContractPK((JSONObject)json.get("contractpk"));
                            result = JSONContractitem.toJSONArray(blcontractitem.getContractitems4contract(contractPK)).toJSONString();
                            break;
                        case IContractitemOperation.SELECT_SEARCH:
                            IContractitemsearch search = (IContractitemsearch)JSONContractitem.toContractitemsearch((JSONObject)json.get("search"));
                            result = JSONContractitem.toJSONArray(blcontractitem.search(search)).toJSONString();
                            break;
                        case IContractitemOperation.SELECT_SEARCHCOUNT:
                            IContractitemsearch contractitemsearch = (IContractitemsearch)JSONContractitem.toContractitemsearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blcontractitem.searchcount(contractitemsearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREINSERT:
                    switch(operation) {
                        case IContractitemOperation.INSERT_CONTRACTITEM:
                            contractitem = (IContractitem)JSONContractitem.toContractitem((JSONObject)json.get("contractitem"));
                            blcontractitem.secureinsertContractitem(contractitem);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREUPDATE:
                    switch(operation) {
                        case IContractitemOperation.UPDATE_CONTRACTITEM:
                            JSONObject jsoncontractitem = (JSONObject)json.get("contractitem");
                            contractitemPK = JSONContractitem.toContractitemPK((JSONObject)jsoncontractitem.get("PK"));
                            contractitem = blcontractitem.getContractitem(contractitemPK);
                            JSONContractitem.updateContractitem(contractitem, jsoncontractitem);
                            blcontractitem.secureupdateContractitem(contractitem);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREDELETE:
                    switch(operation) {
                        case IContractitemOperation.DELETE_CONTRACTITEM:
                            contractitem = (IContractitem)JSONContractitem.toContractitem((JSONObject)json.get("contractitem"));
                            blcontractitem.securedeleteContractitem(contractitem);
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
     * PUT method for updating or creating an instance of RSContractitem
     * @param content representation for the resource
     */
    @PUT
    @Consumes("text/html")
    public void put(String content) {
    }
}

