/*
 * DataServlet.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 18.6.2021 14:35
 *
 */

package eve.servlets.data;

import eve.BusinessObject.Logic.*;
import general.exception.CustomException;
import data.interfaces.db.Filedata;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.IOrder_history;
import eve.interfaces.servlet.IOrder_historyOperation;
import eve.interfaces.searchentity.IOrder_historysearch;
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
@WebServlet(name="Order_history", urlPatterns={"/eve.Order_history"})
public class Order_history extends SecurityDataServlet {
   
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
        BLorder_history blorder_history = new BLorder_history();
        blorder_history.setAuthenticated(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    IOrder_historyPK order_historyPK;
                    IOrder_history order_history;
                    switch(this.operation) {
                        case IOrder_historyOperation.SELECT_ALL:
                            dataobject = blorder_history.getOrder_historys();
                            break;
                        case IOrder_historyOperation.SELECT_ORDER_HISTORY:
                            order_historyPK = (IOrder_historyPK)parser.getJavaObject("order_historypk");
                            dataobject = blorder_history.getOrder_history(order_historyPK);
                            break;
                        case IOrder_historyOperation.SELECT_Evetype:
                            IEvetypePK evetypePK = (IEvetypePK)parser.getJavaObject("evetypepk");
                            dataobject = blorder_history.getOrder_historys4evetype(evetypePK);
                            break;
                        case IOrder_historyOperation.SELECT_Region:
                            IRegionPK regionPK = (IRegionPK)parser.getJavaObject("regionpk");
                            dataobject = blorder_history.getOrder_historys4region(regionPK);
                            break;
                        case IOrder_historyOperation.SELECT_SEARCH:
                            IOrder_historysearch search = (IOrder_historysearch)parser.getJavaObject("search");
                            dataobject = blorder_history.search(search);
                            break;
                        case IOrder_historyOperation.SELECT_SEARCHCOUNT:
                            IOrder_historysearch order_historysearch = (IOrder_historysearch)parser.getJavaObject("search");
                            dataobject = blorder_history.searchcount(order_historysearch);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;

                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(this.operation) {
                        case IOrder_historyOperation.INSERT_ORDER_HISTORY:
                            order_history = (IOrder_history)parser.getJavaObject("order_history");
                            blorder_history.insertOrder_history(order_history);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(this.operation) {
                        case IOrder_historyOperation.UPDATE_ORDER_HISTORY:
                            order_history = (IOrder_history)parser.getJavaObject("order_history");
                            blorder_history.updateOrder_history(order_history);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(this.operation) {
                        case IOrder_historyOperation.DELETE_ORDER_HISTORY:
                            order_history = (IOrder_history)parser.getJavaObject("order_history");
                            blorder_history.deleteOrder_history(order_history);
                            break;
                        case IOrder_historyOperation.DELETE_Evetype:
                            IEvetypePK evetypePK = (IEvetypePK)parser.getJavaObject("evetypepk");
                            blorder_history.delete4evetype(this.getServletName(), evetypePK);
                            break;
                        case IOrder_historyOperation.DELETE_Region:
                            IRegionPK regionPK = (IRegionPK)parser.getJavaObject("regionpk");
                            blorder_history.delete4region(this.getServletName(), regionPK);
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
        return "order_history";
    }

}

