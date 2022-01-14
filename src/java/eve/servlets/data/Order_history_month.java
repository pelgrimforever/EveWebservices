/*
 * Order_history_month.java
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
import eve.interfaces.logicentity.IOrder_history_month;
import eve.interfaces.servlet.IOrder_history_monthOperation;
import eve.interfaces.searchentity.IOrder_history_monthsearch;
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
@WebServlet(name="Order_history_month", urlPatterns={"/eve.Order_history_month"})
public class Order_history_month extends SecurityDataServlet {
   
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
        BLorder_history_month blorder_history_month = new BLorder_history_month();
        blorder_history_month.setAuthenticated(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    IOrder_history_monthPK order_history_monthPK;
                    IOrder_history_month order_history_month;
                    switch(this.operation) {
                        case IOrder_history_monthOperation.SELECT_ALL:
                            dataobject = blorder_history_month.getOrder_history_months();
                            break;
                        case IOrder_history_monthOperation.SELECT_ORDER_HISTORY_MONTH:
                            order_history_monthPK = (IOrder_history_monthPK)parser.getJavaObject("order_history_monthpk");
                            dataobject = blorder_history_month.getOrder_history_month(order_history_monthPK);
                            break;
                        case IOrder_history_monthOperation.SELECT_Evetype:
                            IEvetypePK evetypePK = (IEvetypePK)parser.getJavaObject("evetypepk");
                            dataobject = blorder_history_month.getOrder_history_months4evetype(evetypePK);
                            break;
                        case IOrder_history_monthOperation.SELECT_Region:
                            IRegionPK regionPK = (IRegionPK)parser.getJavaObject("regionpk");
                            dataobject = blorder_history_month.getOrder_history_months4region(regionPK);
                            break;
                        case IOrder_history_monthOperation.SELECT_SEARCH:
                            IOrder_history_monthsearch search = (IOrder_history_monthsearch)parser.getJavaObject("search");
                            dataobject = blorder_history_month.search(search);
                            break;
                        case IOrder_history_monthOperation.SELECT_SEARCHCOUNT:
                            IOrder_history_monthsearch order_history_monthsearch = (IOrder_history_monthsearch)parser.getJavaObject("search");
                            dataobject = blorder_history_month.searchcount(order_history_monthsearch);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;

                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(this.operation) {
                        case IOrder_history_monthOperation.INSERT_ORDER_HISTORY_MONTH:
                            order_history_month = (IOrder_history_month)parser.getJavaObject("order_history_month");
                            blorder_history_month.insertOrder_history_month(order_history_month);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(this.operation) {
                        case IOrder_history_monthOperation.UPDATE_ORDER_HISTORY_MONTH:
                            order_history_month = (IOrder_history_month)parser.getJavaObject("order_history_month");
                            blorder_history_month.updateOrder_history_month(order_history_month);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(this.operation) {
                        case IOrder_history_monthOperation.DELETE_ORDER_HISTORY_MONTH:
                            order_history_month = (IOrder_history_month)parser.getJavaObject("order_history_month");
                            blorder_history_month.deleteOrder_history_month(order_history_month);
                            break;
                        case IOrder_history_monthOperation.DELETE_Evetype:
                            IEvetypePK evetypePK = (IEvetypePK)parser.getJavaObject("evetypepk");
                            blorder_history_month.delete4evetype(evetypePK);
                            break;
                        case IOrder_history_monthOperation.DELETE_Region:
                            IRegionPK regionPK = (IRegionPK)parser.getJavaObject("regionpk");
                            blorder_history_month.delete4region(regionPK);
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
        return "order_history_month";
    }

}

