/*
 * Generated on 20.4.2022 10:3
 */

package eve.usecases;

import data.conversion.JSONConversion;
import data.interfaces.db.Filedata;
import data.gis.shape.piPoint;
import eve.BusinessObject.Logic.*;
import eve.entity.pk.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.searchentity.*;
import eve.interfaces.entity.pk.*;
import eve.logicentity.Station;
import general.exception.*;
import java.sql.Date;
import java.util.*;
import java.io.IOException;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class Station_usecases {

    private boolean loggedin = false;
    private BLstation blstation = new BLstation();
    
    public Station_usecases() {
        this(false);
    }
    
    public Station_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blstation.setAuthenticated(loggedin);
    }
    
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   

    public long count() throws DBException {
        return blstation.count();
    }
    
    public ArrayList<Station> get_all() throws DBException {
        return blstation.getStations();
    }
    
    public boolean getStationExists(IStationPK stationPK) throws DBException {
        return blstation.getEntityExists(stationPK);
    }
    
    public Station get_station_by_primarykey(IStationPK stationPK) throws DBException {
        return blstation.getStation(stationPK);
    }

    public ArrayList<Station> get_station_with_foreignkey_race(IRacePK racePK) throws CustomException {
        return blstation.getStations4race(racePK);
    }
    
    public ArrayList<Station> get_station_with_foreignkey_evetype(IEvetypePK evetypePK) throws CustomException {
        return blstation.getStations4evetype(evetypePK);
    }
    
    public ArrayList<Station> get_station_with_foreignkey_system(ISystemPK systemPK) throws CustomException {
        return blstation.getStations4system(systemPK);
    }
    
    public Station get_station_with_externalforeignkey_station_service(IStation_servicePK station_servicePK) throws CustomException {
        return blstation.getStation_service(station_servicePK);
    }
    
    public ArrayList<Station> search_station(IStationsearch stationsearch) throws CustomException {
        return blstation.search(stationsearch);
    }
    
    public long search_station_count(IStationsearch stationsearch) throws CustomException {
        return blstation.searchcount(stationsearch);
    }

    public void secureinsertStation(IStation station) throws DBException, DataException {
        blstation.secureinsertStation(station);
    }

    public void secureupdateStation(IStation station) throws DBException, DataException {
        blstation.secureupdateStation(station);
    }

    public void securedeleteStation(IStation station) throws DBException, DataException {
        blstation.securedeleteStation(station);
    }
}

