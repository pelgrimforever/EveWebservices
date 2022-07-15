/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 13.6.2022 11:21
 */

package eve.servlets.typegroup;

import general.exception.CustomException;
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
@WebServlet(name="Typegroup_delete", urlPatterns={"/eve.Typegroup_delete"})
public class Typegroup_delete extends SecurityDataServlet {
   
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
                case ITypegroupOperation.DELETE_TYPEGROUP:
                    delete_typegroup(typegroupusecases);
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

    private void delete_typegroup(Typegroup_usecases typegroupusecases) throws CustomException {
        ITypegroup typegroup = (ITypegroup)parser.getJavaObject("typegroup");
        typegroupusecases.deleteTypegroup(typegroup);
    }
    
    @Override
    public String getServletInfo() {
        return "typegroup_insert";
    }

}

