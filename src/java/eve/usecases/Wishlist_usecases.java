/*
 * Generated on 13.4.2022 19:13
 */

package eve.usecases;

import data.conversion.JSONConversion;
import eve.BusinessObject.Logic.*;
import eve.entity.pk.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.searchentity.*;
import eve.interfaces.entity.pk.*;
import eve.logicentity.Wishlist;
import eve.logicview.*;
import general.exception.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.IOException;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class Wishlist_usecases {

    private boolean loggedin = false;
    private BLwishlist blwishlist = new BLwishlist();
    
    public Wishlist_usecases() {
        this(false);
    }
    
    public Wishlist_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blwishlist.setAuthenticated(loggedin);
    }
    
//Custom code, do not change this line
//add here custom operations
    public void add_wishlist_item(IWishlist wishlist) throws DBException, DataException {
        blwishlist.addWishlist(wishlist);
    }
//Custom code, do not change this line   

    public long count() throws DBException {
        return blwishlist.count();
    }
    
    public ArrayList<Wishlist> get_all() throws DBException {
        return blwishlist.getWishlists();
    }
    
    public boolean getWishlistExists(IWishlistPK wishlistPK) throws DBException {
        return blwishlist.getEntityExists(wishlistPK);
    }
    
    public Wishlist get_wishlist_by_primarykey(IWishlistPK wishlistPK) throws DBException {
        return blwishlist.getWishlist(wishlistPK);
    }

    public ArrayList<Wishlist> get_wishlist_with_foreignkey_evetype(IEvetypePK evetypePK) throws CustomException {
        return blwishlist.getWishlists4evetype(evetypePK);
    }
    
    public ArrayList<Wishlist> search_wishlist(IWishlistsearch wishlistsearch) throws ParseException, CustomException {
        return blwishlist.search(wishlistsearch);
    }
    
    public long search_wishlist_count(IWishlistsearch wishlistsearch) throws ParseException, CustomException {
        return blwishlist.searchcount(wishlistsearch);
    }

    public void secureinsertWishlist(IWishlist wishlist) throws DBException, DataException {
        blwishlist.secureinsertWishlist(wishlist);
    }

    public void secureupdateWishlist(IWishlist wishlist) throws DBException, DataException {
        blwishlist.secureupdateWishlist(wishlist);
    }

    public void securedeleteWishlist(IWishlist wishlist) throws DBException, DataException {
        blwishlist.securedeleteWishlist(wishlist);
    }
}

