/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 23.8.2022 14:38
 * @author Franky Laseure
 */

package eve.servlets.stock;

import general.exception.*;
import data.interfaces.db.Filedata;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.IStock;
import eve.interfaces.servlet.IStockOperation;
import eve.interfaces.searchentity.IStocksearch;
import eve.servlets.DataServlet;
import eve.servlets.SecurityDataServlet;
import eve.usecases.Stock_usecases;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="Stock_select", urlPatterns={"/eve.Stock_select"})
public class Stock_select extends SecurityDataServlet {
   
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);
        Object dataobject = null;
        Stock_usecases stockusecases = new Stock_usecases(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operation) {
                case IStockOperation.SELECT_ALL:
                    dataobject = stockusecases.get_all();
                    break;
                case IStockOperation.SELECT_STOCK:
                    dataobject = get_stock_with_primarykey(stockusecases);
                    break;
                case IStockOperation.SELECT_Evetype:
                    dataobject = get_stock_with_foreignkey_evetype(stockusecases);
                    break;
                case IStockOperation.SELECT_Stocktrade:
                    dataobject = get_stock_with_externalforeignkey_stocktrade(stockusecases);
                    break;
                case IStockOperation.SELECT_SEARCH:
                    dataobject = search_stock(stockusecases);
                    break;
                case IStockOperation.SELECT_SEARCHCOUNT:
                    dataobject = search_stock_count(stockusecases);
                    break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            }

        } 
        catch(CustomException e) {
            dataobject = e;
        }
        finally {
        }
        this.sendData(response, dataobject);
    } 

//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   

    private Object get_stock_with_primarykey(Stock_usecases stockusecases) throws DBException {
        IStockPK stockPK = (IStockPK)parser.getJavaObject("stockpk");
        return stockusecases.get_stock_by_primarykey(stockPK);
    }

    private Object get_stock_with_foreignkey_evetype(Stock_usecases stockusecases) throws CustomException {
        IEvetypePK evetypePK = (IEvetypePK)parser.getJavaObject("evetypepk");
        return stockusecases.get_stock_with_foreignkey_evetype(evetypePK);
    }
    
    private Object get_stock_with_externalforeignkey_stocktrade(Stock_usecases stockusecases) throws CustomException {
        IStocktradePK stocktradePK = (IStocktradePK)parser.getJavaObject("stocktradepk");
        return stockusecases.get_stock_with_externalforeignkey_stocktrade(stocktradePK);
    }
    
    private Object search_stock(Stock_usecases stockusecases) throws CustomException {
        IStocksearch search = (IStocksearch)parser.getJavaObject("search");
        return stockusecases.search_stock(search);
    }
    
    private Object search_stock_count(Stock_usecases stockusecases) throws CustomException {
        IStocksearch stocksearch = (IStocksearch)parser.getJavaObject("search");
        return stockusecases.search_stock_count(stocksearch);
    }

    @Override
    public String getServletInfo() {
        return "stock_select";
    }

}

