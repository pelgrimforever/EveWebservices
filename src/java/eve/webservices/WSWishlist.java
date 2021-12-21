/*
 * WSWishlist.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 16.11.2021 15:46
 *
 */

package eve.webservices;

import eve.BusinessObject.Logic.*;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.webservice.WSIWishlist;
import eve.logicentity.Wishlist;
import eve.searchentity.Wishlistsearch;
import general.exception.CustomException;
import general.exception.DataException;
import general.exception.DBException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.jws.WebMethod;
import javax.jws.WebService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Franky Laseure
 */
@WebService(endpointInterface = "eve.interfaces.webservice.WSIWishlist")
public class WSWishlist implements WSIWishlist {

    private JSONArray toJSONArray(ArrayList wishlists) {
        JSONArray jsonwishlists = new JSONArray();
        Iterator wishlistsI = wishlists.iterator();
        while(wishlistsI.hasNext()) {
            jsonwishlists.add(JSONWishlist.toJSON((Wishlist)wishlistsI.next()));
        }
        return jsonwishlists;
    }

    /**
     * Web service operation
     */
    //@WebMethod(operationName = "getWishlists")
    @Override
    public String getWishlists() {
        try {
            BLwishlist blwishlist = new BLwishlist();
            ArrayList wishlists = blwishlist.getAll();
            JSONArray jsonwishlists = toJSONArray(wishlists);
            return jsonwishlists.toJSONString();
        }
        catch(DBException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "search")
    @Override
    public String search(String json) {
        BLwishlist blwishlist = new BLwishlist();
        JSONParser parser = new JSONParser();
        String result = "";
        Wishlist wishlist;
        try {
            Wishlistsearch wishlistsearch = JSONWishlist.toWishlistsearch((JSONObject)parser.parse(json));
            ArrayList wishlists = blwishlist.search(wishlistsearch);
            JSONArray jsonwishlists = toJSONArray(wishlists);
            result = jsonwishlists.toJSONString();
        }
        catch(ParseException e) {
            result = "";
        }
        catch(DBException e) {
            result = "";
        }
        return result;
    }

    //@WebMethod(operationName = "getWishlist")
    @Override
    public String getWishlist(String json) {
        BLwishlist blwishlist = new BLwishlist();
        JSONParser parser = new JSONParser();
        String result = "";
        Wishlist wishlist;
        try {
            WishlistPK wishlistPK = JSONWishlist.toWishlistPK((JSONObject)parser.parse(json));
            wishlist = blwishlist.getWishlist(wishlistPK);
            if(wishlist!=null) {
                result = JSONWishlist.toJSON(wishlist).toJSONString();
            }
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
        return result;
    }

    //@WebMethod(operationName = "insertWishlist")
    @Override
    public void insertWishlist(String json) {
        BLwishlist blwishlist = new BLwishlist();
        JSONParser parser = new JSONParser();
        try {
            IWishlist wishlist = JSONWishlist.toWishlist((JSONObject)parser.parse(json));
            blwishlist.insertWishlist(wishlist);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "updateWishlist")
    @Override
    public void updateWishlist(String json) {
        BLwishlist blwishlist = new BLwishlist();
        JSONParser parser = new JSONParser();
        try {
            IWishlist wishlist = JSONWishlist.toWishlist((JSONObject)parser.parse(json));
            blwishlist.updateWishlist(wishlist);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "deleteWishlist")
    @Override
    public void deleteWishlist(String json) {
        BLwishlist blwishlist = new BLwishlist();
        JSONParser parser = new JSONParser();
        try {
            IWishlist wishlist = JSONWishlist.toWishlist((JSONObject)parser.parse(json));
            blwishlist.deleteWishlist(wishlist);
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "getWishlists4evetype")
    @Override
    public String getWishlists4evetype(String json) {
        BLwishlist blwishlist = new BLwishlist();
        JSONParser parser = new JSONParser();
        Wishlist wishlist;
        try {
            IEvetypePK evetypePK = JSONEvetype.toEvetypePK((JSONObject)parser.parse(json));
            ArrayList wishlists = blwishlist.getWishlists4evetype(evetypePK);
            JSONArray jsonwishlists = toJSONArray(wishlists);
            return jsonwishlists.toJSONString();
        }
        catch(ParseException e) {
            return null;
        }
        catch(DBException e) {
            return null;
        }
        catch(CustomException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "delete4evetype")
    @Override
    public void delete4evetype(String json) {
        BLwishlist blwishlist = new BLwishlist();
        JSONParser parser = new JSONParser();
        Wishlist wishlist;
        try {
            IEvetypePK evetypePK = JSONEvetype.toEvetypePK((JSONObject)parser.parse(json));
            blwishlist.delete4evetype(evetypePK);
        }
        catch(ParseException e) {
        }
    }


}

