/*
 * Bstation_service.java
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
import eve.conversion.json.JSONStation_service;
import eve.conversion.entity.EMstation_service;
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
public abstract class Bstation_service extends BLtable {

    /**
     * Constructor, sets Station_service as default Entity
     */
    public Bstation_service() {
        super(new Station_service(), new EMstation_service());
    }

    /**
     * Constructor, sets Station_service as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Bstation_service(BLtable transactionobject) {
        super(transactionobject, new Station_service(), new EMstation_service());
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
     * @param station primary key field
     * @param service primary key field
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
     * @param station primary key field
     * @param service primary key field
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
    public ArrayList<Station_service> getStation_services() throws DBException {
        return (ArrayList<Station_service>)super.getEntities(EMstation_service.SQLSelectAll);
    }

    /**
     * search Station_service for primary key
     * @param station_servicePK: Station_service primary key
     * @return Station_service object
     * @throws DBException
     */
    public Station_service getStation_service(IStation_servicePK station_servicePK) throws DBException {
        return (Station_service)super.getEntity((Station_servicePK)station_servicePK);
    }

    /**
     * search station_service with IStation_servicesearch parameters
     * @param search IStation_servicesearch
     * @return ArrayList of Station_service
     * @throws DBException 
     */
    public ArrayList<Station_service> searchstation_services(IStation_servicesearch search) throws DBException {
        return (ArrayList<Station_service>)this.search(search);
    }

    /**
     * search station_service with IStation_servicesearch parameters, order by orderby sql clause
     * @param search IStation_servicesearch
     * @param orderby sql order by string
     * @return ArrayList of Station_service
     * @throws DBException 
     */
    public ArrayList<Station_service> searchstation_services(IStation_servicesearch search, String orderby) throws DBException {
        return (ArrayList<Station_service>)this.search(search, orderby);
    }

    /**
     * Search station_service in database for station_servicePK:
     * @param station_servicePK: Station_service Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getStation_serviceExists(IStation_servicePK station_servicePK) throws DBException {
        return super.getEntityExists((Station_servicePK)station_servicePK);
    }

    /**
     * try to insert Station_service in database
     * @param station_service Station_service object
     * @throws DBException
     * @throws DataException
     */
    public void insertStation_service(IStation_service station_service) throws DBException, DataException {
        super.insertEntity(station_service);
    }

    /**
     * check if Station_servicePK exists
     * insert if not, update if found
     * do not commit transaction
     * @param station_service Station_service object
     * @throws DBException
     * @throws DataException
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
     * @param station_service Station_service object
     * @throws DBException
     * @throws DataException
     */
    public void updateStation_service(IStation_service station_service) throws DBException, DataException {
        super.updateEntity(station_service);
    }

    /**
     * try to delete Station_service in database
     * @param station_service Station_service object
     * @throws DBException
     */
    public void deleteStation_service(IStation_service station_service) throws DBException {
        cascadedeleteStation_service(station_service.getPrimaryKey());
        super.deleteEntity(station_service);
    }

    /**
     * check data rules in Station_service, throw DataException with customized message if rules do not apply
     * @param station_service Station_service object
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
    public void cascadedeleteStation_service(IStation_servicePK station_servicePK) {
    }

    /**
     * @param stationPK: foreign key for Station
     * @delete all Station_service Entity objects for Station in database
     */
    public void delete4station(IStationPK stationPK) {
        super.addStatement(EMstation_service.SQLDelete4station, stationPK.getSQLprimarykey());
    }

    /**
     * @param stationPK: foreign key for Station
     * @return all Station_service Entity objects for Station
     * @throws CustomException
     */
    public ArrayList<Station_service> getStation_services4station(IStationPK stationPK) throws CustomException {
        return super.getEntities(EMstation_service.SQLSelect4station, stationPK.getSQLprimarykey());
    }

    /**
     * get all Station_service objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @param sortlist sql sort string
     * @param sortoperator asc/desc
     * @return ArrayList of Station_service objects
     * @throws DBException
     */
    public ArrayList<Station_service> getStation_services(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMstation_service.SQLSelect);
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
        return (ArrayList<Station_service>)super.getEntities(sql.toString(), sqlparameters);
    }

    /**
     * delete all Station_service objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @throws DBException
     */
    public void delStation_service(SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Station_service.table);
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
