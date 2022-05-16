/*
 * View_bpmaterial.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 24.0.2022 17:38
 *
 */

package eve.servlets.data;

import eve.BusinessObject.Logic.BLview_bpmaterial;
import general.exception.CustomException;
import data.interfaces.db.Filedata;
import eve.interfaces.logicview.IView_bpmaterial;
import eve.interfaces.servlet.IView_bpmaterialOperation;
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
@WebServlet(name="View_bpmaterial", urlPatterns={"/eve.View_bpmaterial"})
public class View_bpmaterial extends SecurityDataServlet {
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
        BLview_bpmaterial blview_bpmaterial = new BLview_bpmaterial();
        //boolean privateaccess = userprofile!=null && userprofile.privateaccess();
        try {
            switch(this.operationtype) {
                case DataServlet.SELECT:
                    switch(this.operation) {
                        case IView_bpmaterialOperation.SELECT_ALL:
                            dataobject = blview_bpmaterial.getView_bpmaterials();
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
        return "view_bpmaterial";
    }

}

