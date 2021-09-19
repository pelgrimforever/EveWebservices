/*
 * DataServlet.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 18.8.2021 11:31
 *
 */

package eve.servlets.data;

import eve.BusinessObject.Logic.*;
import general.exception.CustomException;
import data.interfaces.db.Filedata;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.IConstellation_neighbour;
import eve.interfaces.servlet.IConstellation_neighbourOperation;
import eve.interfaces.searchentity.IConstellation_neighboursearch;
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
@WebServlet(name="Constellation_neighbour", urlPatterns={"/eve.Constellation_neighbour"})
public class Constellation_neighbour extends SecurityDataServlet {
   
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
        BLconstellation_neighbour blconstellation_neighbour = new BLconstellation_neighbour();
        blconstellation_neighbour.setAuthenticated(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    IConstellation_neighbourPK constellation_neighbourPK;
                    IConstellation_neighbour constellation_neighbour;
                    switch(this.operation) {
                        case IConstellation_neighbourOperation.SELECT_ALL:
                            dataobject = blconstellation_neighbour.getConstellation_neighbours();
                            break;
                        case IConstellation_neighbourOperation.SELECT_CONSTELLATION_NEIGHBOUR:
                            constellation_neighbourPK = (IConstellation_neighbourPK)parser.getJavaObject("constellation_neighbourpk");
                            dataobject = blconstellation_neighbour.getConstellation_neighbour(constellation_neighbourPK);
                            break;
                        case IConstellation_neighbourOperation.SELECT_Constellationneighbour:
                            IConstellationPK constellationNeighbourPK = (IConstellationPK)parser.getJavaObject("constellationpk");
                            dataobject = blconstellation_neighbour.getConstellation_neighbours4constellationNeighbour(constellationNeighbourPK);
                            break;
                        case IConstellation_neighbourOperation.SELECT_Constellationconstellation:
                            IConstellationPK constellationConstellationPK = (IConstellationPK)parser.getJavaObject("constellationpk");
                            dataobject = blconstellation_neighbour.getConstellation_neighbours4constellationConstellation(constellationConstellationPK);
                            break;
                        case IConstellation_neighbourOperation.SELECT_SEARCH:
                            IConstellation_neighboursearch search = (IConstellation_neighboursearch)parser.getJavaObject("search");
                            dataobject = blconstellation_neighbour.search(search);
                            break;
                        case IConstellation_neighbourOperation.SELECT_SEARCHCOUNT:
                            IConstellation_neighboursearch constellation_neighboursearch = (IConstellation_neighboursearch)parser.getJavaObject("search");
                            dataobject = blconstellation_neighbour.searchcount(constellation_neighboursearch);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;

                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(this.operation) {
                        case IConstellation_neighbourOperation.INSERT_CONSTELLATION_NEIGHBOUR:
                            constellation_neighbour = (IConstellation_neighbour)parser.getJavaObject("constellation_neighbour");
                            blconstellation_neighbour.insertConstellation_neighbour(constellation_neighbour);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(this.operation) {
                        case IConstellation_neighbourOperation.UPDATE_CONSTELLATION_NEIGHBOUR:
                            constellation_neighbour = (IConstellation_neighbour)parser.getJavaObject("constellation_neighbour");
                            blconstellation_neighbour.updateConstellation_neighbour(constellation_neighbour);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(this.operation) {
                        case IConstellation_neighbourOperation.DELETE_CONSTELLATION_NEIGHBOUR:
                            constellation_neighbour = (IConstellation_neighbour)parser.getJavaObject("constellation_neighbour");
                            blconstellation_neighbour.deleteConstellation_neighbour(constellation_neighbour);
                            break;
                        case IConstellation_neighbourOperation.DELETE_Constellationneighbour:
                            IConstellationPK constellationNeighbourPK = (IConstellationPK)parser.getJavaObject("constellationpk");
                            blconstellation_neighbour.delete4constellationNeighbour(this.getServletName(), constellationNeighbourPK);
                            break;
                        case IConstellation_neighbourOperation.DELETE_Constellationconstellation:
                            IConstellationPK constellationConstellationPK = (IConstellationPK)parser.getJavaObject("constellationpk");
                            blconstellation_neighbour.delete4constellationConstellation(this.getServletName(), constellationConstellationPK);
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
        return "constellation_neighbour";
    }

}

