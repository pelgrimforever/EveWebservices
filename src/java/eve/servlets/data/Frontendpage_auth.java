/*
 * Frontendpage_auth.java
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
import eve.interfaces.logicentity.IFrontendpage_auth;
import eve.interfaces.servlet.IFrontendpage_authOperation;
import eve.interfaces.searchentity.IFrontendpage_authsearch;
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
@WebServlet(name="Frontendpage_auth", urlPatterns={"/eve.Frontendpage_auth"})
public class Frontendpage_auth extends SecurityDataServlet {
   
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
        BLfrontendpage_auth blfrontendpage_auth = new BLfrontendpage_auth();
        blfrontendpage_auth.setAuthenticated(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operationtype) {
                case DataServlet.SELECT:
                    IFrontendpage_authPK frontendpage_authPK;
                    IFrontendpage_auth frontendpage_auth;
                    switch(this.operation) {
                        case IFrontendpage_authOperation.SELECT_ALL:
                            dataobject = blfrontendpage_auth.getFrontendpage_auths();
                            break;
                        case IFrontendpage_authOperation.SELECT_FRONTENDPAGE_AUTH:
                            frontendpage_authPK = (IFrontendpage_authPK)parser.getJavaObject("frontendpage_authpk");
                            dataobject = blfrontendpage_auth.getFrontendpage_auth(frontendpage_authPK);
                            break;
                        case IFrontendpage_authOperation.SELECT_Frontendpage:
                            IFrontendpagePK frontendpagePK = (IFrontendpagePK)parser.getJavaObject("frontendpagepk");
                            dataobject = blfrontendpage_auth.getFrontendpage_auths4frontendpage(frontendpagePK);
                            break;
                        case IFrontendpage_authOperation.SELECT_Eveuser:
                            IEveuserPK eveuserPK = (IEveuserPK)parser.getJavaObject("eveuserpk");
                            dataobject = blfrontendpage_auth.getFrontendpage_auths4eveuser(eveuserPK);
                            break;
                        case IFrontendpage_authOperation.SELECT_SEARCH:
                            IFrontendpage_authsearch search = (IFrontendpage_authsearch)parser.getJavaObject("search");
                            dataobject = blfrontendpage_auth.search(search);
                            break;
                        case IFrontendpage_authOperation.SELECT_SEARCHCOUNT:
                            IFrontendpage_authsearch frontendpage_authsearch = (IFrontendpage_authsearch)parser.getJavaObject("search");
                            dataobject = blfrontendpage_auth.searchcount(frontendpage_authsearch);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;

                case DataServlet.INSERT:
                    switch(this.operation) {
                        case IFrontendpage_authOperation.INSERT_FRONTENDPAGE_AUTH:
                            frontendpage_auth = (IFrontendpage_auth)parser.getJavaObject("frontendpage_auth");
                            blfrontendpage_auth.insertFrontendpage_auth(frontendpage_auth);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.UPDATE:
                    switch(this.operation) {
                        case IFrontendpage_authOperation.UPDATE_FRONTENDPAGE_AUTH:
                            frontendpage_auth = (IFrontendpage_auth)parser.getJavaObject("frontendpage_auth");
                            blfrontendpage_auth.updateFrontendpage_auth(frontendpage_auth);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.DELETE:
                    switch(this.operation) {
                        case IFrontendpage_authOperation.DELETE_FRONTENDPAGE_AUTH:
                            frontendpage_auth = (IFrontendpage_auth)parser.getJavaObject("frontendpage_auth");
                            blfrontendpage_auth.deleteFrontendpage_auth(frontendpage_auth);
                            break;
                        case IFrontendpage_authOperation.DELETE_Frontendpage:
                            IFrontendpagePK frontendpagePK = (IFrontendpagePK)parser.getJavaObject("frontendpagepk");
                            blfrontendpage_auth.delete4frontendpage(frontendpagePK);
                            break;
                        case IFrontendpage_authOperation.DELETE_Eveuser:
                            IEveuserPK eveuserPK = (IEveuserPK)parser.getJavaObject("eveuserpk");
                            blfrontendpage_auth.delete4eveuser(eveuserPK);
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
        return "frontendpage_auth";
    }

}

