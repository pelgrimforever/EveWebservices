/*
 * Bstation.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 18.8.2021 11:31
 *
 */

package eve.BusinessObject.table;

import BusinessObject.GeneralEntityInterface;
import BusinessObject.GeneralEntityObject;
import general.exception.*;
import java.util.ArrayList;

import data.gis.shape.*;
import data.json.piJson;
import data.json.psqlJsonobject;
import db.SQLMapper_pgsql;
import data.interfaces.db.Filedata;
import eve.BusinessObject.Logic.*;
import eve.conversion.json.JSONStation;
import eve.data.ProjectConstants;
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
public abstract class Bstation extends GeneralEntityObject implements ProjectConstants {

    /**
     * Constructor, sets Station as default Entity
     */
    public Bstation() {
        super(new SQLMapper_pgsql(connectionpool, "Station"), new Station());
    }

    /**
     * Constructor, sets Station as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Bstation(GeneralEntityInterface transactionobject) {
        super(transactionobject, new Station());
    }

    /**
     * Map ResultSet Field values to Station
     * @param dbresult: Database ResultSet
     */
    public Station mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        StationPK stationPK = null;
        Station station;
        if(dbresult==null) {
            station = new Station(stationPK);
        } else {
            try {
                stationPK = new StationPK(dbresult.getLong("id"));
                station = new Station(stationPK);
                station.initRacePK(new RacePK(dbresult.getLong("race_id")));
                if(dbresult.wasNull()) station.setRacePK(null);                
                station.initEvetypePK(new EvetypePK(dbresult.getLong("type_id")));
                if(dbresult.wasNull()) station.setEvetypePK(null);                
                station.initSystemPK(new SystemPK(dbresult.getLong("system_id")));
                if(dbresult.wasNull()) station.setSystemPK(null);                
                station.initName(dbresult.getString("name"));
                station.initOffice_rental_cost(dbresult.getDouble("office_rental_cost"));
                station.initReprocessing_efficiency(dbresult.getDouble("reprocessing_efficiency"));
                station.initReprocessing_stations_take(dbresult.getDouble("reprocessing_stations_take"));
                station.initMax_dockable_ship_volume(dbresult.getDouble("max_dockable_ship_volume"));
                station.initOwner(dbresult.getLong("owner"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        this.loadExtra(dbresult, station);
        return station;
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
    public ArrayList getStations() throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Station.SQLSelectAll);
        } else return new ArrayList();
    }

    /**
     * search Station for primary key
     * @param stationPK: Station primary key
     * @return Station object
     * @throws DBException
     */
    public Station getStation(IStationPK stationPK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return (Station)super.getEntity((StationPK)stationPK);
        } else return null;
    }

    public ArrayList searchstations(IStationsearch search) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return this.search(search);
        } else return new ArrayList();
    }

    public ArrayList searchstations(IStationsearch search, String orderby) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return this.search(search, orderby);
        } else return new ArrayList();
    }

    /**
     * Search station in database for stationPK:
     * @param stationPK: Station Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getStationExists(IStationPK stationPK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return super.getEntityExists((StationPK)stationPK);
        } else return false;
    }

    /**
     * try to insert Station in database
     * @param film: Station object
     * @throws DBException
     */
    public void insertStation(IStation station) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.insertEntity(station);
        }
    }

    /**
     * check if StationPK exists
     * insert if not, update if found
     * do not commit transaction
     * @param film: Station object
     * @throws DBException
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
     * @param film: Station object
     * @throws DBException
     */
    public void updateStation(IStation station) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.updateEntity(station);
        }
    }

    /**
     * try to delete Station in database
     * @param film: Station object
     * @throws DBException
     */
    public void deleteStation(IStation station) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            cascadedeleteStation(station.getOwnerobject(), station.getPrimaryKey());
            super.deleteEntity(station);
        }
    }

    /**
     * check data rules in Station, throw DataException with customized message if rules do not apply
     * @param film: Station object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(IStation station) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //Primary key



        if(station.getName()!=null && station.getName().length()>IStation.SIZE_NAME) {
            message.append("Name is langer dan toegestaan. Max aantal karakters: " + IStation.SIZE_NAME + "\n");
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
    public void cascadedeleteStation(String senderobject, IStationPK stationPK) {
        BLstation_service blstation_service = new BLstation_service(this);
        blstation_service.delete4station(senderobject, stationPK);
    }

    /**
     * @param racePK: foreign key for Race
     * @delete all Station Entity objects for Race in database
     * @throws eve.general.exception.CustomException
     */
    public void delete4race(String senderobject, IRacePK racePK) {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.addStatement(senderobject, Station.SQLDelete4race, racePK.getKeyFields());
        }
    }

    /**
     * @param racePK: foreign key for Race
     * @return all Station Entity objects for Race
     * @throws eve.general.exception.CustomException
     */
    public ArrayList getStations4race(IRacePK racePK) throws CustomException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Station.SQLSelect4race, racePK.getKeyFields());
        } else return new ArrayList();
    }
    /**
     * @param evetypePK: foreign key for Evetype
     * @delete all Station Entity objects for Evetype in database
     * @throws eve.general.exception.CustomException
     */
    public void delete4evetype(String senderobject, IEvetypePK evetypePK) {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.addStatement(senderobject, Station.SQLDelete4evetype, evetypePK.getKeyFields());
        }
    }

    /**
     * @param evetypePK: foreign key for Evetype
     * @return all Station Entity objects for Evetype
     * @throws eve.general.exception.CustomException
     */
    public ArrayList getStations4evetype(IEvetypePK evetypePK) throws CustomException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Station.SQLSelect4evetype, evetypePK.getKeyFields());
        } else return new ArrayList();
    }
    /**
     * @param systemPK: foreign key for System
     * @delete all Station Entity objects for System in database
     * @throws eve.general.exception.CustomException
     */
    public void delete4system(String senderobject, ISystemPK systemPK) {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.addStatement(senderobject, Station.SQLDelete4system, systemPK.getKeyFields());
        }
    }

    /**
     * @param systemPK: foreign key for System
     * @return all Station Entity objects for System
     * @throws eve.general.exception.CustomException
     */
    public ArrayList getStations4system(ISystemPK systemPK) throws CustomException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Station.SQLSelect4system, systemPK.getKeyFields());
        } else return new ArrayList();
    }
    /**
     * @param station_servicePK: parent Station_service for child object Station Entity
     * @return child Station Entity object
     * @throws eve.general.exception.CustomException
     */
    public IStation getStation_service(IStation_servicePK station_servicePK) throws CustomException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            StationPK stationPK = new StationPK(station_servicePK.getStation());
            return this.getStation(stationPK);
        } else return null;
    }


    /**
     * get all Station objects for sqlparameters
     * @return ArrayList of Station objects
     * @throws DBException
     */
    public ArrayList getStations(Object[][] sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        String sql =  Station.SQLSelect;
        int l = sqlparameters.length;
        if(sqlparameters.length>0) {
            sql += " where ";
            for(int i=0; i<l; i++) {
                sql += String.valueOf(sqlparameters[i][0]) + " = :" + String.valueOf(sqlparameters[i][0]) + ": ";
                if(i<l-1) sql += " " + andoroperator + " ";
            }
        }
        if(sortlist.length()>0) {
            sql += " order by " + sortlist + " " + sortoperator;
        }
        return getMapper().loadEntityVector(this, sql, sqlparameters);
    }

    /**
     * delete all Station objects for sqlparameters
     * @throws DBException
     */
    public void delStation(String senderobject, Object[][] sqlparameters, String andoroperator) throws DBException {
        String sql =  "Delete from " + Station.table;
        int l = sqlparameters.length;
        if(sqlparameters.length>0) {
            sql += " where ";
            for(int i=0; i<l; i++) {
                sql += String.valueOf(sqlparameters[i][0]) + " = :" + String.valueOf(sqlparameters[i][0]) + ": ";
                if(i<l-1) sql += " " + andoroperator + " ";
            }
        }
        this.addStatement(senderobject, sql, sqlparameters);
    }


}
