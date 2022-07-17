/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 17.6.2022 13:4
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

/**
 * @author Franky Laseure
 */
@WebServlet(name="Frontendpage_select", urlPatterns={"/eve.Frontendpage_select"})
public class Frontendpage_select extends SecurityDataServlet {
   
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
                case IFrontendpageOperation.SELECT_ALL:
                    dataobject = frontendpageusecases.get_all();
                    break;
                case IFrontendpageOperation.SELECT_FRONTENDPAGE:
                    dataobject = get_frontendpage_with_primarykey(frontendpageusecases);
                    break;
                case IFrontendpageOperation.SELECT_Frontendpage_auth:
                    dataobject = get_frontendpage_with_externalforeignkey_frontendpage_auth(frontendpageusecases);
                    break;
                case IFrontendpageOperation.SELECT_SEARCH:
                    dataobject = search_frontendpage(frontendpageusecases);
                    break;
                case IFrontendpageOperation.SELECT_SEARCHCOUNT:
                    dataobject = search_frontendpage_count(frontendpageusecases);
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

    private Object get_frontendpage_with_primarykey(Frontendpage_usecases frontendpageusecases) throws DBException {
        IFrontendpagePK frontendpagePK = (IFrontendpagePK)parser.getJavaObject("frontendpagepk");
        return frontendpageusecases.get_frontendpage_by_primarykey(frontendpagePK);
    }

    private Object get_frontendpage_with_externalforeignkey_frontendpage_auth(Frontendpage_usecases frontendpageusecases) throws CustomException {
        IFrontendpage_authPK frontendpage_authPK = (IFrontendpage_authPK)parser.getJavaObject("frontendpage_authpk");
        return frontendpageusecases.get_frontendpage_with_externalforeignkey_frontendpage_auth(frontendpage_authPK);
    }
    
    private Object search_frontendpage(Frontendpage_usecases frontendpageusecases) throws CustomException {
        IFrontendpagesearch search = (IFrontendpagesearch)parser.getJavaObject("search");
        return frontendpageusecases.search_frontendpage(search);
    }
    
    private Object search_frontendpage_count(Frontendpage_usecases frontendpageusecases) throws CustomException {
        IFrontendpagesearch frontendpagesearch = (IFrontendpagesearch)parser.getJavaObject("search");
        return frontendpageusecases.search_frontendpage_count(frontendpagesearch);
    }

    @Override
    public String getServletInfo() {
        return "frontendpage_select";
    }

}

