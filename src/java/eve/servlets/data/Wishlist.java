/*
 * Wishlist.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 14.0.2022 16:56
 *
 */

package eve.servlets.data;

import eve.BusinessObject.Logic.*;
import general.exception.CustomException;
import data.interfaces.db.Filedata;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.IWishlist;
import eve.interfaces.servlet.IWishlistOperation;
import eve.interfaces.searchentity.IWishlistsearch;
import eve.servlets.DataServlet;
import eve.servlets.SecurityDataServlet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Franky Laseure
 */
@WebServlet(name="Wishlist", urlPatterns={"/eve.Wishlist"})
public class Wishlist extends SecurityDataServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);

        Object dataobject = null;
        BLwishlist blwishlist = new BLwishlist();
        blwishlist.setAuthenticated(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    IWishlistPK wishlistPK;
                    IWishlist wishlist;
                    switch(this.operation) {
                        case IWishlistOperation.SELECT_ALL:
                            dataobject = blwishlist.getWishlists();
                            break;
                        case IWishlistOperation.SELECT_WISHLIST:
                            wishlistPK = (IWishlistPK)parser.getJavaObject("wishlistpk");
                            dataobject = blwishlist.getWishlist(wishlistPK);
                            break;
                        case IWishlistOperation.SELECT_Evetype:
                            IEvetypePK evetypePK = (IEvetypePK)parser.getJavaObject("evetypepk");
                            dataobject = blwishlist.getWishlists4evetype(evetypePK);
                            break;
                        case IWishlistOperation.SELECT_SEARCH:
                            IWishlistsearch search = (IWishlistsearch)parser.getJavaObject("search");
                            dataobject = blwishlist.search(search);
                            break;
                        case IWishlistOperation.SELECT_SEARCHCOUNT:
                            IWishlistsearch wishlistsearch = (IWishlistsearch)parser.getJavaObject("search");
                            dataobject = blwishlist.searchcount(wishlistsearch);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;

                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(this.operation) {
                        case IWishlistOperation.INSERT_WISHLIST:
                            wishlist = (IWishlist)parser.getJavaObject("wishlist");
                            blwishlist.insertWishlist(wishlist);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(this.operation) {
                        case IWishlistOperation.UPDATE_WISHLIST:
                            wishlist = (IWishlist)parser.getJavaObject("wishlist");
                            blwishlist.updateWishlist(wishlist);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(this.operation) {
                        case IWishlistOperation.DELETE_WISHLIST:
                            wishlist = (IWishlist)parser.getJavaObject("wishlist");
                            blwishlist.deleteWishlist(wishlist);
                            break;
                        case IWishlistOperation.DELETE_Evetype:
                            IEvetypePK evetypePK = (IEvetypePK)parser.getJavaObject("evetypepk");
                            blwishlist.delete4evetype(evetypePK);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_BACKUP:
                    switch(this.operation) {
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line
                    }
                    break;
            }

        } 
        catch(CustomException e) {
            dataobject = e;
        }
        finally {
        }
        this.sendData(response, dataobject);
    } 

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "wishlist";
    }

}

