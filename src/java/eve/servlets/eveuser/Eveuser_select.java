/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 13.6.2022 11:21
 */

package eve.servlets.eveuser;

import general.exception.*;
import data.interfaces.db.Filedata;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.IEveuser;
import eve.interfaces.servlet.IEveuserOperation;
import eve.interfaces.searchentity.IEveusersearch;
import eve.servlets.DataServlet;
import eve.servlets.SecurityDataServlet;
import eve.usecases.Eveuser_usecases;
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
@WebServlet(name="Eveuser_select", urlPatterns={"/eve.Eveuser_select"})
public class Eveuser_select extends SecurityDataServlet {
   
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);
        Object dataobject = null;
        Eveuser_usecases eveuserusecases = new Eveuser_usecases(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operation) {
                case IEveuserOperation.SELECT_ALL:
                    dataobject = eveuserusecases.get_all();
                    break;
                case IEveuserOperation.SELECT_EVEUSER:
                    dataobject = get_eveuser_with_primarykey(eveuserusecases);
                    break;
                case IEveuserOperation.SELECT_Frontendpage_auth:
                    dataobject = get_eveuser_with_externalforeignkey_frontendpage_auth(eveuserusecases);
                    break;
                case IEveuserOperation.SELECT_SEARCH:
                    dataobject = search_eveuser(eveuserusecases);
                    break;
                case IEveuserOperation.SELECT_SEARCHCOUNT:
                    dataobject = search_eveuser_count(eveuserusecases);
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

    private Object get_eveuser_with_primarykey(Eveuser_usecases eveuserusecases) throws DBException {
        IEveuserPK eveuserPK = (IEveuserPK)parser.getJavaObject("eveuserpk");
        return eveuserusecases.get_eveuser_by_primarykey(eveuserPK);
    }

    private Object get_eveuser_with_externalforeignkey_frontendpage_auth(Eveuser_usecases eveuserusecases) throws CustomException {
        IFrontendpage_authPK frontendpage_authPK = (IFrontendpage_authPK)parser.getJavaObject("frontendpage_authpk");
        return eveuserusecases.get_eveuser_with_externalforeignkey_frontendpage_auth(frontendpage_authPK);
    }
    
    private Object search_eveuser(Eveuser_usecases eveuserusecases) throws CustomException {
        IEveusersearch search = (IEveusersearch)parser.getJavaObject("search");
        return eveuserusecases.search_eveuser(search);
    }
    
    private Object search_eveuser_count(Eveuser_usecases eveuserusecases) throws CustomException {
        IEveusersearch eveusersearch = (IEveusersearch)parser.getJavaObject("search");
        return eveuserusecases.search_eveuser_count(eveusersearch);
    }

    @Override
    public String getServletInfo() {
        return "eveuser_select";
    }

}

