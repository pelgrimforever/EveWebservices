/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 13.6.2022 11:21
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
@WebServlet(name="Order_history_month_update", urlPatterns={"/eve.Order_history_month_update"})
public class Order_history_month_update extends SecurityDataServlet {
   
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
                case IOrder_history_monthOperation.UPDATE_ORDER_HISTORY_MONTH:
                    update_order_history_month(order_history_monthusecases);
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

    private void update_order_history_month(Order_history_month_usecases order_history_monthusecases) throws CustomException {
        IOrder_history_month order_history_month = (IOrder_history_month)parser.getJavaObject("order_history_month");
        order_history_monthusecases.updateOrder_history_month(order_history_month);
    }
    
    @Override
    public String getServletInfo() {
        return "order_history_month_insert";
    }

}

