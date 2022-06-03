/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 18.4.2022 19:43
 */

package eve.servlets.order_history_maxdate;

import general.exception.CustomException;
import data.interfaces.db.Filedata;
import eve.interfaces.logicview.IOrder_history_maxdate;
import eve.interfaces.servlet.IOrder_history_maxdateOperation;
import eve.servlets.DataServlet;
import eve.servlets.SecurityDataServlet;
import eve.usecases.Order_history_maxdate_usecases;
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
@WebServlet(name="Order_history_maxdate_select", urlPatterns={"/eve.Order_history_maxdate_select"})
public class Order_history_maxdate_select extends SecurityDataServlet {
//Metacoder: NO AUTHOMATIC UPDATE
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);

        Object dataobject = null;
        Order_history_maxdate_usecases order_history_maxdateusecases = new Order_history_maxdate_usecases(authenticated);
        try {
            switch(this.operation) {
                case IOrder_history_maxdateOperation.SELECT_ALL:
                    dataobject = order_history_maxdateusecases.get_all();
                    break;
            }
        } 
        catch(CustomException e) {
            dataobject = e;
        }
        this.sendData(response, dataobject);
    } 

    @Override
    public String getServletInfo() {
        return "order_history_maxdate_select";
    }

}

