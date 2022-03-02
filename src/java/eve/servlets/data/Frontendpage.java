/*
 * Frontendpage.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 16.1.2022 20:54
 *
 */

package eve.servlets.data;

import eve.BusinessObject.Logic.*;
import general.exception.CustomException;
import data.interfaces.db.Filedata;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.IFrontendpage;
import eve.interfaces.servlet.IFrontendpageOperation;
import eve.interfaces.searchentity.IFrontendpagesearch;
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
@WebServlet(name="Frontendpage", urlPatterns={"/eve.Frontendpage"})
public class Frontendpage extends SecurityDataServlet {
   
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
        BLfrontendpage blfrontendpage = new BLfrontendpage();
        blfrontendpage.setAuthenticated(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    IFrontendpagePK frontendpagePK;
                    IFrontendpage frontendpage;
                    switch(this.operation) {
                        case IFrontendpageOperation.SELECT_ALL:
                            dataobject = blfrontendpage.getFrontendpages();
                            break;
                        case IFrontendpageOperation.SELECT_FRONTENDPAGE:
                            frontendpagePK = (IFrontendpagePK)parser.getJavaObject("frontendpagepk");
                            dataobject = blfrontendpage.getFrontendpage(frontendpagePK);
                            break;
                        case IFrontendpageOperation.SELECT_Frontendpage_auth:
                            IFrontendpage_authPK frontendpage_authPK = (IFrontendpage_authPK)parser.getJavaObject("frontendpage_authpk");
                            dataobject = blfrontendpage.getFrontendpage_auth(frontendpage_authPK);
                            break;
                        case IFrontendpageOperation.SELECT_SEARCH:
                            IFrontendpagesearch search = (IFrontendpagesearch)parser.getJavaObject("search");
                            dataobject = blfrontendpage.search(search);
                            break;
                        case IFrontendpageOperation.SELECT_SEARCHCOUNT:
                            IFrontendpagesearch frontendpagesearch = (IFrontendpagesearch)parser.getJavaObject("search");
                            dataobject = blfrontendpage.searchcount(frontendpagesearch);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;

                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(this.operation) {
                        case IFrontendpageOperation.INSERT_FRONTENDPAGE:
                            frontendpage = (IFrontendpage)parser.getJavaObject("frontendpage");
                            blfrontendpage.insertFrontendpage(frontendpage);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(this.operation) {
                        case IFrontendpageOperation.UPDATE_FRONTENDPAGE:
                            frontendpage = (IFrontendpage)parser.getJavaObject("frontendpage");
                            blfrontendpage.updateFrontendpage(frontendpage);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(this.operation) {
                        case IFrontendpageOperation.DELETE_FRONTENDPAGE:
                            frontendpage = (IFrontendpage)parser.getJavaObject("frontendpage");
                            blfrontendpage.deleteFrontendpage(frontendpage);
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
        return "frontendpage";
    }

}

