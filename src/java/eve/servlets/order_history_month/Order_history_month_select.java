/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 17.6.2022 13:4
 */

package eve.servlets.order_history_month;

import general.exception.*;
import data.interfaces.db.Filedata;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.IOrder_history_month;
import eve.interfaces.servlet.IOrder_history_monthOperation;
import eve.interfaces.searchentity.IOrder_history_monthsearch;
import eve.servlets.DataServlet;
import eve.servlets.SecurityDataServlet;
import eve.usecases.Order_history_month_usecases;
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
@WebServlet(name="Order_history_month_select", urlPatterns={"/eve.Order_history_month_select"})
public class Order_history_month_select extends SecurityDataServlet {
   
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);
        Object dataobject = null;
        Order_history_month_usecases order_history_monthusecases = new Order_history_month_usecases(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operation) {
                case IOrder_history_monthOperation.SELECT_ALL:
                    dataobject = order_history_monthusecases.get_all();
                    break;
                case IOrder_history_monthOperation.SELECT_ORDER_HISTORY_MONTH:
                    dataobject = get_order_history_month_with_primarykey(order_history_monthusecases);
                    break;
                case IOrder_history_monthOperation.SELECT_Evetype:
                    dataobject = get_order_history_month_with_foreignkey_evetype(order_history_monthusecases);
                    break;
                case IOrder_history_monthOperation.SELECT_Region:
                    dataobject = get_order_history_month_with_foreignkey_region(order_history_monthusecases);
                    break;
                case IOrder_history_monthOperation.SELECT_SEARCH:
                    dataobject = search_order_history_month(order_history_monthusecases);
                    break;
                case IOrder_history_monthOperation.SELECT_SEARCHCOUNT:
                    dataobject = search_order_history_month_count(order_history_monthusecases);
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

    private Object get_order_history_month_with_primarykey(Order_history_month_usecases order_history_monthusecases) throws DBException {
        IOrder_history_monthPK order_history_monthPK = (IOrder_history_monthPK)parser.getJavaObject("order_history_monthpk");
        return order_history_monthusecases.get_order_history_month_by_primarykey(order_history_monthPK);
    }

    private Object get_order_history_month_with_foreignkey_evetype(Order_history_month_usecases order_history_monthusecases) throws CustomException {
        IEvetypePK evetypePK = (IEvetypePK)parser.getJavaObject("evetypepk");
        return order_history_monthusecases.get_order_history_month_with_foreignkey_evetype(evetypePK);
    }
    
    private Object get_order_history_month_with_foreignkey_region(Order_history_month_usecases order_history_monthusecases) throws CustomException {
        IRegionPK regionPK = (IRegionPK)parser.getJavaObject("regionpk");
        return order_history_monthusecases.get_order_history_month_with_foreignkey_region(regionPK);
    }
    
    private Object search_order_history_month(Order_history_month_usecases order_history_monthusecases) throws CustomException {
        IOrder_history_monthsearch search = (IOrder_history_monthsearch)parser.getJavaObject("search");
        return order_history_monthusecases.search_order_history_month(search);
    }
    
    private Object search_order_history_month_count(Order_history_month_usecases order_history_monthusecases) throws CustomException {
        IOrder_history_monthsearch order_history_monthsearch = (IOrder_history_monthsearch)parser.getJavaObject("search");
        return order_history_monthusecases.search_order_history_month_count(order_history_monthsearch);
    }

    @Override
    public String getServletInfo() {
        return "order_history_month_select";
    }

}

