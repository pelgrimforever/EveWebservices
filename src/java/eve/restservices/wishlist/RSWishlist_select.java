/*
 * Generated on 20.4.2022 10:3
 */

package eve.restservices.wishlist;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.usecases.Wishlist_usecases;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.searchentity.IWishlistsearch;
import eve.interfaces.servlet.IWishlistOperation;
import eve.logicentity.Wishlist;
import eve.searchentity.Wishlistsearch;
import eve.servlets.DataServlet;
import eve.usecases.Security_usecases;
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
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
@Path("rswishlist_select")
public class RSWishlist_select extends RS_json_login {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(Security_usecases.check_authorization(authorisationstring));
            IWishlistPK wishlistPK;
            IWishlist wishlist;
            Wishlist_usecases wishlistusecases = new Wishlist_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IWishlistOperation.SELECT_COUNT:
                    result = count_records(wishlistusecases);
                    break;
                case IWishlistOperation.SELECT_ALL:
                    result = get_all_wishlist(wishlistusecases);
                    break;
                case IWishlistOperation.SELECT_WISHLIST:
                    result = get_wishlist_with_primarykey(wishlistusecases, json);
                    break;
                case IWishlistOperation.SELECT_Evetype:
                    result = get_wishlist_with_foreignkey_evetype(wishlistusecases, json);
                    break;
                case IWishlistOperation.SELECT_SEARCH:
                    result = search_wishlist(wishlistusecases, json);
                    break;
                case IWishlistOperation.SELECT_SEARCHCOUNT:
                    result = search_wishlist_count(wishlistusecases, json);
                    break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            }
        }
        catch(ParseException | CustomException | IOException e) {
            setReturnstatus(e.getMessage());
        }
        return result;
    }

//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   

    private String count_records(Wishlist_usecases wishlistusecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", wishlistusecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_wishlist(Wishlist_usecases wishlistusecases) throws ParseException, CustomException {
    	return JSONWishlist.toJSONArray(wishlistusecases.get_all()).toJSONString();
    }
    
    private String get_wishlist_with_primarykey(Wishlist_usecases wishlistusecases, JSONObject json) throws ParseException, CustomException {
        IWishlistPK wishlistPK = (IWishlistPK)JSONWishlist.toWishlistPK((JSONObject)json.get("wishlistpk"));
	return JSONWishlist.toJSON(wishlistusecases.get_wishlist_by_primarykey(wishlistPK)).toJSONString();
    }
    
    private String get_wishlist_with_foreignkey_evetype(Wishlist_usecases wishlistusecases, JSONObject json) throws ParseException, CustomException {
        IEvetypePK evetypePK = (IEvetypePK)JSONEvetype.toEvetypePK((JSONObject)json.get("evetypepk"));
        return JSONWishlist.toJSONArray(wishlistusecases.get_wishlist_with_foreignkey_evetype(evetypePK)).toJSONString();
    }
    
    private String search_wishlist(Wishlist_usecases wishlistusecases, JSONObject json) throws ParseException, CustomException {
        IWishlistsearch search = (IWishlistsearch)JSONWishlist.toWishlistsearch((JSONObject)json.get("search"));
        return JSONWishlist.toJSONArray(wishlistusecases.search_wishlist(search)).toJSONString();
    }
    
    private String search_wishlist_count(Wishlist_usecases wishlistusecases, JSONObject json) throws ParseException, CustomException {
        IWishlistsearch wishlistsearch = (IWishlistsearch)JSONWishlist.toWishlistsearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", wishlistusecases.search_wishlist_count(wishlistsearch));
        return jsonsearchcount.toJSONString();
    }
}

