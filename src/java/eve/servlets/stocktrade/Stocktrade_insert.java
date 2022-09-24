/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 23.8.2022 14:38
 * @author Franky Laseure
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

@WebServlet(name="Stocktrade_insert", urlPatterns={"/eve.Stocktrade_insert"})
public class Stocktrade_insert extends SecurityDataServlet {
   
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
                case IStocktradeOperation.INSERT_STOCKTRADE:
                    insert_stocktrade(stocktradeusecases);
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

    private void insert_stocktrade(Stocktrade_usecases stocktradeusecases) throws CustomException {
        IStocktrade stocktrade = (IStocktrade)parser.getJavaObject("stocktrade");
        stocktradeusecases.insertStocktrade(stocktrade);
    }
    
    @Override
    public String getServletInfo() {
        return "stocktrade_insert";
    }

}

