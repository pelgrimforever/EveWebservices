/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 17.6.2022 13:4
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
@WebServlet(name="Wishlist_insert", urlPatterns={"/eve.Wishlist_insert"})
public class Wishlist_insert extends SecurityDataServlet {
   
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
                case IWishlistOperation.INSERT_WISHLIST:
                    insert_wishlist(wishlistusecases);
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

    private void insert_wishlist(Wishlist_usecases wishlistusecases) throws CustomException {
        IWishlist wishlist = (IWishlist)parser.getJavaObject("wishlist");
        wishlistusecases.insertWishlist(wishlist);
    }
    
    @Override
    public String getServletInfo() {
        return "wishlist_insert";
    }

}

