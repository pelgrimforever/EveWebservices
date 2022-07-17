/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 17.6.2022 13:4
 */

package eve.servlets.frontendpage;

import general.exception.CustomException;
import data.interfaces.db.Filedata;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.IFrontendpage;
import eve.interfaces.servlet.IFrontendpageOperation;
import eve.interfaces.searchentity.IFrontendpagesearch;
import eve.servlets.DataServlet;
import eve.servlets.SecurityDataServlet;
import eve.usecases.Frontendpage_usecases;
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
@WebServlet(name="Frontendpage_delete", urlPatterns={"/eve.Frontendpage_delete"})
public class Frontendpage_delete extends SecurityDataServlet {
   
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);
        Object dataobject = null;
        Frontendpage_usecases frontendpageusecases = new Frontendpage_usecases(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operation) {
                case IFrontendpageOperation.DELETE_FRONTENDPAGE:
                    delete_frontendpage(frontendpageusecases);
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

    private void delete_frontendpage(Frontendpage_usecases frontendpageusecases) throws CustomException {
        IFrontendpage frontendpage = (IFrontendpage)parser.getJavaObject("frontendpage");
        frontendpageusecases.deleteFrontendpage(frontendpage);
    }
    
    @Override
    public String getServletInfo() {
        return "frontendpage_insert";
    }

}

