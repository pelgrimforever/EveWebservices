/*
 * View_tradecombined.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 23.10.2021 18:1
 *
 */

package eve.servlets.data;

import eve.BusinessObject.Logic.BLview_tradecombined;
import general.exception.CustomException;
import data.interfaces.db.Filedata;
import eve.interfaces.logicview.IView_tradecombined;
import eve.interfaces.servlet.IView_tradecombinedOperation;
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
@WebServlet(name="View_tradecombined", urlPatterns={"/eve.View_tradecombined"})
public class View_tradecombined extends SecurityDataServlet {
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
        BLview_tradecombined blview_tradecombined = new BLview_tradecombined();
        //boolean privateaccess = userprofile!=null && userprofile.privateaccess();
        try {
            switch(this.operationtype) {
                case DataServlet.SELECT:
                    switch(this.operation) {
                        case IView_tradecombinedOperation.SELECT_ALL:
                            dataobject = blview_tradecombined.getView_tradecombineds();
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
        return "view_tradecombined";
    }

}

