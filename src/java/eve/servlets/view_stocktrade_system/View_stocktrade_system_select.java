/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 18.4.2022 19:46
 */

package eve.servlets.view_stocktrade_system;

import general.exception.CustomException;
import data.interfaces.db.Filedata;
import eve.interfaces.logicview.IView_stocktrade_system;
import eve.interfaces.servlet.IView_stocktrade_systemOperation;
import eve.servlets.DataServlet;
import eve.servlets.SecurityDataServlet;
import eve.usecases.View_stocktrade_system_usecases;
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
@WebServlet(name="View_stocktrade_system_select", urlPatterns={"/eve.View_stocktrade_system_select"})
public class View_stocktrade_system_select extends SecurityDataServlet {
//Metacoder: NO AUTHOMATIC UPDATE
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);

        Object dataobject = null;
        View_stocktrade_system_usecases view_stocktrade_systemusecases = new View_stocktrade_system_usecases(authenticated);
        try {
            switch(this.operation) {
                case IView_stocktrade_systemOperation.SELECT_ALL:
                    dataobject = view_stocktrade_systemusecases.get_all();
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
        return "view_stocktrade_system_select";
    }

}

