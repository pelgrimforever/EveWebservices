/*
 * Bregion.java
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
import eve.conversion.json.JSONRegion;
import eve.conversion.entity.EMregion;
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
public abstract class Bregion extends BLtable {

    /**
     * Constructor, sets Region as default Entity
     */
    public Bregion() {
        super(new Region(), new EMregion());
    }

    /**
     * Constructor, sets Region as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Bregion(BLtable transactionobject) {
        super(transactionobject, new Region(), new EMregion());
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
     * @param id primary key field
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
     * @param id primary key field
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
    public ArrayList<Region> getRegions() throws DBException {
        return (ArrayList<Region>)super.getEntities(EMregion.SQLSelectAll);
    }

    /**
     * search Region for primary key
     * @param regionPK: Region primary key
     * @return Region object
     * @throws DBException
     */
    public Region getRegion(IRegionPK regionPK) throws DBException {
        return (Region)super.getEntity((RegionPK)regionPK);
    }

    /**
     * search region with IRegionsearch parameters
     * @param search IRegionsearch
     * @return ArrayList of Region
     * @throws DBException 
     */
    public ArrayList<Region> searchregions(IRegionsearch search) throws DBException {
        return (ArrayList<Region>)this.search(search);
    }

    /**
     * search region with IRegionsearch parameters, order by orderby sql clause
     * @param search IRegionsearch
     * @param orderby sql order by string
     * @return ArrayList of Region
     * @throws DBException 
     */
    public ArrayList<Region> searchregions(IRegionsearch search, String orderby) throws DBException {
        return (ArrayList<Region>)this.search(search, orderby);
    }

    /**
     * Search region in database for regionPK:
     * @param regionPK: Region Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getRegionExists(IRegionPK regionPK) throws DBException {
        return super.getEntityExists((RegionPK)regionPK);
    }

    /**
     * try to insert Region in database
     * @param region Region object
     * @throws DBException
     * @throws DataException
     */
    public void insertRegion(IRegion region) throws DBException, DataException {
        super.insertEntity(region);
    }

    /**
     * check if RegionPK exists
     * insert if not, update if found
     * do not commit transaction
     * @param region Region object
     * @throws DBException
     * @throws DataException
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
     * @param region Region object
     * @throws DBException
     * @throws DataException
     */
    public void updateRegion(IRegion region) throws DBException, DataException {
        super.updateEntity(region);
    }

    /**
     * try to delete Region in database
     * @param region Region object
     * @throws DBException
     */
    public void deleteRegion(IRegion region) throws DBException {
        cascadedeleteRegion(region.getPrimaryKey());
        super.deleteEntity(region);
    }

    /**
     * check data rules in Region, throw DataException with customized message if rules do not apply
     * @param region Region object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(IRegion region) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //Primary key
        if(region.getName()!=null && region.getName().length()>IRegion.SIZE_NAME) {
            message.append("Name is langer dan toegestaan. Max aantal karakters: ").append(IRegion.SIZE_NAME).append("\n");
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
    public void cascadedeleteRegion(IRegionPK regionPK) {
        BLorder_history blorder_history = new BLorder_history(this);
        blorder_history.delete4region(regionPK);
        BLregion_neighbour blregion_neighbourRegion = new BLregion_neighbour(this);
        blregion_neighbourRegion.delete4regionRegion(regionPK);
        BLregion_neighbour blregion_neighbourNeighbour = new BLregion_neighbour(this);
        blregion_neighbourNeighbour.delete4regionNeighbour(regionPK);
    }

    /**
     * @param order_historyPK: parent Order_history for child object Region Entity
     * @return child Region Entity object
     * @throws CustomException
     */
    public Region getOrder_history(IOrder_historyPK order_historyPK) throws CustomException {
        RegionPK regionPK = new RegionPK(order_historyPK.getRegion());
        return this.getRegion(regionPK);
    }

    /**
     * @param region_neighbourPK: parent Region_neighbour for child object Region Entity
     * @return child Region Entity object
     * @throws CustomException
     */
    public Region getRegion_neighbourregion(IRegion_neighbourPK region_neighbourPK) throws CustomException {
        RegionPK regionPK = new RegionPK(region_neighbourPK.getRegion());
        return this.getRegion(regionPK);
    }

    /**
     * @param region_neighbourPK: parent Region_neighbour for child object Region Entity
     * @return child Region Entity object
     * @throws CustomException
     */
    public Region getRegion_neighbourneighbour(IRegion_neighbourPK region_neighbourPK) throws CustomException {
        RegionPK regionPK = new RegionPK(region_neighbourPK.getNeighbour());
        return this.getRegion(regionPK);
    }


    /**
     * get all Region objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @param sortlist sql sort string
     * @param sortoperator asc/desc
     * @return ArrayList of Region objects
     * @throws DBException
     */
    public ArrayList<Region> getRegions(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMregion.SQLSelect);
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
        return (ArrayList<Region>)super.getEntities(sql.toString(), sqlparameters);
    }

    /**
     * delete all Region objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @throws DBException
     */
    public void delRegion(SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Region.table);
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
