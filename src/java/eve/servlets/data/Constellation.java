/*
 * Constellation.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 14.0.2022 16:56
 *
 */

package eve.servlets.data;

import eve.BusinessObject.Logic.*;
import general.exception.CustomException;
import data.interfaces.db.Filedata;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.IConstellation;
import eve.interfaces.servlet.IConstellationOperation;
import eve.interfaces.searchentity.IConstellationsearch;
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
@WebServlet(name="Constellation", urlPatterns={"/eve.Constellation"})
public class Constellation extends SecurityDataServlet {
   
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
        BLconstellation blconstellation = new BLconstellation();
        blconstellation.setAuthenticated(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    IConstellationPK constellationPK;
                    IConstellation constellation;
                    switch(this.operation) {
                        case IConstellationOperation.SELECT_ALL:
                            dataobject = blconstellation.getConstellations();
                            break;
                        case IConstellationOperation.SELECT_CONSTELLATION:
                            constellationPK = (IConstellationPK)parser.getJavaObject("constellationpk");
                            dataobject = blconstellation.getConstellation(constellationPK);
                            break;
                        case IConstellationOperation.SELECT_Region:
                            IRegionPK regionPK = (IRegionPK)parser.getJavaObject("regionpk");
                            dataobject = blconstellation.getConstellations4region(regionPK);
                            break;
                        case IConstellationOperation.SELECT_Constellation_neighbourneighbour:
                            IConstellation_neighbourPK constellation_neighbourNeighbourPK = (IConstellation_neighbourPK)parser.getJavaObject("constellation_neighbourpk");
                            dataobject = blconstellation.getConstellation_neighbourneighbour(constellation_neighbourNeighbourPK);
                            break;
                        case IConstellationOperation.SELECT_Constellation_neighbourconstellation:
                            IConstellation_neighbourPK constellation_neighbourConstellationPK = (IConstellation_neighbourPK)parser.getJavaObject("constellation_neighbourpk");
                            dataobject = blconstellation.getConstellation_neighbourconstellation(constellation_neighbourConstellationPK);
                            break;
                        case IConstellationOperation.SELECT_SEARCH:
                            IConstellationsearch search = (IConstellationsearch)parser.getJavaObject("search");
                            dataobject = blconstellation.search(search);
                            break;
                        case IConstellationOperation.SELECT_SEARCHCOUNT:
                            IConstellationsearch constellationsearch = (IConstellationsearch)parser.getJavaObject("search");
                            dataobject = blconstellation.searchcount(constellationsearch);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;

                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(this.operation) {
                        case IConstellationOperation.INSERT_CONSTELLATION:
                            constellation = (IConstellation)parser.getJavaObject("constellation");
                            blconstellation.insertConstellation(constellation);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(this.operation) {
                        case IConstellationOperation.UPDATE_CONSTELLATION:
                            constellation = (IConstellation)parser.getJavaObject("constellation");
                            blconstellation.updateConstellation(constellation);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(this.operation) {
                        case IConstellationOperation.DELETE_CONSTELLATION:
                            constellation = (IConstellation)parser.getJavaObject("constellation");
                            blconstellation.deleteConstellation(constellation);
                            break;
                        case IConstellationOperation.DELETE_Region:
                            IRegionPK regionPK = (IRegionPK)parser.getJavaObject("regionpk");
                            blconstellation.delete4region(regionPK);
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
        return "constellation";
    }

}

