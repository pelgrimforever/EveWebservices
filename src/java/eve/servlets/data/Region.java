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
import eve.interfaces.logicentity.IRegion;
import eve.interfaces.servlet.IRegionOperation;
import eve.interfaces.searchentity.IRegionsearch;
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
@WebServlet(name="Region", urlPatterns={"/eve.Region"})
public class Region extends SecurityDataServlet {
   
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
        BLregion blregion = new BLregion();
        blregion.setAuthenticated(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    IRegionPK regionPK;
                    IRegion region;
                    switch(this.operation) {
                        case IRegionOperation.SELECT_ALL:
                            dataobject = blregion.getRegions();
                            break;
                        case IRegionOperation.SELECT_REGION:
                            regionPK = (IRegionPK)parser.getJavaObject("regionpk");
                            dataobject = blregion.getRegion(regionPK);
                            break;
                        case IRegionOperation.SELECT_Order_history:
                            IOrder_historyPK order_historyPK = (IOrder_historyPK)parser.getJavaObject("order_historypk");
                            dataobject = blregion.getOrder_history(order_historyPK);
                            break;
                        case IRegionOperation.SELECT_Region_neighbourregion:
                            IRegion_neighbourPK region_neighbourRegionPK = (IRegion_neighbourPK)parser.getJavaObject("region_neighbourpk");
                            dataobject = blregion.getRegion_neighbourregion(region_neighbourRegionPK);
                            break;
                        case IRegionOperation.SELECT_Region_neighbourneighbour:
                            IRegion_neighbourPK region_neighbourNeighbourPK = (IRegion_neighbourPK)parser.getJavaObject("region_neighbourpk");
                            dataobject = blregion.getRegion_neighbourneighbour(region_neighbourNeighbourPK);
                            break;
                        case IRegionOperation.SELECT_SEARCH:
                            IRegionsearch search = (IRegionsearch)parser.getJavaObject("search");
                            dataobject = blregion.search(search);
                            break;
                        case IRegionOperation.SELECT_SEARCHCOUNT:
                            IRegionsearch regionsearch = (IRegionsearch)parser.getJavaObject("search");
                            dataobject = blregion.searchcount(regionsearch);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;

                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(this.operation) {
                        case IRegionOperation.INSERT_REGION:
                            region = (IRegion)parser.getJavaObject("region");
                            blregion.insertRegion(region);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(this.operation) {
                        case IRegionOperation.UPDATE_REGION:
                            region = (IRegion)parser.getJavaObject("region");
                            blregion.updateRegion(region);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(this.operation) {
                        case IRegionOperation.DELETE_REGION:
                            region = (IRegion)parser.getJavaObject("region");
                            blregion.deleteRegion(region);
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
        return "region";
    }

}

