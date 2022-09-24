/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 23.8.2022 14:38
 * @author Franky Laseure
 */
 
package eve.conversion.json;

import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.interfaces.db.EntityPK;
import data.interfaces.db.Fieldsearcher;
import data.json.piJson;
import eve.entity.pk.WishlistPK;
import eve.interfaces.entity.pk.IWishlistPK;
import eve.interfaces.logicentity.IWishlist;
import eve.logicentity.Wishlist;
import eve.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JSONWishlist {
    
    public static JSONArray toJSONArray(ArrayList wishlists) {
        JSONArray jsonwishlists = new JSONArray();
        Iterator wishlistsI = wishlists.iterator();
        while(wishlistsI.hasNext()) {
            jsonwishlists.add(toJSON((Wishlist)wishlistsI.next()));
        }
        return jsonwishlists;
    }

    public static JSONObject toJSON(IWishlistPK wishlistPK) {
        JSONObject json = null;
        if(wishlistPK!=null) {
            json = new JSONObject();
            json.put("evetype", String.valueOf(wishlistPK.getEvetype()));
            json.put("username", wishlistPK.getUsername());
        }
        return json;
    }

    public static JSONObject toJSON(IWishlist wishlist) {
        JSONObject json = new JSONObject();
        json.put("PK", toJSON(wishlist.getPrimaryKey()));
        json.put("maxprice", wishlist.getMaxprice());
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    public static JSONObject toJSON(Wishlistsearch wishlistsearch) {
        JSONObject json = new JSONObject();
        if(wishlistsearch.used()) {
            byte andoroperator = wishlistsearch.getAndoroperator();
            int maxresults = wishlistsearch.getMaxresults();
            boolean docount = wishlistsearch.getDocount();
            Iterator<EntityPK> primarykeysI = wishlistsearch.getPrimarykeys().iterator();
            Iterator<Fieldsearcher> fieldsearchersI = wishlistsearch.getFieldsearchers().iterator();
            EntityPK primarykey;
            Fieldsearcher fieldsearcher;
            
            json.put("andor", andoroperator);
            json.put("maxresults", maxresults);
            json.put("docount", docount);
            JSONArray pks = new JSONArray();
            int i = 0;
            while(primarykeysI.hasNext()) {
                primarykey = primarykeysI.next();
                pks.add(primarykey.getKeystring());
            }
            json.put("primarykeys", pks);
            JSONObject fss = new JSONObject();
            while(fieldsearchersI.hasNext()) {
                fieldsearcher = fieldsearchersI.next();
                if(fieldsearcher.used()) {
                    fss.put(fieldsearcher.getShortFieldname(), JSONConversion.toJSON(fieldsearcher));
                }
            }
            json.put("fields", fss);
            JSONObject kss = new JSONObject();
            if(wishlistsearch.getEvetypesearch()!=null && wishlistsearch.getEvetypesearch().used()) {
                kss.put("evetypesearcher", JSONEvetype.toJSON((Evetypesearch)wishlistsearch.getEvetypesearch()));
            }
            json.put("keysearch", kss);
        }
        return json;
    }

    public static Wishlistsearch toWishlistsearch(JSONObject json) {
        Wishlistsearch wishlistsearch = new Wishlistsearch();
        wishlistsearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        wishlistsearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        wishlistsearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONArray pks = (JSONArray)json.get("primarykeys");
        for(int i=0; i<pks.size(); i++) {
            wishlistsearch.addPrimarykey(WishlistPK.getKey((String)pks.get(i)));
        }
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("username");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            wishlistsearch.username(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("maxprice");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            wishlistsearch.maxprice(valuearray, operators, andor);
        }
        JSONObject kss = (JSONObject)json.get("keysearch");
        JSONArray keysearch;
        keysearch = (JSONArray)kss.get("evetypesearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Evetypesearch evetypesearch = JSONEvetype.toEvetypesearch((JSONObject)keysearch.get(i));
                wishlistsearch.evetype(evetypesearch);
            }
        }
        return wishlistsearch;
    }
    
    public static WishlistPK toWishlistPK(JSONObject json) {
        WishlistPK wishlistPK = null;
        if(json!=null) {
            wishlistPK = new WishlistPK(JSONConversion.getlong(json, "evetype"), JSONConversion.getString(json, "username"));
        }
        return wishlistPK;
    }

    public static Wishlist toWishlist(JSONObject json) {
        Wishlist wishlist = new Wishlist(toWishlistPK((JSONObject)json.get("PK")));
        updateWishlist(wishlist, json);
        return wishlist;
    }

    public static void updateWishlist(IWishlist wishlist, JSONObject json) {
        wishlist.setMaxprice(JSONConversion.getdouble(json, "maxprice"));
    }

    public static Wishlist initWishlist(JSONObject json) {
        Wishlist wishlist = new Wishlist(toWishlistPK((JSONObject)json.get("PK")));
        wishlist.initMaxprice(JSONConversion.getdouble(json, "maxprice"));
        return wishlist;
    }
}

