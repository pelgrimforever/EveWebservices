/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 17.6.2022 13:4
 */

package eve.servlets.station;

import general.exception.*;
import data.interfaces.db.Filedata;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.IStation;
import eve.interfaces.servlet.IStationOperation;
import eve.interfaces.searchentity.IStationsearch;
import eve.servlets.DataServlet;
import eve.servlets.SecurityDataServlet;
import eve.usecases.Station_usecases;
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
@WebServlet(name="Station_select", urlPatterns={"/eve.Station_select"})
public class Station_select extends SecurityDataServlet {
   
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);
        Object dataobject = null;
        Station_usecases stationusecases = new Station_usecases(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operation) {
                case IStationOperation.SELECT_ALL:
                    dataobject = stationusecases.get_all();
                    break;
                case IStationOperation.SELECT_STATION:
                    dataobject = get_station_with_primarykey(stationusecases);
                    break;
                case IStationOperation.SELECT_Race:
                    dataobject = get_station_with_foreignkey_race(stationusecases);
                    break;
                case IStationOperation.SELECT_Evetype:
                    dataobject = get_station_with_foreignkey_evetype(stationusecases);
                    break;
                case IStationOperation.SELECT_System:
                    dataobject = get_station_with_foreignkey_system(stationusecases);
                    break;
                case IStationOperation.SELECT_Station_service:
                    dataobject = get_station_with_externalforeignkey_station_service(stationusecases);
                    break;
                case IStationOperation.SELECT_SEARCH:
                    dataobject = search_station(stationusecases);
                    break;
                case IStationOperation.SELECT_SEARCHCOUNT:
                    dataobject = search_station_count(stationusecases);
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

    private Object get_station_with_primarykey(Station_usecases stationusecases) throws DBException {
        IStationPK stationPK = (IStationPK)parser.getJavaObject("stationpk");
        return stationusecases.get_station_by_primarykey(stationPK);
    }

    private Object get_station_with_foreignkey_race(Station_usecases stationusecases) throws CustomException {
        IRacePK racePK = (IRacePK)parser.getJavaObject("racepk");
        return stationusecases.get_station_with_foreignkey_race(racePK);
    }
    
    private Object get_station_with_foreignkey_evetype(Station_usecases stationusecases) throws CustomException {
        IEvetypePK evetypePK = (IEvetypePK)parser.getJavaObject("evetypepk");
        return stationusecases.get_station_with_foreignkey_evetype(evetypePK);
    }
    
    private Object get_station_with_foreignkey_system(Station_usecases stationusecases) throws CustomException {
        ISystemPK systemPK = (ISystemPK)parser.getJavaObject("systempk");
        return stationusecases.get_station_with_foreignkey_system(systemPK);
    }
    
    private Object get_station_with_externalforeignkey_station_service(Station_usecases stationusecases) throws CustomException {
        IStation_servicePK station_servicePK = (IStation_servicePK)parser.getJavaObject("station_servicepk");
        return stationusecases.get_station_with_externalforeignkey_station_service(station_servicePK);
    }
    
    private Object search_station(Station_usecases stationusecases) throws CustomException {
        IStationsearch search = (IStationsearch)parser.getJavaObject("search");
        return stationusecases.search_station(search);
    }
    
    private Object search_station_count(Station_usecases stationusecases) throws CustomException {
        IStationsearch stationsearch = (IStationsearch)parser.getJavaObject("search");
        return stationusecases.search_station_count(stationsearch);
    }

    @Override
    public String getServletInfo() {
        return "station_select";
    }

}

