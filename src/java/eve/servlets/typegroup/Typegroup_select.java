/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 17.6.2022 13:4
 */

package eve.servlets.typegroup;

import general.exception.*;
import data.interfaces.db.Filedata;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.ITypegroup;
import eve.interfaces.servlet.ITypegroupOperation;
import eve.interfaces.searchentity.ITypegroupsearch;
import eve.servlets.DataServlet;
import eve.servlets.SecurityDataServlet;
import eve.usecases.Typegroup_usecases;
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
@WebServlet(name="Typegroup_select", urlPatterns={"/eve.Typegroup_select"})
public class Typegroup_select extends SecurityDataServlet {
   
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);
        Object dataobject = null;
        Typegroup_usecases typegroupusecases = new Typegroup_usecases(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operation) {
                case ITypegroupOperation.SELECT_ALL:
                    dataobject = typegroupusecases.get_all();
                    break;
                case ITypegroupOperation.SELECT_TYPEGROUP:
                    dataobject = get_typegroup_with_primarykey(typegroupusecases);
                    break;
                case ITypegroupOperation.SELECT_Category:
                    dataobject = get_typegroup_with_foreignkey_category(typegroupusecases);
                    break;
                case ITypegroupOperation.SELECT_SEARCH:
                    dataobject = search_typegroup(typegroupusecases);
                    break;
                case ITypegroupOperation.SELECT_SEARCHCOUNT:
                    dataobject = search_typegroup_count(typegroupusecases);
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

    private Object get_typegroup_with_primarykey(Typegroup_usecases typegroupusecases) throws DBException {
        ITypegroupPK typegroupPK = (ITypegroupPK)parser.getJavaObject("typegrouppk");
        return typegroupusecases.get_typegroup_by_primarykey(typegroupPK);
    }

    private Object get_typegroup_with_foreignkey_category(Typegroup_usecases typegroupusecases) throws CustomException {
        ICategoryPK categoryPK = (ICategoryPK)parser.getJavaObject("categorypk");
        return typegroupusecases.get_typegroup_with_foreignkey_category(categoryPK);
    }
    
    private Object search_typegroup(Typegroup_usecases typegroupusecases) throws CustomException {
        ITypegroupsearch search = (ITypegroupsearch)parser.getJavaObject("search");
        return typegroupusecases.search_typegroup(search);
    }
    
    private Object search_typegroup_count(Typegroup_usecases typegroupusecases) throws CustomException {
        ITypegroupsearch typegroupsearch = (ITypegroupsearch)parser.getJavaObject("search");
        return typegroupusecases.search_typegroup_count(typegroupsearch);
    }

    @Override
    public String getServletInfo() {
        return "typegroup_select";
    }

}

