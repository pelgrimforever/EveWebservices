/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 18.4.2022 19:46
 */

package eve.servlets.view_order_region_evetype;

import general.exception.CustomException;
import data.interfaces.db.Filedata;
import eve.interfaces.logicview.IView_order_region_evetype;
import eve.interfaces.servlet.IView_order_region_evetypeOperation;
import eve.servlets.DataServlet;
import eve.servlets.SecurityDataServlet;
import eve.usecases.View_order_region_evetype_usecases;
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
@WebServlet(name="View_order_region_evetype_select", urlPatterns={"/eve.View_order_region_evetype_select"})
public class View_order_region_evetype_select extends SecurityDataServlet {
//Metacoder: NO AUTHOMATIC UPDATE
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);

        Object dataobject = null;
        View_order_region_evetype_usecases view_order_region_evetypeusecases = new View_order_region_evetype_usecases(authenticated);
        try {
            switch(this.operation) {
                case IView_order_region_evetypeOperation.SELECT_ALL:
                    dataobject = view_order_region_evetypeusecases.get_all();
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
        return "view_order_region_evetype_select";
    }

}

