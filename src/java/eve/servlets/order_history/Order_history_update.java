/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 20.4.2022 10:3
 */

package eve.servlets.order_history;

import general.exception.CustomException;
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
@WebServlet(name="Order_history_update", urlPatterns={"/eve.Order_history_update"})
public class Order_history_update extends SecurityDataServlet {
   
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
                case IOrder_historyOperation.UPDATE_ORDER_HISTORY:
                    update_order_history(order_historyusecases);
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

    private void update_order_history(Order_history_usecases order_historyusecases) throws CustomException {
        IOrder_history order_history = (IOrder_history)parser.getJavaObject("order_history");
        order_historyusecases.secureupdateOrder_history(order_history);
    }
    
    @Override
    public String getServletInfo() {
        return "order_history_insert";
    }

}

