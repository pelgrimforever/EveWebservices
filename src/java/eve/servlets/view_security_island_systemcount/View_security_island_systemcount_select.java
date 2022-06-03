/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 18.4.2022 19:46
 */

package eve.servlets.view_security_island_systemcount;

import general.exception.CustomException;
import data.interfaces.db.Filedata;
import eve.interfaces.logicview.IView_security_island_systemcount;
import eve.interfaces.servlet.IView_security_island_systemcountOperation;
import eve.servlets.DataServlet;
import eve.servlets.SecurityDataServlet;
import eve.usecases.View_security_island_systemcount_usecases;
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
@WebServlet(name="View_security_island_systemcount_select", urlPatterns={"/eve.View_security_island_systemcount_select"})
public class View_security_island_systemcount_select extends SecurityDataServlet {
//Metacoder: NO AUTHOMATIC UPDATE
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);

        Object dataobject = null;
        View_security_island_systemcount_usecases view_security_island_systemcountusecases = new View_security_island_systemcount_usecases(authenticated);
        try {
            switch(this.operation) {
                case IView_security_island_systemcountOperation.SELECT_ALL:
                    dataobject = view_security_island_systemcountusecases.get_all();
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
        return "view_security_island_systemcount_select";
    }

}

