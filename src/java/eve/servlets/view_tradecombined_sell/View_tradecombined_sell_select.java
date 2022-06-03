/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 18.4.2022 19:46
 */

package eve.servlets.view_tradecombined_sell;

import general.exception.CustomException;
import data.interfaces.db.Filedata;
import eve.interfaces.logicview.IView_tradecombined_sell;
import eve.interfaces.servlet.IView_tradecombined_sellOperation;
import eve.servlets.DataServlet;
import eve.servlets.SecurityDataServlet;
import eve.usecases.View_tradecombined_sell_usecases;
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
@WebServlet(name="View_tradecombined_sell_select", urlPatterns={"/eve.View_tradecombined_sell_select"})
public class View_tradecombined_sell_select extends SecurityDataServlet {
//Metacoder: NO AUTHOMATIC UPDATE
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);

        Object dataobject = null;
        View_tradecombined_sell_usecases view_tradecombined_sellusecases = new View_tradecombined_sell_usecases(authenticated);
        try {
            switch(this.operation) {
                case IView_tradecombined_sellOperation.SELECT_ALL:
                    dataobject = view_tradecombined_sellusecases.get_all();
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
        return "view_tradecombined_sell_select";
    }

}

