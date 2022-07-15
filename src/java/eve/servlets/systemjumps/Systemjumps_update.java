/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 13.6.2022 11:21
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

/**
 * @author Franky Laseure
 */
@WebServlet(name="Systemjumps_update", urlPatterns={"/eve.Systemjumps_update"})
public class Systemjumps_update extends SecurityDataServlet {
   
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
                case ISystemjumpsOperation.UPDATE_SYSTEMJUMPS:
                    update_systemjumps(systemjumpsusecases);
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

    private void update_systemjumps(Systemjumps_usecases systemjumpsusecases) throws CustomException {
        ISystemjumps systemjumps = (ISystemjumps)parser.getJavaObject("systemjumps");
        systemjumpsusecases.updateSystemjumps(systemjumps);
    }
    
    @Override
    public String getServletInfo() {
        return "systemjumps_insert";
    }

}

