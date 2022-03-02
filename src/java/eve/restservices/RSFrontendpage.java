/*
 * RSFrontendpage.java
 *
 * Generated on 16.1.2022 20:53
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
import eve.interfaces.searchentity.IFrontendpagesearch;
import eve.interfaces.servlet.IFrontendpageOperation;
import eve.logicentity.Frontendpage;
import eve.searchentity.Frontendpagesearch;
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
@Path("rsfrontendpage")
public class RSFrontendpage {

    /**
     * Creates a new instance of HelloWorld
     */
    public RSFrontendpage() {
    }

    /**
     * Retrieves representation of an instance of frontendpage.restservices.RSFrontendpage
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{json}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@PathParam("json") String jsonstring) {
        try {
            BLfrontendpage blfrontendpage = new BLfrontendpage();
            ArrayList frontendpages = blfrontendpage.getAll();
            JSONArray jsonfrontendpages = JSONFrontendpage.toJSONArray(frontendpages);
            return jsonfrontendpages.toJSONString();
        }
        catch(DBException e) {
            return "{ \"status\": \"error\"}";
        }
    }

    /**
     * Retrieves representation of an instance of frontendpage.restservices.RSFrontendpage
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        String result = "";
        BLfrontendpage blfrontendpage = new BLfrontendpage();
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject)parser.parse(jsonstring);
            JSONObject jsonoperation = (JSONObject)json.get("operation");
            byte operationtype = JSONConversion.getbyte(jsonoperation, "type");
            byte operation = JSONConversion.getbyte(jsonoperation, "operation");
            IFrontendpagePK frontendpagePK;
            IFrontendpage frontendpage;
//Security parameters
            boolean loggedin = RSsecurity.check(json);
            blfrontendpage.setAuthenticated(loggedin);
//Custom code, do not change this line
//add here custom operations
            //Select is allowed for all, anything else needs USERS authorization
            String auth = (String)json.get("auth");
            String username = "";
            try {
                username = Securitycheck.getUsername(auth);
            }
            catch(IOException e) {
            }
            if(operationtype!=DataServlet.OPERATIONTYPE_SELECT && operationtype!=DataServlet.OPERATIONTYPE_SECURESELECT) {
                BLfrontendpage_auth blfrontendpage_auth = new BLfrontendpage_auth();
                blfrontendpage_auth.setAuthenticated(true);
                loggedin = loggedin && blfrontendpage_auth.checkAuth(username, BLfrontendpage.USERS);
            }
            blfrontendpage.setAuthenticated(loggedin);
//Custom code, do not change this line   
            switch(operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    switch(operation) {
                        case IFrontendpageOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blfrontendpage.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IFrontendpageOperation.SELECT_ALL:
                            result = JSONFrontendpage.toJSONArray(blfrontendpage.getFrontendpages()).toJSONString();
                            break;
                        case IFrontendpageOperation.SELECT_FRONTENDPAGE:
                            frontendpagePK = (IFrontendpagePK)JSONFrontendpage.toFrontendpagePK((JSONObject)json.get("frontendpagepk"));
                            result = JSONFrontendpage.toJSON(blfrontendpage.getFrontendpage(frontendpagePK)).toJSONString();
                            break;
                        case IFrontendpageOperation.SELECT_Frontendpage_auth:
                            IFrontendpage_authPK frontendpage_authPK = (IFrontendpage_authPK)JSONFrontendpage_auth.toFrontendpage_authPK((JSONObject)json.get("frontendpage_authpk"));
                            result = JSONFrontendpage.toJSON(blfrontendpage.getFrontendpage_auth(frontendpage_authPK)).toJSONString();
                            break;
                        case IFrontendpageOperation.SELECT_SEARCH:
                            IFrontendpagesearch search = (IFrontendpagesearch)JSONFrontendpage.toFrontendpagesearch((JSONObject)json.get("search"));
                            result = JSONFrontendpage.toJSONArray(blfrontendpage.search(search)).toJSONString();
                            break;
                        case IFrontendpageOperation.SELECT_SEARCHCOUNT:
                            IFrontendpagesearch frontendpagesearch = (IFrontendpagesearch)JSONFrontendpage.toFrontendpagesearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blfrontendpage.searchcount(frontendpagesearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(operation) {
                        case IFrontendpageOperation.INSERT_FRONTENDPAGE:
                            frontendpage = (IFrontendpage)JSONFrontendpage.toFrontendpage((JSONObject)json.get("frontendpage"));
                            blfrontendpage.insertFrontendpage(frontendpage);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(operation) {
                        case IFrontendpageOperation.UPDATE_FRONTENDPAGE:
                            JSONObject jsonfrontendpage = (JSONObject)json.get("frontendpage");
                            frontendpagePK = JSONFrontendpage.toFrontendpagePK((JSONObject)jsonfrontendpage.get("PK"));
                            frontendpage = blfrontendpage.getFrontendpage(frontendpagePK);
                            JSONFrontendpage.updateFrontendpage(frontendpage, jsonfrontendpage);
                            blfrontendpage.updateFrontendpage(frontendpage);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(operation) {
                        case IFrontendpageOperation.DELETE_FRONTENDPAGE:
                            frontendpage = (IFrontendpage)JSONFrontendpage.toFrontendpage((JSONObject)json.get("frontendpage"));
                            blfrontendpage.deleteFrontendpage(frontendpage);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECURESELECT:
                    switch(operation) {
                        case IFrontendpageOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blfrontendpage.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IFrontendpageOperation.SELECT_ALL:
                            result = JSONFrontendpage.toJSONArray(blfrontendpage.getFrontendpages()).toJSONString();
                            break;
                        case IFrontendpageOperation.SELECT_FRONTENDPAGE:
                            frontendpagePK = (IFrontendpagePK)JSONFrontendpage.toFrontendpagePK((JSONObject)json.get("frontendpagepk"));
                            result = JSONFrontendpage.toJSON(blfrontendpage.getFrontendpage(frontendpagePK)).toJSONString();
                            break;
                        case IFrontendpageOperation.SELECT_Frontendpage_auth:
                            IFrontendpage_authPK frontendpage_authPK = (IFrontendpage_authPK)JSONFrontendpage_auth.toFrontendpage_authPK((JSONObject)json.get("frontendpage_authpk"));
                            result = JSONFrontendpage.toJSON(blfrontendpage.getFrontendpage_auth(frontendpage_authPK)).toJSONString();
                            break;
                        case IFrontendpageOperation.SELECT_SEARCH:
                            IFrontendpagesearch search = (IFrontendpagesearch)JSONFrontendpage.toFrontendpagesearch((JSONObject)json.get("search"));
                            result = JSONFrontendpage.toJSONArray(blfrontendpage.search(search)).toJSONString();
                            break;
                        case IFrontendpageOperation.SELECT_SEARCHCOUNT:
                            IFrontendpagesearch frontendpagesearch = (IFrontendpagesearch)JSONFrontendpage.toFrontendpagesearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blfrontendpage.searchcount(frontendpagesearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREINSERT:
                    switch(operation) {
                        case IFrontendpageOperation.INSERT_FRONTENDPAGE:
                            frontendpage = (IFrontendpage)JSONFrontendpage.toFrontendpage((JSONObject)json.get("frontendpage"));
                            blfrontendpage.secureinsertFrontendpage(frontendpage);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREUPDATE:
                    switch(operation) {
                        case IFrontendpageOperation.UPDATE_FRONTENDPAGE:
                            JSONObject jsonfrontendpage = (JSONObject)json.get("frontendpage");
                            frontendpagePK = JSONFrontendpage.toFrontendpagePK((JSONObject)jsonfrontendpage.get("PK"));
                            frontendpage = blfrontendpage.getFrontendpage(frontendpagePK);
                            JSONFrontendpage.updateFrontendpage(frontendpage, jsonfrontendpage);
                            blfrontendpage.secureupdateFrontendpage(frontendpage);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREDELETE:
                    switch(operation) {
                        case IFrontendpageOperation.DELETE_FRONTENDPAGE:
                            frontendpage = (IFrontendpage)JSONFrontendpage.toFrontendpage((JSONObject)json.get("frontendpage"));
                            blfrontendpage.securedeleteFrontendpage(frontendpage);
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
     * PUT method for updating or creating an instance of RSFrontendpage
     * @param content representation for the resource
     */
    @PUT
    @Consumes("text/html")
    public void put(String content) {
    }
}

