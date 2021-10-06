/*
 * Corporation.java
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
import eve.interfaces.logicentity.ICorporation;
import eve.interfaces.servlet.ICorporationOperation;
import eve.interfaces.searchentity.ICorporationsearch;
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
@WebServlet(name="Corporation", urlPatterns={"/eve.Corporation"})
public class Corporation extends SecurityDataServlet {
   
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
        BLcorporation blcorporation = new BLcorporation();
        blcorporation.setAuthenticated(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    ICorporationPK corporationPK;
                    ICorporation corporation;
                    switch(this.operation) {
                        case ICorporationOperation.SELECT_ALL:
                            dataobject = blcorporation.getCorporations();
                            break;
                        case ICorporationOperation.SELECT_CORPORATION:
                            corporationPK = (ICorporationPK)parser.getJavaObject("corporationpk");
                            dataobject = blcorporation.getCorporation(corporationPK);
                            break;
                        case ICorporationOperation.SELECT_Station:
                            IStationPK stationPK = (IStationPK)parser.getJavaObject("stationpk");
                            dataobject = blcorporation.getCorporations4station(stationPK);
                            break;
                        case ICorporationOperation.SELECT_Faction:
                            IFactionPK factionPK = (IFactionPK)parser.getJavaObject("factionpk");
                            dataobject = blcorporation.getCorporations4faction(factionPK);
                            break;
                        case ICorporationOperation.SELECT_Alliance:
                            IAlliancePK alliancePK = (IAlliancePK)parser.getJavaObject("alliancepk");
                            dataobject = blcorporation.getCorporations4alliance(alliancePK);
                            break;
                        case ICorporationOperation.SELECT_SEARCH:
                            ICorporationsearch search = (ICorporationsearch)parser.getJavaObject("search");
                            dataobject = blcorporation.search(search);
                            break;
                        case ICorporationOperation.SELECT_SEARCHCOUNT:
                            ICorporationsearch corporationsearch = (ICorporationsearch)parser.getJavaObject("search");
                            dataobject = blcorporation.searchcount(corporationsearch);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;

                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(this.operation) {
                        case ICorporationOperation.INSERT_CORPORATION:
                            corporation = (ICorporation)parser.getJavaObject("corporation");
                            blcorporation.insertCorporation(corporation);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(this.operation) {
                        case ICorporationOperation.UPDATE_CORPORATION:
                            corporation = (ICorporation)parser.getJavaObject("corporation");
                            blcorporation.updateCorporation(corporation);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(this.operation) {
                        case ICorporationOperation.DELETE_CORPORATION:
                            corporation = (ICorporation)parser.getJavaObject("corporation");
                            blcorporation.deleteCorporation(corporation);
                            break;
                        case ICorporationOperation.DELETE_Station:
                            IStationPK stationPK = (IStationPK)parser.getJavaObject("stationpk");
                            blcorporation.delete4station(this.getServletName(), stationPK);
                            break;
                        case ICorporationOperation.DELETE_Faction:
                            IFactionPK factionPK = (IFactionPK)parser.getJavaObject("factionpk");
                            blcorporation.delete4faction(this.getServletName(), factionPK);
                            break;
                        case ICorporationOperation.DELETE_Alliance:
                            IAlliancePK alliancePK = (IAlliancePK)parser.getJavaObject("alliancepk");
                            blcorporation.delete4alliance(this.getServletName(), alliancePK);
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
        return "corporation";
    }

}

