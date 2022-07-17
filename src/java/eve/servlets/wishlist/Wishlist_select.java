/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 17.6.2022 13:4
 */

package eve.servlets.wishlist;

import general.exception.*;
import data.interfaces.db.Filedata;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.IWishlist;
import eve.interfaces.servlet.IWishlistOperation;
import eve.interfaces.searchentity.IWishlistsearch;
import eve.servlets.DataServlet;
import eve.servlets.SecurityDataServlet;
import eve.usecases.Wishlist_usecases;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Franky Laseure
 */
@WebServlet(name="Wishlist_select", urlPatterns={"/eve.Wishlist_select"})
public class Wishlist_select extends SecurityDataServlet {
   
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);
        Object dataobject = null;
        Wishlist_usecases wishlistusecases = new Wishlist_usecases(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operation) {
                case IWishlistOperation.SELECT_ALL:
                    dataobject = wishlistusecases.get_all();
                    break;
                case IWishlistOperation.SELECT_WISHLIST:
                    dataobject = get_wishlist_with_primarykey(wishlistusecases);
                    break;
                case IWishlistOperation.SELECT_Evetype:
                    dataobject = get_wishlist_with_foreignkey_evetype(wishlistusecases);
                    break;
                case IWishlistOperation.SELECT_SEARCH:
                    dataobject = search_wishlist(wishlistusecases);
                    break;
                case IWishlistOperation.SELECT_SEARCHCOUNT:
                    dataobject = search_wishlist_count(wishlistusecases);
                    break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            }

        } 
        catch(CustomException e) {
            dataobject = e;
        }
        finally {
        }
        this.sendData(response, dataobject);
    } 

//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   

    private Object get_wishlist_with_primarykey(Wishlist_usecases wishlistusecases) throws DBException {
        IWishlistPK wishlistPK = (IWishlistPK)parser.getJavaObject("wishlistpk");
        return wishlistusecases.get_wishlist_by_primarykey(wishlistPK);
    }

    private Object get_wishlist_with_foreignkey_evetype(Wishlist_usecases wishlistusecases) throws CustomException {
        IEvetypePK evetypePK = (IEvetypePK)parser.getJavaObject("evetypepk");
        return wishlistusecases.get_wishlist_with_foreignkey_evetype(evetypePK);
    }
    
    private Object search_wishlist(Wishlist_usecases wishlistusecases) throws CustomException {
        IWishlistsearch search = (IWishlistsearch)parser.getJavaObject("search");
        return wishlistusecases.search_wishlist(search);
    }
    
    private Object search_wishlist_count(Wishlist_usecases wishlistusecases) throws CustomException {
        IWishlistsearch wishlistsearch = (IWishlistsearch)parser.getJavaObject("search");
        return wishlistusecases.search_wishlist_count(wishlistsearch);
    }

    @Override
    public String getServletInfo() {
        return "wishlist_select";
    }

}

