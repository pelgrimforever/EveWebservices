/*
 * View_shipfitorder.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 19.11.2021 16:16
 *
 */

package eve.servlets.data;

import eve.BusinessObject.Logic.BLview_shipfitorder;
import general.exception.CustomException;
import data.interfaces.db.Filedata;
import eve.interfaces.logicview.IView_shipfitorder;
import eve.interfaces.servlet.IView_shipfitorderOperation;
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
@WebServlet(name="View_shipfitorder", urlPatterns={"/eve.View_shipfitorder"})
public class View_shipfitorder extends SecurityDataServlet {
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
        BLview_shipfitorder blview_shipfitorder = new BLview_shipfitorder();
        //boolean privateaccess = userprofile!=null && userprofile.privateaccess();
        try {
            switch(this.operationtype) {
                case DataServlet.SELECT:
                    switch(this.operation) {
                        case IView_shipfitorderOperation.SELECT_ALL:
                            dataobject = blview_shipfitorder.getView_shipfitorders();
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
        return "view_shipfitorder";
    }

}

