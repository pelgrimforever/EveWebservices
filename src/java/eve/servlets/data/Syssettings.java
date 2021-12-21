/*
 * Syssettings.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 16.11.2021 15:46
 *
 */

package eve.servlets.data;

import eve.BusinessObject.Logic.*;
import general.exception.CustomException;
import data.interfaces.db.Filedata;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.ISyssettings;
import eve.interfaces.servlet.ISyssettingsOperation;
import eve.interfaces.searchentity.ISyssettingssearch;
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
@WebServlet(name="Syssettings", urlPatterns={"/eve.Syssettings"})
public class Syssettings extends SecurityDataServlet {
   
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
        BLsyssettings blsyssettings = new BLsyssettings();
        blsyssettings.setAuthenticated(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    ISyssettingsPK syssettingsPK;
                    ISyssettings syssettings;
                    switch(this.operation) {
                        case ISyssettingsOperation.SELECT_ALL:
                            dataobject = blsyssettings.getSyssettingss();
                            break;
                        case ISyssettingsOperation.SELECT_SYSSETTINGS:
                            syssettingsPK = (ISyssettingsPK)parser.getJavaObject("syssettingspk");
                            dataobject = blsyssettings.getSyssettings(syssettingsPK);
                            break;
                        case ISyssettingsOperation.SELECT_SEARCH:
                            ISyssettingssearch search = (ISyssettingssearch)parser.getJavaObject("search");
                            dataobject = blsyssettings.search(search);
                            break;
                        case ISyssettingsOperation.SELECT_SEARCHCOUNT:
                            ISyssettingssearch syssettingssearch = (ISyssettingssearch)parser.getJavaObject("search");
                            dataobject = blsyssettings.searchcount(syssettingssearch);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;

                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(this.operation) {
                        case ISyssettingsOperation.INSERT_SYSSETTINGS:
                            syssettings = (ISyssettings)parser.getJavaObject("syssettings");
                            blsyssettings.insertSyssettings(syssettings);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(this.operation) {
                        case ISyssettingsOperation.UPDATE_SYSSETTINGS:
                            syssettings = (ISyssettings)parser.getJavaObject("syssettings");
                            blsyssettings.updateSyssettings(syssettings);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(this.operation) {
                        case ISyssettingsOperation.DELETE_SYSSETTINGS:
                            syssettings = (ISyssettings)parser.getJavaObject("syssettings");
                            blsyssettings.deleteSyssettings(syssettings);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_BACKUP:
                    switch(this.operation) {
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line
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
        return "syssettings";
    }

}

