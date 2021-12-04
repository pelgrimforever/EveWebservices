/*
 * Alliance.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 4.11.2021 14:51
 *
 */

package eve.servlets.data;

import eve.BusinessObject.Logic.*;
import general.exception.CustomException;
import data.interfaces.db.Filedata;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.IAlliance;
import eve.interfaces.servlet.IAllianceOperation;
import eve.interfaces.searchentity.IAlliancesearch;
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
@WebServlet(name="Alliance", urlPatterns={"/eve.Alliance"})
public class Alliance extends SecurityDataServlet {
   
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
        BLalliance blalliance = new BLalliance();
        blalliance.setAuthenticated(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    IAlliancePK alliancePK;
                    IAlliance alliance;
                    switch(this.operation) {
                        case IAllianceOperation.SELECT_ALL:
                            dataobject = blalliance.getAlliances();
                            break;
                        case IAllianceOperation.SELECT_ALLIANCE:
                            alliancePK = (IAlliancePK)parser.getJavaObject("alliancepk");
                            dataobject = blalliance.getAlliance(alliancePK);
                            break;
                        case IAllianceOperation.SELECT_Corporationcreator_corporation:
                            ICorporationPK corporationCreator_corporationPK = (ICorporationPK)parser.getJavaObject("corporationpk");
                            dataobject = blalliance.getAlliances4corporationCreator_corporation(corporationCreator_corporationPK);
                            break;
                        case IAllianceOperation.SELECT_Corporationexecutor_corporation:
                            ICorporationPK corporationExecutor_corporationPK = (ICorporationPK)parser.getJavaObject("corporationpk");
                            dataobject = blalliance.getAlliances4corporationExecutor_corporation(corporationExecutor_corporationPK);
                            break;
                        case IAllianceOperation.SELECT_SEARCH:
                            IAlliancesearch search = (IAlliancesearch)parser.getJavaObject("search");
                            dataobject = blalliance.search(search);
                            break;
                        case IAllianceOperation.SELECT_SEARCHCOUNT:
                            IAlliancesearch alliancesearch = (IAlliancesearch)parser.getJavaObject("search");
                            dataobject = blalliance.searchcount(alliancesearch);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;

                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(this.operation) {
                        case IAllianceOperation.INSERT_ALLIANCE:
                            alliance = (IAlliance)parser.getJavaObject("alliance");
                            blalliance.insertAlliance(alliance);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(this.operation) {
                        case IAllianceOperation.UPDATE_ALLIANCE:
                            alliance = (IAlliance)parser.getJavaObject("alliance");
                            blalliance.updateAlliance(alliance);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(this.operation) {
                        case IAllianceOperation.DELETE_ALLIANCE:
                            alliance = (IAlliance)parser.getJavaObject("alliance");
                            blalliance.deleteAlliance(alliance);
                            break;
                        case IAllianceOperation.DELETE_Corporationcreator_corporation:
                            ICorporationPK corporationCreator_corporationPK = (ICorporationPK)parser.getJavaObject("corporationpk");
                            blalliance.delete4corporationCreator_corporation(corporationCreator_corporationPK);
                            break;
                        case IAllianceOperation.DELETE_Corporationexecutor_corporation:
                            ICorporationPK corporationExecutor_corporationPK = (ICorporationPK)parser.getJavaObject("corporationpk");
                            blalliance.delete4corporationExecutor_corporation(corporationExecutor_corporationPK);
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
        return "alliance";
    }

}

