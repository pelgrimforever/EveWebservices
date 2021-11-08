/*
 * Bstation.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 8.10.2021 7:21
 *
 */

package eve.BusinessObject.table;

import BusinessObject.BLtable;
import general.exception.*;
import java.util.ArrayList;
import db.SQLMapperFactory;
import db.SQLparameters;
import data.gis.shape.*;
import data.json.piJson;
import data.json.psqlJsonobject;
import db.SQLMapper_pgsql;
import data.interfaces.db.Filedata;
import eve.BusinessObject.Logic.*;
import eve.conversion.json.JSONStation;
import eve.conversion.entity.EMstation;
import eve.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.searchentity.IStationsearch;
import eve.logicentity.Station;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Business Entity class Bstation
 *
 * Superclass for manipulating data- and database objects
 * for Entity Station and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bstation extends BLtable {

    /**
     * Constructor, sets Station as default Entity
     */
    public Bstation() {
        super(new Station(), new EMstation());
    }

    /**
     * Constructor, sets Station as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Bstation(BLtable transactionobject) {
        super(transactionobject, new Station(), new EMstation());
    }

    /**
     * create new empty Station object
     * @return empty IStation
     */
    public IStation newStation() {
    	return new Station();
    }
    
    /**
     * create new empty Station object
     * create new primary key with given parameters
     * @param id primary key field
     * @return IStation with primary key
     */
    public IStation newStation(long id) {
        return new Station(id);
    }

    /**
     * create new empty Station object with given primary key
     * @param stationPK: primary key for Station
     * @return IStation with primary key
     */
    public IStation newStation(IStationPK stationPK) {
        return new Station((StationPK)stationPK);
    }

    /**
     * create new empty primary key
     * @return empty StationPK
     */
    public IStationPK newStationPK() {
        return new StationPK();
    }

    /**
     * create new primary key with given parameters
     * @param id primary key field
     * @return new IStationPK
     */
    public IStationPK newStationPK(long id) {
        return new StationPK(id);
    }

    /**
     * get all Station objects from database
     * @return ArrayList of Station objects
     * @throws DBException
     */
    public ArrayList<Station> getStations() throws DBException {
        return (ArrayList<Station>)super.getEntities(EMstation.SQLSelectAll);
    }

    /**
     * search Station for primary key
     * @param stationPK: Station primary key
     * @return Station object
     * @throws DBException
     */
    public Station getStation(IStationPK stationPK) throws DBException {
        return (Station)super.getEntity((StationPK)stationPK);
    }

    /**
     * search station with IStationsearch parameters
     * @param search IStationsearch
     * @return ArrayList of Station
     * @throws DBException 
     */
    public ArrayList<Station> searchstations(IStationsearch search) throws DBException {
        return (ArrayList<Station>)this.search(search);
    }

    /**
     * search station with IStationsearch parameters, order by orderby sql clause
     * @param search IStationsearch
     * @param orderby sql order by string
     * @return ArrayList of Station
     * @throws DBException 
     */
    public ArrayList<Station> searchstations(IStationsearch search, String orderby) throws DBException {
        return (ArrayList<Station>)this.search(search, orderby);
    }

    /**
     * Search station in database for stationPK:
     * @param stationPK: Station Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getStationExists(IStationPK stationPK) throws DBException {
        return super.getEntityExists((StationPK)stationPK);
    }

    /**
     * try to insert Station in database
     * @param station Station object
     * @throws DBException
     * @throws DataException
     */
    public void insertStation(IStation station) throws DBException, DataException {
        super.insertEntity(station);
    }

    /**
     * check if StationPK exists
     * insert if not, update if found
     * do not commit transaction
     * @param station Station object
     * @throws DBException
     * @throws DataException
     */
    public void insertupdateStation(IStation station) throws DBException, DataException {
        if(this.getStationExists(station.getPrimaryKey())) {
            super.updateEntity(station);
        } else {
            super.insertEntity(station);
        }
    }

    /**
     * try to update Station in database
     * @param station Station object
     * @throws DBException
     * @throws DataException
     */
    public void updateStation(IStation station) throws DBException, DataException {
        super.updateEntity(station);
    }

    /**
     * try to delete Station in database
     * @param station Station object
     * @throws DBException
     */
    public void deleteStation(IStation station) throws DBException {
        cascadedeleteStation(station.getPrimaryKey());
        super.deleteEntity(station);
    }

    /**
     * check data rules in Station, throw DataException with customized message if rules do not apply
     * @param station Station object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(IStation station) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //Primary key
        if(station.getName()!=null && station.getName().length()>IStation.SIZE_NAME) {
            message.append("Name is langer dan toegestaan. Max aantal karakters: ").append(IStation.SIZE_NAME).append("\n");
        }
        if(station.getName()==null) {
            message.append("Name mag niet leeg zijn.\n");
        }
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where stationPK is used in a primary key
     * @param stationPK: Station primary key
     */
    public void cascadedeleteStation(IStationPK stationPK) {
        BLstation_service blstation_service = new BLstation_service(this);
        blstation_service.delete4station(stationPK);
    }

    /**
     * @param racePK: foreign key for Race
     * @delete all Station Entity objects for Race in database
     */
    public void delete4race(IRacePK racePK) {
        super.addStatement(EMstation.SQLDelete4race, racePK.getSQLprimarykey());
    }

    /**
     * @param racePK: foreign key for Race
     * @return all Station Entity objects for Race
     * @throws CustomException
     */
    public ArrayList<Station> getStations4race(IRacePK racePK) throws CustomException {
        return super.getEntities(EMstation.SQLSelect4race, racePK.getSQLprimarykey());
    }
    /**
     * @param evetypePK: foreign key for Evetype
     * @delete all Station Entity objects for Evetype in database
     */
    public void delete4evetype(IEvetypePK evetypePK) {
        super.addStatement(EMstation.SQLDelete4evetype, evetypePK.getSQLprimarykey());
    }

    /**
     * @param evetypePK: foreign key for Evetype
     * @return all Station Entity objects for Evetype
     * @throws CustomException
     */
    public ArrayList<Station> getStations4evetype(IEvetypePK evetypePK) throws CustomException {
        return super.getEntities(EMstation.SQLSelect4evetype, evetypePK.getSQLprimarykey());
    }
    /**
     * @param systemPK: foreign key for System
     * @delete all Station Entity objects for System in database
     */
    public void delete4system(ISystemPK systemPK) {
        super.addStatement(EMstation.SQLDelete4system, systemPK.getSQLprimarykey());
    }

    /**
     * @param systemPK: foreign key for System
     * @return all Station Entity objects for System
     * @throws CustomException
     */
    public ArrayList<Station> getStations4system(ISystemPK systemPK) throws CustomException {
        return super.getEntities(EMstation.SQLSelect4system, systemPK.getSQLprimarykey());
    }
    /**
     * @param station_servicePK: parent Station_service for child object Station Entity
     * @return child Station Entity object
     * @throws CustomException
     */
    public Station getStation_service(IStation_servicePK station_servicePK) throws CustomException {
        StationPK stationPK = new StationPK(station_servicePK.getStation());
        return this.getStation(stationPK);
    }


    /**
     * get all Station objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @param sortlist sql sort string
     * @param sortoperator asc/desc
     * @return ArrayList of Station objects
     * @throws DBException
     */
    public ArrayList<Station> getStations(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMstation.SQLSelect);
        ArrayList<Object[]> parameters = sqlparameters.getParameters();
        int l = parameters.size();
        if(l>0) {
            sql.append(" where ");
            for(int i=0; i<l; i++) {
                sql.append(String.valueOf(parameters.get(i)[0])).append(" = :").append(String.valueOf(parameters.get(i)[0])).append(": ");
                if(i<l-1) sql.append(" ").append(andoroperator).append(" ");
            }
        }
        if(sortlist.length()>0) {
            sql.append(" order by ").append(sortlist).append(" ").append(sortoperator);
        }
        return (ArrayList<Station>)super.getEntities(sql.toString(), sqlparameters);
    }

    /**
     * delete all Station objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @throws DBException
     */
    public void delStation(SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Station.table);
        ArrayList<Object[]> parameters = sqlparameters.getParameters();
        int l = parameters.size();
        if(l>0) {
            sql.append(" where ");
            for(int i=0; i<l; i++) {
                sql.append(String.valueOf(parameters.get(i)[0])).append(" = :").append(String.valueOf(parameters.get(i)[0])).append(": ");
                if(i<l-1) sql.append(" ").append(andoroperator).append(" ");
            }
        }
        this.addStatement(sql.toString(), sqlparameters);
    }


}
