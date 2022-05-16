/*
 * Userbp.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 11.4.2022 9:13
 *
 */

package eve.servlets.data;

import eve.BusinessObject.Logic.*;
import general.exception.CustomException;
import data.interfaces.db.Filedata;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.IUserbp;
import eve.interfaces.servlet.IUserbpOperation;
import eve.interfaces.searchentity.IUserbpsearch;
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
@WebServlet(name="Userbp", urlPatterns={"/eve.Userbp"})
public class Userbp extends SecurityDataServlet {
   
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
        BLuserbp bluserbp = new BLuserbp();
        bluserbp.setAuthenticated(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operationtype) {
                case DataServlet.SELECT:
                    IUserbpPK userbpPK;
                    IUserbp userbp;
                    switch(this.operation) {
                        case IUserbpOperation.SELECT_ALL:
                            dataobject = bluserbp.getUserbps();
                            break;
                        case IUserbpOperation.SELECT_USERBP:
                            userbpPK = (IUserbpPK)parser.getJavaObject("userbppk");
                            dataobject = bluserbp.getUserbp(userbpPK);
                            break;
                        case IUserbpOperation.SELECT_Evetype:
                            IEvetypePK evetypePK = (IEvetypePK)parser.getJavaObject("evetypepk");
                            dataobject = bluserbp.getUserbps4evetype(evetypePK);
                            break;
                        case IUserbpOperation.SELECT_SEARCH:
                            IUserbpsearch search = (IUserbpsearch)parser.getJavaObject("search");
                            dataobject = bluserbp.search(search);
                            break;
                        case IUserbpOperation.SELECT_SEARCHCOUNT:
                            IUserbpsearch userbpsearch = (IUserbpsearch)parser.getJavaObject("search");
                            dataobject = bluserbp.searchcount(userbpsearch);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;

                case DataServlet.INSERT:
                    switch(this.operation) {
                        case IUserbpOperation.INSERT_USERBP:
                            userbp = (IUserbp)parser.getJavaObject("userbp");
                            bluserbp.insertUserbp(userbp);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.UPDATE:
                    switch(this.operation) {
                        case IUserbpOperation.UPDATE_USERBP:
                            userbp = (IUserbp)parser.getJavaObject("userbp");
                            bluserbp.updateUserbp(userbp);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.DELETE:
                    switch(this.operation) {
                        case IUserbpOperation.DELETE_USERBP:
                            userbp = (IUserbp)parser.getJavaObject("userbp");
                            bluserbp.deleteUserbp(userbp);
                            break;
                        case IUserbpOperation.DELETE_Evetype:
                            IEvetypePK evetypePK = (IEvetypePK)parser.getJavaObject("evetypepk");
                            bluserbp.delete4evetype(evetypePK);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.BACKUP:
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
        return "userbp";
    }

}

