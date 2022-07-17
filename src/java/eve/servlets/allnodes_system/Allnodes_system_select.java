/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 17.6.2022 13:4
 */

package eve.servlets.allnodes_system;

import general.exception.*;
import data.interfaces.db.Filedata;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.IAllnodes_system;
import eve.interfaces.servlet.IAllnodes_systemOperation;
import eve.interfaces.searchentity.IAllnodes_systemsearch;
import eve.servlets.DataServlet;
import eve.servlets.SecurityDataServlet;
import eve.usecases.Allnodes_system_usecases;
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
@WebServlet(name="Allnodes_system_select", urlPatterns={"/eve.Allnodes_system_select"})
public class Allnodes_system_select extends SecurityDataServlet {
   
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);
        Object dataobject = null;
        Allnodes_system_usecases allnodes_systemusecases = new Allnodes_system_usecases(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operation) {
                case IAllnodes_systemOperation.SELECT_ALL:
                    dataobject = allnodes_systemusecases.get_all();
                    break;
                case IAllnodes_systemOperation.SELECT_ALLNODES_SYSTEM:
                    dataobject = get_allnodes_system_with_primarykey(allnodes_systemusecases);
                    break;
                case IAllnodes_systemOperation.SELECT_SEARCH:
                    dataobject = search_allnodes_system(allnodes_systemusecases);
                    break;
                case IAllnodes_systemOperation.SELECT_SEARCHCOUNT:
                    dataobject = search_allnodes_system_count(allnodes_systemusecases);
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

    private Object get_allnodes_system_with_primarykey(Allnodes_system_usecases allnodes_systemusecases) throws DBException {
        IAllnodes_systemPK allnodes_systemPK = (IAllnodes_systemPK)parser.getJavaObject("allnodes_systempk");
        return allnodes_systemusecases.get_allnodes_system_by_primarykey(allnodes_systemPK);
    }

    private Object search_allnodes_system(Allnodes_system_usecases allnodes_systemusecases) throws CustomException {
        IAllnodes_systemsearch search = (IAllnodes_systemsearch)parser.getJavaObject("search");
        return allnodes_systemusecases.search_allnodes_system(search);
    }
    
    private Object search_allnodes_system_count(Allnodes_system_usecases allnodes_systemusecases) throws CustomException {
        IAllnodes_systemsearch allnodes_systemsearch = (IAllnodes_systemsearch)parser.getJavaObject("search");
        return allnodes_systemusecases.search_allnodes_system_count(allnodes_systemsearch);
    }

    @Override
    public String getServletInfo() {
        return "allnodes_system_select";
    }

}

