/*
 * Generated on 13.4.2022 19:13
 */

package eve.usecases;

import data.conversion.JSONConversion;
import eve.BusinessObject.Logic.*;
import eve.entity.pk.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.searchentity.*;
import eve.interfaces.entity.pk.*;
import eve.logicentity.Station_service;
import eve.logicview.*;
import general.exception.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.IOException;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class Station_service_usecases {

    private boolean loggedin = false;
    private BLstation_service blstation_service = new BLstation_service();
    
    public Station_service_usecases() {
        this(false);
    }
    
    public Station_service_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blstation_service.setAuthenticated(loggedin);
    }
    
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   

    public long count() throws DBException {
        return blstation_service.count();
    }
    
    public ArrayList<Station_service> get_all() throws DBException {
        return blstation_service.getStation_services();
    }
    
    public boolean getStation_serviceExists(IStation_servicePK station_servicePK) throws DBException {
        return blstation_service.getEntityExists(station_servicePK);
    }
    
    public Station_service get_station_service_by_primarykey(IStation_servicePK station_servicePK) throws DBException {
        return blstation_service.getStation_service(station_servicePK);
    }

    public ArrayList<Station_service> get_station_service_with_foreignkey_station(IStationPK stationPK) throws CustomException {
        return blstation_service.getStation_services4station(stationPK);
    }
    
    public ArrayList<Station_service> search_station_service(IStation_servicesearch station_servicesearch) throws ParseException, CustomException {
        return blstation_service.search(station_servicesearch);
    }
    
    public long search_station_service_count(IStation_servicesearch station_servicesearch) throws ParseException, CustomException {
        return blstation_service.searchcount(station_servicesearch);
    }

    public void secureinsertStation_service(IStation_service station_service) throws DBException, DataException {
        blstation_service.secureinsertStation_service(station_service);
    }

    public void secureupdateStation_service(IStation_service station_service) throws DBException, DataException {
        blstation_service.secureupdateStation_service(station_service);
    }

    public void securedeleteStation_service(IStation_service station_service) throws DBException, DataException {
        blstation_service.securedeleteStation_service(station_service);
    }
}

