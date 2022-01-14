/*
 * RSWishlist.java
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
import eve.interfaces.searchentity.IWishlistsearch;
import eve.interfaces.servlet.IWishlistOperation;
import eve.logicentity.Wishlist;
import eve.searchentity.Wishlistsearch;
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
@Path("rswishlist")
public class RSWishlist {

    /**
     * Creates a new instance of HelloWorld
     */
    public RSWishlist() {
    }

    /**
     * Retrieves representation of an instance of wishlist.restservices.RSWishlist
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{json}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@PathParam("json") String jsonstring) {
        try {
            BLwishlist blwishlist = new BLwishlist();
            ArrayList wishlists = blwishlist.getAll();
            JSONArray jsonwishlists = JSONWishlist.toJSONArray(wishlists);
            return jsonwishlists.toJSONString();
        }
        catch(DBException e) {
            return "{ \"status\": \"error\"}";
        }
    }

    /**
     * Retrieves representation of an instance of wishlist.restservices.RSWishlist
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        String result = "";
        BLwishlist blwishlist = new BLwishlist();
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject)parser.parse(jsonstring);
            JSONObject jsonoperation = (JSONObject)json.get("operation");
            byte operationtype = JSONConversion.getbyte(jsonoperation, "type");
            byte operation = JSONConversion.getbyte(jsonoperation, "operation");
            IWishlistPK wishlistPK;
            IWishlist wishlist;
//Security parameters
            boolean loggedin = RSsecurity.check(json);
            blwishlist.setAuthenticated(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    switch(operation) {
                        case IWishlistOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blwishlist.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IWishlistOperation.SELECT_ALL:
                            result = JSONWishlist.toJSONArray(blwishlist.getWishlists()).toJSONString();
                            break;
                        case IWishlistOperation.SELECT_WISHLIST:
                            wishlistPK = (IWishlistPK)JSONWishlist.toWishlistPK((JSONObject)json.get("wishlistpk"));
                            result = JSONWishlist.toJSON(blwishlist.getWishlist(wishlistPK)).toJSONString();
                            break;
                        case IWishlistOperation.SELECT_Evetype:
                            IEvetypePK evetypePK = (IEvetypePK)JSONEvetype.toEvetypePK((JSONObject)json.get("evetypepk"));
                            result = JSONWishlist.toJSONArray(blwishlist.getWishlists4evetype(evetypePK)).toJSONString();
                            break;
                        case IWishlistOperation.SELECT_SEARCH:
                            IWishlistsearch search = (IWishlistsearch)JSONWishlist.toWishlistsearch((JSONObject)json.get("search"));
                            result = JSONWishlist.toJSONArray(blwishlist.search(search)).toJSONString();
                            break;
                        case IWishlistOperation.SELECT_SEARCHCOUNT:
                            IWishlistsearch wishlistsearch = (IWishlistsearch)JSONWishlist.toWishlistsearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blwishlist.searchcount(wishlistsearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(operation) {
                        case IWishlistOperation.INSERT_WISHLIST:
                            wishlist = (IWishlist)JSONWishlist.toWishlist((JSONObject)json.get("wishlist"));
                            blwishlist.insertWishlist(wishlist);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(operation) {
                        case IWishlistOperation.UPDATE_WISHLIST:
                            JSONObject jsonwishlist = (JSONObject)json.get("wishlist");
                            wishlistPK = JSONWishlist.toWishlistPK((JSONObject)jsonwishlist.get("PK"));
                            wishlist = blwishlist.getWishlist(wishlistPK);
                            JSONWishlist.updateWishlist(wishlist, jsonwishlist);
                            blwishlist.updateWishlist(wishlist);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
                        case IWishlistOperation.UPDATE_ADDWISHLIST:
                            JSONObject jsonaddwishlist = (JSONObject)json.get("wishlist");
                            wishlist = JSONWishlist.toWishlist(jsonaddwishlist);
                            blwishlist.addWishlist(wishlist);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(operation) {
                        case IWishlistOperation.DELETE_WISHLIST:
                            wishlist = (IWishlist)JSONWishlist.toWishlist((JSONObject)json.get("wishlist"));
                            blwishlist.deleteWishlist(wishlist);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECURESELECT:
                    switch(operation) {
                        case IWishlistOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blwishlist.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IWishlistOperation.SELECT_ALL:
                            result = JSONWishlist.toJSONArray(blwishlist.getWishlists()).toJSONString();
                            break;
                        case IWishlistOperation.SELECT_WISHLIST:
                            wishlistPK = (IWishlistPK)JSONWishlist.toWishlistPK((JSONObject)json.get("wishlistpk"));
                            result = JSONWishlist.toJSON(blwishlist.getWishlist(wishlistPK)).toJSONString();
                            break;
                        case IWishlistOperation.SELECT_Evetype:
                            IEvetypePK evetypePK = (IEvetypePK)JSONEvetype.toEvetypePK((JSONObject)json.get("evetypepk"));
                            result = JSONWishlist.toJSONArray(blwishlist.getWishlists4evetype(evetypePK)).toJSONString();
                            break;
                        case IWishlistOperation.SELECT_SEARCH:
                            IWishlistsearch search = (IWishlistsearch)JSONWishlist.toWishlistsearch((JSONObject)json.get("search"));
                            result = JSONWishlist.toJSONArray(blwishlist.search(search)).toJSONString();
                            break;
                        case IWishlistOperation.SELECT_SEARCHCOUNT:
                            IWishlistsearch wishlistsearch = (IWishlistsearch)JSONWishlist.toWishlistsearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blwishlist.searchcount(wishlistsearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREINSERT:
                    switch(operation) {
                        case IWishlistOperation.INSERT_WISHLIST:
                            wishlist = (IWishlist)JSONWishlist.toWishlist((JSONObject)json.get("wishlist"));
                            blwishlist.secureinsertWishlist(wishlist);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREUPDATE:
                    switch(operation) {
                        case IWishlistOperation.UPDATE_WISHLIST:
                            JSONObject jsonwishlist = (JSONObject)json.get("wishlist");
                            wishlistPK = JSONWishlist.toWishlistPK((JSONObject)jsonwishlist.get("PK"));
                            wishlist = blwishlist.getWishlist(wishlistPK);
                            JSONWishlist.updateWishlist(wishlist, jsonwishlist);
                            blwishlist.secureupdateWishlist(wishlist);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREDELETE:
                    switch(operation) {
                        case IWishlistOperation.DELETE_WISHLIST:
                            wishlist = (IWishlist)JSONWishlist.toWishlist((JSONObject)json.get("wishlist"));
                            blwishlist.securedeleteWishlist(wishlist);
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
     * PUT method for updating or creating an instance of RSWishlist
     * @param content representation for the resource
     */
    @PUT
    @Consumes("text/html")
    public void put(String content) {
    }
}

