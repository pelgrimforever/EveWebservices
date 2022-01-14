/*
 * Allnodes_system.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 14.0.2022 16:56
 *
 */

package eve.servlets.data;

import eve.BusinessObject.Logic.*;
import general.exception.CustomException;
import data.interfaces.db.Filedata;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.IAllnodes_system;
import eve.interfaces.servlet.IAllnodes_systemOperation;
import eve.interfaces.searchentity.IAllnodes_systemsearch;
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
@WebServlet(name="Allnodes_system", urlPatterns={"/eve.Allnodes_system"})
public class Allnodes_system extends SecurityDataServlet {
   
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
        BLallnodes_system blallnodes_system = new BLallnodes_system();
        blallnodes_system.setAuthenticated(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    IAllnodes_systemPK allnodes_systemPK;
                    IAllnodes_system allnodes_system;
                    switch(this.operation) {
                        case IAllnodes_systemOperation.SELECT_ALL:
                            dataobject = blallnodes_system.getAllnodes_systems();
                            break;
                        case IAllnodes_systemOperation.SELECT_ALLNODES_SYSTEM:
                            allnodes_systemPK = (IAllnodes_systemPK)parser.getJavaObject("allnodes_systempk");
                            dataobject = blallnodes_system.getAllnodes_system(allnodes_systemPK);
                            break;
                        case IAllnodes_systemOperation.SELECT_SEARCH:
                            IAllnodes_systemsearch search = (IAllnodes_systemsearch)parser.getJavaObject("search");
                            dataobject = blallnodes_system.search(search);
                            break;
                        case IAllnodes_systemOperation.SELECT_SEARCHCOUNT:
                            IAllnodes_systemsearch allnodes_systemsearch = (IAllnodes_systemsearch)parser.getJavaObject("search");
                            dataobject = blallnodes_system.searchcount(allnodes_systemsearch);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;

                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(this.operation) {
                        case IAllnodes_systemOperation.INSERT_ALLNODES_SYSTEM:
                            allnodes_system = (IAllnodes_system)parser.getJavaObject("allnodes_system");
                            blallnodes_system.insertAllnodes_system(allnodes_system);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(this.operation) {
                        case IAllnodes_systemOperation.UPDATE_ALLNODES_SYSTEM:
                            allnodes_system = (IAllnodes_system)parser.getJavaObject("allnodes_system");
                            blallnodes_system.updateAllnodes_system(allnodes_system);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(this.operation) {
                        case IAllnodes_systemOperation.DELETE_ALLNODES_SYSTEM:
                            allnodes_system = (IAllnodes_system)parser.getJavaObject("allnodes_system");
                            blallnodes_system.deleteAllnodes_system(allnodes_system);
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
        return "allnodes_system";
    }

}

