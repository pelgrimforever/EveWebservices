/*
 * Bregion.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 23.5.2021 16:2
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
import eve.conversion.json.JSONRegion;
import eve.data.ProjectConstants;
import eve.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.searchentity.IRegionsearch;
import eve.logicentity.Region;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Business Entity class Bregion
 *
 * Superclass for manipulating data- and database objects
 * for Entity Region and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bregion extends GeneralEntityObject implements ProjectConstants {

    /**
     * Constructor, sets Region as default Entity
     */
    public Bregion() {
        super(new SQLMapper_pgsql(connectionpool, "Region"), new Region());
    }

    /**
     * Constructor, sets Region as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Bregion(GeneralEntityInterface transactionobject) {
        super(transactionobject, new Region());
    }

    /**
     * Map ResultSet Field values to Region
     * @param dbresult: Database ResultSet
     */
    public Region mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        RegionPK regionPK = null;
        Region region;
        if(dbresult==null) {
            region = new Region(regionPK);
        } else {
            try {
                regionPK = new RegionPK(dbresult.getLong("id"));
                region = new Region(regionPK);
                region.initName(dbresult.getString("name"));
                region.initNoaccess(dbresult.getBoolean("noaccess"));
                region.initOrderpages(dbresult.getInt("orderpages"));
                region.initOrdererrors(dbresult.getInt("ordererrors"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        this.loadExtra(dbresult, region);
        return region;
    }

    /**
     * create new empty Region object
     * @return empty IRegion
     */
    public IRegion newRegion() {
    	return new Region();
    }
    
    /**
     * create new empty Region object
     * create new primary key with given parameters
     * @return IRegion with primary key
     */
    public IRegion newRegion(long id) {
        return new Region(id);
    }

    /**
     * create new empty Region object with given primary key
     * @param regionPK: primary key for Region
     * @return IRegion with primary key
     */
    public IRegion newRegion(IRegionPK regionPK) {
        return new Region((RegionPK)regionPK);
    }

    /**
     * create new empty primary key
     * @return empty RegionPK
     */
    public IRegionPK newRegionPK() {
        return new RegionPK();
    }

    /**
     * create new primary key with given parameters
     * @return new IRegionPK
     */
    public IRegionPK newRegionPK(long id) {
        return new RegionPK(id);
    }

    /**
     * get all Region objects from database
     * @return ArrayList of Region objects
     * @throws DBException
     */
    public ArrayList getRegions() throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Region.SQLSelectAll);
        } else return new ArrayList();
    }

    /**
     * search Region for primary key
     * @param regionPK: Region primary key
     * @return Region object
     * @throws DBException
     */
    public Region getRegion(IRegionPK regionPK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return (Region)super.getEntity((RegionPK)regionPK);
        } else return null;
    }

    public ArrayList searchregions(IRegionsearch search) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return this.search(search);
        } else return new ArrayList();
    }

    public ArrayList searchregions(IRegionsearch search, String orderby) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return this.search(search, orderby);
        } else return new ArrayList();
    }

    /**
     * Search region in database for regionPK:
     * @param regionPK: Region Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getRegionExists(IRegionPK regionPK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return super.getEntityExists((RegionPK)regionPK);
        } else return false;
    }

    /**
     * try to insert Region in database
     * @param film: Region object
     * @throws DBException
     */
    public void insertRegion(IRegion region) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.insertEntity(region);
        }
    }

    /**
     * check if RegionPK exists
     * insert if not, update if found
     * do not commit transaction
     * @param film: Region object
     * @throws DBException
     */
    public void insertupdateRegion(IRegion region) throws DBException, DataException {
        if(this.getRegionExists(region.getPrimaryKey())) {
            super.updateEntity(region);
        } else {
            super.insertEntity(region);
        }
    }

    /**
     * try to update Region in database
     * @param film: Region object
     * @throws DBException
     */
    public void updateRegion(IRegion region) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.updateEntity(region);
        }
    }

    /**
     * try to delete Region in database
     * @param film: Region object
     * @throws DBException
     */
    public void deleteRegion(IRegion region) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            cascadedeleteRegion(region.getOwnerobject(), region.getPrimaryKey());
            super.deleteEntity(region);
        }
    }

    /**
     * check data rules in Region, throw DataException with customized message if rules do not apply
     * @param film: Region object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(IRegion region) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //Primary key
        if(region.getName()!=null && region.getName().length()>IRegion.SIZE_NAME) {
            message.append("Name is langer dan toegestaan. Max aantal karakters: " + IRegion.SIZE_NAME + "\n");
        }
        if(region.getName()==null) {
            message.append("Name mag niet leeg zijn.\n");
        }
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where regionPK is used in a primary key
     * @param regionPK: Region primary key
     */
    public void cascadedeleteRegion(String senderobject, IRegionPK regionPK) {
        BLorder_history blorder_history = new BLorder_history(this);
        blorder_history.delete4region(senderobject, regionPK);
        BLregion_neighbour blregion_neighbourRegion = new BLregion_neighbour(this);
        blregion_neighbourRegion.delete4regionRegion(senderobject, regionPK);
        BLregion_neighbour blregion_neighbourNeighbour = new BLregion_neighbour(this);
        blregion_neighbourNeighbour.delete4regionNeighbour(senderobject, regionPK);
    }

    /**
     * @param order_historyPK: parent Order_history for child object Region Entity
     * @return child Region Entity object
     * @throws eve.general.exception.CustomException
     */
    public IRegion getOrder_history(IOrder_historyPK order_historyPK) throws CustomException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            RegionPK regionPK = new RegionPK(order_historyPK.getRegion());
            return this.getRegion(regionPK);
        } else return null;
    }

    /**
     * @param region_neighbourPK: parent Region_neighbour for child object Region Entity
     * @return child Region Entity object
     * @throws eve.general.exception.CustomException
     */
    public IRegion getRegion_neighbourregion(IRegion_neighbourPK region_neighbourPK) throws CustomException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            RegionPK regionPK = new RegionPK(region_neighbourPK.getRegion());
            return this.getRegion(regionPK);
        } else return null;
    }

    /**
     * @param region_neighbourPK: parent Region_neighbour for child object Region Entity
     * @return child Region Entity object
     * @throws eve.general.exception.CustomException
     */
    public IRegion getRegion_neighbourneighbour(IRegion_neighbourPK region_neighbourPK) throws CustomException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            RegionPK regionPK = new RegionPK(region_neighbourPK.getNeighbour());
            return this.getRegion(regionPK);
        } else return null;
    }


    /**
     * get all Region objects for sqlparameters
     * @return ArrayList of Region objects
     * @throws DBException
     */
    public ArrayList getRegions(Object[][] sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        String sql =  Region.SQLSelect;
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
     * delete all Region objects for sqlparameters
     * @throws DBException
     */
    public void delRegion(String senderobject, Object[][] sqlparameters, String andoroperator) throws DBException {
        String sql =  "Delete from " + Region.table;
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
