/*
 * RSFrontendpage_auth.java
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
import eve.interfaces.searchentity.IFrontendpage_authsearch;
import eve.interfaces.servlet.IFrontendpage_authOperation;
import eve.logicentity.Frontendpage_auth;
import eve.searchentity.Frontendpage_authsearch;
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
@Path("rsfrontendpage_auth")
public class RSFrontendpage_auth {

    /**
     * Creates a new instance of HelloWorld
     */
    public RSFrontendpage_auth() {
    }

    /**
     * Retrieves representation of an instance of frontendpage_auth.restservices.RSFrontendpage_auth
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{json}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@PathParam("json") String jsonstring) {
        try {
            BLfrontendpage_auth blfrontendpage_auth = new BLfrontendpage_auth();
            ArrayList frontendpage_auths = blfrontendpage_auth.getAll();
            JSONArray jsonfrontendpage_auths = JSONFrontendpage_auth.toJSONArray(frontendpage_auths);
            return jsonfrontendpage_auths.toJSONString();
        }
        catch(DBException e) {
            return "{ \"status\": \"error\"}";
        }
    }

    /**
     * Retrieves representation of an instance of frontendpage_auth.restservices.RSFrontendpage_auth
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        String result = "";
        BLfrontendpage_auth blfrontendpage_auth = new BLfrontendpage_auth();
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject)parser.parse(jsonstring);
            JSONObject jsonoperation = (JSONObject)json.get("operation");
            byte operationtype = JSONConversion.getbyte(jsonoperation, "type");
            byte operation = JSONConversion.getbyte(jsonoperation, "operation");
            IFrontendpage_authPK frontendpage_authPK;
            IFrontendpage_auth frontendpage_auth;
//Security parameters
            boolean loggedin = RSsecurity.check(json);
            blfrontendpage_auth.setAuthenticated(loggedin);
//Custom code, do not change this line
//add here custom operations
            //Select is allowed for all, anything else needs admin status
            String auth = (String)json.get("auth");
            String username = "";
            try {
                username = Securitycheck.getUsername(auth);
            }
            catch(IOException e) {
            }
            if(operationtype!=DataServlet.OPERATIONTYPE_SELECT && operationtype!=DataServlet.OPERATIONTYPE_SECURESELECT) {
                boolean isadmin = RSsecurity.isadmin(auth);
                loggedin = isadmin;
            }
            blfrontendpage_auth.setAuthenticated(loggedin);
//Custom code, do not change this line   
            switch(operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    switch(operation) {
                        case IFrontendpage_authOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blfrontendpage_auth.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IFrontendpage_authOperation.SELECT_ALL:
                            result = JSONFrontendpage_auth.toJSONArray(blfrontendpage_auth.getFrontendpage_auths()).toJSONString();
                            break;
                        case IFrontendpage_authOperation.SELECT_FRONTENDPAGE_AUTH:
                            frontendpage_authPK = (IFrontendpage_authPK)JSONFrontendpage_auth.toFrontendpage_authPK((JSONObject)json.get("frontendpage_authpk"));
                            result = JSONFrontendpage_auth.toJSON(blfrontendpage_auth.getFrontendpage_auth(frontendpage_authPK)).toJSONString();
                            break;
                        case IFrontendpage_authOperation.SELECT_Frontendpage:
                            IFrontendpagePK frontendpagePK = (IFrontendpagePK)JSONFrontendpage.toFrontendpagePK((JSONObject)json.get("frontendpagepk"));
                            result = JSONFrontendpage_auth.toJSONArray(blfrontendpage_auth.getFrontendpage_auths4frontendpage(frontendpagePK)).toJSONString();
                            break;
                        case IFrontendpage_authOperation.SELECT_Eveuser:
                            IEveuserPK eveuserPK = (IEveuserPK)JSONEveuser.toEveuserPK((JSONObject)json.get("eveuserpk"));
                            result = JSONFrontendpage_auth.toJSONArray(blfrontendpage_auth.getFrontendpage_auths4eveuser(eveuserPK)).toJSONString();
                            break;
                        case IFrontendpage_authOperation.SELECT_SEARCH:
                            IFrontendpage_authsearch search = (IFrontendpage_authsearch)JSONFrontendpage_auth.toFrontendpage_authsearch((JSONObject)json.get("search"));
                            result = JSONFrontendpage_auth.toJSONArray(blfrontendpage_auth.search(search)).toJSONString();
                            break;
                        case IFrontendpage_authOperation.SELECT_SEARCHCOUNT:
                            IFrontendpage_authsearch frontendpage_authsearch = (IFrontendpage_authsearch)JSONFrontendpage_auth.toFrontendpage_authsearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blfrontendpage_auth.searchcount(frontendpage_authsearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(operation) {
                        case IFrontendpage_authOperation.INSERT_FRONTENDPAGE_AUTH:
                            frontendpage_auth = (IFrontendpage_auth)JSONFrontendpage_auth.toFrontendpage_auth((JSONObject)json.get("frontendpage_auth"));
                            blfrontendpage_auth.insertFrontendpage_auth(frontendpage_auth);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(operation) {
                        case IFrontendpage_authOperation.UPDATE_FRONTENDPAGE_AUTH:
                            JSONObject jsonfrontendpage_auth = (JSONObject)json.get("frontendpage_auth");
                            frontendpage_authPK = JSONFrontendpage_auth.toFrontendpage_authPK((JSONObject)jsonfrontendpage_auth.get("PK"));
                            frontendpage_auth = blfrontendpage_auth.getFrontendpage_auth(frontendpage_authPK);
                            JSONFrontendpage_auth.updateFrontendpage_auth(frontendpage_auth, jsonfrontendpage_auth);
                            blfrontendpage_auth.updateFrontendpage_auth(frontendpage_auth);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(operation) {
                        case IFrontendpage_authOperation.DELETE_FRONTENDPAGE_AUTH:
                            frontendpage_auth = (IFrontendpage_auth)JSONFrontendpage_auth.toFrontendpage_auth((JSONObject)json.get("frontendpage_auth"));
                            blfrontendpage_auth.deleteFrontendpage_auth(frontendpage_auth);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECURESELECT:
                    switch(operation) {
                        case IFrontendpage_authOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blfrontendpage_auth.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IFrontendpage_authOperation.SELECT_ALL:
                            result = JSONFrontendpage_auth.toJSONArray(blfrontendpage_auth.getFrontendpage_auths()).toJSONString();
                            break;
                        case IFrontendpage_authOperation.SELECT_FRONTENDPAGE_AUTH:
                            frontendpage_authPK = (IFrontendpage_authPK)JSONFrontendpage_auth.toFrontendpage_authPK((JSONObject)json.get("frontendpage_authpk"));
                            result = JSONFrontendpage_auth.toJSON(blfrontendpage_auth.getFrontendpage_auth(frontendpage_authPK)).toJSONString();
                            break;
                        case IFrontendpage_authOperation.SELECT_Frontendpage:
                            IFrontendpagePK frontendpagePK = (IFrontendpagePK)JSONFrontendpage.toFrontendpagePK((JSONObject)json.get("frontendpagepk"));
                            result = JSONFrontendpage_auth.toJSONArray(blfrontendpage_auth.getFrontendpage_auths4frontendpage(frontendpagePK)).toJSONString();
                            break;
                        case IFrontendpage_authOperation.SELECT_Eveuser:
                            IEveuserPK eveuserPK = (IEveuserPK)JSONEveuser.toEveuserPK((JSONObject)json.get("eveuserpk"));
                            result = JSONFrontendpage_auth.toJSONArray(blfrontendpage_auth.getFrontendpage_auths4eveuser(eveuserPK)).toJSONString();
                            break;
                        case IFrontendpage_authOperation.SELECT_SEARCH:
                            IFrontendpage_authsearch search = (IFrontendpage_authsearch)JSONFrontendpage_auth.toFrontendpage_authsearch((JSONObject)json.get("search"));
                            result = JSONFrontendpage_auth.toJSONArray(blfrontendpage_auth.search(search)).toJSONString();
                            break;
                        case IFrontendpage_authOperation.SELECT_SEARCHCOUNT:
                            IFrontendpage_authsearch frontendpage_authsearch = (IFrontendpage_authsearch)JSONFrontendpage_auth.toFrontendpage_authsearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blfrontendpage_auth.searchcount(frontendpage_authsearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREINSERT:
                    switch(operation) {
                        case IFrontendpage_authOperation.INSERT_FRONTENDPAGE_AUTH:
                            frontendpage_auth = (IFrontendpage_auth)JSONFrontendpage_auth.toFrontendpage_auth((JSONObject)json.get("frontendpage_auth"));
                            blfrontendpage_auth.secureinsertFrontendpage_auth(frontendpage_auth);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREUPDATE:
                    switch(operation) {
                        case IFrontendpage_authOperation.UPDATE_FRONTENDPAGE_AUTH:
                            JSONObject jsonfrontendpage_auth = (JSONObject)json.get("frontendpage_auth");
                            frontendpage_authPK = JSONFrontendpage_auth.toFrontendpage_authPK((JSONObject)jsonfrontendpage_auth.get("PK"));
                            frontendpage_auth = blfrontendpage_auth.getFrontendpage_auth(frontendpage_authPK);
                            JSONFrontendpage_auth.updateFrontendpage_auth(frontendpage_auth, jsonfrontendpage_auth);
                            blfrontendpage_auth.secureupdateFrontendpage_auth(frontendpage_auth);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREDELETE:
                    switch(operation) {
                        case IFrontendpage_authOperation.DELETE_FRONTENDPAGE_AUTH:
                            frontendpage_auth = (IFrontendpage_auth)JSONFrontendpage_auth.toFrontendpage_auth((JSONObject)json.get("frontendpage_auth"));
                            blfrontendpage_auth.securedeleteFrontendpage_auth(frontendpage_auth);
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
     * PUT method for updating or creating an instance of RSFrontendpage_auth
     * @param content representation for the resource
     */
    @PUT
    @Consumes("text/html")
    public void put(String content) {
    }
}

