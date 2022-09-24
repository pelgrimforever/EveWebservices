/*
 * Generated on 23.8.2022 14:38
 * @author Franky Laseure
 */

package eve.restservices.wishlist;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.usecases.*;
import eve.usecases.custom.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.searchentity.IWishlistsearch;
import eve.interfaces.servlet.IWishlistOperation;
import eve.logicentity.Wishlist;
import eve.searchentity.Wishlistsearch;
import eve.servlets.DataServlet;
import eve.usecases.*;
import eve.usecases.custom.*;
import general.exception.*;
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

@Path("rswishlist_update")
public class RSWishlist_update extends RS_json_login {

    private Security_usecases security_usecases = new Security_usecases();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Wishlist_usecases wishlistusecases = new Wishlist_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IWishlistOperation.UPDATE_WISHLIST:
                    update_wishlist(wishlistusecases, json);
                    break;
//Custom code, do not change this line
//add here custom operations
                case IWishlistOperation.UPDATE_ADDWISHLIST:
                    add_wishlist_item(wishlistusecases, json);
                    break;
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
    private void add_wishlist_item(Wishlist_usecases wishlistusecases, JSONObject json) throws ParseException, CustomException {
        JSONObject jsonaddwishlist = (JSONObject)json.get("wishlist");
        IWishlist wishlist = JSONWishlist.toWishlist(jsonaddwishlist);
        wishlistusecases.add_wishlist_item(wishlist);
        setReturnstatus("OK");
    }
//Custom code, do not change this line   

    private void update_wishlist(Wishlist_usecases wishlistusecases, JSONObject json) throws ParseException, CustomException {
        IWishlist wishlist = (IWishlist)JSONWishlist.toWishlist((JSONObject)json.get("wishlist"));
        wishlistusecases.updateWishlist(wishlist);
        setReturnstatus("OK");
    }
}

