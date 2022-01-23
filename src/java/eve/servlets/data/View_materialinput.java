/*
 * View_materialinput.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 17.0.2022 13:34
 *
 */

package eve.servlets.data;

import eve.BusinessObject.Logic.BLview_materialinput;
import general.exception.CustomException;
import data.interfaces.db.Filedata;
import eve.interfaces.logicview.IView_materialinput;
import eve.interfaces.servlet.IView_materialinputOperation;
import eve.servlets.DataServlet;
import eve.servlets.SecurityDataServlet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Franky Laseure
 */
@WebServlet(name="View_materialinput", urlPatterns={"/eve.View_materialinput"})
public class View_materialinput extends SecurityDataServlet {
//Metacoder: NO AUTHOMATIC UPDATE
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);

        Object dataobject = null;
        BLview_materialinput blview_materialinput = new BLview_materialinput();
        //boolean privateaccess = userprofile!=null && userprofile.privateaccess();
        try {
            switch(this.operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    switch(this.operation) {
                        case IView_materialinputOperation.SELECT_ALL:
                            dataobject = blview_materialinput.getView_materialinputs();
                            break;
                    }
                    break;
            }

        } 
        catch(CustomException e) {
            dataobject = e;
        }
        finally {
        }
        this.sendData(response, dataobject);
    } 

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "view_materialinput";
    }

}

