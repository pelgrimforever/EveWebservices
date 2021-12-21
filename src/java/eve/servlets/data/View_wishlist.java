/*
 * View_wishlist.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 16.11.2021 15:51
 *
 */

package eve.servlets.data;

import eve.BusinessObject.Logic.BLview_wishlist;
import general.exception.CustomException;
import data.interfaces.db.Filedata;
import eve.interfaces.logicview.IView_wishlist;
import eve.interfaces.servlet.IView_wishlistOperation;
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
@WebServlet(name="View_wishlist", urlPatterns={"/eve.View_wishlist"})
public class View_wishlist extends SecurityDataServlet {
//Metacoder: NO AUTHOMATIC UPDATE
   
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
        BLview_wishlist blview_wishlist = new BLview_wishlist();
        //boolean privateaccess = userprofile!=null && userprofile.privateaccess();
        try {
            switch(this.operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    switch(this.operation) {
                        case IView_wishlistOperation.SELECT_ALL:
                            dataobject = blview_wishlist.getView_wishlists();
                            break;
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
        return "view_wishlist";
    }

}

