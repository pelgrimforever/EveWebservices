/*
 * Stocktrade.java
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
import eve.interfaces.logicentity.IStocktrade;
import eve.interfaces.servlet.IStocktradeOperation;
import eve.interfaces.searchentity.IStocktradesearch;
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
@WebServlet(name="Stocktrade", urlPatterns={"/eve.Stocktrade"})
public class Stocktrade extends SecurityDataServlet {
   
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
        BLstocktrade blstocktrade = new BLstocktrade();
        blstocktrade.setAuthenticated(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    IStocktradePK stocktradePK;
                    IStocktrade stocktrade;
                    switch(this.operation) {
                        case IStocktradeOperation.SELECT_ALL:
                            dataobject = blstocktrade.getStocktrades();
                            break;
                        case IStocktradeOperation.SELECT_STOCKTRADE:
                            stocktradePK = (IStocktradePK)parser.getJavaObject("stocktradepk");
                            dataobject = blstocktrade.getStocktrade(stocktradePK);
                            break;
                        case IStocktradeOperation.SELECT_Stock:
                            IStockPK stockPK = (IStockPK)parser.getJavaObject("stockpk");
                            dataobject = blstocktrade.getStocktrades4stock(stockPK);
                            break;
                        case IStocktradeOperation.SELECT_SEARCH:
                            IStocktradesearch search = (IStocktradesearch)parser.getJavaObject("search");
                            dataobject = blstocktrade.search(search);
                            break;
                        case IStocktradeOperation.SELECT_SEARCHCOUNT:
                            IStocktradesearch stocktradesearch = (IStocktradesearch)parser.getJavaObject("search");
                            dataobject = blstocktrade.searchcount(stocktradesearch);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;

                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(this.operation) {
                        case IStocktradeOperation.INSERT_STOCKTRADE:
                            stocktrade = (IStocktrade)parser.getJavaObject("stocktrade");
                            blstocktrade.insertStocktrade(stocktrade);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(this.operation) {
                        case IStocktradeOperation.UPDATE_STOCKTRADE:
                            stocktrade = (IStocktrade)parser.getJavaObject("stocktrade");
                            blstocktrade.updateStocktrade(stocktrade);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(this.operation) {
                        case IStocktradeOperation.DELETE_STOCKTRADE:
                            stocktrade = (IStocktrade)parser.getJavaObject("stocktrade");
                            blstocktrade.deleteStocktrade(stocktrade);
                            break;
                        case IStocktradeOperation.DELETE_Stock:
                            IStockPK stockPK = (IStockPK)parser.getJavaObject("stockpk");
                            blstocktrade.delete4stock(stockPK);
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
        return "stocktrade";
    }

}

