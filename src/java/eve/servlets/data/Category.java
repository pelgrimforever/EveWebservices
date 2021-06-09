/*
 * DataServlet.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 8.5.2021 19:33
 *
 */

package eve.servlets.data;

import eve.BusinessObject.Logic.*;
import general.exception.CustomException;
import data.interfaces.db.Filedata;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.ICategory;
import eve.interfaces.servlet.ICategoryOperation;
import eve.interfaces.searchentity.ICategorysearch;
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
@WebServlet(name="Category", urlPatterns={"/eve.Category"})
public class Category extends SecurityDataServlet {
   
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
        BLcategory blcategory = new BLcategory();
        blcategory.setAuthenticated(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    ICategoryPK categoryPK;
                    ICategory category;
                    switch(this.operation) {
                        case ICategoryOperation.SELECT_ALL:
                            dataobject = blcategory.getCategorys();
                            break;
                        case ICategoryOperation.SELECT_CATEGORY:
                            categoryPK = (ICategoryPK)parser.getJavaObject("categorypk");
                            dataobject = blcategory.getCategory(categoryPK);
                            break;
                        case ICategoryOperation.SELECT_SEARCH:
                            ICategorysearch search = (ICategorysearch)parser.getJavaObject("search");
                            dataobject = blcategory.search(search);
                            break;
                        case ICategoryOperation.SELECT_SEARCHCOUNT:
                            ICategorysearch categorysearch = (ICategorysearch)parser.getJavaObject("search");
                            dataobject = blcategory.searchcount(categorysearch);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;

                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(this.operation) {
                        case ICategoryOperation.INSERT_CATEGORY:
                            category = (ICategory)parser.getJavaObject("category");
                            blcategory.insertCategory(category);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(this.operation) {
                        case ICategoryOperation.UPDATE_CATEGORY:
                            category = (ICategory)parser.getJavaObject("category");
                            blcategory.updateCategory(category);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(this.operation) {
                        case ICategoryOperation.DELETE_CATEGORY:
                            category = (ICategory)parser.getJavaObject("category");
                            blcategory.deleteCategory(category);
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
        return "category";
    }

}

