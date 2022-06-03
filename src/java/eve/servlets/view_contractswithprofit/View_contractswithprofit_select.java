/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 18.4.2022 19:46
 */

package eve.servlets.view_contractswithprofit;

import general.exception.CustomException;
import data.interfaces.db.Filedata;
import eve.interfaces.logicview.IView_contractswithprofit;
import eve.interfaces.servlet.IView_contractswithprofitOperation;
import eve.servlets.DataServlet;
import eve.servlets.SecurityDataServlet;
import eve.usecases.View_contractswithprofit_usecases;
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
@WebServlet(name="View_contractswithprofit_select", urlPatterns={"/eve.View_contractswithprofit_select"})
public class View_contractswithprofit_select extends SecurityDataServlet {
//Metacoder: NO AUTHOMATIC UPDATE
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);

        Object dataobject = null;
        View_contractswithprofit_usecases view_contractswithprofitusecases = new View_contractswithprofit_usecases(authenticated);
        try {
            switch(this.operation) {
                case IView_contractswithprofitOperation.SELECT_ALL:
                    dataobject = view_contractswithprofitusecases.get_all();
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
        return "view_contractswithprofit_select";
    }

}

