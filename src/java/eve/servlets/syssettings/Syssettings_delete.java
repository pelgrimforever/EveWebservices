/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 23.8.2022 14:38
 * @author Franky Laseure
 */

package eve.servlets.syssettings;

import general.exception.CustomException;
import data.interfaces.db.Filedata;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.ISyssettings;
import eve.interfaces.servlet.ISyssettingsOperation;
import eve.interfaces.searchentity.ISyssettingssearch;
import eve.servlets.DataServlet;
import eve.servlets.SecurityDataServlet;
import eve.usecases.Syssettings_usecases;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="Syssettings_delete", urlPatterns={"/eve.Syssettings_delete"})
public class Syssettings_delete extends SecurityDataServlet {
   
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);
        Object dataobject = null;
        Syssettings_usecases syssettingsusecases = new Syssettings_usecases(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operation) {
                case ISyssettingsOperation.DELETE_SYSSETTINGS:
                    delete_syssettings(syssettingsusecases);
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

    private void delete_syssettings(Syssettings_usecases syssettingsusecases) throws CustomException {
        ISyssettings syssettings = (ISyssettings)parser.getJavaObject("syssettings");
        syssettingsusecases.deleteSyssettings(syssettings);
    }
    
    @Override
    public String getServletInfo() {
        return "syssettings_insert";
    }

}

