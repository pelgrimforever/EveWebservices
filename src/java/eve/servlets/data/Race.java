/*
 * Race.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 9.11.2021 14:30
 *
 */

package eve.servlets.data;

import eve.BusinessObject.Logic.*;
import general.exception.CustomException;
import data.interfaces.db.Filedata;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.IRace;
import eve.interfaces.servlet.IRaceOperation;
import eve.interfaces.searchentity.IRacesearch;
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
@WebServlet(name="Race", urlPatterns={"/eve.Race"})
public class Race extends SecurityDataServlet {
   
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
        BLrace blrace = new BLrace();
        blrace.setAuthenticated(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    IRacePK racePK;
                    IRace race;
                    switch(this.operation) {
                        case IRaceOperation.SELECT_ALL:
                            dataobject = blrace.getRaces();
                            break;
                        case IRaceOperation.SELECT_RACE:
                            racePK = (IRacePK)parser.getJavaObject("racepk");
                            dataobject = blrace.getRace(racePK);
                            break;
                        case IRaceOperation.SELECT_Faction:
                            IFactionPK factionPK = (IFactionPK)parser.getJavaObject("factionpk");
                            dataobject = blrace.getRaces4faction(factionPK);
                            break;
                        case IRaceOperation.SELECT_SEARCH:
                            IRacesearch search = (IRacesearch)parser.getJavaObject("search");
                            dataobject = blrace.search(search);
                            break;
                        case IRaceOperation.SELECT_SEARCHCOUNT:
                            IRacesearch racesearch = (IRacesearch)parser.getJavaObject("search");
                            dataobject = blrace.searchcount(racesearch);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;

                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(this.operation) {
                        case IRaceOperation.INSERT_RACE:
                            race = (IRace)parser.getJavaObject("race");
                            blrace.insertRace(race);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(this.operation) {
                        case IRaceOperation.UPDATE_RACE:
                            race = (IRace)parser.getJavaObject("race");
                            blrace.updateRace(race);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(this.operation) {
                        case IRaceOperation.DELETE_RACE:
                            race = (IRace)parser.getJavaObject("race");
                            blrace.deleteRace(race);
                            break;
                        case IRaceOperation.DELETE_Faction:
                            IFactionPK factionPK = (IFactionPK)parser.getJavaObject("factionpk");
                            blrace.delete4faction(factionPK);
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
        return "race";
    }

}

