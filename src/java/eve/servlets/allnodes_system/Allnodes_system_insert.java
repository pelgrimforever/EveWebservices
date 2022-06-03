/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 20.4.2022 10:3
 */

package eve.servlets.allnodes_system;

import general.exception.CustomException;
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
@WebServlet(name="Allnodes_system_insert", urlPatterns={"/eve.Allnodes_system_insert"})
public class Allnodes_system_insert extends SecurityDataServlet {
   
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
                case IAllnodes_systemOperation.INSERT_ALLNODES_SYSTEM:
                    insert_allnodes_system(allnodes_systemusecases);
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

    private void insert_allnodes_system(Allnodes_system_usecases allnodes_systemusecases) throws CustomException {
        IAllnodes_system allnodes_system = (IAllnodes_system)parser.getJavaObject("allnodes_system");
        allnodes_systemusecases.secureinsertAllnodes_system(allnodes_system);
    }
    
    @Override
    public String getServletInfo() {
        return "allnodes_system_insert";
    }

}

