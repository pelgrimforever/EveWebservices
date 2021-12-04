/*
 * Typegroup.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 4.11.2021 14:51
 *
 */

package eve.servlets.data;

import eve.BusinessObject.Logic.*;
import general.exception.CustomException;
import data.interfaces.db.Filedata;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.ITypegroup;
import eve.interfaces.servlet.ITypegroupOperation;
import eve.interfaces.searchentity.ITypegroupsearch;
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
@WebServlet(name="Typegroup", urlPatterns={"/eve.Typegroup"})
public class Typegroup extends SecurityDataServlet {
   
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
        BLtypegroup bltypegroup = new BLtypegroup();
        bltypegroup.setAuthenticated(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    ITypegroupPK typegroupPK;
                    ITypegroup typegroup;
                    switch(this.operation) {
                        case ITypegroupOperation.SELECT_ALL:
                            dataobject = bltypegroup.getTypegroups();
                            break;
                        case ITypegroupOperation.SELECT_TYPEGROUP:
                            typegroupPK = (ITypegroupPK)parser.getJavaObject("typegrouppk");
                            dataobject = bltypegroup.getTypegroup(typegroupPK);
                            break;
                        case ITypegroupOperation.SELECT_Category:
                            ICategoryPK categoryPK = (ICategoryPK)parser.getJavaObject("categorypk");
                            dataobject = bltypegroup.getTypegroups4category(categoryPK);
                            break;
                        case ITypegroupOperation.SELECT_SEARCH:
                            ITypegroupsearch search = (ITypegroupsearch)parser.getJavaObject("search");
                            dataobject = bltypegroup.search(search);
                            break;
                        case ITypegroupOperation.SELECT_SEARCHCOUNT:
                            ITypegroupsearch typegroupsearch = (ITypegroupsearch)parser.getJavaObject("search");
                            dataobject = bltypegroup.searchcount(typegroupsearch);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;

                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(this.operation) {
                        case ITypegroupOperation.INSERT_TYPEGROUP:
                            typegroup = (ITypegroup)parser.getJavaObject("typegroup");
                            bltypegroup.insertTypegroup(typegroup);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(this.operation) {
                        case ITypegroupOperation.UPDATE_TYPEGROUP:
                            typegroup = (ITypegroup)parser.getJavaObject("typegroup");
                            bltypegroup.updateTypegroup(typegroup);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(this.operation) {
                        case ITypegroupOperation.DELETE_TYPEGROUP:
                            typegroup = (ITypegroup)parser.getJavaObject("typegroup");
                            bltypegroup.deleteTypegroup(typegroup);
                            break;
                        case ITypegroupOperation.DELETE_Category:
                            ICategoryPK categoryPK = (ICategoryPK)parser.getJavaObject("categorypk");
                            bltypegroup.delete4category(categoryPK);
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
        return "typegroup";
    }

}

