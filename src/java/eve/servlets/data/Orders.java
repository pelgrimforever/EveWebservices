/*
 * Orders.java
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
import eve.interfaces.logicentity.IOrders;
import eve.interfaces.servlet.IOrdersOperation;
import eve.interfaces.searchentity.IOrderssearch;
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
@WebServlet(name="Orders", urlPatterns={"/eve.Orders"})
public class Orders extends SecurityDataServlet {
   
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
        BLorders blorders = new BLorders();
        blorders.setAuthenticated(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    IOrdersPK ordersPK;
                    IOrders orders;
                    switch(this.operation) {
                        case IOrdersOperation.SELECT_ALL:
                            dataobject = blorders.getOrderss();
                            break;
                        case IOrdersOperation.SELECT_ORDERS:
                            ordersPK = (IOrdersPK)parser.getJavaObject("orderspk");
                            dataobject = blorders.getOrders(ordersPK);
                            break;
                        case IOrdersOperation.SELECT_Evetype:
                            IEvetypePK evetypePK = (IEvetypePK)parser.getJavaObject("evetypepk");
                            dataobject = blorders.getOrderss4evetype(evetypePK);
                            break;
                        case IOrdersOperation.SELECT_System:
                            ISystemPK systemPK = (ISystemPK)parser.getJavaObject("systempk");
                            dataobject = blorders.getOrderss4system(systemPK);
                            break;
                        case IOrdersOperation.SELECT_Tradecombined_sellbuy_order_id:
                            ITradecombined_sellPK tradecombined_sellBuy_order_idPK = (ITradecombined_sellPK)parser.getJavaObject("tradecombined_sellpk");
                            dataobject = blorders.getTradecombined_sellbuy_order_id(tradecombined_sellBuy_order_idPK);
                            break;
                        case IOrdersOperation.SELECT_Tradecombined_sellsell_order_id:
                            ITradecombined_sellPK tradecombined_sellSell_order_idPK = (ITradecombined_sellPK)parser.getJavaObject("tradecombined_sellpk");
                            dataobject = blorders.getTradecombined_sellsell_order_id(tradecombined_sellSell_order_idPK);
                            break;
                        case IOrdersOperation.SELECT_Tradesell_order_id:
                            ITradePK tradeSell_order_idPK = (ITradePK)parser.getJavaObject("tradepk");
                            dataobject = blorders.getTradesell_order_id(tradeSell_order_idPK);
                            break;
                        case IOrdersOperation.SELECT_Tradebuy_order_id:
                            ITradePK tradeBuy_order_idPK = (ITradePK)parser.getJavaObject("tradepk");
                            dataobject = blorders.getTradebuy_order_id(tradeBuy_order_idPK);
                            break;
                        case IOrdersOperation.SELECT_SEARCH:
                            IOrderssearch search = (IOrderssearch)parser.getJavaObject("search");
                            dataobject = blorders.search(search);
                            break;
                        case IOrdersOperation.SELECT_SEARCHCOUNT:
                            IOrderssearch orderssearch = (IOrderssearch)parser.getJavaObject("search");
                            dataobject = blorders.searchcount(orderssearch);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;

                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(this.operation) {
                        case IOrdersOperation.INSERT_ORDERS:
                            orders = (IOrders)parser.getJavaObject("orders");
                            blorders.insertOrders(orders);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(this.operation) {
                        case IOrdersOperation.UPDATE_ORDERS:
                            orders = (IOrders)parser.getJavaObject("orders");
                            blorders.updateOrders(orders);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(this.operation) {
                        case IOrdersOperation.DELETE_ORDERS:
                            orders = (IOrders)parser.getJavaObject("orders");
                            blorders.deleteOrders(orders);
                            break;
                        case IOrdersOperation.DELETE_Evetype:
                            IEvetypePK evetypePK = (IEvetypePK)parser.getJavaObject("evetypepk");
                            blorders.delete4evetype(evetypePK);
                            break;
                        case IOrdersOperation.DELETE_System:
                            ISystemPK systemPK = (ISystemPK)parser.getJavaObject("systempk");
                            blorders.delete4system(systemPK);
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
        return "orders";
    }

}

