/*
 * Order_hist.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 9.11.2021 14:30
 *
 */

package eve.servlets.data;

import eve.BusinessObject.Logic.*;
import general.exception.CustomException;
import data.interfaces.db.Filedata;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.IOrder_hist;
import eve.interfaces.servlet.IOrder_histOperation;
import eve.interfaces.searchentity.IOrder_histsearch;
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
@WebServlet(name="Order_hist", urlPatterns={"/eve.Order_hist"})
public class Order_hist extends SecurityDataServlet {
   
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
        BLorder_hist blorder_hist = new BLorder_hist();
        blorder_hist.setAuthenticated(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    IOrder_histPK order_histPK;
                    IOrder_hist order_hist;
                    switch(this.operation) {
                        case IOrder_histOperation.SELECT_ALL:
                            dataobject = blorder_hist.getOrder_hists();
                            break;
                        case IOrder_histOperation.SELECT_ORDER_HIST:
                            order_histPK = (IOrder_histPK)parser.getJavaObject("order_histpk");
                            dataobject = blorder_hist.getOrder_hist(order_histPK);
                            break;
                        case IOrder_histOperation.SELECT_Evetype:
                            IEvetypePK evetypePK = (IEvetypePK)parser.getJavaObject("evetypepk");
                            dataobject = blorder_hist.getOrder_hists4evetype(evetypePK);
                            break;
                        case IOrder_histOperation.SELECT_System:
                            ISystemPK systemPK = (ISystemPK)parser.getJavaObject("systempk");
                            dataobject = blorder_hist.getOrder_hists4system(systemPK);
                            break;
                        case IOrder_histOperation.SELECT_SEARCH:
                            IOrder_histsearch search = (IOrder_histsearch)parser.getJavaObject("search");
                            dataobject = blorder_hist.search(search);
                            break;
                        case IOrder_histOperation.SELECT_SEARCHCOUNT:
                            IOrder_histsearch order_histsearch = (IOrder_histsearch)parser.getJavaObject("search");
                            dataobject = blorder_hist.searchcount(order_histsearch);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;

                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(this.operation) {
                        case IOrder_histOperation.INSERT_ORDER_HIST:
                            order_hist = (IOrder_hist)parser.getJavaObject("order_hist");
                            blorder_hist.insertOrder_hist(order_hist);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(this.operation) {
                        case IOrder_histOperation.UPDATE_ORDER_HIST:
                            order_hist = (IOrder_hist)parser.getJavaObject("order_hist");
                            blorder_hist.updateOrder_hist(order_hist);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(this.operation) {
                        case IOrder_histOperation.DELETE_ORDER_HIST:
                            order_hist = (IOrder_hist)parser.getJavaObject("order_hist");
                            blorder_hist.deleteOrder_hist(order_hist);
                            break;
                        case IOrder_histOperation.DELETE_Evetype:
                            IEvetypePK evetypePK = (IEvetypePK)parser.getJavaObject("evetypepk");
                            blorder_hist.delete4evetype(evetypePK);
                            break;
                        case IOrder_histOperation.DELETE_System:
                            ISystemPK systemPK = (ISystemPK)parser.getJavaObject("systempk");
                            blorder_hist.delete4system(systemPK);
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
        return "order_hist";
    }

}

