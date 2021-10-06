/*
 * Systemjumps.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 6.9.2021 16:29
 *
 */

package eve.servlets.data;

import eve.BusinessObject.Logic.*;
import general.exception.CustomException;
import data.interfaces.db.Filedata;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.ISystemjumps;
import eve.interfaces.servlet.ISystemjumpsOperation;
import eve.interfaces.searchentity.ISystemjumpssearch;
import eve.servlets.DataServlet;
import eve.servlets.SecurityDataServlet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Franky Laseure
 */
@WebServlet(name="Systemjumps", urlPatterns={"/eve.Systemjumps"})
public class Systemjumps extends SecurityDataServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);

        Object dataobject = null;
        BLsystemjumps blsystemjumps = new BLsystemjumps();
        blsystemjumps.setAuthenticated(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    ISystemjumpsPK systemjumpsPK;
                    ISystemjumps systemjumps;
                    switch(this.operation) {
                        case ISystemjumpsOperation.SELECT_ALL:
                            dataobject = blsystemjumps.getSystemjumpss();
                            break;
                        case ISystemjumpsOperation.SELECT_SYSTEMJUMPS:
                            systemjumpsPK = (ISystemjumpsPK)parser.getJavaObject("systemjumpspk");
                            dataobject = blsystemjumps.getSystemjumps(systemjumpsPK);
                            break;
                        case ISystemjumpsOperation.SELECT_Systemsystem_end:
                            ISystemPK systemSystem_endPK = (ISystemPK)parser.getJavaObject("systempk");
                            dataobject = blsystemjumps.getSystemjumpss4systemSystem_end(systemSystem_endPK);
                            break;
                        case ISystemjumpsOperation.SELECT_Systemsystem_start:
                            ISystemPK systemSystem_startPK = (ISystemPK)parser.getJavaObject("systempk");
                            dataobject = blsystemjumps.getSystemjumpss4systemSystem_start(systemSystem_startPK);
                            break;
                        case ISystemjumpsOperation.SELECT_SEARCH:
                            ISystemjumpssearch search = (ISystemjumpssearch)parser.getJavaObject("search");
                            dataobject = blsystemjumps.search(search);
                            break;
                        case ISystemjumpsOperation.SELECT_SEARCHCOUNT:
                            ISystemjumpssearch systemjumpssearch = (ISystemjumpssearch)parser.getJavaObject("search");
                            dataobject = blsystemjumps.searchcount(systemjumpssearch);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;

                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(this.operation) {
                        case ISystemjumpsOperation.INSERT_SYSTEMJUMPS:
                            systemjumps = (ISystemjumps)parser.getJavaObject("systemjumps");
                            blsystemjumps.insertSystemjumps(systemjumps);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(this.operation) {
                        case ISystemjumpsOperation.UPDATE_SYSTEMJUMPS:
                            systemjumps = (ISystemjumps)parser.getJavaObject("systemjumps");
                            blsystemjumps.updateSystemjumps(systemjumps);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(this.operation) {
                        case ISystemjumpsOperation.DELETE_SYSTEMJUMPS:
                            systemjumps = (ISystemjumps)parser.getJavaObject("systemjumps");
                            blsystemjumps.deleteSystemjumps(systemjumps);
                            break;
                        case ISystemjumpsOperation.DELETE_Systemsystem_end:
                            ISystemPK systemSystem_endPK = (ISystemPK)parser.getJavaObject("systempk");
                            blsystemjumps.delete4systemSystem_end(this.getServletName(), systemSystem_endPK);
                            break;
                        case ISystemjumpsOperation.DELETE_Systemsystem_start:
                            ISystemPK systemSystem_startPK = (ISystemPK)parser.getJavaObject("systempk");
                            blsystemjumps.delete4systemSystem_start(this.getServletName(), systemSystem_startPK);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_BACKUP:
                    switch(this.operation) {
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line
                    }
                    break;
            }

        } 
        catch(CustomException e) {
            dataobject = e;
        }
        finally {
        }
        this.sendData(response, dataobject);
    } 

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "systemjumps";
    }

}

