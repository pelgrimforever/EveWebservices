/*
 * Systemtrade_order.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 6.9.2021 16:29
 *
 */

package eve.servlets.data;

import eve.BusinessObject.Logic.*;
import general.exception.CustomException;
import data.interfaces.db.Filedata;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.ISystemtrade_order;
import eve.interfaces.servlet.ISystemtrade_orderOperation;
import eve.interfaces.searchentity.ISystemtrade_ordersearch;
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
@WebServlet(name="Systemtrade_order", urlPatterns={"/eve.Systemtrade_order"})
public class Systemtrade_order extends SecurityDataServlet {
   
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
        BLsystemtrade_order blsystemtrade_order = new BLsystemtrade_order();
        blsystemtrade_order.setAuthenticated(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    ISystemtrade_orderPK systemtrade_orderPK;
                    ISystemtrade_order systemtrade_order;
                    switch(this.operation) {
                        case ISystemtrade_orderOperation.SELECT_ALL:
                            dataobject = blsystemtrade_order.getSystemtrade_orders();
                            break;
                        case ISystemtrade_orderOperation.SELECT_SYSTEMTRADE_ORDER:
                            systemtrade_orderPK = (ISystemtrade_orderPK)parser.getJavaObject("systemtrade_orderpk");
                            dataobject = blsystemtrade_order.getSystemtrade_order(systemtrade_orderPK);
                            break;
                        case ISystemtrade_orderOperation.SELECT_Ordersbuy_order:
                            IOrdersPK ordersBuy_orderPK = (IOrdersPK)parser.getJavaObject("orderspk");
                            dataobject = blsystemtrade_order.getSystemtrade_orders4ordersBuy_order(ordersBuy_orderPK);
                            break;
                        case ISystemtrade_orderOperation.SELECT_Orderssell_order:
                            IOrdersPK ordersSell_orderPK = (IOrdersPK)parser.getJavaObject("orderspk");
                            dataobject = blsystemtrade_order.getSystemtrade_orders4ordersSell_order(ordersSell_orderPK);
                            break;
                        case ISystemtrade_orderOperation.SELECT_Systemtrade:
                            ISystemtradePK systemtradePK = (ISystemtradePK)parser.getJavaObject("systemtradepk");
                            dataobject = blsystemtrade_order.getSystemtrade_orders4systemtrade(systemtradePK);
                            break;
                        case ISystemtrade_orderOperation.SELECT_SEARCH:
                            ISystemtrade_ordersearch search = (ISystemtrade_ordersearch)parser.getJavaObject("search");
                            dataobject = blsystemtrade_order.search(search);
                            break;
                        case ISystemtrade_orderOperation.SELECT_SEARCHCOUNT:
                            ISystemtrade_ordersearch systemtrade_ordersearch = (ISystemtrade_ordersearch)parser.getJavaObject("search");
                            dataobject = blsystemtrade_order.searchcount(systemtrade_ordersearch);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;

                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(this.operation) {
                        case ISystemtrade_orderOperation.INSERT_SYSTEMTRADE_ORDER:
                            systemtrade_order = (ISystemtrade_order)parser.getJavaObject("systemtrade_order");
                            blsystemtrade_order.insertSystemtrade_order(systemtrade_order);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(this.operation) {
                        case ISystemtrade_orderOperation.UPDATE_SYSTEMTRADE_ORDER:
                            systemtrade_order = (ISystemtrade_order)parser.getJavaObject("systemtrade_order");
                            blsystemtrade_order.updateSystemtrade_order(systemtrade_order);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(this.operation) {
                        case ISystemtrade_orderOperation.DELETE_SYSTEMTRADE_ORDER:
                            systemtrade_order = (ISystemtrade_order)parser.getJavaObject("systemtrade_order");
                            blsystemtrade_order.deleteSystemtrade_order(systemtrade_order);
                            break;
                        case ISystemtrade_orderOperation.DELETE_Ordersbuy_order:
                            IOrdersPK ordersBuy_orderPK = (IOrdersPK)parser.getJavaObject("orderspk");
                            blsystemtrade_order.delete4ordersBuy_order(this.getServletName(), ordersBuy_orderPK);
                            break;
                        case ISystemtrade_orderOperation.DELETE_Orderssell_order:
                            IOrdersPK ordersSell_orderPK = (IOrdersPK)parser.getJavaObject("orderspk");
                            blsystemtrade_order.delete4ordersSell_order(this.getServletName(), ordersSell_orderPK);
                            break;
                        case ISystemtrade_orderOperation.DELETE_Systemtrade:
                            ISystemtradePK systemtradePK = (ISystemtradePK)parser.getJavaObject("systemtradepk");
                            blsystemtrade_order.delete4systemtrade(this.getServletName(), systemtradePK);
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
        return "systemtrade_order";
    }

}

