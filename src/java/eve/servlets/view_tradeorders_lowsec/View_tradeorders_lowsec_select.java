/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 18.4.2022 19:46
 */

package eve.servlets.view_tradeorders_lowsec;

import general.exception.CustomException;
import data.interfaces.db.Filedata;
import eve.interfaces.logicview.IView_tradeorders_lowsec;
import eve.interfaces.servlet.IView_tradeorders_lowsecOperation;
import eve.servlets.DataServlet;
import eve.servlets.SecurityDataServlet;
import eve.usecases.View_tradeorders_lowsec_usecases;
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
@WebServlet(name="View_tradeorders_lowsec_select", urlPatterns={"/eve.View_tradeorders_lowsec_select"})
public class View_tradeorders_lowsec_select extends SecurityDataServlet {
//Metacoder: NO AUTHOMATIC UPDATE
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);

        Object dataobject = null;
        View_tradeorders_lowsec_usecases view_tradeorders_lowsecusecases = new View_tradeorders_lowsec_usecases(authenticated);
        try {
            switch(this.operation) {
                case IView_tradeorders_lowsecOperation.SELECT_ALL:
                    dataobject = view_tradeorders_lowsecusecases.get_all();
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
        return "view_tradeorders_lowsec_select";
    }

}

