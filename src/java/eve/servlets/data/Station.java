/*
 * Station.java
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
import eve.interfaces.logicentity.IStation;
import eve.interfaces.servlet.IStationOperation;
import eve.interfaces.searchentity.IStationsearch;
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
@WebServlet(name="Station", urlPatterns={"/eve.Station"})
public class Station extends SecurityDataServlet {
   
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
        BLstation blstation = new BLstation();
        blstation.setAuthenticated(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    IStationPK stationPK;
                    IStation station;
                    switch(this.operation) {
                        case IStationOperation.SELECT_ALL:
                            dataobject = blstation.getStations();
                            break;
                        case IStationOperation.SELECT_STATION:
                            stationPK = (IStationPK)parser.getJavaObject("stationpk");
                            dataobject = blstation.getStation(stationPK);
                            break;
                        case IStationOperation.SELECT_Race:
                            IRacePK racePK = (IRacePK)parser.getJavaObject("racepk");
                            dataobject = blstation.getStations4race(racePK);
                            break;
                        case IStationOperation.SELECT_Evetype:
                            IEvetypePK evetypePK = (IEvetypePK)parser.getJavaObject("evetypepk");
                            dataobject = blstation.getStations4evetype(evetypePK);
                            break;
                        case IStationOperation.SELECT_System:
                            ISystemPK systemPK = (ISystemPK)parser.getJavaObject("systempk");
                            dataobject = blstation.getStations4system(systemPK);
                            break;
                        case IStationOperation.SELECT_Station_service:
                            IStation_servicePK station_servicePK = (IStation_servicePK)parser.getJavaObject("station_servicepk");
                            dataobject = blstation.getStation_service(station_servicePK);
                            break;
                        case IStationOperation.SELECT_SEARCH:
                            IStationsearch search = (IStationsearch)parser.getJavaObject("search");
                            dataobject = blstation.search(search);
                            break;
                        case IStationOperation.SELECT_SEARCHCOUNT:
                            IStationsearch stationsearch = (IStationsearch)parser.getJavaObject("search");
                            dataobject = blstation.searchcount(stationsearch);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;

                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(this.operation) {
                        case IStationOperation.INSERT_STATION:
                            station = (IStation)parser.getJavaObject("station");
                            blstation.insertStation(station);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(this.operation) {
                        case IStationOperation.UPDATE_STATION:
                            station = (IStation)parser.getJavaObject("station");
                            blstation.updateStation(station);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(this.operation) {
                        case IStationOperation.DELETE_STATION:
                            station = (IStation)parser.getJavaObject("station");
                            blstation.deleteStation(station);
                            break;
                        case IStationOperation.DELETE_Race:
                            IRacePK racePK = (IRacePK)parser.getJavaObject("racepk");
                            blstation.delete4race(this.getServletName(), racePK);
                            break;
                        case IStationOperation.DELETE_Evetype:
                            IEvetypePK evetypePK = (IEvetypePK)parser.getJavaObject("evetypepk");
                            blstation.delete4evetype(this.getServletName(), evetypePK);
                            break;
                        case IStationOperation.DELETE_System:
                            ISystemPK systemPK = (ISystemPK)parser.getJavaObject("systempk");
                            blstation.delete4system(this.getServletName(), systemPK);
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
        return "station";
    }

}

