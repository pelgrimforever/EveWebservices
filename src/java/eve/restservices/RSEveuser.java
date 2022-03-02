/*
 * RSEveuser.java
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
import eve.interfaces.searchentity.IEveusersearch;
import eve.interfaces.servlet.IEveuserOperation;
import eve.logicentity.Eveuser;
import eve.searchentity.Eveusersearch;
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
@Path("rseveuser")
public class RSEveuser {

    /**
     * Creates a new instance of HelloWorld
     */
    public RSEveuser() {
    }

    /**
     * Retrieves representation of an instance of eveuser.restservices.RSEveuser
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{json}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@PathParam("json") String jsonstring) {
        try {
            BLeveuser bleveuser = new BLeveuser();
            ArrayList eveusers = bleveuser.getAll();
            JSONArray jsoneveusers = JSONEveuser.toJSONArray(eveusers);
            return jsoneveusers.toJSONString();
        }
        catch(DBException e) {
            return "{ \"status\": \"error\"}";
        }
    }

    /**
     * Retrieves representation of an instance of eveuser.restservices.RSEveuser
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        String result = "";
        BLeveuser bleveuser = new BLeveuser();
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject)parser.parse(jsonstring);
            JSONObject jsonoperation = (JSONObject)json.get("operation");
            byte operationtype = JSONConversion.getbyte(jsonoperation, "type");
            byte operation = JSONConversion.getbyte(jsonoperation, "operation");
            IEveuserPK eveuserPK;
            IEveuser eveuser;
//Security parameters
            boolean loggedin = RSsecurity.check(json);
            bleveuser.setAuthenticated(loggedin);
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
            bleveuser.setAuthenticated(loggedin);
//Custom code, do not change this line   
            switch(operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    switch(operation) {
                        case IEveuserOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", bleveuser.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IEveuserOperation.SELECT_ALL:
                            result = JSONEveuser.toJSONArray(bleveuser.getEveusers()).toJSONString();
                            break;
                        case IEveuserOperation.SELECT_EVEUSER:
                            eveuserPK = (IEveuserPK)JSONEveuser.toEveuserPK((JSONObject)json.get("eveuserpk"));
                            result = JSONEveuser.toJSON(bleveuser.getEveuser(eveuserPK)).toJSONString();
                            break;
                        case IEveuserOperation.SELECT_Frontendpage_auth:
                            IFrontendpage_authPK frontendpage_authPK = (IFrontendpage_authPK)JSONFrontendpage_auth.toFrontendpage_authPK((JSONObject)json.get("frontendpage_authpk"));
                            result = JSONEveuser.toJSON(bleveuser.getFrontendpage_auth(frontendpage_authPK)).toJSONString();
                            break;
                        case IEveuserOperation.SELECT_SEARCH:
                            IEveusersearch search = (IEveusersearch)JSONEveuser.toEveusersearch((JSONObject)json.get("search"));
                            result = JSONEveuser.toJSONArray(bleveuser.search(search)).toJSONString();
                            break;
                        case IEveuserOperation.SELECT_SEARCHCOUNT:
                            IEveusersearch eveusersearch = (IEveusersearch)JSONEveuser.toEveusersearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", bleveuser.searchcount(eveusersearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(operation) {
                        case IEveuserOperation.INSERT_EVEUSER:
                            eveuser = (IEveuser)JSONEveuser.toEveuser((JSONObject)json.get("eveuser"));
                            bleveuser.insertEveuser(eveuser);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(operation) {
                        case IEveuserOperation.UPDATE_EVEUSER:
                            JSONObject jsoneveuser = (JSONObject)json.get("eveuser");
                            eveuserPK = JSONEveuser.toEveuserPK((JSONObject)jsoneveuser.get("PK"));
                            eveuser = bleveuser.getEveuser(eveuserPK);
                            JSONEveuser.updateEveuser(eveuser, jsoneveuser);
                            bleveuser.updateEveuser(eveuser);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(operation) {
                        case IEveuserOperation.DELETE_EVEUSER:
                            eveuser = (IEveuser)JSONEveuser.toEveuser((JSONObject)json.get("eveuser"));
                            bleveuser.deleteEveuser(eveuser);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECURESELECT:
                    switch(operation) {
                        case IEveuserOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", bleveuser.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IEveuserOperation.SELECT_ALL:
                            result = JSONEveuser.toJSONArray(bleveuser.getEveusers()).toJSONString();
                            break;
                        case IEveuserOperation.SELECT_EVEUSER:
                            eveuserPK = (IEveuserPK)JSONEveuser.toEveuserPK((JSONObject)json.get("eveuserpk"));
                            result = JSONEveuser.toJSON(bleveuser.getEveuser(eveuserPK)).toJSONString();
                            break;
                        case IEveuserOperation.SELECT_Frontendpage_auth:
                            IFrontendpage_authPK frontendpage_authPK = (IFrontendpage_authPK)JSONFrontendpage_auth.toFrontendpage_authPK((JSONObject)json.get("frontendpage_authpk"));
                            result = JSONEveuser.toJSON(bleveuser.getFrontendpage_auth(frontendpage_authPK)).toJSONString();
                            break;
                        case IEveuserOperation.SELECT_SEARCH:
                            IEveusersearch search = (IEveusersearch)JSONEveuser.toEveusersearch((JSONObject)json.get("search"));
                            result = JSONEveuser.toJSONArray(bleveuser.search(search)).toJSONString();
                            break;
                        case IEveuserOperation.SELECT_SEARCHCOUNT:
                            IEveusersearch eveusersearch = (IEveusersearch)JSONEveuser.toEveusersearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", bleveuser.searchcount(eveusersearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
                        case IEveuserOperation.SELECT_ISADMIN:
                            boolean isadmin = RSsecurity.isadmin(auth);
                            break;
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREINSERT:
                    switch(operation) {
                        case IEveuserOperation.INSERT_EVEUSER:
                            eveuser = (IEveuser)JSONEveuser.toEveuser((JSONObject)json.get("eveuser"));
                            bleveuser.secureinsertEveuser(eveuser);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
                        case IEveuserOperation.INSERT_NEWUSER:
                            eveuser = (IEveuser)JSONEveuser.toEveuser((JSONObject)json.get("eveuser"));
                            if(bleveuser.getEveuserExists(eveuser.getPrimaryKey())) {
                                result = returnstatus("User exists");
                            } else {
                                boolean isregistered = RSsecurity.register(auth, eveuser.getPrimaryKey().getUsername());
                                if(isregistered) {
                                    bleveuser.secureinsertEveuser(eveuser);
                                    result = returnstatus("OK");
                                } else {
                                    result = returnstatus("Registration failed");
                                }
                            }
                            break;
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREUPDATE:
                    switch(operation) {
                        case IEveuserOperation.UPDATE_EVEUSER:
                            JSONObject jsoneveuser = (JSONObject)json.get("eveuser");
                            eveuserPK = JSONEveuser.toEveuserPK((JSONObject)jsoneveuser.get("PK"));
                            eveuser = bleveuser.getEveuser(eveuserPK);
                            JSONEveuser.updateEveuser(eveuser, jsoneveuser);
                            bleveuser.secureupdateEveuser(eveuser);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
                        case IEveuserOperation.UPDATE_EVEUSERPASS:
                            eveuserPK = new EveuserPK(username);
                            if(bleveuser.getEveuserExists(eveuserPK)) {
                                String newauth = JSONConversion.getString(json, "newauth");
                                boolean isupdated = RSsecurity.updatepass(auth, newauth);
                                if(isupdated) {
                                    result = returnstatus("OK");
                                } else {
                                    result = returnstatus("Password update failed");
                                }
                            } else {
                                result = returnstatus("User not found");
                            }
                            break;
                        case IEveuserOperation.UPDATE_EVEUSERRESET:
                            eveuser = (IEveuser)JSONEveuser.toEveuser((JSONObject)json.get("eveuser"));
                            if(bleveuser.getEveuserExists(eveuser.getPrimaryKey())) {
                                String authreset = (String)json.get("auth");
                                boolean isreset = RSsecurity.reset(authreset, eveuser.getPrimaryKey().getUsername());
                                if(isreset) {
                                    result = returnstatus("OK");
                                } else {
                                    result = returnstatus("Reset failed");
                                }
                            }
                            break;
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREDELETE:
                    switch(operation) {
                        case IEveuserOperation.DELETE_EVEUSER:
                            eveuser = (IEveuser)JSONEveuser.toEveuser((JSONObject)json.get("eveuser"));
                            bleveuser.securedeleteEveuser(eveuser);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
                        case IEveuserOperation.DELETE_REGISTRATION:
                            boolean isadmin = RSsecurity.isadmin(auth);
                            if(isadmin) {
                                eveuser = (IEveuser)JSONEveuser.toEveuser((JSONObject)json.get("eveuser"));
                                bleveuser.securedeleteEveuser(eveuser);
                                result = returnstatus("OK");
                            } else {
                                result = returnstatus("Not authorized");
                            }
                            break;
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
     * PUT method for updating or creating an instance of RSEveuser
     * @param content representation for the resource
     */
    @PUT
    @Consumes("text/html")
    public void put(String content) {
    }
}

