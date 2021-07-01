/*
 * Blocation.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 30.5.2021 15:39
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
import eve.conversion.json.JSONLocation;
import eve.data.ProjectConstants;
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
public abstract class Blocation extends GeneralEntityObject implements ProjectConstants {

    /**
     * Constructor, sets Location as default Entity
     */
    public Blocation() {
        super(new SQLMapper_pgsql(connectionpool, "Location"), new Location());
    }

    /**
     * Constructor, sets Location as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Blocation(GeneralEntityInterface transactionobject) {
        super(transactionobject, new Location());
    }

    /**
     * Map ResultSet Field values to Location
     * @param dbresult: Database ResultSet
     */
    public Location mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        LocationPK locationPK = null;
        Location location;
        if(dbresult==null) {
            location = new Location(locationPK);
        } else {
            try {
                locationPK = new LocationPK(dbresult.getLong("id"));
                location = new Location(locationPK);
                location.initSystemPK(new SystemPK(dbresult.getLong("system")));
                if(dbresult.wasNull()) location.setSystemPK(null);                
                location.initName(dbresult.getString("name"));
                location.initVisited(dbresult.getBoolean("visited"));
                location.initAccess(dbresult.getBoolean("access"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        this.loadExtra(dbresult, location);
        return location;
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
    public ArrayList getLocations() throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Location.SQLSelectAll);
        } else return new ArrayList();
    }

    /**
     * search Location for primary key
     * @param locationPK: Location primary key
     * @return Location object
     * @throws DBException
     */
    public Location getLocation(ILocationPK locationPK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return (Location)super.getEntity((LocationPK)locationPK);
        } else return null;
    }

    public ArrayList searchlocations(ILocationsearch search) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return this.search(search);
        } else return new ArrayList();
    }

    public ArrayList searchlocations(ILocationsearch search, String orderby) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return this.search(search, orderby);
        } else return new ArrayList();
    }

    /**
     * Search location in database for locationPK:
     * @param locationPK: Location Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getLocationExists(ILocationPK locationPK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return super.getEntityExists((LocationPK)locationPK);
        } else return false;
    }

    /**
     * try to insert Location in database
     * @param film: Location object
     * @throws DBException
     */
    public void insertLocation(ILocation location) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.insertEntity(location);
        }
    }

    /**
     * check if LocationPK exists
     * insert if not, update if found
     * do not commit transaction
     * @param film: Location object
     * @throws DBException
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
     * @param film: Location object
     * @throws DBException
     */
    public void updateLocation(ILocation location) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.updateEntity(location);
        }
    }

    /**
     * try to delete Location in database
     * @param film: Location object
     * @throws DBException
     */
    public void deleteLocation(ILocation location) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            cascadedeleteLocation(location.getOwnerobject(), location.getPrimaryKey());
            super.deleteEntity(location);
        }
    }

    /**
     * check data rules in Location, throw DataException with customized message if rules do not apply
     * @param film: Location object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(ILocation location) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //Primary key

        if(location.getName()!=null && location.getName().length()>ILocation.SIZE_NAME) {
            message.append("Name is langer dan toegestaan. Max aantal karakters: " + ILocation.SIZE_NAME + "\n");
        }
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where locationPK is used in a primary key
     * @param locationPK: Location primary key
     */
    public void cascadedeleteLocation(String senderobject, ILocationPK locationPK) {
    }

    /**
     * @param systemPK: foreign key for System
     * @delete all Location Entity objects for System in database
     * @throws eve.general.exception.CustomException
     */
    public void delete4system(String senderobject, ISystemPK systemPK) {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.addStatement(senderobject, Location.SQLDelete4system, systemPK.getKeyFields());
        }
    }

    /**
     * @param systemPK: foreign key for System
     * @return all Location Entity objects for System
     * @throws eve.general.exception.CustomException
     */
    public ArrayList getLocations4system(ISystemPK systemPK) throws CustomException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Location.SQLSelect4system, systemPK.getKeyFields());
        } else return new ArrayList();
    }

    /**
     * get all Location objects for sqlparameters
     * @return ArrayList of Location objects
     * @throws DBException
     */
    public ArrayList getLocations(Object[][] sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        String sql =  Location.SQLSelect;
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
     * delete all Location objects for sqlparameters
     * @throws DBException
     */
    public void delLocation(String senderobject, Object[][] sqlparameters, String andoroperator) throws DBException {
        String sql =  "Delete from " + Location.table;
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
