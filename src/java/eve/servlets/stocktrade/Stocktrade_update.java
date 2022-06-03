/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 20.4.2022 10:3
 */

package eve.servlets.stocktrade;

import general.exception.CustomException;
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
@WebServlet(name="Stocktrade_update", urlPatterns={"/eve.Stocktrade_update"})
public class Stocktrade_update extends SecurityDataServlet {
   
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
                case IStocktradeOperation.UPDATE_STOCKTRADE:
                    update_stocktrade(stocktradeusecases);
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

    private void update_stocktrade(Stocktrade_usecases stocktradeusecases) throws CustomException {
        IStocktrade stocktrade = (IStocktrade)parser.getJavaObject("stocktrade");
        stocktradeusecases.secureupdateStocktrade(stocktrade);
    }
    
    @Override
    public String getServletInfo() {
        return "stocktrade_insert";
    }

}

