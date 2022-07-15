/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 13.6.2022 11:21
 */

package eve.servlets.stocktrade;

import general.exception.*;
import data.interfaces.db.Filedata;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.IStocktrade;
import eve.interfaces.servlet.IStocktradeOperation;
import eve.interfaces.searchentity.IStocktradesearch;
import eve.servlets.DataServlet;
import eve.servlets.SecurityDataServlet;
import eve.usecases.Stocktrade_usecases;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Franky Laseure
 */
@WebServlet(name="Stocktrade_select", urlPatterns={"/eve.Stocktrade_select"})
public class Stocktrade_select extends SecurityDataServlet {
   
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);
        Object dataobject = null;
        Stocktrade_usecases stocktradeusecases = new Stocktrade_usecases(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operation) {
                case IStocktradeOperation.SELECT_ALL:
                    dataobject = stocktradeusecases.get_all();
                    break;
                case IStocktradeOperation.SELECT_STOCKTRADE:
                    dataobject = get_stocktrade_with_primarykey(stocktradeusecases);
                    break;
                case IStocktradeOperation.SELECT_Stock:
                    dataobject = get_stocktrade_with_foreignkey_stock(stocktradeusecases);
                    break;
                case IStocktradeOperation.SELECT_SEARCH:
                    dataobject = search_stocktrade(stocktradeusecases);
                    break;
                case IStocktradeOperation.SELECT_SEARCHCOUNT:
                    dataobject = search_stocktrade_count(stocktradeusecases);
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

    private Object get_stocktrade_with_primarykey(Stocktrade_usecases stocktradeusecases) throws DBException {
        IStocktradePK stocktradePK = (IStocktradePK)parser.getJavaObject("stocktradepk");
        return stocktradeusecases.get_stocktrade_by_primarykey(stocktradePK);
    }

    private Object get_stocktrade_with_foreignkey_stock(Stocktrade_usecases stocktradeusecases) throws CustomException {
        IStockPK stockPK = (IStockPK)parser.getJavaObject("stockpk");
        return stocktradeusecases.get_stocktrade_with_foreignkey_stock(stockPK);
    }
    
    private Object search_stocktrade(Stocktrade_usecases stocktradeusecases) throws CustomException {
        IStocktradesearch search = (IStocktradesearch)parser.getJavaObject("search");
        return stocktradeusecases.search_stocktrade(search);
    }
    
    private Object search_stocktrade_count(Stocktrade_usecases stocktradeusecases) throws CustomException {
        IStocktradesearch stocktradesearch = (IStocktradesearch)parser.getJavaObject("search");
        return stocktradeusecases.search_stocktrade_count(stocktradesearch);
    }

    @Override
    public String getServletInfo() {
        return "stocktrade_select";
    }

}

