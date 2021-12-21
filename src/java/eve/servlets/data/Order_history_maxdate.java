/*
 * Order_history_maxdate.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 12.11.2021 17:9
 *
 */

package eve.servlets.data;

import eve.BusinessObject.Logic.BLorder_history_maxdate;
import general.exception.CustomException;
import data.interfaces.db.Filedata;
import eve.interfaces.logicview.IOrder_history_maxdate;
import eve.interfaces.servlet.IOrder_history_maxdateOperation;
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
@WebServlet(name="Order_history_maxdate", urlPatterns={"/eve.Order_history_maxdate"})
public class Order_history_maxdate extends SecurityDataServlet {
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
        BLorder_history_maxdate blorder_history_maxdate = new BLorder_history_maxdate();
        //boolean privateaccess = userprofile!=null && userprofile.privateaccess();
        try {
            switch(this.operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    switch(this.operation) {
                        case IOrder_history_maxdateOperation.SELECT_ALL:
                            dataobject = blorder_history_maxdate.getOrder_history_maxdates();
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
        return "order_history_maxdate";
    }

}

