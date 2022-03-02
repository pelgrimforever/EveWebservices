/*
 * View_evetype_order_history_region_month.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 11.1.2022 21:46
 *
 */

package eve.servlets.data;

import eve.BusinessObject.Logic.BLview_evetype_order_history_region_month;
import general.exception.CustomException;
import data.interfaces.db.Filedata;
import eve.interfaces.logicview.IView_evetype_order_history_region_month;
import eve.interfaces.servlet.IView_evetype_order_history_region_monthOperation;
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
@WebServlet(name="View_evetype_order_history_region_month", urlPatterns={"/eve.View_evetype_order_history_region_month"})
public class View_evetype_order_history_region_month extends SecurityDataServlet {
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
        BLview_evetype_order_history_region_month blview_evetype_order_history_region_month = new BLview_evetype_order_history_region_month();
        //boolean privateaccess = userprofile!=null && userprofile.privateaccess();
        try {
            switch(this.operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    switch(this.operation) {
                        case IView_evetype_order_history_region_monthOperation.SELECT_ALL:
                            dataobject = blview_evetype_order_history_region_month.getView_evetype_order_history_region_months();
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
        return "view_evetype_order_history_region_month";
    }

}

