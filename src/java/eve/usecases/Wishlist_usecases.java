/*
 * Generated on 13.6.2022 11:21
 */

package eve.usecases;

import db.*;
import data.conversion.JSONConversion;
import data.interfaces.db.Filedata;
import data.gis.shape.piPoint;
import eve.BusinessObject.Logic.*;
import eve.entity.pk.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.searchentity.*;
import eve.interfaces.entity.pk.*;
import eve.logicentity.*;
import eve.logicentity.Wishlist;
import eve.logicview.*;
import eve.usecases.custom.*;
import general.exception.*;
import java.sql.Date;
import java.util.*;
import java.io.IOException;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class Wishlist_usecases {

    private boolean loggedin = false;
    private SQLreader sqlreader = new SQLreader();
    private SQLTwriter sqlwriter = new SQLTwriter();
    private BLwishlist blwishlist = new BLwishlist(sqlreader);
    
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
        SQLTqueue tq = new SQLTqueue();
        blwishlist.insertupdateWishlist(tq, wishlist);
        sqlwriter.Commit2DB(tq);
    }
//Custom code, do not change this line   

    public long count() throws DBException {
        return blwishlist.count();
    }
    
    public ArrayList<Wishlist> get_all() throws DBException {
        return blwishlist.getWishlists();
    }
    
    public boolean getWishlistExists(IWishlistPK wishlistPK) throws DBException {
        return blwishlist.getWishlistExists(wishlistPK);
    }
    
    public Wishlist get_wishlist_by_primarykey(IWishlistPK wishlistPK) throws DBException {
        return blwishlist.getWishlist(wishlistPK);
    }

    public ArrayList<Wishlist> get_wishlist_with_foreignkey_evetype(IEvetypePK evetypePK) throws CustomException {
        return blwishlist.getWishlists4evetype(evetypePK);
    }
    
    public ArrayList<Wishlist> search_wishlist(IWishlistsearch wishlistsearch) throws CustomException {
        return blwishlist.search(wishlistsearch);
    }
    
    public long search_wishlist_count(IWishlistsearch wishlistsearch) throws CustomException {
        return blwishlist.searchcount(wishlistsearch);
    }

    public void insertWishlist(IWishlist wishlist) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blwishlist.insertWishlist(tq, wishlist);
        sqlwriter.Commit2DB(tq);
    }

    public void updateWishlist(IWishlist wishlist) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blwishlist.updateWishlist(tq, wishlist);
        sqlwriter.Commit2DB(tq);
    }

    public void deleteWishlist(IWishlist wishlist) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blwishlist.deleteWishlist(tq, wishlist);
        sqlwriter.Commit2DB(tq);
    }

    public void delete_all_containing_Evetype(IEvetypePK evetypePK) throws CustomException {
        SQLTqueue tq = new SQLTqueue();
        blwishlist.delete4evetype(tq, evetypePK);
        sqlwriter.Commit2DB(tq);
    }
    
}

