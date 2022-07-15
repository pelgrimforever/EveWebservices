/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 13.6.2022 11:21
 */

package eve.servlets.evetype;

import general.exception.CustomException;
import data.interfaces.db.Filedata;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.IEvetype;
import eve.interfaces.servlet.IEvetypeOperation;
import eve.interfaces.searchentity.IEvetypesearch;
import eve.servlets.DataServlet;
import eve.servlets.SecurityDataServlet;
import eve.usecases.Evetype_usecases;
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
@WebServlet(name="Evetype_update", urlPatterns={"/eve.Evetype_update"})
public class Evetype_update extends SecurityDataServlet {
   
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);
        Object dataobject = null;
        Evetype_usecases evetypeusecases = new Evetype_usecases(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operation) {
                case IEvetypeOperation.UPDATE_EVETYPE:
                    update_evetype(evetypeusecases);
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

    private void update_evetype(Evetype_usecases evetypeusecases) throws CustomException {
        IEvetype evetype = (IEvetype)parser.getJavaObject("evetype");
        evetypeusecases.updateEvetype(evetype);
    }
    
    @Override
    public String getServletInfo() {
        return "evetype_insert";
    }

}

