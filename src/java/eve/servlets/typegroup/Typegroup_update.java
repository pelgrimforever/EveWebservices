/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 20.4.2022 10:3
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
@WebServlet(name="Typegroup_update", urlPatterns={"/eve.Typegroup_update"})
public class Typegroup_update extends SecurityDataServlet {
   
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
                case ITypegroupOperation.UPDATE_TYPEGROUP:
                    update_typegroup(typegroupusecases);
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

    private void update_typegroup(Typegroup_usecases typegroupusecases) throws CustomException {
        ITypegroup typegroup = (ITypegroup)parser.getJavaObject("typegroup");
        typegroupusecases.secureupdateTypegroup(typegroup);
    }
    
    @Override
    public String getServletInfo() {
        return "typegroup_insert";
    }

}

