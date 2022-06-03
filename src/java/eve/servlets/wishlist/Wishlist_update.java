/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 20.4.2022 10:3
 */

package eve.servlets.wishlist;

import general.exception.CustomException;
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
@WebServlet(name="Wishlist_update", urlPatterns={"/eve.Wishlist_update"})
public class Wishlist_update extends SecurityDataServlet {
   
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
                case IWishlistOperation.UPDATE_WISHLIST:
                    update_wishlist(wishlistusecases);
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

    private void update_wishlist(Wishlist_usecases wishlistusecases) throws CustomException {
        IWishlist wishlist = (IWishlist)parser.getJavaObject("wishlist");
        wishlistusecases.secureupdateWishlist(wishlist);
    }
    
    @Override
    public String getServletInfo() {
        return "wishlist_insert";
    }

}

