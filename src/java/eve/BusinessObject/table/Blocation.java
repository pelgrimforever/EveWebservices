/*
 * Blocation.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 4.11.2021 14:51
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
import eve.conversion.json.JSONLocation;
import eve.conversion.entity.EMlocation;
import eve.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.searchentity.ILocationsearch;
import eve.logicentity.Location;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Business Entity class Blocation
 *
 * Superclass for manipulating data- and database objects
 * for Entity Location and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Blocation extends BLtable {

    /**
     * Constructor, sets Location as default Entity
     */
    public Blocation() {
        super(new Location(), new EMlocation());
    }

    /**
     * Constructor, sets Location as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Blocation(BLtable transactionobject) {
        super(transactionobject, new Location(), new EMlocation());
    }

    /**
     * create new empty Location object
     * @return empty ILocation
     */
    public ILocation newLocation() {
    	return new Location();
    }
    
    /**
     * create new empty Location object
     * create new primary key with given parameters
     * @param id primary key field
     * @return ILocation with primary key
     */
    public ILocation newLocation(long id) {
        return new Location(id);
    }

    /**
     * create new empty Location object with given primary key
     * @param locationPK: primary key for Location
     * @return ILocation with primary key
     */
    public ILocation newLocation(ILocationPK locationPK) {
        return new Location((LocationPK)locationPK);
    }

    /**
     * create new empty primary key
     * @return empty LocationPK
     */
    public ILocationPK newLocationPK() {
        return new LocationPK();
    }

    /**
     * create new primary key with given parameters
     * @param id primary key field
     * @return new ILocationPK
     */
    public ILocationPK newLocationPK(long id) {
        return new LocationPK(id);
    }

    /**
     * get all Location objects from database
     * @return ArrayList of Location objects
     * @throws DBException
     */
    public ArrayList<Location> getLocations() throws DBException {
        return (ArrayList<Location>)super.getEntities(EMlocation.SQLSelectAll);
    }

    /**
     * search Location for primary key
     * @param locationPK: Location primary key
     * @return Location object
     * @throws DBException
     */
    public Location getLocation(ILocationPK locationPK) throws DBException {
        return (Location)super.getEntity((LocationPK)locationPK);
    }

    /**
     * search location with ILocationsearch parameters
     * @param search ILocationsearch
     * @return ArrayList of Location
     * @throws DBException 
     */
    public ArrayList<Location> searchlocations(ILocationsearch search) throws DBException {
        return (ArrayList<Location>)this.search(search);
    }

    /**
     * search location with ILocationsearch parameters, order by orderby sql clause
     * @param search ILocationsearch
     * @param orderby sql order by string
     * @return ArrayList of Location
     * @throws DBException 
     */
    public ArrayList<Location> searchlocations(ILocationsearch search, String orderby) throws DBException {
        return (ArrayList<Location>)this.search(search, orderby);
    }

    /**
     * Search location in database for locationPK:
     * @param locationPK: Location Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getLocationExists(ILocationPK locationPK) throws DBException {
        return super.getEntityExists((LocationPK)locationPK);
    }

    /**
     * try to insert Location in database
     * @param location Location object
     * @throws DBException
     * @throws DataException
     */
    public void insertLocation(ILocation location) throws DBException, DataException {
        super.insertEntity(location);
    }

    /**
     * check if LocationPK exists
     * insert if not, update if found
     * do not commit transaction
     * @param location Location object
     * @throws DBException
     * @throws DataException
     */
    public void insertupdateLocation(ILocation location) throws DBException, DataException {
        if(this.getLocationExists(location.getPrimaryKey())) {
            super.updateEntity(location);
        } else {
            super.insertEntity(location);
        }
    }

    /**
     * try to update Location in database
     * @param location Location object
     * @throws DBException
     * @throws DataException
     */
    public void updateLocation(ILocation location) throws DBException, DataException {
        super.updateEntity(location);
    }

    /**
     * try to delete Location in database
     * @param location Location object
     * @throws DBException
     */
    public void deleteLocation(ILocation location) throws DBException {
        cascadedeleteLocation(location.getPrimaryKey());
        super.deleteEntity(location);
    }

    /**
     * check data rules in Location, throw DataException with customized message if rules do not apply
     * @param location Location object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(ILocation location) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //Primary key
        if(location.getName()!=null && location.getName().length()>ILocation.SIZE_NAME) {
            message.append("Name is langer dan toegestaan. Max aantal karakters: ").append(ILocation.SIZE_NAME).append("\n");
        }
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where locationPK is used in a primary key
     * @param locationPK: Location primary key
     */
    public void cascadedeleteLocation(ILocationPK locationPK) {
    }

    /**
     * @param systemPK: foreign key for System
     * @delete all Location Entity objects for System in database
     */
    public void delete4system(ISystemPK systemPK) {
        super.addStatement(EMlocation.SQLDelete4system, systemPK.getSQLprimarykey());
    }

    /**
     * @param systemPK: foreign key for System
     * @return all Location Entity objects for System
     * @throws CustomException
     */
    public ArrayList<Location> getLocations4system(ISystemPK systemPK) throws CustomException {
        return super.getEntities(EMlocation.SQLSelect4system, systemPK.getSQLprimarykey());
    }

    /**
     * get all Location objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @param sortlist sql sort string
     * @param sortoperator asc/desc
     * @return ArrayList of Location objects
     * @throws DBException
     */
    public ArrayList<Location> getLocations(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMlocation.SQLSelect);
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
        return (ArrayList<Location>)super.getEntities(sql.toString(), sqlparameters);
    }

    /**
     * delete all Location objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @throws DBException
     */
    public void delLocation(SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Location.table);
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
