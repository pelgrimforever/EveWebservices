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
import eve.interfaces.logicentity.IRegion_neighbour;
import eve.interfaces.servlet.IRegion_neighbourOperation;
import eve.interfaces.searchentity.IRegion_neighboursearch;
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
@WebServlet(name="Region_neighbour", urlPatterns={"/eve.Region_neighbour"})
public class Region_neighbour extends SecurityDataServlet {
   
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
        BLregion_neighbour blregion_neighbour = new BLregion_neighbour();
        blregion_neighbour.setAuthenticated(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    IRegion_neighbourPK region_neighbourPK;
                    IRegion_neighbour region_neighbour;
                    switch(this.operation) {
                        case IRegion_neighbourOperation.SELECT_ALL:
                            dataobject = blregion_neighbour.getRegion_neighbours();
                            break;
                        case IRegion_neighbourOperation.SELECT_REGION_NEIGHBOUR:
                            region_neighbourPK = (IRegion_neighbourPK)parser.getJavaObject("region_neighbourpk");
                            dataobject = blregion_neighbour.getRegion_neighbour(region_neighbourPK);
                            break;
                        case IRegion_neighbourOperation.SELECT_Regionregion:
                            IRegionPK regionRegionPK = (IRegionPK)parser.getJavaObject("regionpk");
                            dataobject = blregion_neighbour.getRegion_neighbours4regionRegion(regionRegionPK);
                            break;
                        case IRegion_neighbourOperation.SELECT_Regionneighbour:
                            IRegionPK regionNeighbourPK = (IRegionPK)parser.getJavaObject("regionpk");
                            dataobject = blregion_neighbour.getRegion_neighbours4regionNeighbour(regionNeighbourPK);
                            break;
                        case IRegion_neighbourOperation.SELECT_SEARCH:
                            IRegion_neighboursearch search = (IRegion_neighboursearch)parser.getJavaObject("search");
                            dataobject = blregion_neighbour.search(search);
                            break;
                        case IRegion_neighbourOperation.SELECT_SEARCHCOUNT:
                            IRegion_neighboursearch region_neighboursearch = (IRegion_neighboursearch)parser.getJavaObject("search");
                            dataobject = blregion_neighbour.searchcount(region_neighboursearch);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;

                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(this.operation) {
                        case IRegion_neighbourOperation.INSERT_REGION_NEIGHBOUR:
                            region_neighbour = (IRegion_neighbour)parser.getJavaObject("region_neighbour");
                            blregion_neighbour.insertRegion_neighbour(region_neighbour);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(this.operation) {
                        case IRegion_neighbourOperation.UPDATE_REGION_NEIGHBOUR:
                            region_neighbour = (IRegion_neighbour)parser.getJavaObject("region_neighbour");
                            blregion_neighbour.updateRegion_neighbour(region_neighbour);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(this.operation) {
                        case IRegion_neighbourOperation.DELETE_REGION_NEIGHBOUR:
                            region_neighbour = (IRegion_neighbour)parser.getJavaObject("region_neighbour");
                            blregion_neighbour.deleteRegion_neighbour(region_neighbour);
                            break;
                        case IRegion_neighbourOperation.DELETE_Regionregion:
                            IRegionPK regionRegionPK = (IRegionPK)parser.getJavaObject("regionpk");
                            blregion_neighbour.delete4regionRegion(this.getServletName(), regionRegionPK);
                            break;
                        case IRegion_neighbourOperation.DELETE_Regionneighbour:
                            IRegionPK regionNeighbourPK = (IRegionPK)parser.getJavaObject("regionpk");
                            blregion_neighbour.delete4regionNeighbour(this.getServletName(), regionNeighbourPK);
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
        return "region_neighbour";
    }

}

