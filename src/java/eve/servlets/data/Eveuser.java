/*
 * Eveuser.java
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
import eve.interfaces.logicentity.IEveuser;
import eve.interfaces.servlet.IEveuserOperation;
import eve.interfaces.searchentity.IEveusersearch;
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
@WebServlet(name="Eveuser", urlPatterns={"/eve.Eveuser"})
public class Eveuser extends SecurityDataServlet {
   
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
        BLeveuser bleveuser = new BLeveuser();
        bleveuser.setAuthenticated(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operationtype) {
                case DataServlet.SELECT:
                    IEveuserPK eveuserPK;
                    IEveuser eveuser;
                    switch(this.operation) {
                        case IEveuserOperation.SELECT_ALL:
                            dataobject = bleveuser.getEveusers();
                            break;
                        case IEveuserOperation.SELECT_EVEUSER:
                            eveuserPK = (IEveuserPK)parser.getJavaObject("eveuserpk");
                            dataobject = bleveuser.getEveuser(eveuserPK);
                            break;
                        case IEveuserOperation.SELECT_Frontendpage_auth:
                            IFrontendpage_authPK frontendpage_authPK = (IFrontendpage_authPK)parser.getJavaObject("frontendpage_authpk");
                            dataobject = bleveuser.getFrontendpage_auth(frontendpage_authPK);
                            break;
                        case IEveuserOperation.SELECT_SEARCH:
                            IEveusersearch search = (IEveusersearch)parser.getJavaObject("search");
                            dataobject = bleveuser.search(search);
                            break;
                        case IEveuserOperation.SELECT_SEARCHCOUNT:
                            IEveusersearch eveusersearch = (IEveusersearch)parser.getJavaObject("search");
                            dataobject = bleveuser.searchcount(eveusersearch);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;

                case DataServlet.INSERT:
                    switch(this.operation) {
                        case IEveuserOperation.INSERT_EVEUSER:
                            eveuser = (IEveuser)parser.getJavaObject("eveuser");
                            bleveuser.insertEveuser(eveuser);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.UPDATE:
                    switch(this.operation) {
                        case IEveuserOperation.UPDATE_EVEUSER:
                            eveuser = (IEveuser)parser.getJavaObject("eveuser");
                            bleveuser.updateEveuser(eveuser);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.DELETE:
                    switch(this.operation) {
                        case IEveuserOperation.DELETE_EVEUSER:
                            eveuser = (IEveuser)parser.getJavaObject("eveuser");
                            bleveuser.deleteEveuser(eveuser);
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
        return "eveuser";
    }

}

