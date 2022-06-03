/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 20.4.2022 10:3
 */

package eve.servlets.systemjumps;

import general.exception.*;
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
@WebServlet(name="Systemjumps_select", urlPatterns={"/eve.Systemjumps_select"})
public class Systemjumps_select extends SecurityDataServlet {
   
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
                case ISystemjumpsOperation.SELECT_ALL:
                    dataobject = systemjumpsusecases.get_all();
                    break;
                case ISystemjumpsOperation.SELECT_SYSTEMJUMPS:
                    dataobject = get_systemjumps_with_primarykey(systemjumpsusecases);
                    break;
                case ISystemjumpsOperation.SELECT_Systemsystem_end:
                    dataobject = get_systemjumps_with_foreignkey_systemSystem_end(systemjumpsusecases);
                    break;
                case ISystemjumpsOperation.SELECT_Systemsystem_start:
                    dataobject = get_systemjumps_with_foreignkey_systemSystem_start(systemjumpsusecases);
                    break;
                case ISystemjumpsOperation.SELECT_SEARCH:
                    dataobject = search_systemjumps(systemjumpsusecases);
                    break;
                case ISystemjumpsOperation.SELECT_SEARCHCOUNT:
                    dataobject = search_systemjumps_count(systemjumpsusecases);
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

    private Object get_systemjumps_with_primarykey(Systemjumps_usecases systemjumpsusecases) throws DBException {
        ISystemjumpsPK systemjumpsPK = (ISystemjumpsPK)parser.getJavaObject("systemjumpspk");
        return systemjumpsusecases.get_systemjumps_by_primarykey(systemjumpsPK);
    }

    private Object get_systemjumps_with_foreignkey_systemSystem_end(Systemjumps_usecases systemjumpsusecases) throws CustomException {
        ISystemPK systemSystem_endPK = (ISystemPK)parser.getJavaObject("systempk");
        return systemjumpsusecases.get_systemjumps_with_foreignkey_systemSystem_end(systemSystem_endPK);
    }
    
    private Object get_systemjumps_with_foreignkey_systemSystem_start(Systemjumps_usecases systemjumpsusecases) throws CustomException {
        ISystemPK systemSystem_startPK = (ISystemPK)parser.getJavaObject("systempk");
        return systemjumpsusecases.get_systemjumps_with_foreignkey_systemSystem_start(systemSystem_startPK);
    }
    
    private Object search_systemjumps(Systemjumps_usecases systemjumpsusecases) throws CustomException {
        ISystemjumpssearch search = (ISystemjumpssearch)parser.getJavaObject("search");
        return systemjumpsusecases.search_systemjumps(search);
    }
    
    private Object search_systemjumps_count(Systemjumps_usecases systemjumpsusecases) throws CustomException {
        ISystemjumpssearch systemjumpssearch = (ISystemjumpssearch)parser.getJavaObject("search");
        return systemjumpsusecases.search_systemjumps_count(systemjumpssearch);
    }

    @Override
    public String getServletInfo() {
        return "systemjumps_select";
    }

}

