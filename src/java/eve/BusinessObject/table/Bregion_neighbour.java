/*
 * Bregion_neighbour.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 12.6.2021 13:57
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
import eve.conversion.json.JSONRegion_neighbour;
import eve.data.ProjectConstants;
import eve.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.searchentity.IRegion_neighboursearch;
import eve.logicentity.Region_neighbour;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Business Entity class Bregion_neighbour
 *
 * Superclass for manipulating data- and database objects
 * for Entity Region_neighbour and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bregion_neighbour extends GeneralEntityObject implements ProjectConstants {

    /**
     * Constructor, sets Region_neighbour as default Entity
     */
    public Bregion_neighbour() {
        super(new SQLMapper_pgsql(connectionpool, "Region_neighbour"), new Region_neighbour());
    }

    /**
     * Constructor, sets Region_neighbour as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Bregion_neighbour(GeneralEntityInterface transactionobject) {
        super(transactionobject, new Region_neighbour());
    }

    /**
     * Map ResultSet Field values to Region_neighbour
     * @param dbresult: Database ResultSet
     */
    public Region_neighbour mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Region_neighbourPK region_neighbourPK = null;
        Region_neighbour region_neighbour;
        if(dbresult==null) {
            region_neighbour = new Region_neighbour(region_neighbourPK);
        } else {
            try {
                region_neighbourPK = new Region_neighbourPK(dbresult.getLong("region"), dbresult.getLong("neighbour"));
                region_neighbour = new Region_neighbour(region_neighbourPK);
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        this.loadExtra(dbresult, region_neighbour);
        return region_neighbour;
    }

    /**
     * create new empty Region_neighbour object
     * @return empty IRegion_neighbour
     */
    public IRegion_neighbour newRegion_neighbour() {
    	return new Region_neighbour();
    }
    
    /**
     * create new empty Region_neighbour object
     * create new primary key with given parameters
     * @return IRegion_neighbour with primary key
     */
    public IRegion_neighbour newRegion_neighbour(long region, long neighbour) {
        return new Region_neighbour(region, neighbour);
    }

    /**
     * create new empty Region_neighbour object with given primary key
     * @param region_neighbourPK: primary key for Region_neighbour
     * @return IRegion_neighbour with primary key
     */
    public IRegion_neighbour newRegion_neighbour(IRegion_neighbourPK region_neighbourPK) {
        return new Region_neighbour((Region_neighbourPK)region_neighbourPK);
    }

    /**
     * create new empty primary key
     * @return empty Region_neighbourPK
     */
    public IRegion_neighbourPK newRegion_neighbourPK() {
        return new Region_neighbourPK();
    }

    /**
     * create new primary key with given parameters
     * @return new IRegion_neighbourPK
     */
    public IRegion_neighbourPK newRegion_neighbourPK(long region, long neighbour) {
        return new Region_neighbourPK(region, neighbour);
    }

    /**
     * get all Region_neighbour objects from database
     * @return ArrayList of Region_neighbour objects
     * @throws DBException
     */
    public ArrayList getRegion_neighbours() throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Region_neighbour.SQLSelectAll);
        } else return new ArrayList();
    }

    /**
     * search Region_neighbour for primary key
     * @param region_neighbourPK: Region_neighbour primary key
     * @return Region_neighbour object
     * @throws DBException
     */
    public Region_neighbour getRegion_neighbour(IRegion_neighbourPK region_neighbourPK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return (Region_neighbour)super.getEntity((Region_neighbourPK)region_neighbourPK);
        } else return null;
    }

    public ArrayList searchregion_neighbours(IRegion_neighboursearch search) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return this.search(search);
        } else return new ArrayList();
    }

    public ArrayList searchregion_neighbours(IRegion_neighboursearch search, String orderby) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return this.search(search, orderby);
        } else return new ArrayList();
    }

    /**
     * Search region_neighbour in database for region_neighbourPK:
     * @param region_neighbourPK: Region_neighbour Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getRegion_neighbourExists(IRegion_neighbourPK region_neighbourPK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return super.getEntityExists((Region_neighbourPK)region_neighbourPK);
        } else return false;
    }

    /**
     * try to insert Region_neighbour in database
     * @param film: Region_neighbour object
     * @throws DBException
     */
    public void insertRegion_neighbour(IRegion_neighbour region_neighbour) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.insertEntity(region_neighbour);
        }
    }

    /**
     * check if Region_neighbourPK exists
     * insert if not, update if found
     * do not commit transaction
     * @param film: Region_neighbour object
     * @throws DBException
     */
    public void insertupdateRegion_neighbour(IRegion_neighbour region_neighbour) throws DBException, DataException {
        if(this.getRegion_neighbourExists(region_neighbour.getPrimaryKey())) {
            super.updateEntity(region_neighbour);
        } else {
            super.insertEntity(region_neighbour);
        }
    }

    /**
     * try to update Region_neighbour in database
     * @param film: Region_neighbour object
     * @throws DBException
     */
    public void updateRegion_neighbour(IRegion_neighbour region_neighbour) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.updateEntity(region_neighbour);
        }
    }

    /**
     * try to delete Region_neighbour in database
     * @param film: Region_neighbour object
     * @throws DBException
     */
    public void deleteRegion_neighbour(IRegion_neighbour region_neighbour) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            cascadedeleteRegion_neighbour(region_neighbour.getOwnerobject(), region_neighbour.getPrimaryKey());
            super.deleteEntity(region_neighbour);
        }
    }

    /**
     * check data rules in Region_neighbour, throw DataException with customized message if rules do not apply
     * @param film: Region_neighbour object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(IRegion_neighbour region_neighbour) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //foreign key Region_neighbour.Region - Region.Id
        //foreign key Region_neighbour.Neighbour - Region.Id
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where region_neighbourPK is used in a primary key
     * @param region_neighbourPK: Region_neighbour primary key
     */
    public void cascadedeleteRegion_neighbour(String senderobject, IRegion_neighbourPK region_neighbourPK) {
    }

    /**
     * @param regionPK: foreign key for Region
     * @delete all Region_neighbour Entity objects for Region in database
     * @throws eve.general.exception.CustomException
     */
    public void delete4regionRegion(String senderobject, IRegionPK regionPK) {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.addStatement(senderobject, Region_neighbour.SQLDelete4regionRegion, regionPK.getKeyFields());
        }
    }

    /**
     * @param regionPK: foreign key for Region
     * @return all Region_neighbour Entity objects for Region
     * @throws eve.general.exception.CustomException
     */
    public ArrayList getRegion_neighbours4regionRegion(IRegionPK regionPK) throws CustomException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Region_neighbour.SQLSelect4regionRegion, regionPK.getKeyFields());
        } else return new ArrayList();
    }
    /**
     * @param regionPK: foreign key for Region
     * @delete all Region_neighbour Entity objects for Region in database
     * @throws eve.general.exception.CustomException
     */
    public void delete4regionNeighbour(String senderobject, IRegionPK regionPK) {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.addStatement(senderobject, Region_neighbour.SQLDelete4regionNeighbour, regionPK.getKeyFields());
        }
    }

    /**
     * @param regionPK: foreign key for Region
     * @return all Region_neighbour Entity objects for Region
     * @throws eve.general.exception.CustomException
     */
    public ArrayList getRegion_neighbours4regionNeighbour(IRegionPK regionPK) throws CustomException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Region_neighbour.SQLSelect4regionNeighbour, regionPK.getKeyFields());
        } else return new ArrayList();
    }

    /**
     * get all Region_neighbour objects for sqlparameters
     * @return ArrayList of Region_neighbour objects
     * @throws DBException
     */
    public ArrayList getRegion_neighbours(Object[][] sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        String sql =  Region_neighbour.SQLSelect;
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
     * delete all Region_neighbour objects for sqlparameters
     * @throws DBException
     */
    public void delRegion_neighbour(String senderobject, Object[][] sqlparameters, String andoroperator) throws DBException {
        String sql =  "Delete from " + Region_neighbour.table;
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
