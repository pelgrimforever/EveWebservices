/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 20.4.2022 10:3
 */

package eve.servlets.tradecombined_sell;

import general.exception.*;
import data.interfaces.db.Filedata;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.ITradecombined_sell;
import eve.interfaces.servlet.ITradecombined_sellOperation;
import eve.interfaces.searchentity.ITradecombined_sellsearch;
import eve.servlets.DataServlet;
import eve.servlets.SecurityDataServlet;
import eve.usecases.Tradecombined_sell_usecases;
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
@WebServlet(name="Tradecombined_sell_select", urlPatterns={"/eve.Tradecombined_sell_select"})
public class Tradecombined_sell_select extends SecurityDataServlet {
   
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);
        Object dataobject = null;
        Tradecombined_sell_usecases tradecombined_sellusecases = new Tradecombined_sell_usecases(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operation) {
                case ITradecombined_sellOperation.SELECT_ALL:
                    dataobject = tradecombined_sellusecases.get_all();
                    break;
                case ITradecombined_sellOperation.SELECT_TRADECOMBINED_SELL:
                    dataobject = get_tradecombined_sell_with_primarykey(tradecombined_sellusecases);
                    break;
                case ITradecombined_sellOperation.SELECT_Ordersbuy_order_id:
                    dataobject = get_tradecombined_sell_with_foreignkey_ordersBuy_order_id(tradecombined_sellusecases);
                    break;
                case ITradecombined_sellOperation.SELECT_Orderssell_order_id:
                    dataobject = get_tradecombined_sell_with_foreignkey_ordersSell_order_id(tradecombined_sellusecases);
                    break;
                case ITradecombined_sellOperation.SELECT_Tradecombined:
                    dataobject = get_tradecombined_sell_with_foreignkey_tradecombined(tradecombined_sellusecases);
                    break;
                case ITradecombined_sellOperation.SELECT_SEARCH:
                    dataobject = search_tradecombined_sell(tradecombined_sellusecases);
                    break;
                case ITradecombined_sellOperation.SELECT_SEARCHCOUNT:
                    dataobject = search_tradecombined_sell_count(tradecombined_sellusecases);
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

    private Object get_tradecombined_sell_with_primarykey(Tradecombined_sell_usecases tradecombined_sellusecases) throws DBException {
        ITradecombined_sellPK tradecombined_sellPK = (ITradecombined_sellPK)parser.getJavaObject("tradecombined_sellpk");
        return tradecombined_sellusecases.get_tradecombined_sell_by_primarykey(tradecombined_sellPK);
    }

    private Object get_tradecombined_sell_with_foreignkey_ordersBuy_order_id(Tradecombined_sell_usecases tradecombined_sellusecases) throws CustomException {
        IOrdersPK ordersBuy_order_idPK = (IOrdersPK)parser.getJavaObject("orderspk");
        return tradecombined_sellusecases.get_tradecombined_sell_with_foreignkey_ordersBuy_order_id(ordersBuy_order_idPK);
    }
    
    private Object get_tradecombined_sell_with_foreignkey_ordersSell_order_id(Tradecombined_sell_usecases tradecombined_sellusecases) throws CustomException {
        IOrdersPK ordersSell_order_idPK = (IOrdersPK)parser.getJavaObject("orderspk");
        return tradecombined_sellusecases.get_tradecombined_sell_with_foreignkey_ordersSell_order_id(ordersSell_order_idPK);
    }
    
    private Object get_tradecombined_sell_with_foreignkey_tradecombined(Tradecombined_sell_usecases tradecombined_sellusecases) throws CustomException {
        ITradecombinedPK tradecombinedPK = (ITradecombinedPK)parser.getJavaObject("tradecombinedpk");
        return tradecombined_sellusecases.get_tradecombined_sell_with_foreignkey_tradecombined(tradecombinedPK);
    }
    
    private Object search_tradecombined_sell(Tradecombined_sell_usecases tradecombined_sellusecases) throws CustomException {
        ITradecombined_sellsearch search = (ITradecombined_sellsearch)parser.getJavaObject("search");
        return tradecombined_sellusecases.search_tradecombined_sell(search);
    }
    
    private Object search_tradecombined_sell_count(Tradecombined_sell_usecases tradecombined_sellusecases) throws CustomException {
        ITradecombined_sellsearch tradecombined_sellsearch = (ITradecombined_sellsearch)parser.getJavaObject("search");
        return tradecombined_sellusecases.search_tradecombined_sell_count(tradecombined_sellsearch);
    }

    @Override
    public String getServletInfo() {
        return "tradecombined_sell_select";
    }

}

