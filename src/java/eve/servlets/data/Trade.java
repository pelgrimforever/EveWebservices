/*
 * Trade.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 30.10.2021 10:3
 *
 */

package eve.servlets.data;

import eve.BusinessObject.Logic.*;
import general.exception.CustomException;
import data.interfaces.db.Filedata;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.ITrade;
import eve.interfaces.servlet.ITradeOperation;
import eve.interfaces.searchentity.ITradesearch;
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
@WebServlet(name="Trade", urlPatterns={"/eve.Trade"})
public class Trade extends SecurityDataServlet {
   
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
        BLtrade bltrade = new BLtrade();
        bltrade.setAuthenticated(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    ITradePK tradePK;
                    ITrade trade;
                    switch(this.operation) {
                        case ITradeOperation.SELECT_ALL:
                            dataobject = bltrade.getTrades();
                            break;
                        case ITradeOperation.SELECT_TRADE:
                            tradePK = (ITradePK)parser.getJavaObject("tradepk");
                            dataobject = bltrade.getTrade(tradePK);
                            break;
                        case ITradeOperation.SELECT_Orderssell_order_id:
                            IOrdersPK ordersSell_order_idPK = (IOrdersPK)parser.getJavaObject("orderspk");
                            dataobject = bltrade.getTrades4ordersSell_order_id(ordersSell_order_idPK);
                            break;
                        case ITradeOperation.SELECT_Ordersbuy_order_id:
                            IOrdersPK ordersBuy_order_idPK = (IOrdersPK)parser.getJavaObject("orderspk");
                            dataobject = bltrade.getTrades4ordersBuy_order_id(ordersBuy_order_idPK);
                            break;
                        case ITradeOperation.SELECT_SEARCH:
                            ITradesearch search = (ITradesearch)parser.getJavaObject("search");
                            dataobject = bltrade.search(search);
                            break;
                        case ITradeOperation.SELECT_SEARCHCOUNT:
                            ITradesearch tradesearch = (ITradesearch)parser.getJavaObject("search");
                            dataobject = bltrade.searchcount(tradesearch);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;

                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(this.operation) {
                        case ITradeOperation.INSERT_TRADE:
                            trade = (ITrade)parser.getJavaObject("trade");
                            bltrade.insertTrade(trade);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(this.operation) {
                        case ITradeOperation.UPDATE_TRADE:
                            trade = (ITrade)parser.getJavaObject("trade");
                            bltrade.updateTrade(trade);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(this.operation) {
                        case ITradeOperation.DELETE_TRADE:
                            trade = (ITrade)parser.getJavaObject("trade");
                            bltrade.deleteTrade(trade);
                            break;
                        case ITradeOperation.DELETE_Orderssell_order_id:
                            IOrdersPK ordersSell_order_idPK = (IOrdersPK)parser.getJavaObject("orderspk");
                            bltrade.delete4ordersSell_order_id(ordersSell_order_idPK);
                            break;
                        case ITradeOperation.DELETE_Ordersbuy_order_id:
                            IOrdersPK ordersBuy_order_idPK = (IOrdersPK)parser.getJavaObject("orderspk");
                            bltrade.delete4ordersBuy_order_id(ordersBuy_order_idPK);
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
        return "trade";
    }

}

