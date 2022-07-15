/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 13.6.2022 11:21
 */

package eve.servlets.userbp;

import general.exception.*;
import data.interfaces.db.Filedata;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.IUserbp;
import eve.interfaces.servlet.IUserbpOperation;
import eve.interfaces.searchentity.IUserbpsearch;
import eve.servlets.DataServlet;
import eve.servlets.SecurityDataServlet;
import eve.usecases.Userbp_usecases;
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
@WebServlet(name="Userbp_select", urlPatterns={"/eve.Userbp_select"})
public class Userbp_select extends SecurityDataServlet {
   
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);
        Object dataobject = null;
        Userbp_usecases userbpusecases = new Userbp_usecases(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operation) {
                case IUserbpOperation.SELECT_ALL:
                    dataobject = userbpusecases.get_all();
                    break;
                case IUserbpOperation.SELECT_USERBP:
                    dataobject = get_userbp_with_primarykey(userbpusecases);
                    break;
                case IUserbpOperation.SELECT_Evetype:
                    dataobject = get_userbp_with_foreignkey_evetype(userbpusecases);
                    break;
                case IUserbpOperation.SELECT_SEARCH:
                    dataobject = search_userbp(userbpusecases);
                    break;
                case IUserbpOperation.SELECT_SEARCHCOUNT:
                    dataobject = search_userbp_count(userbpusecases);
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

    private Object get_userbp_with_primarykey(Userbp_usecases userbpusecases) throws DBException {
        IUserbpPK userbpPK = (IUserbpPK)parser.getJavaObject("userbppk");
        return userbpusecases.get_userbp_by_primarykey(userbpPK);
    }

    private Object get_userbp_with_foreignkey_evetype(Userbp_usecases userbpusecases) throws CustomException {
        IEvetypePK evetypePK = (IEvetypePK)parser.getJavaObject("evetypepk");
        return userbpusecases.get_userbp_with_foreignkey_evetype(evetypePK);
    }
    
    private Object search_userbp(Userbp_usecases userbpusecases) throws CustomException {
        IUserbpsearch search = (IUserbpsearch)parser.getJavaObject("search");
        return userbpusecases.search_userbp(search);
    }
    
    private Object search_userbp_count(Userbp_usecases userbpusecases) throws CustomException {
        IUserbpsearch userbpsearch = (IUserbpsearch)parser.getJavaObject("search");
        return userbpusecases.search_userbp_count(userbpsearch);
    }

    @Override
    public String getServletInfo() {
        return "userbp_select";
    }

}

