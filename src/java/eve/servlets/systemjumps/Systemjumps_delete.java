/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 23.8.2022 14:38
 * @author Franky Laseure
 */

package eve.servlets.systemjumps;

import general.exception.CustomException;
import data.interfaces.db.Filedata;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.ISystemjumps;
import eve.interfaces.servlet.ISystemjumpsOperation;
import eve.interfaces.searchentity.ISystemjumpssearch;
import eve.servlets.DataServlet;
import eve.servlets.SecurityDataServlet;
import eve.usecases.Systemjumps_usecases;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="Systemjumps_delete", urlPatterns={"/eve.Systemjumps_delete"})
public class Systemjumps_delete extends SecurityDataServlet {
   
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);
        Object dataobject = null;
        Systemjumps_usecases systemjumpsusecases = new Systemjumps_usecases(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operation) {
                case ISystemjumpsOperation.DELETE_SYSTEMJUMPS:
                    delete_systemjumps(systemjumpsusecases);
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

    private void delete_systemjumps(Systemjumps_usecases systemjumpsusecases) throws CustomException {
        ISystemjumps systemjumps = (ISystemjumps)parser.getJavaObject("systemjumps");
        systemjumpsusecases.deleteSystemjumps(systemjumps);
    }
    
    @Override
    public String getServletInfo() {
        return "systemjumps_insert";
    }

}

