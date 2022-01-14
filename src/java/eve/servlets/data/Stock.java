/*
 * Stock.java
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
import eve.interfaces.logicentity.IStock;
import eve.interfaces.servlet.IStockOperation;
import eve.interfaces.searchentity.IStocksearch;
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
@WebServlet(name="Stock", urlPatterns={"/eve.Stock"})
public class Stock extends SecurityDataServlet {
   
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
        BLstock blstock = new BLstock();
        blstock.setAuthenticated(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    IStockPK stockPK;
                    IStock stock;
                    switch(this.operation) {
                        case IStockOperation.SELECT_ALL:
                            dataobject = blstock.getStocks();
                            break;
                        case IStockOperation.SELECT_STOCK:
                            stockPK = (IStockPK)parser.getJavaObject("stockpk");
                            dataobject = blstock.getStock(stockPK);
                            break;
                        case IStockOperation.SELECT_Evetype:
                            IEvetypePK evetypePK = (IEvetypePK)parser.getJavaObject("evetypepk");
                            dataobject = blstock.getStocks4evetype(evetypePK);
                            break;
                        case IStockOperation.SELECT_Stocktrade:
                            IStocktradePK stocktradePK = (IStocktradePK)parser.getJavaObject("stocktradepk");
                            dataobject = blstock.getStocktrade(stocktradePK);
                            break;
                        case IStockOperation.SELECT_SEARCH:
                            IStocksearch search = (IStocksearch)parser.getJavaObject("search");
                            dataobject = blstock.search(search);
                            break;
                        case IStockOperation.SELECT_SEARCHCOUNT:
                            IStocksearch stocksearch = (IStocksearch)parser.getJavaObject("search");
                            dataobject = blstock.searchcount(stocksearch);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;

                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(this.operation) {
                        case IStockOperation.INSERT_STOCK:
                            stock = (IStock)parser.getJavaObject("stock");
                            blstock.insertStock(stock);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(this.operation) {
                        case IStockOperation.UPDATE_STOCK:
                            stock = (IStock)parser.getJavaObject("stock");
                            blstock.updateStock(stock);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(this.operation) {
                        case IStockOperation.DELETE_STOCK:
                            stock = (IStock)parser.getJavaObject("stock");
                            blstock.deleteStock(stock);
                            break;
                        case IStockOperation.DELETE_Evetype:
                            IEvetypePK evetypePK = (IEvetypePK)parser.getJavaObject("evetypepk");
                            blstock.delete4evetype(evetypePK);
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
        return "stock";
    }

}

