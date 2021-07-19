/*
 * DataServlet.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 18.6.2021 14:35
 *
 */

package eve.servlets.data;

import eve.BusinessObject.Logic.*;
import general.exception.CustomException;
import data.interfaces.db.Filedata;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.ISystem;
import eve.interfaces.servlet.ISystemOperation;
import eve.interfaces.searchentity.ISystemsearch;
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
@WebServlet(name="System", urlPatterns={"/eve.System"})
public class System extends SecurityDataServlet {
   
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
        BLsystem blsystem = new BLsystem();
        blsystem.setAuthenticated(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    ISystemPK systemPK;
                    ISystem system;
                    switch(this.operation) {
                        case ISystemOperation.SELECT_ALL:
                            dataobject = blsystem.getSystems();
                            break;
                        case ISystemOperation.SELECT_SYSTEM:
                            systemPK = (ISystemPK)parser.getJavaObject("systempk");
                            dataobject = blsystem.getSystem(systemPK);
                            break;
                        case ISystemOperation.SELECT_Security_island:
                            ISecurity_islandPK security_islandPK = (ISecurity_islandPK)parser.getJavaObject("security_islandpk");
                            dataobject = blsystem.getSystems4security_island(security_islandPK);
                            break;
                        case ISystemOperation.SELECT_Constellation:
                            IConstellationPK constellationPK = (IConstellationPK)parser.getJavaObject("constellationpk");
                            dataobject = blsystem.getSystems4constellation(constellationPK);
                            break;
                        case ISystemOperation.SELECT_Systemjumpssystem_end:
                            ISystemjumpsPK systemjumpsSystem_endPK = (ISystemjumpsPK)parser.getJavaObject("systemjumpspk");
                            dataobject = blsystem.getSystemjumpssystem_end(systemjumpsSystem_endPK);
                            break;
                        case ISystemOperation.SELECT_Systemjumpssystem_start:
                            ISystemjumpsPK systemjumpsSystem_startPK = (ISystemjumpsPK)parser.getJavaObject("systemjumpspk");
                            dataobject = blsystem.getSystemjumpssystem_start(systemjumpsSystem_startPK);
                            break;
                        case ISystemOperation.SELECT_Route:
                            IRoutePK routePK = (IRoutePK)parser.getJavaObject("routepk");
                            dataobject = blsystem.getRoute(routePK);
                            break;
                        case ISystemOperation.SELECT_Systemtradesell_system:
                            ISystemtradePK systemtradeSell_systemPK = (ISystemtradePK)parser.getJavaObject("systemtradepk");
                            dataobject = blsystem.getSystemtradesell_system(systemtradeSell_systemPK);
                            break;
                        case ISystemOperation.SELECT_Systemtradebuy_system:
                            ISystemtradePK systemtradeBuy_systemPK = (ISystemtradePK)parser.getJavaObject("systemtradepk");
                            dataobject = blsystem.getSystemtradebuy_system(systemtradeBuy_systemPK);
                            break;
                        case ISystemOperation.SELECT_SEARCH:
                            ISystemsearch search = (ISystemsearch)parser.getJavaObject("search");
                            dataobject = blsystem.search(search);
                            break;
                        case ISystemOperation.SELECT_SEARCHCOUNT:
                            ISystemsearch systemsearch = (ISystemsearch)parser.getJavaObject("search");
                            dataobject = blsystem.searchcount(systemsearch);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;

                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(this.operation) {
                        case ISystemOperation.INSERT_SYSTEM:
                            system = (ISystem)parser.getJavaObject("system");
                            blsystem.insertSystem(system);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(this.operation) {
                        case ISystemOperation.UPDATE_SYSTEM:
                            system = (ISystem)parser.getJavaObject("system");
                            blsystem.updateSystem(system);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(this.operation) {
                        case ISystemOperation.DELETE_SYSTEM:
                            system = (ISystem)parser.getJavaObject("system");
                            blsystem.deleteSystem(system);
                            break;
                        case ISystemOperation.DELETE_Security_island:
                            ISecurity_islandPK security_islandPK = (ISecurity_islandPK)parser.getJavaObject("security_islandpk");
                            blsystem.delete4security_island(this.getServletName(), security_islandPK);
                            break;
                        case ISystemOperation.DELETE_Constellation:
                            IConstellationPK constellationPK = (IConstellationPK)parser.getJavaObject("constellationpk");
                            blsystem.delete4constellation(this.getServletName(), constellationPK);
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
        return "system";
    }

}

