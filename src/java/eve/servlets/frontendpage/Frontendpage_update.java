/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 23.8.2022 14:38
 * @author Franky Laseure
 */

package eve.servlets.frontendpage;

import general.exception.*;
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

@WebServlet(name="Frontendpage_update", urlPatterns={"/eve.Frontendpage_update"})
public class Frontendpage_update extends SecurityDataServlet {
   
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
                case IFrontendpageOperation.UPDATE_FRONTENDPAGE:
                    update_frontendpage(frontendpageusecases);
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

    private void update_frontendpage(Frontendpage_usecases frontendpageusecases) throws CustomException {
        IFrontendpage frontendpage = (IFrontendpage)parser.getJavaObject("frontendpage");
        frontendpageusecases.updateFrontendpage(frontendpage);
    }
    
    @Override
    public String getServletInfo() {
        return "frontendpage_insert";
    }

}

