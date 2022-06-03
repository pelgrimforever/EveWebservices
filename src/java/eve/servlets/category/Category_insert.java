/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 20.4.2022 10:3
 */

package eve.servlets.category;

import general.exception.CustomException;
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
@WebServlet(name="Category_insert", urlPatterns={"/eve.Category_insert"})
public class Category_insert extends SecurityDataServlet {
   
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
                case ICategoryOperation.INSERT_CATEGORY:
                    insert_category(categoryusecases);
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

    private void insert_category(Category_usecases categoryusecases) throws CustomException {
        ICategory category = (ICategory)parser.getJavaObject("category");
        categoryusecases.secureinsertCategory(category);
    }
    
    @Override
    public String getServletInfo() {
        return "category_insert";
    }

}

