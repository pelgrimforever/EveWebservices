/*
 * WSWishlist.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 13.6.2022 18:20
 *
 */

package eve.webservices;

import base.restservices.RS_json_login;
import eve.BusinessObject.Logic.*;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.searchentity.IWishlistsearch;
import eve.interfaces.webservice.WSIWishlist;
import eve.logicentity.Wishlist;
import eve.searchentity.Wishlistsearch;
import eve.usecases.*;
import general.exception.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.jws.WebMethod;
import javax.jws.WebService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import eve.usecases.custom.Security_usecases;

/**
 *
 * @author Franky Laseure
 */
@WebService(endpointInterface = "eve.interfaces.webservice.WSIWishlist")
public class WSWishlist extends RS_json_login implements WSIWishlist {

    private Security_usecases security_usecases = new Security_usecases();
    
    private JSONArray toJSONArray(ArrayList wishlists) {
        JSONArray jsonwishlists = new JSONArray();
        Iterator wishlistsI = wishlists.iterator();
        while(wishlistsI.hasNext()) {
            jsonwishlists.add(JSONWishlist.toJSON((Wishlist)wishlistsI.next()));
        }
        return jsonwishlists;
    }

    //@WebMethod(operationName = "getWishlists")
    @Override
    public String getWishlists() {
        try {
            Wishlist_usecases wishlistusecases = new Wishlist_usecases(loggedin);
            return get_all_wishlist(wishlistusecases);
        }
        catch(CustomException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "search")
    @Override
    public String search(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Wishlist_usecases wishlistusecases = new Wishlist_usecases(loggedin);
            return search_wishlist(wishlistusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "getWishlist")
    @Override
    public String getWishlist(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Wishlist_usecases wishlistusecases = new Wishlist_usecases(loggedin);
            return get_wishlist_with_primarykey(wishlistusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "insertWishlist")
    @Override
    public void insertWishlist(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Wishlist_usecases wishlistusecases = new Wishlist_usecases(loggedin);
            insert_wishlist(wishlistusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "updateWishlist")
    @Override
    public void updateWishlist(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Wishlist_usecases wishlistusecases = new Wishlist_usecases(loggedin);
            update_wishlist(wishlistusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "deleteWishlist")
    @Override
    public void deleteWishlist(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Wishlist_usecases wishlistusecases = new Wishlist_usecases(loggedin);
            delete_wishlist(wishlistusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getWishlists4evetype")
    @Override
    public String getWishlists4evetype(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Wishlist_usecases wishlistusecases = new Wishlist_usecases(loggedin);
            return get_wishlist_with_foreignkey_evetype(wishlistusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "delete4evetype")
    @Override
    public void delete4evetype(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Wishlist_usecases wishlistusecases = new Wishlist_usecases(loggedin);
            delete_wishlist(wishlistusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }


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

    private void insert_wishlist(Wishlist_usecases wishlistusecases, JSONObject json) throws ParseException, CustomException {
        IWishlist wishlist = (IWishlist)JSONWishlist.toWishlist((JSONObject)json.get("wishlist"));
        wishlistusecases.insertWishlist(wishlist);
        setReturnstatus("OK");
    }

    private void update_wishlist(Wishlist_usecases wishlistusecases, JSONObject json) throws ParseException, CustomException {
        IWishlist wishlist = (IWishlist)JSONWishlist.toWishlist((JSONObject)json.get("wishlist"));
        wishlistusecases.updateWishlist(wishlist);
        setReturnstatus("OK");
    }

    private void delete_wishlist(Wishlist_usecases wishlistusecases, JSONObject json) throws ParseException, CustomException {
        IWishlist wishlist = (IWishlist)JSONWishlist.toWishlist((JSONObject)json.get("wishlist"));
        wishlistusecases.deleteWishlist(wishlist);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Evetype(Wishlist_usecases wishlistusecases, JSONObject json) throws ParseException, CustomException {
        IEvetypePK evetypePK = (IEvetypePK)JSONEvetype.toEvetypePK((JSONObject)json.get("evetypepk"));
        wishlistusecases.delete_all_containing_Evetype(evetypePK);
        setReturnstatus("OK");
    }

}

