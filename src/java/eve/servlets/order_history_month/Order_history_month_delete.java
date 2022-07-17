/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 17.6.2022 13:4
 */

package eve.servlets.order_history_month;

import general.exception.CustomException;
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
@WebServlet(name="Order_history_month_delete", urlPatterns={"/eve.Order_history_month_delete"})
public class Order_history_month_delete extends SecurityDataServlet {
   
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
                case IOrder_history_monthOperation.DELETE_ORDER_HISTORY_MONTH:
                    delete_order_history_month(order_history_monthusecases);
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

    private void delete_order_history_month(Order_history_month_usecases order_history_monthusecases) throws CustomException {
        IOrder_history_month order_history_month = (IOrder_history_month)parser.getJavaObject("order_history_month");
        order_history_monthusecases.deleteOrder_history_month(order_history_month);
    }
    
    @Override
    public String getServletInfo() {
        return "order_history_month_insert";
    }

}

