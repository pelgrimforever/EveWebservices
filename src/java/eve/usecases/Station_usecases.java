/*
 * Generated on 23.8.2022 14:38
 * @author Franky Laseure
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
import eve.logicentity.Station;
import eve.logicview.*;
import eve.usecases.custom.*;
import general.exception.*;
import java.sql.Date;
import java.io.*;
import java.util.*;
import java.io.IOException;
import org.json.simple.parser.ParseException;

public class Station_usecases {

    private boolean loggedin = false;
    private SQLreader sqlreader = new SQLreader();
    private SQLTwriter sqlwriter = new SQLTwriter();
    private BLstation blstation = new BLstation(sqlreader);
    
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
        return blstation.getStationExists(stationPK);
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

    public void insertStation(IStation station) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blstation.insertStation(tq, station);
        sqlwriter.Commit2DB(tq);
    }

    public void updateStation(IStation station) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blstation.updateStation(tq, station);
        sqlwriter.Commit2DB(tq);
    }

    public void deleteStation(IStation station) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blstation.deleteStation(tq, station);
        sqlwriter.Commit2DB(tq);
    }

    public void delete_all_containing_Race(IRacePK racePK) throws CustomException {
        SQLTqueue tq = new SQLTqueue();
        blstation.delete4race(tq, racePK);
        sqlwriter.Commit2DB(tq);
    }
    
    public void delete_all_containing_Evetype(IEvetypePK evetypePK) throws CustomException {
        SQLTqueue tq = new SQLTqueue();
        blstation.delete4evetype(tq, evetypePK);
        sqlwriter.Commit2DB(tq);
    }
    
    public void delete_all_containing_System(ISystemPK systemPK) throws CustomException {
        SQLTqueue tq = new SQLTqueue();
        blstation.delete4system(tq, systemPK);
        sqlwriter.Commit2DB(tq);
    }
    
}

