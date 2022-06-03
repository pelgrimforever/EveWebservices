/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 20.4.2022 10:3
 */

package eve.servlets.trade;

import general.exception.*;
import data.interfaces.db.Filedata;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.ITrade;
import eve.interfaces.servlet.ITradeOperation;
import eve.interfaces.searchentity.ITradesearch;
import eve.servlets.DataServlet;
import eve.servlets.SecurityDataServlet;
import eve.usecases.Trade_usecases;
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
@WebServlet(name="Trade_select", urlPatterns={"/eve.Trade_select"})
public class Trade_select extends SecurityDataServlet {
   
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);
        Object dataobject = null;
        Trade_usecases tradeusecases = new Trade_usecases(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operation) {
                case ITradeOperation.SELECT_ALL:
                    dataobject = tradeusecases.get_all();
                    break;
                case ITradeOperation.SELECT_TRADE:
                    dataobject = get_trade_with_primarykey(tradeusecases);
                    break;
                case ITradeOperation.SELECT_Orderssell_order_id:
                    dataobject = get_trade_with_foreignkey_ordersSell_order_id(tradeusecases);
                    break;
                case ITradeOperation.SELECT_Ordersbuy_order_id:
                    dataobject = get_trade_with_foreignkey_ordersBuy_order_id(tradeusecases);
                    break;
                case ITradeOperation.SELECT_SEARCH:
                    dataobject = search_trade(tradeusecases);
                    break;
                case ITradeOperation.SELECT_SEARCHCOUNT:
                    dataobject = search_trade_count(tradeusecases);
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

    private Object get_trade_with_primarykey(Trade_usecases tradeusecases) throws DBException {
        ITradePK tradePK = (ITradePK)parser.getJavaObject("tradepk");
        return tradeusecases.get_trade_by_primarykey(tradePK);
    }

    private Object get_trade_with_foreignkey_ordersSell_order_id(Trade_usecases tradeusecases) throws CustomException {
        IOrdersPK ordersSell_order_idPK = (IOrdersPK)parser.getJavaObject("orderspk");
        return tradeusecases.get_trade_with_foreignkey_ordersSell_order_id(ordersSell_order_idPK);
    }
    
    private Object get_trade_with_foreignkey_ordersBuy_order_id(Trade_usecases tradeusecases) throws CustomException {
        IOrdersPK ordersBuy_order_idPK = (IOrdersPK)parser.getJavaObject("orderspk");
        return tradeusecases.get_trade_with_foreignkey_ordersBuy_order_id(ordersBuy_order_idPK);
    }
    
    private Object search_trade(Trade_usecases tradeusecases) throws CustomException {
        ITradesearch search = (ITradesearch)parser.getJavaObject("search");
        return tradeusecases.search_trade(search);
    }
    
    private Object search_trade_count(Trade_usecases tradeusecases) throws CustomException {
        ITradesearch tradesearch = (ITradesearch)parser.getJavaObject("search");
        return tradeusecases.search_trade_count(tradesearch);
    }

    @Override
    public String getServletInfo() {
        return "trade_select";
    }

}

