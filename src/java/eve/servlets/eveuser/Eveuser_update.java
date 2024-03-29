/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 23.8.2022 14:38
 * @author Franky Laseure
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

@WebServlet(name="Eveuser_update", urlPatterns={"/eve.Eveuser_update"})
public class Eveuser_update extends SecurityDataServlet {
   
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
                case IEveuserOperation.UPDATE_EVEUSER:
                    update_eveuser(eveuserusecases);
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

    private void update_eveuser(Eveuser_usecases eveuserusecases) throws CustomException {
        IEveuser eveuser = (IEveuser)parser.getJavaObject("eveuser");
        eveuserusecases.updateEveuser(eveuser);
    }
    
    @Override
    public String getServletInfo() {
        return "eveuser_insert";
    }

}

