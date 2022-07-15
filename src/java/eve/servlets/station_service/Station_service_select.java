/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 13.6.2022 11:21
 */

package eve.servlets.station_service;

import general.exception.*;
import data.interfaces.db.Filedata;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.IStation_service;
import eve.interfaces.servlet.IStation_serviceOperation;
import eve.interfaces.searchentity.IStation_servicesearch;
import eve.servlets.DataServlet;
import eve.servlets.SecurityDataServlet;
import eve.usecases.Station_service_usecases;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Franky Laseure
 */
@WebServlet(name="Station_service_select", urlPatterns={"/eve.Station_service_select"})
public class Station_service_select extends SecurityDataServlet {
   
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);
        Object dataobject = null;
        Station_service_usecases station_serviceusecases = new Station_service_usecases(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operation) {
                case IStation_serviceOperation.SELECT_ALL:
                    dataobject = station_serviceusecases.get_all();
                    break;
                case IStation_serviceOperation.SELECT_STATION_SERVICE:
                    dataobject = get_station_service_with_primarykey(station_serviceusecases);
                    break;
                case IStation_serviceOperation.SELECT_Station:
                    dataobject = get_station_service_with_foreignkey_station(station_serviceusecases);
                    break;
                case IStation_serviceOperation.SELECT_SEARCH:
                    dataobject = search_station_service(station_serviceusecases);
                    break;
                case IStation_serviceOperation.SELECT_SEARCHCOUNT:
                    dataobject = search_station_service_count(station_serviceusecases);
                    break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            }

        } 
        catch(CustomException e) {
            dataobject = e;
        }
        finally {
        }
        this.sendData(response, dataobject);
    } 

//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   

    private Object get_station_service_with_primarykey(Station_service_usecases station_serviceusecases) throws DBException {
        IStation_servicePK station_servicePK = (IStation_servicePK)parser.getJavaObject("station_servicepk");
        return station_serviceusecases.get_station_service_by_primarykey(station_servicePK);
    }

    private Object get_station_service_with_foreignkey_station(Station_service_usecases station_serviceusecases) throws CustomException {
        IStationPK stationPK = (IStationPK)parser.getJavaObject("stationpk");
        return station_serviceusecases.get_station_service_with_foreignkey_station(stationPK);
    }
    
    private Object search_station_service(Station_service_usecases station_serviceusecases) throws CustomException {
        IStation_servicesearch search = (IStation_servicesearch)parser.getJavaObject("search");
        return station_serviceusecases.search_station_service(search);
    }
    
    private Object search_station_service_count(Station_service_usecases station_serviceusecases) throws CustomException {
        IStation_servicesearch station_servicesearch = (IStation_servicesearch)parser.getJavaObject("search");
        return station_serviceusecases.search_station_service_count(station_servicesearch);
    }

    @Override
    public String getServletInfo() {
        return "station_service_select";
    }

}

