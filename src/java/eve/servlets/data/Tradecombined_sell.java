/*
 * Tradecombined_sell.java
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
import eve.interfaces.logicentity.ITradecombined_sell;
import eve.interfaces.servlet.ITradecombined_sellOperation;
import eve.interfaces.searchentity.ITradecombined_sellsearch;
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
@WebServlet(name="Tradecombined_sell", urlPatterns={"/eve.Tradecombined_sell"})
public class Tradecombined_sell extends SecurityDataServlet {
   
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
        BLtradecombined_sell bltradecombined_sell = new BLtradecombined_sell();
        bltradecombined_sell.setAuthenticated(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    ITradecombined_sellPK tradecombined_sellPK;
                    ITradecombined_sell tradecombined_sell;
                    switch(this.operation) {
                        case ITradecombined_sellOperation.SELECT_ALL:
                            dataobject = bltradecombined_sell.getTradecombined_sells();
                            break;
                        case ITradecombined_sellOperation.SELECT_TRADECOMBINED_SELL:
                            tradecombined_sellPK = (ITradecombined_sellPK)parser.getJavaObject("tradecombined_sellpk");
                            dataobject = bltradecombined_sell.getTradecombined_sell(tradecombined_sellPK);
                            break;
                        case ITradecombined_sellOperation.SELECT_Ordersbuy_order_id:
                            IOrdersPK ordersBuy_order_idPK = (IOrdersPK)parser.getJavaObject("orderspk");
                            dataobject = bltradecombined_sell.getTradecombined_sells4ordersBuy_order_id(ordersBuy_order_idPK);
                            break;
                        case ITradecombined_sellOperation.SELECT_Orderssell_order_id:
                            IOrdersPK ordersSell_order_idPK = (IOrdersPK)parser.getJavaObject("orderspk");
                            dataobject = bltradecombined_sell.getTradecombined_sells4ordersSell_order_id(ordersSell_order_idPK);
                            break;
                        case ITradecombined_sellOperation.SELECT_Tradecombined:
                            ITradecombinedPK tradecombinedPK = (ITradecombinedPK)parser.getJavaObject("tradecombinedpk");
                            dataobject = bltradecombined_sell.getTradecombined_sells4tradecombined(tradecombinedPK);
                            break;
                        case ITradecombined_sellOperation.SELECT_SEARCH:
                            ITradecombined_sellsearch search = (ITradecombined_sellsearch)parser.getJavaObject("search");
                            dataobject = bltradecombined_sell.search(search);
                            break;
                        case ITradecombined_sellOperation.SELECT_SEARCHCOUNT:
                            ITradecombined_sellsearch tradecombined_sellsearch = (ITradecombined_sellsearch)parser.getJavaObject("search");
                            dataobject = bltradecombined_sell.searchcount(tradecombined_sellsearch);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;

                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(this.operation) {
                        case ITradecombined_sellOperation.INSERT_TRADECOMBINED_SELL:
                            tradecombined_sell = (ITradecombined_sell)parser.getJavaObject("tradecombined_sell");
                            bltradecombined_sell.insertTradecombined_sell(tradecombined_sell);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(this.operation) {
                        case ITradecombined_sellOperation.UPDATE_TRADECOMBINED_SELL:
                            tradecombined_sell = (ITradecombined_sell)parser.getJavaObject("tradecombined_sell");
                            bltradecombined_sell.updateTradecombined_sell(tradecombined_sell);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(this.operation) {
                        case ITradecombined_sellOperation.DELETE_TRADECOMBINED_SELL:
                            tradecombined_sell = (ITradecombined_sell)parser.getJavaObject("tradecombined_sell");
                            bltradecombined_sell.deleteTradecombined_sell(tradecombined_sell);
                            break;
                        case ITradecombined_sellOperation.DELETE_Ordersbuy_order_id:
                            IOrdersPK ordersBuy_order_idPK = (IOrdersPK)parser.getJavaObject("orderspk");
                            bltradecombined_sell.delete4ordersBuy_order_id(ordersBuy_order_idPK);
                            break;
                        case ITradecombined_sellOperation.DELETE_Orderssell_order_id:
                            IOrdersPK ordersSell_order_idPK = (IOrdersPK)parser.getJavaObject("orderspk");
                            bltradecombined_sell.delete4ordersSell_order_id(ordersSell_order_idPK);
                            break;
                        case ITradecombined_sellOperation.DELETE_Tradecombined:
                            ITradecombinedPK tradecombinedPK = (ITradecombinedPK)parser.getJavaObject("tradecombinedpk");
                            bltradecombined_sell.delete4tradecombined(tradecombinedPK);
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
        return "tradecombined_sell";
    }

}

