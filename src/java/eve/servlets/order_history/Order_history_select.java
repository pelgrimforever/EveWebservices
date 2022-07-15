/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 13.6.2022 11:21
 */

package eve.servlets.order_history;

import general.exception.*;
import data.interfaces.db.Filedata;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.IOrder_history;
import eve.interfaces.servlet.IOrder_historyOperation;
import eve.interfaces.searchentity.IOrder_historysearch;
import eve.servlets.DataServlet;
import eve.servlets.SecurityDataServlet;
import eve.usecases.Order_history_usecases;
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
@WebServlet(name="Order_history_select", urlPatterns={"/eve.Order_history_select"})
public class Order_history_select extends SecurityDataServlet {
   
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);
        Object dataobject = null;
        Order_history_usecases order_historyusecases = new Order_history_usecases(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operation) {
                case IOrder_historyOperation.SELECT_ALL:
                    dataobject = order_historyusecases.get_all();
                    break;
                case IOrder_historyOperation.SELECT_ORDER_HISTORY:
                    dataobject = get_order_history_with_primarykey(order_historyusecases);
                    break;
                case IOrder_historyOperation.SELECT_Evetype:
                    dataobject = get_order_history_with_foreignkey_evetype(order_historyusecases);
                    break;
                case IOrder_historyOperation.SELECT_Region:
                    dataobject = get_order_history_with_foreignkey_region(order_historyusecases);
                    break;
                case IOrder_historyOperation.SELECT_SEARCH:
                    dataobject = search_order_history(order_historyusecases);
                    break;
                case IOrder_historyOperation.SELECT_SEARCHCOUNT:
                    dataobject = search_order_history_count(order_historyusecases);
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

    private Object get_order_history_with_primarykey(Order_history_usecases order_historyusecases) throws DBException {
        IOrder_historyPK order_historyPK = (IOrder_historyPK)parser.getJavaObject("order_historypk");
        return order_historyusecases.get_order_history_by_primarykey(order_historyPK);
    }

    private Object get_order_history_with_foreignkey_evetype(Order_history_usecases order_historyusecases) throws CustomException {
        IEvetypePK evetypePK = (IEvetypePK)parser.getJavaObject("evetypepk");
        return order_historyusecases.get_order_history_with_foreignkey_evetype(evetypePK);
    }
    
    private Object get_order_history_with_foreignkey_region(Order_history_usecases order_historyusecases) throws CustomException {
        IRegionPK regionPK = (IRegionPK)parser.getJavaObject("regionpk");
        return order_historyusecases.get_order_history_with_foreignkey_region(regionPK);
    }
    
    private Object search_order_history(Order_history_usecases order_historyusecases) throws CustomException {
        IOrder_historysearch search = (IOrder_historysearch)parser.getJavaObject("search");
        return order_historyusecases.search_order_history(search);
    }
    
    private Object search_order_history_count(Order_history_usecases order_historyusecases) throws CustomException {
        IOrder_historysearch order_historysearch = (IOrder_historysearch)parser.getJavaObject("search");
        return order_historyusecases.search_order_history_count(order_historysearch);
    }

    @Override
    public String getServletInfo() {
        return "order_history_select";
    }

}

