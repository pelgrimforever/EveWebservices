/*
 * Generated on 17.6.2022 13:4
 */

package eve.usecases;

import db.*;
import data.conversion.JSONConversion;
import data.interfaces.db.Filedata;
import data.gis.shape.piPoint;
import eve.BusinessObject.Logic.*;
import eve.entity.pk.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.searchentity.*;
import eve.interfaces.entity.pk.*;
import eve.logicentity.*;
import eve.logicentity.Station_service;
import eve.logicview.*;
import eve.usecases.custom.*;
import general.exception.*;
import java.sql.Date;
import java.util.*;
import java.io.IOException;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class Station_service_usecases {

    private boolean loggedin = false;
    private SQLreader sqlreader = new SQLreader();
    private SQLTwriter sqlwriter = new SQLTwriter();
    private BLstation_service blstation_service = new BLstation_service(sqlreader);
    
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
        return blstation_service.getStation_serviceExists(station_servicePK);
    }
    
    public Station_service get_station_service_by_primarykey(IStation_servicePK station_servicePK) throws DBException {
        return blstation_service.getStation_service(station_servicePK);
    }

    public ArrayList<Station_service> get_station_service_with_foreignkey_station(IStationPK stationPK) throws CustomException {
        return blstation_service.getStation_services4station(stationPK);
    }
    
    public ArrayList<Station_service> search_station_service(IStation_servicesearch station_servicesearch) throws CustomException {
        return blstation_service.search(station_servicesearch);
    }
    
    public long search_station_service_count(IStation_servicesearch station_servicesearch) throws CustomException {
        return blstation_service.searchcount(station_servicesearch);
    }

    public void insertStation_service(IStation_service station_service) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blstation_service.insertStation_service(tq, station_service);
        sqlwriter.Commit2DB(tq);
    }

    public void updateStation_service(IStation_service station_service) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blstation_service.updateStation_service(tq, station_service);
        sqlwriter.Commit2DB(tq);
    }

    public void deleteStation_service(IStation_service station_service) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blstation_service.deleteStation_service(tq, station_service);
        sqlwriter.Commit2DB(tq);
    }

    public void delete_all_containing_Station(IStationPK stationPK) throws CustomException {
        SQLTqueue tq = new SQLTqueue();
        blstation_service.delete4station(tq, stationPK);
        sqlwriter.Commit2DB(tq);
    }
    
}

