/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 17.6.2022 13:4
 */

package eve.servlets.frontendpage_auth;

import general.exception.CustomException;
import data.interfaces.db.Filedata;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.IFrontendpage_auth;
import eve.interfaces.servlet.IFrontendpage_authOperation;
import eve.interfaces.searchentity.IFrontendpage_authsearch;
import eve.servlets.DataServlet;
import eve.servlets.SecurityDataServlet;
import eve.usecases.Frontendpage_auth_usecases;
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
@WebServlet(name="Frontendpage_auth_delete", urlPatterns={"/eve.Frontendpage_auth_delete"})
public class Frontendpage_auth_delete extends SecurityDataServlet {
   
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);
        Object dataobject = null;
        Frontendpage_auth_usecases frontendpage_authusecases = new Frontendpage_auth_usecases(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operation) {
                case IFrontendpage_authOperation.DELETE_FRONTENDPAGE_AUTH:
                    delete_frontendpage_auth(frontendpage_authusecases);
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

    private void delete_frontendpage_auth(Frontendpage_auth_usecases frontendpage_authusecases) throws CustomException {
        IFrontendpage_auth frontendpage_auth = (IFrontendpage_auth)parser.getJavaObject("frontendpage_auth");
        frontendpage_authusecases.deleteFrontendpage_auth(frontendpage_auth);
    }
    
    @Override
    public String getServletInfo() {
        return "frontendpage_auth_insert";
    }

}

