/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 13.6.2022 11:21
 */

package eve.servlets.category;

import general.exception.*;
import data.interfaces.db.Filedata;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.ICategory;
import eve.interfaces.servlet.ICategoryOperation;
import eve.interfaces.searchentity.ICategorysearch;
import eve.servlets.DataServlet;
import eve.servlets.SecurityDataServlet;
import eve.usecases.Category_usecases;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Franky Laseure
 */
@WebServlet(name="Category_select", urlPatterns={"/eve.Category_select"})
public class Category_select extends SecurityDataServlet {
   
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);
        Object dataobject = null;
        Category_usecases categoryusecases = new Category_usecases(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operation) {
                case ICategoryOperation.SELECT_ALL:
                    dataobject = categoryusecases.get_all();
                    break;
                case ICategoryOperation.SELECT_CATEGORY:
                    dataobject = get_category_with_primarykey(categoryusecases);
                    break;
                case ICategoryOperation.SELECT_SEARCH:
                    dataobject = search_category(categoryusecases);
                    break;
                case ICategoryOperation.SELECT_SEARCHCOUNT:
                    dataobject = search_category_count(categoryusecases);
                    break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            }

        } 
        catch(CustomException e) {
            dataobject = e;
        }
        finally {
        }
        this.sendData(response, dataobject);
    } 

//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   

    private Object get_category_with_primarykey(Category_usecases categoryusecases) throws DBException {
        ICategoryPK categoryPK = (ICategoryPK)parser.getJavaObject("categorypk");
        return categoryusecases.get_category_by_primarykey(categoryPK);
    }

    private Object search_category(Category_usecases categoryusecases) throws CustomException {
        ICategorysearch search = (ICategorysearch)parser.getJavaObject("search");
        return categoryusecases.search_category(search);
    }
    
    private Object search_category_count(Category_usecases categoryusecases) throws CustomException {
        ICategorysearch categorysearch = (ICategorysearch)parser.getJavaObject("search");
        return categoryusecases.search_category_count(categorysearch);
    }

    @Override
    public String getServletInfo() {
        return "category_select";
    }

}

