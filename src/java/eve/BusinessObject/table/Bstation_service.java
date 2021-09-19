/*
 * Bstation_service.java
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
import eve.conversion.json.JSONStation_service;
import eve.data.ProjectConstants;
import eve.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.searchentity.IStation_servicesearch;
import eve.logicentity.Station_service;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Business Entity class Bstation_service
 *
 * Superclass for manipulating data- and database objects
 * for Entity Station_service and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bstation_service extends GeneralEntityObject implements ProjectConstants {

    /**
     * Constructor, sets Station_service as default Entity
     */
    public Bstation_service() {
        super(new SQLMapper_pgsql(connectionpool, "Station_service"), new Station_service());
    }

    /**
     * Constructor, sets Station_service as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Bstation_service(GeneralEntityInterface transactionobject) {
        super(transactionobject, new Station_service());
    }

    /**
     * Map ResultSet Field values to Station_service
     * @param dbresult: Database ResultSet
     */
    public Station_service mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Station_servicePK station_servicePK = null;
        Station_service station_service;
        if(dbresult==null) {
            station_service = new Station_service(station_servicePK);
        } else {
            try {
                station_servicePK = new Station_servicePK(dbresult.getLong("station"), dbresult.getString("service"));
                station_service = new Station_service(station_servicePK);
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        this.loadExtra(dbresult, station_service);
        return station_service;
    }

    /**
     * create new empty Station_service object
     * @return empty IStation_service
     */
    public IStation_service newStation_service() {
    	return new Station_service();
    }
    
    /**
     * create new empty Station_service object
     * create new primary key with given parameters
     * @return IStation_service with primary key
     */
    public IStation_service newStation_service(long station, java.lang.String service) {
        return new Station_service(station, service);
    }

    /**
     * create new empty Station_service object with given primary key
     * @param station_servicePK: primary key for Station_service
     * @return IStation_service with primary key
     */
    public IStation_service newStation_service(IStation_servicePK station_servicePK) {
        return new Station_service((Station_servicePK)station_servicePK);
    }

    /**
     * create new empty primary key
     * @return empty Station_servicePK
     */
    public IStation_servicePK newStation_servicePK() {
        return new Station_servicePK();
    }

    /**
     * create new primary key with given parameters
     * @return new IStation_servicePK
     */
    public IStation_servicePK newStation_servicePK(long station, java.lang.String service) {
        return new Station_servicePK(station, service);
    }

    /**
     * get all Station_service objects from database
     * @return ArrayList of Station_service objects
     * @throws DBException
     */
    public ArrayList getStation_services() throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Station_service.SQLSelectAll);
        } else return new ArrayList();
    }

    /**
     * search Station_service for primary key
     * @param station_servicePK: Station_service primary key
     * @return Station_service object
     * @throws DBException
     */
    public Station_service getStation_service(IStation_servicePK station_servicePK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return (Station_service)super.getEntity((Station_servicePK)station_servicePK);
        } else return null;
    }

    public ArrayList searchstation_services(IStation_servicesearch search) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return this.search(search);
        } else return new ArrayList();
    }

    public ArrayList searchstation_services(IStation_servicesearch search, String orderby) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return this.search(search, orderby);
        } else return new ArrayList();
    }

    /**
     * Search station_service in database for station_servicePK:
     * @param station_servicePK: Station_service Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getStation_serviceExists(IStation_servicePK station_servicePK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return super.getEntityExists((Station_servicePK)station_servicePK);
        } else return false;
    }

    /**
     * try to insert Station_service in database
     * @param film: Station_service object
     * @throws DBException
     */
    public void insertStation_service(IStation_service station_service) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.insertEntity(station_service);
        }
    }

    /**
     * check if Station_servicePK exists
     * insert if not, update if found
     * do not commit transaction
     * @param film: Station_service object
     * @throws DBException
     */
    public void insertupdateStation_service(IStation_service station_service) throws DBException, DataException {
        if(this.getStation_serviceExists(station_service.getPrimaryKey())) {
            super.updateEntity(station_service);
        } else {
            super.insertEntity(station_service);
        }
    }

    /**
     * try to update Station_service in database
     * @param film: Station_service object
     * @throws DBException
     */
    public void updateStation_service(IStation_service station_service) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.updateEntity(station_service);
        }
    }

    /**
     * try to delete Station_service in database
     * @param film: Station_service object
     * @throws DBException
     */
    public void deleteStation_service(IStation_service station_service) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            cascadedeleteStation_service(station_service.getOwnerobject(), station_service.getPrimaryKey());
            super.deleteEntity(station_service);
        }
    }

    /**
     * check data rules in Station_service, throw DataException with customized message if rules do not apply
     * @param film: Station_service object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(IStation_service station_service) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //foreign key Station_service.Station - Station.Id
        //Primary key
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where station_servicePK is used in a primary key
     * @param station_servicePK: Station_service primary key
     */
    public void cascadedeleteStation_service(String senderobject, IStation_servicePK station_servicePK) {
    }

    /**
     * @param stationPK: foreign key for Station
     * @delete all Station_service Entity objects for Station in database
     * @throws eve.general.exception.CustomException
     */
    public void delete4station(String senderobject, IStationPK stationPK) {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.addStatement(senderobject, Station_service.SQLDelete4station, stationPK.getKeyFields());
        }
    }

    /**
     * @param stationPK: foreign key for Station
     * @return all Station_service Entity objects for Station
     * @throws eve.general.exception.CustomException
     */
    public ArrayList getStation_services4station(IStationPK stationPK) throws CustomException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Station_service.SQLSelect4station, stationPK.getKeyFields());
        } else return new ArrayList();
    }

    /**
     * get all Station_service objects for sqlparameters
     * @return ArrayList of Station_service objects
     * @throws DBException
     */
    public ArrayList getStation_services(Object[][] sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        String sql =  Station_service.SQLSelect;
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
     * delete all Station_service objects for sqlparameters
     * @throws DBException
     */
    public void delStation_service(String senderobject, Object[][] sqlparameters, String andoroperator) throws DBException {
        String sql =  "Delete from " + Station_service.table;
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
