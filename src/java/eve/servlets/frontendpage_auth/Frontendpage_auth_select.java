/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 23.8.2022 14:38
 * @author Franky Laseure
 */

package eve.servlets.frontendpage_auth;

import general.exception.*;
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

@WebServlet(name="Frontendpage_auth_select", urlPatterns={"/eve.Frontendpage_auth_select"})
public class Frontendpage_auth_select extends SecurityDataServlet {
   
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
                case IFrontendpage_authOperation.SELECT_ALL:
                    dataobject = frontendpage_authusecases.get_all();
                    break;
                case IFrontendpage_authOperation.SELECT_FRONTENDPAGE_AUTH:
                    dataobject = get_frontendpage_auth_with_primarykey(frontendpage_authusecases);
                    break;
                case IFrontendpage_authOperation.SELECT_Frontendpage:
                    dataobject = get_frontendpage_auth_with_foreignkey_frontendpage(frontendpage_authusecases);
                    break;
                case IFrontendpage_authOperation.SELECT_Eveuser:
                    dataobject = get_frontendpage_auth_with_foreignkey_eveuser(frontendpage_authusecases);
                    break;
                case IFrontendpage_authOperation.SELECT_SEARCH:
                    dataobject = search_frontendpage_auth(frontendpage_authusecases);
                    break;
                case IFrontendpage_authOperation.SELECT_SEARCHCOUNT:
                    dataobject = search_frontendpage_auth_count(frontendpage_authusecases);
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

    private Object get_frontendpage_auth_with_primarykey(Frontendpage_auth_usecases frontendpage_authusecases) throws DBException {
        IFrontendpage_authPK frontendpage_authPK = (IFrontendpage_authPK)parser.getJavaObject("frontendpage_authpk");
        return frontendpage_authusecases.get_frontendpage_auth_by_primarykey(frontendpage_authPK);
    }

    private Object get_frontendpage_auth_with_foreignkey_frontendpage(Frontendpage_auth_usecases frontendpage_authusecases) throws CustomException {
        IFrontendpagePK frontendpagePK = (IFrontendpagePK)parser.getJavaObject("frontendpagepk");
        return frontendpage_authusecases.get_frontendpage_auth_with_foreignkey_frontendpage(frontendpagePK);
    }
    
    private Object get_frontendpage_auth_with_foreignkey_eveuser(Frontendpage_auth_usecases frontendpage_authusecases) throws CustomException {
        IEveuserPK eveuserPK = (IEveuserPK)parser.getJavaObject("eveuserpk");
        return frontendpage_authusecases.get_frontendpage_auth_with_foreignkey_eveuser(eveuserPK);
    }
    
    private Object search_frontendpage_auth(Frontendpage_auth_usecases frontendpage_authusecases) throws CustomException {
        IFrontendpage_authsearch search = (IFrontendpage_authsearch)parser.getJavaObject("search");
        return frontendpage_authusecases.search_frontendpage_auth(search);
    }
    
    private Object search_frontendpage_auth_count(Frontendpage_auth_usecases frontendpage_authusecases) throws CustomException {
        IFrontendpage_authsearch frontendpage_authsearch = (IFrontendpage_authsearch)parser.getJavaObject("search");
        return frontendpage_authusecases.search_frontendpage_auth_count(frontendpage_authsearch);
    }

    @Override
    public String getServletInfo() {
        return "frontendpage_auth_select";
    }

}

