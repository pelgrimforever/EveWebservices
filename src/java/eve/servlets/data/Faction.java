/*
 * DataServlet.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 30.5.2021 15:39
 *
 */

package eve.servlets.data;

import eve.BusinessObject.Logic.*;
import general.exception.CustomException;
import data.interfaces.db.Filedata;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.IFaction;
import eve.interfaces.servlet.IFactionOperation;
import eve.interfaces.searchentity.IFactionsearch;
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
@WebServlet(name="Faction", urlPatterns={"/eve.Faction"})
public class Faction extends SecurityDataServlet {
   
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
        BLfaction blfaction = new BLfaction();
        blfaction.setAuthenticated(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    IFactionPK factionPK;
                    IFaction faction;
                    switch(this.operation) {
                        case IFactionOperation.SELECT_ALL:
                            dataobject = blfaction.getFactions();
                            break;
                        case IFactionOperation.SELECT_FACTION:
                            factionPK = (IFactionPK)parser.getJavaObject("factionpk");
                            dataobject = blfaction.getFaction(factionPK);
                            break;
                        case IFactionOperation.SELECT_System:
                            ISystemPK systemPK = (ISystemPK)parser.getJavaObject("systempk");
                            dataobject = blfaction.getFactions4system(systemPK);
                            break;
                        case IFactionOperation.SELECT_SEARCH:
                            IFactionsearch search = (IFactionsearch)parser.getJavaObject("search");
                            dataobject = blfaction.search(search);
                            break;
                        case IFactionOperation.SELECT_SEARCHCOUNT:
                            IFactionsearch factionsearch = (IFactionsearch)parser.getJavaObject("search");
                            dataobject = blfaction.searchcount(factionsearch);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;

                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(this.operation) {
                        case IFactionOperation.INSERT_FACTION:
                            faction = (IFaction)parser.getJavaObject("faction");
                            blfaction.insertFaction(faction);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(this.operation) {
                        case IFactionOperation.UPDATE_FACTION:
                            faction = (IFaction)parser.getJavaObject("faction");
                            blfaction.updateFaction(faction);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(this.operation) {
                        case IFactionOperation.DELETE_FACTION:
                            faction = (IFaction)parser.getJavaObject("faction");
                            blfaction.deleteFaction(faction);
                            break;
                        case IFactionOperation.DELETE_System:
                            ISystemPK systemPK = (ISystemPK)parser.getJavaObject("systempk");
                            blfaction.delete4system(this.getServletName(), systemPK);
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
        return "faction";
    }

}

