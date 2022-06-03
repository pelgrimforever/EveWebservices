/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 20.4.2022 10:3
 */

package eve.servlets.usersettings;

import general.exception.CustomException;
import data.interfaces.db.Filedata;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.IUsersettings;
import eve.interfaces.servlet.IUsersettingsOperation;
import eve.interfaces.searchentity.IUsersettingssearch;
import eve.servlets.DataServlet;
import eve.servlets.SecurityDataServlet;
import eve.usecases.Usersettings_usecases;
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
@WebServlet(name="Usersettings_delete", urlPatterns={"/eve.Usersettings_delete"})
public class Usersettings_delete extends SecurityDataServlet {
   
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);
        Object dataobject = null;
        Usersettings_usecases usersettingsusecases = new Usersettings_usecases(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operation) {
                case IUsersettingsOperation.DELETE_USERSETTINGS:
                    delete_usersettings(usersettingsusecases);
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

    private void delete_usersettings(Usersettings_usecases usersettingsusecases) throws CustomException {
        IUsersettings usersettings = (IUsersettings)parser.getJavaObject("usersettings");
        usersettingsusecases.securedeleteUsersettings(usersettings);
    }
    
    @Override
    public String getServletInfo() {
        return "usersettings_insert";
    }

}

