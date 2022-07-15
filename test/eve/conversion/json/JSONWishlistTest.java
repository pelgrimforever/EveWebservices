package eve.conversion.json;

import data.conversion.JSONConversion;
import eve.logicentity.Wishlist;
import eve.searchentity.Wishlistsearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONWishlistTest {
    
    public JSONWishlistTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        Wishlist wishlist = new Wishlist();
        ArrayList<Wishlist> wishlistlist = new ArrayList<>();
        wishlistlist.add(wishlist);
        JSONArray jsonwishlistarray = JSONWishlist.toJSONArray(wishlistlist);
        JSONObject jsonwishlist = (JSONObject)jsonwishlistarray.get(0);
        wishlist = JSONWishlist.toWishlist(jsonwishlist);
        wishlist = JSONWishlist.initWishlist(jsonwishlist);
        JSONWishlist.updateWishlist(wishlist, jsonwishlist);
        Wishlistsearch search = new Wishlistsearch();
        JSONObject jsonsearch = JSONWishlist.toJSON(search);
        jsonsearch.put("andor", 0);
        jsonsearch.put("maxresults", 0);
        jsonsearch.put("docount", false);
        jsonsearch.put("primarykeys", new JSONArray());
        jsonsearch.put("fields", new JSONObject());
        jsonsearch.put("keysearch", new JSONObject());
        search = JSONWishlist.toWishlistsearch(jsonsearch);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

