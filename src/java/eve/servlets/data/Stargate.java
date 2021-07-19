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
import eve.interfaces.logicentity.IStargate;
import eve.interfaces.servlet.IStargateOperation;
import eve.interfaces.searchentity.IStargatesearch;
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
@WebServlet(name="Stargate", urlPatterns={"/eve.Stargate"})
public class Stargate extends SecurityDataServlet {
   
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
        BLstargate blstargate = new BLstargate();
        blstargate.setAuthenticated(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    IStargatePK stargatePK;
                    IStargate stargate;
                    switch(this.operation) {
                        case IStargateOperation.SELECT_ALL:
                            dataobject = blstargate.getStargates();
                            break;
                        case IStargateOperation.SELECT_STARGATE:
                            stargatePK = (IStargatePK)parser.getJavaObject("stargatepk");
                            dataobject = blstargate.getStargate(stargatePK);
                            break;
                        case IStargateOperation.SELECT_Systemsystem:
                            ISystemPK systemSystemPK = (ISystemPK)parser.getJavaObject("systempk");
                            dataobject = blstargate.getStargates4systemSystem(systemSystemPK);
                            break;
                        case IStargateOperation.SELECT_Systemto_system:
                            ISystemPK systemTo_systemPK = (ISystemPK)parser.getJavaObject("systempk");
                            dataobject = blstargate.getStargates4systemTo_system(systemTo_systemPK);
                            break;
                        case IStargateOperation.SELECT_SEARCH:
                            IStargatesearch search = (IStargatesearch)parser.getJavaObject("search");
                            dataobject = blstargate.search(search);
                            break;
                        case IStargateOperation.SELECT_SEARCHCOUNT:
                            IStargatesearch stargatesearch = (IStargatesearch)parser.getJavaObject("search");
                            dataobject = blstargate.searchcount(stargatesearch);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;

                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(this.operation) {
                        case IStargateOperation.INSERT_STARGATE:
                            stargate = (IStargate)parser.getJavaObject("stargate");
                            blstargate.insertStargate(stargate);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(this.operation) {
                        case IStargateOperation.UPDATE_STARGATE:
                            stargate = (IStargate)parser.getJavaObject("stargate");
                            blstargate.updateStargate(stargate);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(this.operation) {
                        case IStargateOperation.DELETE_STARGATE:
                            stargate = (IStargate)parser.getJavaObject("stargate");
                            blstargate.deleteStargate(stargate);
                            break;
                        case IStargateOperation.DELETE_Systemsystem:
                            ISystemPK systemSystemPK = (ISystemPK)parser.getJavaObject("systempk");
                            blstargate.delete4systemSystem(this.getServletName(), systemSystemPK);
                            break;
                        case IStargateOperation.DELETE_Systemto_system:
                            ISystemPK systemTo_systemPK = (ISystemPK)parser.getJavaObject("systempk");
                            blstargate.delete4systemTo_system(this.getServletName(), systemTo_systemPK);
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
        return "stargate";
    }

}

