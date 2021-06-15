/*
 * DataServlet.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 14.5.2021 13:35
 *
 */

package eve.servlets.data;

import eve.BusinessObject.Logic.*;
import general.exception.CustomException;
import data.interfaces.db.Filedata;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.ILocation;
import eve.interfaces.servlet.ILocationOperation;
import eve.interfaces.searchentity.ILocationsearch;
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
@WebServlet(name="Location", urlPatterns={"/eve.Location"})
public class Location extends SecurityDataServlet {
   
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
        BLlocation bllocation = new BLlocation();
        bllocation.setAuthenticated(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    ILocationPK locationPK;
                    ILocation location;
                    switch(this.operation) {
                        case ILocationOperation.SELECT_ALL:
                            dataobject = bllocation.getLocations();
                            break;
                        case ILocationOperation.SELECT_LOCATION:
                            locationPK = (ILocationPK)parser.getJavaObject("locationpk");
                            dataobject = bllocation.getLocation(locationPK);
                            break;
                        case ILocationOperation.SELECT_System:
                            ISystemPK systemPK = (ISystemPK)parser.getJavaObject("systempk");
                            dataobject = bllocation.getLocations4system(systemPK);
                            break;
                        case ILocationOperation.SELECT_SEARCH:
                            ILocationsearch search = (ILocationsearch)parser.getJavaObject("search");
                            dataobject = bllocation.search(search);
                            break;
                        case ILocationOperation.SELECT_SEARCHCOUNT:
                            ILocationsearch locationsearch = (ILocationsearch)parser.getJavaObject("search");
                            dataobject = bllocation.searchcount(locationsearch);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;

                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(this.operation) {
                        case ILocationOperation.INSERT_LOCATION:
                            location = (ILocation)parser.getJavaObject("location");
                            bllocation.insertLocation(location);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(this.operation) {
                        case ILocationOperation.UPDATE_LOCATION:
                            location = (ILocation)parser.getJavaObject("location");
                            bllocation.updateLocation(location);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(this.operation) {
                        case ILocationOperation.DELETE_LOCATION:
                            location = (ILocation)parser.getJavaObject("location");
                            bllocation.deleteLocation(location);
                            break;
                        case ILocationOperation.DELETE_System:
                            ISystemPK systemPK = (ISystemPK)parser.getJavaObject("systempk");
                            bllocation.delete4system(this.getServletName(), systemPK);
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
        return "location";
    }

}

