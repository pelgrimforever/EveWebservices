/*
 * DataServlet.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 23.5.2021 16:2
 *
 */

package eve.servlets.data;

import eve.BusinessObject.Logic.*;
import general.exception.CustomException;
import data.interfaces.db.Filedata;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.IStation_service;
import eve.interfaces.servlet.IStation_serviceOperation;
import eve.interfaces.searchentity.IStation_servicesearch;
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
@WebServlet(name="Station_service", urlPatterns={"/eve.Station_service"})
public class Station_service extends SecurityDataServlet {
   
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
        BLstation_service blstation_service = new BLstation_service();
        blstation_service.setAuthenticated(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    IStation_servicePK station_servicePK;
                    IStation_service station_service;
                    switch(this.operation) {
                        case IStation_serviceOperation.SELECT_ALL:
                            dataobject = blstation_service.getStation_services();
                            break;
                        case IStation_serviceOperation.SELECT_STATION_SERVICE:
                            station_servicePK = (IStation_servicePK)parser.getJavaObject("station_servicepk");
                            dataobject = blstation_service.getStation_service(station_servicePK);
                            break;
                        case IStation_serviceOperation.SELECT_Station:
                            IStationPK stationPK = (IStationPK)parser.getJavaObject("stationpk");
                            dataobject = blstation_service.getStation_services4station(stationPK);
                            break;
                        case IStation_serviceOperation.SELECT_SEARCH:
                            IStation_servicesearch search = (IStation_servicesearch)parser.getJavaObject("search");
                            dataobject = blstation_service.search(search);
                            break;
                        case IStation_serviceOperation.SELECT_SEARCHCOUNT:
                            IStation_servicesearch station_servicesearch = (IStation_servicesearch)parser.getJavaObject("search");
                            dataobject = blstation_service.searchcount(station_servicesearch);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;

                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(this.operation) {
                        case IStation_serviceOperation.INSERT_STATION_SERVICE:
                            station_service = (IStation_service)parser.getJavaObject("station_service");
                            blstation_service.insertStation_service(station_service);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(this.operation) {
                        case IStation_serviceOperation.UPDATE_STATION_SERVICE:
                            station_service = (IStation_service)parser.getJavaObject("station_service");
                            blstation_service.updateStation_service(station_service);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(this.operation) {
                        case IStation_serviceOperation.DELETE_STATION_SERVICE:
                            station_service = (IStation_service)parser.getJavaObject("station_service");
                            blstation_service.deleteStation_service(station_service);
                            break;
                        case IStation_serviceOperation.DELETE_Station:
                            IStationPK stationPK = (IStationPK)parser.getJavaObject("stationpk");
                            blstation_service.delete4station(this.getServletName(), stationPK);
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
        return "station_service";
    }

}

